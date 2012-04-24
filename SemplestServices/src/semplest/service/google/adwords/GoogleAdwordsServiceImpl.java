package semplest.service.google.adwords;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import semplest.other.DateTimeCeiling;
import semplest.other.DateTimeFloored;
import semplest.server.protocol.adengine.BidObject;
import semplest.server.protocol.adengine.BidSimulatorObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleRelatedKeywordObject;
import semplest.service.google.adwords.GoogleReportDownloader.HttpException;
import semplest.service.msn.adcenter.MsnCloudException;
import semplest.services.client.interfaces.GoogleAdwordsServiceInterface;

import com.google.api.adwords.lib.AdWordsService;
import com.google.api.adwords.lib.AdWordsServiceLogger;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AuthToken;
import com.google.api.adwords.lib.AuthTokenException;
import com.google.api.adwords.lib.utils.MapUtils;
import com.google.api.adwords.v201109.cm.Ad;
import com.google.api.adwords.v201109.cm.AdGroup;
import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupAdOperation;
import com.google.api.adwords.v201109.cm.AdGroupAdReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupAdServiceInterface;
import com.google.api.adwords.v201109.cm.AdGroupAdStatus;
import com.google.api.adwords.v201109.cm.AdGroupBidLandscape;
import com.google.api.adwords.v201109.cm.AdGroupBidLandscapePage;
import com.google.api.adwords.v201109.cm.AdGroupCriterion;
import com.google.api.adwords.v201109.cm.AdGroupCriterionOperation;
import com.google.api.adwords.v201109.cm.AdGroupCriterionPage;
import com.google.api.adwords.v201109.cm.AdGroupCriterionReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.AdGroupOperation;
import com.google.api.adwords.v201109.cm.AdGroupPage;
import com.google.api.adwords.v201109.cm.AdGroupReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupServiceInterface;
import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.Bid;
import com.google.api.adwords.v201109.cm.BidLandscapeLandscapePoint;
import com.google.api.adwords.v201109.cm.BiddableAdGroupCriterion;
import com.google.api.adwords.v201109.cm.Budget;
import com.google.api.adwords.v201109.cm.BudgetBudgetDeliveryMethod;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignOperation;
import com.google.api.adwords.v201109.cm.CampaignPage;
import com.google.api.adwords.v201109.cm.CampaignReturnValue;
import com.google.api.adwords.v201109.cm.CampaignServiceInterface;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.Criterion;
import com.google.api.adwords.v201109.cm.CriterionBidLandscape;
import com.google.api.adwords.v201109.cm.CriterionBidLandscapePage;
import com.google.api.adwords.v201109.cm.DataServiceInterface;
import com.google.api.adwords.v201109.cm.Keyword;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.cm.Language;
import com.google.api.adwords.v201109.cm.ManualCPC;
import com.google.api.adwords.v201109.cm.ManualCPCAdGroupCriterionBids;
import com.google.api.adwords.v201109.cm.Money;
import com.google.api.adwords.v201109.cm.Operator;
import com.google.api.adwords.v201109.cm.OrderBy;
import com.google.api.adwords.v201109.cm.Paging;
import com.google.api.adwords.v201109.cm.Predicate;
import com.google.api.adwords.v201109.cm.PredicateOperator;
import com.google.api.adwords.v201109.cm.Selector;
import com.google.api.adwords.v201109.cm.SortOrder;
import com.google.api.adwords.v201109.cm.TextAd;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.api.adwords.v201109.mcm.CreateAccountOperation;
import com.google.api.adwords.v201109.mcm.CreateAccountServiceInterface;
import com.google.api.adwords.v201109.o.AdGroupEstimateRequest;
import com.google.api.adwords.v201109.o.Attribute;
import com.google.api.adwords.v201109.o.AttributeType;
import com.google.api.adwords.v201109.o.CampaignEstimateRequest;
import com.google.api.adwords.v201109.o.CriterionAttribute;
import com.google.api.adwords.v201109.o.DoubleAttribute;
import com.google.api.adwords.v201109.o.IdeaType;
import com.google.api.adwords.v201109.o.KeywordEstimate;
import com.google.api.adwords.v201109.o.KeywordEstimateRequest;
import com.google.api.adwords.v201109.o.KeywordMatchTypeSearchParameter;
import com.google.api.adwords.v201109.o.LongAttribute;
import com.google.api.adwords.v201109.o.RelatedToKeywordSearchParameter;
import com.google.api.adwords.v201109.o.RelatedToUrlSearchParameter;
import com.google.api.adwords.v201109.o.RequestType;
import com.google.api.adwords.v201109.o.SearchParameter;
import com.google.api.adwords.v201109.o.StatsEstimate;
import com.google.api.adwords.v201109.o.TargetingIdea;
import com.google.api.adwords.v201109.o.TargetingIdeaPage;
import com.google.api.adwords.v201109.o.TargetingIdeaSelector;
import com.google.api.adwords.v201109.o.TargetingIdeaServiceInterface;
import com.google.api.adwords.v201109.o.TrafficEstimatorResult;
import com.google.api.adwords.v201109.o.TrafficEstimatorSelector;
import com.google.api.adwords.v201109.o.TrafficEstimatorServiceInterface;
import com.google.gson.Gson;
import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;

public class GoogleAdwordsServiceImpl implements GoogleAdwordsServiceInterface
{
	private static final Logger logger = Logger.getLogger(GoogleAdwordsServiceImpl.class);
	private static Gson gson = new Gson();
	// THis needs to be read from the Database
	private static String email = "adwords@semplest.com";
	private static String password = "ic0system";
	private static String userAgent = "Icosystem";
	private static String developerToken = "2H8l6aUm6K_Q44vDvxs3Og";
	private static boolean useSandbox = false;// true; //

