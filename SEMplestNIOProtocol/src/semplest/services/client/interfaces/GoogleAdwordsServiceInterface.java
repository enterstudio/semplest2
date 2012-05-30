package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import semplest.other.DateTimeCeiling;
import semplest.other.DateTimeFloored;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.BidSimulatorObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleRelatedKeywordObject;

import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupCriterion;
import com.google.api.adwords.v201109.cm.AdGroupStatus;
import com.google.api.adwords.v201109.cm.Budget;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.mcm.Account;


/*
 * interface for Adwords API 8.5
 */
public interface GoogleAdwordsServiceInterface extends ServiceInitialize
{
	//management console (mcm)
	public abstract Account CreateOneAccountService(String currencyCode, String dateTimeZone,String companyName, String descriptiveName) throws Exception;
	//Campaign Data Management (cm)
	public abstract Campaign CreateOneCampaignForAccount(String accountID, String campaignName, CampaignStatus campaignStatus, BudgetBudgetPeriod period, Long microBudgetAmount) throws Exception;
	public abstract Boolean deleteCampaign(String accountID, Long campaignID) throws Exception;
	public abstract Boolean changeCampaignStatus(String accountID, Long campaignID, CampaignStatus status) throws Exception;
	public abstract Boolean changeCampaignBudget(String accountID, Long campaignID, Long microBudgetAmount) throws Exception;
	public abstract ArrayList<HashMap<String, String>> getCampaignsByAccountId(String accountID, Boolean includeDeleted) throws Exception;
	public abstract Boolean UpdateCampaignName(String accountID, Long campaignID, String newName) throws Exception;
	public abstract  Long getSpentAPIUnitsPerAccountID(Long accountID, java.util.Date startDate, java.util.Date endDate) throws Exception;
	
	public abstract Long AddAdGroup(String accountID, Long campaignID, String AdGroupName, AdGroupStatus status, Long defaultMicroBid) throws Exception;
	public abstract Long addTextAd(String accountID, Long adGroupID, String headline, String description1, String description2, String displayURL, String url) throws Exception;
	public abstract GoogleAdGroupObject[] getAdGroupsByCampaignId(String accountID, Long campaignID, Boolean includeDeleted) throws Exception;
	public abstract Boolean deleteAD(String accountID, Long adGroupID, Long AdID) throws Exception;
	public abstract Boolean updateAD(String accountID, Long adGroupID, Long AdID,String headline, String description1, String description2, String displayURL, String url) throws Exception;
	public abstract Boolean deleteAdGroup(String accountID, Long adGroupID) throws Exception;
	
	public abstract GoogleRelatedKeywordObject GetRelatedKeywords(String keyword, KeywordMatchType matchType, int numberResults) throws Exception;
	public abstract GoogleRelatedKeywordObject GetRelatedKeywordsForURL(String url,String keyword, KeywordMatchType matchType, int numberResults) throws Exception;
	public abstract String[] getAllAdGroupKeywords(String accountID, Long adGroupID, Boolean ActiveOnly) throws Exception;
	public abstract KeywordDataObject[] getAllBiddableAdGroupCriteria(String accountID, Long adGroupID, Boolean ActiveOnly) throws Exception;
	public abstract KeywordDataObject addKeyWordToAdGroup(String accountID, Long adGroupID, String keyword, KeywordMatchType matchType, Long microBidAmount) throws Exception;
	public abstract KeywordDataObject addNegativeKeyWordToAdGroup(String accountID, Long campaignID, String keyword, KeywordMatchType matchType) throws Exception;
	public abstract KeywordDataObject setBidForKeyWord(String accountID, Long keywordID, Long adGroupID, Long microBidAmount) throws Exception;
	public abstract TrafficEstimatorObject getTrafficEstimationForKeywords(String accountID,Long campaignID, KeywordMatchType matchType, HashMap<String, Long> KeywordWithBid) throws Exception;
	public abstract BidSimulatorObject[] getBidLandscapeForKeyword(String accountID, Long adGroupID, Long keywordID) throws Exception;
	public abstract BidSimulatorObject[] getBidLandscapeForAdgroup(String accountID, Long adGroupID) throws Exception;
	
	public abstract AdGroupCriterion[] getAllAdGroupCriteria(String customerId, Long adGroupId, Boolean ActiveOnly) throws Exception;
	
	void updateDefaultBid(String accountID, Long adGroupID, Long microBid) throws Exception; 

	
	//public GeoTargetList getCampaignGeoTargets(String customerId, long campaignId) throws Exception;
	//optimization (o)
	
	//Account Management API Usage
	public abstract void addAccountBudget(Long microBudgetAmount, String customerId, String orderId) throws Exception;
	public abstract String[] getClientAccounts() throws Exception;
	public abstract Budget[] getAccountBudgets(String customerId) throws Exception;
	public abstract void updateAccountBudget(Budget budgetForUpdate, Long microBudgetAmount, String customerId, String orderId) throws Exception;
	public abstract AdGroupAd[] getAdsByAdGroupId(String customerId, long adGroupId) throws Exception;

	
	
	//public AccountInfo getAccountInfo(String customerId) throws Exception;
	public abstract void addAccountBudget(DateTimeFloored start, DateTimeCeiling end, Long microBudgetAmount, String string) throws Exception;
	public abstract void updateAccountBudgetCannotChangeTheStartDateOfTheCurrentBudget(Budget budgetForUpdate, DateTimeCeiling end, Long microBudgetAmount, String string) throws Exception;
	//Utility
	
	//Report
	public abstract ReportObject[] getReportForAccount(String accountID, String startDate, String endDate) throws Exception;

	// GeoTargeting
	public abstract Boolean setGeoTarget(String accountId, Long campaignId, Double latitude, Double longitude, Double radius, String addr, String city, String state, String zip) throws Exception;
	public abstract Boolean updateGeoTargets(String accountId, Long campaignId, List<GeoTargetObject> geoTargets) throws Exception;
	 
	/*
	 * LEFT OUT GoogleCloudReportService and GoogleCloudBulkMutateService
	 */
}
