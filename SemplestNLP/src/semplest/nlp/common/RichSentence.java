package semplest.nlp.common;

import java.util.Arrays;

public class RichSentence {
	

	private String sentence;
	private String [] tokens;
	private String [] tags;
	private String [] chunks;
	
	
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String[] getTokens() {
		return tokens;
	}
	public void setTokens(String[] tokens) {
		this.tokens = tokens;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public String[] getChunks() {
		return chunks;
	}
	public void setChunks(String[] chunks) {
		this.chunks = chunks;
	}
	
	public boolean isConsistent(){
		if(tokens==null || tags == null || chunks == null){
			return false;
		}
		int len = tokens.length;
		if((tags.length!=len) || (chunks.length!=len)){
			return false;
		} else {
			return true;
		}
	}
	@Override
	public String toString() {
		return "RichSentence [sentence=" + sentence + ", tokens="
				+ Arrays.toString(tokens) + ", tags=" + Arrays.toString(tags)
				+ ", chunks=" + Arrays.toString(chunks) + "]";
	}
	
	

}
