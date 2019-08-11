package br.com.alessanderleite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "idade", nullable = false)
	private int idade;
	
	public Cliente() {
	
	}
	
	public Cliente(long id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
	
	public void setAge(int idade) {
		this.idade = idade;
	}
}
