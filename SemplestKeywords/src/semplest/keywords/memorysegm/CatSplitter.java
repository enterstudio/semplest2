package semplest.keywords.memorysegm;

import java.util.*;
import java.io.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.keywords.ldatest.KWGenDmozLDAdata3;

/**
 * The purpose of this class is to provide tools to split large files containing category information into smaller files that 
 * can be loaded into memory in real time.
 * @author lluis
 *
 */

public class CatSplitter {
	
	private static final Logger logger = Logger.getLogger(CatSplitter.class);
	private HashMap<String, String> cat2fileMap;
	
	public CatSplitter(){
		cat2fileMap = new HashMap<String,String>();
	}
	
	public void splitCatFile(String inputFile, String destinFolder, String outputFileName, int catsPerFile) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream(inputFile));
		int catCount =0;
		int fileCount = 0;
		String outputFile = destinFolder+outputFileName+fileCount+".txt";
		PrintStream outputStream = new PrintStream(new FileOutputStream(outputFile));
		logger.info("Generating file: "+outputFile);
		//Read line by line
		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] split = line.split(":");
			String cat = split[0].trim();
			//Create category if it does not exist in map
			if(!cat2fileMap.containsKey(cat)){
				if(catCount>=catsPerFile){
					//If # of categories per file exceeded, create a new file
					fileCount++;
					outputFile = destinFolder+outputFileName+"_"+fileCount+".txt";
					outputStream = new PrintStream(new FileOutputStream(destinFolder+outputFileName+fileCount+".txt"));
					logger.info("Generating file: "+outputFile);
					catCount =0;
				}
				outputStream.println(line);
				cat2fileMap.put(cat, outputFile);
				catCount++;
			}
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		try{
		BasicConfigurator.configure();
		CatSplitter splitter = new CatSplitter();
		splitter.splitCatFile("/semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/business.2", "/home/lluis/Documents/splitTest/", 
				"business2", 1000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
