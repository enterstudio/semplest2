package semplest.services.client.interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public interface SemplestBiddingInterface extends ServiceInitialize {
	
	HashMap<String,Double> getBid(Integer customerID, Integer campaignID, Integer adGroupID, ArrayList<String> keywords) throws Exception ;

}
