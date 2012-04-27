package semplest.server.queue;

import javax.jms.ExceptionListener;  
import javax.jms.JMSException;   

import org.apache.log4j.Logger;

public class JmsExceptionListener implements ExceptionListener  
{  
	static final Logger logger = Logger.getLogger(JmsExceptionListener.class);

	public void onException( final JMSException e )  
	{  
		e.printStackTrace();  
	}  
} 
