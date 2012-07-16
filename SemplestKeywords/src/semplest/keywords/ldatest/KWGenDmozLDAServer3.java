package semplest.keywords.ldatest;
/**
 * Production version of the Keyword Generation Server
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.api.adwords.v201109.cm.ApiException;


import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.javautils.TextUtils;
import semplest.keywords.javautils.ValueComparator;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.lda.*;
import semplest.server.protocol.ProtocolEnum.EmailType;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.protocol.google.KeywordToolStats;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.mail.SemplestMailServiceImpl;


import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;
import cc.mallet.types.InstanceList;

public class KWGenDmozLDAServer3 {//implements SemplestKeywordLDAServiceInterface{
	
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAServer3.class);
	//Search index for categories
	private static KWGenDmozLDAdata3 data;
	private static HashMap<String,Object> configData;
	SemplestMailServiceImpl mail;
	private static enum SearchEngine {
		Google, MSN;
	}
	public KWGenDmozLDAServer3(HashMap<String,Object> configDataIn) throws Exception {
		try{
			configData = configDataIn;
			mail = new SemplestMailServiceImpl();
			mail.initializeService(null);
		}catch(Exception e){
			logger.error(e.toString());
			throw e;
		}
	}

	public ArrayList<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url, GeoTargetObject geo) throws Exception {
		try{
			if(searchTerm!=null && searchTerm.length()>0) searchTerm = searchTerm.toLowerCase().replaceAll("\\p{Punct}", " ");
			if(description==null || description.length()<=0) throw new Exception("No description data provided");
			description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
			if(url!=null) url = TextUtils.formURL(url);
			ArrayList<String> categories = this.getCategories(description, geo);
			return categories;
		}catch(Exception e){
			logger.error(e.toString());
			throw e;
		}
	}
	public ArrayList<String> getCategories(String searchTerm, GeoTargetObject geo) throws Exception {
		//Get category results from dmoz query
		try{
			String qs="";
			String[] res;
			String categories;
			ArrayList<String> optList = new ArrayList<String>();
			ArrayList<String> optInitial = new ArrayList<String>();
			int numresults = 100; // Number of results from the query
			qs=searchTerm;
			int iter = 0 ;
			String qsStem = this.stemvString( qs, data.dict );
			if(qsStem !=null && qsStem.length()>0){
				logger.debug(qsStem);
				while(optInitial.size()<numresults && iter<3 ){
					res = data.dl.search(qsStem,numresults*iter+1);
					for(int i=0; i<res.length; i++){
						categories = res[i].replaceAll("\\s+", "");
						if(catUtils.validcat(categories)){
							if(geo.getState()!=null && !geo.getState().isEmpty() && categories.contains("top/regional")){
								if(categories.contains("top/regional/north_america/united_states/"+data.states.get(geo.getState()))){
									optInitial.add(categories);
								}
							}else{
								optInitial.add(categories);
							}
						}
					}
					iter++;
				}
				//Select repeated patterns
				optList= selectOptions(optInitial, geo);
			}
			return optList;
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}
	

	public KeywordProbabilityObject[] getKeywords(ArrayList<String> categories,String companyName,  String[] searchEngines,
			String searchTerm, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception {
		try{
			ArrayList<SearchEngine> srchE =  new ArrayList<SearchEngine>();
			if(searchTerm!=null || searchTerm.length()>=0) searchTerm = searchTerm.toLowerCase().replaceAll("\\p{Punct}", " ");
			if(description==null || description.length()==0) throw new Exception("No description provided");
			description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
			//Check Search Engines and decide number of kw per Search Engine
			for(int i=0; i< searchEngines.length; i++){
				for (SearchEngine se : SearchEngine.values()){
					if(searchEngines[i].equalsIgnoreCase(se.toString())&& !srchE.contains(se))
						srchE.add(se);
				}
				if(srchE.size()<1){
					throw new Exception("Not valid Search Engines");
				}
			}
			int[] numKw = new int[srchE.size()];
			int j=0;
			for(SearchEngine se : srchE){
				if(se.toString().equalsIgnoreCase("google"))
					numKw[j]=data.numKeywordsGoogle;
				else if(se.toString().equalsIgnoreCase("msn"))
					numKw[j]=data.numKeywordsMSN;
				else
					numKw[j]=0;
				j++;
			}
			
			if(categories==null || categories.size()==0){
				throw new Exception("No categories provided");
			}
			if(nGrams==null || nGrams.length!=3){
				throw new Exception("Wrong number nGrams provided");
			} 
			
			String data1 =  "";
			//Weight data based on on percentage
			data1 = this.weightData(data.userInfoWeight, url, adds,companyName,searchTerm, description);
			String[] dataCount = data1.split("\\s+");
			if(dataCount.length<30) throw new Exception("Not enough data provided");
			
			
			String stemdata1 = new String();
			stemdata1 = this.stemvStringNoFilter( data1, data.dict );
			int numkw =0;
			for(int i = 0; i<numKw.length; i++){
		    	if(numKw[i]>numkw)
		    		numkw=numKw[i];
		    }
			ArrayList<ArrayList<KeywordProbabilityObject>> keywords = this.getKeywords(categories, description, stemdata1, numkw, srchE, gt, nGrams);
			HashMap<KeywordProbabilityObject, Double> map = new HashMap<KeywordProbabilityObject, Double>();
			int num = 0;
			for(ArrayList<KeywordProbabilityObject> list1 : keywords){
				for(KeywordProbabilityObject kw : list1){
					for(int n=0; n<srchE.size();n++){
						SearchEngine se = srchE.get(n);
						if(se.toString().equalsIgnoreCase("google")&& num>=numKw[n])
							kw.setIsTargetGoogle(false);
						else if(se.toString().equalsIgnoreCase("msn")&& num>=numKw[n])
							kw.setIsTargetMSN(false);
					}
					map.put(kw, kw.getSemplestProbability());
					num++;
				}
			}
			ValueComparator vc = new ValueComparator(map);
			TreeMap<KeywordProbabilityObject, Double> tmap = new TreeMap<KeywordProbabilityObject, Double>(vc);
			tmap.putAll(map);
			Set<KeywordProbabilityObject> set = tmap.keySet();
			return set.toArray(new KeywordProbabilityObject[]{});
		}catch(Exception e){
			logger.error(e);
			throw e;
		}
	}
	

	public ArrayList<ArrayList<KeywordProbabilityObject>> getKeywords(ArrayList<String> categories, String searchTerm, String data1,  
			int numkw, ArrayList<SearchEngine> srchE, GeoTargetObject[] gt,Integer[] nGrams) throws Exception {
		try{
			//Create a ArrayList of the categories that satisfy options selected by the user and ArrayList
			//with data form those categories
			long startTime = System.currentTimeMillis();
			ArrayList<String> optCateg = new ArrayList<String>();
			ArrayList<ArrayList<KeywordProbabilityObject>> keywordsfull = new ArrayList<ArrayList<KeywordProbabilityObject>>();
			ArrayList<ArrayList<KeywordProbabilityObject>> keywords = new ArrayList<ArrayList<KeywordProbabilityObject>>();
			Set<String> labels = data.TrainingData.keySet();
			ArrayList<String> trainLines = new ArrayList<String>();
			String cataux;
			for (String label : labels){
				for (int n=0; n<categories.size();n++){
					cataux = categories.get(n);
					if(cataux.indexOf("top/regional")==0){
						cataux = cataux.replaceAll("top/regional/", "");
						String cattail = catUtils.revert(cataux);
						if(gt[0].getState()!=null && !gt[0].getState().isEmpty()){
							if(label.contains("top/regional/north_america/united_states/"+data.states.get(gt[0].getState()))&& label.contains(cattail)){
								optCateg.add(label);
								trainLines.add(data.TrainingData.get(label));
							}
						}else if(label.contains("top/regional")&& label.contains(cattail)){
							optCateg.add(label);
							trainLines.add(data.TrainingData.get(label));
						}
					}else if( label.indexOf( cataux ) == 0 ) {
						//logger.debug(label);
	    				optCateg.add(label);
	    				//Gather training data
	    				trainLines.add(data.TrainingData.get(label));
					}
				}
			}
		
		
		    long endTime = System.currentTimeMillis();
		    logger.info("time for categories" + (endTime-startTime));
		    logger.info("Number of categories to add " + trainLines.size());
			//Train LDA for categories selected and return sorted keywords
		    //and obtain word probability
		    
		    HashMap<String, Double> wordMap= this.createWordMap(data1, trainLines, searchTerm);
		    logger.info("previous wordmap size: "+ wordMap.size());
		    //Rank monograms by probability
		    ValueComparator bvc =  new ValueComparator(wordMap);
			TreeMap<String,Double> wordM = new TreeMap(bvc);
			wordM.putAll(wordMap);
		    logger.info("wordMap Size: "+ wordM.size());
		    
		    logger.info("Generating Kewyords");
		    Set<String> kwSet = wordM.keySet();
	
		    //Generate a maximum of 5000 keywords nGrams[0] bigrams + nGrams[1] trigrams and the rest split between 4 grams and 5 grams
		    keywordsfull= this.getKwMultiCombined(optCateg, searchTerm, nGrams, wordMap, 5, srchE);
		    int kwCount = 0;
		    int iter = 0;
		    ArrayList<KeywordProbabilityObject> finalkwList;
		    for(ArrayList<KeywordProbabilityObject> kwList: keywordsfull){
		    	if(iter<2){
		    		finalkwList = kwList;
		    	}else{
		    		finalkwList = new ArrayList<KeywordProbabilityObject>();
		    	}
		    	int remain = numkw - kwCount;
		    	int num2Gen=0;
		    	//fourgrams and fivegrams 
			    if(iter==2)
			   		num2Gen = remain/2;
			    if(iter==3) num2Gen = remain;
			    int j=0;
			    for(KeywordProbabilityObject keyw: kwList){
			    		if(j>= num2Gen) break;
			    		finalkwList.add(keyw);
			    		j++;
			    }
			    
			    kwCount = kwCount+finalkwList.size();
		    	iter++;
		    	keywords.add(finalkwList);
		    }
	
			return keywords;
		}catch(Exception e){
			logger.error(e.toString());
			throw e;
		}
	}
	
	private ArrayList<String> expandCategories(ArrayList<String> newCategories) throws Exception{

			ArrayList<String> optCateg = new ArrayList<String>();
			Set<String> labels = data.TrainingData.keySet();
			String cataux;
			
		    for (String label : labels){
		    	for (int n=0; n<newCategories.size();n++){
		    		cataux=newCategories.get(n);
		    		if( label.indexOf( cataux ) == 0 ) {
		    			if (!optCateg.contains(label)){
		    				//logger.debug(label);
		    				optCateg.add(label);
		    			}
		    		}
		    	}
		    }
		    return optCateg;

	}
	
	private HashMap<String, Double> createWordMap(String data1, ArrayList<String> trainLines, String searchTerm) throws Exception{

			HashMap<String, Double> wordMap = new HashMap<String, Double>();
			//Instanciate topic model
			MalletTopic lda = new MalletTopic();
			double alpha=0.01;
			double beta=0.01;
			int numiter=100;
			logger.info("Number of categories" + trainLines.size());
			
			lda.CreateInstances(trainLines);
			int numTopics = data.numTopics;
			if(trainLines.size()<numTopics)
				numTopics = trainLines.size();
			lda.setNumTopics(numTopics);
			lda.LDAcreateModel(alpha, beta, numiter);
			InstanceList inferInst;
		    inferInst=lda.CreateInferInstfromData("0", "Test Data", data1);
		    //logger.info("inferInst alphabet size: "+ inferInst.getAlphabet().size());
				    
		    //Infer word probability based on input data
		    wordMap = lda.inferWordprob(inferInst, 0,true);
		    Double maxProb = maxValue(wordMap);
		    if(maxProb == null)
		    	maxProb = 1.0;
		    //logger.info("insider word map size:"+wordMap.size());
		    String qsStem = this.stemvStringNoFilter( searchTerm, data.dict ); 
		    if(searchTerm!=null){
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
	
	private ArrayList<ArrayList<KeywordProbabilityObject>> getKwMultiCombined(ArrayList<String> optCateg, String searchTerms, Integer[] nGrams, 
			HashMap<String, Double> wordMap, int nGramsmax, ArrayList<SearchEngine> srchE) throws Exception{
		
	
		//Returns 4 grams combining 2 and 3 grams
		ArrayList<KeywordProbabilityObject> bigrams = getKwMulti(searchTerms, optCateg, nGrams[0], wordMap, 2, srchE);
		ArrayList<KeywordProbabilityObject> trigrams = getKwMulti(searchTerms, optCateg, nGrams[1], wordMap, 3, srchE);
		ArrayList<KeywordProbabilityObject> fourgrams = getKwMulti(searchTerms, optCateg, nGrams[2], wordMap, 4, srchE);
		//Find max and min probability
		ArrayList<Double> maxValues = new ArrayList<Double>();
		ArrayList<Double> minValues = new ArrayList<Double>();
		if(bigrams != null && bigrams.size()>0){
			maxValues.add(bigrams.get(0).getSemplestProbability());
			minValues.add(bigrams.get(bigrams.size()-1).getSemplestProbability());
		}
		if(trigrams != null && trigrams.size()>0){
			maxValues.add(trigrams.get(0).getSemplestProbability());
			minValues.add(trigrams.get(trigrams.size()-1).getSemplestProbability());
		}
		if(fourgrams != null && fourgrams.size()>0){
			maxValues.add(fourgrams.get(0).getSemplestProbability());
			minValues.add(fourgrams.get(fourgrams.size()-1).getSemplestProbability());
		}
		double maxVal = 0.0;
		double minVal = 1.0;
		for(int j = 0; j<maxValues.size(); j++){
			if(maxVal<maxValues.get(j))
				maxVal = maxValues.get(j);
			if(minVal>minValues.get(j)){
				minVal = minValues.get(j);
			}
		}
		ArrayList<KeywordProbabilityObject> googleSug = getGoogleSug(searchTerms, srchE, minVal, maxVal);
		
		
		
		
		
		
		int iter=0;
		while (iter<3 && (bigrams.size()<10 || trigrams.size()<10)){
			ArrayList<String> newCategories = new ArrayList<String>();
			for (int n=0; n<optCateg.size();n++){
				String parent = catUtils.parent(optCateg.get(n));
				if(catUtils.nodes(parent)>2)
					newCategories.add(parent);
				else
					newCategories.add(optCateg.get(n));
			}
			optCateg= newCategories;
			ArrayList<String> newOptCateg = this.expandCategories(optCateg);
			bigrams = getKwMulti(searchTerms, newOptCateg, nGrams[0], wordMap, 2, srchE);
			trigrams = getKwMulti(searchTerms, newOptCateg, nGrams[1], wordMap, 3, srchE);
			fourgrams = getKwMulti(searchTerms, newOptCateg, nGrams[2], wordMap, 3, srchE);
			logger.info("Expanding categories");
			iter++;
			
		}
		ArrayList<ArrayList<KeywordProbabilityObject>> results = new ArrayList<ArrayList<KeywordProbabilityObject>>();
		results.add(googleSug);
		results.add(bigrams);
		results.add(trigrams);
		results.add(fourgrams);


		return results;

		
	}
	
	private ArrayList<KeywordProbabilityObject> getGoogleSug(String searchTerms, ArrayList<SearchEngine> srchE , 
			Double minVal, Double maxVal) throws Exception{

		ArrayList<KeywordProbabilityObject> kwProb = new ArrayList<KeywordProbabilityObject>();
		
		ArrayList<String> bigrams = this.generateNgramsFromString(searchTerms, 2, false);
		String[] keywords = bigrams.toArray(new String[bigrams.size()]);
		GoogleAdwordsServiceImpl g = new GoogleAdwordsServiceImpl();
		
		int numberResults = 1000;
		boolean repeat = true;
		int countRep = 0;
		ArrayList<KeywordToolStats> keyWordIdeaList = new ArrayList<KeywordToolStats>();
		while(countRep <= 1 && repeat){
			try{
				repeat = false;
				/*keyWordIdeaList = g.getGoogleKeywordIdeas(keywords, numberResults); 
				repeat=false;
				
			}catch(ApiException e){
				logger.error(e.dumpToString(), e);
				if(countRep <1) Thread.sleep(5000);
				countRep++;
				if(countRep>1){
					mail.SendEmail("getKeywords: Exception with Google API", "development@semplest.com", 
							"development@semplest.com", e.dumpToString(), EmailType.PlanText.getEmailValue());
				}*/
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
		for(KeywordToolStats kw : keyWordIdeaList){
			KeywordProbabilityObject kwP = new KeywordProbabilityObject();
			kwP.setIsTargetGoogle(true);
			kwP.setIsTargetMSN(true);
			kwP.setKeyword(kw.getKeyword());
			kwP.setSemplestProbability((maxVal-minVal)*Math.random()+minVal);
			kwProb.add(kwP);
		}
		
		return kwProb;
	}
	
	
	private ArrayList<KeywordProbabilityObject> getKwMulti(String searchTerms,ArrayList<String> optCateg, 
			int numkw, HashMap<String, Double> wordMap, int nGrams, ArrayList<SearchEngine> srchE) throws Exception{
		//Generates keywords with nGrams words

		MultiWordCollect[] nGramsA=data.biGrams;
		ArrayList<KeywordProbabilityObject> keywords = new ArrayList<KeywordProbabilityObject>();
		//Select bigrams or trigrams based on nGrams value
		switch (nGrams){
		case 2: nGramsA=data.biGrams;
				break;
		case 3: nGramsA=data.triGrams; break;
		case 4: nGramsA=data.fourGrams; break;
		default: throw new Exception("nGrams value not valid");
		}
		

		  //**************************************************************************************
			// Now that we have generated a selection of categories that we want to use to generate our alphabet,
			// we need to generate that alphabet and infer the word probabilities for each of the words in the alphabet
			HashMap<String, Double> multWMap = new HashMap<String, Double>();
			ValueComparator bvc =  new ValueComparator(multWMap);
			TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
			int i=0;
			Set<String> keySet;
			java.util.Iterator<String> iterator;

			String[] subWrds;
			String kwrd;
			double wProb;
			boolean in=true;
			
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
					for(String mWrd:mWords){
						subWrds=mWrd.split("\\+");
						wProb=1.0;
						kwrd="";
						String kwstem = "";
						boolean flag = true;
						for(int n=0;n<subWrds.length;n++){
							String subWstem = this.stemvStringNoFilter( subWrds[n], data.dict).replaceAll("\\s+", "");
							if(!wordMap.containsKey(subWstem) || kwstem.contains(subWstem)){
								flag=false;
								break;
							}
							kwrd=kwrd+subWrds[n]+" ";
							kwstem = kwstem+subWstem+" ";
						}
						if(flag!=false && !multWMap.containsKey(kwrd)){
								for(int n=0;n<subWrds.length;n++){
									String subWstem = this.stemvStringNoFilter( subWrds[n], data.dict).replaceAll("\\s+", "");
									wProb=wProb*wordMap.get(subWstem);
								}
								multWMap.put(kwrd, Math.exp(Math.log(wProb)/nGrams));			
						}
						
					}
				}
			}
			//Once the alphabet and probabilities have been generated, sort by probability.
			sorted_map.putAll(multWMap);
			
			//Generating Keywords
		    keySet=sorted_map.keySet();
		    
		    String keyword;
		    i=0;
		    iterator=keySet.iterator();
		    
		    while(i<numkw){
		    		if(iterator.hasNext())keyword =iterator.next();
		    		else break;
	    			KeywordProbabilityObject kProb = new KeywordProbabilityObject();
	    			if(srchE.contains(SearchEngine.Google))
						kProb.setIsTargetGoogle(true);
					else
						kProb.setIsTargetGoogle(false);
					if(srchE.contains(SearchEngine.MSN))
						kProb.setIsTargetMSN(true);
					else
						kProb.setIsTargetMSN(false);
					kProb.setKeyword(keyword);
					kProb.setSemplestProbability(multWMap.get(keyword));
					keywords.add(kProb);
			    	i++;
		    }
		    System.out.println("Bigrams:");
		    
		    if(nGrams==2){
		    	PrintStream pr = new PrintStream(new FileOutputStream("/semplest/data/biddingTest/keywords100.txt"));
		    	for(KeywordProbabilityObject kw : keywords){
		    		pr.println(kw.getKeyword());
		    	}
		    }
		    
		    return keywords;
		
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
	
	
	private static ArrayList<String> selectOptions(ArrayList<String> optKeys, GeoTargetObject geo) throws IOException{
		//Selects patterns from top categories list to generate options for the user based on pre-defined crieteria
		ArrayList<String> categories = new ArrayList<String>();
		
		for(int n=0; n<optKeys.size(); n++){
			if(optKeys.get(n).contains("top/regional")){
				if(geo.getState()== null || geo.getState().isEmpty()){
					String newName = optKeys.get(n).replaceAll("top/regional/", "");
					newName = "top/regional/"+catUtils.revert(newName);
					optKeys.set(n, newName);
				}else{
					String newName = optKeys.get(n).replaceAll("top/regional/north_america/united_states/"+data.states.get(geo.getState()), "");
					newName = "top/regional/"+catUtils.revert(newName);
					optKeys.set(n, newName);
				}
				

			}
		}

		int numNEval=20;
	  	HashMap<String,Double> optList = new HashMap<String,Double>();
	  	ValueComparator bvcAux = new ValueComparator(optList);
	  	TreeMap<String,Double> sorted_opt = new TreeMap<String,Double>(bvcAux);
		
		 
	    int numNodes;
	    //Identify repeated patterns in top categories
	    String  newoption;
	    String[] pair= new String[2];
	    for(int n=0; n<optKeys.size(); n++){
	    	for (int m=0; m<n;m++){
	    		pair[0]=optKeys.get(n); pair[1]=optKeys.get(m);
	    		newoption = catUtils.longestAncestor(pair);
	    		if(optList.containsKey(newoption)){
	    			optList.put(newoption, ((Double)optList.get(newoption))+1.0);
	    		}else {
	    			optList.put(newoption, new Double(1));
	    		}
	    	}
	    }
	    
	    sorted_opt.putAll(optList);
	    
	    //Filter out just relevant patterns
	    HashMap<String,Double> optList2= new HashMap<String,Double>();
		ValueComparator bvcAux2 = new ValueComparator(optList2);
	  	TreeMap<String,Double> sorted_opt2 = new TreeMap<String,Double>(bvcAux2);
	    Double numrepeat;
	    Set<String> optKeys2 = sorted_opt.keySet();
	    for(String optKey:optKeys2){
	    	numNodes = catUtils.nodes(optKey);
	    	numrepeat = optList.get(optKey);
	    	if(optKey.contains("top/regional")){
		    	if(numNodes>=4  && numrepeat >=1){
		    		if(catUtils.last(optKey).length()>1){
			    		if(!optList2.containsKey(catUtils.take(optKey, numNEval))){
			    			optList2.put(catUtils.take(optKey, numNEval),new Double(numNodes));
			    		}
		    		}
		    	}
	    	}else{
	    		if(numNodes>=4  && numrepeat >=3){
		    		if(catUtils.last(optKey).length()>1){
			    		if(!optList2.containsKey(catUtils.take(optKey, numNEval))){
			    			optList2.put(catUtils.take(optKey, numNEval),new Double(numNodes));
			    		}
		    		}
		    	}
	    	}
	    }

	    sorted_opt2.putAll(optList2);
	    // Present sorted pattern form most relevant to less relevant
	    Set<String> sorted_optKeys2 = sorted_opt2.keySet();
	    ArrayList<String> arrayOpt=new ArrayList<String>();
	    //Add top 3
	    int numtop;
	    if(sorted_optKeys2.size()<5)
	    	numtop=5;
	    else
	    	numtop=4;
	    int numresults=0;
	    for(int i=0; i<optKeys.size(); i++){
	    	if(numresults>=numtop) break;
	    	//String key = catUtils.init(optKeys.get(i));
	    	String key = optKeys.get(i);
	    	if(!arrayOpt.contains(key)){
	    		arrayOpt.add(key);
	    		numresults++;
	    	}
	    }
	    //Add rest of the patterns
	    for(String key: sorted_optKeys2){
	    	if(!arrayOpt.contains(key))
	    		arrayOpt.add(key);
	    }
	  
	    return arrayOpt;
	    
	}
	
	private String weightData(double weight, String url, String[] adds, String companyName,String searchTerm, String description) throws Exception{
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
		userData = userData+" "+companyName+" "+searchTerm+" "+description;
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
	

	public void initializeService(String str) throws Exception {
		try{
			data = new KWGenDmozLDAdata3(configData);
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
	    		String newword = dict.getStemWord( w.toLowerCase() );
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
	    	if(!dict.commonWord(w.toLowerCase())){
		    	String aux = dict.getStemWord( w.toLowerCase() );
		    	if(aux != null)
		    		os = os + aux + " ";
		    	else 
		    		os = os + w + " "; 
	    	}
	    }
	    return os;
	}

	
	public static void main(String[] args) throws Exception {
		
		BasicConfigurator.configure();

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
		KWGenDmozLDAServer3 kwGen =  new KWGenDmozLDAServer3(null);
		kwGen.initializeService(null);
		String[] searchTerm = new String[1];
		String userInfo1="";
		BasicConfigurator.configure();
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
			GeoTargetObject geo = new GeoTargetObject();
			geo.setState("NY");
			ArrayList<String> categOpt = kwGen.getCategories(null, null , searchTerm[0], null, null, geo );
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
			Integer[] nGrams = {100,300,100};
			KeywordProbabilityObject[] kw = kwGen.getKeywords(categories,null, new String[] {"Google","MSN"}, uInf, searchTerm[0], adds, url, new GeoTargetObject[] {geo} ,nGrams);
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




}
