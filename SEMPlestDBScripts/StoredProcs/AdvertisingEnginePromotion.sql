IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.AddAdvertisingEnginePromotion') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.AddAdvertisingEnginePromotion;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - add new AdvertisingEnginePromotion					|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.AddAdvertisingEnginePromotion
(
	@AdvertisingEngineAccountID varchar(30),
	@AdvertisingEngineCampaignID int,
	@PromotionID int,
	@IsSearchNetwork bit = 1,
	@IsDisplayNetwork bit = 0,
	@AdvertisingEngineBudget money = 0
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)
	
	IF NOT EXISTS (select 1 from AdvertisingEngineAccount a where a.AdvertisingEngineAccountPK = @AdvertisingEngineAccountID)
	BEGIN
		SELECT @ErrMsg = 'The AdvertisingEngineAccountPK was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	IF NOT EXISTS (select 1 from Promotion p where p.PromotionPK = @PromotionID)
	BEGIN
		SELECT @ErrMsg = 'The PromotionPK was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	if EXISTS (Select * from AdvertisingEnginePromotion ap where ap.AdvertisingEngineCampaignPK = @AdvertisingEngineCampaignID and ap.PromotionFK = @PromotionID)
	BEGIN
		update AdvertisingEnginePromotion set IsSearchNetwork = @IsSearchNetwork, IsDisplayNetwork = @IsDisplayNetwork,
			AdvertisingEngineBudget = @AdvertisingEngineBudget
		from AdvertisingEnginePromotion ap 
		where ap.AdvertisingEngineAccountFK = @AdvertisingEngineAccountID and ap.AdvertisingEngineCampaignPK = @AdvertisingEngineCampaignID	and ap.PromotionFK=@PromotionID
	
	END
	else --add new 
	BEGIN
		INSERT INTO AdvertisingEnginePromotion(AdvertisingEngineAccountFK,AdvertisingEngineCampaignPK,PromotionFK,IsSearchNetwork,IsDisplayNetwork,AdvertisingEngineBudget)
		VALUES (@AdvertisingEngineAccountID,@AdvertisingEngineCampaignID,@PromotionID, @IsSearchNetwork,@IsDisplayNetwork,@AdvertisingEngineBudget)
	
	END
		
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO