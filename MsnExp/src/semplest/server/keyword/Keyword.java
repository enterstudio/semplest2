package semplest.server.keyword;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

import semplest.other.F;
import semplest.other.F2;


public class Keyword implements Comparable<Keyword>, Serializable {
	private static final long serialVersionUID = 1L;
	@XmlAttribute
	private final String keyword;
	
	public Keyword() {
		//hibernate
		keyword = null;
	}
	
	public Keyword(String keyword) {
		this.keyword = keyword;
		if (keyword == null) {
			throw new RuntimeException("Null Keyword");
		}
	}
	
	public static Keyword asKeyword(String keyword) {
		return new Keyword(keyword);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Keyword)) {
			return false;
		}
		Keyword other = (Keyword) obj;
		if (keyword == null) {
			if (other.keyword != null) {
				return false;
			}
		} else if (!keyword.equals(other.keyword)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return keyword;
	}
	
	public String getKeywordString() {
		return keyword;
	}
	
	@Override
	public int compareTo(Keyword o) {
		return keyword.compareTo(o.getKeywordString());
	}
	
	public static F<Keyword, String> asString() {
		return new F<Keyword, String>() {
			
			@Override
			public String apply(Keyword a) {
				return a.getKeywordString();
			}
		};
	}
	
	public static F<String, Keyword> fromString() {
		return new F<String, Keyword>() {
			
			@Override
			public Keyword apply(String a) {
				return new Keyword(a);
			}
		};
	}
	public static F2<Keyword,Keyword,Boolean> keywordsAreEqual() {
		return new F2<Keyword,Keyword,Boolean>() {
			@Override
			public Boolean apply(Keyword a, Keyword b) {
				return a.keyword.equals(b.keyword);
			}
		};
	}
}
