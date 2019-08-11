package br.com.alessanderleite.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alessanderleite.model.Cliente;
import br.com.alessanderleite.service.ClienteService;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	public List<Cliente> listarTodos() {
		return clienteService.listarTodos();
	}
	
	@RequestMapping(value = "/clientes", method = RequestMethod.POST)
	public Cliente criar(@Valid @RequestBody Cliente cliente) {
		return clienteService.criar(cliente);
	}
}
