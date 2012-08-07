package semplest.keywords.lda;
/**
 * Production version of the Keyword Generation Server
 * For Crawl 2 were words are not stemmed. Other improvements added, such as google suggestions and keyword 
 * probability independent of number of words 
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.api.adwords.v201109.cm.ApiException;


import scala.actors.threadpool.Arrays;
import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.javautils.TextUtils;
import semplest.keywords.javautils.ValueComparator;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.lda.*;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolEnum.EmailType;
import semplest.server.protocol.adengine.AdEngineID;
import semplest.server.protocol.adengine.AdsObject;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.google.KeywordToolStats;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailServiceImpl;
import semplest.server.service.springjdbc.PromotionObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.GetAllPromotionDataSP;
import semplest.server.service.springjdbc.storedproc.GetKeywordForAdEngineSP;


import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;
import semplest.util.SemplestUtils;
import cc.mallet.types.InstanceList;

public class KWGenDmozLDAServer2 implements SemplestKeywordLDAServiceInterface{
	
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAServer2.class);
	//Search index for categories
	private static KWGenDmozLDAdata2 data;
	private static HashMap<String,Object> configData;
	SemplestMailServiceImpl mail;
	private static enum SearchEngine {
		Google, MSN;
		boolean equalsSE(SearchEngine e){
			return equalsSE(e.toString());
		}
		boolean equalsSE(String e){
			if(e.equalsIgnoreCase(this.toString()))
				return true;
			return false;
		}
	}
	public KWGenDmozLDAServer2(HashMap<String,Object> configDataIn) throws Exception {
		try{
			configData = configDataIn;
			mail = new SemplestMailServiceImpl();
			mail.initializeService(null);
		}catch(Exception e){
			logger.error(e.toString());
			throw e;
		}
	}
	
	//***************************************** Category Methods ***************************************************************
	
	@Override
	public ArrayList<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception {
		try{
			if(searchTerm!=null && searchTerm.length()>0) searchTerm = searchTerm.toLowerCase().replaceAll("\\p{Punct}", " ");
			if(description==null || description.length()<=0) throw new Exception("No description data provided");
			description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
			if(url!=null) url = TextUtils.formURL(url);
			ArrayList<String> categories = this.getCategories(description);
			return categories;
		}catch(Exception e){
			logger.error(e.toString());
			throw e;
		}
	}
	public ArrayList<String> getCategories(String searchTerm) throws Exception {
		//Get category results from dmoz query
		try{
			String qs="";
			String[] res;
			String categories;
			ArrayList<String> optList = new ArrayList<String>();
			ArrayList<String> optInitial = new ArrayList<String>();
			int numresults = 100; // Number of results from the query
			String qsStem = this.stemvString( searchTerm, data.dict );
			if(qsStem !=null && qsStem.length()>0){
				logger.debug(qsStem);
				res = data.dl.search(qsStem,numresults);
				for(int i=0; i<res.length; i++){
					categories = res[i].trim();
					if(catUtils.validcat(categories))
							optInitial.add(categories);
				}
				//Select repeated patterns
				optList= selectOptions(optInitial);
			}
			return optList;
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}

	private  ArrayList<String> selectOptions(ArrayList<String> optKeys) throws IOException{
		//Selects patterns from top categories list to generate options for the user based on pre-defined crieteria
		ArrayList<String> ret = new ArrayList<String>();
		//Top 5 results
		for(int i=0 ; i<Math.min(optKeys.size(),5); i++){
			ret.add(optKeys.get(i));
		}
		//Identify repeated patterns in top categories
	    HashMap<String,Double> catPatRepMap = idRepeatedCatPat(optKeys);
	    //Filter out just relevant patterns and add to result
	    ret.addAll(selectRelevantOpt(catPatRepMap));
	    return ret;
	    
	}
	
	private HashMap<String,Double> idRepeatedCatPat(ArrayList<String> optList){
		HashMap<String,Double> catRepMap = new HashMap<String,Double>();
		String  newoption;
	    String[] pair= new String[2];
	    for(int n=0; n<optList.size(); n++){
	    	for (int m=0; m<n;m++){
	    		pair[0]=optList.get(n); pair[1]=optList.get(m);
	    		newoption = catUtils.longestAncestor(pair);
	    		if(catRepMap.containsKey(newoption)){
	    			catRepMap.put(newoption, ((Double)catRepMap.get(newoption))+1.0);
	    		}else {
	    			catRepMap.put(newoption, new Double(1));
	    		}
	    	}
	    }
	    return catRepMap;
	}
	
	private ArrayList<String> selectRelevantOpt(HashMap<String,Double> catPatRepMap){
		Double numrepeat;
		int numNodes, numNEval=20;
		
	    HashMap<String,Double> optList= new HashMap<String,Double>();
	    for(String optKey:catPatRepMap.keySet()){
	    	numNodes = catUtils.nodes(optKey);
	    	numrepeat = catPatRepMap.get(optKey);
	    	if(numNodes>=4  && numrepeat >3){
	    		if(catUtils.last(optKey).length()>1){
		    		if(!optList.containsKey(catUtils.take(optKey, numNEval))){
		    			optList.put(catUtils.take(optKey, numNEval),new Double(numNodes));
		    		}
	    		}
	    	}
	    }
	    ValueComparator bvcAux2 = new ValueComparator(optList);
	  	TreeMap<String,Double> sorted_opt = new TreeMap<String,Double>(bvcAux2);
	    sorted_opt.putAll(optList);
	    
	    // Present sorted pattern from most detailed to most general
	    ArrayList<String> sortOptList = new ArrayList<String>();
	    for(String aux : sorted_opt.keySet()){
	    	sortOptList.add(aux);
	    }
	    return sortOptList;
	}
	
	
	//***************************************** Keyword Methods ***************************************************************
	
	@Override
	public KeywordProbabilityObject[] getKeywords(ArrayList<String> categories,String companyName,  String[] searchEngines,
			String productPromotion, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception {
		try{
			ArrayList<SearchEngine> srchE =  new ArrayList<SearchEngine>();
			if(productPromotion!=null && productPromotion.length()>=0) 
				productPromotion = productPromotion.toLowerCase().replaceAll("\\p{Punct}", " ");
			if(description==null || description.length()==0) throw new Exception("No description provided");
			description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
			//Check Search Engines and decide number of kw per Search Engine
			for(int i=0; i< searchEngines.length; i++){
				for (SearchEngine se : SearchEngine.values()){
					if(se.equalsSE(searchEngines[i]))
						srchE.add(se);
				}
				if(srchE.size()<1)
					throw new Exception(searchEngines[i]+ " not a valid Search Engine");
			}
			
			if(categories==null || categories.size()==0){
				throw new Exception("No categories provided");
			}
			if(nGrams==null || nGrams.length!=3){
				throw new Exception("Wrong number nGrams provided");
			} 
			
			//Weight data based on percentage
			String data1 = this.weightData(data.userInfoWeight, url, adds,companyName,productPromotion, description);
			String[] dataCount = data1.split("\\s+");
			if(dataCount.length<30) throw new Exception("Not enough data provided");
			
			String stemdata1 = this.stemvStringNoFilter( data1, data.dict );
			
			int numkw =0;
			for(SearchEngine se : srchE){
				if(se.equalsSE(SearchEngine.Google)){
					if(data.numKeywordsGoogle>numkw)
						numkw = data.numKeywordsGoogle;
				}
				if(se.equalsSE(SearchEngine.MSN)){
					if(data.numKeywordsMSN>numkw)
						numkw = data.numKeywordsMSN;
				}
			}
			
			//Get keywords sorted by probability
			ArrayList<KeywordProbabilityObject> keywords = this.getKeywordsSorted(categories, description, stemdata1, srchE, nGrams, numkw);
			
			
			
			return keywords.toArray(new KeywordProbabilityObject[keywords.size()]);
		
			
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}
	
	private ArrayList<String> getCatChildsAndData(ArrayList<String> categories, ArrayList<String> optCateg){
		//Returns a list with the content of the child categories
		long startTime = System.currentTimeMillis();
		ArrayList<String> trainList = new ArrayList<String>();
		for (String label : data.TrainingData.keySet()){
			for (int n=0; n<categories.size();n++){
				String cataux = categories.get(n);
				if( label.indexOf( cataux ) == 0 ) {
					optCateg.add(label);
					trainList.add(data.TrainingData.get(label));
				}
			}
		}
		logger.info("time for categories" + (System.currentTimeMillis()-startTime));
		return trainList;
	}
	private ArrayList<KeywordProbabilityObject> getKeywordsSorted(ArrayList<String> categories, String description, String data1, 
			ArrayList<SearchEngine> srchE, Integer[] nGrams, int numKw) throws Exception {
		try{
			//Create a ArrayList of the categories that satisfy options selected by the user and ArrayList
			//with data form those categories
			
			ArrayList<String> optCateg = new ArrayList<String>();
			
			ArrayList<String> trainList = getCatChildsAndData(categories, optCateg);

		    logger.info("Number of categories to add " + trainList.size());
			//Train LDA for categories selected and return sorted keywords
		    //and obtain word probability
		    
		    HashMap<String, Double> wordMap= this.createWordMap(data1, trainList, description);
		    logger.info("previous wordmap size: "+ wordMap.size());
		    Double defaultProb = this.getDefaultProbability(wordMap);
		    
	
		    //Generate a maximum of 5000 keywords nGrams[0] bigrams + nGrams[1] trigrams and the rest split between 4 grams and 5 grams
		    ArrayList<KeywordProbabilityObject> kwNOTSorted= this.getKwMultiCombined(optCateg, description, nGrams, wordMap, defaultProb, 5, srchE);
		    
		    ArrayList<KeywordProbabilityObject> keywords = this.sortKeywords(kwNOTSorted, numKw);
		    
		    // Disable the necessary SE flags
 			int j=0;
 			for(SearchEngine se : srchE){
 				if(se.equalsSE(SearchEngine.Google) && data.numKeywordsGoogle<keywords.size()){
 					for(int i=data.numKeywordsGoogle ; i<keywords.size(); i++ ){
 						keywords.get(i).setIsTargetGoogle(false);
 					}
 				}
 				if(se.equalsSE(SearchEngine.MSN) && data.numKeywordsMSN<keywords.size()){
 					for(int i=data.numKeywordsGoogle ; i<keywords.size(); i++ ){
 						keywords.get(i).setIsTargetGoogle(false);
 					}
 				}
 			}
		    
		    return keywords;
			
		}catch(Exception e){
			logger.error(e.toString());
			throw e;
		}
	}
	
	private ArrayList<KeywordProbabilityObject> sortKeywords(ArrayList<KeywordProbabilityObject> kwNOTSorted,int numKw){
		
		ArrayList<KeywordProbabilityObject> sortedKw = new ArrayList<KeywordProbabilityObject>();
		HashMap<KeywordProbabilityObject, Double> map = new HashMap<KeywordProbabilityObject, Double>();
		for(KeywordProbabilityObject kw : kwNOTSorted){		
			map.put(kw, kw.getSemplestProbability());
		}
		ValueComparator vc = new ValueComparator(map);
		TreeMap<KeywordProbabilityObject, Double> tmap = new TreeMap<KeywordProbabilityObject, Double>(vc);
		tmap.putAll(map);
		Set<KeywordProbabilityObject> set = tmap.keySet();
		int i=0;
		for(KeywordProbabilityObject kw : set){
			if(i>=numKw) break;
			sortedKw.add(kw);
		}
		return sortedKw;
	}
	
	private HashMap<String, Double> createWordMap(String data1, ArrayList<String> trainLines, String description) throws Exception{

			HashMap<String, Double> wordMap = new HashMap<String, Double>();
			//Instanciate topic model
			MalletTopic lda = new MalletTopic();
			double alpha=0.01;
			double beta=0.01;
			int numiter=100;
			
			lda.CreateInstances(trainLines);
			int numTopics = data.numTopics;
			if(trainLines.size()<numTopics)
				numTopics = trainLines.size();
			lda.setNumTopics(numTopics);
			lda.LDAcreateModel(alpha, beta, numiter);
		    InstanceList inferInst=lda.CreateInferInstfromData("0", "Test Data", data1);
				    
		    //Infer word probability based on input data
		    wordMap = lda.inferWordprob(inferInst, 0,true);
		    Double maxProb = maxValue(wordMap);
		    if(maxProb == null)
		    	maxProb = 1.0;
		    //logger.info("insider word map size:"+wordMap.size());
		    String qsStem = this.stemvStringNoFilter( description, data.dict ); 
		    if(qsStem!=null){
		    	String[] terms = qsStem.split("\\s+");
			    for(int n=0; n<terms.length; n++){
			    	wordMap.put(terms[n], new Double(maxProb));
			    }
		    }
			return wordMap;

	}
	
	private static Double maxValue(HashMap<String, Double> map){
		double max = 0;
		for(String word : map.keySet()){
			double prob =  map.get(word);
			if(prob>max)
				max=prob;
		}
		return max;
	}
	
	private ArrayList<KeywordProbabilityObject> getKwMultiCombined(ArrayList<String> optCateg, String searchTerms, Integer[] nGrams, 
			HashMap<String, Double> wordMap, Double defaultProb, int nGramsmax, ArrayList<SearchEngine> srchE) throws Exception{
		
		ArrayList<KeywordProbabilityObject> bigrams = new ArrayList<KeywordProbabilityObject>();
		ArrayList<KeywordProbabilityObject> trigrams = new ArrayList<KeywordProbabilityObject>();
		ArrayList<KeywordProbabilityObject> fourgrams = new ArrayList<KeywordProbabilityObject>();
		ArrayList<KeywordProbabilityObject> googleSug = getGoogleSug(searchTerms, srchE, wordMap, defaultProb, 1000);
		int iter=0;
		boolean flag = false;
		//go up to three levens on the tree to get enought bigrams and trigrams
		while (iter<3 && !flag){
			ArrayList<String> newOptCateg = optCateg; 
			if(iter != 0){
				ArrayList<String> newCategories = new ArrayList<String>();
				for (int n=0; n<optCateg.size();n++){
					String parent = catUtils.parent(optCateg.get(n));
					if(catUtils.nodes(parent)>2)
						newCategories.add(parent);
					else
						newCategories.add(optCateg.get(n));
				}
				newOptCateg = new ArrayList<String>();
				this.getCatChildsAndData(newCategories, newOptCateg);;
			}
			logger.info("Expanding categories");
			bigrams = getKwMulti(searchTerms, newOptCateg, nGrams[0], wordMap, defaultProb, 2, srchE);
			trigrams = getKwMulti(searchTerms, newOptCateg, nGrams[1], wordMap, defaultProb, 3, srchE);
			fourgrams = getKwMulti(searchTerms, newOptCateg, nGrams[2], wordMap, defaultProb, 4, srchE);
			flag = (bigrams.size()>10 || trigrams.size()>10);
			iter++;
		}
		ArrayList<KeywordProbabilityObject> results = new ArrayList<KeywordProbabilityObject>();
		results.addAll(bigrams);
		results.addAll(trigrams);
		results.addAll(fourgrams);
		results.addAll(googleSug);
		
		return results;

		
	}
	
	private ArrayList<KeywordProbabilityObject> getGoogleSug(String searchTerms, ArrayList<SearchEngine> srchE , 
			 HashMap<String, Double> wordMap, Double defaultProb,  int numberResults) throws Exception{

		ArrayList<KeywordProbabilityObject> kwProb = new ArrayList<KeywordProbabilityObject>();
		
		ArrayList<String> bigrams = this.generateNgramsFromString(searchTerms, 2, false);
		String[] keywords = bigrams.toArray(new String[bigrams.size()]);
		GoogleAdwordsServiceImpl g = new GoogleAdwordsServiceImpl();
		
		boolean repeat = true;
		int countRep = 0;
		ArrayList<KeywordToolStats> keyWordIdeaList = new ArrayList<KeywordToolStats>();
		while(countRep <= 1 && repeat){
			try{
				keyWordIdeaList = g.getGoogleKeywordIdeas(keywords, numberResults); 
				repeat=false;
				
			}catch(ApiException e){
				logger.error(e.dumpToString(), e);
				if(countRep <1) Thread.sleep(5000);
				countRep++;
				if(countRep>1){
					mail.SendEmail("getKeywords: Exception with Google API", "development@semplest.com", 
							"development@semplest.com", e.dumpToString(), EmailType.PlanText.getEmailValue());
				}
			}catch(Exception e){
				logger.error(e.toString(), e);
				if(countRep <1) Thread.sleep(5000);
				countRep++;
				if(countRep>1){
				 	mail.SendEmail("getKeywords: Exception with Google API", "development@semplest.com",
				 			"development@semplest.com", e.toString(), EmailType.PlanText.getEmailValue());
				}
			}
		}
		
		ArrayList<String> kwrds = new ArrayList<String>();
		for(KeywordToolStats kw : keyWordIdeaList){
			kwrds.add(kw.getKeyword());
		}
		
		HashMap<String, Double> kwProbMap =  getKwProbability(kwrds, wordMap, "\\s+", defaultProb);
		
		return kwProbMap2KwProbList( kwProbMap, srchE, numberResults);
	}
	
	private ArrayList<KeywordProbabilityObject>  kwProbMap2KwProbList( HashMap<String, Double> kwProbMap, ArrayList<SearchEngine> srchE, int numKw){
		
		ArrayList<KeywordProbabilityObject> kwProb = new ArrayList<KeywordProbabilityObject>();
		boolean isGT = false, isMSNT=false;
		if(srchE.contains(SearchEngine.Google))
			isGT = true;
		if(srchE.contains(SearchEngine.MSN))
			isMSNT = true;
		int i =0;
		for(String kw : kwProbMap.keySet()){
			if(i>=numKw) break;
			KeywordProbabilityObject kwP = new KeywordProbabilityObject();
			kwP.setIsTargetGoogle(isGT);
			kwP.setIsTargetMSN(isMSNT);
			kwP.setKeyword(kw.replaceAll("\\p{Punct}", " ").trim().replaceAll(" s ", "'s "));
			kwP.setSemplestProbability(kwProbMap.get(kw));
			kwProb.add(kwP);
			i++;
		}
		
		return kwProb;
	}
	
	private ArrayList<KeywordProbabilityObject> getKwMulti(String searchTerms,ArrayList<String> optCateg, 
			int numkw, HashMap<String, Double> wordMap, Double defaultProb, int nGrams, ArrayList<SearchEngine> srchE) throws Exception{
		//Generates keywords with nGrams words

		MultiWordCollect[] nGramsA=data.biGrams;
		//Select bigrams or trigrams based on nGrams value
		switch (nGrams){
			case 2: nGramsA=data.biGrams; break;
			case 3: nGramsA=data.triGrams; break;
			case 4: nGramsA=data.fourGrams; break;
			default: throw new Exception("nGrams value not valid");
		}
		
		//**************************************************************************************
		// Now that we have generated a selection of categories that we want to use to generate our alphabet,
		// we need to generate that alphabet and infer the word probabilities for each of the words in the alphabet
		HashMap<String, Double> multWMap = new HashMap<String, Double>();
		
		//Generate bigrams and trigrams in search Term and add them to the multi word list to be evaluated
		ArrayList<String> descripWords = this.generateNgramsFromString(searchTerms, nGrams, false);
		
		// Generating Multiword alphabet
		// Extract multiword for each category in the list and multiply probabilities of each subword
		for(String optKey: optCateg){
			int mIndex= data.getnGramSubCatInd(optKey);
			ArrayList<String> mWords= new ArrayList<String>();
			ArrayList<String> auxArray = nGramsA[mIndex].getwordsInCateg(optKey);
			if(descripWords!=null) mWords.addAll(descripWords);
			if(auxArray!=null) mWords.addAll(auxArray);
			if (mWords != null){
				multWMap.putAll(getKwProbability(mWords, wordMap, "\\+", defaultProb));
			}
		}
		
		return kwProbMap2KwProbList(multWMap, srchE, numkw);		
	}
	
	
	private   HashMap<String, Double> getKwProbability(ArrayList<String> wordList, HashMap<String, Double> wordMap, String regSplit, Double defaultProb){
		//Delete this for 60% probability
		defaultProb = 0.0;
		HashMap<String, Double> multWMap = new HashMap<String, Double>();
		for(String mWrd:wordList){
			String[] subWrds=mWrd.split(regSplit);
			Double wProb=1.0;
			String kwrd="";
			String kwstem = "";
			int relevantKw = 0;
			boolean flag = true;
			for(int n=0;n<subWrds.length;n++){
				String subWstem = this.stemvStringNoFilter( subWrds[n], data.dict).trim();
				if(!data.dict.commonWord(subWrds[n])){
					if(!kwstem.contains(subWstem)){
						if(wordMap.containsKey(subWstem)){
							wProb=wProb*wordMap.get(subWstem);
						}else{
							wProb=wProb*defaultProb;
						}
						kwstem = kwstem+subWstem+" ";
						relevantKw++;
					}else { 
						flag = false;
						break ;
					}
				}
				kwrd=kwrd+subWrds[n]+" ";
				
			}
			if(flag!=false && !multWMap.containsKey(kwrd) && relevantKw>1 && wProb!=0){
					multWMap.put(kwrd, Math.exp(Math.log(wProb)/relevantKw));			
			}
			
		}
		
		return multWMap;
	}
	
	private  ArrayList<String> generateNgramsFromString(String string, int nGrams, boolean stem){
		//Given a string returns an ArrayList of all the nGrams groups of words in the string serperated by a blank space
		ArrayList<String> ngrams = new ArrayList<String>();
		if(stem)
			string = this.stemvStringNoFilter(string, data.dict);
		String[] words = string.split("\\s+");
		if(words.length >= nGrams ){
			for(int i=0; i <= words.length-nGrams; i++){
				String newWord = "";
				for(int j=0; j<nGrams ; j++){
					if(words[i+j].equalsIgnoreCase("s"))
						newWord = newWord+"'"+words[i+j];
					else
						newWord = newWord+"+"+words[i+j];
				}
				String word =newWord.replaceAll("\\+$", "").replaceAll("^\\+", "");
				if(!ngrams.contains(word))
					ngrams.add(word);
			}
		}
		
		return ngrams;
		
	}
	
	
	
	private String weightData(double weight, String url, String[] adds, String companyName,String productPromotion, String description) throws Exception{
		//Combine all data from url, description, ads... and weight them differently
		
		//Add all data from inputs
		ArrayList<String> dataUrl= new ArrayList<String>();
		if(url!=null){
			url = TextUtils.formURL(url);
			dataUrl = TextUtils.validHtmlWords(url);
		}

		logger.info("Words from url:"+ dataUrl.size());
		//Text from adds
		String userData="";
		if(adds!=null){
			for(int i=0; i< adds.length; i++){
				userData= userData+" "+ adds[i].toLowerCase().replaceAll("\\p{Punct}", " ");
			}
		}
		//Adding all user data
		userData = userData+" "+companyName+" "+productPromotion+" "+description;
		String[] userCount = userData.split("\\s+");
		//If not user data provided, or too few, it will not be used.
		logger.info("Words from user: "+ userCount.length);
		if((userCount.length)<10) {
			logger.info("No user data provided");
			weight = 0;
		}
		if((userCount.length+dataUrl.size())<30) throw new Exception("Not enough data provided");
		
		//Calculate number of repetitions for each set to meet weight criteria
		
	    int repeatUser=1;
	    int repeatUrl=1;
	    
	    if(dataUrl.size()>=userCount.length&& weight!=1)
	    	repeatUser=(int) Math.round(weight*dataUrl.size()/(userCount.length*(1-weight)));
	    if(dataUrl.size()<userCount.length&& weight!=0)
	    	repeatUrl=(int) Math.round(userCount.length*(1-weight)/(weight*dataUrl.size()));
	    if (weight==0){
	    	repeatUser=0;
	    }
	    if (weight==1){
	    	repeatUrl=0;
	    }
	    logger.info("Number of times to repeat user data "+repeatUser);
	    logger.info("Number of times to repeat ulr data "+repeatUrl);
	    double finalweight = 1.0*(userCount.length*repeatUser)/(dataUrl.size()*repeatUrl+userCount.length*repeatUser);
	    logger.info("Final weight of user data"+ finalweight);
	    //add weighted data from url
	    String totaldata = "";
	    for(int n=0; n<repeatUrl;n++){
		    for( String s : dataUrl ) {
		    	totaldata = totaldata+" "+s;
		    }
	    }
	    //add weighted data from user
	    for(int n=0; n<repeatUser;n++){
		    	totaldata = totaldata+" "+userData;
	    }
	    
		return totaldata;
	}
	
	@Override
	public void initializeService(String str) throws Exception {
		try{
			data = new KWGenDmozLDAdata2(configData);
			Thread thread = new Thread(data);
			thread.start();
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}
	
	private String stemvString( String raws, dictUtils dict) throws Exception{
		//Returns the stemmed version of a word
	    String os = "";
	    boolean flag = false;
	    for( String w: raws.split("\\s+")){
	    	if(!dict.commonWord(w.toLowerCase())){
	    		//String newword = dict.getStemWord( w.toLowerCase() );
	    		String newword = dict.getRoot( w.toLowerCase() );
		    	if(newword != null){
		    		os = os + newword + " ";
		    		flag = true;
		    	}
	    	}
	    }
    	if(!flag){
    		throw new Exception("Not a valid description");
    	}
	    return os;
	}
	
	private String stemvStringNoFilter( String raws, dictUtils dict){
		//Returns the stemmed version of a word
	    String os = "";
	    for( String w: raws.split("\\s+")){
	    	//if(!dict.commonWord(w.toLowerCase())){
	    		//String aux = dict.getRoot( w.toLowerCase() );
		    	String aux = dict.getRoot( w.toLowerCase() );
		    	if(aux != null)
		    		os = os + aux + " ";
		    	else 
		    		os = os + w + " "; 
	    	//}
	    }
	    return os;
	}
	
	
	public KeywordProbabilityObject[] recalculateProbabilities(Integer promotionID) throws Exception{
		
		//Get Promotion data from database
		final GetAllPromotionDataSP getPromoDataSP = new GetAllPromotionDataSP();
		final Boolean returnVal = getPromoDataSP.execute(promotionID);
		final PromotionObj promotionData = getPromoDataSP.getPromotionData();
		List<AdsObject> ads= getPromoDataSP.getAds();
		String[] adsText = new String[ads.size()];
		for(int i=0; i<adsText.length; i++){
			AdsObject ad = ads.get(i);
			adsText[i] = ad.getAdTitle()+" "+ad.getAdTextLine1()+" "+ad.getAdTextLine2();
		}
		String url = promotionData.getLandingPageURL();
		String description = promotionData.getPromotionDescription();
		String productProm = promotionData.getPromotionName();
		final GetKeywordForAdEngineSP getKeywordForAdEngineSP = new GetKeywordForAdEngineSP();		
		final List<KeywordProbabilityObject> keywordList = getKeywordForAdEngineSP.execute(promotionID.intValue(), true, true);
		SemplestUtils.filterOutDeletedKeywords(keywordList);
		
		//Check Search Engines and decide number of kw per Search Engine
		ArrayList<SearchEngine> srchE =  new ArrayList<SearchEngine>();
		final Map<AdEngine,AdEngineID> adEngineInfo = getPromoDataSP.getPromotionAdEngineID(promotionID);
		for(AdEngine adE : adEngineInfo.keySet()){
			for (SearchEngine se : SearchEngine.values()){
				if(se.equalsSE(adE.name()))
					srchE.add(se);
			}
			if(srchE.size()<1)
				throw new Exception(adE.name()+ " not a valid Search Engine");
		}
		
		ArrayList<String> categories = new ArrayList<String>(SemplestDB.getPromotionCategory(promotionID));
		categories = data.cu.decode(categories);
		if(categories==null || categories.size()==0){
			throw new Exception("No categories provided");
		}
		
		//Check promotion data
		
		if(productProm!=null && productProm.length()>=0) 
			productProm = productProm.toLowerCase().replaceAll("\\p{Punct}", " ");
		if(description==null || description.length()==0) throw new Exception("No description provided");
		description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
		
		
		//Weight data based on percentage
		String data1 = this.weightData(data.userInfoWeight, url, adsText,"",productProm, description);
		
		//Create a ArrayList of the categories that satisfy options selected by the user and ArrayList
		//with data form those categories
		ArrayList<String> optCateg = new ArrayList<String>();
		ArrayList<String> trainList = getCatChildsAndData(categories, optCateg);
	    logger.info("Number of categories to add " + trainList.size());
	    
		//Train LDA for categories selected and return sorted keywords
	    //and obtain word probability
	    HashMap<String, Double> wordMap= this.createWordMap(data1, trainList, description);
	    logger.info("previous wordmap size: "+ wordMap.size());
	    Double defaultProb = this.getDefaultProbability(wordMap);
		
	    //Calulate Keyword Probability
	    ArrayList<String> keywords = new ArrayList<String>();
	    for(KeywordProbabilityObject kw : keywordList){
	    	keywords.add(kw.getKeyword().trim());
	    }
	    
	    HashMap<String,Double> kwProbMap = this.getKwProbability(keywords, wordMap, "\\s+", defaultProb);	    
	    ArrayList<KeywordProbabilityObject> kwOut = new ArrayList<KeywordProbabilityObject>(kwProbMap.size());
	    for(String kw : kwProbMap.keySet()){
	    	for(int j=0 ; j< keywordList.size(); j++){
	    		if(kw.trim().equalsIgnoreCase(keywordList.get(j).getKeyword().trim())){
	    			KeywordProbabilityObject kwUpd = keywordList.get(j);
	    			kwUpd.setSemplestProbability(kwProbMap.get(kw));
	    			kwOut.add(kwUpd);
	    		}
	    	}
	    }
	    kwOut = this.sortKeywords(kwOut, kwOut.size());
		return kwOut.toArray(new KeywordProbabilityObject[kwOut.size()]);
	}
	
	private Double getDefaultProbability(HashMap<String, Double> wordMap) throws FileNotFoundException{
		ValueComparator bvc = new ValueComparator(wordMap);
	  	TreeMap<String,Double> sortedMap = new TreeMap<String,Double>(bvc);
	  	sortedMap.putAll(wordMap);
	  	String[] words = sortedMap.keySet().toArray(new String[sortedMap.size()]);
	  	/*
	  	// print word Map
	  	PrintStream pr = new PrintStream(new FileOutputStream("/semplest/data/biddingTest/default/wordMap.wm"));
	  	for(String word : words){
	  		pr.println(word+", " + wordMap.get(word));
	  	}*/
	  	
	  	return wordMap.get(words[(int)(words.length*0.6)]);
	}
	/*
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		
		PrintStream ps = new PrintStream(new FileOutputStream("/semplest/data/biddingTest/default/updatedProbKw.txt"));
		
		
		KWGenDmozLDAServer2 kwGen =  new KWGenDmozLDAServer2(null);
		kwGen.initializeService(null);
		KeywordProbabilityObject[] kwrds = kwGen.recalculateProbabilities(223);
		for(KeywordProbabilityObject kw : kwrds ){
			ps.println(kw.getKeyword()+", "+ kw.getSemplestProbability() +", IsTargetGoogle: " + kw.getIsTargetGoogle() 
					+ ", IsTargetMSN: "+ kw.getIsTargetMSN()+", IsActive: "+kw.getIsActive()+", IsDeleted: "+kw.getIsDeleted()
					+ ", IsNegative: " + kw.getIsNegative()+ ", kwPK:" + kw.getKeywordPK());
		}
		ps.close();
	}
	*/
	
	public static void main(String[] args) throws Exception {
		
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 */
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		/*
		 * Init Keyword Data
		 */
		logger.info("Initialized Keyword generator...");
		
		//KWGenDmozLDAServer kwGen =  new KWGenDmozLDAServer(SemplestConfiguration.configData);
		KWGenDmozLDAServer2 kwGen =  new KWGenDmozLDAServer2(null);
		kwGen.initializeService(null);
		String[] searchTerm = new String[1];
		String userInfo1="";
		PrintStream logging = new PrintStream(new FileOutputStream("/semplest/data/biddingTest/default/categoriesTime.txt"));
		/*
		while(true){
			Long start = System.currentTimeMillis();
			ArrayList<String> categOpt = kwGen.getCategories(null, null , "science fiction", null, null);
			logging.println(System.currentTimeMillis()-start);
		}*/
		
		
		while (!userInfo1.equals("exit")){
			try{
			logger.info("\nPlease, introduce search terms:");
			Scanner scanFile = new Scanner(System.in);
			searchTerm[0] = scanFile.nextLine();
			String[] adds= new String[1];
			adds[0] = "";
			String description="";
			
			logger.info("Search Terms: "+searchTerm[0]);
			ArrayList<String> categOpt = kwGen.getCategories(null, null , searchTerm[0], null, null);
			logger.info("\nCategory options:");
			int m=0;
			for (String opt:categOpt){
				logger.info(m+"- "+opt);
				m++;
			}
			logger.info("Please, type indexes of categories to select separated by ',':");
			Scanner scan = new Scanner(System.in);
		    String mySentence = scan.nextLine(); 
		    String[] indexes = mySentence.split(",");
		    
		    ArrayList<String> categories = new ArrayList<String>();
		    for (int v=0; v<indexes.length;v++){
		    	logger.info(categOpt.get(Integer.parseInt(indexes[v])));
		    	categories.add(categOpt.get(Integer.parseInt(indexes[v])));
		    }
			//categories.add(categOpt.get(0));
			
			logger.info("Please, introduce path to file containing landing page (type \"exit\" to close) :");
			scanFile = new Scanner(System.in);
			userInfo1 = scanFile.nextLine(); 
			ArrayList<String> words1;
			String url=null;
			String uInf="";
			if(userInfo1.contains(".clean")){
				words1 = TextUtils.validTextWords (userInfo1);
				for(String word: words1){
					uInf=uInf+" "+word;
				}
			}else	
				url = userInfo1;
			
			logger.info("Please, introduce path to file containing user info (type \"exit\" to close) :");
			scanFile = new Scanner(System.in);
			userInfo1 = scanFile.nextLine(); 
			if(userInfo1.contains(".info")){
				words1 = TextUtils.validTextWords (userInfo1);
				for(String word: words1){
					description=description+" "+word;
				}
			}
			
			logger.info("Please, introduce path to file containing adds (type \"exit\" to close) :");
			scanFile = new Scanner(System.in);
			userInfo1 = scanFile.nextLine(); 
			if(userInfo1.contains(".add")){
				words1 = TextUtils.validTextWords (userInfo1);
				for(String word: words1){
					adds[0]=adds[0]+" "+word;
				}
			}
			
			
			Double startTime = new Long(System.currentTimeMillis()).doubleValue();
			Integer[] nGrams = {300,300,100};
			KeywordProbabilityObject[] kw = kwGen.getKeywords(categories,null, new String[] {"Google","MSN"}, uInf, searchTerm[0], adds, url, null ,nGrams);
			Double endTime =  new Long(System.currentTimeMillis()).doubleValue();
			System.out.println("Time for keywords: "+(endTime-startTime));
			for(KeywordProbabilityObject k: kw){
				String kaux=k.getKeyword();
				System.out.print(kaux+" "+k.getSemplestProbability()+", ");
			}
		
			PrintStream stdout = System.out;
			System.setOut(new PrintStream(new FileOutputStream("/semplest/data/biddingTest/default/keywordsCrawl2.txt")));

			//System.out.println("\n"+ (n+2)+" word keywords:");
			for(KeywordProbabilityObject k: kw){
				String kaux=k.getKeyword();//.replaceAll("wed", "wedding");
				System.out.println(kaux+", "+k.getSemplestProbability());
			}
			
			System.setOut(stdout);
			
			}catch(Exception e){
				logger.error(e);
			}
		}
	}

	
	
	
	
	
	@Override
	public String checkStatus(String input1, String input2) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




}
