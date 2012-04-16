package semplest.service.bidding;
import java.util.Arrays;

import semplest.bidding.test.ioUtils;
import semplest.server.protocol.google.GoogleAdGroupObject;
import semplest.server.protocol.google.GoogleBidObject;
import semplest.server.protocol.google.GoogleTrafficEstimatorObject;
import semplest.services.client.api.GoogleAdwordsServiceClient;


//import semplest.service.google.adwords.GoogleAdwordsServiceImpl;


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
		
		
		
		GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(null);
//		GoogleAdwordsServiceImpl client = new GoogleAdwordsServiceImpl();
		
		GoogleBidObject[] bidObjects = null;
		GoogleBidObject bidObject;
		
		// A. Add the keywords to the campaign
		
//		Long maxCPC = 1000000L; // bid in microBidAmount;
//		addWords(accountID,	campaignID, adGroupID, keywords, maxCPC);
		
		
		
		// B. get the bid information from ad campaign
		
		// what i can get now: bid related info from google
		// TBD: 1. MSN/yahoo 
		//      2. quality/relevance score for keywords? can we get from keyword gen process?
		//      3. how to get competition info? data which return all zeros are non-competitive? 
		
		
		// get info about the keywords from GOOGLE
		try {
			bidObjects = client.getAllBiddableAdGroupCriteria(accountID, adGroupID, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		HashMap<String,Double> firstPageCPCMap = new HashMap<String,Double>();
		HashMap<String,Double> qualityScoreMap = new HashMap<String,Double>();
		
		for(int i=0; i<bidObjects.length; i++){
				bidObject = bidObjects[i];
				logger.info((i+1)+": "+bidObject.getKeyword()+": "+bidObject.getFirstPageCpc()*1e-6 + ": " + bidObject.getQualityScore()+ ", Status: "+ bidObject.getStatus());
				firstPageCPCMap.put(bidObject.getKeyword(), new Double(bidObject.getFirstPageCpc()*1e-6));
				qualityScoreMap.put(bidObject.getKeyword(), new Double(bidObject.getQualityScore()));
				

//					bidObject
//					try {
//						bidObject=client.setBidForKeyWord(accountID, bidObject.getBidID(), adGroupID,bidObject.getFirstPageCpc()+250000L );
//						Thread.sleep(500);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}					
//		}

				
			} // for(int i=0; i<bidObjects.length; i++)
		
		
		
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
	
	
	
	private void addWords(String accountID,
			Long campaignID, Long adGroupID, ArrayList<String> keywords, Long maxCPC){

		GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(null);
//		GoogleAdwordsServiceImpl client = new GoogleAdwordsServiceImpl();
				
		for(String word : keywords){
			try {
				client.addKeyWordToAdGroup(accountID, adGroupID, word , KeywordMatchType.EXACT, maxCPC);
//				logger.info(bidObject.getKeyword()+": "+bidObject.getFirstPageCpc()*1e-6 + ": " + bidObject.getQualityScore());
				logger.info("Added keyword: "+word+"to the account.");
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
				logger.info("Couldn't add keyword: "+word+"to the account. Exception received.");
			}
		}

	}

	
	
	public static void main(String[] args){
		

		String accountID = "2188810777";


		
////		ArrayList<String> lines = ioUtils.readFile("/semplest/data/biddingTest/Test1/keywords.txt");
//		ArrayList<String> lines = ioUtils.readFile("/semplest/data/biddingTest/Test1/keywordsProb.txt");
		ArrayList<String> lines = ioUtils.readFile("/semplest/data/biddingTest/Test1/keywordsProb500.txt");

		ArrayList<String> keywords = new ArrayList<String>();

		for (String line : lines){
			line=line.replaceFirst("\\S+\\s+", "") ; // for the new format
			keywords.add(line.replaceAll("\n",""));
//			System.out.println(line);
		}
		
//		System.exit(0);
		

		try {
			
			GoogleAdwordsServiceClient client = new GoogleAdwordsServiceClient(null);
//			GoogleAdwordsServiceImpl client = new GoogleAdwordsServiceImpl();


			ArrayList<HashMap<String, String>> campaignsByAccountId = client.getCampaignsByAccountId(accountID, false);
			Long campaignID = new Long(campaignsByAccountId.get(0).get("Id"));
			System.out.println(campaignID);
			

			GoogleAdGroupObject[] adGroups = null;
			
			try {
				adGroups = client.getAdGroupsByCampaignId(accountID, campaignID, false);
				for (int i=0; i< adGroups.length; i++)
					System.out.println(adGroups[i].getAdGroupName()+": "+adGroups[i].getAdGroupID());
			} catch (Exception e) {
				e.printStackTrace();
			}
				
			Long adGroupID = adGroups[0].getAdGroupID();
			


			BidGeneratorServiceImpl bidGenerator = new BidGeneratorServiceImpl();
			bidGenerator.getBid(accountID, campaignID, adGroupID, keywords);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
