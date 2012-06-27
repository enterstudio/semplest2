package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.protocol.adengine.TrafficEstimatorDataObject;
import semplest.server.service.springjdbc.BaseDB;

public class GetLatestTrafficEstimatorSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetLatestTrafficEstimator";
	private static final RowMapper<TrafficEstimatorDataObject> trafficEstDataObjMapper = new BeanPropertyRowMapper(TrafficEstimatorDataObject.class);
	
	public GetLatestTrafficEstimatorSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("Keyword", Types.VARCHAR));
		declareParameter(new SqlReturnResultSet("traffic", trafficEstDataObjMapper));
		compile();
	}
	
	public List<TrafficEstimatorDataObject> execute(int promotionID, String optionalKeyword, AdEngine advertisingEngine )
	{
		Map<String, Object> results = super.execute(new Object[] {promotionID, advertisingEngine, optionalKeyword});
		if (results.get("traffic") == null)
		{
			return null;
		}
		else
		{
			return (ArrayList<TrafficEstimatorDataObject>) results.get("traffic");
		}
	}

}
