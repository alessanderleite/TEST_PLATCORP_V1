package br.com.alessanderleite.businessobject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

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

public class ClienteBO {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private IpVigilanteClient ip;
	
	@Autowired
	private MetaweatherClient metaweather;
	
	public Retorno salvar(Cliente cliente) {
		
		if (!Optional.ofNullable(cliente.getId()).isPresent()) {
			cliente = new Cliente(cliente.getNome(), cliente.getIdade());
			
			Historico historico = new Historico();
			Localizacao localizacao = ip.obterLocalizacao();
			List<Geolocalizacao> listGeolocalizacao = metaweather.obterLocalizacao(String.format("%s,%s", localizacao.getData().getLatitude(), localizacao.getData().getLongitude()));
			
			String dateFormat = "yyyy/MM/dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			String data = simpleDateFormat.format(new Date());
			
			List<Clima> listaClimas = new ArrayList<Clima>();
			
			int i = 0;
			while (listaClimas.size() == 0) {
				listaClimas.addAll(metaweather.obterClima(listGeolocalizacao.get(i).getWoeid(), data));
				i++;
			}
			
			listaClimas.forEach(clima ->{
				if(historico.getMinTemp() == null || Double.parseDouble(clima.getMinTemp()) < Double.parseDouble(historico.getMinTemp()))
					historico.setMinTemp(clima.getMinTemp());
				
				if(historico.getMaxTemp() == null || Double.parseDouble(clima.getMaxTemp()) > Double.parseDouble(historico.getMaxTemp()))
					historico.setMaxTemp(clima.getMaxTemp());		
			});
			
			historico.getClientes().add(cliente);
			historico.setLocalizacao(localizacao);
			localizacao.getHistoricos().add(historico);
			cliente.setHistorico(historico);
			
			Cliente salvarCliente = clienteService.save(cliente);
			
			return buildRetorno(salvarCliente);
		
		} else {
			throw new RuntimeException();
		}		
	}
	
	private Retorno buildRetorno(Cliente cliente) {
		if (!Optional.ofNullable(cliente).isPresent()) {
			return null;
		}
		
		Retorno retorno = new Retorno(new ClienteVO(), new HistoricoVO());
		
		retorno.getCliente().setId(cliente.getId());
		retorno.getCliente().setNome(cliente.getNome());
		retorno.getCliente().setIdade(cliente.getIdade());
		
		retorno.getHistorico().setId(cliente.getHistorico().getId());
		retorno.getHistorico().setMinTemp(cliente.getHistorico().getMinTemp());
		retorno.getHistorico().setMaxTemp(cliente.getHistorico().getMaxTemp());
		
		DataGeoVO localizacao = new DataGeoVO();
		
		localizacao.setId(cliente.getHistorico().getLocalizacao().getId());
		localizacao.setCityName(cliente.getHistorico().getLocalizacao().getData().getCityName());
		localizacao.setContinentName(cliente.getHistorico().getLocalizacao().getData().getContinentName());
		localizacao.setIpv4(cliente.getHistorico().getLocalizacao().getData().getIpv4());
		localizacao.setCountryName(cliente.getHistorico().getLocalizacao().getData().getCountryName());
		localizacao.setLatitude(cliente.getHistorico().getLocalizacao().getData().getLatitude());
		localizacao.setLongitude(cliente.getHistorico().getLocalizacao().getData().getLongitude());
		
		retorno.getHistorico().setLocalidade(localizacao);
		
		return retorno;
	}
	
}
