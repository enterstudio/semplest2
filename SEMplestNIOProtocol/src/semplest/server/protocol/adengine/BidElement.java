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
	private Date endDate;
	private Boolean isDefaultValue;
	private Boolean isActive;
	
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
	public Boolean getIsDefaultValue()
	{
		return isDefaultValue;
	}
	public void setIsDefaultValue(Boolean isDefaultValue)
	{
		this.isDefaultValue = isDefaultValue;
	}
	public Boolean getIsActive()
	{
		return isActive;
	}
	public void setIsActive(Boolean isActive)
	{
		this.isActive = isActive;
	}
	public Date getEndDate()
	{
		return endDate;
	}
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

}
