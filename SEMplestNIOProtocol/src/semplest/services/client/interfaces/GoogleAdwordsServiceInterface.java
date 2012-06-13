package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import semplest.other.DateTimeCeiling;
import semplest.other.DateTimeFloored;
import semplest.server.protocol.adengine.BidSimulatorObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleAddAdRequest;
import semplest.server.protocol.google.GoogleAddAdsRequest;
import semplest.server.protocol.google.GoogleRefreshSiteLinksRequest;
import semplest.server.protocol.google.GoogleRelatedKeywordObject;
import semplest.server.protocol.google.GoogleUpdateAdRequest;
import semplest.server.protocol.google.GoogleUpdateAdsRequest;

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
	Account CreateOneAccountService(String currencyCode, String dateTimeZone,String companyName, String descriptiveName) throws Exception;
	//Campaign Data Management (cm)
	Campaign CreateOneCampaignForAccount(String accountID, String campaignName, CampaignStatus campaignStatus, BudgetBudgetPeriod period, Long microBudgetAmount) throws Exception;
	Boolean deleteCampaign(String accountID, Long campaignID) throws Exception;
	Boolean changeCampaignsStatus(String accountID, List<Long> campaignIds, CampaignStatus status) throws Exception;
	Boolean changeCampaignBudget(String accountID, Long campaignID, Long microBudgetAmount) throws Exception;
	ArrayList<HashMap<String, String>> getCampaignsByAccountId(String accountID, Boolean includeDeleted) throws Exception;
	Boolean UpdateCampaignName(String accountID, Long campaignID, String newName) throws Exception;
	Long getSpentAPIUnitsPerAccountID(Long accountID, java.util.Date startDate, java.util.Date endDate) throws Exception;
	Boolean ChangeCampaignStartDate(String accountID, Long campaignID, java.util.Date newStartDate) throws Exception;
	
	Long AddAdGroup(String accountID, Long campaignID, String AdGroupName, AdGroupStatus status, Long defaultMicroBid) throws Exception;
	Map<GoogleAddAdRequest, Long> addTextAds(GoogleAddAdsRequest request) throws Exception;
	GoogleAdGroupObject[] getAdGroupsByCampaignId(String accountID, Long campaignID, Boolean includeDeleted) throws Exception;
	List<Long> deleteAds(String accountID, Long adGroupID, List<Long> adIds) throws Exception;
	Map<GoogleUpdateAdRequest, Long> updateAds(GoogleUpdateAdsRequest request) throws Exception;
	Boolean deleteAdGroup(String accountID, Long adGroupID) throws Exception;
	
	Boolean refreshSiteLinks(GoogleRefreshSiteLinksRequest request) throws Exception;	
	
	GoogleRelatedKeywordObject GetRelatedKeywords(String keyword, KeywordMatchType matchType, int numberResults) throws Exception;
	GoogleRelatedKeywordObject GetRelatedKeywordsForURL(String url,String keyword, KeywordMatchType matchType, int numberResults) throws Exception;
	String[] getAllAdGroupKeywords(String accountID, Long adGroupID, Boolean ActiveOnly) throws Exception;
		
	Boolean addUpdateKeywords(String accountID, Long campaignID, Long adGroupID, Map<KeywordProbabilityObject, Boolean> keywordProbabilityToRemoveOppositeMap, KeywordMatchType matchType, Long microBidAmount) throws Exception;
	Boolean deleteNegativeKeywords(String accountID, Long campaignID, List<String> keywords, KeywordMatchType matchType) throws Exception;
	KeywordDataObject[] getAllBiddableAdGroupCriteria(String accountID, Long adGroupID, Boolean ActiveOnly) throws Exception;
	KeywordDataObject addKeyWordToAdGroup(String accountID, Long adGroupID, String keyword, KeywordMatchType matchType, Long microBidAmount) throws Exception;
	Boolean deleteKeyWords(String accountID, Long adGroupID, List<String> keywords) throws Exception;
	KeywordDataObject addNegativeKeyWordToAdGroup(String accountID, Long campaignID, String keyword, KeywordMatchType matchType) throws Exception;
	KeywordDataObject setBidForKeyWord(String accountID, Long keywordID, Long adGroupID, Long microBidAmount) throws Exception;
	TrafficEstimatorObject getTrafficEstimationForKeywords(String accountID,Long campaignID, KeywordMatchType matchType, HashMap<String, Long> KeywordWithBid) throws Exception;
	BidSimulatorObject[] getBidLandscapeForKeyword(String accountID, Long adGroupID, Long keywordID) throws Exception;
	BidSimulatorObject[] getBidLandscapeForAdgroup(String accountID, Long adGroupID) throws Exception;
	
	AdGroupCriterion[] getAllAdGroupCriteria(String customerId, Long adGroupId, Boolean ActiveOnly) throws Exception;
	
	void updateDefaultBid(String accountID, Long adGroupID, Long microBid) throws Exception; 

	
	//public GeoTargetList getCampaignGeoTargets(String customerId, long campaignId) throws Exception;
	//optimization (o)
	
	//Account Management API Usage
	void addAccountBudget(Long microBudgetAmount, String customerId, String orderId) throws Exception;
	String[] getClientAccounts() throws Exception;
	Budget[] getAccountBudgets(String customerId) throws Exception;
	void updateAccountBudget(Budget budgetForUpdate, Long microBudgetAmount, String customerId, String orderId) throws Exception;
	AdGroupAd[] getAdsByAdGroupId(String customerId, long adGroupId) throws Exception;

	
	
	//public AccountInfo getAccountInfo(String customerId) throws Exception;
	void addAccountBudget(DateTimeFloored start, DateTimeCeiling end, Long microBudgetAmount, String string) throws Exception;
	void updateAccountBudgetCannotChangeTheStartDateOfTheCurrentBudget(Budget budgetForUpdate, DateTimeCeiling end, Long microBudgetAmount, String string) throws Exception;
	//Utility
	
	//Report
	ReportObject[] getReportForAccount(String accountID, String startDate, String endDate) throws Exception;

	// GeoTargeting
	Boolean setGeoTarget(String accountId, Long campaignId, Double latitude, Double longitude, Double radius, String addr, String city, String state, String zip) throws Exception;
	Boolean updateGeoTargets(String accountId, Long campaignId, List<GeoTargetObject> geoTargets) throws Exception;	
	 
	/*
	 * LEFT OUT GoogleCloudReportService and GoogleCloudBulkMutateService
	 */
}
