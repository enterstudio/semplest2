package semplest.services.client.interfaces;

public interface SemplestMailServiceInterface extends ServiceInitialize
{
	public abstract Boolean SendEmail(String subject,String from,  String recipient, String msgTxt, String msgType) throws Exception;
	public abstract Boolean scheduleSendEmail(String subject,String from,  String recipient, String msgTxt, String msgType) throws Exception;
}
