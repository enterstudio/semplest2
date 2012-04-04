package semplest.services.client.api;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import semplest.server.protocol.ProtocolJSON;
import semplest.services.client.interfaces.SemplestBiddingInterface;

public class SemplestBiddingServiceClient extends ServiceRun implements SemplestBiddingInterface
{
	private static String SERVICEOFFERED = "semplest.service.bidding.BidGeneratorService";
	private static String BASEURLTEST = "http://VMJAVA1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	private static final Logger logger = Logger.getLogger(SemplestBiddingServiceClient.class);

	public static void main(String[] args)
	{
		try
		{
			Integer cust = 0;
			Integer camp = 1;
			Integer ad = 2;
			ArrayList<String> keywords = new  ArrayList<String>();
			keywords.add("peanut butter"); 
			keywords.add("ice"); 
			SemplestBiddingServiceClient client = new SemplestBiddingServiceClient();
			HashMap<String, Double> res = client.getBid(cust, camp, ad, keywords);
			System.out.println(String.valueOf(res.get("ice")));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<String, Double> getBid(Integer customerID, Integer campaignID, Integer adGroupID, ArrayList<String> keywords) throws Exception
	{
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerID", String.valueOf(customerID));
		jsonHash.put("campaignID", String.valueOf(campaignID));
		jsonHash.put("adGroupID", String.valueOf(adGroupID));
		String keyLevelStr = gson.toJson(keywords, ArrayList.class);
		jsonHash.put("keywords",keyLevelStr);
		String json = protocolJson.createJSONHashmap(jsonHash);

		String returnData = runMethod(BASEURLTEST, SERVICEOFFERED, "getBid", json, timeoutMS);
		return gson.fromJson(returnData, HashMap.class);
	}

}
