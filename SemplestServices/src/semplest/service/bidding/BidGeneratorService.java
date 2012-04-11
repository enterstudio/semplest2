package semplest.service.bidding;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import semplest.server.service.ServiceInterface;



public class BidGeneratorService implements ServiceInterface {

	private static final Logger logger = Logger.getLogger(BidGeneratorService.class);

	@Override
	public String ServiceGet(String methodName, String jsonStr) throws Exception
	{
		try
		{
			logger.debug("Running BidGeneratorService " + methodName + ":" + jsonStr);
			BidGeneratorServiceImpl service = new BidGeneratorServiceImpl();
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
