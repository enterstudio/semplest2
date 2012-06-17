package semplest.keywords.ldatest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import semplest.keywords.javautils.TextUtils;
import semplest.keywords.javautils.ValueComparator;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.lda.KWGenLDAStatus;
import semplest.keywords.lda.MalletTopic;
import cc.mallet.types.Alphabet;


public class TestKWGenLDAServer {

	/**
	 * This class packages the Keyword generation process using used in GenerateKeywordsMixModels
	 * for a better integration with UI in a server manner.
	 * Keeps track of multiple queries and stores information for each of them.
	 * At least 30G of memory heap required to instance one of this objects;
	 * Data will be structured in a Query Hashmap. Every time the method getCateg(data) is called,\
	 * a new instance of a query will be generated and a string with the id of the query will be the first
	 * element in the ArrayList<String> returned to the client.
	 * @param args
	 * @throws Exception 
	 */
	
	// Properties:
	
	private static String baseModlPath = "/semplest/data/MalletDmozModels/";
	private static String baseMultiWPath = "/semplest/data/dmoz/multiwords/";
	//List of subcategories that have been trained
	private static String[] trainHtml = {"arts","business", "computers","games", "health", "home", "news", "recreation", "reference", "science", "shopping","society","sports"};
	private static String[] nGramsSubC = {"arts","business", "computers","health", "home", "recreation", "shopping","society","sports"};
	//General Description Model
	private MalletTopic descModl;
	//Array of models for each of the subcategories
	private MalletTopic[] subModl;
	private int maxQueries; //Max number of active queries per instance of KWGenLDAServer object
	private MultiWordCollect[] biGrams; //Collection of bigrams for each subcategory sorted by categories
	private MultiWordCollect[] triGrams; //Collection of trigrams for each subcategory sorted by categories
	
