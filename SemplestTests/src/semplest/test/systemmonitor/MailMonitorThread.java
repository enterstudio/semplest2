package semplest.test.systemmonitor;

import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.services.client.api.SemplestMailServiceClient;
import semplest.test.systemmonitor.MonitorObject.SERVER;
import semplest.test.systemmonitor.MonitorObject.SERVICE;

public class MailMonitorThread implements Runnable {

	private SERVICE service = SERVICE.Mail;	
	private Notification alert = new Notification();
	private MonitorObject monitor = new MonitorObject();	
	
	@Override
	public void run() {		
		while(!monitor.isStop()){	
			try {
				monitor.loadConfig();
				
				for(SERVER server : SERVER.values()){
					if(monitor.isMonitorServer(server)){
						String esbUrl = monitor.getServerEsbUrl(server);
						SemplestMailServiceClient mailService = new SemplestMailServiceClient(esbUrl);
						
						try {
							String ret = mailService.checkStatus(monitor.getClientTimeout());
							
							if(ret.equals(ServiceStatus.Up)){
								System.out.println(service.name() + " is running fine on " + server.name());
								monitor.setServerServiceStatus(server, ServiceStatus.Up);
								if(monitor.isServerServiceUp(server)){
									//if the service used to be down, but just came back up, send notification
									alert.sendNotification(server, service, null);
								}
							}
							else{							
								onError(server, new Exception("Service Status - " + ret));
							}
						} 
						catch (Exception e) {
							onError(server, e);
						}
					}						
				}				
				
				Thread.sleep(monitor.getSleepTime());	
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}			
	}		
	
	private void onError(SERVER server, Exception e){
		System.out.println(service.name() + " is not running on " + server.name() + " - " + e.getMessage());						
		//The service is not healthy
		monitor.setServerServiceStatus(server, ServiceStatus.Down);				
		if(monitor.isServerServiceDown(server)){
			//if the service just went down. send notification
			alert.sendNotification(server, service, e.getMessage());
		}
	}
}
