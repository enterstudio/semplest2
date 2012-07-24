package semplest.system.monitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import semplest.services.client.api.KeywordLDAServiceClient;
import semplest.services.client.api.SemplestAdEngineServiceClient;
import semplest.services.client.api.SemplestBiddingServiceClient;
import semplest.services.client.api.SemplestMailServiceClient;
import semplest.services.client.api.SemplestSchedulerServiceClient;
import semplest.system.monitor.MonitorObject.SERVICE;

public class SystemMonitor {			
	
	public static void main(String[] args){				
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		//Configure the Services
		SemplestAdEngineServiceClient adEngineService = new SemplestAdEngineServiceClient(null);
		SemplestBiddingServiceClient biddingService = new SemplestBiddingServiceClient(null, null);
		KeywordLDAServiceClient keywordService = new KeywordLDAServiceClient(null);
		SemplestMailServiceClient mailService = new SemplestMailServiceClient(null);
		SemplestSchedulerServiceClient schedulerService = new SemplestSchedulerServiceClient(null);
		
		//Start the Monitors
		executor.execute(new MonitorThread(SERVICE.AdEngine, adEngineService));
		executor.execute(new MonitorThread(SERVICE.Bidding, biddingService));
		executor.execute(new MonitorThread(SERVICE.Keyword, keywordService));
		executor.execute(new MonitorThread(SERVICE.Mail, mailService));
		executor.execute(new MonitorThread(SERVICE.Scheduler, schedulerService));
		
		executor.shutdown();
	}
}
