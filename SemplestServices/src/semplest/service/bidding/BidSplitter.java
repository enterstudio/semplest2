package semplest.service.bidding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;

public class BidSplitter {
	
	public static HashMap<String, Double> GetMonthlyBudgetPercentPerSE(
			Integer promotionID, ArrayList<String> searchEngine) throws Exception {
			
		// Right now always split 70-30 or 100 -- to be changed later
		HashSet<String> setSE = new HashSet<String>(); 
		for (String s : searchEngine){
			if(setSE.contains(s.toLowerCase())){
				throw new Exception("Ad engine "+s+" appears twice!!");
			} else {
				setSE.add(s.toLowerCase());
			}
			if (!AdEngine.existsAdEngine(s)){
				throw new Exception("Ad engine "+ s + " Not Found");
			}
		}

		HashMap<String,Double> budgetMap = new HashMap<String,Double>();

		String google = ProtocolEnum.AdEngine.Google.name();
		String msn = ProtocolEnum.AdEngine.MSN.name();
		switch (searchEngine.size()) {
			case 2:
				if(searchEngine.get(0).equalsIgnoreCase(google) && searchEngine.get(1).equalsIgnoreCase(msn) ||
						searchEngine.get(0).equalsIgnoreCase(msn) && searchEngine.get(1).equalsIgnoreCase(google) ) {
					budgetMap.put(google, new Double(70.));
					budgetMap.put(msn, new Double(30.));
					break;
				}
				throw new Exception("Invalid combination of Ad engine options!");
			case 1:
				budgetMap.put(searchEngine.get(0), new Double(100.));
				break;
			default:
				throw new Exception("Invalid number of Ad engines.. Received "+searchEngine.size()+" Ad engine names!");
		}

		
		return budgetMap;
	} // GetMonthlyBudgetPercentPerSE()

}
