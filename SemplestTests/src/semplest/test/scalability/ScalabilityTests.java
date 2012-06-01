package semplest.test.scalability;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.microsoft.adcenter.v8.ReportAggregation;

import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.api.GoogleAdwordsServiceClient;
import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.services.client.api.MSNAdcenterServiceClient;
import semplest.test.unittest.GoogleServiceTest;
import semplest.test.unittest.MsnServiceTest;
import semplest.test.unittest.UnitTests;

import sun.misc.Signal;
import sun.misc.SignalHandler;

public class ScalabilityTests {		

	public static void main(String args[]){		
		
		try{
			//Start to Test
			ExecutorService executor = Executors.newCachedThreadPool();
			int frequency = 0;			
			
			//Test ESB		
			/*
			frequency = 3;
			executor.execute(new EsbTestThread(EsbTestThread.SERVICE_INDEX.all, frequency));	
			Thread.sleep(10);
			executor.execute(new EsbTestThread(EsbTestThread.SERVICE_INDEX.all, frequency));
			*/
			
			//Test Keyword
			
			frequency = 2;
			executor.execute(new KeywordTestThread(frequency));
			Thread.sleep(10);
			executor.execute(new KeywordTestThread(frequency));
			
		}
		catch(Exception e){
			e.printStackTrace();
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
