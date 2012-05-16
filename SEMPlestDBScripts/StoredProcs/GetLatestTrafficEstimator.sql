IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetLatestTrafficEstimator') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetLatestTrafficEstimator;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetLatestTrafficEstimator
(
	@PromotionPK            INT,
	@AdvertisingEngine		varchar(25),
	@Keyword				NVARCHAR(250) = null
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)

	--validate data
	IF NOT EXISTS (select * from Promotion p where p.PromotionPK =@PromotionPK)
	BEGIN
		SELECT @ErrMsg = 'The Promotion was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,te.MicroBid, te.AveMicroCost, te.AveNumberClicks, te.AvePosition,te.AveCPC,bt.BidType,pka.IsNegative, te.CreatedDate, kb.IsActive 
				from KeywordBid kb 
		inner join Keyword k on k.KeywordPK = kb.KeywordFK
		inner join BidType bt on bt.BidTypePK = kb.BidTypeFK
		inner join TrafficEstimator te on te.KeywordBidFK = kb.KeywordBidPK
		inner join Promotion p on p.PromotionPK = kb.PromotionFK
		inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK and pka.KeywordFK = kb.KeywordFK
		inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
		inner join    
				(select te.KeywordBidFK,MAX(te.CreatedDate) [lastDate]  from TrafficEstimator te
				inner join KeywordBid kb on te.KeywordBidFK = kb.KeywordBidPK
				inner join Keyword k on k.KeywordPK = kb.KeywordFK
				inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
				where kb.PromotionFK = @PromotionPK and (@Keyword is null or k.Keyword = @Keyword) and ae.AdvertisingEngine = @AdvertisingEngine
				group by te.KeywordBidFK) mte on te.KeywordBidFK = kb.KeywordBidPK and mte.lastDate = te.CreatedDate 
		where pka.PromotionFK = @PromotionPK and  (@Keyword is null or k.Keyword = @Keyword) and ae.AdvertisingEngine = @AdvertisingEngine			 
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO