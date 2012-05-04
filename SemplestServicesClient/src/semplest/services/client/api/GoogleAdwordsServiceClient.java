package semplest.services.client.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import semplest.other.DateTimeCeiling;
import semplest.other.DateTimeFloored;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.TaskOutput;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.BidSimulatorObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleRelatedKeywordObject;
import semplest.services.client.interfaces.GoogleAdwordsServiceInterface;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;

import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupCriterion;
import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.Budget;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.cm.Money;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.gson.Gson;

public class GoogleAdwordsServiceClient extends ServiceRun implements GoogleAdwordsServiceInterface, SchedulerTaskRunnerInterface
{
	private static String SERVICEOFFERED = "semplest.service.google.adwords.GoogleAdwordsService";
	private static String BASEURLTEST = "http://VMJAVA1:9898/semplest";  //VMJAVA1
	private String timeoutMS = "20000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(GoogleAdwordsServiceClient.class);
	
	private final String baseurl;
	
	public GoogleAdwordsServiceClient(String baseurl)
	{
		if (baseurl == null)
		{
			this.baseurl = BASEURLTEST;
		}
		else
		{
			this.baseurl = baseurl;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		/*
		 * HashMap<String, Object> jsonHash = new HashMap<String, Object>();
		 * jsonHash.put("accountID", "123"); jsonHash.put("campaignName",
		 * "Name"); CampaignStatus campaignStatus = CampaignStatus.PAUSED;
		 * jsonHash.put("campaignStatus", campaignStatus); BudgetBudgetPeriod
		 * period = BudgetBudgetPeriod.MONTHLY; jsonHash.put("period", period);
		 * String json = protocolJson.createJSONHashmap(jsonHash);
		 * System.out.println(json);
		 */

		try
		{
			GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(BASEURLTEST);
			
			
			
			/*********************************************************************************************
			 * GeoTarget Testing
			 */
			Double radius 	= 20.0;
			String addr 	= "195 Broadway";
			String city		= "New York";
			String state 	= "NY";
			String zip 		= "10007";
			
			String clientId = "8982168071";
			long   campaignId = 76709721L;
			
			Boolean res1 = client.setGeoTarget( clientId, campaignId, radius, addr, city, state, zip);
			Boolean res2 = client.setGeoTarget( clientId, campaignId, radius, "", "", "", zip);
			Boolean res3 = client.setGeoTarget( clientId, campaignId, 0.0, "", "", state, "");
			assert( res1 == true && res2 == true && res3 == true);
			
			/*
			 * End GeoTarget Testing
			 ***********************************************************************************************/
			
			
			
			
			/*
			//String accountID = "2188810777";
			String accountID = "218881";  //nan test- to trigger error
			ArrayList<HashMap<String, String>> campaignsByAccountId = client.getCampaignsByAccountId(accountID, false);

			

			Long campaignID = 77290470L; //new Long(campaignsByAccountId.get(0).get("Id"));
			System.out.println(campaignID);
			
			Long adGroupID= 3074331030L;
			KeywordDataObject[] c = client.getAllBiddableAdGroupCriteria(accountID, adGroupID, true); 
			for (int i = 0; i < c.length; i++) 
			{
				System.out.println(c[i].getKeyword() + ":" + c[i].getBidID() + ":"  + c[i].getQualityScore() + ":" + c[i].getFirstPageCpc());
			}
			
			*/
			//String[] keys = client.getAllAdGroupKeywords(accountID, adGroupID);
			
			/*
			GoogleBidObject[] bids = client.getAllBiddableAdGroupCriteria(accountID, adGroupID);
			
			//GoogleBidSimulatorObject[] bidObj = client.getBidLandscapeForKeyword(accountID, adGroupID, bids[0].getBidID());
			GoogleBidSimulatorObject[] bidObj = client.getBidLandscapeForAdgroup(accountID, adGroupID);
			if (bidObj!=null && bidObj.length>0)
			{
				System.out.println(bidObj[0].getBidPoint(bids[0].getBidID()).getCost());
			}
			else
			{
				System.out.println("no landscape for " + bids[0].getKeyword());
			}
					
			*/
			            
			//GoogleAdGroupObject[] adGroups = client.getAdGroupsByCampaignId(accountID, campaignID, false);
			//System.out.println(adGroups[0].getAdGroupID());
			
			
			/*
			
			ArrayList<Double> bidLevels = new ArrayList<Double>();
			bidLevels.add(0.9);
			bidLevels.add(1.00);
			bidLevels.add(1.20);
			bidLevels.add(1.50);
			bidLevels.add(2.00);
			
			// bidLevels.add(1.50);
			// bidLevels.add(10.50);
			 bidLevels.add(2.75);
			GoogleTrafficEstimatorObject o = client.getTrafficEstimationForOneKeyword("wedding venue", KeywordMatchType.EXACT, bidLevels);
			Double[] bids = o.getBidList();
			for (int i = 0; i < bids.length; i++)
			{
				System.out.println(bids[i] + " Aveclicks=" + o.getMaxAveClickPerDay(bids[i]) + " AveCPC=" + o.getAveCPC(bids[i]));
			}
			
			String accountID  = "6048920973";
			Long campaignID = 75239229L;
			*/
/*
			GoogleRelatedKeywordObject resutls=client.GetRelatedKeywordsForURL("www.statefarm.com", "insurance",KeywordMatchType.EXACT, 30);
			ArrayList<String>keywrds =resutls.getKeywords();
			for(String kw:keywrds){
				System.out.println(kw);
			}
			*/
			//String accountID  = "6048920973";
			//Long campaignID = 75239229L;
			/*
>>>>>>> .r523
			//Boolean res= client.UpdateCampaignName(accountID, 75239229L, "Updated Name2");
			
			//Long adgroupID = client.AddAdGroup(accountID, campaignID, "TestAdGroup", AdGroupStatus.PAUSED);
			//System.out.println("Added Addgroup ID=" + String.valueOf(adgroupID));
			//Added Addgroup ID=3380873349
			Long adGroupID = 3380873349L;
			//GoogleBidObject newkeyword = client.addKeyWordToAdGroup(accountID, adGroupID, "MyTestKeyword6", KeywordMatchType.EXACT, 300000L);
			//System.out.println("newkeywordID = " + newkeyword.getKeyword() + ":" + newkeyword.getBidID() + ":" + String.valueOf(newkeyword.getMicroBidAmount()) + ":" + newkeyword.getApprovalStatus());
			//Long firstAdID = client.addTextAd(accountID, adGroupID, "First Ad", "Description1: Testing out the Text Ad","Description2: Testing out the Text Ad", "www.semplest.com", "http://www.semplest.com");
			//System.out.println("Added Addgroup ID=" + String.valueOf(firstAdID));
			
			//Added Addgroup ID=11384558709
			/*
			ArrayList<HashMap<String, String>> res = client.getCampaignsByAccountId(accountid, true);
			for (int i = 0 ; i < res.size(); i++)
			{
				HashMap<String, String> data = res.get(i);
				System.out.println(data.get("Id") + ":" + data.get("Name"));
			}
			
			String[] keywords = client.getAllAdGroupKeywords(accountID, adgroupID);
			for (int i = 0; i < keywords.length; i++)
			{
				System.out.println(keywords[i]);
			}
			/*
			ArrayList<HashMap<String, String>> getCampaignsByAccountId = client.getCampaignsByAccountId(accountID, false);
			for (int i = 0; i < getCampaignsByAccountId.size(); i++)
			{
				System.out.println(getCampaignsByAccountId.get(i).get("Name"));
			}
			*/
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		HashMap<String, Object> jsonHash = new HashMap<String, Object>();
		ArrayList<String> x = new ArrayList<String>();
		x.add("one");
		x.add("two");
		jsonHash.put("array", x);
		jsonHash.put("accountID", "accountID");
		jsonHash.put("campaignName", "campaignName");
		jsonHash.put("campaignStatus", CampaignStatus.PAUSED.getValue());
		jsonHash.put("period", BudgetBudgetPeriod.MONTHLY);
		String json = protocolJson.createJSONHashmap(jsonHash);
		System.out.println(json);
		HashMap<String, Object> data = gson.fromJson(json, HashMap.class); // protocolJson.getHashMapFromJson(json);
		System.out.println(data.get("campaignStatus"));
		CampaignStatus cc = CampaignStatus.fromString(data.get("campaignStatus").toString());
		System.out.println(cc.getValue());
		ArrayList<String> xx = gson.fromJson(data.get("array").toString(), ArrayList.class);
		System.out.println(xx.get(0));
		*/
		// HashMap<String,String> c =
		// gson.(data.get("campaignStatus"),HashMap.class);
		// logger.debug("Campaign=" + c.get("value"));

	}
	

	/*
	 * Campaign
	 * 
	 */
	@Override
	public Account CreateOneAccountService(String currencyCode, String dateTimeZone, String companyName, String descriptiveName) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("currencyCode", currencyCode);
		jsonHash.put("dateTimeZone", dateTimeZone);
		jsonHash.put("companyName", companyName);
		jsonHash.put("descriptiveName", descriptiveName);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "CreateOneAccountService", json, timeoutMS);
		return gson.fromJson(returnData, Account.class);
	}

