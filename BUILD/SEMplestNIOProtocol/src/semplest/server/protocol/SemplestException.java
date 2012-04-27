package semplest.server.protocol;

public class SemplestException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String SemplestErrorID;
	private String SemplestErrorMessage;
	public String getSemplestErrorID()
	{
		return SemplestErrorID;
	}
	public void setSemplestErrorID(String semplestErrorID)
	{
		SemplestErrorID = semplestErrorID;
	}
	public String getSemplestErrorMessage()
	{
		return SemplestErrorMessage;
	}
	public void setSemplestErrorMessage(String semplestErrorMessage)
	{
		SemplestErrorMessage = semplestErrorMessage;
	}

}
