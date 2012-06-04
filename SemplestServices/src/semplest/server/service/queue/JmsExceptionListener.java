package semplest.server.service.queue;

import javax.jms.ExceptionListener;  
import javax.jms.JMSException;   

import semplest.server.service.SEMplestService;
import semplest.server.service.springjdbc.SemplestDB;

public class JmsExceptionListener implements ExceptionListener  
{  

	public void onException( final JMSException e )  
	{  
		
		e.printStackTrace();  
		errorHandler(new Exception("JMSException: " + e.getMessage(), e));
	}  
	
	private void errorHandler(Exception e){
		String serviceName = SEMplestService.properties.getProperty("ServiceName");		
		SemplestDB db = new SemplestDB();
		db.logError(e, serviceName);
	}
} 
