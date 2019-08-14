package br.com.alessanderleite.retorno.retorno;

import java.io.Serializable;

public class ClienteR implements Serializable {
	private static final long serialVersionUID = -2749467240826705415L;

	private Integer id;
	
	private String nome;
	
	private int idade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
