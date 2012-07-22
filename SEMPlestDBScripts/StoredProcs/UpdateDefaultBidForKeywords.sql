IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.UpdateDefaultBidForKeywords') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.UpdateDefaultBidForKeywords;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.UpdateDefaultBidForKeywords
(
	@PromotionPK            INT,
	@AdvertisingEngine		VARCHAR(50)
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @MicroDefaultBid bigint, @currentTime datetime2
	DECLARE @KeybidTable Table(keywordBidPK int)
	
	SET @currentTime = CURRENT_TIMESTAMP

	--validate data
	--AdEngine
	IF NOT EXISTS (select * from AdvertisingEngine a where a.AdvertisingEngine = @AdvertisingEngine)
	BEGIN
		SELECT @ErrMsg = 'The Advertising Engine was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	select @MicroDefaultBid = aep.MicroDefaultBid from AdvertisingEnginePromotion aep
	inner join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK
	inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = aea.AdvertisingEngineFK
	where ae.AdvertisingEngine = @AdvertisingEngine and aep.PromotionFK = @PromotionPK
	/*
	update KeywordBid set MicroBidAmount = @MicroDefaultBid
	from KeywordBid kb 
	inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
	where kb.PromotionFK = @PromotionPK and  ae.AdvertisingEngine = @AdvertisingEngine and kb.IsDefaultValue = 1 and kb.MicroBidAmount != -1
	*/
	--Get all the active default keywords that are being updated
	insert into @KeybidTable
	select kb.KeywordBidPK from KeywordBid kb 
	inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
	where kb.PromotionFK = @PromotionPK and  ae.AdvertisingEngine = @AdvertisingEngine and kb.IsDefaultValue = 1  and kb.IsActive = 1 
			and kb.MicroBidAmount != -1 and kb.MicroBidAmount != @MicroDefaultBid
	
	
	--update the last bid with an end Date and set inactive
	UPDATE KeywordBid set EndDate = @currentTime, IsActive = 0 
	from KeywordBid kb
	inner join @KeybidTable kbt on kbt.keywordBidPK = kb.KeywordBidPK
	
	--add new active keyword bid
	INSERT INTO KeywordBid(KeywordFK,AdvertisingEngineFK,PromotionFK,StartDate,EndDate,IsActive,BidTypeFK,MicroBidAmount,KeywordAdEngineID, CompetitionType, IsDefaultValue)
	select kb.KeywordFK,kb.AdvertisingEngineFK,kb.PromotionFK,@currentTime,null,1,kb.BidTypeFK,@MicroDefaultBid,kb.KeywordAdEngineID, kb.CompetitionType, 1
	from KeywordBid kb
	inner join @KeybidTable kbt on kbt.keywordBidPK = kb.KeywordBidPK
			
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO