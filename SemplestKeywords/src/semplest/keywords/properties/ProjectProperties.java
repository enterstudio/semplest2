package semplest.keywords.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ProjectProperties {

  final public static String PROPSFILE =  "data/SemplestKeywords.properties";

  public static Properties properties;

  //for bdb
  public static String bdbdir;

  //for dictUtils
  public static String dictfile; 
  public static String docfile; 
  public static String twfile;
  public static String dffile;
  //for KWGenDmozLDAServer
  public static String dfile;
  public static String baseMultiWPath;
  public static String[] nGramsSubC; 
  public static String nGramsC; 
  //for CatUtils
  public static String[] validCat; 
  public static String   catMap;
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

  // statics should be initialized in a static constructor block
  // Read in data from properties file
  static {
    properties = new Properties();
    try {
      properties.load( new FileInputStream(PROPSFILE) );
    } catch (Exception e ){
      e.printStackTrace();
      // Note: Logger may not be initialized yet
    }

    bdbdir    = properties.getProperty("bdbdir");
    dictfile  = properties.getProperty("dictfile");
    docfile   = properties.getProperty("docfile"); 
    twfile    = properties.getProperty("twfile"); 
    dffile    = properties.getProperty("dffile"); 
    dfile     = properties.getProperty("dfile"); 
    baseMultiWPath = properties.getProperty("baseMultiWPath");
    nGramsC     = properties.getProperty("nGramsC");; 
    catMap      = properties.getProperty("catMap");
    lucenedfile = properties.getProperty("lucenedfile");
    smallhCounts  = properties.getProperty("smallhCounts");
    stoplist      = properties.getProperty("stoplist");
    numTopics     = Integer.parseInt(properties.getProperty("numTopics"));
    numThreads      = Integer.parseInt(properties.getProperty("numThreads"));
    numKeywordsGoogle = 
      Integer.parseInt(properties.getProperty("numKeywordsGoogle"));
    numKeywordsMSN  = 
      Integer.parseInt( properties.getProperty("numKeywordsMSN"));
    userInfoWeight = Double.parseDouble(properties.getProperty("userInfoWeight"));
    validCat    = loadStringArrayfromfile("validcat");
    nGramsSubC  = loadStringArrayfromfile("nGramsSubC");
  }

  // null ctr not needed, but there to keep code from breaking 
  public ProjectProperties() throws IOException { this(null); }
  // if data is provided from database (as hash), override file properties
  public ProjectProperties( HashMap<String,Object> configDataIn) 
    throws IOException{

    if( configDataIn == null) return;

    logger.info("Updating keyword properties properties from hash...");
    configData = configDataIn;

    bdbdir    = getString("SemplestKeywordsbdbdir",  bdbdir );
    dictfile  = getString("SemplestKeywordsdictfile",  dictfile );
    docfile   = getString("SemplestKeywordsdocfile",    docfile); 
    twfile    = getString("SemplestKeywordstwfile",     twfile); 
    dffile    = getString("SemplestKeywordsdffile",     dffile); 
    dfile     = getString("SemplestKeywordsdfile",      dfile); 
    nGramsC     = getString("SemplestKeywordsnGramsC",  nGramsC); 
    catMap      = getString("catMap",                   catMap);
    lucenedfile = getString("SemplestKeywordslucenedfile",  lucenedfile );
    smallhCounts= getString("SemplestKeywordssmallhCounts", smallhCounts );
    stoplist    = getString("SemplestKeywordsstoplist",     stoplist);
    baseMultiWPath = getString("SemplestKeywordsbaseMultiWPath",
        baseMultiWPath);
    numTopics   = getInteger("SemplestKeywordsnumTopics",   numTopics);
    numKeywordsGoogle = getInteger("SemplestKeywordsnumKeywordsGoogle", 
        numKeywordsGoogle);
    numKeywordsMSN    = getInteger("SemplestKeywordsnumKeywordsMSN",
        numKeywordsMSN);
    numThreads        = getInteger("SemplestKeywordsnumThreads",  numThreads);
    userInfoWeight    = getDouble("SemplestKeywordsuserInfoWeight",
        userInfoWeight);
    nGramsSubC  = getStringArray("SemplestKeywordsnGramsSubC",    nGramsSubC);
    validCat    = getStringArray("SemplestKeywordsvalidcat",      validCat);

    logger.info("Properties Update done...");
  }

  // - private helpers ----------------
  private String getString( String prop, String def ) {
    return configData.get(prop) != null ? (String)configData.get(prop) : def; 
  }
  private Integer getInteger( String prop, Integer def ) {
    return configData.get(prop) != null ? (Integer)configData.get(prop) : def; 
  }
  private Double getDouble( String prop, Double def ) {
    return configData.get(prop) != null ? (Double)configData.get(prop) : def; 
  }
  private static String[] getStringArray(String prop, String[] def){
    if( configData.get(prop) != null ){
      String aux = (String) configData.get(prop);
      aux = aux.replaceAll("\\s", "");
      return aux.split(",");
    } else return def;
  }
  private static String[] loadStringArrayfromfile(String prop){
    String aux = (String) properties.getProperty(prop);
    aux =aux.replaceAll("\\s", "");
    return aux.split(",");
  }
}
