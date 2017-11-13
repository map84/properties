package br.com.properties.json.utils;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Marcos Alves
 *
 */
public class Provinces implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value="Gode")
	private Province gode;
	
	@JsonProperty(value="Ruja")
	private Province ruja;
	
	@JsonProperty(value="Jaby")
	private Province jaby;
	
	@JsonProperty(value="Scavy")
	private Province scavy;
	
	@JsonProperty(value="Groola")
	private Province groola;
	
	@JsonProperty(value="Nova")
	private Province nova;
	
	/**
	 * @return the gode
	 */
	public Province getGode() {
		return gode;
	}
	/**
	 * @param gode the gode to set
	 */
	public void setGode(Province gode) {
		this.gode = gode;
	}
	/**
	 * @return the ruja
	 */
	public Province getRuja() {
		return ruja;
	}
	/**
	 * @param ruja the ruja to set
	 */
	public void setRuja(Province ruja) {
		this.ruja = ruja;
	}
	/**
	 * @return the jaby
	 */
	public Province getJaby() {
		return jaby;
	}
	/**
	 * @param jaby the jaby to set
	 */
	public void setJaby(Province jaby) {
		this.jaby = jaby;
	}
	/**
	 * @return the scavy
	 */
	public Province getScavy() {
		return scavy;
	}
	/**
	 * @param scavy the scavy to set
	 */
	public void setScavy(Province scavy) {
		this.scavy = scavy;
	}
	/**
	 * @return the groola
	 */
	public Province getGroola() {
		return groola;
	}
	/**
	 * @param groola the groola to set
	 */
	public void setGroola(Province groola) {
		this.groola = groola;
	}
	/**
	 * @return the nova
	 */
	public Province getNova() {
		return nova;
	}
	/**
	 * @param nova the nova to set
	 */
	public void setNova(Province nova) {
		this.nova = nova;
	}
}
