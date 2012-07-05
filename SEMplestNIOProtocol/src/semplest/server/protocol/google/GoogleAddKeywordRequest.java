package semplest.server.protocol.google;

import com.google.api.adwords.v201109.cm.KeywordMatchType;

public class GoogleAddKeywordRequest
{
	private final String keyword;
	private final Integer keywordPK;
	private final KeywordMatchType matchType;
	private final Long microBidAmount;
	private String comment;
	
	public GoogleAddKeywordRequest(String keyword, Integer keywordPK, KeywordMatchType matchType, Long microBidAmount)
	{
		this(keyword, keywordPK, matchType, microBidAmount, null);
	}
	
	public GoogleAddKeywordRequest(String keyword, Integer keywordPK, KeywordMatchType matchType, Long microBidAmount, String comment)
	{
		this.keyword = keyword;
		this.keywordPK = keywordPK;
		this.matchType = matchType;
		this.microBidAmount = microBidAmount;
		this.comment = comment;
	}
	
	public Integer getKeywordPK()
	{
		return keywordPK;
	}

	public String getKeyword()
	{
		return keyword;
	}
	
	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public KeywordMatchType getMatchType()
	{
		return matchType;
	}

	public Long getMicroBidAmount()
	{
		return microBidAmount;
	}

	public String getComment()
	{
		return comment;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		result = prime * result + ((keywordPK == null) ? 0 : keywordPK.hashCode());
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
		if (comment == null)
		{
			if (other.comment != null)
				return false;
		}
		else if (!comment.equals(other.comment))
			return false;
		if (keyword == null)
		{
			if (other.keyword != null)
				return false;
		}
		else if (!keyword.equals(other.keyword))
			return false;
		if (keywordPK == null)
		{
			if (other.keywordPK != null)
				return false;
		}
		else if (!keywordPK.equals(other.keywordPK))
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
		return "GoogleAddKeywordRequest [keyword=" + keyword + ", keywordPK=" + keywordPK + ", matchType=" + matchType + ", microBidAmount="
				+ microBidAmount + ", comment=" + comment + "]";
	}

	
	
}
