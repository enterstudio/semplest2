package semplest.service.bidding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import semplest.server.protocol.ProtocolEnum.AdEngine;

public class BidSplitter {
	
	public static HashMap<String, Integer> GetMonthlyBudgetPercentPerSE(
			Integer promotionID, ArrayList<String> searchEngine) throws Exception {
			
		// Right now always split 70-30 or 100 -- to be changed later
		HashSet<String> setSE = new HashSet<String>(); 
		for (String s : searchEngine){
			if(setSE.contains(s)){
				throw new Exception("Ad engine "+s+" appears twice!!");
			} else {
				setSE.add(s);
			}
			if (!AdEngine.existsAdEngine(s)){
				throw new Exception("Ad engine "+ s + " Not Found");
			}
		}

		HashMap<String,Integer> budgetMap = new HashMap<String,Integer>();

		switch (searchEngine.size()) {
			case 2:
				if(searchEngine.get(0).equalsIgnoreCase("Google") && searchEngine.get(1).equalsIgnoreCase("MSN") ||
						searchEngine.get(0).equalsIgnoreCase("MSN") && searchEngine.get(1).equalsIgnoreCase("Geogle") ) {
					budgetMap.put("Google", new Integer(70));
					budgetMap.put("MSN", new Integer(30));
					break;
				}
				throw new Exception("Invalid combination of Ad engine options!");
			case 1:
				budgetMap.put(searchEngine.get(0), new Integer(100));
			default:
				throw new Exception("Invalid number of Ad engines.. Received "+searchEngine.size()+" Ad engine names!");
		}

		
		return budgetMap;
	} // GetMonthlyBudgetPercentPerSE()

}
