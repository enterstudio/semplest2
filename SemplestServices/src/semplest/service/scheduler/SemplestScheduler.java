package semplest.service.scheduler;

import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.TaskOutput;
import semplest.server.service.springjdbc.TaskRunnerDB;
import semplest.server.service.springjdbc.TaskRunnerObj;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;



public class SemplestScheduler extends Thread
{

	private Object lock = null;
	private boolean runSchedule = true;
	private SimpleDateFormat MMddYYYYHHMMSS = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private boolean cancel = false;
	private boolean scheduleRunning = false;
	private static final Logger logger = Logger.getLogger(SemplestScheduler.class);

	private Vector<SchedulerRecord> recordMessageList = null;

	public SemplestScheduler(Object synchLock, Vector<SchedulerRecord> recordMessageList)
	{
		this.recordMessageList = recordMessageList;
		lock = synchLock;
	}
	/*
	 * TEST
	 */
	public static final String PROPSFILE = "bin/system.properties";
	public static final String LOG4JPROPSFILE = "properties/log4j_server.properties";
	private static String url = "http://VMJAVA1:9898/semplest";

	public static ClassPathXmlApplicationContext appContext = null;
	public static void main(String[] args)
	{
		appContext = new ClassPathXmlApplicationContext("Service.xml");
		SemplestScheduler s = new SemplestScheduler(null,null);
		Boolean res = s.runScheduledTasks(0, 2);
		
	}

	synchronized public void run()
	{

		// long delay;
		while (true)
		{
			try
			{
				SchedulerRecord runData = null;
				// loop until a time has been reached, or passed
				while (true)
				{
					// get copy of first in queue
					synchronized (lock)
					{
						runData = getNextScheduleToRun();
					}

					if (runData == null)
					{
						logger.debug("Nothing to Run...waiting");
						wait(0);
						logger.debug("Received Notify");
						runSchedule = true;
					}
					else
					{

						long delay = runData.getTimeToRunInMS() - System.currentTimeMillis();
						logger.info("Waiting to run " + String.valueOf(delay) + " ms");
						if (delay > 0)
						{
							wait(delay);
						}
						else
						{
							wait(100);
						}
						// reached the time to run
						if (runSchedule & !cancel)
						{

							logger.debug("????????????????????????????????????????????????");
							logger.debug("????????????????????????????????????????????????");
							logger.debug("Run Schedule:" + runData.getScheduleID());
							
							
							scheduleRunning = true;
							Boolean result = runSchedule(runData);
							
							logger.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							logger.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							logger.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							

							if (result != null)
							{
								// write result to DB
								logger.debug("*****Write Result to DB for : User" + runData.getUserID() + " ScheduleID=" + runData.getScheduleID());
								//****SetScheduleOrderDataComplete(Integer.parseInt(runData.getScheduleOrderID()),Integer.parseInt(runData.getScheduleID()), result.booleanValue(), Integer.parseInt(runData.getUserID()));
								// remove the schedule and report the result
								synchronized (lock)
								{
									removeScheduleToRun(runData.getScheduleID());
								}
							}
							scheduleRunning = false;
							logger.debug("Run Sched UN-Lock:" + runData.getScheduleID());
						}
						else
						{
							logger.debug("Schedlue Cancel:" + runData.getScheduleID());
							cancel = false;
						}
					}
					runSchedule = true; // reset
				}

			}

			catch (InterruptedException ie)
			{
				// do nothing
			}
			catch (Exception e)
			{
				logger.error(e);
			}
		}
	}

	synchronized public void go(boolean runit, boolean cancel)
	{
		runSchedule = runit;
		this.cancel = cancel;
		notify();
	}

	/*
	 * Add record in correct order in list
	 */
	synchronized public void receiveSchedulerRecord(SchedulerRecord record)
	{
		logger.debug("Message Processor - receiveSchedulerRecord User " + record.getUserID() + " schedID=" + record.getScheduleID() + ":" + record.getTimeToRunInMS());
		if (recordAlreadyExist(record))
		{
			logger.debug("Ignor - Received the same message for " + record.getScheduleID() + ": user " + record.getUserID() + " at Time " + record.getTimeToRunInMS());
		}
		else
		{
			synchronized (lock)
			{
				int pos = findPositionOfscheduleID(record.getScheduleID());
				if (record.isDelete())
				{
					// Trying to remove the Head of the list
					if (pos == 0)
					{
						if (!this.scheduleRunning)
						{
							cancel = true;
							recordMessageList.remove(0);
							notify();
						}
						else
						// already running
						{
							// nothing to do just let it complete
						}
					}
					else if (pos != -1)
					{
						// just remove
						recordMessageList.remove(pos);
					}

				}
				else //adding a new record
				{
					if (recordMessageList.isEmpty())
					{
						recordMessageList.add(record);
						logger.debug("%%%%%%%%%%recordMessageList Empty - Add");
						notify();
					}
					else
					// iterate through and add in correct order
					{
						// new Add
						if (pos == -1)
						{
							int posToAdd = findPositionToAdd(record);
							// add at end?
							if (posToAdd == recordMessageList.size())
							{
								recordMessageList.add(record);
								logger.debug("++++++++Add to end at " + posToAdd);
							}
							else if (posToAdd == 0) // replace the current
							{
								logger.debug("------------------Replace the head of queue");
								if (!this.scheduleRunning)
								{
									cancel = true;
									recordMessageList.add(0, record);
									notify();
								}
								else
								// just add to the head - the running Schedule will be deleted
								{
									recordMessageList.add(0, record);
								}
							}
						}
						else
						// already there so need to replace and put in the right order
						{
							int posToAdd = findPositionToAdd(record);
							// remove and put back in
							if (pos == 0)
							{

								// rest if schedule is not already running otherwise just let it go
								if (!this.scheduleRunning)
								{
									recordMessageList.remove(0);
									cancel = true;

									recordMessageList.add(0, record);
									logger.debug("Already There in Pos 0 - replace");

									notify();
								}
							}
							else
							// put into correct position
							{
								if (posToAdd == recordMessageList.size())
								{
									recordMessageList.add(record);
									logger.debug("++++++++Add to end at " + posToAdd);
								}
								else
								{
									recordMessageList.add(posToAdd, record);
									logger.debug("++++++++Add at Pos=" + posToAdd);
								}
							}
						}
					}
				}
				/*
				 * Test
				 */
				for (int i = 0; i < recordMessageList.size(); i++)
				{
					String timetorun = MMddYYYYHHMMSS.format(new java.util.Date(recordMessageList.get(i).getTimeToRunInMS()));
					logger.debug("recordMessageList(" + i + ")=" + recordMessageList.get(i).getScheduleID() + " Time to Run: " + timetorun);
				}

			}
		}
	}

