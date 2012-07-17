package semplest.system.monitor;

import java.util.HashMap;
import semplest.server.protocol.ProtocolEnum.ServiceStatus;

public class MonitorObject {
	
	public static enum SERVER {DEV, TEST, PROD};
	public static enum SERVICE {AdEngine, Bidding, Keyword, Mail, Scheduler};	
	
	private HashMap<SERVER, Status> serverServiceStatus = new HashMap<SERVER, Status>();
	private HashMap<SERVER, Config> serverConfig = new HashMap<SERVER, Config>();
	
	private boolean isStop;
	private int sleepTime;
	private String clientTimeout;
	private Configuration config = new Configuration();
	
	public MonitorObject() {
		for(SERVER server : SERVER.values()){
			serverServiceStatus.put(server, new Status());
		}
		for(SERVER server : SERVER.values()){
			serverConfig.put(server, new Config());
		}
	}
	
	public void setServerServiceStatus(SERVER server, ServiceStatus status){		
		Status nowStatus = serverServiceStatus.get(server);
		nowStatus.setStatus(status);		
		serverServiceStatus.put(server, nowStatus);
	}
	
	public ServiceStatus getServerServiceStatus(SERVER server){
		return serverServiceStatus.get(server).getStatus();
	}
	
	public boolean isMonitorServer(SERVER server){
		return serverConfig.get(server).isMonitor;
	}
	
	public String getServerEsbUrl(SERVER server){
		return serverConfig.get(server).esbUrl;
	}
	
	public boolean isServerServiceDown(SERVER server){
		return serverServiceStatus.get(server).goesDown();
	}
	
	public boolean isServerServiceUp(SERVER server){
		return serverServiceStatus.get(server).goesUp();
	}

	public boolean isStop() {
		return isStop;
	}

	public int getSleepTime() {
		return sleepTime;
	}

	public String getClientTimeout() {
		return clientTimeout;
	}
	
	public void loadConfig(){		
		config.loadConiguration();
		
		isStop = config.isStop();
		
		sleepTime = config.getMonitorInterval() * 60 * 1000;
		clientTimeout = config.getClientTimeout();		
		
		serverConfig.get(SERVER.DEV).esbUrl = config.getDevEsbUrl();
		serverConfig.get(SERVER.TEST).esbUrl = config.getTestEsbUrl();
		serverConfig.get(SERVER.PROD).esbUrl = config.getProdEsbUrl();
		
		serverConfig.get(SERVER.DEV).isMonitor = config.isMonitorDev();
		serverConfig.get(SERVER.TEST).isMonitor = config.isMonitorTest();
		serverConfig.get(SERVER.PROD).isMonitor = config.isMonitorProd();
	}
	
	//Classes
	private class Status{
		private ServiceStatus prevStatus;
		private ServiceStatus currStatus;
		
		public Status(){
			prevStatus = ServiceStatus.Up;
			currStatus = ServiceStatus.Up;
		}
		
		public void setStatus(ServiceStatus status){
			this.prevStatus = this.currStatus;
			this.currStatus = status;
		}
		
		public ServiceStatus getStatus(){
			return currStatus;
		}
		
		public boolean goesDown(){
			if(prevStatus == ServiceStatus.Up && currStatus == ServiceStatus.Down){
				return true;
			}
			return false;
		}
		
		public boolean goesUp(){
			if(prevStatus == ServiceStatus.Down && currStatus == ServiceStatus.Up){
				return true;
			}
			return false;
		}
	}
	
	private class Config{
		public String esbUrl;
		public boolean isMonitor;
	}
}
