package semplest.keywords.lda;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import org.apache.log4j.Logger;

import cc.mallet.types.InstanceList;


import semplest.keywords.javautils.TextUtils;
import semplest.keywords.javautils.ValueComparator;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;

import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

public class KWGenDmozLDAServer implements SemplestKeywordLDAServiceInterface{
	
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAServer.class);
	//Search index for categories
	private static KWGenDmozLDAdata data;
	public KWGenDmozLDAServer() {

	}
	@Override
	public ArrayList<String> getCategories(String[] searchTerm) throws Exception {
		//Get category results from dmoz query
		String qs="";
		String[] res;
		String categories;
		ArrayList<String> optInitial = new ArrayList<String>();
		int numresults = 100; // Number of results from the query
		for(int i=0; i<searchTerm.length;i++){
			qs=qs+searchTerm[i]+" ";
		}
		String qsStem = this.stemvString( qs, data.dict );
		res = data.dl.search(qsStem,numresults);
		for(int i=0; i<res.length; i++){
			categories = res[i].replaceAll("\\s", "");
			if(catUtils.validcat(categories))
					optInitial.add(categories);
					//System.out.println(categories);
		}

		//Select repeated patterns
		ArrayList<String> optList= selectOptions(optInitial);
		return optList;
	}
	@Override
	public ArrayList<String> getKeywords(ArrayList<String> categories, String data1, int numkw, int nGrams) throws Exception {
		//Create a ArrayList of the categories that satisfy options selected by the user and ArrayList
		//with data form those categories
		ArrayList<String> optCateg = new ArrayList<String>();
		ArrayList<String> keywords = new ArrayList<String>();
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
	    				System.out.println(label);
	    				optCateg.add(label);
	    				//Gather training data
	    				trainLines.add(data.TrainingData.get(label));
	    			}
	    		}
	    	}
	    }
		//Train LDA for categories selected and return sorted keywords
		
		//Instanciate topic model
		MalletTopic lda = new MalletTopic();
		double alpha=0.01;
		double beta=0.01;
		int numiter=100;
		System.out.println("Number of categories" + trainLines.size());
		lda.CreateInstances(trainLines);
		lda.setNumTopics(5);
		lda.LDAcreateModel(alpha, beta, numiter);
		InstanceList inferInst;
		double[][] categInd;
		TreeMap<String, Double> wordM;
	    inferInst=lda.CreateInferInstfromData("0", "Test Data", data1);
	    wordM = lda.inferWordprob(inferInst, 0); 
	    Set<String> keyS = wordM.keySet();
	    System.out.println("wordMap Size: "+ wordM.size());
	    int i=0;
	    for(String keys2 : keyS){
	    	if(i>=numkw)break;
	    	//System.out.print(" "+keys2+",");
	    	keywords.add(keys2);
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
	    	numtop=3;
	    int numresults=0;
	    for(int i=0; i<optKeys.size(); i++){
	    	if(numresults>=numtop) break;
	    	String key = catUtils.init(optKeys.get(i));
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
	
	@Override
	public void initializeService(String str) throws Exception {
		data = new KWGenDmozLDAdata();
		Thread thread = new Thread(data);
		thread.start();
	}
	
	public String stemvString( String raws, dictUtils dict){
		//Returns the stemmed version of a word
	    String os = "";
	    for( String w: raws.split("\\s+"))
	      os = os + dict.getStemWord( w ) + " ";
	    return os;
	  }
	
	public static void main(String[] args) throws Exception {
		KWGenDmozLDAServer kwGen =  new KWGenDmozLDAServer();
		kwGen.initializeService(null);
		String[] searchTerm = {"peanut butter"};
		String aux="";
		for(int i=0; i< searchTerm.length;i++){
			aux=aux+searchTerm[i]+" ";
		}
		System.out.println("Search Terms: "+aux);
		ArrayList<String> categOpt = kwGen.getCategories(searchTerm);
		System.out.println("\nCategory options:");
		for (String opt:categOpt){
			System.out.println(opt);
		}
		System.out.println("\nSubcategories form selected :");
		ArrayList<String> categories = new ArrayList<String>();
		categories.add(categOpt.get(0));
		
		System.out.println("Please, introduce path to file containing user info (type \"exit\" to close) :");
		Scanner scanFile = new Scanner(System.in);
		String userInfo1 = scanFile.nextLine(); 
		ArrayList<String> words1;
		if(userInfo1.contains(".clean"))
			words1 = TextUtils.validTextWords (userInfo1);
		else	
			words1 = TextUtils.validHtmlWords (userInfo1);
		String data1="";
		for( String s : words1 ) {
	    	data1 = data1+" "+s;
	    	//System.out.print(s+"  ");
	    }
		ArrayList<String> kw = kwGen.getKeywords(categories,data1,50, 1);
		for(String k: kw){
			System.out.println(k);
		}
	}



}
