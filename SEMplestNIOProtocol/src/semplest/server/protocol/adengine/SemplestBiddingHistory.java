package semplest.server.protocol.adengine;

public class SemplestBiddingHistory
{
	private Integer PromotionFK;
	private java.util.Date BidCompleted;
	private String AdvertisingEngine;
	private String SemplestBidType;
	public Integer getPromotionFK()
	{
		return PromotionFK;
	}
	public void setPromotionFK(Integer promotionFK)
	{
		PromotionFK = promotionFK;
	}
	public java.util.Date getBidCompleted()
	{
		return BidCompleted;
	}
	public void setBidCompleted(java.util.Date bidCompleted)
	{
		BidCompleted = bidCompleted;
	}
	public String getAdvertisingEngine()
	{
		return AdvertisingEngine;
	}
	public void setAdvertisingEngine(String advertisingEngine)
	{
		AdvertisingEngine = advertisingEngine;
	}
	public String getSemplestBidType()
	{
		return SemplestBidType;
	}
	public void setSemplestBidType(String semplestBidType)
	{
		SemplestBidType = semplestBidType;
	}

}
