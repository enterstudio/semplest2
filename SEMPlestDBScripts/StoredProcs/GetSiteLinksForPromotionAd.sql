IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetSiteLinksForPromotionAd') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetSiteLinksForPromotionAd;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Julian                                                                                               |
-- | Written - 2012-06-04																							|
-- | Parms   - 																										|
-- | Purpose - 																										|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetSiteLinksForPromotionAd
(
	@PromotionAdID            INT
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)

	--validate data
	IF NOT EXISTS (select * from PromotionAds p where p.PromotionAdsPK = @PromotionAdID)
	BEGIN
		SELECT @ErrMsg = 'The Promotion Ad was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	--get site links
	select SiteLinkPk,PromotionAdsFK, LinkText, LinkURL
	from SiteLinks 
	where PromotionAdsFK = @PromotionAdID	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO