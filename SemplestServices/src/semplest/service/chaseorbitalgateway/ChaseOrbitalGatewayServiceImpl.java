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

public class ChaseOrbitalGatewayServiceImpl implements ChaseOrbitalGatewayInterface
{
	public static ChaseOrbitalGatewayObject gatewayObj = null;
	private static final Logger logger = Logger.getLogger(ChaseOrbitalGatewayServiceImpl.class);

	@Override
	public void initializeService(String input) throws Exception
	{
		/*
		 * Read in the Config Data from DB into HashMap<key, Object> SemplestConfiguation.configData
		 */
		SemplestConfiguration configDB = new SemplestConfiguration();
		Thread configThread = new Thread(configDB);
		configThread.start();
		/*
		 * Initialize gateway
		 */
		gatewayObj = new ChaseOrbitalGatewayObject();
		gatewayObj.start();
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

			request.setFieldValue("CustomerBin", gatewayObj.SALEM_PLATFORM);
			request.setFieldValue("CustomerMerchantID", gatewayObj.MERCHANTID_TEST);
			//Customer Info
			request.setFieldValue("CustomerName", customerObject.getFirstName() + " " + customerObject.getLastName());
			request.setFieldValue("CustomerAddress1", customerObject.getAddress1());
			if (customerObject.getAddress2() != null && customerObject.getAddress2().trim().length()  > 0)
			{
				request.setFieldValue("CustomerAddress2", customerObject.getAddress2());
			}
			request.setFieldValue("CustomerCity", customerObject.getCity());
			request.setFieldValue("CustomerState", customerObject.getStateAbbr());
			request.setFieldValue("CustomerZIP", customerObject.getZipCode());
			request.setFieldValue("CustomerEmail", customerObject.getEmail());
			request.setFieldValue("CustomerPhone", customerObject.getPhone());
			//Create
			request.setFieldValue("CustomerProfileAction", "C");
			request.setFieldValue("CustomerProfileOrderOverrideInd", "NO");
			//Auto return profileID
			request.setFieldValue("CustomerProfileFromOrderInd", "A");
			request.setFieldValue("OrderDefaultDescription", "Profile Create");
			
			request.setFieldValue("CustomerAccountType", "CC");
			request.setFieldValue("CCAccountNum", creditCardNumber);
			request.setFieldValue("CCExpireDate", ExpireDateMMYY);

			// Display the request
			logger.debug("\nProfile Request:\n" + request.getXML());
		}
		catch (InitializationException ie)
		{
			logger.error("Unable to initialize request object");
			logger.error(ie.getMessage());
			ie.printStackTrace();
			throw new Exception("Unable to initialize request object" + ":" + ie.getMessage());
		}
		catch (FieldNotFoundException fnfe)
		{
			logger.error("Unable to find XML field in template");
			logger.error(fnfe.getMessage());
			fnfe.printStackTrace();
			throw new Exception("Unable to find XML field in template" + ":" + fnfe.getMessage());

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw ex;

		}

		//run request
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

		//profile specific
		ret.setCustomerRefNum(response.getValue("CustomerRefNum"));
		return ret;
	}

}
