package br.com.alessanderleite.service;

import java.util.List;

import br.com.alessanderleite.model.ipvigilante.Localizacao;
import br.com.alessanderleite.model.metaweather.Temperatura;

public interface GeoLocalizacaoRecuperaIpService {

	Localizacao localizacao(String ip) throws Exception;
	String recuperaIp() throws Exception;
	Integer recuperaWoeid(Localizacao localizacao) throws Exception;
	List<Temperatura> recuperaTemperaturas(Integer woeid) throws Exception;
}