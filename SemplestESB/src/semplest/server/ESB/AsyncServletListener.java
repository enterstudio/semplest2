package semplest.server.ESB;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

import org.apache.log4j.Logger;

public class AsyncServletListener implements AsyncListener
{

	private static final Logger logger = Logger.getLogger(AsyncServletListener.class);
	

	// Public constructor is required by servlet spec
	public AsyncServletListener()
	{
	}

	public void onComplete(AsyncEvent ae)
	{
		//logger.info("AsyncListener: Completed work: " +	ae.getAsyncContext().getRequest().getParameter("uniqueID"));
	}

	public void onTimeout(AsyncEvent ae)
	{
		String uniqueID = ae.getAsyncContext().getRequest().getParameter("uniqueID");
		logger.error("AsyncListener: Timeout: " + uniqueID + ":" + ae.getAsyncContext().getRequest().getParameter("service") + ":" + ae.getAsyncContext().getRequest().getParameter("method"));
		if (ESBServer.esb.getServletAsynchContextMap().containsKey(uniqueID))
		{
			ESBServer.esb.getServletAsynchContextMap().remove(uniqueID);
			logger.info("Removed " + uniqueID + "  from ServletAsynchContextMap");
		}
	}

	public void onError(AsyncEvent ae)
	{
		logger.info("AsyncListener: onError for request: " + ae.getAsyncContext().getRequest().getParameter("uniqueID"));
	}

	public void onStartAsync(AsyncEvent ae)
	{
		logger.info("AsyncListener: onStartAsync");
	}

}
