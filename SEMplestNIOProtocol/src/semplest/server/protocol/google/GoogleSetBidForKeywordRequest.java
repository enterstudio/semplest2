package semplest.server.protocol.google;

public class GoogleSetBidForKeywordRequest
{
	private final Long adGroupID;
	private final String word;
	private final Long keywordID;
	private final Long microBidAmount;
	
	public GoogleSetBidForKeywordRequest(Long adGroupID, String word, Long keywordID, Long microBidAmount)
	{
		this.adGroupID = adGroupID;
		this.word = word;
		this.keywordID = keywordID;
		this.microBidAmount = microBidAmount;
	}

	public Long getAdGroupID()
	{
		return adGroupID;
	}

	public String getWord()
	{
		return word;
	}

	public Long getKeywordID()
	{
		return keywordID;
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
		result = prime * result + ((adGroupID == null) ? 0 : adGroupID.hashCode());
		result = prime * result + ((keywordID == null) ? 0 : keywordID.hashCode());
		result = prime * result + ((microBidAmount == null) ? 0 : microBidAmount.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		GoogleSetBidForKeywordRequest other = (GoogleSetBidForKeywordRequest) obj;		
		if (adGroupID == null)
		{
			if (other.adGroupID != null)
				return false;
		}
		else if (!adGroupID.equals(other.adGroupID))
			return false;
		if (keywordID == null)
		{
			if (other.keywordID != null)
				return false;
		}
		else if (!keywordID.equals(other.keywordID))
			return false;
		if (microBidAmount == null)
		{
			if (other.microBidAmount != null)
				return false;
		}
		else if (!microBidAmount.equals(other.microBidAmount))
			return false;
		if (word == null)
		{
			if (other.word != null)
				return false;
		}
		else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "GoogleSetBidForKeywordRequest [adGroupID=" + adGroupID + ", word=" + word + ", keywordID=" + keywordID
				+ ", microBidAmount=" + microBidAmount + "]";
	}
		
}
