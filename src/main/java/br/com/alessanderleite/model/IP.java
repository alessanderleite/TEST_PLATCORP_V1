package br.com.alessanderleite.model;

/**
 * fonte: https://httpbin.org/
 * 
 * @author Alessander
 *
 */
public class IP {

	private String origin;

	public IP() {}

	public IP(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
	return origin;
	}
	
	public void setOrigin(String origin) {
	this.origin = origin;
	}

	@Override
	public String toString() {
		return "IP [origin=" + origin + "]";
	}
}