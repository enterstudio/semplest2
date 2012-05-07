package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.KeywordDataObject;

public interface SemplestBiddingInterface extends ServiceInitialize {
	
	HashMap<String, Integer> GetMonthlyBudgetPercentPerSE(Integer promotionID, ArrayList<String> searchEngine) throws Exception;
	HashMap<String, AdEngineInitialData> getInitialValues(Integer promotionID, ArrayList<String> searchEngine) throws Exception;
	void setBidsInitial(Integer promotionID, String searchEngine) throws Exception;
	void setBidsUpdate(Integer promotionID, String searchEngine) throws Exception;

	
	HashMap<String,Double> getBid(String accountID, Long campaignID, Long adGroupID, ArrayList<String> keywords) throws Exception ;

	void getBidsInitial(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception;
	void getBidsInitialNaive(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception;

	void getBidsUpdate(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception;
	void getBidsUpdateNaive(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception;
	
	
	



}
