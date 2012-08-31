package semplest.tools;

import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import semplest.server.service.springjdbc.BaseDB;

public class GeneralDB extends BaseDB
{

	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");

	public static HashMap<String, String> getChaseOrbitalConf()
	{
		HashMap<String, String> ChaseOrbitalConfMap = new HashMap<String, String>();

		String sql = "UPDATE SystemMonitor SET Status = ?, TimeStamp = CURRENT_TIMESTAMP WHERE Server = ? AND Service = ?";
		jdbcTemplate.update(sql);

		String hostName = "";
		String failoverName = "";

		ChaseOrbitalConfMap.put("engine.hostname", hostName);
		ChaseOrbitalConfMap.put("engine.hostname.failover", failoverName);

		return ChaseOrbitalConfMap;
	}
}
