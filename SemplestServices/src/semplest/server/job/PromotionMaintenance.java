package semplest.server.job;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.PromotionBudget;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.RunMode;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailClient;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class PromotionMaintenance
{
	private static final Logger log = Logger.getLogger(PromotionMaintenance.class);
	
	/*
	 * Apply budget to promotion
	 * 1) update cycle dates
	 * 2) refill budget
	 * 3) setup next budget for invoice transactions
	 */
	public void engage(final java.util.Date asOfDate)
	{
		log.info("Will try to do Promotion Maintenance for As-Of-Date [" + asOfDate + "]");		
		final List<PromotionBudget> budgets = SemplestDB.getPromotionBudgetsForMaintenance(asOfDate);
		log.info(budgets.size() + " budgets that require maintenance:\n" + SemplestUtils.getEasilyReadableString(budgets));
		for (final PromotionBudget budget : budgets)
		{
			final Double carryOverAmount = budget.getBudgetCarryOverAmount();
			
/*
 * what's the difference between carryOverAmount and BudgetToAddAmount?
 * instead of TransactionsFK, shouldn't the transactions be pointing to PromotionBudget instead?
 * where would one-time transactions (i.e. fees) be pointed to?  It should point to the PromotionBudget, right?
 */
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
			log.info("Starting Promotion Maintenance process");
			PropertyConfigurator.configure("C:/SemplestAdengineService/properties/log4j_server.properties");
			BasicConfigurator.configure();	
			new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			final SemplestConfiguration configDB = new SemplestConfiguration(object);
			final Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			final PromotionMaintenance promotionMaintenance = new PromotionMaintenance();
			final java.util.Date asOfDate = new java.util.Date();
			promotionMaintenance.engage(asOfDate);
		}
		catch (final Throwable t)
		{
			final String errMsg = "Error during Promotion Maintenance";
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
