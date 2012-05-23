package semplest.server.protocol.google;

import com.google.api.adwords.v201109.cm.Keyword;


public class KeywordToolStats {
	
	Keyword kw;
	Long averageMonthlySearches;
	Double competition;
	
	
	public KeywordToolStats(Keyword kw, Long averageMonthlySearches, Double competition) {
		this.kw = kw;
		this.averageMonthlySearches = averageMonthlySearches;
		this.competition = competition;
	}


	public Keyword getKw() {
		return kw;
	}


	public void setKw(Keyword kw) {
		this.kw = kw;
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



