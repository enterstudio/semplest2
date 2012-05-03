package semplest.server.protocol.adengine;

import java.sql.Date;

public class TrafficEstimatorDataObject
{
	private Long microBid;
	private Float aveMicroCost;
	private Float aveNumberClicks;
	private Float avePosition;
	private Float aveCPC;
	private Date createdDate;
	public Long getMicroBid()
	{
		return microBid;
	}
	public void setMicroBid(Long microBid)
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
	
}
