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
	private final Integer maxLengthOfKeyword = 5;
	private final Double weightOfFlexibility = 1d;
	
	public static void main(String[] args){
		ArticleProcesser ap = new ArticleProcesser();
		
		String targetFile = "c:\\temp\\sample1.txt";
		String baseFile = "c:\\temp\\sample2.txt";
		
		ap.processArticle(targetFile, baseFile);
		
	}
	
	public void processArticle(String targetFile, String baseFile){
		ArrayList<String> listOfWords = readFile(targetFile);
		Set<String> generalWords = getGeneralWords(baseFile);
		ArrayList<String> filteredWords = getFilteredWordList(listOfWords, generalWords);
		HashMap<String,Double> probOfAllWords = calProbOfWords(filteredWords);		
		ArrayList<String> longTailWords = generateLongTailWords(filteredWords);
		HashMap<String,Double> probOfLongTailWords = calProbOfLongTailWords(longTailWords, probOfAllWords);		
		HashMap<String,Double> flexOfLongTailWords = calFlexOfLongTailWords(listOfWords, longTailWords);		
		ArrayList<String> rankedLongTailWords = rankLongTailWords(longTailWords, flexOfLongTailWords, flexOfLongTailWords);
		for(String s : rankedLongTailWords){
			System.out.println(s);
		}
	}
	
	public ArrayList<String> rankLongTailWords(ArrayList<String> longTailWords, HashMap<String,Double> probOfLongTailWords, HashMap<String,Double> flexOfLongTailWords){
		HashMap<String,Double> scoreMap = new HashMap<String,Double>();
		for(String word : longTailWords){
			Double prob = probOfLongTailWords.get(word);
			Double flex = flexOfLongTailWords.get(word);
			Double score = prob * flex;
			scoreMap.put(word, score);
		}
		TreeMap<String, Double> rankedMap = sortMap(scoreMap);
		ArrayList<String> ret = new ArrayList<String>();
		ret.addAll(rankedMap.descendingKeySet());
		return ret;
	}
	
	public HashMap<String,Double> calFlexOfLongTailWords(ArrayList<String> listOfWords, ArrayList<String> longTailWords){
		HashMap<String,FlexibilityOfWord> flexOfLongTailWords = new HashMap<String,FlexibilityOfWord>();
		
		for(String longTailWord : longTailWords){
			String[] words = longTailWord.split(" ");
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
					if(flexOfLongTailWords.containsKey(longTailWord)){
						flex = flexOfLongTailWords.get(longTailWord);
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
					flexOfLongTailWords.put(longTailWord, flex);
				}
			}
		}
		
		//process the map
		HashMap<String,Double> finalFlexMap = new HashMap<String,Double>();
		for(String longTailWord : flexOfLongTailWords.keySet()){
			Double flexVal = flexOfLongTailWords.get(longTailWord).getFlexibility();
			finalFlexMap.put(longTailWord, flexVal);
		}
		return finalFlexMap;
	}
	
	public HashMap<String,Double> calProbOfLongTailWords(ArrayList<String> longTailWords, HashMap<String,Double> probabilityOfAllWords){
		HashMap<String,Double> probOfLongTailWords = new HashMap<String,Double>();
		for(String longWord : longTailWords){
			String[] words = longWord.trim().split(" ");
			Double probabilityOfLongWord = 1d;
			for(String word : words){
				Double probabilityOfWord = probabilityOfAllWords.get(word);				
				probabilityOfLongWord = probabilityOfLongWord * probabilityOfWord;				
			}
			probOfLongTailWords.put(longWord, probabilityOfLongWord);
		}
		return probOfLongTailWords;
	}
	
	public ArrayList<String> generateLongTailWords(ArrayList<String> listOfWords){
		ArrayList<String> longTailWords = new ArrayList<String>();
		for(int i = 0 ; i < listOfWords.size(); i++){
			if(!listOfWords.get(i).isEmpty()){
				//use it as a start point to form word
				String longWord = "";
				int count = 0;
				for(int ptr = 0 ; ptr < maxLengthOfKeyword; ptr++){
					int current = i + ptr;
					if(current > listOfWords.size() - 1){
						//out of the array
						break;
					}
					if(!listOfWords.get(current).isEmpty()){
						longWord = longWord + " " + listOfWords.get(current);
					}
					else{
						break;
					}
					count++;
				}
				if(count > 1){
					longTailWords.add(longWord.trim());
				}
			}
		}		
		return longTailWords;
	}
	
	public ArrayList<String> getFilteredWordList(ArrayList<String> listOfWords, Set<String> generalWords){
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
	
	public Set<String> getGeneralWords(String path){
		ArrayList<String> listOfWords = readFile(path);
		HashMap<String,Double> probOfWords = calProbOfWords(listOfWords);
		TreeMap<String,Double> sortedMap = sortMap(probOfWords);
		return sortedMap.descendingKeySet();
	}
	
	public HashMap<String,Double> calProbOfWords(ArrayList<String> listOfWords){
		HashMap<String,Double> probOfWords = new HashMap<String,Double>();
		
		HashMap<String,Integer> countOfWords = calCountsOfWords(listOfWords);
				
		Integer totalCounts = 0;
		for(String word : countOfWords.keySet()){
			totalCounts = totalCounts + countOfWords.get(word);
		}
		
		for(String word : countOfWords.keySet()){
			Double probability = (countOfWords.get(word) * 1.0) / totalCounts;
			probOfWords.put(word, probability);
		}		
		
		return probOfWords;
	}
	
	public TreeMap<String,Double> sortMap(HashMap<String,Double> map){
		ValueComparator bvc =  new ValueComparator(map);
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
        sorted_map.putAll(map);
        return sorted_map;
	}
	
	public ArrayList<String> readFile(String path){
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
	
	public HashMap<String,Integer> calCountsOfWords(ArrayList<String> listOfWords){
		HashMap<String,Integer> countOfWords = new HashMap<String,Integer>();
		for(String word : listOfWords){			
			if(!word.isEmpty()){
				Integer count = 1;
				if(countOfWords.containsKey(word)){
					count = countOfWords.get(word) + 1;				
				}
				countOfWords.put(word, count);
			}
		}
		return countOfWords;
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
			return (Left.size() + Right.size()) * weightOfFlexibility;
		}
	}
	
}
