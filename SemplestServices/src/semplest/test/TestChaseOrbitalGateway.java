package semplest.test;

import java.util.Calendar;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.SemplestString;
import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;
import semplest.service.chaseorbitalgateway.ChaseOrbitalGatewayServiceImpl;

public class TestChaseOrbitalGateway
{
	private static final Logger logger = Logger.getLogger(TestChaseOrbitalGateway.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			BasicConfigurator.configure();
			
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
			ChaseOrbitalGatewayServiceImpl gatew = new ChaseOrbitalGatewayServiceImpl();
			gatew.initializeService(null);
			
			// Create 
			CustomerObject customerObject = new CustomerObject();
			customerObject.setAddress1("1313 Mock Lane");
			customerObject.setCity("Bedrock");
			customerObject.setEmail("Fred@flinstone.com");
			customerObject.setName("Fred Flintstone");
			customerObject.setPhone("5555555555");
			customerObject.setStateAbbr("NY");
			customerObject.setZipCode("67676");
			customerObject.setCreditCardNumber("4112344112344113");
			customerObject.setExpireDateMMYY("0912");			
			GatewayReturnObject r = gatew.CreateProfile(customerObject);
			//ref 1460103
			logger.info("PROFILE: ID " + r.getCustomerRefNum() + ":" + r.getIsGood() + r.getMessage());
			logger.info("GatewayReturnObject response (from CreateProfile): " + r.toStringPretty());
			logger.info("------------------------------------------------------------");
			
			// Authorize and capture
			GatewayReturnObject a = gatew.AuthorizeAndCapture(r.getCustomerRefNum(), 100.99, "222");
			if (a.getIsError())
			{
				logger.info("Error: " + a.getMessage());
			}
			logger.info(" ORDERID + " +  a.getOrderID() + " Amount redeemed=" + a.getAmountRedeemedNoDecimal() + " Amount requested =" + a.getAmountRequestedNoDecimal() + " Remaining bal =" + a.getRemainingBalanceNoDecimal() );
			logger.info("GatewayReturnObject response (from AuthorizeAndCapture): " + a.toStringPretty());
			logger.info("------------------------------------------------------------");
			
			// Update
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, 1);
			GatewayReturnObject update = gatew.UpdateProfileRecurringBilling(r.getCustomerRefNum(), 100.99, cal.getTime(), 25);
			logger.info(update.getOrderID() + ":" + update.getIsGood());
			logger.info("GatewayReturnObject response (from UpdateProfileRecurringBilling): " + update.toStringPretty());
			logger.info("------------------------------------------------------------");
			
			// Refund
			final GatewayReturnObject refundResponse = gatew.refundPayment(r.getCustomerRefNum(), 5.25);
			logger.info("GatewayReturnObject response (from refundPayment): " + refundResponse.toStringPretty());
			logger.info("------------------------------------------------------------");
			
			// Terminate Payment
			final GatewayReturnObject terminateRecurringPaymentsResponse = gatew.terminateRecurringPayments(new SemplestString(r.getCustomerRefNum()));
			logger.info("GatewayReturnObject response (from terminateRecurringPayments): " + terminateRecurringPaymentsResponse.toStringPretty());
			logger.info("------------------------------------------------------------");
		}
		catch (Exception iex)
		{
			System.err.println("TransactionProcessor failed to initialize");
			System.err.println(iex.getMessage());
			logger.error("Problem", iex);
			System.exit(-1);

		}
	}
}
