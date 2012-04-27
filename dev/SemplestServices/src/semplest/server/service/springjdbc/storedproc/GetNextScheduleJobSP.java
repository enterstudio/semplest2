package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.ScheduleJobObj;

public class GetNextScheduleJobSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetNextJobToRun";
	private static final RowMapper<ScheduleJobObj> ScheduleJobObjMapper = new BeanPropertyRowMapper(ScheduleJobObj.class);

	public GetNextScheduleJobSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlReturnResultSet("nextScheduledJob", ScheduleJobObjMapper));
		compile();
	}

	/*
	 * returns the next schedule job to run
	 */
	public ScheduleJobObj execute()
	{
		Map<String, Object> results = super.execute();
		if (results.get("nextScheduledJob") == null)
		{
			return null;
		}
		else
		{
			ArrayList<ScheduleJobObj> res = (ArrayList<ScheduleJobObj>) results.get("nextScheduledJob");
			if (res.size() > 0)
			{
				return res.get(0);
			}
			else
			{
				return null;
			}
		}
	}

}