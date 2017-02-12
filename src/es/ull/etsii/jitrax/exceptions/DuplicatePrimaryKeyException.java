package es.ull.etsii.jitrax.exceptions;

public class DuplicatePrimaryKeyException extends Exception {
	private static final String DEFAULT_MESSAGE = "DuplicatePrimaryKeyException was thrown";
	
	public DuplicatePrimaryKeyException() {
		super(DEFAULT_MESSAGE);
	}
	
	public DuplicatePrimaryKeyException(String message) {
		super(message);
	}
}
