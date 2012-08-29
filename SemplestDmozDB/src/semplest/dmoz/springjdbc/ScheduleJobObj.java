package semplest.dmoz.springjdbc;

import java.util.Date;

public class ScheduleJobObj
{
	private Integer ScheduleJobPK;
	private Integer ScheduleFK;
	private Date ExecutionStartTime;
	public Integer getScheduleJobPK()
	{
		return ScheduleJobPK;
	}
	public void setScheduleJobPK(Integer scheduleJobPK)
	{
		ScheduleJobPK = scheduleJobPK;
	}
	public Integer getScheduleFK()
	{
		return ScheduleFK;
	}
	public void setScheduleFK(Integer scheduleFK)
	{
		ScheduleFK = scheduleFK;
	}
	public Date getExecutionStartTime()
	{
		return ExecutionStartTime;
	}
	public void setExecutionStartTime(Date executionStartTime)
	{
		ExecutionStartTime = executionStartTime;
	}

}
