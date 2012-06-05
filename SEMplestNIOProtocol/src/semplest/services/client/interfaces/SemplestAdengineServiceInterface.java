package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface SemplestAdengineServiceInterface extends ServiceInitialize
{
	Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList) throws Exception;
	Boolean ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngine) throws Exception;
	Boolean UpdateGeoTargeting(Integer PromotionID, List<String> adEngines) throws Exception;
	Boolean AddAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	Boolean DeleteAdEngineAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	Boolean DeleteAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	Boolean UpdateAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;	
	Boolean UpdateBudget(Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception;
	Boolean PausePromotion(Integer promotionID, List<String> adEngines) throws Exception;
	Boolean UnpausePromotion(Integer promotionID, List<String> adEngines) throws Exception;
	Boolean ChangePromotionStartDate(Integer promotionID, java.util.Date newStartDate, List<String> adEngines) throws Exception;
	Boolean DeleteKeyword(Integer promotionID, String Keyword, List<String> adEngines) throws Exception;
	Boolean RefreshSiteLinksForAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	Boolean PauseProductGroup(Integer productGroupID, List<String> adEngines) throws Exception;				
}
