package br.com.alessanderleite.retorno.retorno;

import java.io.Serializable;

public class HistoricoR implements Serializable{
	private static final long serialVersionUID = 7860759791179986727L;

	private Integer id;
	
	private String minTemp;
	
	private String maxTemp;
	
	private GeolocalizacaoR localidade;
	
	public HistoricoR( ) {
	}

	public HistoricoR(Integer id, String minTemp, String maxTemp, GeolocalizacaoR localidade) {
		this.id = id;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.localidade = localidade;
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

	public GeolocalizacaoR getLocalidade() {
		return localidade;
	}

	public void setLocalidade(GeolocalizacaoR localidade) {
		this.localidade = localidade;
	}
}
