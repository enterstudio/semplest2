package semplest.server.queue;

import java.io.PrintWriter;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.servlet.AsyncContext;

import org.apache.log4j.Logger;

import semplest.server.ESB.ESBServer;
import semplest.server.protocol.ProtocolJSON;

public class QueueListener implements MessageListener

{
	static final Logger logger = Logger.getLogger(QueueListener.class);

	@Override
	public void onMessage(Message message)
	{

		try
		{
			if (message instanceof TextMessage)
			{
				final TextMessage textMessage = (TextMessage) message;
				try
				{
					logger.info(textMessage.getText());
				}
				catch (final JMSException e)
				{
					logger.error("Problem", e);
				}
			}
			else if (message instanceof BytesMessage)
			{
				String result = "error";
				if (message != null)
				{
					BytesMessage ByteMess = (BytesMessage) message;
					String uniqueID = ByteMess.getJMSCorrelationID();
					byte[] data = new byte[(int) ByteMess.getBodyLength()];
					ByteMess.readBytes(data);
					// convert from JSON to Object
					result = ProtocolJSON.convertbytesToString(data);
					logger.debug("Received result =" + result);
					// pass back result and remove the asynchContext
					AsyncContext asyncContext = ESBServer.esb.getServletAsynchContextMap().get(uniqueID);
					if (asyncContext != null)
					{
						asyncContext.getResponse().setContentType("text/html");
						try
						{
							PrintWriter out = asyncContext.getResponse().getWriter();
							out.print(result);
						}
						catch (Exception e)
						{
							logger.error(e.getMessage(), e);
						}
						asyncContext.complete();
						if (ESBServer.esb.getServletAsynchContextMap().containsKey(uniqueID))
						{
							ESBServer.esb.getServletAsynchContextMap().remove(uniqueID);
							logger.info("Removed " + uniqueID + "  from ServletAsynchContextMap");
						}
					}
					else
					{
						logger.error("Asynch Context is NULL.  Cannot send back result - Should not be???");
					}
				}
			}
		}
		catch (JMSException e)
		{
			logger.error("Problem", e);
		}

	}

}
