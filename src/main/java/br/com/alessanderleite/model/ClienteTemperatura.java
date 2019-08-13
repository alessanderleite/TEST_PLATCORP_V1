package br.com.alessanderleite.model;

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

import br.com.alessanderleite.model.ipvigilante.Localizacao;

@Entity
@Table(name = "cliente_temperatura")
public class ClienteTemperatura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private Double minTemp;
	private Double maxTemp;
	
	@OneToMany(mappedBy = "clienteTemperatura", fetch = FetchType.LAZY)
	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "id_localizacao", referencedColumnName = "id", nullable = false)})
	private Localizacao localizacao;
	
	public ClienteTemperatura() {
		this.minTemp = null;
		this.maxTemp = null;
	}

	public ClienteTemperatura(Integer id, Double minTemp, Double maxTemp) {
		this.id = id;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public ClienteTemperatura(Integer id, Double minTemp, Double maxTemp, Localizacao localizacao) {
		this.id = id;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.localizacao = localizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}

	public Double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
}
