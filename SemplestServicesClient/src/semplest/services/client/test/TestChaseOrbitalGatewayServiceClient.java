package semplest.services.client.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import semplest.server.protocol.SemplestString;
import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;
import semplest.services.client.api.SemplestChaseOrbitalGatewayServiceClient;
import semplest.services.client.api.ServiceRun;

public class TestChaseOrbitalGatewayServiceClient extends ServiceRun
{
	private static final Logger logger = Logger.getLogger(TestChaseOrbitalGatewayServiceClient.class);
	
	private SemplestChaseOrbitalGatewayServiceClient client;
	
	public TestChaseOrbitalGatewayServiceClient()
	{
		client = new SemplestChaseOrbitalGatewayServiceClient(null);
	}
	
	public static void main(String[] args) throws Exception
	{
		BasicConfigurator.configure();
		final TestChaseOrbitalGatewayServiceClient testClient = new TestChaseOrbitalGatewayServiceClient();		
		final GatewayReturnObject gatewayReturnObject = testClient.testCreateProfile();
		testClient.testAuthorizeAndCapture(gatewayReturnObject);		
		testClient.testUpdateProfileRecurringBilling(gatewayReturnObject);
		testClient.testRefundPayment(gatewayReturnObject);		
		testClient.testGetProfiles(gatewayReturnObject);
		testClient.testCopyProfile(gatewayReturnObject);
		testClient.testTerminateRecurringPayments(gatewayReturnObject);
	}
	
	public GatewayReturnObject testCreateProfile() throws Exception
	{
		final CustomerObject customerObject = new CustomerObject();
		customerObject.setAddress1("1313 Mock Lane");
		customerObject.setCity("Bedrock");
		customerObject.setEmail("Fred@flinstone.com");
		customerObject.setName("Fred Flintstone");
		customerObject.setStateAbbr("NY");
		customerObject.setPhone("5555555555");
		customerObject.setZipCode("67676");
		customerObject.setCreditCardNumber("4112344112344113");
		customerObject.setExpireDateMMYY("0912");
		customerObject.setCreditCardSecurityCode("192");
		final GatewayReturnObject gatewayReturnObject = client.CreateProfile(customerObject);
		logger.info("Response from CreateProfile(...): " + gatewayReturnObject.toStringPretty());
		return gatewayReturnObject;
	}

	public void testAuthorizeAndCapture(final GatewayReturnObject gatewayReturnObject) throws Exception
	{
		final GatewayReturnObject response = client.AuthorizeAndCapture(gatewayReturnObject.getCustomerRefNum(), 10.75);
		logger.info("Response from AuthorizeAndCapture(...): " + response.toStringPretty());
	}
	
	public void testUpdateProfileRecurringBilling(final GatewayReturnObject gatewayReturnObject) throws Exception
	{		
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 2);
		final java.util.Date startDate = cal.getTime();
		final GatewayReturnObject response = client.UpdateProfileRecurringBilling(gatewayReturnObject.getCustomerRefNum(), 45.95, startDate);
		logger.info("Response from UpdateProfileRecurringBilling(...): " + response.toStringPretty());
	}
	
	public void testRefundPayment(final GatewayReturnObject gatewayReturnObject) throws Exception
	{
		final GatewayReturnObject response = client.refundPayment(gatewayReturnObject.getCustomerRefNum(), 5.15);
		logger.info("Response from refundPayment(...): " + response.toStringPretty());
	}
	
	public void testTerminateRecurringPayments(final GatewayReturnObject gatewayReturnObject) throws Exception
	{
		final GatewayReturnObject response = client.terminateRecurringPayments(new SemplestString(gatewayReturnObject.getCustomerRefNum()));
		logger.info("Response from terminateRecurringPayments(...): " + response.toStringPretty());
	}
	
	public void testGetProfiles(final GatewayReturnObject gatewayReturnObject) throws Exception
	{
		final List<String> customerProfileRefNumbers = new ArrayList<String>();
		customerProfileRefNumbers.add(gatewayReturnObject.getCustomerRefNum());
		final List<CustomerObject> response = client.GetProfiles(customerProfileRefNumbers);
		logger.info("Response from testGetProfiles(...): " + response);
	}
	
	public void testCopyProfile(final GatewayReturnObject gatewayReturnObject) throws Exception
	{
		final String customerRefNum = gatewayReturnObject.getCustomerRefNum();
		final SemplestString customerProfileRefNumber = new SemplestString(customerRefNum);
		final GatewayReturnObject response = client.CopyProfile(customerProfileRefNumber);
		logger.info("Response from testCopyProfile(...): " + response.toStringPretty());
	}
}
