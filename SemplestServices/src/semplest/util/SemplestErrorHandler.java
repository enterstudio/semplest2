package semplest.util;

import semplest.server.service.SEMplestService;
import semplest.server.service.springjdbc.SemplestDB;

public class SemplestErrorHandler {	

	public void logToDatabase(Exception e){		 
		String serviceName = SEMplestService.properties.getProperty("YAJSW.servicename");
		SemplestDB.logError(e, serviceName);
	}
}
