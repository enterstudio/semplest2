package semplest.server.service.mail;



import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import semplest.services.client.interfaces.SemplestMailServiceInterface;

public class SemplestMailServiceImpl implements SemplestMailServiceInterface
{
	private Session session = null;
	private static final Logger logger = Logger.getLogger(SemplestMailServiceImpl.class);
	@Override
	public Boolean SendEmail(String subject, String from, String recipient, String msgTxt) throws Exception
	{
		MimeMessage msg = new MimeMessage(session);
		msg.setRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress(recipient) });
		msg.setSubject(subject);
		// create and fill the text message part
		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setText(msgTxt);
		// create the Multipart and add its parts to it
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(mbp1);
		msg.setContent(mp);
		// set the Date: header
		msg.setSentDate(new Date());
		Transport transport = session.getTransport("smtp");
		try
		{
			transport.connect();
			transport.sendMessage(msg, msg.getAllRecipients());
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			throw e;
		}
		finally
		{
			transport.close();
		}
		return true;

	}
	/*
	 * input the SMTP host
	 */
	@Override
	public void initializeService(String input) throws Exception
	{
		Properties props = new Properties();
		props.put("mail.smtp.host", input);
		session = Session.getInstance(props, null);
		
	}
}
