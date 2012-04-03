package semplest.keywords.lda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import semplest.keywords.javautils.DmozLucene;
import semplest.keywords.javautils.ValueComparator;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.ioUtils;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;



public class KWGenDmozLDAServer implements SemplestKeywordLDAServiceInterface{
	//Search index for categories
	private DmozLucene dl; //Index of categories
	public KWGenDmozLDAServer(){
		// Index description information
		 dl = new DmozLucene();
		 System.out.println("Indexing dmoz description data...");
		 dl.loadDesc();
		 System.out.println("Data indexed!");
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
		res = dl.search(qs,numresults);
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
	    for(int i=0; i<numtop; i++){
	    	arrayOpt.add(catUtils.init(optKeys.get(i)));
	    }
	    //Add rest of the patterns
	    for(String key: sorted_optKeys2){
	    	if(!arrayOpt.contains(key))
	    		arrayOpt.add(key);
	    }
	  
	    return arrayOpt;
	    
	}
	
	public static void main(String[] args) throws Exception {
		KWGenDmozLDAServer kwGen =  new KWGenDmozLDAServer();
		String[] searchTerm = {"fine wine liquor wine tasting upper west side"};
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
	}

}
