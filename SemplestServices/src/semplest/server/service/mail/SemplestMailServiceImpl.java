package semplest.server.service.mail;



import javax.mail.Session;

import semplest.services.client.interfaces.MailServiceInterface;

public class SemplestMailServiceImpl implements MailServiceInterface
{

	private Session session = null;
	@Override
	public Boolean SendEmail(String subject, String recipient, String msgTxt, String filename)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
