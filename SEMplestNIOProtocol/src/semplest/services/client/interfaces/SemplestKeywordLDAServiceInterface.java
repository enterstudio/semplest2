package semplest.services.client.interfaces;

import java.util.ArrayList;

public interface SemplestKeywordLDAServiceInterface extends ServiceInitialize
{
	public abstract ArrayList<String> getCategories(String[] searchTerm) throws Exception;
	public abstract ArrayList<String> getKeywords(ArrayList<String> categories, int numKw, int nGrams) throws Exception;

}
