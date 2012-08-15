package semplest.keywords.javautils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import semplest.keywords.properties.ProjectProperties;

public class ExpandNounPhrase {
	
	private static final Logger logger = Logger.getLogger(ExpandNounPhrase.class);
	private DataBuffer db;
	List<String> stemdict;
	
	public ExpandNounPhrase(HashMap<String,Object> configData) throws IOException{
		db = new DataBuffer(configData);
		
	}
	
	//Select noun phrases from text that contain a multi word from selected categories
	public List<String> expandNounPhrase(List<String> categories, List<String> text){
		List<String> multWStemL = getMultWStem(categories);
		List<String> nounPL = null;//getNounPhrase(text);
		List<String> nounPLStem = stemList(nounPL);
		Set<String> ret = new HashSet<String>();
		for(String multWStem: multWStemL)
			for(int i=0; i<nounPL.size(); i++)
				if(!ret.contains(nounPL.get(i)) && cleanWhite(nounPLStem.get(i)).contains(cleanWhite(multWStem))){
					nounPLStem.remove(i);
					ret.add(nounPL.remove(i));
					i--;
				}
		return null;
	}
	
	//Stem a list of Strings
	public List<String> stemList(List<String> list){
		List<String> ret = new ArrayList<String>();
		for(String sent : list){
			String stem = dictUtils.stemNSW(sent).trim();
			if(!stem.isEmpty())
				ret.add(stem);
		}
		return ret;
	}
	
	//Get multiwords from appropiate source and stem them.
	public  List<String> getMultWStem(List<String> categories){
		List<String> multW = getMultWfromMem(categories);
		return stemList(multW);
	}
	
	//Get multiWords when they are stored in memory
	public List<String> getMultWfromMem(List<String> categories){
		
		return null;
	}
	//Cleans white spaces in a String
	public String cleanWhite(String in){
		return in.replaceAll("\\s+", " ").trim();
	}
	//************************************************************************************************************
	private static class DataBuffer{
		private Map<String,MultiWordCollect[]> mWords; //Colections of multiwords with origin as key
		private ProjectProperties pr; // Properties loaded from file or database
		private Map<String,MultiWordCollect[]> db;
		private static final Map<String,String> sources = getSrcNameExt();
		
		public static Map<String,String> getSrcNameExt(){
			Map<String,String> map = new HashMap<String, String>();
			map.put("bigrams", ".2");
				
			
			return null;
		}
		
		DataBuffer(HashMap<String,Object> configData) throws IOException{
			pr=new ProjectProperties(configData);
			mWords = new HashMap<String,MultiWordCollect[]>();
			//populateMWords("", "");
		}
		
		public void insertMultiWSet(String key, String fileExt){
			MultiWordCollect[] mC = new MultiWordCollect[pr.nGramsSubC.length];
			logger.info("loading multiwords [" +key+"]");
			for(int i=0; i<mC.length; i++){
				String path = pr.baseMultiWPath+pr.nGramsSubC[i]+fileExt;
				logger.info("\tloading file:"+ path);
				mC[i] = new MultiWordCollect(pr.nGramsSubC[i], path);	
			}
		}
		
		
		
		
	}

}
