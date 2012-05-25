package semplest.services.client.test;

import java.util.Calendar;

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
		testClient.UpdateProfileRecurringBilling(gatewayReturnObject);
		testClient.refundPayment(gatewayReturnObject);
		testClient.terminateRecurringPayments(gatewayReturnObject);
	}
	
	public GatewayReturnObject testCreateProfile() throws Exception
	{
		final CustomerObject customerObject = new CustomerObject();
		customerObject.setAddress1("1313 Mock Lane");
		customerObject.setCity("Bedrock");
		customerObject.setEmail("Fred@flinstone.com");
		customerObject.setFirstName("Fred");
		customerObject.setLastName("Flintstone");
		customerObject.setPhone("5555555555");
		customerObject.setStateAbbr("NY");
		customerObject.setZipCode("67676");
		final String creditCardNumber = "4112344112344113";
		final String expireDateMMYY = "0912";
		final GatewayReturnObject gatewayReturnObject = client.CreateProfile(customerObject, creditCardNumber, expireDateMMYY);
		logger.info("Response from CreateProfile(...): " + gatewayReturnObject.toStringPretty());
		return gatewayReturnObject;
	}

	public void testAuthorizeAndCapture(final GatewayReturnObject gatewayReturnObject) throws Exception
	{
		final GatewayReturnObject response = client.AuthorizeAndCapture(gatewayReturnObject.getCustomerRefNum(), 10.75);
		logger.info("Response from AuthorizeAndCapture(...): " + response.toStringPretty());
	}
	
	public void UpdateProfileRecurringBilling(final GatewayReturnObject gatewayReturnObject) throws Exception
	{		
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 2);
		final java.util.Date startDate = cal.getTime();
		final GatewayReturnObject response = client.UpdateProfileRecurringBilling(gatewayReturnObject.getCustomerRefNum(), 45.95, startDate);
		logger.info("Response from UpdateProfileRecurringBilling(...): " + response.toStringPretty());
	}
	
	public void refundPayment(final GatewayReturnObject gatewayReturnObject) throws Exception
	{
		final GatewayReturnObject response = client.refundPayment(gatewayReturnObject.getCustomerRefNum(), 5.15);
		logger.info("Response from refundPayment(...): " + response.toStringPretty());
	}
	
	public void terminateRecurringPayments(final GatewayReturnObject gatewayReturnObject) throws Exception
	{
		final GatewayReturnObject response = client.terminateRecurringPayments(new SemplestString(gatewayReturnObject.getCustomerRefNum()));
		logger.info("Response from terminateRecurringPayments(...): " + response.toStringPretty());
	}
}
