package semplest.service.chaseorbitalgateway;

import org.apache.log4j.Logger;

import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;
import semplest.server.service.SemplestConfiguration;
import semplest.services.client.interfaces.ChaseOrbitalGatewayInterface;

import com.paymentech.orbital.sdk.interfaces.RequestIF;
import com.paymentech.orbital.sdk.interfaces.ResponseIF;
import com.paymentech.orbital.sdk.request.FieldNotFoundException;
import com.paymentech.orbital.sdk.request.Request;
import com.paymentech.orbital.sdk.transactionProcessor.TransactionException;
import com.paymentech.orbital.sdk.util.exceptions.InitializationException;

/*
 * Instructions for Processing
 * 
 * Note: Each Campaign is charged a stream of payments billed on a periodic cycle.  Each orbital profile can represent one credit card with a stream of payments.
 * 
 * 1.  Create a profile (or copy a profile by retrieving a profile (including full CC #)
 * 2.  Authenticate and Capture a charge
 * 3.  Update profile - set recurring billing on profile
 * 
 *     To Cancel: Update profile with end date or delete profile 
 *  4. Refund - Send New Order request    
 */
public class ChaseOrbitalGatewayServiceImpl implements ChaseOrbitalGatewayInterface
{
	public static ChaseOrbitalGatewayObject gatewayObj = null;
	private static final Logger logger = Logger.getLogger(ChaseOrbitalGatewayServiceImpl.class);

	public static void main(String[] args)
	{

	}

	@Override
	public void initializeService(String input) throws Exception
	{
		/*
		 * Read in the Config Data from DB into HashMap<key, Object>
		 * SemplestConfiguation.configData
		 */
		Object object = new Object();
		SemplestConfiguration configDB = new SemplestConfiguration(object);
		Thread configThread = new Thread(configDB);
		configThread.start();
		synchronized (object)
		{
			object.wait();
		}
		/*
		 * Initialize gateway
		 */
		Object object2 = new Object();
		gatewayObj = new ChaseOrbitalGatewayObject(object2);
		gatewayObj.start();
		synchronized (object2)
		{
			object2.wait();
		}
		logger.info("Initialized Chase Orbital Gateway");
	}

	@Override
	public GatewayReturnObject CreateProfile(CustomerObject customerObject, String creditCardNumber, String ExpireDateMMYY) throws Exception
	{
		RequestIF request = null;
		try
		{
			request = new Request(RequestIF.PROFILE_TRANSACTION);

			// the follow will create a profile that can be used in
			// future transactions (using the CustomerRefNum)
			request.setFieldValue("OrbitalConnectionUsername", ChaseOrbitalGatewayObject.ORBITAL_USERNAME);
			request.setFieldValue("OrbitalConnectionPassword", gatewayObj.getAes().decrypt(ChaseOrbitalGatewayObject.ORBITAL_PASSWORD));
			request.setFieldValue("CustomerBin", ChaseOrbitalGatewayObject.SALEM_PLATFORM);
			request.setFieldValue("CustomerMerchantID", ChaseOrbitalGatewayObject.MERCHANTID);
			// Customer Info
			request.setFieldValue("CustomerName", customerObject.getFirstName() + " " + customerObject.getLastName());
			request.setFieldValue("CustomerAddress1", customerObject.getAddress1());
			if (customerObject.getAddress2() != null && customerObject.getAddress2().trim().length() > 0)
			{
				request.setFieldValue("CustomerAddress2", customerObject.getAddress2());
			}
			request.setFieldValue("CustomerCity", customerObject.getCity());
			request.setFieldValue("CustomerState", customerObject.getStateAbbr());
			request.setFieldValue("CustomerZIP", customerObject.getZipCode());
			request.setFieldValue("CustomerEmail", customerObject.getEmail());
			request.setFieldValue("CustomerPhone", customerObject.getPhone());
			// Create
			request.setFieldValue("CustomerProfileAction", "C");
			request.setFieldValue("CustomerProfileOrderOverrideInd", "NO");
			// Auto return profileID
			request.setFieldValue("CustomerProfileFromOrderInd", "A");
			request.setFieldValue("OrderDefaultDescription", "Profile Create");
			//Account type credit card
			request.setFieldValue("CustomerAccountType", "CC");
			request.setFieldValue("CCAccountNum", creditCardNumber);
			request.setFieldValue("CCExpireDate", ExpireDateMMYY);
			
			request.setFieldValue("SDMerchantName", ChaseOrbitalGatewayObject.MerchantName);

			// Display the request
			logger.debug("\nProfile Request:\n" + request.getXML());
		}
		catch (InitializationException ie)
		{
			logger.error("Unable to initialize request object " + ie.getMessage());
			ie.printStackTrace();
			throw new Exception("Unable to initialize request object" + ":" + ie.getMessage());
		}
		catch (FieldNotFoundException fnfe)
		{
			logger.error("Unable to find XML field in template " + fnfe.getMessage());
			fnfe.printStackTrace();
			throw new Exception("Unable to find XML field in template" + ":" + fnfe.getMessage());

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw ex;

		}

		// run request
		ResponseIF response = null;
		try
		{
			response = gatewayObj.getTransactionProcessor().process(request);
		}
		catch (TransactionException tex)
		{
			logger.error("Transaction failed, including retries and failover " + tex.getMessage());
			tex.printStackTrace();
			throw new Exception("Transaction failed, including retries and failover" + ":" + tex.getMessage());
		}

		GatewayReturnObject ret = new GatewayReturnObject();
		// Display the response
		// This line displays the entire xml response on the java system
		// console.
		ret.setXmlReturn(response.toXmlString());
		ret.setIsGood(response.isGood());
		ret.setIsError(response.isError());
		ret.setIsQuickResponse(response.isQuickResponse());
		ret.setIsApproved(response.isApproved());
		ret.setIsDeclined(response.isDeclined());
		ret.setAuthCode(response.getAuthCode());
		ret.setTxRefNum(response.getTxRefNum());
		ret.setResponseCode(response.getResponseCode());
		ret.setStatus(response.getStatus());
		ret.setMessage(response.getMessage());
		ret.setAVSCode(response.getAVSResponseCode());
		ret.setCVV2ResponseCode(response.getCVV2RespCode());

		// profile specific
		ret.setCustomerRefNum(response.getValue("CustomerRefNum"));
		return ret;
	}

