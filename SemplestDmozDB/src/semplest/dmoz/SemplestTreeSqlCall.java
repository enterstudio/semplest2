package semplest.dmoz;

public class SemplestTreeSqlCall extends DmozDB
{
	
	private static String sql = "DECLARE @url varchar(1000), @urlID int, @domainID int; insert into SemplestTree(SemplestPK, DMOZCategoryID,NodeText,ParentNodeID,NodeDescription) " +
			"select d.SemplestPK, d.DMOZCategoryID,d.NodeText,d.ParentNodeID,d.NodeDescription from DMOZ d where d.SemplestPK = ? " +
			"if not exists (select * from Domain d where d.Domain = ?) BEGIN insert into Domain(Domain) values (?) set @domainID = @@IDENTITY END ELSE  " +
			"BEGIN	select @domainID = d.DomainPK from Domain d where d.Domain = ? END " +
			"select @url = ud.URL from URLData ud where ud.UrlDataPK = ? " +
			"if not exists (select * from SemplestURLData sud where sud.URL = @url) BEGIN insert into SemplestURLData(URL, URLDescription, DomainFK)  " +
			"select ud.URL, ud.URLDescription, @domainID from URLData ud where ud.UrlDataPK = ? set @urlID = @@IDENTITY END ELSE " +
			"BEGIN select @urlID = sud.UrlDataPK from SemplestURLData sud where sud.URL = @url END " +
			"insert into NodeURLAssociation(SemplestFK, URLDataFK, [Level], ParentURLDataID) " +
			"select ?, @urlID, ud.Level,ud.ParentURLDataID from URLData ud where ud.UrlDataPK = ?";
	
	public static void runSemplestTree(int DMOZSemplestPK, int DMOZURLDataPK, String Domain)
	{
		final int rowcount = jdbcTemplate.update(sql, 
				 new Object[]{DMOZSemplestPK, Domain, Domain, Domain,DMOZURLDataPK, DMOZURLDataPK, DMOZSemplestPK, DMOZURLDataPK});
	}

}
