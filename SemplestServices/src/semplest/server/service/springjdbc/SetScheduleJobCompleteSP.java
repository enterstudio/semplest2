package semplest.server.service.springjdbc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class SetScheduleJobCompleteSP extends StoredProcedure
{
	private static final String SPROC_NAME = "SetScheduleJobComplete";
	private static final RowMapper<ScheduleJobObj> ScheduleJobObjMapper = new BeanPropertyRowMapper(ScheduleJobObj.class);

	public SetScheduleJobCompleteSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlReturnResultSet("nextScheduledJob", ScheduleJobObjMapper));
		declareParameter(new SqlParameter("ScheduleJobID", Types.INTEGER));
		declareParameter(new SqlParameter("IsSuccessful", Types.BIT));
		declareParameter(new SqlParameter("ErrorMessage", Types.VARCHAR));
		// declareParameter(new SqlOutParameter("titles", , new TitleMapper()));
		compile();

	}

	/*
	 * returns the next schedule job to run
	 */
	public ScheduleJobObj execute(Integer ScheduleJobID, boolean IsSuccessful, String ErrorMessage)
	{
		Map<String, Object> inputs = new HashMap<String, Object>();
		inputs.put("ScheduleJobID", ScheduleJobID.intValue());
		inputs.put("IsSuccessful", IsSuccessful);
		inputs.put("ErrorMessage", ErrorMessage);
		Map results = super.execute(inputs);
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
