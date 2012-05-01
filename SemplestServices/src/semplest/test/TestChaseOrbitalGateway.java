package semplest.test;

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
			GatewayReturnObject r = gatew.CreateProfile(customerObject, "376751317521031", "0912");
			//ref 1460103
			System.out.println(r.getAuthCode() + ":" + r.getCustomerRefNum() + ":" + r.getIsGood() + r.getMessage());

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
