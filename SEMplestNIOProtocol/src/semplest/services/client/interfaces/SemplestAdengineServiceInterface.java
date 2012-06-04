package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.List;

public interface SemplestAdengineServiceInterface extends ServiceInitialize
{
	// implemented (at least for Google)
	public abstract Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList) throws Exception;
	public abstract Boolean ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngine) throws Exception;
	public abstract Boolean UpdateGeoTargeting(Integer PromotionID, List<String> adEngines) throws Exception;
	public abstract Boolean AddAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	public abstract Boolean DeleteAdEngineAd(Integer customerID, Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	public abstract Boolean DeleteAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	public abstract Boolean UpdateAd(Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;	
	public abstract Boolean UpdateBudget(Integer promotionID, Double changeInBudget, List<String> adEngines) throws Exception;
	public abstract Boolean PausePromotion(Integer promotionID, List<String> adEngines) throws Exception;
	public abstract Boolean ChangePromotionStartDate(Integer promotionID, java.util.Date newStartDate, List<String> adEngines) throws Exception;
	public abstract Boolean DeleteKeyword(Integer promotionID, String Keyword, List<String> adEngines) throws Exception;
	
	// not yet implemented		
	public abstract Boolean PauseProductGroup(Integer customerID,Integer productGroupID, List<String> adEngines) throws Exception;		
	public abstract Boolean DeleteSiteLinkForAd(Integer customerID,Integer promotionID, Integer promotionAdID, Integer SiteLinkID, List<String> adEngines) throws Exception;
	public abstract Boolean AddSiteLinkForAd(Integer customerID,Integer promotionID, Integer promotionAdID, List<String> adEngines) throws Exception;
	public abstract Boolean UpdateSiteLinkForAd(Integer customerID,Integer promotionID, Integer promotionAdID, Integer SiteLinkID, String siteLink, List<String> adEngines) throws Exception;			
}
