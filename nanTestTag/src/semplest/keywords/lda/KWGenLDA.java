package semplest.keywords.lda;

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
import cc.mallet.types.Alphabet;
import cc.mallet.types.InstanceList;

public class KWGenLDA {
	
	/**
	 * This class packages the Keyword generation process using used in GenerateKeywordsMixModels
	 * for a better integration with UI.
	 * At least 30G of memory heap required to instance one of this objects;
	 * @param args
	 * @throws Exception 
	 */
	
	// Properties:
	
	private static String baseModlPath = "/semplest/data/MalletDmozModels/";
	
	//List of subcategories that have been trained
	private static String[] trainHtml = {"arts","business", "computers","games", "health", "home", "news", "recreation", "reference", "science", "shopping","sports"};
	//General Description Model
	private MalletTopic descModl;
	//Array of models for each of the subcategories
	private MalletTopic[] subModl;
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
	
//---------------------------------------------------------------------------------------------------------------------------	
	public KWGenLDA() throws Exception{
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
				ready4kw=false; //Not ready to generate keywords
				topCat= new String[numCateg];
				
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

				//Number of keywords to print
				numCateg = 10;

	}

	
	//-------------------------------------------------------------------------------------------------------------
	public ArrayList<String> getCateg(String indata) throws Exception{
		
		data=indata;
		TreeMap<String,Double> sorted_opt=this.inferFromData(descModl);
	    //Reduce number of options for the user based on repetition patterns
	    this.selectOptions(sorted_opt,2);
	    ready4kw=false;
	    genericMade=false;
	    if(optList.size()==0){
	    	//if no repetition pattern detected we present all the subcategories in the top 10 options
	    	//for user to select
	    	this.makeGenericCategList();
	    }
	    if (optList.size()==1) {
	    	optList = this.getCateg(0);
	    }  	
	    return optList;
	}
//-------------------------------------------------------------------------------------------------------------	
	public ArrayList<String> getCateg(int index) throws Exception{
		//Get categories after the main subcategory has been selected
		String finalCat;
		if(index==-1){
			if (genericMade==false){
				this.makeGenericCategList();
				this.ready4kw=false;
				return optList;
			} else{
				throw new Exception("Not Enough Information");
			}
		}
		
		//selecting subcategory
		finalCat = optList.get(index);
		finalCat = catUtils.last(finalCat);
		System.out.println("Subcategory selected: "+finalCat);
		indexFinCat=-1;
		for (int i=0; i<trainHtml.length;i++){
		   if(trainHtml[i].equals(finalCat))indexFinCat = i;
		}
		TreeMap<String,Double> sorted_opt = this.inferFromData(subModl[indexFinCat]);
		
		this.selectOptions(sorted_opt,20);
		ready4kw=true;
		return optList;
	}
	//-----------------------------------------------------------------------------------------------------------------	
		private TreeMap<String,Double> inferFromData(MalletTopic model){
			double[][] categInd;
			int i=0, n;
			//Select subcategory using description model
		    System.out.println("Data length: "+data.length());
		    // Create StemWord instances for description model
		    System.out.println("Creating infer inst...");
		    //timetest1= System.currentTimeMillis();
		    inferInst=model.CreateInferInstfromData("0", "Test Data", data);
		   
		    //System.out.println("Instance Created in :"+TextUtils.timeElapsed(System.currentTimeMillis()-timetest1));
		    // Find the closest trained instances
		    categInd=model.InstanceClassifierMat(inferInst, 0, 100);
		    probDistInf=model.getTestProb();
		    
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
		    		if(i>=numCateg) break;
		    		topCat[i]=aux;
		    		System.out.println(aux);
		    		i++;
		    	}
		    }
		
			options = new HashMap<String, Double>();
			ValueComparator bvcAux = new ValueComparator(options);
			TreeMap<String,Double> sorted_opt = new TreeMap<String,Double>(bvcAux);
			
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
		    return sorted_opt;
		}
//-------------------------------------------------------------------------------------------------------------------------------
	private void selectOptions(TreeMap<String,Double> sorted_opt, int numNEval){
		//Selects patterns from top categories list to generate options for the user based on pre-defined crieteria
		 // Criteria to select subcategories:
	    //1- # of nodes between 2 and 4, more than 1 repetition
	    //2- More than 4 nodes, at least 1 repetition
		Set<String> optKeys;
	    optKeys = sorted_opt.keySet();
	    optList = new ArrayList<String>();
	    int numNodes;
	    Double numrepeat;
	    for(String optKey:optKeys){
	    	numNodes = catUtils.nodes(optKey);
	    	numrepeat = options.get(optKey);
	    	if(numNodes>=2 && numNodes<5 && numrepeat >1){
	    		if(!optList.contains(catUtils.take(optKey, numNEval))){
	    			optList.add(catUtils.take(optKey, numNEval));
	    		}
	    	}else{
	    		if(numNodes >= 5 && numrepeat >=1 ){
	    			if(!optList.contains(catUtils.take(optKey, numNEval))){
	    				optList.add(catUtils.take(optKey, numNEval));
	    			}
	    		}
	    	}
	    }

	}
