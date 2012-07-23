package semplest.system.monitor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.springjdbc.BaseDB;

public class Configuration extends BaseDB {	
	private Boolean isStop;
	private int monitorInterval;
	private String clientTimeout;
	private String DevEsbUrl;		
	private String TestEsbUrl;		
	private String ProdEsbUrl;
	private Boolean isMonitorDev;
	private Boolean isMonitorTest;
	private Boolean isMonitorProd;	
	
	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");
		
	public void loadConiguration(){
		String sql;
		
		sql = "SELECT smc.IsStop FROM SystemMonitorConfiguration smc";
		isStop = jdbcTemplate.queryForObject(sql, Boolean.class);
		
		sql = "SELECT smc.MonitorInterval FROM SystemMonitorConfiguration smc";
		monitorInterval = jdbcTemplate.queryForInt(sql);
		
		sql = "SELECT smc.ClientTimeout FROM SystemMonitorConfiguration smc";
		clientTimeout = jdbcTemplate.queryForObject(sql, String.class);
		
		sql = "SELECT smc.DevEsbUrl FROM SystemMonitorConfiguration smc";
		DevEsbUrl = jdbcTemplate.queryForObject(sql, String.class);
		
		sql = "SELECT smc.TestEsbUrl FROM SystemMonitorConfiguration smc";
		TestEsbUrl = jdbcTemplate.queryForObject(sql, String.class);
		
		sql = "SELECT smc.ProductEsbUrl FROM SystemMonitorConfiguration smc";
		ProdEsbUrl = jdbcTemplate.queryForObject(sql, String.class);
		
		sql = "SELECT smc.IsMonitorDev FROM SystemMonitorConfiguration smc";
		isMonitorDev = jdbcTemplate.queryForObject(sql, Boolean.class);
		
		sql = "SELECT smc.IsMonitorTest FROM SystemMonitorConfiguration smc";
		isMonitorTest = jdbcTemplate.queryForObject(sql, Boolean.class);
		
		sql = "SELECT smc.IsMonitorProd FROM SystemMonitorConfiguration smc";
		isMonitorProd = jdbcTemplate.queryForObject(sql, Boolean.class);
		
	}

	public int getMonitorInterval() {
		return monitorInterval;
	}

	public String getDevEsbUrl() {
		return DevEsbUrl;
	}

	public String getTestEsbUrl() {
		return TestEsbUrl;
	}

	public String getProdEsbUrl() {
		return ProdEsbUrl;
	}

	public boolean isMonitorDev() {
		return isMonitorDev;
	}

	public boolean isMonitorTest() {
		return isMonitorTest;
	}

	public boolean isMonitorProd() {
		return isMonitorProd;
	}

	public boolean isStop() {
		return isStop;
	}

	public String getClientTimeout() {
		return clientTimeout;
	}	
	
}
