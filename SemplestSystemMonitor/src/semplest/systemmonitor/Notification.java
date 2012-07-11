package semplest.systemmonitor;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import semplest.systemmonitor.MonitorObject.SERVER;
import semplest.systemmonitor.MonitorObject.SERVICE;

public class Notification {
	
	private static String emailFrom = "system@semplest.com";
	//private static String emailTo = "nan@semplest.com";
	private static String emailTo = "development@semplest.com";
	
	public static void sendNotification(SERVER server, SERVICE service, String errorMsg){
		String downMsg = "[System Monitor] ALERT! " + service.name() + " Service on " + server.name() + " server is down!";
		String upMsg = "[System Monitor] " + service.name() + " Service on " + server.name() + " server is back to normal.";		
		
		if(errorMsg != null){
			sendEmail(downMsg, emailFrom, emailTo, errorMsg);
		}
		else{
			sendEmail(upMsg, emailFrom, emailTo, upMsg);
		}
	}
	
	private static void sendEmail(String subject, String from, String to, String msg)
	{			
		String host = "smtp.gmail.com";
	    String username = "nan@semplest.com";
	    String password = "semplest";
	    Properties props = new Properties();
	    props.put("mail.smtps.auth", "true");
	    
	    Session session = Session.getDefaultInstance(props);	
	    
	    MimeMessage message = new MimeMessage(session);	   
	    Transport t = null;
	    try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	        message.setSubject(subject);
	        message.setText(msg);
	        
	        t = session.getTransport("smtps");
			t.connect(host, username, password);
			t.sendMessage(message, message.getAllRecipients());
			
		} catch (AddressException e1) {
			e1.printStackTrace();
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}        
	    finally{
	    	try {
				t.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
	    }   		
	}
	
}
