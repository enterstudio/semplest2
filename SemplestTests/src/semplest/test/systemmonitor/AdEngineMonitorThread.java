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
	
	private String clientTimeout = "30000"; 
	Notification alert = new Notification();

	public AdEngineMonitorThread(long interval_min, HashMap<SERVER, MonitorData> monitorDataTemplate) {
		this.sleep_time = interval_min * 60 * 1000;		
		monitorData = monitorDataTemplate;
	}
	
	@Override
	public void run() {		
		while(!stop){	
			try {
				for(SERVER s : SERVER.values()){
					String esbUrl = monitorData.get(s).getEsbUrl();
					SemplestAdEngineServiceClient adEngine = new SemplestAdEngineServiceClient(esbUrl);
					try {
						String ret = adEngine.checkStatus(clientTimeout);
					} catch (Exception e) {
						System.out.println("AdEngine is not running on " + s.name());
						e.printStackTrace();
						//The service is not healthy
						monitorData.get(s).setServiceStatus(SERVICE.AdEngine, ServiceStatus.Bad);				
						if(monitorData.get(s).getServiceStatus(SERVICE.AdEngine).goesDown()){
							//if the service just went down. send notification
							alert.sendNotification(s, SERVICE.AdEngine, false);
						}
					}
					System.out.println("AdEngine is running fine on " + s.name());
					if(monitorData.get(s).getServiceStatus(SERVICE.AdEngine).goesUp()){
						//if the service used to be down, but just went up, send notification
						alert.sendNotification(s, SERVICE.AdEngine, true);
					}
				}				
				
				Thread.sleep(sleep_time);	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}			
	}		
}
