IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.AddKeywordBidData') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.AddKeywordBidData;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.AddKeywordBidData
(

	@PromotionID			INT,
	@Keyword				NVARCHAR(250),
	@AdvertisingEngine		VARCHAR(50),
	@BidType				VARCHAR(25),
	@QualityScore           INT = null,
	@ApprovalStatus			VARCHAR(30) = null,
	@FirstPageMicroCpc      INT = null,
	@IsEligibleForShowing	BIT = 1,
	@ID int output
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @keywordBidPK int, @currentTime datetime2, @BidTypeID int, 
			@AdEngineID int,@keywordPK int
	-- make sure keyword is in promotion
	if not exists (select * from PromotionKeywordAssociation pka inner join Keyword k on k.KeywordPK = pka.KeywordFK
					where k.Keyword = @Keyword and pka.PromotionFK = @PromotionID)
	BEGIN
		SELECT @ErrMsg = 'The Selected keyword does not exist for the Promotion'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;	
	set @currentTime = CURRENT_TIMESTAMP
	SET @ID = 0	
	BEGIN TRANSACTION		
	--check to see if the KeywordBid Exists for the MatchType
	if NOT EXISTS (select * from KeywordBid kb 
					inner join Keyword k on k.KeywordPK = kb.KeywordFK
					inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
					inner join BidType bt on bt.BidTypePK = kb.BidTypeFK 
					where kb.PromotionFK = @PromotionID and k.Keyword = @Keyword and ae.AdvertisingEngine = @AdvertisingEngine and bt.BidType = @BidType)
	BEGIN
	--add Keyword /matchtype with -1 microbid
		
		select @BidTypeID = bt.BidTypePK from BidType bt where bt.BidType = @BidType 
		select @AdEngineID = ae.AdvertisingEnginePK from AdvertisingEngine ae where ae.AdvertisingEngine = @AdvertisingEngine  
		--
		insert into KeywordBid(KeywordFK,AdvertisingEngineFK,PromotionFK,StartDate,EndDate,IsActive, BidTypeFK, MicroBidAmount, IsDefaultValue, CreatedDate)
			select k.KeywordPK,@AdEngineID,@PromotionID,@currentTime,@currentTime,0,@BidTypeID,-1,0,@currentTime from Keyword k where k.Keyword = @Keyword
		SET @keywordBidPK = @@IDENTITY
		insert into KeywordBidData(KeywordBidFK,QualityScore,ApprovalStatus,FirstPageMicroCPC,IsEligibleForShowing,CreatedDate)
			VALUES (@keywordBidPK, @QualityScore, @ApprovalStatus, @FirstPageMicroCpc, @IsEligibleForShowing, @currentTime)
		SET @ID = @@IDENTITY	
	END	
	ELSE --keywordBid already exists for match type				 
	BEGIN
		select @keywordBidPK = kb.KeywordBidPK from KeywordBid kb 
					inner join Keyword k on k.KeywordPK = kb.KeywordFK
					inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
					inner join BidType bt on bt.BidTypePK = kb.BidTypeFK 
					where kb.PromotionFK = @PromotionID and k.Keyword = @Keyword and ae.AdvertisingEngine = @AdvertisingEngine and bt.BidType = @BidType
		insert into KeywordBidData(KeywordBidFK,QualityScore,ApprovalStatus,FirstPageMicroCPC,IsEligibleForShowing,CreatedDate)
			VALUES (@keywordBidPK, @QualityScore, @ApprovalStatus, @FirstPageMicroCpc, @IsEligibleForShowing, @currentTime)
		SET @ID = @@IDENTITY	
	END
	
	COMMIT TRANSACTION	
	return @ID
	
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