	private HashMap<String,KWGenLDAStatus> GenQueue; //Structure that contains all the active queries
	/*
	private int numCateg = 10; // Number of categories to consider when generating options for user
	String[] topCat; //Array of the top numCateg categories classified
	private TreeMap<String, Double> wordMap; //sorted map of keywords and probabilities for last run of getKW
	private boolean ready4kw, genericMade; // Final list of categories has been generated.
	private ArrayList<String> optList;
	private String data; //Input data for the kwgenerator;
	private InstanceList inferInst; //Instance of the input data;
	private double[] probDistInf; //Probability distribution of the last inferInst;
	private HashMap<String, Double> options; //Map of repeated patterns and counts
	private int indexFinCat; //index of the final subcategory selected
	*/
//---------------------------------------------------------------------------------------------------------------------------	
	public TestKWGenLDAServer() throws Exception{
	//Load and initialize all trained models into memory. 
				//Loading all models into memory
				double auxStartT, auxEndT;
				// Load description model for all categories
				System.out.println("Loading General Description Model...");
				descModl = new MalletTopic();
				double startT=System.currentTimeMillis();
				descModl.loadLDAInst(new File(baseModlPath+"description/dAll.inst"));
				descModl.loadLDAModel(new File("/semplest/data/MalletDmozModels/description/dAll.modl"));
				auxEndT = System.currentTimeMillis();
				System.out.println("Time to load: "+ TextUtils.timeElapsed(auxEndT-startT));
				maxQueries = 100000;
				GenQueue = new HashMap<String,KWGenLDAStatus>();
				
				//Load Model for each of the subcategories
				subModl= new MalletTopic[trainHtml.length];
				File instFileAux, modlFileAux;
				for (int i=0; i<trainHtml.length;i++){
					auxStartT=System.currentTimeMillis();
					subModl[i]=new MalletTopic();
					instFileAux = new File(baseModlPath+"html/top/"+trainHtml[i]+"/"+trainHtml[i]+".inst");
					modlFileAux = new File(baseModlPath+"html/top/"+trainHtml[i]+"/"+trainHtml[i]+".modl");
					System.out.println("Loading "+instFileAux);
					subModl[i].loadLDAInst(instFileAux);
					System.out.println("Loading "+modlFileAux);
					subModl[i].loadLDAModel(modlFileAux);
					auxEndT = System.currentTimeMillis();
					System.out.println("Time to load: "+TextUtils.timeElapsed(auxEndT-auxStartT));
				}
				System.out.println("Models loaded");
				
				System.out.println("Loading Bigrams for each subcategory");
				biGrams= new MultiWordCollect[nGramsSubC.length];
				for (int i=0; i< nGramsSubC.length; i++){
					String biPath = baseMultiWPath+nGramsSubC[i]+".txt.2";
					System.out.println("Loading"+biPath);
					biGrams[i]= new MultiWordCollect(nGramsSubC[i],biPath);
				}
				/*
				System.out.println("Loading Trigrams for each subcategory");
				triGrams= new MultiWordCollect[nGramsSubC.length];
				for (int i=0; i< nGramsSubC.length; i++){
					String triPath = baseMultiWPath+nGramsSubC[i]+".txt.3";
					System.out.println("Loading"+triPath);
					triGrams[i]= new MultiWordCollect(nGramsSubC[i],triPath);
				}*/

	}

	
	//-------------------------------------------------------------------------------------------------------------
	public ArrayList<String> getCateg(String indata) throws Exception{
		String id="-1";
		if(GenQueue.size()>=maxQueries) throw new Exception("Too many queries for this Server");
		for(int v=0; v<maxQueries; v++){
			id = new Integer(v).toString();
			if(!GenQueue.containsKey(id)) break;
		}
		KWGenLDAStatus newQuery = new KWGenLDAStatus(id);
		newQuery.data=indata;
		TreeMap<String,Double> sorted_opt=this.inferFromData(descModl,newQuery);
	    //Reduce number of options for the user based on repetition patterns
	    this.selectOptions(sorted_opt,2,newQuery);
	    newQuery.ready4kw=false;
	    newQuery.genericMade=false;
	    GenQueue.put(id, newQuery);
	    if(newQuery.optList.size()==0){
	    	//if no repetition pattern detected we present all the subcategories in the top 10 options
	    	//for user to select
	    	this.makeGenericCategList(newQuery);
	    }
	    if (newQuery.optList.size()==1) {
	    	newQuery.optList = this.getCateg(0, id);
	    	return newQuery.optList;
	    }  	
	    return this.appendID(newQuery.optList, id);
	    
	}

//-------------------------------------------------------------------------------------------------------------
	public ArrayList<String> getCateg(int index, String id) throws Exception{
		//Get categories after the main subcategory has been selected
		//id corresponds to the ID of the query
		KWGenLDAStatus query = GenQueue.get(id);
		String finalCat;
		if(index==-1){
			if (query.genericMade==false){
				this.makeGenericCategList(query);
				query.ready4kw=false;
				return this.appendID(query.optList, id);
			} else{
				throw new Exception("Not Enough Information");
			}
		}
		
		//selecting subcategory
		finalCat = query.optList.get(index);
		finalCat = catUtils.last(finalCat);
		System.out.println("Subcategory selected: "+finalCat);
		query.indexFinCat=-1;
		for (int i=0; i<trainHtml.length;i++){
		   if(trainHtml[i].equals(finalCat))query.indexFinCat = i;
		}
		TreeMap<String,Double> sorted_opt = this.inferFromData(subModl[query.indexFinCat],query);
		
		this.selectOptions(sorted_opt,20,query);
		query.ready4kw=true;
		return this.appendID(query.optList, id);
	}
	//-----------------------------------------------------------------------------------------------------------------
		public boolean ready4kw(String id){
			//Returns true if kwGenLDA is ready to generate keywords or it needs another getCateg
			return GenQueue.get(id).ready4kw;
		}

