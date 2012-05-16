IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetSpendForPromotion') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetSpendForPromotion;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetSpendForPromotion
(
	@PromotionPK            INT,
	@AdvertisingEngine		VARCHAR(25),
	@StartDate				datetime2,
	@EndDate				datetime2 = null,
	@Cost bigint output
	
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
	Declare @costTable Table(KeywordFK int, Cost Bigint);
	--get general info
	insert into @costTable(KeywordFK, Cost)
	select kb.KeywordFK, Sum(aerd.MicroCost) [TotalMicroSpent] from KeywordBid kb 
	inner join AdvertisingEngineReportData aerd on aerd.KeywordBidFK = kb.KeywordBidPK
	inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
	where kb.PromotionFK = @PromotionPK and ae.AdvertisingEngine = @AdvertisingEngine
	and aerd.TransactionDate >= @StartDate and (@EndDate is null or aerd.TransactionDate <= @EndDate)
	group by kb.KeywordFK	
	having Sum(aerd.MicroCost) > 0
	
	select @Cost = SUM(cost) from @costTable
	
	return @Cost			 
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO