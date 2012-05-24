package semplest.client.nio;

import org.apache.log4j.Logger;

public class NIOResponseHandler
{
	private static final Logger logger = Logger.getLogger(NIOResponseHandler.class);
	
	private byte[] rsp = null;

	public synchronized boolean handleResponse(byte[] rsp)
	{
		this.rsp = rsp;
		this.notify();
		return true;
	}

	public synchronized byte[] waitForResponse()
	{
		while (this.rsp == null)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				logger.debug("Got interrupted", e);
			}
		}

		return rsp;
	}
}
