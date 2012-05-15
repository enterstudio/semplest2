package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Date;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class GetSpendForPromotionSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetSpendForPromotion";
	
	public GetSpendForPromotionSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("StartDate", Types.TIMESTAMP));
		declareParameter(new SqlParameter("EndDate", Types.TIMESTAMP));
		declareParameter(new SqlOutParameter("Cost", Types.BIGINT));
		compile();
	}

	/*
	 * returns KeywordBidPK
	 */
	public Long execute(int PromotionPK, String AdvertisingEngine, Date StartDate, Date EndDate) throws Exception
	{
		Map<String, Object> results = super.execute(PromotionPK, AdvertisingEngine, StartDate, EndDate);
		if (results.get("Cost") == null)
		{
			return null;
		}
		else
		{
			return (Long) results.get("Cost");
		}
	}
}
