package semplest.ml.interfaces;

import java.util.List;

public interface TextAnalyzer {
	
	public List<String> getTokens(String text);
	public List<String> getStemmedTokens(String text);

}
