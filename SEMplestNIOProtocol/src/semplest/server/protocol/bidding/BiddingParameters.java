package semplest.server.protocol.bidding;

public class BiddingParameters
{
	private Integer SemplestBiddingBudgetMultFactor;
	private Float SemplestBiddingInitialBidBoostFactor;
	private Integer SemplestBiddingPercentileValue;
	private Float SemplestBiddingMarginFactor;
	private Integer BiddingServiceTargetPosition;
	private Double BiddingServiceBidMultiplierForGoogleFromMSNHistory;
	private Integer BiddingServiceGoogleVolMultiplierFromMSNHistory;
	public Integer getSemplestBiddingBudgetMultFactor()
	{
		return SemplestBiddingBudgetMultFactor;
	}
	public void setSemplestBiddingBudgetMultFactor(Integer semplestBiddingBudgetMultFactor)
	{
		SemplestBiddingBudgetMultFactor = semplestBiddingBudgetMultFactor;
	}
	public Float getSemplestBiddingInitialBidBoostFactor()
	{
		return SemplestBiddingInitialBidBoostFactor;
	}
	public void setSemplestBiddingInitialBidBoostFactor(Float semplestBiddingInitialBidBoostFactor)
	{
		SemplestBiddingInitialBidBoostFactor = semplestBiddingInitialBidBoostFactor;
	}
	public Integer getSemplestBiddingPercentileValue()
	{
		return SemplestBiddingPercentileValue;
	}
	public void setSemplestBiddingPercentileValue(Integer semplestBiddingPercentileValue)
	{
		SemplestBiddingPercentileValue = semplestBiddingPercentileValue;
	}
	public Float getSemplestBiddingMarginFactor()
	{
		return SemplestBiddingMarginFactor;
	}
	public void setSemplestBiddingMarginFactor(Float semplestBiddingMarginFactor)
	{
		SemplestBiddingMarginFactor = semplestBiddingMarginFactor;
	}
	public Integer getBiddingServiceTargetPosition()
	{
		return BiddingServiceTargetPosition;
	}
	public void setBiddingServiceTargetPosition(Integer biddingServiceTargetPosition)
	{
		BiddingServiceTargetPosition = biddingServiceTargetPosition;
	}
	public Double getBiddingServiceBidMultiplierForGoogleFromMSNHistory()
	{
		return BiddingServiceBidMultiplierForGoogleFromMSNHistory;
	}
	public void setBiddingServiceBidMultiplierForGoogleFromMSNHistory(Double biddingServiceBidMultiplierForGoogleFromMSNHistory)
	{
		BiddingServiceBidMultiplierForGoogleFromMSNHistory = biddingServiceBidMultiplierForGoogleFromMSNHistory;
	}
	public Integer getBiddingServiceGoogleVolMultiplierFromMSNHistory()
	{
		return BiddingServiceGoogleVolMultiplierFromMSNHistory;
	}
	public void setBiddingServiceGoogleVolMultiplierFromMSNHistory(Integer biddingServiceGoogleVolMultiplierFromMSNHistory)
	{
		BiddingServiceGoogleVolMultiplierFromMSNHistory = biddingServiceGoogleVolMultiplierFromMSNHistory;
	}

}