	//-----------------------------------------------------------------------------------------------------------------
		public ArrayList<String> getKw(int[] indexInt, int numkw, String id) throws Exception{
			int numNod;
			KWGenLDAStatus query = GenQueue.get(id);
			String instLabel,cataux;
			ArrayList<Integer> auxList;
			ArrayList<String> keywords = new ArrayList<String>();
			for(int n=0; n<indexInt.length;n++){
				System.out.println("Selected: "+query.optList.get(indexInt[n]));
			}
			if(query.ready4kw==true){
			    //Create a Hashtable that contains the options selected and the indexes of the instances that satisfy those options
				 Hashtable<String, ArrayList<Integer>> optCateg = new Hashtable<String, ArrayList<Integer>>();
			    for (int m=0; m<subModl[query.indexFinCat].getInstances().size(); m++){
			    	instLabel = subModl[query.indexFinCat].getInstanceLabel(m);
			    	for (int n=0; n<indexInt.length;n++){
			    		if(indexInt[n]==-1) throw new Exception("Not enough information");
			    		cataux=query.optList.get(indexInt[n]);
			    		numNod = catUtils.nodes(cataux);
			    		if(catUtils.take(instLabel, numNod).equals(catUtils.take(cataux,numNod))){
			    			if (!optCateg.containsKey(cataux))
			    				optCateg.put(cataux, new ArrayList<Integer>());
			    			auxList = optCateg.get(cataux);
		    				auxList.add(new Integer(m));
		    				optCateg.put(cataux, auxList);
			    		}
			    	}
			    }
			    /* Uncomment if you want to print
				for(String optKey: optCateg.keySet()){
					java.util.Iterator<Integer> it= optCateg.get(optKey).iterator();
					System.out.println("Categories for option :" +optKey);
					while(it.hasNext()){
						System.out.println("\t\t"+lda.getInstanceLabel(it.next()));
					}
				}*/
				
				//**************************************************************************************
				// Now that we have generated a selection of categories that we want to use to generate our alphabet,
				// we need to generate that alphabet and infer the word probabilities for each of the word in the alphabet
			    query.wordMap= new TreeMap<String, Double>();
				int i=0;
				Set<String> keySet;
				java.util.Iterator<String> iterator;
				
				// Generating alphabet
				Alphabet newAlph = new Alphabet();
				for(String optKey: optCateg.keySet()){
					java.util.Iterator<Integer> it= optCateg.get(optKey).iterator();
					while(it.hasNext()){
						int auxIns = it.next();
						//System.out.println("Adding to alphabet category " + subModl[indexFinCat].getInstanceLabel(auxIns));
						newAlph = subModl[query.indexFinCat].add2Alphabet(newAlph,subModl[query.indexFinCat].getInstances(),auxIns);
						//System.out.println("Contains the word FARM :"+ newAlph.contains("farm"));
					}
				}
		
				//Generating Keywords
			    query.wordMap=subModl[query.indexFinCat].inferWordprob(query.probDistInf,newAlph);
			    keySet=query.wordMap.keySet();
			    iterator=keySet.iterator();
			    
			    String keyword;
			    i=0;
			    iterator=keySet.iterator();
			    while(i<numkw){
			    		if(iterator.hasNext())keyword =iterator.next();
			    		else keyword=null;
			    		keywords.add(keyword);
					    i++;
			    }
			    return this.appendID(keywords, id);
			}else{
				throw new Exception("Not ready to generate KeyWords");
			}
		    
		}
		
