package semplest.keywords.lda;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashMap;

import semplest.keywords.javautils.*;

import cc.mallet.types.*;

public class GenerateKeywordsMixModels {

	/**
	 * Third version of the generate Keyword program
	 * When initializing program, it will load the general description/all.modl into memory
	 * and all the rest of the models for the subcategories of the html data (business, shopping...)
	 * Then it finds the top 10 categories closest to the url that we want to classify and based on repetition of the top two nodes, 
	 * it will select which model of the subcateogories should be used for the final classification. In case of uncertainity, ask user.
	 * Once the subcategory has been selected it will perform the same operation with the html data of the subcategory selected
	 * and present the top categories selected to the user.
	 * User will select which is the one that best fits his campain and it will generate set of keywords based on input.
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		//Loading all models into memory
		String baseModlPath = "/semplest/data/MalletDmozModels/";
		//List of subcategories that have been trained
		String[] trainHtml = {"arts","business", "computers","games", "health", "home", "news", "recreation", "reference", "science", "shopping","sports"};
		double auxStartT, auxEndT;
		// Load description model for all categories
		MalletTopic descModl = new MalletTopic();
		System.out.println("Loading General Description Model...");
		double startT=System.currentTimeMillis();
		descModl.loadLDAInst(new File(baseModlPath+"description/dAll.inst"));
		descModl.loadLDAModel(new File("/semplest/data/MalletDmozModels/description/dAll.modl"));
		auxEndT = System.currentTimeMillis();
		System.out.println("Time to load: "+ TextUtils.timeElapsed(auxEndT-startT));
		
		//Load Model for each of the subcategories
		MalletTopic[] subModl= new MalletTopic[trainHtml.length];
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

		int numCateg = 10; // Number of categories to consider when generating options for user  
		// Map to sort options by relevance (relevance will be number of pair of the common nodes)
		HashMap<String, Double> options; 
		ValueComparator bvcAux; 
		TreeMap<String,Double> sorted_opt;
		InstanceList inferInst;
		//Number of keywords to print
		int numWords = 50;
		
		
		// Get landing page from user
		System.out.println("Please, introduce your landing page (type \"exit\" to close) :");
		//String url = "http://www.bestbuy.com/site/Electronics/Audio/abcat0200000.c?id=abcat0200000"; //URL
		Scanner scanUrl = new Scanner(System.in);
	    String url = scanUrl.nextLine(); 
	    
	    String data ="";
		double[][] categInd;
		ArrayList<String> stemwords,words, optList;
		Set<String> optKeys;
		double timetest1;
		int i,n,numNodes,numNod;
		Double numrepeat;
		String finalCat,instLabel,cataux;
		Scanner scan;

	    String mySentence; 
	    String[] index;
	    int[] indexInt ;

	    ArrayList<Integer> auxList;
	    Hashtable<String, ArrayList<Integer>> optCateg;
	    
		TreeMap<String, Double> wordMap;
		Set<String> keySet; 
		java.util.Iterator<String> iterator;
	    
	    while(!url.equals("exit")){
			
			
			//----------- Select subcategory using description model-------------------------------------------
			auxStartT = System.currentTimeMillis();
			System.out.println("Selecting Sub-Category..."); 
			// Create data from URL
		    stemwords = TextUtils.validHtmlWords (url);
		    words = stemwords;
		    System.out.println("Words from URL: "+ stemwords.size());
		    data ="";
		    for( String s : stemwords ) {
		    	data = data+" "+s;
		    	//System.out.print(s+"  ");
		    }
		    System.out.println("Data length: "+data.length());
		    // Create StemWord instances for description model
		    System.out.println("Creating infer inst...");
		    //timetest1= System.currentTimeMillis();
		    inferInst=descModl.CreateInferInstfromData("0", url, data);
		    //System.out.println("Instance Created in :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		    // Find the closest trained instances
		    timetest1= System.currentTimeMillis();
		    categInd=descModl.InstanceClassifierMat(inferInst, 0, 100);
		    System.out.println("Inference finished in :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		    
		    //Select top Categories and pick common nodes on descriptions
		    //timetest1=System.currentTimeMillis();
		    //Remove Top/Regional from options
		    String[] topCat= new String[numCateg];
		    String aux, newoption;
		    String[] pair= new String[2];
		    i=0;
		    
		    for (int j=0; j<categInd[0].length;j++){
		    	aux=descModl.getInstanceLabel((int) categInd[0][j]);
		    	//System.out.println(aux);
		    	if (catUtils.take(aux, 2).equals("top/regional"));
		    	else {
		    		if(i>=numCateg) break;
		    		topCat[i]=aux;
		    		System.out.println(aux);
		    		i++;
		    	}
		    }
		    //System.out.println("Top/Regional removed in :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		    //timetest1=System.currentTimeMillis();
		    
			options = new HashMap<String, Double>();
			bvcAux = new ValueComparator(options);
			sorted_opt = new TreeMap<String,Double>(bvcAux);
			
		    //Identify repeated patterns in top categories
		    for(n=0; n<topCat.length; n++){
		    	for (int m=0; m<n;m++){
		    		pair[0]=topCat[n]; pair[1]=topCat[m];
		    		newoption = catUtils.longestAncestor(pair);
		    		if(options.containsKey(newoption)){
		    			options.put(newoption, ((Double) options.get(newoption))+1.0);
		    		}else {
		    			options.put(newoption, new Double(1));
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
		    sorted_opt.putAll(options);
		    System.out.println("\n");
		    // Criteria to select subcategories:
		    //1- # of nodes between 2 and 4, more than 1 repetition
		    //2- More than 4 nodes, at least 1 repetition
		    optKeys = sorted_opt.keySet();
		    n=1;
		    
		    optList = new ArrayList<String>();
		    for(String optKey:optKeys){
		    	numNodes = catUtils.nodes(optKey);
		    	numrepeat = options.get(optKey);
		    	if(numNodes>=2 && numNodes<5 && numrepeat >1){
		    		if(!optList.contains(catUtils.take(optKey, 2))){
		    			optList.add(catUtils.take(optKey, 2));
		    			System.out.println(n+"- "+catUtils.take(optKey, 2));
		    			n++;
		    		}
		    	}else{
		    		if(numNodes >= 5 && numrepeat >=1 ){
		    			if(!optList.contains(catUtils.take(optKey, 2))){
		    				optList.add(catUtils.take(optKey, 2));
		    				System.out.println(n+"- "+catUtils.take(optKey, 2));
				    		n++;
		    			}
		    		}
		    	}
		    }
		    /*//if no category has been found we weaken our criteria
		    if (optList.size()==0){
		    	for(String optKey:optKeys){
			    	numNodes = catUtils.nodes(optKey);
			    	numrepeat = options.get(optKey);
			    	if(numNodes>=2 && numrepeat >=1){
			    		if(!optList.contains(catUtils.take(optKey, 2))){
			    			optList.add(catUtils.take(optKey, 2));
			    			System.out.println(n+"- "+catUtils.take(optKey, 2));
			    			n++;
			    		}
			    	}
			    }
		    }
		    */
		    //System.out.println("Options for user created in :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		    
		    // Ask user to choose subcategory if we are not sure
		    if(optList.size()>1){
		    	System.out.print("\nPlease, type index of the above category that best fits your product:\n");
		    	System.out.println("(Type -1 if none are acceptable)");
		    	scan = new Scanner(System.in);
			    mySentence = scan.nextLine();
			    // If user does not like any of the categories
			    if ( Integer.parseInt(mySentence)!=-1){
				    finalCat = optList.get(Integer.parseInt(mySentence)-1);
				    finalCat = catUtils.last(finalCat);
			    }else{
			    	optList = new ArrayList<String>();
			    	n=1;
			    	for(int m=0; m<topCat.length;m++){
				    		if(!optList.contains(catUtils.take(topCat[m], 2))){
				    			optList.add(catUtils.take(topCat[m], 2));
				    			System.out.println(n+"- "+catUtils.take(topCat[m], 2));
				    			n++;
				    		}
				    }
			    	System.out.print("\nPlease, type index of the above category that best fit your product:\n");
			    	System.out.println("(Type -1 if none are acceptable)");
			    	scan = new Scanner(System.in);
				    mySentence = scan.nextLine();
			    }
		    } else{
		    	if (optList.size()!=0)
		    		mySentence = "1";
		    	else {
		    		optList = new ArrayList<String>();
			    	n=1;
			    	for(int m=0; m<topCat.length;m++){
				    		if(!optList.contains(catUtils.take(topCat[m], 2))){
				    			optList.add(catUtils.take(topCat[m], 2));
				    			System.out.println(n+"- "+catUtils.take(topCat[m], 2));
				    			n++;
				    		}
				    }
			    	System.out.print("\nPlease, type index of the above category that best fit your product:\n");
			    	System.out.println("(Type -1 if none are acceptable)");
			    	scan = new Scanner(System.in);
				    mySentence = scan.nextLine();
		    	}
		    }
		    if(Integer.parseInt(mySentence)==-1){
		    	System.out.println("Not enough information");
		    	break;
		    }
		    finalCat = optList.get(Integer.parseInt(mySentence)-1);
		    finalCat = catUtils.last(finalCat);
		 
