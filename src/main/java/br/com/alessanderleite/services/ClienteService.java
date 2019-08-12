package br.com.alessanderleite.services;

import java.util.List;
import java.util.Optional;

import br.com.alessanderleite.model.Cliente;
import javassist.NotFoundException;

public interface ClienteService {

	Cliente criar(Cliente cliente);
	void alterar(Cliente cliente);
	Optional<Cliente> consultarPorId(Long id);
	List<Cliente> listarTodos();
	void removerPorId(Long id) throws NotFoundException;
}
