package semplest.keywords.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
	
	
	
	//load properties
	static{
		String PROPSFILE = "C:/SEMplestServiceKeywords/data/SemplestKeywords.properties";  //"data/SemplestKeywords.properties"
		properties = new Properties();
		try {
			FileInputStream is = new FileInputStream(PROPSFILE);
			properties.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	}
	
	private static String[] loadStringArray(String property){
		String aux;
		aux =properties.getProperty(property);
		aux =aux.replaceAll("\\s", "");
		return aux.split(",");
	}

}
