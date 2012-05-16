package semplest.server.service.springjdbc.helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import semplest.server.protocol.adengine.BidElement;

public class AllBidRSExtactor implements ResultSetExtractor<HashMap<String,ArrayList<BidElement>>>
{

	public HashMap<String,ArrayList<BidElement>> extractData(ResultSet rs) throws SQLException, DataAccessException
	{
		HashMap<String,ArrayList<BidElement>> result = new HashMap<String,ArrayList<BidElement>>();

		while (rs.next())
		{				
			String keyword = rs.getString("Keyword");
			BidElement bidEle = new BidElement();
			bidEle.setCompetitiveType(rs.getString("CompetitionType"));
			bidEle.setEndDate(rs.getTimestamp("EndDate"));
			bidEle.setIsActive(rs.getBoolean("IsActive"));
			bidEle.setIsDefaultValue(rs.getBoolean("IsDefaultValue"));
			bidEle.setKeyword(keyword);
			bidEle.setKeywordAdEngineID(rs.getLong("KeywordAdEngineID"));
			bidEle.setMatchType(rs.getString("BidType"));
			bidEle.setMicroBidAmount(rs.getLong("MicroBidAmount"));
			bidEle.setStartDate(rs.getTimestamp("StartDate"));
			//
			if (result.containsKey(keyword))
			{
				ArrayList<BidElement> bids = result.get(keyword);
				bids.add(bidEle);
			}
			else
			{
				ArrayList<BidElement> bids = new ArrayList<BidElement>();
				bids.add(bidEle);
				result.put(keyword, bids);
			}
		}

		return result;

	}
}