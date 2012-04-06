package semplest.keywords.lda;

import java.io.IOException;
import java.util.HashMap;


import semplest.keywords.javautils.DmozLucene;
import semplest.keywords.javautils.MultiWordCollect;
import semplest.keywords.javautils.catUtils;
import semplest.keywords.javautils.dictUtils;
import semplest.keywords.javautils.ioUtils;
import semplest.keywords.properties.ProjectProperties;

public class KWGenDmozLDAdata implements Runnable{
	
	public DmozLucene dl; //Index of categories
	public HashMap<String,String> TrainingData;
	public dictUtils dict;
	private static String dfile = ProjectProperties.dfile;
	private static String baseMultiWPath = ProjectProperties.baseMultiWPath;
	public MultiWordCollect[] biGrams; //Collection of bigrams for each subcategory sorted by categories
	public MultiWordCollect[] triGrams; //Collection of trigrams for each subcategory sorted by categories
	private static String[] nGramsSubC = ProjectProperties.nGramsSubC;
	public static ProjectProperties pr; 
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
		pr=new ProjectProperties();
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
		
		System.out.println("Loading Bigrams for each subcategory");
		biGrams= new MultiWordCollect[nGramsSubC.length];
		for (int i=0; i< nGramsSubC.length; i++){
			String biPath = baseMultiWPath+nGramsSubC[i]+".txt.2";
			System.out.println("Loading"+biPath);
			biGrams[i]= new MultiWordCollect(nGramsSubC[i],biPath);
		}
		System.out.println("Loading Trigrams for each subcategory");
		triGrams= new MultiWordCollect[nGramsSubC.length];
		for (int i=0; i< nGramsSubC.length; i++){
			String triPath = baseMultiWPath+nGramsSubC[i]+".txt.3";
			System.out.println("Loading"+triPath);
			triGrams[i]= new MultiWordCollect(nGramsSubC[i],triPath);
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
