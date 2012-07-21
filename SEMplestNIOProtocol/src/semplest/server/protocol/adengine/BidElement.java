package semplest.server.protocol.adengine;

import java.util.Date;

public class BidElement
{
	private Long keywordAdEngineID;
	private String keyword;
	private Long microBidAmount;
	private String matchType;
	private String competitionType;
	private Date startDate;
	private Date endDate;
	private Boolean isDefaultValue;
	private Boolean isActive;
	private Boolean isNegative;
	
	public BidElement() {
		// do nothing!!
	}
	
	public BidElement(String keyword, Long keywordAdEngineID, Long microBidAmount, 
			String matchType, String competitiveType, Boolean isDefaultValue, 
			Boolean isActive, Boolean isNegative){ // leaving the Date fields out of the constructor
		this.keyword = keyword;
		this.keywordAdEngineID = keywordAdEngineID;
		this.microBidAmount = microBidAmount;
		this.matchType = matchType;
		this.competitionType = competitiveType;
		this.isDefaultValue = isDefaultValue;
		this.isNegative = isNegative;
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

	public Boolean getIsNegative()
	{
		return isNegative;
	}

	public void setIsNegative(Boolean isNegative)
	{
		this.isNegative = isNegative;
	}

	public String getCompetitionType()
	{
		return competitionType;
	}

	public void setCompetitionType(String competitionType)
	{
		this.competitionType = competitionType;
	}

	@Override
	public String toString() {
		return "BidElement [keywordAdEngineID=" + keywordAdEngineID
				+ ", keyword=" + keyword + ", microBidAmount=" + microBidAmount
				+ ", matchType=" + matchType + ", competitionType="
				+ competitionType + ", startDate=" + startDate + ", endDate="
				+ endDate + ", isDefaultValue=" + isDefaultValue
				+ ", isActive=" + isActive + ", isNegative=" + isNegative + "]";
	}
	
	

}
