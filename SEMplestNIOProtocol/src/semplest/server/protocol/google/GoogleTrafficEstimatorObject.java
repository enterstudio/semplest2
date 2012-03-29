package semplest.server.protocol.google;

import java.util.HashMap;
/*
 * All estimates are in dollar amounts
 */
public class GoogleTrafficEstimatorObject
{
	private static long micro = 1000000;
	private String keyword;
	private HashMap<Double,BidData> bidDataMap = new HashMap<Double,BidData>();
	
	public GoogleTrafficEstimatorObject(String keyword)
	{
		this.keyword = keyword;
	}
	public void setBidData(Double bidAmount, Long minAveCPC, Long maxAveCPC,Double minAvePosition,Double maxAvePosition,Float minClickPerDay,Float maxClickPerDay,Long minTotalDailyMicroCost,Long maxTotalDailyMicroCost) throws Exception
	{
		if (bidDataMap.containsKey(bidAmount))
		{
			throw new Exception("Already have set bid Amount " + String.valueOf(bidAmount) + " for keyword " + keyword);
		}
		else
		{
			BidData biddata = new BidData(minAveCPC,maxAveCPC,minAvePosition,maxAvePosition,minClickPerDay,maxClickPerDay,minTotalDailyMicroCost,maxTotalDailyMicroCost);
			bidDataMap.put(bidAmount, biddata);
		}
	}
	public Double[] getBidList()
	{
		return bidDataMap.keySet().toArray(new Double[bidDataMap.keySet().size()]);	
	}
	public Long getMinAveCPC(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return bidDataMap.get(bid).getMinAveCPC() / micro;
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	public Long getMaxAveCPC(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return bidDataMap.get(bid).getMaxAveCPC() / micro;
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	public Double getAveCPC(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return ((bidDataMap.get(bid).getMinAveCPC() + bidDataMap.get(bid).getMaxAveCPC()) /2.0) / micro ;
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	
	//Position
	public Double getMinAvePosition(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return bidDataMap.get(bid).getMinAvePosition();
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	public Double getMaxAvePosition(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return bidDataMap.get(bid).getMaxAvePosition();
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	public Double getAvePosition(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return (bidDataMap.get(bid).getMinAvePosition() + bidDataMap.get(bid).getMaxAvePosition()) /2.0 ;
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	
	//clicks
	public Float getMinAveClickPerDay(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return bidDataMap.get(bid).getMinClickPerDay();
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	public Float getMaxAveClickPerDay(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return bidDataMap.get(bid).getMaxClickPerDay();
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	public Float getAveClickPerDay(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return (bidDataMap.get(bid).getMinClickPerDay() + bidDataMap.get(bid).getMaxClickPerDay())/ 2.0F  ;
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	//dailycost

	public Long getMinTotalDailyMicroCost(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return bidDataMap.get(bid).getMinTotalDailyMicroCost();
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	public Long getMaxTotalDailyMicroCost(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return bidDataMap.get(bid).getMaxTotalDailyMicroCost();
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	public Double getAveTotalDailyMicroCost(Double bid) throws Exception
	{
		if (bidDataMap.containsKey(bid))
		{
			return (bidDataMap.get(bid).getMinTotalDailyMicroCost() + bidDataMap.get(bid).getMinTotalDailyMicroCost())/ 2.0  ;
		}
		else
		{
			throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
		}
	}
	
	public String getKeyword()
	{
		return keyword;
	}
	
	/*
	 * All in micro amounts
	 */
	private class BidData
	{
		private Long minAveCPC;
		private Long maxAveCPC;
		private Double minAvePosition;
		private Double maxAvePosition;
		private Float minClickPerDay;
		private Float maxClickPerDay;
		private Long minTotalDailyMicroCost;
		private Long maxTotalDailyMicroCost;
		public BidData(Long minAveCPC, Long maxAveCPC,Double minAvePosition,Double maxAvePosition,Float minClickPerDay,Float maxClickPerDay,Long minTotalDailyMicroCost,Long maxTotalDailyMicroCost)
		{
			this.minAveCPC = minAveCPC;
			this.maxAveCPC = maxAveCPC;
			this.minAvePosition = minAvePosition;
			this.maxAvePosition = maxAvePosition;
			this.minClickPerDay = minClickPerDay;
			this.maxClickPerDay = maxClickPerDay;
			this.minTotalDailyMicroCost = minTotalDailyMicroCost;
			this.maxTotalDailyMicroCost = maxTotalDailyMicroCost;
		}
		public Long getMinAveCPC()
		{
			return minAveCPC;
		}
		public void setMinAveCPC(Long minAveCPC)
		{
			this.minAveCPC = minAveCPC;
		}
		public Long getMaxAveCPC()
		{
			return maxAveCPC;
		}
		public void setMaxAveCPC(Long maxAveCPC)
		{
			this.maxAveCPC = maxAveCPC;
		}
		public Double getMinAvePosition()
		{
			return minAvePosition;
		}
		public void setMinAvePosition(Double minAvePosition)
		{
			this.minAvePosition = minAvePosition;
		}
		public Double getMaxAvePosition()
		{
			return maxAvePosition;
		}
		public void setMaxAvePosition(Double maxAvePosition)
		{
			this.maxAvePosition = maxAvePosition;
		}
		public Float getMinClickPerDay()
		{
			return minClickPerDay;
		}
		public void setMinClickPerDay(Float minClickPerDay)
		{
			this.minClickPerDay = minClickPerDay;
		}
		public Float getMaxClickPerDay()
		{
			return maxClickPerDay;
		}
		public void setMaxClickPerDay(Float maxClickPerDay)
		{
			this.maxClickPerDay = maxClickPerDay;
		}
		public Long getMinTotalDailyMicroCost()
		{
			return minTotalDailyMicroCost;
		}
		public void setMinTotalDailyMicroCost(Long minTotalDailyMicroCost)
		{
			this.minTotalDailyMicroCost = minTotalDailyMicroCost;
		}
		public Long getMaxTotalDailyMicroCost()
		{
			return maxTotalDailyMicroCost;
		}
		public void setMaxTotalDailyMicroCost(Long maxTotalDailyMicroCost)
		{
			this.maxTotalDailyMicroCost = maxTotalDailyMicroCost;
		}
		
		
		
		
		
	}

	
}
