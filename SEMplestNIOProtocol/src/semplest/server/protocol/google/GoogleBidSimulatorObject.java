package semplest.server.protocol.google;

import com.google.api.adwords.v201109.cm.Money;

public class GoogleBidSimulatorObject
{
	private Long AdGroupId;
	private Long CriterionId;
	private java.util.Date StartDate;
	private java.util.Date EndDate;
	
	public class BidPoints
	{
		private Long LocalClicks;
		private Money LocalCost;
		private Money MarginalCpc;
		private Long LocalImpressions; 
		private Integer QualityScore;
		private Double Bid;
		public Double getBid()
		{
			return Bid;
		}
		public void setBid(Double bid)
		{
			Bid = bid;
		}
		public Long getLocalClicks()
		{
			return LocalClicks;
		}
		public void setLocalClicks(Long localClicks)
		{
			LocalClicks = localClicks;
		}
		public Money getLocalCost()
		{
			return LocalCost;
		}
		public void setLocalCost(Money localCost)
		{
			LocalCost = localCost;
		}
		public Money getMarginalCpc()
		{
			return MarginalCpc;
		}
		public void setMarginalCpc(Money marginalCpc)
		{
			MarginalCpc = marginalCpc;
		}
		public Long getLocalImpressions()
		{
			return LocalImpressions;
		}
		public void setLocalImpressions(Long localImpressions)
		{
			LocalImpressions = localImpressions;
		}
		public Integer getQualityScore()
		{
			return QualityScore;
		}
		public void setQualityScore(Integer qualityScore)
		{
			QualityScore = qualityScore;
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

	public java.util.Date getStartDate()
	{
		return StartDate;
	}

	public void setStartDate(java.util.Date startDate)
	{
		StartDate = startDate;
	}

	public java.util.Date getEndDate()
	{
		return EndDate;
	}

	public void setEndDate(java.util.Date endDate)
	{
		EndDate = endDate;
	}

}