//---------------------------------------------------------------------------------------------------------------
	private void makeGenericCategList(){
		//Creates a list of all the subcategories in the top 10 options
		optList = new ArrayList<String>();
    	for(int m=0; m<topCat.length;m++){
	    		if(!optList.contains(catUtils.take(topCat[m], 2))){
	    			optList.add(catUtils.take(topCat[m], 2));
	    		}
	    }
    	genericMade = true;
	}
//-----------------------------------------------------------------------------------------------------------------
	public boolean ready4kw(){
		//Returns true if kwGenLDA is ready to generate keywords or it needs another getCateg
		return ready4kw;
	}

//-----------------------------------------------------------------------------------------------------------------
	public ArrayList<String> getKw(int[] indexInt, int numkw) throws Exception{
		int numNod;
		String instLabel,cataux;
		ArrayList<Integer> auxList;
		ArrayList<String> keywords = new ArrayList<String>();
		if(ready4kw==true){
		    //Create a Hashtable that contains the options selected and the indexes of the instances that satisfy those options
			 Hashtable<String, ArrayList<Integer>> optCateg = new Hashtable<String, ArrayList<Integer>>();;
		    for (int m=0; m<subModl[indexFinCat].getInstances().size(); m++){
		    	instLabel = subModl[indexFinCat].getInstanceLabel(m);
		    	for (int n=0; n<indexInt.length;n++){
		    		if(indexInt[n]==-1) throw new Exception("Not enough information");
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
		    wordMap= new TreeMap<String, Double>();
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
					newAlph = subModl[indexFinCat].add2Alphabet(newAlph,subModl[indexFinCat].getInstances(),auxIns);
					//System.out.println("Contains the word FARM :"+ newAlph.contains("farm"));
				}
			}
	
			//Generating Keywords
		    wordMap=subModl[indexFinCat].inferWordprob(probDistInf,newAlph);
		    keySet=wordMap.keySet();
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
		    return keywords;
		}else{
			throw new Exception("Not ready to generate KeyWords");
		}
	    
	}
//----------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws Exception {
		// This is an examples of how to use KWGenLDA to generate keywords based on data obtained from a url.
		
		//Initialize KWGenLDA and load all models into memory (at least 25G of memory heap required)
		KWGenLDA kwGenerator = new KWGenLDA();
		// Get landing page from user
		System.out.println("Please, introduce your landing page (type \"exit\" to close) :");
		Scanner scanUrl = new Scanner(System.in);
		String url = scanUrl.nextLine(); 	    
		String data ="";
		ArrayList<String> words, keywords, categories;
		String index,mySentence;
		Scanner scan;
		String[] indexes;
		int[] indexInt;
		while (!url.equals("exit")){ 
			// Create data from URL
		    words = TextUtils.validHtmlWords (url);
		    System.out.println("Words from URL: "+ words.size());
		    data ="";
		    for( String s : words ) {
		    	data = data+" "+s;
		    	//System.out.print(s+"  ");
		    }
		    //Infer options for user input
			categories=kwGenerator.getCateg(data);
			while(!kwGenerator.ready4kw()){
				//We did not have enough information to infer the final set of options for the user
				//We present the user a preliminary version of categories to select the main subcategory
				System.out.print("\nPlease, type one index of the following category that best fits your product:\n");
		    	System.out.println("(Type -1 if none are acceptable)");
		    	for (int i=0; i<categories.size();i++){
		    		System.out.println(i+" - "+categories.get(i));
		    	}
		    	//Get index from user
		    	scanUrl = new Scanner(System.in);
				index = scanUrl.nextLine();
				try{
					categories=kwGenerator.getCateg(Integer.parseInt(index));
				}catch(Exception e){
					System.out.println(e);
					break;
				}
			}
			//User is ready to select the final set of categories to generate keywords
			if(kwGenerator.ready4kw()){
				System.out.print("\nPlease, type indexes of the following categories that best fits your product separated by ',':\n");
		    	System.out.println("(Type -1 if none are acceptable)");
		    	for (int i=0; i<categories.size();i++){
		    		System.out.println(i+" - "+categories.get(i));
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
			    	keywords=kwGenerator.getKw(indexInt, 100);
			    	for(String kw:keywords){
			    		System.out.println(kw);
			    	}
			    }catch(Exception e){
			    	System.out.println(e);
			    }
			}
			System.out.println("Please, introduce your landing page (type \"exit\" to close) :");
			scanUrl = new Scanner(System.in);
			url = scanUrl.nextLine(); 
		}
		
	}

}
