package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Date;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class UpdateRemainingBudgetInCycleSP  extends StoredProcedure
{
	private static final String SPROC_NAME = "UpdateRemainingBudgetInCycle";
	
	public UpdateRemainingBudgetInCycleSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlParameter("StartDate", Types.TIMESTAMP));
		declareParameter(new SqlParameter("EndDate", Types.TIMESTAMP));
		declareParameter(new SqlOutParameter("ID", Types.BIGINT));
		compile();
	}

	/*
	 * returns KeywordBidPK
	 */
	public Integer execute(int PromotionPK, Date StartDate, Date EndDate) throws Exception
	{
		Map<String, Object> results = super.execute(PromotionPK, StartDate, EndDate);
		if (results.get("ID") == null)
		{
			return null;
		}
		else
		{
			return ((Long)results.get("ID")).intValue();
		}
	}
}
