package semplest.other;

public class SemplestError extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public SemplestError(String message) {
		super(message);
	}
	
	public SemplestError(Exception e) {
		super(e);
	}
	
	public SemplestError(String message, Exception e) {
		super(message, e);
	}
}
