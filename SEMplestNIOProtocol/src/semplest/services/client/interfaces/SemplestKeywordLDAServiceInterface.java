package semplest.services.client.interfaces;

import java.util.ArrayList;

public interface SemplestKeywordLDAServiceInterface
{
	public abstract ArrayList<String> getCategories(String[] searchTerm) throws Exception;

}
