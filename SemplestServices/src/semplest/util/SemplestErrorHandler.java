package semplest.util;

import semplest.server.service.SEMplestService;
import semplest.server.service.springjdbc.SemplestDB;

public class SemplestErrorHandler {	

	public static void logToDatabase(Exception e){		 
		if(SEMplestService.properties == null) return;
		
		String serviceName = SEMplestService.properties.getProperty("YAJSW.servicename");
		SemplestDB.logError(e, serviceName);
	}
}
