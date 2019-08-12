package br.com.alessanderleite.model.ipvigilante;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.alessanderleite.model.ClienteTemperatura;

/**
 * fonte: https://www.ipvigilante.com/
 * 
 * @author Alessander
 *
 */
@Entity
@Table(name = "localizacao")
public class Localizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	private String status;
	
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "id_date", referencedColumnName = "id", nullable = false)})
	private Data data;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localizacao")
	private Set<ClienteTemperatura> clienteTemperaturas = new HashSet<ClienteTemperatura>(0);

	public Localizacao() {}

	public Localizacao(Integer id, Data data) {
		this.id = id;
		this.data = data;
	}

	public Localizacao(Integer id, String status, Data data) {
		this.id = id;
		this.status = status;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Set<ClienteTemperatura> getClienteTemperaturas() {
		return clienteTemperaturas;
	}

	public void setClienteTemperaturas(Set<ClienteTemperatura> clienteTemperaturas) {
		this.clienteTemperaturas = clienteTemperaturas;
	}
}