	public static void main(String[] args)
	{

		// Log SOAP XML request and response.
		try
		{
			/*
			 * AdWordsServiceLogger.log(); String accountID = "6048920973"; //
			 * Get AdWordsUser from "~/adwords.properties". //AdWordsUser user =
			 * new AdWordsUser(email, password, "6048920973", userAgent,
			 * developerToken, useSandbox); GoogleAdwordsServiceImpl g = new
			 * GoogleAdwordsServiceImpl(); AdGroup[] res =
			 * g.getAdGroupsByCampaignId("6048920973", 75239229L, false); if
			 * (res != null) { for(int i = 0; i < res.length; i++) {
			 * System.out.println(res[i].getCampaignName() + ":" +
			 * res[i].getName()); } } Campaign[] camp =
			 * g.getCampaignsByAccountId(accountID, false); if (camp != null) {
			 * for(int i = 0; i < camp.length; i++) {
			 * System.out.println(camp[i].getName()); } }
			 */
			GoogleAdwordsServiceImpl g = new GoogleAdwordsServiceImpl();
			String accountID = "2188810777"; // "5058200123";// "8019925375"; //
			// "6048920973";
			Long adGroupID = 3074331030L;
			Long campaignID = 77290470L;


			BidObject[] c = g.getAllBiddableAdGroupCriteria(accountID, adGroupID, true);

			/*
			String accountID = "2188810777"; // "5058200123";// "8019925375"; //
												// "6048920973";
			Long adGroupID = 3380873349L;
			Long campaignID = 77290470L;

			
			HashMap<String, Double> bids = new HashMap<String, Double>();
			bids.put("wedding flower", 2.0);
			HashMap<String, Double> bids2 = new HashMap<String, Double>();
			bids2.put("wedding photo", 8.0);

			GoogleTrafficEstimatorObject o = g.getTrafficEstimationForKeywords(accountID, campaignID, KeywordMatchType.EXACT, bids);
			String[] keywords = o.getListOfKeywords();
			for (int i=0; i < keywords.length; i++)
			{
				HashMap<Double, GoogleTrafficEstimatorObject.BidData> points = o.getMapOfPoints(keywords[i]);
				Iterator<Double> bidIT = points.keySet().iterator();
				while(bidIT.hasNext())
				{
					Double abid= bidIT.next();
					System.out.println(keywords[i] + ":" + abid + ":" + points.get(abid).getMaxAveCPC());
				}
			}
			GoogleTrafficEstimatorObject o2 = g.getTrafficEstimationForKeywords(accountID, campaignID, KeywordMatchType.EXACT, bids2);
			o.addGoogleTrafficEstimatorObject(o2);
			keywords = o.getListOfKeywords();
			for (int i=0; i < keywords.length; i++)
			{
				HashMap<Double, GoogleTrafficEstimatorObject.BidData> points = o.getMapOfPoints(keywords[i]);
				Iterator<Double> bidIT = points.keySet().iterator();
				while(bidIT.hasNext())
				{
					Double abid= bidIT.next();
					System.out.println(keywords[i] + ":" + abid + ":" + points.get(abid).getMaxAveCPC());
				}
			}
			
			*/
			/*
			 * Double[] bids = o.getBidList(); for (int i = 0; i < bids.length;
			 * i++) { System.out.println(bids[i] + " Aveclicks=" +
			 * o.getMaxAveClickPerDay(bids[i]) + " AveCPC=" +
			 * o.getAveCPC(bids[i])); }
			 */

			// File f = g.getReportForAccount(accountID);
			// f.getName();
			/*
			 * ArrayList<HashMap<String, String>> camp =
			 * g.getCampaignsByAccountId(accountID, false);
			 * 
			 * Long campaignID = new Long(camp.get(0).get("Id"));
			 * System.out.println(campaignID); AdGroup[] adgroups =
			 * g.getAdGroupsByCampaignId(accountID, campaignID, false);
			 * adGroupID = adgroups[0].getId();
			 */
			/*
			 * GoogleBidObject[] c = g.getAllBiddableAdGroupCriteria(accountID,
			 * adGroupID); for (int i = 0; i < c.length; i++) {
			 * System.out.println(c[i].getKeyword() + ":" + c[i].getBidID()); }
			 */
			// MyTestKeyword3:34632214029
			// Long keywordID = 41030523L; // wedding venue
			// g.getBidLandscapeForAdgroup(accountID, adGroupID); // ,
			// keywordID);
			// g.reportfields();
			// ArrayList<HashMap<String, String>> res =
			// g.getCampaignsByAccountId(accountID, false);
			// System.out.println(res.get(0).get("Name"));
			// TargetingIdea[] res = g.GetRelatedKeywords("Red Shoes",
			// KeywordMatchType.EXACT, 20);

			/*
			 * GoogleRelatedKeywordObject res =
			 * g.GetRelatedKeywordsForURL("http://www.peanutbutter.com/",
			 * "peanut butter", KeywordMatchType.EXACT, 20); ArrayList<String>
			 * keys = res.getKeywords(); for (int i = 0; i < keys.size(); i++) {
			 * System.out.println(keys.get(i)); ArrayList<String> match =
			 * res.getMatchTypesForKeyword(keys.get(i)); for (int j = 0; j <
			 * match.size(); j++) { System.out.println(match.get(j)); } }
			 */

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * Account
	 */
	public String CreateOneAccountService(String json) throws Exception
	{
		logger.debug("call CreateOneAccountService(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class); // protocolJson.getHashMapFromJson(json);
		Account account = CreateOneAccountService(data.get("currencyCode"), data.get("dateTimeZone"), data.get("companyName"),
				data.get("descriptiveName"));
		// convert result to Json String
		return gson.toJson(account);
	}

	@Override
	public Account CreateOneAccountService(String currencyCode, String dateTimeZone, String companyName, String descriptiveName) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, null, userAgent, developerToken, useSandbox);
			// Get the AccountService.
			CreateAccountServiceInterface createAccountService = user.getService(AdWordsService.V201109.CREATE_ACCOUNT_SERVICE);
			// Create account.
			Account account = new Account();
			if (currencyCode == null)
			{
				currencyCode = "USD";
			}
			if (dateTimeZone == null)
			{
				dateTimeZone = "America/New_York";
			}
			account.setCurrencyCode(currencyCode);
			account.setDateTimeZone(dateTimeZone);
			account.setCompanyName(companyName);
			// Create operations.
			CreateAccountOperation operation = new CreateAccountOperation();
			operation.setOperand(account);
			operation.setDescriptiveName(descriptiveName);
			operation.setOperator(Operator.ADD);
	
			CreateAccountOperation[] operations = new CreateAccountOperation[]
			{ operation };
			// Add account.
			Account[] result = createAccountService.mutate(operations);
			// Display accounts.
			return result[0];
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}

	}

