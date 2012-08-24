package experiment.analyze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ArticleProcesser {
	
	private final boolean useDmoz = true;
	private final boolean useStopList = true;
	private final String seperators = "\\W";
	private final Integer maxWordsOfPhrase = 5;
	private final Double weightOfFrequency = 0.5;
	private final Double weightOfFlexibility = 0.5;
	
	private final String stoplistFile = "c:\\temp\\stoplist.txt";
	
	public static void main(String[] args){
		ArticleProcesser ap = new ArticleProcesser();
		
		String category = "top/business/consumer_goods_and_services/home_and_garden/furniture/by_room_or_item/home_entertainment";
		
		String outputFile = "c:\\temp\\rank.txt";	
		
		String dmozFile = "C:\\temp\\samples\\business\\dmoz.8-12.1.1";
		String compareFile1 = "c:\\temp\\samples\\dmoz_health";
		String compareFile2 = "c:\\temp\\samples\\dmoz_science";
		
		String targetFile = ap.useDmoz ? dmozFile : compareFile1;
		String baseFile = ap.useStopList ? ap.stoplistFile : compareFile2;		
				
		TreeMap<String, Double> rankOfPhrases;
		try {
			rankOfPhrases = ap.ProcessArticle(targetFile, baseFile, category);
			ap.OutputReport(outputFile, rankOfPhrases);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public void OutputReport(String outputPath, TreeMap<String, Double> rankOfPhrases){		
		try{
			FileWriter fstream = new FileWriter(outputPath);
			BufferedWriter out = new BufferedWriter(fstream);
			
			out.write("Date - " + new Date());
			out.append("\n\n");
			
			for(String s : rankOfPhrases.descendingKeySet()){
				out.append(s + " : " + rankOfPhrases.get(s) + "\n");
			}			
			
			out.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public TreeMap<String, Double> ProcessContent(String input) throws Exception{
		ArrayList<String> listOfWords = ReadInContent(input);
		Set<String> listOfGeneralWords = GetStopListWords(stoplistFile);		
		ArrayList<String> listOfFilteredWords = GetFilteredWordList(listOfWords, listOfGeneralWords);
		HashMap<String,Double> probOfAllWords = FrequencyOfWords(listOfFilteredWords);		
		ArrayList<String> listOfPhrases = GeneratePhrases(listOfFilteredWords);
		HashMap<String,Double> freqOfPhrases = FrequencyOfPhrases(listOfPhrases, probOfAllWords);		
		HashMap<String,Double> flexOfPhrases = FlexibilityOfPhrases(listOfWords, listOfPhrases);		
		TreeMap<String, Double> rankedMap = RankPhrases(listOfPhrases, freqOfPhrases, flexOfPhrases);
		
		return rankedMap;
	}
	
	public TreeMap<String, Double> ProcessArticle(String targetFile, String baseFile, String category) throws Exception{
		ArrayList<String> listOfWords = useDmoz ? ReadDmozByCategory(targetFile, category) : ReadInFile(targetFile);
		Set<String> listOfGeneralWords = useStopList ? GetStopListWords(baseFile) : GetGeneralWords(baseFile);		
		ArrayList<String> listOfFilteredWords = GetFilteredWordList(listOfWords, listOfGeneralWords);
		HashMap<String,Double> probOfAllWords = FrequencyOfWords(listOfFilteredWords);		
		ArrayList<String> listOfPhrases = GeneratePhrases(listOfFilteredWords);
		HashMap<String,Double> freqOfPhrases = FrequencyOfPhrases(listOfPhrases, probOfAllWords);		
		HashMap<String,Double> flexOfPhrases = FlexibilityOfPhrases(listOfWords, listOfPhrases);		
		TreeMap<String, Double> rankedMap = RankPhrases(listOfPhrases, freqOfPhrases, flexOfPhrases);
		
		return rankedMap;
	}
	
	public TreeMap<String, Double> RankPhrases(ArrayList<String> listOfPhrases, HashMap<String,Double> frequencyOfPhrases, HashMap<String,Double> flexibilityOfPhrases) throws Exception{
		HashMap<String,Double> scoreMap = new HashMap<String,Double>();
		for(String phrase : listOfPhrases){
			Double prob = frequencyOfPhrases.get(phrase);
			Double flex = flexibilityOfPhrases.get(phrase);
			if(!(prob == null) && !(flex == null)){
				Double score = (prob * weightOfFrequency + flex * weightOfFlexibility) * 10000;
				scoreMap.put(phrase, score);
			}
		}
		TreeMap<String, Double> rankedMap = SortMap(scoreMap);		
		
		return rankedMap;
	}
	
	public HashMap<String,Double> FlexibilityOfPhrases(ArrayList<String> listOfWords, ArrayList<String> listOfPhrases) throws Exception{
		HashMap<String,FlexibilityOfWord> flexOfPhrases = new HashMap<String,FlexibilityOfWord>();
		
		for(String phrase : listOfPhrases){
			String[] words = phrase.split(" ");
			for(int i = 0; i < listOfWords.size(); i++){
				int count = 0;
				//find the long tail word in the entire article
				for(int ptr = 0; ptr < words.length; ptr ++){
					int current = i + ptr;
					if(current >= (listOfWords.size() - 1)){
						break;
					}
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
	
	public HashMap<String,Double> FrequencyOfPhrases(ArrayList<String> listOfPhrases, HashMap<String,Double> probabilityOfAllWords) throws Exception{
		HashMap<String,Double> freqOfPhrases = new HashMap<String,Double>();
		for(String phrase : listOfPhrases){
			String[] words = phrase.trim().split(" ");
			Double probabilityOfPhrase = 1d;
			for(String word : words){
				Double probabilityOfWord = probabilityOfAllWords.get(word);				
				double prob = probabilityOfPhrase.doubleValue();
				probabilityOfPhrase = prob * probabilityOfWord;	
				//probabilityOfPhrase = prob + Math.log(probabilityOfWord);
			}
			//freqOfPhrases.put(phrase, probabilityOfPhrase);
			freqOfPhrases.put(phrase, Math.log(probabilityOfPhrase)/words.length);
		}
		return freqOfPhrases;
	}
	
	public ArrayList<String> GeneratePhrases(ArrayList<String> listOfWords) throws Exception{
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
	
	public ArrayList<String> GetFilteredWordList(ArrayList<String> listOfWords, Set<String> generalWords) throws Exception{
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
	
	public Set<String> GetStopListWords(String path) throws Exception{
		Set<String> stopListWords = new HashSet<String>();
		
		FileInputStream fstream = new FileInputStream(path);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		while ((strLine = br.readLine()) != null)   {
			stopListWords.add(strLine.trim());
		}
		in.close();
		
		return stopListWords;
	}
	
	public HashMap<String,Double> FrequencyOfWords(ArrayList<String> listOfWords) throws Exception{
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
	
	public HashMap<String,Integer> CountsOfWords(ArrayList<String> listOfWords) throws Exception{
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
	
	public Set<String> GetGeneralWords(String path) throws Exception{
		ArrayList<String> listOfWords = ReadInFile(path);
		HashMap<String,Double> probOfWords = FrequencyOfWords(listOfWords);
		TreeMap<String,Double> sortedMap = SortMap(probOfWords);
		return sortedMap.descendingKeySet();
	}
	
	public TreeMap<String,Double> SortMap(HashMap<String,Double> map) throws Exception{
		ValueComparator bvc =  new ValueComparator(map);
        TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
        sorted_map.putAll(map);
        return sorted_map;
	}
	
	public ArrayList<String> ReadInContent(String content) throws Exception{
		ArrayList<String> singleWords = new ArrayList<String>();		
		
		String[] words = content.split(seperators);
		for(String s : words){
			singleWords.add(s.trim().toLowerCase());
		}		
		
		return singleWords;
	}
	
	public ArrayList<String> ReadInFile(String path) throws Exception{
		ArrayList<String> singleWords = new ArrayList<String>();
		
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
		
		return singleWords;
	}
	
	public ArrayList<String> ReadDmozByCategory(String path, String category) throws Exception{
		ArrayList<String> singleWords = new ArrayList<String>();
		
		FileInputStream fstream = new FileInputStream(path);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		int endIndex = 300;
		while ((strLine = br.readLine()) != null)   {
			endIndex = strLine.length() > endIndex ? endIndex : strLine.length();
			String ctgr = strLine.substring(0, endIndex).split(" ")[0];
			if(ctgr.equals(category.trim())){
				String[] words = strLine.split(seperators);
				for(String s : words){
					if (s.matches("[a-zA-Z]+$")) {
						singleWords.add(s.toLowerCase());
					}
					else{
						singleWords.add("");
					}
				}
			}				
		}
		in.close();
		
		return singleWords;
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
