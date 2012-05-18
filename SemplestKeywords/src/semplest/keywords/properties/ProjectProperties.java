package semplest.keywords.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ProjectProperties {
	
	public static Properties properties;
	
	//for dictUtils
	public static String dictfile; 
	public static String docfile; 
	public static String twfile;
	//for KWGenDmozLDAServer
	public static String dfile;
	public static String baseMultiWPath;
	public static String[] nGramsSubC; 
	public static String nGramsC; 
	//for CatUtils
	public static String[] validCat; 
	//for DmozLucene
	public static String lucenedfile;
	//for MalletTopic
	public static String smallhCounts;
	public static String stoplist;
	//for KWGenDmozLDAServer
	public static int numTopics;
	public static double userInfoWeight;
	public static int numKeywordsGoogle;
	public static int numKeywordsMSN;
	public static int numThreads;
	private static final Logger logger = Logger.getLogger(ProjectProperties.class);
	private static HashMap<String,Object> configData;
	
	
	//load properties
	public ProjectProperties() throws IOException{
		this(null);
	}
	
	public ProjectProperties( HashMap<String,Object> configDataIn) throws IOException{
		if(configDataIn!=null){
			logger.info("Read in properties file...");
			configData = configDataIn;
			dictfile = (String) configData.get("SemplestKeywordsdictfile");
			docfile = (String) configData.get("SemplestKeywordsdocfile"); 
			twfile = (String) configData.get("SemplestKeywordstwfile"); 
			dfile = (String) configData.get("SemplestKeywordsdfile"); 
			baseMultiWPath = (String) configData.get("SemplestKeywordsbaseMultiWPath");
			nGramsSubC = loadStringArray("SemplestKeywordsnGramsSubC");
			nGramsC = (String) configData.get("SemplestKeywordsnGramsC");; 
			validCat = loadStringArray("SemplestKeywordsvalidcat");
			lucenedfile = (String) configData.get("SemplestKeywordslucenedfile");
			smallhCounts = (String) configData.get("SemplestKeywordssmallhCounts");
			stoplist = (String) configData.get("SemplestKeywordsstoplist");
			numTopics = (Integer) configData.get("SemplestKeywordsnumTopics");
			userInfoWeight = (Double) configData.get("SemplestKeywordsuserInfoWeight");
			numKeywordsGoogle = (Integer) configData.get("SemplestKeywordsnumKeywordsGoogle");
			numKeywordsMSN = (Integer) configData.get("SemplestKeywordsnumKeywordsMSN");
			numThreads= (Integer) configData.get("SemplestKeywordsnumThreads");
			logger.info("Set all property data...");
		}else{
			File directory = new File (".");
			String PROPSFILE =  "data/SemplestKeywords.properties";
			properties = new Properties();
			logger.info("PROPSFILE=" + PROPSFILE);

			FileInputStream is = new FileInputStream(PROPSFILE);
		
			properties.load(is);
			is.close();
			logger.info("Read in properties file...");
			
			dictfile = properties.getProperty("dictfile");
			docfile = properties.getProperty("docfile"); 
			twfile = properties.getProperty("twfile"); 
			dfile = properties.getProperty("dfile"); 
			baseMultiWPath = properties.getProperty("baseMultiWPath");
			nGramsSubC = loadStringArrayfromfile("nGramsSubC");
			nGramsC = properties.getProperty("nGramsC");; 
			validCat = loadStringArrayfromfile("validcat");
			lucenedfile = properties.getProperty("lucenedfile");
			smallhCounts = properties.getProperty("smallhCounts");
			stoplist = properties.getProperty("stoplist");
			numTopics = Integer.parseInt(properties.getProperty("numTopics"));
			userInfoWeight = Double.parseDouble(properties.getProperty("userInfoWeight"));
			numKeywordsGoogle = Integer.parseInt(properties.getProperty("numKeywordsGoogle"));
			numKeywordsMSN = Integer.parseInt(properties.getProperty("numKeywordsMSN"));
			numThreads= Integer.parseInt(properties.getProperty("numThreads"));
			logger.info("Set all property data...");
		}
		
		
	}
	
	private static String[] loadStringArray(String property){
		String aux;
		aux =(String) configData.get(property);
		aux =aux.replaceAll("\\s", "");
		return aux.split(",");
	}
	private static String[] loadStringArrayfromfile(String property){
		String aux;
		aux =(String) properties.getProperty(property);
		aux =aux.replaceAll("\\s", "");
		return aux.split(",");
	}
}