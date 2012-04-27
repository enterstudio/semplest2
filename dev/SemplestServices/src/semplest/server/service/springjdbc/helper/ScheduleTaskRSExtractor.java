package semplest.server.service.springjdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import semplest.server.service.springjdbc.TaskRunnerObj;

public class ScheduleTaskRSExtractor
{
	public TaskRunnerObj extractData(ResultSet rs) throws SQLException, DataAccessException
	{
		TaskRunnerObj task = new TaskRunnerObj();
		task.setMethodName(rs.getString("MethodName").trim());
		task.setParameters(rs.getString("Parameters").trim());
		task.setSchedulePK(rs.getInt("SchedulePK"));
		task.setServiceName(rs.getString("ServiceName").trim());
		task.setTaskExecutionOrder(rs.getInt("TaskExecutionOrder"));
		return task;
		
	}

}
