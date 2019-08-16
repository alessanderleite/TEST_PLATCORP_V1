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

import org.springframework.stereotype.Component;

import br.com.alessanderleite.model.Historico;

/**
 * 
 * @author Alessander
 *
 */
@Component
@Entity
@Table(name = "localizacao")
public class Localizacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private String status;
	
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_data", referencedColumnName = "id", nullable = false) })
	private Data data;
	
	@OneToMany(mappedBy = "localidade", fetch = FetchType.LAZY)
	private Set<Historico> historicos = new HashSet<Historico>(0);

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

	public Set<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(Set<Historico> historicos) {
		this.historicos = historicos;
	}
}