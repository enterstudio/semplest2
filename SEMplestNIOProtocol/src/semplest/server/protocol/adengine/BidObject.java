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
	private Boolean IsEligibleForShowing = true;
	private Boolean isNegative = false;
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
	
	public Boolean isNegative()
	{
		return isNegative;
	}
	public void setNegative(Boolean isNegative)
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
	public Boolean isIsEligibleForShowing()
	{
		return IsEligibleForShowing;
	}
	public void setIsEligibleForShowing(Boolean isEligibleForShowing)
	{
		IsEligibleForShowing = isEligibleForShowing;
	}
	
}
