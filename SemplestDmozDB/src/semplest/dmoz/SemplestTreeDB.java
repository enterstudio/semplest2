package semplest.dmoz;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import semplest.dmoz.objects.AddSemplestTreeRequest;
import semplest.dmoz.springjdbc.BaseDB;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.UrlDataObject;

public class SemplestTreeDB extends BaseDB{
	
	public static void AddSemplestTree(final List<DmozTreeNode> semplestTreeNodes)
	{
		//form the request list
		final List<AddSemplestTreeRequest> addSemplestTreeRequests = new ArrayList<AddSemplestTreeRequest>();
		for(DmozTreeNode node : semplestTreeNodes){
			for(UrlDataObject urlData : node.getCategoryData().getUrlData()){				
				AddSemplestTreeRequest request = new AddSemplestTreeRequest();
				request.setDMOZSemplestPK(node.getNodeID());
				request.setDMOZURLDataPK(urlData.getUrlDataPK());
				request.setDomain(getDomain(urlData.getUrl()));
				
				addSemplestTreeRequests.add(request);
			}
		}		
		
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
	
	//helper method
	private static String getDomain(String url)
	{
		String[] parts = url.split("://");
		String subUrl;
		if(parts.length > 1){
			subUrl = parts[1];
		}
		else{
			subUrl = parts[0];
		}
		int index = subUrl.indexOf("/");
		String domain;
		if(index > 0){
			domain = subUrl.substring(0, index);
		}
		else{
			domain = subUrl;
		}
		
		return domain;
	}
}
