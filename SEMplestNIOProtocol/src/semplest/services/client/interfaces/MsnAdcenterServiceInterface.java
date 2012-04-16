package semplest.services.client.interfaces;

import java.util.List;
import java.util.Map;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition;
import org.joda.time.DateTime;

import semplest.other.KeywordEstimate;
import semplest.other.Maybe;
import semplest.other.Money;
import semplest.other.MsnCloudKeywordProxy;
import semplest.other.MsnManagementIds;
import semplest.server.protocol.SemplestString;

import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.Ad;
import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.ReportAggregation;
import com.microsoft.adcenter.v8.Target;

public interface MsnAdcenterServiceInterface extends ServiceInitialize {
	
	// ============================
	// Info 
	// ===============================
	
	public boolean isProduction();
	
	// ============================
	// Procedural 
	// ===============================
	
	public void setTimeout(int millis);
	
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
	public abstract MsnManagementIds createAccount(SemplestString name) throws Exception;  
	
	public abstract Account getAccountById(Long accountId) throws Exception;
	
	// ==================================
	// Campaign Methods
	// ==================================
	public abstract Long createCampaign(Long accountId, String campaignName, double dailyBudget, double monthlyBudget, CampaignStatus CampaignStatus) throws Exception;
	
	public abstract Campaign getCampaignById(Long accountId, Long campaignId) throws Exception;
	
	public abstract Campaign[] getCampaignsByAccountId(Long accountId) throws Exception;
	
	public abstract void pauseCampaignById(Long accountId, Long campaignId) throws Exception;
	
	public abstract void pauseCampaignsByAccountId(Long accountId) throws Exception;
	
	public abstract void resumeCampaignById(Long accountId, Long campaignId) throws Exception;
	
	public abstract void deleteCampaignById(Long accountId, Long campaignId) throws Exception;
	
	public abstract void updateCampaignBudget(Long accountId, Long campaignId, double dailyBudget, double monthlyBudget) throws Exception;
	
	public abstract void setCampaignStateTargets(Long accountId, long customerId, Long campaignId, List<String> states) throws Exception;
	
	public abstract void deleteCampaignTargets(Long accountId, long customerId, Long campaignId) throws Exception;
	
	public abstract Target getCampaignTargets(Long accountId, long customerId, Long campaignId) throws Exception;
	
	// ==================================
	// AdGroup Methods
	// ==================================
	public abstract long createAdGroup(Long accountId, Long campaignId) throws Exception;
	
	public abstract AdGroup[] getAdGroupsByCampaignId(Long accountId, Long campaignId) throws Exception;
	
	public abstract AdGroup getAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws Exception;
	
	public abstract void deleteAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws Exception;
	
	public abstract void setAdGroupStateTargets(Long accountId, long customerId, Long adGroupId, List<String> states) throws Exception;
	
	public abstract void setAdGroupCityTargets(Long accountId, long customerId, Long adGroupId, List<String> cities) throws Exception;
	
	public abstract void setAdGroupMetroAreaTargets(Long accountId, long customerId, long msnAdGroupId, List<String> metroTargets) throws Exception;
	
	public abstract void deleteAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws Exception;
	
	public abstract Target getAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws Exception;
	
	// ==================================
	// Ad Methods
	// ==================================
	public abstract long createAd(Long accountId, Long adGroupId, String title, String text, String displayUrl, String destinationUrl) throws Exception;
	
	public abstract Ad getAdById(Long accountId, Long adGroupId, long adId) throws Exception;
	
	public abstract Ad[] getAdsByAdGroupId(Long accountId, Long adGroupId) throws Exception;
	
	public abstract void updateAdById(Long accountId, Long adGroupId, long adId, String title, String text, String displayUrl, String destinationUrl) throws Exception;
	
	public abstract void pauseAdById(Long accountId, Long adGroupId, long adId) throws Exception;
	
	public abstract void resumeAdById(Long accountId, Long adGroupId, long adId) throws Exception;
	
	public abstract void deleteAdById(Long accountId, Long adGroupId, long adId) throws Exception;
	
	// ==================================
	// Keyword Methods
	// ==================================
	public abstract long createKeyword(Long accountId, Long adGroupId, String text, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid, Bid phraseMatchBid) throws Exception;
	
	public abstract long[] createKeywords(Long accountId, Long adGroupId, Keyword... keywords) throws Exception;
	
	public abstract Keyword getKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception;
	
	public abstract Keyword[] getKeywordByAdGroupId(Long accountId, Long adGroupId) throws Exception;
	
	public abstract void updateKeywordBidById(Long accountId, Long adGroupId, long keywordId, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid, Bid phraseMatchBid) throws Exception;
	
	public abstract void updateKeywordBidsByIds(Long accountId, Long adGroupId, long[] keywordId, Bid[] broadMatchBid, Bid[] contentMatchBid, Bid[] exactMatchBid, Bid[] phraseMatchBid) throws Exception;
	
	public abstract void pauseKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception;
	
	public abstract void deleteKeywordById(Long accountId, Long adGroupId, long keywordId) throws Exception;
	
	public abstract void deleteKeywordsById(Long accountId, Long adGroupId, long[] keywordIds) throws Exception;
	
	// ==================================
	// Keyword Estimates
	// ==================================
	public KeywordEstimatedPosition[] getKeywordEstimateByBids(String[] keywords, Money bid) throws Exception;
	
	public abstract KeywordEstimate getKeywordEstimateByBid(Long accountId, String keyword, double broadMatchBid, double exactMatchBid, double phraseMatchBid) throws Exception;
	//	
	public abstract KeywordEstimate[] getKeywordEstimateByBids(Long accountId, String[] keywords, double[] broadMatchBids, double[] exactMatchBids, double[] phraseMatchBids) throws Exception;
	
	Map<String, String[]> getReportData(String reportId, Long accountId) throws Exception;
	
	// ==================================
	// Reports
	// ==================================
	String requestCampaignReport(Long accountId, int campaignId, int days, ReportAggregation aggregation);
	
	String requestKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation);
}