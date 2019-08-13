package br.com.alessanderleite.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alessanderleite.model.metaweather.Temperatura;
import br.com.alessanderleite.model.metaweather.Woeid;

@FeignClient(name = "MetaweatherClient", url = "https://www.metaweather.com/api/location")
public interface MetaweatherClient {

	@GetMapping(path = "/search/")
	List<Woeid> obterLocalizacao(@RequestParam("lattlong") String latt);
	
	@GetMapping(path = "/{woeid}/{date}")
	List<Temperatura> obterTemperatura(@PathVariable("woeid") String woeid, @PathVariable("date") String date);
}