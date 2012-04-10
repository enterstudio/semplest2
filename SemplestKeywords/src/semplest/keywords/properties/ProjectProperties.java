package semplest.keywords.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
	//for CatUtils
	public static String[] validCat; 
	//for DmozLucene
	public static String lucenedfile;
	//for MalletTopic
	public static String smallhCounts;
	public static String stoplist;
	private static final Logger logger = Logger.getLogger(ProjectProperties.class);
	
	
	//load properties
	static{
		
		try {
			File directory = new File (".");
			String PROPSFILE =  "data/SemplestKeywords.properties";
			properties = new Properties();
			logger.info("PROPSFILE=" + PROPSFILE);
			FileInputStream is = new FileInputStream(PROPSFILE);
			properties.load(is);
			is.close();
			logger.info("Read in proprties file...");
			
			dictfile = properties.getProperty("dictfile");
			docfile = properties.getProperty("docfile"); 
			twfile = properties.getProperty("twfile"); 
			dfile = properties.getProperty("dfile"); 
			baseMultiWPath = properties.getProperty("baseMultiWPath");
			nGramsSubC = loadStringArray("nGramsSubC");
			validCat = loadStringArray("validcat");
			lucenedfile = properties.getProperty("lucenedfile");
			smallhCounts = properties.getProperty("smallhCounts");
			stoplist = properties.getProperty("stoplist");
			logger.info("Set all property data...");
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
	private static String[] loadStringArray(String property){
		String aux;
		aux =properties.getProperty(property);
		aux =aux.replaceAll("\\s", "");
		return aux.split(",");
	}

}