	@Override
	public void addAccountBudget(Money money, String customerId, String orderId) throws Exception
	{

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

	/*
	 * Add Group and Ads
	 */
	public String AddAdGroup(String json) throws Exception
	{
		logger.debug("call AddAdGroup" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long campaignID = Long.parseLong(data.get("campaignID"));
		Long adGroupID = AddAdGroup(data.get("accountID"), campaignID, data.get("AdGroupName"), AdGroupStatus.fromString(data.get("status")));
		// convert result to Json String
		return gson.toJson(adGroupID);
	}

	@Override
	public Long AddAdGroup(String accountID, Long campaignID, String AdGroupName, AdGroupStatus status) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupService.
			AdGroupServiceInterface adGroupService = user.getService(AdWordsService.V201109.ADGROUP_SERVICE);
			long campaignId = campaignID;
			// Create ad group.
			AdGroup adGroup = new AdGroup();
			adGroup.setName(AdGroupName);
			adGroup.setStatus(status);
			adGroup.setCampaignId(campaignId);
			// Create operations.
			AdGroupOperation operation = new AdGroupOperation();
			operation.setOperand(adGroup);
			operation.setOperator(Operator.ADD);
			AdGroupOperation[] operations = new AdGroupOperation[]
			{ operation };
			// Add ad group.
			AdGroupReturnValue result = adGroupService.mutate(operations);
			if (result != null && result.getValue() != null)
			{
				return result.getValue()[0].getId();
			}
			else
			{
				return null;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}		
	}

	public String addTextAd(String json) throws Exception
	{
		logger.debug("call addTextAd" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long addGroupID = Long.parseLong(data.get("addGroupID"));
		Long res = addTextAd(data.get("accountID"), addGroupID, data.get("headline"), data.get("description1"), data.get("description2"),
				data.get("displayURL"), data.get("url"));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public Long addTextAd(String accountID, Long adGroupID, String headline, String description1, String description2, String displayURL, String url)
			throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupAdService.
			AdGroupAdServiceInterface adGroupAdService = user.getService(AdWordsService.V201109.ADGROUP_AD_SERVICE);
	
			// Create text ad.
			TextAd textAd = new TextAd();
			textAd.setHeadline(headline);
			textAd.setDescription1(description1);
			textAd.setDescription2(description2);
			textAd.setDisplayUrl(displayURL);
			textAd.setUrl(url);
			// Create ad group ad.
			AdGroupAd textAdGroupAd = new AdGroupAd();
			textAdGroupAd.setAdGroupId(adGroupID.longValue());
			textAdGroupAd.setAd(textAd);
			// Create operations.
			AdGroupAdOperation textAdGroupAdOperation = new AdGroupAdOperation();
			textAdGroupAdOperation.setOperand(textAdGroupAd);
			textAdGroupAdOperation.setOperator(Operator.ADD);
	
			AdGroupAdOperation[] operations = new AdGroupAdOperation[]
			{ textAdGroupAdOperation };
			AdGroupAdReturnValue result = adGroupAdService.mutate(operations);
			if (result != null && result.getValue() != null)
			{
				return result.getValue()[0].getAd().getId();
			}
			else
			{
				return null;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}

	}

	public String getAllAdGroupCriteria(String json) throws Exception
	{
		logger.debug("call getAllAdGroupCriteria(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		AdGroupCriterion[] res = getAllAdGroupCriteria(data.get("accountID"), adGroupID, Boolean.valueOf(data.get("ActiveOnly")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public AdGroupCriterion[] getAllAdGroupCriteria(String accountID, Long adGroupID, Boolean ActiveOnly) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupCriterionService.
			AdGroupCriterionServiceInterface adGroupCriterionService = user.getService(AdWordsService.V201109.ADGROUP_CRITERION_SERVICE);
			// Create selector.
			Selector selector = new Selector();
			
			selector.setFields(new String[]
			{ "Id", "KeywordText", "KeywordMatchType", "ApprovalStatus", "Status", "MaxCpc", "QualityScore", "FirstPageCpc", "SystemServingStatus" });
			selector.setOrdering(new OrderBy[]
			{ new OrderBy("AdGroupId", SortOrder.ASCENDING) });
			// Create predicates. 
			Predicate adGroupIdPredicate = new Predicate("AdGroupId", PredicateOperator.IN, new String[]
			{ adGroupID.toString() });
			if (ActiveOnly)
			{
				Predicate statusPredicate = new Predicate("Status", PredicateOperator.IN, new String[] {"ACTIVE"}); 
				selector.setPredicates(new Predicate[] { adGroupIdPredicate, statusPredicate });
			}
			else
			{
				selector.setPredicates(new Predicate[] { adGroupIdPredicate });
			}
			
			// Get all ad group criteria.
			AdGroupCriterionPage page = adGroupCriterionService.get(selector);
			// Display ad group criteria.
			if (page.getEntries() != null && page.getEntries().length > 0)
			{
				return page.getEntries();
			}
			else
			{
				return new AdGroupCriterion[0];
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String getAllBiddableAdGroupCriteria(String json) throws Exception
	{
		logger.debug("call getAllBiddableAdGroupCriteria(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));

		BidObject[] res = getAllBiddableAdGroupCriteria(data.get("accountID"), adGroupID, Boolean.valueOf(data.get("ActiveOnly")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public BidObject[] getAllBiddableAdGroupCriteria(String accountID, Long adGroupID,Boolean ActiveOnly) throws Exception
	{
		List<BidObject> result = new ArrayList<BidObject>();
		for (AdGroupCriterion criterion : getAllAdGroupCriteria(accountID, adGroupID, ActiveOnly))
		{
			if (criterion instanceof BiddableAdGroupCriterion)
			{
				BiddableAdGroupCriterion res = (BiddableAdGroupCriterion) criterion;
				BidObject bidRes = new BidObject();
				if (res.getQualityInfo() != null)
				{
					bidRes.setQualityScore(res.getQualityInfo().getQualityScore());
				}
				if (res.getFirstPageCpc() != null)
				{
					bidRes.setFirstPageCpc(res.getFirstPageCpc().getAmount().getMicroAmount());
				}
				bidRes.setBidID(res.getCriterion().getId());
				if(res.getSystemServingStatus()!=null){
					bidRes.setStatus(res.getSystemServingStatus().getValue());
				}
				if (res.getApprovalStatus() != null)
				{
					bidRes.setApprovalStatus(res.getApprovalStatus().getValue());
				}
				Keyword keyword = ((Keyword) criterion.getCriterion());
				bidRes.setKeyword((keyword.getText()));
				
				bidRes.setMatchType(keyword.getMatchType().getValue());
				if (res.getBids() != null)	
				{
					bidRes.setMicroBidAmount(((ManualCPCAdGroupCriterionBids) res.getBids()).getMaxCpc().getAmount().getMicroAmount());
				}
				result.add(bidRes);
			}
		}
		return result.toArray(new BidObject[result.size()]);
	}

	public String getAllAdGroupKeywords(String json) throws Exception
	{
		logger.debug("call getAllAdGroupKeywords(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));

		String[] res = getAllAdGroupKeywords(data.get("accountID"), adGroupID, Boolean.valueOf(data.get("ActiveOnly")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public String[] getAllAdGroupKeywords(String accountID, Long adGroupID, Boolean ActiveOnly) throws Exception
	{
		List<String> keywords = new ArrayList<String>();
		for (BidObject criterion : getAllBiddableAdGroupCriteria(accountID, adGroupID, ActiveOnly))
		{
			keywords.add(criterion.getKeyword());
		}
		return keywords.toArray(new String[keywords.size()]);
	}

	@Override
	public AdGroupAd[] getAdsByAdGroupId(String customerId, long adGroupId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteAD(String json) throws Exception
	{
		logger.debug("call deleteAd(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long AdID = Long.parseLong(data.get("AdID"));
		Boolean del = deleteAD(data.get("accountID"), adGroupID, AdID);
		// convert result to Json String
		return gson.toJson(del);
	}

	@Override
	public Boolean deleteAD(String accountID, Long adGroupID, Long AdID) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupAdService.
			AdGroupAdServiceInterface adGroupAdService = user.getService(AdWordsService.V201109.ADGROUP_AD_SERVICE);
			// Create base class ad to avoid setting type specific fields.
			Ad ad = new Ad();
			ad.setId(AdID.longValue());
			// Create ad group ad.
			AdGroupAd adGroupAd = new AdGroupAd();
			adGroupAd.setAdGroupId(adGroupID.longValue());
			adGroupAd.setAd(ad);
			// Create operations.
			AdGroupAdOperation operation = new AdGroupAdOperation();
			operation.setOperand(adGroupAd);
			operation.setOperator(Operator.REMOVE);
			AdGroupAdOperation[] operations = new AdGroupAdOperation[]
			{ operation };
			// Delete ad.
			AdGroupAdReturnValue result = adGroupAdService.mutate(operations);
			if (result != null && result.getValue() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String deleteAdGroup(String json) throws Exception
	{
		logger.debug("call deleteAdGroup(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Boolean del = deleteAdGroup(data.get("accountID"), adGroupID);
		// convert result to Json String
		return gson.toJson(del);
	}

	@Override
	public Boolean deleteAdGroup(String accountID, Long adGroupID) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupService.
			AdGroupServiceInterface adGroupService = user.getService(AdWordsService.V201109.ADGROUP_SERVICE);
			// Create ad group with DELETED status.
			AdGroup adGroup = new AdGroup();
			adGroup.setId(adGroupID.longValue());
			adGroup.setStatus(AdGroupStatus.DELETED);
			// Create operations.
			AdGroupOperation operation = new AdGroupOperation();
			operation.setOperand(adGroup);
			operation.setOperator(Operator.SET);
			AdGroupOperation[] operations = new AdGroupOperation[]
			{ operation };
			// Delete ad group.
			AdGroupReturnValue result = adGroupService.mutate(operations);
			// Display ad groups.
			if (result != null && result.getValue() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String updateAD(String json) throws Exception
	{
		logger.debug("call updateAD(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long AdID = Long.parseLong(data.get("AdID"));
		Boolean update = updateAD(data.get("accountID"), adGroupID, AdID, data.get("headline"), data.get("description1"), data.get("description2"),
				data.get("displayURL"), data.get("url"));
		// convert result to Json String
		return gson.toJson(update);
	}

	@Override
	public Boolean updateAD(String accountID, Long adGroupID, Long AdID, String headline, String description1, String description2,
			String displayURL, String url) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupAdService.
			AdGroupAdServiceInterface adGroupAdService = user.getService(AdWordsService.V201109.ADGROUP_AD_SERVICE);
			// Create ad with updated status.
			TextAd textAd = new TextAd();
			textAd.setId(AdID);
			textAd.setHeadline(headline);
			textAd.setDescription1(description1);
			textAd.setDescription2(description2);
			textAd.setDisplayUrl(displayURL);
			textAd.setUrl(url);
			//
			AdGroupAd adGroupAd = new AdGroupAd();
			adGroupAd.setAdGroupId(adGroupID.longValue());
			adGroupAd.setAd(textAd);
			adGroupAd.setStatus(AdGroupAdStatus.PAUSED);
			// Create operations.
			AdGroupAdOperation operation = new AdGroupAdOperation();
			operation.setOperand(adGroupAd);
			operation.setOperator(Operator.SET);
			AdGroupAdOperation[] operations = new AdGroupAdOperation[]
			{ operation };
			// Update ad.
			AdGroupAdReturnValue result = adGroupAdService.mutate(operations);
			if (result != null && result.getValue() != null)
			{
				// Update the AdGroup Status
				adGroupAd = new AdGroupAd();
				adGroupAd.setAdGroupId(adGroupID.longValue());
				adGroupAd.setStatus(AdGroupAdStatus.ENABLED);
				AdGroupAdOperation operation2 = new AdGroupAdOperation();
				operation.setOperand(adGroupAd);
				operation.setOperator(Operator.SET);
				AdGroupAdOperation[] operations2 = new AdGroupAdOperation[]
				{ operation2 };
				// Update ad.
				AdGroupAdReturnValue result2 = adGroupAdService.mutate(operations2);
				if (result2 != null && result2.getValue() != null)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String addKeyWordToAdGroup(String json) throws Exception
	{
		logger.debug("call addKeyWordToAdGroup" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long microBidAmount = Long.parseLong(data.get("microBidAmount"));
		BidObject res = addKeyWordToAdGroup(data.get("accountID"), adGroupID, data.get("keyword"),
				KeywordMatchType.fromString(data.get("matchType")), microBidAmount);

		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public BidObject addKeyWordToAdGroup(String accountID, Long adGroupID, String keyword, KeywordMatchType matchType, Long microBidAmount)
			throws Exception
	{
		try{
			// AdWordsServiceLogger.log(); //SOAP XML Logger
	
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupCriterionService.
			AdGroupCriterionServiceInterface adGroupCriterionService = user.getService(AdWordsService.V201109.ADGROUP_CRITERION_SERVICE);
			// Create keyword.
			Keyword keywrd = new Keyword();
			keywrd.setText(keyword);
			keywrd.setMatchType(matchType);
			// Create biddable ad group criterion.
			BiddableAdGroupCriterion keywordBiddableAdGroupCriterion = new BiddableAdGroupCriterion();
			keywordBiddableAdGroupCriterion.setAdGroupId(adGroupID);
			keywordBiddableAdGroupCriterion.setCriterion(keywrd);
			// add bid amount
			ManualCPCAdGroupCriterionBids bid = new ManualCPCAdGroupCriterionBids();
			bid.setMaxCpc(new Bid(new Money(null, microBidAmount)));
			keywordBiddableAdGroupCriterion.setBids(bid);
			// Create operations.
			AdGroupCriterionOperation keywordAdGroupCriterionOperation = new AdGroupCriterionOperation();
			keywordAdGroupCriterionOperation.setOperand(keywordBiddableAdGroupCriterion);
			keywordAdGroupCriterionOperation.setOperator(Operator.ADD);
			AdGroupCriterionOperation[] operations = new AdGroupCriterionOperation[]
			{ keywordAdGroupCriterionOperation };
			// Add ad group criteria.
			AdGroupCriterionReturnValue result = adGroupCriterionService.mutate(operations);
			// Display ad group criteria.
			if (result != null && result.getValue() != null && (result.getValue(0) instanceof BiddableAdGroupCriterion))
			{
				BiddableAdGroupCriterion res = (BiddableAdGroupCriterion) result.getValue(0);
				BidObject bidRes = new BidObject();
				if (res.getQualityInfo() != null)
				{
					bidRes.setQualityScore(res.getQualityInfo().getQualityScore());
				}
				if (res.getFirstPageCpc() != null)
				{
					bidRes.setFirstPageCpc(res.getFirstPageCpc().getAmount().getMicroAmount());
				}
				bidRes.setBidID(res.getCriterion().getId());
				bidRes.setApprovalStatus(res.getApprovalStatus().getValue());
				bidRes.setKeyword(keyword);
				bidRes.setMatchType(matchType.getValue());
				bidRes.setMicroBidAmount(((ManualCPCAdGroupCriterionBids) res.getBids()).getMaxCpc().getAmount().getMicroAmount());
				return bidRes;
			}
			else
			{
				return new BidObject();
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String setBidForKeyWord(String json) throws Exception
	{
		logger.debug("call setBidForKeyWord" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long keywordID = Long.parseLong(data.get("keywordID"));
		Long microBidAmount = Long.parseLong(data.get("microBidAmount"));
		BidObject res = setBidForKeyWord(data.get("accountID"), keywordID, adGroupID, microBidAmount);
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public BidObject setBidForKeyWord(String accountID, Long keywordID, Long adGroupID, Long microBidAmount) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupCriterionService.
			AdGroupCriterionServiceInterface adGroupCriterionService = user.getService(AdWordsService.V201109.ADGROUP_CRITERION_SERVICE);
			// Create ad group criterion with updated bid.
			Criterion criterion = new Criterion();
			criterion.setId(keywordID);
			BiddableAdGroupCriterion biddableAdGroupCriterion = new BiddableAdGroupCriterion();
			biddableAdGroupCriterion.setAdGroupId(adGroupID);
			biddableAdGroupCriterion.setCriterion(criterion);
			// Create bids.
			ManualCPCAdGroupCriterionBids bids = new ManualCPCAdGroupCriterionBids();
			bids.setMaxCpc(new Bid(new Money(null, microBidAmount)));
			biddableAdGroupCriterion.setBids(bids);
			// Create operations.
			AdGroupCriterionOperation operation = new AdGroupCriterionOperation();
			operation.setOperand(biddableAdGroupCriterion);
			operation.setOperator(Operator.SET);
			AdGroupCriterionOperation[] operations = new AdGroupCriterionOperation[]
			{ operation };
			// Update ad group criteria.
			AdGroupCriterionReturnValue result = adGroupCriterionService.mutate(operations);
			// Display ad group criteria.
			if (result != null && result.getValue() != null && (result.getValue(0) instanceof BiddableAdGroupCriterion))
			{
				BiddableAdGroupCriterion res = (BiddableAdGroupCriterion) result.getValue(0);
				Keyword keyword = ((Keyword) res.getCriterion());
				BidObject bidRes = new BidObject();
				if (res.getQualityInfo() != null)
				{
					bidRes.setQualityScore(res.getQualityInfo().getQualityScore());
				}
				if (res.getFirstPageCpc() != null)
				{
					bidRes.setFirstPageCpc(res.getFirstPageCpc().getAmount().getMicroAmount());
				}
				bidRes.setBidID(res.getCriterion().getId());
				bidRes.setApprovalStatus(res.getApprovalStatus().getValue());
				bidRes.setMicroBidAmount(((ManualCPCAdGroupCriterionBids) res.getBids()).getMaxCpc().getAmount().getMicroAmount());
				bidRes.setKeyword(keyword.getText());
				return bidRes;
			}
			else
			{
				return new BidObject();
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	/*
	 * Campaign
	 */

	public String CreateOneCampaignForAccount(String json) throws Exception
	{
		logger.debug("call CreateOneAccountService(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Money budget = new Money(null, Long.parseLong(data.get("budgetAmount"))); // set
																					// MicroAmount
		Campaign campaign = CreateOneCampaignForAccount(data.get("accountID"), data.get("campaignName"),
				CampaignStatus.fromString(data.get("campaignStatus")), BudgetBudgetPeriod.fromString(data.get("period")), budget);
		// convert result to Json String
		return gson.toJson(campaign);
	}

	@Override
	public Campaign CreateOneCampaignForAccount(String accountID, String campaignName, CampaignStatus campaignStatus, BudgetBudgetPeriod period,
			Money budgetAmount) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
	
			CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);
			Campaign campaign = new Campaign();
			campaign.setName(campaignName);
			if (campaignStatus == null)
			{
				campaignStatus = CampaignStatus.PAUSED;
			}
			campaign.setStatus(campaignStatus);
			campaign.setBiddingStrategy(new ManualCPC());
	
			Budget budget = new Budget();
			if (period == null)
			{
				period = BudgetBudgetPeriod.MONTHLY;
			}
			budget.setPeriod(period);
			budget.setAmount(budgetAmount);
			budget.setDeliveryMethod(BudgetBudgetDeliveryMethod.STANDARD);
			campaign.setBudget(budget);
	
			CampaignOperation Coperation = new CampaignOperation();
			Coperation.setOperand(campaign);
	
			Coperation.setOperator(Operator.ADD);
			CampaignOperation[] Coperations = new CampaignOperation[]
			{ Coperation };
	
			CampaignReturnValue Cresult = campaignService.mutate(Coperations);
	
			if (Cresult != null && Cresult.getValue() != null)
			{
				return Cresult.getValue()[0];
			}
			else
			{
				System.out.println("No campaigns were added.");
				return null;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String getAdGroupsByCampaignId(String json) throws Exception
	{
		logger.debug("call getCampaignsByAccountId" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long campaignID = Long.parseLong(data.get("campaignID"));
		GoogleAdGroupObject[] res = getAdGroupsByCampaignId(data.get("accountID"), campaignID, Boolean.valueOf(data.get("includeDeleted")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public GoogleAdGroupObject[] getAdGroupsByCampaignId(String accountID, Long campaignID, Boolean includeDeleted) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupService.
			AdGroupServiceInterface adGroupService = user.getService(AdWordsService.V201109.ADGROUP_SERVICE);
			// Create selector.
			Selector selector = new Selector();
			selector.setFields(new String[]
			{ "Id", "Name" });
			selector.setOrdering(new OrderBy[]
			{ new OrderBy("Name", SortOrder.ASCENDING) });
			// Create predicates.
			Predicate campaignIdPredicate = new Predicate("CampaignId", PredicateOperator.IN, new String[]
			{ campaignID.toString() });
			selector.setPredicates(new Predicate[]
			{ campaignIdPredicate });
			// Get all ad groups.
			AdGroupPage page = adGroupService.get(selector);
			AdGroup[] pages = page.getEntries();
			GoogleAdGroupObject[] res =
			{ new GoogleAdGroupObject() };
			if (pages.length > 0)
			{
				res = new GoogleAdGroupObject[pages.length];
				for (int i = 0; i < pages.length; i++)
				{
					GoogleAdGroupObject obj = new GoogleAdGroupObject();
					obj.setAdGroupID(pages[i].getId());
					obj.setAdGroupName(pages[i].getName());
					obj.setCampaignId(pages[i].getCampaignId());
					obj.setCampaignName(pages[i].getCampaignName());
					/*
					 * adGroupStats s = obj.new adGroupStats(); if
					 * (pages[i].getStats().getAverageCpc() != null) {
					 * s.setAverageCpc
					 * (pages[i].getStats().getAverageCpc().getMicroAmount()); } if
					 * (pages[i].getStats().getAverageCpm() != null) {
					 * s.setAverageCpm
					 * (pages[i].getStats().getAverageCpm().getMicroAmount()); }
					 * s.setAveragePosition
					 * (pages[i].getStats().getAveragePosition());
					 * s.setAvgCallDurationSecs
					 * (pages[i].getStats().getAvgCallDurationSecs());
					 * s.setClicks(pages[i].getStats().getClicks());
					 * s.setConversionRate(pages[i].getStats().getConversionRate());
					 * if (pages[i].getStats().getCost() != null) {
					 * s.setCost(pages[i].getStats().getCost().getMicroAmount()); }
					 * if (pages[i].getStats().getCostPerConversion() != null) {
					 * s.setCostPerConversion
					 * (pages[i].getStats().getCostPerConversion
					 * ().getMicroAmount()); }
					 * s.setCtr(pages[i].getStats().getCtr()); obj.setStats(s);
					 */
					obj.setStatus(pages[i].getStatus());
					res[i] = obj;
				}
			}
	
			return res;
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String deleteCampaign(String json) throws Exception
	{
		logger.debug("call deleteCampaign" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long campaignID = Long.parseLong(data.get("campaignID"));
		Boolean res = deleteCampaign(data.get("accountID"), campaignID);
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public Boolean deleteCampaign(String accountID, Long campaignID) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the CampaignService.
			CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);
	
			// Create campaign with DELETED status.
			Campaign campaign = new Campaign();
			campaign.setId(campaignID.longValue());
			campaign.setStatus(CampaignStatus.DELETED);
			// Create operations.
			CampaignOperation operation = new CampaignOperation();
			operation.setOperand(campaign);
			operation.setOperator(Operator.SET);
			CampaignOperation[] operations = new CampaignOperation[]
			{ operation };
			// Delete campaign.
			CampaignReturnValue result = campaignService.mutate(operations);
			// Display campaigns.
			if (result != null && result.getValue() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String changeCampaignStatus(String json) throws Exception
	{
		logger.debug("call changeCampaignStatus" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long campaignID = Long.parseLong(data.get("campaignID"));
		Boolean res = changeCampaignStatus(data.get("accountID"), campaignID, CampaignStatus.fromString(data.get("status")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public Boolean changeCampaignStatus(String accountID, Long campaignID, CampaignStatus status) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_TARGET_SERVICE);
			CampaignOperation[] operations = getCampaignOp(campaignID, Operator.SET);
			CampaignReturnValue ret = campaignService.mutate(operations);
			if (ret != null && ret.getValue() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String changeCampaignBudget(String json) throws Exception
	{
		logger.debug("call changeCampaignStatus" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long campaignID = Long.parseLong(data.get("campaignID"));
		Boolean res = changeCampaignBudget(data.get("accountID"), campaignID, new Money(null, Long.valueOf(data.get("budgetAmount"))));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public Boolean changeCampaignBudget(String accountID, Long campaignID, Money budgetAmount) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_TARGET_SERVICE);
			Budget budget = new Budget();
			budget.setPeriod(BudgetBudgetPeriod.DAILY);
			budget.setAmount(budgetAmount);
			budget.setDeliveryMethod(BudgetBudgetDeliveryMethod.STANDARD);
			CampaignOperation[] operations = getCampaignOp(campaignID, Operator.SET);
			CampaignReturnValue ret = campaignService.mutate(operations);
			if (ret != null && ret.getValue() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String getCampaignsByAccountId(String json) throws Exception
	{
		logger.debug("call getCampaignsByAccountId" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		ArrayList<HashMap<String, String>> res = getCampaignsByAccountId(data.get("accountID"), Boolean.valueOf(data.get("includeDeleted")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public ArrayList<HashMap<String, String>> getCampaignsByAccountId(String accountID, Boolean includeDeleted) throws Exception
	{
		try{

			// AdWordsServiceLogger.log(); //SOAP XML Logger
	
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);
	
			// Create selector.
			Selector selectActiveAndPausedCampaigns = new Selector();
			selectActiveAndPausedCampaigns.setFields(new String[]
			{ "Id", "Name", "Status", "Amount" });
			// TODO should only be returning Id, Name and Status from this method
			// not Campaign[]
	
			if (!includeDeleted)
			{
				selectActiveAndPausedCampaigns.setPredicates(new Predicate[]
				{ new Predicate("Status", PredicateOperator.IN, new String[]
				{ CampaignStatus.ACTIVE.getValue(), CampaignStatus.PAUSED.getValue() }) });
			}
			CampaignPage page = campaignService.get(selectActiveAndPausedCampaigns);
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (page.getEntries() != null)
			{
				for (Campaign campaign : page.getEntries())
				{
					HashMap<String, String> row = new HashMap<String, String>();
					row.put("Id", String.valueOf(campaign.getId()));
					row.put("Name", campaign.getName());
					row.put("Status", campaign.getStatus().getValue());
					row.put("Amount", String.valueOf(campaign.getBudget().getAmount().getMicroAmount()));
					list.add(row);
				}
	
			}
			return list;
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String UpdateCampaignName(String json) throws Exception
	{
		logger.debug("call UpdateCampaignName" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long campaignID = Long.parseLong(data.get("campaignID"));
		Boolean res = UpdateCampaignName(data.get("accountID"), campaignID, data.get("newName"));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public Boolean UpdateCampaignName(String accountID, Long campaignID, String newName) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);
			CampaignOperation[] operations = getCampaignOp(campaignID, Operator.SET);
			operations[0].getOperand().setName(newName);
			CampaignReturnValue ret = campaignService.mutate(operations);
			if (ret != null && ret.getValue() != null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	private CampaignOperation[] getCampaignOp(Long campaignID, Operator op)
	{
		Campaign campaign = new Campaign();
		campaign.setId(campaignID.longValue());

		CampaignOperation operation = new CampaignOperation();
		operation.setOperand(campaign);
		operation.setOperator(op);
		return new CampaignOperation[]
		{ operation };
	}

	/*
	 * Keywords
	 */
	public String GetRelatedKeywords(String json) throws Exception
	{
		logger.debug("call GetRelatedKeywords" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		GoogleRelatedKeywordObject res = GetRelatedKeywords(data.get("keyword"), KeywordMatchType.fromString(data.get("matchType")),
				Integer.parseInt(data.get("numberResults")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public GoogleRelatedKeywordObject GetRelatedKeywords(String keyword, KeywordMatchType matchType, int numberResults) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, null, userAgent, developerToken, useSandbox);
			// Get the TargetingIdeaService.
			TargetingIdeaServiceInterface targetingIdeaService = user.getService(AdWordsService.V201109.TARGETING_IDEA_SERVICE);
			// Create seed keyword.
			Keyword keywrd = new Keyword();
			keywrd.setText(keyword);
			keywrd.setMatchType(matchType);
			// Create selector.
			TargetingIdeaSelector selector = new TargetingIdeaSelector();
			selector.setRequestType(RequestType.IDEAS);
			selector.setIdeaType(IdeaType.KEYWORD);
			selector.setRequestedAttributeTypes(new AttributeType[]
			{ AttributeType.CRITERION, AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES, AttributeType.COMPETITION });
			// Set selector paging (required for targeting idea service).
			Paging paging = new Paging();
			paging.setStartIndex(0);
			paging.setNumberResults(numberResults);
			selector.setPaging(paging);
			// Create related to keyword search parameter.
			RelatedToKeywordSearchParameter relatedToKeywordSearchParameter = new RelatedToKeywordSearchParameter();
			relatedToKeywordSearchParameter.setKeywords(new Keyword[]
			{ keywrd });
			// Create keyword match type search parameter to ensure unique results.
			KeywordMatchTypeSearchParameter keywordMatchTypeSearchParameter = new KeywordMatchTypeSearchParameter();
			keywordMatchTypeSearchParameter.setKeywordMatchTypes(new KeywordMatchType[]
			{ matchType });
			selector.setSearchParameters(new SearchParameter[]
			{ relatedToKeywordSearchParameter, keywordMatchTypeSearchParameter });
			// Get related keywords.
			TargetingIdeaPage page = targetingIdeaService.get(selector);
			if (page != null && page.getEntries() != null)
			{
				GoogleRelatedKeywordObject keyObj = new GoogleRelatedKeywordObject(keyword, null);
	
				for (TargetingIdea targetingIdea : page.getEntries())
				{
					Map<AttributeType, Attribute> data = MapUtils.toMap(targetingIdea.getData());
					Keyword kw = (Keyword) ((CriterionAttribute) data.get(AttributeType.CRITERION)).getValue();
					Long averageMonthlySearches = ((LongAttribute) data.get(AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES)).getValue();
					Double comp = ((DoubleAttribute) data.get(AttributeType.COMPETITION)).getValue();
					keyObj.addKeywordData(kw.getText(), kw.getMatchType().getValue(), averageMonthlySearches, comp);
				}
				return keyObj;
			}
			else
			{
				return new GoogleRelatedKeywordObject(keyword, null);
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}

	}

	public String GetRelatedKeywordsForURL(String json) throws Exception
	{
		logger.debug("call GetRelatedKeywords" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		GoogleRelatedKeywordObject res = GetRelatedKeywordsForURL(data.get("url"), data.get("keyword"),
				KeywordMatchType.fromString(data.get("matchType")), Integer.parseInt(data.get("numberResults")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public GoogleRelatedKeywordObject GetRelatedKeywordsForURL(String url, String keyword, KeywordMatchType matchType, int numberResults)
			throws Exception
	{
		try{
			// Specifically you would use the RelatedToUrlSearchParameter, ideaType
			// of KEYWORD, and requestType of IDEAS
			// TODO Auto-generated method stub
			AdWordsUser user = new AdWordsUser(email, password, null, userAgent, developerToken, useSandbox);
			// Get the TargetingIdeaService.
			TargetingIdeaServiceInterface targetingIdeaService = user.getService(AdWordsService.V201109.TARGETING_IDEA_SERVICE);
			// Create selector.
			TargetingIdeaSelector selector = new TargetingIdeaSelector();
			selector.setRequestType(RequestType.IDEAS);
			selector.setIdeaType(IdeaType.KEYWORD);
			selector.setRequestedAttributeTypes(new AttributeType[]
			{ AttributeType.CRITERION, AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES, AttributeType.COMPETITION }); // AttributeType.APPROX_CONTENT_IMPRESSIONS_PER_DAY,
			// });
			// Set selector paging (required for targeting idea service).
			Paging paging = new Paging();
			paging.setStartIndex(0);
			paging.setNumberResults(numberResults);
			selector.setPaging(paging);
			Keyword keywrd = new Keyword();
			keywrd.setText(keyword);
			keywrd.setMatchType(matchType);
			// Create related to keyword search parameter.
			RelatedToKeywordSearchParameter relatedToKeywordSearchParameter = new RelatedToKeywordSearchParameter();
			relatedToKeywordSearchParameter.setKeywords(new Keyword[]
			{ keywrd });
			// Create related to URL search parameter.
			RelatedToUrlSearchParameter relatedToUrlSearchParameter = new RelatedToUrlSearchParameter();
			relatedToUrlSearchParameter.setUrls(new String[]
			{ url });
			// relatedToUrlSearchParameter.setIncludeSubUrls(true);
			selector.setSearchParameters(new SearchParameter[]
			{ relatedToKeywordSearchParameter, relatedToUrlSearchParameter }); // ,
			// Get related placements.
			TargetingIdeaPage page = targetingIdeaService.get(selector);
			if (page != null && page.getEntries() != null)
			{
				GoogleRelatedKeywordObject keyObj = new GoogleRelatedKeywordObject(keyword, null);
	
				for (TargetingIdea targetingIdea : page.getEntries())
				{
					Map<AttributeType, Attribute> data = MapUtils.toMap(targetingIdea.getData());
					Keyword kw = (Keyword) ((CriterionAttribute) data.get(AttributeType.CRITERION)).getValue();
					Long averageMonthlySearches = ((LongAttribute) data.get(AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES)).getValue();
					Double comp = ((DoubleAttribute) data.get(AttributeType.COMPETITION)).getValue();
					keyObj.addKeywordData(kw.getText(), kw.getMatchType().getValue(), averageMonthlySearches, comp);
				}
				return keyObj;
			}
			else
			{
				return new GoogleRelatedKeywordObject(keyword, null);
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String getTrafficEstimationForOneKeyword(String json) throws Exception
	{
		logger.debug("call getTrafficEstimationForOneKeyword" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		HashMap<String, Double> KeywordWithBid = gson.fromJson(data.get("KeywordWithBid"), HashMap.class);
		Long campaignID = Long.parseLong(data.get("campaignID"));
		// String accountID, Long campaignID, KeywordMatchType matchType,
		// HashMap<String, ArrayList<Double>> KeywordWithBid
		TrafficEstimatorObject res = getTrafficEstimationForKeywords(data.get("accountID"), campaignID,
				KeywordMatchType.fromString(data.get("matchType")), KeywordWithBid);
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public TrafficEstimatorObject getTrafficEstimationForKeywords(String accountID, Long campaignID, KeywordMatchType matchType,
			HashMap<String, Double> KeywordWithBid) throws Exception
	{
		try{
			AdWordsServiceLogger.log();
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			List<AdGroupEstimateRequest> adGroupEstimateRequests = new ArrayList<AdGroupEstimateRequest>();
			ArrayList<KeywordEstimateRequest> keywordEstimateRequests = new ArrayList<KeywordEstimateRequest>();
	
			// Get the TrafficEstimatorService.
			TrafficEstimatorServiceInterface trafficEstimatorService = user.getService(AdWordsService.V201109.TRAFFIC_ESTIMATOR_SERVICE);
	
			// for each keyword
			String[] keywords = KeywordWithBid.keySet().toArray(new String[] {});
	
			for (int i = 0; i < keywords.length; i++)
			{
	
				String keyword = keywords[i];
				// Use same keyword
				Keyword keywrd = new Keyword();
				keywrd.setText(keyword);
				keywrd.setMatchType(matchType);
				// Sets up one Campaign EStimate for each Keyword/bid - Campaign
				// budget
				// is unlimited
				Double bidamount = KeywordWithBid.get(keyword);
	
				if (bidamount != null)
				{
					// one keyword estimate request
					KeywordEstimateRequest keywordEstimateRequest = new KeywordEstimateRequest();
					keywordEstimateRequest.setKeyword(keywrd);
					keywordEstimateRequest.setMaxCpc(new Money(null, new Long((long) (bidamount * 1000000.0))));
					keywordEstimateRequests.add(keywordEstimateRequest);
				}
			}
			AdGroupEstimateRequest adGroupEstimateRequest = new AdGroupEstimateRequest();
			adGroupEstimateRequest.setKeywordEstimateRequests(keywordEstimateRequests.toArray(new KeywordEstimateRequest[]
					{ }));
					
			adGroupEstimateRequests.add(adGroupEstimateRequest);
					
			CampaignEstimateRequest campaignEstimateRequest = new CampaignEstimateRequest();
			campaignEstimateRequest.setAdGroupEstimateRequests(adGroupEstimateRequests.toArray(new AdGroupEstimateRequest[]
			{}));
			campaignEstimateRequest.setCampaignId(campaignID);
			Language english = new Language();
			english.setId(1000L);
			campaignEstimateRequest.setCriteria(new Criterion[]
			{ english });
			// Create selector.
			TrafficEstimatorSelector selector = new TrafficEstimatorSelector();
			selector.setCampaignEstimateRequests(new CampaignEstimateRequest[]
			{ campaignEstimateRequest });
			// Get traffic estimates.
	
			TrafficEstimatorResult result = trafficEstimatorService.get(selector);
			// Display traffic estimates.
			if (result != null && result.getCampaignEstimates() != null)
			{
				TrafficEstimatorObject estimatorObj = new TrafficEstimatorObject();
				KeywordEstimate[] keywordEstimates = result.getCampaignEstimates()[0].getAdGroupEstimates()[0].getKeywordEstimates();
				
					
					for (int i = 0; i < keywordEstimates.length; i++)
					{
						
						StatsEstimate min = keywordEstimates[i].getMin();
						StatsEstimate max = keywordEstimates[i].getMax();
						estimatorObj.setBidData(adGroupEstimateRequests.get(0).getKeywordEstimateRequests()[i].getKeyword().getText(), Double.valueOf(adGroupEstimateRequests.get(0).getKeywordEstimateRequests()[i].getMaxCpc().getMicroAmount()),
						min.getAverageCpc().getMicroAmount(), max.getAverageCpc().getMicroAmount(),min.getAveragePosition(), max.getAveragePosition(), min.getClicksPerDay(), max.getClicksPerDay(),
						min.getTotalCost().getMicroAmount(),max.getTotalCost().getMicroAmount());
					}
				
				return estimatorObj;
			}
			else
			{
	
				return new TrafficEstimatorObject();
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}

	}

	public String getBidLandscapeForKeyword(String json) throws Exception
	{
		logger.debug("call  getBidLandscapeForKeyword" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long keywordID = Long.parseLong(data.get("keywordID"));
		BidSimulatorObject[] res = getBidLandscapeForKeyword(data.get("accountID"), adGroupID, keywordID);
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public BidSimulatorObject[] getBidLandscapeForKeyword(String accountID, Long adGroupID, Long keywordID) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the DataService.
			DataServiceInterface dataService = user.getService(AdWordsService.V201109.DATA_SERVICE);
	
			// Create selector.
			Selector selector = new Selector();
			selector.setFields(new String[]
			{ "AdGroupId", "CriterionId", "StartDate", "EndDate", "Bid", "LocalClicks", "LocalCost", "MarginalCpc", "LocalImpressions" });
			// Create predicates.
			Predicate adGroupIdPredicate = new Predicate("AdGroupId", PredicateOperator.IN, new String[]
			{ adGroupID.toString() });
	
			Predicate criterionIdPredicate = new Predicate("CriterionId", PredicateOperator.IN, new String[]
			{ keywordID.toString() });
			selector.setPredicates(new Predicate[]
			{ adGroupIdPredicate, criterionIdPredicate });
	
			// Get bid landscape for ad group criteria.
			CriterionBidLandscapePage page = dataService.getCriterionBidLandscape(selector);
			// Display bid landscapes.
			BidSimulatorObject[] res;
			if (page.getEntries() != null && page.getEntries().length > 0)
			{
				res = new BidSimulatorObject[page.getEntries().length];
				int i = 0;
				for (CriterionBidLandscape criterionBidLandscape : page.getEntries())
				{
					BidSimulatorObject obj = new BidSimulatorObject();
					obj.setAdGroupId(criterionBidLandscape.getAdGroupId());
					obj.setCriterionId(criterionBidLandscape.getCriterionId());
					obj.setEndDate(criterionBidLandscape.getEndDate());
					obj.setStartDate(criterionBidLandscape.getStartDate());
	
					for (BidLandscapeLandscapePoint bidLanscapePoint : criterionBidLandscape.getLandscapePoints())
					{
						obj.addBidPoint(bidLanscapePoint.getBid().getMicroAmount(), bidLanscapePoint.getClicks(), bidLanscapePoint.getCost()
								.getMicroAmount(), bidLanscapePoint.getMarginalCpc().getMicroAmount(), bidLanscapePoint.getImpressions());
					}
					res[i] = obj;
					i++;
				}
			}
			else
			{
				res = new BidSimulatorObject[0];
				logger.info("No criterion bid landscapes were found.");
			}
			return res;
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}

	}

	public String getBidLandscapeForAdgroup(String json) throws Exception
	{
		logger.debug("call  getBidLandscapeForAdgroup" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		BidSimulatorObject[] res = getBidLandscapeForAdgroup(data.get("accountID"), adGroupID);
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public BidSimulatorObject[] getBidLandscapeForAdgroup(String accountID, Long adGroupID) throws Exception
	{
		try{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the DataService.
			DataServiceInterface dataService = user.getService(AdWordsService.V201109.DATA_SERVICE);
	
			// Create selector.
			Selector selector = new Selector();
			selector.setFields(new String[]
			{ "AdGroupId", "LandscapeType", "LandscapeCurrent", "StartDate", "EndDate", "Bid", "LocalClicks", "LocalCost", "MarginalCpc",
					"LocalImpressions" });
			// Create predicates.
			Predicate adGroupIdPredicate = new Predicate("AdGroupId", PredicateOperator.IN, new String[]
			{ adGroupID.toString() });
			selector.setPredicates(new Predicate[]
			{ adGroupIdPredicate });
			// Get bid landscape for ad group criteria.
			AdGroupBidLandscapePage page = dataService.getAdGroupBidLandscape(selector);
			BidSimulatorObject[] res;
			if (page.getEntries() != null && page.getEntries().length > 0)
			{
				res = new BidSimulatorObject[page.getEntries().length];
				int i = 0;
				for (AdGroupBidLandscape adGroupBidLandscape : page.getEntries())
				{
					BidSimulatorObject obj = new BidSimulatorObject();
					obj.setAdGroupId(adGroupBidLandscape.getAdGroupId());
					obj.setEndDate(adGroupBidLandscape.getEndDate());
					obj.setStartDate(adGroupBidLandscape.getStartDate());
	
					for (BidLandscapeLandscapePoint bidLanscapePoint : adGroupBidLandscape.getLandscapePoints())
					{
						obj.addBidPoint(bidLanscapePoint.getBid().getMicroAmount(), bidLanscapePoint.getClicks(), bidLanscapePoint.getCost()
								.getMicroAmount(), bidLanscapePoint.getMarginalCpc().getMicroAmount(), bidLanscapePoint.getImpressions());
					}
					res[i] = obj;
					i++;
				}
			}
			else
			{
				res = new BidSimulatorObject[0];
				logger.info("No Adgroup bid landscapes were found.");
			}
			return res;
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiFault e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	private static final String DEFINITION = "<reportDefinition><selector><fields>Date</fields>"
			+ "<fields>CampaignId</fields><fields>Id</fields><fields>HourOfDay</fields>"
			+ "<fields>Impressions</fields><fields>Clicks</fields><fields>Cost</fields>"
			+ "</selector><reportName>Custom ADGROUP_PERFORMANCE_REPORT for testing</reportName>"
			+ "<reportType>ADGROUP_PERFORMANCE_REPORT</reportType>"
			+ "<dateRangeType>LAST_7_DAYS</dateRangeType><downloadFormat>CSV</downloadFormat>" + "</reportDefinition>";
	private static final String KEYWORD_DEFINITION = "<reportDefinition><selector><fields>Date</fields>"
			+ "<fields>AdGroupId</fields><fields>Id</fields><fields>KeywordText</fields><fields>KeywordMatchType</fields>"
			+ "<fields>Impressions</fields><fields>Clicks</fields><fields>Cost</fields><fields>QualityScore</fields>"
			+ "<fields>AverageCpc</fields><fields>AveragePosition</fields><fields>CampaignId</fields><fields>Ctr</fields><fields>FirstPageCpc</fields><fields>MaxCpc</fields>"
			+ "</selector><reportName>KEYWORDS_PERFORMANCE_REPORT</reportName>" + "<reportType>KEYWORDS_PERFORMANCE_REPORT</reportType>"
			+ "<dateRangeType>ALL_TIME</dateRangeType><downloadFormat>CSV</downloadFormat>" + "</reportDefinition>";

	public File getReportForAccount(String accountID) throws MalformedURLException, HttpException, IOException, AuthTokenException
	{
		// ReportDefinitionDateRangeType.ALL_TIME;
		GoogleReportDownloader report = new GoogleReportDownloader(KEYWORD_DEFINITION, new Long(accountID));//
		return report.downloadReport(new AuthToken(email, password).getAuthToken(), developerToken);
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub

	}

}
