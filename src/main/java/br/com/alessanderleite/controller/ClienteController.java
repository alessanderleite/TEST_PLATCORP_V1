package br.com.alessanderleite.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alessanderleite.businessobject.ClienteBO;
import br.com.alessanderleite.model.Cliente;
import br.com.alessanderleite.valueobject.Retorno;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

	@Autowired
	private ClienteBO clienteBO;

	@PostMapping("/criar")
	public ResponseEntity<?> criar(@RequestBody Cliente cliente) throws URISyntaxException {
		Retorno clientSave = clienteBO.salvar(cliente);
		String uri = "localhost:8080/clientes/"; 
		return ResponseEntity
				.created(new URI(uri+clientSave.getCliente().getId()))
				.body(clientSave);
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody Retorno cliente) throws IOException {
		return ResponseEntity.ok().body(clienteBO.atualizar(cliente));
	}

	@GetMapping("/consultar/{id}")
	public ResponseEntity<?> consultarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok().body(clienteBO.buscarClienteId(id));
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok().body(clienteBO.listaClientes());
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		clienteBO.deletar(id);
		return ResponseEntity.ok().build();
	}
}
