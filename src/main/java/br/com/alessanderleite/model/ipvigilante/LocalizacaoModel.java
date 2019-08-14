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

import br.com.alessanderleite.model.HistoricoModel;

/**
 * fonte: https://www.ipvigilante.com/
 * 
 * @author Alessander
 *
 */
@Component
@Entity
@Table(name = "localizacao")
public class LocalizacaoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	private Integer id;
	
	private String status;
	
	@OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "id_date", referencedColumnName = "id", nullable = false)})
	private DataModel data;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localizacao")
	private Set<HistoricoModel> historicos = new HashSet<HistoricoModel>(0);

	public LocalizacaoModel() {}

	public LocalizacaoModel(Integer id, DataModel data) {
		this.id = id;
		this.data = data;
	}

	public LocalizacaoModel(Integer id, String status, DataModel data) {
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

	public DataModel getData() {
		return data;
	}

	public void setData(DataModel data) {
		this.data = data;
	}

	public Set<HistoricoModel> getHistoricos() {
		return historicos;
	}

	public void setHistorico(Set<HistoricoModel> historicos) {
		this.historicos = historicos;
	}
}