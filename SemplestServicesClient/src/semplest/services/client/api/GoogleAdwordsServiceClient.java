package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;

import semplest.other.DateTimeCeiling;
import semplest.other.DateTimeFloored;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.google.GoogleBidObject;
import semplest.server.protocol.google.GoogleRelatedKeywordObject;
import semplest.server.protocol.google.GoogleTrafficEstimatorObject;
import semplest.services.client.interfaces.GoogleAdwordsServiceInterface;

import com.google.api.adwords.v201109.cm.AdGroup;
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
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class GoogleAdwordsServiceClient implements GoogleAdwordsServiceInterface
{
	private static String SERVICEOFFERED = "semplest.service.google.adwords.GoogleAdwordsService";
	private static String BASEURLTEST = "http://VMJAVA1:9898/semplest";  //VMJAVA1
	private static String timeoutMS = "10000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(GoogleAdwordsServiceClient.class);

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
			GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient();

			
			
			ArrayList<Double> bidLevels = new ArrayList<Double>();
			bidLevels.add(0.9);
			bidLevels.add(1.00);
			bidLevels.add(1.20);
			bidLevels.add(1.50);
			bidLevels.add(2.00);
			
			// bidLevels.add(1.50);
			// bidLevels.add(10.50);
			// bidLevels.add(0.75);
			GoogleTrafficEstimatorObject o = client.getTrafficEstimationForOneKeyword("wedding venue", KeywordMatchType.EXACT, bidLevels);
			Double[] bids = o.getBidList();
			for (int i = 0; i < bids.length; i++)
			{
				System.out.println(bids[i] + " Aveclicks=" + o.getMaxAveClickPerDay(bids[i]) + " AveCPC=" + o.getAveCPC(bids[i]));
			}
			
			String accountID  = "6048920973";
			Long campaignID = 75239229L;

			GoogleRelatedKeywordObject resutls=client.GetRelatedKeywordsForURL("www.statefarm.com", "insurance",KeywordMatchType.EXACT, 30);
			ArrayList<String>keywrds =resutls.getKeywords();
			for(String kw:keywrds){
				System.out.println(kw);
			}
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
	private String runMethod(String baseURL, String methodName, String jsonStr)
	{
		Client client = Client.create();
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("jsonStr", jsonStr);
		queryParams.add("service", SERVICEOFFERED);
		queryParams.add("method", methodName);
		queryParams.add("timeout", timeoutMS);
		WebResource webResource = client.resource(baseURL);
		return webResource.queryParams(queryParams).get(String.class);
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

		String returnData = runMethod(BASEURLTEST, "CreateOneAccountService", json);
		return gson.fromJson(returnData, Account.class);
	}

	@Override
	public Boolean deleteCampaign(String accountID, Long campaignID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, "deleteCampaign", json);
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

		String returnData = runMethod(BASEURLTEST, "CreateOneCampaignForAccount", json);
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

		String returnData = runMethod(BASEURLTEST, "AddAdGroup", json);
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

		String returnData = runMethod(BASEURLTEST, "addTextAd", json);
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
	public AdGroup[] getAdGroupsByCampaignId(String accountID, Long campaignID, Boolean includeDeleted) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("includeDeleted",  String.valueOf(includeDeleted));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, "getAdGroupsByCampaignId", json);
		return gson.fromJson(returnData, AdGroup[].class);
	}
	
	@Override
	public AdGroupCriterion[] getAllAdGroupCriteria(String customerId, Long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public GoogleBidObject[] getAllBiddableAdGroupCriteria(String accountID, Long adGroupID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, "getAllBiddableAdGroupCriteria", json);
		return gson.fromJson(returnData,  GoogleBidObject[].class);
	}
	@Override
	public String[] getAllAdGroupKeywords(String accountID, Long adGroupID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, "getAllAdGroupKeywords", json);
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

		String returnData = runMethod(BASEURLTEST, "deleteAD", json);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public Boolean deleteAdGroup(String accountID, Long adGroupID) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, "deleteAdGroup", json);
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

		String returnData = runMethod(BASEURLTEST, "GetRelatedKeywords", json);
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

		String returnData = runMethod(BASEURLTEST, "GetRelatedKeywordsForURL", json);
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

		String returnData = runMethod(BASEURLTEST, " updateAD", json);
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

		String returnData = runMethod(BASEURLTEST, "changeCampaignStatus", json);
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

		String returnData = runMethod(BASEURLTEST, "changeCampaignBudget", json);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public ArrayList<HashMap<String, String>> getCampaignsByAccountId(String accountID, Boolean includeDeleted) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("includeDeleted", String.valueOf(includeDeleted));
		String json = protocolJson.createJSONHashmap(jsonHash);
		
		String returnData = runMethod(BASEURLTEST, "getCampaignsByAccountId", json);
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

		String returnData = runMethod(BASEURLTEST, "UpdateCampaignName", json);
		return gson.fromJson(returnData, Boolean.class);
	}
	@Override
	public GoogleBidObject addKeyWordToAdGroup(String accountID, Long adGroupID, String keyword, KeywordMatchType matchType, Long microBidAmount) throws Exception
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

		String returnData = runMethod(BASEURLTEST, "addKeyWordToAdGroup", json);
		System.out.println(returnData);
		return gson.fromJson(returnData, GoogleBidObject.class);
	}
	@Override
	public GoogleBidObject setBidForKeyWord(String accountID, Long keywordID, Long adGroupID, Long microBidAmount) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID);
		jsonHash.put("keywordID", String.valueOf(keywordID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		jsonHash.put("microBidAmount",String.valueOf(microBidAmount));
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, "setBidForKeyWord", json);
		return gson.fromJson(returnData, GoogleBidObject.class);
	}
	@Override
	public GoogleTrafficEstimatorObject getTrafficEstimationForOneKeyword(String keyword, KeywordMatchType matchType, ArrayList<Double> bidLevels)
			throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("keyword", keyword);
		jsonHash.put("matchType", matchType.getValue());
		String bidLevelStr = gson.toJson(bidLevels, ArrayList.class);
		jsonHash.put("bidLevels",bidLevelStr);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, "getTrafficEstimationForOneKeyword", json);
		return gson.fromJson(returnData,GoogleTrafficEstimatorObject.class);
	}
	@Override
	public void getBidLandscapeForKeyword(String accountID, Long adGroupID, Long keywordID) throws Exception
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void getBidLandscapeForAdgroup(String accountID, Long adGroupID) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

}
