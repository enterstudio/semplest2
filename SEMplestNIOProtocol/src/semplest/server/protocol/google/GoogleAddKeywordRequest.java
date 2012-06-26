package semplest.server.protocol.google;

import com.google.api.adwords.v201109.cm.KeywordMatchType;

public class GoogleAddKeywordRequest
{
	private final String keyword;
	private final KeywordMatchType matchType;
	private final Long microBidAmount;
	
	public GoogleAddKeywordRequest(String keyword, KeywordMatchType matchType, Long microBidAmount)
	{
		this.keyword = keyword;
		this.matchType = matchType;
		this.microBidAmount = microBidAmount;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public KeywordMatchType getMatchType()
	{
		return matchType;
	}

	public Long getMicroBidAmount()
	{
		return microBidAmount;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((matchType == null) ? 0 : matchType.hashCode());
		result = prime * result + ((microBidAmount == null) ? 0 : microBidAmount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoogleAddKeywordRequest other = (GoogleAddKeywordRequest) obj;		
		if (keyword == null)
		{
			if (other.keyword != null)
				return false;
		}
		else if (!keyword.equals(other.keyword))
			return false;
		if (matchType == null)
		{
			if (other.matchType != null)
				return false;
		}
		else if (!matchType.equals(other.matchType))
			return false;
		if (microBidAmount == null)
		{
			if (other.microBidAmount != null)
				return false;
		}
		else if (!microBidAmount.equals(other.microBidAmount))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GoogleAddKeywordRequest [keyword=" + keyword + ", matchType=" + matchType
				+ ", microBidAmount=" + microBidAmount + "]";
	}
	
	
}
