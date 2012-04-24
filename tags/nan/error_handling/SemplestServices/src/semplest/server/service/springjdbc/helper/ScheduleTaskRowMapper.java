package semplest.server.service.springjdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import semplest.server.service.springjdbc.TaskRunnerObj;

public class ScheduleTaskRowMapper implements RowMapper<TaskRunnerObj>
{
	public TaskRunnerObj mapRow(ResultSet rs, int row) throws SQLException
	{
		ScheduleTaskRSExtractor extractor = new ScheduleTaskRSExtractor();
		return extractor.extractData(rs);
	}

}
