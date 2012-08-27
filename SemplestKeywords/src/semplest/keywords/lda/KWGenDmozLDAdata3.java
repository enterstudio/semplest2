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


public class KWGenDmozLDAdata3 implements Runnable{
	
	private static final Logger logger = Logger.getLogger(KWGenDmozLDAdata3.class);
	public DmozLucene dl; //Index of categories
	public dictUtils dict;
	public int numTopics;
	public double userInfoWeight; 
	public int numKeywordsGoogle; 
	public int numKeywordsMSN; 
	public static ProjectProperties pr;
	public catUtils cu;
	dictUtils du ;
	
	public KWGenDmozLDAdata3(HashMap<String,Object> configData) throws IOException {
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
			numTopics = pr.numTopics;
			userInfoWeight = pr.userInfoWeight;
			numKeywordsGoogle = pr.numKeywordsGoogle;
			numKeywordsMSN = pr.numKeywordsMSN;
			
			//logger.info(pr.dfile+"\n"+pr.baseMultiWPath+"\n"+pr.numTopics);
			
			cu = new catUtils();
			du = new dictUtils();
			
			
			logger.info("create DmozLucene()");
			dl = new DmozLucene();
			logger.info("Indexing dmoz description data...");
			DmozLucene.loadDescDB(dl);
			logger.info("Data indexed!");
		
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new IOException(e);
		}
		
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
