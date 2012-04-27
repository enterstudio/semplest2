package semplest.server.ESB;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;

public class AsyncServletListener implements AsyncListener
{

	private static final Logger logger = Logger.getLogger(AsyncServletListener.class);
	private static ProtocolJSON json = new ProtocolJSON();

	// Public constructor is required by servlet spec
	public AsyncServletListener()
	{
	}

	public void onComplete(AsyncEvent ae)
	{
		// logger.info("AsyncListener: Completed work: " +
		// ae.getAsyncContext().getRequest().getParameter("uniqueID"));
	}

	public void onTimeout(AsyncEvent ae)
	{
		String uniqueID = (String) ae.getAsyncContext().getRequest().getAttribute("uniqueID");
		logger.error("AsyncListener: Timeout: " + uniqueID + ":" + ae.getAsyncContext().getRequest().getParameter("service") + ":"
				+ ae.getAsyncContext().getRequest().getParameter("method"));
		if (ESBServer.esb.getServletAsynchContextMap().containsKey(uniqueID))
		{
			HashMap<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("errorMessage", "Service Timeout");
			errorMap.put("errorType", "Timeout");
			errorMap.put("errorID", uniqueID);
			String ret = json.createJSONHashmap(errorMap);
			AsyncContext asyncContext = ESBServer.esb.getServletAsynchContextMap().get(uniqueID);
			if (asyncContext != null)
			{
				asyncContext.getResponse().setContentType("text/html");
				try
				{
					PrintWriter out = asyncContext.getResponse().getWriter();
					out.print(ret);
				}
				catch (Exception e)
				{
					logger.error(e.getMessage(), e);
				}
				asyncContext.complete();

				ESBServer.esb.getServletAsynchContextMap().remove(uniqueID);
				logger.info("Removed " + uniqueID + "  from ServletAsynchContextMap");

			}

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
