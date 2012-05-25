package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class UpdateDefaultBidForKeywordsSP extends StoredProcedure
{
	private static final String SPROC_NAME = "UpdateDefaultBidForKeywords";

	public UpdateDefaultBidForKeywordsSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
	
		compile();

	}

	/*
	 * returns the next schedule job to run
	 */
	public void execute(Integer promotionPK, String advertisingEngine)
	{
		Map<String, Object> inputs = new HashMap<String, Object>();
		inputs.put("PromotionPK", promotionPK);
		inputs.put("AdvertisingEngine", advertisingEngine);
		Map results = super.execute(inputs);
	}
}