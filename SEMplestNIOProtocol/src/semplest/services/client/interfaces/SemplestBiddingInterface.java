package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface SemplestBiddingInterface extends ServiceInitialize {
	
	HashMap<String,Double> getBid(String accountID, Long campaignID, Long adGroupID, ArrayList<String> keywords) throws Exception ;

}
