package semplest.services.client.interfaces;

import java.util.List;
import java.util.Map;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType;
import org.joda.time.DateTime;

import semplest.other.MsnManagementIds;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.adengine.BidElement;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.GeoTargetType;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.protocol.adengine.TrafficEstimatorObject;
import semplest.server.protocol.msn.MsnCloudException;
import semplest.server.protocol.msn.MsnCreateKeywordsResponse;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.Ad;
import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.BudgetLimitType;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.ReportAggregation;
import com.microsoft.adcenter.v8.Target;

public interface MsnAdcenterServiceInterface extends ServiceInitialize 
{
	// ============================
	// Info 
	// ===============================
	
	boolean isProduction();
	
	// ============================
	// Procedural 
	// ===============================
	
	void setTimeout(int millis);
	
	// ==================================
	// Account Methods
	// ==================================
	/**
	 * Creates an account. Note account's must have distinct names. campaignName length limit is 20 characters - Account
	 * limit = 100, User limit = 20, Customer Limit = 63
	 * 
	 * @return Msn keeps three distinct account "manager" type objects: Account, User and Customer. Save the ids
	 *         returned here since obtaining them otherwise is difficult.
	 */
	MsnManagementIds createAccount(SemplestString name) throws Exception;  	
	Account getAccountById(Long accountId) throws Exception;	
	Map<String,Long> getAccountIDs() throws Exception;
	
	// ==================================
	// GeoTargeting Methods
	// ==================================
	
	Boolean updateGeoTargets(final Long accountId, final Long campaignId, final Long adGroupId, final Map<GeoTargetObject, GeoTargetType> geoTargetVsTypeMap) throws MsnCloudException;
	void deleteAllTargetsInCampaign(Long accountId, Long campaignId) throws Exception;
	
	// ==================================
	// Campaign Methods
	// ==================================
	Long createCampaign(Long accountId, String campaignName, BudgetLimitType budgetLimitType, double dailyBudget, double monthlyBudget, CampaignStatus CampaignStatus) throws Exception;	
	Campaign getCampaignById(Long accountId, Long campaignId) throws Exception;	
	Campaign[] getCampaignsByAccountId(Long accountId) throws Exception;	
	void pauseCampaignById(Long accountId, Long campaignId) throws Exception;
	void unpauseCampaignById(Long accountId, Long campaignId) throws MsnCloudException;
	void pauseCampaignsByAccountId(Long accountId) throws Exception;	
	void resumeCampaignById(Long accountId, Long campaignId) throws Exception;	
	void deleteCampaignById(Long accountId, Long campaignId) throws Exception;	
	void updateCampaignBudget(Long accountId, Long campaignId, BudgetLimitType budgetLimitType, double dailyBudget, double monthlyBudget) throws Exception;	
	void setCampaignStateTargets(Long accountId, long customerId, Long campaignId, List<String> states) throws Exception;	
	void deleteCampaignTargets(Long accountId, long customerId, Long campaignId) throws Exception;	
	Target getCampaignTargets(Long accountId, long customerId, Long campaignId) throws Exception;
	
	// ==================================
	// AdGroup Methods
	// ==================================
	long createAdGroup(Long accountId, Long campaignId) throws Exception;	
	AdGroup[] getAdGroupsByCampaignId(Long accountId, Long campaignId) throws Exception;	
	AdGroup getAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws Exception;	
	void deleteAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws Exception;	
	void setAdGroupStateTargets(Long accountId, long customerId, Long adGroupId, List<String> states) throws Exception;	
	void setAdGroupCityTargets(Long accountId, long customerId, Long adGroupId, List<String> cities) throws Exception;	
	void setAdGroupMetroAreaTargets(Long accountId, long customerId, long msnAdGroupId, List<String> metroTargets) throws Exception;
	void deleteAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws Exception;
	Target getAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws Exception;	
	Boolean updateAdGroupDefaultBids(Long accountId, Long campaignId, Long adGroupId, Double exactMatchBid, Double phraseMatchBid, Double broadMatchBid) throws Exception;
	
	// ==================================
	// Ad Methods
	// ==================================
	long createAd(Long accountId, Long adGroupId, String title, String text, String displayUrl, String destinationUrl) throws Exception;
	Ad getAdById(Long accountId, Long adGroupId, long adId) throws Exception;
	Ad[] getAdsByAdGroupId(Long accountId, Long adGroupId) throws Exception;
	void updateAdById(Long accountId, Long adGroupId, long adId, String title, String text, String displayUrl, String destinationUrl) throws Exception;
	void pauseAdById(Long accountId, Long adGroupId, long adId) throws Exception;
	void resumeAdById(Long accountId, Long adGroupId, long adId) throws Exception;
	void deleteAdById(Long accountId, Long adGroupId, long adId) throws Exception;
	
	// ==================================
	// Keyword Methods
	// ==================================
	
	long createKeyword(Long accountId, Long adGroupId, String text, MatchType matchType, Bid bid) throws Exception;
	MsnCreateKeywordsResponse createKeywords(Long accountId, Long adGroupId, Map<Keyword, Integer> keywordToPkMap) throws Exception;	
	Keyword getKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception;	
	Keyword[] getKeywordByAdGroupId(Long accountId, Long adGroupId) throws Exception;	
	void updateKeywordBidById(Long accountId, Long adGroupId, long keywordId, MatchType matchType, Bid bid) throws Exception;	
	void updateKeywordBidsByIds(Long accountId, Long adGroupId, List<BidElement> bids) throws Exception;	
	void pauseKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception;	
	void deleteKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception;	
	void deleteKeywordsById(Long accountId, Long adGroupId, long[] keywordIds) throws Exception;
	Map<Integer, String> setNegativeKeywords(final Long accountId, final Long campaignId, final Map<String, Integer> negativeKeywordToPkMap) throws MsnCloudException;
	
	// ==================================
	// Keyword Estimates
	// ==================================
	// Maximum 1000 words per call!!
	TrafficEstimatorObject getKeywordEstimateByBids(Long accountId, String[] keywords, Long[] microBidAmount, MatchType matchType) throws Exception;
	
	Map<String, String[]> getReportData(String reportId, Long accountId) throws Exception;
	String requestCampaignReport(Long accountId, Long campaignId, int days, ReportAggregation aggregation) throws Exception;	
	String requestKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation) throws Exception;
	ReportObject[] getKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay) throws Exception;
	
}