		public ArrayList<String> getKwMulti(int[] indexInt, int numkw, String id, int nGrams) throws Exception{
			//Generates keywords with nGrams words
			int numNod;
			MultiWordCollect[] nGramsA=biGrams;
			KWGenLDAStatus query = GenQueue.get(id);
			String instLabel,cataux;
			ArrayList<Integer> auxList;
			ArrayList<String> keywords = new ArrayList<String>();
			//Select bigrams or trigrams based on nGrams value
			switch (nGrams){
			case 2: nGramsA=biGrams; break;
			//case 3: nGramsA=triGrams; break;
			default: throw new Exception("nGrams value not valid");
			}
			
			for(int n=0; n<indexInt.length;n++){
				System.out.println("Selected: "+query.optList.get(indexInt[n]));
			}
			if(query.ready4kw==true){
			    //Create a Hashtable that contains the options selected and the indexes of the instances that 
				//satisfy those options
				int mIndex=-1;
				for(int i=0; i<nGramsA.length; i++){
					if(nGramsA[i].getID().equals(trainHtml[query.indexFinCat])) mIndex=i;
				}
				if(mIndex==-1) throw new Exception("No nGrams available for this subcategory");
				
				Hashtable<String, ArrayList<Integer>> optCateg = new Hashtable<String, ArrayList<Integer>>();
			    for (int m=0; m<nGramsA[mIndex].size(); m++){
			    	instLabel = nGramsA[mIndex].getCategName(m);
			    	for (int n=0; n<indexInt.length;n++){
			    		if(indexInt[n]==-1) throw new Exception("Not enough information");
			    		cataux=query.optList.get(indexInt[n]);
			    		numNod = catUtils.nodes(cataux);
			    		if(catUtils.take(instLabel, numNod).equals(catUtils.take(cataux,numNod))){
			    			if (!optCateg.containsKey(cataux))
			    				optCateg.put(cataux, new ArrayList<Integer>());
			    			auxList = optCateg.get(cataux);
		    				auxList.add(new Integer(m));
		    				optCateg.put(cataux, auxList);
			    		}
			    	}
			    }
			  //**************************************************************************************
				// Now that we have generated a selection of categories that we want to use to generate our alphabet,
				// we need to generate that alphabet and infer the word probabilities for each of the word in the alphabet
				HashMap<String, Double> multWMap = new HashMap<String, Double>();
				ValueComparator bvc =  new ValueComparator(multWMap);
				TreeMap<String,Double> sorted_map = new TreeMap(bvc);
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
				for(String optKey: optCateg.keySet()){
					java.util.Iterator<Integer> it= optCateg.get(optKey).iterator();
					while(it.hasNext()){
						int auxIns = it.next();
						mWords = nGramsA[mIndex].getwordsInCateg(auxIns);
						for(String mWrd:mWords){
							subWrds=mWrd.split("\\+");
							wProb=1.0;
							kwrd="";
							for(int n=0;n<subWrds.length;n++){
								if(kwrd.contains(subWrds[n])){
									in=true;
									break;
								}
								try{
									in=false;
									query.wordMap.containsKey(subWrds[n]);
									wProb=wProb*query.wordMap.get(subWrds[n]);
								} catch(NullPointerException e) {
									//System.out.println(subWrds[n]+" is not in wordmap");
									wProb=wProb*0.0;
								}
								kwrd=kwrd+subWrds[n]+" ";
							}
							if(!in) multWMap.put(kwrd, wProb);
						}
					}
				}
				sorted_map.putAll(multWMap);
				//Once the alphabet and probabilities have been generated, sort by probability.
		
				//Generating Keywords

			    keySet=sorted_map.keySet();
			    iterator=keySet.iterator();
			    
			    String keyword;
			    i=0;
			    iterator=keySet.iterator();
			    while(i<numkw){
			    		if(iterator.hasNext())keyword =iterator.next();
			    		else keyword=null;
			    		keywords.add(keyword);
					    i++;
			    }
			    return this.appendID(keywords, id);
			}else{
				throw new Exception("Not ready to generate KeyWords");
			}
			
		}
	//-------------------------------------------------------------------------------------------------------------
		public void killQuery(String id){
			//Removes a query from the Hashmap once we have finished with it.
			GenQueue.remove(id);
		}
	//-------------------------------------------------------------------------------------------------------------	
		private ArrayList<String> appendID(ArrayList<String> list, String id){
			//Generates a new ArrayList that contains the QueryID in the first element
			ArrayList<String> returnList;
		    returnList=(ArrayList<String>)list.clone();
		    returnList.add(0, id);
		    return returnList;
		}
	//-----------------------------------------------------------------------------------------------------------------	
		private TreeMap<String,Double> inferFromData(MalletTopic model, KWGenLDAStatus query){
			double[][] categInd;
			int i=0, n;
			//Select subcategory using description model
		    System.out.println("Data length: "+query.data.length());
		    // Create StemWord instances for description model
		    System.out.println("Creating infer inst...");
		    //timetest1= System.currentTimeMillis();
		    query.inferInst=model.CreateInferInstfromData("0", "Test Data", query.data);
		   
		    //System.out.println("Instance Created in :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		    // Find the closest trained instances
		    categInd=model.InstanceClassifierMat(query.inferInst, 0, 100);
		    query.probDistInf=model.getTestProb();
		    
		    //Select top Categories and pick common nodes on descriptions
		    //timetest1=System.currentTimeMillis();
		    //Remove Top/Regional from options
		    String aux, newoption;
		    String[] pair= new String[2];
		    for (int j=0; j<categInd[0].length;j++){
		    	aux=model.getInstanceLabel((int) categInd[0][j]);
		    	//System.out.println(aux);
		    	if (catUtils.take(aux, 2).equals("top/regional"));
		    	else {
		    		if(i>=query.numCateg) break;
		    		query.topCat[i]=aux;
		    		//System.out.println(aux);
		    		i++;
		    	}
		    }
		
			query.options = new HashMap<String, Double>();
			ValueComparator bvcAux = new ValueComparator(query.options);
			TreeMap<String,Double> sorted_opt = new TreeMap<String,Double>(bvcAux);
			
		    //Identify repeated patterns in top categories
		    for(n=0; n<query.topCat.length; n++){
		    	for (int m=0; m<n;m++){
		    		pair[0]=query.topCat[n]; pair[1]=query.topCat[m];
		    		newoption = catUtils.longestAncestor(pair);
		    		if(query.options.containsKey(newoption)){
		    			query.options.put(newoption, ((Double) query.options.get(newoption))+1.0);
		    		}else {
		    			query.options.put(newoption, new Double(1));
		    		}
		    	}
		    }
		    //System.out.println("Repeated patterns identified in :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		    //timetest1=System.currentTimeMillis();
		    /*Uncomment if you want to print
		    System.out.print("\n\nOptions:\n");
		    for(String optKey:optKeys){
		    	System.out.println(optKey +" : "+options.get(optKey));
		    }*/
		    
		    //Sort Options
		    sorted_opt.putAll(query.options);
		    System.out.println("\n");
		    return sorted_opt;
		}
//-------------------------------------------------------------------------------------------------------------------------------
	private void selectOptions(TreeMap<String,Double> sorted_opt, int numNEval,KWGenLDAStatus query){
		//Selects patterns from top categories list to generate options for the user based on pre-defined crieteria
		 // Criteria to select subcategories:
	    //1- # of nodes between 2 and 4, more than 1 repetition
	    //2- More than 4 nodes, at least 1 repetition
		Set<String> optKeys;
	    optKeys = sorted_opt.keySet();
	    query.optList = new ArrayList<String>();
	    int numNodes;
	    Double numrepeat;
	    for(String optKey:optKeys){
	    	numNodes = catUtils.nodes(optKey);
	    	numrepeat = query.options.get(optKey);
	    	if(numNodes>=2 && numNodes<5 && numrepeat >1){
	    		if(!query.optList.contains(catUtils.take(optKey, numNEval))){
	    			query.optList.add(catUtils.take(optKey, numNEval));
	    		}
	    	}else{
	    		if(numNodes >= 5 && numrepeat >=1 ){
	    			if(!query.optList.contains(catUtils.take(optKey, numNEval))){
	    				query.optList.add(catUtils.take(optKey, numNEval));
	    			}
	    		}
	    	}
	    }

	}
//---------------------------------------------------------------------------------------------------------------
	private void makeGenericCategList(KWGenLDAStatus query){
		//Creates a list of all the subcategories in the top 10 options
		query.optList = new ArrayList<String>();
    	for(int m=0; m<query.topCat.length;m++){
	    		if(!query.optList.contains(catUtils.take(query.topCat[m], 2))){
	    			query.optList.add(catUtils.take(query.topCat[m], 2));
	    		}
	    }
    	query.genericMade = true;
	}

//----------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		// This is an examples of how to use KWGenLDA to generate keywords based on data obtained from a url.
		
