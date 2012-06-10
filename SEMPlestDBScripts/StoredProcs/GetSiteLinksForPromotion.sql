IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetSiteLinksForPromotion') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetSiteLinksForPromotion;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Julian                                                                                               |
-- | Written - 2012-06-04																							|
-- | Parms   - 																										|
-- | Purpose - 																										|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetSiteLinksForPromotion
(
	@PromotionID            INT
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)

	--validate data
	IF NOT EXISTS (select * from PromotionAds p where p.PromotionFK = @PromotionID)
	BEGIN
		SELECT @ErrMsg = 'No Promotion Ad was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	--get site links
	select SiteLinkPk,PromotionFK, LinkText, LinkURL
	from SiteLinks 
	where PromotionFK = @PromotionID	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO