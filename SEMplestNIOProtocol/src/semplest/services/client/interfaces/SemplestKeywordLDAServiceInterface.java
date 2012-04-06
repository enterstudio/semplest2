package semplest.services.client.interfaces;

import java.util.ArrayList;

public interface SemplestKeywordLDAServiceInterface extends ServiceInitialize
{
	public abstract ArrayList<String> getCategories(String companyName, String searchTerm, String description, String[] adds, String url) throws Exception;
	public abstract ArrayList<ArrayList<String>> getKeywords(ArrayList<String> categories,String companyName, String searchTerm, String description, String[] adds, String url, Integer[] nGrams) throws Exception;
}
