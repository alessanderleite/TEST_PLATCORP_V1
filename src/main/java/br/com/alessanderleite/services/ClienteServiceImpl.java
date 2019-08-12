package br.com.alessanderleite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alessanderleite.model.Cliente;
import br.com.alessanderleite.repository.ClienteRepository;
import javassist.NotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente criar(final Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}

	@Override
	public void alterar(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public Optional<Cliente> consultarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			try {
				throw new NotFoundException("Não foi possível localizar o id " + id);
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}

	@Override
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
		
	}

	@Override
	public void removerPorId(Long id) throws NotFoundException {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		cliente.orElseThrow(() -> new NotFoundException("Não foi possível localizar o id " + id));
		
		clienteRepository.deleteById(id);
	}
}
