package semplest.server.service.springjdbc.storedproc;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import semplest.server.service.springjdbc.BaseDB;

public class AddReportDataSP extends StoredProcedure
{
	private static final String SPROC_NAME = "SetReportObject";
	
	public AddReportDataSP()
	{
		super(BaseDB.jdbcTemplate.getDataSource(), SPROC_NAME);
		declareParameter(new SqlParameter("AccountID", Types.BIGINT));
		declareParameter(new SqlParameter("CampaignID", Types.BIGINT));
		declareParameter(new SqlParameter("Keyword", Types.NVARCHAR));
		declareParameter(new SqlParameter("TransactionDate", Types.DATE));
		declareParameter(new SqlParameter("MicroBidAmount", Types.INTEGER));
		declareParameter(new SqlParameter("BidMatchType", Types.VARCHAR));
		declareParameter(new SqlParameter("NumberImpressions", Types.INTEGER));
		declareParameter(new SqlParameter("NumberClick", Types.INTEGER));
		declareParameter(new SqlParameter("AveragePosition", Types.FLOAT));
		declareParameter(new SqlParameter("AverageCPC", Types.FLOAT));
		declareParameter(new SqlParameter("QualityScore", Types.INTEGER));
		declareParameter(new SqlParameter("ApprovalStatus", Types.VARCHAR));
		declareParameter(new SqlParameter("FirstPageMicroCpc", Types.INTEGER));
		declareParameter(new SqlParameter("MicroCost", Types.BIGINT));
		
		compile();
	}
	
	public void execute(int AccountID,int CampaignID, String Keyword, java.sql.Date TransactionDate, Integer MicroBidAmount, String BidMatchType, 
			Integer NumberImpressions, Integer NumberClick, Float AveragePosition, Float AverageCPC,Integer QualityScore, String ApprovalStatus,
			Integer FirstPageMicroCpc, Long MicroCost) throws Exception
	{
		Map<String, Object> results = super.execute(AccountID,CampaignID, Keyword, TransactionDate,MicroBidAmount,BidMatchType, 
				NumberImpressions, NumberClick, AveragePosition, AverageCPC,QualityScore, ApprovalStatus,
				FirstPageMicroCpc, MicroCost);
	}
}
