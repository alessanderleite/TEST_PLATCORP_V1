package br.com.alessanderleite.valueobject;

import br.com.alessanderleite.model.ipvigilante.Localizacao;

public class DataGeoVO {
	
	private Integer id;
	private String ipv4;
	private String continentName;
	private String countryName;
	private String cityName;
	private String latitude;
	private String longitude;
	
	public DataGeoVO() {}

	public DataGeoVO(Integer id, String ipv4, String continentName, String countryName, String cityName,
			String latitude, String longitude) {
		this.id = id;
		this.ipv4 = ipv4;
		this.continentName = continentName;
		this.countryName = countryName;
		this.cityName = cityName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public DataGeoVO(Localizacao localizacao) {
		this.id = localizacao.getId();
		this.ipv4 = localizacao.getData().getIpv4();
		this.continentName = localizacao.getData().getContinentName();
		this.countryName = localizacao.getData().getCountryName();
		this.cityName = localizacao.getData().getCityName();
		this.latitude = localizacao.getData().getLatitude();
		this.longitude = localizacao.getData().getLongitude();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
