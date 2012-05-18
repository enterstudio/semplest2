package semplest.keywords.lda;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;

import semplest.keywords.javautils.DmozLucene;
import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.javautils.ioUtils;
import semplest.keywords.properties.ProjectProperties;


public class KWGenDmozLDAdata implements Runnable{
	
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAdata.class);
	public DmozLucene dl; //Index of categories
	public HashMap<String,String> TrainingData;
	public dictUtils dict;
	private static String dfile; 
	private static String baseMultiWPath ;
	public MultiWordCollect[] biGrams; //Collection of bigrams for each subcategory sorted by categories
	public MultiWordCollect[] triGrams; //Collection of trigrams for each subcategory sorted by categories
	private static String[] nGramsSubC; 
	public int numTopics; 
	public double userInfoWeight; 
	public int numKeywordsGoogle; 
	public int numKeywordsMSN; 
	public static ProjectProperties pr; 
	
	public KWGenDmozLDAdata(HashMap<String,Object> configData) throws IOException {
		/*//Load property file if necessary for paths
		if(SEMplestService.properties==null){
			String PROPSFILE = "../SemplestServices/bin/system.properties";
			SEMplestService.properties = new Properties();
			FileInputStream is = new FileInputStream(PROPSFILE);
			SEMplestService.properties.load(is);
			is.close();
		}
		
		dfile = SEMplestService.properties.getProperty("data.dmoz.all.alldesc"); */
		try
		{
			pr=new ProjectProperties(configData);
			dfile = pr.dfile;
			baseMultiWPath = pr.baseMultiWPath;
			nGramsSubC = pr.nGramsSubC;
			numTopics = pr.numTopics;
			userInfoWeight = pr.userInfoWeight;
			numKeywordsGoogle = pr.numKeywordsGoogle;
			numKeywordsMSN = pr.numKeywordsMSN;
			logger.info(pr.dfile+"\n"+pr.baseMultiWPath+"\n"+pr.numTopics);
			
		
			logger.info("create DmozLucene()");
			dl = new DmozLucene();
			logger.info("Indexing dmoz description data...");
			DmozLucene.loadDesc(dl,dfile);
			logger.info("Data indexed!");
			
			logger.info("Loading training data...");
			logger.info("dfile:"+ dfile);
			TrainingData = ioUtils.file2Hash(dfile);
			Set<String> keys = TrainingData.keySet();
			for(String key: keys){
				logger.info(key+"\n");
			}
			logger.info("Data loaded");
			
			logger.info("Loading stem dictionary...");
			dict = new dictUtils();
			logger.info("Dictionary loaded");
			
			logger.info("Loading Bigrams for each subcategory");
			biGrams= new MultiWordCollect[nGramsSubC.length];
			for (int i=0; i< nGramsSubC.length; i++){
				String biPath = baseMultiWPath+nGramsSubC[i]+".txt.2";
				logger.info("Loading"+biPath);
				biGrams[i]= new MultiWordCollect(nGramsSubC[i],biPath);
			}
			logger.info("Loading Trigrams for each subcategory");
			triGrams= new MultiWordCollect[nGramsSubC.length];
			for (int i=0; i< nGramsSubC.length; i++){
				String triPath = baseMultiWPath+nGramsSubC[i]+".txt.3";
				logger.info("Loading"+triPath);
				triGrams[i]= new MultiWordCollect(nGramsSubC[i],triPath);
			}
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new IOException(e);
		}
		
	}
	public int getnGramSubCatInd(String categ){
		//Return index of the subcategory containing the category inspected
		for(int i=0; i<nGramsSubC.length; i++){
			if (catUtils.take(categ, 2).contains(nGramsSubC[i]))
				return i;
		}
		return -1;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
