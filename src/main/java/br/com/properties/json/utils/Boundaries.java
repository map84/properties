package br.com.properties.json.utils;

import java.io.Serializable;

/**
 * 
 * @author Marcos Alves
 *
 */
public class Boundaries implements Serializable {

	private static final long serialVersionUID = 1L;

	private Coordinate upperLeft;
	private Coordinate bottomRight;
	
	/**
	 * @return the upperLeft
	 */
	public Coordinate getUpperLeft() {
		return upperLeft;
	}
	/**
	 * @param upperLeft the upperLeft to set
	 */
	public void setUpperLeft(Coordinate upperLeft) {
		this.upperLeft = upperLeft;
	}
	/**
	 * @return the bottomRight
	 */
	public Coordinate getBottomRight() {
		return bottomRight;
	}
	/**
	 * @param bottomRight the bottomRight to set
	 */
	public void setBottomRight(Coordinate bottomRight) {
		this.bottomRight = bottomRight;
	}
}
