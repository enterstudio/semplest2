package semplest.server.protocol.google;

public class GoogleBidObject
{

	private Long bidID;
	private String keyword;
	private Long microBidAmount;
	private String approvalStatus;
	private String matchType;
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
	
}
