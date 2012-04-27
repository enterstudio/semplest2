package semplest.server.keyword;

import semplest.other.F;



public class MasterKeyword{
	
	
	private Long id;
	
	private Integer version;
	
	
	private String word;
	
	MasterKeyword() {
		// for hibernate
	}
	
	public MasterKeyword(String word) {
		this.word = word;
	}
	
	public Long getId() {
		return id;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public String getWord() {
		return word;
	}
	
	@Override
	public String toString() {
		return "MasterKeyword [id=" + id + ", version=" + version + ", word=" + word + "]";
	}
	
	public String getKeywordString() {
		return word;
	}
	
	public static MasterKeyword.MasterKeywordAsString asString() {
		return new MasterKeywordAsString();
	}
	
	public static final class MasterKeywordAsString implements F<MasterKeyword, String> {
		@Override
		public String apply(MasterKeyword a) {
			return a.getKeywordString();
		}
	}
	
	public Keyword getKeyword() {
		return new Keyword(word);
	}
}
