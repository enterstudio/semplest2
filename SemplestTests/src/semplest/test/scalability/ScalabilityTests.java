package semplest.test.scalability;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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

public class ScalabilityTests {
	
	public enum SERVICE_INDEX {all, service_google, service_msn, service_keyword, service_bidding, service_mail, service_adengine};
	
	public static String eol = System.getProperty("line.separator");

	public static void main(String args[]){
		DateFormat dateFormat = new SimpleDateFormat("_MM-dd-yy_HHmm");
		Date date = new Date();
		String now = dateFormat.format(date);
		String reportName = "ScalabilityTestReport" + now + ".txt";
		String reportPath = "Z:\\TestReports\\ScalabilityTest\\" + reportName;
		
		try{
			//Create Report Header						
			//PrintStream out = new PrintStream(new FileOutputStream(reportPath));
			//System.setOut(out);
			
			DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");		
			File file = new File(reportPath);
			FileWriter fstream = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("Start SEMplest Scalability Test at >>> " + date + eol);				
			
			
			System.out.println("************************************************************************************");
			System.out.println("*                                                                                  *");
			System.out.println("*                            SEMplest Scalability Test                             *");
			System.out.println("*                                                                                  *");
			System.out.println("************************************************************************************");
			System.out.println("Report Time: " + now);
			System.out.println(" ");
			
			//Start to Test
			
			//Test ESB
			System.out.println("Start to test ESB...");		
			out.write(eol + "********** ESB TEST **********" + eol);
			int freq1 = 20; 
			int freq2 = 30; 
			int freq3 = 60;
			
			ExecutorService executor = Executors.newCachedThreadPool();
			
			System.out.println("Start a test thread that sends random request to ESB server with frequency of " + freq1 + "/min...");
			out.write("Start a test thread that sends random request to ESB server with frequency of " + freq1 + "/min." + eol);
			executor.execute(new EsbTestThread(SERVICE_INDEX.all, freq1, reportPath));
			
			System.out.println("Start a test thread that sends random request to ESB server with frequency of " + freq2 + "/min...");
			out.write("Start a test thread that sends random request to ESB server with frequency of " + freq2 + "/min." + eol);
			executor.execute(new EsbTestThread(SERVICE_INDEX.all, freq2, reportPath));
			
			System.out.println("Start a test thread that sends random request to ESB server with frequency of " + freq3 + "/min...");
			out.write("Start a test thread that sends random request to ESB server with frequency of " + freq3 + "/min." + eol);
			executor.execute(new EsbTestThread(SERVICE_INDEX.all, freq3, reportPath));
			
			
						
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("////////////////////////////////////////////////////");	
			System.out.println("SCALABILITY TEST ERROR:");
			System.out.println(e.getMessage());
			System.out.println("////////////////////////////////////////////////////");	
			System.out.println(" ");
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
