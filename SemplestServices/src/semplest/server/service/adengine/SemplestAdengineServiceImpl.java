package semplest.server.service.adengine;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.other.MsnManagementIds;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.SemplestMatchType;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.BudgetObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.SemplestCampaignStatus;
import semplest.server.protocol.adengine.SiteLink;
import semplest.server.protocol.google.GoogleSiteLink;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.AdvertisingEnginePromotionObj;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.AddBidSP;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;
import semplest.server.service.springjdbc.storedproc.GetKeywordForAdEngineSP;
import semplest.server.service.springjdbc.storedproc.GetSiteLinksForPromotionSP;
import semplest.server.service.springjdbc.storedproc.UpdateRemainingBudgetInCycleSP;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.service.scheduler.CreateSchedulerAndTask;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.services.client.interfaces.SemplestAdengineServiceInterface;
import semplest.util.SemplestUtils;

import com.google.api.adwords.lib.AdWordsService;
import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.mcm.Account;
import com.google.gson.Gson;

public class SemplestAdengineServiceImpl implements SemplestAdengineServiceInterface
{
	private static final Logger logger = Logger.getLogger(SemplestAdengineServiceImpl.class);
	private static Gson gson = new Gson();
	private SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
	private static Calendar cal = Calendar.getInstance();

	// private String esbURL = "http://VMDEVJAVA1:9898/semplest";

	// CustomerID = 2 State Farm coffee machine promotionID = 4
	// ProductGroupID=37 coffee machine
	public static void main(String[] args) throws Exception
	{
		try
		{

			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			
			/*
			 * GetKeywordForAdEngineSP getKeywords = new
			 * GetKeywordForAdEngineSP(); String advertisingEngine = "Google";
			 * List<KeywordProbabilityObject> keywordList =
			 * getKeywords.execute(4,
			 * (advertisingEngine.equalsIgnoreCase(AdEngine.Google.name())) ?
			 * true : false ,
			 * (advertisingEngine.equalsIgnoreCase(AdEngine.MSN.name())) ? true
			 * : false); keywordList.size();
			 */
			
			
			ArrayList<String> adEngList = new ArrayList<String>();
			adEngList.add("Google");
			String scheduleName = "ReceptionHalls_OnGoingBidding";
			// Schedule for next day at the same time
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_MONTH, 1);
			Date startTime = cal.getTime();
			SemplestAdengineServiceImpl adEng = new SemplestAdengineServiceImpl();
			adEng.initializeService(null);
			adEng.scheduleOngoingBidding(scheduleName, 60, adEngList, startTime);
			
			//SemplestAdengineServiceImpl adEng = new SemplestAdengineServiceImpl();
			//adEng.initializeService(null);
			//Thread.sleep(1000);
			// Long micro = adEng.calculateDailyMicroBudgetFromMonthly(new
			// Double(25.0), 30);
			// String u = adEng.getURL("www.xyz.com");
			// Tovah Photography 2 47 Photography 58 38 Event and portrait
			// photos
			//adEng.AddPromotionToAdEngine(12, 76, 62, adEngList);
			//adEng.AddPromotionToAdEngine(74, 171, 183, adEngList);
			//adEng.AddPromotionToAdEngine(95,182, 197, adEngList);
			//adEng.AddPromotionToAdEngine(26,51, 60, adEngList);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		
		/*
		 * GetKeywordForAdEngineSP getKeywords = new
		 * GetKeywordForAdEngineSP(); String advertisingEngine = "Google";
		 * List<KeywordProbabilityObject> keywordList =
		 * getKeywords.execute(4,
		 * (advertisingEngine.equalsIgnoreCase(AdEngine.Google.name())) ?
		 * true : false ,
		 * (advertisingEngine.equalsIgnoreCase(AdEngine.MSN.name())) ? true
		 * : false); keywordList.size();
		 */
		ArrayList<String> adEngList = new ArrayList<String>();
		adEngList.add("Google");
		SemplestAdengineServiceImpl adEng = new SemplestAdengineServiceImpl();
		adEng.initializeService(null);
		//Thread.sleep(1000);
		// Long micro = adEng.calculateDailyMicroBudgetFromMonthly(new
		// Double(25.0), 30);
		// String u = adEng.getURL("www.xyz.com");
		// Tovah Photography 2 47 Photography 58 38 Event and portrait
		// photos
		//adEng.AddPromotionToAdEngine(12, 76, 62, adEngList);
		adEng.AddPromotionToAdEngine(74, 171, 183, adEngList);

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

	public String AddPromotionToAdEngine(String json) throws Exception
	{
		logger.debug("call  AddPromotionToAdEngine(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer customerID = Integer.parseInt(data.get("customerID"));
		Integer productGroupID = Integer.parseInt(data.get("productGroupID"));
		Integer promotionID = Integer.parseInt(data.get("promotionID"));
		ArrayList<String> adEngineList = gson.fromJson(data.get("adEngineList"), ArrayList.class);
		AddPromotionToAdEngine(customerID, productGroupID, promotionID, adEngineList);
		return gson.toJson(true);
	}

	@Override
	public void AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList)
			throws Exception
	{		
		/*
			// 1. Create Account - AdWordsService.V201109.CREATE_ACCOUNT_SERVICE
			// 2. Create Campaign - AdWordsService.V201109.CAMPAIGN_SERVICE
			// 3. Create AdGroup - AdWordsService.V201109.ADGROUP_SERVICE
			// 4. Create Ads - AdWordsService.V201109.ADGROUP_AD_SERVICE
			// 5. Set GeoTargets - AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE
			// 6. Add Negative Keywords - AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE
			// 7. Add Keywords - AdWordsService.V201109.ADGROUP_CRITERION_SERVICE
			// 8. Service call - semplest.service.bidding.BidGeneratorService#setBidsInitial
			// 9. Schedule OnGoingBidding  
		 */
		final SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient((String) SemplestConfiguration.configData.get("ESBWebServerURL"), getTimeoutMS());
		final HashMap<String, AdEngineInitialData> adEngineInitialMap = bidClient.getInitialValues(PromotionID, adEngineList);
		final GetKeywordForAdEngineSP getKeywords = new GetKeywordForAdEngineSP();
		final Map<String, HashMap<String, Object>> remainingBudgetDaysMap = setupAdEngineBudget(PromotionID, adEngineList, bidClient);
		String companyName = null;
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		getPromoDataSP.execute(PromotionID);
		for (final String advertisingEngine : adEngineList)
		{
			Long accountID = null;
			final AdEngineInitialData adEngineInitialData = adEngineInitialMap.get(advertisingEngine);
			if (!AdEngine.existsAdEngine(advertisingEngine))
			{
				throw new Exception(advertisingEngine + " Not Found");
			}
			final List<Map<String, Object>> AdEngineAccoutRow = SemplestDB.getAdEngineAccount(customerID, advertisingEngine);
			companyName = (String) AdEngineAccoutRow.get(0).get("CustomerName");
			if (AdEngineAccoutRow.get(0).get("AccountID") == null)
			{
				
				accountID = createAdEngineAccount(advertisingEngine, companyName);
				SemplestDB.addAdEngineAccountID(customerID, accountID, advertisingEngine);
				logger.debug("Created Account for " + companyName + ":" + String.valueOf(accountID));
			}
			else
			{
				accountID = (Long) AdEngineAccoutRow.get(0).get("AccountID");
				logger.debug("Found Account for " + companyName + ":" + String.valueOf(accountID));
			}
			final AdvertisingEnginePromotionObj promotionDataList = SemplestDB.getAdvertisingEngineCampaign(accountID, PromotionID);
			if (promotionDataList != null)
			{
				throw new Exception("A Campaign has already been created for the Promotion " + PromotionID);
			}
			else
			{
				final Double budget = (Double) remainingBudgetDaysMap.get(advertisingEngine).get("RemainingBudgetInCycle");
				final Integer daysLeft = (Integer) remainingBudgetDaysMap.get(advertisingEngine).get("RemainingDays");				
				final Long campaignID = createCampaign(String.valueOf(accountID), PromotionID, customerID, advertisingEngine, budget, getPromoDataSP, daysLeft); 
				SemplestDB.addPromotionToAdEngineAccountID(PromotionID, accountID, campaignID, null);
				final AdgroupData adGroupData = createAdGroupAndAds(String.valueOf(accountID), campaignID, advertisingEngine, AdGroupStatus.ENABLED, getPromoDataSP, adEngineInitialData.getDefaultMicroBid());
				storeAdGroupData(advertisingEngine, campaignID, adGroupData);
				final List<KeywordProbabilityObject> keywordList = getKeywords.execute(PromotionID, (advertisingEngine.equalsIgnoreCase(AdEngine.Google.name())) ? true : false, (advertisingEngine.equalsIgnoreCase(AdEngine.MSN.name())) ? true : false);
				addKeywordsToAdGroup(String.valueOf(accountID), campaignID, PromotionID, adGroupData.getAdGroupID(), advertisingEngine, keywordList, KeywordMatchType.fromString(SemplestMatchType.getSearchEngineMatchType(adEngineInitialData.getSemplestMatchType(), advertisingEngine)), null);
				final BudgetObject budgetData = new BudgetObject();
				budgetData.setRemainingBudgetInCycle(budget);
				budgetData.setRemainingDays(daysLeft);
				bidClient.setBidsInitial(PromotionID, advertisingEngine, budgetData);
				final String scheduleName = getPromoDataSP.getPromotionData().getPromotionName() + "_OnGoingBidding";
				cal.setTime(new Date());
				cal.add(Calendar.DAY_OF_MONTH, 1);
				final Date startTime = cal.getTime();
				scheduleOngoingBidding(scheduleName, PromotionID, adEngineList, startTime);
			}
		}
	}
	
	private String getTimeoutMS()
	{
		String bidTimeoutMS = null;
		Object timeout =  SemplestConfiguration.configData.get("SemplestClientBiddingTimeoutMS");
		if (timeout != null)
		{
			bidTimeoutMS = String.valueOf((Integer) timeout);
		}
		return  bidTimeoutMS;
	}

	/*
	 * schedules the on-going bidding
	 */
	private void scheduleOngoingBidding(String scheduleName, int promotionID, ArrayList<String> adEngineList, Date startTime) throws Exception
	{
		
		ArrayList<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>(); 
		SemplestSchedulerTaskObject executeOngoinBiddingTask = CreateSchedulerAndTask.ExecuteBidProcess(promotionID, adEngineList);
		listOfTasks.add(executeOngoinBiddingTask);
		CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, startTime, null, ProtocolEnum.ScheduleFrequency.Daily.name(), true, false, promotionID, null, null, null);
		//*****TEST
		//CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.TenMinutes.name(), true, false, promotionID, null, null, null);
	}

