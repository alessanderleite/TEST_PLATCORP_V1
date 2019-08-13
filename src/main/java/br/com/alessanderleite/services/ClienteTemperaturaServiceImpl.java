package br.com.alessanderleite.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.model.ClienteTemperatura;
import br.com.alessanderleite.repository.ClienteTemperaturaRepository;

@Service
public class ClienteTemperaturaServiceImpl implements ClienteTemperaturaService{

	@Autowired 
	ClienteTemperaturaRepository clienteTemperaturaRepository;

	@Override
	public Iterable<ClienteTemperatura> listAll() {
		return clienteTemperaturaRepository.findAll();
	}

	@Override
	public ClienteTemperatura getById(Integer id) throws IOException {
		Optional<ClienteTemperatura> clienteTemperatura = clienteTemperaturaRepository.findById(id);
		clienteTemperatura.orElseThrow(() -> new IOException("Não foi possível localizar o id " + id));
		
		return clienteTemperatura.get();
	}

	@Override
	public ClienteTemperatura save(ClienteTemperatura entity) {
		return clienteTemperaturaRepository.save(entity);
	}

	@Override
	public void delete(Integer id) throws IOException {
		Optional<ClienteTemperatura> clienteTemperatura = clienteTemperaturaRepository.findById(id);
		if (!clienteTemperatura.isPresent()) {
			throw new IOException("Não foi possível localizar o id " + id);
		}
		clienteTemperaturaRepository.deleteById(id);
	}

	@Override
	public ClienteTemperatura update(ClienteTemperatura entity) throws IOException {
		ClienteTemperatura clienteTemperatura = getById(entity.getId());
		if (clienteTemperatura != null) {
			return clienteTemperaturaRepository.save(entity);
		}
		return null;
	}

}
