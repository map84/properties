package br.com.properties.json.utils;

import java.io.Serializable;

/**
 * 
 * @author Marcos Alves
 *
 */
public class Coordinate implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer x;
	private Integer y;
	
	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}
}