		    System.out.println("Subcategory selected: "+finalCat);
		    int indexFinCat=-1;
		    for (i=0; i<trainHtml.length;i++){
		    	if(trainHtml[i].equals(finalCat))indexFinCat = i;
		    }
			auxEndT = System.currentTimeMillis();
			System.out.println("Time to select subcategory: "+TextUtils.timeElapsed(auxEndT-auxStartT));
			
			
			
			
		    //---------------Make inference from subcategory selected---------------------------------------------
			double auxStartT2 = System.currentTimeMillis();
			// Create data from URL
			data ="";
		    System.out.println("Words from URL: "+ words.size());
		    for( String s : words ) {
		    	data = data+" "+s;
		    	//System.out.print(s+"  ");
		    }
		    // Create Word instances for description model
		    inferInst=subModl[indexFinCat].CreateInferInstfromData("0", url, data);
		    // Find the closest trained instances
		    categInd=subModl[indexFinCat].InstanceClassifierMat(inferInst, 0, 100);
		    
		    
		    //Select top Categories and pick common nodes on descriptions
		    
		    //Remove Top/Regional from options
		    topCat= new String[numCateg];
		    pair= new String[2];
		    i=0;
		    for (int j=0; j<categInd[0].length;j++){
		    	aux=subModl[indexFinCat].getInstanceLabel((int) categInd[0][j]);
		    	
		    	if (catUtils.take(aux, 2).equals("top/regional"));
		    	else {
		    		if(i>=numCateg) break;
		    		topCat[i]=aux;
		    		System.out.println(aux);
		    		i++;
		    	}
		    }
		    options = new HashMap<String, Double>();
			bvcAux = new ValueComparator(options);
			sorted_opt = new TreeMap<String,Double>(bvcAux);
		    //Identify repeated patterns in top categories
		    for(n=0; n<topCat.length; n++){
		    	for (int m=0; m<n;m++){
		    		pair[0]=topCat[n]; pair[1]=topCat[m];
		    		newoption = catUtils.longestAncestor(pair);
		    		if(options.containsKey(newoption)){
		    			options.put(newoption, ((Double) options.get(newoption))+1.0);
		    		}else {
		    			options.put(newoption, new Double(1));
		    		}
		    	}
		    }
		    /*Uncomment if you want to print
		    System.out.print("\n\nOptions:\n");
		    for(String optKey:optKeys){
		    	System.out.println(optKey +" : "+options.get(optKey));
		    }*/
		    
