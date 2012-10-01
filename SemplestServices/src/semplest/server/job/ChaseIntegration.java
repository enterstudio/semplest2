package semplest.server.job;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.CreditCardProfile;
import semplest.server.protocol.Job;
import semplest.server.protocol.JobName;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.RunMode;
import semplest.server.protocol.chaseorbitalgateway.ChaseFileTransaction;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailClient;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.service.filetransfer.SecureFTPUsingSSH;
import semplest.util.SemplestUtils;

public class ChaseIntegration
{
	private static final Logger log = Logger.getLogger(ChaseIntegration.class);
	
	private static final JobName JOB_NAME = JobName.CHASE_INTEGRATION;
		
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
	
	public static String getLocalDirectory()
	{
		return (String)SemplestConfiguration.configData.get("SemplestOrbitalLocalFileDir");
	}
	
	public static String getDevelopmentEmail()
	{
		return (String)SemplestConfiguration.configData.get("DevelopmentEmail");
	}
	
	public static String getEsbWebServiceURL()
	{
		return (String)SemplestConfiguration.configData.get("ESBWebServerURL");
	}
	
	public void engageBatch(final java.util.Date asOfDate) throws Exception
	{
		final Job job = SemplestDB.getJob(JOB_NAME);
		log.info("State of the job before running the current iteration: " + job);
		engage(asOfDate);
		SemplestDB.updateJobLastSuccessfulRunTime(JOB_NAME);
	}
	
	public static List<String> getFilesOfInterest(final List<String> files, final String chaseTransactionFileNamePrefix)
	{
		final List<String> filesOfInterest = new ArrayList<String>();
		for (final String file : files)
		{
			if (file != null && file.startsWith(chaseTransactionFileNamePrefix))
			{
				filesOfInterest.add(file);
			}
		}
		return filesOfInterest;
	}
	
	public static List<ChaseFileTransaction> extractChaseFileTransactions(final String localFile) throws Exception
	{
		log.info("Will extract Chase File Transactions from file [" + localFile + "]");
		final List<ChaseFileTransaction> chaseFileTransactions = new ArrayList<ChaseFileTransaction>();
		final Reader fileReader = new FileReader(localFile);
		final BufferedReader br = new BufferedReader(fileReader);
		String line;
		while ((line = br.readLine()) != null)
		{
			final boolean isPayload = isPayload(line);
			if (isPayload)
			{
				try
				{
					final ChaseFileTransaction chaseFileTransaction = getChaseFileTransaction(line);
					chaseFileTransactions.add(chaseFileTransaction);
				}
				catch (Exception e)
				{
					throw new Exception("Problem extracting the Chase File Transaction from file [" + localFile + "]", e);
				}
			}
		}
		return chaseFileTransactions;
	}
	
	public static ChaseFileTransaction getChaseFileTransaction(final String line) throws Exception
	{
		final String[] tokens = line.split(",");
		final String cardType = tokens[0];	
		final String cardNumber = tokens[1];	
		final String transactionType = tokens[2];
		final String amountString = tokens[3];
		final Number amountNumber = SemplestUtils.CURRENCY_FORMAT.parse(amountString);
		final double amountDouble = amountNumber.doubleValue();
		final BigDecimal amountBigDecimal = new BigDecimal(amountDouble);
		final String responseCode = tokens[4];
		final String dateTimeString = tokens[5];		
		final java.util.Date dateTime;
		try
		{
			dateTime = SemplestUtils.DATE_FORMAT_YYYYMMDD_space_HH_MM_SS.parse(dateTimeString);
		}
		catch (ParseException e1)
		{
			throw new Exception("Could not parse date from token [" + dateTimeString + "] within Chase file line [" + line + "]"); 
		}
		final String settlementDateTimeString = tokens[6];
		final java.util.Date settlementDateTime;
		try
		{
			settlementDateTime = SemplestUtils.DATE_FORMAT_YYYYMMDD_space_HH_MM_SS.parse(settlementDateTimeString);
		}
		catch (ParseException e)
		{
			throw new Exception("Could not parse date from token [" + settlementDateTimeString + "] within Chase file line [" + line + "]");
		}
		final String orderNum = tokens[7];
		final String orderDescription = tokens[8];
		final String batchId = tokens[9];
		final String entrySourceId = tokens[10];
		final String customerProfileNum = tokens[11];		
		final ChaseFileTransaction chaseFileTransaction = new ChaseFileTransaction(cardType, cardNumber, transactionType, amountBigDecimal, responseCode, dateTime, settlementDateTime, orderNum, orderDescription, batchId, entrySourceId, customerProfileNum);
		return chaseFileTransaction;
	}
	
