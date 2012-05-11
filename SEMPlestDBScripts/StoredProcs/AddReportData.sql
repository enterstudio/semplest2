IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.AddReportData') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.AddReportData;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.AddReportData
(

	@PromotionID			INT,
	@Keyword				NVARCHAR(250),
	@AdvertisingEngine		VARCHAR(50),
	@TransactionDate		datetime2, 
	@MicroBidAmount			int, 
	@NumberImpressions		int,
	@NumberClick			int, 
	@AveragePosition		int, 
	@AverageCPC				Money, 
	@BidType				VARCHAR(25),
	@QualityScore           INT = null,
	@ApprovalStatus			VARCHAR(30) = null,
	@FirstPageMicroCpc      INT = null,
	@MicroCost				int,
	@ID int output

)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @keywordBidPK int,  @BidTypeID int, 
			@AdEngineID int
	-- make sure keyword is in promotion
	if not exists (select * from PromotionKeywordAssociation pka inner join Keyword k on k.KeywordPK = pka.KeywordFK
					where k.Keyword = @Keyword and pka.PromotionFK = @PromotionID)
	BEGIN
		SELECT @ErrMsg = 'The Selected keyword does not exist for the Promotion'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;	
	set @ID = 0
	select @BidTypeID = bt.BidTypePK from BidType bt where bt.BidType = @BidType 
	select @AdEngineID = ae.AdvertisingEnginePK from AdvertisingEngine ae where ae.AdvertisingEngine = @AdvertisingEngine		
	--check to see if the KeywordBid Exists for the MatchType
	select @keywordBidPK = kb.KeywordBidPK from PromotionKeywordAssociation pka
		inner join Keyword k on k.KeywordPK = pka.KeywordFK
		inner join KeywordBid kb on kb.KeywordFK = k.KeywordPK
		where kb.PromotionFK = @PromotionID and kb.AdvertisingEngineFK = @AdEngineID and k.Keyword = @Keyword and kb.BidTypeFK = @BidTypeID
		
	if (@keywordBidPK is null)
	BEGIN
		SELECT @ErrMsg = 'The Selected keyword has not been bid on for the Promotion'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;	
	--ADD ONLY IF THE TRANSACTION DOES NOT EXIST
	if not exists (select * from AdvertisingEngineReportData aerd where aerd.KeywordBidFK = @keywordBidPK and aerd.TransactionDate = @TransactionDate)
	BEGIN
		insert into AdvertisingEngineReportData(TransactionDate, MicroBidAmount, NumberImpressions, NumberClick, 
			AveragePosition, AverageCPC, BidTypeFK, QualityScore,ApprovalStatus, FirstPageMicroCPC, MicroCost, CreatedDate)
			VALUES (@TransactionDate, @MicroBidAmount,@NumberImpressions, @NumberClick, @AveragePosition, @AverageCPC, @BidTypeID, @QualityScore, @ApprovalStatus,
			@FirstPageMicroCpc,@MicroCost,CURRENT_TIMESTAMP)
		set @ID = @@IDENTITY		
	END		
	
	RETURN @ID	  
	
	
END TRY
BEGIN CATCH
 
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO