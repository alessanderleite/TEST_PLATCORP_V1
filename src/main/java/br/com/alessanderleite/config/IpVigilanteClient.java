package br.com.alessanderleite.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alessanderleite.model.ipvigilante.Localizacao;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "IpVigilanteClient", url = "https://ipvigilante.com/")
public interface IpVigilanteClient {
	
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	Localizacao obterLocalizacao();
}
