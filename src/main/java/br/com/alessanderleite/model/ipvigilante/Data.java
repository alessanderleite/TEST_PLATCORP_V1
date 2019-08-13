package br.com.alessanderleite.model.ipvigilante;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * fonte de referência: https://ipvigilante.com/
 * 
 * @author Alessander
 *
 */
@Entity
@Table(name = "data")
public class Data {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	private String ipv4;
	private String continentName;
	private String countryName;
	private String subdivision1Name;
	private String subdivision2Name;
	private String cityName;
	private String latitude;
	private String longitude;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "data")
	private Set<Localizacao> localizacoes = new HashSet<Localizacao>(0);
	
	public Data() {}

	public Data(String ipv4, String continentName, String countryName, String cityName, String latitude,
			String longitude) {
		this.ipv4 = ipv4;
		this.continentName = continentName;
		this.countryName = countryName;
		this.cityName = cityName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Data(Integer id, String ipv4, String continentName, String countryName, String cityName, String latitude,
			String longitude) {
		this.id = id;
		this.ipv4 = ipv4;
		this.continentName = continentName;
		this.countryName = countryName;
		this.cityName = cityName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Data(Integer id, String ipv4, String continentName, String countryName, String subdivision1Name,
			String subdivision2Name, String cityName, String latitude, String longitude,
			Set<Localizacao> localizacoes) {
		this.id = id;
		this.ipv4 = ipv4;
		this.continentName = continentName;
		this.countryName = countryName;
		this.subdivision1Name = subdivision1Name;
		this.subdivision2Name = subdivision2Name;
		this.cityName = cityName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.localizacoes = localizacoes;
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

	public String getSubdivision1Name() {
		return subdivision1Name;
	}

	public void setSubdivision1Name(String subdivision1Name) {
		this.subdivision1Name = subdivision1Name;
	}

	public String getSubdivision2Name() {
		return subdivision2Name;
	}

	public void setSubdivision2Name(String subdivision2Name) {
		this.subdivision2Name = subdivision2Name;
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

	public Set<Localizacao> getLocalizacoes() {
		return localizacoes;
	}

	public void setLocalizacoes(Set<Localizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}
}