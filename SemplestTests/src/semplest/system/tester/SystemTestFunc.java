package semplest.system.tester;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
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
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.BaseDB;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class SystemTestFunc extends BaseDB{	
	
	private static final String eol = System.getProperty("line.separator");
	
	public static void main(String[] args){		
		String tmp = "AddPromotionToAdEngine(SystemTestDataModel.semplestCustomerId, SystemTestDataModel.semplestProductGroupId, SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList)";
		PrintMethodCall(tmp);
	}
	
	public static void InitializeSystemTest() throws Exception{		
		setPropertiesFile(); //Set DB to the Test box
		
		System.out.println("====================================================================================");
		System.out.println(">>> Initialization >>>");
		System.out.println("====================================================================================");
		System.out.println();

		System.out.println("Loading configuration...");
		
		//Load the configuration
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}	
		
		PrintLineSeperator();
		System.out.println("Initializing the test data...");	
		System.out.println();
		
		//create a new promotion for the test
		String sql;
		
		SystemTestDataModel.semplestPromotionName = "AdEng_" + System.currentTimeMillis();
		sql = "INSERT INTO Promotion (ProductGroupFK,PromotionName,PromotionDescription,PromotionStartDate,PromotionEndDate," +
				"LandingPageURL,DisplayURL,PromotionBudgetAmount,BudgetCycleFK,CycleStartDate,CycleEndDate,StartBudgetInCycle,RemainingBudgetInCycle,BudgetToAddToNextCycle," +
				"IsPaused,IsCompleted,IsLaunched,CreatedDate,IsDeleted)" +
				"VALUES (?, ?, '" + SystemTestDataModel.promotionDescription + "', CURRENT_TIMESTAMP, '2020-01-01', " +
				"'http://www.semplest.com', 'www.semplest.com',100.00, 3, CURRENT_TIMESTAMP, '2020-01-01', 100.00, 100.00, 100.00, " +
				"0, 0, 1, CURRENT_TIMESTAMP, 0)";
		jdbcTemplate.update(sql, new Object[]
				{SystemTestDataModel.semplestProductGroupId, SystemTestDataModel.semplestPromotionName});
		
		sql = "SELECT p.PromotionPK FROM Promotion p WHERE PromotionName = ?";
		SystemTestDataModel.semplestPromotionId = jdbcTemplate.queryForInt(sql, new Object[]
				{SystemTestDataModel.semplestPromotionName});			
		
		//Create promotion data on the related tables
		//ADs			
		for(SystemTestDataModel.AD ad : SystemTestDataModel.promotionAds){
			sql = "INSERT INTO PromotionAds(PromotionFK,AdTitle,AdTextLine1,AdTextLine2,IsDeleted,CreatedDate) " +
					"VALUES(?, ?, ?, ?, 0 , CURRENT_TIMESTAMP)";
			jdbcTemplate.update(sql, new Object[]
					{SystemTestDataModel.semplestPromotionId, ad.adTitle, ad.adTextLine1, ad.adTextLine2});	
		}			
		sql = "SELECT pa.PromotionAdsPK FROM PromotionAds pa WHERE pa.PromotionFK = ?";
		SystemTestDataModel.promotionAdIds = jdbcTemplate.queryForList(sql, new Object[]
				{SystemTestDataModel.semplestPromotionId}, Integer.class);							
		
		//Keywords
		for(Integer kwId : SystemTestDataModel.keywordIds){
			sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
					"VALUES(?,?,CURRENT_TIMESTAMP,1,0,0,1,1,1)";
			
			jdbcTemplate.update(sql, new Object[]
					{kwId, SystemTestDataModel.semplestPromotionId});
		}		
		
		//Negative Keywords
		for(Integer kwId : SystemTestDataModel.negKeywordIds){
			sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
					"VALUES(?,?,CURRENT_TIMESTAMP,1,0,1,1,1,1)";
			
			jdbcTemplate.update(sql, new Object[]
					{kwId, SystemTestDataModel.semplestPromotionId});
		}		
		
		//GeoTargeting			
		sql = "INSERT INTO GeoTargeting (PromotionFK, Address,City,StateCodeFK,Zip,Longitude,Latitude,ProximityRadius) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[]
				{SystemTestDataModel.semplestPromotionId, SystemTestDataModel.address, SystemTestDataModel.city, SystemTestDataModel.stateCode, SystemTestDataModel.zipCode, SystemTestDataModel.longitude, SystemTestDataModel.latitude, SystemTestDataModel.radius});
		
		//SiteLinks
		for(SystemTestDataModel.SiteLink sl : SystemTestDataModel.sitelinks){
			sql = "INSERT INTO SiteLinks(PromotionFK,LinkText,LinkURL) " +
					"VALUES(?,?,?)";
			jdbcTemplate.update(sql, new Object[]
					{SystemTestDataModel.semplestPromotionId, sl.linkText, sl.linkUrl});
		}		
				
		System.out.println(" - Created Promotion " + SystemTestDataModel.semplestPromotionId + " for the system test.");
		System.out.println(" - Test Data that will be used in this test: " + SystemTestDataModel.printTestData());
		
		System.out.println();
		System.out.println("End of initialization.");
		System.out.println();
	}
	
	public static void CleanUpTestData() throws Exception{
		System.out.println("====================================================================================");
		System.out.println(">>> Clean Up Test Data >>>");
		System.out.println("====================================================================================");
		System.out.println();
		
		GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
		MsnCloudServiceImpl msn = new MsnCloudServiceImpl();	
		String sql;		
		
		System.out.println("Clearing history test data...");
		
		System.out.println(" - Delete history test data from database.");
		
		//Clear the scheduler data
		System.out.println("  -- clear scheduler data");		
		
		sql = "select s.SchedulePK from Schedule s where s.PromotionFK = ?";
		List<Integer> scheduleIDs = jdbcTemplate.queryForList(sql, new Object[] 
				{SystemTestDataModel.semplestPromotionId}, Integer.class);
		
		List<Integer> scheduleJobIDs = new ArrayList<Integer>();
		for(Integer schedulePK : scheduleIDs){
			sql = "select sj.ScheduleJobPK from ScheduleJob sj where ScheduleFK = ?";
			List<Integer> ret = jdbcTemplate.queryForList(sql, new Object[] 
					{schedulePK}, Integer.class);
			scheduleJobIDs.addAll(ret);
		}
		
		List<Integer> taskIDs = new ArrayList<Integer>();
		for(Integer schedulePK : scheduleIDs){
			sql = "select sta.TaskFK from ScheduleTaskAssociation sta where sta.ScheduleFK = ?";
			List<Integer> ret = jdbcTemplate.queryForList(sql, new Object[] 
					{schedulePK}, Integer.class);
			taskIDs.addAll(ret);
		}
		
		for(Integer scheduleJobID : scheduleJobIDs){
			sql = "delete from ScheduleLog where ScheduleJobFK = ?";
			jdbcTemplate.update(sql, new Object[] 
					{scheduleJobID});
			System.out.println("  	> deleted ScheduleLogs for ScheduleJobID " + scheduleJobID);	
		}
		System.out.println("  	>>");	
		for(Integer scheduleID : scheduleIDs){
			sql = "delete from ScheduleJob where ScheduleFK = ?";
			jdbcTemplate.update(sql, new Object[] 
					{scheduleID});
			System.out.println("  	> deleted ScheduleJobs for ScheduleID " + scheduleID);	
		}
		System.out.println("  	>>");	
		for(Integer scheduleID : scheduleIDs){
			sql = "delete from ScheduleTaskAssociation where ScheduleFK = ?";
			jdbcTemplate.update(sql, new Object[] 
					{scheduleID});
			System.out.println("  	> deleted ScheduleTaskAssociations for ScheduleID " + scheduleID);	
		}
		System.out.println("  	>>");
		sql = "delete from Schedule where PromotionFK = ?";
		jdbcTemplate.update(sql, new Object[] 
				{SystemTestDataModel.semplestPromotionId});
		System.out.println("  	> deleted Schedules for PromotionID " + SystemTestDataModel.semplestPromotionId);
		System.out.println("  	>>");
		for(Integer taskID : taskIDs){
			sql = "delete from Task where TaskPK = ?";
			jdbcTemplate.update(sql, new Object[] 
					{taskID});
			System.out.println("  	> deleted Tasks for TaskID " + taskID);	
		}
		
		//clear other data
		System.out.println("  -- clear other data");
		sql= "DELETE from KeywordBidData;" +
				"DELETE FROM TargetedDailyBudget;" +
				"DELETE FROM AdvertisingEngineAds;";			
		jdbcTemplate.update(sql);						
		
		//get the list of promotion IDs
		sql = "SELECT p.PromotionPK FROM Promotion p WHERE ProductGroupFK = ?";
		List<Integer> promoIds = jdbcTemplate.queryForList(sql, new Object[]
				{SystemTestDataModel.semplestProductGroupId}, Integer.class);
				//{testData.productGroupIds.get(1)}, Integer.class);
		
		System.out.println("  -- delete promotion data.");
		for(Integer promoId : promoIds){				
			sql = "DELETE FROM AdvertisingEnginePromotion where PromotionFK = ?;" +
					"DELETE PromotionAds WHERE PromotionFK = ?;" +
					"DELETE FROM KeywordBid WHERE PromotionFK = ?;" +
					"DELETE PromotionKeywordAssociation WHERE PromotionFK = ?;" +
					"DELETE FROM KeywordCategory WHERE PromotionFK = ?;" +
					"DELETE GeoTargeting WHERE PromotionFK = ?;" +
					"DELETE SiteLinks WHERE PromotionFK = ?;" +
					"DELETE FROM PromotionAdEngineSelected WHERE PromotionFK = ?;" +
					"DELETE Promotion WHERE PromotionPK = ?;";
			
			jdbcTemplate.update(sql, new Object[]
					{promoId,promoId,promoId,promoId,promoId,promoId,promoId,promoId,promoId});						
			
			System.out.println("     - promotion " + promoId + " deleted");
		}			
		
		System.out.println(" - Delete history test data from google.");
		//clear Test Data on google	
		ArrayList<HashMap<String, String>> googleCampaigns = google.getCampaignsByAccountId(SystemTestDataModel.googleAccountId.toString(), false);
		for(HashMap<String, String> map : googleCampaigns){
			google.deleteCampaign(SystemTestDataModel.googleAccountId.toString(), Long.valueOf(map.get("Id")));
			System.out.println("  -- deleted campaign " + map.get("Id"));
			Thread.sleep(500);
		}	
		
		System.out.println(" - Delete history test data from msn.");
		//clear Test Data on google	
		com.microsoft.adcenter.v8.Campaign[] msnCampaigns = msn.getCampaignsByAccountId(SystemTestDataModel.msnAccountId);
		for(com.microsoft.adcenter.v8.Campaign cpn : msnCampaigns){
			msn.deleteCampaignById(SystemTestDataModel.msnAccountId, cpn.getId());
			System.out.println("  -- deleted campaign " + cpn.getId());
			Thread.sleep(500);
		}	
		
		System.out.println("History test data cleaned up.");
	}
	
	public static void ErrorHandler(Exception e){
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
	
	public static void ErrorHandler(String verifFailedMsg){
		System.out.println("/////////////////////////////////////////////////////");
		System.out.println("Verification FAILED! - " + verifFailedMsg);		
		System.out.println("/////////////////////////////////////////////////////");
		SystemTestDataModel.errorCounter++;
	}

	public static void PrintServiceHeader(String serviceName){
		System.out.println("====================================================================================");
		System.out.println(">>> Start to run " + serviceName + " Service Test >>>");
		System.out.println("====================================================================================");
		System.out.println();
	}
	
	public static void PrintServiceFooter(String serviceName, int numError){
		String result = numError > 0 ? "FAILED" : "PASSED";	
		System.out.println("------------------------------------------------------------");
		System.out.println();
		System.out.println("!!! Test of " + serviceName + " Service - " + result);
		System.out.println();
	}
	
	public static void PrintLineSeperator(){
		System.out.println("------------------------------------------------------------");
	}

	public static void PrintMethodCall(String methodCall){		
		try{
			String methodName;
			String[] parameters;
			
			String[] step1 = methodCall.split("\\(");
			methodName = step1[0].trim();
			String step2 = step1[1].split("\\)")[0];
			parameters = step2.split(",");				
			
			System.out.print("=> Run Method: ");
			System.out.print(methodName + "(");		
			int i = 0;
			for(String par : parameters){
				i++;
				par.trim();
				String[] field = par.split("\\.");
				if(field.length > 1){
					System.out.print(SystemTestDataModel.class.getField(field[1]).get(field[1]));
				}
				else{
					System.out.print(field[0]);
				}				
				if(i < parameters.length){
					System.out.print(",");
				}
			}
			System.out.print(")");
			System.out.println();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void InitializeReport(){
		try{
			InetAddress ownIP = InetAddress.getLocalHost();
			String hudsonServerIP = "172.18.9.5";
			
			DateFormat dateFormat = new SimpleDateFormat("_MM-dd-yy_HHmm");
			Date date = new Date();
			String now = dateFormat.format(date);
			SystemTestDataModel.reportName = "UnitTestReport" + now + ".txt";
			
			String reportDir;
			if(ownIP.getHostAddress().equalsIgnoreCase(hudsonServerIP)){
				reportDir = "/semplest/TestReports/UnitTest/";
			}
			else{
				reportDir = "Z:\\TestReports\\UnitTest\\";
			}
			String reportPath = reportDir + SystemTestDataModel.reportName;
			
			//Create Report Header						
			PrintStream out = new PrintStream(new FileOutputStream(reportPath));
			System.setOut(out);
			
			System.out.println("************************************************************************************");
			System.out.println("*                        SEMplest System Unit Test Report                          *");
			System.out.println("************************************************************************************");
			System.out.println("Created Time: " + date);
			System.out.println("   ");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void FinalizeReport(){
		//Generate Report and Email the Report		
		
		int numAllErrs = SystemTestDataModel.adEngineErrors 
				+ SystemTestDataModel.biddingErrors 
				+ SystemTestDataModel.keywordErrors 
				+ SystemTestDataModel.mailErrors;		
		
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
		
		//send email of the test result
		String testResult = (numAllErrs > 0)? "FAILED!" : "PASSED!";
		reportSummary = reportSummary + eol + eol + eol + "The completed report is at: \\semplest\\TestReports\\UnitTest\\" + SystemTestDataModel.reportName;
		String subject = "[System Test] System Unit Test is " + testResult;		
		sendEmail(subject, "devuser@semplest.com", "development@semplest.com", reportSummary);
		
	}
	
	//Helper Methods
	private static void setPropertiesFile() throws Exception{
		final String PROPSFILE = "system.properties";
		String jdbc = "jdbc:jtds:sqlserver://172.18.9.35/semplestTest";		
		
		InputStream in = SystemTestFunc.class.getClassLoader().getResourceAsStream(PROPSFILE);
		Properties props = new Properties();
		props.load(in);			
		StringBuilder sb = new StringBuilder();			
		
		sb.append("semplest.service" + " = " + props.getProperty("semplest.service") + eol);
		sb.append("YAJSW.servicename" + " = " + props.getProperty("YAJSW.servicename") + eol); 
		sb.append("jdbc.driverClassName" + " = " + props.getProperty("jdbc.driverClassName") + eol);
		sb.append("jdbc.url" + " = " + jdbc + eol);
		sb.append("jdbc.username" + " = " + props.getProperty("jdbc.username") + eol);
		sb.append("jdbc.password" + " = " + props.getProperty("jdbc.password") + eol);		
		
		props.clear();
		props.store(new FileOutputStream(sb.toString()), "Properties for System Test");
				
		in.close();	
	}

	private static void sendEmail(String subject, String from, String to, String msg)
	{		
		String host = "smtp.gmail.com";
	    String username = "devuser@semplest.com";
	    String password = "devuser2012";
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
