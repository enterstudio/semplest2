package semplest.server.protocol.adengine;

public class BidElement
{
	private Long bidID;
	private String keyword;
	private Long microBidAmount;
	private String matchType;
	private String competitiveType;
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
	public String getMatchType()
	{
		return matchType;
	}
	public void setMatchType(String matchType)
	{
		this.matchType = matchType;
	}
	public String getCompetitiveType()
	{
		return competitiveType;
	}
	public void setCompetitiveType(String competitiveType)
	{
		this.competitiveType = competitiveType;
	}

}
