package semplest.server.service.springjdbc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

public class AddTaskSP extends StoredProcedure
{
	private static final String SPROC_NAME = "AddTask";
	
	public AddTaskSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("ServiceName", Types.VARCHAR));
		declareParameter(new SqlParameter("MethodName", Types.VARCHAR));
		declareParameter(new SqlParameter("Parameters", Types.VARCHAR));
		declareParameter(new SqlOutParameter("ID", Types.INTEGER));
		compile();
	}

	/*
	 * returns the next schedule job to run
	 */
	public Integer execute(String ServiceName, String MethodName, String Parameters)
	{
		Map<String, Object> results = super.execute(ServiceName, MethodName, Parameters);
		if (results.get("ID") == null)
		{
			return null;
		}
		else
		{
			Integer res = (Integer) results.get("ID");
			if (res == null)
			{
				return null;
			}
			else
			{
				return res;
			}
		}
	}
}
