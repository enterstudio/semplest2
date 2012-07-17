package semplest.system.tester;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.BaseDB;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;

public class SetupTest extends BaseDB{
	
	public static void InitializeSystemTest() throws Exception{
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
		
		System.out.println("Initializing the test...");
		
		//create a new promotion for the test
		String sql;
		
		SystemTestDataModel.semplestPromotionName = "AdEng_" + System.currentTimeMillis();
		sql = "INSERT INTO Promotion (ProductGroupFK,PromotionName,PromotionDescription,PromotionStartDate,PromotionEndDate," +
				"LandingPageURL,DisplayURL,PromotionBudgetAmount,BudgetCycleFK,CycleStartDate,CycleEndDate,StartBudgetInCycle,RemainingBudgetInCycle,BudgetToAddToNextCycle," +
				"IsPaused,IsCompleted,IsLaunched,CreatedDate,IsDeleted)" +
				"VALUES (?, ?, '" + SystemTestDataModel.promotionDescription + "', CURRENT_TIMESTAMP, '2020-01-01', " +
				"'http://www.semplest.com', 'http://www.semplest.com',100.00, 3, CURRENT_TIMESTAMP, '2020-01-01', 100.00, 100.00, 100.00, " +
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
		
		System.out.println("End of initialization.");
	}
	
	public static void CleanUpTestData() throws Exception{
		GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
		MsnCloudServiceImpl msn = new MsnCloudServiceImpl();	
		String sql;
		
		System.out.println("Clearing history test data...");
		
		System.out.println(" - Delete history test data from database.");
		
		System.out.println("  -- clear scheduler data");
		//Clear the scheduler data
		sql = "delete from ScheduleLog; " +
				"delete from ScheduleJob; " +
				"delete from ScheduleTaskAssociation; " +
				"delete from Schedule; " +
				"delete from Task; ";
		jdbcTemplate.update(sql);
		
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
					"DELETE GeoTargeting WHERE PromotionFK = ?;" +
					"DELETE SiteLinks WHERE PromotionFK = ?;" +
					"DELETE Promotion WHERE PromotionPK = ?;";
			
			jdbcTemplate.update(sql, new Object[]
					{promoId,promoId,promoId,promoId,promoId,promoId,promoId});						
			
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

}
