package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.CustomOperation;
import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.service.springjdbc.BaseDB;
import semplest.server.service.springjdbc.SemplestDB;
import semplest.util.SemplestUtils;

public class AddBidSP extends StoredProcedure
{
	private static final String SPROC_NAME = "SetBidObject";
	
	public AddBidSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlParameter("KeywordAdEngineID", Types.BIGINT));
		declareParameter(new SqlParameter("Keyword", Types.VARCHAR));
		declareParameter(new SqlParameter("MicroBidAmount", Types.INTEGER));
		declareParameter(new SqlParameter("BidType", Types.VARCHAR));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("IsNegative", Types.BIT));
		declareParameter(new SqlParameter("CompetitionType", Types.VARCHAR));
		declareParameter(new SqlParameter("IsDefaultValue", Types.BIT));
		declareParameter(new SqlOutParameter("ID", Types.INTEGER));

		compile();
	}

	/*
	 * returns KeywordBidPK
	 */
	public Integer execute(final int PromotionPK, final Long KeywordAdEngineID, final String Keyword, final Integer MicroBidAmount, final String BidType, final AdEngine AdvertisingEngine, final boolean IsNegative, final String CompetitionType, final boolean IsDefaultValue) throws Exception
	{
		//Map<String, Object> results = super.execute(PromotionPK, KeywordAdEngineID, Keyword,  MicroBidAmount,BidType, AdvertisingEngine.name(),IsNegative, CompetitionType, IsDefaultValue);
		final StoredProcedure sp = this;
		Map<String, Object> results = SemplestDB.executeRetryOnDeadlock(new CustomOperation<Map<String, Object>>()
					{
						public Map<String, Object> performCustomOperation()
						{
							return sp.execute(PromotionPK, KeywordAdEngineID, Keyword,  MicroBidAmount,BidType, AdvertisingEngine.name(),IsNegative, CompetitionType, IsDefaultValue);			
						}
					}, SemplestUtils.DEFAULT_RETRY_COUNT);
		if (results.get("ID") == null)
		{
			return null;
		}
		else
		{
			Integer res = (Integer) results.get("ID");
			if (res == null)
			{
				return null;
			}
			else
			{
				return res;
			}
		}
	}
}