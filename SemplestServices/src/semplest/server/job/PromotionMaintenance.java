package semplest.server.job;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.PromotionBudget;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.RunMode;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailClient;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;
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
		final GetAllPromotionDataSP getPromotionSP = new GetAllPromotionDataSP();
		final Map<Integer, String> errorMap = new HashMap<Integer, String>();
		final List<Integer> promotionsProcessed = new ArrayList<Integer>();
		for (final PromotionBudget budget : budgets)
		{			
			try
			{
				final Double amountToRefill = budget.getBudgetCarryOverAmount();
				//final Double spendIncurredThisMonth = getMonthlySpend(...);
				
				final Double spendIncurredThisMonth = 5.2;
				
				
				final Integer promotionId = budget.getPromotionFK();
				final Boolean result = getPromotionSP.execute(promotionId);
				final PromotionObj promotion = getPromotionSP.getPromotionData();
				final Double remainingBudget = promotion.getRemainingBudgetInCycle();
				final Double carryOverAmount = amountToRefill - spendIncurredThisMonth;			
				final java.util.Date cycleStartDate = promotion.getCycleStartDate();
				final Calendar cal = Calendar.getInstance();
				cal.setTime(cycleStartDate);
				cal.add(Calendar.MONTH, 1);
				final java.util.Date newCycleStartDate = cal.getTime();
				final java.util.Date cycleEndDate = promotion.getCycleEndDate();
				final Calendar c = Calendar.getInstance();
				c.setTime(cycleEndDate);
				c.add(Calendar.MONTH, 1);
				final java.util.Date newCycleEndDate = c.getTime();
				final Double newRemainingBudget = remainingBudget + amountToRefill;
				SemplestDB.applyPromotionBudget(promotionId, newCycleStartDate, newCycleEndDate, newRemainingBudget);
				promotionsProcessed.add(promotionId);
			}
			catch (Exception e)
			{				
				final Integer promotionId = budget.getPromotionFK();
				final String errMsg = "Problem applying new budget for PromotionID [" + promotionId + "] by processing Budget [" + budget + "]: " + e.getMessage();
				log.error(errMsg, e);
				errorMap.put(promotionId, errMsg);
			}
		}
		log.info("Summary:\n\nPromotions successfully processed:\n" + SemplestUtils.getEasilyReadableString(promotionsProcessed) + "\n\nPromotions with problems:\n" + SemplestUtils.getEasilyReadableString(errorMap));
	}
	
	// TODO: see if you need StartBudgetInCycle column, if not then delete it

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
