package semplest.services.client.interfaces;

import java.util.ArrayList;

import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;

public interface SemplestKeywordLDAServiceInterface extends ServiceInitialize
{
	//Company name : not used currently
	//N grams should be removed in the future, we are getting all ngrams???
	public abstract ArrayList<String> getCategories(String companyName, String promotionName, String description, String[] adds, String url) throws Exception;
	
	public KeywordProbabilityObject[] getKeywords(ArrayList<String> categories,String companyName,  String[] searchEngines,
			String promotionName, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception ;
}
