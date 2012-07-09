package semplest.test.systemmonitor;

import java.util.HashMap;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;


public class MonitorData {
	
	public static enum SERVER {DEV, TEST, PROD};
	public static enum SERVICE {AdEngine, Bidding, Keyword, Mail, Scheduler};
	
	private String esbUrl;
	private HashMap<SERVICE, Status> serviceStatus = new HashMap<SERVICE, Status>();

	public MonitorData(String esbUrl) {
		this.esbUrl = esbUrl;
		for(SERVICE s : SERVICE.values()){
			serviceStatus.put(s, new Status());
		}
	}
	
	public String getEsbUrl() {
		return esbUrl;
	}
	
	public void setServiceStatus(SERVICE service, ServiceStatus status){
		Status nowStatus = serviceStatus.get(service);
		nowStatus.setStatus(status);
		serviceStatus.put(service, nowStatus);
	}
	
	public Status getServiceStatus(SERVICE service){
		return serviceStatus.get(service);
	}
	
	public class Status{
		private ServiceStatus prevStatus;
		private ServiceStatus currStatus;
		
		public Status(){
			prevStatus = ServiceStatus.Good;
			currStatus = ServiceStatus.Good;
		}
		
		public void setStatus(ServiceStatus status){
			this.prevStatus = this.currStatus;
			this.currStatus = status;
		}
		
		public boolean goesDown(){
			if(prevStatus == ServiceStatus.Good && currStatus == ServiceStatus.Bad){
				return true;
			}
			return false;
		}
		
		public boolean goesUp(){
			if(prevStatus == ServiceStatus.Bad && currStatus == ServiceStatus.Good){
				return true;
			}
			return false;
		}
	}
}
