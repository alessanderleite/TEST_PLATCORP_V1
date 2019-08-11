package br.com.alessanderleite.model;

/**
 * fonte: https://www.ipvigilante.com/
 * 
 * @author Alessander
 *
 */
public class Localizacao {

	private String status;
	private Data data;

	public Localizacao() {}

	public Localizacao(String status, Data data) {
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Data getData() {
		return data;
	}
	
	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Localizacao [status=" + status + ", data=" + data + "]";
	}
}