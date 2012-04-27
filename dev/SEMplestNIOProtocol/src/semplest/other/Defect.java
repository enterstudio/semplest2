package semplest.other;

public class Defect extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public Defect(String message) {
		super(message);
	}
	
	public Defect(Exception e) {
		super(e);
	}
}
