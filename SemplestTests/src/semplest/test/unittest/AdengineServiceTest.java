package semplest.test.unittest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupCriterion;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignCriterion;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.TextAd;

import semplest.server.protocol.KeywordIdRemoveOppositePair;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.adengine.SemplestAdengineServiceImpl;
import semplest.server.service.springjdbc.BaseDB;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.services.client.api.SemplestAdEngineServiceClient;

public class AdengineServiceTest extends BaseDB{	
	
	private int errorCounter = 0;
	private int sleepTime = 500;
	
	private String vMsg = "Verification FAILED! ";
	
	//private String baseUrl = "http://172.18.9.26:9898/semplest";	
	private String baseUrl = "http://VMDEVJAVA1:9898/semplest";
	
	SemplestAdEngineServiceClient adEngine;
	GoogleAdwordsServiceImpl google;
	MsnCloudServiceImpl msn;
	
	//Semplest Variables
	private Integer semplestCustomerId = 1388;
	private Integer semplestProductGroupId = 196;
	private Integer semplestPromotionId = 207;
	private ArrayList<String> adEngineList = new ArrayList<String>(Arrays.asList(AdEngine.Google.name()));
	private List<Integer> promotionAdIds = Arrays.asList(2255,2256,2257);
	private List<Integer> keywordIds = Arrays.asList(622665, 622666, 622667);
	private List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs;
	private List<Integer> productGroupIds = Arrays.asList(196,197);
	
	//Variables
	private Integer googleAccountId = 54103;
	private Long msnAccountId = 1629687L;
	private Long campaignId;
	private Long adGroupId;
	
	public static void main(String[] args){
		AdengineServiceTest test = new AdengineServiceTest();
		test.Test_Adengine_Client();
	}
	
