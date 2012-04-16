package semplest.service.bidding;
import java.util.Arrays;

import semplest.bidding.test.ioUtils;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleBidObject;
import semplest.server.protocol.google.GoogleTrafficEstimatorObject;
import semplest.services.client.api.GoogleAdwordsServiceClient;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.google.api.adwords.v201109.cm.AdGroup;
import com.google.api.adwords.v201109.cm.KeywordMatchType;
import com.google.api.adwords.v201109.cm.Money;

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
		String accountID = data.get("accountID");
		Long campaignID = Long.parseLong(data.get("campaignID")); 
		Long adGroupID = Long.parseLong(data.get("adGroupID"));
		ArrayList<String> keywords = gson.fromJson(data.get("keywords"), ArrayList.class);
		HashMap<String,Double> res = getBid(accountID,campaignID,adGroupID, keywords);
		return gson.toJson(res);
	}
	
	
	@Override
	public HashMap<String,Double> getBid(String accountID,
			Long campaignID, Long adGroupID, ArrayList<String> keywords)
			throws Exception {
		
		logger.info("Computing bids ...");

		
		
		
		// ************************************************************************** 
		
		// A. get the bid information from ad campaign
		
		// what i can get now: bid related info from google
		// TBD: 1. MSN/yahoo 
		//      2. quality/relevance score for keywords? can we get from keyword gen process?
		//      3. how to get competition info? data which return all zeros are non-competitive? 
		
		
		try
		{
			GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(null);

			ArrayList<Double> bidLevels = new ArrayList<Double>();

			for (double b = 1.1; b<3.5; b=b+0.5){
				bidLevels.add(new Double(b));
			}
//			System.out.println("Number of points on bid axis: "+bidLevels.size());
//			for(int i=0; i< bidLevels.size(); i++){
//				System.out.format("Bid: %.1f\n",bidLevels.get(i));
//			}
			
			
			HashMap<String, Double > keywordbids = new HashMap<String, Double >();
			/*
			for (String word : keywords){
				keywordbids.put(word, bidLevels.get(0)); //THIS NEEDS TO BE FIXED
				GoogleTrafficEstimatorObject o = client.getTrafficEstimationForKeywords(accountID, campaignID, KeywordMatchType.EXACT, keywordbids);
				
				Double[] bids = o.getBidList();
				Arrays.sort(bids);

				logger.info(word);
				for (int i = 0; i < bids.length; i++) {
					System.out.println(bids[i]/1e6 + " Avg Clicks=" + o.getMaxAveClickPerDay(bids[i])
							+ " Avg CPC="+ o.getAveCPC(bids[i]) + " Avg Pos=" + o.getAvePosition(bids[i]));
				}
				
			}
			*/
			
			

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 // ************************************************************************** 

		
		// B. decide which keywords to are competitive and which ones are not
		
		HashMap<String,Double> bidData = new HashMap<String,Double>();

		
		 // ************************************************************************** 

		
		// C. bid by a pre-determined strategy for the keywords that are non-competitive
		
		// TBD: 1. random or aim for first/top page? do we get any other information like bid for first or top page?
		
		
		
		 // ************************************************************************** 
		
		// D. compute optimal bids for the competitive keywords
		
		for(String s : keywords){
			bidData.put(s, new Double(1.0));
		}
		// TODO Auto-generated method stub
		return bidData;
	}
	
	public static void main(String[] args){
		

		String accountID = "2188810777";


		
////		ArrayList<String> lines = ioUtils.readFile("/semplest/data/biddingTest/Test1/keywords.txt");
//		ArrayList<String> lines = ioUtils.readFile("/semplest/data/biddingTest/Test1/keywordsProb.txt");
//
//		ArrayList<String> keywords = new ArrayList<String>();
//		
//		for (String line : lines){
//			line=line.replaceFirst("\\S+\\s+", "") ; // for the new format
//			keywords.add(line.replaceAll("\n",""));
////			System.out.println(line);
//		}
		
//		System.exit(0);
		

		
		ArrayList<Double> bidLevels; 

		

		try {
			
			GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(null);
			GoogleTrafficEstimatorObject o;

			
			GoogleBidObject bidObject;
			GoogleBidObject[] bidObjects = null;
			Long maxCPC;

			ArrayList<HashMap<String, String>> campaignsByAccountId = client.getCampaignsByAccountId(accountID, false);
			Long campaignID = new Long(campaignsByAccountId.get(0).get("Id"));
//			System.out.println(campaignID);
			

			GoogleAdGroupObject[] adGroups = null;
			
			try {
				adGroups = client.getAdGroupsByCampaignId(accountID, campaignID, false);
				for (int i=0; i< adGroups.length; i++)
					System.out.println(adGroups[i].getAdGroupName()+": "+adGroups[i].getAdGroupID());
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			Long adGroupID = adGroups[0].getAdGroupID();
			
			
//			maxCPC = 100000L; // bid in microBidAmount
//			int count=0;
//			for(String word : keywords){
//				count++;
//				System.out.println(count+": "+word);
//				try {
//					bidObject = client.addKeyWordToAdGroup(accountID, adGroupID, word , KeywordMatchType.EXACT, maxCPC);
//					Thread.sleep(500);
//				} catch (Exception e) {
//					e.printStackTrace();
//					System.out.println("Skipping keyword: "+word);
//				}
//			}
//			
//			Thread.sleep(10000);
			
			
			try {
				bidObjects = client.getAllBiddableAdGroupCriteria(accountID, adGroupID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(bidObjects.length);
			System.exit(0);

			
//			System.out.println(bidObjects[1000].getKeyword());
			
//			for(int i=0; i<bidObjects.length; i++){
////			for(int i=10; i<12; i++){
//				bidObject = bidObjects[i];
////				client.getBidLandscapeForKeyword(accountID, adGroupID, bidObjects[i].getBidID());
////				System.out.println(i+": "+bidObject.getKeyword()+": "+bidObject.getFirstPageCpc()*1e-6 + ": " + bidObject.getQualityScore());
//				if(bidObject.getFirstPageCpc()<8000000L) {
//					System.out.println((i+1)+": "+bidObject.getKeyword()+": "+bidObject.getFirstPageCpc()*1e-6 + ": " + bidObject.getQualityScore());
//					try {
//						bidObject=client.setBidForKeyWord(accountID, bidObject.getBidID(), adGroupID,bidObject.getFirstPageCpc()+250000L );
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					Thread.sleep(500);
//				}
////				System.out.println(bidObject.getMicroBidAmount());
//				
//				
////				bidLevels = new ArrayList<Double>();
////				for (double b = bidObject.getFirstPageCpc()*1e-6+0.05; b<bidObject.getFirstPageCpc()*1e-6+0.5; b=b+0.5){
//////					bidLevels.add(new Double(b/bidObject.getQualityScore()));
////					bidLevels.add(new Double(b));
////				}
////				
////				o = client.getTrafficEstimationForOneKeyword(bidObject.getKeyword(), KeywordMatchType.EXACT, bidLevels);
////				Double[] bids = o.getBidList();
////				Arrays.sort(bids);
////
////				logger.info(bidObject.getKeyword());
////				for (int j = 0; j < bids.length; j++) {
////					logger.info(bids[j]/1e6 + " Avg Clicks=" + o.getMaxAveClickPerDay(bids[j])
////							+ " Avg CPC="+ o.getAveCPC(bids[j]) + " Avg Pos=" + o.getAvePosition(bids[j]));
////				}
//				
//			} // for(int i=0; i<bidObjects.length; i++)
			
//			System.out.println(bidObjects.length);
//			bidObject = bidObjects[0];
//			System.out.println(bidObject.getKeyword()+": "+bidObject.getFirstPageCpc() + ": " + bidObject.getQualityScore());
			
			
//			maxCPC = 200000L;
//			bidObject=client.setBidForKeyWord(accountID, 16748361L, adGroupID, maxCPC);
//			System.out.println(bidObject.getMicroBidAmount());

			
			
//			String [] words = client.getAllAdGroupKeywords(accountID, adGroupID);
//			System.out.println(words.length);
			
//			client.UpdateCampaignName(accountID, campaignID, "Test 1");
//			campaignsByAccountId = client.getCampaignsByAccountId(accountID, false);

//			Money m =new Money();
//			m.setMicroAmount(360000L);
//			client.changeCampaignBudget(accountID, campaignID, m); //doesn't work
//			campaignsByAccountId = client.getCampaignsByAccountId(accountID, false);
			
//			AdGroup[] adGroups = client.getAdGroupsByCampaignId(accountID, campaignID, false);
//			client.

//			BidGeneratorServiceImpl bidGenerator = new BidGeneratorServiceImpl();
//			bidGenerator.getBid(customerID, campaignID, adGroupID, keywords);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
