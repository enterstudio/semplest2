package semplest.server.service.queue;

import javax.jms.ExceptionListener;  
import javax.jms.JMSException;   

import semplest.server.service.SEMplestService;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestErrorHandler;

public class JmsExceptionListener implements ExceptionListener  
{  
	private SemplestErrorHandler errorHandler = new SemplestErrorHandler();

	public void onException( final JMSException e )  
	{  
		
		e.printStackTrace();  
		errorHandler.logToDatabase(new Exception("JMSException: " + e.getMessage(), e));
	}  
	
} 
