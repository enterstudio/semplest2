package semplest.test;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.server.protocol.chaseorbitalgateway.GatewayReturnObject;
import semplest.service.chaseorbitalgateway.ChaseOrbitalGatewayServiceImpl;

public class TestChaseOrbitalGateway
{

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
			CustomerObject customerObject = new CustomerObject();
			customerObject.setAddress1("1313 Mock Lane");
			customerObject.setCity("Bedrock");
			customerObject.setEmail("Fred@flinstone.com");
			customerObject.setFirstName("Fred");
			customerObject.setLastName("Flintstone");
			customerObject.setPhone("5555555555");
			customerObject.setStateAbbr("NY");
			customerObject.setZipCode("67676");
			GatewayReturnObject r = gatew.CreateProfile(customerObject, "4112344112344113", "0912");
			//ref 1460103
			System.out.println("PROFILE: ID " + r.getCustomerRefNum() + ":" + r.getIsGood() + r.getMessage());
			
			//Authorize and capture
			GatewayReturnObject a = gatew.AuthorizeAndCapture(r.getCustomerRefNum(), 100.99);
			if (a.getIsError())
			{
				System.out.println(a.getMessage());
			}
			System.out.println(" ORDERID + " +  a.getOrderID() + " Amount redeemed=" + a.getAmountRedeemedNoDecimal() + " Amount requested =" + a.getAmountRequestedNoDecimal() + " Remaining bal =" + a.getRemainingBalanceNoDecimal() );

		}
		catch (Exception iex)
		{
			System.err.println("TransactionProcessor failed to initialize");
			System.err.println(iex.getMessage());
			iex.printStackTrace();
			System.exit(-1);

		}
	}
}
