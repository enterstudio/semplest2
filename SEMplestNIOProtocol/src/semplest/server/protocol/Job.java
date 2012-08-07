package semplest.server.protocol;

import java.util.Date;

public class Job
{
	private final Integer pk;
	private final JobName name;
	private final java.util.Date lastRunTime;
	
	public Job(Integer pk, JobName name, Date lastRunTime)
	{
		this.pk = pk;
		this.name = name;
		this.lastRunTime = lastRunTime;
	}

	public Integer getPk()
	{
		return pk;
	}

	public JobName getName()
	{
		return name;
	}

	public java.util.Date getLastRunTime()
	{
		return lastRunTime;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastRunTime == null) ? 0 : lastRunTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (lastRunTime == null)
		{
			if (other.lastRunTime != null)
				return false;
		}
		else if (!lastRunTime.equals(other.lastRunTime))
			return false;
		if (name != other.name)
			return false;
		if (pk == null)
		{
			if (other.pk != null)
				return false;
		}
		else if (!pk.equals(other.pk))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Job [pk=" + pk + ", name=" + name + ", lastRunTime=" + lastRunTime + "]";
	}
	
}
