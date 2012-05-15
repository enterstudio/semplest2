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

import org.apache.log4j.BasicConfigurator;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TargetedDailyBudget;
import semplest.server.protocol.adengine.TrafficEstimatorDataObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.TransactionManager;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.google.adwords.GoogleReportDownloader;

import com.google.api.adwords.lib.AuthToken;
import com.google.api.adwords.v201109.cm.KeywordMatchType;

public class DatabaseTest extends BaseDB{	
	
	private ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	private SemplestDB db = new SemplestDB();
	
	private Integer promotionID = 71;
	private Long google_accountId = 5058200123L;
	private Long google_campaignId = 116193337L;
		
	public static void main(String[] args){
		DatabaseTest test = new DatabaseTest();
		
		//test.Test_ReportData();				
		//test.Test_TrafficEstimatorData();						
		//test.Test_DefaultBid();		
		//test.Test_KeywordDataObject();
		
		//test.Test_BidDataObject();
		
		
		System.out.println("*** DONE ***");
	}	
	
	public void Test_ReportData(){		
		try{			
			/* ******************************************************************************************* */
			//*** store report data to the AdvertisingEngineReportData table			
			//store_ReportData(1);
			
			/* ******************************************************************************************* */
			//*** get report data from the database			
			get_ReportData();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void store_ReportData(int caseNum){
		try{
			ReportObject[] report = null;
			ReportObject[] dup = null;
			switch(caseNum){
				case 1: {//real data
					//get report (of ALL_TIME) from google
					report = getReportFromGoogle();	
					db.storeAdvertisingEngineReportData(promotionID, AdEngine.Google.name(), report);
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
					report[0].setFirstPageCPC(1000000);
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
					dup[0].setFirstPageCPC(2000000);
					dup[0].setKeyword(keyword);
					dup[0].setMicroBidAmount(20000000L);
					dup[0].setMicroCost(2000000L);
					dup[0].setNumberClick(2000);
					dup[0].setNumberImpressions(2100);
					dup[0].setQualityScore(6);
					dup[0].setTransactionDate(transactionDate);
					
					db.storeAdvertisingEngineReportData(promotionID, AdEngine.Google.name(), report);
					db.storeAdvertisingEngineReportData(promotionID, AdEngine.Google.name(), dup);
					break;
				}
				default: report = null;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void get_ReportData(){
		try{
			//get report data from database
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -365);
			List<ReportObject> ret = db.getReportData(promotionID, AdEngine.Google.name(), cal.getTime(), null);
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
		}
	}
	
	public void Test_TrafficEstimatorData(){
		
		/* ******************************************************************************************* */
		//*** test store proc of traffic estimator data to the TrafficEstimator table		
		//store_TrafficEstimatorData();
		
		/* ******************************************************************************************* */
		//*** test get traffic estimator data from the database		
		get_TrafficEstimatorData();
		
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
			db.storeTrafficEstimatorData(promotionID, AdEngine.Google.name(), ret);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void get_TrafficEstimatorData(){
		try {
			String keyword;
			
			keyword = "civil wedding ceremony venues";
			List<TrafficEstimatorDataObject> ret = db.getLatestTrafficEstimatorForKeyword(promotionID, keyword, AdEngine.Google.name());
			System.out.println(keyword + " ==============================================");
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			Long ret = db.getDefaultBid(promotionID, AdEngine.Google.name());
			System.out.println("DefaultBid = " + ret);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			get_KeywordDataObject(2);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void store_KeywordDataObject(){
		try{
			//*** test for Existed KeywordBid			
			ArrayList<KeywordDataObject> kdo1 = genKeywordDataObj(MatchType.Exact.getValue());
			db.storeKeywordDataObjects(promotionID, AdEngine.Google.name(), kdo1);			
			
			//*** test for New Bid on Keyword			
			ArrayList<KeywordDataObject> kdo2 = genKeywordDataObj(MatchType.Broad.getValue());
			db.storeKeywordDataObjects(promotionID, AdEngine.Google.name(), kdo2);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void get_KeywordDataObject(int caseNum){
		try{			
			switch(caseNum){
				case 1:{
					//*** get Latest Biddable AdGroup Criteria from the database
					List<KeywordDataObject> ret = db.getLatestBiddableAdGroupCriteria(promotionID, AdEngine.Google.name());
					int i = 0;
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
					HashMap<String, ArrayList<KeywordDataObject>> rets = db.getAllBiddableAdGroupCriteria(promotionID, AdEngine.Google.name(), new Date(2011, 1, 1), null);
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
				}
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Test_BidDataObject(){
		try{
			
			
			
			/* ******************************************************************************************* */
			//*** get Latest Bids from the database
			List<BidElement> bids = db.getLatestBids(promotionID, AdEngine.Google.name());
			int i = 0;
			for(BidElement be : bids){
				System.out.println("#"+i+"----------------------------");
				System.out.println("keyword = " + be.getKeyword());
				System.out.println("matchType = " + be.getMatchType());
				System.out.println("microBidAmount = " + be.getMicroBidAmount());				
				i++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

	
	
	// Helper methods
	
	public void prepDataInDatabase_reportData(){	
		
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
	
	public void init(){
		//insert test data to the database				
		
		
	}
	
	public void cleanUp(){
		//remove test data from the database
		
	}
	
	
}
