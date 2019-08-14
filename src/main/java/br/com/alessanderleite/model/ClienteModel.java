package br.com.alessanderleite.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	private Integer id;

	@NotBlank(message = "Preenchimento obrigatório")
	private String nome;
	
	@Min(value = 1, message = "A idade tem que ser maior que zero")
	private int idade;
	
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "id_historico", referencedColumnName = "id", nullable = false)})
	@JsonIgnore
	private HistoricoModel historico;
	
	public ClienteModel() {}
	
	public ClienteModel(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public ClienteModel(Integer id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

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

	public HistoricoModel getHistorico() {
		return historico;
	}

	public void setClienteTemperatura(HistoricoModel historico) {
		this.historico = historico;
	}
}
