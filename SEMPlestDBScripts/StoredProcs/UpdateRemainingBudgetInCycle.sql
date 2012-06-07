IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.UpdateRemainingBudgetInCycle') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.UpdateRemainingBudgetInCycle;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.UpdateRemainingBudgetInCycle
(
	@PromotionPK            INT,
	@StartDate				datetime2,
	@EndDate				datetime2,
	@ID int output
	
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @Cost bigint, @paid bigint

	--validate data
	IF NOT EXISTS (select * from Promotion p where p.PromotionPK =@PromotionPK)
	BEGIN
		SELECT @ErrMsg = 'The Promotion was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	Declare @ReportDataTable Table(KeywordBidFK int, TransactionDate datetime2, MicroCost bigint)
	--Table of transactions not yet applied to promotion from all AdEngines
	insert into @ReportDataTable(KeywordBidFK,TransactionDate,MicroCost)
	select aerd.KeywordBidFK, aerd.TransactionDate, aerd.MicroCost from KeywordBid kb 
		inner join AdvertisingEngineReportData aerd on aerd.KeywordBidFK = kb.KeywordBidPK
		inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = kb.AdvertisingEngineFK
		where kb.PromotionFK = @PromotionPK
		and aerd.TransactionDate >= @StartDate and aerd.TransactionDate <= @EndDate and aerd.MicroCost > 0 and aerd.CostAppliedToPromotionDate is null
		
	--Total cost update a given Date
	select @Cost = SUM(MicroCost) from @ReportDataTable
	--Total amount paid until date
	select @paid = SUM(cct.MediaSpend) * 1000000 from PromotionPayment pp
	inner join CreditCardTransaction cct on cct.CreditCardTransactionPK = pp.CreditCardTransactionFK
	where pp.IsValid = 1 and pp.BudgetToAddDate <= @EndDate and pp.PromotionFK = @PromotionPK
	--update the remaining budget
	BEGIN TRANSACTION
	
	 --update Promotion set RemainingBudgetInCycle = (Isnull(@paid,0) - isNull(@Cost,0))/1000000, EditedDate = CURRENT_TIMESTAMP
	 --from Promotion p where p.PromotionPK = @PromotionPK
	 --THIS NEEDS TO BE FIXED AFTER CREDIT CARD
	 update Promotion set RemainingBudgetInCycle = RemainingBudgetInCycle - ((Isnull(@paid,0) - isNull(@Cost,0))/1000000), EditedDate = CURRENT_TIMESTAMP
	 from Promotion p where p.PromotionPK = @PromotionPK
	
	 update AdvertisingEngineReportData set CostAppliedToPromotionDate = CURRENT_TIMESTAMP
	 from AdvertisingEngineReportData aerd
	 inner join @ReportDataTable rd on rd.KeywordBidFK = aerd.KeywordBidFK and rd.TransactionDate = aerd.TransactionDate
	
	COMMIT TRANSACTION
	
	Set @ID = @PromotionPK
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