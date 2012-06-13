package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.List;

import semplest.server.protocol.KeywordIdRemoveOppositePair;

public interface SemplestAdengineServiceInterface extends ServiceInitialize
{		
	Boolean scheduleAddAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines);
	void AddAds(Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines) throws Exception;
	
	Boolean scheduleDeleteAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines);
	void DeleteAds(Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines) throws Exception;
	
	Boolean scheduleUpdateAds(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines);
	void UpdateAds(Integer promotionID, List<Integer> promotionAdIds, List<String> adEngines) throws Exception;
	
	Boolean scheduleUpdateGeoTargeting(Integer customerID, Integer promotionID, List<String> adEngines);
	void UpdateGeoTargeting(Integer promotionID, List<String> adEngines) throws Exception;
	
	Boolean scheduleChangePromotionStartDate(Integer customerID, Integer promotionID, java.util.Date newStartDate, List<String> adEngines);
	void ChangePromotionStartDate(Integer promotionID, java.util.Date newStartDate, List<String> adEngines) throws Exception;
	
	Boolean scheduleUpdateBudget(Integer customerID, Integer promotionID, Double changeInBudget, List<String> adEngines);
	void UpdateBudget(Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception;
	
	Boolean schedulePausePromotion(Integer customerID, Integer promotionID, List<String> adEngines);
	void PausePromotion(Integer promotionID, List<String> adEngines) throws Exception;
	
	Boolean scheduleUnpausePromotion(Integer customerID, Integer promotionID, List<String> adEngines);
	void UnpausePromotion(Integer promotionID, List<String> adEngines) throws Exception;
	
	Boolean scheduleRefreshSiteLinks(Integer customerID, Integer promotionID, List<String> adEngines);
	void RefreshSiteLinks(Integer promotionID, List<String> adEngines) throws Exception;
	
	Boolean schedulePauseProductGroups(Integer customerID, List<Integer> productGroupIds, List<String> adEngines);
	void PauseProductGroups(List<Integer> productGroupIds, List<String> adEngines) throws Exception;
	
	// TODO: separate out schedule methods where possible into multiple schedules in order to avoid transactionality issues when 1 schedule would make multiple calls to Google/MSN
	
	Boolean scheduleAddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList);	
	void AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList) throws Exception;
	
	Boolean scheduleAddKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<String> adEngines);
	void AddKeywords(Integer promotionID, List<Integer> keywordIds, List<String> adEngines) throws Exception;
	
	Boolean scheduleDeleteKeywords(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<String> adEngines);
	void DeleteKeywords(Integer promotionID, List<Integer> keywordIds, List<String> adEngines) throws Exception;
	
	Boolean scheduleAddNegativeKeywords(Integer customerID, Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<String> adEngines);
	void AddNegativeKeywords(Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<String> adEngines) throws Exception;
	
	Boolean scheduleDeleteNegativeKeywords(Integer customerID, Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<String> adEngines);
	void DeleteNegativeKeywords(Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<String> adEngines) throws Exception;
	
	
	Boolean ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngine) throws Exception;	
}