	public int Test_Adengine_Client(){
		
		try{
			//Load the configuration
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			Object object = new Object();
			SemplestConfiguration configDB = new SemplestConfiguration(object);
			Thread configThread = new Thread(configDB);
			configThread.start();
			synchronized (object)
			{
				object.wait();
			}
						
			adEngine = new SemplestAdEngineServiceClient(baseUrl);
			google = new GoogleAdwordsServiceImpl();
			msn = new MsnCloudServiceImpl();
			
		
			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                              AdEngine Test (Client)                              #");
			System.out.println("#                                                                                  #");
			System.out.println("####################################################################################");			
			
			adEngineList =  new ArrayList<String>();
			adEngineList.add(AdEngine.Google.name());
			
			
			/* ********** Start to Test ********** */
			
			AddPromotionToAdEngine();  //Manually verification
			PausePromotion();  //google,msn
			cleanUp();
/*			PausePromotion();  //google,msn
			UnpausePromotion();  //google,msn
			ChangePromotionStartDate();  //done
			UpdateGeoTargeting();  //change in database, manual veri
			UpdateBudget();  //TODO
			RefreshSiteLinks();  //TODO
			AddAds();  //TODO
			UpdateAds();  //TODO
			DeleteAds();  //TODO
			AddKeywords();  //TODO
			DeleteKeywords();  //TODO
			AddNegativeKeywords();  //TODO
			DeleteNegativeKeywords();  //TODO
			PauseProductGroups();  //TODO
			ExecuteBidProcess();  //TODO			
	*/		
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		if(errorCounter > 0){
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                          AdEngine Test (Client) FAILED!                          #");
			System.out.println("####################################################################################");
		}
		else{
			System.out.println(" ");
			System.out.println("####################################################################################");
			System.out.println("#                          AdEngine Test (Client) PASSED!                          #");
			System.out.println("####################################################################################");
		}
		
		return errorCounter;
	}
	
	private void AddPromotionToAdEngine() throws Exception{
		//AddPromotionToAdEngine
		System.out.println("------------------------------------------------------------");
		try{				
			//update the promotion name in database
			String campaignName = "AdEng_" + System.currentTimeMillis() ;
			String sql = "UPDATE Promotion SET PromotionName = ? WHERE PromotionPK = 207";
			jdbcTemplate.update(sql,new Object[]{campaignName});
			
			//call the method
			System.out.println("AddPromotionToAdEngine(" + semplestCustomerId + ", " +  semplestProductGroupId + ", " + semplestPromotionId + ", " + AdEngine.Google.name() + ")");
			adEngine.AddPromotionToAdEngine(semplestCustomerId, semplestProductGroupId, semplestPromotionId, adEngineList);
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			
			/* ********** Verification ********** */		
						
			//***check if we got all the things created successfully at google, and stored necessary information in the database	
			System.out.println("Verify IDs:");
			
			sql = "SELECT aep.AdvertisingEngineCampaignPK FROM AdvertisingEnginePromotion aep WHERE PromotionFK = ?";
			campaignId = jdbcTemplate.queryForLong(sql, semplestPromotionId);
			
			sql = "SELECT aep.AdvertisingEngineAdGroupID FROM AdvertisingEnginePromotion aep WHERE PromotionFK = ?";
			adGroupId = jdbcTemplate.queryForLong(sql, semplestPromotionId);
			
			System.out.println(" -Account ID = " + googleAccountId);
			System.out.println(" -Campaign ID = " + campaignId);
			System.out.println(" -AdGroup ID = " + adGroupId);
			
			if(campaignId.equals(null) || adGroupId.equals(null)){
				errorHandler(new Exception(vMsg + "The promotion is not created correctly. One or more IDs are missing in the database."));
			}
			else{
				System.out.println("*ID verification PASSED");
				
				sql = "SELECT AdTitle FROM PromotionAds WHERE PromotionFK = 207 and IsDeleted = 0";
				List<String> adTitles = jdbcTemplate.queryForList(sql, String.class);
				List<String> dkws = Arrays.asList("nan adengine test","nan adengine test one","nan adengine test two");
				
				/* ***** For Google ***** */
				
				System.out.println("=== Verify result on Google ===");
				
				//***check if we have all the ads are set up on google
				System.out.println("Verify ADs:");				
				AdGroupAd[] gads = google.getAdsByAdGroupId(googleAccountId.toString(), new Long(adGroupId).longValue());
				System.out.println("Ads that we put on google:");
				//verify content of the Ads
				int match = 0;
				for(AdGroupAd ad : gads){
					TextAd ad2 = (TextAd)ad.getAd();
					System.out.println(" -" + ad2.getHeadline());
					if(ad2.getHeadline().equals(adTitles.get(0)))
						match++;
				}	
				if(match != 1){
					errorHandler(new Exception(vMsg + "Ads are not created correctly on google. " +
							"An Ad title '" + adTitles.get(0) + "' is not found."));
				}
				if(gads.length != adTitles.size()){
					//verify the num of Ads get added
					errorHandler(new Exception(vMsg + "The num of Ads in database and the num of Ads be created on google don't match. " +
							"Num of active Ads in database: " + adTitles.size() + ". Num of Ads added to google: " + gads.length));
				}
				
				//***check if we have all the keywords are set up on google
				System.out.println("Verify Keywords:");				
				String[] gkws = google.getAllAdGroupKeywords(googleAccountId.toString(), new Long(adGroupId), true);
				System.out.println("Keywords that we put on google:");
				//verify content of the Keywords
				match = 0;
				for(String kw : gkws){
					System.out.println(" -" + kw);
					if(kw.equals(dkws.get(1)))
						match++;
				}				
				if(match != 1){
					errorHandler(new Exception(vMsg + "Keywords are not created correctly on google. " +
							"An Keyword '" + dkws.get(1) + "' is not found."));
				}
				if(gkws.length != dkws.size()){
					//verify the num of Keywords get added
					errorHandler(new Exception(vMsg + "Not all Keywords in database are created on google. " +
							"Num of Keywords in database: " + dkws.size() + ". Num of Ads added to google: " + gkws.length));
				}				
				
				//***check if we set negative keywords correctly on google					
				//TODO
				
				//***check if we set geoTarget correctly on google
				System.out.println("Verify Geo Targets: (Manually)");		
				
				//***check if we schedule the OnGoingBidding correctly in the database
				System.out.println("Verify OnGoingBidding Schedule: (Manually)");
				
				
/*				 ***** For MSN ***** 
				
				System.out.println("=== Verify result on MSN ===");
				
				//***check if we have all the ads are set up on msn
				System.out.println("Verify ADs:");
				
				com.microsoft.adcenter.v8.Ad[] mads = msn.getAdsByAdGroupId(msnAccountId, adGroupId);
				//verify content of the Ads
				System.out.println("Ads that we put on msn:");
				match = 0;
				for(com.microsoft.adcenter.v8.Ad ad : mads){
					com.microsoft.adcenter.v8.TextAd ad2 = (com.microsoft.adcenter.v8.TextAd)ad;
					System.out.println(" -" + ad2.getTitle());
					if(ad2.getTitle().equals(adTitles.get(0)))
						match++;
				}						
				if(match != 1){
					errorHandler(new Exception(vMsg + "Ads are not created correctly on MSN. " +
							"An Ad title '" + adTitles.get(0) + "' is not found."));
				}				
				if(mads.length != adTitles.size()){
					//verify the num of Ads get added
					errorHandler(new Exception(vMsg + "The num of Ads in database and the num of Ads be created on MSN don't match. " +
							"Num of active Ads in database: " + adTitles.size() + ". Num of Ads added to google: " + mads.length));
				}				
				
				//***check if we have all the keywords are set up on google
				System.out.println("Verify Keywords:");
				
				com.microsoft.adcenter.v8.Keyword[] mkws = msn.getKeywordByAdGroupId(msnAccountId, new Long(adGroupId));
				System.out.println("Keywords that we put on MSN:");
				//verify content of the Keywords
				match = 0;
				for(com.microsoft.adcenter.v8.Keyword kw : mkws){
					System.out.println(" -" + kw);
					if(kw.equals(dkws.get(1)))
						match++;
				}		
				if(match != 1){
					errorHandler(new Exception(vMsg + "Keywords are not created correctly on MSN. " +
							"An Keyword '" + dkws.get(1) + "' is not found."));
				}
				if(mkws.length != dkws.size()){
					//verify the num of Keywords get added
					errorHandler(new Exception(vMsg + "Not all Keywords in database are created on MSN. " +
							"Num of Keywords in database: " + dkws.size() + ". Num of Ads added to MSN: " + mkws.length));
				}				
				
				//***check if we set negative keywords correctly on google					
				//TODO
				
				//***check if we set geoTarget correctly on google
				System.out.println("Verify Geo Targets: (Manually)");		
				
				//***check if we schedule the OnGoingBidding correctly in the database
				System.out.println("Verify OnGoingBidding Schedule: (Manually)");*/
								
			}			
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);			
		
	}
	
	private void PausePromotion() throws Exception{
		//PausePromotion
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("PausePromotion(" + semplestPromotionId + ", " + AdEngine.Google.name() + ")");
			//adEngine.PausePromotion(semplestPromotionId, adEngineList);
			adEngine.schedulePausePromotion(semplestCustomerId, semplestPromotionId, adEngineList);
			System.out.println("DONE");			
			Thread.sleep(sleepTime);
			
			//Verification
			
			/* ***** For Google ***** */			
			System.out.println("=== Verify result on Google ===");
			ArrayList<HashMap<String, String>> ret = google.getCampaignsByAccountId(googleAccountId.toString(), false);
			for(HashMap<String, String> map : ret){
				if(map.get("Id").equals(campaignId.toString())){
					String status = map.get("Status");
					System.out.println("Status of Campaign " + campaignId + " is - " + status);
					if(!status.equals(CampaignStatus.PAUSED.getValue())){
						errorHandler(new Exception(vMsg + "Campaign is not paused."));
					}
				}
			}
			
			/* ***** For MSN ***** */			
			/*System.out.println("=== Verify result on MSN ===");
			com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(msnAccountId, campaignId);
			if(!mcpn.getStatus().equals(com.microsoft.adcenter.v8.CampaignStatus.Paused)){
				errorHandler(new Exception(vMsg + "Campaign is not paused."));
			}*/
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void UnpausePromotion() throws Exception{
		//UnpausePromotion
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("UnpausePromotion(" + semplestPromotionId + ", " + AdEngine.Google.name() + ")");
			adEngine.UnpausePromotion(semplestPromotionId, adEngineList);
			System.out.println("DONE");			
			Thread.sleep(sleepTime);
			
			//Verification
			
			/* ***** For Google ***** */			
			System.out.println("=== Verify result on Google ===");
			ArrayList<HashMap<String, String>> ret = google.getCampaignsByAccountId(googleAccountId.toString(), false);
			for(HashMap<String, String> map : ret){
				if(map.get("Id").equals(campaignId.toString())){
					String status = map.get("Status");
					System.out.println("Status of Campaign " + campaignId + " is - " + status);
					if(!status.equals(CampaignStatus.ACTIVE.getValue())){
						errorHandler(new Exception(vMsg + "Campaign is not unpaused."));
					}
				}
			}
			
			/* ***** For MSN ***** */			
			System.out.println("=== Verify result on MSN ===");
			com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(msnAccountId, campaignId);
			if(!mcpn.getStatus().equals(com.microsoft.adcenter.v8.CampaignStatus.Active)){
				errorHandler(new Exception(vMsg + "Campaign is not unpaused."));
			}
			
			//Pause the promotion again (and double check the PausePromotion)
			System.out.println("Pause the promotion again (and double check the PausePromotion function)");
			adEngine.PausePromotion(semplestPromotionId, adEngineList);
			//google
			ArrayList<HashMap<String, String>> ret2 = google.getCampaignsByAccountId(googleAccountId.toString(), false);
			for(HashMap<String, String> map : ret2){
				if(map.get("Id").equals(campaignId.toString())){
					String status = map.get("Status");
					System.out.println("Status of Campaign " + campaignId + " is - " + status);
					if(!status.equals(CampaignStatus.PAUSED.getValue())){
						errorHandler(new Exception(vMsg + "Campaign is not paused on Google."));
					}
				}
			}
			//msn
			com.microsoft.adcenter.v8.Campaign mcpn2 = msn.getCampaignById(msnAccountId, campaignId);
			if(!mcpn2.getStatus().equals(com.microsoft.adcenter.v8.CampaignStatus.Paused)){
				errorHandler(new Exception(vMsg + "Campaign is not paused on MSN."));
			}		
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void ChangePromotionStartDate() throws Exception{
		//ChangePromotionStartDate
		System.out.println("------------------------------------------------------------");
		try{
			Date startDate = new Date();
			System.out.println("ChangePromotionStartDate(" + semplestPromotionId + ", " + startDate.toString() + ", " + AdEngine.Google.name() + ")");
			adEngine.ChangePromotionStartDate(semplestPromotionId, startDate, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			DateFormat df = new SimpleDateFormat("YYYYMMDD");
			ArrayList<HashMap<String, String>> ret2 = google.getCampaignsByAccountId(googleAccountId.toString(), false);
			for(HashMap<String, String> map : ret2){
				if(map.get("Id").equals(campaignId.toString())){
					String ret = map.get("StartDate");
					System.out.println("StartDate of Campaign " + campaignId + " is - " + ret);
					if(!ret.equals(df.format(startDate))){
						errorHandler(new Exception(vMsg + "Campaign is not updated to Date " + df.format(startDate)));
					}
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void UpdateGeoTargeting() throws Exception{
		//UpdateGeoTargeting
		System.out.println("------------------------------------------------------------");
		try{
			//TODO
			//Change the geotarget in the database
			
			
			System.out.println("UpdateGeoTargeting(" + semplestPromotionId + ", " + AdEngine.Google.name() + ")");
			adEngine.UpdateGeoTargeting(semplestPromotionId, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void UpdateBudget() throws Exception{
		//UpdateBudget
		System.out.println("------------------------------------------------------------");
		try{
			Double changeInBudget = (Double)(System.currentTimeMillis()/10000000000.00);
			System.out.println("UpdateBudget(" + semplestPromotionId + ", " + changeInBudget + ", " + AdEngine.Google.name() + ")");
			adEngine.UpdateBudget(semplestPromotionId, changeInBudget, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void RefreshSiteLinks() throws Exception{
		//RefreshSiteLinks
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("RefreshSiteLinks(" + semplestPromotionId + ", " + AdEngine.Google.name() + ")");
			adEngine.RefreshSiteLinks(semplestPromotionId, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void AddAds() throws Exception{
		//AddAds
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("AddAds(" + semplestPromotionId + ", " + "promotionAdIds" + ", " + AdEngine.Google.name() + ")");
			adEngine.AddAds(semplestPromotionId, promotionAdIds, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void UpdateAds() throws Exception{
		//UpdateAds
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("UpdateAds(" + semplestPromotionId + ", " + "promotionAdIds" + ", " + AdEngine.Google.name() + ")");
			adEngine.UpdateAds(semplestPromotionId, promotionAdIds, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void DeleteAds() throws Exception{
		//DeleteAds
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("DeleteAds(" + semplestPromotionId + ", " + "promotionAdIds" + ", " + AdEngine.Google.name() + ")");
			adEngine.DeleteAds(semplestPromotionId, promotionAdIds, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void AddKeywords() throws Exception{
		//AddKeywords
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("AddKeywords(" + semplestPromotionId + ", " + "keywordIds" + ", " + AdEngine.Google.name() + ")");
			adEngine.AddKeywords(semplestPromotionId, keywordIds, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void DeleteKeywords() throws Exception{
		//DeleteKeywords
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("DeleteKeywords(" + semplestPromotionId + ", " + "keywordIds" + ", " + AdEngine.Google.name() + ")");
			adEngine.DeleteKeywords(semplestPromotionId, keywordIds, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void AddNegativeKeywords() throws Exception{
		//AddNegativeKeywords
		System.out.println("------------------------------------------------------------");
		try{
			//no same positive keyword exists in the database before
			//TODO
			
			//same positive keyword already exists in the database
			//firstly add positive keyword and related keywords
			//TODO
			//Then set negative keyword
			KeywordIdRemoveOppositePair nk1 = new KeywordIdRemoveOppositePair(keywordIds.get(0),true);
			keywordIdRemoveOppositePairs.add(nk1);
			System.out.println("AddNegativeKeywords(" + semplestPromotionId + ", " + "keywordIdRemoveOppositePairs[622665,true]" + ", " + AdEngine.Google.name() + ")");
			adEngine.AddNegativeKeywords(semplestPromotionId, keywordIdRemoveOppositePairs, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void DeleteNegativeKeywords() throws Exception{
		//DeleteNegativeKeywords
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("DeleteNegativeKeywords(" + semplestPromotionId + ", " + "keywordIds[622665]" + ", " + AdEngine.Google.name() + ")");
			adEngine.DeleteNegativeKeywords(semplestPromotionId, keywordIds.subList(0, 1), adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void PauseProductGroups() throws Exception{
		//PauseProductGroups
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("PauseProductGroups(" + semplestPromotionId + ", " + "productGroupIds[196,197]" + ", " + AdEngine.Google.name() + ")");
			adEngine.PauseProductGroups(productGroupIds, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void ExecuteBidProcess() throws Exception{
		//ExecuteBidProcess
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("v(" + semplestPromotionId + ", " + AdEngine.Google.name() + ")");
			adEngine.ExecuteBidProcess(semplestPromotionId, adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			//TODO
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void errorHandler(Exception e){
		e.printStackTrace();
		System.out.println("////////////////////////////////////////////////////");	
		System.out.println("ERROR:");
		System.out.println(e.getMessage());
		StackTraceElement[] ste = e.getStackTrace();
		for(StackTraceElement s : ste){
			System.out.println(s.getClassName() + ": " + s.getMethodName() + ": " + s.getLineNumber());
		}
		System.out.println();
		System.out.println("");
		System.out.println("////////////////////////////////////////////////////");			
		
		errorCounter++;
	}
	
	private void cleanUp(){
		String sql = "DELETE AdvertisingEnginePromotion WHERE PromotionFK = 207";
		jdbcTemplate.update(sql);
	}

}
