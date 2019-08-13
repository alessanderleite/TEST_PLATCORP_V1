package br.com.alessanderleite.model;

import java.io.Serializable;

public class Retorno implements Serializable{
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private ClienteTemperatura historico;
	
	public Retorno() {}

	public Retorno(Cliente cliente, ClienteTemperatura historico) {
		this.cliente = cliente;
		this.historico = historico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteTemperatura getHistorico() {
		return historico;
	}

	public void setHistorico(ClienteTemperatura historico) {
		this.historico = historico;
	}
}
