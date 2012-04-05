package semplest.keywords.javautils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MultiWordCollect {
/**
 * Object that contains a multiwords Collection with all the categories and words for each category
 */
	private String id;
	private HashMap<String,Integer> categories;
	private ArrayList<ArrayList<String>> wordsInCategories;
	
	public MultiWordCollect(String name, String filePath){
		//Read a file and load all words and names of categories
		id=name;
		categories = new HashMap<String,Integer>();
		wordsInCategories = new ArrayList<ArrayList<String>>();
		ArrayList<String> lines = ioUtils.readFile( filePath );
		int i=0;
	    for( String line : lines ){
	      	ArrayList<String> tokens = ioUtils.line2ArrayList( line );
	      	categories.put(tokens.remove(0),new Integer(i));
	      	wordsInCategories.add(tokens);
	      	i++;
	    } 
	}
	public String getCategName(int index){
		Set<String> keys =categories.keySet();
		for(String key:keys){
			if(categories.get(key).equals(new Integer(index)))
				return key;
		}
		return null;
	}
	public ArrayList<String> getwordsInCateg(int index){
		return wordsInCategories.get(index);
	}
	public ArrayList<String> getwordsInCateg(String categ){
		Integer aux = categories.get(categ);
		if(aux==null)
			return null;
		return wordsInCategories.get(categories.get(categ));
	}
	
	public int size(){
		return categories.size();
	}
	public String getID(){
		return id;
	}
}
