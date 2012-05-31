package semplest.service.scheduler;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import semplest.server.service.springjdbc.SemplestDB;

public class SemplestMessageBroker extends Thread
{
	// private Vector<SchedulerRecord> recordMessageList = null;
	//private SimpleDateFormat MMddYYYYHHMMSS = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private SemplestScheduler scheduler = null;
	private static final Logger logger = Logger.getLogger(SemplestMessageBroker.class);
	private BlockingQueue<SchedulerRecord> messageQueue = new LinkedBlockingQueue<SchedulerRecord>();
	private String serviceName = "SemplestSchedulerService";

	public SemplestMessageBroker(Object synchLock, SemplestScheduler scheduler)
	{
		this.scheduler = scheduler;
	}

	public void run()
	{
		logger.info("Starting the SchedulerMessageBroker");

		while (true)
		{
			try
			{
				processMessage();
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				errorHandler(e);
			}

		}
	}

	private void processMessage()
	{
		// process data into schedulerRecord and put in messageList
		try
		{
			while (true)
			{
				SchedulerRecord newschedule = (SchedulerRecord) messageQueue.take();
				logger.info("MessageBroker ProcessMessage: " + newschedule.getScheduleID());
				// newschedule.setTimeToRunInMS(MMddYYYYHHMMSS.parse(newschedule.getTimeToRunInMS()).getTime());
				// send to message processor
				logger.debug("messageProcessor.receiveSchedulerRecord(newschedule)");
				scheduler.receiveSchedulerRecord(newschedule);
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			logger.error("Error getting Message: " + e.getMessage());
			errorHandler(e);
		}
	}

	synchronized public void newMessageFromWebService(SchedulerRecord data)
	{
		logger.debug("MessageBroker- New Message From DB:" +  data.getScheduleID());
		messageQueue.add(data);
		logger.debug("messageQueue");
		/*
		 * Test
		 */
		Iterator<SchedulerRecord> it = messageQueue.iterator();
		int i = 0;
		while (it.hasNext())
		{
			SchedulerRecord d = it.next();
			logger.debug("messageQueue:" + i + " val=" + d.getScheduleID() + ": job" + d.getScheduleJobID());
			i++;
		}
	}
	
	private void errorHandler(Exception e){
		SemplestDB db = new SemplestDB();
		db.logError(e, serviceName);
	}
	
}
