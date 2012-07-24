package semplest.server.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.encryption.AESBouncyCastle;
import semplest.server.protocol.Credential;
import semplest.server.protocol.EmailTemplate;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.RunMode;
import semplest.server.protocol.User;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailClient;
import semplest.server.service.springjdbc.CustomerObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class ExpiredEmailSender
{
	private static final Logger log = Logger.getLogger(ExpiredEmailSender.class);
	
	private final String defaultEmailContactUsEmail;
	private final String esbWebServerURL;
	private final String reminderEmailUrlPrefix;
	private final RunMode runMode;
	private final AESBouncyCastle aes;
	
	public ExpiredEmailSender(final String defaultEmailContactUsEmail, final String esbWebServerURL, final String reminderEmailUrlPrefix, final RunMode runMode, final AESBouncyCastle aes) throws Exception
	{
		this.defaultEmailContactUsEmail = defaultEmailContactUsEmail;
		this.esbWebServerURL = esbWebServerURL;
		this.reminderEmailUrlPrefix = reminderEmailUrlPrefix;
		this.runMode = runMode;
		this.aes = aes;
	}
	
	public static EmailTemplate getEmailTemplateForCustomer(final Integer customerID, final List<EmailTemplate> emailTemplates)
	{
		for (final EmailTemplate emailTemplate : emailTemplates)
		{
			final Integer emailTemplateaCustomerID = emailTemplate.getCustomerFK();
			if (emailTemplateaCustomerID != null && emailTemplateaCustomerID.equals(customerID))
			{
				return emailTemplate;
			}			
		}
		return null;
	}
	
	public static EmailTemplate getEmailTemplateForUser(final User user, final List<EmailTemplate> emailTemplates)
	{
		final Integer customerFK = user.getCustomerFk();
		final EmailTemplate emailTemplateForCustomer = getEmailTemplateForCustomer(customerFK, emailTemplates);
		if (emailTemplateForCustomer != null)
		{
			return emailTemplateForCustomer;
		}
		for (final EmailTemplate emailTemplate : emailTemplates)
		{
			final Integer emailTemplateCustomerID = emailTemplate.getCustomerFK();
			if (emailTemplateCustomerID == null)
			{
				return emailTemplate;
			}
		}
		return null;
	}
	
	public String generateExcryptedLink(final Integer userID, final java.util.Date dateTime, final String username, final String password)
	{
		final String encryptedToken = generateEncryptedToken(userID, dateTime, username, password);
		final String encryptedUrl = reminderEmailUrlPrefix + encryptedToken;
		return encryptedUrl;
	}
	
	public String generateEncryptedToken(final Integer userID, final java.util.Date dateTime, final String username, final String password)
	{
		final String unencryptedToken = getConcatenatedString(userID, dateTime, username, password);
		final String encryptedToken = aes.encrypt(unencryptedToken);
		return encryptedToken;
	}
			
	public static String getConcatenatedString(final Integer userID, final java.util.Date dateTime, final String username, final String password)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append(SemplestUtils.USER_ID).append(SemplestUtils.VALUE_DELIMITER).append(userID).append(SemplestUtils.TOKEN_DELIMITER);
		sb.append(SemplestUtils.DATE_TIME).append(SemplestUtils.VALUE_DELIMITER).append(dateTime).append(SemplestUtils.TOKEN_DELIMITER);
		sb.append(SemplestUtils.USER_NAME).append(SemplestUtils.VALUE_DELIMITER).append(username).append(SemplestUtils.TOKEN_DELIMITER);
		sb.append(SemplestUtils.PASSWORD).append(SemplestUtils.VALUE_DELIMITER).append(password).append(SemplestUtils.TOKEN_DELIMITER);
		return sb.toString();
	}
	
	public String getRefinedEmailBody(final String rawEmailBody, final User user, final Integer numDaysTillExpiration)
	{
		final Integer customerID = user.getCustomerFk();
		final CustomerObj customer = SemplestDB.getCustomer(customerID);
		final String vendorName = customer.getName();
		final Integer userID = user.getUserPk();
		final Credential credential = SemplestDB.getCredential(userID);
		final String username = credential.getUsername();
		final String password = credential.getPassword();
		final java.util.Date now = new java.util.Date();
		final String link = generateExcryptedLink(userID, now, username, password);		
		final String refinedEmailBody = rawEmailBody.replaceAll("VendorName", vendorName).replaceAll("XX", "" + numDaysTillExpiration).replaceAll("xxxxxx", username).replaceAll("xxxxx", password).replaceAll("SEMPLEST LINK", link).replaceAll("help@semplest.com", defaultEmailContactUsEmail).replaceAll("\\[", "").replaceAll("\\]", "");
		return refinedEmailBody;
	}
	
	public void engage() throws Exception
	{
		final List<EmailTemplate> emailTemplates = SemplestDB.getEmailTemplates(semplest.server.protocol.EmailType.EXPIRED_ACTIVATION_IDS);
		log.info("Email Templates that will be used:\n" + SemplestUtils.getEasilyReadableString(emailTemplates));
		final java.util.Date now = new java.util.Date();
		final List<User> users = SemplestDB.getUsersForRegistrationReminder(now, SemplestUtils.EMAIL_EXPIRED_REGISTRATION_REMINDER_DAYS_BACK);
		log.info("Users to whom to send reminder email:\n" + SemplestUtils.getEasilyReadableString(users));
		for (final User user : users)
		{
			final EmailTemplate userEmailTemplate = getEmailTemplateForUser(user, emailTemplates);
			final String emailFrom = userEmailTemplate.getEmailFrom();
			final String emailTo = runMode == RunMode.PRODUCTION ? user.getEmail() : defaultEmailContactUsEmail;			
			final String emailSubject = (runMode == RunMode.PRODUCTION ? "" : runMode.getName() + " -- ") + userEmailTemplate.getEmailSubject();
			final String rawEmailBody = userEmailTemplate.getEmailBody();
			final String refinedEmailBody = getRefinedEmailBody(rawEmailBody, user, SemplestUtils.NUM_DATS_TILL_REGISTRATION_LINK_EXPIRATION);
			log.info(refinedEmailBody);
			log.info("Will send reminder email To [" + emailTo + "], From [" + emailFrom + "], Subject [" + emailSubject + "], Body [" + refinedEmailBody + "]");
			SemplestMailClient.sendMailFromService(esbWebServerURL, emailSubject, emailFrom, emailTo, refinedEmailBody, ProtocolEnum.EmailType.HTML.getEmailValue());
			final Integer userID = user.getUserPk();
			SemplestDB.updateUserLastEmailReminderDate(userID, now);
		}
	}
	
	public static void main(final String[] args) throws Exception
	{
		try
		{
			log.info("Starting process for sending reminder emails to customers who have not finished registering and whose last registration reminder was at least 3 days ago");
			log.info("Initializing");		
			final ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			final String defaultEmailContactUsEmail = (String)SemplestConfiguration.configData.get("DefaultEmailContactUs");
			final String esbWebServerURL = (String) SemplestConfiguration.configData.get("ESBWebServerURL");
			final String reminderEmailUrlPrefix = (String) SemplestConfiguration.configData.get("ReminderEmailUrlPrefix");			
			final String runModeString = (String) SemplestConfiguration.configData.get("RunMode");
			final RunMode runMode = RunMode.fromName(runModeString);
			if (runMode == null)
			{
				throw new Exception("RunMode [" + runModeString + "] not a valid RunMode.  Valid RunModes are [" + RunMode.getValidRunModes() + "]");
			}
			final String semplestEncryptionKey = (String) SemplestConfiguration.configData.get("SemplestEncryptionkey");
			final AESBouncyCastle aes = AESBouncyCastle.getInstance(semplestEncryptionKey);			
			final ExpiredEmailSender emailSender = new ExpiredEmailSender(defaultEmailContactUsEmail, esbWebServerURL, reminderEmailUrlPrefix, runMode, aes);
			emailSender.engage();
		}
		catch (Exception e)
		{
			final String errMsg = "Problem during execution";
			log.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}
}
