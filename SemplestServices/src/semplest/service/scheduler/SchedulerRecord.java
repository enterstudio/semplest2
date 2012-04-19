package semplest.service.scheduler;

public class SchedulerRecord
{

	private String scheduleID;
	private String scheduleOrderID;
	private long timeToRunInMS;
	private String UserID;
	private boolean IsDelete = false;

	public long getTimeToRunInMS()
	{
		return timeToRunInMS;
	}

	public void setTimeToRunInMS(long timeToRunInMS)
	{
		this.timeToRunInMS = timeToRunInMS;
	}

	

	public String getUserID()
	{
		return UserID;
	}

	public void setUserID(String userID)
	{
		UserID = userID;
	}

	public String getScheduleOrderID()
	{
		return scheduleOrderID;
	}

	public void setScheduleOrderID(String scheduleOrderID)
	{
		this.scheduleOrderID = scheduleOrderID;
	}

	public boolean isDelete()
	{
		return IsDelete;
	}

	public void setDelete(boolean isDelete)
	{
		IsDelete = isDelete;
	}

	public String getScheduleID()
	{
		return scheduleID;
	}

	public void setScheduleID(String scheduleID)
	{
		this.scheduleID = scheduleID;
	}

	
}
