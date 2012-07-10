package semplest.test.systemmonitor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.service.springjdbc.BaseDB;

public class LoadConfig extends BaseDB {
	private ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
	
	private boolean isStop = false;
	private int monitorInterval = 10;
	private String clientTimeout = "30000";
	private String DevEsbUrl = "http://VMDEVJAVA1:9898/semplest";		
	private String TestEsbUrl = "http://VMJAVA1:9898/semplest";		
	private String ProdEsbUrl = "http://10.80.130.64:9898/semplest";
	private boolean isMonitorDev = true;
	private boolean isMonitorTest = true;
	private boolean isMonitorProd = true;
	
	public void loadConiguration(){
		String sql;
		
		sql = "SELECT smc.IsStop FROM SystemMonitorConfiguration smc";
		isStop = jdbcTemplate.queryForObject(sql, boolean.class);
		
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
		isMonitorDev = jdbcTemplate.queryForObject(sql, boolean.class);
		
		sql = "SELECT smc.IsMonitorDev FROM SystemMonitorConfiguration smc";
		isMonitorTest = jdbcTemplate.queryForObject(sql, boolean.class);
		
		sql = "SELECT smc.IsMonitorDev FROM SystemMonitorConfiguration smc";
		isMonitorProd = jdbcTemplate.queryForObject(sql, boolean.class);
		
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
