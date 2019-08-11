package br.com.alessanderleite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.model.ClienteTemperatura;
import br.com.alessanderleite.repository.ClienteTemperaturaRepository;

@Service
public class ClienteTemperaturaServiceImpl implements ClienteTemperaturaService{

	@Autowired ClienteTemperaturaRepository clienteTemperaturaRepository;

	@Override
	public ClienteTemperatura criar(ClienteTemperatura clienteTemperatura) {
		return clienteTemperaturaRepository.save(clienteTemperatura);
	}
	
	
}
