package semplest.server.service.queue;

import javax.jms.ExceptionListener;  
import javax.jms.JMSException;   

import semplest.server.service.SEMplestService;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestErrorHandler;

public class JmsExceptionListener implements ExceptionListener  
{  
	public void onException( final JMSException e )  
	{  
		
		e.printStackTrace();  
		SemplestErrorHandler.logToDatabase(new Exception("JMSException: " + e.getMessage(), e));
	}  
	
} 
