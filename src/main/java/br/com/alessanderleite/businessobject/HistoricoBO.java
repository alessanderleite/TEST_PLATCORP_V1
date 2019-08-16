package br.com.alessanderleite.businessobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alessanderleite.service.HistoricoService;

@Component
public class HistoricoBO {

	@Autowired
	private HistoricoService historicoService;
	
}
