package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.protocol.ProtocolEnum.AdEngine;
import semplest.server.service.springjdbc.BaseDB;

public class AddKeywordBidDataSP extends StoredProcedure
{
	private static final String SPROC_NAME = "AddKeywordBidData";

	/*
	 * @PromotionID			INT,
	@Keyword				NVARCHAR(250),
	@AdvertisingEngine		VARCHAR(50),
	@BidType				VARCHAR(25),
	@QualityScore           INT = null,
	@ApprovalStatus			VARCHAR(30) = null,
	@FirstPageMicroCpc      INT = null,
	@IsEligibleForShowing	BIT = 1
	 */
	public AddKeywordBidDataSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("PromotionID", Types.INTEGER));
		declareParameter(new SqlParameter("Keyword", Types.VARCHAR));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		declareParameter(new SqlParameter("BidType", Types.VARCHAR));
		declareParameter(new SqlParameter("QualityScore", Types.INTEGER));
		declareParameter(new SqlParameter("ApprovalStatus", Types.VARCHAR));
		declareParameter(new SqlParameter("FirstPageMicroCpc", Types.INTEGER));
		declareParameter(new SqlParameter("IsEligibleForShowing", Types.BIT));
		
		
		declareParameter(new SqlOutParameter("ID", Types.INTEGER));

		compile();
	}

	public Integer execute(int PromotionID, String Keyword, AdEngine AdvertisingEngine, String BidType, Integer QualityScore, String ApprovalStatus, Integer FirstPageMicroCpc, Boolean IsEligibleForShowing) throws Exception
	{
		Map<String, Object> results = super.execute(PromotionID, Keyword, AdvertisingEngine.name(), BidType, QualityScore, ApprovalStatus, FirstPageMicroCpc, IsEligibleForShowing);
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
