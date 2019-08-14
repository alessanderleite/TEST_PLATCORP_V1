package br.com.alessanderleite.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.model.ClienteModel;
import br.com.alessanderleite.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Iterable<ClienteModel> listAll() {
		return clienteRepository.findAll();
	}

	@Override
	public ClienteModel getById(Integer id) throws IOException {
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		cliente.orElseThrow(() -> new IOException("Não foi possível localizar o id " + id));
		
		return cliente.get();
	}

	@Override
	public ClienteModel save(ClienteModel entity) {
		return clienteRepository.save(entity);
	}

	@Override
	public void delete(Integer id) throws IOException {
		Optional<ClienteModel> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			throw new IOException("Não foi possível localizar o id " + id);
		}
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteModel update(ClienteModel entity) throws IOException {
		ClienteModel cliente = getById(entity.getId());
		if (cliente != null) {
			return clienteRepository.save(entity);
		}
		return null;
	}

}
