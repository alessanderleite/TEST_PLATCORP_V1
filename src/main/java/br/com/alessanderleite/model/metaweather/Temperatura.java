package br.com.alessanderleite.model.metaweather;

/**
 * fonte: https://www.metaweather.com/api/
 * Location Day
 * 
 * @author Alessander
 *
 */
public class Temperatura {

	private Integer id;
	private String weatherStateName;
	private String weatherStateAbbr;
	private String windDirectionCompass;
	private String created;
	private String applicableDate;
	private Double minTemp;
	private Double maxTemp;
	private Double theTemp;
	private Double windSpeed;
	private Double windDirection;
	private Double airPressure;
	private Integer humidity;
	private Object visibility;
	private Integer predictability;

	public Temperatura() {}

	public Temperatura(Integer id, String weatherStateName, String weatherStateAbbr, String windDirectionCompass,
			String created, String applicableDate, Double minTemp, Double maxTemp, Double theTemp, Double windSpeed,
			Double windDirection, Double airPressure, Integer humidity, Object visibility, Integer predictability) {
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

	public Double getTheTemp() {
		return theTemp;
	}

	public void setTheTemp(Double theTemp) {
		this.theTemp = theTemp;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Double getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Double windDirection) {
		this.windDirection = windDirection;
	}

	public Double getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(Double airPressure) {
		this.airPressure = airPressure;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Object getVisibility() {
		return visibility;
	}

	public void setVisibility(Object visibility) {
		this.visibility = visibility;
	}

	public Integer getPredictability() {
		return predictability;
	}

	public void setPredictability(Integer predictability) {
		this.predictability = predictability;
	}

	@Override
	public String toString() {
		return "Temperatura [id=" + id + ", weatherStateName=" + weatherStateName + ", weatherStateAbbr="
				+ weatherStateAbbr + ", windDirectionCompass=" + windDirectionCompass + ", created=" + created
				+ ", applicableDate=" + applicableDate + ", minTemp=" + minTemp + ", maxTemp=" + maxTemp + ", theTemp="
				+ theTemp + ", windSpeed=" + windSpeed + ", windDirection=" + windDirection + ", airPressure="
				+ airPressure + ", humidity=" + humidity + ", visibility=" + visibility + ", predictability="
				+ predictability + "]";
	}

}
