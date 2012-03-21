package semplest.keywords.javautils;

import java.util.ArrayList;

public class MultiWordCollect {
/**
 * Object that contains a multiwords Collection with all the categories and words for each category
 */
	private String id;
	private ArrayList<String> categories;
	private ArrayList<ArrayList<String>> wordsInCategories;
	
	public MultiWordCollect(String name, String filePath){
		//Read a file and load all words and names of categories
		id=name;
		categories = new ArrayList<String>();
		wordsInCategories = new ArrayList<ArrayList<String>>();
		ArrayList<String> lines = ioUtils.readFile( filePath );
	    for( String line : lines ){
	      	ArrayList<String> tokens = ioUtils.line2ArrayList( line );
	      	categories.add(tokens.remove(0));
	      	wordsInCategories.add(tokens);
	    } 
	}
	public String getCategName(int index){
		return categories.get(index);
	}
	public ArrayList<String> getwordsInCateg(int index){
		return wordsInCategories.get(index);
	}
	public int size(){
		return categories.size();
	}
	public String getID(){
		return id;
	}
}
