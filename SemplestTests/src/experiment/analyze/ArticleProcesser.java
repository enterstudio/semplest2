package experiment.analyze;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ArticleProcesser {
	
	private final String seperators = " |\\.|\\,|\\(|\\)|\\[|\\]|\\\"|\\'";	
	private final Integer maxWordsOfPhrase = 5;
	private Double weightOfProbability = 0.3;
	private Double weightOfFlexibility = 0.7;
	
	public static void main(String[] args){
		ArticleProcesser ap = new ArticleProcesser();
		
		String targetFile = "c:\\temp\\sample1.txt";
		String baseFile = "c:\\temp\\sample2.txt";
		//String targetFile = "/semplest/nan/sample1.txt";
		//String baseFile = "/semplest/nan/sample2.txt";
		
		ap.ProcessArticle(targetFile, baseFile);
		
	}
	
	public void ProcessArticle(String targetFile, String baseFile){
		ArrayList<String> listOfWords = ReadFile(targetFile);
		Set<String> listOfGeneralWords = GetGeneralWords(baseFile);
		ArrayList<String> listOfFilteredWords = GetFilteredWordList(listOfWords, listOfGeneralWords);
		HashMap<String,Double> probOfAllWords = FrequencyOfWords(listOfFilteredWords);		
		ArrayList<String> listOfPhrases = GeneratePhrases(listOfFilteredWords);
		HashMap<String,Double> freqOfPhrases = FrequencyOfPhrases(listOfPhrases, probOfAllWords);		
		HashMap<String,Double> flexOfPhrases = FlexibilityOfPhrases(listOfWords, listOfPhrases);		
		ArrayList<String> rankedPhrases = RankPhrases(listOfPhrases, freqOfPhrases, flexOfPhrases);
		for(String s : rankedPhrases){
			System.out.println(s);
		}
	}
	
	public ArrayList<String> RankPhrases(ArrayList<String> listOfPhrases, HashMap<String,Double> frequencyOfPhrases, HashMap<String,Double> flexibilityOfPhrases){
		HashMap<String,Double> scoreMap = new HashMap<String,Double>();
		for(String phrase : listOfPhrases){
			Double prob = frequencyOfPhrases.get(phrase);
			Double flex = flexibilityOfPhrases.get(phrase);
			Double score = (prob * weightOfProbability + flex * weightOfFlexibility) * 10000;
			scoreMap.put(phrase, score);
		}
		TreeMap<String, Double> rankedMap = SortMap(scoreMap);		
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(rankedMap.descendingKeySet());
		return ret;
	}
	
	public HashMap<String,Double> FlexibilityOfPhrases(ArrayList<String> listOfWords, ArrayList<String> listOfPhrases){
		HashMap<String,FlexibilityOfWord> flexOfPhrases = new HashMap<String,FlexibilityOfWord>();
		
		for(String phrase : listOfPhrases){
			String[] words = phrase.split(" ");
			for(int i = 0; i < listOfWords.size(); i++){
				int count = 0;
				//find the long tail word in the entire article
				for(int ptr = 0; ptr < words.length; ptr ++){
					int current = i + ptr;
					if(listOfWords.get(current).equalsIgnoreCase(words[ptr])){
						count++;
					}
					else{
						break;
					}
				}
				if(count == words.length){
					//we found one, now calculate the left flexibility and the right flexibility					
					FlexibilityOfWord flex;
					if(flexOfPhrases.containsKey(phrase)){
						flex = flexOfPhrases.get(phrase);
					}
					else{
						flex = new FlexibilityOfWord();
					}
					int ptrToTheLeftWord = i - 1;
					int ptrToTheRightWord = i + count + 1;
					if(ptrToTheLeftWord >= 0){
						String leftWord = listOfWords.get(ptrToTheLeftWord);
						flex.addLeft(leftWord);
					}
					if(ptrToTheRightWord < listOfWords.size()){
						String rightWord = listOfWords.get(ptrToTheRightWord);
						flex.addRight(rightWord);
					}
					flexOfPhrases.put(phrase, flex);
				}
			}
		}
		
		//process the map
		HashMap<String,Double> finalFlexMap = new HashMap<String,Double>();
		for(String longTailWord : flexOfPhrases.keySet()){
			Double flexVal = flexOfPhrases.get(longTailWord).getFlexibility() / listOfWords.size();
			finalFlexMap.put(longTailWord, flexVal);
		}
		return finalFlexMap;
	}
	
	public HashMap<String,Double> FrequencyOfPhrases(ArrayList<String> listOfPhrases, HashMap<String,Double> probabilityOfAllWords){
		HashMap<String,Double> freqOfPhrases = new HashMap<String,Double>();
		for(String phrase : listOfPhrases){
			String[] words = phrase.trim().split(" ");
			Double probabilityOfPhrase = 1d;
			for(String word : words){
				Double probabilityOfWord = probabilityOfAllWords.get(word);				
				probabilityOfPhrase = probabilityOfPhrase * probabilityOfWord;				
			}
			freqOfPhrases.put(phrase, probabilityOfPhrase);
		}
		return freqOfPhrases;
	}
	
	public ArrayList<String> GeneratePhrases(ArrayList<String> listOfWords){
		ArrayList<String> phrases = new ArrayList<String>();
		for(int i = 0 ; i < listOfWords.size(); i++){
			if(!listOfWords.get(i).isEmpty()){
				//use it as a start point to form a phrase
				String phrase = "";
				int count = 0;
				for(int ptr = 0 ; ptr < maxWordsOfPhrase; ptr++){
					int current = i + ptr;
					if(current > listOfWords.size() - 1){
						//out of the array
						break;
					}
					if(!listOfWords.get(current).isEmpty()){
						phrase = phrase + " " + listOfWords.get(current);
					}
					else{
						break;
					}
					count++;
				}
				if(count > 1){
					phrases.add(phrase.trim());
				}
			}
		}		
		return phrases;
	}
	
	public ArrayList<String> GetFilteredWordList(ArrayList<String> listOfWords, Set<String> generalWords){
		ArrayList<String> newListOfWords = new ArrayList<String>();
		newListOfWords.addAll(listOfWords);
		for(int i = 0; i < newListOfWords.size(); i++){
			for(String generalWord : generalWords){
				if(newListOfWords.get(i).equalsIgnoreCase(generalWord)){
					newListOfWords.set(i, "");
					break;
				}				
			}
		}
		
		return newListOfWords;
	}
	
	public Set<String> GetGeneralWords(String path){
		ArrayList<String> listOfWords = ReadFile(path);
		HashMap<String,Double> probOfWords = FrequencyOfWords(listOfWords);
		TreeMap<String,Double> sortedMap = SortMap(probOfWords);
		return sortedMap.descendingKeySet();
	}
	
	public HashMap<String,Double> FrequencyOfWords(ArrayList<String> listOfWords){
		HashMap<String,Double> freqOfWords = new HashMap<String,Double>();
		
		HashMap<String,Integer> countOfWords = CountsOfWords(listOfWords);
				
		Integer totalCounts = 0;
		for(String word : countOfWords.keySet()){
			totalCounts = totalCounts + countOfWords.get(word);
		}
		
		for(String word : countOfWords.keySet()){
			Double frequency = (countOfWords.get(word) * 1.0) / totalCounts;
			freqOfWords.put(word, frequency);
		};
		
		return freqOfWords;
	}
	
	public TreeMap<String,Double> SortMap(HashMap<String,Double> map){
		ValueComparator bvc =  new ValueComparator(map);
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
        sorted_map.putAll(map);
        return sorted_map;
	}
	
	public ArrayList<String> ReadFile(String path){
		ArrayList<String> singleWords = new ArrayList<String>();
		try{
			FileInputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				String[] words = strLine.split(seperators);
				for(String s : words){
					singleWords.add(s.toLowerCase());
				}
			}
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return singleWords;
	}
	
	public HashMap<String,Integer> CountsOfWords(ArrayList<String> listOfWords){
		HashMap<String,Integer> countsOfWords = new HashMap<String,Integer>();
		for(String word : listOfWords){			
			if(!word.isEmpty()){
				Integer count = 1;
				if(countsOfWords.containsKey(word)){
					count = countsOfWords.get(word) + 1;				
				}
				countsOfWords.put(word, count);
			}
		}
		return countsOfWords;
	}
	
	
	private class ValueComparator implements Comparator<String> {

	    Map<String, Double> base;
	    public ValueComparator(Map<String, Double> base) {
	        this.base = base;
	    }

	    public int compare(String a, String b) {
	        return base.get(a).compareTo(base.get(b));
	    }
	}
	
	private class FlexibilityOfWord{
		private Set<String> Left;
		private Set<String> Right;
		private Double Flexibility;
		public FlexibilityOfWord(){
			Left = new HashSet<String>();
			Right = new HashSet<String>();
		}
		public Set<String> getLeft() {
			return Left;
		}
		public void addLeft(String word) {
			Left.add(word);
		}
		public Set<String> getRight() {
			return Right;
		}
		public void addRight(String word) {
			Right.add(word);
		}
		public Integer getLeftCount() {
			return Left.size();
		}		
		public Integer getRightCount() {
			return Right.size();
		}
		public Double getFlexibility() {
			return (Left.size() + Right.size()) * 1d;
		}
	}
	
}
