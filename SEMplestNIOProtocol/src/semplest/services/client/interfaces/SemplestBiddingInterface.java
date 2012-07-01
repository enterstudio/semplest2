package semplest.services.client.interfaces;

import java.util.List;
import java.util.Map;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.AdEngineInitialData;
import semplest.server.protocol.adengine.BudgetObject;

public interface SemplestBiddingInterface extends ServiceInitialize 
{	
	Map<AdEngine, Double> GetMonthlyBudgetPercentPerSE(Integer promotionID, List<AdEngine> searchEngine) throws Exception;
	Map<AdEngine, AdEngineInitialData> getInitialValues(Integer promotionID, List<AdEngine> searchEngine) throws Exception;
	Boolean setBidsInitial(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception;
	Boolean setBidsUpdate(Integer promotionID, AdEngine searchEngine, BudgetObject budgetData) throws Exception;

	Map<String,Double> getBid(String accountID, Long campaignID, Long adGroupID, List<String> keywords) throws Exception ;

	//void getBidsInitial(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception;
	void getBidsInitialNaive(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception;

	//void getBidsUpdate(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception;
	void getBidsUpdateNaive(String accountID, Long campaignID, Long adGroupID, AdEngine searchEngine) throws Exception;
}
