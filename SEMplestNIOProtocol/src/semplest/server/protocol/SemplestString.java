package semplest.server.protocol;

public class SemplestString {
	private String semplestString;

	public String getSemplestString() {
		return semplestString;
	}

	public void setSemplestString(String semplestString) {
		this.semplestString = semplestString;
	}
	
	public SemplestString toSemplestString(String string){
		SemplestString ret = new SemplestString();
		ret.setSemplestString(string);
		return ret;
	}

}