	public static boolean isPayload(final String line)
	{
		if (line == null)
		{
			return false;
		}
		final String trimmedLine = line.trim();
		if (trimmedLine.isEmpty())
		{
			return false;
		}
		if (trimmedLine.startsWith(",,,,") || 
				trimmedLine.startsWith("CLOSED BATCH") ||
				trimmedLine.startsWith("Merchant ID") || 
				trimmedLine.startsWith("Currency") || 
				trimmedLine.startsWith("Report Generated") ||
				trimmedLine.startsWith("Card Type,Card Number"))				
		{
			return false;
		}
		final String[] tokens = trimmedLine.split(",");
		if (tokens.length != 12)
		{
			return false;	
		}
		return true;
	}
	
	public static void processChaseFile(final String file) throws Exception
	{
		final String operationDescription = "process file [" + file + "]"; 
		log.info("Will try to " + operationDescription);
		try 
		{
			final List<ChaseFileTransaction> chaseFileTransactions = extractChaseFileTransactions(file);
			log.info("Extracted " + chaseFileTransactions.size() + " Chase File Transactions");
			final List<ChaseFileTransaction> problemChaseFileTransactions = new ArrayList<ChaseFileTransaction>();
			log.info("Extracted " + chaseFileTransactions.size() + " Chase File Transactions from file [" + file + "]:\n" + SemplestUtils.getEasilyReadableString(chaseFileTransactions));
			for (final ChaseFileTransaction chaseFileTransaction : chaseFileTransactions)
			{
				final String responseCode = chaseFileTransaction.getResponseCode();
				if ("00".equals(responseCode))
				{
					problemChaseFileTransactions.add(chaseFileTransaction);
				}
				final String profileRefNum = chaseFileTransaction.getCustomerProfileNum();
				final CreditCardProfile creditCardProfile = SemplestDB.getCreditCardProfile(profileRefNum);
				final Integer creditCardProfileFK = creditCardProfile.getCreditCardProfilePk();
				final BigDecimal amount = chaseFileTransaction.getAmount();
				final java.util.Date createdDate = new java.util.Date();
				final java.util.Date editedDate = new java.util.Date();
				final String authCode = null;
				final String txRefNum = chaseFileTransaction.getOrderNum();
				SemplestDB.insertChaseFileTransaction(creditCardProfileFK, amount, createdDate, editedDate, authCode, txRefNum);
			}
		}
		catch (Exception e)
		{
			throw new Exception("Problem trying to " + operationDescription, e);
		}
	}
	
