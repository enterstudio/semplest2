package semplest.server.protocol.google;

public class GoogleAdGroupObject
{
	private Long adGroupID;
	private Long campaignId;
	private String campaignName;
	private java.lang.String adGroupName;
	private com.google.api.adwords.v201109.cm.AdGroupStatus status;
	//private adGroupStats stats;

	public Long getAdGroupID()
	{
		return adGroupID;
	}

	public void setAdGroupID(Long adGroupID)
	{
		this.adGroupID = adGroupID;
	}

	public Long getCampaignId()
	{
		return campaignId;
	}

	public void setCampaignId(Long campaignId)
	{
		this.campaignId = campaignId;
	}

	public String getCampaignName()
	{
		return campaignName;
	}

	public void setCampaignName(String campaignName)
	{
		this.campaignName = campaignName;
	}

	public java.lang.String getAdGroupName()
	{
		return adGroupName;
	}

	public void setAdGroupName(java.lang.String adGroupName)
	{
		this.adGroupName = adGroupName;
	}

	public com.google.api.adwords.v201109.cm.AdGroupStatus getStatus()
	{
		return status;
	}

	public void setStatus(com.google.api.adwords.v201109.cm.AdGroupStatus status)
	{
		this.status = status;
	}
/*
 * all costs are in MicroAmounts
 */
	public class adGroupStats
	{

		private String startDate;

		/* Ending date (inclusive) of the statistics. Format is YYYYMMDD. */
		private java.lang.String endDate;
		private java.lang.Long clicks;

		private java.lang.Long impressions;
		private Long cost;
		private Double averagePosition;
		private Long averageCpc;
		private Long averageCpm;
		private Double ctr;
		private Long conversions;
		private Double conversionRate;
		private Long costPerConversion;
		private Long conversionsManyPerClick;
		private Double conversionRateManyPerClick;
		private Long costPerConversionManyPerClick;
		private Long viewThroughConversions;
		private Long totalConvValue;
		private Double valuePerConv;
		private Double valuePerConvManyPerClick;
		private Long invalidClicks;
		private Double invalidClickRate;
		private Long numCalls;
		private Long numMissedCalls;
		private Long numReceivedCalls;
		private Long callDurationSecs;
		private Double avgCallDurationSecs;
		private String statsType;
		
		public String getStartDate()
		{
			return startDate;
		}

		public void setStartDate(String startDate)
		{
			this.startDate = startDate;
		}

		public java.lang.String getEndDate()
		{
			return endDate;
		}

		public void setEndDate(java.lang.String endDate)
		{
			this.endDate = endDate;
		}

		public java.lang.Long getClicks()
		{
			return clicks;
		}

		public void setClicks(java.lang.Long clicks)
		{
			this.clicks = clicks;
		}

		public java.lang.Long getImpressions()
		{
			return impressions;
		}

		public void setImpressions(java.lang.Long impressions)
		{
			this.impressions = impressions;
		}

		

		public Double getAveragePosition()
		{
			return averagePosition;
		}

		public void setAveragePosition(Double averagePosition)
		{
			this.averagePosition = averagePosition;
		}

		

		public Double getCtr()
		{
			return ctr;
		}

		public void setCtr(Double ctr)
		{
			this.ctr = ctr;
		}

		public Long getConversions()
		{
			return conversions;
		}

		public void setConversions(Long conversions)
		{
			this.conversions = conversions;
		}

		public Double getConversionRate()
		{
			return conversionRate;
		}

		public void setConversionRate(Double conversionRate)
		{
			this.conversionRate = conversionRate;
		}

		

		public Long getConversionsManyPerClick()
		{
			return conversionsManyPerClick;
		}

		public void setConversionsManyPerClick(Long conversionsManyPerClick)
		{
			this.conversionsManyPerClick = conversionsManyPerClick;
		}

		public Double getConversionRateManyPerClick()
		{
			return conversionRateManyPerClick;
		}

		public void setConversionRateManyPerClick(Double conversionRateManyPerClick)
		{
			this.conversionRateManyPerClick = conversionRateManyPerClick;
		}

		

		public Long getViewThroughConversions()
		{
			return viewThroughConversions;
		}

		public void setViewThroughConversions(Long viewThroughConversions)
		{
			this.viewThroughConversions = viewThroughConversions;
		}

		public Long getTotalConvValue()
		{
			return totalConvValue;
		}

		public void setTotalConvValue(Long totalConvValue)
		{
			this.totalConvValue = totalConvValue;
		}

		public Double getValuePerConv()
		{
			return valuePerConv;
		}

		public void setValuePerConv(Double valuePerConv)
		{
			this.valuePerConv = valuePerConv;
		}

		public Double getValuePerConvManyPerClick()
		{
			return valuePerConvManyPerClick;
		}

		public void setValuePerConvManyPerClick(Double valuePerConvManyPerClick)
		{
			this.valuePerConvManyPerClick = valuePerConvManyPerClick;
		}

		public Long getInvalidClicks()
		{
			return invalidClicks;
		}

		public void setInvalidClicks(Long invalidClicks)
		{
			this.invalidClicks = invalidClicks;
		}

		public Double getInvalidClickRate()
		{
			return invalidClickRate;
		}

		public void setInvalidClickRate(Double invalidClickRate)
		{
			this.invalidClickRate = invalidClickRate;
		}

		public Long getNumCalls()
		{
			return numCalls;
		}

		public void setNumCalls(Long numCalls)
		{
			this.numCalls = numCalls;
		}

		public Long getNumMissedCalls()
		{
			return numMissedCalls;
		}

		public void setNumMissedCalls(Long numMissedCalls)
		{
			this.numMissedCalls = numMissedCalls;
		}

		public Long getNumReceivedCalls()
		{
			return numReceivedCalls;
		}

		public void setNumReceivedCalls(Long numReceivedCalls)
		{
			this.numReceivedCalls = numReceivedCalls;
		}

		public Long getCallDurationSecs()
		{
			return callDurationSecs;
		}

		public void setCallDurationSecs(Long callDurationSecs)
		{
			this.callDurationSecs = callDurationSecs;
		}

		public Double getAvgCallDurationSecs()
		{
			return avgCallDurationSecs;
		}

		public void setAvgCallDurationSecs(Double avgCallDurationSecs)
		{
			this.avgCallDurationSecs = avgCallDurationSecs;
		}

		public String getStatsType()
		{
			return statsType;
		}

		public void setStatsType(String statsType)
		{
			this.statsType = statsType;
		}

		public Long getCost()
		{
			return cost;
		}

		public void setCost(Long cost)
		{
			this.cost = cost;
		}

		public Long getAverageCpc()
		{
			return averageCpc;
		}

		public void setAverageCpc(Long averageCpc)
		{
			this.averageCpc = averageCpc;
		}

		public Long getAverageCpm()
		{
			return averageCpm;
		}

		public void setAverageCpm(Long averageCpm)
		{
			this.averageCpm = averageCpm;
		}

		public Long getCostPerConversion()
		{
			return costPerConversion;
		}

		public void setCostPerConversion(Long costPerConversion)
		{
			this.costPerConversion = costPerConversion;
		}

		public Long getCostPerConversionManyPerClick()
		{
			return costPerConversionManyPerClick;
		}

		public void setCostPerConversionManyPerClick(Long costPerConversionManyPerClick)
		{
			this.costPerConversionManyPerClick = costPerConversionManyPerClick;
		}
	}

	/*
	public adGroupStats getStats()
	{
		return stats;
	}

	public void setStats(adGroupStats stats)
	{
		this.stats = stats;
	}
	*/

}
