package semplest.test.unittest;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.BasicConfigurator;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.PromotionBiddingType;
import semplest.server.protocol.ProtocolEnum.SemplestCompetitionType;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.SemplestBiddingHistory;
import semplest.server.protocol.adengine.TargetedDailyBudget;
import semplest.server.protocol.adengine.TrafficEstimatorDataObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.service.springjdbc.AdvertisingEnginePromotionObj;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.CustomerObj;
import semplest.server.service.springjdbc.DefaultBidObject;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.TransactionManager;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;
import semplest.server.service.springjdbc.storedproc.GetKeywordForAdEngineSP;
import semplest.server.service.springjdbc.storedproc.UpdateRemainingBudgetInCycleSP;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.google.adwords.GoogleReportDownloader;

import com.google.api.adwords.lib.AuthToken;
import com.google.api.adwords.v201109.cm.KeywordMatchType;

public class DatabaseTest extends BaseDB{	
	public static String eol = System.getProperty("line.separator");
	
	private ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	private SemplestDB db = new SemplestDB();
	
	private int errorCounter = 0;
	
	private Integer customerID = 48;
	//private Integer promotionID = 71;
	private int promotionID;
	private Long test_accountId;
	private Long test_campaignId;
	
	private AdEngine adEngine = AdEngine.Google;
	private Long google_accountId = 5058200123L;
	private Long google_campaignId = 116193337L;
	private int adEnginePK = 2;
	
	private String vmsg = "Verification FAILED! ";
		
	public static void main(String[] args){
		DatabaseTest test = new DatabaseTest();
		
		//test.Test_ALL();
		//test.Test_ReportData();				
		//test.Test_TrafficEstimatorData();						
		//test.Test_DefaultBid();		
		//test.Test_KeywordDataObject();		
		//test.Test_BidObject();	
		//test.Test_TargetedDailyBudget();		
		//test.Test_PromotionData();
		test.Test_Other();
		
		System.out.println("*** DONE ***");
	}	
	
