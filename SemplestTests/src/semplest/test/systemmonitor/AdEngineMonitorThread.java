package semplest.test.systemmonitor;

import java.util.HashMap;

import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.services.client.api.SemplestAdEngineServiceClient;
import semplest.test.systemmonitor.MonitorData.SERVER;
import semplest.test.systemmonitor.MonitorData.SERVICE;

public class AdEngineMonitorThread implements Runnable {

	private long sleep_time;
	private HashMap<SERVER, MonitorData> monitorData;
	private boolean stop = false;	
	
	private String dummyInput = "test"; 
	Notification alert = new Notification();

	public AdEngineMonitorThread(long interval_min, HashMap<SERVER, MonitorData> monitorDataTemplate) {
		this.sleep_time = interval_min * 60 * 1000;		
		monitorData = monitorDataTemplate;
	}
	
	@Override
	public void run() {
		while(!stop){	
			for(SERVER s : SERVER.values()){
				SemplestAdEngineServiceClient adEngine = new SemplestAdEngineServiceClient(monitorData.get(s).getEsbUrl());
				try {
					String ret = adEngine.checkStatus(dummyInput);
				} catch (Exception e) {
					e.printStackTrace();
					//The service is not healthy
					monitorData.get(s).setServiceStatus(SERVICE.AdEngine, ServiceStatus.Bad);				
					if(monitorData.get(s).getServiceStatus(SERVICE.AdEngine).goesDown()){
						//if the service just went down. send notification
						alert.sendNotification(s, SERVICE.AdEngine, false);
					}
				}
				if(monitorData.get(s).getServiceStatus(SERVICE.AdEngine).goesUp()){
					//if the service used to be down, but just went up, send notification
					alert.sendNotification(s, SERVICE.AdEngine, true);
				}
			}
			
			try {
				Thread.sleep(sleep_time);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}		
}
