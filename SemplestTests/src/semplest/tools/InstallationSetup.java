package semplest.tools;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

/*
 * How to deploy the InstallationSetup:
 * 		1) Export latest version of all the 3 projects: 'SEMplestProtocol', 'SemplestService' and 'SemplestServicesClient' as 'SemplestAll.jar'
 to the /lib folder of SemplestTests project.
 * 		2) Export the 'SemplestTests' project with Main-class 'InstallationSetup' as a Runnable Jar, to /semplest/nan folder. 
 * 			All the shortcuts on the server machines would pick up this latest version then.
 */

public class InstallationSetup
{

	// Configurations
	// DEV
	private final static String DevJdbc = "jdbc:jtds:sqlserver://172.18.9.23/semplest";
	private final static String DevEsbServer = "VMDEVJAVA1";
	private final static String DevServiceServer = "VMDEVJAVA2";
	private final static String DevKeywordServer = "VMDEVJAVA3";

	// TEST
	private final static String TestJdbc = "jdbc:jtds:sqlserver://172.18.9.35/semplestTest";
	private final static String TestEsbServer = "VMJAVA1";
	private final static String TestServiceServer = "VMJAVA2";
	private final static String TestKeywordServer = "VMJAVA3";

	// EXP
	// private final static String ExpJdbc = "jdbc:jtds:sqlserver://172.18.9.23/semplest_testing";
	private final static String ExpJdbc = "jdbc:jtds:sqlserver://172.18.9.23/SemplestPRODUCTION";
	private final static String ExpEsbServer = "172.18.9.26";
	private final static String ExpServiceServer = "VMDEVJAVA3";
	private final static String ExpKeywordServer = "VMDEVJAVA2";

	// UAT
	private final static String UatJdbc = "jdbc:jtds:sqlserver://172.18.9.35/semplest";
	private final static String UatEsbServer = "NY-semplestDev2";
	private final static String UatServiceServer = "NY-semplestDev2";
	private final static String UatKeywordServer = "NY-semplestDev2";

	// PRODUCTION
	private final static String ProdJdbc = "jdbc:jtds:sqlserver://10.118.218.132/semplest";
	private final static String ProdEsbServer = "23.22.63.111";
	private final static String ProdServiceServer1 = "107.21.163.3";
	private final static String ProdServiceServer2 = "23.22.245.35";
	private final static String ProdKeywordServer = "107.20.43.149";

	private enum SERVER_BOX
	{
		DEV, TEST, EXP, UAT, PROD
	};

	private static HashMap<SERVER_BOX, ServerConfiguration> config = new HashMap<SERVER_BOX, ServerConfiguration>();

