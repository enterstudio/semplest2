IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetLatestBiddableAdGroupCriteria') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetLatestBiddableAdGroupCriteria;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetLatestBiddableAdGroupCriteria
(
	@PromotionPK            INT,
	@AdvertisingEngine		varchar(25)
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
	--get general info
	select kb.KeywordAdEngineID,k.Keyword,kb.MicroBidAmount,mkbd.ApprovalStatus, bt.BidType [MatchType],mkbd.FirstPageMicroCPC, 
				mkbd.QualityScore,mkbd.IsEligibleForShowing, pka.IsNegative,mkbd.CreatedDate from Keyword k
			inner join KeywordBid kb on k.KeywordPK = kb.KeywordFK
			inner join BidType bt on bt.BidTypePK = kb.BidTypeFK
			inner join Promotion p on p.PromotionPK = kb.PromotionFK
			inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK and pka.KeywordFK = kb.KeywordFK
			inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
			left join  
				(select kbd.KeywordBidFK,kbd.ApprovalStatus ,kbd.FirstPageMicroCPC,kbd.QualityScore,kbd.IsEligibleForShowing,kbd.CreatedDate,MAX(kbd.CreatedDate) [lastDate]  from KeywordBidData kbd 
				inner join KeywordBid kb on kb.KeywordBidPK = kbd.KeywordBidFK
				inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
				where kb.PromotionFK = @PromotionPK and ae.AdvertisingEngine = @AdvertisingEngine and kb.IsActive = 1
				group by kbd.KeywordBidFK,kbd.ApprovalStatus,kbd.FirstPageMicroCPC,kbd.QualityScore,kbd.IsEligibleForShowing,kbd.CreatedDate) mkbd 
				on mkbd.KeywordBidFK = kb.KeywordBidPK
				
			where kb.PromotionFK = @PromotionPK and kb.IsActive = 1 and ae.AdvertisingEngine = @AdvertisingEngine			 
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO