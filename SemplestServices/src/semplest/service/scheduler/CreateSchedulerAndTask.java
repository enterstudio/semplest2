package semplest.service.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.joda.time.DateTime;

import com.google.gson.Gson;
import com.microsoft.adcenter.v8.ReportAggregation;

import semplest.server.protocol.KeywordIdRemoveOppositePair;
import semplest.server.protocol.ProtocolEnum;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestSchedulerTaskObject;
import semplest.server.protocol.SemplestString;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.storedproc.AddScheduleJobSP;
import semplest.services.client.api.SemplestSchedulerServiceClient;
import semplest.util.SemplestUtils;

/*
 * Object contains all services that can be scheduled to run by scheduler
 */
public class CreateSchedulerAndTask
{
	
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static Gson gson = new Gson();
	
	public static SemplestSchedulerTaskObject getTestTask(String uniqueID)
	{
		SemplestSchedulerTaskObject taskObj = new SemplestSchedulerTaskObject();
		//Client service name to call from scheduler
		taskObj.setClientServiceName("semplest.services.client.test.TestService2Client");
		//method
		taskObj.setMethodName("TestMethod");		
		
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("uniqueID", uniqueID);		
		String json = protocolJson.createJSONHashmap(jsonHash);
		taskObj.setParameters(json);
		//
		return taskObj;
	}
	
	public static SemplestSchedulerTaskObject getSendMailTask(String subject, String from, String recipient, String msgTxt, String msgType)
	{
		SemplestSchedulerTaskObject taskObj = new SemplestSchedulerTaskObject();
		//Client service name to call from scheduler
		taskObj.setClientServiceName(ProtocolEnum.ClientServiceName.valueOf("Email").getClientServiceNameValue());
		//method
		taskObj.setMethodName("SendEmail");
		//json parameters
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("subject", subject);
		jsonHash.put("from", from);
		jsonHash.put("recipient", recipient);
		jsonHash.put("msgTxt", msgTxt);
		jsonHash.put("msgType", msgType);
		String json = protocolJson.createJSONHashmap(jsonHash);
		taskObj.setParameters(json);
		//
		return taskObj;
	}	
	
	public static SemplestSchedulerTaskObject getGoogleReportTask(SemplestString accountID)
	{
		SemplestSchedulerTaskObject taskObj = new SemplestSchedulerTaskObject();
		//Client service name to call from scheduler
		taskObj.setClientServiceName(ProtocolEnum.ClientServiceName.valueOf("GoogleReport").getClientServiceNameValue());
		//method
		taskObj.setMethodName("getReportForAccount");
		//json parameters
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountID", accountID.getSemplestString());
		String json = protocolJson.createJSONHashmap(jsonHash);
		taskObj.setParameters(json);
		//
		return taskObj;
	}
	
	public static SemplestSchedulerTaskObject getMsnReportTask(Long accountId, Long campaignId, DateTime firstDay, DateTime lastDay, ReportAggregation aggregation)
	{
		SemplestSchedulerTaskObject taskObj = new SemplestSchedulerTaskObject();
		//Client service name to call from scheduler
		taskObj.setClientServiceName(ProtocolEnum.ClientServiceName.valueOf("MsnReport").getClientServiceNameValue());
		//method
		taskObj.setMethodName("getKeywordReport");
		//json parameters
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("accountId", Long.toString(accountId));
		jsonHash.put("campaignId", Long.toString(campaignId));
		jsonHash.put("firstDay", gson.toJson(firstDay));
		jsonHash.put("lastDay", gson.toJson(lastDay));
		jsonHash.put("aggregation", gson.toJson(aggregation));
		String json = protocolJson.createJSONHashmap(jsonHash);
		taskObj.setParameters(json);
		//
		return taskObj;
	}
	
