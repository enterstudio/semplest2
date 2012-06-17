package semplest.keywords.ldatest;

/**
 * Test version of the keyword generation process
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
import semplest.keywords.lda.MalletTopic;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;
import cc.mallet.types.InstanceList;

public class KWGenDmozLDAServerTest {
	
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAServerTest.class);
	//Search index for categories
	private static KWGenDmozLDAdataTest data;
	public KWGenDmozLDAServerTest() {

	}
	public ArrayList<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception {
		if(searchTerm==null || searchTerm.length()==0) throw new Exception("No search term provided");
		if(url!=null) url = TextUtils.formURL(url);
		ArrayList<String> categories = this.getCategories(searchTerm);
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
	

	public ArrayList<ArrayList<String>> getKeywords(ArrayList<String> categories,String companyName, String searchTerm, String description, String[] adds, String url, Integer[] nGrams) throws Exception {
		
		if(categories==null || categories.size()==0){
			throw new Exception("No categories provided");
		}
		if(nGrams==null || nGrams.length!=2){
			throw new Exception("Wrong number nGrams provided");
		} 
		//Add all data from inputs
		ArrayList<String> dataUrl= new ArrayList<String>();
		if(url!=null){
			url = TextUtils.formURL(url);
			dataUrl = TextUtils.validHtmlWords(url);
		}
		String data1 =  "";
		logger.info("Words from url:"+ dataUrl.size());
		for( String s : dataUrl ) {
	    	data1 = data1+" "+s;
	    }
		if(adds!=null){
			for(int i=0; i< adds.length; i++){
				data1= data1+" "+ adds;
			}
		}
		data1 = data1+" "+companyName+" "+searchTerm+" "+description;
		String stemdata1 = new String();
		String[] datacount = data1.split("\\s+");
		if(datacount.length<30) throw new Exception("Not enough data provided");
		stemdata1 = this.stemvString( data1, data.dict );
		ArrayList<ArrayList<String>> keywords = this.getKeywords(categories, searchTerm, stemdata1, 5000, nGrams);
		return keywords;
	}
	
	
	public ArrayList<ArrayList<String>> getKeywords(ArrayList<String> categories, String searchTerm, String data1, int numkw, Integer[] nGrams) throws Exception {
		//Create a ArrayList of the categories that satisfy options selected by the user and ArrayList
		//with data form those categories
		ArrayList<String> optCateg = new ArrayList<String>();
		ArrayList<ArrayList<String>> keywordsfull = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> keywords = new ArrayList<ArrayList<String>>();
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
		//Train LDA for categories selected and return sorted keywords
	    //and obtain word probability
	    HashMap<String, Double> wordMap= this.createWordMap(data1, trainLines, searchTerm);
	    //Rank monograms by probability
	    ValueComparator bvc =  new ValueComparator(wordMap);
		TreeMap<String,Double> wordM = new TreeMap(bvc);
		wordM.putAll(wordMap);
	    Set<String> keyS = wordM.keySet();
	    logger.info("wordMap Size: "+ wordM.size());
	    
	    logger.info("Generating Kewyords");
	    
	    //Generate a maximum of 5000 keywords nGrams[0] bigrams + nGrams[1] trigrams and the rest split between 4 grams and 5 grams
	    keywordsfull= this.getKwMultiCombined(optCateg, nGrams, wordMap, 5);
	    int kwCount = 0;
	    int iter = 0;
	    ArrayList<String> finalkwList;
	    for(ArrayList<String> kwList: keywordsfull){
	    	if(iter<2){
	    		finalkwList = kwList;
	    	}else{
	    		finalkwList = new ArrayList<String>();
	    	}
	    	int remain = numkw - kwCount;
	    	int num2Gen=0;
	    	//fourgrams and fivegrams 
		    if(iter==2)
		   		num2Gen = remain/2;
		    if(iter==3) num2Gen = remain;
		    int j=0;
		    for(String keyw: kwList){
		    		if(j>= num2Gen) break;
		    		finalkwList.add(keyw);
		    		j++;
		    }
		    
		    kwCount = kwCount+finalkwList.size();
	    	iter++;
	    	keywords.add(finalkwList);
	    }
	    
		return keywords;
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
		lda.setNumTopics(10);
		lda.LDAcreateModel(alpha, beta, numiter);
		InstanceList inferInst;
		double[][] categInd;
	    inferInst=lda.CreateInferInstfromData("0", "Test Data", data1);
			    
	    //Infer word probability based on input data
	    wordMap = lda.inferWordprob(inferInst, 0,true);
	    String qsStem = this.stemvString( searchTerm, data.dict ); 
	    if(searchTerm!=null){
	    	String[] terms = qsStem.split("\\s+");
		    for(int n=0; n<terms.length; n++){
		    	wordMap.put(terms[n], new Double(1.0));
		    }
	    }
		return wordMap;
	}
	
	private ArrayList<ArrayList<String>> getKwMultiCombined(ArrayList<String> optCateg, Integer[] nGrams, HashMap<String, Double> wordMap, int nGramsmax) throws Exception{
		
		//Returns 4 grams combining 2 and 3 grams
		ArrayList<String> bigrams = getKwMulti(optCateg, nGrams[0], wordMap, 2);
		ArrayList<String> trigrams = getKwMulti(optCateg, nGrams[1], wordMap, 3);
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		results.add(bigrams);
		results.add(trigrams);
		
		HashMap<String,ArrayList<String>> biGMap= new HashMap<String,ArrayList<String>>();
		// Create Hashmap of biwords;
		for(String base: bigrams){
			String[] words = base.split("\\s+");
			ArrayList<String> aux;
			for(int i=0; i<words.length; i++){
				
					if(biGMap.containsKey(words[i])){
						aux = biGMap.get(words[i]);
						aux.add(base);
					}else{
						aux = new ArrayList<String>();
						aux.add(base);
						biGMap.put(words[i], aux);
					}
				
			}
		}
		
		
		logger.info("Creating nGrams bigger than 3...");
		//Extend keyword list
		if(nGramsmax>=4){
			for(int m = 4; m<=nGramsmax; m++){
				ArrayList<String> tempArray = new ArrayList<String>();
				HashMap<String,Double> temp = new HashMap<String,Double>();
				ValueComparator bvc =  new ValueComparator(temp);
				TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
				ArrayList<String> baseList = results.get(m-3);
				for(String base: baseList){
					String[] words = base.split("\\s+");
					ArrayList<String> aux;
					for(int i=0; i<words.length; i++){				
						if(biGMap.containsKey(words[i])){
							aux=biGMap.get(words[i]);
							for(String gr: aux){
								boolean flag=false;
								String[] prts = gr.split("\\s+");
								for(int n=0;n<prts.length;n++){
										String stembase= stemvString( base, data.dict);
										stembase = stembase.replaceAll("\\s+", "");
										String stempart = stemvString( prts[n], data.dict);
										stempart = stempart.replaceAll("\\s+", "");
										String stemwrdsi = stemvString( words[i], data.dict);
										stemwrdsi = stemwrdsi.replaceAll("\\s+", "");
										if(!stempart.equals(stemwrdsi) && stembase.contains(stempart)){
											flag=true;
											break;
										}
									
								}
								if(!flag){
									String kwnew = base.replace(words[i],gr);
									kwnew = kwnew.replaceAll("\\s+", " ");
									temp.put(kwnew,this.calculateKWProb(kwnew, wordMap));
								}
							}
						}
						
					}
				}
				sorted_map.putAll(temp);
				Set<String> keySet = sorted_map.keySet();
				for(String key: keySet){
					tempArray.add(key);
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
	
	private ArrayList<String> getKwMulti(ArrayList<String> optCateg, int numkw, HashMap<String, Double> wordMap, int nGrams) throws Exception{
		//Generates keywords with nGrams words

		MultiWordCollect nGramsA=data.biGrams;
		ArrayList<String> keywords = new ArrayList<String>();
		//Select bigrams or trigrams based on nGrams value
		switch (nGrams){
		case 2: nGramsA=data.biGrams; break;
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
			// Generating Multiword alphabet
			// Extract multiword for each category in the list and multiply probabilities of each subword
			for(String optKey: optCateg){
				mWords = nGramsA.getwordsInCateg(optKey);
				if (mWords != null){
					for(String mWrd:mWords){
						subWrds=mWrd.split("\\+");
						wProb=1.0;
						kwrd="";
						String kwrdstem="";
						for(int n=0;n<subWrds.length;n++){
							String subWstem = this.stemvString( subWrds[n], data.dict);
							subWstem = subWstem.replaceAll("\\s+", "");
							if(kwrdstem.contains(subWstem)){
								in=true;
								break;
							}
							in=false;
							if(wordMap.containsKey(subWstem)){
								wProb=wProb*wordMap.get(subWstem);
							}else {
								//logger.debug(subWrds[n]+" is not in wordmap");
								wProb=wProb*0.0;
							}
							kwrd=kwrd+subWrds[n]+" ";
							kwrdstem=kwrdstem+subWstem;
						}
						
						if(!in && wProb>0){
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
		    double baseProb = 1.0;
		    while(i<numkw){
		    		if(iterator.hasNext())keyword =iterator.next();
		    		else break;
		    		if(baseProb>=1.0 && multWMap.get(keyword)<1.0)
		    			baseProb = multWMap.get(keyword);
		    		double diff = baseProb- multWMap.get(keyword);
		    		//if(nGrams==2 && diff>0.01718787) break;
		    		//if(nGrams==3 && diff>0.001718787) break;
		    		//logger.debug(diff+"\t"+keyword);
		    		keywords.add(keyword);
				    i++;
		    }
		    return keywords;
		
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
	
	public void initializeService(String str) throws Exception {
		data = new KWGenDmozLDAdataTest();
		Thread thread = new Thread(data);
		thread.start();
	}
	
	private String stemvString( String raws, dictUtils dict){
		//Returns the stemmed version of a word
	    String os = "";
	    for( String w: raws.split("\\s+"))
	      os = os + dict.getStemWord( w ) + " ";
	    return os;
	  }
	
	public static void main(String[] args) throws Exception {
		KWGenDmozLDAServerTest kwGen =  new KWGenDmozLDAServerTest();
		kwGen.initializeService(null);
		String[] searchTerm = new String[1];
		String userInfo1="";
		BasicConfigurator.configure();
		while (!userInfo1.equals("exit")){
			try{
			logger.info("\nPlease, introduce search terms:");
			Scanner scanFile = new Scanner(System.in);
			searchTerm[0] = scanFile.nextLine();
			String[] adds= new String[1];
			adds[0] = "";
			String description="";
			
			logger.info("Search Terms: "+searchTerm[0]);
			ArrayList<String> categOpt = kwGen.getCategories(null, searchTerm[0], null, null, null);
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
			categories.add(categOpt.get(0));
			
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
			/*
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
			*/
			
			
			Integer[] nGrams = {50,50};
			ArrayList<ArrayList<String>> kw = kwGen.getKeywords(categories,null, searchTerm[0], uInf, adds, url,nGrams);
			
			for(int n=0; n<4; n++){
				System.out.println("\n"+ (n+2)+" word keywords:");
				for(String k: kw.get(n)){
					//k=k.replaceAll("wed", "wedding");
					System.out.print(k+", ");
				}
			}
			
			PrintStream stdout = System.out;
			System.setOut(new PrintStream(new FileOutputStream("/semplest/data/biddingTest/default/keywords.txt")));
			for(int n=0; n<4; n++){
				System.out.println("\n"+ (n+2)+" word keywords:");
				for(String k: kw.get(n)){
					System.out.println(k);
				}
			}
			System.setOut(stdout);
			}catch(Exception e){
				logger.error(e);
			}
		}
	}



}
