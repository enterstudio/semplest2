package semplest.services.client.interfaces;

import java.util.List;

import semplest.server.protocol.adengine.GetCategoriesRequest;
import semplest.server.protocol.adengine.GetKeywordsRequest;
import semplest.server.protocol.adengine.KeywordProbabilityObject;

public interface KeywordServiceInterface extends ServiceInitialize
{
	List<String> getCategories(final GetCategoriesRequest request) throws Exception;	
	List<KeywordProbabilityObject> getKeywords(final GetKeywordsRequest request) throws Exception;
}
