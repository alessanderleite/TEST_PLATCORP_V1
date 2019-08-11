package br.com.alessanderleite.service;

import java.util.List;
import java.util.Optional;

import br.com.alessanderleite.model.Cliente;

public interface ClienteService {

	Cliente criar(Cliente cliente);
	void alterar(Cliente cliente);
	Optional<Cliente> consultarPorId(Long id);
	List<Cliente> listarTodosClientes();
	void removerPorId(Long id);
}
