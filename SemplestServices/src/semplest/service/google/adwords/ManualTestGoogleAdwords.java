package semplest.service.google.adwords;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.description.FieldDesc;

import com.google.api.adwords.lib.AdWordsService;
import com.google.api.adwords.lib.AdWordsUser;
import com.google.api.adwords.v201109.cm.AdGroupServiceInterface;
import com.google.api.adwords.v201109.cm.Address;
import com.google.api.adwords.v201109.cm.ApiException;
import com.google.api.adwords.v201109.cm.CampaignCriterion;
import com.google.api.adwords.v201109.cm.CampaignCriterionOperation;
import com.google.api.adwords.v201109.cm.CampaignCriterionPage;
import com.google.api.adwords.v201109.cm.CampaignCriterionServiceInterface;
import com.google.api.adwords.v201109.cm.CampaignOperation;
import com.google.api.adwords.v201109.cm.CampaignServiceInterface;
import com.google.api.adwords.v201109.cm.CampaignTargetPage;
import com.google.api.adwords.v201109.cm.CampaignTargetSelector;
import com.google.api.adwords.v201109.cm.CampaignTargetServiceInterface;
import com.google.api.adwords.v201109.cm.Criterion;
import com.google.api.adwords.v201109.cm.CriterionType;
import com.google.api.adwords.v201109.cm.GeoLocation;
import com.google.api.adwords.v201109.cm.GeoLocationSelector;
import com.google.api.adwords.v201109.cm.GeoLocationServiceInterface;
import com.google.api.adwords.v201109.cm.GeoPoint;
import com.google.api.adwords.v201109.cm.Location;
import com.google.api.adwords.v201109.cm.Operator;
import com.google.api.adwords.v201109.cm.Predicate;
import com.google.api.adwords.v201109.cm.PredicateOperator;
import com.google.api.adwords.v201109.cm.Proximity;
import com.google.api.adwords.v201109.cm.ProximityDistanceUnits;
import com.google.api.adwords.v201109.cm.Selector;
import com.google.api.adwords.v201109.cm.Setting;
import com.google.api.adwords.v201109.cm.TargetList;

