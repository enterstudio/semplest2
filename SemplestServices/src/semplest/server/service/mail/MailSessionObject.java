package semplest.server.service.mail;

import java.util.Properties;

import javax.mail.Session;

import org.apache.log4j.Logger;

import semplest.server.service.SemplestConfiguration;

public class MailSessionObject implements Runnable
{

	private static final Logger logger = Logger.getLogger(MailSessionObject.class);
	private Session session = null;
	@Override
	public void run()
	{
		logger.info("initialize SMTP server ");
		Properties props = new Properties();
		props.put("mail.smtp.host", (String) SemplestConfiguration.configData.get("ServiceSMTP")); //SEMplestService.properties.getProperty("SMTP"));
		session = Session.getInstance(props, null);
		try
		{
			Thread.sleep(0);
		}
		catch (InterruptedException e)
		{
			logger.error("THREAD INTERRUPTED...", e);
		}
	}
	public Session getSession()
	{
		return session;
	}

}
