package semplest.server.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.encryption.AESBouncyCastle;
import semplest.server.protocol.Credential;
import semplest.server.protocol.CustomerHierarchy;
import semplest.server.protocol.CustomerType;
import semplest.server.protocol.EmailTemplate;
import semplest.server.protocol.EmailType;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.RunMode;
import semplest.server.protocol.User;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailClient;
import semplest.server.service.springjdbc.CustomerObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class AccountActivationEmailSender
{
	private static final Logger log = Logger.getLogger(AccountActivationEmailSender.class);
	
	private final String defaultEmailContactUsEmail;
	private final String esbWebServerURL;
	private final String reminderEmailUrlPrefix;
	private final RunMode runMode;
	private final AESBouncyCastle aes;
		
	public AccountActivationEmailSender(String defaultEmailContactUsEmail, String esbWebServerURL, String reminderEmailUrlPrefix, RunMode runMode, AESBouncyCastle aes)
	{
		this.defaultEmailContactUsEmail = defaultEmailContactUsEmail;
		this.esbWebServerURL = esbWebServerURL;
		this.reminderEmailUrlPrefix = reminderEmailUrlPrefix;
		this.runMode = runMode;
		this.aes = aes;
	}

	public static EmailType getEmailType(final CustomerType customerType) throws Exception
	{
		if (customerType == CustomerType.CHILD)
		{
			return EmailType.WELCOME_EMAIL_CHILD;
		}
		if (customerType == CustomerType.PARENT)
		{
			return EmailType.WELCOME_EMAIL_PARENT;
		}
		if (customerType == CustomerType.SINGLE_USER)
		{
			return EmailType.WELCOME_EMAIL_NON_PARENT_USER;
		}
		throw new Exception("CustomerType [" + customerType + "] not recognized as valid for sending Account Activation emails");
	}
	
	public String getRefinedEmailBody(final EmailTemplate emailTemplate, final User user) throws Exception
	{
		final EmailType emailType = emailTemplate.getEmailType();
		final String emailBody = emailTemplate.getEmailBody();
		if (emailType == EmailType.WELCOME_EMAIL_CHILD)
		{
			return getRefinedEmailBodyForWelcomeEmailChild(emailBody, user);
		}
		else if (emailType == EmailType.WELCOME_EMAIL_PARENT)
		{
			return getRefinedEmailBodyForWelcomeEmailParent(emailBody, user);
		}
		else if (emailType == EmailType.WELCOME_EMAIL_NON_PARENT_USER)
		{
			return getRefinedEmailBodyForWelcomeEmailNonParentUser(emailBody, user);
		}
		else
		{
			throw new Exception("Cannot generate the refined email body for User [" + user + "] and EmailTemplate [" + emailTemplate + "]because the EmailTemplate found for this user is not of applicable type [" + emailType + "] for sending account activation emails");
		}
	}
	
	public String getRefinedEmailBodyForWelcomeEmailNonParentUser(final String rawEmailBody, final User user) throws Exception
	{
		final Integer userID = user.getUserPk();
		final String firstName = user.getFirstName();
		final String lastName = user.getLastName();
		final String middleInitial = SemplestUtils.getTrimmedNonNullString(user.getMiddleInidial());
		final String fullName;
		if (middleInitial.equals(""))
		{
			fullName = firstName + " " + lastName;
		}
		else
		{
			fullName = firstName + " " + middleInitial + "." + lastName;
		}
		final Credential credential = SemplestDB.getCredential(userID);
		final String username = credential.getUsername();
		final String password = credential.getPassword();
		final java.util.Date now = new java.util.Date();
		final String link = SemplestUtils.generateEncryptedHtmlLink(aes, reminderEmailUrlPrefix, userID, now, username, password);	
		final String mailToLink = "<a href=\"mailto:" + defaultEmailContactUsEmail + "?subject=Please%20help%20me%20(User%20Name:%20" + username + ")\">" + defaultEmailContactUsEmail + "</a>";
		final String refinedEmailBody = rawEmailBody.replaceAll("\\[NonParentCustomer\\]", fullName)											
													.replaceAll("\\[INSERT LINK\\]", link)
													.replaceAll("\\[NonParentCustomerUserID\\]", username)
													.replaceAll("\\[NonParentCustomerPassword\\]", password)
													.replaceAll("\\[help@semplest.com\\]", mailToLink);
		return refinedEmailBody;
	}
	
	public String getRefinedEmailBodyForWelcomeEmailParent(final String rawEmailBody, final User user) throws Exception
	{
		final Integer userID = user.getUserPk();
		final String firstName = user.getFirstName();
		final String lastName = user.getLastName();
		final String middleInitial = SemplestUtils.getTrimmedNonNullString(user.getMiddleInidial());
		final String fullName;
		if (middleInitial.equals(""))
		{
			fullName = firstName + " " + lastName;
		}
		else
		{
			fullName = firstName + " " + middleInitial + "." + lastName;
		}
		final Credential credential = SemplestDB.getCredential(userID);
		final String username = credential.getUsername();
		final String password = credential.getPassword();
		final java.util.Date now = new java.util.Date();
		final Integer customerID = user.getCustomerFk();
		final CustomerObj customer = SemplestDB.getCustomer(customerID);
		if (customer == null)
		{
			throw new Exception("Could not refine the email body for account activation email for User [" + user + "] becuase could not find it's Customer info");
		}
		final String customerName = customer.getName();
		final String link = SemplestUtils.generateEncryptedHtmlLink(aes, reminderEmailUrlPrefix, userID, now, username, password);
		final String mailToLink = "<a href=\"mailto:" + defaultEmailContactUsEmail + "?subject=Please%20help%20me%20(User%20Name:%20" + username + ")\">" + defaultEmailContactUsEmail + "</a>";
		final String refinedEmailBody = rawEmailBody.replaceAll("\\[VendorName\\]", fullName)
													.replaceAll("\\[CustomerName\\]", "" + customerName)												
													.replaceAll("\\[INSERT LINK\\]", link)
													.replaceAll("\\[xxxxxx\\]", username)
													.replaceAll("\\[xxxxx\\]", password)
													.replaceAll("\\[help@semplest.com\\]", mailToLink);
		return refinedEmailBody;
	}
	
	public String getRefinedEmailBodyForWelcomeEmailChild(final String rawEmailBody, final User user) throws Exception
	{
		final Integer userID = user.getUserPk();
		final String firstName = user.getFirstName();
		final String lastName = user.getLastName();
		final String middleInitial = SemplestUtils.getTrimmedNonNullString(user.getMiddleInidial());
		final String fullName;
		if (middleInitial.equals(""))
		{
			fullName = firstName + " " + lastName;
		}
		else
		{
			fullName = firstName + " " + middleInitial + "." + lastName;
		}
		final Credential credential = SemplestDB.getCredential(userID);
		final String username = credential.getUsername();
		final String password = credential.getPassword();
		final java.util.Date now = new java.util.Date();
		final Integer customerID = user.getCustomerFk();
		final CustomerObj customer = SemplestDB.getCustomer(customerID);
		if (customer == null)
		{
			throw new Exception("Could not refine the email body for account activation email for User [" + user + "] becuase could not it's Customer info");
		}
		final String customerName = customer.getName();
		final String link = SemplestUtils.generateEncryptedHtmlLink(aes, reminderEmailUrlPrefix, userID, now, username, password);		
		final String refinedEmailBody = rawEmailBody.replaceAll("\\[VendorName\\]", fullName)
													.replaceAll("\\[CustomerName\\]", "" + customerName)												
													.replaceAll("\\[INSERT LINK\\]", link)
													.replaceAll("\\[xxxxxx\\]", username)
													.replaceAll("\\[xxxxx\\]", password);
		return refinedEmailBody;
	}
	
	public void sendAccountActivationEmail(final Integer userID) throws Exception
	{
		log.info("Will try to send account activation email for UserID [" + userID + "]");
		final User user = SemplestDB.getUser(userID);
		log.info("Found User data for UserID [" + userID + "]: " + user);
		final Integer customerID = user.getCustomerFk();
		final CustomerHierarchy hierarchy = SemplestDB.getCustomerHierarchy(customerID);
		log.info("Found this CustomerHierarchy for CustomerID [" + customerID + "]: " + hierarchy);
		final CustomerType customerType = SemplestUtils.getCustomerType(hierarchy);
		log.info("CustomerType [" + customerType + "]");
		final EmailType emailType = getEmailType(customerType);
		log.info("EmailType [" + emailType + "]");
		final List<EmailTemplate> emailTemplates = SemplestDB.getEmailTemplates(emailType);
		log.info("EmailTemplates:\n" + SemplestUtils.getEasilyReadableString(emailTemplates));
		final EmailTemplate emailTemplate = SemplestUtils.getEmailTemplateForUser(user, emailTemplates);
		log.info("Specific EmailTemplate:" + emailTemplate);
		final EmailTemplate userEmailTemplate = SemplestUtils.getEmailTemplateForUser(user, emailTemplates);		
		final String emailFrom = userEmailTemplate.getEmailFrom();
		final String emailTo = runMode == RunMode.PRODUCTION ? user.getEmail() : defaultEmailContactUsEmail;			
		final String emailSubject = (runMode == RunMode.PRODUCTION ? "" : runMode.getName() + " -- ") + userEmailTemplate.getEmailSubject();
		final String refinedEmailBody = getRefinedEmailBody(userEmailTemplate, user);
		log.info("Will send account activation email To [" + emailTo + "], From [" + emailFrom + "], Subject [" + emailSubject + "], Body [" + refinedEmailBody + "]");
		SemplestMailClient.sendMailFromService(esbWebServerURL, emailSubject, emailFrom, emailTo, refinedEmailBody, ProtocolEnum.EmailType.HTML.getEmailValue());
	}
	
	public static AccountActivationEmailSender getDefaultAccountActivationEmailSender() throws Exception
	{
		final String defaultEmailContactUsEmail = (String)SemplestConfiguration.configData.get("DefaultEmailContactUs");
		final String esbWebServerURL = getEsbWebServiceURL();
		final String reminderEmailUrlPrefix = (String) SemplestConfiguration.configData.get("ReminderEmailUrlPrefix");			
		final RunMode runMode = getRunMode();
		final String semplestEncryptionKey = (String) SemplestConfiguration.configData.get("SemplestEncryptionkey");
		final AESBouncyCastle aes = AESBouncyCastle.getInstance(semplestEncryptionKey);		
		final AccountActivationEmailSender emailSender = new AccountActivationEmailSender(defaultEmailContactUsEmail, esbWebServerURL, reminderEmailUrlPrefix, runMode, aes);
		return emailSender;
	}
	
	public static String getDevelopmentEmail()
	{
		return (String)SemplestConfiguration.configData.get("DevelopmentEmail");
	}
	
	public static String getEsbWebServiceURL()
	{
		return (String)SemplestConfiguration.configData.get("ESBWebServerURL");
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
	
	public static void main(final String[] args) throws Exception
	{
		try
		{
			log.info("Starting process for sending account activation email");
			log.info("Initializing");		
			new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			final AccountActivationEmailSender emailSender = getDefaultAccountActivationEmailSender();
			emailSender.sendAccountActivationEmail(24); // for testing only
		}
		catch (Throwable t)
		{
			final String errMsg = "Error sending account activation emails.";
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
