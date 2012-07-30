alter table promotion drop column BudgetToAddDate
alter table promotion drop column BudgetToAddToNextCycle

-- NEED TO DROP THIS TABLE FIRST AdvertisingEngineReportData

---
--- CREATE TABLE: dbo.AdvertisingEngineReportData
---
CREATE TABLE dbo.AdvertisingEngineReportData
(
	AdvertisingEngineBidDataPK int NOT NULL IDENTITY,
	TransactionDate datetime2 NOT NULL,
	MicroBidAmount int NOT NULL,
	NumberImpressions int NOT NULL,
	NumberClick int NOT NULL,
	AveragePosition float NOT NULL,
	AverageCPC bigint NOT NULL,
	BidTypeFK int,
	QualityScore int,
	ApprovalStatus varchar(30),
	FirstPageMicroCPC int,
	MicroCost int,
	CreatedDate datetime2 NOT NULL DEFAULT getdate(),
	CostAppliedToPromotionDate datetime2,
	KeywordFK int NOT NULL,
	PromotionFK int NOT NULL,
	AdvertisingEngineFK int NOT NULL,
	PRIMARY KEY CLUSTERED (AdvertisingEngineBidDataPK)
)
GO
EXEC sp_addextendedproperty @name = 'MS_Description', @value = 'The unique key is keyword and transactionDAte ',
	@level0type = 'Schema', @level0name = 'dbo',
	@level1type = 'Table', @level1name = 'AdvertisingEngineReportData';
GO


---
--- CREATE FOREIGN KEY CONSTRAINT: REL_BidType_AdvertisingEngineReportData_2
---
ALTER TABLE dbo.AdvertisingEngineReportData ADD 
	CONSTRAINT REL_BidType_AdvertisingEngineReportData_2 FOREIGN KEY (BidTypeFK)
		REFERENCES dbo.BidType(BidTypePK)
GO


---
--- CREATE FOREIGN KEY CONSTRAINT: REL_Keyword_AdvertisingEngineReportData_3
---
ALTER TABLE dbo.AdvertisingEngineReportData ADD 
	CONSTRAINT REL_Keyword_AdvertisingEngineReportData_3 FOREIGN KEY (KeywordFK)
		REFERENCES dbo.Keyword(KeywordPK)
GO


---
--- CREATE FOREIGN KEY CONSTRAINT: REL_Promotion_AdvertisingEngineReportData_4
---
ALTER TABLE dbo.AdvertisingEngineReportData ADD 
	CONSTRAINT REL_Promotion_AdvertisingEngineReportData_4 FOREIGN KEY (PromotionFK)
		REFERENCES dbo.Promotion(PromotionPK)
GO


---
--- CREATE FOREIGN KEY CONSTRAINT: REL_AdvertisingEngine_AdvertisingEngineReportData_5
---
ALTER TABLE dbo.AdvertisingEngineReportData ADD 
	CONSTRAINT REL_AdvertisingEngine_AdvertisingEngineReportData_5 FOREIGN KEY (AdvertisingEngineFK)
		REFERENCES dbo.AdvertisingEngine(AdvertisingEnginePK)
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

ALTER VIEW [dbo].[vwPromotionChart]
AS
SELECT     k.Keyword, p.PromotionName, a.NumberImpressions, a.NumberClick, a.TransactionDate, CONVERT(DECIMAL, a.MicroBidAmount) / 1000000. AS MicroBidAmount, 
                      CONVERT(INT, a.AveragePosition) AS AveragePosition, CONVERT(DECIMAL, a.AverageCPC) / 1000000. AS AverageCPC, a.AdvertisingEngineBidDataPK, 
                      u.UserPK
FROM         dbo.AdvertisingEngineReportData AS a INNER JOIN
                      dbo.Keyword AS k ON a.KeywordFK = k.KeywordPK INNER JOIN
                      dbo.Promotion AS p ON a.PromotionFK = p.PromotionPK INNER JOIN
                      dbo.ProductGroup AS pg ON p.ProductGroupFK = pg.ProductGroupPK INNER JOIN
                      dbo.Customer AS c ON pg.CustomerFK = c.CustomerPK INNER JOIN
                      dbo.Users AS u ON c.CustomerPK = u.CustomerFK

