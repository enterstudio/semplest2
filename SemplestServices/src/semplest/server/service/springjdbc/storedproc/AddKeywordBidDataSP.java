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
		declareParameter(new SqlParameter("Keyword", Types.VARCHAR));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("BidType", Types.VARCHAR));
		
		declareParameter(new SqlParameter("ApprovalStatus", Types.VARCHAR));
		declareParameter(new SqlParameter("FirstPageMicroCpc", Types.INTEGER));
		declareParameter(new SqlParameter("IsEligibleForShowing", Types.BIT));
		
		
		declareParameter(new SqlOutParameter("ID", Types.INTEGER));

		compile();
	}

	public void execute(int PromotionID, String Keyword, String AdvertisingEngine, String BidType, String ApprovalStatus, Integer FirstPageMicroCpc, Boolean IsEligibleForShowing) throws Exception
	{
		Map<String, Object> results = super.execute(PromotionID, Keyword, AdvertisingEngine, BidType, ApprovalStatus, FirstPageMicroCpc, IsEligibleForShowing);
	}

}
