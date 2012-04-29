package semplest.service.chaseorbitalgateway;

import org.apache.log4j.Logger;

import semplest.server.protocol.chaseorbitalgateway.CustomerObject;
import semplest.services.client.interfaces.ChaseOrbitalGatewayInterface;

public class ChaseOrbitalGatewayServiceImpl implements ChaseOrbitalGatewayInterface
{
	public static ChaseOrbitalGatewayObject gatewayObj = null;
	private static final Logger logger = Logger.getLogger(ChaseOrbitalGatewayServiceImpl.class);
	@Override
	public void initializeService(String input) throws Exception
	{
		gatewayObj = new  ChaseOrbitalGatewayObject();
		gatewayObj.start();
		logger.info("Initialized Chase Orbital Gateway");
	}

	@Override
	public String CreateProfile(CustomerObject customerObject, String creditCardNumber) throws Exception
	{
		// TODO Auto-generated method stub
		return null;
	}

}
