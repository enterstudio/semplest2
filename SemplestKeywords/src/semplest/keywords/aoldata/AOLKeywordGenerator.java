package semplest.keywords.aoldata;

import java.io.*;
import java.net.URL;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class AOLKeywordGenerator {
	/**
	 * This class reads the AOL search data files and classifies keywords into categories
	 */
	
	private static final Logger logger = Logger.getLogger(AOLKeywordGenerator.class);
	private String dmozUrlPath = "/semplest/data/dmoz/all.urls";
	private String[] categories = {"arts","business","computers","games","health","home","news","recreation","reference","science","shopping","society","sports","regional"};
	
	public static void main(String[] args) throws IOException{
		String urlKwMapPath ="/semplest/data/aolData/urlKwMap.all";
		String categoriesKwMapPath ="/semplest/data/aolData/categoriesKwMap.all";
		String categoriesUrlMapPath = "/semplest/data/aolData/categoriesDomainMap.all";
		String categoriesKwMapBasePath = "/home/lluis/Documents/aol/categoriesKw_";
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
		
		
		
		//Read in a hashmap of url to keyword and convert into hashMap of categories to keyword finding urls in dmoz
		HashMap<String,ArrayList<String>> urlKwMap = aol.loadUrlHashMap(urlKwMapPath);
		HashMap<String,ArrayList<String>> categoriesKwMap = aol.createCategoriesUrlMap(urlKwMap);
		aol.saveHashMap(categoriesKwMap, categoriesKwMapPath);
		*/
		
		//Load categories to url and url to kw maps and create multiword file per category
		HashMap<String,ArrayList<String>> urlKwMap = aol.loadUrlHashMap(urlKwMapPath);
		HashMap<String,ArrayList<String>> categoriesUrlMap = aol.loadHashMap(categoriesUrlMapPath);
		aol.saveCategoriesKwMap(categoriesUrlMap, urlKwMap, categoriesKwMapBasePath);
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
			i++;
		}
	}
	
	public HashMap<String, ArrayList<String>> loadHashMap(String filePath) throws IOException{
		//Loads any hashMap that has been saved with the saveHashMap method
		logger.info("Reading in HashMap");
		HashMap<String, ArrayList<String>> hMap = new HashMap<String, ArrayList<String>>();
		
		DataInputStream in = new DataInputStream(new FileInputStream(new File(filePath)));
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String line;
	    int i=0;
	    while((line = br.readLine()) != null ){
	    	
	    	logger.info("reading line " + i);
	    	String fields[] = line.split(": ");
    		String[] kw = fields[1].split(",");
	    	List<String> kwList = Arrays.asList(kw);
	    	hMap.put(fields[0], new ArrayList<String>(kwList));
	    	i++;
	    }
		
		return hMap;
	}
	
	public HashMap<String, ArrayList<String>> loadUrlHashMap(String filePath) throws IOException{
		//loads a url to keyword hashMap but extracting only the domain in the url as a key
		logger.info("Reading in HashMap");
		HashMap<String, ArrayList<String>> hMap = new HashMap<String, ArrayList<String>>();
		
		DataInputStream in = new DataInputStream(new FileInputStream(new File(filePath)));
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String line;
	    int i=0;
	    while((line = br.readLine()) != null ){
	    	
	    	logger.info("reading line " + i);
	    	String fields[] = line.split(": ");
    		String[] kw = fields[1].split(",");
	    	List<String> kwList = Arrays.asList(kw);
	    	hMap.put(this.getMainUrl(fields[0]), new ArrayList<String>(kwList));
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
	
	
	public HashMap<String,ArrayList<String>> createCategoriesUrlMap(HashMap<String,ArrayList<String>> urlKwMap) throws IOException{
		//given a url to keywords map, generate a categories to url Map only using urls that contain keywords.
		//url will contain only the domain part
		//Relatively fast speed
	    
	    FileInputStream fstream = new FileInputStream(dmozUrlPath);
	    DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		HashMap<String,ArrayList<String>> categoriesKwMap = new HashMap<String,ArrayList<String>>();
		String strLine;
		String[] lineParts;
		//Read File Line By Line
		int j=0;
		while ((strLine = br.readLine()) != null)   {
			long start = System.currentTimeMillis();
			logger.info("processing category"+j);
			lineParts=strLine.split(" : ");
			String[] urls = lineParts[1].split("\\s+");
			for(String url : urls ){
				String mainUrl = this.getMainUrl(url);
				if(urlKwMap.containsKey(mainUrl)){
					
					if(categoriesKwMap.containsKey(lineParts[0])){
						if(!categoriesKwMap.get(lineParts[0]).contains(mainUrl))
								categoriesKwMap.get(lineParts[0]).add(mainUrl);
			  		}else{
			  			ArrayList<String> aux2 = new ArrayList<String>();
			  			aux2.add(mainUrl);
			  			categoriesKwMap.put(lineParts[0], aux2);
			  		}
				}
			}
			logger.info("Time to process category"+(System.currentTimeMillis()-start));
			j++;
		  	
		}
		return categoriesKwMap;
	}
	
	
	public void saveCategoriesKwMap(HashMap<String,ArrayList<String>> categoriesUrlMap, HashMap<String, ArrayList<String>> urlKwMap, String baseSavePath) throws FileNotFoundException{
		//Takes a HashMap of categories to urls containing keywords and creates a file with the categories
		// and the keywords associated to its categories
		//The file has a multiword file format
		
		//Create different printstreams for the different subcategories
		PrintStream[] ps = new PrintStream[categories.length];
		int j=0;
		
		for(String cat : categories){
			String filePath = baseSavePath+cat+".aol";
			ps[j] = new PrintStream(new FileOutputStream(new File(filePath)));
			j++;
		}
		
		
		for(String cat: categoriesUrlMap.keySet()){
			logger.info("Saving category "+cat);
			int n=0;
			for(n=0; n<=categories.length; n++){
				if(cat.contains("top/"+categories[n]))
					break;
			}
			ps[n].print(cat+":0 ");
			for(String domain: categoriesUrlMap.get(cat)){
				if(domain!=null && domain.length()>2){
					ArrayList<String> aux3 = urlKwMap.get(domain.replaceAll("\\s+", ""));
					if(aux3.size()<1000){
						for(String kw : urlKwMap.get(domain.replaceAll("\\s+", ""))){
							if(kw!=null && kw.length()>1){
								String multiwrd = kw.replaceAll("\\s+", "\\+").replaceAll("^\\+", "").replace("\\+$", "");
								ps[n].print(multiwrd+":0 ");
							}	
						}
					}
				}
			}
			ps[n].print("\n");
		}
		
	}
	
	
	public HashMap<String,ArrayList<String>> createCategoriesKwMap(HashMap<String,ArrayList<String>> urlKwMap) throws IOException{
		
		//Warning: really slow
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

		
		
		HashMap<String, String> caturlMap = new HashMap<String,String>();
		int j=0;
		while ((strLine = br.readLine()) != null)   {
			logger.info("loading category: "+ j);
			lineParts=strLine.split(" : ");
			caturlMap.put(lineParts[0], lineParts[1]);
			j++;
		}


		for(int i=0; i<mainUrls.size(); i++){
			logger.info("Processing ulr : "+i);
			String mainUrl = mainUrls.get(i);
			if(mainUrl.length()>=4){
				for(Map.Entry<String,String> ent : caturlMap.entrySet()){
					if (ent.getValue().contains(mainUrl)){
				  		if(categoriesKwMap.containsKey(ent.getKey())){
				  			categoriesKwMap.get(ent.getKey()).addAll(urlKwMap.get(urls.get(i)));
				  		}else{
				  			categoriesKwMap.put(ent.getKey(), urlKwMap.get(urls.get(i)));
				  		}
				  	}
				}
			}
				
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


