package semplest.systemmonitor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.server.service.springjdbc.BaseDB;
import semplest.systemmonitor.MonitorObject.SERVER;
import semplest.systemmonitor.MonitorObject.SERVICE;

public class MonitorDB extends BaseDB {
	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	
	public void storeServerServiceStatus(SERVER server, SERVICE service, ServiceStatus status){
		String sql = "UPDATE SystemMonitor SET Status = ?, TimeStamp = CURRENT_TIMESTAMP WHERE Server = ? AND Service = ?";
		jdbcTemplate.update(sql, new Object[] 
				{status.getServiceStatusValue(), server.name(), service.name()});
	}
}
