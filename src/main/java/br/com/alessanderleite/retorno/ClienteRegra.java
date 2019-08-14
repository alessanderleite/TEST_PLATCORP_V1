package br.com.alessanderleite.retorno;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ConstraintDefinitionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alessanderleite.config.IpVigilanteClient;
import br.com.alessanderleite.config.MetaweatherClient;
import br.com.alessanderleite.model.Cliente;
import br.com.alessanderleite.model.ClienteTemperatura;
import br.com.alessanderleite.model.ipvigilante.Localizacao;
import br.com.alessanderleite.model.metaweather.Temperatura;
import br.com.alessanderleite.model.metaweather.Woeid;
import br.com.alessanderleite.retorno.retorno.ClienteR;
import br.com.alessanderleite.retorno.retorno.GeolocalizacaoR;
import br.com.alessanderleite.retorno.retorno.HistoricoR;
import br.com.alessanderleite.services.ClienteService;
import javassist.NotFoundException;

@Component
public class ClienteRegra {
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
			
			ClienteTemperatura hist = new ClienteTemperatura();
			
			Localizacao localizacao = ipVigilante.obterLocalizacao();
			
			List<Woeid> listaWoeid = metaweather.obterLocalizacao(String.format("%s,%s", localizacao.getData().getLatitude(), localizacao.getData().getLongitude()));
			
			String dateFormat = "yyyy/MM/dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			String data = simpleDateFormat.format(new Date());
			
			List<Temperatura> listaTemperaturas = new ArrayList<Temperatura>();
			
			int i = 0;
			while (listaTemperaturas.size() == 0) {
				listaTemperaturas.addAll(metaweather.obterTemperatura(listaWoeid.get(i).getWoeid(), data));
				i++;
			}
			
			listaTemperaturas.forEach(temperatura -> {
				if (hist.getMinTemp() == null || Double.parseDouble(temperatura.getMinTemp()) < Double.parseDouble(hist.getMinTemp()))
					hist.setMinTemp(temperatura.getMinTemp());

				if (hist.getMaxTemp() == null || Double.parseDouble(temperatura.getMaxTemp()) < Double.parseDouble(hist.getMaxTemp()))
					hist.setMaxTemp(temperatura.getMaxTemp());
			});
			
			hist.getClientes().add(cliente);
			hist.setLocalizacao(localizacao);
			localizacao.getClienteTemperaturas().add(hist);
			cliente.setClienteTemperatura(hist);
			
			Cliente clienteSave = clienteService.save(cliente);
			
			return buildRetorno(clienteSave);
			
		} else {
			throw new ConstraintDefinitionException();
		}
	}
	
	public List<Retorno> listaClientes() throws NotFoundException {
		try {
			Iterable<Cliente> clientes = clienteService.listAll();
			List<Retorno> lista = new ArrayList<Retorno>();
			clientes.forEach(cliente -> lista.add(buildRetorno(cliente)));
			return lista;
		} catch (Exception e) {
			throw new NotFoundException("Não encontrado");
		}
	}
	
	private Retorno buildRetorno(Cliente cliente) {
		if (!Optional.ofNullable(cliente).isPresent()) {
			return null;
		}
		Retorno retorno = new Retorno(new ClienteR(), new HistoricoR());
		
		retorno.getCliente().setId(cliente.getId());
		retorno.getCliente().setNome(cliente.getNome());
		retorno.getCliente().setIdade(cliente.getIdade());

		retorno.getHistorico().setId(cliente.getClienteTemperatura().getId());
		retorno.getHistorico().setMinTemp(cliente.getClienteTemperatura().getMinTemp());
		retorno.getHistorico().setMaxTemp(cliente.getClienteTemperatura().getMaxTemp());
		
		GeolocalizacaoR local = new GeolocalizacaoR();
		
		local.setId(cliente.getClienteTemperatura().getLocalizacao().getId());
		local.setCidade(cliente.getClienteTemperatura().getLocalizacao().getData().getCityName());
		local.setContinete(cliente.getClienteTemperatura().getLocalizacao().getData().getContinentName());
		local.setIpv4(cliente.getClienteTemperatura().getLocalizacao().getData().getIpv4());
		local.setPais(cliente.getClienteTemperatura().getLocalizacao().getData().getCountryName());
		local.setLatitude(cliente.getClienteTemperatura().getLocalizacao().getData().getLatitude());
		local.setLongitude(cliente.getClienteTemperatura().getLocalizacao().getData().getLongitude());
		
		retorno.getHistorico().setLocalidade(local);
		
		return retorno;
	}
}
