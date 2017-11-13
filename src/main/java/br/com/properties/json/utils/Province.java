package br.com.properties.json.utils;

import java.io.Serializable;

/**
 * 
 * @author Marcos Alves
 *
 */
public class Province implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boundaries boundaries;

	/**
	 * @return the boundaries
	 */
	public Boundaries getBoundaries() {
		return boundaries;
	}

	/**
	 * @param boundaries the boundaries to set
	 */
	public void setBoundaries(Boundaries boundaries) {
		this.boundaries = boundaries;
	}
}