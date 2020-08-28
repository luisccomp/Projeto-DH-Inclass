package br.com.mgoficina.exception;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = -7257310193270972655L;

	public DataIntegrityException(String message) {
		super(message);
	}
	
}
