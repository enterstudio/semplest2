package semplest.server.service.adengine;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.other.MsnManagementIds;
import semplest.server.protocol.KeywordIdRemoveOppositePair;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.SemplestMatchType;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.AdEngineAccountIdGroup;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.adengine.PromotionStatus;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.SemplestCampaignStatus;
import semplest.server.protocol.adengine.SiteLink;
import semplest.server.protocol.google.GoogleViolation;
import semplest.server.protocol.google.GoogleAdIdSemplestAdIdPair;
import semplest.server.protocol.google.GoogleAddAdRequest;
import semplest.server.protocol.google.GoogleAddAdsRequest;
import semplest.server.protocol.google.GoogleAddKeywordRequest;
import semplest.server.protocol.google.GoogleRefreshSiteLinksRequest;
import semplest.server.protocol.google.GoogleSiteLink;
import semplest.server.protocol.google.KeywordToolStats;
import semplest.server.protocol.google.UpdateAdRequest;
import semplest.server.protocol.google.UpdateAdsRequestObj;
import semplest.server.protocol.msn.MsnCreateKeywordsResponse;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.AdEngineAccountObj;
import semplest.server.service.springjdbc.AdvertisingEnginePromotionObj;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.AddBidSP;
import semplest.server.service.springjdbc.storedproc.GetAdEngineAccountSP;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;
import semplest.server.service.springjdbc.storedproc.GetKeywordForAdEngineSP;
import semplest.server.service.springjdbc.storedproc.GetSiteLinksForPromotionSP;
import semplest.server.service.springjdbc.storedproc.UpdateAdEngineAPIChargeSP;
import semplest.server.service.springjdbc.storedproc.UpdateRemainingBudgetInCycleSP;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.service.scheduler.CreateSchedulerAndTask;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.services.client.interfaces.GoogleAdwordsServiceInterface;
import semplest.services.client.interfaces.SemplestAdengineServiceInterface;
import semplest.util.SemplestUtils;

import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.BudgetLimitType;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.Keyword;

public class SemplestAdengineServiceImpl implements SemplestAdengineServiceInterface
{
	private static final Logger logger = Logger.getLogger(SemplestAdengineServiceImpl.class);
	private static Gson gson = new Gson();
	private static SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	private static Calendar cal = Calendar.getInstance();
	private static String ESBWebServerURL = null;
	private static Long AdwordsValidationAccountID = null;
	private static Long AdwordsValidationCampaignID = null;
	private static Long AdwordsValidationAdGroupID = null;
	
	private static Integer BudgetMultFactor = null;

	// private String esbURL = "http://VMDEVJAVA1:9898/semplest";

	// CustomerID = 2 State Farm coffee machine promotionID = 4
	// ProductGroupID=37 coffee machine
	public static void main(String[] args) throws Exception
	{
		try
		{

			/*
			 * GetKeywordForAdEngineSP getKeywords = new GetKeywordForAdEngineSP(); String advertisingEngine = "Google";
			 * List<KeywordProbabilityObject> keywordList = getKeywords.execute(4, (advertisingEngine.equalsIgnoreCase(AdEngine.Google.name())) ? true
			 * : false , (advertisingEngine.equalsIgnoreCase(AdEngine.MSN.name())) ? true : false); keywordList.size();
			 */
			/*
			 * GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP(); getPromoDataSP.execute(60); List<GeoTargetObject> geoObjList =
			 * getPromoDataSP.getGeoTargets(); GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl(); for (GeoTargetObject geoObj :
			 * geoObjList) { Thread.sleep(1000); google.setGeoTarget("2387614989", 88453391L, geoObj.getLatitude(), geoObj.getLongitude(),
			 * geoObj.getRadius(), geoObj.getAddress(), geoObj.getCity(), geoObj.getState(), geoObj.getZip()); logger.info("Added GeoTarget. Title=" +
			 * geoObj.getAddress());
			 * 
			 * }
			 */
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");

			ArrayList<String> adEngList = new ArrayList<String>();
			adEngList.add("Google");
			String scheduleName = "Test_OnGoingBidding2";
			// Schedule for next day at the same time

			SemplestAdengineServiceImpl adEng = new SemplestAdengineServiceImpl();
			adEng.initializeService(null);
			/*
			 * ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); SemplestSchedulerTaskObject
			 * executeOngoinBiddingTask = CreateSchedulerAndTask.ExecuteBidProcess(60, adEngList); listOfTasks.add(executeOngoinBiddingTask);
			 * CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL,listOfTasks, scheduleName, new Date(), null,
			 * ProtocolEnum.ScheduleFrequency.Now.name(), true, false, 60, null, null, null);
			 */

			final Integer customerID = 12;
			final Integer productGroupID = 76;
			final Integer PromotionID = 62;
			final List<AdEngine> adEngineList = Arrays.asList(AdEngine.MSN);
			adEng.AddPromotionToAdEngine(customerID, productGroupID, PromotionID, adEngineList);

			// adEng.scheduleOngoingBidding(scheduleName, 60, adEngList, startTime);

			// SemplestAdengineServiceImpl adEng = new SemplestAdengineServiceImpl();
			// adEng.initializeService(null);
			// Thread.sleep(1000);
			// Long micro = adEng.calculateDailyMicroBudgetFromMonthly(new
			// Double(25.0), 30);
			// String u = adEng.getURL("www.xyz.com");
			// Tovah Photography 2 47 Photography 58 38 Event and portrait
			// photos
			// adEng.AddPromotionToAdEngine(12, 76, 62, adEngList);
			// adEng.AddPromotionToAdEngine(74, 171, 183, adEngList);
			// adEng.AddPromotionToAdEngine(95,182, 197, adEngList);
			// adEng.AddPromotionToAdEngine(26,51, 60, adEngList);

		}
		catch (Exception e)
		{
			logger.error("Problem", e);
		}

	}

	@Override
	public void initializeService(String input) throws Exception
	{
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 */
		logger.info("InitializeService");
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		ESBWebServerURL = (String) SemplestConfiguration.configData.get("ESBWebServerURL");
		AdwordsValidationAccountID = (Long) SemplestConfiguration.configData.get("AdwordsValidationAccountID");
		AdwordsValidationCampaignID = (Long) SemplestConfiguration.configData.get("AdwordsValidationCampaignID");
		AdwordsValidationAdGroupID = (Long) SemplestConfiguration.configData.get("AdwordsValidationAdGroupID");		
		BudgetMultFactor = (Integer) SemplestConfiguration.configData.get("SemplestBiddingBudgetMultFactor");

	}

