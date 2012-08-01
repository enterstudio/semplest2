package semplest.server.job;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.encryption.AESBouncyCastle;
import semplest.server.protocol.Credential;
import semplest.server.protocol.EmailTemplate;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.RegistrationLinkDecryptedInfo;
import semplest.server.protocol.RunMode;
import semplest.server.protocol.User;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailClient;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class ExpiredCredentialsEmailSender
{
	private static final Logger log = Logger.getLogger(ExpiredCredentialsEmailSender.class);
	
	private final String defaultEmailContactUsEmail;
	private final String esbWebServerURL;
	private final String reminderEmailUrlPrefix;
	private final RunMode runMode;
	private final AESBouncyCastle aes;
	private final java.util.Date asOfDate;
	private final Integer numDaysBack;
	private final Integer numDaysInLink;
	
	public ExpiredCredentialsEmailSender(final String defaultEmailContactUsEmail, 
			final String esbWebServerURL, 
			final String reminderEmailUrlPrefix, 
			final RunMode runMode, 
			final AESBouncyCastle aes,
			final java.util.Date asOfDate,
			final Integer numDaysBack,
			final Integer numDaysInLink) throws Exception
	{
		this.defaultEmailContactUsEmail = defaultEmailContactUsEmail;
		this.esbWebServerURL = esbWebServerURL;
		this.reminderEmailUrlPrefix = reminderEmailUrlPrefix;
		this.runMode = runMode;
		this.aes = aes;
		this.asOfDate = asOfDate;
		this.numDaysBack = numDaysBack;
		this.numDaysInLink = numDaysInLink;
	}

	public String getRefinedEmailBody(final String rawEmailBody, final User user, final Integer numDaysTillExpiration)
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
		final String link = SemplestUtils.generateEncryptedLink(aes, reminderEmailUrlPrefix, userID, now, username, password);		
		final String refinedEmailBody = rawEmailBody.replaceAll("\\[VendorName\\]", fullName)
													.replaceAll("\\[XX\\]", "" + numDaysTillExpiration)
													.replaceAll("\\[xxxxxx\\]", username)
													.replaceAll("\\[xxxxx\\]", password)
													.replaceAll("\\[SEMPLEST LINK\\]", link)
													.replaceAll("\\[help@semplest.com\\]", defaultEmailContactUsEmail);
		return refinedEmailBody;
	}
	
	public void engageForUser(final Integer userID) throws Exception
	{
		final User user = SemplestDB.getUserForRegistrationReminder(asOfDate, numDaysBack, userID);
		if (user == null)
		{
			throw new Exception("Cannot send reminder email for UserPK [" + userID + "], AsOfDate [" + asOfDate + "], DaysBack [" + numDaysBack + "] because cannot find that User in the database");
		}
		engage(Arrays.asList(user));
	}
	
	public void engage(final List<User> users) throws Exception
	{
		log.info("Will try to send registration reminder emails for Users [" + users + "] <== if null, then will be done for all eligible users");
		final List<EmailTemplate> emailTemplates = SemplestDB.getEmailTemplates(semplest.server.protocol.EmailType.EXPIRED_ACTIVATION_IDS);
		log.info("Email Templates that may potentially apply:\n" + SemplestUtils.getEasilyReadableString(emailTemplates));
		final java.util.Date now = new java.util.Date();
		final List<User> usersToWorkOn;
		if (users == null || users.isEmpty())
		{
			usersToWorkOn = SemplestDB.getUsersForRegistrationReminder(now, numDaysBack) ;
		}
		else
		{
			usersToWorkOn = users;
		}
		log.info("Users to whom to send reminder email:\n" + SemplestUtils.getEasilyReadableString(usersToWorkOn));
		for (final User user : usersToWorkOn)
		{
			final EmailTemplate userEmailTemplate = SemplestUtils.getEmailTemplateForUser(user, emailTemplates);
			final String emailFrom = userEmailTemplate.getEmailFrom();
			final String emailTo = runMode == RunMode.PRODUCTION ? user.getEmail() : defaultEmailContactUsEmail;			
			final String emailSubject = (runMode == RunMode.PRODUCTION ? "" : runMode.getName() + " -- ") + userEmailTemplate.getEmailSubject();
			final String rawEmailBody = userEmailTemplate.getEmailBody();
			final String refinedEmailBody = getRefinedEmailBody(rawEmailBody, user, numDaysInLink);
			log.info(refinedEmailBody);
			log.info("Will send reminder email To [" + emailTo + "], From [" + emailFrom + "], Subject [" + emailSubject + "], Body [" + refinedEmailBody + "]");
			SemplestMailClient.sendMailFromService(esbWebServerURL, emailSubject, emailFrom, emailTo, refinedEmailBody, ProtocolEnum.EmailType.HTML.getEmailValue());
			final Integer userID = user.getUserPk();
			SemplestDB.updateUserLastEmailReminderDate(userID, now);
		}
	}
		
	public static ExpiredCredentialsEmailSender getDefaultExpiredEmailSender() throws Exception
	{
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
		final AESBouncyCastle aes = SemplestUtils.getDefaultAESBouncyCastle(semplestEncryptionKey);
		final java.util.Date asOfDate = new java.util.Date();
		final Integer numDaysBack = (Integer) SemplestConfiguration.configData.get("RegistrationReminderEmailDaysBack");
		//final Integer numDaysBackLinkAdditionalDays = (Integer) SemplestConfiguration.configData.get("RegistrationReminderLinkAdditionalDays");
		//final Integer numDaysInLink = numDaysBack + numDaysBackLinkAdditionalDays;
		final ExpiredCredentialsEmailSender emailSender = new ExpiredCredentialsEmailSender(defaultEmailContactUsEmail, esbWebServerURL, reminderEmailUrlPrefix, runMode, aes, asOfDate, numDaysBack, numDaysBack);
		return emailSender;
	}
	
	public static void main(final String[] args) throws Exception
	{
		try
		{
			log.info("Starting process for sending reminder emails to customers who have not finished registering");
			PropertyConfigurator.configure("log4j_server.properties");
			//BasicConfigurator.configure();	
			final ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			final ExpiredCredentialsEmailSender emailSender = getDefaultExpiredEmailSender();
			emailSender.engage(null); // will do all eligible users
		}
		catch (Exception e)
		{
			final String errMsg = "Problem during execution";
			log.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}
}
