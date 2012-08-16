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
	DECLARE @ErrMsg VARCHAR(250),  @BidTypeID int, @AdEngineID int, @keywordPK int
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
	select @keywordPK = k.KeywordPK from Keyword k where k.Keyword = @Keyword
	if (@BidTypeID is null or @AdEngineID is null or @keywordPK is null)
	BEGIN
		SELECT @ErrMsg = 'The Bid Type, AdEngine or keyword Not found'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	--ADD ONLY IF THE TRANSACTION DOES NOT EXIST
	if not exists (select * from AdvertisingEngineReportData aerd where aerd.PromotionFK = @PromotionID and aerd.KeywordFK = @keywordPK 
		and aerd.BidTypeFK =  @BidTypeID and aerd.AdvertisingEngineFK = @AdEngineID and aerd.TransactionDate = @TransactionDate)
	BEGIN
		insert into AdvertisingEngineReportData(PromotionFK, KeywordFK,AdvertisingEngineFK, TransactionDate, MicroBidAmount, NumberImpressions, NumberClick, 
			AveragePosition, AverageCPC, BidTypeFK, QualityScore,ApprovalStatus, FirstPageMicroCPC, MicroCost, CreatedDate)
			VALUES (@PromotionID,@keywordPK,@AdEngineID, @TransactionDate, @MicroBidAmount,@NumberImpressions, @NumberClick, @AveragePosition, @AverageCPC, @BidTypeID, @QualityScore, @ApprovalStatus,
			@FirstPageMicroCpc,@MicroCost,CURRENT_TIMESTAMP)
		set @ID = @@IDENTITY		
	END
	ELSE -- exists just update		
	BEGIN
		update AdvertisingEngineReportData
		set MicroBidAmount = @MicroBidAmount, NumberImpressions = @NumberImpressions, NumberClick = @NumberClick, 
			AveragePosition = @AveragePosition, AverageCPC = @AverageCPC, QualityScore = @QualityScore,ApprovalStatus = @ApprovalStatus, 
			FirstPageMicroCPC = @FirstPageMicroCpc, MicroCost = @MicroCost
		from AdvertisingEngineReportData aerd 
		where aerd.PromotionFK = @PromotionID and aerd.KeywordFK = @keywordPK 
			and aerd.BidTypeFK =  @BidTypeID and aerd.AdvertisingEngineFK = @AdEngineID and aerd.TransactionDate = @TransactionDate
		--@ID will return 0
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