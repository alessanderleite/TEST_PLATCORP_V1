package br.com.alessanderleite.model.metaweather;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * fonte: https://www.metaweather.com/api/
 * Location Day
 * 
 * @author Alessander
 *
 */
@Entity
@Table(name = "clima")
public class Clima {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	@JsonIgnore
	private Integer id;
	private String weatherStateName;
	private String weatherStateAbbr;
	private String windDirectionCompass;
	private String created;
	private String applicableDate;
	private String minTemp;
	private String maxTemp;
	private String theTemp;
	private String windSpeed;
	private String windDirection;
	private String airPressure;
	private String humidity;
	private String visibility;
	private String predictability;

	public Clima() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWeatherStateName() {
		return weatherStateName;
	}

	public void setWeatherStateName(String weatherStateName) {
		this.weatherStateName = weatherStateName;
	}

	public String getWeatherStateAbbr() {
		return weatherStateAbbr;
	}

	public void setWeatherStateAbbr(String weatherStateAbbr) {
		this.weatherStateAbbr = weatherStateAbbr;
	}

	public String getWindDirectionCompass() {
		return windDirectionCompass;
	}

	public void setWindDirectionCompass(String windDirectionCompass) {
		this.windDirectionCompass = windDirectionCompass;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getApplicableDate() {
		return applicableDate;
	}

	public void setApplicableDate(String applicableDate) {
		this.applicableDate = applicableDate;
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

	public String getTheTemp() {
		return theTemp;
	}

	public void setTheTemp(String theTemp) {
		this.theTemp = theTemp;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(String airPressure) {
		this.airPressure = airPressure;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getPredictability() {
		return predictability;
	}

	public void setPredictability(String predictability) {
		this.predictability = predictability;
	}
}
