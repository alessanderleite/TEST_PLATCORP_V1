package br.com.alessanderleite.service;

import java.util.List;
import java.util.Optional;

import br.com.alessanderleite.model.Cliente;

public interface ClienteService {

	Cliente criarCliente(Cliente cliente);
	void alterarCliente(Cliente cliente);
	Optional<Cliente> consultarClientePorId(Long id);
	List<Cliente> listarTodosClientes();
	void removerClientePorId(Long id);
}
