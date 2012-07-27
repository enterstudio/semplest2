package semplest.system.tester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.adwords.v201109.cm.AdGroupAd;
import com.google.api.adwords.v201109.cm.CampaignCriterion;
import com.google.api.adwords.v201109.cm.CampaignStatus;
import com.google.api.adwords.v201109.cm.TextAd;
import com.google.api.adwords.v201109_1.cm.CampaignAdExtensionStatus;
import com.google.api.adwords.v201109_1.cm.SitelinksExtension;

import semplest.server.protocol.KeywordIdRemoveOppositePair;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.google.GoogleAddAdRequest;
import semplest.server.protocol.google.GoogleViolation;
import semplest.server.protocol.google.KeywordToolStats;
import semplest.server.service.springjdbc.BaseDB;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;
import semplest.service.msn.adcenter.MsnCloudServiceImpl;
import semplest.services.client.api.SemplestAdEngineServiceClient;
import semplest.services.client.interfaces.SemplestAdengineServiceInterface;

public class AdEngineServiceTest extends BaseDB implements SemplestAdengineServiceInterface{
	private String serviceName = "AdEngine";
	
	private static Long sleepTime = 10000L;

	private SemplestAdEngineServiceClient adEngineService;
	private GoogleAdwordsServiceImpl google;
	private MsnCloudServiceImpl msn;	
	
