IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.AddSemplestTree') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.AddSemplestTree;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 9/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.AddSemplestTree
(

	@DMOZSemplestPK int,
	@DMOZURLDataPK int,
	@Domain varchar(300)
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @url varchar(1000), @urlID int, @domainID int
	
	--insert into SemplestTreeTemp(SemplestPK, URLPK, Domain) values (@DMOZSemplestPK, @DMOZURLDataPK, @Domain)
	
	
	
	begin transaction
	
	--insert into semplest tree
	insert into SemplestTree(SemplestPK, DMOZCategoryID,NodeText,ParentNodeID,NodeDescription)
	select d.SemplestPK, d.DMOZCategoryID,d.NodeText,d.ParentNodeID,d.NodeDescription from DMOZ d 
	inner join (select stt.SemplestPK from SemplestTreeTemp stt group by stt.SemplestPK) stt on stt.SemplestPK = d.SemplestPK

--insert domain 
	insert into Domain(Domain) select stt.Domain from SemplestTreeTemp stt group by stt.Domain

--URL
	insert into SemplestURLData(URL, DomainFK) 
	select ud.URL, d.DomainPK from URLData ud 
	inner join SemplestTreeTemp stt on stt.URLPK = ud.UrlDataPK
	inner join Domain d on d.Domain = stt.Domain
	group by ud.URL, d.DomainPK
	
	update SemplestURLData set URLDescription = ud.URLDescription
	from URLData ud 	
	inner join SemplestURLData sud on sud.URL = ud.URL

--Associations
	insert into NodeURLAssociation(SemplestFK, URLDataFK, [Level], ParentURLDataID)
	select stt.SemplestPK, sud.UrlDataPK, ud.Level, ud.ParentURLDataID from SemplestTreeTemp stt
	inner join URLData ud on ud.UrlDataPK = stt.URLPK and ud.SemplestFK = stt.SemplestPK
	inner join SemplestURLData sud on sud.URL = ud.URL
	
	commit transaction
	
	
END TRY
BEGIN CATCH
 IF XACT_STATE() != 0 OR @@TRANCOUNT > 0
    ROLLBACK TRANSACTION;
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO