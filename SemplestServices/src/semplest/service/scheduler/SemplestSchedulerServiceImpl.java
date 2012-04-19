package semplest.service.scheduler;

import java.util.Vector;

import org.apache.log4j.Logger;

import semplest.services.client.interfaces.SemplestSchedulerInterface;

public class SemplestSchedulerServiceImpl implements SemplestSchedulerInterface
{
	private static final Logger logger = Logger.getLogger(SemplestSchedulerServiceImpl.class);

	@Override
	public void initializeService(String input) throws Exception
	{
		Object lock = new Object();
		Vector<SchedulerRecord> recordMessageList = new Vector<SchedulerRecord>();
		//Start the Scheduler
		SemplestScheduler scheduler = new SemplestScheduler(lock,recordMessageList);
		scheduler.start();
		SemplestMessageBroker messageBroker = new SemplestMessageBroker(lock, scheduler);
		messageBroker.start();
		logger.info("Started Semplest Scheduler Service");
		//load the next schedule from the DB
	}

}