		//Initialize KWGenLDA and load all models into memory (at least 25G of memory heap required)
		TestKWGenLDAServer kwGenerator = new TestKWGenLDAServer();
		// Get landing page from user
		//-----------------------URL1----------------------------------------------
		System.out.println("Please, introduce your landing page for query 1 (type \"exit\" to close) :");
		Scanner scanUrl = new Scanner(System.in);
		String url1 = scanUrl.nextLine(); 	    
		System.out.println("Please, introduce path to file containing user info (type \"exit\" to close) :");
		Scanner scanFile = new Scanner(System.in);
		String userInfo1 = scanFile.nextLine(); 
		System.out.println("Please, introduce weight for user input (number from 0 to 1)");
		Scanner scanWeight = new Scanner(System.in);
		String userWeight = scanWeight.nextLine(); 
		//----------------------------------------------------------------------------
		/*//-----------------------URL2--------------------------------------------------
		System.out.println("Please, introduce your landing page for query 2 (type \"exit\" to close) :");
		scanUrl = new Scanner(System.in);
		String url2 = scanUrl.nextLine();
		*/
		//-----------------------------------------------------------------------------------
		String data1,data2;
		ArrayList<String> words1, words2, userIn1, keywords1,keywords2, bikwords1, trikwords1,categories1,categories2;
		String index,mySentence,id1, id2;
		Scanner scan;
		String[] indexes;
		int[] indexInt;
		Double weight1;
		while (!url1.equals("exit")){ 
			//--------------------------URL1------------------------------------------
			// Create data from URL1
			if(url1.contains(".clean"))
				//words1 = TextUtils.validHtmlWords (url1);
				words1 = TextUtils.validTextWords (url1);
			else	
				words1 = TextUtils.validHtmlWords (url1);
		    System.out.println("Words from URL1: "+ words1.size());
		    data1 ="";
		    
		    //Create data from user input
		    userIn1=TextUtils.validTextWords(userInfo1);
		    System.out.println("Words from user input: "+userIn1.size());
		    //Calculate multiplication factor for user input
		    int repeatUser=1;
		    int repeatUrl=1;
		    weight1=Double.parseDouble(userWeight);
		    if(words1.size()>=userIn1.size()&& weight1!=1)
		    	repeatUser=(int) Math.round(weight1*words1.size()/(userIn1.size()*(1-weight1)));
		    if(words1.size()<userIn1.size()&& weight1!=0)
		    	repeatUrl=(int) Math.round(userIn1.size()*(1-weight1)/(weight1*words1.size()));
		    if (weight1==0){
		    	repeatUser=0;
		    }
		    if (weight1==1){
		    	repeatUrl=0;
		    }
		    System.out.println("Number of times to repeat user data "+repeatUser);
		    System.out.println("Number of times to repeat ulr data "+repeatUrl);
		    double finalweight = 1.0*(userIn1.size()*repeatUser)/(words1.size()*repeatUrl+userIn1.size()*repeatUser);
		    System.out.println("Final weight of user data"+ finalweight);
		    //add weighted data from url
		    for(int n=0; n<repeatUrl;n++){
			    for( String s : words1 ) {
			    	data1 = data1+" "+s;
			    	//System.out.print(s+"  ");
			    }
		    }
		    //add weighted data from user
		    for(int n=0; n<repeatUser;n++){
			    for( String s : userIn1 ) {
			    	data1 = data1+" "+s;
			    	//System.out.print(s+"  ");
			    }
		    }
		    
		    
		    //Multiply user input
		    //Infer options for user input
			categories1=kwGenerator.getCateg(data1);
			id1=categories1.remove(0);
			System.out.println("Query ID1 : "+id1);
			//-------------------------------------------------------------------------
			/*//-------------------------URL2--------------------------------------------
			// Create data from URL2
		    words2 = TextUtils.validHtmlWords (url2);
		    System.out.println("Words from URL2: "+ words2.size());
		    data2 ="";
		    for( String s : words2 ) {
		    	data2 = data2+" "+s;
		    	//System.out.print(s+"  ");
		    }
		    //Infer options for user input
			categories2=kwGenerator.getCateg(data2);
			id2=categories2.remove(0);
			System.out.println("Query ID2 : "+id2);
			*///--------------------------------------------------------------------------
			//---------------------- URL1-----------------------------------------------
			while(!kwGenerator.ready4kw(id1)){
				//We did not have enough information to infer the final set of options for the user
				//We present the user a preliminary version of categories to select the main subcategory
				System.out.print("\nPlease, type one index of the following category that best fits your product 1:\n");
		    	System.out.println("(Type -1 if none are acceptable)");
		    	for (int i=0; i<categories1.size();i++){
		    		System.out.println(i+" - "+categories1.get(i));
		    	}
		    	//Get index from user
		    	scanUrl = new Scanner(System.in);
				index = scanUrl.nextLine();
				try{
					categories1=kwGenerator.getCateg(Integer.parseInt(index),id1);
					id1=categories1.remove(0);
					System.out.println("Query ID1 : "+id1);
				}catch(Exception e){
					System.out.println(e);
					break;
				}
			}
			//------------------------------------------------------------------------------------------------------
			
			/*//--------------------------------URL 2--------------------------------------------------------
			while(!kwGenerator.ready4kw(id2)){
				//We did not have enough information to infer the final set of options for the user
				//We present the user a preliminary version of categories to select the main subcategory
				System.out.print("\nPlease, type one index of the following category that best fits your product 2:\n");
		    	System.out.println("(Type -1 if none are acceptable)");
		    	for (int i=0; i<categories2.size();i++){
		    		System.out.println(i+" - "+categories2.get(i));
		    	}
		    	//Get index from user
		    	scanUrl = new Scanner(System.in);
				index = scanUrl.nextLine();
				try{
					categories2=kwGenerator.getCateg(Integer.parseInt(index),id2);
					id2=categories2.remove(0);
					System.out.println("Query ID2 : "+id2);
				}catch(Exception e){
					System.out.println(e);
					break;
				}
			}
			
			*///---------------------------------------------------------------------------------------------------------
			
			//------------------------------URL 1----------------------------------------------------------------------
			//User is ready to select the final set of categories to generate keywords
			if(kwGenerator.ready4kw(id1)){
				System.out.print("\nPlease, type indexes of the following categories that best fits your product 1 separated by ',':\n");
		    	System.out.println("(Type -1 if none are acceptable)");
		    	for (int i=0; i<categories1.size();i++){
		    		System.out.println(i+" - "+categories1.get(i));
		    	}
		    	//Get indexes from user
		        scan = new Scanner(System.in);
			    mySentence = scan.nextLine(); 
			    indexes = mySentence.split(",");
			    indexInt = new int[indexes.length];

			    for (int m=0; m<indexes.length;m++){
			    	indexInt[m]=Integer.parseInt(indexes[m]);
			    }
			    try{//Get keywords based on user input
			    	keywords1=kwGenerator.getKw(indexInt, 50,id1);
			    	bikwords1=kwGenerator.getKwMulti(indexInt, 50, id1, 2);
			    	//trikwords1=kwGenerator.getKwMulti(indexInt, 50, id1, 3);
			    	kwGenerator.killQuery(id1); //Remove query from list
			    	keywords1.remove(0);
			    	bikwords1.remove(0);
			    	//trikwords1.remove(0);
			    	//for(String kw:trikwords1) System.out.println(kw);
			    	for(String kw:bikwords1) System.out.println(kw);
			    	for(String kw:keywords1)System.out.println(kw);
			    }catch(Exception e){
			    	kwGenerator.killQuery(id1); //Remove query from list
			    	System.out.println(e);
			    }
			}
			//---------------------------------------------------------------------------------------------------------
			
			/*//------------------------------URL 2----------------------------------------------------------------------
			//User is ready to select the final set of categories to generate keywords
			if(kwGenerator.ready4kw(id2)){
				System.out.print("\nPlease, type indexes of the following categories that best fits your product 2 separated by ',':\n");
		    	System.out.println("(Type -1 if none are acceptable)");
		    	for (int i=0; i<categories2.size();i++){
		    		System.out.println(i+" - "+categories2.get(i));
		    	}
		    	//Get indexes from user
		        scan = new Scanner(System.in);
			    mySentence = scan.nextLine(); 
			    indexes = mySentence.split(",");
			    indexInt = new int[indexes.length];

			    for (int m=0; m<indexes.length;m++){
			    	indexInt[m]=Integer.parseInt(indexes[m]);
			    }
			    try{//Get keywords based on user input
			    	keywords2=kwGenerator.getKw(indexInt, 100,id2);
			    	kwGenerator.killQuery(id2);//Remove Query from list
			    	keywords2.remove(0);
			    	for(String kw:keywords2){
			    		System.out.println(kw);
			    	}
			    }catch(Exception e){
			    	System.out.println(e);
			    }
			}
			*///----------------------------------------------------------------------------------------
			System.out.println("Please, introduce your landing page 1 (type \"exit\" to close) :");
			scanUrl = new Scanner(System.in);
			url1 = scanUrl.nextLine(); 
			System.out.println("Please, introduce path to file containing user info (type \"exit\" to close) :");
			scanFile = new Scanner(System.in);
			userInfo1 = scanUrl.nextLine(); 
			System.out.println("Please, introduce weight for user input (number from 0 to 1)");
			scanWeight = new Scanner(System.in);
			userWeight = scanUrl.nextLine(); 
			/*System.out.println("Please, introduce your landing page 2 (type \"exit\" to close) :");
			scanUrl = new Scanner(System.in);
			url2 = scanUrl.nextLine(); */
		}
		
		
	}
}
	