	public static void main(String args[])
	{

		InstallationSetup is = new InstallationSetup();

		is.init();

		try
		{
			InetAddress ownIP = InetAddress.getLocalHost();
			String hostName = ownIP.getHostName();

			/* =================================== */
			/* Development Servers */
			/* =================================== */

			if (hostName.equals(config.get(SERVER_BOX.DEV).esbServer))
			{
				// DEV Box ESB
				is.setEsb(SERVER_BOX.DEV);
			}

			if (hostName.equals(config.get(SERVER_BOX.DEV).serviceServer))
			{
				// DEV Box Services
				is.setServices(SERVER_BOX.DEV);
				is.setChaseOrbitalLineHandler();
			}

			if (hostName.equals(config.get(SERVER_BOX.DEV).keywordServer))
			{
				// DEV Box Keyword Service
				is.setKeywordService(SERVER_BOX.DEV);
			}

			/* =================================== */
			/* Test Servers */
			/* =================================== */

			if (hostName.equals(config.get(SERVER_BOX.TEST).esbServer))
			{
				// TEST Box ESB
				is.setEsb(SERVER_BOX.TEST);
			}

			if (hostName.equals(config.get(SERVER_BOX.TEST).serviceServer))
			{
				// TEST Box Services
				is.setServices(SERVER_BOX.TEST);
				is.setChaseOrbitalLineHandler();
			}

			if (hostName.equals(config.get(SERVER_BOX.TEST).keywordServer))
			{
				// TEST Box Keyword Service
				is.setKeywordService(SERVER_BOX.TEST);
			}

			/* =================================== */
			/* Experiment Servers */
			/* =================================== */

			if (ownIP.getHostAddress().equalsIgnoreCase(config.get(SERVER_BOX.EXP).esbServer))
			{
				// Exp Box ESB
				is.setEsb(SERVER_BOX.EXP);
			}

			if (hostName.equals(config.get(SERVER_BOX.EXP).serviceServer))
			{
				// Exp Services
				is.setServices(SERVER_BOX.EXP);
				is.setChaseOrbitalLineHandler();
			}

			if (hostName.equals(config.get(SERVER_BOX.EXP).keywordServer))
			{
				// Exp Keyword Service
				is.setKeywordService(SERVER_BOX.EXP);
			}

			/* =================================== */
			/* UAT Servers */
			/* =================================== */

			if (hostName.equals(config.get(SERVER_BOX.UAT).esbServer))
			{
				// UAT Box ESB
				is.setEsb(SERVER_BOX.UAT);
			}

			if (hostName.equals(config.get(SERVER_BOX.UAT).serviceServer))
			{
				// UAT Box Services
				is.setServices(SERVER_BOX.UAT);
				is.setChaseOrbitalLineHandler();
			}

			if (hostName.equals(config.get(SERVER_BOX.UAT).keywordServer))
			{
				// UAT Box Keyword service
				is.setKeywordService(SERVER_BOX.UAT);
			}

			/* =================================== */
			/* Production Servers */
			/* =================================== */

			if (ownIP.getHostAddress().equalsIgnoreCase(config.get(SERVER_BOX.PROD).esbServer))
			{
				// PROD Box ESB
				is.setEsb(SERVER_BOX.PROD);
			}

			if (ownIP.getHostAddress().equalsIgnoreCase(ProdServiceServer1) || ownIP.getHostAddress().equalsIgnoreCase(ProdServiceServer2))
			{
				// PROD Box Services
				is.setServices(SERVER_BOX.PROD);
			}

			if (ownIP.getHostAddress().equalsIgnoreCase(config.get(SERVER_BOX.PROD).keywordServer))
			{
				// PROD Box Keyword Service
				is.setKeywordService(SERVER_BOX.PROD);
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setEsb(SERVER_BOX box) throws Exception
	{
		String esbProps = "C:\\SEMplestESB\\properties\\system.properties";

		Properties properties = new Properties();
		FileInputStream in = new FileInputStream(esbProps);
		properties.load(in);
		in.close();

		String esb = config.get(box).esbServer;
		properties.setProperty("BrokerIP", esb);

		FileOutputStream out = new FileOutputStream(esbProps);
		String comment = "ESB on " + box.name() + " Box. Updated by InstallationSetup (Nan).";
		properties.store(out, comment);
		out.close();
	}

	public void setServices(SERVER_BOX box)
	{
		String serviceName;
		String comment = "Service on " + box.name() + " Box. Updated by InstallationSetup (Nan).";
		String jdbc = config.get(box).jdbc;

		serviceName = "SemplestAdengineService";
		setProps(serviceName, jdbc, comment);

		serviceName = "SemplestBidGeneratorService";
		setProps(serviceName, jdbc, comment);

		serviceName = "SemplestChaseOrbitalGatewayService";
		setProps(serviceName, jdbc, comment);

		serviceName = "SemplestMailService";
		setProps(serviceName, jdbc, comment);

		serviceName = "SemplestSchedulerService";
		setProps(serviceName, jdbc, comment);
	}

	public void setKeywordService(SERVER_BOX box)
	{
		String serviceName = "SemplestKeywordGeneratorService";
		String comment = "Service on " + box.name() + " Box. Updated by InstallationSetup (Nan).";
		String jdbc = config.get(box).jdbc;

		setProps(serviceName, jdbc, comment);
	}

	public void setProps(String serviceName, String jdbc, String comment)
	{
		try
		{
			String path = "C:\\" + serviceName + "\\bin\\system.properties";
			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();

			FileWriter out = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(out);

			Date now = new Date();

			writer.write("#" + comment);
			writer.newLine();

			writer.write("#Date: " + now.toString());
			writer.newLine();

			writer.append("semplest.service" + " = " + properties.getProperty("semplest.service"));
			writer.newLine();
			writer.append("YAJSW.servicename" + " = " + properties.getProperty("YAJSW.servicename"));
			writer.newLine();
			writer.append("jdbc.driverClassName" + " = " + properties.getProperty("jdbc.driverClassName"));
			writer.newLine();
			writer.append("jdbc.url" + " = " + jdbc); // update the JDBC link
			writer.newLine();
			writer.append("jdbc.username" + " = " + properties.getProperty("jdbc.username"));
			writer.newLine();
			writer.append("jdbc.password" + " = " + properties.getProperty("jdbc.password"));
			writer.newLine();

			writer.close();
		}
		catch (FileNotFoundException e)
		{
			// file not found. probably the service is not installed.
			// do nothing
		}
		catch (IOException e)
		{
			// do nothing
		}
	}

	public void setChaseOrbitalLineHandler()
	{
		try
		{
			String path = "C:\\SemplestChaseOrbitalGatewayService\\config\\linehandler.properties";

			Properties properties = new Properties();
			FileInputStream in = new FileInputStream(path);
			properties.load(in);
			in.close();

			properties.setProperty("engine.hostname", "orbitalvar1.paymentech.net");
			properties.setProperty("engine.hostname.failover", "orbitalvar2.paymentech.net");

			FileOutputStream out = new FileOutputStream(path);
			String comment = "Updated by InstallationSetup. " + new Date();
			properties.store(out, comment);
		}
		catch (Exception e)
		{
			// do nothing
		}
	}

	public void init()
	{
		// for DEV box
		ServerConfiguration devConfig = new ServerConfiguration(DevJdbc, DevEsbServer, DevServiceServer, DevKeywordServer);
		config.put(SERVER_BOX.DEV, devConfig);

		// for TEST box
		ServerConfiguration testConfig = new ServerConfiguration(TestJdbc, TestEsbServer, TestServiceServer, TestKeywordServer);
		config.put(SERVER_BOX.TEST, testConfig);

		// for EXP box
		ServerConfiguration expConfig = new ServerConfiguration(ExpJdbc, ExpEsbServer, ExpServiceServer, ExpKeywordServer);
		config.put(SERVER_BOX.EXP, expConfig);

		// for UAT box
		ServerConfiguration uatConfig = new ServerConfiguration(UatJdbc, UatEsbServer, UatServiceServer, UatKeywordServer);
		config.put(SERVER_BOX.UAT, uatConfig);

		// for PRODUCTION box
		ServerConfiguration prodConfig = new ServerConfiguration(ProdJdbc, ProdEsbServer, ProdServiceServer1, ProdKeywordServer);
		config.put(SERVER_BOX.PROD, prodConfig);

	}

	public class ServerConfiguration
	{
		public String jdbc;
		public String esbServer;
		public String serviceServer;
		public String keywordServer;

		public ServerConfiguration()
		{
		}

		public ServerConfiguration(String jdbc, String esbServer, String serviceServer, String keywordServer)
		{
			super();
			this.jdbc = jdbc;
			this.esbServer = esbServer;
			this.serviceServer = serviceServer;
			this.keywordServer = keywordServer;
		}
	}

}
