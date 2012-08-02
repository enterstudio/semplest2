package semplest.services.client.api;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	//private static String BASEURLTEST = "http://VMDEVJAVA1:9898/semplest"; // VMJAVA1
	private static String BASEURLTEST = "http://VMJAVA1:9898/semplest"; // VMJAVA1
	private static String timeoutMS = "40000";
	private static Gson gson = new Gson();
	private static ProtocolJSON protocolJson = new ProtocolJSON();
	private static SimpleDateFormat MMDDYYYY = new SimpleDateFormat("MMddyyyy");
	private static final Logger logger = Logger.getLogger(SemplestChaseOrbitalGatewayServiceClient.class);
	private String baseurl;	
	
	public static void main(String[] args){
		try{
			String testServer = "http://VMJAVA1:9898/semplest";
			SemplestChaseOrbitalGatewayServiceClient test = new SemplestChaseOrbitalGatewayServiceClient(testServer);
			
			/*
			CustomerObject customer = new CustomerObject();
			customer.setName("Visa");
			customer.setCreditCardNumber("4112344112344113");
			customer.setAddress1("Apt 2");
			customer.setAddress2("1 Northeastern Blvd");
			customer.setCity("Bedford");
			customer.setStateAbbr("NH");
			customer.setZipCode("03109-1234");
			GatewayReturnObject ret = test.CreateProfile(customer);			
			
			System.out.println(ret.toStringPretty());
			*/
			
			//GatewayReturnObject ret = test.refundPayment("12878509", 10.00);
			/*
			Calendar cal = Calendar.getInstance();
			cal.set(2012, 9, 1);			
			GatewayReturnObject ret = test.UpdateProfileRecurringBilling("12878509", 10.00, cal.getTime());
			*/
			HashMap<String,String[]> Cards = new HashMap<String,String[]>();
			Cards.put("American Express", new String[]{"341134113411347","13008451","1234","530.00"});
			Cards.put("Discover", new String[]{"6559906559906557","13008459","613","304.00"});
			Cards.put("MasterCard", new String[]{"5112345112345114","13008469","123","402.00"});
			Cards.put("Visa", new String[]{"4112344112344113","13008473","411","999.00"});		
			
			/*
			System.out.println("---------- Refund Testing");			
			for(String cardName : Cards.keySet()){
				System.out.println("* " + cardName);
				
				String customerProfileRefNumber = Cards.get(cardName)[1];
				Double Amount = 10.00;
				
				GatewayReturnObject ret = test.refundPayment(customerProfileRefNumber, Amount);
				System.out.println("OrderID = " + ret.getOrderID());
				System.out.println("TxRefNum = " + ret.getTxRefNum());
			}
			*/
			
			CustomerObject customer = new CustomerObject();
			customer.setName("Visa");
			customer.setCreditCardNumber("4112344112344113");
			customer.setAddress1("Apt 2");
			customer.setAddress2("1 Northeastern Blvd");
			customer.setCity("Bedford");
			customer.setStateAbbr("NH");
			customer.setZipCode("03109-1234");
			GatewayReturnObject ret = test.CreateProfile(customer);
			System.out.println(ret.toStringPretty());
			
			Calendar cal = Calendar.getInstance();
			cal.set(2012, 9, 1);
			Date startDate = cal.getTime();
			GatewayReturnObject ret1 = test.UpdateProfileRecurringBilling(ret.getCustomerRefNum(), 100.00, startDate);
			
			System.out.println(ret1.toStringPretty());
			
			/*
			System.out.println("---------- Using Customer Profile Testing");			
			for(String cardName : Cards.keySet()){
				System.out.println("* " + cardName);
				
				String customerProfileRefNumber = Cards.get(cardName)[1];
				Double recurringAmount = 10.00;
				Calendar cal = Calendar.getInstance();
				cal.set(2012, 9, 1);
				Date startDate = cal.getTime();
				
				GatewayReturnObject ret = test.UpdateProfileRecurringBilling(customerProfileRefNumber, recurringAmount, startDate);
				System.out.println("CustomerRefNum = " + ret.getCustomerRefNum());
				System.out.println("AuthCode = " + ret.getAuthCode());
				System.out.println("OrderID = " + ret.getOrderID());
				System.out.println("TxRefNum = " + ret.getTxRefNum());
				System.out.println(ret.toString());
			}
			*/
			/*
			System.out.println("---------- Delete Customer Profile Testing");			
			for(String cardName : Cards.keySet()){
				System.out.println("* " + cardName);
				String CardNum = Cards.get(cardName)[0];
				
				CustomerObject customer = new CustomerObject();
				customer.setName(cardName);
				customer.setCreditCardNumber(CardNum);
				customer.setAddress1("Delete Test");
				customer.setCity("Boston");
				customer.setStateAbbr("MA");
				customer.setZipCode("02101");
				
				GatewayReturnObject ret = test.CreateProfile(customer);				
				String cusRefNum = ret.getCustomerRefNum();				
				ret = test.terminateRecurringPayments(new SemplestString(cusRefNum));
				
				System.out.println("CustomerRefNum = " + ret.getCustomerRefNum());
			}
			
			System.out.println("---------- Negative Testing Cases");			
			for(String cardName : Cards.keySet()){
				System.out.println("* " + cardName);
				
				String customerProfileRefNumber = Cards.get(cardName)[1];
				String cardSecVal = Cards.get(cardName)[2];
				Double Amount = Double.valueOf(Cards.get(cardName)[3]);
				
				GatewayReturnObject ret = test.AuthorizeAndCapture(customerProfileRefNumber, Amount, cardSecVal);
				System.out.println("ResponseCode = " + ret.getResponseCode());
				System.out.println("Message = " + ret.getMessage());
				System.out.println("OrderID = " + ret.getOrderID());
				System.out.println("TxRefNum = " + ret.getTxRefNum());
			}
			
			
			System.out.println("---------- Auth/Capture Testing");			
			for(String cardName : Cards.keySet()){
				System.out.println("* " + cardName);
				
				String customerProfileRefNumber = Cards.get(cardName)[1];
				String cardSecVal = Cards.get(cardName)[2];
				Double Amount = 10.00;
				
				GatewayReturnObject ret = test.AuthorizeAndCapture(customerProfileRefNumber, Amount, cardSecVal);
				System.out.println("Auth Code = " + ret.getAuthCode());
				System.out.println("OrderID = " + ret.getOrderID());
				System.out.println("TxRefNum = " + ret.getTxRefNum());
			}
			*/
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void initializeService(String input) throws Exception
	{
		logger.info("Doing nothing during initialization");
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
	public GatewayReturnObject AuthorizeAndCapture(String customerProfileRefNumber, Double Amount, String cardSecVal) throws Exception 
	{
		logger.info("Got request to authorize and capture for customerProfileRefNumber [" + customerProfileRefNumber + "], Amount [" + Amount + "], CardSecVal [" + cardSecVal + "]");
		final HashMap<String, String> jsonHash = new HashMap<String, String>();
		jsonHash.put("customerProfileRefNumber", customerProfileRefNumber);
		jsonHash.put("Amount", String.valueOf(Amount));
		jsonHash.put("cardSecVal", cardSecVal);
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
		final String customerProfileRefNumbersStr = customerProfileRefNumber.getSemplestString();	
		jsonHash.put("customerProfileRefNumber", customerProfileRefNumbersStr);
		final String json = protocolJson.createJSONHashmap(jsonHash);
		logger.info("Request JSON: [" + json + "]");
		final String returnData = runMethod(baseurl, SERVICEOFFERED, "CopyProfile", json, timeoutMS);
		logger.info("Response JSON returned from processing: [" + returnData + "]");
		final GatewayReturnObject gatewayReturnObject =  gson.fromJson(returnData, GatewayReturnObject.class);
		logger.info("GatewayReturnObject generated from the Final JSON: [" + gatewayReturnObject + "]");
		return gatewayReturnObject;
	}

	@Override
	public String checkStatus(String esbUrl, String timeout) throws Exception {
		HashMap<String, String> jsonHash = new HashMap<String, String>();		
		jsonHash.put("input", esbUrl);
		String json = protocolJson.createJSONHashmap(jsonHash);
		String ret = runMethod(esbUrl, SERVICEOFFERED, "checkStatus", json, timeout);
		return ret;
	}
}
