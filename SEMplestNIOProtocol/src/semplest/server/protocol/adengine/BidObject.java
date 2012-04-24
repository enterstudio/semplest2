package semplest.server.protocol.adengine;

public class BidObject
{

	private Long bidID;
	private String keyword;
	private Long microBidAmount;
	private String approvalStatus;
	private String matchType;
	private Long firstPageCpc;
	private Integer qualityScore;
	private boolean IsEligibleForShowing = true;
	private boolean isNegative = false;
	private Double semplestProbability = -1.0;
	
	public Long getBidID()
	{
		return bidID;
	}
	public void setBidID(Long bidID)
	{
		this.bidID = bidID;
	}
	public String getKeyword()
	{
		return keyword;
	}
	public void setKeyword(String keyword)
	{
		this.keyword = keyword;
	}
	public Long getMicroBidAmount()
	{
		return microBidAmount;
	}
	public void setMicroBidAmount(Long microBidAmount)
	{
		this.microBidAmount = microBidAmount;
	}
	public String getApprovalStatus()
	{
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus)
	{
		this.approvalStatus = approvalStatus;
	}
	public String getMatchType()
	{
		return matchType;
	}
	public void setMatchType(String matchType)
	{
		this.matchType = matchType;
	}
	public Long getFirstPageCpc()
	{
		return firstPageCpc;
	}
	public void setFirstPageCpc(Long firstPageCpc)
	{
		this.firstPageCpc = firstPageCpc;
	}
	public Integer getQualityScore()
	{
		return qualityScore;
	}
	public void setQualityScore(Integer qualityScore)
	{
		this.qualityScore = qualityScore;
	}
	
	public boolean isNegative()
	{
		return isNegative;
	}
	public void setNegative(boolean isNegative)
	{
		this.isNegative = isNegative;
	}
	public Double getSemplestProbability()
	{
		return semplestProbability;
	}
	public void setSemplestProbability(Double semplestProbability)
	{
		this.semplestProbability = semplestProbability;
	}
	public boolean isIsEligibleForShowing()
	{
		return IsEligibleForShowing;
	}
	public void setIsEligibleForShowing(boolean isEligibleForShowing)
	{
		IsEligibleForShowing = isEligibleForShowing;
	}
	
}
