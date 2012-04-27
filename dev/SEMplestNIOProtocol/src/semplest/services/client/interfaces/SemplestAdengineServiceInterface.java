package semplest.services.client.interfaces;

import java.util.ArrayList;

public interface SemplestAdengineServiceInterface extends ServiceInitialize
{
	public abstract Boolean AddPromotionToAdEngine(Integer customerID, Long productGroupID, Integer PromotionID, ArrayList<String> adEngineList ) throws Exception;
	public abstract Boolean PausePromotion(Integer customerID,Integer promotionID, String adEngine) throws Exception;
	public abstract Boolean PauseProductGroup(Integer customerID,Integer productGroupID, String adEngine) throws Exception;
	public abstract Boolean DeleteAd(Integer customerID,Integer promotionID, Integer promotionAdID) throws Exception;
	public abstract Boolean DeleteSiteLinkForAd(Integer customerID,Integer promotionID, Integer promotionAdID, Integer SiteLinkID) throws Exception;
	public abstract Boolean UpdateGeoTargeting(Integer customerID,Integer productGroupID, Integer GeoTargetingID ) throws Exception;

}
