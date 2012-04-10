package semplest.services.client.interfaces;

public interface MailServiceInterface
{
	public abstract Boolean SendEmail(String subject, String recipient, String msgTxt, String filename);
}
