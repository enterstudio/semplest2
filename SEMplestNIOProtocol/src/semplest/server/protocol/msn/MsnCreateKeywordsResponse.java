package semplest.server.protocol.msn;

import java.util.Map;

public class MsnCreateKeywordsResponse
{
	final Map<String, Long> keywordToMsnIdMap;
	private final Map<Integer, String> filteredOutKeywordPkToCommentMap;
	
	public MsnCreateKeywordsResponse(Map<String, Long> keywordToMsnIdMap, Map<Integer, String> filteredOutKeywordPkToCommentMap)
	{
		this.keywordToMsnIdMap = keywordToMsnIdMap;
		this.filteredOutKeywordPkToCommentMap = filteredOutKeywordPkToCommentMap;
	}

	public Map<String, Long> getKeywordToMsnIdMap()
	{
		return keywordToMsnIdMap;
	}

	public Map<Integer, String> getFilteredOutKeywordPkToCommentMap()
	{
		return filteredOutKeywordPkToCommentMap;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filteredOutKeywordPkToCommentMap == null) ? 0 : filteredOutKeywordPkToCommentMap.hashCode());
		result = prime * result + ((keywordToMsnIdMap == null) ? 0 : keywordToMsnIdMap.hashCode());
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
		MsnCreateKeywordsResponse other = (MsnCreateKeywordsResponse) obj;
		if (filteredOutKeywordPkToCommentMap == null)
		{
			if (other.filteredOutKeywordPkToCommentMap != null)
				return false;
		}
		else if (!filteredOutKeywordPkToCommentMap.equals(other.filteredOutKeywordPkToCommentMap))
			return false;
		if (keywordToMsnIdMap == null)
		{
			if (other.keywordToMsnIdMap != null)
				return false;
		}
		else if (!keywordToMsnIdMap.equals(other.keywordToMsnIdMap))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "MsnCreateKeywordsResponse [keywordToMsnIdMap=" + keywordToMsnIdMap + ", filteredOutKeywordPkToCommentMap="
				+ filteredOutKeywordPkToCommentMap + "]";
	}
	
}
