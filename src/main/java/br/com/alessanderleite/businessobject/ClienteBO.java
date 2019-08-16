package br.com.alessanderleite.businessobject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintDefinitionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.alessanderleite.config.IpVigilanteClient;
import br.com.alessanderleite.config.MetaweatherClient;
import br.com.alessanderleite.model.Cliente;
import br.com.alessanderleite.model.Historico;
import br.com.alessanderleite.model.ipvigilante.Localizacao;
import br.com.alessanderleite.model.metaweather.Clima;
import br.com.alessanderleite.model.metaweather.Geolocalizacao;
import br.com.alessanderleite.service.ClienteService;
import br.com.alessanderleite.valueobject.ClienteVO;
import br.com.alessanderleite.valueobject.DataGeoVO;
import br.com.alessanderleite.valueobject.HistoricoVO;
import br.com.alessanderleite.valueobject.Retorno;

@Component
public class ClienteBO {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private IpVigilanteClient ipVigilante;
	
	@Autowired
	private MetaweatherClient metaweather;
	
	@Transactional
	public Retorno salvar(Cliente cliente) {
		
		if (!Optional.ofNullable(cliente.getId()).isPresent()) {
			cliente = new Cliente(cliente.getNome(), cliente.getIdade());
			
			Historico hist = new Historico();
			
			Localizacao localidade = ipVigilante.obterLocalizacao();
			
			List<Geolocalizacao> listaGeolocalizacao = metaweather.obterLocalizacao(String.format("%s,%s", localidade.getData().getLatitude(), localidade.getData().getLongitude()));
			
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String data = simpleDateFormat.format(new Date());
			
			List<Clima> listaClimas = new ArrayList<Clima>();
			
			int i = 0;
			while (listaClimas.size() == 0) {
				listaClimas.addAll(metaweather.obterClima(listaGeolocalizacao.get(i).getWoeid(), data));
				i++;
			}
					
			listaClimas.forEach(clima ->{
				if(hist.getMinTemp() == null || Double.parseDouble(clima.getMinTemp()) < Double.parseDouble(hist.getMinTemp()))
					hist.setMinTemp(clima.getMinTemp());
				
				if(hist.getMaxTemp() == null || Double.parseDouble(clima.getMaxTemp()) > Double.parseDouble(hist.getMaxTemp()))
					hist.setMaxTemp(clima.getMaxTemp());		
			});
			
			hist.getClientes().add(cliente);
			hist.setLocalizacao(localidade);
			localidade.getHistoricos().add(hist);
			cliente.setHistorico(hist);
			
			Cliente clienteSave = clienteService.save(cliente);
			
			return buildRetorno(clienteSave);

			
		}else {
			throw new ConstraintDefinitionException();
		}
	}
	
	public List<Retorno> listaTodosClientes() {
		try {
			Iterable<Cliente> clientes = clienteService.listAll();
			List<Retorno> lista = new ArrayList<Retorno>();
			clientes.forEach(cliente -> lista.add(buildRetorno(cliente)));
			return lista;
		} catch (Exception e) {
			throw new RuntimeException("não foi encontrado clientes");
		}
	}
	
	private Retorno buildRetorno(Cliente cliente) {
		if (!Optional.ofNullable(cliente).isPresent()) {
			return null;
		}

		Retorno retorno = new Retorno(new ClienteVO(), new HistoricoVO());

		// Montando VO Cliente
		retorno.getCliente().setId(cliente.getId());
		retorno.getCliente().setNome(cliente.getNome());
		retorno.getCliente().setIdade(cliente.getIdade());

		// Montar VO Historico
		retorno.getHistorico().setId(cliente.getHistorico().getId());
		retorno.getHistorico().setMinTemp(cliente.getHistorico().getMinTemp());
		retorno.getHistorico().setMaxTemp(cliente.getHistorico().getMaxTemp());
		
		//Corrigir VO e Mappear Data em Localidade
		DataGeoVO local = new DataGeoVO();
		
		local.setId(cliente.getHistorico().getLocalizacao().getId());
		local.setCityName(cliente.getHistorico().getLocalizacao().getData().getCityName());
		local.setContinentName(cliente.getHistorico().getLocalizacao().getData().getContinentName());
		local.setIpv4(cliente.getHistorico().getLocalizacao().getData().getIpv4());
		local.setCountryName(cliente.getHistorico().getLocalizacao().getData().getCountryName());
		local.setLatitude(cliente.getHistorico().getLocalizacao().getData().getLatitude());
		local.setLongitude(cliente.getHistorico().getLocalizacao().getData().getLongitude());
		
		
		retorno.getHistorico().setLocalidade(local);
		

		return retorno;
	}
	
}
