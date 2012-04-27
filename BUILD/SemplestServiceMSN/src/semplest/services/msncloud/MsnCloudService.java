package semplest.services.msncloud;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition;
import org.joda.time.DateTime;

import semplest.other.Maybe;
import semplest.other.Money;

import com.microsoft.adapi.AdApiFaultDetail;
import com.microsoft.adcenter.api.customermanagement.Entities.Account;
import com.microsoft.adcenter.v8.Ad;
import com.microsoft.adcenter.v8.AdGroup;
import com.microsoft.adcenter.v8.ApiFaultDetail;
import com.microsoft.adcenter.v8.Bid;
import com.microsoft.adcenter.v8.Campaign;
import com.microsoft.adcenter.v8.CampaignStatus;
import com.microsoft.adcenter.v8.EditorialApiFaultDetail;
import com.microsoft.adcenter.v8.Keyword;
import com.microsoft.adcenter.v8.ReportAggregation;
import com.microsoft.adcenter.v8.Target;

public interface MsnCloudService {
	
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
	public abstract MsnManagementIds createAccount(String name) throws MsnCloudException;
	
	public abstract Account getAccountById(Long accountId) throws MsnCloudException;
	
	// ==================================
	// Campaign Methods
	// ==================================
	public abstract Long createCampaign(Long accountId, String campaignName, double dailyBudget, double monthlyBudget, CampaignStatus CampaignStatus) throws MsnCloudException;
	
	public abstract Campaign getCampaignById(Long accountId, Long campaignId) throws RemoteException;
	
	public abstract Campaign[] getCampaignsByAccountId(Long accountId) throws RemoteException;
	
	public abstract void pauseCampaignById(Long accountId, Long campaignId) throws RemoteException;
	
	public abstract void pauseCampaignsByAccountId(Long accountId) throws RemoteException;
	
	public abstract void resumeCampaignById(Long accountId, Long campaignId) throws RemoteException;
	
	public abstract void deleteCampaignById(Long accountId, Long campaignId) throws RemoteException;
	
	public abstract void updateCampaignBudget(Long accountId, Long campaignId, double dailyBudget, double monthlyBudget) throws RemoteException;
	
	public abstract void setCampaignStateTargets(Long accountId, long customerId, Long campaignId, List<String> states) throws RemoteException;
	
	public abstract void deleteCampaignTargets(Long accountId, long customerId, Long campaignId) throws RemoteException;
	
	public abstract Target getCampaignTargets(Long accountId, long customerId, Long campaignId) throws RemoteException;
	
	// ==================================
	// AdGroup Methods
	// ==================================
	public abstract long createAdGroup(Long accountId, Long campaignId) throws RemoteException, ApiFaultDetail, AdApiFaultDetail;
	
	public abstract AdGroup[] getAdGroupsByCampaignId(Long accountId, Long campaignId) throws RemoteException;
	
	public abstract AdGroup getAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws RemoteException;
	
	public abstract void deleteAdGroupById(Long accountId, Long campaignId, Long adGroupId) throws RemoteException;
	
	public abstract void setAdGroupStateTargets(Long accountId, long customerId, Long adGroupId, List<String> states) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract void setAdGroupCityTargets(Long accountId, long customerId, Long adGroupId, List<String> cities) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract void setAdGroupMetroAreaTargets(Long accountId, long customerId, long msnAdGroupId, List<String> metroTargets) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract void deleteAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws RemoteException;
	
	public abstract Target getAdGroupTargets(Long accountId, long customerId, Long adGroupId) throws RemoteException;
	
	// ==================================
	// Ad Methods
	// ==================================
	public abstract long createAd(Long accountId, Long adGroupId, String title, String text, String displayUrl, String destinationUrl) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract Ad getAdById(Long accountId, Long adGroupId, long adId) throws RemoteException;
	
	public abstract Ad[] getAdsByAdGroupId(Long accountId, Long adGroupId) throws RemoteException;
	
	public abstract void updateAdById(Long accountId, Long adGroupId, long adId, String title, String text, String displayUrl, String destinationUrl) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract void pauseAdById(Long accountId, Long adGroupId, long adId) throws RemoteException;
	
	public abstract void resumeAdById(Long accountId, Long adGroupId, long adId) throws RemoteException;
	
	public abstract void deleteAdById(Long accountId, Long adGroupId, long adId) throws RemoteException;
	
	// ==================================
	// Keyword Methods
	// ==================================
	public abstract long createKeyword(Long accountId, Long adGroupId, String text, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid, Bid phraseMatchBid) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract long[] createKeywords(Long accountId, Long adGroupId, MsnCloudKeywordProxy... keywords) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract Maybe<Keyword> getKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException;
	
	public abstract Keyword[] getKeywordByAdGroupId(Long accountId, Long adGroupId) throws RemoteException;
	
	public abstract void updateKeywordBidById(Long accountId, Long adGroupId, long keywordId, Bid broadMatchBid, Bid contentMatchBid, Bid exactMatchBid, Bid phraseMatchBid) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract void updateKeywordBidsByIds(Long accountId, Long adGroupId, long[] keywordId, Bid[] broadMatchBid, Bid[] contentMatchBid, Bid[] exactMatchBid, Bid[] phraseMatchBid) throws RemoteException, ApiFaultDetail, AdApiFaultDetail, EditorialApiFaultDetail;
	
	public abstract void pauseKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException;
	
	public abstract void deleteKeywordById(Long accountId, Long adGroupId, long keywordId) throws RemoteException;
	
	public abstract void deleteKeywordsById(Long accountId, Long adGroupId, long[] keywordIds) throws RemoteException;
	
	// ==================================
	// Keyword Estimates
	// ==================================
	public KeywordEstimatedPosition[] getKeywordEstimateByBids(String[] keywords, Money bid) throws MsnCloudException;
	
	//	public abstract KeywordEstimate getKeywordEstimateByBid(Long accountId, String keyword, double broadMatchBid, double exactMatchBid, double phraseMatchBid) throws RemoteException, ApiFaultDetail, MsnServiceException;
	//	
	//	public abstract KeywordEstimate[] getKeywordEstimateByBids(Long accountId, String[] keywords, double[] broadMatchBids, double[] exactMatchBids, double[] phraseMatchBids) throws RemoteException, ApiFaultDetail, MsnServiceException;
	
	Map<String, String[]> getReportData(String reportId, Long accountId) throws RemoteException, MsnCloudException;
	
	// ==================================
	// Reports
	// ==================================
	String requestCampaignReport(Long accountId, int campaignId, int days, ReportAggregation aggregation);
	
	String requestKeywordReport(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation);
}