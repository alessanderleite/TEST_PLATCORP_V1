package br.com.alessanderleite.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alessanderleite.model.Cliente;
import br.com.alessanderleite.retorno.ClienteRegra;
import br.com.alessanderleite.retorno.Retorno;
import javassist.NotFoundException;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRegra clienteRegra;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente) throws URISyntaxException {
		Retorno clienteSave = clienteRegra.salvar(cliente);
		return ResponseEntity
				.created(new URI("localhost:8080/clientes/"+clienteSave.getCliente().getId()))
				.body(clienteSave);
	}
	
	@GetMapping
	public ResponseEntity<?> listaClientes() throws NotFoundException {
		return ResponseEntity.ok().body(clienteRegra.listaClientes());
	}
}
