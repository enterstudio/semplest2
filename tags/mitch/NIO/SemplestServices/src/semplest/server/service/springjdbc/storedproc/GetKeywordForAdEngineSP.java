package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.adengine.KeywordProbabilityObject;
import semplest.server.service.springjdbc.BaseDB;

public class GetKeywordForAdEngineSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetKeywordForAdEngine";
	private static final RowMapper<KeywordProbabilityObject> keywordProbabilityObjectMapper = new BeanPropertyRowMapper(KeywordProbabilityObject.class);
	
	public GetKeywordForAdEngineSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlParameter("IsTargetGoogle", Types.BIT));
		declareParameter(new SqlParameter("IsTargetMSN", Types.BIT));
		declareParameter(new SqlReturnResultSet("keyword", keywordProbabilityObjectMapper));
		compile();
	}
	
	public List<KeywordProbabilityObject> execute(int promotionID, boolean isTargetGoogle, boolean isTargetMSN )
	{
		Map<String, Object> results = super.execute(new Object[] {promotionID, isTargetGoogle, isTargetMSN});
		if (results.get("keyword") == null)
		{
			return null;
		}
		else
		{
			return (ArrayList<KeywordProbabilityObject>) results.get("keyword");
		}
	}

}
