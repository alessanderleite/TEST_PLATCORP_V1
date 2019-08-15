package br.com.alessanderleite.valueobject;

public class Retorno {
	
	private ClienteVO cliente;
	private HistoricoVO historico;
	
	public Retorno() {}

	public Retorno(ClienteVO cliente, HistoricoVO historico) {
		this.cliente = cliente;
		this.historico = historico;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public HistoricoVO getHistorico() {
		return historico;
	}

	public void setHistorico(HistoricoVO historico) {
		this.historico = historico;
	}
}
