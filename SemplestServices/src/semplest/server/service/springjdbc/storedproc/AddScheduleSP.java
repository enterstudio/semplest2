package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Date;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class AddScheduleSP extends StoredProcedure
{
	private static final String SPROC_NAME = "AddSchedule";
	
	public AddScheduleSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("ScheduleName", Types.VARCHAR));
		declareParameter(new SqlParameter("StartTime", Types.TIMESTAMP));
		declareParameter(new SqlParameter("EndDate", Types.TIMESTAMP));
		declareParameter(new SqlParameter("Frequency", Types.VARCHAR));
		declareParameter(new SqlParameter("IsEnabled", Types.BIT));
		declareParameter(new SqlParameter("IsInactive", Types.BIT));
		declareParameter(new SqlParameter("PromotionFK", Types.INTEGER));
		declareParameter(new SqlParameter("CustomerFK", Types.INTEGER));
		declareParameter(new SqlParameter("ProductGroupFK", Types.INTEGER));
		declareParameter(new SqlParameter("UsersFK", Types.INTEGER));
		declareParameter(new SqlOutParameter("ID", Types.INTEGER));
		compile();
	}

	/*
	 * returns the next schedule job to run
	 */
	public Integer execute(String ScheduleName, Date StartTime, Date EndDate, String Frequency, boolean isEnabled, boolean isInactive, Integer PromotionID, Integer CustomerID, Integer ProductGroupID, Integer UserID)
	{
		Map<String, Object> results = super.execute(ScheduleName, StartTime, EndDate, Frequency, isEnabled, isInactive, PromotionID, CustomerID, ProductGroupID, UserID);
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
