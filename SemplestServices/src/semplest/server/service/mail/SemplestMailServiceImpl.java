package semplest.server.service.mail;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.service.SemplestConfiguration;
import semplest.service.scheduler.CreateSchedulerAndTask;
import semplest.services.client.interfaces.SemplestMailServiceInterface;

import com.google.gson.Gson;

public class SemplestMailServiceImpl implements SemplestMailServiceInterface
{
	
	private static final Logger logger = Logger.getLogger(SemplestMailServiceImpl.class);
	private static Gson gson = new Gson();
	private static MailSessionObject sessionObj = null;
	
	private String ESBWebServerURL = null;
	private static AtomicInteger atomic = new AtomicInteger(Integer.MIN_VALUE);
	
	
	public String SendEmail(String json) throws Exception
	{
		logger.debug("call  SendEmail(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		String subject = data.get("subject");
		String from = data.get("from");
		String recipient = data.get("recipient");
		String msgTxt = data.get("msgTxt");
		String msgType = data.get("msgType");
		Boolean res = SendEmail(subject, from, recipient, msgTxt, msgType);
		return gson.toJson(res);
	}
	@Override
	public Boolean SendEmail(String subject, String from, String recipient, String msgTxt, String msgType) throws Exception
	{
		logger.debug("SendMail" + "- subject:" + subject +"; from: " + from + "; recipient: " + recipient + "; msgTxt: " + msgTxt);
		if (sessionObj.getSession() == null)
		{
			throw new Exception("Session is Null");
		}
		
		MimeMessage msg = new MimeMessage(sessionObj.getSession());
		msg.setRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress(recipient) });
		msg.setFrom(new InternetAddress(from));
		msg.setSubject(subject);
		// create and fill the text message part
		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setContent(msgTxt, msgType);
		// create the Multipart and add its parts to it
		Multipart mp = new MimeMultipart();
		mp.addBodyPart(mbp1);
		msg.setContent(mp);
		// set the Date: header
		msg.setSentDate(new Date());
		Transport transport = sessionObj.getSession().getTransport("smtp");
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
		/*
		 * Read in the Config Data from DB into HashMap<key, Object>
		 * SemplestConfiguation.configData
		 */
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		//
		ESBWebServerURL = (String) SemplestConfiguration.configData.get("ESBWebServerURL");
		//
		sessionObj = new MailSessionObject();
		Thread t = new Thread(sessionObj);
		t.start();
		logger.info("Started Session thread...");
	}
	@Override
	public Boolean scheduleSendEmail(String subject, String from, String recipient, String msgTxt, String msgType) throws Exception
	{
		
		ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
		SemplestSchedulerTaskObject mailTask = CreateSchedulerAndTask.getSendMailTask(subject, from, recipient, msgTxt);
		listOfTasks.add(mailTask);
		return CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL,listOfTasks, "EmailSchedule_" + getNextNumber() , new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, null, null, null);
	}
	private static Integer getNextNumber()
	{
		if (atomic.get() < Integer.MAX_VALUE)
		{
			return atomic.incrementAndGet();
		}
		else
		{
			return Integer.MIN_VALUE;
		}
	}
}
