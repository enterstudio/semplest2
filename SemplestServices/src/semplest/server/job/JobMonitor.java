package semplest.server.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.RunMode;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailClient;
import semplest.util.SemplestUtils;

public class JobMonitor
{
	private static final Logger log = Logger.getLogger(JobMonitor.class);
	
	public JobMonitor() throws Exception
	{
		new ClassPathXmlApplicationContext("Service.xml");
		final Object object = new Object();
		final SemplestConfiguration configDB = new SemplestConfiguration(object);
		final Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
	}
	
	public void engage() throws Exception
	{
		final List<String> errorMessages = new ArrayList<String>();
		checkExpiredCredentialsEmailSender(errorMessages);
		checkCleaner(errorMessages);
		if (errorMessages.isEmpty())
		{
			log.info("All Jobs ran as expected");
		}
		else
		{
			final String errMsg = "NOT all Jobs ran as expected";
			final String emailBody = errMsg + "\n\n" + SemplestUtils.getEasilyReadableString(errorMessages);
			log.info(emailBody);
			sendEmailAlert(errMsg, emailBody, null);
		}
	}
	
	public void checkCleaner(List<String> errorMessages) throws Exception
	{
		final String status = Cleaner.lastRunAsExpected();
		if (status != null)
		{
			errorMessages.add(status + "\n");
		}
	}
	
	public void checkExpiredCredentialsEmailSender(List<String> errorMessages) throws Exception
	{
		final String status = ExpiredCredentialsEmailSender.lastRunAsExpected();
		if (status != null)
		{
			errorMessages.add(status + "\n");
		}
	}
	
	public static RunMode getRunMode() throws Exception
	{
		final String runModeString = (String) SemplestConfiguration.configData.get("RunMode");
		final RunMode runMode = RunMode.fromName(runModeString);
		if (runMode == null)
		{
			throw new Exception("RunMode [" + runModeString + "] not a valid RunMode.  Valid RunModes are [" + RunMode.getValidRunModes() + "]");
		}
		return runMode;
	}
	
	public static String getDevelopmentEmail()
	{
		return (String)SemplestConfiguration.configData.get("DevelopmentEmail");
	}
	
	public static String getEsbWebServiceURL()
	{
		return (String)SemplestConfiguration.configData.get("ESBWebServerURL");
	}
	
	public static void main(final String[] args) throws Exception
	{
		try
		{
			final JobMonitor jobMonitor = new JobMonitor();
			jobMonitor.engage();
		}
		catch (Throwable t)
		{
			final String errMsg = "Problem running the JobMonitor";
			log.error(errMsg, t);			
			throw new Exception(errMsg, t);
		}
	}
	
	public static void sendEmailAlert(final String subject, final String body, final Throwable t) throws Exception
	{
		final RunMode runMode = getRunMode();
		final String subjectLine = (runMode == RunMode.PRODUCTION ? "" : runMode.getName() + " -- ") + subject;
		final String emailBody;
		if (t == null)
		{
			emailBody = body;
		}
		else
		{
			final String stackTrace = SemplestUtils.getStackTraceString(t);
			emailBody = body + "\n\n" + stackTrace;
		}		
		try
		{
			final String esbWebServerURL = getEsbWebServiceURL();				
			final String developmentEmail = getDevelopmentEmail();
			SemplestMailClient.sendMailFromService(esbWebServerURL, subjectLine, developmentEmail, developmentEmail, emailBody, ProtocolEnum.EmailType.PlanText.getEmailValue());
		}
		catch (Exception e2)
		{
			log.error("Problem sending email with subject [" + subjectLine + "] and content [" + emailBody + "].  Logging, but otherwise continuing processing.", e2);
		}
	}
}
