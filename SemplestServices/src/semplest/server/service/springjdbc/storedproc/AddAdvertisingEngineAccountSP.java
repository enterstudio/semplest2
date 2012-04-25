package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class AddAdvertisingEngineAccountSP extends StoredProcedure
{
	private static final String SPROC_NAME = "AddAdvertisingEngineAccount";
	
	public AddAdvertisingEngineAccountSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("AdvertisingEngineAccountID", Types.VARCHAR));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("CustomerID", Types.INTEGER));
		compile();
	}

	/*
	 * returns the next schedule job to run
	 */
	public void execute(String AdvertisingEngineAccountID, String AdvertisingEngine, Integer CustomerID)
	{
		Map<String, Object> results = super.execute(AdvertisingEngineAccountID, AdvertisingEngine, CustomerID);
	}
}
