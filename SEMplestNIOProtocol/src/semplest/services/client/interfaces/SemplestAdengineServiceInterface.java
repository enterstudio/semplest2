package semplest.services.client.interfaces;

import java.util.ArrayList;

public interface SemplestAdengineServiceInterface extends ServiceInitialize
{
	public abstract Boolean AddPromotionToAdEngine(Integer customerID, Integer productGroupID, Integer PromotionID, ArrayList<String> adEngineList ) throws Exception;
	public abstract Boolean ExecuteBidProcess(Integer PromotionID, ArrayList<String> adEngine ) throws Exception;
	public abstract Boolean PausePromotion(Integer customerID,Integer promotionID, String adEngine) throws Exception;
	public abstract Boolean PauseProductGroup(Integer customerID,Integer productGroupID, String adEngine) throws Exception;
	public abstract Boolean DeleteAd(Integer customerID,Integer promotionID, Integer promotionAdID) throws Exception;
	public abstract Boolean UpdateAd(Integer customerID,Integer promotionID, Integer promotionAdID) throws Exception;
	public abstract Boolean AddAd(Integer customerID,Integer promotionID) throws Exception;
	public abstract Boolean DeleteSiteLinkForAd(Integer customerID,Integer promotionID, Integer promotionAdID, Integer SiteLinkID) throws Exception;
	public abstract Boolean AdSiteLinkForAd(Integer customerID,Integer promotionID, Integer promotionAdID) throws Exception;
	public abstract Boolean UpdateSiteLinkForAd(Integer customerID,Integer promotionID, Integer promotionAdID, Integer SiteLinkID, String siteLink) throws Exception;
	
	public abstract Boolean UpdateGeoTargeting(Integer customerID,Integer productGroupID, Integer GeoTargetingID ) throws Exception;
	public abstract Boolean UpdateBudget(Integer promotionID, Double changeInBudget) throws Exception;
	public abstract Boolean ChangePromotionStartDate(Integer promotionID, java.util.Date newStartDate) throws Exception;
	public abstract Boolean DeleteKeyword(Integer promotionID, String Keyword) throws Exception;
	

}
