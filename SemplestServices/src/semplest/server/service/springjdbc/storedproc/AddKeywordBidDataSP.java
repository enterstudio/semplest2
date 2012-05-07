package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class AddKeywordBidDataSP extends StoredProcedure
{
	private static final String SPROC_NAME = "AddKeywordBidData";

	public AddKeywordBidDataSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionID", Types.INTEGER));
		declareParameter(new SqlParameter("KeywordAdEngineID", Types.BIGINT));
		declareParameter(new SqlParameter("Keyword", Types.NVARCHAR));
		declareParameter(new SqlParameter("MicroBidAmount", Types.INTEGER));
		declareParameter(new SqlParameter("BidType", Types.VARCHAR));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlOutParameter("ID", Types.INTEGER));

		compile();
	}

	public void execute(int PromotionID, Long KeywordAdEngineID, String Keyword, Long MicroBidAmount, String BidType, String AdvertisingEngine) throws Exception
	{
		Map<String, Object> results = super.execute(PromotionID, KeywordAdEngineID, Keyword, MicroBidAmount.intValue(), BidType, AdvertisingEngine);
	}

}
