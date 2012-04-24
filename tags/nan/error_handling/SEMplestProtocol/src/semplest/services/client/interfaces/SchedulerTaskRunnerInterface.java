package semplest.services.client.interfaces;

import semplest.server.protocol.TaskOutput;

public interface SchedulerTaskRunnerInterface
{
	public abstract TaskOutput RunTask(String method, String jsonParameters, String optionalTimeoutMS, TaskOutput previousTaskOutput) throws Exception; 
}
