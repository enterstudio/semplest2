IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.SetPromotionBidding') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.SetPromotionBidding;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 7/2012																							|
-- | Parms   - 																							|
-- | Purpose - 					|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.SetPromotionBidding
(
	@PromotionID			INT,
	@AdvertisingEngine	varchar(25),
	@PromotionBiddingType	varchar(25) = null,
	@ID int output
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @PromotionBiddingTypePK int, @AdvertisingEnginePK int
	IF NOT EXISTS (select * from Promotion p where p.PromotionPK = @PromotionID)
	BEGIN
		SELECT @ErrMsg = 'The Promotion was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	IF NOT EXISTS (select * from AdvertisingEngine a where a.AdvertisingEngine = @AdvertisingEngine)
	BEGIN
		SELECT @ErrMsg = 'The Advertising Engine was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	SET @PromotionBiddingTypePK = null
	if (@PromotionBiddingType is not null)
	BEGIN
		IF NOT EXISTS (select * from SemplestBidType sbt where sbt.SemplestBidType = @PromotionBiddingType)
		BEGIN
			SELECT @ErrMsg = 'The SemplestBidType ' + @PromotionBiddingType + ' was not found.'; 
			RAISERROR (@ErrMsg, 16, 1);
		END;
		ELSE
		BEGIN
			select @PromotionBiddingTypePK = sbt.SemplestBidTypePK from SemplestBidType sbt where sbt.SemplestBidType = @PromotionBiddingType
		END
	END
	select @AdvertisingEnginePK = a.AdvertisingEnginePK from AdvertisingEngine a where a.AdvertisingEngine = @AdvertisingEngine
	
	INSERT into PromotionBidding(PromotionFK,AdvertisingEngineFK,SemplestBidTypeFK,BidCompleted)
	VALUES (@PromotionID, @AdvertisingEnginePK, @PromotionBiddingTypePK, CURRENT_TIMESTAMP)
	
	set @ID = @@IDENTITY
	
	
END TRY
BEGIN CATCH
 
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO