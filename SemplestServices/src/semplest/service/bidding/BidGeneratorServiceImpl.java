package semplest.service.bidding;


import semplest.server.protocol.google.GoogleTrafficEstimatorObject;
import semplest.services.client.api.GoogleAdwordsServiceClient;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.gson.Gson;

//import com.google.gson.Gson;

import semplest.services.client.interfaces.SemplestBiddingInterface;

public class BidGeneratorServiceImpl implements SemplestBiddingInterface {
	
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(BidGeneratorServiceImpl.class);

	@Override
	public void initializeService(String input) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public String getBid(String json) throws Exception
	{
		logger.debug("call  getBid(String json)" + json);
		HashMap<String, String> data = gson.fromJson(json, HashMap.class);
		Integer customerID = Integer.parseInt(data.get("customerID"));
		Integer campaignID = Integer.parseInt(data.get("campaignID")); 
		Integer adGroupID = Integer.parseInt(data.get("adGroupID"));
		ArrayList<String> keywords = gson.fromJson(data.get("keywords"), ArrayList.class);
		HashMap<String,Double> res = getBid(customerID,campaignID,adGroupID, keywords);
		return gson.toJson(res);
	}
	
	
	@Override
	public HashMap<String,Double> getBid(Integer customerID,
			Integer campaignID, Integer adGroupID, ArrayList<String> keywords)
			throws Exception {
		
		logger.info("Computing bids ...");

		
		// get the bid information from ad campaign
		
		
		try
		{
			GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(null);

			ArrayList<Double> bidLevels = new ArrayList<Double>();
			for (double b = 1.0; b<1.5; b=b+0.1){
				bidLevels.add(new Double(b));
			}
			System.out.println("Number of points on bid axis: "+bidLevels.size());
			for(int i=0; i< bidLevels.size(); i++){
				System.out.format("Bid: %.1f\n",bidLevels.get(i));
			}
			
//			bidLevels.add(0.9);
//			bidLevels.add(1.00);
//			bidLevels.add(1.20);
//			bidLevels.add(1.50);
//			bidLevels.add(2.00);

//			 bidLevels.add(1.50);
//			 bidLevels.add(10.50);
//			 bidLevels.add(0.75);
			
			GoogleTrafficEstimatorObject o = client.getTrafficEstimationForOneKeyword("red shoe", KeywordMatchType.EXACT, bidLevels);
			Double[] bids = o.getBidList();
			for (int i = 0; i < bids.length; i++)
			{
				System.out.println(bids[i] + " Aveclicks=" + o.getMaxAveClickPerDay(bids[i]) + " AveCPC=" + o.getAveCPC(bids[i]));
			}


		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// decide which keywords to are competitive and which ones are not
		
		HashMap<String,Double> bidData = new HashMap<String,Double>();

		// bid by a pre-determined strategy for the keywords that are non-competitive
		
		// compute optimum bids for the competitive keywords
		
		for(String s : keywords){
			bidData.put(s, new Double(1.0));
		}
		// TODO Auto-generated method stub
		return bidData;
	}
	
	public static void main(String[] args){
		
		Integer customerID = new Integer(0);
		Integer campaignID = new Integer(0);
		Integer adGroupID = new Integer(0);
		ArrayList<String> keywords = new ArrayList<String>();
		keywords.add("wedding venues");
		keywords.add("ice");
		

		try {

			BidGeneratorServiceImpl bidGenerator = new BidGeneratorServiceImpl();
			bidGenerator.getBid(customerID, campaignID, adGroupID, keywords);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
