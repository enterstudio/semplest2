package semplest.keywords.aoldata;

import java.io.*;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class AOLKeywordGenerator {
	/**
	 * This class reads the AOL search data files and classifies keywords into categories
	 */
	
	private static final Logger logger = Logger.getLogger(AOLKeywordGenerator.class);
	private String dmozUrlPath = "/semplest/data/dmoz/all.urls";
	
	public static void main(String[] args) throws IOException{
		String urlKwMapPath ="/semplest/data/aolData/urlKwMap.all";
		String categoriesKwMapPath ="/semplest/data/aolData/categoriesKwMap.all";
		BasicConfigurator.configure();
		AOLKeywordGenerator aol = new AOLKeywordGenerator();
		
		/*
		// Create a Hashmap of url to keywords and save to file
		HashMap<String,ArrayList<String>> urlKwMap = new  HashMap<String,ArrayList<String>>();
		String basePath = "/semplest/data/aolData/AOL-user-ct-collection/user-ct-test-collection-0";
		for(int i=1; i<10; i++){
			String path = basePath+i+".txt";
			urlKwMap =  aol.createUrlKwMap(path, urlKwMap);
		}
		urlKwMap =  aol.createUrlKwMap("/semplest/data/aolData/AOL-user-ct-collection/user-ct-test-collection-10.txt", urlKwMap);
		aol.saveHashMap(urlKwMap, urlKwMapPath);
		*/
		
		
		//Read in a hashmap of url to keyword and convert into hashMap of categories to keyword finding urls in dmoz
		HashMap<String,ArrayList<String>> urlKwMap = aol.loadHashMap(urlKwMapPath);
		HashMap<String,ArrayList<String>> categoriesKwMap = aol.createCategoriesKwMap(urlKwMap);
		aol.saveHashMap(categoriesKwMap, categoriesKwMapPath);
	}
	public void saveHashMap(HashMap<String,ArrayList<String>> hMap, String filePath) throws FileNotFoundException{
		//Saves a HashMap into a file
		PrintStream ps2 = new PrintStream(new FileOutputStream(new File(filePath)));
		this.saveHashMap(hMap, ps2);
	}
	
	public void saveHashMap(HashMap<String,ArrayList<String>> hMap, PrintStream ps2) throws FileNotFoundException{
		//Saves a HashMap into PrintStream (appending to printStream)
		int i=0;
		for(String cat: hMap.keySet()){
			logger.info("Saving map entry "+i);
			ps2.print(cat+": ");
			for(String kw: hMap.get(cat)){
				ps2.print(kw+", ");
			}
			ps2.print("\n");
		}
	}
	
	public HashMap<String, ArrayList<String>> loadHashMap(String filePath) throws IOException{
		logger.info("Reading in HashMap");
		HashMap<String, ArrayList<String>> hMap = new HashMap<String, ArrayList<String>>();
		
		DataInputStream in = new DataInputStream(new FileInputStream(new File(filePath)));
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String line;
	    int i=0;
	    while((line = br.readLine()) != null ){
	    	logger.info("reading line " + i);
	    	String fields[] = line.split(":");
	    	String[] kw = fields[1].split(",");
	    	List<String> kwList = Arrays.asList(kw);
	    	hMap.put(fields[0], new ArrayList<String>(kwList));
	    	i++;
	    }
		
		return hMap;
	}
	public HashMap<String,ArrayList<String>> createUrlKwMap( String pathIn, HashMap<String,ArrayList<String>> mapUrlKw) throws IOException{
		//Obtain a HashMap of url and keywords that generated clicks for that url, extending the input map
		DataInputStream in = new DataInputStream(new FileInputStream(new File(pathIn)));
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String line;
	    
	    ArrayList<String> nonClickKw = new ArrayList<String>();
	    int i=0;
	    while((line = br.readLine()) != null ){
	    	String[] fields = line.split("\t");
	    	if(fields.length<4){
	    		if(!nonClickKw.contains(fields[1]))
	    			nonClickKw.add(fields[1]);
	    	}else{
	    		if(mapUrlKw.containsKey(fields[4])){
	    			mapUrlKw.get(fields[4]).add(fields[1]);
	    		}else{
	    			ArrayList<String> arrAux = new ArrayList<String>();
	    			arrAux.add(fields[1]);
	    			mapUrlKw.put(fields[4], arrAux);
	    		}
	    	}
	    	logger.info("line "+ i);
	    	i++;
	    }
	    return mapUrlKw;
	}
	
	public HashMap<String,ArrayList<String>> createCategoriesKwMap(HashMap<String,ArrayList<String>> urlKwMap) throws IOException{
		//given a url to keywords map, generate a categories to kw Map based on the urls contained in dmoz
	    
	    FileInputStream fstream = new FileInputStream(dmozUrlPath);
	    DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		Set<String> keySet = urlKwMap.keySet();
		HashMap<String,ArrayList<String>> categoriesKwMap = new HashMap<String,ArrayList<String>>();
		
		ArrayList<String> mainUrls = new ArrayList<String>();
		ArrayList<String> urls = new ArrayList<String>();
		for(String url: keySet){
			mainUrls.add(this.getMainUrl(url));
			urls.add(url);
		}
		String strLine;
		String[] lineParts;
		//Read File Line By Line
		int j=0;
		while ((strLine = br.readLine()) != null)   {
			long start = System.currentTimeMillis();
			logger.info("processing category"+j);
			lineParts=strLine.split(":");
			for(int i=0; i<mainUrls.size(); i++){
				String mainUrl = mainUrls.get(i);
				if (strLine.contains(mainUrl)){
			  		if(categoriesKwMap.containsKey(lineParts[0])){
			  			categoriesKwMap.get(lineParts[0]).addAll(urlKwMap.get(urls.get(i)));
			  		}else{
			  			categoriesKwMap.put(lineParts[0], urlKwMap.get(urls.get(i)));
			  		}
			  	}
			}
			logger.info("Time to process category"+(System.currentTimeMillis()-start));
			j++;
		  	
		}
		return categoriesKwMap;
	}
	    
	public String getMainUrl(String url){
		String[] urlparts = url.split("/");
		String mainURL=url;
		for (String part :urlparts){
			if(!part.contains("http")&& part.length()!=0){
				mainURL=part;
				break;
			}
		}
		return mainURL;
	}
}


