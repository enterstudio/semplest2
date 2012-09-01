package semplest.services.client.interfaces;

import java.util.List;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.GeoTargetObject;
import semplest.server.protocol.adengine.KeywordProbabilityObject;

public interface SemplestKeywordLDAServiceInterface extends ServiceInitialize
{
	//Company name : not used currently
	//N grams should be removed in the future, we are getting all ngrams???
	List<String> getCategories(String companyName, String promotionName, String description, String[] adds, String url) throws Exception;	
	KeywordProbabilityObject[] getKeywords(List<String> categories,String companyName, AdEngine[] searchEngines, String promotionName, String description, String[] adds, String url, GeoTargetObject[] gt, Integer[] nGrams) throws Exception ;
}