	public int Test_ALL(){
		try{
			errorCounter = 0;		
			test_accountId = System.currentTimeMillis();
			test_campaignId = test_accountId + 1;
			
			/*
			//Create Test Promotion
			try{
				int ProductGroupFK = 81;
				String PromotionName = "Database Test";
				String PromotionDescription = "should be deleted after the test";
				Date PromotionStartDate = new Date();
				String LandingPageURL = "www.semplest.com";
				Double PromotionBudgetAmount = 700.00;
				int BudgetCycleFK = 3;
				Double StartBudgetInCycle = 500.00;
				Date CreatedDate = new Date();
				String sql = "INSERT Promotion(ProductGroupFK, PromotionName, PromotionDescription, PromotionStartDate, LandingPageURL, " +
						"PromotionBudgetAmount, BudgetCycleFK, StartBudgetInCycle, CreatedDate) " +
						"VALUES(?,?,?,?,?,?,?,?,?)";
				jdbcTemplate.update(sql, new Object[]
						{ProductGroupFK, PromotionName, PromotionDescription, PromotionStartDate, 
						LandingPageURL, PromotionBudgetAmount, BudgetCycleFK, StartBudgetInCycle, CreatedDate});
				sql = "SELECT p.PromotionPK from Promotion p WHERE p.PromotionName = ? and p.CreatedDate = ?";
				int vret = jdbcTemplate.queryForInt(sql, PromotionName, CreatedDate);
				promotionID = vret;
				System.out.println("Created test promotion. PromotionPK = " + vret);
				System.out.println(" ");
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(new Exception("Failed to create a test promotion. Exit the test now." + eol + e.getMessage()));
				return 1;
			}
			*/
			
			/*
			Test_PromotionData();		
			Test_DefaultBid();
			Test_KeywordDataObject();		
			Test_BidObject();	
			Test_TargetedDailyBudget();
			Test_TrafficEstimatorData();	
			Test_ReportData();	
			Test_Other();
			*/
			
			ArrayList<KeywordDataObject> kdo = new ArrayList<KeywordDataObject>();
			KeywordDataObject k = new KeywordDataObject();
			k.setKeyword("test");
			kdo.add(k);
			
			try {
				db.storeKeywordDataObjects(promotionID, AdEngine.Google, kdo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				errorHandler(e);
			}
			
			return errorCounter;
		}
		finally{
			
		}
	}
	
	public void Test_ReportData(){		
			
		/* ******************************************************************************************* */
		//*** store report data to the AdvertisingEngineReportData table			
		//store_ReportData(1);
		
		/* ******************************************************************************************* */
		//*** get report data from the database			
		get_ReportData();		
		
	}
	
	public void store_ReportData(int caseNum){
		try{
			ReportObject[] report = null;
			ReportObject[] dup = null;
			switch(caseNum){
				case 1: {//real data
					//get report (of ALL_TIME) from google
					report = getReportFromGoogle();	
					db.storeAdvertisingEngineReportData(promotionID, AdEngine.Google, report);
					break;
				}
				case 2:{//duplicated both keywords and transaction date
					//choose entry #400 to be duplicated
					String keyword = "lake tahoe outdoor wedding venues";
					Date transactionDate = new Date();
					
					report = new ReportObject[1];
					report[0] = new ReportObject();
					report[0].setApprovalStatus("approved");
					report[0].setAverageCPC(2000000L);
					report[0].setAveragePosition(0.8F);
					report[0].setBidMatchType(MatchType.Exact.toString());
					report[0].setCampaignID(5058200123L);
					report[0].setCreatedDate(new Date());
					report[0].setFirstPageCPC(1000000L);
					report[0].setKeyword(keyword);
					report[0].setMicroBidAmount(10000000L);
					report[0].setMicroCost(1000000L);
					report[0].setNumberClick(1000);
					report[0].setNumberImpressions(1100);
					report[0].setQualityScore(5);
					report[0].setTransactionDate(transactionDate);	
					
					dup = new ReportObject[1];
					dup[0] = new ReportObject();
					dup[0].setApprovalStatus(" --");
					dup[0].setAverageCPC(1000000L);
					dup[0].setAveragePosition(0.8F);
					dup[0].setBidMatchType(MatchType.Exact.toString());
					dup[0].setCampaignID(5058200123L);
					dup[0].setCreatedDate(new Date());
					dup[0].setFirstPageCPC(2000000L);
					dup[0].setKeyword(keyword);
					dup[0].setMicroBidAmount(20000000L);
					dup[0].setMicroCost(2000000L);
					dup[0].setNumberClick(2000);
					dup[0].setNumberImpressions(2100);
					dup[0].setQualityScore(6);
					dup[0].setTransactionDate(transactionDate);
					
					db.storeAdvertisingEngineReportData(promotionID, AdEngine.Google, report);
					db.storeAdvertisingEngineReportData(promotionID, AdEngine.Google, dup);
					break;
				}
				default: report = null;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void get_ReportData(){
		try{
			//get report data from database
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -365);
			List<ReportObject> ret = db.getReportData(promotionID, AdEngine.Google, cal.getTime(), null);
			int c = 0;
			for(ReportObject r: ret){
				System.out.println("#"+c+" ---------------------------------------");										
				System.out.println("AccountID = " + r.getAccountID());
				System.out.println("keyword = " + r.getKeyword());
				System.out.println("ApprovalStatus = " + r.getApprovalStatus());		
				System.out.println("BidMatchType = " + r.getBidMatchType());
				System.out.println("AverageCPC = " + r.getAverageCPC());
				System.out.println("AveragePosition = " + r.getAveragePosition());
				System.out.println("CampaignID = " + r.getCampaignID());
				System.out.println("FirstPageCPC = " + r.getFirstPageCPC());
				System.out.println("MicroBidAmount = " + r.getMicroBidAmount());
				System.out.println("MicroCost = " + r.getMicroCost());
				System.out.println("NumberClick = " + r.getNumberClick());
				System.out.println("NumberImpressions = " + r.getNumberImpressions());
				System.out.println("QualityScore = " + r.getQualityScore());
				System.out.println("CreatedDate = " + r.getCreatedDate());
				System.out.println("TransactionDate = " + r.getTransactionDate());
				c++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void Test_TrafficEstimatorData(){
		
		/* ******************************************************************************************* */
		//*** test store proc of traffic estimator data to the TrafficEstimator table		
		//store_TrafficEstimatorData();
		
		/* ******************************************************************************************* */
		//*** test get traffic estimator data from the database		
		//get_TrafficEstimatorData(1);
		get_TrafficEstimatorData(2);
		
	}
	
	public void store_TrafficEstimatorData(){
		try{
			//get TrafficEstimate data from google
			GoogleAdwordsServiceImpl test = new GoogleAdwordsServiceImpl();
			
			HashMap<String, Long> KeywordWithBid = new HashMap<String, Long>();
			KeywordWithBid.put("civil wedding ceremony venues", 100000L);
			KeywordWithBid.put("personal wedding sites", 100000L);
			KeywordWithBid.put("small wedding venues", 100000L);
			
			String test_accountId = google_accountId.toString();
			Long test_campaignId = google_campaignId;
			TrafficEstimatorObject ret = test.getTrafficEstimationForKeywords(test_accountId,test_campaignId, KeywordMatchType.EXACT, KeywordWithBid);
			
			//store data to the database
			db.storeTrafficEstimatorData(promotionID, AdEngine.Google, ret);
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void get_TrafficEstimatorData(int caseNum){
		try {
			switch(caseNum){
				case 1:{//getLatestTrafficEstimatorForKeyword()				
					String keyword = "civil wedding ceremony venues";
					List<TrafficEstimatorDataObject> ret = db.getLatestTrafficEstimatorForKeyword(promotionID, keyword, AdEngine.Google);
					System.out.println("keyword = " + keyword);
					int c = 0;
					for(TrafficEstimatorDataObject t : ret){
						System.out.println("#"+c+" ---------------------------------------");
						System.out.println("MicroBid = " + t.getMicroBid());
						System.out.println("AveMicroCost = " + t.getAveMicroCost());
						System.out.println("AveNumberClicks = " + t.getAveNumberClicks());
						System.out.println("AvePosition = " + t.getAvePosition());				
						System.out.println("AveCPC = " + t.getAveCPC());				
						System.out.println("CreatedDate = " + t.getCreatedDate());				
						c++;
					}
					break;
				}
				case 2:{//getLatestTrafficEstimator()
					List<TrafficEstimatorDataObject> ret = db.getLatestTrafficEstimator(promotionID, adEngine);					
					int c = 0;
					for(TrafficEstimatorDataObject t : ret){
						System.out.println("#"+c+" ---------------------------------------");
						System.out.println("Keyword = " + t.getKeyword());
						System.out.println("MicroBid = " + t.getMicroBid());
						System.out.println("AveMicroCost = " + t.getAveMicroCost());
						System.out.println("AveNumberClicks = " + t.getAveNumberClicks());
						System.out.println("AvePosition = " + t.getAvePosition());				
						System.out.println("AveCPC = " + t.getAveCPC());				
						System.out.println("CreatedDate = " + t.getCreatedDate());				
						c++;
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void Test_DefaultBid(){
		
		try {
			/* ******************************************************************************************* */
			//*** store default bid to the AdvertisingEnginePromotion table
			//db.storeDefaultBid(promotionPK, AdEngine.Google.name(), 2000000L);
			
			/* ******************************************************************************************* */
			//*** update defalt bid amount to the keywords that are set to accept default bid value to the KeywordBid table
			//db.UpdateDefaultBidForKeywords(promotionPK, AdEngine.Google.name());
			
			/* ******************************************************************************************* */
			//*** get default bid amount from the AdvertisingEnginePromotion table
			DefaultBidObject ret = db.getDefaultBid(promotionID, AdEngine.Google);
			System.out.println("DefaultBid = " + ret);
			
		} catch (Exception e) {
			e.printStackTrace();
			errorHandler(e);
		}		
	}
	
	public void Test_KeywordDataObject(){
		try{
			/* ******************************************************************************************* */
			//*** store KeywordDataObject to the KeywordBid table
			//store_KeywordDataObject();
			
			
			/* ******************************************************************************************* */
			//*** get Latest Biddable AdGroup Criteria from the database
			get_KeywordDataObject(1);			
			//get_KeywordDataObject(2);
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void store_KeywordDataObject(){
		try{
			//*** test for Existed KeywordBid			
			ArrayList<KeywordDataObject> kdo1 = genKeywordDataObj(MatchType.Exact.getValue());
			db.storeKeywordDataObjects(promotionID, AdEngine.Google, kdo1);			
			
			//*** test for New Bid on Keyword			
			ArrayList<KeywordDataObject> kdo2 = genKeywordDataObj(MatchType.Broad.getValue());
			db.storeKeywordDataObjects(promotionID, AdEngine.Google, kdo2);
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}

	public void get_KeywordDataObject(int caseNum){
		try{			
			switch(caseNum){
				case 1:{
					//*** get Latest Biddable AdGroup Criteria from the database
					List<KeywordDataObject> ret = db.getLatestBiddableAdGroupCriteria(promotionID, AdEngine.Google);
					int i = 0;
					System.out.println("num of KeywordDataObject=" + ret.size());
					for(KeywordDataObject kd : ret){
						System.out.println("#"+i+"----------------------------");
						System.out.println("keyword = " + kd.getKeyword());
						System.out.println("keywordId = " + kd.getBidID());
						System.out.println("matchType = " + kd.getMatchType());
						System.out.println("microBidAmount = " + kd.getMicroBidAmount());
						System.out.println("approvalStatus = " + kd.getApprovalStatus());
						System.out.println("qualityScore = " + kd.getQualityScore());
						System.out.println("firstPageCpc = " + kd.getFirstPageCpc());
						System.out.println("createdDate = " + kd.getCreatedDate());
						i++;
					}
					break;
				}
				case 2:{
					//*** get ALL Biddable AdGroup Criteria from the database
					HashMap<String, ArrayList<KeywordDataObject>> rets = db.getAllBiddableAdGroupCriteria(promotionID, AdEngine.Google, new Date(2011, 1, 1), null);
					Set<String> ks = rets.keySet();
					int i = 0;
					for(String k : ks){
						System.out.println("#"+i+" = "+k+" ----------------------------");
						ArrayList<KeywordDataObject> kds = rets.get(k);
						int j = 0;
						for(KeywordDataObject kd : kds){
							System.out.println("->"+j);
							System.out.println("keyword = " + kd.getKeyword());
							System.out.println("keywordId = " + kd.getBidID());
							System.out.println("matchType = " + kd.getMatchType());
							System.out.println("microBidAmount = " + kd.getMicroBidAmount());
							System.out.println("approvalStatus = " + kd.getApprovalStatus());
							System.out.println("qualityScore = " + kd.getQualityScore());
							System.out.println("firstPageCpc = " + kd.getFirstPageCpc());
							System.out.println("createdDate = " + kd.getCreatedDate());
							j++;
						}
						i++;
					}
					break;
				}
			}			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void Test_BidObject(){
		try{
			/* ******************************************************************************************* */
			//*** store bid object to KeywordBid table
			//store_BidObject();
			
			/* ******************************************************************************************* */
			//*** get bid objects from the database
			//get_BidObject(1);  //get latest bids
			get_BidObject(2);  //get all bids
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void store_BidObject(){
		try{
			//*** test for Existed KeywordBid			
			ArrayList<BidElement> bo1 = genBidElements(MatchType.Broad.getValue(), false);
			db.storeBidObjects(promotionID, adEngine, bo1);
			
			//*** test for New Bid on Keyword		
			ArrayList<BidElement> bo2 = genBidElements(MatchType.Phrase.getValue(), false);
			db.storeBidObjects(promotionID, adEngine, bo2);
			
			//*** test for IsNegative keywords
			ArrayList<BidElement> bo3 = genBidElements(MatchType.Exact.getValue(), true);
			db.storeBidObjects(promotionID, adEngine, bo3);
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void get_BidObject(int caseNum){
		try{	
			switch(caseNum){
				case 1:{
					//*** get Latest Bids from the database
					List<BidElement> bids = db.getLatestBids(promotionID, AdEngine.Google);
					int i = 0;
					for(BidElement be : bids){
						System.out.println("#"+i+"----------------------------");
						System.out.println("keyword = " + be.getKeyword());
						System.out.println("matchType = " + be.getMatchType());
						System.out.println("microBidAmount = " + be.getMicroBidAmount());	
						i++;
					}
					break;
				}
				case 2:{
					//*** get ALL Bids from the database
					Calendar cal = Calendar.getInstance();
					cal.set(2011, 1, 1); Date start = cal.getTime();
					cal.set(2012, 5, 15); Date end = cal.getTime();
					HashMap<String, ArrayList<BidElement>> rets = db.getAllBids(promotionID, adEngine, start, end);
					Set<String> ks = rets.keySet();
					int i = 0;
					for(String k : ks){
						System.out.println("#"+i+" = "+k+" ----------------------------");
						ArrayList<BidElement> bids = rets.get(k);
						int j = 0;
						for(BidElement be : bids){
							System.out.println("->"+j);
							System.out.println("keyword = " + be.getKeyword());
							System.out.println("matchType = " + be.getMatchType());
							System.out.println("microBidAmount = " + be.getMicroBidAmount());			
							System.out.println("startDate = " + be.getStartDate());
							System.out.println("endDate = " + be.getEndDate());
							j++;
						}
						i++;
					}
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void Test_TargetedDailyBudget(){
		try {
			/* ******************************************************************************************* */
			//*** store Targeted Daily Budget to TargetedDailyBudget table
			//store_TargetedDailyBudget();
			
			/* ******************************************************************************************* */
			//*** get Targeted Daily Budget from TargetedDailyBudget table
			//get_TargetedDailyBudget(1);  //get LATEST TargetedDailyBudget
			//get_TargetedDailyBudget(2);  //get ALL TargetedDailyBudget
			
		} catch (Exception e) {
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void store_TargetedDailyBudget(){		
		try {
			Long targetedDailyMicroBudget = 70000L;
			Integer targetedDailyClicks = 300;
			db.storeTargetedDailyBudget(promotionID, adEngine, targetedDailyMicroBudget, targetedDailyClicks);
		} catch (Exception e) {
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	public void get_TargetedDailyBudget(int caseNum){
		try{
			switch(caseNum){
				case 1:{ //getLatestTargetedDailyBudget
					TargetedDailyBudget ret = db.getLatestTargetedDailyBudget(promotionID, adEngine);
					System.out.println("TargetedDailyMicroBudget = " + ret.getTargetedDailyMicroBudget());
					System.out.println("TargetedDailyClicks = " + ret.getTargetedDailyClicks());
					break;
				}
				case 2:{//getAllTargetedDailyBudget
					Calendar cal = Calendar.getInstance(); cal.set(2011, 1, 1);					
					Date startDate = cal.getTime();
					List<TargetedDailyBudget> ret = db.getAllTargetedDailyBudget(promotionID, adEngine, startDate, null);
					int i = 0;
					for(TargetedDailyBudget t : ret){
						System.out.println("#"+i+"----------------------------");
						System.out.println("TargetedDailyMicroBudget = " + t.getTargetedDailyMicroBudget());
						System.out.println("TargetedDailyClicks = " + t.getTargetedDailyClicks());
						i++;
					}
					break;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}

	public void Test_PromotionData(){
		try{
			
			try{
				//*** add AdEngine AccountID to AdvertisingEngineAccount table
				System.out.println("------------------------------------------------------------");
				System.out.println("addAdEngineAccountID:");
				
				//db.addAdEngineAccountID(customerID, google_accountId, adEngine);
				db.addAdEngineAccountID(customerID, "account_number", test_accountId, adEngine);
				System.out.println("OK");
				
				//--- verification
				String sql = "select aea.AdvertisingEngineAccountPK from AdvertisingEngineAccount aea where aea.CustomerFK = ? and aea.AdvertisingEngineAccountPK = ? and aea.AdvertisingEngineFK = ?";
				int vret = jdbcTemplate.queryForInt(sql, customerID, test_accountId, adEnginePK);
				if(vret != test_accountId.intValue())
					errorHandler(new Exception(vmsg + "AccountID is not added to the AdvertisingEngineAccount table."));
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			try{
				//*** add Promotion To AdvertisingEnginePromotion table
				System.out.println("------------------------------------------------------------");
				System.out.println("addPromotionToAdEngineAccountID:");
				
				Long advertisingEngineAdGroupID = 1234567L;
				Double advertisingEngineBudget = 10.00;
				Double currentDailyBudget = 1.00;
				db.addPromotionToAdEngineAccountID(promotionID, test_accountId, test_campaignId, advertisingEngineAdGroupID, advertisingEngineBudget, currentDailyBudget);
				System.out.println("OK");
				
				//--- verification
				String sql = "SELECT aep.AdvertisingEngineCampaignPK FROM AdvertisingEnginePromotion aep WHERE aep.PromotionFK = ? and aep.AdvertisingEngineAccountFK = ?";
				int vret = jdbcTemplate.queryForInt(sql, promotionID, test_accountId);
				if(vret != test_campaignId.intValue()){
					errorHandler(new Exception(vmsg + "Promotion is not added to the AdvertisingEnginePromotion table."));
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			try{
				//*** get AdEngine ID from the database
				System.out.println("------------------------------------------------------------");
				System.out.println("getAdEngineID:");
				
				AdEngineID adEngineId = db.getAdEngineID(promotionID, adEngine);
				System.out.println("OK");
				
				//--- verification
				System.out.println("AccountID = " + adEngineId.getAccountID()); System.out.println("CampaignID = " + adEngineId.getCampaignID()); System.out.println("AdGroupID = " + adEngineId.getAdGroupID());
				if(adEngineId.getAccountID() == null)
					errorHandler(new Exception(vmsg + "AdEngine ID not returned."));
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			try{
				//*** get AdEngine Promotions from the database
				System.out.println("------------------------------------------------------------");
				System.out.println("getAdvertisingEnginePromotion:");
				
				List<AdvertisingEnginePromotionObj> promotions = db.getAdvertisingEnginePromotion(test_accountId);				
				System.out.println("OK");
				
				//--- verification
				for(AdvertisingEnginePromotionObj a : promotions){
					System.out.println("->");
					System.out.println("AdEngineAccountID = " + a.getAdvertisingEngineAccountID());
					System.out.println("PromotionID = " + a.getPromotionID());
					System.out.println("AdEngineCampaignID = " + a.getAdvertisingEngineCampaignID());
					System.out.println("AdEngineAdgroupID = " + a.getAdvertisingEngineAdGroupID());
				}
				if(promotions.size() == 0)
					errorHandler(new Exception(vmsg + "No AdEnginge promotion returned."));
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			try{
				//*** get AdEngine campaign from the database
				System.out.println("------------------------------------------------------------");
				System.out.println("getAdvertisingEngineCampaign:");
				
				AdvertisingEnginePromotionObj campaign = db.getAdvertisingEngineCampaign(test_accountId, promotionID);
				System.out.println("OK");
				
				//--- verification
				System.out.println("AdEngineAccountID = " + campaign.getAdvertisingEngineAccountID());
				System.out.println("PromotionID = " + campaign.getPromotionID());
				System.out.println("AdEngineCampaignID = " + campaign.getAdvertisingEngineCampaignID());
				System.out.println("AdEngineAdgroupID = " + campaign.getAdvertisingEngineAdGroupID());
				if(campaign.getAdvertisingEngineAccountID() == null)
					errorHandler(new Exception(vmsg + "No campaign data returned."));
				if(campaign.getAdvertisingEngineAccountID() != test_accountId.intValue())
					errorHandler(new Exception(vmsg + "Campaign data returned incorrectly."));
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			/*try{
				//*** get AdEngine campaign from the database
				System.out.println("------------------------------------------------------------");
				System.out.println("getAdEngineAccount:");
				
				List<Map<String, Object>> accs = db.getAdEngineAccount(customerID, adEngine);
				System.out.println("OK");
				
				//--- verification
				int i = 0;
				for(Map<String, Object> m : accs){
					System.out.println("#"+i+" ---------------------------------------");
					System.out.println("AccountID = " + m.get("AccountID"));
					System.out.println("CustomerName = " + m.get("CustomerName"));
					i++;
				}
				if(accs.size() == 0){
					errorHandler(new Exception(vmsg + "No campaign returned."));
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}*/
			
			try{
				//*** set AdEngine AdGroupID and get CampaignID at AdvertisingEnginePromotion table
				System.out.println("------------------------------------------------------------");
				System.out.println("setAdvertisingEngineAdGroupID:");
				
				Long adGroupId = 54321L;
				db.setAdvertisingEngineAdGroupID(test_campaignId, adGroupId);
				System.out.println("OK");

				//--- verification
				String sql = "SELECT aep.AdvertisingEngineAdGroupID from AdvertisingEnginePromotion aep where aep.AdvertisingEngineCampaignPK = ?";
				int vret = jdbcTemplate.queryForInt(sql, test_campaignId);
				if(vret != adGroupId.intValue()){
					errorHandler(new Exception(vmsg + "AdGroupID is not added to the AdvertisingEnginePromotion table."));
				}

			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}

			try{
				//*** set AdID For AdGroup at the AdvertisingEngineAds table
				System.out.println("------------------------------------------------------------");
				System.out.println("setAdIDForAdGroup:");
				
				Long advertisingEngineAdPK = 13579L;
				int PromotionAdsFK = 17;
				db.setAdIDForAdGroup(advertisingEngineAdPK, adEngine, PromotionAdsFK);
				System.out.println("OK");
				
				//--- verification
				String sql = "select aea.PromotionAdsFK from AdvertisingEngineAds aea where aea.AdvertisingEngineAdPK = ?";
				int vret = jdbcTemplate.queryForInt(sql, advertisingEngineAdPK);
				if(vret != PromotionAdsFK){
					errorHandler(new Exception(vmsg + "AdID is not set to the AdvertisingEngineAds table."));
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			try{
				//*** update Promotion To AdEngineAccountID at the AdvertisingEnginePromotion table
				System.out.println("------------------------------------------------------------");
				System.out.println("updatePromotionToAdEngineAccountID:");
				
				Double AdvertisingEngineBudget = 50.00;
				Double advertisingEngineBudget = 20.00;
				Double currentDailyBudget = 2.00;
				db.updatePromotionToAdEngineAccountID(test_campaignId, true, true, AdvertisingEngineBudget, currentDailyBudget);
				System.out.println("OK");
				
				//--- verification
				String sql = "select aep.AdvertisingEngineBudget from AdvertisingEnginePromotion aep where aep.AdvertisingEngineCampaignPK = ?";
				Double vret = jdbcTemplate.queryForObject(sql, new Object[]{test_campaignId}, Double.class);
				if(vret != AdvertisingEngineBudget){
					errorHandler(new Exception(vmsg + "Promotion data is not updated properly to the AdvertisingEnginePromotion table."));
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			/* ******************************************************************************************* */
			//*** get all customer data from the Customer table
			/*
			List<CustomerObj> ret = db.getAllCustomers();
			int i = 0;
			for(CustomerObj c : ret){
				System.out.println("#"+i+"----------------------------");
				System.out.println("name = " + c.getName());
				System.out.println("customerPK = " + c.getCustomerPK());
				System.out.println("billType = " + c.getBillType());
				System.out.println("campaignCycleType = " + c.getCampaignCycleType());
				System.out.println("cycleInDays = " + c.getCycleInDays());
				System.out.println("totalTargetCycleBudget = " + c.getTotalTargetCycleBudget());
				System.out.println("createdDate = " + c.getCreatedDate());
				i++;
			}
			*/
			
			/* ******************************************************************************************* */
			//*** get budget from Promotion table
			/*
			BudgetObject b = db.getBudget(promotionID);
			System.out.println("RemainingBudgetInCycle = " + b.getRemainingBudgetInCycle());
			System.out.println("RemainingDays = " + b.getRemainingDays());
			*/
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}

	public void Test_Other(){
		try{
			/* ******************************************************************************************* */
			//*** Test GetKeywordForAdEngineSP(). Get keyword list from the database
			/*
			GetKeywordForAdEngineSP getKeywords = new GetKeywordForAdEngineSP();
			List<KeywordProbabilityObject> keywordList = getKeywords.execute(promotionID,true,false);
			int i = 0;
			for(KeywordProbabilityObject k : keywordList){
				System.out.println("#"+i+"----------------------------");
				System.out.println("keyword = " + k.getKeyword());
				System.out.println("probability = " + k.getSemplestProbability());
				System.out.println("isActive = " + k.getIsActive());
				System.out.println("isTargetGoogle = " + k.getIsTargetGoogle());
				System.out.println("isTargetMsn = " + k.getIsTargetMSN());
				i++;
			}
			*/
			
			/* ******************************************************************************************* */
			//*** Test GetAllPromotionDataSP(). Get promotion data from the database
			/*
			GetAllPromotionDataSP retpromo = new GetAllPromotionDataSP();
			boolean ret = retpromo.execute(promotionID);
			PromotionObj pd = retpromo.getPromotionData();
			System.out.println("Promotions: -------------------");
			System.out.println(ReflectionToStringBuilder.toString(pd));
			List<AdsObject> ads = retpromo.getAds();
			System.out.println("Ads: -------------------");
			for(AdsObject a : ads){
				System.out.println(ReflectionToStringBuilder.toString(a));
			}
			List<GeoTargetObject> gts = retpromo.getGeoTargets();
			System.out.println("GeoTargets: -------------------");
			for(GeoTargetObject g : gts){
				System.out.println(ReflectionToStringBuilder.toString(g));
			}
			*/
			
			/* ******************************************************************************************* */
			//*** Test UpdateRemainingBudgetInCycleSP(). Update Remaining Budget In Cycle to the database.
			/*
			UpdateRemainingBudgetInCycleSP updbudget = new UpdateRemainingBudgetInCycleSP();
			Calendar cal = Calendar.getInstance();
			cal.set(2011, 1, 1); Date start = cal.getTime();
			cal.set(2012, 06, 01); Date end = cal.getTime();
			Integer ret = updbudget.execute(promotionID, start, end);
			*/
			
			/* ******************************************************************************************* */
			//*** Test setSemplestBiddingHistory() and getSemplestBiddingHistory().
			///*
			//set
			db.setSemplestBiddingHistory(71, AdEngine.Google, PromotionBiddingType.Initial);
			db.setSemplestBiddingHistory(71, AdEngine.MSN, PromotionBiddingType.Ongoing);
			//get
			List<SemplestBiddingHistory> gRet = db.getSemplestBiddingHistory(71, AdEngine.Google);
			List<SemplestBiddingHistory> mRet = db.getSemplestBiddingHistory(71, AdEngine.MSN);
			//print
			for(SemplestBiddingHistory sb : gRet){
				System.out.println("PromotionFK = " + sb.getPromotionFK() + "; AdvertisingEngine = " + sb.getAdvertisingEngine() + "; SemplestBidType = " + sb.getSemplestBidType() + "; BidCompleted = " + sb.getBidCompleted());
			}
			for(SemplestBiddingHistory sb : mRet){
				System.out.println("PromotionFK = " + sb.getPromotionFK() + "; AdvertisingEngine = " + sb.getAdvertisingEngine() + "; SemplestBidType = " + sb.getSemplestBidType() + "; BidCompleted = " + sb.getBidCompleted());
			}
			//*/
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	
	// Helper methods
	
	private void prepDataInDatabase_reportData(){	
		
		//get report from google
		ReportObject[] report = getReportFromGoogle();
		
		//insert keywords to the campaign
		String[] keywords = genKeywordList(report);	
		for(String s : keywords){
			System.out.println(s);
		}
		
		//Insert keywords to the Keyword table
		//insertKeywordTable(keywords);
		
		//get keywordPK for the keywords
		System.out.println("===================================================================================");
		ArrayList<Integer> pkList = getKeywordPk(keywords);
		
		for(Integer pk : pkList){
			System.out.println(pk);
		}
		
		System.out.println("===================================================================================");
		System.out.println("num of keywords = " + keywords.length);
		System.out.println("num of PKs = " + pkList.size());
		
		//Insert PromotionPK and KeywordPK pair to the PromotionKeywordAssociation table.
		//insertPKtoAssociationTable(pkList);
		
		//Insert keywords to KeywordBid table
		//insertKeywordBidTable(pkList);
		
		//String strSQL = "update KeywordBid set IsActive = 1 where PromotionFK = 71";
		//jdbcTemplate.update(strSQL);	
		
	}	
	
	private ArrayList<Integer> getKeywordPk(String[] keywords){
		try
		{						
			ArrayList<Integer> ret = new ArrayList<Integer>();
			for(String k : keywords){
				String strSQL = "select k.KeywordPK [KeywordPK] from Keyword k where Keyword = ?";		
				List item = jdbcTemplate.queryForList(strSQL, new Object[] { k });
				HashMap<String,Integer> map = (HashMap<String, Integer>) item.get(0);
				Integer pk = map.get("KeywordPK");				
				ret.add(pk);
			}			
			return ret;
		}
		catch (EmptyResultDataAccessException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	private void insertKeywordBidTable(ArrayList<Integer> pklist){
		for(Integer keywordPK : pklist){
			String strSQL = "insert into KeywordBid(KeywordFK, AdvertisingEngineFK, PromotionFK, StartDate, IsActive, BidTypeFK, MicroBidAmount, IsDefaultValue, CreatedDate) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
	
			jdbcTemplate.update(strSQL, new Object[]
			{ keywordPK, 2, promotionID, new Date(), 0, 1, 100000, 0, new Date() });
			
			System.out.println();
		}
	}
	
	private void insertKeywordTable(String[] keywords){
		
		for(String k : keywords){
			String strSQL = "insert into Keyword(Keyword) "
					+ "VALUES (?)";
	
			jdbcTemplate.update(strSQL, new Object[]
			{ k });
		}		
	}
	
	private void insertPKtoAssociationTable(ArrayList<Integer> pklist){		
		for(Integer keywordPK : pklist){
			String strSQL = "insert into PromotionKeywordAssociation(KeywordFK, PromotionFK, CreatedDate, IsActive, IsDeleted, IsNegative, IsTargetMSN, IsTargetGoogle) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
	
			jdbcTemplate.update(strSQL, new Object[]
			{ keywordPK, promotionID, new Date(), 0, 0, 0, 0, 1 });
			
			System.out.println();
		}
	}
	
	private String[] genKeywordList(ReportObject[] report){
		HashMap<String, String> map = new HashMap<String, String>();
		for(ReportObject r : report){
			if(!map.containsKey(r.getKeyword())){
				map.put(r.getKeyword(), null);
			}
		}		
		String[] ret = new String[map.keySet().size()];
		map.keySet().toArray(ret);
		return ret;
	}
	
	private ReportObject[] getReportFromGoogle(){
		try{
			DateFormat dateFormat = new SimpleDateFormat("_MMddyy_HHmm");			
			String reportName = "GoogleReportData" + dateFormat.format(new Date()) + ".txt";
			String reportPath = "\\Z:\\TestReports\\" + reportName;								
			PrintStream out = new PrintStream(new FileOutputStream(reportPath));
			
			String REPORT_DEFINITION = "<reportDefinition><selector><fields>Date</fields>"
					+ "<fields>AdGroupId</fields><fields>Id</fields><fields>KeywordText</fields><fields>KeywordMatchType</fields>"
					+ "<fields>Impressions</fields><fields>Clicks</fields><fields>Cost</fields><fields>QualityScore</fields>"
					+ "<fields>AverageCpc</fields><fields>AveragePosition</fields><fields>CampaignId</fields><fields>Ctr</fields><fields>FirstPageCpc</fields><fields>MaxCpc</fields>"
					+ "<fields>ApprovalStatus</fields><fields>CampaignId</fields>"
					+ "</selector><reportName>KEYWORDS_PERFORMANCE_REPORT</reportName>"
					+ "<reportType>KEYWORDS_PERFORMANCE_REPORT</reportType>" + "<dateRangeType>ALL_TIME</dateRangeType><downloadFormat>CSV</downloadFormat>"
					+ "</reportDefinition>";
			
			Long accountId = google_accountId;   //"2188810777"; // "5058200123";
			GoogleReportDownloader report = new GoogleReportDownloader(REPORT_DEFINITION, accountId);
	
			String email = "adwords@semplest.com";
			String password = "ic0system";
			String userAgent = "Icosystem";
			String developerToken = "2H8l6aUm6K_Q44vDvxs3Og";
	
			ArrayList<ReportObject> reportObj = report.getReportObject(new AuthToken(email, password).getAuthToken(), developerToken);
			
			String eol = System.getProperty("line.separator");
			for(ReportObject r : reportObj){
				out.append(eol);			
				out.append(String.valueOf(r.getTransactionDate().getTime()));
				out.append(" --- " + r.getKeyword());				
			}
			out.close();
			
			if (reportObj.size() == 0)
			{
				return null;
			}
			else
			{
				ReportObject[] ret = new ReportObject[reportObj.size()];
				reportObj.toArray(ret);
				return ret;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	private ArrayList<KeywordDataObject> genKeywordDataObj(String matchType){
		ArrayList<KeywordDataObject> ret  = new ArrayList<KeywordDataObject>();		
		
		//get keyword list for the promotion
		ArrayList<String> kws  = new ArrayList<String>();
		String sql = "select k.Keyword from Keyword k inner join PromotionKeywordAssociation pka on k.KeywordPK = pka.KeywordFK where PromotionFK = 71";
		List<Map<String, Object>> item = jdbcTemplate.queryForList(sql);
		for(Map<String, Object> k : item){
			kws.add((String) k.get("Keyword"));
		}
				
		//generate fake transactions
		int c = 0;
		for(String k : kws){
			KeywordDataObject kd = new KeywordDataObject();
			kd.setApprovalStatus("approved");
			kd.setBidID(Long.valueOf(10000+c));
			kd.setCreatedDate(new Date());
			kd.setFirstPageCpc(Long.valueOf(200+new Date().getHours()));
			kd.setIsEligibleForShowing(true);
			kd.setKeyword(k);
			kd.setMatchType(matchType);
			kd.setMicroBidAmount(300000L);
			kd.setNegative(false);
			kd.setQualityScore(77);
			ret.add(kd);
			c++;
		}		
		
		return ret;
	}
	
	private ArrayList<BidElement> genBidElements(String matchType, boolean isNegative){
		ArrayList<BidElement> ret = new ArrayList<BidElement>();
		
		//get valid keyword list from the promotion
		ArrayList<String> kws  = new ArrayList<String>();
		String sql = "select k.Keyword from Keyword k inner join PromotionKeywordAssociation pka on k.KeywordPK = pka.KeywordFK where PromotionFK = 71 and IsActive = 1";
		List<Map<String, Object>> item = jdbcTemplate.queryForList(sql);
		for(Map<String, Object> k : item){
			kws.add((String) k.get("Keyword"));
		}
		
		//generate fake transactions
		int i = 0;
		for(String k : kws){
			BidElement be = new BidElement();
			be.setKeyword(k);
			be.setCompetitionType(SemplestCompetitionType.NotSelected.name());
			be.setKeywordAdEngineID(Long.valueOf(2000+i));
			be.setMatchType(matchType);
			be.setMicroBidAmount(12300L);
			be.setIsNegative(isNegative);
			be.setIsActive(true);
			be.setIsDefaultValue(true);
			be.setStartDate(new Date());
			be.setEndDate(null);
			ret.add(be);
			i++;
		}
				
		return ret;
	}
	
	public void init(){
		
		
	}
	
	public void cleanUp(){
		//remove test data from the database
		
		
	}
	
	private void errorHandler(Exception e){
		e.printStackTrace();
		System.out.println("////////////////////////////////////////////////////");	
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		StackTraceElement[] ste = e.getStackTrace();
		for(StackTraceElement s : ste){
			System.out.println(s.getClassName() + ": " + s.getMethodName() + ": " + s.getLineNumber());
		}
		System.out.println();
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");			
		
		errorCounter++;
	}
	
}
