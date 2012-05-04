package semplest.test.unittest;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import semplest.server.service.SEMplestService;
import semplest.server.service.mail.MailSessionObject;


public class UnitTests {
	
	private static String now = "";
	
	private static int numMsnStandaloneError = 0;
	private static int numMsnServiceError = 0;
	private static int numGoogleStandaloneError = 0;
	private static int numGoogleServiceError = 0;
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
		 * List of services/methods that needs to be tested:
		 * 	- SemplestAdengineService
		 * 	- MsnCloudService
		 * 	- GoogleAdwordsService
		 * 	- KeywordsService
		 * 	- BiddingService
		 * 
		 */				
		
		DateFormat dateFormat = new SimpleDateFormat("_MM-dd-yy_HHmm");
		Date date = new Date();
		now = dateFormat.format(date);
		String reportName = "UnitTestReport" + now + ".txt";
		String reportPath = "\\Z:\\TestReports\\UnitTest\\" + reportName;
		
		try{
			//Create Report						
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
			
			//Test Msn Service
			MsnServiceTest msnServiceTest = new MsnServiceTest();
			numMsnStandaloneError = msnServiceTest.Test_MsnServices_Standalone();	
			numMsnServiceError = msnServiceTest.Test_MsnServices_Service();
			
			//Test Google Service
			GoogleServiceTest googleServiceTest = new GoogleServiceTest();
			numGoogleStandaloneError = googleServiceTest.Test_GoogleService_Standalone();
			numGoogleServiceError = googleServiceTest.Test_GoogleService_Service();
			
			//Test Adengine Service
			
			
			//Test Keyword Service
			
			
			//Test Bidding Service		
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("////////////////////////////////////////////////////");	
			System.out.println("ERROR:");
			System.out.println(e.getMessage());
			System.out.println("////////////////////////////////////////////////////");	
			System.out.println(" ");
			System.out.println("************************************************************************************");
			System.out.println("*                                                                                  *");
			System.out.println("*                             SEMplest Unit Test FAILED                            *");
			System.out.println("*                                                                                  *");
			System.out.println("************************************************************************************");

		}
		
		numAllErrs = numMsnStandaloneError + numMsnServiceError + numGoogleStandaloneError + numGoogleServiceError 
				+ numAdEngineStandalongError + numAdEngineServiceError + numKeywordStandaloneError + numKeywordServiceError 
				+ numBiddingStandaloneError + numBiddingServiceError;
		
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
		String testResult = (numAllErrs > 0)? "FAILED" : "SUCCESSFUL";
		summary = summary + eol + "Detail report is at \\semplest\\TestReports\\UnitTest\\" + reportName;
		String subject = "[Test Result] Semplest Unit Test is " + testResult;
		unitTest.sendEmail(subject, "nan@semplest.com", "nan@semplest.com", summary);
		//unitTest.sendEmail(subject, "nan@semplest.com", "mitch@semplest.com", summary);
        
	}	
	
	private String reportSummary(){
		StringBuilder sb = new StringBuilder();
        sb.append("Unit test finished with " + numAllErrs + " errors in total." + eol);
        sb.append("Msn Service (Standalone): 		" + numMsnStandaloneError + " errors" + eol);
        sb.append("Msn Service (Service): 			" + numMsnServiceError + " errors" + eol);
        sb.append("Google Service (Standalone): 		" + numGoogleStandaloneError + " errors" + eol);
        sb.append("Google Service (Service): 		" + numGoogleServiceError + " errors" + eol);
        sb.append("Adengine Service (Standalone): 		" + numAdEngineStandalongError + " errors" + eol);
        sb.append("Adengine Service (Service): 		" + numAdEngineServiceError + " errors" + eol);
        sb.append("Keyword Service (Standalone): 		" + numKeywordStandaloneError + " errors" + eol);
        sb.append("Keyword Service (Service): 		" + numKeywordServiceError + " errors" + eol);
        sb.append("Bidding Service (Standalone): 		" + numBiddingStandaloneError + " errors" + eol);
        sb.append("Bidding Service (Service):	 	" + numBiddingServiceError + " errors" + eol);
        
        return sb.toString();		
	}
	
	private void sendEmail(String subject, String from, String to, String msg)
	{
	      String host = "VMJAVA2";
	      Properties properties = System.getProperties();
	      properties.setProperty("mail.smtp.host", host);
	      Session session = Session.getDefaultInstance(properties);
	      try{
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	         message.setSubject(subject);
	         message.setText(msg);
	         
	         Transport.send(message);
	         
	      }catch (Exception e) {
	         e.printStackTrace();
	      }
	}

}