public class ManualTestGoogleAdwords
{
	public static void main(String[] args) throws Exception
	{
		final String email = "adwords@semplest.com";
		//final String password = "7ylZJTlhuCG4loTC6Qllrw==";
		final String password = "ic0system";		
		final String userAgent = "Icosystem";
		final String developerToken = "2H8l6aUm6K_Q44vDvxs3Og";
		final boolean useSandbox = true;
		
		final String accountId = "54101";
		//final String accountId = "54100"; // Mark's Sports
		final Long campaignId = 647605L;
		
		final AdWordsUser user = new AdWordsUser(email, password, accountId, userAgent, developerToken, useSandbox);
		/*
		final GeoLocationServiceInterface geoLocationService = user.getService(AdWordsService.V201109.GEO_LOCATION_SERVICE);
		final GeoLocationSelector selector = new GeoLocationSelector(new Address[]{});
		final GeoLocation[] geoLocations = geoLocationService.get(selector);
		System.out.println(geoLocations.length);
		*/
		/*
		final CampaignTargetServiceInterface campaignTargetService = user.getService(AdWordsService.V201109.CAMPAIGN_TARGET_SERVICE);
		final CampaignTargetSelector sel = new CampaignTargetSelector();
		final CampaignTargetPage page = campaignTargetService.get(sel);
		final TargetList[] targetListArray = page.getEntries();
		for (int i = 0; i < targetListArray.length; ++i)
		{
			final TargetList tl = targetListArray[i];
			System.out.println(tl.getCampaignId() + ", " + tl.getTargetListType());
		}*/
		
		final Campaign c = new Campaign(accountId, campaignId, user);
		final String[] locations = c.getGeoLocs();
		for (int i = 0; i < locations.length; ++i)
		{
			System.out.println(i + "->   " + locations[i]);
		}
		System.out.println("===============");
		/*
		final Selector s = new Selector();
		final String[] fields = {"Id","CampaignId","LocationName","DisplayType","RadiusInUnits","GeoPoint","Address"};
	    s.setFields(fields);
//	    final Predicate cp = new Predicate("CampaignId", PredicateOperator.EQUALS, new String[]{"" + campaignId});
	    s.setPredicates(new Predicate[]{cp});
				
		final CampaignCriterionServiceInterface campaignCriterionService = user.getService(AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE);
		
		final CampaignCriterionPage page = campaignCriterionService.get(s);
		final CampaignCriterion[] campaignCriterion = page.getEntries();
		for (int i = 0; i < campaignCriterion.length; ++i)
		{
			final CampaignCriterion campaignCriteria = campaignCriterion[i];
			System.out.println(campaignCriteria.getCampaignId() + " " + campaignCriteria.getCampaignCriterionType());
			
			final Criterion criterion = campaignCriteria.getCriterion();			
			System.out.println(criterion.getId() + " " + criterion.getType() + " " + criterion.getCriterionType());
		}
		*/
	    final GeoLocationServiceInterface geoLocationService = user.getService(AdWordsService.V201109.GEO_LOCATION_SERVICE);
	    //final Address address = new Address("1916 East 9th Street", "Apt 2R", "Brooklyn", "US-NY", "New York", "11223", "US");
	    final Address address = new Address("195 Broadway", "Floor 24", "New York", "US-NY", "New York", "10007", "US");
	    final Address address2 = new Address("2827 Brown Street", "Apt 3B", "Brooklyn", "US-NY", "New York", "11235", "US");
	    final Address address3 = new Address("2829 Haring Street", "Apt 7", "Brooklyn", "US-NY", "New York", "11235", "US");
	    final GeoLocationSelector geoLocationSelector = new GeoLocationSelector(new Address[] {address, address2});
	    final GeoLocation[] geoLocations = geoLocationService.get(geoLocationSelector);
	    /*for (int i = 0; i < geoLocations.length; ++i)
	    {
	    	final GeoLocation geoLocation = geoLocations[i];
	    	final GeoPoint geoPoint = geoLocation.getGeoPoint();
	    	System.out.println(geoLocation.getGeoLocationType() + " " + geoPoint.getLatitudeInMicroDegrees() + " " + geoPoint.getLongitudeInMicroDegrees());
	    }
	    System.out.println("===============");
	    
	    System.out.println(">>>>>>>>>>>>>>>.");
	    final FieldDesc[] fieldsDescriptions = Predicate.getTypeDesc().getFields();
	    for (int i = 0; i < fieldsDescriptions.length; ++i)
	    {
	    	final FieldDesc fieldDescription = fieldsDescriptions[i];
	    	System.out.println(fieldDescription.getFieldName() + " " + fieldDescription.getJavaType() + " " + fieldDescription.toString());
	    }
	    System.out.println(">>>>>>>>>>>>>>>.");*/
	    
	    final CampaignCriterionServiceInterface campaignCriterionService = user.getService(AdWordsService.V201109.CAMPAIGN_CRITERION_SERVICE);
	    final Selector selector = new Selector();
	    selector.setFields(new String[] {"Id", "CampaignId", "CriteriaType", "GeoPoint", "RadiusDistanceUnits", "RadiusInUnits", "Address"});
	    final Predicate cp = new Predicate("CampaignId", PredicateOperator.EQUALS, new String[]{"" + campaignId});
	    selector.setPredicates(new Predicate[]{cp});
	    final CampaignCriterionPage page = campaignCriterionService.get(selector);
	    System.out.println("EXISTING criterions...");
	    System.out.println("Page Type: " + page.getPageType());
	    final CampaignCriterion[] campaignCriterion = page.getEntries();
	    final List<Long> existingProximityIds = new ArrayList<Long>();
	    
	    for (int i = 0; i < campaignCriterion.length; ++i)
		{
			final CampaignCriterion campaignCriteria = campaignCriterion[i];
			final Criterion criterion = campaignCriteria.getCriterion();			
			System.out.println(campaignCriteria.getCampaignId() + " " + campaignCriteria.getCampaignCriterionType() + " || " + criterion.getId() + " " + criterion.getType() + " " + criterion.getCriterionType());
			if (criterion.getType() == CriterionType.PROXIMITY)
			{
				existingProximityIds.add(criterion.getId());
			}
		}
	    System.out.println("Proximities: " + existingProximityIds);
	    System.out.println("===============");
	    
	    final GeoLocation geoLocation = geoLocations[0];
	    final GeoPoint geoPoint = geoLocation.getGeoPoint();
	    final Proximity proximity = new Proximity();
		proximity.setAddress(address3);
		proximity.setRadiusDistanceUnits(ProximityDistanceUnits.MILES);
		proximity.setRadiusInUnits(10D);
		proximity.setGeoPoint(geoPoint);
		final GeoLocation geoLocation2 = geoLocations[1];
		final GeoPoint geoPoint2 = geoLocation2.getGeoPoint();
		final Proximity proximity2 = new Proximity();
		proximity2.setAddress(address2);
		proximity2.setRadiusDistanceUnits(ProximityDistanceUnits.MILES);
		proximity2.setRadiusInUnits(15D);
		proximity2.setGeoPoint(geoPoint2);
		
		final List<CampaignCriterionOperation> removeOperations = new ArrayList<CampaignCriterionOperation>();
		for (final Long proximityId : existingProximityIds)
		{
			final Criterion criterionRemove = new Criterion();
			criterionRemove.setId(proximityId);
			criterionRemove.setType(CriterionType.PROXIMITY);
			final CampaignCriterion ccRemove = new CampaignCriterion();
			ccRemove.setCampaignId(campaignId);
			ccRemove.setCriterion(criterionRemove);
			final CampaignCriterionOperation operationRemove = new CampaignCriterionOperation();
			operationRemove.setOperand(ccRemove);
			operationRemove.setOperator(Operator.REMOVE);
			removeOperations.add(operationRemove);
		}
		
		final CampaignCriterion cc = new CampaignCriterion();
		cc.setCampaignId(campaignId);
		cc.setCriterion(proximity);	
		final CampaignCriterion cc2 = new CampaignCriterion();
		cc2.setCampaignId(campaignId);
		cc2.setCriterion(proximity2);
		final CampaignCriterionOperation operation = new CampaignCriterionOperation();
		operation.setOperand(cc);
		operation.setOperator(Operator.ADD);
		//operation.setOperator(Operator.SET);
		final CampaignCriterionOperation operation2 = new CampaignCriterionOperation();
		operation2.setOperand(cc2);
		operation2.setOperator(Operator.ADD);		
		//final CampaignCriterion[] rs = campaignCriterionService.mutate(new CampaignCriterionOperation[]{operation, operation2}).getValue();
		final CampaignCriterion[] rs = campaignCriterionService.mutate(new CampaignCriterionOperation[]{operation}).getValue();
		//final CampaignCriterion[] rs = campaignCriterionService.mutate(removeOperations.toArray(new CampaignCriterionOperation[removeOperations.size()])).getValue();		
		for (int i = 0; i < rs.length; ++i)
		{
			final CampaignCriterion resultCriterion = rs[i];			
			final Criterion criterion = resultCriterion.getCriterion();
			System.out.println(resultCriterion.getCampaignId() + " " + resultCriterion.getCampaignCriterionType() + " | " + criterion.getId() + " " + criterion.getType() + " " + criterion.getCriterionType());
		}		
		System.out.println("===============");
		
		/*
		final com.google.api.adwords.v201109.cm.Campaign campaign = new com.google.api.adwords.v201109.cm.Campaign();
	    campaign.setId(647605L);
	    Setting.getTypeDesc().

	    final CampaignOperation operation = new CampaignOperation();
	    operation.setOperand(campaign);
	    operation.setOperator(Operator.REMOVE);
	    
		campaignService.
		*/
	}
}
