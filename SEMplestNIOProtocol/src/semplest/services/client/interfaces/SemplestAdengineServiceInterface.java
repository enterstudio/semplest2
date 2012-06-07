package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface SemplestAdengineServiceInterface extends ServiceInitialize
{		
	Boolean scheduleAddAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines);
	void AddAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	
	Boolean scheduleDeleteAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	void DeleteAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	
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
	
	Boolean scheduleDeleteKeyword(Integer customerID, Integer promotionID, String Keyword, List<String> adEngines);
	void DeleteKeyword(Integer promotionID, String Keyword, List<String> adEngines) throws Exception;
	
	Boolean scheduleUpdateAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines);
	void UpdateAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	
	Boolean scheduleRefreshSiteLinksForAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines);
	void RefreshSiteLinksForAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	
	Boolean schedulePauseProductGroup(Integer customerID, Integer productGroupID, List<String> adEngines);
	void PauseProductGroup(Integer productGroupID, List<String> adEngines) throws Exception;
		
	// TODO: separate out schedule methods where possible into multiple schedules in order to avoid transactionality issues when 1 schedule would make multiple calls to Google/MSN
	
	Boolean scheduleAddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList);	
	void AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList) throws Exception;
	
	void ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngine) throws Exception;	
}
