package semplest.service.google.adwords;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.other.DateTimeCeiling;
import semplest.other.DateTimeFloored;
import semplest.server.encryption.AESBouncyCastle;
import semplest.server.keyword.KeywordMatchingType;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.BidSimulatorObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleRelatedKeywordObject;
import semplest.server.protocol.google.GoogleSiteLink;
import semplest.server.protocol.google.KeywordToolStats;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.GoogleAdwordsServiceInterface;
import semplest.util.SemplestUtils;

import com.google.api.adwords.lib.AdWordsService;
import com.google.api.adwords.lib.AdWordsServiceLogger;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.lib.AuthToken;
import com.google.api.adwords.lib.utils.MapUtils;
import com.google.api.adwords.v201109.cm.Ad;
import com.google.api.adwords.v201109.cm.AdGroup;
import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupAdOperation;
import com.google.api.adwords.v201109.cm.AdGroupAdReturnValue;
import com.google.api.adwords.v201109.cm.AdGroupAdServiceInterface;
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
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.Bid;
import com.google.api.adwords.v201109.cm.BidLandscapeLandscapePoint;
import com.google.api.adwords.v201109.cm.BiddableAdGroupCriterion;
import com.google.api.adwords.v201109.cm.Budget;
import com.google.api.adwords.v201109.cm.BudgetBudgetDeliveryMethod;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignCriterion;
import com.google.api.adwords.v201109.cm.CampaignCriterionOperation;
import com.google.api.adwords.v201109.cm.CampaignCriterionReturnValue;
import com.google.api.adwords.v201109.cm.CampaignCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.CampaignOperation;
import com.google.api.adwords.v201109.cm.CampaignPage;
import com.google.api.adwords.v201109.cm.CampaignReturnValue;
import com.google.api.adwords.v201109.cm.CampaignServiceInterface;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.Criterion;
import com.google.api.adwords.v201109.cm.CriterionBidLandscape;
import com.google.api.adwords.v201109.cm.CriterionBidLandscapePage;
import com.google.api.adwords.v201109.cm.DataServiceInterface;
import com.google.api.adwords.v201109.cm.DateRange;
import com.google.api.adwords.v201109.cm.Keyword;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.cm.Language;
import com.google.api.adwords.v201109.cm.Location;
import com.google.api.adwords.v201109.cm.ManualCPC;
import com.google.api.adwords.v201109.cm.ManualCPCAdGroupBids;
import com.google.api.adwords.v201109.cm.ManualCPCAdGroupCriterionBids;
import com.google.api.adwords.v201109.cm.Money;
import com.google.api.adwords.v201109.cm.NegativeCampaignCriterion;
import com.google.api.adwords.v201109.cm.NetworkSetting;
import com.google.api.adwords.v201109.cm.Operator;
import com.google.api.adwords.v201109.cm.OrderBy;
import com.google.api.adwords.v201109.cm.Paging;
import com.google.api.adwords.v201109.cm.Predicate;
import com.google.api.adwords.v201109.cm.PredicateOperator;
import com.google.api.adwords.v201109.cm.Selector;
import com.google.api.adwords.v201109.cm.SortOrder;
import com.google.api.adwords.v201109.cm.TextAd;
import com.google.api.adwords.v201109.info.ApiUsageInfo;
import com.google.api.adwords.v201109.info.ApiUsageRecord;
import com.google.api.adwords.v201109.info.ApiUsageType;
import com.google.api.adwords.v201109.info.InfoSelector;
import com.google.api.adwords.v201109.info.InfoServiceInterface;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.api.adwords.v201109.mcm.CreateAccountOperation;
import com.google.api.adwords.v201109.mcm.CreateAccountServiceInterface;
import com.google.api.adwords.v201109.o.AdGroupEstimateRequest;
import com.google.api.adwords.v201109.o.Attribute;
import com.google.api.adwords.v201109.o.AttributeType;
import com.google.api.adwords.v201109.o.CampaignEstimateRequest;
import com.google.api.adwords.v201109.o.CategoryProductsAndServicesSearchParameter;
import com.google.api.adwords.v201109.o.CriterionAttribute;
import com.google.api.adwords.v201109.o.DoubleAttribute;
import com.google.api.adwords.v201109.o.ExcludedKeywordSearchParameter;
import com.google.api.adwords.v201109.o.IdeaType;
import com.google.api.adwords.v201109.o.KeywordEstimate;
import com.google.api.adwords.v201109.o.KeywordEstimateRequest;
import com.google.api.adwords.v201109.o.KeywordMatchTypeSearchParameter;
import com.google.api.adwords.v201109.o.LocationSearchParameter;
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
import com.google.api.adwords.v201109_1.billing.BudgetOrder;
import com.google.api.adwords.v201109_1.billing.BudgetOrderOperation;
import com.google.api.adwords.v201109_1.billing.BudgetOrderReturnValue;
import com.google.api.adwords.v201109_1.billing.BudgetOrderServiceInterface;
import com.google.api.adwords.v201109_1.cm.AdExtension;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtension;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionOperation;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionPage;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionReturnValue;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionServiceInterface;
import com.google.api.adwords.v201109_1.cm.Sitelink;
import com.google.api.adwords.v201109_1.cm.SitelinksExtension;
import com.google.gson.Gson;

public class GoogleAdwordsServiceImpl implements GoogleAdwordsServiceInterface
{
	private static final Logger logger = Logger.getLogger(GoogleAdwordsServiceImpl.class);
	private static Gson gson = new Gson();
	// THis needs to be read from the Database
	private final String email; // = "adwords@semplest.com";
	private final String password; // = "ic0system";
	private final String userAgent; // = "Icosystem";
	private final String developerToken; // = "2H8l6aUm6K_Q44vDvxs3Og";
	private final boolean useSandbox; // = false; // true; // // true; //

