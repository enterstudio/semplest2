package semplest.service.bidding;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import semplest.keywords.lda.KWGenDmozLDAServer;
import semplest.services.client.interfaces.SemplestBiddingInterface;
import semplest.services.client.interfaces.SemplestKeywordLDAServiceInterface;

public class BidGeneratorServiceImpl implements SemplestBiddingInterface {

	@Override
	public void initializeService(String input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashMap<String, Double> getBid(Integer customerID,
			Integer campaignID, Integer adGroupID, ArrayList<String> keywords)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
