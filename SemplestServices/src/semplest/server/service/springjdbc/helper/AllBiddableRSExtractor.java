package semplest.server.service.springjdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import semplest.server.protocol.adengine.KeywordDataObject;

public class AllBiddableRSExtractor implements ResultSetExtractor<HashMap<String, ArrayList<KeywordDataObject>>>
{

	public HashMap<String, ArrayList<KeywordDataObject>> extractData(ResultSet rs) throws SQLException, DataAccessException
	{
		HashMap<String, ArrayList<KeywordDataObject>> result = new HashMap<String, ArrayList<KeywordDataObject>>();

		/*
		 * select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,ki.ApprovalStatus,b.BidType, ki.FirstPageMicroCPC, " +
					"ki.QualityScore,ki.IsEligibleForShowing,p.IsNegative,ki.CreatedDate
		 */
		while (rs.next())
		{
			String keyword = rs.getString("Keyword");
			KeywordDataObject dataObj = new KeywordDataObject();
			dataObj.setApprovalStatus(rs.getString("ApprovalStatus"));
			dataObj.setBidID(rs.getLong("KeywordAdEngineID"));
			dataObj.setCreatedDate(rs.getDate("CreatedDate"));
			dataObj.setFirstPageCpc(Long.valueOf(rs.getInt("FirstPageMicroCPC")));
			dataObj.setIsEligibleForShowing(rs.getBoolean("IsEligibleForShowing"));
			dataObj.setKeyword(keyword);
			dataObj.setMatchType(rs.getString("BidType"));
			dataObj.setMicroBidAmount(Long.valueOf(rs.getInt("MicroBidAmount")));
			dataObj.setNegative(rs.getBoolean("IsNegative"));
			dataObj.setQualityScore(rs.getInt("QualityScore"));
			
			//
			if (result.containsKey(keyword))
			{
				ArrayList<KeywordDataObject> data = result.get(keyword);
				data.add(dataObj);
			}
			else
			{
				ArrayList<KeywordDataObject> data = new ArrayList<KeywordDataObject>();
				data.add(dataObj);
				result.put(keyword, data);
			}
		}

		return result;

	}
}