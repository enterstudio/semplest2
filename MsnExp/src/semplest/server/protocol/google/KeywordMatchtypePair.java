package semplest.server.protocol.google;

import com.google.api.adwords.v201109.cm.KeywordMatchType;

public class KeywordMatchtypePair {
	
	String keyword;
	KeywordMatchType matchType;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public KeywordMatchType getMatchType() {
		return matchType;
	}

	public void setMatchType(KeywordMatchType matchType) {
		this.matchType = matchType;
	}
	
	public KeywordMatchtypePair(String keyword, KeywordMatchType matchType){
		this.keyword = keyword;
		this.matchType = matchType;
	}
	

}
