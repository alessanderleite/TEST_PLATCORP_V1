package br.com.alessanderleite.services;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alessanderleite.model.IP;
import br.com.alessanderleite.model.ipvigilante.Localizacao;
import br.com.alessanderleite.model.metaweather.Temperatura;
import br.com.alessanderleite.model.metaweather.Woeid;

@Service
public class GeoLocalizacaoRecuperaIpServiceImpl implements GeoLocalizacaoRecuperaIpService {

	@Override
	public Localizacao localizacao(String ip) throws Exception {
		
		String url = "https://ipvigilante.com/" + ip;
		RestTemplate restTemplate = new RestTemplate();
		Localizacao localizacao = restTemplate.getForObject(url, Localizacao.class);
		return localizacao;
	}

	@Override
	public String recuperaIp() throws Exception {
		
		String url = "http://httpbin.org/ip";
		RestTemplate restTemplate = new RestTemplate();
		IP ip = restTemplate.getForObject(url, IP.class);
		return ip.getOrigin();
	}

	@Override
	public String recuperaWoeid(Localizacao localizacao) throws Exception {
		
		String url = "https://www.metaweather.com/api/location/search/?lattlong="
				+ localizacao.getData().getLatitude()
				+ ","
				+ localizacao.getData().getLongitude();
		RestTemplate restTemplate = new RestTemplate();
		Woeid[] woeids = restTemplate.getForObject(url, Woeid[].class);
		List<Woeid> woeidList = Arrays.asList(woeids);
		
		for (Woeid woeid : woeidList) {
			if (woeid.getTitle().equals(localizacao.getData().getCityName())) {
				System.out.println(woeid.getWoeid());
				return woeid.getWoeid();
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public List<Temperatura> recuperaTemperaturas(Integer woeid) throws Exception {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(dateFormat.format(date));
		
		String url = "https://www.metaweather.com/api/location/" + woeid + "/" + dateFormat.format(date) + "/";
		RestTemplate restTemplate = new RestTemplate();
		Temperatura[] temperaturas = restTemplate.getForObject(url, Temperatura[].class);
		List<Temperatura> temperaturaList = Arrays.asList(temperaturas);
		return temperaturaList;
	}

}