GO
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
	DECLARE @ErrMsg VARCHAR(250), @AdEngineID int
	
	set @AdEngineID = null

	--validate data
	IF NOT EXISTS (select * from Promotion p where p.PromotionPK =@PromotionPK)
	BEGIN
		SELECT @ErrMsg = 'The Promotion was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	if (@AdvertisingEngine is not null)
	BEGIN
		if exists (select * from AdvertisingEngine ae where ae.AdvertisingEngine = @AdvertisingEngine)
		BEGIN
			select @AdEngineID = ae.AdvertisingEnginePK from AdvertisingEngine ae where ae.AdvertisingEngine = @AdvertisingEngine
		END
		ELSE
		BEGIN
			SELECT @ErrMsg = 'The AdEngine ' + @AdvertisingEngine + ' was not found.'; 
			RAISERROR (@ErrMsg, 16, 1);
		END	
	END
			

	Declare @costTable Table(KeywordFK int, Cost Bigint);
	--get general info
	insert into @costTable(KeywordFK, Cost)
	select aerd.KeywordFK, Sum(aerd.MicroCost) [TotalMicroSpent] from 
		AdvertisingEngineReportData aerd
		where aerd.PromotionFK = @PromotionPK and (@AdEngineID is null or aerd.AdvertisingEngineFK = @AdEngineID)
			and aerd.TransactionDate >= @StartDate and (@EndDate is null or aerd.TransactionDate <= @EndDate)
		group by aerd.KeywordFK	
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
		and aerd.BidTypeFK =  @BidTypeID and aerd.TransactionDate = @TransactionDate)
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
		
		select @ID = aerd.AdvertisingEngineBidDataPK from AdvertisingEngineReportData aerd 
		where aerd.PromotionFK = @PromotionID and aerd.KeywordFK = @keywordPK 
			and aerd.BidTypeFK =  @BidTypeID and aerd.AdvertisingEngineFK = @AdEngineID and aerd.TransactionDate = @TransactionDate	
			
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

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetAllPromotionData') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetAllPromotionData;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetAllPromotionData
(
	@PromotionPK            INT
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
	select p.PromotionPK,p.ProductGroupFK,p.PromotionName,p.PromotionDescription,p.LandingPageURL,p.DisplayURL,
		p.PromotionBudgetAmount,p.PromotionStartDate, p.PromotionEndDate,bc.BudgetCycle,
		p.CycleStartDate,
		p.RemainingBudgetInCycle,p.StartBudgetInCycle,
		p.EditedDate, p.IsLaunched, p.IsCompleted,p.IsPaused,p.CreatedDate, aep.AdvertisingEngineCampaignPK, aep.AdvertisingEngineAdGroupID , aea.AdvertisingEngineAccountPK,aea.AdvertisingEngineAccountNumber, ae.AdvertisingEngine

		from Promotion p 
		inner join BudgetCycle bc on bc.BudgetCyclePK = p.BudgetCycleFK
		left join AdvertisingEnginePromotion aep on aep.PromotionFK = p.PromotionPK
		left join AdvertisingEngineAccount aea on aea.AdvertisingEngineAccountPK = aep.AdvertisingEngineAccountFK
		left join AdvertisingEngine ae on aea.AdvertisingEngineFK = ae.AdvertisingEnginePK
		where p.PromotionPK  = @PromotionPK
		--get ADs
		select pa.PromotionAdsPK,pa.PromotionFK,  pa.AdTitle, pa.AdTextLine1, pa.AdTextLine2, aea.AdvertisingEngineAdPK [AdEngineAdID], pa.IsDeleted, pa.CreatedDate, pa.DeletedDate from Promotion p
		inner join PromotionAds pa on pa.PromotionFK = p.PromotionPK
		left outer join AdvertisingEngineAds aea on aea.PromotionAdsFK = pa.PromotionAdsPK
		where p.PromotionPK = @PromotionPK
		--get Geotargeting
		select gt.Address, gt.City,st.StateAbbr [State], gt.Zip, gt.Latitude, gt.Longitude,gt.ProximityRadius [Radius] from Promotion p 
		inner join GeoTargeting gt on gt.PromotionFK = p.PromotionPK
		left join StateCode st on st.StateAbbrPK = gt.StateCodeFK
		where p.PromotionPK = @PromotionPK			 
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO

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
	DECLARE @ErrMsg VARCHAR(250), @Cost money, @paid money

	--validate data
	IF NOT EXISTS (select * from Promotion p where p.PromotionPK =@PromotionPK)
	BEGIN
		SELECT @ErrMsg = 'The Promotion was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	Declare @ReportDataTable Table(TransactionDate datetime2, MicroCost bigint)
	--Table of transactions not yet applied to promotion from all AdEngines
	insert into @ReportDataTable(TransactionDate,MicroCost)
	select aerd.TransactionDate, aerd.MicroCost from AdvertisingEngineReportData aerd
		where aerd.PromotionFK = @PromotionPK
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
	 update Promotion set RemainingBudgetInCycle = RemainingBudgetInCycle - (isNull(@Cost,0)/1000000), EditedDate = CURRENT_TIMESTAMP
	 from Promotion p where p.PromotionPK = @PromotionPK
	
	 update AdvertisingEngineReportData set CostAppliedToPromotionDate = CURRENT_TIMESTAMP
	 from AdvertisingEngineReportData aerd
	 inner join @ReportDataTable rd on aerd.PromotionFK = @PromotionPK and rd.TransactionDate = aerd.TransactionDate
	
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