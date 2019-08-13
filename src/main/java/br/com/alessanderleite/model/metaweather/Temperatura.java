package br.com.alessanderleite.model.metaweather;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * fonte: https://www.metaweather.com/api/
 * Location Day
 * 
 * @author Alessander
 *
 */
@Entity
@Table(name = "temperatura")
public class Temperatura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
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

	public Temperatura() {}

	public Temperatura(Integer id, String weatherStateName, String weatherStateAbbr, String windDirectionCompass,
			String created, String applicableDate, String minTemp, String maxTemp, String theTemp, String windSpeed,
			String windDirection, String airPressure, String humidity, String visibility, String predictability) {
		this.id = id;
		this.weatherStateName = weatherStateName;
		this.weatherStateAbbr = weatherStateAbbr;
		this.windDirectionCompass = windDirectionCompass;
		this.created = created;
		this.applicableDate = applicableDate;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
		this.theTemp = theTemp;
		this.windSpeed = windSpeed;
		this.windDirection = windDirection;
		this.airPressure = airPressure;
		this.humidity = humidity;
		this.visibility = visibility;
		this.predictability = predictability;
	}

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
