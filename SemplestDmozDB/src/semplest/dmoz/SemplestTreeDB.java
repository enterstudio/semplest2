package semplest.dmoz;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import semplest.dmoz.objects.AddSemplestTreeRequest;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tools.DbSemplestTreeOperator;
import semplest.dmoz.tree.UrlDataObject;

public class SemplestTreeDB extends BaseDB{	
		
	public static void AddSemplestTree(final List<AddSemplestTreeRequest> addSemplestTreeRequests) throws Exception
	{
		//call the store proc in batch
		String sql = "{call AddSemplestTree(?,?,?)}";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				AddSemplestTreeRequest request = addSemplestTreeRequests.get(i);
				ps.setLong(1, request.getDMOZSemplestPK());
				ps.setLong(2, request.getDMOZURLDataPK());
				ps.setString(3, request.getDomain());
			}

			@Override
			public int getBatchSize()
			{
				return addSemplestTreeRequests.size();
			}
		});		
	}
	
	public static Map<String,List<UrlDataObject>> getUrlsByDomain(String categoryName) throws Exception{
		Map<String,List<UrlDataObject>> domainUrlsMap = new HashMap<String,List<UrlDataObject>>();
		String sql;
		
		Set<Long> domainPKs = DbSemplestTreeOperator.getDomainPKsOfTree(categoryName);
		
		//for each domain, get all the urlData
		for(Long domainPK : domainPKs){
			sql = "SELECT u.UrlDataPK,u.URL FROM SemplestURLData u " +
					"WHERE u.DomainFK = ?";
			
			List<UrlDataObject> urls = jdbcTemplate.queryForList(sql, new Object[]{domainPK}, UrlDataObject.class);
			
			domainUrlsMap.put(domainPK.toString(), urls);
		}
		
		return domainUrlsMap;
	}	
	
}
