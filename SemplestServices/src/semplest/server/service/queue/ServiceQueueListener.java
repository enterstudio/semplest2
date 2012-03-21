package semplest.server.service.queue;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

import semplest.server.protocol.ProtocolJSON;
import semplest.server.service.SEMplestService;
import semplest.server.service.SemplestServiceTemplate;
import semplest.server.service.ServiceThread;


public class ServiceQueueListener implements MessageListener
{
	//private static ProtocolJSON json = new ProtocolJSON();
	private final ServiceActiveMQConnection cn;
	private SemplestServiceTemplate myService = null;
	static final Logger logger = Logger.getLogger(ServiceQueueListener.class);
	
	public ServiceQueueListener(ServiceActiveMQConnection cn)
	{
		this.cn = cn;
		myService = (SemplestServiceTemplate) SEMplestService.appContext.getBean("semplestService");
	}
    public void onMessage( final Message message )
    {
        try
		{
			if ( message instanceof TextMessage )
			{
			    final TextMessage textMessage = (TextMessage) message;
			    try
			    {
			        logger.info(textMessage.getText() );
			    }
			    catch (final JMSException e)
			    {
			        e.printStackTrace();
			    }
			}
			else if (message instanceof BytesMessage)
			{ 
				BytesMessage ByteMess = (BytesMessage) message;
				String methodName = ByteMess.getStringProperty("method");
				String uniqueID = ByteMess.getJMSCorrelationID();
				byte[] data = new byte[(int) ByteMess.getBodyLength()];;
				ByteMess.readBytes(data);
				//convert from JSON to Object
				String jsonStr = ProtocolJSON.convertbytesToString(data);
				//ProtocolMQDataObject mqDataObj = json.createMQDataObjFromJSON(jsonStr); 
				
				try
				{
					ServiceThread serviceThread = new ServiceThread(cn,myService,methodName, jsonStr,uniqueID);
					SEMplestService.executor.submit(serviceThread);
				}
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else
			{
				logger.error("MQ message rec but not processed");
			}
		}
		catch (JMSException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
