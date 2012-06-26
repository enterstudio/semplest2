package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class AddTrafficEstimatorSP extends StoredProcedure
{
	private static final String SPROC_NAME = " AddTrafficEstimator";

	public  AddTrafficEstimatorSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionID", Types.INTEGER));
		declareParameter(new SqlParameter("Keyword", Types.VARCHAR));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("BidType", Types.VARCHAR));
		declareParameter(new SqlParameter("MicroBid", Types.INTEGER));
		declareParameter(new SqlParameter("AveMicroCost", Types.FLOAT));
		declareParameter(new SqlParameter("AveNumberClicks", Types.FLOAT));
		declareParameter(new SqlParameter("AvePosition", Types.FLOAT));
		declareParameter(new SqlParameter("AveCPC", Types.FLOAT));
		declareParameter(new SqlParameter("currentTime", Types.TIMESTAMP));

		compile();
	}

	public void execute(int PromotionID, String Keyword, String AdvertisingEngine, String BidType, Integer MicroBid, Float AveMicroCost,
			Float AveNumberClicks, Float AvePosition, Float AveCPC, java.util.Date currentTime) throws Exception
	{
		Map<String, Object> results = super.execute(PromotionID, Keyword, AdvertisingEngine, BidType,  MicroBid, AveMicroCost,
				AveNumberClicks,AvePosition, AveCPC, currentTime);
	}
}
