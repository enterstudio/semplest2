package semplest.service.keywords.lda;

import java.util.ArrayList;

import semplest.keywords.lda.KWGenDmozLDAServer;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

public class KeywordGeneratorServiceImpl implements SemplestKeywordLDAServiceInterface
{
	private KWGenDmozLDAServer kwGen;
	public String getCategories(String json) throws Exception
	{
		return null;
	}

	@Override
	public ArrayList<String> getCategories(String[] searchTerm) throws Exception
	{
		if(kwGen==null){
			kwGen =  new KWGenDmozLDAServer();
		}
		ArrayList<String> categOpt = kwGen.getCategories(searchTerm);
		return categOpt;
	}
	
}
