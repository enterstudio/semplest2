package semplest.services.client.interfaces;

public interface SemplestSchedulerInterface extends ServiceInitialize
{
	public abstract Boolean NewSchedule(Integer scheduleJobID,Integer ScheduleID,java.util.Date StartTime, Boolean IsDelete) throws Exception;
}
