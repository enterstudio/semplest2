package semplest.test.systemmonitor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SystemMonitor {			
	
	public static void main(String[] args){				
		ExecutorService executor = Executors.newCachedThreadPool();
		
		executor.execute(new AdEngineMonitorThread());
		executor.execute(new BiddingMonitorThread());
		executor.execute(new KeywordMonitorThread());
		executor.execute(new SchedulerMonitorThread());
		executor.execute(new MailMonitorThread());		
	}	

}
