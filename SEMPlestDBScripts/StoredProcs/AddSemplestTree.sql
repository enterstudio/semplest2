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
	begin transaction
	
	--add the data to the Semplest treefrom DMOZ
	insert into SemplestTree(SemplestPK, DMOZCategoryID,NodeText,ParentNodeID,NodeDescription)
	select d.SemplestPK, d.DMOZCategoryID,d.NodeText,d.ParentNodeID,d.NodeDescription from DMOZ d where d.SemplestPK = @DMOZSemplestPK
	
	--get the domain
	if not exists (select * from Domain d where d.Domain = @Domain)
	BEGIN
		insert into Domain(Domain) values (@Domain)
		set @domainID = @@IDENTITY
	END 
	ELSE
	BEGIN
		select @domainID = d.DomainPK from Domain d where d.Domain = @Domain
	END
	--if the URL does not exist then add it
	select @url = ud.URL from URLData ud where ud.UrlDataPK = @DMOZURLDataPK
	if not exists (select * from SemplestURLData sud where sud.URL = @url)
	BEGIN
		insert into SemplestURLData(URL, URLDescription, DomainFK) 
			select ud.URL, ud.URLDescription, @domainID from URLData ud where ud.UrlDataPK = @DMOZURLDataPK
		set @urlID = @@IDENTITY	
	END
	ELSE --url exists
	BEGIN
		select @urlID = sud.UrlDataPK from SemplestURLData sud where sud.URL = @url
	END
	
	--Associate Semplest Node to URL
	insert into NodeURLAssociation(SemplestFK, URLDataFK, [Level], ParentURLDataID)
		select @DMOZSemplestPK, @urlID, ud.Level,ud.ParentURLDataID from URLData ud where ud.UrlDataPK = @DMOZURLDataPK
	
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