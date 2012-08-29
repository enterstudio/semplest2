package semplest.dmoz.springjdbc;

public class AdvertisingEnginePromotionObj
{
	private Long AdvertisingEngineAccountID;
	private Long AdvertisingEngineCampaignID;
	private Integer PromotionID;
	private Boolean IsSearchNetwork;
	private Boolean IsDisplayNetwork;
	private Double MicroDefaultBid;
	private Long AdvertisingEngineAdGroupID; 
	
	private Double AdvertisingEngineBudget;
	private Double CurrentDailyBudget;
	
	
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
	
	public Long getAdvertisingEngineAccountID()
	{
		return AdvertisingEngineAccountID;
	}
	public void setAdvertisingEngineAccountID(Long advertisingEngineAccountID)
	{
		AdvertisingEngineAccountID = advertisingEngineAccountID;
	}
	public Double getMicroDefaultBid()
	{
		return MicroDefaultBid;
	}
	public void setMicroDefaultBid(Double microDefaultBid)
	{
		MicroDefaultBid = microDefaultBid;
	}
	public Long getAdvertisingEngineCampaignID()
	{
		return AdvertisingEngineCampaignID;
	}
	public void setAdvertisingEngineCampaignID(Long advertisingEngineCampaignID)
	{
		AdvertisingEngineCampaignID = advertisingEngineCampaignID;
	}
	public Long getAdvertisingEngineAdGroupID()
	{
		return AdvertisingEngineAdGroupID;
	}
	public void setAdvertisingEngineAdGroupID(Long advertisingEngineAdGroupID)
	{
		AdvertisingEngineAdGroupID = advertisingEngineAdGroupID;
	}
	public Double getAdvertisingEngineBudget()
	{
		return AdvertisingEngineBudget;
	}
	public void setAdvertisingEngineBudget(Double advertisingEngineBudget)
	{
		AdvertisingEngineBudget = advertisingEngineBudget;
	}
	public Double getCurrentDailyBudget()
	{
		return CurrentDailyBudget;
	}
	public void setCurrentDailyBudget(Double currentDailyBudget)
	{
		CurrentDailyBudget = currentDailyBudget;
	}

}
