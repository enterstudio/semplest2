package semplest.services.client.interfaces;

import java.util.ArrayList;

import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;

public interface SemplestKeywordLDAServiceInterface extends ServiceInitialize
{
	public abstract ArrayList<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception;
	public ArrayList<ArrayList<KeywordProbabilityObject>> getKeywords(ArrayList<String> categories,String companyName,  String[] searchEngines,
			String searchTerm, String description, String[] adds, String url, GeoTargetObject gt, Integer[] nGrams) throws Exception ;
}
