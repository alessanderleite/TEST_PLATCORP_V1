package br.com.alessanderleite.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.model.Cliente;
import br.com.alessanderleite.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Iterable<Cliente> listAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getById(Integer id) throws IOException {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		cliente.orElseThrow(() -> new IOException("Não foi possível localizar o id " + id));
		
		return cliente.get();
	}

	@Override
	public Cliente save(Cliente entity) {
		return clienteRepository.save(entity);
	}

	@Override
	public void delete(Integer id) throws IOException {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			throw new IOException("Não foi possível localizar o id " + id);
		}
		clienteRepository.deleteById(id);
	}

	@Override
	public Cliente update(Cliente entity) throws IOException {
		Cliente cliente = getById(entity.getId());
		if (cliente != null) {
			return clienteRepository.save(entity);
		}
		return null;
	}

}