	private boolean recordAlreadyExist(SchedulerRecord record)
	{
		for (SchedulerRecord rec : recordMessageList)
		{
			if (record.getScheduleID().equals(rec.getScheduleID()) && record.getTimeToRunInMS() == rec.getTimeToRunInMS()) 
			{
				return true;
			}
		}
		return false;
	}
	/*
	 * Should be based on ScheduleOrderID?
	 */
	private boolean removeScheduleToRun(Integer ScheduleID)
	{
		try
		{
			int pos = findPositionOfscheduleID(ScheduleID);
			if (pos != -1)
			{
				SchedulerRecord removed = recordMessageList.remove(pos);
				if (removed != null)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				logger.warn("Could not find record to delete for schedule:" + ScheduleID);
				return false;
			}
		}
		catch (Exception e)
		{
			logger.error("Error removeScheduleToRun: " + e.getMessage() + " for schedule:" + ScheduleID);
			return false;

		}
	}

	private int findPositionToAdd(SchedulerRecord record)
	{
		int i = 0;

		for (SchedulerRecord rec : recordMessageList)
		{
			if (record.getTimeToRunInMS() < rec.getTimeToRunInMS())
			{
				break;
			}
			else
			{
				i++;
			}
		}
		return i;
	}

	private int findPositionOfscheduleID(Integer ScheduleID)
	{
		int i = 0;
		int pos = -1;
		for (SchedulerRecord rec : recordMessageList)
		{
			if (rec.getScheduleID().equals(ScheduleID))
			{
				pos = i;
				break;

			}
			else
			{
				i++;
			}
		}
		return pos;
	}

	private Boolean runSchedule(SchedulerRecord runData)
	{
		// Serialize Each Schedule For Now
		try
		{

			if (!this.getNextScheduleToRun().equals(runData))
			{
				logger.debug("SKIPPING OLD DATA:" + runData.getScheduleID());
				return null;
			}
			Boolean res = runScheduledTasks(runData.getUserID(), runData.getScheduleID());

			return res;

			//
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	private synchronized SchedulerRecord getNextScheduleToRun()
	{
		if (this.recordMessageList.isEmpty())
		{
			return null;
		}
		else
		// get first in list
		{
			return this.recordMessageList.get(0);
		}
		// return schedulerData.getScheduleToRun();
	}

	private Boolean runScheduledTasks(Integer UserID, Integer SchedulePK)
	{
		java.util.Date startTime = null;
		try
		{
			Calendar c = Calendar.getInstance();
			startTime = c.getTime();
		}
		catch (Exception e2)
		{
			logger.error("Error Getting StartTime" + e2.getMessage());
			e2.printStackTrace();
			return false;
		}
		HashMap<String, TaskOutput> TaskOutputData = new HashMap<String, TaskOutput>();
		if (UserID == null || SchedulePK == null)
		{
			logger.error("Cannot execute runScheduledTasks:  UserID = <" + UserID + "> SCHEDULEPK=<" + SchedulePK + ">");
			return false;
		}

		
		TaskOutput previousTaskOutput = null; // First TaskOutput is null
		//Run the Set of Tasks and return the output
		TaskRunnerDB tasks = new TaskRunnerDB();
		List<TaskRunnerObj> listofTasks = tasks.getScheduleTasks(SchedulePK);
		if (!listofTasks.isEmpty())
		{
			try
			{
				for (int i = 0; i < listofTasks.size(); i++)
				{
					TaskRunnerObj taskObj = listofTasks.get(i);
					System.out.println(taskObj.getServiceName() + ":" + taskObj.getMethodName() + ":" + taskObj.getParameters());
					Class taskClass = Class.forName(taskObj.getServiceName());
					Constructor taskConstructor = taskClass.getDeclaredConstructor(String.class);
					SchedulerTaskRunnerInterface taskRunner =  (SchedulerTaskRunnerInterface) taskConstructor.newInstance(new Object[] {url});
					previousTaskOutput = taskRunner.RunTask(taskObj.getMethodName(),taskObj.getParameters(), null, previousTaskOutput);
					TaskOutputData.put(String.valueOf(taskObj.getTaskExecutionOrder()), previousTaskOutput);
					taskRunner = null;
				}
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("No tasks found");
		}
		
		
		//UpdateSchedule(BPMUtil.parseInt(UserID), BPMUtil.parseInt(SchedulePK), true, previousTaskOutput.isSuccess(), null);
		return true;
	}

}

