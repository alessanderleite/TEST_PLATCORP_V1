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

import org.springframework.stereotype.Component;

import br.com.alessanderleite.model.ipvigilante.Localizacao;


/**
 * 
 * @author Alessander
 *
 */
@Component
@Entity
@Table(name = "historico")
public class Historico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private String minTemp;
	private String maxTemp;
	
	@OneToMany(mappedBy = "historico", fetch = FetchType.LAZY)
	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "id_localidade", referencedColumnName = "id", nullable = false)})
	private Localizacao localidade;
	
	public Historico() {
		this.minTemp = null;
		this.maxTemp = null;
	}

	public Historico(Integer id, String minTemp, String maxTemp, Localizacao localidade) {
		this.id = id;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.localidade = localidade;
	}

	public Historico(Integer id, String minTemp, String maxTemp) {
		this.id = id;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}

	public String getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Localizacao getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localizacao localidade) {
		this.localidade = localidade;
	}
}
