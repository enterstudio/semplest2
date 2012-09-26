package semplest.system.tester;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.google.GoogleSiteLink;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.BaseDB;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class SystemTestFunc extends BaseDB
{

	// private static final String reportDir = "/semplest/Test_Report/System_Test_Report/";
	private static String reportDir;

	private static final String eol = System.getProperty("line.separator");

	public static void main(String[] args)
	{
		String tmp = "AddPromotionToAdEngine(SystemTestDataModel.semplestCustomerId, SystemTestDataModel.semplestProductGroupId, SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList)";
		PrintMethodCall(tmp);
	}

	public static void LoadConfiguration() throws Exception
	{

		System.out.println("====================================================================================");
		System.out.println(">>> Load Configuration >>>");
		System.out.println("====================================================================================");
		System.out.println();

		System.out.println("Loading configuration...");

		// Load the configuration
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
	}

	public static void BuildTestData()
	{

		System.out.println("====================================================================================");
		System.out.println(">>> Initialize Test Data >>>");
		System.out.println("====================================================================================");
		System.out.println();

		// create a new promotion for the test
		String sql;

		SystemTestDataModel.semplestPromotionName = "AdEng_" + System.currentTimeMillis();
		sql = "INSERT INTO Promotion (ProductGroupFK,PromotionName,PromotionDescription,PromotionStartDate,PromotionEndDate," + "LandingPageURL,DisplayURL,PromotionBudgetAmount,BudgetCycleFK,CycleStartDate,CycleEndDate,StartBudgetInCycle,RemainingBudgetInCycle,"
				+ "IsPaused,IsCompleted,IsLaunched,CreatedDate,IsDeleted)" + "VALUES (?, ?, '" + SystemTestDataModel.promotionDescription + "', CURRENT_TIMESTAMP, '2020-01-01', " + "'http://www.semplest.com', 'www.semplest.com',100.00, 3, CURRENT_TIMESTAMP, '2020-01-01', 100.00, 100.00, "
				+ "0, 0, 1, CURRENT_TIMESTAMP, 0)";
		jdbcTemplate.update(sql, new Object[] { SystemTestDataModel.semplestProductGroupId, SystemTestDataModel.semplestPromotionName });

		sql = "SELECT p.PromotionPK FROM Promotion p WHERE PromotionName = ?";
		SystemTestDataModel.semplestPromotionId = jdbcTemplate.queryForInt(sql, new Object[] { SystemTestDataModel.semplestPromotionName });

		// Create promotion data on the related tables
		// ADs
		for (SystemTestDataModel.AD ad : SystemTestDataModel.promotionAds)
		{
			sql = "INSERT INTO PromotionAds(PromotionFK,AdTitle,AdTextLine1,AdTextLine2,IsDeleted,CreatedDate) " + "VALUES(?, ?, ?, ?, 0 , CURRENT_TIMESTAMP)";
			jdbcTemplate.update(sql, new Object[] { SystemTestDataModel.semplestPromotionId, ad.adTitle, ad.adTextLine1, ad.adTextLine2 });
		}
		sql = "SELECT pa.PromotionAdsPK FROM PromotionAds pa WHERE pa.PromotionFK = ?";
		SystemTestDataModel.promotionAdIds = jdbcTemplate.queryForList(sql, new Object[] { SystemTestDataModel.semplestPromotionId }, Integer.class);

		// Keywords
		for (Integer kwId : SystemTestDataModel.keywordIds)
		{
			sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" + "VALUES(?,?,CURRENT_TIMESTAMP,1,0,0,1,1,1)";

			jdbcTemplate.update(sql, new Object[] { kwId, SystemTestDataModel.semplestPromotionId });
		}

		// Negative Keywords
		for (Integer kwId : SystemTestDataModel.negKeywordIds)
		{
			sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" + "VALUES(?,?,CURRENT_TIMESTAMP,1,0,1,1,1,1)";

			jdbcTemplate.update(sql, new Object[] { kwId, SystemTestDataModel.semplestPromotionId });
		}

		// GeoTargeting
		sql = "INSERT INTO GeoTargeting (PromotionFK, Address,City,StateCodeFK,Zip,Longitude,Latitude,ProximityRadius) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { SystemTestDataModel.semplestPromotionId, SystemTestDataModel.address, SystemTestDataModel.city, SystemTestDataModel.stateCode, SystemTestDataModel.zipCode, SystemTestDataModel.longitude, SystemTestDataModel.latitude, SystemTestDataModel.radius });

		// SiteLinks
		for (GoogleSiteLink sl : SystemTestDataModel.sitelinks)
		{
			sql = "INSERT INTO SiteLinks(PromotionFK,LinkText,LinkURL) " + "VALUES(?,?,?)";
			jdbcTemplate.update(sql, new Object[] { SystemTestDataModel.semplestPromotionId, sl.getLinkText(), sl.getLinkURL() });
		}

		System.out.println(" - Created Promotion " + SystemTestDataModel.semplestPromotionId + " for the system test.");
		System.out.println(" - Test Data that will be used in this test: " + SystemTestDataModel.printTestData());

		System.out.println();
		System.out.println("End of initialization.");
		System.out.println();
	}

	public static void CleanUpTestData() throws Exception
	{
		System.out.println("====================================================================================");
		System.out.println(">>> Clean Up History Test Data >>>");
		System.out.println("====================================================================================");
		System.out.println();

		GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
		MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
		String sql;

		System.out.println("Clearing history test data...");

		System.out.println(" - Delete history test data from database.");		
		
		// get the list of promotion IDs
		sql = "SELECT p.PromotionPK FROM Promotion p WHERE ProductGroupFK = ?";
		List<Integer> promoIds = jdbcTemplate.queryForList(sql, new Object[] { SystemTestDataModel.semplestProductGroupId }, Integer.class);
		// {testData.productGroupIds.get(1)}, Integer.class);

		for (Integer promoId : promoIds)
		{
			System.out.println("  - deleting promotion " + promoId);

			// Clear scheduler data
			System.out.println("    -- deleting scheduler data");

			sql = "select s.SchedulePK from Schedule s where s.PromotionFK = ?";
			List<Integer> scheduleIDs = jdbcTemplate.queryForList(sql, new Object[] { promoId }, Integer.class);

			List<Integer> scheduleJobIDs = new ArrayList<Integer>();
			for (Integer schedulePK : scheduleIDs)
			{
				sql = "select sj.ScheduleJobPK from ScheduleJob sj where ScheduleFK = ?";
				List<Integer> ret = jdbcTemplate.queryForList(sql, new Object[] { schedulePK }, Integer.class);
				scheduleJobIDs.addAll(ret);
			}

			List<Integer> taskIDs = new ArrayList<Integer>();
			for (Integer schedulePK : scheduleIDs)
			{
				sql = "select sta.TaskFK from ScheduleTaskAssociation sta where sta.ScheduleFK = ?";
				List<Integer> ret = jdbcTemplate.queryForList(sql, new Object[] { schedulePK }, Integer.class);
				taskIDs.addAll(ret);
			}

			for (Integer scheduleJobID : scheduleJobIDs)
			{
				sql = "delete from ScheduleLog where ScheduleJobFK = ?";
				jdbcTemplate.update(sql, new Object[] { scheduleJobID });
				System.out.println("  	> deleted ScheduleLogs for ScheduleJobID " + scheduleJobID);
			}
			System.out.println("  	>>");
			for (Integer scheduleID : scheduleIDs)
			{
				sql = "delete from ScheduleJob where ScheduleFK = ?";
				jdbcTemplate.update(sql, new Object[] { scheduleID });
				System.out.println("  	> deleted ScheduleJobs for ScheduleID " + scheduleID);
			}
			System.out.println("  	>>");
			for (Integer scheduleID : scheduleIDs)
			{
				sql = "delete from ScheduleTaskAssociation where ScheduleFK = ?";
				jdbcTemplate.update(sql, new Object[] { scheduleID });
				System.out.println("  	> deleted ScheduleTaskAssociations for ScheduleID " + scheduleID);
			}
			System.out.println("  	>>");
			sql = "delete from Schedule where PromotionFK = ?";
			jdbcTemplate.update(sql, new Object[] { promoId });
			System.out.println("  	> deleted Schedules for PromotionID " + promoId);
			System.out.println("  	>>");
			for (Integer taskID : taskIDs)
			{
				sql = "delete from Task where TaskPK = ?";
				jdbcTemplate.update(sql, new Object[] { taskID });
				System.out.println("  	> deleted Tasks for TaskID " + taskID);
			}

			// Clear promotion data
			System.out.println("    -- deleting promotion data");

			sql = "SELECT pa.PromotionAdsPK FROM PromotionAds pa WHERE pa.PromotionFK = ?";
			List<Integer> adIds = jdbcTemplate.queryForList(sql, new Object[] { promoId }, Integer.class);
			for (Integer adId : adIds)
			{
				sql = "DELETE FROM AdvertisingEngineAds WHERE PromotionAdsFK = ?";
				jdbcTemplate.update(sql, new Object[] { adId });
				System.out.println("  	> deleted AdvertisingEngineAds for PromotionAdsID " + adId);
			}
			System.out.println("  	>>");

			sql = "SELECT kb.KeywordBidPK FROM KeywordBid kb WHERE kb.PromotionFK = ?";
			List<Integer> kbIds = jdbcTemplate.queryForList(sql, new Object[] { promoId }, Integer.class);
			for (Integer kbId : kbIds)
			{
				sql = "DELETE FROM TrafficEstimator WHERE KeywordBidFK = ?; " + "DELETE FROM KeywordBidData WHERE KeywordBidFK = ?;";
				jdbcTemplate.update(sql, new Object[] { kbId, kbId });
				System.out.println("  	> deleted TrafficEstimator for KeywordBidID " + kbId);
				System.out.println("  	> deleted KeywordBidData for KeywordBidID " + kbId);
			}
			System.out.println("  	>>");

			sql = "DELETE FROM AdvertisingEnginePromotion where PromotionFK = ?;" + 
					"DELETE FROM PromotionAds WHERE PromotionFK = ?;" + 
					"DELETE FROM KeywordBid WHERE PromotionFK = ?;" + 
					"DELETE FROM PromotionKeywordAssociation WHERE PromotionFK = ?;" + 
					"DELETE FROM KeywordCategory WHERE PromotionFK = ?;" + 
					"DELETE FROM GeoTargeting WHERE PromotionFK = ?;" + 
					"DELETE FROM SiteLinks WHERE PromotionFK = ?;" + 
					"DELETE FROM PromotionAdEngineSelected WHERE PromotionFK = ?;" + 
					"DELETE FROM PromotionAdengineStatus WHERE PromotionFK = ?;" + 
					"DELETE FROM PromotionBidding WHERE PromotionFK = ?;" + 
					"DELETE FROM TargetedDailyBudget WHERE PromotionFK = ?;" + 
					"DELETE FROM PromotionBudget WHERE PromotionFK = ?;" + 
					"DELETE FROM Promotion WHERE PromotionPK = ?;";

			jdbcTemplate.update(sql, new Object[] { promoId, promoId, promoId, promoId, promoId, promoId, promoId, promoId, promoId, promoId, promoId, promoId, promoId});

			System.out.println("  	> deleted all the other data for PromotionID " + promoId);
		}

		System.out.println(" - Delete history test data from google.");
		// clear Test Data on google
		ArrayList<HashMap<String, String>> googleCampaigns = google.getCampaignsByAccountId(SystemTestDataModel.googleAccountId.toString(), false);
		for (HashMap<String, String> map : googleCampaigns)
		{
			google.deleteCampaign(SystemTestDataModel.googleAccountId.toString(), Long.valueOf(map.get("Id")));
			System.out.println("  -- deleted campaign " + map.get("Id"));
			Thread.sleep(500);
		}

		System.out.println(" - Delete history test data from msn.");
		// clear Test Data on google
		com.microsoft.adcenter.v8.Campaign[] msnCampaigns = msn.getCampaignsByAccountId(SystemTestDataModel.msnAccountId);
		for (com.microsoft.adcenter.v8.Campaign cpn : msnCampaigns)
		{
			msn.deleteCampaignById(SystemTestDataModel.msnAccountId, cpn.getId());
			System.out.println("  -- deleted campaign " + cpn.getId());
			Thread.sleep(500);
		}

		System.out.println("History test data cleaned up.");
	}

	public static void ErrorHandler(Exception e)
	{
		Writer error = new StringWriter();
		PrintWriter printWriter = new PrintWriter(error);
		e.printStackTrace(printWriter);
		e.printStackTrace();
		System.out.println("/////////////////////////////////////////////////////");
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		System.out.println();
		System.out.println(error.toString());
		System.out.println("/////////////////////////////////////////////////////");
		SystemTestDataModel.errorCounter++;
	}

	public static void ErrorHandler(String verifFailedMsg)
	{
		System.out.println("/////////////////////////////////////////////////////");
		System.out.println("Verification FAILED! - " + verifFailedMsg);
		System.out.println("/////////////////////////////////////////////////////");
		SystemTestDataModel.errorCounter++;
	}

	public static void PrintServiceHeader(String serviceName)
	{
		System.out.println("====================================================================================");
		System.out.println(">>> Start to run " + serviceName + " Service Test >>>");
		System.out.println("====================================================================================");
		System.out.println();
	}

	public static void PrintServiceFooter(String serviceName, int numError)
	{
		String result = numError > 0 ? "FAILED" : "PASSED";
		System.out.println("------------------------------------------------------------");
		System.out.println();
		System.out.println("!!! Test of " + serviceName + " Service - " + result);
		System.out.println();
	}

	public static void PrintLineSeperator()
	{
		System.out.println("------------------------------------------------------------");
	}

	public static void PrintMethodCall(String methodCall)
	{
		try
		{
			String methodName;
			String[] parameters;

			String[] step1 = methodCall.split("\\(");
			methodName = step1[0].trim();
			String step2 = step1[1].split("\\)")[0];
			parameters = step2.split(",");

			System.out.print("=> Run Method: ");
			System.out.print(methodName + "(");
			int i = 0;
			for (String par : parameters)
			{
				i++;
				par.trim();
				String[] field = par.split("\\.");
				if (field.length > 1)
				{
					System.out.print(SystemTestDataModel.class.getField(field[1]).get(field[1]));
				}
				else
				{
					System.out.print(field[0]);
				}
				if (i < parameters.length)
				{
					System.out.print(",");
				}
			}
			System.out.print(")");
			System.out.println();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void InitializeReport(String reportPath)
	{
		try
		{
			reportDir = reportPath;
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy_HH-mm");
			Date date = new Date();
			String now = dateFormat.format(date);
			SystemTestDataModel.reportName = "SystemTestReport_" + now + ".txt";
			String reportFullPath = reportDir + SystemTestDataModel.reportName;

			// Create Report Header
			PrintStream out = new PrintStream(new FileOutputStream(reportFullPath));
			System.setOut(out);

			System.out.println("************************************************************************************");
			System.out.println("*                        SEMplest System Unit Test Report                          *");
			System.out.println("************************************************************************************");
			System.out.println("Created Time: " + date);
			System.out.println("   ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void FinalizeReport()
	{
		// Generate Report and Email the Report

		int numAllErrs = SystemTestDataModel.adEngineErrors + SystemTestDataModel.biddingErrors + SystemTestDataModel.keywordErrors + SystemTestDataModel.mailErrors;

		StringBuilder sb = new StringBuilder();
		sb.append("System Test finished with " + numAllErrs + " errors in total." + eol);
		sb.append(eol);
		sb.append("Number of Errors: " + eol);
		sb.append("AdEngine Service - " + SystemTestDataModel.adEngineErrors + eol);
		sb.append("Bidding Service - " + SystemTestDataModel.biddingErrors + eol);
		sb.append("Keyword Service - " + SystemTestDataModel.keywordErrors + eol);
		sb.append("Mail Service - " + SystemTestDataModel.mailErrors + eol);
		sb.append(eol);
		sb.append("Test Data that has been used in this test: ");
		sb.append(eol);
		sb.append(SystemTestDataModel.printTestData());
		String reportSummary = sb.toString();

		System.out.println(" ");
		System.out.println("************************************************************************************");
		System.out.println("*                               SYSTEM TEST SUMMARY                                *");
		System.out.println("************************************************************************************");
		System.out.println(" ");
		System.out.println(reportSummary);

		// send email of the test result
		String testResult = (numAllErrs > 0) ? "FAILED!" : "PASSED!";
		reportSummary = reportSummary + eol + eol + eol + "The completed report is at: " + reportDir + SystemTestDataModel.reportName;
		String subject = "[System Test] System Unit Test is " + testResult;
		sendEmail(subject, "devuser@semplest.com", "development@semplest.com", reportSummary);

	}

	private static void sendEmail(String subject, String from, String to, String msg)
	{
		final String username = "devuser@semplest.com";
		final String password = "SEMplest2012";

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username, password);
			}
		});

		try
		{

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(msg);

			Transport.send(message);

		}
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}
	}
}