	public void engage(final java.util.Date asOfDate) throws Exception
	{
		final String operationDescription = "Chase Integration for As-Of-Date [" + asOfDate + "]";
		log.info("Will try to " + operationDescription);	
		final String chaseTransactionFileNamePrefix = getTransactionFileNamePrefix(asOfDate);
		log.info("Will look for file with prefix [" + chaseTransactionFileNamePrefix + "]");
		
		// TODO: when these properties are in db, change the hardcoded values to be read from db
		final SecureFTPUsingSSH ftps = new SecureFTPUsingSSH("orbitalbatchvar.paymentech.net", null,22);
		try
		{
			if (ftps.connectFTP("VNVRB7PP", "KWLT3LTB"))
			{
				//ftps.getFile("ClosedBatchSummaryRpt_211416_09242012_094834_155938_resp.csv.ASC", "c:/ClosedBatchSummaryRpt_211416_09242012_094834_155938_resp.csv.ASC", null);
				final String[] files = ftps.getFileList("/files");
				final List<String> fileList = Arrays.asList(files);
				log.info(fileList.size() + " files seen on Chase remote SFTP server:\n" + SemplestUtils.getEasilyReadableString(fileList));
				final List<String> filesOfInterest = getFilesOfInterest(fileList, chaseTransactionFileNamePrefix);
				log.info(filesOfInterest.size() + " files of interest because they start with prefix [" + chaseTransactionFileNamePrefix + "]:\n" + SemplestUtils.getEasilyReadableString(filesOfInterest));
				final String localDir = "C:/SemplestCommon/data/chase/"; // TODO: put this into SemplestConfiguration
				final List<String> localFiles = new ArrayList<String>();
				for (final String fileOfInterest : filesOfInterest)
				{
					final String localFile = localDir + fileOfInterest;
					final boolean isFtpTransmittionSuccessful = ftps.getFile(fileOfInterest, localFile, null);
					if (!isFtpTransmittionSuccessful)
					{
						throw new Exception("Problem downloaing from Chase SFTP site remote file [" + fileOfInterest + "] into local file [" + localFile + "]");
					}
					localFiles.add(localFile);
				}
				log.info(localFiles.size() + " local downloaded files to process:\n" + SemplestUtils.getEasilyReadableString(localFiles));
				
				final List<String> tempLocalFiles = Arrays.asList("C:\\SemplestCommon\\data\\chase\\5b6768e6-5fd2-4903-824c-9ae53dc0c9c1-09272012.csv");
				for (final String localFile : tempLocalFiles)
				{
					processChaseFile(localFile);
				}
			}
		}
		catch (Exception e)
		{
			throw new Exception("Problem doing " + operationDescription, e);
		}
		finally
		{
			try
			{
				ftps.disconnectFTP();
			}
			catch (IOException e)
			{
				log.warn("Problem disconnecting from SFTP.  Logging, but otherwise continuing.", e);
			}
		}
	}
	
	public static String getTransactionFileNamePrefix(final java.util.Date asOfDate)
	{
		final Calendar cal = Calendar.getInstance();
		cal.setTime(asOfDate);
		final int year = cal.get(Calendar.YEAR);
		final int month = cal.get(Calendar.MONTH) + 1;
		final int day = cal.get(Calendar.DAY_OF_MONTH);
		final String yearString = SemplestUtils.getNumberString(year, 4);
		final String monthString = SemplestUtils.getNumberString(month, 2);
		final String dayString = SemplestUtils.getNumberString(day, 2);
		final String fileNamePrefix = SemplestUtils.CHASE_DAILY_TRANSACTION_FILE_PREFIX + monthString + dayString + yearString + "_";
		return fileNamePrefix;
	}
	
	public static void main(final String[] args) throws Exception
	{
		try
		{			
			PropertyConfigurator.configure("properties/log4j_server.properties");
			BasicConfigurator.configure();
			log.info("Starting Chase Integration process");
			new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			final SemplestConfiguration configDB = new SemplestConfiguration(object);
			final Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			final ChaseIntegration chaseIntegration = new ChaseIntegration();
			
			//final java.util.Date asOfDate = new java.util.Date();
			final Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2012);
			cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
			cal.set(Calendar.DAY_OF_MONTH, 24);
			final java.util.Date asOfDate = cal.getTime();
			chaseIntegration.engageBatch(asOfDate);
		}
		catch (final Throwable t)
		{
			final String errMsg = "Error during Chase Integration";
			log.error(errMsg, t);	
			final RunMode runMode = getRunMode();
			final String subject = (runMode == RunMode.PRODUCTION ? "" : runMode.getName() + " -- ") + errMsg;			
			final String stackTrace = SemplestUtils.getStackTraceString(t);
			final String emailBody = subject + "\n\n" + stackTrace;
			try
			{
				final String esbWebServerURL = getEsbWebServiceURL();				
				final String developmentEmail = getDevelopmentEmail();
				SemplestMailClient.sendMailFromService(esbWebServerURL, subject, developmentEmail, developmentEmail, emailBody, ProtocolEnum.EmailType.PlanText.getEmailValue());
			}
			catch (Exception e2)
			{
				log.error("Problem sending email with subject [" + subject + "] and content [" + emailBody + "].  Logging, but otherwise continuing processing.", e2);
			}
			throw new Exception(errMsg, t);
		}
	}
}