	/*
	 * store the adGroupID and AdIDs
	 */
	private void storeAdGroupData(String advertisingEngine, Long campaignID, AdgroupData adGroupData) throws Exception
	{
		SemplestDB.setAdvertisingEngineAdGroupID(campaignID, adGroupData.getAdGroupID());
		List<AdsObject> adList = adGroupData.getAds();
		for (AdsObject adObj : adList)
		{
			SemplestDB.setAdIDForAdGroup(adObj.getAdEngineAdID(), advertisingEngine, adObj.getPromotionAdsPK());
		}
	}
	
	public String DeleteKeyword(String json) throws Exception
	{
		logger.debug("call DeleteKeyword(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, HashMap.class);
		final Integer PromotionID = Integer.parseInt(data.get("promotionID"));
		final String keyword = data.get("keyword");
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		DeleteKeyword(PromotionID, keyword, adEngines);
		return gson.toJson(true);
	}
	
	@Override
	public void DeleteKeyword(Integer promotionID, String keyword, List<String> adEngines) throws Exception
	{
		logger.info("Will try to Delete Keyword [" + keyword + "] for PromotionID [" + promotionID + "] and AdEngines [" + adEngines + "]");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		getPromoDataSP.execute(promotionID);
		final PromotionObj promotion = getPromoDataSP.getPromotionData();
		final String accountId = "" + promotion.getAdvertisingEngineAccountPK();
		final Long adGroupID = promotion.getAdvertisingEngineAdGroupID();
		final Map<String, String> errorMap = new HashMap<String, String>();
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{
				logger.info("Will try to Delete Keyword [" + keyword + "] within Google Adwords for AccountID [" + accountId + "], AdGroupID [" + adGroupID + "]");
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				googleAdwordsService.deleteKeyWordFromAdGroup(accountId, adGroupID, keyword);		
			}
			else
			{
				final String errMsg = "AdEngine specified [" + adEngine + "] is not valid for Deleting Keywords (at least not yet)";
				logger.error(errMsg);
				errorMap.put(adEngine, errMsg);
			}						
		}			
		if (!errorMap.isEmpty())
		{
			final String errorMapEasilyReadableString = SemplestUtils.getEasilyReadableString(errorMap);
			final String errMsg = "Summary of errors when trying to Delete Keyword [" + keyword + "] for PromotionID [" + promotionID + "] and AdEngines [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
	}

	private void addKeywordsToAdGroup(String accountID, Long campaignID, Integer promotionID, Long adGroupID, String adEngine,
			List<KeywordProbabilityObject> keywordList, KeywordMatchType matchType, Long microBidAmount) throws Exception
	{
		int TEST = 0;
		AddBidSP addKeywordBidSP = new AddBidSP();
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			// assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			for (KeywordProbabilityObject keywordObj : keywordList)
			{
				KeywordDataObject keywordDataObj = null;
				if (keywordObj.getIsNegative())
				{					
					keywordDataObj = google.addNegativeKeyWordToAdGroup(accountID, campaignID, keywordObj.getKeyword(), matchType);
				}
				else
				{					
					keywordDataObj = google.addKeyWordToAdGroup(accountID, adGroupID, keywordObj.getKeyword(), matchType, microBidAmount);
				}

				// Store result in DB including AdEngine KeywordID
				// int PromotionPK, Long KeywordAdEngineID, String Keyword,
				// Integer MicroBidAmount, String BidType, String
				// AdvertisingEngine, Boolean IsNegative
				addKeywordBidSP.execute(promotionID, keywordDataObj.getBidID(), keywordDataObj.getKeyword(), keywordDataObj.getMicroBidAmount().intValue(), 
						keywordDataObj.getMatchType(), adEngine, keywordObj.getIsNegative());
				logger.info("Add Keyword " + keywordDataObj.getKeyword() + " to " + promotionID.toString());
				Thread.sleep(500); // Wait for google
				//*****TEST
				//TEST++;
				//if (TEST > 15) return;
			}
		}

	}

