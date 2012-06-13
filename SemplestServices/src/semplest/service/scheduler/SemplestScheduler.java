package semplest.service.scheduler;

import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import semplest.server.protocol.TaskOutput;
import semplest.server.service.SemplestConfiguration;
import semplest.server.service.springjdbc.ScheduleJobObj;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.server.service.springjdbc.TaskRunnerObj;
import semplest.server.service.springjdbc.storedproc.SetScheduleJobCompleteSP;
import semplest.services.client.interfaces.SchedulerTaskRunnerInterface;
import semplest.util.SemplestErrorHandler;



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
	private static String url = (String) SemplestConfiguration.configData.get("ESBWebServerURL");
	//private static String url = "http://localhost:9898/semplest";

	public static ClassPathXmlApplicationContext appContext = null;
	public static void main(String[] args)
	{
		appContext = new ClassPathXmlApplicationContext("Service.xml");
		SemplestScheduler s = new SemplestScheduler(null,null);
		Boolean res = s.runScheduledTasks(1, 2);
		
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
							logger.debug("Run Schedule:" + runData.getScheduleJobID());
							
							
							scheduleRunning = true;
							Boolean result = runSchedule(runData);													
							
							
							logger.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							logger.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							logger.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							

							if (result != null)
							{
								logger.debug("removeScheduleToRun : ScheduleJobID=" + runData.getScheduleJobID());
								// remove the schedule and report the result
								synchronized (lock)
								{
									removeScheduleToRun(runData.getScheduleJobID());
								}
							}
							scheduleRunning = false;
							logger.debug("Run Sched UN-Lock:" + runData.getScheduleJobID());
						}
						else
						{
							logger.debug("Schedlue Cancel:" + runData.getScheduleJobID());
							cancel = false;
						}
					}
					runSchedule = true; // reset
				}

			}

			catch (InterruptedException ie)
			{
				logger.error(ie);
				SemplestErrorHandler.logToDatabase(ie);
			}
			catch (Exception e)
			{
				logger.error(e);
				SemplestErrorHandler.logToDatabase(e);
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
	synchronized public void receiveSchedulerRecord(SchedulerRecord scheduleRecord)
	{
		logger.debug("Message Processor -job" + scheduleRecord.getScheduleJobID() +":" + "schedID=" + scheduleRecord.getScheduleID() + ":" + scheduleRecord.getTimeToRunInMS());
		if (recordAlreadyExist(scheduleRecord))
		{
			logger.debug("Ignor - Received the same message for " + scheduleRecord.getScheduleID() + " at Time " + scheduleRecord.getTimeToRunInMS());
		}
		else if (scheduleRecord.getScheduleJobID() == null)
		{
			logger.error("Received message with no JobID for " + scheduleRecord.getScheduleID() + " at Time " + scheduleRecord.getTimeToRunInMS());
		}
		else
		{
			synchronized (lock)
			{
				int pos = findPositionOfscheduleJobID(scheduleRecord.getScheduleJobID());
				if (scheduleRecord.getIsDelete())
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
						recordMessageList.add(scheduleRecord);
						logger.debug("%%%%%%%%%%recordMessageList Empty - Add");
						notify();
					}
					else
					// iterate through and add in correct order
					{
						// new Add
						if (pos == -1)
						{
							int posToAdd = findPositionToAdd(scheduleRecord);
							// add at end?
							if (posToAdd == recordMessageList.size())
							{
								recordMessageList.add(scheduleRecord);
								logger.debug("++++++++Add to end at " + posToAdd);
							}
							else if (posToAdd == 0) // replace the current
							{
								logger.debug("------------------Replace the head of queue");
								if (!this.scheduleRunning)
								{
									cancel = true;
									recordMessageList.add(0, scheduleRecord);
									notify();
								}
								else
								// just add to the head - the running Schedule will be deleted
								{
									recordMessageList.add(0, scheduleRecord);
								}
							}
						}
						else
						// already there so need to replace and put in the right order
						{
							int posToAdd = findPositionToAdd(scheduleRecord);
							// remove and put back in
							if (pos == 0)
							{

								// rest if schedule is not already running otherwise just let it go
								if (!this.scheduleRunning)
								{
									recordMessageList.remove(0);
									cancel = true;

									recordMessageList.add(0, scheduleRecord);
									logger.debug("Already There in Pos 0 - replace");

									notify();
								}
							}
							else
							// put into correct position
							{
								if (posToAdd == recordMessageList.size())
								{
									recordMessageList.add(scheduleRecord);
									logger.debug("++++++++Add to end at " + posToAdd);
								}
								else
								{
									recordMessageList.add(posToAdd, scheduleRecord);
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
					logger.debug("recordMessageList(" + i + ")=" + recordMessageList.get(i).getScheduleJobID() + ":" + recordMessageList.get(i).getScheduleID() + " Time to Run: " + timetorun);
				}

			}
		}
	}

	private boolean recordAlreadyExist(SchedulerRecord record)
	{
		for (SchedulerRecord rec : recordMessageList)
		{
			if (record.getScheduleJobID().equals(rec.getScheduleJobID())) 
			{
				return true;
			}
		}
		return false;
	}
	/*
	 *
	 */
	private boolean removeScheduleToRun(Integer ScheduleJobID)
	{
		try
		{
			int pos = findPositionOfscheduleJobID(ScheduleJobID);
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
				logger.warn("Could not find record to delete for schedule job:" + ScheduleJobID);
				return false;
			}
		}
		catch (Exception e)
		{
			logger.error("Error removeScheduleToRun: " + e.getMessage() + " for schedule job:" + ScheduleJobID);
			SemplestErrorHandler.logToDatabase(new Exception("Error removeScheduleToRun: " + e.getMessage() + " for schedule job:" + ScheduleJobID, e));
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

	private int findPositionOfscheduleJobID(Integer ScheduleJobID)
	{
		int i = 0;
		int pos = -1;
		for (SchedulerRecord rec : recordMessageList)
		{
			if (rec.getScheduleJobID().equals(ScheduleJobID))
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
			//Test_Nan: log some test data to the TestData table in the database
			SemplestErrorHandler.logTest(new Date(), "scheduler", "runSchedule", runData.toString(), null);

			if (!this.getNextScheduleToRun().equals(runData))
			{
				logger.debug("SKIPPING OLD DATA:" + runData.getScheduleID());
				return null;
			}
			Boolean res = runScheduledTasks(runData.getScheduleJobID(),runData.getScheduleID());

			return res;

			//
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());		
			SemplestErrorHandler.logToDatabase(e);
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

	private Boolean runScheduledTasks(Integer scheduleJobPK, Integer SchedulePK)
	{
		
		HashMap<String, TaskOutput> TaskOutputData = new HashMap<String, TaskOutput>();
		if (SchedulePK == null)
		{
			logger.error("Cannot execute runScheduledTasks: SCHEDULEPK=<" + SchedulePK + ">");
			return false;
		}

		
		TaskOutput previousTaskOutput = null; // First TaskOutput is null
		//Run the Set of Tasks and return the output
		try
		{
			List<TaskRunnerObj> listofTasks = SemplestDB.getScheduleTasks(SchedulePK);
			if (!listofTasks.isEmpty())
			{
				try
				{
					for (int i = 0; i < listofTasks.size(); i++)
					{
						TaskRunnerObj taskObj = listofTasks.get(i);
						logger.debug("Running Task: " + taskObj.getServiceName() + ":" + taskObj.getMethodName() + ":" + taskObj.getParameters());
						Class taskClass = Class.forName(taskObj.getServiceName());
						Constructor taskConstructor = taskClass.getDeclaredConstructor(String.class);
						SchedulerTaskRunnerInterface taskRunner =  (SchedulerTaskRunnerInterface) taskConstructor.newInstance(new Object[] {url});
						previousTaskOutput = taskRunner.RunTask(taskObj.getMethodName(),taskObj.getParameters(), null, previousTaskOutput);
						TaskOutputData.put(String.valueOf(taskObj.getTaskExecutionOrder()), previousTaskOutput);
						taskRunner = null;
						
						//Test_Nan: log some test data to the TestData table in the database
						SemplestErrorHandler.logTest(new Date(), "scheduler", "runScheduledTasks", taskObj.getServiceName() + ":" + taskObj.getMethodName() + ":" + taskObj.getParameters(), null);
					}
					//TODO: send email for successfully executed schedule	
				}
				catch (Exception e)
				{
					TaskOutput errorOutput = new TaskOutput();
					errorOutput.setIsSuccessful(false);
					errorOutput.setErrorMessage(e.getMessage());
					previousTaskOutput = errorOutput;
					logger.error(e.getMessage());			
					SemplestErrorHandler.logToDatabase(e);
					//TODO: send email is successful = false
				}				 
				//Update results to the DB and add next Job if necessary
				logger.debug("getNextJobToExecute after running job = " + scheduleJobPK);
				getNextJobToExecute(scheduleJobPK, previousTaskOutput.getIsSuccessful(), previousTaskOutput.getErrorMessage());
			}
			else
			{
				System.out.println("No tasks found");
				
				//Test_Nan: log some test data to the TestData table in the database
				SemplestErrorHandler.logTest(new Date(), "scheduler", "runScheduledTasks", "No tasks found", null);
			}
			return true;
		}
		catch (Exception e)
		{
			logger.error("runScheduledTasks:" + e.getMessage());
			e.printStackTrace();
			SemplestErrorHandler.logToDatabase(e);
			return false;
		}
	}
	
	private void getNextJobToExecute(Integer scheduleJobID, boolean IsSuccessful, String ErrorMessage) throws Exception
	{
		SetScheduleJobCompleteSP getNextJob = new SetScheduleJobCompleteSP();
		ScheduleJobObj nextJob = getNextJob.execute(scheduleJobID, IsSuccessful, ErrorMessage);
		if (nextJob != null)
		{
			SchedulerRecord newschedule = new SchedulerRecord();
			newschedule.setScheduleJobID(nextJob.getScheduleJobPK());
			newschedule.setIsDelete(false);
			newschedule.setScheduleID(nextJob.getScheduleFK());
			newschedule.setTimeToRunInMS(nextJob.getExecutionStartTime().getTime());
			
			//Test_Nan: log some test data to the TestData table in the database
			SemplestErrorHandler.logTest(new Date(), "scheduler", "getNextJobToExecute", nextJob.toString(), null);
			synchronized (lock)
			{
				this.receiveSchedulerRecord(newschedule);
			}
		}
		else
		{
			logger.debug("Get Next Job to Run returned null");
		}
	}
	
}

