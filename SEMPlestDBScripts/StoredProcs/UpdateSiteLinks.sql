IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.UpdateSiteLinks') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.UpdateSiteLinks;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Andre                                                                                                |
-- | Written - 8/11/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.UpdateSiteLinks
(
	@PromotionPK			INT,
	@SlTVP					dbo.SiteLinksTableType READONLY
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	BEGIN
	
	begin Transaction
        INSERT INTO dbo.SiteLinks (PromotionFK,LinkText,LinkURL)
			select @PromotionPK,st.LinkText,st.LinkURL from @SlTVP st WHERE st.Operation ='I'
			
		UPDATE s SET 
			s.LinkText = st.LinkText, s.LinkURL = st.LinkURL
			FROM dbo.SiteLinks s 
			INNER JOIN @SlTVP st ON st.PKEY = s.SiteLInkPK WHERE st.Operation = 'U'
			
		DELETE from dbo.SiteLinks from dbo.SiteLinks s INNER JOIN  @SlTVP st on st.PKEY = s.SiteLInkPK where st.Operation= 'D'
     commit transaction   
	END
	
	SELECT s.SiteLInkPK as PKEY, st.UID as UID from dbo.SiteLinks s 
	inner JOIN @SlTVP st on 
			st.LinkText = s.LinkText and st.LinkURL = s.LinkURL
	WHERE st.operation = 'I' and s.PromotionFK = @PromotionPK 

END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO