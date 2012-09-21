package semplest.dmoz;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import semplest.dmoz.objects.AddSemplestTreeRequest;

public class SemplestTreeSqlCall extends DmozDB
{
	
	private static String sql = "DECLARE @url varchar(1000), @urlID int, @domainID int; if not exists (select * from SemplestTree st where st.SemplestPK = ?) " +
			"Begin insert into SemplestTree(SemplestPK, DMOZCategoryID,NodeText,ParentNodeID,NodeDescription) " +
			"select d.SemplestPK, d.DMOZCategoryID,d.NodeText,d.ParentNodeID,d.NodeDescription from DMOZ d where d.SemplestPK = ? End " +
			"if not exists (select * from Domain d where d.Domain = ?) BEGIN insert into Domain(Domain) values (?) set @domainID = @@IDENTITY END ELSE  " +
			"BEGIN	select @domainID = d.DomainPK from Domain d where d.Domain = ? END " +
			"select @url = ud.URL from URLData ud where ud.UrlDataPK = ? " +
			"if not exists (select * from SemplestURLData sud where sud.URL = @url) BEGIN insert into SemplestURLData(URL, URLDescription, DomainFK)  " +
			"select ud.URL, ud.URLDescription, @domainID from URLData ud where ud.UrlDataPK = ? set @urlID = @@IDENTITY END ELSE " +
			"BEGIN select @urlID = sud.UrlDataPK from SemplestURLData sud where sud.URL = @url END " +
			"insert into NodeURLAssociation(SemplestFK, URLDataFK, [Level], ParentURLDataID) " +
			"select ?, @urlID, ud.Level,ud.ParentURLDataID from URLData ud where ud.UrlDataPK = ?";
	
	public static void runSemplestTree(final List<AddSemplestTreeRequest> addSemplestTreeRequests) //int DMOZSemplestPK, int DMOZURLDataPK, String Domain)
	{		
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

}