	public static SemplestSchedulerTaskObject createAddPromotionToAdEngineTask(Integer customerID, Integer productGroupID, Integer promotionID, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.AddPromotionToAdEngine.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("productGroupID",Integer.toString(productGroupID));
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject ExecuteBidProcess(Integer promotionID, List<AdEngine> adEngines)
	{
		SemplestSchedulerTaskObject taskObj = new SemplestSchedulerTaskObject();
		//Client service name to call from scheduler
		taskObj.setClientServiceName(ProtocolEnum.ClientServiceName.valueOf("ExecuteBidProcess").getClientServiceNameValue());
		//method
		taskObj.setMethodName("ExecuteBidProcess");
		//json parameters
		HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("promotionID",Integer.toString(promotionID));
		String adEngineListStr = gson.toJson(adEngines);
		jsonHash.put("adEngines",adEngineListStr);
		String json = protocolJson.createJSONHashmap(jsonHash);
		taskObj.setParameters(json);
		//
		return taskObj;
	}
	
	public static SemplestSchedulerTaskObject createChangePromotionStartDateTask(Integer customerID, Integer promotionID, Date newStartDate, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.ChangePromotionStartDate.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID",Integer.toString(promotionID));
		final String newStartDateString = SemplestUtils.DATE_FORMAT_YYYYMMDD.format(newStartDate);
		jsonHash.put("newStartDate", newStartDateString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
		
	public static SemplestSchedulerTaskObject createUpdateBudgetTask(Integer customerID, Integer promotionID, Double changeInBudget, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.UpdateBudget.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		jsonHash.put("changeInBudget", Double.toString(changeInBudget));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject createPausePromotionTask(Integer customerID, Integer promotionID, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.PausePromotion.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject createUnpausePromotionTask(Integer customerID, Integer promotionID, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.UnpausePromotion.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
		
	public static SemplestSchedulerTaskObject createPauseProductGroupTask(Integer customerID, List<Integer> productGroupIds, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.RefreshSiteLinksForAd.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		final String productGroupIdsString = gson.toJson(productGroupIds);		
		jsonHash.put("productGroupIds", productGroupIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}	
		
	public static SemplestSchedulerTaskObject createRefreshSiteLinksForAdTask(Integer customerID, Integer promotionID, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.RefreshSiteLinksForAd.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject createDeleteNegativeKeywordTask(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.DeleteKeyword.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));		
		final String keywordIdsString = gson.toJson(keywordIds, List.class);		
		jsonHash.put("keywordIds", keywordIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}	
	
	public static SemplestSchedulerTaskObject createDeleteKeywordTask(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.DeleteKeyword.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));		
		final String keywordIdsString = gson.toJson(keywordIds, List.class);		
		jsonHash.put("keywordIds", keywordIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}	
	
	public static SemplestSchedulerTaskObject createUpdateGeoTargetingTask(Integer customerID, Integer promotionID, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.UpdateGeoTargeting.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID",Integer.toString(customerID));
		jsonHash.put("promotionID",Integer.toString(promotionID));		
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines",adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject createUpdateAdsTask(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.UpdateAds.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String promotionAdIdsString = gson.toJson(promotionAdIds, List.class);		
		jsonHash.put("promotionAdIds", promotionAdIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject createAddNegativeKeywordsTask(Integer customerID, Integer promotionID, List<KeywordIdRemoveOppositePair> keywordIdRemoveOppositePairs, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.AddNegativeKeywords.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdRemoveOppositePairsString = gson.toJson(keywordIdRemoveOppositePairs, List.class);		
		jsonHash.put("keywordIdRemoveOppositePairs", keywordIdRemoveOppositePairsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject createAddKeywordsTask(Integer customerID, Integer promotionID, List<Integer> keywordIds, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.AddKeywords.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String keywordIdsString = gson.toJson(keywordIds, List.class);		
		jsonHash.put("keywordIds", keywordIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject createAddAdsTask(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines, String scheduleNamePostfix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.AddAds.getClientServiceNameValue());
		task.setMethodName(scheduleNamePostfix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String promotionAdIdsString = gson.toJson(promotionAdIds, List.class);		
		jsonHash.put("promotionAdIds", promotionAdIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	public static SemplestSchedulerTaskObject createDeleteAdEngineAdTask(Integer customerID, Integer promotionID, List<Integer> promotionAdIds, List<AdEngine> adEngines, String deleteAdPostFix)
	{
		final SemplestSchedulerTaskObject task = new SemplestSchedulerTaskObject();
		task.setClientServiceName(ProtocolEnum.ClientServiceName.DeleteAd.getClientServiceNameValue());
		task.setMethodName(deleteAdPostFix);
		final HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("customerID", Integer.toString(customerID));
		jsonHash.put("promotionID", Integer.toString(promotionID));
		final String promotionAdIdsString = gson.toJson(promotionAdIds, List.class);
		jsonHash.put("promotionAdIds", promotionAdIdsString);
		final String adEnginesStr = gson.toJson(adEngines, List.class);
		jsonHash.put("adEngines", adEnginesStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		task.setParameters(json);
		return task;
	}
	
	/*
	 * method creates a new schedule and associated the tasks, add a new job to the database and run it
	 * THIS NEEDS TO BE IN TRANACTION*******
	 */
	public static Boolean createScheduleAndRun(String ESBUrl, List<SemplestSchedulerTaskObject> tasks, String ScheduleName, Date StartTime, Date EndDate, String Frequency, boolean isEnabled, boolean isInactive, Integer PromotionID, 
			Integer CustomerID, Integer ProductGroupID, Integer UserID) throws Exception
	{
		if (tasks == null  || tasks.size() == 0)
		{
			throw new Exception ("No Tasks to Run for Schedule " + ScheduleName);
		}
			
		//create the schedule
		Integer scheduleID = SemplestDB.addSchedule(ScheduleName, StartTime, EndDate, Frequency, isEnabled, isInactive, PromotionID, CustomerID, ProductGroupID, UserID);
		if (scheduleID == null)
		{
			throw new Exception ("Unable to create Schedule " + ScheduleName);
		}
		AddScheduleJobSP addJob = new AddScheduleJobSP();
		SemplestDB.createTaskAndAssociateToSchedule(scheduleID, tasks);
		Integer jobID = addJob.execute(scheduleID, StartTime);
		if (jobID == null)
		{
			throw new Exception ("Unable to create job for Schedule " + ScheduleName + " scheduleID=" + scheduleID);
		}
		//run the schedule
		SemplestSchedulerServiceClient client = new SemplestSchedulerServiceClient(ESBUrl);
		Boolean res = client.NewSchedule(jobID,scheduleID, StartTime, false);
		return res;
	}

}
