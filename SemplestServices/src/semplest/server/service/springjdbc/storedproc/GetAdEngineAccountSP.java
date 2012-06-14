package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.AdEngineAccountObj;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.ScheduleJobObj;


public class GetAdEngineAccountSP extends StoredProcedure
{
	private static final RowMapper<AdEngineAccountObj> AdEngineAccountObjMapper = new BeanPropertyRowMapper(AdEngineAccountObj.class);
	private static final String SPROC_NAME = "GetAdEngineAccount";
	
	public GetAdEngineAccountSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("CustomerID", Types.INTEGER));
		declareParameter(new SqlParameter("AdEngine", Types.VARCHAR));
		declareParameter(new SqlReturnResultSet("acct", AdEngineAccountObjMapper));
		
		compile();
	}

	/*
	 * returns KeywordBidPK
	 */
	public AdEngineAccountObj execute(int CustomerID, String AdEngine) throws Exception
	{
		Map<String, Object> results = super.execute(CustomerID, AdEngine);
		
		if (results.get("acct") == null)
		{
			return null;
		}
		else
		{
			ArrayList<AdEngineAccountObj> res = (ArrayList<AdEngineAccountObj>) results.get("acct");
			if (res.size() > 0)
			{
				return res.get(0);
			}
			else
			{
				return null;
			}
		}
	}
}
