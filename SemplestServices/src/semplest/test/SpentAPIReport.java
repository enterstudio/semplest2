package semplest.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.SemplestConfiguration;
import semplest.service.google.adwords.GoogleAdwordsServiceImpl;

public class SpentAPIReport {

	/**
	 * print a report of the API Units spent for a customer
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Long accountId = 2387614989L;
		
		/*
		 * Read in the Config Data from DB into HashMap<key, Object>
		 * SemplestConfiguation.configData
		 */
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		
		
		GoogleAdwordsServiceImpl google = new GoogleAdwordsServiceImpl();
		String serviceName;
		String methodName;
		Long methodUnits;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate = df.parse("06/16/2012");
		System.out.println(startDate);
		System.out.println(new Date());
		Long totalUnits = google.getSpentAPIUnitsPerAccountID(accountId, startDate, startDate);
		System.out.println("Total Units :"+totalUnits);
		
		//Method 1
		serviceName = "CampaignCriterionService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 1
		serviceName = "CampaignCriterionService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 2
		serviceName = "AdGroupCriterionService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 2
		serviceName = "AdGroupCriterionService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 3
		serviceName = "CampaignService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 3
		serviceName = "CampaignService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 4
		serviceName = "CampaignTargetService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 4
		serviceName = "CampaignTargetService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 5
		serviceName = "AdGroupService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 5
		serviceName = "AdGroupService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 6
		serviceName = "AdGroupAdService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 6
		serviceName = "AdGroupAdService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 7
		serviceName = "AdParamService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 7
		serviceName = "AdParamService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 8
		serviceName = "CampaignCriterionService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 8
		serviceName = "CampaignCriterionService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 9
		serviceName = "DataService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 9
		serviceName = "DataService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 10
		serviceName = "UserListService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 10
		serviceName = "UserListService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 11
		serviceName = "TrafficEstimatorService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 12
		serviceName = "TargetingIdeaService";
		methodName = "getBulkKeywordIdeas";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 12
		serviceName = "TargetingIdeaService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 13
		serviceName = "ReportDefinitionService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 13
		serviceName = "ReportDefinitionService";
		methodName = "getReportFields";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 14
		serviceName = "AlertService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 15
		serviceName = "CustomerSyncService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 16
		serviceName = "InfoService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 17
		serviceName = "ServicedAccountService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 18
		serviceName = "MutateJobService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
	
		//Method 18
		serviceName = "MutateJobService";
		methodName = "getResult";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 18
		serviceName = "MutateJobService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 19
		serviceName = "BulkMutateJobService";
		methodName = "mutate";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 19
		serviceName = "BulkMutateJobService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 20
		serviceName = "GeoLocationService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 21
		serviceName = "ConstantDataService";
		methodName = "getCarrierCriterion";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 21
		serviceName = "ConstantDataService";
		methodName = "getLanguageCriterion";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
		
		//Method 21
		serviceName = "LocationCriterionService";
		methodName = "get";
		methodUnits = google.getSpentAPIUnitsPerMethodAndAccountID(accountId, serviceName, methodName, startDate,  startDate);
		System.out.println("Total Units service("+serviceName+") method("+methodName +") : "+methodUnits);
	}

}
