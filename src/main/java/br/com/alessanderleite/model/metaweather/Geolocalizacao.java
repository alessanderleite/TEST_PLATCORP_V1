package br.com.alessanderleite.model.metaweather;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * fonte: https://www.metaweather.com/api/
 * Location Search
 * 
 * @author Alessander
 *
 */
@Entity
@Table(name = "geolocalizacao")
public class Geolocalizacao implements Comparable<Geolocalizacao> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	private String distance;
	private String title;
	private String locationType;
	private String woeid;
	private String lattLong;
	
	public Geolocalizacao() {}

	public Geolocalizacao(Integer id, String distance, String title, String locationType, String woeid, String lattLong) {
		this.id = id;
		this.distance = distance;
		this.title = title;
		this.locationType = locationType;
		this.woeid = woeid;
		this.lattLong = lattLong;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
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

	public String getWoeid() {
		return woeid;
	}

	public void setWoeid(String woeid) {
		this.woeid = woeid;
	}

	public String getLattLong() {
		return lattLong;
	}

	public void setLattLong(String lattLong) {
		this.lattLong = lattLong;
	}

	@Override
	public int compareTo(Geolocalizacao o) {
		
		if (Integer.parseInt(this.distance) <= Integer.parseInt(o.distance)) {
			return -1;
		} else {
			return 1;	
		}
		
	}
}
