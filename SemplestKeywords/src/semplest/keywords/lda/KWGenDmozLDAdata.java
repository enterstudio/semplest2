package semplest.keywords.lda;

import java.io.IOException;
import java.util.HashMap;


import semplest.keywords.javautils.DmozLucene;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.javautils.ioUtils;

public class KWGenDmozLDAdata implements Runnable{
	
	public DmozLucene dl; //Index of categories
	public HashMap<String,String> TrainingData;
	public dictUtils dict;
	private String dfile = "data/dmoz/all/all.descs";
	private static final boolean serviceCall = false; //true if the object is instanciated by a service call
	
	public KWGenDmozLDAdata() throws IOException {
		/*//Load property file if necessary for paths
		if(SEMplestService.properties==null){
			String PROPSFILE = "../SemplestServices/bin/system.properties";
			SEMplestService.properties = new Properties();
			FileInputStream is = new FileInputStream(PROPSFILE);
			SEMplestService.properties.load(is);
			is.close();
		}
		
		dfile = SEMplestService.properties.getProperty("data.dmoz.all.alldesc"); */
		
		dl = new DmozLucene();
		System.out.println("Indexing dmoz description data...");
		DmozLucene.loadDesc(dl,dfile);
		System.out.println("Data indexed!");
		System.out.println("Loading training data...");
		TrainingData = ioUtils.file2Hash(dfile);
		System.out.println("Data loaded");
		System.out.println("Loading stem dictionary...");
		dict = new dictUtils();
		System.out.println("Dictionary loaded");
		
		
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
