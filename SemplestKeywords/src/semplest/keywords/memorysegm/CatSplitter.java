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
	
	private HashMap<String, String> loadedCats;
	private String[] allCats;
	private int numSubFiles;
	
	public CatSplitter(int numSubFiles) {
		this.numSubFiles = numSubFiles;
	}
	
	public String[] getAllCats(){
		return allCats;
	}
	
	public void loadAllCats(String inputFile) throws FileNotFoundException{
		ArrayList<String> allCatsList = new ArrayList<String>();
		Scanner sc = new Scanner(new FileInputStream(inputFile));
		logger.info("loading all categories...");
		long start = System.currentTimeMillis();
		while(sc.hasNext()){
			String[] split =sc.nextLine().split(":");
			if(split.length>0)
				allCatsList.add(split[0]);
		}
		allCats = allCatsList.toArray(new String[allCatsList.size()]);
		Arrays.sort(allCats);
		logger.info("time to load categories : "+(System.currentTimeMillis()-start)+" msec");
	}
	
	private PrintStream[] openAllOutputFiles(String destinFolder, String outputFileName, String extension) throws FileNotFoundException{
		PrintStream[] outputs = new PrintStream[numSubFiles];
		for(int i=0; i<outputs.length ; i++){
			outputs[i] = new PrintStream(new FileOutputStream(destinFolder+outputFileName+"_"+i+extension));
		}
		return outputs;
	}
	
	private void closeAllOutputFiles(PrintStream[] outputs){
		for(PrintStream output : outputs){
			output.close();
		}
	}
	
	public void splitCatFile(String inputFile, String destinFolder, String outputFileName, String extension) throws FileNotFoundException {
		String line, cat;
		String[] split;
		PrintStream[] outputs = openAllOutputFiles(destinFolder, outputFileName, extension);
		
		Scanner sc = new Scanner(new FileInputStream(inputFile));
		if(allCats == null)
			loadAllCats(inputFile);
		int catsPerFile = (int) Math.ceil(1.0*allCats.length/numSubFiles);
		//Read line by line
		logger.info("generating subfiles...");
		long start = System.currentTimeMillis();
		while(sc.hasNext()){
			line = sc.nextLine();
			split = line.split(":");
			cat = split[0].trim();
			//Find index of category
			int index = Arrays.binarySearch(allCats, cat);
			PrintStream output = outputs[index/catsPerFile];
			output.println(line);
		}
		logger.info("time to generate subfiles : " + (System.currentTimeMillis()-start)+" msec");
		closeAllOutputFiles(outputs);
	}
	
	
	
	/*
	public void splitCatFile2HashMap(String inputFile, String destinFolder, String outputFileName, String extension, int catsPerFile) throws FileNotFoundException {
		HashMap<String, String> cat2fileMap = new HashMap<String,String>();
		Scanner sc = new Scanner(new FileInputStream(inputFile));
		int catCount =0;
		int fileCount = 0;
		String outputFile = destinFolder+outputFileName+fileCount+extension;
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
	*/
	
	
	public static void main(String[] args) throws FileNotFoundException{
		try{
		BasicConfigurator.configure();
		CatSplitter splitter = new CatSplitter(100);
		splitter.splitCatFile("/semplest/data/dmoz/multiwords/crawl2MSNVolFiltered/business.2", "/home/lluis/Documents/splitTest/", 
				"business",".2.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
