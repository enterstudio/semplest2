package semplest.system.monitor;

import semplest.server.protocol.ProtocolEnum.ServiceStatus;
import semplest.services.client.interfaces.ServiceInitialize;
import semplest.system.monitor.MonitorObject.SERVER;
import semplest.system.monitor.MonitorObject.SERVICE;

public class MonitorThread implements Runnable
{

	private MonitorObject monitor = new MonitorObject();
	private MonitorDB db = new MonitorDB();

	private SERVICE service;
	private ServiceInitialize serviceObject;

	public MonitorThread(SERVICE service, ServiceInitialize serviceObject)
	{
		this.service = service;
		this.serviceObject = serviceObject;
	}

	@Override
	public void run()
	{
		while (!monitor.isStop())
		{
			try
			{
				monitor.loadConfig();
				System.out.println(monitor.isStop());

				for (SERVER server : SERVER.values())
				{
					if (monitor.isMonitorServer(server))
					{
						String esbUrl = monitor.getServerEsbUrl(server);

						try
						{
							String ret = serviceObject.checkStatus(esbUrl, monitor.getClientTimeout());

							if (ret.equals(ServiceStatus.Up.getServiceStatusValue()))
							{
								System.out.println(service.name() + " is running fine on " + server.name());
								ServiceStatus status = ServiceStatus.Up;
								monitor.setServerServiceStatus(server, status);
								db.storeServerServiceStatus(server, service, status);
								if (monitor.isServerServiceUp(server))
								{
									// if the service used to be down, but just came back up, send notification
									Notification.sendNotification(server, service, null);
								}
							}
							else
							{
								onError(server, new Exception("Service Status - " + ret));
							}
						}
						catch (Exception e)
						{
							onError(server, e);
						}
					}
				}

				Thread.sleep(monitor.getSleepTime());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private void onError(SERVER server, Exception e)
	{
		System.out.println(service.name() + " is not running on " + server.name() + " - " + e.getMessage());
		// The service is not healthy
		ServiceStatus status = ServiceStatus.Down;
		monitor.setServerServiceStatus(server, status);
		db.storeServerServiceStatus(server, service, status);
		if (monitor.isServerServiceDown(server))
		{
			// if the service just went down. send notification
			Notification.sendNotification(server, service, e.getMessage());
		}
	}
}
