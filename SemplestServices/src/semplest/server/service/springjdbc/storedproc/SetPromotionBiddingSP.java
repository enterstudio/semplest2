package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class SetPromotionBiddingSP extends StoredProcedure
{
	private static final String SPROC_NAME = "SetPromotionBidding";

	public SetPromotionBiddingSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionID", Types.INTEGER));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("PromotionBiddingType", Types.VARCHAR));
		declareParameter(new SqlOutParameter("ID", Types.INTEGER));
		
		compile();

	}

	/*
	 * returns the next schedule job to run
	 */
	public Integer execute(Integer PromotionID, String AdvertisingEngine, String PromotionBiddingType)
	{
		Map<String, Object> results = super.execute(PromotionID, AdvertisingEngine, PromotionBiddingType);
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
