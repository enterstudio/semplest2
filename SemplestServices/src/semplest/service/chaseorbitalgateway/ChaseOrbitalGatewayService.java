package semplest.service.chaseorbitalgateway;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;

public class ChaseOrbitalGatewayService implements ServiceInterface 
{

	private static final Logger logger = Logger.getLogger(ChaseOrbitalGatewayService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr) throws Exception
	{
		try
		{
			logger.debug("Running ChaseOrbitalGatewayService " + methodName + ":" + jsonStr);
			ChaseOrbitalGatewayServiceImpl service = new ChaseOrbitalGatewayServiceImpl();
			Class[] parameterTypes = new Class[] {String.class};
			Method method = service.getClass().getMethod(methodName, parameterTypes);
			return (String) method.invoke(service,jsonStr);
		}
		catch (Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

}