		    //Sort Options
		    sorted_opt.putAll(options);
		    
		    // Criteria to select subcategories:
		    //1- # of nodes between 2 and 4, more than 1 repetition
		    //2- More than 4 nodes, at least 1 repetition
		    optKeys = sorted_opt.keySet();
		    n=1;
		    optList = new ArrayList<String>();
			auxEndT = System.currentTimeMillis();
			System.out.println("Time to infer for subcategory: " +TextUtils.timeElapsed(auxEndT-auxStartT2));
			System.out.println("Total time: "+TextUtils.timeElapsed(auxEndT-auxStartT));
			
		    System.out.print("\n\nPlease, type index of the following category that best fit your product:\n");
		    System.out.println("(Separate different options by ',')");
		    for(String optKey:optKeys){
		    	numNodes = catUtils.nodes(optKey);
		    	numrepeat = options.get(optKey);
		    	if(numNodes>=2 && numNodes<5 && numrepeat >1){
		    		if(!optList.contains(optKey)){
		    			optList.add(optKey);
		    			System.out.println(n+"- "+optKey);
		    			n++;
		    		}
		    	}else{
		    		if(numNodes >= 5 && numrepeat >=1 ){
		    			if(!optList.contains(optKey)){
		    				optList.add(optKey);
		    				System.out.println(n+"- "+optKey);
				    		n++;
		    			}
		    		}
		    	}
		    }
		    

//***********************************************************************************************************************		    
		    //Read Categories selected by the user
		    scan = new Scanner(System.in);
		    mySentence = scan.nextLine(); 
		    index = mySentence.split(",");
		    indexInt = new int[index.length];
		    optCateg = new Hashtable<String, ArrayList<Integer>>();
		    for (int m=0; m<index.length;m++){
		    	indexInt[m]=Integer.parseInt(index[m])-1;
		    }
		    
