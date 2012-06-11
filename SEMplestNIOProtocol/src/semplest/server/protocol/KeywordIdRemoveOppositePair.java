package semplest.server.protocol;

public class KeywordIdRemoveOppositePair
{
	private final Integer keywordId;
	private final Boolean removeOpposite;
	
	public KeywordIdRemoveOppositePair(Integer keywordId, Boolean removeOpposite)
	{
		this.keywordId = keywordId;
		this.removeOpposite = removeOpposite;
	}

	public Integer getKeywordId()
	{
		return keywordId;
	}

	public Boolean getRemoveOpposite()
	{
		return removeOpposite;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keywordId == null) ? 0 : keywordId.hashCode());
		result = prime * result + ((removeOpposite == null) ? 0 : removeOpposite.hashCode());
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
		KeywordIdRemoveOppositePair other = (KeywordIdRemoveOppositePair) obj;
		if (keywordId == null)
		{
			if (other.keywordId != null)
				return false;
		}
		else if (!keywordId.equals(other.keywordId))
			return false;
		if (removeOpposite == null)
		{
			if (other.removeOpposite != null)
				return false;
		}
		else if (!removeOpposite.equals(other.removeOpposite))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "KeywordIdRemoveOppositePair [keywordId=" + keywordId + ", removeOpposite=" + removeOpposite + "]";
	}
	
}
