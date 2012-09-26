package semplest.dmoz;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import semplest.dmoz.objects.AddSemplestTreeRequest;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tools.DbSemplestTreeOperator;
import semplest.dmoz.tree.DbTreeNodeObject;
import semplest.dmoz.tree.UrlDataObject;

public class SemplestTreeDB extends BaseDB{	
	
	private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("Service.xml");	
		
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
		
		//get all the urls		
		List<UrlDataObject> allUrlData = DbSemplestTreeOperator.getUrlsOfTree(categoryName);
		
		//organize urls by domain
		for(UrlDataObject urlData : allUrlData){
			String domainID = urlData.getDomainFK().toString();
			if(!domainUrlsMap.containsKey(domainID)){
				List<UrlDataObject> urlList = new ArrayList<UrlDataObject>();
				domainUrlsMap.put(domainID, urlList);
			}
			domainUrlsMap.get(domainID).add(urlData);			
		}
		
		return domainUrlsMap;
	}	
	
}
