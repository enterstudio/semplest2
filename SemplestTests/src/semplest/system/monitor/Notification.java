package semplest.system.monitor;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import semplest.system.monitor.MonitorObject.SERVER;
import semplest.system.monitor.MonitorObject.SERVICE;

public class Notification {
	
	private static String emailFrom = "devuser@semplest.com";
	//private static String emailTo = "nan@semplest.com";
	private static String emailTo = "development@semplest.com";
	
	public static void main(String[] args){
		sendEmail("test", "nan@semplest.com","nan@semplest.com","test");
	}
	
	public static void sendNotification(SERVER server, SERVICE service, String errorMsg){
		String downMsg = "[System Monitor] ALERT! " + service.name() + " Service on " + server.name() + " Server is down!";
		String upMsg = "[System Monitor] " + service.name() + " Service on " + server.name() + " Server is back to normal.";		
		
		if(errorMsg != null){
			sendEmail(downMsg, emailFrom, emailTo, errorMsg);
		}
		else{
			sendEmail(upMsg, emailFrom, emailTo, upMsg);
		}
	}
	
	private static void sendEmail(String subject, String from, String to, String msg)
	{			
		final String username = "nan@semplest.com";
		final String password = "semplest";
 
		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(msg);
 
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
