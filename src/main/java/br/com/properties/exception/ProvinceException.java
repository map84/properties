package br.com.properties.exception;

public class ProvinceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProvinceException(Exception e) {
		super(e);
	}
	
	public ProvinceException(String message, Exception e) {
		super(message, e);
	}
}
