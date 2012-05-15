package semplest.keywords.lda;
/**
 * Production version of the Keyword Generation Server
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.javautils.TextUtils;
import semplest.keywords.javautils.ValueComparator;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;
import cc.mallet.types.InstanceList;

public class KWGenDmozLDAServer implements SemplestKeywordLDAServiceInterface{
	
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAServer.class);
	//Search index for categories
	private static KWGenDmozLDAdata data;
	private static enum SearchEngine {
		Google, MSN;
	}
	public KWGenDmozLDAServer() {

	}
	@Override
	public ArrayList<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception {
		if(searchTerm!=null && searchTerm.length()>0) searchTerm = searchTerm.toLowerCase().replaceAll("\\p{Punct}", " ");
		if(description==null || description.length()<=0) throw new Exception("No description data provided");
		description = description.toLowerCase().replaceAll("\\p{Punct}", " ");
		if(url!=null) url = TextUtils.formURL(url);
		ArrayList<String> categories = this.getCategories(description);
		return categories;
	}
	public ArrayList<String> getCategories(String searchTerm) throws Exception {
		//Get category results from dmoz query
		
		String qs="";
		String[] res;
		String categories;
		ArrayList<String> optList = new ArrayList<String>();
		ArrayList<String> optInitial = new ArrayList<String>();
		int numresults = 100; // Number of results from the query
		qs=searchTerm;
		String qsStem = this.stemvString( qs, data.dict );
		if(qsStem !=null && qsStem.length()>0){
			logger.debug(qsStem);
			res = data.dl.search(qsStem,numresults);
			for(int i=0; i<res.length; i++){
				categories = res[i].replaceAll("\\s+", "");
				if(catUtils.validcat(categories))
						optInitial.add(categories);
						//logger.debug(categories);
			}
			//Select repeated patterns
			optList= selectOptions(optInitial);
		}
		return optList;
	}
	
	@Override
	public KeywordProbabilityObject[] getKeywords(ArrayList<String> categories,String companyName,  String[] searchEngines,
			String searchTerm, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception {
		ArrayList<SearchEngine> srchE =  new ArrayList<SearchEngine>();
		if(searchTerm!=null || searchTerm.length()>=0) searchTerm = searchTerm.toLowerCase().replaceAll("\\p{Punct}", " ");
		if(description==null || description.length()==0) throw new Exception("No description provided");
		description = description.toLowerCase().replaceAll("\\p{Punct}", " ");

		for(int i=0; i< searchEngines.length; i++){
			for (SearchEngine se : SearchEngine.values()){
				if(searchEngines[i].equalsIgnoreCase(se.toString())&& !srchE.contains(se))
					srchE.add(se);
			}
			if(srchE.size()<1){
				throw new Exception("Not valid Search Engines");
			}
		}
		if(categories==null || categories.size()==0){
			throw new Exception("No categories provided");
		}
		if(nGrams==null || nGrams.length!=2){
			throw new Exception("Wrong number nGrams provided");
		} 
		
		String data1 =  "";
		
		data1 = this.weightData(data.userInfoWeight, url, adds,companyName,searchTerm, description);
		String[] dataCount = data1.split("\\s+");
		if(dataCount.length<30) throw new Exception("Not enough data provided");
		String stemdata1 = new String();
		stemdata1 = this.stemvStringNoFilter( data1, data.dict );
		ArrayList<ArrayList<KeywordProbabilityObject>> keywords = this.getKeywords(categories, description, stemdata1, data.numKeywords, srchE, nGrams);
		
		ArrayList<KeywordProbabilityObject> keywordsList = new ArrayList<KeywordProbabilityObject>();
		for(ArrayList<KeywordProbabilityObject> list1 : keywords){
			for(KeywordProbabilityObject kwrd : list1 ){
				keywordsList.add(kwrd);
			}
		}
		KeywordProbabilityObject[] keywordArray = new KeywordProbabilityObject[keywordsList.size()];
		for(int v =0; v<keywordsList.size(); v++){
			keywordArray[v]=keywordsList.get(v);
		}
		return keywordArray;
	}
	
	
	public ArrayList<ArrayList<KeywordProbabilityObject>> getKeywords(ArrayList<String> categories, String searchTerm, String data1,  
			int numkw, ArrayList<SearchEngine> srchE, Integer[] nGrams) throws Exception {
		//Create a ArrayList of the categories that satisfy options selected by the user and ArrayList
		//with data form those categories
		ArrayList<String> optCateg = new ArrayList<String>();
		ArrayList<ArrayList<KeywordProbabilityObject>> keywordsfull = new ArrayList<ArrayList<KeywordProbabilityObject>>();
		ArrayList<ArrayList<KeywordProbabilityObject>> keywords = new ArrayList<ArrayList<KeywordProbabilityObject>>();
		Set<String> labels = data.TrainingData.keySet();
		String cataux;
		int numNod;
		ArrayList<String> trainLines = new ArrayList<String>();
	    for (String label : labels){
	    	for (int n=0; n<categories.size();n++){
	    		cataux=categories.get(n);
	    		numNod = catUtils.nodes(cataux);
	    		if(catUtils.take(label, numNod).equals(catUtils.take(cataux,numNod))){
	    			if (!optCateg.contains(label)){
	    				//logger.debug(label);
	    				optCateg.add(label);
	    				//Gather training data
	    				trainLines.add(data.TrainingData.get(label));
	    			}
	    		}
	    	}
	    }
	    logger.info("Number of categories to add " + trainLines.size());
		//Train LDA for categories selected and return sorted keywords
	    //and obtain word probability
	    HashMap<String, Double> wordMap= this.createWordMap(data1, trainLines, searchTerm);
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
	    /*
	    //******************************** Print report with probabilities *********************************************
	    PrintStream stdout = System.out;
		System.setOut(new PrintStream(new FileOutputStream("/semplest/data/biddingTest/Test1/keywordsProb500.txt")));
		for(int n=0; n<4; n++){
			for(String k: keywords.get(n)){
				double prob = this.calculateKWProb(k, wordMap);
				k=k.replaceAll("wed", "wedding");
				System.out.println(prob+"\t"+k);
			}
		}
		System.setOut(stdout);
		//**************************************************************************/
		return keywords;
	}
	
	private ArrayList<String> expandCategories(ArrayList<String> categories){
		ArrayList<String> optCateg = new ArrayList<String>();
		Set<String> labels = data.TrainingData.keySet();
		String cataux;
		int numNod;
	    for (String label : labels){
	    	for (int n=0; n<categories.size();n++){
	    		cataux=catUtils.parent(categories.get(n));
	    		numNod = catUtils.nodes(cataux);
	    		if(catUtils.take(label, numNod).equals(catUtils.take(cataux,numNod))){
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
			    
	    //Infer word probability based on input data
	    wordMap = lda.inferWordprob(inferInst, 0,true);
	    String qsStem = this.stemvStringNoFilter( searchTerm, data.dict ); 
	    if(searchTerm!=null){
	    	String[] terms = qsStem.split("\\s+");
		    for(int n=0; n<terms.length; n++){
		    	wordMap.put(terms[n], new Double(1.0));
		    }
	    }
		return wordMap;
	}
	
	private ArrayList<ArrayList<KeywordProbabilityObject>> getKwMultiCombined(ArrayList<String> optCateg, String searchTerms, Integer[] nGrams, 
			HashMap<String, Double> wordMap, int nGramsmax, ArrayList<SearchEngine> srchE) throws Exception{
		
		//Returns 4 grams combining 2 and 3 grams
		ArrayList<KeywordProbabilityObject> bigrams = getKwMulti(searchTerms, optCateg, nGrams[0], wordMap, 2, srchE);
		ArrayList<KeywordProbabilityObject> trigrams = getKwMulti(searchTerms, optCateg, nGrams[1], wordMap, 3, srchE);
		int iter=0;
		while (iter<3 && (bigrams.size()<10 || trigrams.size()<10)){
			optCateg = this.expandCategories(optCateg);
			bigrams = getKwMulti(searchTerms, optCateg, nGrams[0], wordMap, 2, srchE);
			trigrams = getKwMulti(searchTerms, optCateg, nGrams[1], wordMap, 3, srchE);
			logger.info("Expanding categories");
			iter++;
			
		}
		ArrayList<ArrayList<KeywordProbabilityObject>> results = new ArrayList<ArrayList<KeywordProbabilityObject>>();
		results.add(bigrams);
		results.add(trigrams);
		
		HashMap<String,ArrayList<String>> biGMap= new HashMap<String,ArrayList<String>>();
		// Create Hashmap of biwords;
		for(KeywordProbabilityObject base: bigrams){
			String[] words = base.getKeyword().split("\\s+");
			ArrayList<String> aux;
			for(int i=0; i<words.length; i++){
				if(biGMap.containsKey(words[i])){
					aux = biGMap.get(words[i]);
					aux.add(base.getKeyword());
				}else{
					aux = new ArrayList<String>();
					aux.add(base.getKeyword());
					biGMap.put(words[i], aux);
				}
			}
		}
		
		
		logger.info("Creating nGrams bigger than 3...");
		//Extend keyword list
		if(nGramsmax>=4){
			for(int m = 4; m<=nGramsmax; m++){
				ArrayList<KeywordProbabilityObject> tempArray = new ArrayList<KeywordProbabilityObject>();
				HashMap<String,Double> temp = new HashMap<String,Double>();
				ValueComparator bvc =  new ValueComparator(temp);
				TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
				ArrayList<KeywordProbabilityObject> baseList = results.get(m-3);
				for(KeywordProbabilityObject base: baseList){
					String[] words = base.getKeyword().split("\\s+");
					ArrayList<String> aux;
					for(int i=0; i<words.length; i++){
						if(biGMap.containsKey(words[i])){
							aux=biGMap.get(words[i]);
							for(String gr: aux){
								boolean flag=false;
								String[] prts = gr.split("\\s+");
								for(int n=0;n<prts.length;n++){
									if(!prts[n].equals(words[i]) && base.getKeyword().contains(prts[n])){
										flag=true;
										break;
									}
								}
								if(!flag){
									String kwnew = base.getKeyword().replace(words[i],gr);
									kwnew=kwnew.replaceAll("\\s+", " ");
									temp.put(kwnew,this.calculateKWProb(kwnew, wordMap));
								}
							}
						}
					}
				}
				sorted_map.putAll(temp);
				Set<String> keySet = sorted_map.keySet();
				for(String key: keySet){
					KeywordProbabilityObject kProb = new KeywordProbabilityObject();
					if(srchE.contains(SearchEngine.Google))
						kProb.setIsTargetGoogle(true);
					else
						kProb.setIsTargetGoogle(false);
					if(srchE.contains(SearchEngine.MSN))
						kProb.setIsTargetMSN(true);
					else
						kProb.setIsTargetMSN(false);
					kProb.setKeyword(key);
					kProb.setSemplestProbability(temp.get(key));
					tempArray.add(kProb);
				}
				results.add(tempArray);
			}
		}
		return results;
	}
	private Double calculateKWProb(String keyword, HashMap<String,Double> wordMap){
	  String[] kwPart = keyword.split("\\s+");
	  double wProb = 1;
	  for(int i=0; i< kwPart.length;i++){
		  if(wordMap.containsKey(kwPart[i])){
			  wProb = wProb*wordMap.get(kwPart[i]);
		  } else { 
				  wProb = 0; break;
		  }
	  }
	  return new Double(wProb);
	}
	
	private ArrayList<KeywordProbabilityObject> getKwMulti(String searchTerms,ArrayList<String> optCateg, 
			int numkw, HashMap<String, Double> wordMap, int nGrams, ArrayList<SearchEngine> srchE) throws Exception{
		//Generates keywords with nGrams words

		MultiWordCollect[] nGramsA=data.biGrams;
		ArrayList<KeywordProbabilityObject> keywords = new ArrayList<KeywordProbabilityObject>();
		//Select bigrams or trigrams based on nGrams value
		switch (nGrams){
		case 2: nGramsA=data.biGrams;
				/*
				KeywordProbabilityObject kProb = new KeywordProbabilityObject();
				if(srchE.contains(SearchEngine.Google))
					kProb.setIsTargetGoogle(true);
				else
					kProb.setIsTargetGoogle(false);
				if(srchE.contains(SearchEngine.MSN))
					kProb.setIsTargetMSN(true);
				else
					kProb.setIsTargetMSN(false);
				kProb.setKeyword(searchTerms.toLowerCase());
				kProb.setSemplestProbability(1.0);
				keywords.add(kProb);
				*/
				break;
		case 3: nGramsA=data.triGrams; break;
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
			ArrayList<String> mWords= new ArrayList<String>();
			String[] subWrds;
			String kwrd;
			double wProb;
			boolean in=true;
			
			//Generate bigrams and trigrams in search Term and add them to the multi word list to be evaluated
			mWords.addAll(this.generateNgramsFromString(searchTerms, nGrams));

			// Generating Multiword alphabet
			// Extract multiword for each category in the list and multiply probabilities of each subword
			for(String optKey: optCateg){
				int mIndex= data.getnGramSubCatInd(optKey);
				ArrayList<String> auxArray = nGramsA[mIndex].getwordsInCateg(optKey);
				if(auxArray!=null) mWords.addAll(auxArray);
				if (mWords != null){
					for(String mWrd:mWords){
						subWrds=mWrd.split("\\+");
						wProb=1.0;
						kwrd="";
						for(int n=0;n<subWrds.length;n++){
							if(kwrd.contains(subWrds[n])){
								in=true;
								break;
							}
							in=false;
							if(wordMap.containsKey(subWrds[n])){
								wProb=wProb*wordMap.get(subWrds[n]);
							}else {
								//logger.debug(subWrds[n]+" is not in wordmap");
								wProb=wProb*0.0;
							}
							kwrd=kwrd+subWrds[n]+" ";
						}
						
						if(!in && wProb>0 && !multWMap.containsKey(kwrd)){
								multWMap.put(kwrd, wProb);
						}
						
					}
				}
			}
			//Once the alphabet and probabilities have been generated, sort by probability.
			sorted_map.putAll(multWMap);
			
			//Generating Keywords
		    keySet=sorted_map.keySet();
		    iterator=keySet.iterator();
		    
		    String keyword;
		    i=0;
		    iterator=keySet.iterator();
		    String stcompare = searchTerms.replaceAll("\\s+$", "").replaceAll("^\\s+", "");
		    while(i<numkw){
		    		if(iterator.hasNext())keyword =iterator.next();
		    		else break;
		    		if(!keyword.replaceAll("\\s+$", "").replaceAll("^\\s+", "").equals(stcompare)){
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
		    }
		    return keywords;
		
	}
	
	private  ArrayList<String> generateNgramsFromString(String string, int nGrams){
		//Given a string returns an ArrayList of all the nGrams groups of words in the string serperated by a blank space
		ArrayList<String> ngrams = new ArrayList<String>();
		string = this.stemvStringNoFilter(string, data.dict);
		String[] words = string.split("\\s+");
		if(words.length >= nGrams ){
			for(int i=0; i <= words.length-nGrams; i++){
				String newWord = "";
				for(int j=0; j<nGrams ; j++){
					newWord = newWord+"+"+words[i+j];
				}
				ngrams.add(newWord.replaceAll("\\+$", "").replaceAll("^\\+", ""));
			}
		}
		
		return ngrams;
		
	}
	
	
	private static ArrayList<String> selectOptions(ArrayList<String> optKeys) throws IOException{
		//Selects patterns from top categories list to generate options for the user based on pre-defined crieteria


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
	    	if(numNodes>=4  && numrepeat >3){
	    		if(catUtils.last(optKey).length()>1){
		    		if(!optList2.containsKey(catUtils.take(optKey, numNEval))){
		    			optList2.put(catUtils.take(optKey, numNEval),new Double(numNodes));
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
	
	@Override
	public void initializeService(String str) throws Exception {
		data = new KWGenDmozLDAdata();
		Thread thread = new Thread(data);
		thread.start();
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
		KWGenDmozLDAServer kwGen =  new KWGenDmozLDAServer();
		kwGen.initializeService(null);
		String[] searchTerm = new String[1];
		String userInfo1="";
		BasicConfigurator.configure();
		while (!userInfo1.equals("exit")){
			//try{
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
			Integer[] nGrams = {100,100};
			KeywordProbabilityObject[] kw = kwGen.getKeywords(categories,null, new String[] {"Google", "MSN"}, uInf, searchTerm[0], adds, url, null ,nGrams);
			Double endTime =  new Long(System.currentTimeMillis()).doubleValue();
			System.out.println("Time for keywords: "+(endTime-startTime));
			for(KeywordProbabilityObject k: kw){
				String kaux=k.getKeyword();//.replaceAll("wed", "wedding");
				System.out.print(kaux+" "+k.getSemplestProbability()+", ");
			}
		
			PrintStream stdout = System.out;
			System.setOut(new PrintStream(new FileOutputStream("/semplest/data/biddingTest/default/keywords.txt")));

			//System.out.println("\n"+ (n+2)+" word keywords:");
			for(KeywordProbabilityObject k: kw){
				String kaux=k.getKeyword();//.replaceAll("wed", "wedding");
				System.out.println(kaux);
			}
			
			System.setOut(stdout);
			/*
			}catch(Exception e){
				logger.error(e);
			}*/
		}
	}
	/*
	public static void main(String[] args)
	{

		try
		{
			KWGenDmozLDAServer client = new KWGenDmozLDAServer();
			client.initializeService(null);
			long start = System.currentTimeMillis();
			ArrayList<String> res = client.getCategories(null, "peanut butter", null, null, null);
			double sec = (double) (System.currentTimeMillis() - start)/1000.0;
			System.out.println("categories took " + sec + " seconds");
			for (int i = 0; i < res.size(); i++)
			{
				System.out.println(res.get(i));
			}
			
			start = System.currentTimeMillis();
			ArrayList<String> selectCateg = new ArrayList<String>();
			selectCateg.add(res.get(1));
			System.out.println("Selected:"+res.get(1));
			ArrayList<ArrayList<String>> kw = client.getKeywords(selectCateg,null, "peanut butter", null, null, "http://peanutbutterlovers.com/", new Integer[]{50,50});
			sec = (double) (System.currentTimeMillis() - start)/1000.0;
			System.out.println("keywords took " + sec + " seconds");
			for(int n=0; n<kw.size(); n++){
				System.out.println("\n"+ (n+2)+" word keywords:");
				for(String k: kw.get(n)){
					System.out.print(k+", ");
				}
			}
	
		}
		catch (Exception e)
		{
			//logger.error(e.getSemplestErrorID() + e.getSemplestErrorMessage());
			e.printStackTrace();
		}
	} */



}
