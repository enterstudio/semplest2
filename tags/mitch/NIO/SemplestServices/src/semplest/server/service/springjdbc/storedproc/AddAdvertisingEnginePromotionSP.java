package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class AddAdvertisingEnginePromotionSP extends StoredProcedure
{
	private static final String SPROC_NAME = "AddAdvertisingEnginePromotion";
	
	public AddAdvertisingEnginePromotionSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("AdvertisingEngineAccountID", Types.BIGINT));
		declareParameter(new SqlParameter("AdvertisingEngineCampaignID", Types.BIGINT));
		declareParameter(new SqlParameter("PromotionID", Types.INTEGER));
		declareParameter(new SqlParameter("IsSearchNetwork", Types.BIT));
		declareParameter(new SqlParameter("IsDisplayNetwork", Types.BIT));
		declareParameter(new SqlParameter("AdvertisingEngineBudget", Types.DOUBLE));
		compile();
	}

	/*
	 * AddAdvertising Engine Promotion
	 */
	public void execute(Long AdvertisingEngineAccountID,Integer AdvertisingEngineCampaignID, Integer PromotionID, Boolean IsSearchNetwork, Boolean IsDisplayNetwork, Double AdvertisingEngineBudget )
	{
		Map<String, Object> results = super.execute(AdvertisingEngineAccountID,AdvertisingEngineCampaignID, PromotionID, IsSearchNetwork, IsDisplayNetwork, AdvertisingEngineBudget);
	}
}

