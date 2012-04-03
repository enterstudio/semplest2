package semplest.keywords.lda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import semplest.keywords.javautils.DmozLucene;
import semplest.keywords.javautils.ioUtils;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;



public class KWGenDmozLDAServer implements SemplestKeywordLDAServiceInterface{
	//Search index for categories
	private DmozLucene dl; //Index of categories
	public KWGenDmozLDAServer(){
		// Index description information
		 DmozLucene dl = new DmozLucene();
		 dl.loadDesc();
	}
	@Override
	public ArrayList<String> getCategories(String[] searchTerm) throws Exception {
		//Get category results from dmoz query
		String qs="";
		String[] res;
		int numresults = 100; // Number of results from the query
		for(int i=0; i<searchTerm.length;i++){
			qs=qs+searchTerm[i]+" ";
		}
		res = dl.search(qs,numresults);
		
		//Select repeated patterns
		
		return null;
	}

}
