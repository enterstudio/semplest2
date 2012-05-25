package semplest.server.protocol.adengine;

import java.util.Date;

public class TrafficEstimatorDataObject
{
	private String keyword;
	private Integer microBid;
	private Float aveMicroCost;
	private Float aveNumberClicks;
	private Float avePosition;
	private Float aveCPC;
	private Date createdDate;

	private Boolean isActive;

	
	public Integer getMicroBid()

	{
		return microBid;
	}
	public void setMicroBid(Integer microBid)
	{
		this.microBid = microBid;
	}
	public Float getAveMicroCost()
	{
		return aveMicroCost;
	}
	public void setAveMicroCost(Float aveMicroCost)
	{
		this.aveMicroCost = aveMicroCost;
	}
	public Float getAveNumberClicks()
	{
		return aveNumberClicks;
	}
	public void setAveNumberClicks(Float aveNumberClicks)
	{
		this.aveNumberClicks = aveNumberClicks;
	}
	public Float getAvePosition()
	{
		return avePosition;
	}
	public void setAvePosition(Float avePosition)
	{
		this.avePosition = avePosition;
	}
	public Float getAveCPC()
	{
		return aveCPC;
	}
	public void setAveCPC(Float aveCPC)
	{
		this.aveCPC = aveCPC;
	}
	public Date getCreatedDate()
	{
		return createdDate;
	}
	public void setCreatedDate(Date createdDate)
	{
		this.createdDate = createdDate;
	}

	public Boolean getIsActive()
	{
		return isActive;
	}
	public void setIsActive(Boolean isActive)
	{
		this.isActive = isActive;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
