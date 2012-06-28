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
import semplest.server.protocol.adengine.KeywordDataObject;
import semplest.server.service.springjdbc.BaseDB;

public class GetBiddableAdGroupCriteriaSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetBiddableAdGroupCriteria";
	private static final RowMapper<KeywordDataObject> bidObjMapper = new BeanPropertyRowMapper(KeywordDataObject.class);
	
	public GetBiddableAdGroupCriteriaSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlReturnResultSet("biddable", bidObjMapper));
		compile();
	}
	
	public List<KeywordDataObject> execute(int promotionID, AdEngine advertisingEngine )
	{
		Map<String, Object> results = super.execute(new Object[] {promotionID, advertisingEngine.name()});
		if (results.get("biddable") == null)
		{
			return null;
		}
		else
		{
			return (ArrayList<KeywordDataObject>) results.get("biddable");
		}
	}

}