	public GoogleAdwordsServiceImpl() throws Exception
	{
		try
		{
			String key = (String) SemplestConfiguration.configData.get("SemplestEncryptionkey");
			AESBouncyCastle aes = AESBouncyCastle.getInstance(key);
			email = (String) SemplestConfiguration.configData.get("AdwordsEmail");
			password = aes.decrypt((String) SemplestConfiguration.configData.get("AdwordsPassword"));
			userAgent = (String) SemplestConfiguration.configData.get("AdwordsUserAgent");
			developerToken = (String) SemplestConfiguration.configData.get("AdwordsDeveloperToken");
			useSandbox = (Boolean) SemplestConfiguration.configData.get("AdwordsUseSandbox");
			logger.info("Initialized Google API sandbox=" + useSandbox);
		}
		catch (Exception e)
		{
			logger.error("Unable to initialize Google API");
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args)
	{

		// Log SOAP XML request and response.
		try
		{
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
			
			GoogleAdwordsServiceImpl g = new GoogleAdwordsServiceImpl();
			
			ArrayList<GoogleSiteLink> siteLinks = new ArrayList<GoogleSiteLink>();
			GoogleSiteLink l = new GoogleSiteLink();
			l.setLinkText("TestSiteLink");
			l.setLinkURL("http://www.semplest.com");
			siteLinks.add(l);
			Boolean res = g.addSiteLinkForCampaign("54102", 656140L, siteLinks);
			
			System.out.println(res);
			
			// Long id = g.GetActiveSitelinkExtension("54102", 656140L);
			// System.out.println("id=" + id);
			
			//String url = "www.summithillsfloristnj.com";
			String[] keywords = new String[]
			{ "wedding flowers", "flower centerpieces", "floral shop", "flower arrangement", "arrange flower" };
			//int numberResults = 100;
			//int categoryId = 11476; // Wedding Flowers
			//String accountID = null;
			//String [] exclude_keywords = null;
			/*
			 * ArrayList<KeywordToolStats> keyWordIdeaMap; try{ keyWordIdeaMap =
			 * g.getGoogleKeywordIdeas(accountID, url, keywords,
			 * exclude_keywords, categoryId, numberResults); } catch (Exception
			 * e){ e.printStackTrace(); }
			 */
			/*
			 * ArrayList<KeywordToolStats> stats =
			 * g.getGoogleVolumeCompetition(keywords, null); for
			 * (KeywordToolStats k : stats) { System.out.println(k.getKeyword()
			 * + "," + k.getMatchType() + "," + k.getAverageMonthlySearches() +
			 * "," + k.getCompetition()); }
			*/
			
			/*
			 * AdEngineID adEngineInfo = SemplestDB.getAdEngineID(62, "Google");
			 * GoogleAdwordsServiceImpl g = new GoogleAdwordsServiceImpl();
			 * KeywordDataObject[] keyData =
			 * g.getAllBiddableAdGroupCriteria(String
			 * .valueOf(adEngineInfo.getAccountID()),
			 * adEngineInfo.getAdGroupID(), true); //"54100",3066028785L, true);
			 * for (int i = 0; i < keyData.length; i++) {
			 * System.out.println(keyData[i].getKeyword()); }
			*/
			
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
			
			/*
			 * AdWordsUser user = new AdWordsUser(email, password, null,
			 * userAgent, developerToken, true); ServicedAccountServiceInterface
			 * accountService =
			 * user.getService(AdWordsService.V201109.SERVICED_ACCOUNT_SERVICE);
			 * ServicedAccountGraph ret = accountService.get(new
			 * ServicedAccountSelector()); Account[] accounts =
			 * ret.getAccounts(); for(Account a : accounts){
			 * System.out.println("accountId = " + a.getCustomerId()); }
			*/
			
			/*
			 * GoogleAdwordsServiceImpl g = new GoogleAdwordsServiceImpl();
			 * Campaign ret = g.CreateOneCampaignForAccount("54100", "temp1",
			 * CampaignStatus.PAUSED, BudgetBudgetPeriod.DAILY, 1000000L);
			 * System.out.println("campaignId = " + ret.getId());
			*/


			// Campaign c = g.CreateOneCampaignForAccount(null, "test",
			// CampaignStatus.ACTIVE, BudgetBudgetPeriod.MONTHLY, 1000000L);
			// String accountID = "2188810777"; // "5058200123";// "8019925375";
			// //

			// String accountID = "2188810777"; // "5058200123";// "8019925375";
			// //
			
			// "6048920973";
			//Long adGroupID = 3074331030L;
			//Long campaignID = 77290470L;
			//Long accountID = 9036397375L;

			// g.getSpentAPIUnitsPerAccountID(accountID,new java.util.Date(),new
			// java.util.Date());

			/*
			 * 
			 * ArrayList<HashMap<String, String>> ret =
			 * g.getCampaignsByAccountId("2188810777", false); String id =
			 * ret.get(0).values().toString(); System.out.println(id);
			 */

			// ArrayList<HashMap<String, String>> ret =
			// g.getCampaignsByAccountId("2188810777", false);
			//String id = ret.get(0).values().toString();
			//System.out.println(id);

			// KeywordDataObject[] c =
			// g.getAllBiddableAdGroupCriteria(accountID, adGroupID, true);

			/*
			 * String accountID = "2188810777"; // "5058200123";// "8019925375";
			 * // // "6048920973"; Long adGroupID = 3380873349L; Long campaignID
			 * = 77290470L;
			 * 
			 * 
			 * HashMap<String, Double> bids = new HashMap<String, Double>();
			 * bids.put("wedding flower", 2.0); HashMap<String, Double> bids2 =
			 * new HashMap<String, Double>(); bids2.put("wedding photo", 8.0);
			 * 
			 * GoogleTrafficEstimatorObject o =
			 * g.getTrafficEstimationForKeywords(accountID, campaignID,
			 * KeywordMatchType.EXACT, bids); String[] keywords =
			 * o.getListOfKeywords(); for (int i=0; i < keywords.length; i++) {
			 * HashMap<Double, GoogleTrafficEstimatorObject.BidData> points =
			 * o.getMapOfPoints(keywords[i]); Iterator<Double> bidIT =
			 * points.keySet().iterator(); while(bidIT.hasNext()) { Double abid=
			 * bidIT.next(); System.out.println(keywords[i] + ":" + abid + ":" +
			 * points.get(abid).getMaxAveCPC()); } }
			 * GoogleTrafficEstimatorObject o2 =
			 * g.getTrafficEstimationForKeywords(accountID, campaignID,
			 * KeywordMatchType.EXACT, bids2);
			 * o.addGoogleTrafficEstimatorObject(o2); keywords =
			 * o.getListOfKeywords(); for (int i=0; i < keywords.length; i++) {
			 * HashMap<Double, GoogleTrafficEstimatorObject.BidData> points =
			 * o.getMapOfPoints(keywords[i]); Iterator<Double> bidIT =
			 * points.keySet().iterator(); while(bidIT.hasNext()) { Double abid=
			 * bidIT.next(); System.out.println(keywords[i] + ":" + abid + ":" +
			 * points.get(abid).getMaxAveCPC()); } }
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
			/*
			 * SemplestString ss = new SemplestString(); ArrayList<ReportObject>
			 * f = g.getReportForAccount(ss.toSemplestString(accountID));
			 * for(ReportObject t : f){ logger.info("Keyword: " + t.getKeyword()
			 * + "; " + "Bidamount: " + t.getMicroBidAmount() + "; " +
			 * "BidMatchType: " + t.getBidMatchType() + "; " +
			 * "NumberImpressions: " + t.getNumberImpressions() + "; " +
			 * "NumberClick: " + t.getNumberClick() + "; " + "AveragePosition: "
			 * + t.getAveragePosition() + "; " + "AverageCPC: " +
			 * t.getAverageCPC() + "; " + "QualityScore: " +
			 * t.getQualityScore()+ "; " + "ApprovalStatus: " +
			 * t.getApprovalStatus()+ "; " + "FirstPageCPC: " +
			 * t.getFirstPageCPC()+ "; " + "TransactionDate: " +
			 * t.getTransactionDate()+ "; " + "AccountID: " + t.getAccountID()+
			 * "; " + "CampaignID: " + t.getCampaignID()+ "; " + "Cost: " +
			 * t.getMicroCost() + "; " ); } //
			 */

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getSpentAPIUnitsPerAccountID(String json) throws Exception
	{
		logger.debug("call getSpentAPIUnitsPerAccountID(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class); // protocolJson.getHashMapFromJson(json);
		Long accountID = Long.parseLong(data.get("accountID"));
		Long unitsSpent = getSpentAPIUnitsPerAccountID(accountID, gson.fromJson(data.get("startDate"), java.util.Date.class), gson.fromJson(data.get("endDate"), java.util.Date.class));
		// convert result to Json String
		return gson.toJson(unitsSpent);
	}

	@Override
	public Long getSpentAPIUnitsPerAccountID(Long accountID, java.util.Date startDate, java.util.Date endDate) throws Exception
	{
		try
		{
			AdWordsUser user = new AdWordsUser(email, password, null, userAgent, developerToken, useSandbox);
			// Get the INFO_SERVICe.

			InfoServiceInterface infoService = user.getService(AdWordsService.V201109.INFO_SERVICE);
			InfoSelector selector = new InfoSelector();
			selector.setApiUsageType(ApiUsageType.UNIT_COUNT_FOR_CLIENTS);
			selector.setClientCustomerIds(new long[]
			{ accountID });
			String start = "";
			String end = "";
			if (startDate != null && endDate != null)
			{
				start = SemplestUtils.DATE_FORMAT_YYYYMMDD.format(startDate);
				end = SemplestUtils.DATE_FORMAT_YYYYMMDD.format(endDate);
			}
			else
			{
				throw new Exception("Date is null");
			}
			// selector.setClientEmails(new String[]{email});
			selector.setDateRange(new DateRange(start, end));
			ApiUsageInfo info = infoService.get(selector);
			// System.out.println("API Usage Record :"
			// +info.getApiUsageRecords(0).getCost());
			return info.getApiUsageRecords(0).getCost();

		}
		catch (ServiceException se)
		{
			throw new Exception(se);
		}
		catch (ApiException e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
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
		try
		{
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
		catch (ApiException e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}

	}

	@Override
	public void addAccountBudget(Long microBudgetAmount, String customerId, String orderId) throws Exception
	{

	}

	@Override
	public String[] getClientAccounts() throws Exception
	{
		AdWordsUser user = new AdWordsUser(email, password, null, userAgent, developerToken, useSandbox);
		// Get the InfoService.
		InfoServiceInterface infoService = user.getService(AdWordsService.V201109.INFO_SERVICE);
		// ClientEmails to look up clientCustomerId for.
		String[] clientEmails = new String[]
		{ email };
		// Create selector.
		InfoSelector selector = new InfoSelector();
		selector.setApiUsageType(ApiUsageType.UNIT_COUNT_FOR_CLIENTS);
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		selector.setDateRange(new DateRange(today, today));
		selector.setClientEmails(clientEmails);
		selector.setIncludeSubAccounts(true);
		// Get api usage info.
		ApiUsageInfo apiUsageInfo = infoService.get(selector);
		for (ApiUsageRecord record : apiUsageInfo.getApiUsageRecords())
		{
			System.out.printf("Client with email '%s' has ID '%d'.\n", record.getClientEmail(), record.getClientCustomerId());

		}
		return null;
	}

	@Override
	public Budget[] getAccountBudgets(String customerId) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccountBudget(Budget budgetForUpdate, Long microBudgetAmount, String customerId, String orderId) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void addAccountBudget(DateTimeFloored start, DateTimeCeiling end, Long microBudgetAmount, String string) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccountBudgetCannotChangeTheStartDateOfTheCurrentBudget(Budget budgetForUpdate, DateTimeCeiling end, Long microBudgetAmount,
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
		Long defaultMicroBid = Long.parseLong(data.get("defaultMicroBid"));
		Long adGroupID = AddAdGroup(data.get("accountID"), campaignID, data.get("AdGroupName"), AdGroupStatus.fromString(data.get("status")),
				defaultMicroBid);
		// convert result to Json String
		return gson.toJson(adGroupID);
	}

	@Override
	public Long AddAdGroup(String accountID, Long campaignID, String AdGroupName, AdGroupStatus status, Long defaultMicroBid) throws Exception
	{
		try
		{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupService.
			AdGroupServiceInterface adGroupService = user.getService(AdWordsService.V201109.ADGROUP_SERVICE);
			long campaignId = campaignID;
			// Create ad group.
			AdGroup adGroup = new AdGroup();
			adGroup.setName(AdGroupName);
			adGroup.setStatus(status);
			adGroup.setCampaignId(campaignId);
			
			// Update ad group bid.
			ManualCPCAdGroupBids adGroupBids = new ManualCPCAdGroupBids();
			Money money = new Money();
			money.setMicroAmount(defaultMicroBid);
			adGroupBids.setKeywordMaxCpc(new Bid(money));
			adGroup.setBids(adGroupBids);
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
		catch (ApiException e)
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
		logger.debug("call addTextAd (" + json + ")");		
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final String accountID = data.get("accountID");
		final Long addGroupID = Long.parseLong(data.get("addGroupID"));
		final String headline = data.get("headline");
		final String description1 = data.get("description1");
		final String description2 = data.get("description2");
		final String displayURL = data.get("displayURL");
		final String url = data.get("url");
		final Long res = addTextAd(accountID, addGroupID, headline, description1, description2, displayURL, url);
		return gson.toJson(res);
	}

	/*
	 * Ads can show, including spaces, 25 characters for the title, 70
	 * characters for the ad text and 35 characters for a Display URL (or
	 * approximately 17 for languages that use non-ASCII (multi-byte)
	 * characters). NEED to Break up 35/Desc1, 35 Desc2
	 */
	@Override
	public Long addTextAd(String accountID, Long adGroupID, String headline, String description1, String description2, String displayURL, String url)
			throws Exception
	{
		//headline = "Exp123123123"; // for testing
		logger.info("Will try to add Text Ad for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], DisplayURL [" + displayURL + "], URL [" + url + "]");
		try
		{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupAdService.
			AdGroupAdServiceInterface adGroupAdService = user.getService(AdWordsService.V201109.ADGROUP_AD_SERVICE);

			// Create text ad.
			TextAd textAd = new TextAd();
			textAd.setHeadline(SemplestUtils.getTrimmedNonNullString(headline));
			textAd.setDescription1(SemplestUtils.getTrimmedNonNullString(description1));
			textAd.setDescription2(SemplestUtils.getTrimmedNonNullString(description2));
			textAd.setDisplayUrl(SemplestUtils.getTrimmedNonNullString(displayURL));
			textAd.setUrl(SemplestUtils.getTrimmedNonNullString(url));
			// Create ad group ad.
			AdGroupAd textAdGroupAd = new AdGroupAd();
			textAdGroupAd.setAdGroupId(adGroupID.longValue());
			textAdGroupAd.setAd(textAd);
			// Create operations.
			AdGroupAdOperation textAdGroupAdOperation = new AdGroupAdOperation();
			textAdGroupAdOperation.setOperand(textAdGroupAd);
			textAdGroupAdOperation.setOperator(Operator.ADD);
			AdGroupAdOperation[] operations = new AdGroupAdOperation[]{textAdGroupAdOperation};
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
			throw new Exception("Problem adding ad text for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], displayURL [" + displayURL + "], URL [" + url + "]", e);
		}
		catch (ApiException e)
		{
			throw new Exception("Problem adding ad text for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], displayURL [" + displayURL + "], URL [" + url + "]: " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new Exception("Problem adding ad text for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], displayURL [" + displayURL + "], URL [" + url + "]", e);
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
		try
		{
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
				Predicate statusPredicate = new Predicate("Status", PredicateOperator.IN, new String[]
				{ "ACTIVE" });
				selector.setPredicates(new Predicate[]
				{ adGroupIdPredicate, statusPredicate });
			}
			else
			{
				selector.setPredicates(new Predicate[]
				{ adGroupIdPredicate });
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
		catch (ApiException e)
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

		KeywordDataObject[] res = getAllBiddableAdGroupCriteria(data.get("accountID"), adGroupID, Boolean.valueOf(data.get("ActiveOnly")));
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public KeywordDataObject[] getAllBiddableAdGroupCriteria(String accountID, Long adGroupID, Boolean ActiveOnly) throws Exception
	{
		List<KeywordDataObject> result = new ArrayList<KeywordDataObject>();
		for (AdGroupCriterion criterion : getAllAdGroupCriteria(accountID, adGroupID, ActiveOnly))
		{
			if (criterion instanceof BiddableAdGroupCriterion)
			{
				BiddableAdGroupCriterion res = (BiddableAdGroupCriterion) criterion;
				KeywordDataObject bidRes = new KeywordDataObject();
				if (res.getQualityInfo() != null)
				{
					bidRes.setQualityScore(res.getQualityInfo().getQualityScore());
				}
				if (res.getFirstPageCpc() != null)
				{
					bidRes.setFirstPageCpc(res.getFirstPageCpc().getAmount().getMicroAmount());
				}
				bidRes.setBidID(res.getCriterion().getId());
				if (res.getSystemServingStatus() != null)
				{
					if (res.getSystemServingStatus().getValue().equalsIgnoreCase("Eligible"))
					{
						bidRes.setIsEligibleForShowing(true);
					}
					else
					{
						bidRes.setIsEligibleForShowing(false);
					}
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
		return result.toArray(new KeywordDataObject[result.size()]);
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
		for (KeywordDataObject criterion : getAllBiddableAdGroupCriteria(accountID, adGroupID, ActiveOnly))
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
		logger.debug("call deleteAd(String json) [" + json + "]");
		Map<String, String> data = gson.fromJson(json, Map.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long AdID = Long.parseLong(data.get("AdID"));
		Long googleAdID = deleteAD(data.get("accountID"), adGroupID, AdID);
		return gson.toJson(googleAdID);
	}

	@Override
	public Long deleteAD(String accountID, Long adGroupID, Long AdID) throws Exception
	{
		logger.info("Will try to delete ad in Goole Adwords for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], AdID [" + AdID + "]");
		try
		{
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
				final AdGroupAd[] adGroupAdArray = result.getValue();
				final AdGroupAd adGroupAdReturned = adGroupAdArray[0];
				final Ad returnedAd = adGroupAdReturned.getAd();
				final Long returnedAdID = returnedAd.getId();
				return returnedAdID;
			}
			else
			{
				return null;
			}			
		}
		catch (ServiceException e)
		{
			throw new Exception("Problem deleting Google AdWords Ad for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], AdID [" + AdID + "]", e);
		}
		catch (ApiException e)
		{
			throw new Exception("Problem deleting Google AdWords Ad for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], AdID [" + AdID + "]: " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new Exception("Problem deleting Google AdWords Ad for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], AdID [" + AdID + "]", e);
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
		try
		{
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
		catch (ApiException e)
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
		Map<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long AdID = Long.parseLong(data.get("AdID"));
		Long result = updateAD(data.get("accountID"), adGroupID, AdID, data.get("headline"), data.get("description1"), data.get("description2"), data.get("displayURL"), data.get("url"));
		return gson.toJson(result);
	}

	/**
	 * Only status of an ad can be updated.  So in order to accomodate changes to other fields, like headline/description/etc, we add the new ad with new params and delete the old ad.
	 */
	@Override
	public Long updateAD(String accountID, Long adGroupID, Long oldGoogleAdID, String headline, String description1, String description2, String displayURL, String url) throws Exception
	{	
		logger.info("Will try to update ad in Goole Adwords for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], OldGoogleAdID [" + oldGoogleAdID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], DisplayURL [" + displayURL + "], URL [" + url + "]");
		try
		{
			final Long newTextAdID = addTextAd(accountID, adGroupID, headline, description1, description2, displayURL, url);
			logger.info("New ad created (as part of update) with Google Ad ID [" + newTextAdID + "].  Now will try to delete the old ad for Google Ad ID [" + oldGoogleAdID + "]");
			final Long deletedTextAdID = deleteAD(accountID, adGroupID, oldGoogleAdID);
			if (deletedTextAdID.equals(oldGoogleAdID))
			{
				logger.info("OLD Ad deleted (as part of update) with Google Ad ID [" + oldGoogleAdID + "].  Returning the NEW Google Ad ID [" + newTextAdID + "]");
				return newTextAdID;
			}
			else
			{
				throw new Exception("Google Ad ID returned from the delete part of the update operation [" + deletedTextAdID + "] is not the same as expected [" + oldGoogleAdID + "].  Maybe the wrong Google Ad was deleted?  Other params used in the delete call: GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "].");
			}
		}
		catch (Exception e)
		{
			throw new Exception("Problem updating ad for AccountID [" + accountID + "], AdGroupID [" + adGroupID + "], GoogleAdId [" + oldGoogleAdID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], displayURL [" + displayURL + "], URL [" + url + "]", e);
		}
	}

	public String addKeyWordToAdGroup(String json) throws Exception
	{
		logger.debug("call addKeyWordToAdGroup" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long microBidAmount = Long.parseLong(data.get("microBidAmount"));
		KeywordDataObject res = addKeyWordToAdGroup(data.get("accountID"), adGroupID, data.get("keyword"),
				KeywordMatchType.fromString(data.get("matchType")), microBidAmount);

		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public KeywordDataObject addKeyWordToAdGroup(String accountID, Long adGroupID, String keyword, KeywordMatchType matchType, Long microBidAmount)
			throws Exception
	{
		try
		{
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
			Money money = new Money();
			money.setMicroAmount(microBidAmount);
			bid.setMaxCpc(new Bid(money));

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
				KeywordDataObject bidRes = new KeywordDataObject();
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
				return new KeywordDataObject();
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiException e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}
	
	public ArrayList<KeywordToolStats> getGoogleVolumeCompetition(String[] keywords, KeywordMatchType matchType) throws Exception
	{
	
		ArrayList<KeywordToolStats> returnData = new ArrayList<KeywordToolStats>();
		TargetingIdeaPage page;
		TargetingIdeaServiceInterface targetingIdeaService;
		
		if (keywords == null)
		{
			throw new Exception("Empty keyword list!");
		}
		
		try
		{
			AdWordsUser user = new AdWordsUser(email, password, null, userAgent, developerToken, useSandbox);
			// Get the TargetingIdeaService
			targetingIdeaService = user.getService(AdWordsService.V201109.TARGETING_IDEA_SERVICE);
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}


		// Create selector.
		TargetingIdeaSelector selector = new TargetingIdeaSelector();
		selector.setRequestType(RequestType.STATS);
		selector.setIdeaType(IdeaType.KEYWORD);
		selector.setRequestedAttributeTypes(new AttributeType[]
		{ AttributeType.CRITERION, AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES, AttributeType.COMPETITION }); // AttributeType.APPROX_CONTENT_IMPRESSIONS_PER_DAY,//
																													// });

		selector.setLocaleCode("US");
		selector.setCurrencyCode("USD");


		// Set selector paging (required for targeting idea service).
		Paging paging = new Paging();
		paging.setStartIndex(0);
		if (matchType == null)
		{
			paging.setNumberResults(3*keywords.length);
		}
		else
		{
			paging.setNumberResults(keywords.length);
		}
		selector.setPaging(paging);


		ArrayList<SearchParameter> searchParamList = new ArrayList<SearchParameter>();


		
		
		ArrayList<Keyword> wordList = new ArrayList<Keyword>();
		
		if (matchType == null)
		{
			for (String word : keywords)
			{
		
				Keyword kw = new Keyword();
				kw.setText(word);
				kw.setMatchType(KeywordMatchType.EXACT);
				wordList.add(kw);
				
				kw = new Keyword();
				kw.setText(word);
				kw.setMatchType(KeywordMatchType.PHRASE);
				wordList.add(kw);
				
				kw = new Keyword();
				kw.setText(word);
				kw.setMatchType(KeywordMatchType.BROAD);
				wordList.add(kw);
			}
		}
		else
		{
			for (String word : keywords)
			{

				Keyword kw = new Keyword();
				kw.setText(word);
				kw.setMatchType(matchType);
				wordList.add(kw);

			}
		}
		

		// Create related to keyword search parameter.
		RelatedToKeywordSearchParameter relatedToKeywordSearchParameter = new RelatedToKeywordSearchParameter();
		relatedToKeywordSearchParameter.setKeywords(wordList.toArray(new Keyword[wordList.size()]));
		//relatedToKeywordSearchParameter.setKeywords(new Keyword[] {keywrd});
		searchParamList.add(relatedToKeywordSearchParameter);




		// Location search parameter		
		Location loc = new Location();
		loc.setId(new Long(2840)); // United States
		LocationSearchParameter locationSearchParameter = new LocationSearchParameter();
		locationSearchParameter.setLocations(new Location[]
		{ loc });
		searchParamList.add(locationSearchParameter);


		// set the selector
		selector.setSearchParameters(searchParamList.toArray(new SearchParameter[searchParamList.size()]));

		try
		{
			// Get related placements.
			page = targetingIdeaService.get(selector);
			//page = targetingIdeaService.getBulkKeywordIdeas(selector);
		}
		catch (ApiException e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}


		//System.out.println(page.getTotalNumEntries());

		if (page != null && page.getEntries() != null)
		{

			for (TargetingIdea targetingIdea : page.getEntries())
			{
				Map<AttributeType, Attribute> data = MapUtils.toMap(targetingIdea.getData());
				Keyword kw = (Keyword) ((CriterionAttribute) data.get(AttributeType.CRITERION)).getValue();
				Long averageMonthlySearches = ((LongAttribute) data.get(AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES)).getValue();
				Double comp = ((DoubleAttribute) data.get(AttributeType.COMPETITION)).getValue();
				// logger.info(kw.getText()+","+
				// kw.getMatchType().getValue()+","+ averageMonthlySearches+","+
				// comp);
				//System.out.println(kw.getText()+": "+averageMonthlySearches);
				//System.out.println(kw.getText());
				KeywordMatchingType kwMatchType = null;
				if (kw.getMatchType() == KeywordMatchType.EXACT)
				{
					kwMatchType = KeywordMatchingType.EXACT;
				}
				else if (kw.getMatchType() == KeywordMatchType.PHRASE)
				{
					kwMatchType = KeywordMatchingType.PHRASE;
				}
				else if (kw.getMatchType() == KeywordMatchType.BROAD)
				{
					kwMatchType = KeywordMatchingType.BROAD;
				}
				returnData.add(new KeywordToolStats(kw.getText(),kwMatchType,averageMonthlySearches,comp));
			}

		}


		logger.info("Total number of words received from Google: "+returnData.size());
		return returnData;

	}
	
	public ArrayList<KeywordToolStats> getGoogleKeywordIdeas(String[] keywords, int numberResults) throws Exception
	{
	
		

		if (numberResults > 1000)
		{
			throw new Exception("numberResults must be <= 1000. Google doesn't return more than that!! The feature"
					+ " is given so that you may use a smaller number to save API cost in case a small number of keywords needed.");
		}
		
		ArrayList<KeywordToolStats> returnData = new ArrayList<KeywordToolStats>();
		TargetingIdeaPage page;
		TargetingIdeaServiceInterface targetingIdeaService;

		HashSet<Keyword> stopWordSet = new HashSet<Keyword>();
		
		int iterations=1;
		int numResIter = numberResults;
		if(numberResults>800) {
			iterations=2;
			numResIter=numberResults-800;
		}

		/*
		for (String word : keywords)
		{
			Keyword kw = new Keyword();
			kw.setText(word);
			kw.setMatchType(KeywordMatchType.EXACT);
			stopWordSet.add(kw);
		}

		if (exclude_keywords != null)
		{
			if (exclude_keywords.length + keywords.length > 200)
			{
				throw new Exception("Total number of keywords and exclude keywords must be less than equal to 200. It's a Google policy");
			}
			for (String word : exclude_keywords)
			{
				Keyword kw = new Keyword();
				kw.setText(word);
				kw.setMatchType(KeywordMatchType.EXACT);
				stopWordSet.add(kw);
			}
		}
		*/

		try
		{
			AdWordsUser user = new AdWordsUser(email, password, null, userAgent, developerToken, useSandbox);
			// AdWordsUser user = new AdWordsUser("adwords@semplest.com","ic0system",accountID,"Icosystem","2H8l6aUm6K_Q44vDvxs3Og");
			// Get the TargetingIdeaService
			targetingIdeaService = user.getService(AdWordsService.V201109.TARGETING_IDEA_SERVICE);
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}


		//for (String word : keywords){


		// Create selector.
		TargetingIdeaSelector selector = new TargetingIdeaSelector();
		selector.setRequestType(RequestType.IDEAS);
		selector.setIdeaType(IdeaType.KEYWORD);
		selector.setRequestedAttributeTypes(new AttributeType[]
		{ AttributeType.CRITERION, AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES, AttributeType.COMPETITION }); // AttributeType.APPROX_CONTENT_IMPRESSIONS_PER_DAY,//
																													//});
		
		// Set selector paging (required for targeting idea service).
		Paging paging = new Paging();
		paging.setStartIndex(0);
		paging.setNumberResults(numResIter);
		selector.setPaging(paging);

		ArrayList<SearchParameter> searchParamList = new ArrayList<SearchParameter>();

		// Keyword

		ArrayList<Keyword> kwList = new ArrayList<Keyword>();
		for (String s : keywords)
		{
			Keyword keywrd = new Keyword();
			keywrd.setText(s);
			keywrd.setMatchType(KeywordMatchType.EXACT);
			kwList.add(keywrd);
		} 
		/*
		 * Keyword keywrd = new Keyword(); keywrd.setText(word);
		 * keywrd.setMatchType(KeywordMatchType.EXACT);
		 */
		// Create related to keyword search parameter.
		RelatedToKeywordSearchParameter relatedToKeywordSearchParameter = new RelatedToKeywordSearchParameter();
		relatedToKeywordSearchParameter.setKeywords(kwList.toArray(new Keyword[kwList.size()]));
		//relatedToKeywordSearchParameter.setKeywords(new Keyword[] {keywrd});
		searchParamList.add(relatedToKeywordSearchParameter);


		/*
		
		// Exclude search parameter
		ExcludedKeywordSearchParameter excludeKeywordSearchParameter = new ExcludedKeywordSearchParameter();
		excludeKeywordSearchParameter.setKeywords(stopWordSet.toArray(new Keyword[stopWordSet.size()]));
		searchParamList.add(excludeKeywordSearchParameter);
		*/

		/*

		// Create related to URL search parameter.
		RelatedToUrlSearchParameter relatedToUrlSearchParameter = new RelatedToUrlSearchParameter();
		relatedToUrlSearchParameter.setUrls(new String[] { url });
		//relatedToUrlSearchParameter.setIncludeSubUrls(true);
		searchParamList.add(relatedToUrlSearchParameter);
		 */

		// matchType parameter
		KeywordMatchTypeSearchParameter matchTypeParameter = new KeywordMatchTypeSearchParameter();
		matchTypeParameter.setKeywordMatchTypes(new KeywordMatchType[]
		{ KeywordMatchType.EXACT });
		searchParamList.add(matchTypeParameter);


		/*
		// Category ID parameter
		CategoryProductsAndServicesSearchParameter categoryProductServiceSearchParameter = new CategoryProductsAndServicesSearchParameter ();
		if (categoryId != null)
		{
			categoryProductServiceSearchParameter.setCategoryId(categoryId);
			searchParamList.add(categoryProductServiceSearchParameter);
		}
		*/


		// Location search parameter		
		Location loc = new Location();
		loc.setId(new Long(2840)); // United States
		LocationSearchParameter locationSearchParameter = new LocationSearchParameter();
		locationSearchParameter.setLocations(new Location[]
		{ loc });
		searchParamList.add(locationSearchParameter);


		// set the selector
		selector.setSearchParameters(searchParamList.toArray(new SearchParameter[searchParamList.size()]));

		
		for (int iter = 1; iter <= iterations; iter++){ 
			try {
				// Get related placements.
				page = targetingIdeaService.get(selector);
			} catch (ApiException e) {
				throw new Exception(e.dumpToString());
			} catch (RemoteException e) {
				throw new Exception(e);
			}


			if (page != null && page.getEntries() != null) {

				for (TargetingIdea targetingIdea : page.getEntries()) {
					
					Map<AttributeType, Attribute> data = MapUtils.toMap(targetingIdea.getData());
					Keyword kw = (Keyword) ((CriterionAttribute) data.get(AttributeType.CRITERION)).getValue();
					Long averageMonthlySearches = ((LongAttribute) data.get(AttributeType.AVERAGE_TARGETED_MONTHLY_SEARCHES)).getValue();
					Double comp = ((DoubleAttribute) data.get(AttributeType.COMPETITION)).getValue();
					// logger.info(kw.getText()+" "+
					// kw.getMatchType().getValue()+" "+ averageMonthlySearches+" "+
					// comp);
					//logger.info(kw.getText()+": "+averageMonthlySearches);
					//logger.info(kw.getText());

					KeywordMatchingType kwMatchType = null;
					if (kw.getMatchType() == KeywordMatchType.EXACT)
					{
						kwMatchType = KeywordMatchingType.EXACT;
					}
					else if (kw.getMatchType() == KeywordMatchType.PHRASE)
					{
						kwMatchType = KeywordMatchingType.PHRASE;
					}
					else if (kw.getMatchType() == KeywordMatchType.BROAD)
					{
						kwMatchType = KeywordMatchingType.BROAD;
					}

					returnData.add(new KeywordToolStats(kw.getText(),kwMatchType,averageMonthlySearches,comp));
					if (stopWordSet.contains(kw))
					{
						logger.info("Google is fooling us... returned a keyword from the stop list: "+kw.getText());
					}
					else
					{
						if (stopWordSet.size() < 200)
						{
							stopWordSet.add(kw);
						}
					}
				}

			}


			// Exclude search parameter
			ExcludedKeywordSearchParameter excludeKeywordSearchParameter = new ExcludedKeywordSearchParameter();
			excludeKeywordSearchParameter.setKeywords(stopWordSet.toArray(new Keyword[stopWordSet.size()]));
			searchParamList.add(excludeKeywordSearchParameter);

			selector.setSearchParameters(searchParamList.toArray(new SearchParameter[searchParamList.size()]));
			numResIter=800;
			// Set selector paging (required for targeting idea service).
			paging = new Paging();
			paging.setStartIndex(0);
			paging.setNumberResults(numResIter);
			selector.setPaging(paging);
		
		}
		

		//logger.info("Keyword "+word+" is done.");
		//} //for (String word : keywords)


		logger.info("Total number of words received from Google: "+returnData.size());
		return returnData;

	}

	public String setBidForKeyWord(String json) throws Exception
	{
		logger.debug("call setBidForKeyWord" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long keywordID = Long.parseLong(data.get("keywordID"));
		Long microBidAmount = Long.parseLong(data.get("microBidAmount"));
		KeywordDataObject res = setBidForKeyWord(data.get("accountID"), keywordID, adGroupID, microBidAmount);
		// convert result to Json String
		return gson.toJson(res);
	}

	@Override
	public KeywordDataObject setBidForKeyWord(String accountID, Long keywordID, Long adGroupID, Long microBidAmount) throws Exception
	{
		try
		{
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
			Money money = new Money();
			money.setMicroAmount(microBidAmount);
			bids.setMaxCpc(new Bid(money));

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
				KeywordDataObject bidRes = new KeywordDataObject();
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
				bidRes.setMatchType(keyword.getMatchType().getValue());
				bidRes.setNegative(false);
				return bidRes;
			}
			else
			{
				return new KeywordDataObject();
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiException e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}
	
	public String addNegativeKeyWordToAdGroup(String json) throws Exception
	{
		logger.debug("call addKeyWordToAdGroup" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		KeywordDataObject res = addNegativeKeyWordToAdGroup(data.get("accountID"), adGroupID, data.get("keyword"),
				KeywordMatchType.fromString(data.get("matchType")));

		// convert result to Json String
		return gson.toJson(res);
	}
	@Override
	public KeywordDataObject addNegativeKeyWordToAdGroup(String accountID, Long campaignID, String keyword, KeywordMatchType matchType)
			throws Exception
	{
		try
		{
			// Log SOAP XML request and response. AdWordsServiceLogger.log();          
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);        
			// Get the CampaignCriterionService.        
			CampaignCriterionServiceInterface campaignCriterionService = user.getService(AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE);         
			       
			// Create keyword.        
			Keyword keywrd = new Keyword();        
			keywrd.setText(keyword);        
			keywrd.setMatchType(matchType);          
			// Create negative campaign criterion.        
			NegativeCampaignCriterion negativeCampaignCriterion = new NegativeCampaignCriterion();        
			negativeCampaignCriterion.setCampaignId(campaignID);        
			negativeCampaignCriterion.setCriterion(keywrd);          
			// Create operations.        
			CampaignCriterionOperation operation = new CampaignCriterionOperation();        
			operation.setOperand(negativeCampaignCriterion);        
			operation.setOperator(Operator.ADD);          
			// Add campaign criteria.        
			CampaignCriterionReturnValue result = campaignCriterionService.mutate(new CampaignCriterionOperation[]
			{ operation });
			if (result != null && result.getValue() != null && (result.getValue(0) instanceof CampaignCriterion))
			{
				CampaignCriterion res = (CampaignCriterion ) result.getValue(0);
				Keyword akeyword = ((Keyword) res.getCriterion());
				KeywordDataObject bidRes = new KeywordDataObject();
				bidRes.setBidID(res.getCriterion().getId());
				bidRes.setMatchType(akeyword.getMatchType().getValue());
				bidRes.setKeyword(akeyword.getText());
				bidRes.setNegative(true);
				return bidRes;
			}
			else
			{
				return new KeywordDataObject();
			}
		}
		catch (ServiceException e)
		{
			throw new Exception(e);
		}
		catch (ApiException e)
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

		// MicroAmount
		Campaign campaign = CreateOneCampaignForAccount(data.get("accountID"), data.get("campaignName"),
				CampaignStatus.fromString(data.get("campaignStatus")), BudgetBudgetPeriod.fromString(data.get("period")),
				new Long(data.get("microBudgetAmount")));
		// convert result to Json String
		return gson.toJson(campaign);
	}

	@Override
	public Campaign CreateOneCampaignForAccount(String accountID, String campaignName, CampaignStatus campaignStatus, BudgetBudgetPeriod period,
			Long microBudgetAmount) throws Exception
	{
		try
		{
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
			/*
			 * Default network is Google Search ONLY
			 */
			NetworkSetting network = new NetworkSetting();
			network.setTargetGoogleSearch(true);
			network.setTargetPartnerSearchNetwork(false);
			network.setTargetContentNetwork(false);
			network.setTargetSearchNetwork(false);
			campaign.setNetworkSetting(network);

			budget.setPeriod(period);

			Money money = new Money();
			money.setMicroAmount(microBudgetAmount);

			budget.setAmount(money);
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
		catch (ApiException e)
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
		try
		{
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
					 * (pages[i].getStats().getAverageCpc().getMicroAmount()); }
					 * if (pages[i].getStats().getAverageCpm() != null) {
					 * s.setAverageCpm
					 * (pages[i].getStats().getAverageCpm().getMicroAmount()); }
					 * s.setAveragePosition
					 * (pages[i].getStats().getAveragePosition());
					 * s.setAvgCallDurationSecs
					 * (pages[i].getStats().getAvgCallDurationSecs());
					 * s.setClicks(pages[i].getStats().getClicks());
					 * s.setConversionRate
					 * (pages[i].getStats().getConversionRate()); if
					 * (pages[i].getStats().getCost() != null) {
					 * s.setCost(pages[
					 * i].getStats().getCost().getMicroAmount()); } if
					 * (pages[i].getStats().getCostPerConversion() != null) {
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
		catch (ApiException e)
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
		try
		{
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
		catch (ApiException e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}
	
	@Override
	public Boolean ChangeCampaignStartDate(String accountID, Long campaignID, java.util.Date newStartDate) throws Exception
	{
		logger.info("Will try to change the Campaign StartDate to [" + newStartDate + "] for AccountID [" + accountID + "] and CampaignID [" + campaignID + "]");
		try
		{
			final AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			final CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);			
			final Campaign campaign = new Campaign();
			campaign.setId(campaignID);
			final String startDateString = SemplestUtils.DATE_FORMAT_YYYYMMDD.format(newStartDate);
			campaign.setStartDate(startDateString);
			final CampaignOperation operation = new CampaignOperation();
			operation.setOperand(campaign);
			operation.setOperator(Operator.SET);
			final CampaignOperation[] operations = new CampaignOperation[]{operation};
			final CampaignReturnValue ret = campaignService.mutate(operations);
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
			final String errMsg = "Problem changing the StartDate of Google campaign [" + campaignID + "] to StartDate [" + newStartDate + "] for Google Account ID [" + accountID + "]";
			logger.info(errMsg, e);
			throw new Exception(errMsg, e);
		}
		catch (ApiException e)
		{
			final String errMsg = "Problem changing the StartDate of Google campaign [" + campaignID + "] to StartDate [" + newStartDate + "] for Google Account ID [" + accountID + "]: " + e.dumpToString();
			logger.info(errMsg, e);
			throw new Exception(errMsg, e);
		}
		catch (RemoteException e)
		{
			final String errMsg = "Problem changing the StartDate of Google campaign [" + campaignID + "] to StartDate [" + newStartDate + "] for Google Account ID [" + accountID + "]";
			logger.info(errMsg, e);
			throw new Exception(errMsg, e);
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
		logger.info("Will try to change the CampaignStatus to [" + status + "] for AccountID [" + accountID + "] and CampaignID [" + campaignID + "]");
		try
		{
			final AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			final CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);			
			final Campaign campaign = new Campaign();
			campaign.setId(campaignID);
			campaign.setStatus(status);
			final CampaignOperation operation = new CampaignOperation();
			operation.setOperand(campaign);
			operation.setOperator(Operator.SET);
			final CampaignOperation[] operations = new CampaignOperation[]{operation};
			final CampaignReturnValue ret = campaignService.mutate(operations);
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
			final String errMsg = "Problem changing the status of Google campaign [" + campaignID + "] to Status [" + status + "] for Google Account ID [" + accountID + "]";
			logger.info(errMsg, e);
			throw new Exception(errMsg, e);
		}
		catch (ApiException e)
		{
			final String errMsg = "Problem changing the status of Google campaign [" + campaignID + "] to Status [" + status + "] for Google Account ID [" + accountID + "]: " + e.dumpToString();
			logger.info(errMsg, e);
			throw new Exception(errMsg, e);
		}
		catch (RemoteException e)
		{
			final String errMsg = "Problem changing the status of Google campaign [" + campaignID + "] to Status [" + status + "] for Google Account ID [" + accountID + "]";
			logger.info(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String changeCampaignBudget(String json) throws Exception
	{
		logger.debug("call changeCampaignStatus(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final String accountID = data.get("accountID");
		final Long campaignID = Long.parseLong(data.get("campaignID"));
		final Long microBudgetAmount = Long.valueOf(data.get("microBudgetAmount"));
		final Boolean res = changeCampaignBudget(accountID, campaignID, microBudgetAmount);
		return gson.toJson(res);
	}

	@Override
	public Boolean changeCampaignBudget(String accountID, Long campaignID, Long newMicroBudgetAmount) throws Exception
	{
		logger.info("Will try to update Google Campaign for ID [" + campaignID + "] with new Micro Budget Amount [" + newMicroBudgetAmount + "] for Google Account [" + accountID + "]");		
		try
		{
			final AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			final CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);
			final Budget budget = new Budget();
			budget.setPeriod(BudgetBudgetPeriod.DAILY);
			final Money money = new Money();
			money.setMicroAmount(newMicroBudgetAmount);
			budget.setAmount(money);
			budget.setDeliveryMethod(BudgetBudgetDeliveryMethod.STANDARD);
			final Campaign campaign = new Campaign();
			campaign.setId(campaignID);
			campaign.setBudget(budget);
			final CampaignOperation operation = new CampaignOperation();
			operation.setOperand(campaign);
			operation.setOperator(Operator.SET);
			final CampaignOperation[] operations = new CampaignOperation[]{operation};
			final CampaignReturnValue ret = campaignService.mutate(operations);
			if (ret != null && ret.getValue() != null)
			{
				final Campaign[] affectedCampaigns = ret.getValue();
				final Campaign affectedCampaign = affectedCampaigns[0];
				final Long affectedCampaignID = affectedCampaign.getId();
				final Budget affectedCampaignBudget = affectedCampaign.getBudget();
				final Money affectedCampaignBudgetAmountMoney = affectedCampaignBudget.getAmount();
				final Long affectedCampaignBudgetAmount = affectedCampaignBudgetAmountMoney.getMicroAmount();
				if (!campaignID.equals(affectedCampaignID))
				{
					final String errMsg = "The ID of the Google campaign that was changed [" + affectedCampaignID + "] is not the same as the ID of the campaign that we intended to change [" + campaignID + "].  Perhaps the wrong campaign was changed.";
					logger.error(errMsg);
					throw new Exception(errMsg);
				}
				if (!newMicroBudgetAmount.equals(affectedCampaignBudgetAmount))
				{
					final String errMsg = "The resulting $-amount of the Google campaign that was changed [" + affectedCampaignBudgetAmount + "] is not the same as the amount that we intended [" + newMicroBudgetAmount + "].";
					logger.error(errMsg);
					throw new Exception(errMsg);
				}
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (ServiceException e)
		{
			throw new Exception("Problem updating Google Campaign for ID [" + campaignID + "] with new Micro Budget Amount [" + newMicroBudgetAmount + "]", e);
		}
		catch (ApiException e)
		{
			throw new Exception("Problem updating Google Campaign for ID [" + campaignID + "] with new Micro Budget Amount [" + newMicroBudgetAmount + "]: " + e.dumpToString(), e);
		}
		catch (RemoteException e)
		{
			throw new Exception("Problem updating Google Campaign for ID [" + campaignID + "] with new Micro Budget Amount [" + newMicroBudgetAmount + "]", e);
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
		try
		{

			// AdWordsServiceLogger.log(); //SOAP XML Logger

			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			CampaignServiceInterface campaignService = user.getService(AdWordsService.V201109.CAMPAIGN_SERVICE);

			// Create selector.
			Selector selectActiveAndPausedCampaigns = new Selector();
			selectActiveAndPausedCampaigns.setFields(new String[]
			{ "Id", "Name", "Status", "Amount" });
			// TODO should only be returning Id, Name and Status from this
			// method
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
		catch (ApiException e)
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
		try
		{
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
		catch (ApiException e)
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
		final Campaign campaign = new Campaign();
		campaign.setId(campaignID);
		final CampaignOperation operation = new CampaignOperation();
		operation.setOperand(campaign);
		operation.setOperator(op);
		return new CampaignOperation[]{operation};
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
		try
		{
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
			// Create keyword match type search parameter to ensure unique
			// results.
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
		catch (ApiException e)
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
		try
		{
			// Specifically you would use the RelatedToUrlSearchParameter,
			// ideaType
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
		catch (ApiException e)
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
		HashMap<String, Long> KeywordWithBid = gson.fromJson(data.get("KeywordWithBid"), HashMap.class);
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
			HashMap<String, Long> newKeywordWithBid) throws Exception
	{
		try
		{
			AdWordsServiceLogger.log();
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			List<AdGroupEstimateRequest> adGroupEstimateRequests = new ArrayList<AdGroupEstimateRequest>();
			ArrayList<KeywordEstimateRequest> keywordEstimateRequests = new ArrayList<KeywordEstimateRequest>();

			// Get the TrafficEstimatorService.
			TrafficEstimatorServiceInterface trafficEstimatorService = user.getService(AdWordsService.V201109.TRAFFIC_ESTIMATOR_SERVICE);

			// for each keyword
			String[] keywords = newKeywordWithBid.keySet().toArray(new String[]
			{});

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
				Long microBidamount = newKeywordWithBid.get(keyword);

				if (microBidamount != null)
				{
					// one keyword estimate request
					KeywordEstimateRequest keywordEstimateRequest = new KeywordEstimateRequest();
					keywordEstimateRequest.setKeyword(keywrd);

					Money money = new Money();
					money.setMicroAmount(microBidamount);
					keywordEstimateRequest.setMaxCpc(money);
					keywordEstimateRequests.add(keywordEstimateRequest);
				}
			}
			AdGroupEstimateRequest adGroupEstimateRequest = new AdGroupEstimateRequest();
			adGroupEstimateRequest.setKeywordEstimateRequests(keywordEstimateRequests.toArray(new KeywordEstimateRequest[]
			{}));

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
					estimatorObj.setBidData(adGroupEstimateRequests.get(0).getKeywordEstimateRequests()[i].getKeyword().getText(),
							adGroupEstimateRequests.get(0).getKeywordEstimateRequests()[i].getMaxCpc().getMicroAmount(),
							adGroupEstimateRequests.get(0).getKeywordEstimateRequests()[i].getKeyword().getMatchType().toString(), min
									.getAverageCpc().getMicroAmount(), max.getAverageCpc().getMicroAmount(), min.getAveragePosition(), max
									.getAveragePosition(), min.getClicksPerDay(), max.getClicksPerDay(), min.getTotalCost().getMicroAmount(), max
									.getTotalCost().getMicroAmount());
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
		catch (ApiException e)
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
		try
		{
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
		catch (ApiException e)
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
		try
		{
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
		catch (ApiException e)
		{
			throw new Exception(e.dumpToString());
		}
		catch (RemoteException e)
		{
			throw new Exception(e);
		}
	}

	public String getReportForAccount(String json) throws Exception
	{
		logger.debug("call  getReportForAccount" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);		
		ReportObject[] res = getReportForAccount(data.get("accountID"), data.get("startDate"), data.get("endDate"));
		// convert result to Json String
		return gson.toJson(res);
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
			+ "<fields>ApprovalStatus</fields><fields>CampaignId</fields>" + "</selector><reportName>KEYWORDS_PERFORMANCE_REPORT</reportName>"
			+ "<reportType>KEYWORDS_PERFORMANCE_REPORT</reportType>"
			+ "<dateRangeType>LAST_7_DAYS</dateRangeType><downloadFormat>CSV</downloadFormat>" + "</reportDefinition>";

	private static final String SEARCH_QUERY_DEFINITION = "<reportDefinition><selector><fields>Date</fields>"
			+ "<fields>AdGroupId</fields><fields>Query</fields><fields>MatchType</fields>"
			+ "<fields>Impressions</fields><fields>Clicks</fields><fields>Cost</fields>"
			+ "<fields>AverageCpc</fields><fields>AveragePosition</fields><fields>CampaignId</fields><fields>Ctr</fields>"
			+ "</selector><reportName>SEARCH_QUERY_PERFORMANCE_REPORT</reportName>" + "<reportType>SEARCH_QUERY_PERFORMANCE_REPORT</reportType>"
			+ "<dateRangeType>ALL_TIME</dateRangeType><downloadFormat>CSV</downloadFormat>" + "</reportDefinition>";

	public ReportObject[] getReportForAccount(String accountID, String startDate, String endDate) throws Exception
	{
		// DON'T CHANGE THE SELECOTR FIELDS! OR THE FORMAT OF REPORT WILL BE
		// DIFFERENT. AND THE DOWNLOADER WON'T TRANSLATE IT CORRECTLY!
		String REPORT_DEFINITION = "<reportDefinition><selector><fields>Date</fields>"
				+ "<fields>AdGroupId</fields><fields>Id</fields><fields>KeywordText</fields><fields>KeywordMatchType</fields>"
				+ "<fields>Impressions</fields><fields>Clicks</fields><fields>Cost</fields><fields>QualityScore</fields>"
				+ "<fields>AverageCpc</fields><fields>AveragePosition</fields><fields>CampaignId</fields><fields>Ctr</fields><fields>FirstPageCpc</fields><fields>MaxCpc</fields>"
				+ "<fields>ApprovalStatus</fields><fields>CampaignId</fields>" + "<dateRange> <min>" + startDate + "</min> <max>" + endDate
				+ "</max> </dateRange>" + "</selector><reportName>KEYWORDS_PERFORMANCE_REPORT</reportName>"
				+ "<reportType>KEYWORDS_PERFORMANCE_REPORT</reportType>"
				+ "<dateRangeType>CUSTOM_DATE</dateRangeType><downloadFormat>CSV</downloadFormat>" + "</reportDefinition>";
		
		GoogleReportDownloader report = new GoogleReportDownloader(REPORT_DEFINITION, new Long(accountID));//

		// File reportFile = report.downloadReport(new AuthToken(email,
		// password).getAuthToken(), developerToken);

		ArrayList<ReportObject> reportObj = report.getReportObject(new AuthToken(email, password).getAuthToken(), developerToken);
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

	public ReportObject[] getSearchQueryReportForAccount(SemplestString accountID) throws Exception
	{
		GoogleReportDownloader report = new GoogleReportDownloader(SEARCH_QUERY_DEFINITION, new Long(accountID.getSemplestString()));//

		// File reportFile = report.downloadReport(new AuthToken(email,
		// password).getAuthToken(), developerToken);

		ArrayList<ReportObject> reportObj = report.getSearchQueryReportObject(new AuthToken(email, password).getAuthToken(), developerToken);
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

	/*
	 * GeoTargeting
	 */
	public String setGeoTarget(String json) throws Exception
	{
		logger.debug("call CreateOneAccountService(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long campaignId = Long.parseLong(data.get("campaignId"));
		Double latitude = Double.parseDouble(data.get("latitude"));
		Double longitude = Double.parseDouble(data.get("longitude"));
		Double radius = Double.parseDouble(data.get("radius"));
		Boolean retval = setGeoTarget(data.get("accountId"), campaignId, latitude, longitude, radius, data.get("addr"), data.get("city"),
				data.get("state"), data.get("zip"));
		return gson.toJson(retval);
	}
	
	@Override
	public Boolean setGeoTarget(String accountId, Long campaignId, Double latitude, Double longitude, Double radius, String addr, String city,
			String state, String zip) throws Exception
	{
		AdWordsUser user = new AdWordsUser(email, password, accountId, userAgent, developerToken, useSandbox);
		semplest.service.google.adwords.Campaign c = new semplest.service.google.adwords.Campaign(accountId, campaignId, user);
		long res = 0;
		if (radius <= 0)
			res = c.setGeoLoc(state);
		else
			res = c.setGeoLoc(radius, addr, city, state, zip);
		if (res == 0)
			return false;
		return true;
	}
	
	@Override
	public Boolean updateGeoTargets(final String accountId, final Long campaignId, final List<GeoTargetObject> geoTargets) throws Exception
	{
		final AdWordsUser user = new AdWordsUser(email, password, accountId, userAgent, developerToken, useSandbox);
		final semplest.service.google.adwords.Campaign semplestCampaign = new semplest.service.google.adwords.Campaign(accountId, campaignId, user);
		semplestCampaign.removeAllGeoLoc(campaignId);
		semplestCampaign.addGeoLoc(geoTargets);
		return true;
	}

	public void updateDefaultBid(String json) throws Exception
	{
		logger.debug("call updateDefaultBid(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		Long microBid = Long.parseLong(data.get("microBid"));
		updateDefaultBid(data.get("accountID"), adGroupID, microBid);
		// convert result to Json String
	}

	@Override
	public void updateDefaultBid(String accountID, Long adGroupID, Long microBid) throws Exception
	{
		try
		{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			// Get the AdGroupCriterionService.
			AdGroupServiceInterface adGroupService = user.getService(AdWordsService.V201109.ADGROUP_SERVICE);

			// long adGroupId = Long.parseLong(a;

			// Create ad group with updated status.
			AdGroup adGroup = new AdGroup();
			adGroup.setId(adGroupID);
			// adGroup.setStatus(AdGroupStatus.ENABLED);

			// Update ad group bid.
			ManualCPCAdGroupBids adGroupBids = new ManualCPCAdGroupBids();
			Money money = new Money();
			money.setMicroAmount(microBid);
			adGroupBids.setKeywordMaxCpc(new Bid(money));
			adGroup.setBids(adGroupBids);

			// Create operations.
			AdGroupOperation operation = new AdGroupOperation();
			operation.setOperand(adGroup);
			operation.setOperator(Operator.SET);

			AdGroupOperation[] operations = new AdGroupOperation[]
			{ operation };
			AdGroupReturnValue result = adGroupService.mutate(operations);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new Exception(e);
		}

	}
	
	/*
	 * initialBudget null means unlimited amount
	 */
	public Boolean setAccountBudget(String accountID, String billingAccountID, Long initialBudgetAmount) throws Exception
	{
		AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
		//Get the BudgetOrderService
		BudgetOrderServiceInterface budgetOrderService = user.getService(AdWordsService.V201109_1.BUDGET_ORDER_SERVICE);
		//create a budget order
		BudgetOrder budgetOrder = new BudgetOrder();
		budgetOrder.setBillingAccountId(billingAccountID);
		//states now
		Calendar cal = Calendar.getInstance();
		budgetOrder.setStartDateTime(SemplestUtils.DATE_FORMAT_YYYYMMDD.format(cal.getTime()));
		//assume enddate 15 years in future
		cal.add(Calendar.YEAR, 15);
		budgetOrder.setEndDateTime(SemplestUtils.DATE_FORMAT_YYYYMMDD.format(cal.getTime()));
		//setUnlimited Budget
		if (initialBudgetAmount == null)
		{
			initialBudgetAmount = -1L;
		}
		com.google.api.adwords.v201109_1.cm.Money initialBudgetAmountMicro = new com.google.api.adwords.v201109_1.cm.Money();
		initialBudgetAmountMicro.setMicroAmount(initialBudgetAmount);
		budgetOrder.setSpendingLimit(initialBudgetAmountMicro);
		//create the Add operation
		BudgetOrderOperation budgetOrderOperation =  new BudgetOrderOperation();
		budgetOrderOperation.setOperator(com.google.api.adwords.v201109_1.cm.Operator.ADD);
		budgetOrderOperation.setOperand(budgetOrder);
		
		//run
		BudgetOrderOperation[] operations = new BudgetOrderOperation[] 
		{ budgetOrderOperation};
		BudgetOrderReturnValue result = budgetOrderService.mutate(operations);
		
		BudgetOrder[] orders = result.getValue();
		if (orders.length > 0)
		{
			logger.info("Setup Account budget for " + accountID + " On BillingAccountID=" + orders[0].getBillingAccountId() + " For "
					+ orders[0].getSpendingLimit().getMicroAmount());
			return true;
		}
		else
		{
			logger.warn("Unable to setup Account budget for " + accountID + " On BillingAccountID=" +  billingAccountID );
			return false;
		}
		
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		/*
		 * Read in the Config Data from DB into HashMap<key, Object>
		 * SemplestConfiguation.configData
		 */
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}

	}

	private Long GetActiveSitelinkExtension(String accountID, Long campaignID) throws Exception
	{
		// Get the CampaignAdExtensionService.
		AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
		CampaignAdExtensionServiceInterface campaignAdExtensionService = user.getService(AdWordsService.V201109_1.CAMPAIGN_AD_EXTENSION_SERVICE);

		// Create selector.
		com.google.api.adwords.v201109_1.cm.Selector selector = new com.google.api.adwords.v201109_1.cm.Selector();
		selector.setFields(new String[]
		{ "AdExtensionId", "CampaignId" });
		selector.setOrdering(new com.google.api.adwords.v201109_1.cm.OrderBy[]
		{ new com.google.api.adwords.v201109_1.cm.OrderBy("AdExtensionId", com.google.api.adwords.v201109_1.cm.SortOrder.ASCENDING) });
	
		// Create predicates.
		com.google.api.adwords.v201109_1.cm.Predicate campaignIdPredicate = new com.google.api.adwords.v201109_1.cm.Predicate("CampaignId",
				com.google.api.adwords.v201109_1.cm.PredicateOperator.IN, new String[]
				{ campaignID.toString() });
		selector.setPredicates(new com.google.api.adwords.v201109_1.cm.Predicate[]
		{ campaignIdPredicate });

		// Get all campaign ad extensions.
		CampaignAdExtensionPage page = campaignAdExtensionService.get(selector);

		// Display campaign ad extensions.
		if (page.getEntries() != null && page.getEntries().length > 0)
		{
			for (CampaignAdExtension campaignAdExtension : page.getEntries())
			{
				if (campaignAdExtension.getAdExtension().getAdExtensionType().equalsIgnoreCase("SitelinksExtension"))
				{
					logger.debug("Campaign ad extension with campaign id \"" + campaignAdExtension.getCampaignId() + "\", ad extension id \""
							+ campaignAdExtension.getAdExtension().getId() + "\", and type \""
							+ campaignAdExtension.getAdExtension().getAdExtensionType() + "\" was found.");

					return campaignAdExtension.getAdExtension().getId();
				}
			}
		}
		else
		{
			logger.debug("No campaign ad extensions were found.");
		}
		return null;
	}

	private void RemoveActiveSitelinkExtension(String accountID, Long campaignID, Long siteLinkExtID) throws Exception
	{
		AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
		CampaignAdExtensionServiceInterface campaignAdExtensionService = user.getService(AdWordsService.V201109_1.CAMPAIGN_AD_EXTENSION_SERVICE);

		// Create ad extension override.
		CampaignAdExtension campaignAdExtension = new CampaignAdExtension();
		campaignAdExtension.setCampaignId(campaignID);
		AdExtension adExt = new AdExtension();
		adExt.setId(siteLinkExtID);
		campaignAdExtension.setAdExtension(adExt);

		CampaignAdExtensionOperation operation = new CampaignAdExtensionOperation();
		operation.setOperand(campaignAdExtension);
		operation.setOperator(com.google.api.adwords.v201109_1.cm.Operator.REMOVE);

		CampaignAdExtensionOperation[] operations = new CampaignAdExtensionOperation[]
		{ operation };

		// Add campaign ad extension.
		CampaignAdExtensionReturnValue result = campaignAdExtensionService.mutate(operations);
		logger.debug("Removed site links");
	}

	@Override
	public Boolean addSiteLinkForCampaign(String accountID, Long campaignID, ArrayList<GoogleSiteLink> siteLinks) throws Exception
	{

		// Can have only one Site link
		Long currentID = GetActiveSitelinkExtension(accountID, campaignID);
		if (currentID != null)
		{
			RemoveActiveSitelinkExtension(accountID, campaignID, currentID);
		}
		if (siteLinks != null)
		{
			AdWordsUser user = new AdWordsUser(email, password, accountID, userAgent, developerToken, useSandbox);
			CampaignAdExtensionServiceInterface campaignAdExtensionService = user.getService(AdWordsService.V201109_1.CAMPAIGN_AD_EXTENSION_SERVICE);

			// Create ad extensionfor site links.
			Sitelink[] googleSitelinks = new Sitelink[siteLinks.size()];

			int i = 0;
			for (GoogleSiteLink gl : siteLinks)
			{
				Sitelink googleSL = new Sitelink();
				googleSL.setDestinationUrl(gl.getLinkURL());
				googleSL.setDisplayText(gl.getLinkText());
				googleSitelinks[i] = googleSL;
				i++;
			}
			SitelinksExtension siteLinksExtension = new SitelinksExtension();
			siteLinksExtension.setSitelinks(googleSitelinks);

			// Create ad extension override.
			CampaignAdExtension campaignAdExtension = new CampaignAdExtension();
			campaignAdExtension.setCampaignId(campaignID);
			campaignAdExtension.setAdExtension(siteLinksExtension);

			// Create operations.
			CampaignAdExtensionOperation operation = new CampaignAdExtensionOperation();
			operation.setOperand(campaignAdExtension);
			operation.setOperator(com.google.api.adwords.v201109_1.cm.Operator.ADD);

			CampaignAdExtensionOperation[] operations = new CampaignAdExtensionOperation[]
			{ operation };

			// Add campaign ad extension.
			CampaignAdExtensionReturnValue result = campaignAdExtensionService.mutate(operations);

			// Display ad extension overrides.
			if (result != null && result.getValue() != null)
			{
				for (CampaignAdExtension campaignAdExtensionResult : result.getValue())
				{
					logger.debug("Campaign ad extension with campaign id \"" + campaignAdExtensionResult.getCampaignId() + "\", ad extension id \""
							+ campaignAdExtensionResult.getAdExtension().getId() + "\", and type \""
							+ campaignAdExtensionResult.getAdExtension().getAdExtensionType() + "\" was added.");
				}
			}
			else
			{
				System.out.println("No campaign ad extensions were added.");
			}
		}
		return true;
	}

}
