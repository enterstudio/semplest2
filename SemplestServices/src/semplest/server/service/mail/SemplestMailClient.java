package semplest.server.service.mail;

import org.apache.log4j.Logger;

import semplest.services.client.api.SemplestMailServiceClient;

public class SemplestMailClient
{
	private static final Logger logger = Logger.getLogger(SemplestMailClient.class);
	
	public static void sendMailFromService(String ESBUrl,String subject, String from, String recipient, String msgTxt, String msgType) throws Exception
	{
		try
		{
			SemplestMailServiceClient client = new SemplestMailServiceClient(ESBUrl);
			Boolean ret = client.SendEmail(subject, from, recipient, msgTxt, msgType);
			logger.info("Sent Email: " + subject + ":" + from + ":" + recipient + ":" + msgTxt);
		}
		catch (Exception e)
		{
			logger.error("Error Sending Email: " + subject + ":" + from + ":" + recipient + ":" + msgTxt, e);
			throw e;
		}
	}

}
