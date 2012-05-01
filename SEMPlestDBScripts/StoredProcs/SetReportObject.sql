IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.SetReportObject') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.SetReportObject;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.SetReportObject
(

	@AccountID			BIGINT,
	@CampaignID        BIGINT,
	@Keyword				NVARCHAR(250),
	@TransactionDate        datetime2,
	@MicroBidAmount			INT,
	@ApprovalStatus			VARCHAR(30) = null,
	@BidType				VARCHAR(25),
	@FirstPageMicroCpc      INT = null,
	@QualityScore           INT = null,
	@IsEligibleForShowing	BIT = 1,
	@IsBidActive			BIT = 1,
	@IsNegative				BIT = 0,
	@AdvertisingEngine		VARCHAR(50),
	@SemplestProbability    float = null
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @keywordBidPK int, @currentTime datetime2, @BidTypeID int, 
			@AdEngineID int,@keywordPK int
		 
	-- get the keyword bid PK
	select @keywordBidPK = kb.KeywordBidPK from AdvertisingEngineAccount a
	inner join AdvertisingEnginePromotion ap on a.AdvertisingEngineAccountPK = ap.AdvertisingEngineAccountFK
	inner join KeywordBid kb on kb.PromotionFK = ap.PromotionFK
	inner join Keyword k on k.KeywordPK = kb.KeywordFK 
	where a.AdvertisingEngineAccountPK = @AccountID and ap.AdvertisingEngineCampaignPK = @CampaignID 
		and k.Keyword =@Keyword
	if (@keywordBidPK is null)
	BEGIN
		SELECT @ErrMsg = 'The Keyword Bid was not found for keyword.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
		
	
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