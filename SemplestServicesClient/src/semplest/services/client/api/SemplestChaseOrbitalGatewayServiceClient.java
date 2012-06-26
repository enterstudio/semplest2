package semplest.services.client.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.protocol.SemplestString;
import semplest.server.protocol.TaskOutput;
import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;
import semplest.services.client.interfaces.ChaseOrbitalGatewayInterface;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.util.SemplestUtils;

import com.google.gson.Gson;

public class SemplestChaseOrbitalGatewayServiceClient extends ServiceRun implements ChaseOrbitalGatewayInterface, SchedulerTaskRunnerInterface
{
	private static String SERVICEOFFERED = "semplest.service.chaseorbitalgateway.ChaseOrbitalGatewayService";
	private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static Gson gson = new Gson();
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static SimpleDateFormat MMDDYYYY = new SimpleDateFormat("MMddyyyy");
	private static final Logger logger = Logger.getLogger(SemplestChaseOrbitalGatewayServiceClient.class);
	private String baseurl;	

	@Override
	public void initializeService(String input) throws Exception
	{
		// TODO Auto-generated method stub		
	}
	
	public SemplestChaseOrbitalGatewayServiceClient(String baseurl)
	{
		if (baseurl == null)
		{
			this.baseurl = BASEURLTEST;
		}
		else
		{
			this.baseurl = baseurl;
		}
	}

	@Override
	public TaskOutput RunTask(String method, String jsonParameters,String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception
	{
		if (optionalTimeoutMS == null)
		{
			optionalTimeoutMS = timeoutMS;
		}
		return RunTask(this.getClass(), baseurl, SERVICEOFFERED, method, jsonParameters,optionalTimeoutMS);
	}
		
	@Override
	public GatewayReturnObject CreateProfile(CustomerObject customerObject) throws Exception 
	{
		logger.info("Got request to create profile for Customer [" + customerObject + "]");
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		final String customerObjectJsonString = gson.toJson(customerObject);
		jsonHash.put("customerObject", customerObjectJsonString);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("Request JSON: [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "CreateProfile", json, timeoutMS);
		logger.info("Response JSON returned from processing: [" + returnData + "]");
		final GatewayReturnObject gatewayReturnObject =  gson.fromJson(returnData, GatewayReturnObject.class);
		logger.info("GatewayReturnObject generated from the Final JSON: [" + gatewayReturnObject + "]");
		return gatewayReturnObject;
	}

	@Override
	public GatewayReturnObject AuthorizeAndCapture(String customerProfileRefNumber, Double Amount) throws Exception 
	{
		logger.info("Got request to authorize and capture for customerProfileRefNumber [" + customerProfileRefNumber + "], Amount [" + Amount + "]");
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerProfileRefNumber", customerProfileRefNumber);
		jsonHash.put("Amount", String.valueOf(Amount));
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("Request JSON: [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "AuthorizeAndCapture", json, timeoutMS);
		logger.info("Response JSON returned from processing: [" + returnData + "]");
		final GatewayReturnObject gatewayReturnObject =  gson.fromJson(returnData, GatewayReturnObject.class);
		logger.info("GatewayReturnObject generated from the Final JSON: [" + gatewayReturnObject + "]");
		return gatewayReturnObject;
	}

	@Override
	public GatewayReturnObject UpdateProfileRecurringBilling(String customerProfileRefNumber, Double recurringAmount, Date startDate) throws Exception 
	{
		logger.info("Got request to update profile recurring billing for customerProfileRefNumber [" + customerProfileRefNumber + "], recurringAmount [" + recurringAmount + "], startDate [" + startDate + "]");		
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerProfileRefNumber", customerProfileRefNumber);
		jsonHash.put("recurringAmount", String.valueOf(recurringAmount));		
		jsonHash.put("startDate", MMDDYYYY.format(startDate));		
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("Request JSON: [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "UpdateProfileRecurringBilling", json, timeoutMS);
		logger.info("Response JSON returned from processing: [" + returnData + "]");
		final GatewayReturnObject gatewayReturnObject =  gson.fromJson(returnData, GatewayReturnObject.class);
		logger.info("GatewayReturnObject generated from the Final JSON: [" + gatewayReturnObject + "]");
		return gatewayReturnObject;
	}

	@Override
	public GatewayReturnObject terminateRecurringPayments(SemplestString customerProfileRefNumber) throws Exception 
	{
		logger.info("Got request to terminate recurring payments for customerProfileRefNumber [" + customerProfileRefNumber + "]");
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerProfileRefNumber", customerProfileRefNumber.getSemplestString());
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("Request JSON: [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "terminateRecurringPayments", json, timeoutMS);
		logger.info("Response JSON returned from processing: [" + returnData + "]");
		final GatewayReturnObject gatewayReturnObject =  gson.fromJson(returnData, GatewayReturnObject.class);
		logger.info("GatewayReturnObject generated from the Final JSON: [" + gatewayReturnObject + "]");
		return gatewayReturnObject;
	}

	@Override
	public GatewayReturnObject refundPayment(String customerProfileRefNumber, Double Amount) throws Exception 
	{
		logger.info("Got request to refund payment customerProfileRefNumber [" + customerProfileRefNumber + "], Amount [" + Amount + "]");
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerProfileRefNumber", customerProfileRefNumber);
		jsonHash.put("Amount", String.valueOf(Amount));
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("Request JSON: [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "refundPayment", json, timeoutMS);
		logger.info("Response JSON returned from processing: [" + returnData + "]");
		final GatewayReturnObject gatewayReturnObject =  gson.fromJson(returnData, GatewayReturnObject.class);
		logger.info("GatewayReturnObject generated from the Final JSON: [" + gatewayReturnObject + "]");
		return gatewayReturnObject;
	}

	@Override
	public List<CustomerObject> GetProfiles(List<String> customerProfileRefNumbers) throws Exception
	{
		logger.info("Got request to get profiles for CustomerProfileRefNumbers [" + customerProfileRefNumbers + "]");
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		final String customerProfileRefNumbersStr = gson.toJson(customerProfileRefNumbers, List.class);	
		jsonHash.put("customerProfileRefNumbers", customerProfileRefNumbersStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("Request JSON: [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "GetProfiles", json, timeoutMS);
		logger.info("Response JSON returned from processing: [" + returnData + "]");
		final List<CustomerObject> customers =  gson.fromJson(returnData, SemplestUtils.TYPE_LIST_OF_CUSTOMER_OBJECTS);
		logger.info("Customers generated from the Final JSON: [" + customers + "]");
		return customers;
	}

	@Override
	public GatewayReturnObject CopyProfile(SemplestString customerProfileRefNumber) throws Exception
	{
		logger.info("Got request to copy profile for CustomerProfileRefNumber [" + customerProfileRefNumber + "]");
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		final String customerProfileRefNumbersStr = gson.toJson(customerProfileRefNumber, List.class);	
		jsonHash.put("customerProfileRefNumber", customerProfileRefNumbersStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("Request JSON: [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "CopyProfile", json, timeoutMS);
		logger.info("Response JSON returned from processing: [" + returnData + "]");
		final GatewayReturnObject gatewayReturnObject =  gson.fromJson(returnData, GatewayReturnObject.class);
		logger.info("GatewayReturnObject generated from the Final JSON: [" + gatewayReturnObject + "]");
		return gatewayReturnObject;
	}

}
