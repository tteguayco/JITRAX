package es.ull.etsii.jitrax.exceptions;

public class DuplicateTableException extends Exception {
	private static final String DEFAULT_MESSAGE = "DuplicatePrimaryKeyException was thrown";
	
	public DuplicateTableException() {
		super(DEFAULT_MESSAGE);
	}
	
	public DuplicateTableException(String message) {
		super(message);
	}
}
