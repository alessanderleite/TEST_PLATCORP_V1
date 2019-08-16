package br.com.alessanderleite.businessobject;

import java.io.IOException;
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
import br.com.alessanderleite.model.ipvigilante.Data;
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
			
			Localizacao localidade = ipVigilante.getLocalidade();
			
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
			hist.setLocalidade(localidade);
			localidade.getHistoricos().add(hist);
			cliente.setHistorico(hist);
			
			Cliente clienteSave = clienteService.save(cliente);
			
			return buildRetorno(clienteSave);

			
		}else {
			throw new ConstraintDefinitionException();
		}
	}
	
	public List<Retorno> listaClientes() {
		try {
			Iterable<Cliente> clientes = clienteService.listAll();
			List<Retorno> lista = new ArrayList<Retorno>();
			clientes.forEach(cliente -> lista.add(buildRetorno(cliente)));
			return lista;
		} catch (Exception e) {
			throw new RuntimeException("não encontrado");
		}
	}
	
	public Retorno buscarClienteId(Integer id) {
		try {
			Cliente cliente = clienteService.getById(id);
			return buildRetorno(cliente);
		} catch (Exception e) {
			throw new RuntimeException("Não encontrado");
		}
	}
	
	public void deletar(Integer id) {
		try {
			clienteService.delete(id);
		} catch (Exception e) {
			throw new RuntimeException("Não encontrado");
		}
	}
	
	public Retorno atualizar(Retorno clienteVO) throws IOException {
		Cliente cliente = clienteService.getById(clienteVO.getCliente().getId());
		if (Optional.ofNullable(cliente).isPresent()) {
			
			Cliente clienteAtualizado = new Cliente(
					clienteVO.getCliente().getId(), 
					clienteVO.getCliente().getNome(), 
					clienteVO.getCliente().getIdade());
			Historico historico = new Historico(
					clienteVO.getHistorico().getId(), 
					clienteVO.getHistorico().getMinTemp(), 
					clienteVO.getHistorico().getMaxTemp());
			
			Localizacao localidade = new Localizacao(
					cliente.getHistorico().getLocalidade().getId(),
					cliente.getHistorico().getLocalidade().getData());
			localidade.setData(new Data(
					clienteVO.getHistorico().getLocalidade().getIpv4(),
					clienteVO.getHistorico().getLocalidade().getContinentName(),
					clienteVO.getHistorico().getLocalidade().getCountryName(),
					clienteVO.getHistorico().getLocalidade().getCityName(),
					clienteVO.getHistorico().getLocalidade().getLatitude(), 
					clienteVO.getHistorico().getLocalidade().getLongitude()));
			
			historico.getClientes().add(clienteAtualizado);
			historico.setLocalidade(localidade);
			localidade.getHistoricos().add(historico);
			clienteAtualizado.setHistorico(historico);
			cliente = clienteService.save(clienteAtualizado);
			return buildRetorno(clienteAtualizado);
		}else {
			throw new RuntimeException("Não encontrado");
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
		DataGeoVO localidade = new DataGeoVO();
		
		localidade.setId(cliente.getHistorico().getLocalidade().getId());
		localidade.setCityName(cliente.getHistorico().getLocalidade().getData().getCityName());
		localidade.setContinentName(cliente.getHistorico().getLocalidade().getData().getContinentName());
		localidade.setIpv4(cliente.getHistorico().getLocalidade().getData().getIpv4());
		localidade.setCountryName(cliente.getHistorico().getLocalidade().getData().getCountryName());
		localidade.setLatitude(cliente.getHistorico().getLocalidade().getData().getLatitude());
		localidade.setLongitude(cliente.getHistorico().getLocalidade().getData().getLongitude());
		
		
		retorno.getHistorico().setLocalidade(localidade);
		

		return retorno;
	}
	
}