	public static void main(String[] args){
		try {
			SystemTestFunc.InitializeSystemTest();			
			System.out.println("########## Initialization done!");
			Thread.sleep(10000);
			System.out.println("########## AddPromotionToAdEngine Starts!");
			
			AdEngineServiceTest test = new AdEngineServiceTest();
			
			test.Test_AdEngineService("http://VMJAVA1:9898/semplest");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int Test_AdEngineService(String serviceURL){	
		try{			
			SystemTestFunc.PrintServiceHeader(serviceName);			
			SystemTestDataModel.errorCounter = 0;
			
			adEngineService = new SemplestAdEngineServiceClient(serviceURL);
			google = new GoogleAdwordsServiceImpl();		
			msn = new MsnCloudServiceImpl();
			
			/* ***** List of Methods ***** */
			AddPromotionToAdEngine(null, null, null, null);					
			validateGoogleAd(null, null, null);
			validateGoogleRefreshSiteLinks(null);
			validateGoogleGeoTargets(null);
			validateGoogleNegativeKeywords(null);
			AddAds(null, null, null);
			UpdateAds(null, null, null);
			DeleteAds(null, null, null);
			UpdateGeoTargeting(null, null);
			ChangePromotionStartDate(null, null, null);
			UpdateBudget(null, null, null);
			RefreshSiteLinks(null, null);
			AddKeywords(null, null, null);
			DeleteKeywords(null, null, null);
			AddNegativeKeywords(null, null, null);
			DeleteNegativeKeywords(null, null, null);
			PauseProductGroups(null, null);
			UnpausePromotion(null, null);
			PausePromotion(null, null);
			
			//methods that haven't been implemented by AdEngine service yet
			//EndPromotion(null, null);
			//DeletePromotion(null, null);
			
			/* ***** End of List of Methods ***** */
			
		}
		catch(Exception e){
			SystemTestFunc.PrintLineSeperator();
			SystemTestFunc.ErrorHandler(e);
		}
		
		SystemTestFunc.PrintServiceFooter(serviceName, SystemTestDataModel.errorCounter);	
		SystemTestDataModel.adEngineErrors = SystemTestDataModel.errorCounter;
		return SystemTestDataModel.errorCounter;
	}	
	
	
	@Override
	public Boolean AddPromotionToAdEngine(Integer customerID,
			Integer productGroupID, Integer PromotionID,
			List<AdEngine> adEngineList) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
					
		boolean ret = false;
		long start = System.currentTimeMillis();
		
		SystemTestFunc.PrintMethodCall("AddPromotionToAdEngine(SystemTestDataModel.semplestCustomerId, SystemTestDataModel.semplestProductGroupId, SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList)");
		try{
			ret = adEngineService.AddPromotionToAdEngine(SystemTestDataModel.semplestCustomerId, SystemTestDataModel.semplestProductGroupId, SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			e.printStackTrace();
			SystemTestFunc.ErrorHandler(e);
		}
		System.out.println(" - DONE");
		double sec = (double) (System.currentTimeMillis() - start)/1000.00;
		System.out.println("AddPromotionToAdEngine took " + sec + " seconds");
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("AddPromotionToAdEngine failed.");
			return false;
		}	
		else{									
			Verification_AddPromotionToAdEngine();
		}			
		
		Thread.sleep(sleepTime);
		return null;
	}	

	@Override
	public Boolean scheduleAddPromotionToAdEngine(Integer customerID,
			Integer productGroupID, Integer PromotionID,
			List<AdEngine> adEngineList) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		
		boolean ret = false;
		
		SystemTestFunc.PrintMethodCall("scheduleAddPromotionToAdEngine(SystemTestDataModel.semplestCustomerId, SystemTestDataModel.semplestProductGroupId, SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList)");
		try{
			ret = adEngineService.scheduleAddPromotionToAdEngine(SystemTestDataModel.semplestCustomerId, SystemTestDataModel.semplestProductGroupId, SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			e.printStackTrace();
			SystemTestFunc.ErrorHandler(e);
		}
		System.out.println(" - DONE");
		
		if(!ret){
			SystemTestFunc.ErrorHandler("scheduleAddPromotionToAdEngine failed.");
			return false;
		}	
		else{							
			Verification_AddPromotionToAdEngine();
		}			
		
		Thread.sleep(sleepTime);		
		return null;
	}
	
	@Override
	public Boolean AddAds(Integer promotionID, List<Integer> promotionAdIds,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		
		//Add a new AD to the DB
		SystemTestDataModel.promotionAdIds2 = new ArrayList<Integer>();
		for(SystemTestDataModel.AD ad : SystemTestDataModel.promotionAds2){
			String sql = "INSERT INTO PromotionAds(PromotionFK,AdTitle,AdTextLine1,AdTextLine2,IsDeleted,CreatedDate) " +
					"VALUES(?, ?, ?, ?, 0 , CURRENT_TIMESTAMP)";
			jdbcTemplate.update(sql, new Object[]
					{SystemTestDataModel.semplestPromotionId, ad.adTitle, ad.adTextLine1, ad.adTextLine2});	
			
			sql = "SELECT pa.PromotionAdsPK FROM PromotionAds pa WHERE pa.PromotionFK = ? and pa.AdTitle = ?";
			Integer id = jdbcTemplate.queryForInt(sql, new Object[]
					{SystemTestDataModel.semplestPromotionId, ad.adTitle});
			SystemTestDataModel.promotionAdIds2.add(id);
		}
		
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("AddAds(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.promotionAdIds2, SystemTestDataModel.adEngineList");
		try{			
			ret = adEngineService.AddAds(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.promotionAdIds2, SystemTestDataModel.adEngineList);			
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("AddAds failed.");
			return false;
		}	
		else{
			Verification_AddAds();
		}
		
		Thread.sleep(sleepTime);
		return null;
	}

	
	@Override
	public Boolean UpdateAds(Integer promotionID, List<Integer> promotionAdIds,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		String newAdTitle = "Simplify your SEM";
		String sql = "update PromotionAds set AdTitle = ? where PromotionAdsPK = ?";
		jdbcTemplate.update(sql, new Object[]
				{newAdTitle, SystemTestDataModel.promotionAdIds2.get(0)});	
		
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("UpdateAds(" + SystemTestDataModel.semplestPromotionId + ", " + SystemTestDataModel.promotionAdIds2 + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.UpdateAds(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.promotionAdIds2, SystemTestDataModel.adEngineList);			
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("AddAds failed.");
			return false;
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	
	
	@Override
	public Boolean DeleteAds(Integer promotionID, List<Integer> promotionAdIds,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("DeleteAds(" + SystemTestDataModel.semplestPromotionId + ", " + SystemTestDataModel.promotionAdIds + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.DeleteAds(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.promotionAdIds, SystemTestDataModel.adEngineList);			
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("DeleteAds failed.");
			return false;
		}	
		else{
			verification_DeleteAds();
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	
	
	@Override
	public Boolean UpdateGeoTargeting(Integer promotionID,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("UpdateGeoTargeting(" + SystemTestDataModel.semplestPromotionId + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.UpdateGeoTargeting(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("UpdateGeoTargeting failed.");
			return false;
		}
		
		Thread.sleep(sleepTime);
		return null;
	}

	@Override
	public Boolean ChangePromotionStartDate(Integer promotionID,
			Date newStartDate, List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("ChangePromotionStartDate(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngine_NewPromotionStartDate, SystemTestDataModel.adEngineListGoogle)");
		try{			
			ret = adEngineService.ChangePromotionStartDate(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngine_NewPromotionStartDate, SystemTestDataModel.adEngineListGoogle);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("ChangePromotionStartDate failed.");
			return false;
		}
		
		Thread.sleep(sleepTime);
		return null;
	}

	@Override
	public Boolean UpdateBudget(Integer promotionID, Double changeInBudget,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("UpdateBudget(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngine_ChangeInBudget, SystemTestDataModel.adEngineList)");
		try{			
			ret = adEngineService.UpdateBudget(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngine_ChangeInBudget, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("UpdateBudget failed.");
			return false;
		}
		else{
			verification_UpdateBudget();
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	

	@Override
	public Boolean RefreshSiteLinks(Integer promotionID,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("RefreshSiteLinks(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineListGoogle");
		try{			
			ret = adEngineService.RefreshSiteLinks(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineListGoogle);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("RefreshSiteLinks failed.");
			return false;
		}
		else{
			verification_RefreshSiteLinks();
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	

	@Override
	public Boolean AddKeywords(Integer promotionID, List<Integer> keywordIds,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		
		//Link new keywords to the promotion
		for(Integer kwId : SystemTestDataModel.keywordIds2){
			String sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
					"VALUES(?,?,CURRENT_TIMESTAMP,1,0,0,1,1,1)";
			
			jdbcTemplate.update(sql, new Object[]
					{kwId, SystemTestDataModel.semplestPromotionId});
		}
		
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("AddKeywords(" + SystemTestDataModel.semplestPromotionId + ", " + SystemTestDataModel.keywordIds2 + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.AddKeywords(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.keywordIds2, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("AddKeywords failed.");
			return false;
		}
		else{
			verification_AddKeywords();
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	

	@Override
	public Boolean DeleteKeywords(Integer promotionID,
			List<Integer> keywordIds, List<AdEngine> adEngines)
			throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		SystemTestFunc.PrintMethodCall("DeleteKeywords(" + SystemTestDataModel.semplestPromotionId + ", " + SystemTestDataModel.keywordIds + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.DeleteKeywords(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.keywordIds, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("DeleteKeywords failed.");
			return false;
		}
		else{
			verification_DeleteKeywords();
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	

	@Override
	public Boolean AddNegativeKeywords(Integer promotionID,
			List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		
		for(Integer kwId : SystemTestDataModel.negKeywordIds2){
			String sql = "INSERT INTO PromotionKeywordAssociation(KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)" +
					"VALUES(?,?,CURRENT_TIMESTAMP,1,0,1,1,1,1)";
			
			jdbcTemplate.update(sql, new Object[]
					{kwId, SystemTestDataModel.semplestPromotionId});
			
			KeywordIdRemoveOppositePair nk = new KeywordIdRemoveOppositePair(kwId,false);
			SystemTestDataModel.keywordIdRemoveOppositePairs2.add(nk);
		}
		
		SystemTestFunc.PrintMethodCall("AddNegativeKeywords(" + SystemTestDataModel.semplestPromotionId + ", " + SystemTestDataModel.keywordIdRemoveOppositePairs2 + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.AddNegativeKeywords(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.keywordIdRemoveOppositePairs2, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("AddNegativeKeywords failed.");
			return false;
		}
		else{
			//no completed verification
		}
		
		Thread.sleep(sleepTime);
		return null;
	}

	@Override
	public Boolean DeleteNegativeKeywords(Integer promotionID,
			List<Integer> keywordIds, List<AdEngine> adEngines)
			throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;		
		
		SystemTestFunc.PrintMethodCall("DeleteNegativeKeywords(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.negKeywordIds, SystemTestDataModel.adEngineListGoogle)");
		try{			
			ret = adEngineService.DeleteNegativeKeywords(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.negKeywordIds, SystemTestDataModel.adEngineListGoogle);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("DeleteNegativeKeywords failed.");
			return false;
		}
		else{
			//no completed verification
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	@Override
	public Boolean PauseProductGroups(List<Integer> productGroupIds,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		
		SystemTestFunc.PrintMethodCall("PauseProductGroups(" + SystemTestDataModel.productGroupIds + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.PauseProductGroups(SystemTestDataModel.productGroupIds, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("PauseProductGroups failed.");
			return false;
		}
		else{
			//no completed verification
		}
		
		Thread.sleep(sleepTime);
		return null;
	}	
	@Override
	public Boolean UnpausePromotion(Integer promotionID,
			List<AdEngine> adEngines) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		
		SystemTestFunc.PrintMethodCall("UnpausePromotion(" + SystemTestDataModel.semplestPromotionId + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.UnpausePromotion(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("UnpausePromotion failed.");
			return false;
		}
		else{
			verification_UnpausePromotion();
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	@Override
	public Boolean PausePromotion(Integer promotionID, List<AdEngine> adEngines)
			throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		
		SystemTestFunc.PrintMethodCall("PausePromotion(" + SystemTestDataModel.semplestPromotionId + ", " + SystemTestDataModel.adEngineList + ")");
		try{			
			ret = adEngineService.PausePromotion(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("PausePromotion failed.");
			return false;
		}
		else{
			verification_PausePromotion();
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	@Override
	public List<GoogleViolation> validateGoogleAd(String landingPageURL,
			String displayURL, List<GoogleAddAdRequest> ads) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		List<GoogleViolation> ret = null;
		
		SystemTestDataModel.adEngine_validateGoogleAds = new ArrayList<GoogleAddAdRequest>(
				Arrays.asList(new GoogleAddAdRequest(SystemTestDataModel.promotionAdIds.get(0), SystemTestDataModel.ad1.adTitle, SystemTestDataModel.ad1.adTextLine1, SystemTestDataModel.ad1.adTextLine2)));
		
		SystemTestFunc.PrintMethodCall("validateGoogleAd(SystemTestDataModel.adEngine_ValidateUrl1, SystemTestDataModel.adEngine_ValidateUrl2, SystemTestDataModel.adEngine_validateGoogleAds)");
		try{			
			ret = adEngineService.validateGoogleAd(SystemTestDataModel.adEngine_ValidateUrl1, SystemTestDataModel.adEngine_ValidateUrl2, SystemTestDataModel.adEngine_validateGoogleAds);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(ret == null){
			SystemTestFunc.ErrorHandler("validateGoogleAd failed.");
			return null;
		}	
		else if(ret.size() < 1){
			SystemTestFunc.ErrorHandler("validateGoogleAd failed.");
			return null;
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	@Override
	public List<GoogleViolation> validateGoogleRefreshSiteLinks(
			Integer promotionID) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		List<GoogleViolation> ret = null;
				
		SystemTestFunc.PrintMethodCall("validateGoogleRefreshSiteLinks(" + SystemTestDataModel.semplestPromotionId + ")");
		try{			
			ret = adEngineService.validateGoogleRefreshSiteLinks(SystemTestDataModel.semplestPromotionId);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		//no verification needed here
		
		Thread.sleep(sleepTime);
		return null;
	}
	@Override
	public List<GoogleViolation> validateGoogleGeoTargets(Integer promotionID)
			throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		List<GoogleViolation> ret = null;
				
		SystemTestFunc.PrintMethodCall("validateGoogleGeoTargets(" + SystemTestDataModel.semplestPromotionId + ")");
		try{			
			ret = adEngineService.validateGoogleGeoTargets(SystemTestDataModel.semplestPromotionId);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		//no verification needed here
		
		Thread.sleep(sleepTime);
		return null;
	}
	@Override
	public List<GoogleViolation> validateGoogleNegativeKeywords(
			List<String> negativeKeywords) throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		List<GoogleViolation> ret = null;
				
		SystemTestFunc.PrintMethodCall("validateGoogleNegativeKeywords(" + SystemTestDataModel.negKeywords + ")");
		try{			
			ret = adEngineService.validateGoogleNegativeKeywords(SystemTestDataModel.negKeywords);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		//no verification needed here
		
		Thread.sleep(sleepTime);
		return null;
	}			

	//Verification Helper Methods
	private void Verification_AddPromotionToAdEngine() throws Exception{
		Thread.sleep(sleepTime);
		/* ********** Verification ********** */ 		
		String sql;
		int match = 0;
		String finaATitle = SystemTestDataModel.promotionAds.get(0).adTitle;
		String findAKeyword = SystemTestDataModel.keywords.get(0);
		String findANegKeyword = SystemTestDataModel.negKeywords.get(0);									
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.Google)){
			/* ***** For Google ***** */
			
			System.out.println(">>> Verify results on Google >>>");
			
			//***check if we got all the things created successfully at google, and stored necessary information in the database	
			System.out.println("Verify IDs:");			
			
			sql = "select aep.AdvertisingEngineCampaignPK from AdvertisingEnginePromotion aep " +
					"inner join AdvertisingEngineAccount aea on aep.AdvertisingEngineAccountFK = aea.AdvertisingEngineAccountPK " +
					"where aea.AdvertisingEngineFK = 2 and aep.PromotionFK = ?";
			SystemTestDataModel.googleCampaignId = jdbcTemplate.queryForLong(sql, SystemTestDataModel.semplestPromotionId);
			
			sql = "SELECT aep.AdvertisingEngineAdGroupID FROM AdvertisingEnginePromotion aep " +
					"inner join AdvertisingEngineAccount aea on aep.AdvertisingEngineAccountFK = aea.AdvertisingEngineAccountPK " +
					"where aea.AdvertisingEngineFK = 2 and aep.PromotionFK = ?";
			SystemTestDataModel.googleAdGroupId = jdbcTemplate.queryForLong(sql, SystemTestDataModel.semplestPromotionId);
			
			System.out.println(" -Account ID = " + SystemTestDataModel.googleAccountId);
			System.out.println(" -Campaign ID = " + SystemTestDataModel.googleCampaignId);
			System.out.println(" -AdGroup ID = " + SystemTestDataModel.googleAdGroupId);
			
			if(SystemTestDataModel.googleCampaignId.equals(null) || SystemTestDataModel.googleAdGroupId.equals(null)){
				SystemTestFunc.ErrorHandler("The promotion is not created correctly. One or more IDs are missing in the database.");
				return;
			}
			
			//***check if we have all the ads are set up on google
			System.out.println("Verify ADs:");				
			AdGroupAd[] gads = google.getAdsByAdGroupId(SystemTestDataModel.googleAccountId, new Long(SystemTestDataModel.googleAdGroupId).longValue());
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
				SystemTestFunc.ErrorHandler("Ads are not created correctly on google. " +
						"An Ad title '" + finaATitle + "' is not found.");
			}
			if(gads.length != SystemTestDataModel.promotionAds.size()){
				//verify the num of Ads get added
				SystemTestFunc.ErrorHandler("The num of Ads in database and the num of Ads be created on google don't match. " +
						"Num of active Ads in database: " + SystemTestDataModel.promotionAds.size() + ". Num of Ads added to google: " + gads.length);
			}
			
			//***check if we have all the keywords are set up on google
			System.out.println("Verify Keywords:");				
			String[] gkws = google.getAllAdGroupKeywords(SystemTestDataModel.googleAccountId, new Long(SystemTestDataModel.googleAdGroupId), true);
			System.out.println("Keywords that we put on google:");
			//verify content of the Keywords
			match = 0;				
			for(String kw : gkws){
				System.out.println(" -" + kw);
				if(kw.equals(findAKeyword))
					match++;
			}				
			if(match != 1){
				SystemTestFunc.ErrorHandler("Keywords are not created correctly on google. " +
						"An Keyword '" + findAKeyword + "' is not found.");
			}
			if(gkws.length != SystemTestDataModel.keywords.size()){
				//verify the num of Keywords get added
				SystemTestFunc.ErrorHandler("Not all Keywords in database are created on google. " +
						"Num of Keywords in database: " + SystemTestDataModel.keywords.size() + ". Num of Keywords added to google: " + gkws.length);
			}				
			
			//***check if we set negative keywords correctly on google	
			System.out.println("Verify Negative Keywords:");	
			Map<String, Long> negKeywords = google.getAllNegativeKeywordsToCriterionIdMap(SystemTestDataModel.googleAccountId, SystemTestDataModel.googleCampaignId, com.google.api.adwords.v201109.cm.KeywordMatchType.EXACT);
			System.out.println("Negative keywords that we put on google:");
			match = 0;
			for(String negkw : negKeywords.keySet()){
				System.out.println(" -" + negkw);
				if(negkw.equals(findANegKeyword))
					match++;
			}
			if(match != 1){
				SystemTestFunc.ErrorHandler("Negative Keywords are not created correctly on google. " +
						"A Negative Keyword '" + findANegKeyword + "' is not found.");
			}				
			
			//***check if we set geoTarget correctly on google
			System.out.println("Verify Geo Targets:");	
			CampaignCriterion[] gCpnCrits = google.getAllCampaignCriterions(SystemTestDataModel.googleAccountId, SystemTestDataModel.googleCampaignId);
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
					
					if(!gLongitude.equals(new Double(SystemTestDataModel.longitude * 1000000).intValue())){
						SystemTestFunc.ErrorHandler("Longitude doesn't match. Value in database = " + SystemTestDataModel.longitude + ". Value on google = " + gLongitude + "(in micro).");
					}
					if(!gLatitude.equals(new Double(SystemTestDataModel.latitude * 1000000).intValue())){
						SystemTestFunc.ErrorHandler("Latitude doesn't match. Value in database = " + SystemTestDataModel.latitude + ". Value on google = " + gLatitude + "(in micro).");
					}						
					if(!gRadius.equals(SystemTestDataModel.radius)){
						SystemTestFunc.ErrorHandler("Latitude doesn't match. Value in database = " + SystemTestDataModel.radius + ". Value on google = " + gRadius + ".");
					}
				}
			}				
		}
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.MSN)){
			/* ***** For MSN ***** */
			
			System.out.println(">>> Verify results on MSN >>>");
			
			//***check if we got all the things created successfully on msn, and stored necessary information in the database	
			System.out.println("Verify IDs:");			
			
			sql = "select aep.AdvertisingEngineCampaignPK from AdvertisingEnginePromotion aep " +
					"inner join AdvertisingEngineAccount aea on aep.AdvertisingEngineAccountFK = aea.AdvertisingEngineAccountPK " +
					"where aea.AdvertisingEngineFK = 1 and aep.PromotionFK = ?";
			SystemTestDataModel.msnCampaignId = jdbcTemplate.queryForLong(sql, SystemTestDataModel.semplestPromotionId);
			
			sql = "SELECT aep.AdvertisingEngineAdGroupID FROM AdvertisingEnginePromotion aep " +
					"inner join AdvertisingEngineAccount aea on aep.AdvertisingEngineAccountFK = aea.AdvertisingEngineAccountPK " +
					"where aea.AdvertisingEngineFK = 1 and aep.PromotionFK = ?";
			SystemTestDataModel.msnAdGroupId = jdbcTemplate.queryForLong(sql, SystemTestDataModel.semplestPromotionId);
			
			System.out.println(" -Account ID = " + SystemTestDataModel.msnAccountId);
			System.out.println(" -Campaign ID = " + SystemTestDataModel.msnCampaignId);
			System.out.println(" -AdGroup ID = " + SystemTestDataModel.msnAdGroupId);
			
			if(SystemTestDataModel.msnCampaignId.equals(null) || SystemTestDataModel.msnAdGroupId.equals(null)){
				SystemTestFunc.ErrorHandler("The promotion is not created correctly. One or more IDs are missing in the database.");
				return;
			}
			
			//***check if we have all the ads are set up on msn
			System.out.println("Verify ADs:");
			
			com.microsoft.adcenter.v8.Ad[] mads = msn.getAdsByAdGroupId(SystemTestDataModel.msnAccountId, SystemTestDataModel.msnAdGroupId);
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
				SystemTestFunc.ErrorHandler("Ads are not created correctly on MSN. " +
						"An Ad title '" + finaATitle + "' is not found.");
			}				
			if(mads.length != SystemTestDataModel.promotionAds.size()){
				//verify the num of Ads get added
				SystemTestFunc.ErrorHandler("The num of Ads in database and the num of Ads be created on MSN don't match. " +
						"Num of active Ads in database: " + SystemTestDataModel.promotionAds.size() + ". Num of Ads added to google: " + mads.length);
			}				
			
			//***check if we have all the keywords are set up on msn
			System.out.println("Verify Keywords:");
			
			com.microsoft.adcenter.v8.Keyword[] mkws = msn.getKeywordByAdGroupId(SystemTestDataModel.msnAccountId, new Long(SystemTestDataModel.msnAdGroupId));
			System.out.println("Keywords that we put on MSN:");
			//verify content of the Keywords
			match = 0;
			for(com.microsoft.adcenter.v8.Keyword kw : mkws){
				System.out.println(" -" + kw.getText());
				if(kw.getText().equals(findAKeyword))
					match++;
			}		
			if(match != 1){
				SystemTestFunc.ErrorHandler("Keywords are not created correctly on MSN. " +
						"An Keyword '" + findAKeyword + "' is not found.");
			}
			if(mkws.length != SystemTestDataModel.keywords.size()){
				//verify the num of Keywords get added
				SystemTestFunc.ErrorHandler("Not all Keywords in database are created on MSN. " +
						"Num of Keywords in database: " + SystemTestDataModel.keywords.size() + ". Num of Ads added to MSN: " + mkws.length);
			}				
			
			//***check if we set negative keywords correctly on msn					
			System.out.println("Verify Negative Keywords: (manually)");					
			
			//***check if we set geoTarget correctly on msn
			System.out.println("Verify Geo Targets: (Manually)");	
			//com.microsoft.adcenter.v8.Target mTarget = msn.getCampaignTargets(SystemTestDataModel.msnAccountId, SystemTestDataModel.msnCustomerId, SystemTestDataModel.msnCampaignId);
			
			//com.microsoft.adcenter.v8.LocationTarget mLocation = mTarget.getLocation();
			/*Double mLatitude = mLocation.getRadiusTarget().getBids()[0].getLatitudeDegrees();
			Double mLongitude = mLocation.getRadiusTarget().getBids()[0].getLongitudeDegrees();
			int mRadius = mLocation.getRadiusTarget().getBids()[0].getRadius();
			
			System.out.println(" -address = (street address), " + mLocation.getCityTarget().getBids()[0].getCity() + ", " + mLocation.getMetroAreaTarget().getBids()[0].getMetroArea() + ", " + mLocation.getStateTarget().getBids()[0].getState() + ", " + mLocation.getCountryTarget().getBids()[0].getCountryAndRegion());
			System.out.println(" -latitude = " + mLatitude);	
			System.out.println(" -longtitude = " + mLongitude);	
			System.out.println(" -radius = " + mRadius);	
			
			if(!mLongitude.equals(SystemTestDataModel.longitude)){
				errorHandler(new Exception(vMsg + "Longitude doesn't match. Value in database = " + SystemTestDataModel.longitude + ". Value on msn = " + mLongitude + "."));
			}
			if(!mLatitude.equals(SystemTestDataModel.latitude)){
				errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + SystemTestDataModel.latitude + ". Value on msn = " + mLatitude + "."));
			}				
			if(mRadius != SystemTestDataModel.radius.intValue()){
				errorHandler(new Exception(vMsg + "Latitude doesn't match. Value in database = " + SystemTestDataModel.radius + ". Value on msn = " + mRadius + "(double to int)."));
			}				*/

		}				
		
		//***check if we schedule the OnGoingBidding correctly in the database
		System.out.println("Verify OnGoingBidding Schedule: (Manually)");					
	}
	private void Verification_AddAds() throws Exception{
		Thread.sleep(sleepTime);
		
		//Verification
		System.out.println("Verify result...");
		int match = 0;
		String finaATitle = SystemTestDataModel.promotionAds2.get(0).adTitle;
		int numAllAds = SystemTestDataModel.promotionAds.size() + SystemTestDataModel.promotionAds2.size();
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.Google)){
			/* ***** For Google ***** */				
			System.out.println(">>> Verify result on Google >>>");
			
			//***check if we have all the ads are set up on google
			AdGroupAd[] gads = google.getAdsByAdGroupId(SystemTestDataModel.googleAccountId, new Long(SystemTestDataModel.googleAdGroupId).longValue());
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
				SystemTestFunc.ErrorHandler("Ads are not created correctly on google. " +
						"An Ad title '" + finaATitle + "' is not found.");
			}				
			if(gads.length != numAllAds){
				//verify the num of Ads get added
				SystemTestFunc.ErrorHandler("The num of Ads in database and the num of Ads be created on google don't match. " +
						"Num of active Ads in database: " + numAllAds + ". Num of Ads added to google: " + gads.length);
			}
		}
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.MSN)){
			/* ***** For MSN ***** */				
			System.out.println(">>> Verify result on MSN >>>");
			
			//***check if we have all the ads are set up on msn			
			com.microsoft.adcenter.v8.Ad[] mads = msn.getAdsByAdGroupId(SystemTestDataModel.msnAccountId, SystemTestDataModel.msnAdGroupId);
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
				SystemTestFunc.ErrorHandler("Ads are not created correctly on MSN. " +
						"An Ad title '" + finaATitle + "' is not found.");
			}				
			if(mads.length != numAllAds){
				//verify the num of Ads get added
				SystemTestFunc.ErrorHandler("The num of Ads in database and the num of Ads be created on MSN don't match. " +
						"Num of active Ads in database: " + numAllAds + ". Num of Ads added to google: " + mads.length);
			}				
		}
	}
	private void verification_DeleteAds() throws Exception{
		Thread.sleep(sleepTime);
		//Verification
		System.out.println("Verify result...");
		int match = 0;
		String finaATitle = SystemTestDataModel.promotionAds.get(0).adTitle;
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.Google)){
			/* ***** For Google ***** */				
			System.out.println(">>> Verify result on Google >>>");
			
			//***check if we have all the ads are set up on google
			AdGroupAd[] gads = google.getAdsByAdGroupId(SystemTestDataModel.googleAccountId, new Long(SystemTestDataModel.googleAdGroupId).longValue());
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
				SystemTestFunc.ErrorHandler("Ads are not completely deleted on google. " +
						"An Ad title '" + finaATitle + "' is found, while it should have been deleted.");
			}							
		}
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.MSN)){
			/* ***** For MSN ***** */				
			System.out.println(">>> Verify result on MSN >>>");
			
			//***check if we have all the ads are set up on msn			
			com.microsoft.adcenter.v8.Ad[] mads = msn.getAdsByAdGroupId(SystemTestDataModel.msnAccountId, SystemTestDataModel.msnAdGroupId);
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
				SystemTestFunc.ErrorHandler("Ads are not completely deleted on MSN. " +
						"An Ad title '" + finaATitle + "' is found, while it should have been deleted.");
			}			
		}
	}
	private void verification_UpdateBudget() throws Exception{
		Thread.sleep(sleepTime);
		//Verification
		System.out.println("Verify result...");
		
		//get the BudgetToAddToNextCycle from database
		String sql = "SELECT P.BudgetToAddToNextCycle FROM Promotion P WHERE PromotionPK = ?";
		Double updatedBudget = jdbcTemplate.queryForObject(sql, new Object[]
				{SystemTestDataModel.semplestPromotionId}, Double.class);
		
		updatedBudget = updatedBudget + SystemTestDataModel.adEngine_ChangeInBudget;
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.Google)){
			/* ***** For Google ***** */			
			System.out.println(">>> Verify result on Google >>>");
			ArrayList<HashMap<String, String>> gcpn = google.getCampaignsByAccountId(SystemTestDataModel.googleAccountId, false);
			for(HashMap<String, String> map : gcpn){
				if(map.get("Id").equals(SystemTestDataModel.googleCampaignId.toString())){
					String amount = map.get("Amount");
					System.out.println("Budget Amount of the Campaign " + SystemTestDataModel.googleCampaignId + " is - " + amount + " (in micro).");
					if(!amount.equals(String.valueOf(new Double(updatedBudget * 1000000).intValue()))){
						SystemTestFunc.ErrorHandler("Budget Amount is not updated correctly. Update budget amount = " + updatedBudget + " (" + String.valueOf(updatedBudget * 1000000) + "). The value on google = " + amount + " (in micro).");
					}
				}
			}
		}
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.MSN)){
			/* ***** For MSN ***** */			
			System.out.println(">>> Verify result on MSN >>>");
			com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(SystemTestDataModel.msnAccountId, SystemTestDataModel.msnCampaignId);
			System.out.println("Budget Amount of the Campaign " + SystemTestDataModel.msnCampaignId + " is - " + mcpn.getDailyBudget() + " (Daily Budget)");
			if(!mcpn.getDailyBudget().equals(updatedBudget)){
				SystemTestFunc.ErrorHandler("Budget Amount is not updated correctly. Update budget amount = " + updatedBudget + ". The value on msn = " + mcpn.getDailyBudget() + ".");
			}
		}
	}
	private void verification_RefreshSiteLinks() throws Exception{
		Thread.sleep(sleepTime);		
		//Verification
		System.out.println("Verify result...");
		int match = 0;
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.Google)){
			/* ***** For Google ***** */			
			System.out.println(">>> Verify result on Google >>>");
			
			List<SitelinksExtension> gSiteLinks = google.GetSitelinkExtensions(SystemTestDataModel.googleAccountId, SystemTestDataModel.googleCampaignId, CampaignAdExtensionStatus.ACTIVE);
			match = 0;
			for(SitelinksExtension sle : gSiteLinks){
				System.out.println("Sitelinks:");
				for(com.google.api.adwords.v201109_1.cm.Sitelink sl : sle.getSitelinks()){
					System.out.println(" - " + sl.getDisplayText() + ", " + sl.getDestinationUrl());
					if((sl.getDisplayText().equals(SystemTestDataModel.siteLink1.linkText))
							&& (sl.getDestinationUrl().equals(SystemTestDataModel.siteLink1.linkUrl))){
						match++;
					}
				}
				if(sle.getSitelinks().length != SystemTestDataModel.sitelinks.size()){
					SystemTestFunc.ErrorHandler("The num of SiteLinks in database and the num of SiteLinks be refreshed on google don't match. " +
							"Num of SiteLinks in database: " + SystemTestDataModel.sitelinks.size() + ". Num of SiteLinks refreshed to google: " + sle.getSitelinks().length);
				}
				if(match != 1){
					SystemTestFunc.ErrorHandler("SiteLinks are not refreshed correctly on google. " +
							"A SiteLink " + SystemTestDataModel.siteLink1.linkText + " is not found on google.");
				}
			}
		}
	}
	private void verification_AddKeywords() throws Exception {
		Thread.sleep(sleepTime);
		//Verification
		System.out.println("Verify result...");
		int match = 0;
		String findAKeyword = SystemTestDataModel.keywords2.get(0);
		Integer numAllKeywords = SystemTestDataModel.keywordIds.size() + SystemTestDataModel.keywordIds2.size();
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.Google)){
			/* ***** For Google ***** */
			
			System.out.println(">>> Verify result on Google >>>");
			
			String[] gkws = google.getAllAdGroupKeywords(SystemTestDataModel.googleAccountId, new Long(SystemTestDataModel.googleAdGroupId), true);
			System.out.println("Keywords that we have on google:");
			//verify content of the Keywords
			match = 0;				
			for(String kw : gkws){
				System.out.println(" -" + kw);
				if(kw.equals(findAKeyword))
					match++;
			}				
			if(match != 1){
				SystemTestFunc.ErrorHandler("Keywords are not added correctly on google. " +
						"An Keyword '" + findAKeyword + "' is not found.");
			}
			if(gkws.length != numAllKeywords){
				//verify the num of Keywords get added
				SystemTestFunc.ErrorHandler("Not all Keywords in database are added to google. " +
						"Num of Keywords in database: " + numAllKeywords + ". Num of Ads added to google: " + gkws.length);
			}		
		}
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.MSN)){
			/* ***** For MSN ***** */
			
			System.out.println(">>> Verify result on MSN >>>");
			
			com.microsoft.adcenter.v8.Keyword[] mkws = msn.getKeywordByAdGroupId(SystemTestDataModel.msnAccountId, new Long(SystemTestDataModel.msnAdGroupId));
			System.out.println("Keywords that we put on MSN:");
			//verify content of the Keywords
			match = 0;
			for(com.microsoft.adcenter.v8.Keyword kw : mkws){
				System.out.println(" -" + kw.getText());
				if(kw.getText().equals(findAKeyword))
					match++;
			}		
			if(match != 1){
				SystemTestFunc.ErrorHandler("Keywords are not added correctly on MSN. " +
						"An Keyword '" + findAKeyword + "' is not found.");
			}
			if(mkws.length != numAllKeywords){
				//verify the num of Keywords get added
				SystemTestFunc.ErrorHandler("Not all Keywords in database are added to MSN. " +
						"Num of Keywords in database: " + numAllKeywords + ". Num of Ads added to MSN: " + mkws.length);
			}				
		}
	}
	private void verification_DeleteKeywords() throws Exception{
		Thread.sleep(sleepTime);
		
		//Verification
		System.out.println("Verify result...");
		int match = 0;
		String findAKeyword = SystemTestDataModel.keywords.get(0);
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.Google)){
			/* ***** For Google ***** */				
			System.out.println(">>> Verify result on Google >>>");
			
			String[] gkws = google.getAllAdGroupKeywords(SystemTestDataModel.googleAccountId, new Long(SystemTestDataModel.googleAdGroupId), true);
			System.out.println("Keywords that we have on google:");
			//verify content of the Keywords
			match = 0;				
			for(String kw : gkws){
				System.out.println(" -" + kw);
				if(kw.equals(findAKeyword))
					match++;
			}				
			if(match > 0){
				SystemTestFunc.ErrorHandler("Keywords are not completely deleted on google. " +
						"A Keyword '" + findAKeyword + "' is found, while it should have been deleted.");
			}
		}
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.MSN)){
			/* ***** For MSN ***** */				
			System.out.println(">>> Verify result on MSN >>>");
			
			com.microsoft.adcenter.v8.Keyword[] mkws = msn.getKeywordByAdGroupId(SystemTestDataModel.msnAccountId, new Long(SystemTestDataModel.msnAdGroupId));
			System.out.println("Keywords that we put on MSN:");
			//verify content of the Keywords
			match = 0;
			for(com.microsoft.adcenter.v8.Keyword kw : mkws){
				System.out.println(" -" + kw.getText());
				if(kw.getText().equals(findAKeyword))
					match++;
			}		
			if(match > 0){
				SystemTestFunc.ErrorHandler("Keywords are not completely deleted on MSN. " +
						"A Keyword '" + findAKeyword + "' is found, while it should have been deleted.");
			}			
		}
	}
	private void verification_UnpausePromotion() throws Exception{
		//Verification
		
		/* ***** For Google ***** */			
		System.out.println(">>> Verify result on Google >>>");
		ArrayList<HashMap<String, String>> ret = google.getCampaignsByAccountId(SystemTestDataModel.googleAccountId, false);
		for(HashMap<String, String> map : ret){
			if(map.get("Id").equals(SystemTestDataModel.googleCampaignId.toString())){
				String status = map.get("Status");
				System.out.println("Status of Campaign " + SystemTestDataModel.googleCampaignId + " is - " + status);
				if(!status.equals(CampaignStatus.ACTIVE.getValue())){
					SystemTestFunc.ErrorHandler("Campaign is not unpaused.");
				}
			}
		}
		
		/* ***** For MSN ***** */			
		System.out.println(">>> Verify result on MSN >>>");
		com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(SystemTestDataModel.msnAccountId, SystemTestDataModel.msnCampaignId);
		System.out.println("Status of Campaign " + SystemTestDataModel.msnCampaignId + " is - " + mcpn.getStatus());
		if(!mcpn.getStatus().equals(com.microsoft.adcenter.v8.CampaignStatus.Active)){
			SystemTestFunc.ErrorHandler("Campaign is not unpaused.");
		}
	}
	private void verification_PausePromotion() throws Exception{
		//Verification
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.Google)){
			/* ***** For Google ***** */			
			System.out.println(">>> Verify result on Google >>>");
			ArrayList<HashMap<String, String>> gcpn = google.getCampaignsByAccountId(SystemTestDataModel.googleAccountId, false);
			for(HashMap<String, String> map : gcpn){
				if(map.get("Id").equals(SystemTestDataModel.googleCampaignId.toString())){
					String status = map.get("Status");
					System.out.println("Status of Campaign " + SystemTestDataModel.googleCampaignId + " is - " + status);
					if(!status.equals(CampaignStatus.PAUSED.getValue())){
						SystemTestFunc.ErrorHandler("Campaign is not paused.");
					}
				}
			}
		}
		
		if(SystemTestDataModel.adEngineList.contains(AdEngine.MSN)){
			/* ***** For MSN ***** */			
			System.out.println(">>> Verify result on MSN >>>");
			com.microsoft.adcenter.v8.Campaign mcpn = msn.getCampaignById(SystemTestDataModel.msnAccountId, SystemTestDataModel.msnCampaignId);
			System.out.println("Status of Campaign " + SystemTestDataModel.msnCampaignId + " is - " + mcpn.getStatus().getValue());
			if(!mcpn.getStatus().equals(com.microsoft.adcenter.v8.CampaignStatus.Paused)){
				SystemTestFunc.ErrorHandler("Campaign is not paused.");
			}
		}
	}

	
	//Not sure how to test it
	@Override
	public Boolean ExecuteBidProcess(Integer PromotionID,
			List<AdEngine> adEngine) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	//unimplemented by adEngine service yet
	
	@Override
	public Boolean EndPromotion(Integer promotionID, List<AdEngine> adEngines)
			throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		
		SystemTestFunc.PrintMethodCall("EndPromotion(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList)");
		try{			
			ret = adEngineService.EndPromotion(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("EndPromotion failed.");
			return false;
		}
		else{
			//no further verification yet
		}
		
		Thread.sleep(sleepTime);
		return null;
	}
	@Override
	public Boolean DeletePromotion(Integer promotionID, List<AdEngine> adEngines)
			throws Exception {
		SystemTestFunc.PrintLineSeperator();	
		boolean ret = false;
		
		SystemTestFunc.PrintMethodCall("DeletePromotion(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList)");
		try{			
			ret = adEngineService.DeletePromotion(SystemTestDataModel.semplestPromotionId, SystemTestDataModel.adEngineList);
		}
		catch(Exception e){
			SystemTestFunc.ErrorHandler(e);
		}
		
		//Verification
		if(!ret){
			SystemTestFunc.ErrorHandler("DeletePromotion failed.");
			return false;
		}
		else{
			//no further verification yet
		}
		
		Thread.sleep(sleepTime);
		return null;
	}


	//Methods that don't need to be tested (non-scheduled version AddPromotionToAdEngine method and scheduled version of all the other methods)
	//Unused methods
	@Override
	public Boolean scheduleAddAds(Integer customerID, Integer promotionID,
			List<Integer> promotionAdIds, List<AdEngine> adEngines)
			throws Exception {		
		return null;
	}	
	@Override
	public Boolean scheduleDeleteAds(Integer customerID, Integer promotionID,
			List<Integer> promotionAdIds, List<AdEngine> adEngines)
			throws Exception {
		return null;
	}	
	@Override
	public Boolean scheduleUpdateAds(Integer customerID, Integer promotionID,
			List<Integer> promotionAdIds, List<AdEngine> adEngines)
			throws Exception {
		return null;
	}	
	@Override
	public Boolean scheduleUpdateGeoTargeting(Integer customerID,
			Integer promotionID, List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleChangePromotionStartDate(Integer customerID,
			Integer promotionID, Date newStartDate, List<AdEngine> adEngines)
			throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleUpdateBudget(Integer customerID,
			Integer promotionID, Double changeInBudget, List<AdEngine> adEngines)
			throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleUnpausePromotion(Integer customerID,
			Integer promotionID, List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleDeletePromotion(Integer customerID,
			Integer promotionID, List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleEndPromotion(Integer customerID,
			Integer promotionID, List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleRefreshSiteLinks(Integer customerID,
			Integer promotionID, List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public Boolean schedulePauseProductGroups(Integer customerID,
			List<Integer> productGroupIds, List<AdEngine> adEngines)
			throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleAddKeywords(Integer customerID, Integer promotionID,
			List<Integer> keywordIds, List<AdEngine> adEngines)
			throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleDeleteKeywords(Integer customerID,
			Integer promotionID, List<Integer> keywordIds,
			List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleAddNegativeKeywords(Integer customerID,
			Integer promotionID,
			List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs,
			List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public Boolean scheduleDeleteNegativeKeywords(Integer customerID,
			Integer promotionID, List<Integer> keywordIds,
			List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public Boolean schedulePausePromotion(Integer customerID,
			Integer promotionID, List<AdEngine> adEngines) throws Exception {
		return null;
	}
	@Override
	public KeywordToolStats[] getGoogleKeywordIdeas(List<String> keywords,
			int numberResults) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}	
	
	//Unrelated methods
	@Override
	public String checkStatus(String input1, String input2) throws Exception {
		return null;
	}
	@Override
	public void initializeService(String input) throws Exception {		
	}

	@Override
	public Boolean sendRegistrationReminderEmail(Integer userID) throws Exception
	{
		// S
		return null;
	}

	@Override
	public Boolean sendAccountActivationEmail(Integer userID) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> validateAccountActivationToken(String ecryptedToken)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
