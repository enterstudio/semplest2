package semplest.server.protocol.adengine;

import java.util.Date;

public class BidElement
{
	private Long keywordAdEngineID;
	private String keyword;
	private Long microBidAmount;
	private String matchType;
	private String competitiveType;
	private Date startDate;
	
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
	
	public Long getKeywordAdEngineID()
	{
		return keywordAdEngineID;
	}
	public void setKeywordAdEngineID(Long keywordAdEngineID)
	{
		this.keywordAdEngineID = keywordAdEngineID;
	}
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

}
