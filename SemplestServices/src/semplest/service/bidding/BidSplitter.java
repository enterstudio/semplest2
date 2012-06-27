package semplest.service.bidding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.service.SemplestConfiguration;

public class BidSplitter {
	
	private static final Logger logger = Logger.getLogger(BidSplitter.class);

	public static HashMap<AdEngine, Double> GetMonthlyBudgetPercentPerSE(Integer promotionID, List<AdEngine> searchEngine) throws Exception 
	{		
		try{
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error("Unable to sleep! May have error in default config values! "+e.getMessage(), e);
		}
		
		Double googlePercent =  ((Integer) SemplestConfiguration.configData.get("SemplestBiddingGooglePercent")).doubleValue();

		
		// Right now always split 70-30 or 100 -- to be changed later
		HashSet<AdEngine> setSE = new HashSet<AdEngine>(); 
		for (AdEngine s : searchEngine){
			if(setSE.contains(s)){
				throw new Exception("Ad engine "+s+" appears twice!!");
			} else {
				setSE.add(s);
			}
		}

		HashMap<AdEngine,Double> budgetMap = new HashMap<AdEngine,Double>();

		switch (searchEngine.size()) {
			case 2:
				if(searchEngine.get(0) == AdEngine.Google && searchEngine.get(1) == AdEngine.MSN ||
				   searchEngine.get(0) == AdEngine.MSN && searchEngine.get(1) == AdEngine.Google)  
				{
					budgetMap.put(AdEngine.Google, new Double(googlePercent));
					budgetMap.put(AdEngine.MSN, new Double(100.0-googlePercent));
					break;
				}
				throw new Exception("Invalid combination of Ad engine options!");
			case 1:
				budgetMap.put(searchEngine.get(0), new Double(100.0));
				break;
			default:
				throw new Exception("Invalid number of Ad engines.. Received "+searchEngine.size()+" Ad engine names!");
		}

		
		return budgetMap;
	} // GetMonthlyBudgetPercentPerSE()

}
