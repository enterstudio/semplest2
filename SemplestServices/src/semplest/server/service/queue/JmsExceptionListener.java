package semplest.server.service.queue;

import javax.jms.ExceptionListener;  
import javax.jms.JMSException;   

import org.apache.log4j.Logger;

import semplest.server.service.SEMplestService;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestErrorHandler;

public class JmsExceptionListener implements ExceptionListener  
{  
	private static final Logger logger = Logger.getLogger(JmsExceptionListener.class);
	
	public void onException( final JMSException e )  
	{  
		logger.error("Problem", e);
		SemplestErrorHandler.logToDatabase(new Exception("JMSException: " + e.getMessage(), e));
	}  
	
} 
