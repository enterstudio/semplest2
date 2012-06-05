package semplest.test.unittest;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.SEMplestService;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.MailSessionObject;


public class UnitTests {
	
	private static String now = "";
	
	private static int numMsnStandaloneError = 0;
	private static int numMsnServiceError = 0;
	private static int numGoogleStandaloneError = 0;
	private static int numGoogleServiceError = 0;
	private static int numDatabaseError = 0;
	private static int numAdEngineStandalongError = 0;
	private static int numAdEngineServiceError = 0;
	private static int numKeywordStandaloneError = 0;
	private static int numKeywordServiceError = 0;
	private static int numBiddingStandaloneError = 0;
	private static int numBiddingServiceError = 0;	
	private static int numAllErrs = 0;
	
	public static String eol = System.getProperty("line.separator");
	
	public static void main(String[] args)
	{
		/*
		 * List of Tests:
		 * 
		 * 	- MsnCloudService Test
		 * 	- GoogleAdwordsService Test
		 *  - SchedulerService Test
		 *  - Database Test
		 *  - SemplestAdengineService
		 * 	- KeywordsService
		 * 	- BiddingService
		 * 
		 */				
		
		DateFormat dateFormat = new SimpleDateFormat("_MM-dd-yy_HHmm");
		Date date = new Date();
		now = dateFormat.format(date);
		String reportName = "UnitTestReport" + now + ".txt";
		String reportPath = "/semplest/TestReports/UnitTest/" + reportName;
		//String reportPath = "Z:\\TestReports\\UnitTest\\" + reportName;
		
		try{
			//Create Report Header						
			PrintStream out = new PrintStream(new FileOutputStream(reportPath));
			System.setOut(out);
			
			System.out.println("************************************************************************************");
			System.out.println("*                                                                                  *");
			System.out.println("*                             SEMplest Unit Test Report                            *");
			System.out.println("*                                                                                  *");
			System.out.println("************************************************************************************");
			System.out.println("Report Time: " + now);
			System.out.println("   ");
			
			//Start to Test
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			
			//Test Msn Service
			MsnServiceTest msnServiceTest = new MsnServiceTest();
			numMsnStandaloneError = msnServiceTest.Test_MsnServices_Standalone();	
			//numMsnServiceError = msnServiceTest.Test_MsnReport();  //Test only Report through ESB
			
			
			//Test Google Service
			/* Google is charging money for each request. So only test when the configuration points to SANDBOX! */			
			Boolean useSandbox = (Boolean) configDB.configData.get("AdwordsUseSandbox");
			if(useSandbox){
				GoogleServiceTest googleServiceTest = new GoogleServiceTest();
				numGoogleStandaloneError = googleServiceTest.Test_GoogleService_Standalone();
				//numGoogleServiceError = googleServiceTest.Test_getReportForAccount();  //Test only Report through ESB
			}		
			
			
			//Test Keyword Service		
			KeywordServiceTest keywordServiceTest = new KeywordServiceTest();
			//numKeywordStandaloneError = keywordServiceTest.Test_KeywordService1();  //Impl
			numKeywordServiceError = keywordServiceTest.Test_KeywordService2();  //client
			
			
			//Test Bidding Service		
			BiddingServiceTest biddingServiceTest = new BiddingServiceTest();
			numBiddingServiceError = biddingServiceTest.Test_BiddingService2();  //Client
			
			
			//Test Scheduler
			/*** This test is implemented separately by sending daily emails to Nan ***/
			
			
			//Test Database
			DatabaseTest databaseTest = new DatabaseTest();
			//numDatabaseError = databaseTest.Test_ALL();
			
			
			//Test Adengine Service		
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("////////////////////////////////////////////////////");	
			System.out.println("UNIT TEST ERROR:");
			System.out.println(e.getMessage());
			System.out.println("////////////////////////////////////////////////////");	
			System.out.println(" ");
		}
		
		//Generate Report and Email the Report
		
		numAllErrs = numMsnStandaloneError + numMsnServiceError 
				+ numGoogleStandaloneError + numGoogleServiceError 
				+ numAdEngineStandalongError + numAdEngineServiceError 
				+ numKeywordStandaloneError + numKeywordServiceError 
				+ numBiddingStandaloneError + numBiddingServiceError 
				+ numDatabaseError;
		
		UnitTests unitTest = new UnitTests();
		String summary = unitTest.reportSummary();
		
		System.out.println(" ");
		System.out.println("************************************************************************************");
		System.out.println("*                                                                                  *");
		System.out.println("*                                UNIT TEST SUMMARY                                 *");
		System.out.println("*                                                                                  *");
		System.out.println("************************************************************************************");
		System.out.println(" ");
		System.out.println(summary);
		
		//send email of the test result
		String testResult = (numAllErrs > 0)? "FAILED" : "PASSED";
		summary = summary + eol + "Please look at the report at <\\semplest\\TestReports\\UnitTest\\" + reportName + "> for details";
		String subject = "[Test Result] Semplest Unit Test is " + testResult;
		//send to Nan
		unitTest.sendEmail(subject, "nan@semplest.com", "nan@semplest.com", summary);
		if(numAllErrs > 0){
			//if test failed, send report to Mitch
			unitTest.sendEmail(subject, "nan@semplest.com", "mitch@semplest.com", summary);
		}
        
	}	
	
	private String reportSummary(){
		StringBuilder sb = new StringBuilder();
        sb.append("Unit test finished with " + numAllErrs + " errors in total." + eol + eol);
        sb.append("Msn APIs: 		" + numMsnStandaloneError + " errors" + eol);
        sb.append("Msn Report: 		" + numMsnServiceError + " errors" + eol);
        sb.append("Google APIs: 		" + numGoogleStandaloneError + " errors" + eol);
        sb.append("Google Report: 		" + numGoogleServiceError + " errors" + eol);
        sb.append("Keyword Service:	" + numKeywordServiceError + " errors" + eol);
        sb.append("Bidding Service:	" + numBiddingServiceError + " errors" + eol);
        //sb.append("Database: 		" + numDatabaseError + " errors" + eol);        
        
        
        return sb.toString();		
	}
	
	private void sendEmail(String subject, String from, String to, String msg)
	{					
		/*
	      String host = "VMDEVWEB1";
	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);
	      Session session = Session.getDefaultInstance(properties);	      
		
	      try{
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         message.setSubject(subject);
	         message.setText(msg);
	         
	         Transport.send(message);
	         
	      }catch (Exception e) {
	         e.printStackTrace();
	      }	      
	      */
		
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
