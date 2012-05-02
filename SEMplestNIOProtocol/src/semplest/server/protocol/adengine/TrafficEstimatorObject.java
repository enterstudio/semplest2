package semplest.server.protocol.adengine;

import java.util.HashMap;
import java.util.Iterator;

/*
 * All estimates are in dollar amounts
 */
public class TrafficEstimatorObject
{
	// keyword, matchtype, [list of bids]

	private HashMap<String, HashMap<String, HashMap<Double, BidData>>> bidDataMap = new HashMap<String, HashMap<String, HashMap<Double, BidData>>>();

	public void setBidData(String keyword, Double bidAmount, String matchType, Long minAveCPC, Long maxAveCPC, Double minAvePosition,
			Double maxAvePosition, Float minClickPerDay, Float maxClickPerDay, Long minTotalDailyMicroCost, Long maxTotalDailyMicroCost)
			throws Exception
	{
		BidData biddata = new BidData(minAveCPC, maxAveCPC, minAvePosition, maxAvePosition, minClickPerDay, maxClickPerDay,
				minTotalDailyMicroCost, maxTotalDailyMicroCost);
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap != null && matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				data.put(bidAmount, biddata);
			}
			else
			// new match type
			{
				HashMap<Double, BidData> data = new HashMap<Double, BidData>();
				data.put(bidAmount, biddata);
				matchTypeMap.put(matchType, data);
				bidDataMap.put(keyword, matchTypeMap);
			}
		}
		else
		{
			HashMap<Double, BidData> data = new HashMap<Double, BidData>();
			data.put(bidAmount, biddata);
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = new HashMap<String, HashMap<Double, BidData>>();
			matchTypeMap.put(matchType, data);
			bidDataMap.put(keyword, matchTypeMap);
		}
	}

	private void setBidData(String keyword, String matchType, Double bidAmount, BidData biddata)
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap != null && matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				data.put(bidAmount, biddata);
			}
			else
			// new match type
			{
				HashMap<Double, BidData> data = new HashMap<Double, BidData>();
				data.put(bidAmount, biddata);
				matchTypeMap.put(matchType, data);
				bidDataMap.put(keyword, matchTypeMap);
			}
		}
		else
		{
			HashMap<Double, BidData> data = new HashMap<Double, BidData>();
			data.put(bidAmount, biddata);
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = new HashMap<String, HashMap<Double, BidData>>();
			matchTypeMap.put(matchType, data);
			bidDataMap.put(keyword, matchTypeMap);
		}
	}

	public String[] getListOfKeywords()
	{
		return bidDataMap.keySet().toArray(new String[bidDataMap.keySet().size()]);
	}

	public Double[] getBidList(String keyword, String matchType)
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchType != null && matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				return data.keySet().toArray(new Double[bidDataMap.keySet().size()]);
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}

	}

	public HashMap<Double, BidData> getMapOfPoints(String keyword, String matchType)
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchType != null && matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				return data;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	public void addGoogleTrafficEstimatorObject(TrafficEstimatorObject trafficData, String matchType)
	{
		if (trafficData != null)
		{
			String[] keywords = trafficData.getListOfKeywords();
			for (int i = 0; i < keywords.length; i++)
			{
				HashMap<Double, BidData> ptData = trafficData.getMapOfPoints(keywords[i], matchType);
				Iterator<Double> bidsIT = ptData.keySet().iterator();
				while (bidsIT.hasNext())
				{
					Double bid = bidsIT.next();
					BidData aBidData = ptData.get(bid);
					this.setBidData(keywords[i], matchType, bid, aBidData);
				}
			}
		}
	}

	public Long getMinAveCPC(String keyword, String matchType, Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return data.get(bid).getMinAveCPC();
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	public Long getMaxAveCPC(String keyword, String matchType, Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return data.get(bid).getMaxAveCPC();
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	public Double getAveCPC(String keyword, String matchType, Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return ((data.get(bid).getMinAveCPC() + data.get(bid).getMaxAveCPC()) / 2.0);
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	// Position
	public Double getMinAvePosition(String keyword,String matchType, Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return data.get(bid).getMinAvePosition();
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	public Double getMaxAvePosition(String keyword,String matchType, Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return data.get(bid).getMaxAvePosition();
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	public Double getAvePosition(String keyword, String matchType,Double bid) throws Exception
	{

		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return (data.get(bid).getMinAvePosition() + data.get(bid).getMaxAvePosition()) / 2.0;
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
		
	}

	// clicks
	public Float getMinAveClickPerDay(String keyword,String matchType,  Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return data.get(bid).getMinClickPerDay();
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	public Float getMaxAveClickPerDay(String keyword,String matchType, Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return data.get(bid).getMaxClickPerDay();
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	public Float getAveClickPerDay(String keyword,String matchType,  Double bid) throws Exception
	{

		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return (data.get(bid).getMinClickPerDay() + data.get(bid).getMaxClickPerDay()) / 2.0F;
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	// dailycost

	public Long getMinTotalDailyMicroCost(String keyword,String matchType, Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return data.get(bid).getMinTotalDailyMicroCost();
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	public Long getMaxTotalDailyMicroCost(String keyword,String matchType,  Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return data.get(bid).getMaxTotalDailyMicroCost();
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	public Double getAveTotalDailyMicroCost(String keyword,String matchType, Double bid) throws Exception
	{
		if (bidDataMap.containsKey(keyword))
		{
			HashMap<String, HashMap<Double, BidData>> matchTypeMap = bidDataMap.get(keyword);
			if (matchTypeMap.containsKey(matchType))
			{
				HashMap<Double, BidData> data = matchTypeMap.get(matchType);
				if (data.containsKey(bid))
				{
					return (data.get(bid).getMinTotalDailyMicroCost() + data.get(bid).getMinTotalDailyMicroCost()) / 2.0;
				}
				else
				{
					throw new Exception("Bid level " + bid + " not found for keyword " + keyword);
				}
			}
			else
			{
				throw new Exception("Match type " + matchType + " for Keyword not found " + keyword);
			}
		}
		else
		{
			throw new Exception("Keyword not found " + keyword);
		}
	}

	/*
	 * All in micro amounts
	 */
	public class BidData
	{
		private Long minAveCPC;
		private Long maxAveCPC;
		private Double minAvePosition;
		private Double maxAvePosition;
		private Float minClickPerDay;
		private Float maxClickPerDay;
		private Long minTotalDailyMicroCost;
		private Long maxTotalDailyMicroCost;
		//private String matchType; String matchType, 

		public BidData(Long minAveCPC, Long maxAveCPC, Double minAvePosition, Double maxAvePosition, Float minClickPerDay,
				Float maxClickPerDay, Long minTotalDailyMicroCost, Long maxTotalDailyMicroCost)
		{
			this.minAveCPC = minAveCPC;
			this.maxAveCPC = maxAveCPC;
			this.minAvePosition = minAvePosition;
			this.maxAvePosition = maxAvePosition;
			this.minClickPerDay = minClickPerDay;
			this.maxClickPerDay = maxClickPerDay;
			this.minTotalDailyMicroCost = minTotalDailyMicroCost;
			this.maxTotalDailyMicroCost = maxTotalDailyMicroCost;
			//this.matchType = matchType;
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

		/*
		public String getMatchType()
		{
			return matchType;
		}

		public void setMatchType(String matchType)
		{
			this.matchType = matchType;
		}
		*/

	}

	public HashMap<String, HashMap<String, HashMap<Double, BidData>>> getBidDataMap()
	{
		return bidDataMap;
	}

}