	public String AddPromotionToAdEngine(String json) throws Exception
	{
		logger.debug("JSON: [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer productGroupID = Integer.parseInt(data.get("productGroupID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		AddPromotionToAdEngine(customerID, productGroupID, promotionID, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Add Promotion To AdEngines for CustomerID [" + customerID + "], ProductGroupID [" + productGroupID + "], PromotionID [" + PromotionID + "], AdEngines [" + adEngines + "]");
		/*
		 * TODO: break up this method into separate steps as per below
		 * 
		 * // 1. Create Account - AdWordsService.V201109.CREATE_ACCOUNT_SERVICE // 2. Create Campaign - AdWordsService.V201109.CAMPAIGN_SERVICE // 3.
		 * Create AdGroup - AdWordsService.V201109.ADGROUP_SERVICE // 4. Create Ads - AdWordsService.V201109.ADGROUP_AD_SERVICE // 5. Set GeoTargets -
		 * AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE // 6. Set Negative Keywords - AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE // 7. Set
		 * Keywords - AdWordsService.V201109.ADGROUP_CRITERION_SERVICE // 8. Service call -
		 * semplest.service.bidding.BidGeneratorService#setBidsInitial // 9. Schedule OnGoingBidding
		 */
		SemplestDB.updatePromotionStatus(PromotionID, adEngines, PromotionStatus.PENDING);
		final SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient(ESBWebServerURL, getTimeoutMS());
		final Map<AdEngine, AdEngineInitialData> adEngineInitialMap = bidClient.getInitialValues(PromotionID, adEngines);
		final GetKeywordForAdEngineSP getKeywords = new GetKeywordForAdEngineSP();
		final Map<AdEngine, HashMap<String, Object>> remainingBudgetDaysMap = setupAdEngineBudget(PromotionID, adEngines, bidClient);
		String companyName = null;
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		getPromoDataSP.execute(PromotionID);
		for (final AdEngine advertisingEngine : adEngines)
		{
			Long accountID = null;
			final AdEngineInitialData adEngineInitialData = adEngineInitialMap.get(advertisingEngine);
			logger.info("AdEngine Initial Data found: [" + adEngineInitialData + "]");
			GetAdEngineAccountSP getAdEngineAccount = new GetAdEngineAccountSP();
			AdEngineAccountObj AdEngineAccoutRow = getAdEngineAccount.execute(customerID, advertisingEngine);
			companyName = AdEngineAccoutRow.getCustomerName();
			if (AdEngineAccoutRow.getAccountID() == null)
			{
				final AdEngineAccountIdGroup idGroup = createAdEngineAccount(advertisingEngine, companyName);
				accountID = idGroup.getAccountId();
				final String accountNumber = idGroup.getAccountNumber();
				SemplestDB.addAdEngineAccountID(customerID, accountNumber, accountID, advertisingEngine);
				logger.info("Created Account for " + companyName + ":" + idGroup);
			}
			else
			{
				accountID = AdEngineAccoutRow.getAccountID();
				logger.info("Found Account for " + companyName + ":" + String.valueOf(accountID));
			}
			final AdvertisingEnginePromotionObj promotionDataList = SemplestDB.getAdvertisingEngineCampaign(accountID, PromotionID);
			if (promotionDataList != null)
			{
				throw new Exception("A Campaign has already been created for the Promotion " + PromotionID);
			}
			else
			{
				// Create Campaign
				final Double budget = (Double) remainingBudgetDaysMap.get(advertisingEngine).get("RemainingBudgetInCycle");
				final Integer daysLeft = (Integer) remainingBudgetDaysMap.get(advertisingEngine).get("RemainingDays");
				final Long campaignID = createCampaign(String.valueOf(accountID), PromotionID, customerID, advertisingEngine, budget, getPromoDataSP, daysLeft);
				SemplestDB.addPromotionToAdEngineAccountID(PromotionID, accountID, campaignID, null);
				// Create Ad group and Ads
				final AdgroupData adGroupData = createAdGroupAndAds(String.valueOf(accountID), campaignID, advertisingEngine, AdGroupStatus.ENABLED, getPromoDataSP, adEngineInitialData.getDefaultMicroBid());
				storeAdGroupData(advertisingEngine, campaignID, adGroupData);
				// Keywords
				final List<KeywordProbabilityObject> keywordList = getKeywords.execute(PromotionID, advertisingEngine == AdEngine.Google, advertisingEngine == AdEngine.MSN);
				final String semplestMatchType = adEngineInitialData.getSemplestMatchType();
				addKeywordsToAdGroup(String.valueOf(accountID), campaignID, PromotionID, adGroupData.getAdGroupID(), advertisingEngine, keywordList, semplestMatchType, null);
				// Set initial bidding
				final BudgetObject budgetData = new BudgetObject();
				budgetData.setRemainingBudgetInCycle(budget);
				budgetData.setRemainingDays(daysLeft);
				
				logger.info("About to Set Initial Bids for " + advertisingEngine);
				bidClient.setBidsInitial(PromotionID, advertisingEngine, budgetData);
				logger.info("Done setting Initial Bids for " + advertisingEngine);
				
				// Schedule ongoing bidding
				final String scheduleName = getPromoDataSP.getPromotionData().getPromotionName() + "_OnGoingBidding";
				cal.setTime(new Date());
				cal.add(Calendar.DAY_OF_MONTH, 1);
				final Date startTime = cal.getTime();
				logger.info("Abiout to schedule ongoing bidding for " + advertisingEngine);
				scheduleOngoingBidding(scheduleName, PromotionID, adEngines, startTime);
				logger.info("Scheduled ongoing bidding for " + advertisingEngine);
			}
			SemplestDB.updatePromotionStatus(PromotionID, advertisingEngine, PromotionStatus.LIVE);
		}
		logger.info("Done");
		return true;
	}

	private String getTimeoutMS()
	{
		String bidTimeoutMS = null;
		Object timeout = SemplestConfiguration.configData.get("SemplestClientBiddingTimeoutMS");
		if (timeout != null)
		{
			bidTimeoutMS = String.valueOf((Integer) timeout);
		}
		return bidTimeoutMS;
	}

	/*
	 * schedules the on-going bidding
	 */
	private void scheduleOngoingBidding(String scheduleName, int promotionID, List<AdEngine> adEngines, Date startTime) throws Exception
	{

		ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
		SemplestSchedulerTaskObject executeOngoinBiddingTask = CreateSchedulerAndTask.ExecuteBidProcess(promotionID, adEngines);
		listOfTasks.add(executeOngoinBiddingTask);
		CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, startTime, null, ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, promotionID, null, null, null);
		// *****TEST
		// CreateSchedulerAndTask.createScheduleAndRun(listOfTasks,
		// scheduleName, new Date(), null,
		// ProtocolEnum.ScheduleFrequency.TenMinutes.name(), true, false,
		// promotionID, null, null, null);
	}

	/*
	 * store the adGroupID and AdIDs
	 */
	private void storeAdGroupData(AdEngine advertisingEngine, Long campaignID, AdgroupData adGroupData) throws Exception
	{
		SemplestDB.setAdvertisingEngineAdGroupID(campaignID, adGroupData.getAdGroupID());
		List<AdsObject> adList = adGroupData.getAds();
		for (AdsObject adObj : adList)
		{
			SemplestDB.setAdIDForAdGroup(adObj.getAdEngineAdID(), advertisingEngine, adObj.getPromotionAdsPK());
		}
	}

	public String scheduleDeleteNegativeKeywords(String json) throws Exception
	{
		logger.debug("call scheduleDeleteNegativeKeywords(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String keywordIdRemoveOppositePairsString = data.get("keywordIds");
		final List<Integer> keywordIds = gson.fromJson(keywordIdRemoveOppositePairsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleDeleteNegativeKeywords(customerID, promotionID, keywordIds, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleDeleteNegativeKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Delete Negative Keywords for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "], " + keywordIds.size() + " KeywordIds [" + keywordIds + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "DeleteNegativeKeywords";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createDeleteNegativeKeywordTask(customerID, promotionID, keywordIds, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Delete Negative Keywords for Customer [" + customerID + "], PromotionID [" + promotionID + "], " + keywordIds.size() + " KeywordIds [" + keywordIds + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String DeleteNegativeKeywords(String json) throws Exception
	{
		logger.debug("call DeleteNegativeKeywords(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<Integer> keywordIds = gson.fromJson(data.get("keywordIds"), SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineString = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineString);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineString);
		DeleteNegativeKeywords(promotionID, keywordIds, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean DeleteNegativeKeywords(Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Delete Negative Keywords for PromotionID [" + promotionID + "], AdEngines [" + adEngines + "], and KeywordIds [" + keywordIds + "]");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		getPromoDataSP.execute(promotionID);
		final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
		final GetKeywordForAdEngineSP getKeywordForAdEngineSP = new GetKeywordForAdEngineSP();
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		final String esbServerTimeout = getTimeoutMS();
		final SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient(ESBWebServerURL, esbServerTimeout);
		final Map<AdEngine, AdEngineInitialData> adEngineInitialMap = bidClient.getInitialValues(promotionID, adEngines);
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountId = "" + adEngineData.getAccountID();
				final Long campaignId = adEngineData.getCampaignID();
				final AdEngineInitialData adEngineInitialData = adEngineInitialMap.get(adEngine);
				final String semplestMatchType = adEngineInitialData.getSemplestMatchType();
				final String keywordMatchTypeString = SemplestMatchType.getSearchEngineMatchType(semplestMatchType, adEngine);
				final KeywordMatchType keywordMatchType = KeywordMatchType.fromString(keywordMatchTypeString);
				final List<KeywordProbabilityObject> keywordProbabilities = getKeywordForAdEngineSP.execute(promotionID, true, false);
				final List<String> keywords = getKeywords(keywordProbabilities, keywordIds);
				logger.info("Generated " + keywords.size() + " Keyword strings out of " + keywordProbabilities.size() + " KeywordProbabilities that were found in database");
				final GoogleAdwordsServiceInterface googleAdwordsService = new GoogleAdwordsServiceImpl();
				googleAdwordsService.deleteNegativeKeywords(accountId, campaignId, keywords, keywordMatchType);
			}
			else if (AdEngine.MSN == adEngine)
			{
				final String errMsg = "MSN doesn't support deleting negative keywords directly.  You need to simply call the AddNegativeKeywords with the keywords that should reamins (MSN will delete the rest).";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Deleting Negative Keywords (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errMsg = "Summary of errors when trying to Delete Negative Keywords for PromotionID [" + promotionID + "], AdEngines [" + adEngines + "], KeywordIds [" + keywordIds + "]:\n" + SemplestUtils.getEasilyReadableString(errorMap);
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public String DeleteKeywords(String json) throws Exception
	{
		logger.debug("call DeleteKeywords(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer PromotionID = Integer.parseInt(data.get("promotionID"));
		final List<Integer> keywordIds = gson.fromJson(data.get("keywordIds"), SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		DeleteKeywords(PromotionID, keywordIds, adEngines);
		return gson.toJson(true);
	}

	public static List<String> getKeywords(final List<KeywordProbabilityObject> keywordProbabilities, List<Integer> keywordIds)
	{
		final List<String> keywords = new ArrayList<String>();
		for (final KeywordProbabilityObject keywordProbability : keywordProbabilities)
		{
			final Integer keywordPK = keywordProbability.getKeywordPK();
			if (keywordIds.contains(keywordPK))
			{
				final String keyword = keywordProbability.getKeyword();
				keywords.add(keyword);
			}
		}
		return keywords;
	}

	public List<KeywordProbabilityObject> getKeywordProbabilitiesForKeywordIds(List<KeywordProbabilityObject> keywordProbabilities, List<Integer> keywordIds)
	{
		final List<KeywordProbabilityObject> keywordProbabilitiesForKeywordIds = new ArrayList<KeywordProbabilityObject>();
		for (final KeywordProbabilityObject keywordProbability : keywordProbabilities)
		{
			final Integer keywordPK = keywordProbability.getKeywordPK();
			if (keywordIds.contains(keywordPK))
			{
				keywordProbabilitiesForKeywordIds.add(keywordProbability);
			}
		}
		return keywordProbabilitiesForKeywordIds;
	}

	@Override
	public Boolean DeleteKeywords(Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Delete Keywords for PromotionID [" + promotionID + "], AdEngines [" + adEngines + "], and KeywordIds [" + keywordIds + "]");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final Map<AdEngine, AdEngineID> promotionAdEngineData = getPromoDataSP.getPromotionAdEngineID(promotionID);
		final GetKeywordForAdEngineSP getKeywordForAdEngineSP = new GetKeywordForAdEngineSP();
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineData.get(adEngine);
				final String accountId = "" + adEngineData.getAccountID();
				final Long adGroupID = adEngineData.getAdGroupID();
				final List<KeywordProbabilityObject> keywordProbabilities = getKeywordForAdEngineSP.execute(promotionID, true, false);
				final List<String> keywords = getKeywords(keywordProbabilities, keywordIds);
				final GoogleAdwordsServiceInterface googleAdwordsService = new GoogleAdwordsServiceImpl();
				googleAdwordsService.deleteKeyWords(accountId, adGroupID, keywords);
			}
			else if (AdEngine.MSN == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineData.get(adEngine);
				final Long accountId = adEngineData.getAccountID();
				final Long adGroupId = adEngineData.getAdGroupID();
				final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
				final List<KeywordProbabilityObject> keywordProbabilities = getKeywordForAdEngineSP.execute(promotionID, false, true);
				final List<KeywordProbabilityObject> keywordProbabilitiesForKeywordIds = getKeywordProbabilitiesForKeywordIds(keywordProbabilities, keywordIds);
				logger.info("Out of the following " + keywordProbabilities.size() + " KeywordProbabilities, found " + keywordProbabilitiesForKeywordIds.size() + " for KeywordIds [" + keywordIds + "]");
				final List<BidElement> bids = SemplestDB.getLatestBids(promotionID, adEngine);
				final List<Long> msnKeywordIds = new ArrayList<Long>();
				for (final KeywordProbabilityObject keywordProbability : keywordProbabilitiesForKeywordIds)
				{
					final String kpText = keywordProbability.getKeyword();
					for (final BidElement bid : bids)
					{
						final String keyword = bid.getKeyword();
						if (kpText.equals(keyword))
						{
							final Long msnKeywordId = bid.getKeywordAdEngineID();
							msnKeywordIds.add(msnKeywordId);
						}
					}
				}
				logger.info("Will try to delete MSN keywords for MSN IDs [" + msnKeywordIds + "]");
				final long[] msnKeywordIdArray = new long[msnKeywordIds.size()];
				for (int i = 0; i < msnKeywordIdArray.length; ++i)
				{
					msnKeywordIdArray[i] = msnKeywordIds.get(i);
				}
				msn.deleteKeywordsById(accountId, adGroupId, msnKeywordIdArray);
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Deleting Keywords (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		final Map<Integer, String> keywordIdToCommentMap = new HashMap<Integer, String>();
		for (final Integer keywordId : keywordIds)
		{
			keywordIdToCommentMap.put(keywordId, "deleted by request");
		}
		SemplestDB.markKeywordDeletedBulk(keywordIdToCommentMap, promotionID);
		if (!errorMap.isEmpty())
		{
			final String errMsg = "Summary of errors when trying to Delete Keywords for PromotionID [" + promotionID + "], AdEngines [" + adEngines + "], KeywordIds [" + keywordIds + "]:\n" + SemplestUtils.getEasilyReadableString(errorMap);
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public List<KeywordProbabilityObject> getKeywordProbabilities(final List<KeywordProbabilityObject> keywordList, final Boolean isNegative)
	{
		final List<KeywordProbabilityObject> keywordProbabilities = new ArrayList<KeywordProbabilityObject>();
		for (final KeywordProbabilityObject keywordProbability : keywordList)
		{
			if (keywordProbability.getIsNegative() == isNegative)
			{
				keywordProbabilities.add(keywordProbability);
			}
		}
		return keywordProbabilities;
	}

	public List<GoogleAddKeywordRequest> getAddKeywordRequests(final List<KeywordProbabilityObject> keywordProbabilities, final KeywordMatchType keywordMatchType, final Long microBidAmount)
	{
		final List<GoogleAddKeywordRequest> addKeywordRequests = new ArrayList<GoogleAddKeywordRequest>();
		for (final KeywordProbabilityObject keywordProbability : keywordProbabilities)
		{
			final String keyword = keywordProbability.getKeyword();
			final Integer keywordPK = keywordProbability.getKeywordPK();
			final GoogleAddKeywordRequest request = new GoogleAddKeywordRequest(keyword, keywordPK, keywordMatchType, microBidAmount);
			addKeywordRequests.add(request);
		}
		return addKeywordRequests;
	}

	private void addKeywordsToAdGroup(String accountID, Long campaignID, Integer promotionID, Long adGroupID, AdEngine adEngine, List<KeywordProbabilityObject> keywordList, final String semplestMatchType, Long microBidAmount) throws Exception
	{
		logger.info("Will try to add keywords to ad group for AccountID [" + accountID + "], CampaignID [" + campaignID + "], PromotionID [" + promotionID + "], AdGroupID [" + adGroupID + "], AdEngine [" + adEngine + "], SemplestMatchType [" + semplestMatchType + "], MicroBidAmount ["
				+ microBidAmount + "], " + keywordList.size() + " Keywords [<not printing because can be way too many to realistically print>]");
		AddBidSP addKeywordBidSP = new AddBidSP();
		if (adEngine == AdEngine.Google)
		{
			final String keywordMatchTypeString = SemplestMatchType.getSearchEngineMatchType(semplestMatchType, adEngine);
			final KeywordMatchType keywordMatchType = KeywordMatchType.fromString(keywordMatchTypeString);
			// assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			int counter = 0;
			final List<KeywordProbabilityObject> regularKeywordProbabilities = getKeywordProbabilities(keywordList, false);
			final List<KeywordProbabilityObject> negativeKeywordProbabilities = getKeywordProbabilities(keywordList, true);
			// Add Negative Keywords
			for (KeywordProbabilityObject negativeKeyword : negativeKeywordProbabilities)
			{
				final String negativeKeywordText = negativeKeyword.getKeyword();
				KeywordDataObject keywordDataObj = google.addNegativeKeyWordToAdGroup(accountID, campaignID, negativeKeywordText, keywordMatchType);
				final Long keywordBidID = keywordDataObj.getBidID();
				logger.info(++counter + ": will try to save in db Google Negative Keyword for GoogleID [" + keywordBidID + "], Text [" + negativeKeywordText + "], PromotionID [" + promotionID + "], SemplestMatchType [" + semplestMatchType + "], IsNegative [" + true + "]");
				final Long microBidAmt = keywordDataObj.getMicroBidAmount();
				final int microBidIntValue = microBidAmt == null ? 0 : microBidAmt.intValue();
				Integer ret = addKeywordBidSP.execute(promotionID, keywordDataObj.getBidID(), keywordDataObj.getKeyword(), microBidIntValue, keywordDataObj.getMatchType(), adEngine, true, null, true);
				Thread.sleep(1000); // Wait for google
			}
			// Add Positive Keywords
			final List<GoogleAddKeywordRequest> positiveKeywordRequests = getAddKeywordRequests(regularKeywordProbabilities, keywordMatchType, 0L);
			final List<List<GoogleAddKeywordRequest>> positiveKeywordRequestBatches = SemplestUtils.getBatches(positiveKeywordRequests, 500);
			final Map<GoogleAddKeywordRequest, Long> requestToGoogleIdMap = new HashMap<GoogleAddKeywordRequest, Long>();
			for (final List<GoogleAddKeywordRequest> requestBatch : positiveKeywordRequestBatches)
			{
				final Map<GoogleAddKeywordRequest, Long> requestToGoogleIdMapForBatch = google.addKeywords(accountID, adGroupID, requestBatch, promotionID);
				requestToGoogleIdMap.putAll(requestToGoogleIdMapForBatch);
			}
			logger.info("Generated total of " + requestToGoogleIdMap.size() + " GoogleAddKeywordRequest<->GoogleKeywordId mappings");
			final Set<Entry<GoogleAddKeywordRequest, Long>> entrySet = requestToGoogleIdMap.entrySet();
			counter = 0;
			for (final Entry<GoogleAddKeywordRequest, Long> entry : entrySet)
			{
				final GoogleAddKeywordRequest request = entry.getKey();
				final Long googleKeywordId = entry.getValue();
				final String keyword = request.getKeyword();
				final Long microBidAmt = request.getMicroBidAmount();
				final int microBidIntValue = microBidAmt == null ? 0 : microBidAmt.intValue();
				final String matchType = request.getMatchType().toString();
				logger.info(++counter + ": will try to save in db Google Positive Keyword for GoogleID [" + googleKeywordId + "], Text [" + keyword + "], PromotionID [" + promotionID + "], SemplestMatchType [" + matchType + "], IsNegative [" + false + "]");
				Integer ret = addKeywordBidSP.execute(promotionID, googleKeywordId, keyword, microBidIntValue, matchType, adEngine, false, null, true);
			}
		}
		else if (AdEngine.MSN == adEngine)
		{
			final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
			final Long accId = Long.valueOf(accountID);
			int counter = 0;

			final List<KeywordProbabilityObject> regularKeywordProbabilities = getKeywordProbabilities(keywordList, false);
			final List<KeywordProbabilityObject> negativeKeywordProbabilities = getKeywordProbabilities(keywordList, true);
			final Map<com.microsoft.adcenter.v8.Keyword, Integer> regularKeywordsToPkMap = new HashMap<com.microsoft.adcenter.v8.Keyword, Integer>();
			for (final KeywordProbabilityObject keyword : regularKeywordProbabilities)
			{
				final String keywordText = keyword.getKeyword();
				final Integer keywordPK = keyword.getKeywordPK();
				final Bid bid = new Bid();
				final Double bidAmount = SemplestUtils.MSN_DEFAULT_BID_AMOUNT;
				bid.setAmount(bidAmount);
				final SemplestMatchType semplestMatchTypeEnum = SemplestMatchType.valueOf(semplestMatchType);
				final com.microsoft.adcenter.v8.Keyword msnKeyword;
				if (semplestMatchTypeEnum == SemplestMatchType.Broad)
				{
					msnKeyword = msn.getKeyword(accId, adGroupID, keywordText, MatchType.Broad, bid);
				}
				else if (semplestMatchTypeEnum == SemplestMatchType.Exact)
				{
					msnKeyword = msn.getKeyword(accId, adGroupID, keywordText, MatchType.Exact, bid);
				}
				else if (semplestMatchTypeEnum == SemplestMatchType.Phrase)
				{
					msnKeyword = msn.getKeyword(accId, adGroupID, keywordText, MatchType.Phrase, bid);
				}
				else
				{
					throw new Exception("[" + semplestMatchType + "] is not a known SemplestMatchType");
				}
				regularKeywordsToPkMap.put(msnKeyword, keywordPK);
			}
			// Add Positive Keywords
			final int batchSize = 1000;
			final List<Map<com.microsoft.adcenter.v8.Keyword, Integer>> keywordBatches = SemplestUtils.getBatches(regularKeywordsToPkMap, batchSize);
			logger.info("Out of " + regularKeywordsToPkMap.size() + " MSN keywords, created " + keywordBatches.size() + " batches of max " + batchSize);
			for (final Map<com.microsoft.adcenter.v8.Keyword, Integer> batch : keywordBatches)
			{
				final MsnCreateKeywordsResponse response = msn.createKeywords(accId, adGroupID, batch);
				final Map<String, Long> keywordToMsnIdMap = response.getKeywordToMsnIdMap();
				final Map<Integer, String> filteredOutKeywordIdsToCommentMap = response.getFilteredOutKeywordPkToCommentMap();
				logger.info("Successfully created Keywords in MSN (KeywordText<->MsnID):\n" + SemplestUtils.getEasilyReadableString(keywordToMsnIdMap) + "\n\nCould not create these Keywords in MSN (KeywordPK<->Comment):\n" + SemplestUtils.getEasilyReadableString(filteredOutKeywordIdsToCommentMap));
				// Mark as Deleted in DB for Keywords that could not be added to MSN
				SemplestDB.removeKeywordFromAdEngine(filteredOutKeywordIdsToCommentMap, promotionID, adEngine);
				// Persist MsnKeywordID in DB for Keywords that were added to MSN
				final Set<Entry<String, Long>> keywordToMsnIdEntrySet = keywordToMsnIdMap.entrySet();				
				for (final Entry<String, Long> entry : keywordToMsnIdEntrySet)
				{
					final String text = entry.getKey();
					final Long keywordId = entry.getValue();
					logger.info(++counter + ": will try to save in db MSN Keyword for MsnKeywordID [" + keywordId + "], Text [" + text + "], PromotionID [" + promotionID + "], SemplestMatchType [" + semplestMatchType + "], IsNegative [" + false + "]");
					Integer ret = addKeywordBidSP.execute(promotionID, keywordId, text, SemplestUtils.MSN_DEFAULT_BID_MIRCOAMOUNT.intValue(), semplestMatchType, adEngine, false, null, true);
				}				
			}
			// Add Negative Keywords
			if (!negativeKeywordProbabilities.isEmpty())
			{
				logger.info("Will try to add " + negativeKeywordProbabilities.size() + " Negative Keywords to MSN");
				final List<String> keywordTexts = getKywordTextList(negativeKeywordProbabilities);
				msn.setNegativeKeywords(accId, campaignID, keywordTexts);
			}
		}
		else
		{
			throw new Exception("AdEngine specified [" + adEngine + "] is not valid for Adding Keywords to AdGroup (at least not yet)");
		}
	}

	private List<String> getKywordTextList(final List<KeywordProbabilityObject> keywords)
	{
		final List<String> keywordTextList = new ArrayList<String>();
		for (final KeywordProbabilityObject keyword : keywords)
		{
			final String keywordText = keyword.getKeyword();
			keywordTextList.add(keywordText);
		}
		return keywordTextList;
	}

	private Map<AdEngine, HashMap<String, Object>> setupAdEngineBudget(Integer PromotionID, List<AdEngine> adEngines, SemplestBiddingServiceClient bidClient) throws Exception
	{
		Map<AdEngine, HashMap<String, Object>> remainingBudgetDaysMap = new HashMap<AdEngine, HashMap<String, Object>>();
		Map<AdEngine, Double> AdEngineBudgetPercent = bidClient.GetMonthlyBudgetPercentPerSE(PromotionID, adEngines);
		BudgetObject remainingBudget = SemplestDB.getBudget(PromotionID);
		Iterator<AdEngine> adEngineIT = AdEngineBudgetPercent.keySet().iterator();
		while (adEngineIT.hasNext())
		{
			AdEngine adEng = adEngineIT.next();
			Double budgetSplit = remainingBudget.getRemainingBudgetInCycle() * (0.01 * AdEngineBudgetPercent.get(adEng));
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("RemainingBudgetInCycle", budgetSplit);
			data.put("RemainingDays", remainingBudget.getRemainingDays());
			remainingBudgetDaysMap.put(adEng, data);
		}
		return remainingBudgetDaysMap;
	}

	public static void backfillAdEngineAdID(final List<AdsObject> ads, final Map<GoogleAddAdRequest, Long> requestToAdEngineAdIdMap)
	{
		for (final AdsObject ad : ads)
		{
			final Integer promotionAdID = ad.getPromotionAdsPK();
			final String headline = ad.getAdTitle();
			final String description1 = ad.getAdTextLine1();
			final String description2 = ad.getAdTextLine2();
			final GoogleAddAdRequest textRequestKey = new GoogleAddAdRequest(promotionAdID, headline, description1, description2);
			final Long adEngineAdID = requestToAdEngineAdIdMap.get(textRequestKey);
			logger.info("Found GoogleAdID [" + adEngineAdID + "] for [" + textRequestKey + "]");
			ad.setAdEngineAdID(adEngineAdID);
		}
	}

	public static List<AdsObject> getNonDeletedAds(final List<AdsObject> ads)
	{
		final List<AdsObject> nonDeletedAds = new ArrayList<AdsObject>();
		for (final AdsObject ad : ads)
		{
			if (!ad.isIsDeleted())
			{
				nonDeletedAds.add(ad);
			}
		}
		return nonDeletedAds;
	}

	private AdgroupData createAdGroupAndAds(String accountID, Long campaignID, AdEngine adEngine, AdGroupStatus status, GetAllPromotionDataSP getPromoDataSP, Long defaultMicroBid) throws Exception
	{
		logger.info("Will try AdGroup and Ads for AccountID [" + accountID + "], CampaignID [" + campaignID + "], AdEngine [" + adEngine + "], AdGroupStatus [" + status + "], DefaultMicroBid [" + defaultMicroBid + "]");
		AdgroupData adGrpData = new AdgroupData();
		List<AdsObject> adList = getPromoDataSP.getAds();
		PromotionObj promotionData = getPromoDataSP.getPromotionData();
		final String displayURL = promotionData.getDisplayURL();
		final String url = promotionData.getLandingPageURL();
		Long adGroupID = null;
		final List<GeoTargetObject> geoObjList = getPromoDataSP.getGeoTargets();
		final List<AdsObject> nonDeletedAds = getNonDeletedAds(adList);
		if (adEngine == AdEngine.Google)
		{
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			adGroupID = google.AddAdGroup(accountID, campaignID, promotionData.getPromotionName() + "_AdGroup", status, defaultMicroBid);
			adGrpData.setAdGroupID(adGroupID);
			final List<GoogleAddAdRequest> textRequests = new ArrayList<GoogleAddAdRequest>();
			for (AdsObject ad : nonDeletedAds)
			{
				final Integer promotionAdID = ad.getPromotionAdsPK();
				final String headline = SemplestUtils.getTrimmedNonNullString(ad.getAdTitle());
				final String description1 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine1());
				final String description2 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine2());
				final GoogleAddAdRequest textRequest = new GoogleAddAdRequest(promotionAdID, headline, description1, description2);
				textRequests.add(textRequest);
			}
			final GoogleAddAdsRequest request = new GoogleAddAdsRequest(accountID, adGroupID, displayURL, url, textRequests);
			final Map<GoogleAddAdRequest, Long> requestToGoogleAdIdMap = google.addTextAds(request);
			logger.info("Added " + requestToGoogleAdIdMap.size() + " Google ads in bulk:\n" + SemplestUtils.getEasilyReadableString(requestToGoogleAdIdMap));
			backfillAdEngineAdID(nonDeletedAds, requestToGoogleAdIdMap);
			adGrpData.setAds(nonDeletedAds);
			google.updateGeoTargets(accountID, campaignID, geoObjList);
			logger.info("Added Google GeoTargets: " + geoObjList);
		}
		else if (adEngine == AdEngine.MSN)
		{
			final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
			final Long msnAccountId = Long.valueOf(accountID);
			adGroupID = msn.createAdGroup(msnAccountId, campaignID);
			logger.info("Created MSN AdGroup with ID [" + adGroupID + "]");
			int counter = 0;
			for (AdsObject ad : nonDeletedAds)
			{
				final String title = SemplestUtils.getTrimmedNonNullString(ad.getAdTitle());
				final String text1 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine1());
				final String text2 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine2());
				final String text = text1 + " " + text2;
				final Long msnAdId = msn.createAd(msnAccountId, adGroupID, title, text, displayURL, url);
				logger.info(++counter + ": got the MSN Ad ID [" + msnAdId + "] after creating this Ad in MSN for AdGroupID [" + adGroupID + "]: [" + ad + "]");
				ad.setAdEngineAdID(msnAdId);
			}
			adGrpData.setAdGroupID(adGroupID);
			adGrpData.setAds(nonDeletedAds);
			for (final GeoTargetObject geoTarget : geoObjList)
			{
				final Long accountId = Long.valueOf(accountID);
				Double latitude = geoTarget.getLatitude();
				Double longitude = geoTarget.getLongitude();
				Double radius = geoTarget.getRadius();
				String addr = geoTarget.getAddress();
				String city = geoTarget.getCity();
				String state = geoTarget.getState();
				String country = "US";
				String zip = geoTarget.getZip();
				msn.setGeoTarget(accountId, campaignID, latitude, longitude, radius, addr, city, state, country, zip);
				logger.info("Added MSN GeoTarget: " + geoTarget);
			}
		}
		else
		{
			throw new Exception("AdEngine [" + adEngine + "] is not supported for adding AdGroup and Adds");
		}
		return adGrpData;
	}

	private class AdgroupData
	{
		private Long adGroupID;
		private List<AdsObject> ads = new ArrayList<AdsObject>();
		private List<GeoTargetObject> geoTargetList = new ArrayList<GeoTargetObject>();

		public Long getAdGroupID()
		{
			return adGroupID;
		}

		public void setAdGroupID(Long adGroupID)
		{
			this.adGroupID = adGroupID;
		}

		public List<AdsObject> getAds()
		{
			return ads;
		}

		public void setAds(List<AdsObject> ads)
		{
			this.ads = ads;
		}

		public List<GeoTargetObject> getGeoTargetList()
		{
			return geoTargetList;
		}

		public void setGeoTargetList(List<GeoTargetObject> geoTargetList)
		{
			this.geoTargetList = geoTargetList;
		}

	}

	/*
	 * Assumes Daily budget
	 */
	private Long createCampaign(String accountID, Integer promotionID, Integer customerID, AdEngine adEngine, Double monthlyBudgetAmount, GetAllPromotionDataSP getPromoDataSP, Integer remainingDaysInCycle) throws Exception
	{
		logger.info("Will try to create campaign for AccountID [" + accountID + "], PromotionID [" + promotionID + "], CustomerID [" + customerID + "], AdEngine [" + adEngine + "], MonthlyBudgetAmount [" + monthlyBudgetAmount + "], RemainingDaysInCycle [" + remainingDaysInCycle + "]");
		if (monthlyBudgetAmount < 0)
		{
			throw new IllegalArgumentException("Cannot process request to create campaign for AccountID [" + accountID + "], PromotionID [" + promotionID + "], CustomerID [" + customerID + "], AdEngine [" + adEngine + "], RemainingDaysInCycle [" + remainingDaysInCycle
					+ "] because MonthlyBudgetAmount [" + monthlyBudgetAmount + "] is less than 0");
		}
		final String campaignName = System.currentTimeMillis() + "_" + getPromoDataSP.getPromotionData().getPromotionName();
		if (adEngine == AdEngine.Google)
		{
			// assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			Long microbudgetAmount = calculateDailyMicroBudgetFromMonthly(monthlyBudgetAmount, remainingDaysInCycle);
			Campaign campaign = google.CreateOneCampaignForAccount(accountID, campaignName, com.google.api.adwords.v201109.cm.CampaignStatus.ACTIVE, BudgetBudgetPeriod.DAILY, microbudgetAmount);
			return campaign.getId();
		}
		else if (adEngine == AdEngine.MSN)
		{
			MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
			double dailybudgetAmount = calculateDailyBudgetFromMonthly(monthlyBudgetAmount, remainingDaysInCycle);
			final Long accountId = Long.valueOf(accountID);
			final BudgetLimitType budgetLimitType = BudgetLimitType.DailyBudgetStandard;
			final double monthlyBudget = monthlyBudgetAmount.doubleValue();
			final CampaignStatus campaignStatus = com.microsoft.adcenter.v8.CampaignStatus.Active;
			logger.info("About to call CreateCampaign on MSN implementation with AccountID [" + accountId + "], campaignName [" + campaignName + "], BudgetLimitType [" + budgetLimitType + "], DailyBudgetAmount [" + dailybudgetAmount + "], MonthlyBudget [" + monthlyBudget + "], CampaignStatus ["
					+ campaignStatus + "]");
			Long campaignID = msn.createCampaign(accountId, campaignName, budgetLimitType, dailybudgetAmount, monthlyBudget, campaignStatus);
			return campaignID;
		}
		else
		{
			throw new Exception(adEngine + " Not found to create account");
		}

	}

	private Long calculateDailyMicroBudgetFromMonthly(Double monthlyBudget, Integer remainingDaysInCycle)
	{
		final Double daily = ((BudgetMultFactor * monthlyBudget) / remainingDaysInCycle.doubleValue()) * 100.;
		final BigDecimal bd = new BigDecimal(daily);
		return (bd.longValue() * 10000L);
	}

	private Double calculateDailyBudgetFromMonthly(Double monthlyBudget, Integer remainingDaysInCycle)
	{
		Double daily = (BudgetMultFactor * monthlyBudget) / remainingDaysInCycle.doubleValue();
		return daily;
	}

	private AdEngineAccountIdGroup createAdEngineAccount(AdEngine adEngine, String companyName) throws Exception
	{
		logger.info("Will try to Create AdEngine Account with AdEngine [" + adEngine + "], CompanyName [" + companyName + "]");
		if (adEngine == AdEngine.Google)
		{
			// assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			Account account = google.CreateOneAccountService(null, null, companyName, "Semplest account for " + companyName);
			String googleBillingAccount = (String) SemplestConfiguration.configData.get("AdwordsBillingAccount");
			try
			{
				if (google.setAccountBudget(String.valueOf(account.getCustomerId()), googleBillingAccount, null))
				{
					logger.info("Setup unlimited budget at the account level");
				}
				else
				{
					logger.warn("Unable to setup budget at the account level");
				}
			}
			catch (Exception e)
			{
				logger.error("Error Setting up Budget at the account level ", e);
			}
			final Long customerId = account.getCustomerId();
			final AdEngineAccountIdGroup idGroup = new AdEngineAccountIdGroup(customerId, null);
			return idGroup;
		}
		else if (adEngine == AdEngine.MSN)
		{
			// assume US dollars US timezone
			MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
			// final String legalUserName =
			// SemplestUtils.getLegalUserName(companyName + "_Semplest");

			// TODO: remove the prefix after testing
			final String userName = System.currentTimeMillis() + companyName + "_Semplest";
			// final String userName = companyName + "_Semplest";
			SemplestString company = new SemplestString();
			company.setSemplestString(userName);
			MsnManagementIds ids = msn.createAccount(company);
			final Long accountId = ids.getAccountId();
			final String accountNumber = ids.getAccountNumber();
			final AdEngineAccountIdGroup idGroup = new AdEngineAccountIdGroup(accountId, accountNumber);
			return idGroup;
		}
		else
		{
			throw new Exception("AdEngine [" + adEngine + "] not setup to create accounts (at least not yet)");
		}

	}

	/*
	 * This executes the bidding process synchronously
	 */
	public String ExecuteBidProcess(String json) throws Exception
	{
		logger.debug("call ExecuteBidProcess(String json)" + json);
		Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		final Boolean processedSuccessfully = ExecuteBidProcess(promotionID, adEngines);
		if (!processedSuccessfully)
		{
			logger.error("Problem running ExecuteBidProcess with json [" + json + "]");
		}
		return gson.toJson(processedSuccessfully);
	}

	@Override
	public Boolean ExecuteBidProcess(Integer PromotionID, List<AdEngine> adEngineList) throws Exception
	{
		GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(PromotionID);
		PromotionObj promoObj = getPromoDataSP.getPromotionData();
		final Map<AdEngine, AdEngineID> adEngineMap = getPromoDataSP.getPromotionAdEngineID(PromotionID);
		/*
		 * from Yesterday look back 5 days to get the transactions
		 */

		Date now = new Date();
		cal.setTime(now);
		// get yesterday
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -5);
		for (AdEngine adEngine : adEngineList)
		{
			if (adEngine == AdEngine.Google)
			{
				final AdEngineID adEngineData = adEngineMap.get(adEngine);
				final Long accountId = adEngineData.getAccountID();
				// go get the report from Google
				SemplestString semplstStr = new SemplestString();
				final String accountIdString = "" + accountId;
				semplstStr.setSemplestString("" + accountId);
				GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
				try
				{
					ReportObject[] getReportData = google.getReportForAccount(accountIdString, YYYYMMDD.format(cal.getTime()), YYYYMMDD.format(yesterday));
					SemplestDB.storeAdvertisingEngineReportData(PromotionID, adEngine, getReportData);
				}
				catch (Exception e)
				{
					logger.error("Unable to download Report for account " + accountIdString + ":" + e.getMessage(), e);
				}
				// update the API charges
				try
				{
					Long cumulativeUnitsUsedFromStart = google.getSpentAPIUnitsPerAccountID(accountId, promoObj.getPromotionStartDate(), new Date());
					if (cumulativeUnitsUsedFromStart != null && cumulativeUnitsUsedFromStart > 0)
					{
						UpdateAdEngineAPIChargeSP updateApiSP = new UpdateAdEngineAPIChargeSP();
						Double newCost = updateApiSP.execute(accountId, adEngine, cumulativeUnitsUsedFromStart);
						logger.info("Added additional API Cost of " + newCost + " to Google Account " + accountId);
					}
				}
				catch (Exception e)
				{
					logger.error("Error updating API charges for Google Account " + accountIdString + ":" + e.getMessage(), e);
				}
			}
			else if (adEngine == AdEngine.MSN)
			{
				logger.info("REPORT FOR MSN NOT YET IMPLEMENTED");
				// get report and store
				// SemplestDB.storeAdvertisingEngineReportData(PromotionID, adEngine, getReportData);
			}
			else
			{
				logger.error("NO SUPPORT FOR ADENGINE " + adEngine);
			}
		}
		// CALL A SP TO UPDATE THE REMAINING CYCLE BUDGET
		UpdateRemainingBudgetInCycleSP updateBudgetSP = new UpdateRemainingBudgetInCycleSP();
		Integer res = updateBudgetSP.execute(PromotionID, promoObj.getPromotionStartDate(), new Date());
		// Call bidding service to split the budget
		SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient(ESBWebServerURL, getTimeoutMS());
		// setup the budget for each ad engine
		Map<AdEngine, HashMap<String, Object>> remainingBudgetDaysMap = setupAdEngineBudget(PromotionID, adEngineList, bidClient);
		// call setBidsUpdate
		for (AdEngine adEngine : adEngineList)
		{
			Double budget = (Double) remainingBudgetDaysMap.get(adEngine).get("RemainingBudgetInCycle");
			Integer daysLeft = (Integer) remainingBudgetDaysMap.get(adEngine).get("RemainingDays");
			BudgetObject budgetData = new BudgetObject();
			budgetData.setRemainingBudgetInCycle(budget);
			budgetData.setRemainingDays(daysLeft);
			bidClient.setBidsUpdate(PromotionID, adEngine, budgetData);
		}
		return true;
	}

	public String UpdateGeoTargeting(String json) throws Exception
	{
		logger.debug("call UpdateGeoTargeting(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer PromotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		UpdateGeoTargeting(PromotionID, adEngines);
		return gson.toJson(true);
	}

	public String scheduleUpdateGeoTargeting(String json) throws Exception
	{
		logger.debug("call scheduleUpdateGeoTargeting(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngineStrings = gson.fromJson(adEnginesString, SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean res = scheduleUpdateGeoTargeting(customerID, promotionID, adEngines);
		return gson.toJson(res);
	}

	@Override
	public Boolean scheduleUpdateGeoTargeting(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Update Geo Targeting for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "UpdateGeoTargeting";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createUpdateGeoTargetingTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Update Geo Targetting for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	@Override
	public Boolean UpdateGeoTargeting(Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		logger.info("call UpdateGeoTargeting(" + promotionID + ", " + adEngines + ")");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final List<GeoTargetObject> geoTargets = getPromoDataSP.getGeoTargets();
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
				final AdEngineID promotionAdEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountId = "" + promotionAdEngineData.getAccountID();
				final Long campaignId = promotionAdEngineData.getCampaignID();
				logger.info("Will try to update within Google Adwords the Account[" + accountId + "]/CampaignId[" + campaignId + "]/Promotion[" + promotionID + "] with the following GeoTargets: [" + geoTargets + "]");
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				googleAdwordsService.updateGeoTargets(accountId, campaignId, geoTargets);
			}
			else if (AdEngine.MSN == adEngine)
			{
				final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
				final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
				final AdEngineID promotionAdEngineData = promotionAdEngineDataMap.get(adEngine);
				final Long accountId = promotionAdEngineData.getAccountID();
				final Long campaignId = promotionAdEngineData.getCampaignID();
				for (final GeoTargetObject geoTarget : geoTargets)
				{
					final String address = geoTarget.getAddress();
					final String city = geoTarget.getCity();
					final String state = geoTarget.getState();
					final String zip = geoTarget.getZip();
					final Double radius = geoTarget.getRadius();
					final Double latitude = geoTarget.getLatitude();
					final Double longitude = geoTarget.getLongitude();
					final String country = "US";
					msn.setGeoTarget(accountId, campaignId, latitude, longitude, radius, address, city, state, country, zip);
				}
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Updating GEO Targets (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to Update Geo Targetting for PromotionID [" + promotionID + "], AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}
	
	public String scheduleEndPromotion(String json) throws Exception
	{
		logger.debug("call scheduleEndPromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleEndPromotion(customerID, promotionID, adEngines);
		return gson.toJson(result);
	}
	
	public Boolean scheduleEndPromotion(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to End Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "EndPromotion";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createEndPromotionTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to End Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}
	
	public String EndPromotion(String json) throws Exception
	{
		logger.debug("JSON [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer PromotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		EndPromotion(PromotionID, adEngines);
		return gson.toJson(true);
	}
	
	public Boolean EndPromotion(Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to End Promotion for PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		
		// can only end promotion if it's live or paused
		final Map<AdEngine, PromotionStatus> promotionStatusMap = SemplestDB.getPromotionStatus(promotionID, adEngines);
		final Set<Entry<AdEngine, PromotionStatus>> entrySet = promotionStatusMap.entrySet();
		for (final Entry<AdEngine, PromotionStatus> entry : entrySet)
		{
			final AdEngine entryAdEngine = entry.getKey();
			final PromotionStatus entryPromotionStatus = entry.getValue();
			if (!(entryPromotionStatus == PromotionStatus.LIVE || entryPromotionStatus == PromotionStatus.PENDING))
			{
				throw new Exception("Cannot End Promotion for PromotionID [" + promotionID + "] and AdEngine [" + entryAdEngine + "] because it's currently in Status [" + entryPromotionStatus.getName() + "], but can only End Promotions when they are in Status [" + PromotionStatus.LIVE.getName() + "] or [" + PromotionStatus.PENDING.getName() + "]");
			}
		}		
		final GetAllPromotionDataSP getAllPromotionDataSP = new GetAllPromotionDataSP();
		final Boolean result = getAllPromotionDataSP.execute(promotionID);
		for (final AdEngine adEngine : adEngines)
		{
			if (adEngine == AdEngine.Google)
			{
				final Map<AdEngine, AdEngineID> adengineDataMap = getAllPromotionDataSP.getPromotionAdEngineID(promotionID);
				final AdEngineID adEngineData = adengineDataMap.get(adEngine);
				final String accountID = "" + adEngineData.getAccountID();
				final Long campaignID = adEngineData.getCampaignID();
				final GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
				final Boolean deleteCampaignSuccessful = google.deleteCampaign(accountID, campaignID);
				if (!deleteCampaignSuccessful)
				{
					errorMap.put(adEngine, "Problem Ending Promotion for PromotionID [" + promotionID + "], AdEngine [" + adEngine + "] because Google's response from delete call is empty");
				}
				else
				{
					SemplestDB.updatePromotionStatus(promotionID, adEngine, PromotionStatus.ENDED);
				}
			}
			else if (adEngine == AdEngine.MSN)
			{
				final Map<AdEngine, AdEngineID> adengineDataMap = getAllPromotionDataSP.getPromotionAdEngineID(promotionID);
				final AdEngineID adEngineData = adengineDataMap.get(adEngine);
				final Long accountID = adEngineData.getAccountID();
				final Long campaignID = adEngineData.getCampaignID();
				final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
				msn.deleteCampaignById(accountID, campaignID);
				SemplestDB.updatePromotionStatus(promotionID, adEngine, PromotionStatus.ENDED);
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Ending Promotion (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to End Promotion for PromotionID [" + promotionID + "] and AdEngines [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}
	
	public String scheduleDeletePromotion(String json) throws Exception
	{
		logger.debug("call scheduleDeletePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleDeletePromotion(customerID, promotionID, adEngines);
		return gson.toJson(result);
	}

	public Boolean scheduleDeletePromotion(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Delete Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "DeletePromotion";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createPausePromotionTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Delete Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String DeletePromotion(String json) throws Exception
	{
		logger.debug("JSON [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngineStrings = gson.fromJson(adEnginesString, SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		DeletePromotion(promotionID, adEngines);
		return gson.toJson(true);
	}

	public static String getShortDescription(final Map<AdEngine, PromotionStatus> promotionStatusMap)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append("(");
		final Set<Entry<AdEngine, PromotionStatus>> entrySet = promotionStatusMap.entrySet();
		for (final Entry<AdEngine, PromotionStatus> entry : entrySet)
		{
			final AdEngine adEngine = entry.getKey();
			final PromotionStatus promotionStatus = entry.getValue();
			final String adEngineName = adEngine.name();
			final String promotionStatusName = promotionStatus.getName();
			if (sb.length() <= 1)
			{
				sb.append(", ");
			}
			sb.append(adEngineName).append("->").append(promotionStatusName);
		}
		sb.append(")");
		return sb.toString();
	}

	public Boolean DeletePromotion(Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Delete Promotion for PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
		final Map<AdEngine, PromotionStatus> promotionStatusMap = SemplestDB.getPromotionStatus(promotionID, adEngines);
		if (promotionStatusMap.isEmpty())
		{
			SemplestDB.updatePromotionStatus(promotionID, adEngines, PromotionStatus.DELETED);
			return true;
		}
		else
		{
			final String shortDescription = getShortDescription(promotionStatusMap);
			throw new Exception("Cannot delete Promotion for ID [" + promotionID + "] because it has already been launched: " + shortDescription);
		}
	}

	public String UnpausePromotion(String json) throws Exception
	{
		logger.debug("call UnpausePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer PromotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		UnpausePromotion(PromotionID, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean UnpausePromotion(Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Un-Pause Promotion for PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
		final List<Integer> promotionIds = new ArrayList<Integer>();
		promotionIds.add(promotionID);
		ChangePromotionsStatus(promotionIds, adEngines, SemplestCampaignStatus.ACTIVE);
		SemplestDB.updatePromotionStatus(promotionID, adEngines, PromotionStatus.LIVE);
		return true;
	}

	public String schedulePausePromotion(String json) throws Exception
	{
		logger.debug("call schedulePausePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = schedulePausePromotion(customerID, promotionID, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean schedulePausePromotion(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Pause Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "PausePromotion";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createPausePromotionTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Pause Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String PausePromotion(String json) throws Exception
	{
		logger.debug("call PausePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer PromotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		PausePromotion(PromotionID, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean PausePromotion(Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		final List<Integer> promotionIds = new ArrayList<Integer>();
		promotionIds.add(promotionID);
		ChangePromotionsStatus(promotionIds, adEngines, SemplestCampaignStatus.PAUSED);
		SemplestDB.updatePromotionStatus(promotionID, adEngines, PromotionStatus.PAUSED);
		return true;
	}

	public String PauseProductGroups(String json) throws Exception
	{
		logger.debug("call PauseProductGroups(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String productGroupIdsString = data.get("productGroupIds");
		final List<Integer> productGroupIds = gson.fromJson(productGroupIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		PauseProductGroups(productGroupIds, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean PauseProductGroups(List<Integer> productGroupIds, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Pause ProductGroups for ProductGroupIDs [" + productGroupIds + "] for AdEngines [" + adEngines + "])");
		final List<Integer> promotionIds = new ArrayList<Integer>();
		for (final Integer productGroupID : productGroupIds)
		{
			final List<Integer> promotionIdsForProductGroup = SemplestDB.getPromotionIdsForProductGroup(productGroupID);
			promotionIds.addAll(promotionIdsForProductGroup);
		}
		logger.info("From the ProductGroupIDs [" + productGroupIds + "] found the associated PromotionIDs for which the Campaigns we'll need to Pause:\n" + SemplestUtils.getEasilyReadableString(promotionIds));
		ChangePromotionsStatus(promotionIds, adEngines, SemplestCampaignStatus.PAUSED);
		return true;
	}

	public void ChangePromotionsStatus(List<Integer> promotionIds, List<AdEngine> adEngines, SemplestCampaignStatus newStatus) throws Exception
	{
		logger.info("Will try to Change Status to [" + newStatus + "] for PromotionIds [" + promotionIds + "] and AdEngines [" + adEngines + "])");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		String googleAccountId = null;
		Long msnAccountId = null;
		final List<Long> googleCampaignIds = new ArrayList<Long>();
		final List<Long> msnCampaignIds = new ArrayList<Long>();
		for (final Integer promotionId : promotionIds)
		{
			Boolean ret = getPromoDataSP.execute(promotionId);
			final Map<AdEngine, AdEngineID> adEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionId);
			final AdEngineID googleAdEngineData = adEngineDataMap.get(AdEngine.Google);
			if (googleAdEngineData != null)
			{
				if (googleAccountId == null)
				{
					googleAccountId = "" + googleAdEngineData.getAccountID();
				}
				final Long campaignId = googleAdEngineData.getCampaignID();
				googleCampaignIds.add(campaignId);
			}
			final AdEngineID msnAdEngineData = adEngineDataMap.get(AdEngine.MSN);
			if (msnAdEngineData != null)
			{
				if (msnAccountId == null)
				{
					msnAccountId = msnAdEngineData.getAccountID();
				}
				final Long campaignId = msnAdEngineData.getCampaignID();
				msnCampaignIds.add(campaignId);
			}
		}
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				logger.info("Will try to Change Status of Google Campaigns to [" + newStatus + "] using AccountID [" + googleAccountId + "] and CampaignIds [" + googleCampaignIds + "])");
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final Boolean result = googleAdwordsService.changeCampaignsStatus(googleAccountId, googleCampaignIds, newStatus.getGoogleCampaignStatus());
				if (!result)
				{
					final String errMsg = "Request to Change Status of Google Campaigns for AccountID [" + googleAccountId + "] and CampaignIds [" + googleCampaignIds + "] failed";
					logger.info(errMsg);
					errorMap.put(adEngine, errMsg);
				}
			}
			else if (AdEngine.MSN == adEngine)
			{
				if (newStatus == SemplestCampaignStatus.PAUSED)
				{
					final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
					for (final Long msnCampaignId : msnCampaignIds)
					{
						msn.pauseCampaignById(msnAccountId, msnCampaignId);
					}
				}
				else if (newStatus == SemplestCampaignStatus.ACTIVE)
				{
					final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
					for (final Long msnCampaignId : msnCampaignIds)
					{
						msn.unpauseCampaignById(msnAccountId, msnCampaignId);
					}
				}
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Changing Promotion Status (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to Change Status to [" + newStatus + "] for PromotionIds [" + promotionIds + "] and AdEngines [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
	}

	public List<AdsObject> getFilteredAds(final List<AdsObject> ads, final Boolean isDeleted)
	{
		final List<AdsObject> adsFound = new ArrayList<AdsObject>();
		for (final AdsObject ad : ads)
		{
			if (isDeleted.equals(ad.isIsDeleted()))
			{
				adsFound.add(ad);
			}
		}
		return adsFound;
	}

	public List<AdsObject> getAdsForPromotionAdID(final List<AdsObject> ads, Integer promotionAdID)
	{
		final List<AdsObject> adsFound = new ArrayList<AdsObject>();
		for (final AdsObject ad : ads)
		{
			final Integer adPromotionAdID = ad.getPromotionAdsPK();
			if (adPromotionAdID.intValue() == promotionAdID.intValue())
			{
				adsFound.add(ad);
			}
		}
		return adsFound;
	}

	public String scheduleAddNegativeKeywords(String json) throws Exception
	{
		logger.info("call scheduleAddNegativeKeywords(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String keywordIdRemoveOppositePairsString = data.get("keywordIdRemoveOppositePairs");
		final List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs = gson.fromJson(keywordIdRemoveOppositePairsString, SemplestUtils.TYPE_LIST_OF_KEYWORD_ID_REMOVE_OPPOSITE_PAIRS);
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngineStrings = gson.fromJson(adEnginesString, SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean res = scheduleAddNegativeKeywords(customerID, promotionID, keywordIdRemoveOppositePairs, adEngines);
		return gson.toJson(res);
	}

	@Override
	public Boolean scheduleAddNegativeKeywords(Integer customerID, Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Add Negative Keywords for Customer [" + customerID + "], PromotionID [" + promotionID + "], KeywordIdRemoveOppositePairs [" + keywordIdRemoveOppositePairs + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "AddNegativeKeywords";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createAddNegativeKeywordsTask(customerID, promotionID, keywordIdRemoveOppositePairs, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Add Negative Keywords for Customer [" + customerID + "], PromotionID [" + promotionID + "], KeywordIdRemoveOppositePairs [" + keywordIdRemoveOppositePairs + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public Map<KeywordProbabilityObject, Boolean> getKeywordProbabilityToRemoveOppositeMap(final List<KeywordProbabilityObject> keywordProbabilities, final List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs)
	{
		final Map<KeywordProbabilityObject, Boolean> keywordToRemoveOppositeMap = new HashMap<KeywordProbabilityObject, Boolean>();
		for (final KeywordProbabilityObject currentKeywordProbability : keywordProbabilities)
		{
			final Integer currentKeywordId = currentKeywordProbability.getKeywordPK();
			for (final KeywordIdRemoveOppositePair pair : keywordIdRemoveOppositePairs)
			{
				final Integer pairKeywordId = pair.getKeywordId();
				if (currentKeywordId.intValue() == pairKeywordId.intValue())
				{
					final Boolean removeOpposite = pair.getRemoveOpposite();
					keywordToRemoveOppositeMap.put(currentKeywordProbability, removeOpposite);
				}
			}
		}
		return keywordToRemoveOppositeMap;
	}

	public String AddNegativeKeywords(String json) throws Exception
	{
		logger.debug("call AddNegativeKeywords(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String keywordIdRemoveOppositePairsString = data.get("keywordIdRemoveOppositePairs");
		final List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs = gson.fromJson(keywordIdRemoveOppositePairsString, SemplestUtils.TYPE_LIST_OF_KEYWORD_ID_REMOVE_OPPOSITE_PAIRS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		AddNegativeKeywords(promotionID, keywordIdRemoveOppositePairs, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean AddNegativeKeywords(Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Add Negative Keywords for PromotionID [" + promotionID + "], " + keywordIdRemoveOppositePairs.size() + " KeywordIdRemoveOppositePairs [" + keywordIdRemoveOppositePairs + "], AdEngines [" + adEngines + "]");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
		final GetKeywordForAdEngineSP getKeywordForAdEngineSP = new GetKeywordForAdEngineSP();
		final List<KeywordProbabilityObject> keywordProbabilitiesAll = getKeywordForAdEngineSP.execute(promotionID, true, false);
		final Map<KeywordProbabilityObject, Boolean> keywordToRemoveOppositeMap = getKeywordProbabilityToRemoveOppositeMap(keywordProbabilitiesAll, keywordIdRemoveOppositePairs);
		if (keywordToRemoveOppositeMap.size() != keywordIdRemoveOppositePairs.size())
		{
			logger.warn("# of keywords we'll work on as was found in db " + keywordToRemoveOppositeMap.size() + " is NOT the same as # of keywords requested to be worked on " + keywordIdRemoveOppositePairs.size());
		}
		else
		{
			logger.info("As expected, we'll work on " + keywordToRemoveOppositeMap.size() + " keywords which is the same as " + keywordIdRemoveOppositePairs.size() + " requested to be worked on");
		}
		final String esbServerTimeout = getTimeoutMS();
		final SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient(ESBWebServerURL, esbServerTimeout);
		final Map<AdEngine, AdEngineInitialData> adEngineInitialMap = bidClient.getInitialValues(promotionID, adEngines);
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountID = "" + adEngineData.getAccountID();
				final Long adGroupID = adEngineData.getAdGroupID();
				final Long campaignID = adEngineData.getCampaignID();
				final AdEngineInitialData adEngineInitialData = adEngineInitialMap.get(adEngine);
				final String semplestMatchType = adEngineInitialData.getSemplestMatchType();
				final String keywordMatchTypeString = SemplestMatchType.getSearchEngineMatchType(semplestMatchType, adEngine);
				final KeywordMatchType keywordMatchType = KeywordMatchType.fromString(keywordMatchTypeString);
				final GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
				final Boolean processedSuccessfully = google.addUpdateKeywords(accountID, campaignID, adGroupID, keywordToRemoveOppositeMap, keywordMatchType, null);
				if (processedSuccessfully)
				{
					logger.info("Processed successfully");
				}
				else
				{
					errorMap.put(adEngine, "Problem doing Add/Update Negative Keywords for PromotionID [" + promotionID + "], " + keywordIdRemoveOppositePairs.size() + " KeywordIdRemoveOppositePairs [" + keywordIdRemoveOppositePairs + "]");
				}
			}
			else if (AdEngine.MSN == adEngine)
			{
				final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final Long accountID = adEngineData.getAccountID();
				final Long adGroupID = adEngineData.getAdGroupID();
				final Long campaignID = adEngineData.getCampaignID();
				final Set<Entry<KeywordProbabilityObject, Boolean>> entrySet = keywordToRemoveOppositeMap.entrySet();
				final List<String> negativeKeywordsToAdd = new ArrayList<String>();
				final List<BidElement> bids = SemplestDB.getLatestBids(promotionID, adEngine);
				final List<Long> msnPositiveKeywordIdsToRemove = new ArrayList<Long>();
				for (final Entry<KeywordProbabilityObject, Boolean> entry : entrySet)
				{
					final KeywordProbabilityObject keywordProbability = entry.getKey();
					if (keywordProbability.getIsNegative())
					{
						final String keywordText = keywordProbability.getKeyword();
						negativeKeywordsToAdd.add(keywordText);
						final Boolean removeOpposite = entry.getValue();
						if (removeOpposite)
						{
							for (final BidElement bid : bids)
							{
								final String keyword = bid.getKeyword();
								if (keywordText.equals(keyword))
								{
									final Long msnKeywordId = bid.getKeywordAdEngineID();
									msnPositiveKeywordIdsToRemove.add(msnKeywordId);
								}
							}
						}
					}
				}
				final long[] msnPositiveKeywordIdsToRemoveArray = new long[msnPositiveKeywordIdsToRemove.size()];
				for (int i = 0; i < msnPositiveKeywordIdsToRemove.size(); ++i)
				{
					msnPositiveKeywordIdsToRemoveArray[i] = msnPositiveKeywordIdsToRemove.get(i);
				}
				logger.info("Will try to:\nDelete MSN keywords for MSN IDs [" + msnPositiveKeywordIdsToRemove + "]\nAdd Negative Keywords: [" + negativeKeywordsToAdd + "]");
				msn.deleteKeywordsById(accountID, adGroupID, msnPositiveKeywordIdsToRemoveArray);
				msn.setNegativeKeywords(accountID, campaignID, negativeKeywordsToAdd);
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Adding Keywords (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public String scheduleAddKeywords(String json) throws Exception
	{
		logger.debug("call scheduleAddKeywords(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String keywordIdsString = data.get("keywordIds");
		final List<Integer> keywordIds = gson.fromJson(keywordIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngineStrings = gson.fromJson(adEnginesString, SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean res = scheduleAddKeywords(customerID, promotionID, keywordIds, adEngines);
		return gson.toJson(res);
	}

	@Override
	public Boolean scheduleAddKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Add Keywords for Customer [" + customerID + "], PromotionID [" + promotionID + "], KeywordIds [" + keywordIds + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "AddKeywords";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createAddKeywordsTask(customerID, promotionID, keywordIds, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Add Keywords for Customer [" + customerID + "], PromotionID [" + promotionID + "], KeywordIds [" + keywordIds + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String scheduleAddAds(String json) throws Exception
	{
		logger.debug("call scheduleAddAds(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String promotionAdIdsString = data.get("promotionAdIds");
		final List<Integer> promotionAdIds = gson.fromJson(promotionAdIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngineStrings = gson.fromJson(adEnginesString, SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);		
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean res = scheduleAddAds(customerID, promotionID, promotionAdIds, adEngines);
		return gson.toJson(res);
	}

	@Override
	public Boolean scheduleAddAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task for Adding Ads for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdIds [" + promotionAdIds + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "AddAds";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createAddAdsTask(customerID, promotionID, promotionAdIds, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Add Ads for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdIds [" + promotionAdIds + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String AddKeywords(String json) throws Exception
	{
		logger.debug("call AddKeywords(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String keywordIdsString = data.get("keywordIds");
		final List<Integer> keywordIds = gson.fromJson(keywordIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		AddKeywords(promotionID, keywordIds, adEngines);
		return gson.toJson(true);
	}

	public List<KeywordProbabilityObject> getFilteredKeywordProbabilities(final List<KeywordProbabilityObject> keywordProbabilities, final List<Integer> keywordIds)
	{
		final List<KeywordProbabilityObject> filteredKeywordProbabilities = new ArrayList<KeywordProbabilityObject>();
		for (final KeywordProbabilityObject currentKeywordProbability : keywordProbabilities)
		{
			final Integer currentKeywordId = currentKeywordProbability.getKeywordPK();
			if (keywordIds.contains(currentKeywordId))
			{
				filteredKeywordProbabilities.add(currentKeywordProbability);
			}
		}
		return filteredKeywordProbabilities;
	}

	@Override
	public Boolean AddKeywords(Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Add Keywords for PromotionID [" + promotionID + "], " + keywordIds.size() + " KeywordIds [" + keywordIds + "], AdEngines [" + adEngines + "]");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		final Boolean ret = getPromoDataSP.execute(promotionID);
		final Map<AdEngine, AdEngineID> promotionAdEngineData = getPromoDataSP.getPromotionAdEngineID(promotionID);
		final GetKeywordForAdEngineSP getKeywordForAdEngineSP = new GetKeywordForAdEngineSP();
		final List<KeywordProbabilityObject> keywordProbabilitiesAll = getKeywordForAdEngineSP.execute(promotionID, true, false);
		final List<KeywordProbabilityObject> keywordProbabilitiesForIds = getFilteredKeywordProbabilities(keywordProbabilitiesAll, keywordIds);
		if (keywordProbabilitiesForIds.size() != keywordIds.size())
		{
			logger.warn("# of keywords found " + keywordProbabilitiesForIds.size() + " is NOT the same as # of keywords Ids " + keywordIds.size() + " requested to add.");
		}
		else
		{
			logger.info("As expected, found " + keywordProbabilitiesForIds.size() + " keywords for " + keywordIds.size() + " ids");
		}
		final SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient((String) SemplestConfiguration.configData.get("ESBWebServerURL"), getTimeoutMS());
		final Map<AdEngine, AdEngineInitialData> adEngineInitialMap = bidClient.getInitialValues(promotionID, adEngines);
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		final AddBidSP addKeywordBidSP = new AddBidSP();
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineData.get(adEngine);
				final String accountID = "" + adEngineData.getAccountID();
				final Long adGroupID = adEngineData.getAdGroupID();
				final Long campaignID = adEngineData.getCampaignID();
				final AdEngineInitialData adEngineInitialData = adEngineInitialMap.get(adEngine);
				final String semplestMatchType = adEngineInitialData.getSemplestMatchType();
				addKeywordsToAdGroup(accountID, campaignID, promotionID, adGroupID, adEngine, keywordProbabilitiesForIds, semplestMatchType, null);
			}
			else if (AdEngine.MSN == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineData.get(adEngine);
				final Long accountId = adEngineData.getAccountID();
				final Long adGroupId = adEngineData.getAdGroupID();
				final AdEngineInitialData adEngineInitialData = adEngineInitialMap.get(adEngine);
				final String semplestMatchType = adEngineInitialData.getSemplestMatchType();
				final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
				final Map<Keyword, Integer> keywordToPkMap = new HashMap<Keyword, Integer>();
				for (final KeywordProbabilityObject keywordProbabilitiesForId : keywordProbabilitiesForIds)
				{
					if (keywordProbabilitiesForId.getIsActive() && keywordProbabilitiesForId.getIsTargetMSN())
					{
						final String keywordText = keywordProbabilitiesForId.getKeyword();
						com.microsoft.adcenter.v8.Keyword k = new com.microsoft.adcenter.v8.Keyword();
						k.setText(keywordText);
						final Integer keywordPK = keywordProbabilitiesForId.getKeywordPK();
						final Bid bid = new Bid(SemplestUtils.MSN_DEFAULT_BID_AMOUNT);
						k.setBroadMatchBid(null);
						k.setExactMatchBid(null);
						k.setPhraseMatchBid(null);
						k.setContentMatchBid(null);
						if (SemplestMatchType.Broad.name().equals(semplestMatchType))
						{
							k.setBroadMatchBid(bid);
						}
						else if (SemplestMatchType.Exact.name().equals(semplestMatchType))
						{
							k.setExactMatchBid(bid);
						}
						else if (SemplestMatchType.Phrase.name().equals(semplestMatchType))
						{
							k.setPhraseMatchBid(bid);
						}
						else
						{
							throw new Exception("SemplestMatchType [" + semplestMatchType + "] is not recognized");
						}
						keywordToPkMap.put(k, keywordPK);
					}
				}
				// Add Positive Keywords
				final int batchSize = 1000;
				int counter = 0;
				final List<Map<com.microsoft.adcenter.v8.Keyword, Integer>> keywordBatches = SemplestUtils.getBatches(keywordToPkMap, batchSize);
				logger.info("Out of " + keywordToPkMap.size() + " MSN keywords, created " + keywordBatches.size() + " batches of max " + batchSize);
				for (final Map<com.microsoft.adcenter.v8.Keyword, Integer> batch : keywordBatches)
				{
					final MsnCreateKeywordsResponse response = msn.createKeywords(accountId, adGroupId, batch);
					final Map<String, Long> keywordToMsnIdMap = response.getKeywordToMsnIdMap();
					final Map<Integer, String> filteredOutKeywordIdsToCommentMap = response.getFilteredOutKeywordPkToCommentMap();
					logger.info("Successfully created Keywords in MSN (KeywordText<->MsnID):\n" + SemplestUtils.getEasilyReadableString(keywordToMsnIdMap) + "\n\nCould not create these Keywords in MSN (KeywordPK<->Comment):\n"
							+ SemplestUtils.getEasilyReadableString(filteredOutKeywordIdsToCommentMap));
					// Persist MsnKeywordID in DB for Keywords that were added to MSN
					final Set<Entry<String, Long>> keywordToMsnIdEntrySet = keywordToMsnIdMap.entrySet();
					for (final Entry<String, Long> entry : keywordToMsnIdEntrySet)
					{
						final String text = entry.getKey();
						final Long keywordId = entry.getValue();
						logger.info(++counter + ": will try to save in db MSN Keyword for MsnKeywordID [" + keywordId + "], Text [" + text + "], PromotionID [" + promotionID + "], SemplestMatchType [" + semplestMatchType + "], IsNegative [" + false + "]");
						Integer spRet = addKeywordBidSP.execute(promotionID, keywordId, text, SemplestUtils.MSN_DEFAULT_BID_MIRCOAMOUNT.intValue(), semplestMatchType, adEngine, false, null, true);
					}
					// Mark as Deleted in DB for Keywords that could not be added to MSN
					SemplestDB.markKeywordDeletedBulk(filteredOutKeywordIdsToCommentMap, promotionID);
				}
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Adding Keywords (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public String AddAds(String json) throws Exception
	{
		logger.debug("call AddAds(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String promotionAdIdsString = data.get("promotionAdIds");
		final List<Integer> promotionAdIds = gson.fromJson(promotionAdIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		AddAds(promotionID, promotionAdIds, adEngines);
		return gson.toJson(true);
	}

	public List<GoogleAdIdSemplestAdIdPair> getIdPairs(Map<GoogleAddAdRequest, Long> requestToGoogleIdMap)
	{
		final List<GoogleAdIdSemplestAdIdPair> idPairs = new ArrayList<GoogleAdIdSemplestAdIdPair>();
		final Set<Entry<GoogleAddAdRequest, Long>> entrySet = requestToGoogleIdMap.entrySet();
		for (final Entry<GoogleAddAdRequest, Long> entry : entrySet)
		{
			final GoogleAddAdRequest request = entry.getKey();
			final Integer semplestAdId = request.getPromotionAdID();
			final Long googleAdId = entry.getValue();
			final GoogleAdIdSemplestAdIdPair idPair = new GoogleAdIdSemplestAdIdPair(googleAdId, semplestAdId);
			idPairs.add(idPair);
		}
		return idPairs;
	}

	public Map<Entry<UpdateAdRequest, Long>, Integer> getUpdateRequestNewIdToRowCountMapWithBadRows(final Map<Entry<UpdateAdRequest, Long>, Integer> updateRequestNewIdToRowCountMap)
	{
		final Map<Entry<UpdateAdRequest, Long>, Integer> updateRequestNewIdToRowCountMapWithBadRows = new HashMap<Entry<UpdateAdRequest, Long>, Integer>();
		final Set<Entry<Entry<UpdateAdRequest, Long>, Integer>> entrySet = updateRequestNewIdToRowCountMap.entrySet();
		for (final Entry<Entry<UpdateAdRequest, Long>, Integer> entry : entrySet)
		{
			final Integer rowCount = entry.getValue();
			if (rowCount != 1)
			{
				final Entry<UpdateAdRequest, Long> updateRequestToNewIdMapping = entry.getKey();
				updateRequestNewIdToRowCountMapWithBadRows.put(updateRequestToNewIdMapping, rowCount);
			}
		}
		return updateRequestNewIdToRowCountMapWithBadRows;
	}

	public Map<Integer, Integer> getDeletedAdMappingRowCountMapWithBadRowCounts(final Map<Integer, Integer> deletedAdMappingRowCountMap)
	{
		final Map<Integer, Integer> idPaidRowCountMapWithBadRowCounts = new HashMap<Integer, Integer>();
		final Set<Entry<Integer, Integer>> entrySet = deletedAdMappingRowCountMap.entrySet();
		for (final Entry<Integer, Integer> entry : entrySet)
		{
			final Integer rowCount = entry.getValue();
			if (rowCount != 1)
			{
				final Integer deletedAdId = entry.getKey();
				idPaidRowCountMapWithBadRowCounts.put(deletedAdId, rowCount);
			}
		}
		return idPaidRowCountMapWithBadRowCounts;
	}

	public Map<Long, Integer> getDeletedAdIdRowCountMapWithBadRowCounts(final Map<Long, Integer> deletedAdIdRowCountMap)
	{
		final Map<Long, Integer> idPaidRowCountMapWithBadRowCounts = new HashMap<Long, Integer>();
		final Set<Entry<Long, Integer>> entrySet = deletedAdIdRowCountMap.entrySet();
		for (final Entry<Long, Integer> entry : entrySet)
		{
			final Integer rowCount = entry.getValue();
			if (rowCount != 1)
			{
				final Long deletedAdId = entry.getKey();
				idPaidRowCountMapWithBadRowCounts.put(deletedAdId, rowCount);
			}
		}
		return idPaidRowCountMapWithBadRowCounts;
	}

	public Map<GoogleAdIdSemplestAdIdPair, Integer> getIdPairRowCountMapWithBadRowCounts(final Map<GoogleAdIdSemplestAdIdPair, Integer> idPairRowCountMap)
	{
		final Map<GoogleAdIdSemplestAdIdPair, Integer> idPairRowCountMapWithBadRowCounts = new HashMap<GoogleAdIdSemplestAdIdPair, Integer>();
		final Set<Entry<GoogleAdIdSemplestAdIdPair, Integer>> entrySet = idPairRowCountMap.entrySet();
		for (final Entry<GoogleAdIdSemplestAdIdPair, Integer> entry : entrySet)
		{
			final Integer rowCount = entry.getValue();
			if (rowCount != 1)
			{
				final GoogleAdIdSemplestAdIdPair idPair = entry.getKey();
				idPairRowCountMapWithBadRowCounts.put(idPair, rowCount);
			}
		}
		return idPairRowCountMapWithBadRowCounts;
	}

	@Override
	public Boolean AddAds(Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Add Ads for PromotionID [" + promotionID + "], " + promotionAdIds.size() + " PromotionAdIds [" + promotionAdIds + "], AdEngines [" + adEngines + "]");
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final List<AdsObject> ads = getPromoDataSP.getAds();
		final PromotionObj promotion = getPromoDataSP.getPromotionData();
		final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final GoogleAdwordsServiceInterface googleAdwordsService = new GoogleAdwordsServiceImpl();
				final AdEngineID promotionAdEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountID = "" + promotionAdEngineData.getAccountID();
				final Long adGroupID = promotionAdEngineData.getAdGroupID();

				final List<GoogleAddAdRequest> addAdTextRequests = new ArrayList<GoogleAddAdRequest>();
				final String displayURL = SemplestUtils.getTrimmedNonNullString(promotion.getDisplayURL());
				final String url = SemplestUtils.getTrimmedNonNullString(promotion.getLandingPageURL());
				for (final Integer promotionAdID : promotionAdIds)
				{
					final List<AdsObject> adsForPromotionAdID = getAdsForPromotionAdID(ads, promotionAdID);
					if (!adsForPromotionAdID.isEmpty())
					{
						Collections.sort(adsForPromotionAdID, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
						final AdsObject ad = adsForPromotionAdID.get(0);
						final String headline = SemplestUtils.getTrimmedNonNullString(ad.getAdTitle());
						final String description1 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine1());
						final String description2 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine2());
						final GoogleAddAdRequest addAdRequest = new GoogleAddAdRequest(promotionAdID, headline, description1, description2);
						addAdTextRequests.add(addAdRequest);
					}
				}
				final GoogleAddAdsRequest request = new GoogleAddAdsRequest(accountID, adGroupID, displayURL, url, addAdTextRequests);
				logger.info("Generated " + addAdTextRequests.size() + " individual requests within a single GoogleAddAdsRequest from " + promotionAdIds.size() + " PromotionAdIds");
				final Map<GoogleAddAdRequest, Long> requestToGoogleIdMap = googleAdwordsService.addTextAds(request);
				logger.info("Created " + requestToGoogleIdMap.size() + " known Ads in Google that are associated with " + addAdTextRequests.size() + " original requests");
				final String easilyReadableRequestToGoogleIdMap = SemplestUtils.getEasilyReadableString(requestToGoogleIdMap);
				logger.info("Results from operation:\n" + easilyReadableRequestToGoogleIdMap);
				final List<GoogleAdIdSemplestAdIdPair> idPairs = getIdPairs(requestToGoogleIdMap);
				final Map<GoogleAdIdSemplestAdIdPair, Integer> idPairRowCountMap = SemplestDB.setAdIDForAdGroupBulk(idPairs, adEngine);
				final Map<GoogleAdIdSemplestAdIdPair, Integer> idPairRowCountMapWithBadRowCounts = getIdPairRowCountMapWithBadRowCounts(idPairRowCountMap);
				if (!idPairRowCountMapWithBadRowCounts.isEmpty())
				{
					logger.warn("Problems updating db with the following GoogleAdID<->SemplestAdID pairs because row-counts were not 1:\n" + SemplestUtils.getEasilyReadableString(idPairRowCountMapWithBadRowCounts));
				}
			}
			else if (AdEngine.MSN == adEngine)
			{
				final AdEngineID promotionAdEngineData = promotionAdEngineDataMap.get(adEngine);
				final Long accountID = promotionAdEngineData.getAccountID();
				final Long adGroupID = promotionAdEngineData.getAdGroupID();
				final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
				final String displayURL = SemplestUtils.getTrimmedNonNullString(promotion.getDisplayURL());
				final String url = SemplestUtils.getTrimmedNonNullString(promotion.getLandingPageURL());
				for (final Integer promotionAdID : promotionAdIds)
				{
					final List<AdsObject> adsForPromotionAdID = getAdsForPromotionAdID(ads, promotionAdID);
					if (!adsForPromotionAdID.isEmpty())
					{
						Collections.sort(adsForPromotionAdID, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
						final AdsObject ad = adsForPromotionAdID.get(0);
						final String headline = SemplestUtils.getTrimmedNonNullString(ad.getAdTitle());
						final String description1 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine1());
						final String description2 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine2());
						final String combinedText = description1 + description2;
						final long msnAdID = msn.createAd(accountID, adGroupID, headline, combinedText, displayURL, url);
						final Integer rowCount = SemplestDB.setAdIDForAdGroup(msnAdID, adEngine, promotionAdID);
						if (rowCount != 1)
						{
							logger.warn("Problem updating db with the following MsnAdID<->SemplestAdID pair because rowcount from the update operation is not 1, but is " + rowCount + ": " + msnAdID + "<->" + promotionAdID);
						}
					}
				}
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Adding Ads (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public String scheduleDeleteAds(String json) throws Exception
	{
		logger.debug("call scheduleDeleteAds(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String promotionAdIdsString = data.get("promotionAdIds");
		final List<Integer> promotionAdIds = gson.fromJson(promotionAdIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean res = scheduleDeleteAds(customerID, promotionID, promotionAdIds, adEngines);
		return gson.toJson(res);
	}

	@Override
	public Boolean scheduleDeleteAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task for Deleting Ad for CUstomer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdIds + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String deleteAdPostFix = "DeleteAds";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createDeleteAdEngineAdTask(customerID, promotionID, promotionAdIds, adEngines, deleteAdPostFix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + deleteAdPostFix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			if (!taskScheduleSuccessful)
			{
				return false;
			}
			final Integer rowCount = SemplestDB.markPromotionAdDeleted(promotionID, new Date());
			if (rowCount != 1)
			{
				logger.warn("Num of Promotions marked deleted for PromotionAdID [" + promotionAdIds + "] should be 1 but was [" + rowCount + "]");
			}
			return true;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Delete Ad for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdIds + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String DeleteAds(String json) throws Exception
	{
		logger.debug("call DeleteAds(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String promotionAdIdsString = data.get("promotionAdIds");
		final List<Integer> promotionAdIds = gson.fromJson(promotionAdIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		DeleteAds(promotionID, promotionAdIds, adEngines);
		return gson.toJson(true);
	}

	public List<Long> getAdIds(final List<AdsObject> ads)
	{
		final List<Long> adIds = new ArrayList<Long>();
		for (final AdsObject ad : ads)
		{
			final Long adEnginerID = ad.getAdEngineAdID();
			adIds.add(adEnginerID);
		}
		return adIds;
	}

	@Override
	public Boolean DeleteAds(Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Delete Ads for PromotionID [" + promotionID + "], PromotionAdIds [" + promotionAdIds + "], AdEngines [" + adEngines + "]");
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final PromotionObj promotion = getPromoDataSP.getPromotionData();
		final List<AdsObject> ads = getPromoDataSP.getAds();
		final List<AdsObject> nonDeletedAdsForPromotionAdIds = new ArrayList<AdsObject>();
		for (final Integer promotionAdID : promotionAdIds)
		{
			final List<AdsObject> adsForPromotionAdID = getAdsForPromotionAdID(ads, promotionAdID);
			final List<AdsObject> nonDeletedAdsForPromotionAdID = getFilteredAds(adsForPromotionAdID, false);
			// TODO: once AdvertisingEngineAds table has constraint such that
			// PromotionFK is unique in the table, remove the sorting code and
			// only deal with 1 item (not List)
			Collections.sort(nonDeletedAdsForPromotionAdID, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
			if (!nonDeletedAdsForPromotionAdID.isEmpty())
			{
				final AdsObject ad = nonDeletedAdsForPromotionAdID.get(0);
				nonDeletedAdsForPromotionAdIds.add(ad);
			}
		}
		if (nonDeletedAdsForPromotionAdIds.isEmpty())
		{
			final String errMsg = "Could not find non-deleted Ads in database for PromotionID [" + promotionID + "] and PromotionAdIds [" + promotionAdIds + "], so nothing to delete.";
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		final int numAdsToDelete = nonDeletedAdsForPromotionAdIds.size();
		logger.info("Will try to delete " + numAdsToDelete + " Ads");
		List<Long> adIds = getAdIds(nonDeletedAdsForPromotionAdIds);
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final GoogleAdwordsServiceInterface googleAdwordsService = new GoogleAdwordsServiceImpl();
				final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountID = "" + adEngineData.getAccountID();
				final Long adGroupID = adEngineData.getAdGroupID();
				final List<Long> deletedGoogleAdIds = googleAdwordsService.deleteAds(accountID, adGroupID, adIds);
				final int numDeletedAds = deletedGoogleAdIds.size();
				if (numAdsToDelete != numDeletedAds)
				{
					logger.warn("# of ads we expected to delete [" + numAdsToDelete + "] is not the same as the # of ads that were actually deleted [" + numDeletedAds + "] in Google");
				}
				final Map<Long, Integer> deletedAdIdRowCountMap = SemplestDB.markPromotionAdDeletedBulk(new java.util.Date(), deletedGoogleAdIds);
				final Map<Long, Integer> deletedAdIdRowCountMapWithBadRowCounts = getDeletedAdIdRowCountMapWithBadRowCounts(deletedAdIdRowCountMap);
				if (!deletedAdIdRowCountMapWithBadRowCounts.isEmpty())
				{
					logger.warn("Problems updating db with marking the following PromotionAdIds as deleted because row-counts were not 1:\n" + SemplestUtils.getEasilyReadableString(deletedAdIdRowCountMapWithBadRowCounts));
				}
				final Map<Integer, Integer> deletedAdMappingRowCountMap = SemplestDB.deleteAdIDForAdGroupBulk(promotionAdIds, adEngine);
				final Map<Integer, Integer> deletedAdMappingRowCountMapWithBadRowCounts = getDeletedAdMappingRowCountMapWithBadRowCounts(deletedAdMappingRowCountMap);
				if (!deletedAdMappingRowCountMapWithBadRowCounts.isEmpty())
				{
					logger.warn("Problems deleting these Google<->Semplest Ad ID mappings because row-counts were not 1:\n" + SemplestUtils.getEasilyReadableString(deletedAdMappingRowCountMapWithBadRowCounts));
				}
			}
			else if (AdEngine.MSN == adEngine)
			{
				final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
				final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final Long accountId = adEngineData.getAccountID();
				final Long adGroupId = adEngineData.getAdGroupID();
				for (final AdsObject ad : nonDeletedAdsForPromotionAdIds)
				{
					final Long msnAdID = ad.getAdEngineAdID();
					msn.deleteAdById(accountId, adGroupId, msnAdID);
					final Integer promotionAdsPK = ad.getPromotionAdsPK();
					final Integer rowCountMarkPromotionAdDeleted = SemplestDB.markPromotionAdDeleted(new java.util.Date(), msnAdID);
					if (rowCountMarkPromotionAdDeleted != 1)
					{
						logger.warn("Rowcount returned from db when marking Semplest Ad as IsDeleted for MsnAdId [" + msnAdID + "] and SemplestAdID [" + promotionAdsPK + "] is not 1, but is " + rowCountMarkPromotionAdDeleted);
					}
					final Integer rowCountDeleteMapping = SemplestDB.deleteAdIDForAdGroup(adEngine, promotionAdsPK);
					if (rowCountDeleteMapping != 1)
					{
						logger.warn("Rowcount returned from db when deleting MSN<->Semplest Ad ID mapping for MsnAdId [" + msnAdID + "] and SemplestAdID [" + promotionAdsPK + "] is not 1, but is " + rowCountDeleteMapping);
					}
				}
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Removing Ads (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to Delete Ads for PromotionID [" + promotionID + "], PromotionAdIds [" + promotionAdIds + "], AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public String validateGoogleGeoTargets(String json) throws Exception
	{
		logger.debug("call (String json)" + json);
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String promotionIdString = data.get("promotionID");
		final Integer promotionID = Integer.valueOf(promotionIdString);
		final List<GoogleViolation> res = validateGoogleGeoTargets(promotionID);
		return gson.toJson(res);
	}

	@Override
	public List<GoogleViolation> validateGoogleGeoTargets(Integer promotionID) throws Exception
	{
		logger.info("Will try to Validate Google GeoTargets associated with PromotionID [" + promotionID + "]");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final List<GeoTargetObject> geoTargets = getPromoDataSP.getGeoTargets();
		final GoogleAdwordsServiceInterface googleAdwordsService = new GoogleAdwordsServiceImpl();
		final String validationAccountId = "" + AdwordsValidationAccountID;
		final List<GoogleViolation> violations = googleAdwordsService.validateUpdateGeoTargets(validationAccountId, AdwordsValidationCampaignID, geoTargets);
		return violations;
	}

	public String validateGoogleRefreshSiteLinks(String json) throws Exception
	{
		logger.info("JSON [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.valueOf(data.get("promotionID"));
		final List<GoogleViolation> res = validateGoogleRefreshSiteLinks(promotionID);
		return gson.toJson(res);
	}

	public String validateGoogleNegativeKeywords(String json) throws Exception
	{
		logger.info("JSON [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final String negativeKeywordsString = data.get("negativeKeywords");
		final List<String> negativeKeywords = gson.fromJson(negativeKeywordsString, SemplestUtils.TYPE_LIST_OF_STRINGS);
		final List<GoogleViolation> googleValidations = validateGoogleNegativeKeywords(negativeKeywords);
		return gson.toJson(googleValidations);
	}

	@Override
	public List<GoogleViolation> validateGoogleNegativeKeywords(final List<String> negativeKeywords) throws Exception
	{
		logger.info("Will try to Validate Google Negative Keywords [" + negativeKeywords + "]");
		final String googleValidationAccount = String.valueOf(AdwordsValidationAccountID);
		final GoogleAdwordsServiceInterface googleAdwordsService = new GoogleAdwordsServiceImpl();
		final List<GoogleViolation> googleValidations = googleAdwordsService.validateNegativeKeywords(googleValidationAccount, AdwordsValidationCampaignID, negativeKeywords);
		return googleValidations;
	}

	@Override
	public List<GoogleViolation> validateGoogleRefreshSiteLinks(Integer promotionID) throws Exception
	{
		logger.info("Will try to Validate Refresh SiteLinks associated with PromotionID [" + promotionID + "]");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final String googleValidationAccount = String.valueOf(AdwordsValidationAccountID);
		final GetSiteLinksForPromotionSP getSiteLinksForPromotionSP = new GetSiteLinksForPromotionSP();
		Boolean r = getSiteLinksForPromotionSP.execute(promotionID);
		final List<SiteLink> siteLinks = getSiteLinksForPromotionSP.getSiteLinks();
		final List<GoogleSiteLink> googleSiteLinks = getGoogleSiteLinks(siteLinks);
		final GoogleRefreshSiteLinksRequest request = new GoogleRefreshSiteLinksRequest(googleValidationAccount, AdwordsValidationCampaignID, googleSiteLinks);
		logger.info("Generated the following request to validate the update of Google SiteLinks: " + request.toStringPretty());
		final GoogleAdwordsServiceInterface googleAdwordsService = new GoogleAdwordsServiceImpl();
		final List<GoogleViolation> googleValidations = googleAdwordsService.validateRefreshSiteLinks(googleValidationAccount, AdwordsValidationCampaignID, request);
		return googleValidations;
	}

	public String RefreshSiteLinks(String json) throws Exception
	{
		logger.debug("call RefreshSiteLinks(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		RefreshSiteLinks(promotionID, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean RefreshSiteLinks(Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Refresh SiteLinks associated with PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountID = "" + adEngineData.getAccountID();
				final Long campaignID = adEngineData.getCampaignID();
				final GetSiteLinksForPromotionSP getSiteLinksForPromotionSP = new GetSiteLinksForPromotionSP();
				Boolean r = getSiteLinksForPromotionSP.execute(promotionID);
				final List<SiteLink> siteLinks = getSiteLinksForPromotionSP.getSiteLinks();
				final List<GoogleSiteLink> googleSiteLinks = getGoogleSiteLinks(siteLinks);
				final GoogleRefreshSiteLinksRequest request = new GoogleRefreshSiteLinksRequest(accountID, campaignID, googleSiteLinks);
				logger.info("Generated the following request to update Google SiteLinks: " + request.toStringPretty());
				final GoogleAdwordsServiceInterface googleAdwordsService = new GoogleAdwordsServiceImpl();
				final Boolean processedSuccessully = googleAdwordsService.refreshSiteLinks(request);
				if (!processedSuccessully)
				{
					final String errMsg = "Problem refreshing SiteLinks within Campaign [" + campaignID + "] for AccountID [" + accountID + "]";
					logger.error(errMsg);
					errorMap.put(adEngine, errMsg);
				}
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for refreshing sitelinks (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to Refresh SiteLinks associated with PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public String scheduleUpdateAds(String json) throws Exception
	{
		logger.debug("call scheduleUpdateAds(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String promotionAdIdsString = data.get("promotionAdIds");
		List<Integer> promotionAdIds = gson.fromJson(promotionAdIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngineStrings = gson.fromJson(adEnginesString, SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean res = scheduleUpdateAds(customerID, promotionID, promotionAdIds, adEngines);
		return gson.toJson(res);
	}

	@Override
	public Boolean scheduleUpdateAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task for Adding Ad for Customer [" + customerID + "], PromotionID [" + promotionID + "], promotionAdIds [" + promotionAdIds + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "UpdateAds";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createUpdateAdsTask(customerID, promotionID, promotionAdIds, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Update Ads for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdIds [" + promotionAdIds + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String UpdateAds(String json) throws Exception
	{
		logger.debug("call UpdateAds(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String promotionAdIdsString = data.get("promotionAdIds");
		final List<Integer> promotionAdIds = gson.fromJson(promotionAdIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		UpdateAds(promotionID, promotionAdIds, adEngines);
		return gson.toJson(true);
	}

	public static List<UpdateAdRequest> getUpdateRequests(final String newDisplayUrl, final String newUrl, final List<AdsObject> ads)
	{
		final List<UpdateAdRequest> updateRequests = new ArrayList<UpdateAdRequest>();
		for (final AdsObject ad : ads)
		{
			final Long adId = ad.getAdEngineAdID();
			final String newHeadline = SemplestUtils.getTrimmedNonNullString(ad.getAdTitle());
			final String newDescription1 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine1());
			final String newDescription2 = SemplestUtils.getTrimmedNonNullString(ad.getAdTextLine2());
			final Integer promotionAdID = ad.getPromotionAdsPK();
			final UpdateAdRequest updateRequest = new UpdateAdRequest(adId, newHeadline, newDescription1, newDescription2, newDisplayUrl, newUrl, promotionAdID);
			updateRequests.add(updateRequest);
		}
		return updateRequests;
	}

	@Override
	public Boolean UpdateAds(Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Update Ad for PromotionID [" + promotionID + "], PromotionAdIds [" + promotionAdIds + "], AdEndinges [" + adEngines + "]");
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
		final PromotionObj promotion = getPromoDataSP.getPromotionData();
		final String displayURL = SemplestUtils.getTrimmedNonNullString(promotion.getDisplayURL());
		final String url = SemplestUtils.getTrimmedNonNullString(promotion.getLandingPageURL());
		final List<AdsObject> ads = getPromoDataSP.getAds();
		final List<AdsObject> nonDeletedAdsForPromotionAdIds = new ArrayList<AdsObject>();
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountID = SemplestUtils.getTrimmedNonNullString("" + adEngineData.getAccountID());
				final Long adGroupID = adEngineData.getAdGroupID();
				for (final Integer promotionAdID : promotionAdIds)
				{
					final List<AdsObject> adsForPromotionAdID = getAdsForPromotionAdID(ads, promotionAdID);
					final List<AdsObject> nonDeletedAdsForPromotionAdID = getFilteredAds(adsForPromotionAdID, false);
					// TODO: once AdvertisingEngineAds table has constraint such
					// that PromotionFK is unique in the table, remove the
					// sorting code and only deal with 1 item (not List)
					Collections.sort(nonDeletedAdsForPromotionAdID, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
					if (!nonDeletedAdsForPromotionAdID.isEmpty())
					{
						final AdsObject ad = nonDeletedAdsForPromotionAdID.get(0);
						nonDeletedAdsForPromotionAdIds.add(ad);
					}
				}
				if (!nonDeletedAdsForPromotionAdIds.isEmpty())
				{
					final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
					final List<UpdateAdRequest> updateRequests = getUpdateRequests(displayURL, url, nonDeletedAdsForPromotionAdIds);
					final int numUpdateRequests = updateRequests.size();
					logger.info("Will try to update " + numUpdateRequests + " Ads in Google");
					final UpdateAdsRequestObj request = new UpdateAdsRequestObj(accountID, adGroupID, updateRequests);
					final Map<UpdateAdRequest, Long> requestToNewAdIdMap = googleAdwordsService.updateAds(request);
					final int numAdsUpdated = requestToNewAdIdMap.size();
					logger.info("# of Ads updated: " + numAdsUpdated);
					if (numUpdateRequests != numAdsUpdated)
					{
						logger.warn("# of ads we expected to update [" + numUpdateRequests + "] is not the same as the # of ads that were actually updated [" + numAdsUpdated + "]");
					}
					final Map<Entry<UpdateAdRequest, Long>, Integer> updateRequestNewIdToRowCountMap = SemplestDB.updateAdIDForAdGroupBulk(requestToNewAdIdMap, adEngine);
					final Map<Entry<UpdateAdRequest, Long>, Integer> updateRequestNewIdToRowCountMapWithBadRowCounts = getUpdateRequestNewIdToRowCountMapWithBadRows(updateRequestNewIdToRowCountMap);
					if (!updateRequestNewIdToRowCountMapWithBadRowCounts.isEmpty())
					{
						logger.warn("Problems updating db with updating AdEngineAdID for the following because row-counts were not 1:\n" + SemplestUtils.getEasilyReadableString(updateRequestNewIdToRowCountMapWithBadRowCounts));
					}
				}
				else
				{
					final String errMsg = "Could not find non-deleted Ads in database for PromotionID [" + promotionID + "] and PromotionAdIds [" + promotionAdIds + "] for Google";
					logger.error(errMsg);
					errorMap.put(adEngine, errMsg);
				}
			}
			else if (AdEngine.MSN == adEngine)
			{
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountID = SemplestUtils.getTrimmedNonNullString("" + adEngineData.getAccountID());
				final Long adGroupID = adEngineData.getAdGroupID();
				for (final Integer promotionAdID : promotionAdIds)
				{
					final List<AdsObject> adsForPromotionAdID = getAdsForPromotionAdID(ads, promotionAdID);
					final List<AdsObject> nonDeletedAdsForPromotionAdID = getFilteredAds(adsForPromotionAdID, false);
					// TODO: once AdvertisingEngineAds table has constraint such
					// that PromotionFK is unique in the table, remove the
					// sorting code and only deal with 1 item (not List)
					Collections.sort(nonDeletedAdsForPromotionAdID, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
					if (!nonDeletedAdsForPromotionAdID.isEmpty())
					{
						final AdsObject ad = nonDeletedAdsForPromotionAdID.get(0);
						nonDeletedAdsForPromotionAdIds.add(ad);
					}
				}
				if (!nonDeletedAdsForPromotionAdIds.isEmpty())
				{
					logger.info("Updating Ads on MSN for PromotionID = " + promotionID);
					final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
					final List<UpdateAdRequest> updateRequests = getUpdateRequests(displayURL, url, nonDeletedAdsForPromotionAdIds);
					final int numUpdateRequests = updateRequests.size();
					logger.info("Will try to update " + numUpdateRequests + " Ads inMSN");
					final UpdateAdsRequestObj request = new UpdateAdsRequestObj(accountID, adGroupID, updateRequests);
					Map<UpdateAdRequest, Long> requestToNewAdIdMap = msn.updateAllAdById(request);
					final int numAdsUpdated = requestToNewAdIdMap.size();
					logger.info("# of Ads updated: " + numAdsUpdated);
					if (numUpdateRequests != numAdsUpdated)
					{
						logger.warn("# of ads we expected to update [" + numUpdateRequests + "] is not the same as the # of ads that were actually updated [" + numAdsUpdated + "]");
					}
					final Map<Entry<UpdateAdRequest, Long>, Integer> updateRequestNewIdToRowCountMap = SemplestDB.updateAdIDForAdGroupBulk(requestToNewAdIdMap, adEngine);
					final Map<Entry<UpdateAdRequest, Long>, Integer> updateRequestNewIdToRowCountMapWithBadRowCounts = getUpdateRequestNewIdToRowCountMapWithBadRows(updateRequestNewIdToRowCountMap);
					if (!updateRequestNewIdToRowCountMapWithBadRowCounts.isEmpty())
					{
						logger.warn("Problems updating db with updating AdEngineAdID for the following because row-counts were not 1:\n" + SemplestUtils.getEasilyReadableString(updateRequestNewIdToRowCountMapWithBadRowCounts));
					}
				}
				else
				{
					final String errMsg = "Could not find non-deleted Ads in database for PromotionID [" + promotionID + "] and PromotionAdIds [" + promotionAdIds + "] for Google";
					logger.error(errMsg);
					errorMap.put(adEngine, errMsg);
				}
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for updating ads (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to Update Ads for PromotionID [" + promotionID + "], PromotionAdIds [" + promotionAdIds + "], AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public String UpdateBudget(String json) throws Exception
	{
		logger.debug("call UpdateBudget(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Double changeInBudget = Double.parseDouble(data.get("changeInBudget"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		UpdateBudget(promotionID, changeInBudget, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean UpdateBudget(Integer promotionID, Double changeInBudgetMonthly, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to Change Budget for PromotionID [" + promotionID + "] by changeInBudgetMonthly [" + changeInBudgetMonthly + "] for AdEngines [" + adEngines + "]");
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
				Boolean ret = getPromoDataSP.execute(promotionID);
				final Map<AdEngine, AdEngineID> promotionAdEngineData = getPromoDataSP.getPromotionAdEngineID(promotionID);
				final AdEngineID adEngineData = promotionAdEngineData.get(adEngine);
				final String accountID = "" + adEngineData.getAccountID();
				final Long campaignID = adEngineData.getCampaignID();
				final PromotionObj promotion = getPromoDataSP.getPromotionData();
				final Double oldBudgetAmount = promotion.getPromotionBudgetAmount();
				final Double changeInBudgetDaily = changeInBudgetMonthly / 31;
				final Double newBudgetDouble = oldBudgetAmount + changeInBudgetDaily;
				final Double newBudgetDoubleGoogleUnits = newBudgetDouble * SemplestUtils.GOOGLE_MONEY_UNIT;
				final Long newBudgetAmountGoogleUnits = newBudgetDoubleGoogleUnits.longValue();
				final Double oldBudgetDoubleGoogleUnits = oldBudgetAmount * SemplestUtils.GOOGLE_MONEY_UNIT;
				final Long oldBudgetAmountGoogleUnits = oldBudgetDoubleGoogleUnits.longValue();
				logger.info("Will try to update Old Budget [" + oldBudgetAmount + "] (" + oldBudgetAmountGoogleUnits + " in Google Units) with New Budget [" + newBudgetDouble + "] (" + newBudgetAmountGoogleUnits + " in Google Units)");
				final Boolean processedSuccessully = googleAdwordsService.changeCampaignBudget(accountID, campaignID, newBudgetAmountGoogleUnits);
				if (!processedSuccessully)
				{
					final String errMsg = "Problem processing budget change from Old Budget [" + oldBudgetAmount + "] to New Budget [" + newBudgetDouble + "] for GoogleAccountID [" + accountID + "], CampaignID [" + campaignID + "]";
					logger.error(errMsg);
					errorMap.put(adEngine, errMsg);
				}
				else
				{
					// TODO: update budget in DB (ask Mitch where to do that)
				}
			}
			else if (AdEngine.MSN == adEngine)
			{
				final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
				Boolean ret = getPromoDataSP.execute(promotionID);
				final PromotionObj promotion = getPromoDataSP.getPromotionData();
				final Map<AdEngine, AdEngineID> promotionAdEngineData = getPromoDataSP.getPromotionAdEngineID(promotionID);
				final AdEngineID adEngineData = promotionAdEngineData.get(adEngine);
				final Long accountId = adEngineData.getAccountID();
				final Long campaignId = adEngineData.getCampaignID();
				final MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
				final Double oldMonthlyBudget = promotion.getPromotionBudgetAmount();
				final Double oldDailyBudget = oldMonthlyBudget / 31;
				final Double changeInBudgetDaily = changeInBudgetMonthly / 31;
				final double dailyBudget = oldDailyBudget + changeInBudgetDaily;
				final double monthlyBudget = oldMonthlyBudget + changeInBudgetMonthly;
				msn.updateCampaignBudget(accountId, campaignId, BudgetLimitType.DailyBudgetStandard, dailyBudget, monthlyBudget);
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for updating budgets (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to Change Budget for PromotionID [" + promotionID + "] by [" + changeInBudgetMonthly + "] for AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public String scheduleChangePromotionStartDate(String json) throws Exception
	{
		logger.debug("call scheduleChangePromotionStartDate(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String newStartDateString = data.get("newStartDate");
		final java.util.Date newStartDate = SemplestUtils.DATE_FORMAT_YYYYMMDD.parse(newStartDateString);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleChangePromotionStartDate(customerID, promotionID, newStartDate, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleChangePromotionStartDate(Integer customerID, Integer promotionID, Date newStartDate, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Change Promotion StartDate for Customer [" + customerID + "], PromotionID [" + promotionID + "], New Start Date [" + newStartDate + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "ChangePromotionStartDate";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createChangePromotionStartDateTask(customerID, promotionID, newStartDate, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Change Promotion StartDate for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String ChangePromotionStartDate(String json) throws Exception
	{
		logger.debug("call ChangePromotionStartDate(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String newStartDateString = data.get("newStartDate");
		final java.util.Date newStartDate = SemplestUtils.DATE_FORMAT_YYYYMMDD.parse(newStartDateString);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		ChangePromotionStartDate(promotionID, newStartDate, adEngines);
		return gson.toJson(true);
	}

	@Override
	public Boolean ChangePromotionStartDate(Integer promotionID, Date newStartDate, List<AdEngine> adEngines) throws Exception
	{
		logger.info("Will try to change StartDate for PromotionID [" + promotionID + "] to  [" + newStartDate + "] for AdEngines [" + adEngines + "]");
		final Map<AdEngine, String> errorMap = new HashMap<AdEngine, String>();
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		Boolean ret = getPromoDataSP.execute(promotionID);
		final Map<AdEngine, AdEngineID> promotionAdEngineDataMap = getPromoDataSP.getPromotionAdEngineID(promotionID);
		for (final AdEngine adEngine : adEngines)
		{
			if (AdEngine.Google == adEngine)
			{
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final AdEngineID adEngineData = promotionAdEngineDataMap.get(adEngine);
				final String accountID = "" + adEngineData.getAccountID();
				final Long campaignID = adEngineData.getCampaignID();
				final Boolean processedSuccessully = googleAdwordsService.ChangeCampaignStartDate(accountID, campaignID, newStartDate);
				if (!processedSuccessully)
				{
					final String errMsg = "Problem changing StartDate in Google Campaign [" + campaignID + "] to [" + newStartDate + "] for GoogleAccountID [" + accountID + "]";
					logger.error(errMsg);
					errorMap.put(adEngine, errMsg);
				}
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for changing Promotion Start Dates (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}
		}
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to Change StartDate for PromotionID [" + promotionID + "], AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
		return true;
	}

	public List<GoogleSiteLink> getGoogleSiteLinks(final List<SiteLink> siteLinks)
	{
		final List<GoogleSiteLink> googleSiteLinks = new ArrayList<GoogleSiteLink>();
		for (final SiteLink siteLink : siteLinks)
		{
			final GoogleSiteLink googleSiteLink = new GoogleSiteLink();
			googleSiteLink.setLinkText(siteLink.getLinkText());
			googleSiteLink.setLinkURL(siteLink.getLinkURL());
			googleSiteLinks.add(googleSiteLink);
		}
		return googleSiteLinks;
	}

	public String scheduleAddPromotionToAdEngine(String json) throws Exception
	{
		logger.debug("call scheduleAddPromotionToAdEngine(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer productGroupID = Integer.parseInt(data.get("productGroupID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleAddPromotionToAdEngine(customerID, productGroupID, promotionID, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleAddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Add Promotion To AdEngine for Customer [" + customerID + "], ProductGroupID [" + productGroupID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "AddPromotionToAdEngine";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createAddPromotionToAdEngineTask(customerID, productGroupID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, productGroupID, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Add Promotion To AdEngine for Customer [" + customerID + "], ProductGroupID [" + productGroupID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String scheduleUpdateBudget(String json) throws Exception
	{
		logger.debug("call scheduleUpdateBudget(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Double changeInBudget = Double.parseDouble(data.get("changeInBudget"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleUpdateBudget(customerID, promotionID, changeInBudget, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleUpdateBudget(Integer customerID, Integer promotionID, Double changeInBudget, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Update Budget for Customer [" + customerID + "], PromotionID [" + promotionID + "], ChangeInBudget [" + changeInBudget + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "UpdateBudget";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createUpdateBudgetTask(customerID, promotionID, changeInBudget, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Update Budget for Customer [" + customerID + "], PromotionID [" + promotionID + "], ChangeInBudget [" + changeInBudget + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String scheduleUnpausePromotion(String json) throws Exception
	{
		logger.debug("call scheduleUnpausePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleUnpausePromotion(customerID, promotionID, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleUnpausePromotion(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Unpause Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "UnpausePromotion";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createUnpausePromotionTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Unpause Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String scheduleDeleteKeywords(String json) throws Exception
	{
		logger.debug("call scheduleDeleteKeywords(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String keywordsString = data.get("keywordIds");
		final List<Integer> keywordIds = gson.fromJson(keywordsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleDeleteKeywords(customerID, promotionID, keywordIds, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleDeleteKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Delete Keyword for Customer [" + customerID + "], PromotionID [" + promotionID + "], KeywordIds [" + keywordIds + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "DeleteKeywords";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createDeleteKeywordTask(customerID, promotionID, keywordIds, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Delete Keywords for Customer [" + customerID + "], PromotionID [" + promotionID + "], KeywordIds [" + keywordIds + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String scheduleRefreshSiteLinks(String json) throws Exception
	{
		logger.debug("call scheduleRefreshSiteLinks(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = scheduleRefreshSiteLinks(customerID, promotionID, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleRefreshSiteLinks(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Refresh SiteLinks for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "RefreshSiteLinks";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createRefreshSiteLinksForAdTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			Boolean ret = getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Refresh SiteLinks for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String schedulePauseProductGroups(String json) throws Exception
	{
		logger.debug("call schedulePauseProductGroup(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final String productGroupIdsString = data.get("productGroupIds");
		final List<Integer> productGroupIds = gson.fromJson(productGroupIdsString, SemplestUtils.TYPE_LIST_OF_INTEGERS);
		final List<String> adEngineStrings = gson.fromJson(data.get("adEngines"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		AdEngine.validateAdEngines(adEngineStrings);
		final List<AdEngine> adEngines = AdEngine.getAdEngines(adEngineStrings);
		if (adEngines.isEmpty())
		{
			throw new Exception("No AdEngines specified");
		}
		final Boolean result = schedulePauseProductGroups(customerID, productGroupIds, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean schedulePauseProductGroups(Integer customerID, List<Integer> productGroupIds, List<AdEngine> adEngines) throws Exception
	{
		try
		{
			logger.info("Will try to schedule task to Pause ProductGroup for Customer [" + customerID + "], ProductGroupIds [" + productGroupIds + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "PauseProductGroups";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createPauseProductGroupTask(customerID, productGroupIds, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final String scheduleName = "ProductGroups[" + productGroupIds + "]_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(ESBWebServerURL, listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			final String errMsg = "Problem scheduling task to Pause ProductGroups for Customer [" + customerID + "], ProductGroupIds [" + productGroupIds + "], AdEngines [" + adEngines + "]";
			logger.error(errMsg, e);
			throw new Exception(errMsg, e);
		}
	}

	public String getGoogleKeywordIdeas(String json) throws Exception
	{
		logger.debug("call  getGoogleKeywordIdeas(String json)" + json);
		Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		List<String> keywords = gson.fromJson(data.get("keywords"), SemplestUtils.TYPE_LIST_OF_STRINGS);
		Integer numberResults = Integer.parseInt(data.get("numberResults"));
		KeywordToolStats[] res = getGoogleKeywordIdeas(keywords, numberResults);
		return gson.toJson(res);
	}

	@Override
	public KeywordToolStats[] getGoogleKeywordIdeas(List<String> keywords, int numberResults) throws Exception
	{
		GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
		String[] keywordArr = new String[keywords.size()];
		keywordArr = keywords.toArray(keywordArr);
		ArrayList<KeywordToolStats> res = google.getGoogleKeywordIdeas(keywordArr, numberResults);
		KeywordToolStats[] statsArr = new KeywordToolStats[res.size()];
		return res.toArray(statsArr);
	}

	public String validateGoogleAd(String json) throws Exception
	{
		logger.debug("call  validateGoogleAd(String json)" + json);
		Map<String, String> data = gson.fromJson(json, SemplestUtils.TYPE_MAP_OF_STRING_TO_STRING);
		String landingPageURL = data.get("landingPageURL");
		String displayURL = data.get("displayURL");
		Type type = new TypeToken<List<GoogleAddAdRequest>>(){}.getType();
		List<GoogleAddAdRequest> ads = gson.fromJson(data.get("ads"), type);
		List<GoogleViolation> res = validateGoogleAd(landingPageURL, displayURL, ads);
		return gson.toJson(res);
	}

	@Override
	public List<GoogleViolation> validateGoogleAd(String landingPageURL, String displayURL, List<GoogleAddAdRequest> ads) throws Exception
	{
		List<GoogleViolation> res = new ArrayList<GoogleViolation>();
		GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
		for (GoogleAddAdRequest oneAd : ads)
		{
			List<GoogleViolation> ret = google.validateAd(String.valueOf(AdwordsValidationAccountID), AdwordsValidationAdGroupID, landingPageURL, displayURL, oneAd.getHeadline(), oneAd.getDescription1(), oneAd.getDescription2());
			res.addAll(ret);
		}
		return res;
	}

	@Override
	public String checkStatus(String input) throws Exception
	{
		return ServiceStatus.Up.getServiceStatusValue();
	}

}
