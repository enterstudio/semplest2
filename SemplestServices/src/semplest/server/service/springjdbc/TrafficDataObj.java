package semplest.server.service.springjdbc;

import java.sql.Timestamp;

public class TrafficDataObj
{
	private int PromotionID;
	private String Keyword;
	private String AdvertisingEngine;
	private String BidType;
	private Integer MicroBid;
	private Float AveMicroCost;
	private Float AveNumberClicks;
	private Float AvePosition;
	private Float AveCPC;
	private Timestamp currentTime;
	public int getPromotionID()
	{
		return PromotionID;
	}
	public void setPromotionID(int promotionID)
	{
		PromotionID = promotionID;
	}
	public String getKeyword()
	{
		return Keyword;
	}
	public void setKeyword(String keyword)
	{
		Keyword = keyword;
	}
	public String getAdvertisingEngine()
	{
		return AdvertisingEngine;
	}
	public void setAdvertisingEngine(String advertisingEngine)
	{
		AdvertisingEngine = advertisingEngine;
	}
	public String getBidType()
	{
		return BidType;
	}
	public void setBidType(String bidType)
	{
		BidType = bidType;
	}
	public Integer getMicroBid()
	{
		return MicroBid;
	}
	public void setMicroBid(Integer microBid)
	{
		MicroBid = microBid;
	}
	public Float getAveMicroCost()
	{
		return AveMicroCost;
	}
	public void setAveMicroCost(Float aveMicroCost)
	{
		AveMicroCost = aveMicroCost;
	}
	public Float getAveNumberClicks()
	{
		return AveNumberClicks;
	}
	public void setAveNumberClicks(Float aveNumberClicks)
	{
		AveNumberClicks = aveNumberClicks;
	}
	public Float getAvePosition()
	{
		return AvePosition;
	}
	public void setAvePosition(Float avePosition)
	{
		AvePosition = avePosition;
	}
	public Float getAveCPC()
	{
		return AveCPC;
	}
	public void setAveCPC(Float aveCPC)
	{
		AveCPC = aveCPC;
	}
	public Timestamp getCurrentTime()
	{
		return currentTime;
	}
	public void setCurrentTime(Timestamp currentTime)
	{
		this.currentTime = currentTime;
	}

}
