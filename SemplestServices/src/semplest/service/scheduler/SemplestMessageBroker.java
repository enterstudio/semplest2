package semplest.service.scheduler;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

public class SemplestMessageBroker extends Thread
{
	//private Vector<SchedulerRecord> recordMessageList = null;
	private SimpleDateFormat MMddYYYYHHMMSS = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private SemplestScheduler scheduler = null;
	private static final Logger logger = Logger.getLogger(SemplestMessageBroker.class);

	private enum parameters
	{
		UserID, ScheduleID, TimeToRun, isDelete, ScheduleOrderID;
	}

	private BlockingQueue<Object> messageQueue = new LinkedBlockingQueue<Object>();

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
				String aMessage = (String) messageQueue.take();
				logger.info("MessageBroker ProcessMessage: " + aMessage);
				String userid = null, schedID = null, datetime = null, isdel = null, scheduleOrderID = null; // 
				// parse the message
				String[] command = aMessage.split("[;]");
				for (int i = 0; i < command.length; i++)
				{
					String[] val = command[i].split("[=]");
					parameters.valueOf(val[0]);
					if (val[0].equalsIgnoreCase(parameters.UserID.name()))
					{
						userid = val[1].trim();
					}
					else if (val[0].equalsIgnoreCase(parameters.ScheduleID.name()))
					{
						schedID = val[1].trim();
					}
					else if (val[0].equalsIgnoreCase(parameters.TimeToRun.name()))
					{
						datetime = val[1].trim();
					}
					else if (val[0].equalsIgnoreCase(parameters.isDelete.name()))
					{
						isdel = val[1].trim();
					}
					else if (val[0].equalsIgnoreCase(parameters.ScheduleOrderID.name()))
					{
						scheduleOrderID = val[1].trim();
					}

				}
				if (userid != null && schedID != null && datetime != null && isdel != null && scheduleOrderID != null)
				{
					try
					{
						logger.warn("UserID = " + userid + " schedID=" + schedID + " scheduleOrderID=" + scheduleOrderID);
						SchedulerRecord newschedule = new SchedulerRecord();
						newschedule.setUserID(userid);
						newschedule.setScheduleID(schedID);
						newschedule.setScheduleOrderID(scheduleOrderID);
						newschedule.setDelete(getDel(isdel));

						newschedule.setTimeToRunInMS(MMddYYYYHHMMSS.parse(datetime).getTime());
						// send to message processor
						logger.debug("messageProcessor.receiveSchedulerRecord(newschedule)");
						scheduler.receiveSchedulerRecord(newschedule);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
						logger.error("FAILED TO Add Schedule ID = " + schedID + ": DateTime parse error " + e.getMessage());
						return;
					}

				}
				else
				{
					logger.warn("One of the message parameters was null");
				}
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			logger.error("Error getting Message: " + e.getMessage());
		}
	}

	synchronized public void newMessageFromDB(Object data)
	{
		logger.debug("MessageBroker- New Message From DB:" + (String) data);
		messageQueue.add(data);
		logger.debug("messageQueue");
		/*
		 * Test
		 */
		Iterator<Object> it = messageQueue.iterator();
		int i = 0;
		while (it.hasNext())
		{
			String d = (String) it.next();
			logger.debug("messageQueue:" + i + " val=" + d);
			i++;
		}
	}

	
	private boolean getDel(String isDel)
	{
		if (isDel != null && isDel.trim().equals("1"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
}

