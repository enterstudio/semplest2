package semplest.services.client.interfaces;

import java.util.List;

import semplest.server.protocol.KeywordIdRemoveOppositePair;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.google.GoogleViolation;
import semplest.server.protocol.google.GoogleAddAdRequest;
import semplest.server.protocol.google.KeywordToolStats;

public interface SemplestAdengineServiceInterface extends ServiceInitialize
{		
	Boolean scheduleAddAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception;
	Boolean AddAds(Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleDeleteAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception;
	Boolean DeleteAds(Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleUpdateAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception;
	Boolean UpdateAds(Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleUpdateGeoTargeting(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception;
	Boolean UpdateGeoTargeting(Integer promotionID, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleChangePromotionStartDate(Integer customerID, Integer promotionID, java.util.Date newStartDate, List<AdEngine> adEngines) throws Exception;
	Boolean ChangePromotionStartDate(Integer promotionID, java.util.Date newStartDate, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleUpdateBudget(Integer customerID, Integer promotionID, Double changeInBudget, List<AdEngine> adEngines) throws Exception;
	Boolean UpdateBudget(Integer promotionID, Double changeInBudget, List<AdEngine> adEngines) throws Exception;
		
	Boolean scheduleUnpausePromotion(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception;
	Boolean UnpausePromotion(Integer promotionID, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleDeletePromotion(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception; 
	Boolean DeletePromotion(Integer promotionID, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleEndPromotion(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception; 
	Boolean EndPromotion(Integer promotionID, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleRefreshSiteLinks(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception;
	Boolean RefreshSiteLinks(Integer promotionID, List<AdEngine> adEngines) throws Exception;
	
	Boolean schedulePauseProductGroups(Integer customerID, List<Integer> productGroupIds, List<AdEngine> adEngines) throws Exception;
	Boolean PauseProductGroups(List<Integer> productGroupIds, List<AdEngine> adEngines) throws Exception;
	
	// Validation
	
	List<GoogleViolation> validateGoogleAd(String landingPageURL,String displayURL, List<GoogleAddAdRequest> ads) throws Exception;
	List<GoogleViolation> validateGoogleRefreshSiteLinks(Integer promotionID) throws Exception;	 
	List<GoogleViolation> validateGoogleGeoTargets(Integer promotionID) throws Exception;
	List<GoogleViolation> validateGoogleNegativeKeywords(final List<String> negativeKeywords) throws Exception;
	
	// TODO: separate out schedule methods where possible into multiple schedules in order to avoid transactionality issues when 1 schedule would make multiple calls to Google/MSN
	
	Boolean scheduleAddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, List<AdEngine> adEngineList) throws Exception;	
	Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, List<AdEngine> adEngineList) throws Exception;
	
	Boolean scheduleAddKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception;
	Boolean AddKeywords(Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleDeleteKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception;
	Boolean DeleteKeywords(Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleAddNegativeKeywords(Integer customerID, Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<AdEngine> adEngines) throws Exception;
	Boolean AddNegativeKeywords(Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<AdEngine> adEngines) throws Exception;
	
	Boolean scheduleDeleteNegativeKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception;
	Boolean DeleteNegativeKeywords(Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines) throws Exception;
		
	Boolean ExecuteBidProcess(Integer PromotionID, List<AdEngine> adEngine) throws Exception;	
		
	Boolean schedulePausePromotion(Integer customerID, Integer promotionID, List<AdEngine> adEngines) throws Exception;
	Boolean PausePromotion(Integer promotionID, List<AdEngine> adEngines) throws Exception;
	
	KeywordToolStats[] getGoogleKeywordIdeas(List<String> keywords, int numberResults) throws Exception;
		
}
