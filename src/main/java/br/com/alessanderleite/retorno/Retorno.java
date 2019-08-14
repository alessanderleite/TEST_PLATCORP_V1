package br.com.alessanderleite.retorno;

import java.io.Serializable;

import br.com.alessanderleite.retorno.retorno.ClienteR;
import br.com.alessanderleite.retorno.retorno.HistoricoR;

public class Retorno implements Serializable{
	private static final long serialVersionUID = -3680020969750698471L;

	private ClienteR cliente;
	
	private HistoricoR historico;
	
	public Retorno() {}

	public Retorno(ClienteR cliente, HistoricoR historico) {
		this.cliente = cliente;
		this.historico = historico;
	}

	public ClienteR getCliente() {
		return cliente;
	}

	public void setCliente(ClienteR cliente) {
		this.cliente = cliente;
	}

	public HistoricoR getHistorico() {
		return historico;
	}

	public void setHistorico(HistoricoR historico) {
		this.historico = historico;
	}
}
