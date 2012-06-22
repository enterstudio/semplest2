package semplest.test.unittest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.AdGroupCriterion;
import com.google.api.adwords.v201109.cm.BudgetBudgetPeriod;
import com.google.api.adwords.v201109.cm.Campaign;
import com.google.api.adwords.v201109.cm.CampaignCriterion;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.TextAd;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionStatus;
import com.google.api.adwords.v201109_1.cm.SitelinksExtension;

import semplest.server.protocol.KeywordIdRemoveOppositePair;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.ReportObject;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.adengine.SemplestAdengineServiceImpl;
import semplest.server.service.springjdbc.BaseDB;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.services.client.api.SemplestAdEngineServiceClient;

public class AdengineServiceTest extends BaseDB{	
	
	private int errorCounter = 0;
	private int sleepTime = 1000;  //1s

	boolean isDeleteHistoryTestData = false;
	
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
			System.out.println();
			System.out.println("***** Start the Test *****");			
			
			//set if to run through scheduler or not
			TEST_METHOD method;			
			
			method = TEST_METHOD.generic;  //Test without going through Scheduler
			//method = TEST_METHOD.scheduled;  //Test that goes through Scheduler
			
			sleepTime = (method == TEST_METHOD.scheduled)? 10000 : sleepTime;
			
/* 
 * Finished Implementation
 */			
			AddPromotionToAdEngine(method);  //google, msn, manual verify onGoingBidding
			PausePromotion(method);  //google,msn
			UpdateGeoTargeting(method);  //google,msn
			UpdateBudget(method);  //google,msn
			AddAds(method);  //google,msn
			UpdateAds(method);  //google,msn
			DeleteAds(method);  //google,msn
			AddKeywords(method);  //google,msn 
			DeleteKeywords(method);  //google,msn
			PauseProductGroups(method);  //google,msn
			//RefreshSiteLinks(method);  //google
			AddNegativeKeywords(method);  //google 
			DeleteNegativeKeywords(method);  //google
			ExecuteBidProcess(method);  //can't verify result without real report data
			
/*		
 * In progress:
 * 			
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
			String findANegKeyword = testData.negKeywords.get(1);
						
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
							"Num of Keywords in database: " + testData.keywords.size() + ". Num of Keywords added to google: " + gkws.length));
				}				
				
				//***check if we set negative keywords correctly on google	
				System.out.println("Verify Negative Keywords:");	
				Map<String, Long> negKeywords = google.getAllNegativeKeywordsToCriterionIdMap(testData.googleAccountId.toString(), testData.campaignId, com.google.api.adwords.v201109.cm.KeywordMatchType.EXACT);
				System.out.println("Negative keywords that we put on google:");
				match = 0;
				for(String negkw : negKeywords.keySet()){
					System.out.println(" -" + negkw);
					if(negkw.equals(findANegKeyword))
						match++;
				}
				if(match != 1){
					errorHandler(new Exception(vMsg + "Negative Keywords are not created correctly on google. " +
							"A Negative Keyword '" + findANegKeyword + "' is not found."));
				}				
				
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
						
						if(!gLongitude.equals(new Double(testData.longitude * 1000000).intValue())){
							errorHandler(new Exception(vMsg + "Longitude doesn't match. Value in database = " + testData.longitude + ". Value on google = " + gLongitude + "(in micro)."));
						}
						if(!gLatitude.equals(new Double(testData.latitude * 1000000).intValue())){
							errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.latitude + ". Value on google = " + gLatitude + "(in micro)."));
						}						
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
					System.out.println(" -" + kw.getText());
					if(kw.getText().equals(findAKeyword))
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
				System.out.println("Verify Negative Keywords: (manually)");					
				
				//***check if we set geoTarget correctly on msn
				System.out.println("Verify Geo Targets:");	
				com.microsoft.adcenter.v8.Target mTarget = msn.getCampaignTargets(testData.msnAccountId, testData.msnCustomerId, testData.campaignId);
				
				com.microsoft.adcenter.v8.LocationTarget mLocation = mTarget.getLocation();
				/*Double mLatitude = mLocation.getRadiusTarget().getBids()[0].getLatitudeDegrees();
				Double mLongitude = mLocation.getRadiusTarget().getBids()[0].getLongitudeDegrees();
				int mRadius = mLocation.getRadiusTarget().getBids()[0].getRadius();
				
				System.out.println(" -address = (street address), " + mLocation.getCityTarget().getBids()[0].getCity() + ", " + mLocation.getMetroAreaTarget().getBids()[0].getMetroArea() + ", " + mLocation.getStateTarget().getBids()[0].getState() + ", " + mLocation.getCountryTarget().getBids()[0].getCountryAndRegion());
				System.out.println(" -latitude = " + mLatitude);	
				System.out.println(" -longtitude = " + mLongitude);	
				System.out.println(" -radius = " + mRadius);	
				
				if(!mLongitude.equals(testData.longitude)){
					errorHandler(new Exception(vMsg + "Longitude doesn't match. Value in database = " + testData.longitude + ". Value on msn = " + mLongitude + "."));
				}
				if(!mLatitude.equals(testData.latitude)){
					errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.latitude + ". Value on msn = " + mLatitude + "."));
				}				
				if(mRadius != testData.radius.intValue()){
					errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.radius + ". Value on msn = " + mRadius + "(double to int)."));
				}				*/

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
					System.out.println("schedulePausePromotion(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.adEngineList.toString() + ")");
					ret = adEngine.schedulePausePromotion(testData.semplestCustomerId, testData.semplestPromotionId, testData.adEngineList);
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
				/*Double mLatitude = mTarget.getLocation().getRadiusTarget().getBids()[0].getLatitudeDegrees();
				Double mLongitude = mTarget.getLocation().getRadiusTarget().getBids()[0].getLongitudeDegrees();
				int mRadius = mTarget.getLocation().getRadiusTarget().getBids()[0].getRadius();
				
				System.out.println(" -address = (street address), " + mLocation.getCityTarget().getBids()[0].getCity() + ", " + mLocation.getMetroAreaTarget().getBids()[0].getMetroArea() + ", " + mLocation.getStateTarget().getBids()[0].getState() + ", " + mLocation.getCountryTarget().getBids()[0].getCountryAndRegion());
				System.out.println(" -latitude = " + mLatitude);	
				System.out.println(" -longtitude = " + mLongitude);	
				System.out.println(" -radius = " + mRadius);	
				
				if(!mLongitude.equals(testData.newLongitude)){
					errorHandler(new Exception(vMsg + "Longitude doesn't match. Value in database = " + testData.newLongitude + ". Value on msn = " + mLongitude + "."));
				}
				if(!mLatitude.equals(testData.newLatitude)){
					errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.newLatitude + ". Value on msn = " + mLatitude + "."));
				}				
				if(mRadius != testData.newRadius.intValue()){
					errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + testData.newRadius + ". Value on msn = " + mRadius + "(double to int)."));
				}*/
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
			Double changeInBudget = 1.55; //77.55;
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
						if(!amount.equals(String.valueOf(new Double(updatedBudget * 1000000).intValue()))){
							errorHandler(new Exception(vMsg + "Budget Amount is not updated correctly. Update budget amount = " + updatedBudget + " (" + String.valueOf(updatedBudget * 1000000) + "). The value on google = " + amount + " (in micro)."));
						}
					}
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */			
				System.out.println(">>> Verify result on MSN >>>");
				com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(testData.msnAccountId, testData.campaignId);
				System.out.println("Budget Amount of the Campaign " + testData.campaignId + " is - " + mcpn.getDailyBudget() + " (Daily Budget)");
				if(!mcpn.getDailyBudget().equals(updatedBudget)){
					errorHandler(new Exception(vMsg + "Budget Amount is not updated correctly. Update budget amount = " + updatedBudget + ". The value on msn = " + mcpn.getDailyBudget() + "."));
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	private void RefreshSiteLinks(TEST_METHOD method) throws Exception{
		//RefreshSiteLinks
		System.out.println("------------------------------------------------------------");
		try{
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleRefreshSiteLinks(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.adEngineList + ")");
					ret = adEngine.scheduleRefreshSiteLinks(testData.semplestCustomerId, testData.semplestPromotionId, testData.adEngineList);
				}
				else{
					System.out.println("RefreshSiteLinks(" + testData.semplestPromotionId + ", " + testData.adEngineList + ")");
					ret = adEngine.RefreshSiteLinks(testData.semplestPromotionId, testData.adEngineList);
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
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */			
				System.out.println(">>> Verify result on Google >>>");
				
				List<SitelinksExtension> gSiteLinks = google.GetSitelinkExtensions(testData.googleAccountId.toString(), testData.campaignId, CampaignAdExtensionStatus.ACTIVE);
				match = 0;
				for(SitelinksExtension sle : gSiteLinks){
					System.out.println("Sitelinks:");
					for(com.google.api.adwords.v201109_1.cm.Sitelink sl : sle.getSitelinks()){
						System.out.println(" - " + sl.getDisplayText() + ", " + sl.getDestinationUrl());
						if((sl.getDisplayText().equalsIgnoreCase(testData.siteLink3.linkText))
								&& (sl.getDestinationUrl().equalsIgnoreCase(testData.siteLink3.linkUrl))){
							match++;
						}
					}
					if(sle.getSitelinks().length != testData.sitelinks.size()){
						errorHandler(new Exception(vMsg + "The num of SiteLinks in database and the num of SiteLinks be refreshed on google don't match. " +
								"Num of SiteLinks in database: " + testData.sitelinks.size() + ". Num of SiteLinks refreshed to google: " + sle.getSitelinks().length));
					}
					if(match != 1){
						errorHandler(new Exception(vMsg + "SiteLinks are not refreshed correctly on google. " +
								"A SiteLink " + testData.siteLink3 + " is not found on google."));
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
					System.out.println(" -" + kw.getText());
					if(kw.getText().equals(findAKeyword))
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
					System.out.println(" -" + kw.getText());
					if(kw.getText().equals(findAKeyword))
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
	
	private void AddNegativeKeywords(TEST_METHOD method) throws Exception{
		//AddNegativeKeywords
		System.out.println("------------------------------------------------------------");
		try{
			//Insert some new positive keywords to the database	
			System.out.println("Add some new positive keywords to the database and google.");
			for(Integer kwid : testData.posKeywordIds){
				String sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
						"VALUES(?,?,CURRENT_TIMESTAMP,1,0,0,1,1,1)";
				
				jdbcTemplate.update(sql, new Object[]
						{kwid, testData.semplestPromotionId});				
			}
			adEngine.AddKeywords(testData.semplestPromotionId, testData.posKeywordIds, testData.adEngineList);
			
			//verify the current negative keywords
			Map<String, Long> negKeywords = google.getAllNegativeKeywordsToCriterionIdMap(testData.googleAccountId.toString(), testData.campaignId, com.google.api.adwords.v201109.cm.KeywordMatchType.EXACT);
			System.out.println("Negative keywords on google before we put on the new negative keywords:");
			for(String negkw : negKeywords.keySet()){
				System.out.println(" -" + negkw);
			}
			
			//verify the current positive keywords
			System.out.println("Positive keywords on google before we put on the new negative keywords:");
			String[] gkws = google.getAllAdGroupKeywords(testData.googleAccountId.toString(), new Long(testData.adGroupId), true);
			for(String kw : gkws){
				System.out.println(" -" + kw);
			}
						
			//Insert some new negative keywords to the database	
			System.out.println("Add some new negative keywords to the database.");			
			for(Integer kwid : testData.newNegKeywordIds){
				//add new negative keywords
				String sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
						"VALUES(?,?,CURRENT_TIMESTAMP,1,0,1,1,1,1)";
				
				jdbcTemplate.update(sql, new Object[]
						{kwid, testData.semplestPromotionId});
				
				KeywordIdRemoveOppositePair nk = new KeywordIdRemoveOppositePair(kwid,false);
				testData.keywordIdRemoveOppositePairs.add(nk);
			}				
			for(Integer kwid : testData.posToNegKeywordIds){
				//update existing positive keywords to negative keywords
				String sql = "UPDATE PromotionKeywordAssociation SET IsNegative = 1 WHERE KeywordFK = ? AND PromotionFK = ?";
				
				jdbcTemplate.update(sql, new Object[]
						{kwid, testData.semplestPromotionId});
				
				KeywordIdRemoveOppositePair nk = new KeywordIdRemoveOppositePair(kwid,true);
				testData.keywordIdRemoveOppositePairs.add(nk);
			}
			
			//run the method
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleAddNegativeKeywords(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + testData.keywordIdRemoveOppositePairs + ", " + testData.adEngineList + ")");
					ret = adEngine.scheduleAddNegativeKeywords(testData.semplestCustomerId, testData.semplestPromotionId, testData.keywordIdRemoveOppositePairs, testData.adEngineList);
				}
				else{
					System.out.println("AddNegativeKeywords(" + testData.semplestPromotionId + ", " + testData.keywordIdRemoveOppositePairs + ", " + testData.adEngineList + ")");
					ret = adEngine.AddNegativeKeywords(testData.semplestPromotionId, testData.keywordIdRemoveOppositePairs, testData.adEngineList);
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
			int numExpectedOutputNegKeywords = testData.negKeywordIds.size() + testData.newNegKeywordIds.size() + testData.posToNegKeywordIds.size();
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */			
				System.out.println(">>> Verify result on Google >>>");					
				
				negKeywords = google.getAllNegativeKeywordsToCriterionIdMap(testData.googleAccountId.toString(), testData.campaignId, com.google.api.adwords.v201109.cm.KeywordMatchType.EXACT);
				System.out.println("Negative keywords that we have on google:");
				match = 0;
				for(String negkw : negKeywords.keySet()){
					System.out.println(" -" + negkw);
					if(negkw.equals(testData.negKeywords.get(1))){
						//the neg keyword that added by addPromotionToAdEngine
						match++;
					}
					if(negkw.equals(testData.newNegKeywords.get(1))){
						//a new neg keyword that added at the beginning at this test
						match++;
					}
					if(negkw.equals(testData.posToNegKeywords.get(1))){
						//a neg keyword that used to be a positive keyword
						match++;
					}
				}								
				if(negKeywords.size() != numExpectedOutputNegKeywords){
					errorHandler(new Exception(vMsg + "The num of Negative Keywords in database and the num of Negative Keywords put on google don't match. " +
							"Num of Negative Keywords in database: " + numExpectedOutputNegKeywords + ". Num of Negative Keywords existing to google: " + negKeywords.size()));
				}
				if(match != 3){
					//some expected neg keywords are not found on google
					errorHandler(new Exception(vMsg + "Negative Keywords are not added correctly on google. Some expected negtive keywords are not found."));
				}
				
				System.out.println("Positive keywords on google after we put on the negative keywords:");
				gkws = google.getAllAdGroupKeywords(testData.googleAccountId.toString(), new Long(testData.adGroupId), true);
				match = 0;
				for(String kw : gkws){
					System.out.println(" -" + kw);
					if(kw.equals(testData.posToNegKeywords.get(0))){
						errorHandler(new Exception(vMsg + "Negative Keywords are not added correctly on google. A Negative Keyword '" + testData.posToNegKeywords.get(0) + "' is not taken off from the Positive Keyword list."));
					}
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */			
				System.out.println(">>> Verify result on MSN >>>");
				System.out.println("Verify manually.");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	
	private void DeleteNegativeKeywords(TEST_METHOD method) throws Exception{
		//DeleteNegativeKeywords
		System.out.println("------------------------------------------------------------");
		try{
			//the negative keywords that we want to delete from google
			List<Integer> deleteKeywordsList = new ArrayList<Integer>();
			deleteKeywordsList.addAll(testData.negKeywordIds);
			deleteKeywordsList.addAll(testData.posToNegKeywordIds);
			
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("scheduleDeleteNegativeKeywords(" + testData.semplestCustomerId + ", " + testData.semplestPromotionId + ", " + deleteKeywordsList + ", " + testData.adEngineList + ")");
					ret = adEngine.scheduleDeleteNegativeKeywords(testData.semplestCustomerId, testData.semplestPromotionId, deleteKeywordsList, testData.adEngineList);
				}
				else{
					System.out.println("DeleteNegativeKeywords(" + testData.semplestPromotionId + ", " + deleteKeywordsList + ", " + testData.adEngineList + ")");
					ret = adEngine.DeleteNegativeKeywords(testData.semplestPromotionId, deleteKeywordsList, testData.adEngineList);
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
			String findANegKeyword1 = testData.negKeywords.get(0);
			String findANegKeyword2 = testData.posToNegKeywords.get(0);
			int numExpectedOutputNegKeywords = testData.newNegKeywordIds.size();
			
			if(testData.adEngineList.contains(AdEngine.Google.name())){
				/* ***** For Google ***** */			
				System.out.println(">>> Verify result on Google >>>");					
				
				Map<String, Long> negKeywords = google.getAllNegativeKeywordsToCriterionIdMap(testData.googleAccountId.toString(), testData.campaignId, com.google.api.adwords.v201109.cm.KeywordMatchType.EXACT);
				System.out.println("Negative keywords that we have on google:");
				match = 0;
				for(String negkw : negKeywords.keySet()){
					System.out.println(" -" + negkw);
					if(negkw.equals(findANegKeyword1) || negkw.equals(findANegKeyword2)){
						//the neg keywords that should have been deleted
						match++;
					}
				}								
				if(negKeywords.size() != numExpectedOutputNegKeywords){
					errorHandler(new Exception(vMsg + "The num of Negative Keywords in database and the num of Negative Keywords put on google don't match. " +
							"Num of Negative Keywords active in database: " + numExpectedOutputNegKeywords + ". Num of Negative Keywords existing to google: " + negKeywords.size()));
				}
				if(match > 0){
					//some neg keywords are not deleted on google
					errorHandler(new Exception(vMsg + "Negative Keywords are not deleted correctly on google. Some negtive keywords that should have been deleted are still found on google."));
				}
				
				System.out.println("Positive keywords on google after we deleted the negative keywords:");
				String[] gkws = google.getAllAdGroupKeywords(testData.googleAccountId.toString(), new Long(testData.adGroupId), true);
				for(String kw : gkws){
					System.out.println(" -" + kw);					
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */			
				System.out.println(">>> Verify result on MSN >>>");
				System.out.println("Verify manually.");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}

	
	private void PauseProductGroups(TEST_METHOD method) throws Exception{
		//PauseProductGroups
		System.out.println("------------------------------------------------------------");
		try{
			//set the target campaigns active before the test
			Long account1 = testData.googleAccountId.longValue();
			Long account2 = testData.presetGoogleAccountId;
			Long campaign1 = testData.campaignId;
			Long campaign2 = testData.presetGoogleCampaignId;
			if(testData.adEngineList.contains(AdEngine.Google.name())){				
				//active a campaign in the 1st product group
				google.changeCampaignsStatus(account1.toString(), Arrays.asList(campaign1), com.google.api.adwords.v201109.cm.CampaignStatus.ACTIVE);
				//active a campaign in the 2nd product group
				google.changeCampaignsStatus(account2.toString(), Arrays.asList(campaign2), com.google.api.adwords.v201109.cm.CampaignStatus.ACTIVE);
			}
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				account1 = testData.msnAccountId;
				account2 = null;
				campaign2 = null;
				msn.resumeCampaignById(account1, campaign1);
			}
			
			//test the method
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){
					System.out.println("schedulePauseProductGroups(" + testData.semplestCustomerId + ", " + testData.productGroupIds + ", " + testData.adEngineList + ")");
					ret = adEngine.schedulePauseProductGroups(testData.semplestCustomerId, testData.productGroupIds, testData.adEngineList);
				}
				else{
					System.out.println("PauseProductGroups(" + testData.productGroupIds + ", " + testData.adEngineList + ")");
					ret = adEngine.PauseProductGroups(testData.productGroupIds, testData.adEngineList);
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
				System.out.println(">>> Verify result on Google >>>");
				//Check if the promotion in the 1st product group be paused
				ArrayList<HashMap<String, String>> gcpn1 = google.getCampaignsByAccountId(account1.toString(), false);
				for(HashMap<String, String> map : gcpn1){
					if(map.get("Id").equals(campaign1.toString())){
						String status = map.get("Status");
						System.out.println("Status of the campaign " + campaign1 + " in the ProductGroup 196 " + " is - " + status);
						if(!status.equals(com.google.api.adwords.v201109.cm.CampaignStatus.PAUSED.getValue())){
							errorHandler(new Exception(vMsg + "Campaign is not paused."));
						}
					}
				}
				//Check if the promotion in the 2nd product group be paused
				ArrayList<HashMap<String, String>> gcpn2 = google.getCampaignsByAccountId(account2.toString(), false);
				for(HashMap<String, String> map : gcpn2){
					if(map.get("Id").equals(campaign2.toString())){
						String status = map.get("Status");
						System.out.println("Status of the campaign " + campaign2 + " in the ProductGroup 197 " + " is - " + status);
						if(!status.equals(com.google.api.adwords.v201109.cm.CampaignStatus.PAUSED.getValue())){
							errorHandler(new Exception(vMsg + "Campaign is not paused."));
						}
					}
				}
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */			
				System.out.println(">>> Verify result on MSN >>>");
				//Check if the promotion in the 1st product group be paused
				com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(account1, campaign1);
				System.out.println("Status of Campaign " + account1 + " is - " + mcpn.getStatus().getValue());
				if(!mcpn.getStatus().equals(com.microsoft.adcenter.v8.CampaignStatus.Paused)){
					errorHandler(new Exception(vMsg + "Campaign is not paused."));
				}
				//TODO
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(e);
		}		
		Thread.sleep(sleepTime);
	}
	
	
	private void ExecuteBidProcess(TEST_METHOD method) throws Exception{
		//ExecuteBidProcess
		System.out.println("------------------------------------------------------------");
		try{			
			boolean ret = false;
			try{
				if(method.equals(TEST_METHOD.scheduled)){}
				else{
					System.out.println("ExecuteBidProcess(" + testData.semplestPromotionId + ", " + AdEngine.Google.name() + ")");
					ret = adEngine.ExecuteBidProcess(testData.semplestPromotionId, testData.adEngineList);
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
				System.out.println(">>> Verify result on Google >>>");						
				//TODO
				
			}
			
			if(testData.adEngineList.contains(AdEngine.MSN.name())){
				/* ***** For MSN ***** */			
				System.out.println(">>> Verify result on MSN >>>");
				//TODO
			}
			
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

			System.out.println("####################################################################################");
			System.out.println("#                                                                                  #");
			System.out.println("#                              AdEngine Test (Client)                              #");
			System.out.println("#                                                                                  #");
			System.out.println("####################################################################################");			
						
			System.out.println("Loading configuration...");
			
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
		
			System.out.println("End of configuration.");
			
			//delete history test data
			if(isDeleteHistoryTestData){
				clearHistoryTestData();
			}			
			
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
			
			//Negative Keywords
			for(Integer kwId : testData.negKeywordIds){
				sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
						"VALUES(?,?,CURRENT_TIMESTAMP,1,0,1,1,1,1)";
				
				jdbcTemplate.update(sql, new Object[]
						{kwId, testData.semplestPromotionId});
			}
			
			//GeoTargeting			
			sql = "INSERT INTO GeoTargeting (PromotionFK, Address,City,StateCodeFK,Zip,Longitude,Latitude,ProximityRadius) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, new Object[]
					{testData.semplestPromotionId, testData.address, testData.city, testData.stateCode, testData.zipCode, testData.longitude, testData.latitude, testData.radius});
			
			//SiteLinks
			for(TestDataModel.SiteLink sl : testData.sitelinks){
				sql = "INSERT INTO SiteLinks(PromotionFK,LinkText,LinkURL) " +
						"VALUES(?,?,?)";
				jdbcTemplate.update(sql, new Object[]
						{testData.semplestPromotionId, sl.linkText, sl.linkUrl});
			}		
			
			
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

	private void clearHistoryTestData(){
		try{
			String sql;
			System.out.println("Clearing history test data...");
			
			System.out.println(" - Delete history test data from database.");
			
			System.out.println("  -- clear scheduler data");
			//Clear the scheduler data
			sql = "delete from ScheduleLog; " +
					"delete from ScheduleJob; " +
					"delete from ScheduleTaskAssociation; " +
					"delete from Schedule; " +
					"delete from Task; ";
			jdbcTemplate.update(sql);
			
			System.out.println("  -- clear other data");
			sql= "DELETE from KeywordBidData;" +
					"DELETE FROM TargetedDailyBudget;" +
					"DELETE FROM AdvertisingEngineAds;";			
			jdbcTemplate.update(sql);						
			
			//get the list of promotion IDs
			sql = "SELECT p.PromotionPK FROM Promotion p WHERE ProductGroupFK = ?";
			List<Integer> promoIds = jdbcTemplate.queryForList(sql, new Object[]
					{testData.semplestProductGroupId}, Integer.class);
					//{testData.productGroupIds.get(1)}, Integer.class);
			
			System.out.println("  -- delete promotion data.");
			for(Integer promoId : promoIds){				
				sql = "DELETE FROM AdvertisingEnginePromotion where PromotionFK = ?;" +
						"DELETE PromotionAds WHERE PromotionFK = ?;" +
						"DELETE FROM KeywordBid WHERE PromotionFK = ?;" +
						"DELETE PromotionKeywordAssociation WHERE PromotionFK = ?;" +
						"DELETE GeoTargeting WHERE PromotionFK = ?;" +
						"DELETE SiteLinks WHERE PromotionFK = ?;" +
						"DELETE Promotion WHERE PromotionPK = ?;";
				
				jdbcTemplate.update(sql, new Object[]
						{promoId,promoId,promoId,promoId,promoId,promoId,promoId});						
				
				System.out.println("     - promotion " + promoId + " deleted");
			}			
			
			System.out.println(" - Delete history test data from google.");
			//clear Test Data on google	
			ArrayList<HashMap<String, String>> googleCampaigns = google.getCampaignsByAccountId(testData.googleAccountId.toString(), false);
			for(HashMap<String, String> map : googleCampaigns){
				google.deleteCampaign(testData.googleAccountId.toString(), Long.valueOf(map.get("Id")));
				System.out.println("  -- deleted campaign " + map.get("Id"));
				Thread.sleep(500);
			}	
			
			System.out.println(" - Delete history test data from msn.");
			//clear Test Data on google	
			com.microsoft.adcenter.v8.Campaign[] msnCampaigns = msn.getCampaignsByAccountId(testData.msnAccountId);
			for(com.microsoft.adcenter.v8.Campaign cpn : msnCampaigns){
				msn.deleteCampaignById(testData.msnAccountId, cpn.getId());
				System.out.println("  -- deleted campaign " + cpn.getId());
				Thread.sleep(500);
			}	
			
			System.out.println("History test data cleaned up.");
		}
		catch(Exception e){
			e.printStackTrace();
			errorHandler(new Exception("Clear History Test Data Failed",e));
		}
	}
	
	private class TestDataModel{	
		
		//Semplest Variables
		public Integer semplestCustomerId = 1388; //semplest_testing (set up manually in database)
		public Integer semplestProductGroupId = 196; //semplest_testing (set up manually in database)
		public Integer semplestPromotionId;
		public String semplestPromotionName;
		//public ArrayList<String> adEngineList = new ArrayList<String>(Arrays.asList(AdEngine.Google.name()));
		public ArrayList<String> adEngineList = new ArrayList<String>(Arrays.asList(AdEngine.MSN.name()));				
		
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
		
		//Ad Group
		public List<Integer> productGroupIds = Arrays.asList(196,197);
		public Integer presetPromoId = 298;  //a promotion pre-set in the database for adgroup 197 for the pauseAdGroup test		
		public Long presetGoogleAccountId = 54103L;
		public Long presetGoogleCampaignId = 680388L;
		public Long presetGoogleAdgroupId = 3066578036L;
		
		//Keywords (all keywords are set up manually in database)
		public List<String> keywords = Arrays.asList("nan adengine test","nan adengine test one","nan adengine test two");
		public List<Integer> keywordIds = Arrays.asList(622665, 622666, 622667);					
		
		public List<String> newKeywords = Arrays.asList("nan adengine test three","nan adengine test four");
		public List<Integer> newKeywordIds = Arrays.asList(781025, 781026);
		
		//Negative Keywords		
		public List<String> negKeywords = Arrays.asList("nan adengine test negative", "nan adengine test negative one");
		public List<Integer> negKeywordIds = Arrays.asList(781027, 781028);	
		
		public List<String> posKeywords = Arrays.asList("nan", "adengine test five", "adengine test six");
		public List<Integer> posKeywordIds = Arrays.asList(781033, 781031, 781032);
		public List<String> newNegKeywords = Arrays.asList("nan adengine test negative two", "nan adengine test negative three");
		public List<Integer> newNegKeywordIds = Arrays.asList(781029, 781030);		
		public List<String> posToNegKeywords = Arrays.asList("nan", "adengine test five");
		public List<Integer> posToNegKeywordIds = Arrays.asList(781033, 781031);	
		
		public List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs = new ArrayList<KeywordIdRemoveOppositePair>();
		
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
		
		//SiteLinks
		private SiteLink siteLink1 = new SiteLink(1);
		private SiteLink siteLink2 = new SiteLink(2);
		private SiteLink siteLink3 = new SiteLink(3);
		public List<SiteLink> sitelinks = Arrays.asList(siteLink1, siteLink2, siteLink3);
		
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
		
		public class SiteLink{
			public String linkText = "Test SiteLink ";
			public String linkUrl = "http://www.semplest.com/";
			
			public SiteLink(Integer index){
				this.linkText = this.linkText + index.toString();
				this.linkUrl = this.linkUrl + index.toString();
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
					+ ", promotionAdIds=" + promotionAdIds + ", ad4=" + ad4
					+ ", ad5=" + ad5 + ", newAds=" + newAds + ", newAdIds="
					+ newAdIds + ", productGroupIds=" + productGroupIds
					+ ", presetPromoId=" + presetPromoId
					+ ", presetGoogleAccountId=" + presetGoogleAccountId
					+ ", presetGoogleCampaignId=" + presetGoogleCampaignId
					+ ", presetGoogleAdgroupId=" + presetGoogleAdgroupId
					+ ", keywords=" + keywords + ", keywordIds=" + keywordIds
					+ ", newKeywords=" + newKeywords + ", newKeywordIds="
					+ newKeywordIds + ", negKeywords=" + negKeywords
					+ ", negKeywordIds=" + negKeywordIds + ", posKeywords="
					+ posKeywords + ", posKeywordIds=" + posKeywordIds
					+ ", newNegKeywords=" + newNegKeywords
					+ ", newNegKeywordIds=" + newNegKeywordIds
					+ ", posToNegKeywords=" + posToNegKeywords
					+ ", posToNegKeywordIds=" + posToNegKeywordIds
					+ ", keywordIdRemoveOppositePairs="
					+ keywordIdRemoveOppositePairs + ", address=" + address
					+ ", city=" + city + ", stateCode=" + stateCode
					+ ", zipCode=" + zipCode + ", longitude=" + longitude
					+ ", latitude=" + latitude + ", radius=" + radius
					+ ", newAddress=" + newAddress + ", newCity=" + newCity
					+ ", newStateCode=" + newStateCode + ", newZipCode="
					+ newZipCode + ", newLongitude=" + newLongitude
					+ ", newLatitude=" + newLatitude + ", newRadius="
					+ newRadius + ", sitelinks=" + sitelinks + "]";
		}				
		
	}

}
