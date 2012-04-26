package semplest.server.service.springjdbc;

public class AdvertisingEnginePromotionObj
{
	private Long AdvertisingEngineAccountID;
	private Integer AdvertisingEngineCampaignID;
	private Integer PromotionID;
	private Boolean IsSearchNetwork;
	private Boolean IsDisplayNetwork;
	private Double AdvertisingEngineBudget;
	
	public Integer getAdvertisingEngineCampaignID()
	{
		return AdvertisingEngineCampaignID;
	}
	public void setAdvertisingEngineCampaignID(Integer advertisingEngineCampaignID)
	{
		AdvertisingEngineCampaignID = advertisingEngineCampaignID;
	}
	public Integer getPromotionID()
	{
		return PromotionID;
	}
	public void setPromotionID(Integer promotionID)
	{
		PromotionID = promotionID;
	}
	public Boolean getIsSearchNetwork()
	{
		return IsSearchNetwork;
	}
	public void setIsSearchNetwork(Boolean isSearchNetwork)
	{
		IsSearchNetwork = isSearchNetwork;
	}
	public Boolean getIsDisplayNetwork()
	{
		return IsDisplayNetwork;
	}
	public void setIsDisplayNetwork(Boolean isDisplayNetwork)
	{
		IsDisplayNetwork = isDisplayNetwork;
	}
	public Double getAdvertisingEngineBudget()
	{
		return AdvertisingEngineBudget;
	}
	public void setAdvertisingEngineBudget(Double advertisingEngineBudget)
	{
		AdvertisingEngineBudget = advertisingEngineBudget;
	}
	public Long getAdvertisingEngineAccountID()
	{
		return AdvertisingEngineAccountID;
	}
	public void setAdvertisingEngineAccountID(Long advertisingEngineAccountID)
	{
		AdvertisingEngineAccountID = advertisingEngineAccountID;
	}

}
