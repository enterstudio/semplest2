package semplest.service.bidding;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

//import com.google.gson.Gson;

import semplest.services.client.interfaces.SemplestBiddingInterface;

public class BidGeneratorServiceImpl implements SemplestBiddingInterface {
	
	private static final Logger logger = Logger.getLogger(BidGeneratorServiceImpl.class);

	@Override
	public void initializeService(String input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String,Double> getBid(Integer customerID,
			Integer campaignID, Integer adGroupID, ArrayList<String> keywords)
			throws Exception {
		
		
		logger.info("Computing bids ...");
		HashMap<String,Double> bidData = new HashMap<String,Double>();
		for(String s : keywords){
			bidData.put(s, new Double(1.0));
		}
		// TODO Auto-generated method stub
		return bidData;
	}

}
