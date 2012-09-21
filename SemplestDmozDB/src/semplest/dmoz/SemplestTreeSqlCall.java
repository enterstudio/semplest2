package semplest.dmoz;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import semplest.dmoz.objects.AddSemplestTreeRequest;
import semplest.dmoz.tree.DmozTreeNode;
import semplest.dmoz.tree.UrlDataObject;

public class SemplestTreeSqlCall extends DmozDB
{
	
	private static String sql = "DECLARE @url varchar(1000), @urlID int, @domainID int; if not exists (select * from SemplestTree st where st.SemplestPK = ?) " +
			"Begin insert into SemplestTree(SemplestPK, DMOZCategoryID,NodeText,ParentNodeID,NodeDescription) End " +
			"select d.SemplestPK, d.DMOZCategoryID,d.NodeText,d.ParentNodeID,d.NodeDescription from DMOZ d where d.SemplestPK = ? " +
			"if not exists (select * from Domain d where d.Domain = ?) BEGIN insert into Domain(Domain) values (?) set @domainID = @@IDENTITY END ELSE  " +
			"BEGIN	select @domainID = d.DomainPK from Domain d where d.Domain = ? END " +
			"select @url = ud.URL from URLData ud where ud.UrlDataPK = ? " +
			"if not exists (select * from SemplestURLData sud where sud.URL = @url) BEGIN insert into SemplestURLData(URL, URLDescription, DomainFK)  " +
			"select ud.URL, ud.URLDescription, @domainID from URLData ud where ud.UrlDataPK = ? set @urlID = @@IDENTITY END ELSE " +
			"BEGIN select @urlID = sud.UrlDataPK from SemplestURLData sud where sud.URL = @url END " +
			"insert into NodeURLAssociation(SemplestFK, URLDataFK, [Level], ParentURLDataID) " +
			"select ?, @urlID, ud.Level,ud.ParentURLDataID from URLData ud where ud.UrlDataPK = ?";
	
	public static void runSemplestTree(final List<DmozTreeNode> semplestTreeNodes) //int DMOZSemplestPK, int DMOZURLDataPK, String Domain)
	{
		final List<AddSemplestTreeRequest> addSemplestTreeRequests = new ArrayList<AddSemplestTreeRequest>();
		for(DmozTreeNode node : semplestTreeNodes){
			List<UrlDataObject> list = node.getCategoryData().getUrlData();
			for(UrlDataObject urlData : list){				
				AddSemplestTreeRequest request = new AddSemplestTreeRequest();
				request.setDMOZSemplestPK(node.getNodeID());
				request.setDMOZURLDataPK(urlData.getUrlDataPK());
				request.setDomain(getDomain(urlData.getUrl()));
				
				addSemplestTreeRequests.add(request);
			}
		}
		//final int rowcount = jdbcTemplate.update(sql, 
		//		 new Object[]{DMOZSemplestPK,DMOZSemplestPK, Domain, Domain, Domain,DMOZURLDataPK, DMOZURLDataPK, DMOZSemplestPK, DMOZURLDataPK});
		
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter()
		{
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException
			{
				AddSemplestTreeRequest request = addSemplestTreeRequests.get(i);
				ps.setLong(1, request.getDMOZSemplestPK());
				ps.setLong(2, request.getDMOZSemplestPK());
				ps.setString(3, request.getDomain());
				ps.setString(4, request.getDomain());
				ps.setString(5, request.getDomain());
				ps.setLong(6, request.getDMOZURLDataPK());
				ps.setLong(7, request.getDMOZURLDataPK());
				ps.setLong(8, request.getDMOZSemplestPK());
				ps.setLong(9, request.getDMOZURLDataPK());
				
			}
			@Override
			public int getBatchSize()
			{
				return addSemplestTreeRequests.size();
			}

		});
	}
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
