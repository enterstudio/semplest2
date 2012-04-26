package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import semplest.server.protocol.adengine.BidObject;

public interface SemplestBiddingInterface extends ServiceInitialize {
	
	HashMap<String,Double> getBid(String accountID, Long campaignID, Long adGroupID, ArrayList<String> keywords) throws Exception ;

	void getBidsInitial(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception;

	void getBidsUpdate(String accountID, Long campaignID, Long adGroupID, String searchEngine) throws Exception;

	HashMap<String,Double> GetMonthlyBudgetPerSE(ArrayList<String> searchEngine, Double TotalMonthlyBudget) throws Exception;

	



}