	@Override
	public GatewayReturnObject AuthorizeAndCapture(String customerProfileRefNumber, Double Amount) throws Exception
	{
		// Create a request object
		// The request object uses the XML templates along with data we provide
		// to generate a String representation of the xml request
		RequestIF request = null;
		try
		{
			// Tell the request object which template to use (see
			// RequestIF.java)
			request = new Request(RequestIF.NEW_ORDER_TRANSACTION);
			// Basic Information
			request.setFieldValue("OrbitalConnectionUsername", ChaseOrbitalGatewayObject.ORBITAL_USERNAME);
			request.setFieldValue("OrbitalConnectionPassword", gatewayObj.getAes().decrypt(ChaseOrbitalGatewayObject.ORBITAL_PASSWORD));
			request.setFieldValue("IndustryType", "EC"); //eCommerce transaction
			request.setFieldValue("MessageType", "AC"); //Authorize and mark for capture
			request.setFieldValue("BIN", ChaseOrbitalGatewayObject.SALEM_PLATFORM);
			request.setFieldValue("MerchantID", ChaseOrbitalGatewayObject.MERCHANTID);
			
			//Use Profile Data
			request.setFieldValue("CustomerRefNum", customerProfileRefNumber);
			//Generate random orderID
			String orderID = generateRandomOrderID(ChaseOrbitalGatewayObject.ORDERIDSTRING, ChaseOrbitalGatewayObject.ORDERIDLENGTH);
			request.setFieldValue("OrderID", orderID);
			Integer amountImpliedDecimal = (new Double(Amount*100.0)).intValue();
			request.setFieldValue("Amount", String.valueOf(amountImpliedDecimal));

			// Display the request
			logger.info("Request profile=" + customerProfileRefNumber+ " orderID=" + orderID + " : Amount (No decimal)=" + amountImpliedDecimal);
			logger.info("\nAuth with Capture Request:\n" + request.getXML());
		}
		catch (InitializationException ie)
		{

			logger.error(ie.getMessage());
			ie.printStackTrace();
			throw new Exception("Unable to initialize request object: " + ie.getMessage());
		}
		catch (FieldNotFoundException fnfe)
		{

			logger.error(fnfe.getMessage());
			fnfe.printStackTrace();
			throw new Exception("Unable to find XML field in template " + fnfe.getMessage());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		//Process Transaction
		ResponseIF response = null;
		try
		{
			response = gatewayObj.getTransactionProcessor().process(request);
		}
		catch (TransactionException tex)
		{

			logger.error(tex.getMessage());
			tex.printStackTrace();
			throw new Exception("Transaction failed, including retries and failover " + tex.getMessage());
		}
		GatewayReturnObject ret = new GatewayReturnObject();
		// This line displays the entire xml response on the java system
		// console.
		ret.setXmlReturn(response.toXmlString());
		ret.setIsGood(response.isGood());
		ret.setIsError(response.isError());
		ret.setIsQuickResponse(response.isQuickResponse());
		ret.setIsApproved(response.isApproved());
		ret.setIsDeclined(response.isDeclined());
		ret.setAuthCode(response.getAuthCode());
		ret.setTxRefNum(response.getTxRefNum());
		ret.setResponseCode(response.getResponseCode());
		ret.setStatus(response.getStatus());
		ret.setMessage(response.getMessage());
		ret.setAVSCode(response.getAVSResponseCode());
		ret.setCVV2ResponseCode(response.getCVV2RespCode());
		//New Order Specific fields
		ret.setOrderID(response.getValue("OrderID"));
		ret.setAmountRequestedNoDecimal(response.getValue("RequestedAmount"));
		ret.setAmountRedeemedNoDecimal(response.getValue("RedeemedAmount"));
		ret.setRemainingBalanceNoDecimal(response.getValue("RemainingBalance"));

		return ret;
	}
	
	/*
	 * return a random string of length returnLength
	 */
	private static String generateRandomOrderID(String charString, int returnLength)
	{
		String random = "";
		for (int j = 0; j < returnLength; j++)
		{
			random += charString.charAt((int) (Math.random() * charString.length()));
		}
		return random;
	}

	@Override
	public GatewayReturnObject UpdateProfileRecurringBilling(String customerProfileRefNumber, Double recurringAmount, java.util.Date startDate) throws Exception
	{
		RequestIF request = null;
		try
		{
			String startingDate = ChaseOrbitalGatewayObject.MMDDYYYY.format(startDate);
			String dayOfMonth =  recurringDayOfMonth(startDate);
			
			request = new Request(RequestIF.PROFILE_TRANSACTION);

			// the follow will create a profile that can be used in
			// future transactions (using the CustomerRefNum)
			request.setFieldValue("OrbitalConnectionUsername", ChaseOrbitalGatewayObject.ORBITAL_USERNAME);
			request.setFieldValue("OrbitalConnectionPassword", gatewayObj.getAes().decrypt(ChaseOrbitalGatewayObject.ORBITAL_PASSWORD));
			request.setFieldValue("CustomerBin", ChaseOrbitalGatewayObject.SALEM_PLATFORM);
			request.setFieldValue("CustomerMerchantID", ChaseOrbitalGatewayObject.MERCHANTID);
			// Update profile using CustomerRefNum
			request.setFieldValue("CustomerProfileAction", "U");
			request.setFieldValue("CustomerProfileFromOrderInd", "S"); //use Profile CustomerRefNum
			request.setFieldValue("CustomerRefNum", customerProfileRefNumber);
			request.setFieldValue("OrderDefaultDescription", "Profile Update");

			//Managed Billing
			request.setFieldValue("MBType", "R"); //Recurring
			request.setFieldValue("MBOrderIDGenerationMethod", "DI"); //Dynamically generate orderID
			request.setFieldValue("MBOrderRecurringStartDate", startingDate);
			request.setFieldValue("MBRecurringFrequency", dayOfMonth + " * ?");  //Bill Monthly
			// Display the request
			logger.debug("\nProfile Request:\n" + request.getXML());
		}
		catch (InitializationException ie)
		{
			logger.error("Unable to initialize request object " + ie.getMessage());
			ie.printStackTrace();
			throw new Exception("Unable to initialize request object" + ":" + ie.getMessage());
		}
		catch (FieldNotFoundException fnfe)
		{
			logger.error("Unable to find XML field in template " + fnfe.getMessage());
			fnfe.printStackTrace();
			throw new Exception("Unable to find XML field in template" + ":" + fnfe.getMessage());

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw ex;

		}

		// run request
		ResponseIF response = null;
		try
		{
			response = gatewayObj.getTransactionProcessor().process(request);
		}
		catch (TransactionException tex)
		{
			logger.error("Transaction failed, including retries and failover");
			logger.error(tex.getMessage());
			tex.printStackTrace();
			throw new Exception("Transaction failed, including retries and failover" + ":" + tex.getMessage());
		}

		GatewayReturnObject ret = new GatewayReturnObject();
		// Display the response
		// This line displays the entire xml response on the java system
		// console.
		ret.setXmlReturn(response.toXmlString());
		ret.setIsGood(response.isGood());
		ret.setIsError(response.isError());
		ret.setIsQuickResponse(response.isQuickResponse());
		ret.setIsApproved(response.isApproved());
		ret.setIsDeclined(response.isDeclined());
		ret.setAuthCode(response.getAuthCode());
		ret.setTxRefNum(response.getTxRefNum());
		ret.setResponseCode(response.getResponseCode());
		ret.setStatus(response.getStatus());
		ret.setMessage(response.getMessage());
		ret.setAVSCode(response.getAVSResponseCode());
		ret.setCVV2ResponseCode(response.getCVV2RespCode());

		// profile specific
		ret.setCustomerRefNum(response.getValue("CustomerRefNum"));
		return ret;
	}
	/*
	 * this needs to be fixed
	 */
	private String recurringDayOfMonth(java.util.Date startDate)
	{
		int day = startDate.getDay();

		return String.valueOf(day);
		
	}

	@Override
	public GatewayReturnObject terminatePayment(String customerProfileRefNumber) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GatewayReturnObject refundPayment(String customerProfileRefNumber, Double Amount) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
