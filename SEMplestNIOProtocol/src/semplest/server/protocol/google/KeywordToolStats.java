package semplest.server.protocol.google;

import semplest.server.keyword.KeywordMatchingType;


public class KeywordToolStats {
	
	//Keyword kw;
	String keyword;
	KeywordMatchingType matchType;
	Long averageMonthlySearches;
	Double competition;
	
	
	public KeywordToolStats(String keyword,	KeywordMatchingType matchType, Long averageMonthlySearches, Double competition) {
		this.keyword = keyword;
		this.matchType = matchType;
		this.averageMonthlySearches = averageMonthlySearches;
		this.competition = competition;
	}


	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public KeywordMatchingType getMatchType() {
		return matchType;
	}

	public void setMatchType(KeywordMatchingType matchType) {
		this.matchType = matchType;
	}

	public Long getAverageMonthlySearches() {
		return averageMonthlySearches;
	}


	public void setAverageMonthlySearches(Long averageMonthlySearches) {
		this.averageMonthlySearches = averageMonthlySearches;
	}


	public Double getCompetition() {
		return competition;
	}


	public void setCompetition(Double competition) {
		this.competition = competition;
	}
	
	
	
}



