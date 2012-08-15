package semplest.nlp;

import java.util.List;



public interface SemplestNLP {
	

	public String[] splitIntoSentences(String text);

	public List<String> getNounBlocksFromSentence(String sentence);

	public List<List<String>> getNounBlocksFromText(String text);

	public List<String> getNounBlocksFromSentence(String sentence, int minLength);

	public List<List<String>> getNounBlocksFromText(String text, int minLength);

}
