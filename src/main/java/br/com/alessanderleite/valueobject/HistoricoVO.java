package br.com.alessanderleite.valueobject;

public class HistoricoVO {

	private Integer id;
	private String minTemp;
	private String maxTemp;
	private DataGeoVO localidade;
	
	public HistoricoVO() {}

	public HistoricoVO(Integer id, String minTemp, String maxTemp, DataGeoVO localidade) {
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

	public DataGeoVO getLocalidade() {
		return localidade;
	}

	public void setLocalidade(DataGeoVO localidade) {
		this.localidade = localidade;
	}
}
