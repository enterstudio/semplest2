package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Date;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class UpdateAdEngineAPIChargeSP  extends StoredProcedure
{
	private static final String SPROC_NAME = "UpdateAdEngineAPICharge";
	
	public UpdateAdEngineAPIChargeSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("AdvertisingEngineAccountID", Types.BIGINT));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("CumulativeAPIUnits", Types.BIGINT));
		declareParameter(new SqlOutParameter("cost", Types.DOUBLE));
		compile();
	}

	/*
	 * returns API cost 
	 */
	public Double execute(Long AdvertisingEngineAccountID, String AdvertisingEngin, Long CumulativeAPIUnits) throws Exception
	{
		Map<String, Object> results = super.execute(AdvertisingEngineAccountID, AdvertisingEngin, CumulativeAPIUnits);
		if (results.get("cost") == null)
		{
			return null;
		}
		else
		{
			return ((Double)results.get("cost"));
		}
	}
}
