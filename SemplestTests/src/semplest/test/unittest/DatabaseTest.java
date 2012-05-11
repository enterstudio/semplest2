package semplest.test.unittest;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TargetedDailyBudget;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.TransactionManager;
import semplest.service.google.adwords.GoogleReportDownloader;

import com.google.api.adwords.lib.AuthToken;

public class DatabaseTest extends BaseDB{	
	
	private ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	private SemplestDB db = new SemplestDB();
	
	private Integer promotionPK = 71;
		
	public static void main(String[] args){
		DatabaseTest test = new DatabaseTest();
		test.Test_Report_Data();					
	}	
	
	public void Test_Report_Data(){		
		try{
		//get report (of ALL_TIME) from google
			ReportObject[] report = getReportFromGoogle();			
			db.storeAdvertisingEngineReportData(promotionPK, AdEngine.Google.name(), report);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void prepDataInDatabase(){	
		
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
	
	public ArrayList<Integer> getKeywordPk(String[] keywords){
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
	
	public void insertKeywordBidTable(ArrayList<Integer> pklist){
		for(Integer keywordPK : pklist){
			String strSQL = "insert into KeywordBid(KeywordFK, AdvertisingEngineFK, PromotionFK, StartDate, IsActive, BidTypeFK, MicroBidAmount, IsDefaultValue, CreatedDate) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
	
			jdbcTemplate.update(strSQL, new Object[]
			{ keywordPK, 2, promotionPK, new Date(), 0, 1, 100000, 0, new Date() });
			
			System.out.println();
		}
	}
	
	public void insertKeywordTable(String[] keywords){
		
		for(String k : keywords){
			String strSQL = "insert into Keyword(Keyword) "
					+ "VALUES (?)";
	
			jdbcTemplate.update(strSQL, new Object[]
			{ k });
		}		
	}
	
	public void insertPKtoAssociationTable(ArrayList<Integer> pklist){		
		for(Integer keywordPK : pklist){
			String strSQL = "insert into PromotionKeywordAssociation(KeywordFK, PromotionFK, CreatedDate, IsActive, IsDeleted, IsNegative, IsTargetMSN, IsTargetGoogle) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
	
			jdbcTemplate.update(strSQL, new Object[]
			{ keywordPK, promotionPK, new Date(), 0, 0, 0, 0, 1 });
			
			System.out.println();
		}
	}
	
	public String[] genKeywordList(ReportObject[] report){
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
	
	public ReportObject[] getReportFromGoogle(){
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
			
			Long accountId = 5058200123L;   //"2188810777"; // "5058200123";
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
	
	public void init(){
		//insert test data to the database				
		
		
	}
	
	public void cleanUp(){
		//remove test data from the database
		
	}
	
	
}
