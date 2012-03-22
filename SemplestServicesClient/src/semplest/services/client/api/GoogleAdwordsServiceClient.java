package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import org.apache.log4j.Logger;

import semplest.other.DateTimeCeiling;
import semplest.other.DateTimeFloored;
import semplest.server.protocol.ProtocolJSON;
import semplest.services.client.interfaces.GoogleAdwordsServiceInterface;

import com.google.api.adwords.v201109.cm.AdGroup;
import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupCriterion;
import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.BiddableAdGroupCriterion;
import com.google.api.adwords.v201109.cm.Budget;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.cm.Money;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.api.adwords.v201109.o.TargetingIdea;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class GoogleAdwordsServiceClient implements GoogleAdwordsServiceInterface
{
	private static String SERVICEOFFERED = "semplest.service.google.adwords.GoogleAdwordsService";
	private static String BASEURLTEST = "http://localhost:9898/semplest";
	private static String timeoutMS = "5000";
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
	public AdGroup[] getAdGroupsByCampaignId(String customerID, Long campaignID, Boolean includeDeleted) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AdGroupCriterion[] getAllAdGroupCriteria(String customerId, Long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BiddableAdGroupCriterion[] getAllBiddableAdGroupCriteria(String accountID, Long adGroupID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String[] getAllAdGroupKeywords(String accountID, Long adGroupID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean deleteAdGroup(String accountID, Long adGroupID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public TargetingIdea[] GetRelatedKeywords(String keyword, KeywordMatchType matchType, int numberResults) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public TargetingIdea[] GetRelatedKeywordsForURL(String url,String keyword, KeywordMatchType matchType, int numberResults) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean updateAD(String accountID, Long adGroupID, Long AdID, String headline, String description1, String description2,
			String displayURL, String url) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
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
	public Campaign[] getCampaignsByAccountId(String accountID, boolean includeDeleted) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean UpdateCampaignName(String accountID, Long campaignID, String newName) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
