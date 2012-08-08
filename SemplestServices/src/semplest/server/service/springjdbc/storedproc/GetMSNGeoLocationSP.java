package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.msn.MSNGeotargetObject;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.MSNGeotargetHelperObj;



public class GetMSNGeoLocationSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetMSNGeoLocation";
	private static final RowMapper<MSNGeotargetHelperObj> GeotargetlistMapper = new BeanPropertyRowMapper(MSNGeotargetHelperObj.class);
	
	public GetMSNGeoLocationSP() 
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		
		declareParameter(new SqlParameter("PromotionID", Types.INTEGER));
		declareParameter(new SqlParameter("ValueList", Types.VARCHAR));
		declareParameter(new SqlParameter("ValueDelimiter", Types.VARCHAR));
		declareParameter(new SqlParameter("ListDelimiter", Types.VARCHAR));
		declareParameter(new SqlOutParameter("totalSize", Types.INTEGER));
		
		declareParameter(new SqlReturnResultSet("states", GeotargetlistMapper));
		declareParameter(new SqlReturnResultSet("metro", GeotargetlistMapper));
		declareParameter(new SqlReturnResultSet("cities", GeotargetlistMapper));
		compile();
	}
	
	public MSNGeotargetObject execute(Integer PromotionID, String ValueList, String ValueDelimiter, String ListDelimiter )
	{
		MSNGeotargetObject res = new MSNGeotargetObject();
	
		Map<String, Object> results = super.execute(new Object[] { PromotionID, ValueList, ValueDelimiter, ListDelimiter});
		if (results.get("totalSize") != null)
		{
			 res.setTotalSize((Integer) results.get("totalSize"));
		}
		
		if (results.get("states") != null)
		{
			List<MSNGeotargetHelperObj>  stateRes = ((List<MSNGeotargetHelperObj>) results.get("states"));
			for (MSNGeotargetHelperObj aState : stateRes)
			{
				res.addState(aState.getMsnName());
			}
			
		}
		if (results.get("metro") != null)
		{
			List<MSNGeotargetHelperObj>  metroRes = ((List<MSNGeotargetHelperObj>) results.get("metro"));
			for (MSNGeotargetHelperObj aMetro : metroRes)
			{
				res.addMetro(aMetro.getMsnName());
			}
		}
		if (results.get("cities") != null)
		{
			List<MSNGeotargetHelperObj>  cityRes = ((List<MSNGeotargetHelperObj>) results.get("cities"));
			for (MSNGeotargetHelperObj aCity : cityRes)
			{
				res.addCity(aCity.getMsnName());
			}
		}
		return res;
		
	}

}
