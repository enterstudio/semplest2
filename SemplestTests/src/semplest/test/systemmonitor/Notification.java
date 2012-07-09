package semplest.test.systemmonitor;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import semplest.test.systemmonitor.MonitorData.SERVER;
import semplest.test.systemmonitor.MonitorData.SERVICE;

public class Notification {
	
	private String emailFrom = "nan@semplest.com";
	private String emailTo = "development@semplest.com";
	
	public void sendNotification(SERVER server, SERVICE service, boolean isServiceHealthy){
		String downMsg = "[ServiceMonitor] Service Down! " + service.name() + "Service on " + server.name() + ".";
		String upMsg = "[ServiceMonitor] Service Back to Normal. " + service.name() + "Service on " + server.name() + ".";		
		
		if(!isServiceHealthy){
			sendEmail(downMsg, emailFrom, emailTo, downMsg);
		}
		else{
			sendEmail(upMsg, emailFrom, emailTo, upMsg);
		}
	}
	
	public void sendEmail(String subject, String from, String to, String msg)
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
