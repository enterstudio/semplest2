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
	
	private String baseUrl = "http://172.18.9.26:9898/semplest";	
	//private String baseUrl = "http://VMDEVJAVA1:9898/semplest";
	
	SemplestAdEngineServiceClient adEngine;
	GoogleAdwordsServiceImpl google;
	MsnCloudServiceImpl msn;	
	
	TestDataModel testData = new TestDataModel();
	
	enum TEST_METHOD {generic, scheduled};
	
	public static void main(String[] args){
		AdengineServiceTest test = new AdengineServiceTest();
		test.Test_Adengine_Client();
	}
	
	public int Test_Adengine_Client(){
		
		try{		
			if(!initializeTest()){
				System.out.println("Failed to initialize the test. Exit without doing tests.");
				return 1;
			}
			
			/* ********** Start to Test ********** */
			
			//Test without going through Scheduler
			
			AddPromotionToAdEngine(TEST_METHOD.generic);  //google, msn, manual verify onGoingBidding and Negative Keywords	
			//PausePromotion(TEST_METHOD.generic);  //google,msn
			//UpdateGeoTargeting(TEST_METHOD.generic);  //google,msn
			//UpdateBudget(TEST_METHOD.generic);  //google,msn
			//AddAds(TEST_METHOD.generic);  //google,msn
			//UpdateAds(TEST_METHOD.generic);  //google,msn
			//DeleteAds(TEST_METHOD.generic);  //google,msn
			AddKeywords(TEST_METHOD.generic);  //google,msn
			DeleteKeywords(TEST_METHOD.generic);  //google,msn
			
/*		
			RefreshSiteLinks();  //TODO					
						
			AddNegativeKeywords();  //TODO
			DeleteNegativeKeywords();  //TODO
			PauseProductGroups();  //TODO
			ExecuteBidProcess();  //TODO			
			
			UnpausePromotion();  //google,msn - n/a for test
			ChangePromotionStartDate();  //low priority
	*/		
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		finally{
			System.out.println("------------------------------------------------------------");
			System.out.println("End of the AdEngine Test. Test Data used for this test:");
			System.out.println(" - " + testData.toString());
			//cleanUp();
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
	
	private void AddPromotionToAdEngine(TEST_METHOD method) throws Exception{
		//AddPromotionToAdEngine
		System.out.println("------------------------------------------------------------");
		try{		
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleAddPromotionToAdEngine(" + testData.semplestCustomerId + ", " + testData.semplestCustomerId + ", " +  testData.semplestProductGroupId + ", " + testData.semplestPromotionId + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.scheduleAddPromotionToAdEngine(testData.semplestCustomerId, testData.semplestProductGroupId, testData.semplestPromotionId, testData.adEngineList);
				}
				else{
					System.out.println("AddPromotionToAdEngine(" + testData.semplestCustomerId + ", " +  testData.semplestProductGroupId + ", " + testData.semplestPromotionId + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.AddPromotionToAdEngine(testData.semplestCustomerId, testData.semplestProductGroupId, testData.semplestPromotionId, testData.adEngineList);
				}	
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			
			/* ********** Verification ********** */		
			String sql;
			int match = 0;
			String finaATitle = testData.promotionAds.get(1).adTitle;
			String findAKeyword = testData.keywords.get(1);
						
			//***check if we got all the things created successfully at google, and stored necessary information in the database	
			System.out.println("Verify IDs:");			
			
			sql = "SELECT aep.AdvertisingEngineCampaignPK FROM AdvertisingEnginePromotion aep WHERE PromotionFK = ?";
			testData.campaignId = jdbcTemplate.queryForLong(sql, testData.semplestPromotionId);
			
			sql = "SELECT aep.AdvertisingEngineAdGroupID FROM AdvertisingEnginePromotion aep WHERE PromotionFK = ?";
			testData.adGroupId = jdbcTemplate.queryForLong(sql, testData.semplestPromotionId);
			
			System.out.println(" -Account ID = " + testData.googleAccountId);
			System.out.println(" -Campaign ID = " + testData.campaignId);
			System.out.println(" -AdGroup ID = " + testData.adGroupId);
			
			if(testData.campaignId.equals(null) || testData.adGroupId.equals(null)){
				errorHandler(new Exception(vMsg + "The promotion is not created correctly. One or more IDs are missing in the database."));
				return;
			}
			System.out.println("*ID verification PASSED");							
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */
				
				System.out.println(">>> Verify result on Google >>>");
				
				//***check if we have all the ads are set up on google
				System.out.println("Verify ADs:");				
				AdGroupAd[] gads = google.getAdsByAdGroupId(testData.googleAccountId.toString(), new Long(testData.adGroupId).longValue());
				System.out.println("Ads that we put on google:");
				//verify content of the Ads
				match = 0;
				for(AdGroupAd ad : gads){
					TextAd ad2 = (TextAd)ad.getAd();
					System.out.println(" -" + ad2.getHeadline());
					if(ad2.getHeadline().equals(finaATitle))
						match++;
				}	
				if(match != 1){
					errorHandler(new Exception(vMsg + "Ads are not created correctly on google. " +
							"An Ad title '" + finaATitle + "' is not found."));
				}
				if(gads.length != testData.promotionAds.size()){
					//verify the num of Ads get added
					errorHandler(new Exception(vMsg + "The num of Ads in database and the num of Ads be created on google don't match. " +
							"Num of active Ads in database: " + testData.promotionAds.size() + ". Num of Ads added to google: " + gads.length));
				}
				
				//***check if we have all the keywords are set up on google
				System.out.println("Verify Keywords:");				
				String[] gkws = google.getAllAdGroupKeywords(testData.googleAccountId.toString(), new Long(testData.adGroupId), true);
				System.out.println("Keywords that we put on google:");
				//verify content of the Keywords
				match = 0;				
				for(String kw : gkws){
					System.out.println(" -" + kw);
					if(kw.equals(findAKeyword))
						match++;
				}				
				if(match != 1){
					errorHandler(new Exception(vMsg + "Keywords are not created correctly on google. " +
							"An Keyword '" + findAKeyword + "' is not found."));
				}
				if(gkws.length != testData.keywords.size()){
					//verify the num of Keywords get added
					errorHandler(new Exception(vMsg + "Not all Keywords in database are created on google. " +
							"Num of Keywords in database: " + testData.keywords.size() + ". Num of Ads added to google: " + gkws.length));
				}				
				
				//***check if we set negative keywords correctly on google					
				//TODO
				
				//***check if we set geoTarget correctly on google
				System.out.println("Verify Geo Targets:");	
				CampaignCriterion[] gCpnCrits = google.getAllCampaignCriterions(testData.googleAccountId.toString(), testData.campaignId);
				for(CampaignCriterion gcpncrit: gCpnCrits){
					if(gcpncrit.getCriterion() instanceof com.google.api.adwords.v201109.cm.Proximity){
						com.google.api.adwords.v201109.cm.Proximity proximity = (com.google.api.adwords.v201109.cm.Proximity)gcpncrit.getCriterion();
						
						com.google.api.adwords.v201109.cm.Address gAddress = proximity.getAddress();
						Integer gLatitude = proximity.getGeoPoint().getLatitudeInMicroDegrees();
						Integer gLongitude = proximity.getGeoPoint().getLongitudeInMicroDegrees();
						Double gRadius = proximity.getRadiusInUnits();
						
						//System.out.println(" -address = " + gAddress.toString());
						System.out.println(" -longtitude = " + gLongitude);	
						System.out.println(" -latitude = " + gLatitude);							
						System.out.println(" -radius = " + gRadius);	
						
						/*if(!gLongitude.equals(new Double(testData.longitude * 1000000).intValue())){
							errorHandler(new Exception(vMsg + "Longitude doesn't match. Value in database = " + testData.longitude + ". Value on google = " + gLongitude + "(in micro)."));
						}
						if(!gLatitude.equals(new Double(testData.latitude * 1000000).intValue())){
							errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.latitude + ". Value on google = " + gLatitude + "(in micro)."));
						}			*/			
						if(!gRadius.equals(testData.radius)){
							errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.radius + ". Value on google = " + gRadius + "."));
						}
					}
				}				
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */
				
				System.out.println(">>> Verify result on MSN >>>");
				
				//***check if we have all the ads are set up on msn
				System.out.println("Verify ADs:");
				
				com.microsoft.adcenter.v8.Ad[] mads = msn.getAdsByAdGroupId(testData.msnAccountId, testData.adGroupId);
				//verify content of the Ads
				System.out.println("Ads that we put on msn:");
				match = 0;
				for(com.microsoft.adcenter.v8.Ad ad : mads){
					com.microsoft.adcenter.v8.TextAd ad2 = (com.microsoft.adcenter.v8.TextAd)ad;
					System.out.println(" -" + ad2.getTitle());
					if(ad2.getTitle().equals(finaATitle))
						match++;
				}						
				if(match != 1){
					errorHandler(new Exception(vMsg + "Ads are not created correctly on MSN. " +
							"An Ad title '" + finaATitle + "' is not found."));
				}				
				if(mads.length != testData.promotionAds.size()){
					//verify the num of Ads get added
					errorHandler(new Exception(vMsg + "The num of Ads in database and the num of Ads be created on MSN don't match. " +
							"Num of active Ads in database: " + testData.promotionAds.size() + ". Num of Ads added to google: " + mads.length));
				}				
				
				//***check if we have all the keywords are set up on msn
				System.out.println("Verify Keywords:");
				
				com.microsoft.adcenter.v8.Keyword[] mkws = msn.getKeywordByAdGroupId(testData.msnAccountId, new Long(testData.adGroupId));
				System.out.println("Keywords that we put on MSN:");
				//verify content of the Keywords
				match = 0;
				for(com.microsoft.adcenter.v8.Keyword kw : mkws){
					System.out.println(" -" + kw);
					if(kw.equals(findAKeyword))
						match++;
				}		
				if(match != 1){
					errorHandler(new Exception(vMsg + "Keywords are not created correctly on MSN. " +
							"An Keyword '" + findAKeyword + "' is not found."));
				}
				if(mkws.length != testData.keywords.size()){
					//verify the num of Keywords get added
					errorHandler(new Exception(vMsg + "Not all Keywords in database are created on MSN. " +
							"Num of Keywords in database: " + testData.keywords.size() + ". Num of Ads added to MSN: " + mkws.length));
				}				
				
				//***check if we set negative keywords correctly on msn					
				//TODO
				
				//***check if we set geoTarget correctly on msn
				System.out.println("Verify Geo Targets:");	
				com.microsoft.adcenter.v8.Target mTarget = msn.getCampaignTargets(testData.msnAccountId, testData.msnCustomerId, testData.campaignId);
				
				com.microsoft.adcenter.v8.LocationTarget mLocation = mTarget.getLocation();
				Double mLatitude = mTarget.getLocation().getRadiusTarget().getBids()[0].getLatitudeDegrees();
				Double mLongitude = mTarget.getLocation().getRadiusTarget().getBids()[0].getLongitudeDegrees();
				int mRadius = mTarget.getLocation().getRadiusTarget().getBids()[0].getRadius();
				
				System.out.println(" -address = (street address), " + mLocation.getCityTarget().getBids()[0].getCity() + ", " + mLocation.getMetroAreaTarget().getBids()[0].getMetroArea() + ", " + mLocation.getStateTarget().getBids()[0].getState() + ", " + mLocation.getCountryTarget().getBids()[0].getCountryAndRegion());
				System.out.println(" -latitude = " + mLatitude);	
				System.out.println(" -longtitude = " + mLongitude);	
				System.out.println(" -radius = " + mRadius);	
				
				/*if(!mLongitude.equals(testData.longitude)){
					errorHandler(new Exception(vMsg + "Longitude doesn't match. Value in database = " + testData.longitude + ". Value on msn = " + mLongitude + "."));
				}
				if(!mLatitude.equals(testData.latitude)){
					errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.latitude + ". Value on msn = " + mLatitude + "."));
				}				*/
				if(mRadius != testData.radius.intValue()){
					errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.radius + ". Value on msn = " + mRadius + "(double to int)."));
				}				

			}				
			
			//***check if we schedule the OnGoingBidding correctly in the database
			System.out.println("Verify OnGoingBidding Schedule: (Manually)");				
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);			
		
	}
	
	private void PausePromotion(TEST_METHOD method) throws Exception{
		//PausePromotion
		System.out.println("------------------------------------------------------------");
		try{			
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleAddPromotionToAdEngine(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.scheduleAddPromotionToAdEngine(testData.semplestCustomerId, testData.semplestProductGroupId, testData.semplestPromotionId, testData.adEngineList);
				}
				else{
					System.out.println("PausePromotion(" + testData.semplestPromotionId + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.PausePromotion(testData.semplestPromotionId, testData.adEngineList);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}
			
			System.out.println("*DONE");			
			Thread.sleep(sleepTime);
			
			//Verification
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */			
				System.out.println(">>> Verify result on Google >>>");
				ArrayList<HashMap<String, String>> gcpn = google.getCampaignsByAccountId(testData.googleAccountId.toString(), false);
				for(HashMap<String, String> map : gcpn){
					if(map.get("Id").equals(testData.campaignId.toString())){
						String status = map.get("Status");
						System.out.println("Status of Campaign " + testData.campaignId + " is - " + status);
						if(!status.equals(CampaignStatus.PAUSED.getValue())){
							errorHandler(new Exception(vMsg + "Campaign is not paused."));
						}
					}
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */			
				System.out.println(">>> Verify result on MSN >>>");
				com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(testData.msnAccountId, testData.campaignId);
				System.out.println("Status of Campaign " + testData.campaignId + " is - " + mcpn.getStatus().getValue());
				if(!mcpn.getStatus().equals(com.microsoft.adcenter.v8.CampaignStatus.Paused)){
					errorHandler(new Exception(vMsg + "Campaign is not paused."));
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}

	private void UpdateGeoTargeting(TEST_METHOD method) throws Exception{
		//UpdateGeoTargeting
		System.out.println("------------------------------------------------------------");
		try{
			//Make changes to the geotarget in the database			
			String sql = "UPDATE GeoTargeting SET Address = ?, City = ?, StateCodeFK = ?, Zip = ?, Longitude = ?, Latitude = ?, ProximityRadius = ? WHERE PromotionFK = ?";
			jdbcTemplate.update(sql, new Object[]
					{testData.newAddress, testData.newCity, testData.newStateCode, testData.newZipCode, testData.newLongitude, testData.newLatitude , testData.newRadius, testData.semplestPromotionId});			
			
			//run the update method through adEngine	
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleUpdateGeoTargeting(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.scheduleUpdateGeoTargeting(testData.semplestCustomerId, testData.semplestPromotionId, testData.adEngineList);
				}
				else{
					System.out.println("UpdateGeoTargeting(" + testData.semplestPromotionId + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.UpdateGeoTargeting(testData.semplestPromotionId, testData.adEngineList);
				}			
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}
			
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			
			//Verification
			System.out.println("Verify result...");
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */		
				System.out.println(">>> Verify results on Google >>>");	
				CampaignCriterion[] gCpnCrits = google.getAllCampaignCriterions(testData.googleAccountId.toString(), testData.campaignId);
				for(CampaignCriterion gcpncrit: gCpnCrits){
					if(gcpncrit.getCriterion() instanceof com.google.api.adwords.v201109.cm.Proximity){
						com.google.api.adwords.v201109.cm.Proximity proximity = (com.google.api.adwords.v201109.cm.Proximity)gcpncrit.getCriterion();
						
						com.google.api.adwords.v201109.cm.Address gAddress = proximity.getAddress();
						Integer gLatitude = proximity.getGeoPoint().getLatitudeInMicroDegrees();
						Integer gLongitude = proximity.getGeoPoint().getLongitudeInMicroDegrees();
						Double gRadius = proximity.getRadiusInUnits();
						
						//System.out.println(" -address = " + gAddress.toString());
						System.out.println(" -longtitude = " + gLongitude);	
						System.out.println(" -latitude = " + gLatitude);							
						System.out.println(" -radius = " + gRadius);	
						
						/*if(!gLongitude.equals(testData.newLongitude * 1000000)){
							errorHandler(new Exception(vMsg + "Longitude doesn't match. Value in database = " + testData.newLongitude + ". Value on google = " + gLongitude + "(in micro)."));
						}
						if(!gLatitude.equals(testData.newLatitude * 1000000)){
							errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.newLatitude + ". Value on google = " + gLatitude + "(in micro)."));
						}	*/					
						if(!gRadius.equals(testData.newRadius)){
							errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.newRadius + ". Value on google = " + gRadius + "."));
						}
					}
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */		
				System.out.println(">>> Verify results on MSN >>>");	
				com.microsoft.adcenter.v8.Target mTarget = msn.getCampaignTargets(testData.msnAccountId, testData.msnCustomerId, testData.campaignId);
				
				com.microsoft.adcenter.v8.LocationTarget mLocation = mTarget.getLocation();
				Double mLatitude = mTarget.getLocation().getRadiusTarget().getBids()[0].getLatitudeDegrees();
				Double mLongitude = mTarget.getLocation().getRadiusTarget().getBids()[0].getLongitudeDegrees();
				int mRadius = mTarget.getLocation().getRadiusTarget().getBids()[0].getRadius();
				
				System.out.println(" -address = (street address), " + mLocation.getCityTarget().getBids()[0].getCity() + ", " + mLocation.getMetroAreaTarget().getBids()[0].getMetroArea() + ", " + mLocation.getStateTarget().getBids()[0].getState() + ", " + mLocation.getCountryTarget().getBids()[0].getCountryAndRegion());
				System.out.println(" -latitude = " + mLatitude);	
				System.out.println(" -longtitude = " + mLongitude);	
				System.out.println(" -radius = " + mRadius);	
				
				/*if(!mLongitude.equals(testData.newLongitude)){
					errorHandler(new Exception(vMsg + "Longitude doesn't match. Value in database = " + testData.newLongitude + ". Value on msn = " + mLongitude + "."));
				}
				if(!mLatitude.equals(testData.newLatitude)){
					errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.newLatitude + ". Value on msn = " + mLatitude + "."));
				}		*/		
				if(mRadius != testData.newRadius.intValue()){
					errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.newRadius + ". Value on msn = " + mRadius + "(double to int)."));
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void UpdateBudget(TEST_METHOD method) throws Exception{
		//UpdateBudget
		System.out.println("------------------------------------------------------------");
		try{
			Double changeInBudget = 77.55;
			boolean ret = false;
			try{			
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleUpdateBudget(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + changeInBudget + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.scheduleUpdateBudget(testData.semplestCustomerId, testData.semplestPromotionId, changeInBudget, testData.adEngineList);
				}
				else{
					System.out.println("UpdateBudget(" + testData.semplestPromotionId + ", " + changeInBudget + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.UpdateBudget(testData.semplestPromotionId, changeInBudget, testData.adEngineList);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}
			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			
			//get the BudgetToAddToNextCycle from database
			String sql = "SELECT P.BudgetToAddToNextCycle FROM Promotion P WHERE PromotionPK = ?";
			Double updatedBudget = jdbcTemplate.queryForObject(sql, new Object[]
					{testData.semplestPromotionId}, Double.class);
			
			updatedBudget = updatedBudget + changeInBudget;
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */			
				System.out.println(">>> Verify result on Google >>>");
				ArrayList<HashMap<String, String>> gcpn = google.getCampaignsByAccountId(testData.googleAccountId.toString(), false);
				for(HashMap<String, String> map : gcpn){
					if(map.get("Id").equals(testData.campaignId.toString())){
						String amount = map.get("Amount");
						System.out.println("Budget Amount of the Campaign " + testData.campaignId + " is - " + amount + " (in micro).");
						if(!amount.equals(new Double(updatedBudget * 1000000).intValue())){
							errorHandler(new Exception(vMsg + "Budget Amount is not updated correctly. Update budget amount = " + updatedBudget + ". The value on google = " + amount + " (in micro)."));
						}
					}
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */			
				System.out.println(">>> Verify result on MSN >>>");
				com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(testData.msnAccountId, testData.campaignId);
				System.out.println("Budget Amount of the Campaign " + testData.campaignId + " is - " + mcpn.getDailyBudget() + " (Daily Budget)");
				if(!mcpn.getDailyBudget().equals(changeInBudget)){
					errorHandler(new Exception(vMsg + "Budget Amount is not updated correctly. Update budget amount = " + changeInBudget + ". The value on msn = " + mcpn.getDailyBudget() + "."));
				}
			}
			
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
			System.out.println("RefreshSiteLinks(" + testData.semplestPromotionId + ", " + AdEngine.Google.name() + ")");
			adEngine.RefreshSiteLinks(testData.semplestPromotionId, testData.adEngineList);
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
	
	private void AddAds(TEST_METHOD method) throws Exception{
		//AddAds
		System.out.println("------------------------------------------------------------");
		try{				
			//insert new ADs to the database, and get Ad Ids
			for(TestDataModel.AD ad : testData.newAds){
				String sql = "INSERT INTO PromotionAds(PromotionFK,AdTitle,AdTextLine1,AdTextLine2,IsDeleted,CreatedDate) " +
						"VALUES(?, ?, ?, ?, 0 , CURRENT_TIMESTAMP)";
				jdbcTemplate.update(sql, new Object[]
						{testData.semplestPromotionId, ad.adTitle, ad.adTextLine1, ad.adTextLine2});
				
				sql = "SELECT pa.PromotionAdsPK FROM PromotionAds pa WHERE pa.PromotionFK = ? and pa.AdTitle = ?";
				Integer id = jdbcTemplate.queryForInt(sql, new Object[]
						{testData.semplestPromotionId, ad.adTitle});
				testData.newAdIds.add(id);
			}
			
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleAddAds(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.newAdIds.toString() + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.scheduleAddAds(testData.semplestCustomerId, testData.semplestPromotionId, testData.newAdIds, testData.adEngineList);
				}
				else{
					System.out.println("AddAds(" + testData.semplestPromotionId + ", " + testData.newAdIds.toString() + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.AddAds(testData.semplestPromotionId, testData.newAdIds, testData.adEngineList);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			
			//Verification
			System.out.println("Verify result...");
			int match = 0;
			String finaATitle = testData.newAds.get(1).adTitle;
			int numAllAds = testData.promotionAds.size() + testData.newAds.size();
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */				
				System.out.println(">>> Verify result on Google >>>");
				
				//***check if we have all the ads are set up on google
				AdGroupAd[] gads = google.getAdsByAdGroupId(testData.googleAccountId.toString(), new Long(testData.adGroupId).longValue());
				System.out.println("Ads that we have on google:");
				//verify content of the Ads
				match = 0;
				for(AdGroupAd ad : gads){
					TextAd ad2 = (TextAd)ad.getAd();
					System.out.println(" -" + ad2.getHeadline());
					if(ad2.getHeadline().equals(finaATitle))
						match++;
				}	
				if(match != 1){
					errorHandler(new Exception(vMsg + "Ads are not created correctly on google. " +
							"An Ad title '" + finaATitle + "' is not found."));
				}				
				if(gads.length != numAllAds){
					//verify the num of Ads get added
					errorHandler(new Exception(vMsg + "The num of Ads in database and the num of Ads be created on google don't match. " +
							"Num of active Ads in database: " + numAllAds + ". Num of Ads added to google: " + gads.length));
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */				
				System.out.println(">>> Verify result on MSN >>>");
				
				//***check if we have all the ads are set up on msn			
				com.microsoft.adcenter.v8.Ad[] mads = msn.getAdsByAdGroupId(testData.msnAccountId, testData.adGroupId);
				//verify content of the Ads
				System.out.println("Ads that we put on msn:");
				match = 0;
				for(com.microsoft.adcenter.v8.Ad ad : mads){
					com.microsoft.adcenter.v8.TextAd ad2 = (com.microsoft.adcenter.v8.TextAd)ad;
					System.out.println(" -" + ad2.getTitle());
					if(ad2.getTitle().equals(finaATitle))
						match++;
				}						
				if(match != 1){
					errorHandler(new Exception(vMsg + "Ads are not created correctly on MSN. " +
							"An Ad title '" + finaATitle + "' is not found."));
				}				
				if(mads.length != numAllAds){
					//verify the num of Ads get added
					errorHandler(new Exception(vMsg + "The num of Ads in database and the num of Ads be created on MSN don't match. " +
							"Num of active Ads in database: " + numAllAds + ". Num of Ads added to google: " + mads.length));
				}				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void UpdateAds(TEST_METHOD method) throws Exception{
		//UpdateAds
		System.out.println("------------------------------------------------------------");
		try{
			//update an AD in the database
			TestDataModel.AD updateAd = testData.new AD(777);
			String sql = "UPDATE PromotionAds SET AdTitle = ?, AdTextLine1 = ?, AdTextLine2 = ? WHERE PromotionAdsPK = ?";
			jdbcTemplate.update(sql, new Object[]
					{updateAd.adTitle, updateAd.adTextLine1, updateAd.adTextLine2, testData.newAdIds.get(0)});
			
			//run the AdEngine method
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleUpdateAds(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.newAdIds.toString() + ", " + testData.adEngineList.toString() + ")");
					ret  = adEngine.scheduleUpdateAds(testData.semplestCustomerId, testData.semplestPromotionId, testData.newAdIds, testData.adEngineList);
				}
				else{
					System.out.println("UpdateAds(" + testData.semplestPromotionId + ", " + testData.newAdIds.toString() + ", " + testData.adEngineList.toString() + ")");
					ret  = adEngine.UpdateAds(testData.semplestPromotionId, testData.newAdIds, testData.adEngineList);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}			
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			
			//Verification
			System.out.println("Verify result...");
			int match = 0;
			String finaATitle = updateAd.adTitle;
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */				
				System.out.println(">>> Verify result on Google >>>");
				
				//***check if we have all the ads are set up on google
				AdGroupAd[] gads = google.getAdsByAdGroupId(testData.googleAccountId.toString(), new Long(testData.adGroupId).longValue());
				System.out.println("Ads that we have on google:");
				//verify content of the Ads
				match = 0;
				for(AdGroupAd ad : gads){
					TextAd ad2 = (TextAd)ad.getAd();
					System.out.println(" -" + ad2.getHeadline());
					if(ad2.getHeadline().equals(finaATitle)){
						match++;
						//verify details
						System.out.println("  Content of the updated AD - [" + ad2.getHeadline() + ", " + ad2.getDescription1() + ", " + ad2.getDescription2() + "]");						
						if((!ad2.getDescription1().equals(updateAd.adTextLine1)) || (!ad2.getDescription2().equals(updateAd.adTextLine2))){
							errorHandler(new Exception(vMsg + "Ads are not updated correctly on google. Ad content doesn't match."));
						}
					}						
				}	
				if(match != 1){
					errorHandler(new Exception(vMsg + "Ads are not updated correctly on google. " +
							"An Ad title '" + finaATitle + "' is not found."));
				}							
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */				
				System.out.println(">>> Verify result on MSN >>>");
				
				//***check if we have all the ads are set up on msn			
				com.microsoft.adcenter.v8.Ad[] mads = msn.getAdsByAdGroupId(testData.msnAccountId, testData.adGroupId);
				//verify content of the Ads
				System.out.println("Ads that we put on msn:");
				match = 0;
				for(com.microsoft.adcenter.v8.Ad ad : mads){
					com.microsoft.adcenter.v8.TextAd ad2 = (com.microsoft.adcenter.v8.TextAd)ad;
					System.out.println(" -" + ad2.getTitle());
					if(ad2.getTitle().equals(finaATitle))
						match++;
				}						
				if(match != 1){
					errorHandler(new Exception(vMsg + "Ads are not updated correctly on MSN. " +
							"An Ad title '" + finaATitle + "' is not found."));
				}			
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void DeleteAds(TEST_METHOD method) throws Exception{
		//DeleteAds
		System.out.println("------------------------------------------------------------");
		try{
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleDeleteAds(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.promotionAdIds.toString() + ", " + AdEngine.Google.name() + ")");
					ret = adEngine.scheduleDeleteAds(testData.semplestCustomerId, testData.semplestPromotionId, testData.promotionAdIds, testData.adEngineList);
				}
				else{
					System.out.println("DeleteAds(" + testData.semplestPromotionId + ", " + testData.promotionAdIds.toString() + ", " + AdEngine.Google.name() + ")");
					ret = adEngine.DeleteAds(testData.semplestPromotionId, testData.promotionAdIds, testData.adEngineList);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}	
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			int match = 0;
			String finaATitle = testData.promotionAds.get(1).adTitle;
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */				
				System.out.println(">>> Verify result on Google >>>");
				
				//***check if we have all the ads are set up on google
				AdGroupAd[] gads = google.getAdsByAdGroupId(testData.googleAccountId.toString(), new Long(testData.adGroupId).longValue());
				System.out.println("Ads that we have on google:");
				//verify content of the Ads
				match = 0;
				for(AdGroupAd ad : gads){
					TextAd ad2 = (TextAd)ad.getAd();
					System.out.println(" -" + ad2.getHeadline());
					if(ad2.getHeadline().equals(finaATitle)){
						match++;
					}						
				}	
				if(match > 0){
					errorHandler(new Exception(vMsg + "Ads are not completely deleted on google. " +
							"An Ad title '" + finaATitle + "' is found, while it should have been deleted."));
				}							
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */				
				System.out.println(">>> Verify result on MSN >>>");
				
				//***check if we have all the ads are set up on msn			
				com.microsoft.adcenter.v8.Ad[] mads = msn.getAdsByAdGroupId(testData.msnAccountId, testData.adGroupId);
				//verify content of the Ads
				System.out.println("Ads that we put on msn:");
				match = 0;
				for(com.microsoft.adcenter.v8.Ad ad : mads){
					com.microsoft.adcenter.v8.TextAd ad2 = (com.microsoft.adcenter.v8.TextAd)ad;
					System.out.println(" -" + ad2.getTitle());
					if(ad2.getTitle().equals(finaATitle))
						match++;
				}						
				if(match > 0){
					errorHandler(new Exception(vMsg + "Ads are not completely deleted on MSN. " +
							"An Ad title '" + finaATitle + "' is found, while it should have been deleted."));
				}			
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void AddKeywords(TEST_METHOD method) throws Exception{
		//AddKeywords
		System.out.println("------------------------------------------------------------");
		try{
			//insert new keywords to the database
			for(Integer kwId : testData.newKeywordIds){
				String sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
						"VALUES(?,?,CURRENT_TIMESTAMP,1,0,0,1,1,1)";
				
				jdbcTemplate.update(sql, new Object[]
						{kwId, testData.semplestPromotionId});
			}
			
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleAddKeywords(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.newKeywordIds + ", " + testData.adEngineList + ")");
					ret = adEngine.scheduleAddKeywords(testData.semplestCustomerId, testData.semplestPromotionId, testData.newKeywordIds, testData.adEngineList);
				}
				else{
					System.out.println("AddKeywords(" + testData.semplestPromotionId + ", " + testData.newKeywordIds + ", " + testData.adEngineList + ")");
					ret = adEngine.AddKeywords(testData.semplestPromotionId, testData.newKeywordIds, testData.adEngineList);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			System.out.println("Verify result...");
			int match = 0;
			String findAKeyword = testData.newKeywords.get(1);
			Integer numAllKeywords = testData.keywordIds.size() + testData.newKeywordIds.size();
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */
				
				System.out.println(">>> Verify result on Google >>>");
				
				String[] gkws = google.getAllAdGroupKeywords(testData.googleAccountId.toString(), new Long(testData.adGroupId), true);
				System.out.println("Keywords that we have on google:");
				//verify content of the Keywords
				match = 0;				
				for(String kw : gkws){
					System.out.println(" -" + kw);
					if(kw.equals(findAKeyword))
						match++;
				}				
				if(match != 1){
					errorHandler(new Exception(vMsg + "Keywords are not added correctly on google. " +
							"An Keyword '" + findAKeyword + "' is not found."));
				}
				if(gkws.length != numAllKeywords){
					//verify the num of Keywords get added
					errorHandler(new Exception(vMsg + "Not all Keywords in database are added to google. " +
							"Num of Keywords in database: " + numAllKeywords + ". Num of Ads added to google: " + gkws.length));
				}				
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */
				
				System.out.println(">>> Verify result on MSN >>>");
				
				com.microsoft.adcenter.v8.Keyword[] mkws = msn.getKeywordByAdGroupId(testData.msnAccountId, new Long(testData.adGroupId));
				System.out.println("Keywords that we put on MSN:");
				//verify content of the Keywords
				match = 0;
				for(com.microsoft.adcenter.v8.Keyword kw : mkws){
					System.out.println(" -" + kw);
					if(kw.equals(findAKeyword))
						match++;
				}		
				if(match != 1){
					errorHandler(new Exception(vMsg + "Keywords are not added correctly on MSN. " +
							"An Keyword '" + findAKeyword + "' is not found."));
				}
				if(mkws.length != numAllKeywords){
					//verify the num of Keywords get added
					errorHandler(new Exception(vMsg + "Not all Keywords in database are added to MSN. " +
							"Num of Keywords in database: " + numAllKeywords + ". Num of Ads added to MSN: " + mkws.length));
				}				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void DeleteKeywords(TEST_METHOD method) throws Exception{
		//DeleteKeywords
		System.out.println("------------------------------------------------------------");
		try{			
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleDeleteKeywords(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.keywordIds + ", " + testData.adEngineList + ")");
					ret = adEngine.scheduleDeleteKeywords(testData.semplestCustomerId, testData.semplestPromotionId, testData.keywordIds, testData.adEngineList);
				}
				else{
					System.out.println("DeleteKeywords(" + testData.semplestPromotionId + ", " + testData.keywordIds + ", " + testData.adEngineList + ")");
					ret = adEngine.DeleteKeywords(testData.semplestPromotionId, testData.keywordIds, testData.adEngineList);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				errorHandler(e);
			}			
			if(!ret){
				errorHandler(new Exception("Failed running method."));
				return;
			}
			System.out.println("*DONE");
			
			Thread.sleep(sleepTime);
			
			//Verification
			System.out.println("Verify result...");
			int match = 0;
			String findAKeyword = testData.keywords.get(1);
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */				
				System.out.println(">>> Verify result on Google >>>");
				
				String[] gkws = google.getAllAdGroupKeywords(testData.googleAccountId.toString(), new Long(testData.adGroupId), true);
				System.out.println("Keywords that we have on google:");
				//verify content of the Keywords
				match = 0;				
				for(String kw : gkws){
					System.out.println(" -" + kw);
					if(kw.equals(findAKeyword))
						match++;
				}				
				if(match > 0){
					errorHandler(new Exception(vMsg + "Keywords are not completely deleted on google. " +
							"A Keyword '" + findAKeyword + "' is found, while it should have been deleted."));
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */				
				System.out.println(">>> Verify result on MSN >>>");
				
				com.microsoft.adcenter.v8.Keyword[] mkws = msn.getKeywordByAdGroupId(testData.msnAccountId, new Long(testData.adGroupId));
				System.out.println("Keywords that we put on MSN:");
				//verify content of the Keywords
				match = 0;
				for(com.microsoft.adcenter.v8.Keyword kw : mkws){
					System.out.println(" -" + kw);
					if(kw.equals(findAKeyword))
						match++;
				}		
				if(match > 0){
					errorHandler(new Exception(vMsg + "Keywords are not completely deleted on MSN. " +
							"A Keyword '" + findAKeyword + "' is found, while it should have been deleted."));
				}			
			}
			
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
			KeywordIdRemoveOppositePair nk1 = new KeywordIdRemoveOppositePair(testData.keywordIds.get(0),true);
			testData.keywordIdRemoveOppositePairs.add(nk1);
			System.out.println("AddNegativeKeywords(" + testData.semplestPromotionId + ", " + "keywordIdRemoveOppositePairs[622665,true]" + ", " + AdEngine.Google.name() + ")");
			adEngine.AddNegativeKeywords(testData.semplestPromotionId, testData.keywordIdRemoveOppositePairs, testData.adEngineList);
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
			System.out.println("DeleteNegativeKeywords(" + testData.semplestPromotionId + ", " + "keywordIds[622665]" + ", " + AdEngine.Google.name() + ")");
			adEngine.DeleteNegativeKeywords(testData.semplestPromotionId, testData.keywordIds.subList(0, 1), testData.adEngineList);
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
			System.out.println("PauseProductGroups(" + testData.semplestPromotionId + ", " + "productGroupIds[196,197]" + ", " + AdEngine.Google.name() + ")");
			adEngine.PauseProductGroups(testData.productGroupIds, testData.adEngineList);
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
			System.out.println("ExecuteBidProcess(" + testData.semplestPromotionId + ", " + AdEngine.Google.name() + ")");
			adEngine.ExecuteBidProcess(testData.semplestPromotionId, testData.adEngineList);
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
	
	//Lower priority or not implemented yet on the service
	
	private void UnpausePromotion(TEST_METHOD method) throws Exception{
		//UnpausePromotion
		System.out.println("------------------------------------------------------------");
		try{
			System.out.println("UnpausePromotion(" + testData.semplestPromotionId + ", " + AdEngine.Google.name() + ")");			
			if(method.equals(TEST_METHOD.scheduled)){
				adEngine.scheduleUnpausePromotion(testData.semplestCustomerId, testData.semplestPromotionId, testData.adEngineList);
			}
			else{
				adEngine.UnpausePromotion(testData.semplestPromotionId, testData.adEngineList);
			}
			System.out.println("DONE");			
			Thread.sleep(sleepTime);
			
			//Verification
			
			/* ***** For Google ***** */			
			System.out.println(">>> Verify result on Google >>>");
			ArrayList<HashMap<String, String>> ret = google.getCampaignsByAccountId(testData.googleAccountId.toString(), false);
			for(HashMap<String, String> map : ret){
				if(map.get("Id").equals(testData.campaignId.toString())){
					String status = map.get("Status");
					System.out.println("Status of Campaign " + testData.campaignId + " is - " + status);
					if(!status.equals(CampaignStatus.ACTIVE.getValue())){
						errorHandler(new Exception(vMsg + "Campaign is not unpaused."));
					}
				}
			}
			
			/* ***** For MSN ***** */			
			System.out.println(">>> Verify result on MSN >>>");
			com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(testData.msnAccountId, testData.campaignId);
			if(!mcpn.getStatus().equals(com.microsoft.adcenter.v8.CampaignStatus.Active)){
				errorHandler(new Exception(vMsg + "Campaign is not unpaused."));
			}
			
			//Pause the promotion again (and double check the PausePromotion)
			System.out.println("Pause the promotion again (and double check the PausePromotion function)");
			adEngine.PausePromotion(testData.semplestPromotionId, testData.adEngineList);
			//google
			ArrayList<HashMap<String, String>> ret2 = google.getCampaignsByAccountId(testData.googleAccountId.toString(), false);
			for(HashMap<String, String> map : ret2){
				if(map.get("Id").equals(testData.campaignId.toString())){
					String status = map.get("Status");
					System.out.println("Status of Campaign " + testData.campaignId + " is - " + status);
					if(!status.equals(CampaignStatus.PAUSED.getValue())){
						errorHandler(new Exception(vMsg + "Campaign is not paused on Google."));
					}
				}
			}
			//msn
			com.microsoft.adcenter.v8.Campaign mcpn2 = msn.getCampaignById(testData.msnAccountId, testData.campaignId);
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
			System.out.println("ChangePromotionStartDate(" + testData.semplestPromotionId + ", " + startDate.toString() + ", " + AdEngine.Google.name() + ")");
			adEngine.ChangePromotionStartDate(testData.semplestPromotionId, startDate, testData.adEngineList);
			System.out.println("DONE");
			
			Thread.sleep(sleepTime);
			//Verification
			/* ***** For Google ***** */			
			System.out.println(">>> Verify result on Google >>>");
			DateFormat df = new SimpleDateFormat("YYYYMMDD");
			ArrayList<HashMap<String, String>> ret2 = google.getCampaignsByAccountId(testData.googleAccountId.toString(), false);
			for(HashMap<String, String> map : ret2){
				if(map.get("Id").equals(testData.campaignId.toString())){
					String ret = map.get("StartDate");
					System.out.println("StartDate of Campaign " + testData.campaignId + " is - " + ret);
					if(!ret.equals(df.format(startDate))){
						errorHandler(new Exception(vMsg + "Campaign is not updated to Date " + df.format(startDate)));
					}
				}
			}
			
			/* ***** For MSN ***** */			
			System.out.println(">>> Verify result on MSN >>>");
			com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(testData.msnAccountId, testData.campaignId);
			//TODO: figure out where can I get the StartDate from msn (not on the website interface?)
			
			
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
		System.out.println("Details:");
		StackTraceElement[] ste = e.getStackTrace();
		for(StackTraceElement s : ste){
			System.out.println(s.getClassName() + ": " + s.getMethodName() + ": " + s.getLineNumber());
		}
		System.out.println("////////////////////////////////////////////////////");		
		System.out.println("");
		
		errorCounter++;
	}
	
	private boolean initializeTest(){
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
						
			System.out.println("Initializing the test...");
			
			//create a new promotion for the test
			String sql;
			
			testData.semplestPromotionName = "AdEng_" + System.currentTimeMillis();
			sql = "INSERT INTO Promotion (ProductGroupFK,PromotionName,PromotionDescription,PromotionStartDate,PromotionEndDate," +
					"LandingPageURL,DisplayURL,PromotionBudgetAmount,BudgetCycleFK,CycleStartDate,CycleEndDate,StartBudgetInCycle,RemainingBudgetInCycle,BudgetToAddToNextCycle," +
					"IsPaused,IsCompleted,IsLaunched,CreatedDate,IsDeleted)" +
					"VALUES (?, ?, 'wedding dresses, gowns, brides, flowers, cakes, hair, booze, food', CURRENT_TIMESTAMP, '2013-01-01', " +
					"'http://www.weddingchannel.com', 'http://www.weddingchannel.com',300.00, 3, CURRENT_TIMESTAMP, '2013-01-01', 500.00, 500.00, 300.00, " +
					"0, 0, 1, CURRENT_TIMESTAMP, 0)";
			jdbcTemplate.update(sql, new Object[]
					{testData.semplestProductGroupId, testData.semplestPromotionName});
			
			sql = "SELECT p.PromotionPK FROM Promotion p WHERE PromotionName = ?";
			testData.semplestPromotionId = jdbcTemplate.queryForInt(sql, new Object[]
					{testData.semplestPromotionName});			
			
			//Create promotion data on the related tables
			//ADs			
			for(TestDataModel.AD ad : testData.promotionAds){
				sql = "INSERT INTO PromotionAds(PromotionFK,AdTitle,AdTextLine1,AdTextLine2,IsDeleted,CreatedDate) " +
						"VALUES(?, ?, ?, ?, 0 , CURRENT_TIMESTAMP)";
				jdbcTemplate.update(sql, new Object[]
						{testData.semplestPromotionId, ad.adTitle, ad.adTextLine1, ad.adTextLine2});	
			}			
			sql = "SELECT pa.PromotionAdsPK FROM PromotionAds pa WHERE pa.PromotionFK = ?";
			testData.promotionAdIds = jdbcTemplate.queryForList(sql, new Object[]
					{testData.semplestPromotionId}, Integer.class);
			
			//Keywords
			for(Integer kwId : testData.keywordIds){
				sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
						"VALUES(?,?,CURRENT_TIMESTAMP,1,0,0,1,1,1)";
				
				jdbcTemplate.update(sql, new Object[]
						{kwId, testData.semplestPromotionId});
			}
			
			//GeoTargeting			
			sql = "INSERT INTO GeoTargeting (PromotionFK, Address,City,StateCodeFK,Zip,Longitude,Latitude,ProximityRadius) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, new Object[]
					{testData.semplestPromotionId, testData.address, testData.city, testData.stateCode, testData.zipCode, testData.longitude, testData.latitude, testData.radius});
		
			
			System.out.println(" - Created Promotion " + testData.semplestPromotionId + " for the test.");
			System.out.println(" - Data created for the promotion:");
			System.out.println("   " + testData.toString());
			
			System.out.println("End of initialization.");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);	
			//cleanUp();
			return false;
		}
	}
	
	private void cleanUp(){
		try{
			//clean up the promotion
			String sql;
			
			System.out.println("------------------------------------------------------------");
			System.out.println("Cleaning up the test...");
			
			for(Integer ad : testData.promotionAdIds){
				sql = "DELETE FROM AdvertisingEngineAds WHERE PromotionAdsFK = ?";
				jdbcTemplate.update(sql, new Object[]
						{ad});
			}
			
			sql = "DELETE PromotionAds WHERE PromotionFK = ?";
			jdbcTemplate.update(sql, new Object[]
					{testData.semplestPromotionId});
			
			System.out.println(" - ADs cleaned up.");
			
			sql = "DELETE PromotionKeywordAssociation WHERE PromotionFK = ?";
			jdbcTemplate.update(sql, new Object[]
					{testData.semplestPromotionId});		
			
			System.out.println(" - Keywords cleaned up.");
			
			sql = "DELETE GeoTargeting WHERE PromotionFK = ?";
			jdbcTemplate.update(sql, new Object[]
					{testData.semplestPromotionId});
			
			System.out.println(" - GeoTargets cleaned up.");
			
			sql = "DELETE AdvertisingEnginePromotion WHERE PromotionFK = ?";
			jdbcTemplate.update(sql, new Object[]
					{testData.semplestPromotionId});
			
			sql = "DELETE Promotion WHERE PromotionPK = ?";
			jdbcTemplate.update(sql, new Object[]
					{testData.semplestPromotionId});
			
			System.out.println(" - Promotion cleaned up.");
			System.out.println("End of clean up.");
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}
	}
	
	private class TestDataModel{	
		
		//Semplest Variables
		public Integer semplestCustomerId = 1388; //semplest_testing (set up manually in database)
		public Integer semplestProductGroupId = 196; //semplest_testing (set up manually in database)
		public Integer semplestPromotionId;  // = 207;
		public String semplestPromotionName;
		public ArrayList<String> adEngineList = new ArrayList<String>(Arrays.asList(AdEngine.Google.name()));
		//public ArrayList<String> adEngineList = new ArrayList<String>(Arrays.asList(AdEngine.Google.name(),AdEngine.MSN.name()));				
		
		//Ad Engine Variables
		public Integer googleAccountId = 54103;
		public Long msnAccountId = 1629687L;
		public Long msnCustomerId = 13068662L;
		public Long campaignId;
		public Long adGroupId;
		
		//ADs
		private AD ad1 = new AD(1);
		private AD ad2 = new AD(2);
		private AD ad3 = new AD(3);
		public List<AD> promotionAds = Arrays.asList(ad1, ad2, ad3);
		public List<Integer> promotionAdIds;
		
		private AD ad4 = new AD(4);
		private AD ad5 = new AD(5);
		public List<AD> newAds = Arrays.asList(ad4, ad5);
		public List<Integer> newAdIds = new ArrayList<Integer>();
		
		public List<Integer> productGroupIds = Arrays.asList(196,197);
		
		//Keywords (set up manually in database)
		public List<String> keywords = Arrays.asList("nan adengine test","nan adengine test one","nan adengine test two");
		public List<Integer> keywordIds = Arrays.asList(622665, 622666, 622667);
		public List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs;		
		
		public List<String> newKeywords = Arrays.asList("nan adengine test three","nan adengine test four");
		public List<Integer> newKeywordIds = Arrays.asList(781025, 781026);
		
		//GeoTargeting
		public String address = "195 Broadway";
		public String city = "New York";
		public Integer stateCode = 32;
		public String zipCode = "10007";
		public Double longitude = -74.009526;
		public Double latitude = 40.710798;
		public Double radius = 10.00;		
		
		public String newAddress = "2420 Poplar St";
		public String newCity = "Union";
		public Integer newStateCode = 30;
		public String newZipCode = "07083";
		public Double newLongitude = -74.29096;
		public Double newLatitude = 40.69801;
		public Double newRadius = 20.00;				
		
		//helper classes
		public class AD{
			public String adTitle = "AdEngine Test ";
			public String adTextLine1 = "test of adEngine index ";
			public String adTextLine2 = "test ";
			
			public AD(Integer index){
				this.adTitle = this.adTitle + index.toString();
				this.adTextLine1 = this.adTextLine1 + index.toString();
				this.adTextLine2 = this.adTextLine2 + index.toString();
			}
		}


		@Override
		public String toString() {
			return "TestDataModel [semplestCustomerId=" + semplestCustomerId
					+ ", semplestProductGroupId=" + semplestProductGroupId
					+ ", semplestPromotionId=" + semplestPromotionId
					+ ", semplestPromotionName=" + semplestPromotionName
					+ ", adEngineList=" + adEngineList + ", googleAccountId="
					+ googleAccountId + ", msnAccountId=" + msnAccountId
					+ ", msnCustomerId=" + msnCustomerId + ", campaignId="
					+ campaignId + ", adGroupId=" + adGroupId
					+ ", promotionAdIds=" + promotionAdIds
					+ ", productGroupIds=" + productGroupIds + ", keywordIds="
					+ keywordIds + ", address=" + address + ", city=" + city
					+ ", longitude=" + longitude + ", latitude=" + latitude
					+ ", radius=" + radius + "]";
		}
		
	}

}
