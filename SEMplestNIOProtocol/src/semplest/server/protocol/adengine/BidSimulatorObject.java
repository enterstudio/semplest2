package semplest.server.protocol.adengine;

import java.util.HashMap;


public class BidSimulatorObject
{
	private Long AdGroupId;
	private Long CriterionId;
	private String StartDate;
	private String EndDate;
	private HashMap<Long,BidPoint> bidPoints = new HashMap<Long,BidPoint>();
	
	public void addBidPoint(Long bid,Long clicks,Long cost,Long marginalCpc,Long impressions)
	{
		BidPoint onebid = new BidPoint();
		onebid.setBid(bid);
		onebid.setClicks(clicks);
		onebid.setCost(cost);
		onebid.setImpressions(impressions);
		onebid.setMarginalCpc(marginalCpc);
		bidPoints.put(bid,onebid);
	}
	public BidPoint getBidPoint(Long bid)
	{
		if (bidPoints.containsKey(bid))
		{
			return bidPoints.get(bid);
		}
		else
		{
			return null;
		}
	}
	/*
	 * {bid: " + bidLanscapePoint.getBid().getMicroAmount() + " clicks: " + bidLanscapePoint.getClicks()
							+ " cost: " + bidLanscapePoint.getCost().getMicroAmount() + " marginalCpc: "
							+ bidLanscapePoint.getMarginalCpc().getMicroAmount() + " impressions:
	 */
	
	public class BidPoint
	{
		private Long bid;
		private Long clicks;
		private Long cost;
		private Long marginalCpc;
		private Long impressions;
		public Long getBid()
		{
			return bid;
		}
		public void setBid(Long bid)
		{
			this.bid = bid;
		}
		public Long getClicks()
		{
			return clicks;
		}
		public void setClicks(Long clicks)
		{
			this.clicks = clicks;
		}
		public Long getCost()
		{
			return cost;
		}
		public void setCost(Long cost)
		{
			this.cost = cost;
		}
		public Long getMarginalCpc()
		{
			return marginalCpc;
		}
		public void setMarginalCpc(Long marginalCpc)
		{
			this.marginalCpc = marginalCpc;
		}
		public Long getImpressions()
		{
			return impressions;
		}
		public void setImpressions(Long impressions)
		{
			this.impressions = impressions;
		}
		
		
	}

	public Long getAdGroupId()
	{
		return AdGroupId;
	}

	public void setAdGroupId(Long adGroupId)
	{
		AdGroupId = adGroupId;
	}

	public Long getCriterionId()
	{
		return CriterionId;
	}

	public void setCriterionId(Long criterionId)
	{
		CriterionId = criterionId;
	}

	public String getStartDate()
	{
		return StartDate;
	}

	public void setStartDate(String startDate)
	{
		StartDate = startDate;
	}

	public String getEndDate()
	{
		return EndDate;
	}

	public void setEndDate(String endDate)
	{
		EndDate = endDate;
	}

	

}
