package semplest.server.protocol.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GoogleRelatedKeywordObject
{
	
	
	private String url = null;
	private String keywordSeed;
	//Keyword-->MatchType(competition, aveMonthlySearch)
	private HashMap<String, HashMap<String,MatchTypeData>> keywordMatchTypeMap = new HashMap<String, HashMap<String,MatchTypeData>>();
	
	public GoogleRelatedKeywordObject(String keywordSeed, String url)
	{
		this.keywordSeed = keywordSeed;
		this.url = url;
		
	}
	public void addKeywordData(String keyword, String matchType, Long aveMonthlySearch,Double competitionScore)
	{
		if (!keywordMatchTypeMap.containsKey(keyword))
		{
			MatchTypeData data = new MatchTypeData(aveMonthlySearch, competitionScore);
			HashMap<String,MatchTypeData> matchMap = new  HashMap<String,MatchTypeData>();
			matchMap.put(matchType, data);
			keywordMatchTypeMap.put(keyword, matchMap);
		}
		else //already exists
		{
			HashMap<String,MatchTypeData> matchMap = keywordMatchTypeMap.get(keyword);
			if (!matchMap.containsKey(matchType))
			{
				MatchTypeData data = new MatchTypeData(aveMonthlySearch, competitionScore);
				matchMap.put(matchType, data);
			}
		}
	}
	
	public Double getCompetionScore(String keyword, String matchType) throws Exception
	{
		if (!keywordMatchTypeMap.containsKey(keyword))
		{
			throw new Exception("Keyword: " + keyword + " not found");
		}
		else
		{
			HashMap<String,MatchTypeData> matchMap = keywordMatchTypeMap.get(keyword);
			if (!matchMap.containsKey(matchType))
			{
				throw new Exception("Match Type: " + matchType + " for keyword: " + keyword + " not found");
			}
			else
				
			{
				MatchTypeData data = matchMap.get(matchType);
				return data.getCompetitionScore();
			}
		}
	}
	
	public Long getAverageMonthlySearch(String keyword, String matchType) throws Exception
	{
		if (!keywordMatchTypeMap.containsKey(keyword))
		{
			throw new Exception("Keyword: " + keyword + " not found");
		}
		else
		{
			HashMap<String,MatchTypeData> matchMap = keywordMatchTypeMap.get(keyword);
			if (!matchMap.containsKey(matchType))
			{
				throw new Exception("Match Type: " + matchType + " for keyword: " + keyword + " not found");
			}
			else
				
			{
				MatchTypeData data = matchMap.get(matchType);
				return data.getAveMonthlySearch();
			}
		}
	}
	
	public ArrayList<String> getKeywords()
	{
		if (keywordMatchTypeMap.size() > 0)
		{
			ArrayList<String> res = new ArrayList<String>(); 
			Iterator<String> it = keywordMatchTypeMap.keySet().iterator();
			while(it.hasNext())
			{
				res.add(it.next());
			}
			return res;
		}
		else
		{
			return null;
		}
	}
	public ArrayList<String> getMatchTypesForKeyword(String keyword) throws Exception
	{
		if (!keywordMatchTypeMap.containsKey(keyword))
		{
			throw new Exception("Keyword: " + keyword + " not found");
		}
		else
		{
			HashMap<String,MatchTypeData> matchMap = keywordMatchTypeMap.get(keyword);
			ArrayList<String> res = new ArrayList<String>(); 
			Iterator<String> it = matchMap.keySet().iterator();
			while(it.hasNext())
			{
				res.add(it.next());
			}
			return res;
		}
	}
	
	private class MatchTypeData
	{
		public MatchTypeData(Long aveMonthlySearch,Double competitionScore)
		{
			this.aveMonthlySearch = aveMonthlySearch;
			this.competitionScore = competitionScore;
			
		}
		private Long aveMonthlySearch;
		private Double competitionScore;
		
		public Double getCompetitionScore()
		{
			return competitionScore;
		}
		public void setCompetitionScore(Double competitionScore)
		{
			this.competitionScore = competitionScore;
		}
		public Long getAveMonthlySearch()
		{
			return aveMonthlySearch;
		}
		public void setAveMonthlySearch(Long aveMonthlySearch)
		{
			this.aveMonthlySearch = aveMonthlySearch;
		}
		
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getKeywordSeed()
	{
		return keywordSeed;
	}

	public void setKeywordSeed(String keywordSeed)
	{
		this.keywordSeed = keywordSeed;
	}

}
