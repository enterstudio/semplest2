package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Date;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class AddBidSP extends StoredProcedure
{
	private static final String SPROC_NAME = "SetBidObject";
	/*
	 * @ProductGroupPK			INT,
	@PromotionPK            INT,
	@KeywordAdEngineID      INT,
	@Keyword				NVARCHAR(250),
	@MicroBidAmount			INT,
	@ApprovalStatus			VARCHAR(30) = null,
	@BidType				VARCHAR(25),
	@FirstPageMicroCpc      INT = null,
	@QualityScore           INT = null,
	@IsEligibleForShowing	BIT = 1,
	@IsBidActive			BIT = 1,
	@IsNegative				BIT = 0,
	@AdvertisingEngine		VARCHAR(50),
	 */
	public AddBidSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("ProductGroupPK", Types.INTEGER));
		declareParameter(new SqlParameter("PromotionPK", Types.INTEGER));
		declareParameter(new SqlParameter("KeywordAdEngineID", Types.INTEGER));
		declareParameter(new SqlParameter("Keyword", Types.NVARCHAR));
		declareParameter(new SqlParameter("MicroBidAmount", Types.INTEGER));
		declareParameter(new SqlParameter("ApprovalStatus", Types.VARCHAR));
		declareParameter(new SqlParameter("BidType", Types.VARCHAR));
		declareParameter(new SqlParameter("FirstPageMicroCpc", Types.INTEGER));
		declareParameter(new SqlParameter("QualityScore", Types.INTEGER));
		declareParameter(new SqlParameter("IsEligibleForShowing", Types.BIT));
		declareParameter(new SqlParameter("IsBidActive", Types.BIT));
		declareParameter(new SqlParameter("IsNegative", Types.BIT));
		declareParameter(new SqlParameter("AdvertisingEngine", Types.VARCHAR));
		
		declareParameter(new SqlOutParameter("ID", Types.INTEGER));
		compile();
	}

	/*
	 * returns the next schedule job to run
	 */
	public Integer execute(int ProductGroupPK, int PromotionPK, int KeywordAdEngineID, String Keyword, Long MicroBidAmount, String ApprovalStatus, String BidType, Long FirstPageMicroCpc, Integer QualityScore,
			Boolean IsEligibleForShowing, boolean IsBidActive, Boolean IsNegative, String AdvertisingEngine) throws Exception
	{
		Map<String, Object> results = super.execute(ProductGroupPK, PromotionPK, KeywordAdEngineID, Keyword,MicroBidAmount, ApprovalStatus, BidType, FirstPageMicroCpc, QualityScore,
				IsEligibleForShowing,IsBidActive, IsNegative, AdvertisingEngine);
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