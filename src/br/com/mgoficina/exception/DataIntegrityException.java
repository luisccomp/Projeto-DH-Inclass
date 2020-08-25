package br.com.mgoficina.exception;

public class DataIntegrityException extends RuntimeException {

	private static final String MESSAGE = "Falha no campo:  ";
	
	public DataIntegrityException(String message) {
		super(MESSAGE+message);
		
	}
	
	
}
