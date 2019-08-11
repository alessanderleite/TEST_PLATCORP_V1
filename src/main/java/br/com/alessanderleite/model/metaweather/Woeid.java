package br.com.alessanderleite.model.metaweather;

/**
 * fonte: https://www.metaweather.com/api/
 * Location Search
 * 
 * @author Alessander
 *
 */
public class Woeid {

	private Integer distance;
	private String title;
	private String locationType;
	private Integer woeid;
	private String lattLong;
	
	public Woeid() {}

	public Woeid(Integer distance, String title, String locationType, Integer woeid, String lattLong) {
		this.distance = distance;
		this.title = title;
		this.locationType = locationType;
		this.woeid = woeid;
		this.lattLong = lattLong;
	}

	public Integer getDistance() {
		return distance;
	}
	
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLocationType() {
		return locationType;
	}
	
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}
	
	public Integer getWoeid() {
		return woeid;
	}
	
	public void setWoeid(Integer woeid) {
		this.woeid = woeid;
	}
	
	public String getLattLong() {
		return lattLong;
	}
	
	public void setLattLong(String lattLong) {
		this.lattLong = lattLong;
	}

	@Override
	public String toString() {
		return "Woeid [distance=" + distance + ", title=" + title + ", locationType=" + locationType + ", woeid="
				+ woeid + ", lattLong=" + lattLong + "]";
	}
}