	private HashMap<String, HashMap<String, Object>> setupAdEngineBudget(Integer PromotionID, ArrayList<String> adEngineList,
			SemplestBiddingServiceClient bidClient) throws Exception
	{
		HashMap<String, HashMap<String, Object>> remainingBudgetDaysMap = new HashMap<String, HashMap<String, Object>>();
		HashMap<String, Double> AdEngineBudgetPercent = bidClient.GetMonthlyBudgetPercentPerSE(PromotionID, adEngineList);
		BudgetObject remainingBudget = SemplestDB.getBudget(PromotionID);
		Iterator<String> adEngineIT = AdEngineBudgetPercent.keySet().iterator();
		while (adEngineIT.hasNext())
		{
			String adEng = adEngineIT.next();
			Double budgetSplit = remainingBudget.getRemainingBudgetInCycle() * (0.01 * AdEngineBudgetPercent.get(adEng));
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("RemainingBudgetInCycle", budgetSplit);
			data.put("RemainingDays", remainingBudget.getRemainingDays());
			remainingBudgetDaysMap.put(adEng, data);
		}
		return remainingBudgetDaysMap;
	}

	private AdgroupData createAdGroupAndAds(String accountID, Long campaignID, String adEngine, AdGroupStatus status,
			GetAllPromotionDataSP getPromoDataSP, Long defaultMicroBid) throws Exception
	{

		AdgroupData adGrpData = new AdgroupData();
		List<AdsObject> adList = getPromoDataSP.getAds();
		PromotionObj promotionData = getPromoDataSP.getPromotionData();
		Long adGroupID = null;
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();			
			adGroupID = google.AddAdGroup(accountID, campaignID, promotionData.getPromotionName() + "_AdGroup", status, defaultMicroBid);
			adGrpData.setAdGroupID(adGroupID);
			for (AdsObject ad : adList)
			{
				Thread.sleep(1000);				
				Long adID = google.addTextAd(accountID, adGroupID, ad.getAdTitle(), ad.getAdTextLine1(), ad.getAdTextLine2(),
						promotionData.getLandingPageURL(), promotionData.getLandingPageURL());
				ad.setAdEngineAdID(adID);
				logger.info("Added Ad Copy. Title=" + ad.getAdTitle());
			}
			adGrpData.setAds(adList);
			// AD GEOTARGET HERE
			List<GeoTargetObject> geoObjList = getPromoDataSP.getGeoTargets();
			for (GeoTargetObject geoObj : geoObjList)
			{
				Thread.sleep(1000);				
				google.setGeoTarget(accountID, campaignID, geoObj.getLatitude(), geoObj.getLongitude(), geoObj.getRadius(), geoObj.getAddress(), geoObj.getCity(), geoObj.getState(),
						geoObj.getZip());
				logger.info("Added GeoTarget. Title=" + geoObj.getAddress());
				
			}

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
	private Long createCampaign(String accountID, Integer promotionID, Integer customerID, String adEngine, Double monthlyBudgetAmount,
			GetAllPromotionDataSP getPromoDataSP, Integer remainingDaysInCycle) throws Exception
	{
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
		{
			// assume US dollars US timezone
			GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
			// get the promotion name/ campaign name, Budget period,
			Long microbudgetAmount = calculateDailyMicroBudgetFromMonthly(monthlyBudgetAmount, remainingDaysInCycle);
			Campaign campaign = google.CreateOneCampaignForAccount(accountID, getPromoDataSP.getPromotionData().getPromotionName(), // + System.currentTimeMillis(),
					CampaignStatus.ACTIVE, BudgetBudgetPeriod.DAILY, microbudgetAmount);
			return campaign.getId();
		}

		else if (adEngine.equalsIgnoreCase(AdEngine.MSN.name()))
		{
			return null;
		}
		else
		{
			throw new Exception(adEngine + " Not found to create account");
		}

	}

	/*
	 * 
	 */
	private Long calculateDailyMicroBudgetFromMonthly(Double monthlyBudget, Integer remainingDaysInCycle)
	{
		Double daily = ((7.0 * monthlyBudget) / remainingDaysInCycle.doubleValue()) * 100.;
		// calculate
		BigDecimal bd = new BigDecimal(daily);
		return (bd.longValue() * 10000L);
	}

	private Long createAdEngineAccount(String adEngine, String companyName) throws Exception
	{
		if (adEngine.equalsIgnoreCase(AdEngine.Google.name()))
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
				logger.error("Error Setting up Budget at the account level " + e.getMessage());
			}
			return account.getCustomerId();
		}
		else if (adEngine.equalsIgnoreCase(AdEngine.MSN.name()))
		{
			// assume US dollars US timezone
			SemplestString company = new SemplestString();
			MsnCloudServiceImpl msn = new MsnCloudServiceImpl();
			company.setSemplestString(companyName + "_Semplest");
			MsnManagementIds id = msn.createAccount(company);
			return id.getCustomerId();
		}
		else
		{
			throw new Exception(adEngine + " Not found to create account");
		}

	}

	/*
	 * This executes the bidding process synchronously
	 */
	public String ExecuteBidProcess(String json) throws Exception
	{
		logger.debug("call ExecuteBidProcess(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer promotionID = Integer.parseInt(data.get("promotionID"));
		ArrayList<String> adEngineList = gson.fromJson(data.get("adEngineList"), ArrayList.class);
		ExecuteBidProcess(promotionID, adEngineList);
		return gson.toJson(true);
	}

	@Override
	public void ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngineList) throws Exception
	{
		GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		getPromoDataSP.execute(PromotionID);
		PromotionObj promoObj = getPromoDataSP.getPromotionData();
		/*
		 * look back 5 days to get the transactions
		 */
		
		Date now = new Date();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_MONTH, -5);
		for (String adEngine : adEngineList)
		{
			if (adEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.Google.name()))
			{
				// go get the report from Google
				SemplestString semplstStr = new SemplestString();
				semplstStr.setSemplestString(promoObj.getAdvertisingEngineAccountPK().toString());
				GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
				try
				{
					ReportObject[] getReportData = google.getReportForAccount(promoObj.getAdvertisingEngineAccountPK().toString(), YYYYMMDD.format(cal.getTime()), YYYYMMDD.format(now));
					SemplestDB.storeAdvertisingEngineReportData(PromotionID, adEngine, getReportData);
				}
				catch (Exception e)
				{
					logger.error("Unable to download Report for account " + promoObj.getAdvertisingEngineAccountPK().toString());
				}
			}
			else if (adEngine.equalsIgnoreCase(ProtocolEnum.AdEngine.MSN.name()))
			{
				logger.info("REPORT FOR MSN NOT YET IMPLEMENTED");
			}
			else
			{
				logger.error("NO SUPPORT FOR ADENGINE " + adEngine);
			}
		}
		// CALL A SP TO UPDATE THE REMAINING CYCLE BUDGET
		UpdateRemainingBudgetInCycleSP updateBudgetSP = new UpdateRemainingBudgetInCycleSP();
		Integer res = updateBudgetSP.execute(PromotionID,  promoObj.getPromotionStartDate(), new Date());
		// Call bidding service to split the budget
		SemplestBiddingServiceClient bidClient = new SemplestBiddingServiceClient((String) SemplestConfiguration.configData.get("ESBWebServerURL"),getTimeoutMS());
		// setup the budget for each ad engine
		HashMap<String, HashMap<String, Object>> remainingBudgetDaysMap = setupAdEngineBudget(PromotionID, adEngineList, bidClient);
		//call setBidsUpdate
		for (String adEngine : adEngineList)
		{
			Double budget = (Double) remainingBudgetDaysMap.get(adEngine).get("RemainingBudgetInCycle");
			Integer daysLeft = (Integer) remainingBudgetDaysMap.get(adEngine).get("RemainingDays");
			BudgetObject budgetData = new BudgetObject();
			budgetData.setRemainingBudgetInCycle(budget);
			budgetData.setRemainingDays(daysLeft);
			bidClient.setBidsUpdate(PromotionID, adEngine, budgetData);
		}
	}

	public String UpdateGeoTargeting(String json) throws Exception
	{
		logger.debug("call UpdateGeoTargeting(String json): [" + json + "]");
		final HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		final Integer PromotionID = Integer.parseInt(data.get("PromotionID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		UpdateGeoTargeting(PromotionID, adEngines);
		return gson.toJson(true);
	}
	
	public String scheduleUpdateGeoTargeting(String json) throws Exception
	{
		logger.debug("call scheduleUpdateGeoTargeting(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngines = gson.fromJson(adEnginesString, List.class);		
		final Boolean res = scheduleUpdateGeoTargeting(customerID, promotionID, adEngines);
		return gson.toJson(res);
	}
	
	@Override
	public Boolean scheduleUpdateGeoTargeting(Integer customerID, Integer promotionID, List<String> adEngines) 
	{
		try 
		{
			logger.info("Will try to schedule task to Update Geo Targeting for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "UpdateGeoTargeting";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createUpdateGeoTargetingTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Update Geo Targetting for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}	
	}
	
	@Override
	public void UpdateGeoTargeting(Integer promotionID, List<String> adEngines) throws Exception
	{
		logger.info("call UpdateGeoTargeting(" + promotionID + ", " + adEngines + ")");
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		getPromoDataSP.execute(promotionID);
		final PromotionObj promotion = getPromoDataSP.getPromotionData();
		final String accountId = "" + promotion.getAdvertisingEngineAccountPK();
		final Long campaignId = promotion.getAdvertisingEngineCampaignPK();
		final List<GeoTargetObject> geoTargets = getPromoDataSP.getGeoTargets();
		final Map<String, String> errorMap = new HashMap<String, String>();
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{
				logger.info("Will try to update within Google Adwords the Account[" + accountId + "]/CampaignId[" + campaignId+ "]/Promotion[" + promotionID + "] with the following GeoTargets: [" + geoTargets + "]");
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				googleAdwordsService.updateGeoTargets(accountId, campaignId, geoTargets);				
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
	}
	
	public String UnpausePromotion(String json) throws Exception
	{
		logger.debug("call UnpausePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, HashMap.class);
		final Integer PromotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		UnpausePromotion(PromotionID, adEngines);
		return gson.toJson(true);
	}
	
	@Override
	public void UnpausePromotion(Integer promotionID, List<String> adEngines) throws Exception
	{
		final List<Integer> promotionIds = new ArrayList<Integer>();
		promotionIds.add(promotionID);
		ChangePromotionsStatus(promotionIds, adEngines, SemplestCampaignStatus.ACTIVE);
	}
	
	public String schedulePausePromotion(String json) throws Exception
	{
		logger.debug("call schedulePausePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		final Boolean result = schedulePausePromotion(customerID, promotionID, adEngines);
		return gson.toJson(result);
	}
	
	@Override
	public Boolean schedulePausePromotion(Integer customerID, Integer promotionID, List<String> adEngines)
	{
		try 
		{
			logger.info("Will try to schedule task to Pause Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "PausePromotion";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createPausePromotionTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Pause Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}
	}
	
	public String PausePromotion(String json) throws Exception
	{
		logger.debug("call PausePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, HashMap.class);
		final Integer PromotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		PausePromotion(PromotionID, adEngines);
		return gson.toJson(true);
	}
	
	@Override
	public void PausePromotion(Integer promotionID, List<String> adEngines) throws Exception
	{
		final List<Integer> promotionIds = new ArrayList<Integer>();
		promotionIds.add(promotionID);
		ChangePromotionsStatus(promotionIds, adEngines, SemplestCampaignStatus.PAUSED);
	}
	
	public String PauseProductGroup(String json) throws Exception
	{
		logger.debug("call PauseProductGroup(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, HashMap.class);
		final Integer productGroupID = Integer.parseInt(data.get("productGroupID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		PauseProductGroup(productGroupID, adEngines);
		return gson.toJson(true);
	}
	
	@Override
	public void PauseProductGroup(Integer productGroupID, List<String> adEngines) throws Exception
	{
		logger.info("Will try to Pause ProductGroup [" + productGroupID + "] for AdEngines [" + adEngines+ "])");
		final List<Integer> promotionIds = SemplestDB.getPromotionIdsForProductGroup(productGroupID);
		final String promotionIdsEasyReadableString = SemplestUtils.getEasilyReadableString(promotionIds);
		logger.info("Found the following Promotion IDs for which the Campaigns we'll need to Pause:\n" + promotionIdsEasyReadableString);	
		ChangePromotionsStatus(promotionIds, adEngines, SemplestCampaignStatus.PAUSED);
	}
		
	public void ChangePromotionsStatus(List<Integer> promotionIds, List<String> adEngines, SemplestCampaignStatus newStatus) throws Exception
	{
		logger.info("Will try to Change Status to [" + newStatus + "] for PromotionIds [" + promotionIds + "] and AdEngines [" + adEngines+ "])");
		final List<Long> campaignIds = new ArrayList<Long>();
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		String accountId = null;
		for (final Integer promotionId : promotionIds)
		{
			getPromoDataSP.execute(promotionId);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			if (accountId == null)
			{
				accountId = "" + promotion.getAdvertisingEngineAccountPK();
			}
			final Long campaignId = promotion.getAdvertisingEngineCampaignPK();
			if (campaignId != null)
			{
				campaignIds.add(campaignId);
			}
		}	
		if (campaignIds.isEmpty())
		{
			throw new Exception("No CampaignIDs found for PromotionIDs [" + promotionIds + "]");
		}
		final Map<String, String> errorMap = new HashMap<String, String>();
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{
				logger.info("Will try to Change Status of Google Campaigns to [" + newStatus + "] using AccountID [" + accountId + "] and CampaignIds [" + campaignIds + "])");
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final Boolean result = googleAdwordsService.changeCampaignsStatus(accountId, campaignIds, newStatus.getGoogleCampaignStatus());
				if (!result)
				{
					final String errMsg = "Request to Change Status of Google Campaigns for AccountID [" + accountId + "] and CampaignIds [" + campaignIds + "] failed";
					logger.info(errMsg);
					errorMap.put(adEngine, errMsg);
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
			final String errMsg = "Summary of errors when trying to Change Status to [" + newStatus + "] for PromotionIds [" + promotionIds + "] and AdEngines [" + adEngines+ "]:\n" + errorMapEasilyReadableString;
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
	
	public List<AdsObject> getAdsForPromotionAdID(final List<AdsObject> ads, final Integer promotionAdID)
	{
		final List<AdsObject> adsFound = new ArrayList<AdsObject>();
		for (final AdsObject ad : ads)
		{
			if (ad.getPromotionAdsPK().intValue() == promotionAdID.intValue())
			{
				adsFound.add(ad);
			}
		}
		return adsFound;
	}
	
	public String scheduleAddAd(String json) throws Exception
	{
		logger.debug("call scheduleAddAd(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Integer promotionAdID = Integer.parseInt(data.get("promotionAdID"));
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngines = gson.fromJson(adEnginesString, List.class);		
		final Boolean res = scheduleAddAd(customerID, promotionID, promotionAdID, adEngines);
		return gson.toJson(res);
	}
	
	@Override
	public Boolean scheduleAddAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines)
	{
		try 
		{
			logger.info("Will try to schedule task for Adding Ad for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "AddAd";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createAddAdTask(customerID, promotionID, promotionAdID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Add Ad for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}
	}
	
	public String AddAd(String json) throws Exception
	{
		logger.debug("call AddAd(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Integer promotionAdID = Integer.parseInt(data.get("promotionAdID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		AddAd(promotionID, promotionAdID, adEngines);
		return gson.toJson(true);
	}
	
	@Override
	public void AddAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		logger.info("Will try to Add Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]");
		final Map<String, String> errorMap = new HashMap<String, String>();
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
				getPromoDataSP.execute(promotionID);
				final List<AdsObject> ads = getPromoDataSP.getAds();				
				final PromotionObj promotion = getPromoDataSP.getPromotionData();
				final List<AdsObject> adsForPromotionID = getAdsForPromotionAdID(ads, promotionAdID);						
				if (!adsForPromotionID.isEmpty())
				{
					Collections.sort(adsForPromotionID, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
					final AdsObject ad = adsForPromotionID.get(0);
					final String accountID = "" + promotion.getAdvertisingEngineAccountPK();				
					final Long adGroupID = promotion.getAdvertisingEngineAdGroupID();
					final String headline = ad.getAdTitle();
					final String description1 = ad.getAdTextLine1();
					final String description2 = ad.getAdTextLine2();
					final String displayURL = promotion.getDisplayURL(); 
					final String url = promotion.getLandingPageURL();
					final Long googleAdID = googleAdwordsService.addTextAd(accountID, adGroupID, headline, description1, description2, displayURL, url);
					if (googleAdID == null || googleAdID == 0)
					{
						final String errMsg = "Got null Google Ad ID from Google AdWords after trying to create the Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], DisplayURL [" + displayURL + "], URL [" + url + "].  This means there was a problem creating the ad within Google AdWords.";
						logger.error(errMsg);
						errorMap.put(adEngine, errMsg);
					}
					else
					{
						logger.info("Google Ad ID returned after creating the ad in Google for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "] is neither null nor 0: [" + googleAdID + "].  This means the ad was created successfully within Google AdWords.");
						final int rowCount = SemplestDB.setAdIDForAdGroup(googleAdID, adEngine, promotionAdID);
						if (rowCount != 1)
						{
							logger.warn("Num or rows added when adding SemplestPromotionAdsPk<->GoogleAdID mapping for PromotionAdID [" + promotionAdID + "], GoogleAdID [" + googleAdID + "], AdEngine [" + adEngine + "] should be 1, but was [" + rowCount + "]");
						}
					}
				}
				else
				{
					final String errMsg = "Could not find Ad in database for PromotionID [" + promotionID + "] and PromotionAdID [" + promotionAdID + "]";
					logger.error(errMsg);
					errorMap.put(adEngine, errMsg);
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
			final String errMsg = "Summary of errors when trying to Add Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}				
	}
	
	public String scheduleDeleteAd(String json) throws Exception
	{
		logger.debug("call scheduleDeleteAd(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Integer promotionAdID = Integer.parseInt(data.get("promotionAdID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);		
		final Boolean res = scheduleDeleteAd(customerID, promotionID, promotionAdID, adEngines);
		return gson.toJson(res);
	}
	
	@Override
	public Boolean scheduleDeleteAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		try 
		{
			logger.info("Will try to schedule task for Deleting Ad for CUstomer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String deleteAdPostFix = "DeleteAd";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createDeleteAdEngineAdTask(customerID, promotionID, promotionAdID, adEngines, deleteAdPostFix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();			
			final String scheduleName = promotion.getPromotionName() + "_" + deleteAdPostFix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			if (!taskScheduleSuccessful)
			{
				return false;
			}
			final Integer rowCount = SemplestDB.markPromotionAdDeleted(promotionID, new Date());
			if (rowCount != 1)
			{
				logger.warn("Num of Promotions marked deleted for PromotionAdID [" + promotionAdID + "] should be 1 but was [" + rowCount + "]");
			}
			return true;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Delete Ad for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}	
	}
	
	public String DeleteAd(String json) throws Exception
	{
		logger.debug("call DeleteAd(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Integer promotionAdID = Integer.parseInt(data.get("promotionAdID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		DeleteAd(promotionID, promotionAdID, adEngines);
		return gson.toJson(true);
	}

	@Override
	public void DeleteAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		logger.info("Will try to Delete Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]");
		final Map<String, String> errorMap = new HashMap<String, String>();
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		getPromoDataSP.execute(promotionID);								
		final PromotionObj promotion = getPromoDataSP.getPromotionData();
		final List<AdsObject> ads = getPromoDataSP.getAds();
		final List<AdsObject> adsForPromotionAdID = getAdsForPromotionAdID(ads, promotionAdID);
		final List<AdsObject> nonDeletedAdsForPromotionAdID = getFilteredAds(adsForPromotionAdID, false);
		logger.info("Found " + nonDeletedAdsForPromotionAdID + " non-deleted Ads out of " + adsForPromotionAdID.size() + " total Ads in DB");
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();				
				if (!nonDeletedAdsForPromotionAdID.isEmpty())
				{
					//TODO: once AdvertisingEngineAds table has constraint such that PromotionFK is unique in the table, remove the sorting code and only deal with 1 item (not List) 
					Collections.sort(nonDeletedAdsForPromotionAdID, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
					final AdsObject ad = nonDeletedAdsForPromotionAdID.get(0);					
					final String accountID = "" + promotion.getAdvertisingEngineAccountPK();
					final Long adGroupID = promotion.getAdvertisingEngineAdGroupID();
					final Long semplestGoogleAdID = ad.getAdEngineAdID();
					final Long googleAdID = googleAdwordsService.deleteAD(accountID, adGroupID, semplestGoogleAdID);
					if (googleAdID == null || googleAdID == 0)
					{
						final String errMsg = "Got null Google Ad ID from Google AdWords after trying to delete the Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "], SemplestGoogleAdID [" + semplestGoogleAdID + "].  This means there was a problem creating the ad within Google AdWords.";
						logger.error(errMsg);
						errorMap.put(adEngine, errMsg);
					}
					else if (!googleAdID.equals(semplestGoogleAdID))
					{
						final String errMsg = "Google Ad ID returned from Google AdWords after trying to delete the Ad [" + googleAdID + "] does not equal the SemplestGoogleAdID [" + semplestGoogleAdID + "].  Maybe the wrong Google Ad was deleted?  Other params used in the delete call: PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "].";
						logger.error(errMsg);
						errorMap.put(adEngine, errMsg);
					}
					else
					{
						logger.info("Google Ad ID returned after deleting the ad in Google for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "] is neither null nor 0 and is the same as the SemplestGoogleAdID [" + semplestGoogleAdID + "] that we expected to delete: [" + googleAdID + "].  This means the ad was deleted successfully within Google AdWords.");
						final int rowCount = SemplestDB.markPromotionAdDeleted(promotionAdID, new Date());
						if (rowCount != 1)
						{
							logger.warn("Num of Promotions marked deleted for PromotionAdID [" + promotionAdID + "] should be 1 but was [" + rowCount + "]");
						}
					}
				}
				else
				{
					final String errMsg = "Could not find non-deleted Ad in database for PromotionID [" + promotionID + "] and PromotionAdID [" + promotionAdID + "]";
					logger.error(errMsg);
					errorMap.put(adEngine, errMsg);
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
			final String errMsg = "Summary of errors when trying to Add Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}		
	}
	
	public String RefreshSiteLinksForAd(String json) throws Exception
	{
		logger.debug("call RefreshSiteLinksForAd(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Integer promotionAdID = Integer.parseInt(data.get("promotionAdID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		RefreshSiteLinksForAd(promotionID, promotionAdID, adEngines);
		return gson.toJson(true);
	}

	@Override
	public void RefreshSiteLinksForAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		logger.info("Will try to Refresh SiteLinks associated with PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]");
		final Map<String, String> errorMap = new HashMap<String, String>();
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{							
				final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
				getPromoDataSP.execute(promotionID);
				final PromotionObj promotion = getPromoDataSP.getPromotionData();
				final String accountID = "" + promotion.getAdvertisingEngineAccountPK();
				final Long campaignId = promotion.getAdvertisingEngineCampaignPK();
				final GetSiteLinksForPromotionSP getSiteLinksForPromotionSP = new GetSiteLinksForPromotionSP();
				getSiteLinksForPromotionSP.execute(promotionAdID);
				final List<SiteLink> siteLinks = getSiteLinksForPromotionSP.getSiteLinks();
				final String siteLinksEasilyReadableString = SemplestUtils.getEasilyReadableString(siteLinks);
				logger.info("Found the following SiteLinks in Semplest DB:\n" + siteLinksEasilyReadableString);
				final List<GoogleSiteLink> googleSiteLinks = getGoogleSiteLinks(siteLinks);
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final Boolean processedSuccessully = googleAdwordsService.refreshSiteLinkForCampaign(accountID, campaignId, googleSiteLinks);
				if (!processedSuccessully)
				{
					final String errMsg = "Problem refreshing SiteLinks within Campaign [" + campaignId + "] for AccountID [" + accountID + "]";
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
			final String errMsg = "Summary of errors when trying to Refresh SiteLinks associated with PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}	
	}
	
	public String scheduleUpdateAd(String json) throws Exception
	{
		logger.debug("call scheduleUpdateAd(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Integer promotionAdID = Integer.parseInt(data.get("promotionAdID"));
		final String adEnginesString = data.get("adEngines");
		final List<String> adEngines = gson.fromJson(adEnginesString, List.class);		
		final Boolean res = scheduleUpdateAd(customerID, promotionID, promotionAdID, adEngines);
		return gson.toJson(res);
	}
		
	@Override
	public Boolean scheduleUpdateAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) 
	{
		try 
		{
			logger.info("Will try to schedule task for Adding Ad for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "UpdateAd";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createAddAdTask(customerID, promotionID, promotionAdID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Update Ad for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}	
	}
	
	public String UpdateAd(String json) throws Exception
	{
		logger.debug("call UpdateAd(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Integer promotionAdID = Integer.parseInt(data.get("promotionAdID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		UpdateAd(promotionID, promotionAdID, adEngines);
		return gson.toJson(true);
	}

	@Override
	public void UpdateAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception
	{
		logger.info("Will try to Update Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEndinges [" + adEngines + "]");
		final Map<String, String> errorMap = new HashMap<String, String>();
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
				getPromoDataSP.execute(promotionID);
				final PromotionObj promotion = getPromoDataSP.getPromotionData();
				final List<AdsObject> ads = getPromoDataSP.getAds();
				final List<AdsObject> adsForPromotionAdID = getAdsForPromotionAdID(ads, promotionAdID);				
				final List<AdsObject> nonDeletedAdsForPromotionAdID = getFilteredAds(adsForPromotionAdID, false);
				logger.info("Found " + nonDeletedAdsForPromotionAdID + " non-deleted Ads out of " + adsForPromotionAdID.size() + " total Ads in DB");				
				if (!nonDeletedAdsForPromotionAdID.isEmpty())
				{
					Collections.sort(nonDeletedAdsForPromotionAdID, AdsObject.AD_ENGINE_AD_ID_COMPARATOR);
					final AdsObject ad = nonDeletedAdsForPromotionAdID.get(0);					
					final Long semplestGoogleAdID = ad.getAdEngineAdID();
					final String accountID = "" + promotion.getAdvertisingEngineAccountPK();				
					final Long adGroupID = promotion.getAdvertisingEngineAdGroupID();
					final String headline = ad.getAdTitle();
					final String description1 = ad.getAdTextLine1();
					final String description2 = ad.getAdTextLine2();
					final String displayURL = promotion.getDisplayURL(); 
					final String url = promotion.getLandingPageURL();
					final Long googleAdID = googleAdwordsService.updateAD(accountID, adGroupID, semplestGoogleAdID, headline, description1, description2, displayURL, url);
					if (googleAdID == null || googleAdID == 0)
					{
						final String errMsg = "Got null Google Ad ID from Google AdWords after trying to update the Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "], SemplestGoogleAdID [" + semplestGoogleAdID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], DisplayURL [" + displayURL + "], URL [" + url + "].  This means there was a problem updating the ad within Google AdWords.";
						logger.error(errMsg);
						errorMap.put(adEngine, errMsg);
					}
					else if (googleAdID.equals(semplestGoogleAdID))
					{
						final String errMsg = "Google Ad ID returned from Google AdWords after trying to update the Ad for GoogleAdID [" + googleAdID + "] equals the SemplestGoogleAdID [" + semplestGoogleAdID + "].  This is not expected.  Update consists of creatae new ad and deleting the old ad.  If the 2 are the same, then the NEW Ad ID is the same as the OLD, but it should be different.  Other params used in the update call: PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "], SemplestGoogleAdID [" + semplestGoogleAdID + "], Headline [" + headline + "], Description1 [" + description1 + "], Description2 [" + description2 + "], DisplayURL [" + displayURL + "], URL [" + url + "].";
						logger.error(errMsg);
						errorMap.put(adEngine, errMsg);
					}
					else
					{
						logger.info("Google Ad ID returned after updating the ad in Google for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], GoogleAccountID [" + accountID + "], AdGroupID [" + adGroupID + "] is neither null nor 0 and is different from the SemplestGoogleAdID [" + semplestGoogleAdID + "] as we expect since the update is a delete of old ad and create of new ad: [" + googleAdID + "].  This means the ad was 'updated' successfully within Google AdWords.");
						final int rowCount = SemplestDB.updateAdIDForAdGroup(googleAdID, semplestGoogleAdID, adEngine, promotionAdID);
						if (rowCount != 1)
						{
							logger.warn("Num or rows updated when updating SemplestPromotionAdsPk<->GoogleAdID mapping for NewGoogleAdID [" + googleAdID + "], OldGoogleAdID [" + semplestGoogleAdID + "], PromotionAdID [" + promotionAdID + "], AdEngine [" + adEngine + "] should be 1, but was [" + rowCount + "]");
						}
					}
				}
				else
				{
					final String errMsg = "Could not find Ad in database for PromotionID [" + promotionID + "] and PromotionAdID [" + promotionAdID + "]";
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
			final String errMsg = "Summary of errors when trying to Update Ad for PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}		
	}
	
	public String UpdateBudget(String json) throws Exception
	{
		logger.debug("call UpdateBudget(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Double changeInBudget = Double.parseDouble(data.get("changeInBudget"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		UpdateBudget(promotionID, changeInBudget, adEngines);
		return gson.toJson(true);
	}

	@Override
	public void UpdateBudget(Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception
	{
		logger.info("Will try to Change Budget for PromotionID [" + promotionID + "] by [" + changeInBudget + "] for AdEngines [" + adEngines + "]");
		final Map<String, String> errorMap = new HashMap<String, String>();
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
				getPromoDataSP.execute(promotionID);
				final PromotionObj promotion = getPromoDataSP.getPromotionData();
				final String accountID = "" + promotion.getAdvertisingEngineAccountPK();
				final Long campaignID = promotion.getAdvertisingEngineCampaignPK();
				final Double oldBudgetAmount = promotion.getPromotionBudgetAmount();
				final Double newBudgetDouble = oldBudgetAmount + changeInBudget;
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
			final String errMsg = "Summary of errors when trying to Change Budget for PromotionID [" + promotionID + "] by [" + changeInBudget + "] for AdEndinges [" + adEngines + "]:\n" + errorMapEasilyReadableString;
			logger.error(errMsg);
			throw new Exception(errMsg);
		}
	}
	
	public String scheduleChangePromotionStartDate(String json) throws Exception
	{
		logger.debug("call scheduleChangePromotionStartDate(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String newStartDateString = data.get("newStartDate");	
		final java.util.Date newStartDate = SemplestUtils.DATE_FORMAT_YYYYMMDD.parse(newStartDateString);
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		final Boolean result = scheduleChangePromotionStartDate(customerID, promotionID, newStartDate, adEngines);
		return gson.toJson(result);
	}
	
	@Override
	public Boolean scheduleChangePromotionStartDate(Integer customerID, Integer promotionID, Date newStartDate, List<String> adEngines) 
	{
		try 
		{
			logger.info("Will try to schedule task to Change Promotion StartDate for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "ChangePromotionStartDate";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createUpdateGeoTargetingTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Change Promotion StartDate for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}	
	}
	
	public String ChangePromotionStartDate(String json) throws Exception
	{
		logger.debug("call ChangePromotionStartDate(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String newStartDateString = data.get("newStartDate");	
		final java.util.Date newStartDate = SemplestUtils.DATE_FORMAT_YYYYMMDD.parse(newStartDateString);
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		ChangePromotionStartDate(promotionID, newStartDate, adEngines);
		return gson.toJson(true);
	}

	@Override
	public void ChangePromotionStartDate(Integer promotionID, Date newStartDate, List<String> adEngines) throws Exception
	{
		logger.info("Will try to change StartDate for PromotionID [" + promotionID + "] to  [" + newStartDate + "] for AdEngines [" + adEngines + "]");
		final Map<String, String> errorMap = new HashMap<String, String>();
		for (final String adEngine : adEngines)
		{
			if (AdEngine.Google.name().equals(adEngine))
			{
				final GoogleAdwordsServiceImpl googleAdwordsService = new GoogleAdwordsServiceImpl();
				final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
				getPromoDataSP.execute(promotionID);				
				final PromotionObj promotion = getPromoDataSP.getPromotionData();
				final String accountID = "" + promotion.getAdvertisingEngineAccountPK();
				final Long campaignID = promotion.getAdvertisingEngineCampaignPK();
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
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer productGroupID = Integer.parseInt(data.get("productGroupID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final ArrayList<String> adEngines = gson.fromJson(data.get("adEngines"), ArrayList.class);
		final Boolean result = scheduleAddPromotionToAdEngine(customerID, productGroupID, promotionID, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleAddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer promotionID, ArrayList<String> adEngines)
	{
		try 
		{
			logger.info("Will try to schedule task to Add Promotion To AdEngine for Customer [" + customerID + "], ProductGroupID [" + productGroupID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "AddPromotionToAdEngine";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createAddPromotionToAdEngineTask(customerID, productGroupID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, productGroupID, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Add Promotion To AdEngine for Customer [" + customerID + "], ProductGroupID [" + productGroupID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}
	}
	
	public String scheduleUpdateBudget(String json) throws Exception
	{
		logger.debug("call scheduleUpdateBudget(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final Double changeInBudget = Double.parseDouble(data.get("changeInBudget"));	
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		final Boolean result = scheduleUpdateBudget(customerID, promotionID, changeInBudget, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleUpdateBudget(Integer customerID, Integer promotionID, Double changeInBudget, List<String> adEngines)
	{
		try 
		{
			logger.info("Will try to schedule task to Update Budget for Customer [" + customerID + "], PromotionID [" + promotionID + "], ChangeInBudget [" + changeInBudget + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "UpdateBudget";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createUpdateBudgetTask(customerID, promotionID, changeInBudget, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Update Budget for Customer [" + customerID + "], PromotionID [" + promotionID + "], ChangeInBudget [" + changeInBudget + "], AdEngines [" + adEngines + "]", e);
			return false;
		}
	}
	
	public String scheduleUnpausePromotion(String json) throws Exception
	{
		logger.debug("call scheduleUnpausePromotion(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		final Boolean result = scheduleUnpausePromotion(customerID, promotionID, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleUnpausePromotion(Integer customerID, Integer promotionID, List<String> adEngines)
	{
		try 
		{
			logger.info("Will try to schedule task to Unpause Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "UnpausePromotion";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createUnpausePromotionTask(customerID, promotionID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Unpause Promotion for Customer [" + customerID + "], PromotionID [" + promotionID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}
	}
	
	public String scheduleDeleteKeyword(String json) throws Exception
	{
		logger.debug("call scheduleDeleteKeyword(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));
		final String keyword = data.get("keyword");
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		final Boolean result = scheduleDeleteKeyword(customerID, promotionID, keyword, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleDeleteKeyword(Integer customerID, Integer promotionID, String keyword, List<String> adEngines)
	{
		try 
		{
			logger.info("Will try to schedule task to Delete Keyword for Customer [" + customerID + "], PromotionID [" + promotionID + "], Keyword [" + keyword + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "DeleteKeyword";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createDeleteKeywordTask(customerID, promotionID, keyword, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Delete Keyword for Customer [" + customerID + "], PromotionID [" + promotionID + "], Keyword [" + keyword + "], AdEngines [" + adEngines + "]", e);
			return false;
		}
	}
	
	public String scheduleRefreshSiteLinksForAd(String json) throws Exception
	{
		logger.debug("call scheduleRefreshSiteLinksForAd(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer promotionID = Integer.parseInt(data.get("promotionID"));		
		final Integer promotionAdID = Integer.parseInt(data.get("promotionAdID"));
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		final Boolean result = scheduleRefreshSiteLinksForAd(customerID, promotionID, promotionAdID, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean scheduleRefreshSiteLinksForAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines)
	{
		try 
		{
			logger.info("Will try to schedule task to Refresh SiteLinks for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "RefreshSiteLinksForAd";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createRefreshSiteLinksForAdTask(customerID, promotionID, promotionAdID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
			getPromoDataSP.execute(promotionID);
			final PromotionObj promotion = getPromoDataSP.getPromotionData();
			final String scheduleName = promotion.getPromotionName() + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, promotionID, customerID, null, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Refresh SiteLinks for Customer [" + customerID + "], PromotionID [" + promotionID + "], PromotionAdID [" + promotionAdID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}
	}
	
	public String schedulePauseProductGroup(String json) throws Exception
	{
		logger.debug("call schedulePauseProductGroup(String json): [" + json + "]");
		final Map<String, String> data = gson.fromJson(json, Map.class);
		final Integer customerID = Integer.parseInt(data.get("customerID"));
		final Integer productGroupID = Integer.parseInt(data.get("productGroupID"));		
		final List<String> adEngines = gson.fromJson(data.get("adEngines"), List.class);
		final Boolean result = schedulePauseProductGroup(customerID, productGroupID, adEngines);
		return gson.toJson(result);
	}

	@Override
	public Boolean schedulePauseProductGroup(Integer customerID, Integer productGroupID, List<String> adEngines)
	{
		try 
		{
			logger.info("Will try to schedule task to Pause ProductGroup for Customer [" + customerID + "], ProductGroupID [" + productGroupID + "], AdEngines [" + adEngines + "]");
			final List<SemplestSchedulerTaskObject> listOfTasks = new ArrayList<SemplestSchedulerTaskObject>();
			final String scheduleNamePostfix = "PauseProductGroup";
			final SemplestSchedulerTaskObject task = CreateSchedulerAndTask.createPauseProductGroupTask(customerID, productGroupID, adEngines, scheduleNamePostfix);
			listOfTasks.add(task);
			// TODO: is this the right way to name the schedule for pausing productGroup?  Can't use a single promotionID since there would be multiple
			final String scheduleName = "ProductGroup" + productGroupID + "_" + scheduleNamePostfix;
			final Boolean taskScheduleSuccessful = CreateSchedulerAndTask.createScheduleAndRun(listOfTasks, scheduleName, new Date(), null, ProtocolEnum.ScheduleFrequency.Now.name(), true, false, null, customerID, productGroupID, null);
			return taskScheduleSuccessful;
		}
		catch (Exception e)
		{
			logger.error("Problem scheduling task to Pause ProductGroup for Customer [" + customerID + "], ProductGroupID [" + productGroupID + "], AdEngines [" + adEngines + "]", e);
			return false;
		}
	}

}
