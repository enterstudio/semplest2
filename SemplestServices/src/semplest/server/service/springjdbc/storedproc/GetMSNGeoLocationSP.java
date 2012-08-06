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

import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.MSNGeotargetObject;



public class GetMSNGeoLocationSP extends StoredProcedure
{
	private static final String SPROC_NAME = "GetMSNGeoLocation";
	private static final RowMapper<MSNGeotargetObject> GeotargetlistMapper = new BeanPropertyRowMapper(MSNGeotargetObject.class);
	
	public GetMSNGeoLocationSP() 
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		
		declareParameter(new SqlParameter("IsState", Types.BIT));
		declareParameter(new SqlParameter("State", Types.VARCHAR));
		declareParameter(new SqlParameter("Longitude", Types.DOUBLE));
		declareParameter(new SqlParameter("Latitude", Types.DOUBLE));
		declareParameter(new SqlParameter("Radius", Types.DOUBLE));
		
		declareParameter(new SqlReturnResultSet("names", GeotargetlistMapper));
		compile();
	}
	
	public List<MSNGeotargetObject> execute(boolean IsState, String State, Double Longitude,Double Latitude,Double Radius )
	{
		Map<String, Object> results = super.execute(new Object[] {IsState, State, Longitude,Latitude,Radius});
		if (results.get("names") == null)
		{
			return null;
		}
		else
		{
			return (ArrayList<MSNGeotargetObject>) results.get("names");
		}
	}

}