	@Override
	public Boolean deleteCampaign(String accountID, Long campaignID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteCampaign", json, timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public Campaign CreateOneCampaignForAccount(String accountID, String campaignName, CampaignStatus campaignStatus, BudgetBudgetPeriod period,
			Money budgetAmount) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignName", campaignName);
		jsonHash.put("campaignStatus", campaignStatus.getValue());
		jsonHash.put("period", period.getValue());
		jsonHash.put("budgetAmount", String.valueOf(budgetAmount.getMicroAmount()));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "CreateOneCampaignForAccount", json,timeoutMS);
		return gson.fromJson(returnData, Campaign.class);
	}
	/*
	 * AdGroup and Ads
	 */
	@Override
	public Long AddAdGroup(String accountID, Long campaignID, String AdGroupName, AdGroupStatus status) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("AdGroupName", AdGroupName);
		jsonHash.put("status", status.getValue());
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "AddAdGroup", json,timeoutMS);
		return gson.fromJson(returnData, Long.class);
	}
	@Override
	public Long addTextAd(String accountID, Long adGroupID, String headline, String description1, String description2, String displayURL,
			String url) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("addGroupID", String.valueOf(adGroupID));
		jsonHash.put("headline", headline);
		jsonHash.put("description1", description1);
		jsonHash.put("description2", description2);
		jsonHash.put("displayURL", displayURL);
		jsonHash.put("url", url);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "addTextAd", json,timeoutMS);
		return gson.fromJson(returnData, Long.class);
	}
	@Override
	public void addAccountBudget(Money money, String customerId, String orderId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[] getClientAccounts() throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Budget[] getAccountBudgets(String customerId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateAccountBudget(Budget budgetForUpdate, Money money, String customerId, String orderId) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addAccountBudget(DateTimeFloored start, DateTimeCeiling end, Money budget, String string) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateAccountBudgetCannotChangeTheStartDateOfTheCurrentBudget(Budget budgetForUpdate, DateTimeCeiling end, Money newBudgetAmount,
			String string) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public GoogleAdGroupObject[] getAdGroupsByCampaignId(String accountID, Long campaignID, Boolean includeDeleted) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("includeDeleted",  String.valueOf(includeDeleted));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAdGroupsByCampaignId", json,timeoutMS);
		return gson.fromJson(returnData, GoogleAdGroupObject[].class);
	}
	
	@Override
	public AdGroupCriterion[] getAllAdGroupCriteria(String customerId, Long adGroupId, Boolean ActiveOnly) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public KeywordDataObject[] getAllBiddableAdGroupCriteria(String accountID, Long adGroupID, Boolean ActiveOnly) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("ActiveOnly",  String.valueOf(ActiveOnly));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAllBiddableAdGroupCriteria", json,timeoutMS);
		return gson.fromJson(returnData,  KeywordDataObject[].class);
	}
	@Override
	public String[] getAllAdGroupKeywords(String accountID, Long adGroupID,  Boolean ActiveOnly) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("ActiveOnly",  String.valueOf(ActiveOnly));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getAllAdGroupKeywords", json,timeoutMS);
		return gson.fromJson(returnData, String[].class);
	}
	@Override
	public AdGroupAd[] getAdsByAdGroupId(String customerId, long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean deleteAD(String accountID, Long adGroupID, Long AdID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("AdID", String.valueOf(AdID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteAD", json,timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public Boolean deleteAdGroup(String accountID, Long adGroupID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "deleteAdGroup", json,timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	
	@Override
	public GoogleRelatedKeywordObject GetRelatedKeywords(String keyword, KeywordMatchType matchType, int numberResults) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("keyword", keyword);
		jsonHash.put("matchType", matchType.getValue());
		jsonHash.put("numberResults",String.valueOf(numberResults));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "GetRelatedKeywords", json,timeoutMS);
		return gson.fromJson(returnData, GoogleRelatedKeywordObject.class);
	}
	
	@Override
	public GoogleRelatedKeywordObject GetRelatedKeywordsForURL(String url,String keyword, KeywordMatchType matchType, int numberResults) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("url", url);
		jsonHash.put("keyword", keyword);
		jsonHash.put("matchType", matchType.getValue());
		jsonHash.put("numberResults",String.valueOf(numberResults));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "GetRelatedKeywordsForURL", json,timeoutMS);
		return gson.fromJson(returnData, GoogleRelatedKeywordObject.class);
	}
	@Override
	public Boolean updateAD(String accountID, Long adGroupID, Long AdID, String headline, String description1, String description2,
			String displayURL, String url) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("AdID", String.valueOf(AdID));
		jsonHash.put("headline", headline);
		jsonHash.put("description1", description1);
		jsonHash.put("description2", description2);
		jsonHash.put("displayURL", displayURL);
		jsonHash.put("url", url);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, " updateAD", json,timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public Boolean changeCampaignStatus(String accountID, Long campaignID, CampaignStatus status) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("status", status.getValue());
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "changeCampaignStatus", json,timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public Boolean changeCampaignBudget(String accountID, Long campaignID, Money budgetAmount) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("budgetAmount", String.valueOf(budgetAmount.getMicroAmount()));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "changeCampaignBudget", json,timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public ArrayList<HashMap<String, String>> getCampaignsByAccountId(String accountID, Boolean includeDeleted) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("includeDeleted", String.valueOf(includeDeleted));
		String json = protocolJson.createJSONHashmap(jsonHash);
		
		String returnData = runMethod(baseurl,SERVICEOFFERED, "getCampaignsByAccountId", json,timeoutMS);
		System.out.println(returnData);
		return gson.fromJson(returnData, ArrayList.class);
	}
	@Override
	public Boolean UpdateCampaignName(String accountID, Long campaignID, String newName) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("newName", newName);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "UpdateCampaignName", json,timeoutMS);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public KeywordDataObject addKeyWordToAdGroup(String accountID, Long adGroupID, String keyword, KeywordMatchType matchType, Long microBidAmount) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("keyword", keyword);
		jsonHash.put("matchType", matchType.getValue());
		if (microBidAmount != null)
		{
			jsonHash.put("microBidAmount", String.valueOf(microBidAmount));
		}
		else
		{
			jsonHash.put("microBidAmount", String.valueOf("0"));
		}
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "addKeyWordToAdGroup", json,timeoutMS);
		System.out.println(returnData);
		return gson.fromJson(returnData, KeywordDataObject.class);
	}
	@Override
	public KeywordDataObject setBidForKeyWord(String accountID, Long keywordID, Long adGroupID, Long microBidAmount) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("keywordID", String.valueOf(keywordID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("microBidAmount",String.valueOf(microBidAmount));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "setBidForKeyWord", json,timeoutMS);
		return gson.fromJson(returnData, KeywordDataObject.class);
	}
	@Override
	public TrafficEstimatorObject getTrafficEstimationForKeywords(String accountID, Long campaignID, KeywordMatchType matchType,
			HashMap<String, Long> KeywordWithBid)
			throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		//jsonHash.put("keyword", keyword);
		jsonHash.put("matchType", matchType.getValue());
		jsonHash.put("KeywordWithBid", gson.toJson(KeywordWithBid,HashMap.class));
		//String bidLevelStr = gson.toJson(bidLevels, ArrayList.class);
		//jsonHash.put("bidLevels",bidLevelStr);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getTrafficEstimationForOneKeyword", json,timeoutMS);
		return gson.fromJson(returnData,TrafficEstimatorObject.class);
	}
	@Override
	public  BidSimulatorObject[] getBidLandscapeForKeyword(String accountID, Long adGroupID, Long keywordID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("keywordID", String.valueOf(keywordID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getBidLandscapeForKeyword", json,timeoutMS);
		return gson.fromJson(returnData, BidSimulatorObject[].class);
		
	}
	@Override
	public BidSimulatorObject[] getBidLandscapeForAdgroup(String accountID, Long adGroupID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getBidLandscapeForAdgroup", json,timeoutMS);
		return gson.fromJson(returnData, BidSimulatorObject[].class);
		
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaskOutput RunTask(String method, String jsonParameters, String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		if (optionalTimeoutMS == null)
		{
			optionalTimeoutMS = timeoutMS;
		}
		return RunTask(this.getClass(), baseurl, SERVICEOFFERED, method, jsonParameters,optionalTimeoutMS);
	}
	
	@Override
	public ReportObject[] getReportForAccount(SemplestString accountID) throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID.toString());
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getReportForAccount", json,timeoutMS);
		return gson.fromJson(returnData, ReportObject[].class);
	}

	@Override
	public Long getSpentAPIUnitsPerAccountID(Long accountID, Date startDate,
			Date endDate) throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", String.valueOf(accountID));
		jsonHash.put("startDate", gson.toJson(startDate));
		jsonHash.put("endDate", gson.toJson(endDate));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(baseurl,SERVICEOFFERED, "getSpentAPIUnitsPerAccountID", json,timeoutMS);
		return gson.fromJson(returnData, Long.class);
	}
	
	@Override 
	public Boolean setGeoTarget(String accountId, Long campaignId, Double radius, String addr, String city, String state, String zip) throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", accountId);
		jsonHash.put("campaignId",	String.valueOf(campaignId));
		jsonHash.put("radius", 		String.valueOf(radius));
		jsonHash.put("addr", 		addr);
		jsonHash.put("city", 		city);
		jsonHash.put("state", 		state);
		jsonHash.put("zip", 		zip);
		
		String json = protocolJson.createJSONHashmap(jsonHash);
		String returnData = runMethod(baseurl,SERVICEOFFERED,"setGeoTarget", json, timeoutMS);
		return gson.fromJson(returnData,Boolean.class);
	}


}