		    //Create a Hashtable that contains the options selected and the indexes of the instances that satisfy those options
		    for (int m=0; m<subModl[indexFinCat].getInstances().size(); m++){
		    	instLabel = subModl[indexFinCat].getInstanceLabel(m);
		    	for (n=0; n<index.length;n++){
		    		cataux=optList.get(indexInt[n]);
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
		    /* Uncoment if you want to print
			for(String optKey: optCateg.keySet()){
				java.util.Iterator<Integer> it= optCateg.get(optKey).iterator();
				System.out.println("Categories for option :" +optKey);
				while(it.hasNext()){
					System.out.println("\t\t"+lda.getInstanceLabel(it.next()));
				}
			}*/
			
		    
		    
		    
			//**************************************************************************************
			// Now that we have generated a selection of cateogries that we want to use to generate our alphabet,
			// we need to generate that alphabet and infer the word probabilities for each of the word in the alphabet
		    wordMap= new TreeMap<String, Double>();
			i=0;
			
			// Generating alphabet
			Alphabet newAlph = new Alphabet();
			for(String optKey: optCateg.keySet()){
				java.util.Iterator<Integer> it= optCateg.get(optKey).iterator();
				while(it.hasNext()){
					int auxIns = it.next();
					//System.out.println("Adding to alphabet category " + subModl[indexFinCat].getInstanceLabel(auxIns));
					newAlph = subModl[indexFinCat].add2Alphabet(newAlph,subModl[indexFinCat].getInstances(),auxIns);
					//System.out.println("Contains the word FARM :"+ newAlph.contains("farm"));
				}
			}

			//Generating Keywords
		    wordMap=subModl[indexFinCat].inferWordprob(inferInst, 0,newAlph);
		    keySet=wordMap.keySet();
		    iterator=keySet.iterator();
		    System.out.println("Using Alphabet for all cateogories selected:");
		    System.out.println("numWords: "+numWords);
		    System.out.print("KW Probabil \t\t\t KW");
		    System.out.println("");
		    String keyword;
		    i=0;
		    iterator=keySet.iterator();
		    while(i<numWords){
		    		if(iterator.hasNext())keyword =iterator.next();
		    		else keyword=null;
		    		if(keyword!=null)System.out.print(wordMap.get(keyword)+"\t\t"+keyword+"\t");
		    		else System.out.print("null\t\t"+"\t\t"+keyword+"\t\t");
		    		System.out.print("\n");
				    i++;
		    }
		    
		    System.out.println("Please, introduce your landing page (type \"exit\" to close) :");
		    url = scanUrl.nextLine(); 
		    
	    }
		
		    
	}
	   
	 
	    
}