alter table promotion drop column BudgetToAddDate
alter table promotion drop column BudgetToAddToNextCycle

alter table promotionpayment drop constraint DF__Promotion___Budg__314D4EA8
alter table promotionpayment drop column _BudgetCarryOverAmount_
alter table promotionpayment add BudgetCarryOverAmount money

-- NEED TO DROP THIS TABLE FIRST AdvertisingEngineReportData

---
--- CREATE TABLE: dbo.AdvertisingEngineReportData
---
drop table AdvertisingEngineReportData
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
SELECT     k.Keyword, p.PromotionName, a.NumberImpressions, a.NumberClick, a.TransactionDate, CONVERT(DECIMAL, ISNULL(a.MicroBidAmount, 0)) 
                      / 1000000. AS MicroBidAmount, CONVERT(INT, ISNULL(a.AveragePosition, 0)) AS AveragePosition, CONVERT(DECIMAL, ISNULL(a.AverageCPC, 0)) 
                      / 1000000. AS AverageCPC, a.AdvertisingEngineBidDataPK, u.UserPK, a.PromotionFK, a.AdvertisingEngineFK
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


/****** Object:  View [dbo].[vwCreditCardTransactionDetail]    Script Date: 08/01/2012 13:01:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

/*-
- CREATE VIEW: vwCreditCardTransactionDetail
-*/
ALTER VIEW [dbo].[vwCreditCardTransactionDetail]
AS
SELECT     dbo.CreditCardProfile.CreditCardProfilePK, dbo.CreditCardProfile.CustomerFK, dbo.CreditCardProfile.CustomerRefNum, dbo.CreditCardProfile.AuthCode, 
                      dbo.CreditCardProfile.TxRefNum, dbo.CreditCardTransaction.CreditCardTransactionPK, dbo.CreditCardTransaction.CreditCardProfileFK, 
                      dbo.CreditCardTransaction.OrderID, dbo.CreditCardTransaction.Amount, dbo.CreditCardTransaction.CreatedDate, dbo.CreditCardTransaction.SEMplestFee, 
                      dbo.CreditCardTransaction.MediaSpend, dbo.CreditCardTransaction.IsRefund, dbo.Customer.CustomerPK, dbo.Customer.Name, 
                      dbo.Customer.TotalTargetCycleBudget, dbo.Customer.ProductGroupCycleTypeFK, dbo.Customer.BillTypeFK, dbo.Customer.ServiceFee, dbo.Customer.PercentOfMedia,
                       dbo.Customer.InternalCustomerId, dbo.Customer.CreditLimit, dbo.Customer.PromotionFeeOverride, dbo.Customer.PromotionFeeAmount, 
                      dbo.ProductGroup.ProductGroupPK, dbo.ProductGroup.StartDate, dbo.ProductGroup.ProductGroupName, dbo.ProductGroup.EndDate, dbo.ProductGroup.IsActive, 
                      dbo.Promotion.PromotionPK, dbo.Promotion.ProductGroupFK, dbo.Promotion.PromotionName, dbo.Promotion.PromotionDescription, 
                      dbo.Promotion.PromotionStartDate, dbo.Promotion.PromotionEndDate, dbo.Promotion.LandingPageURL, dbo.Promotion.PromotionBudgetAmount, 
                      dbo.Promotion.BudgetCycleFK, dbo.Promotion.CycleStartDate, dbo.Promotion.CycleEndDate, dbo.Promotion.StartBudgetInCycle, 
                      dbo.Promotion.RemainingBudgetInCycle, dbo.Promotion.IsPaused, dbo.Promotion.IsCompleted, dbo.Promotion.IsLaunched, dbo.Promotion.IsDeleted, 
                      dbo.Promotion.TargetCPCLevel, dbo.Promotion.DisplayURL, dbo.PromotionPayment.PromotionPaymentPK, dbo.PromotionPayment.PromotionFK, 
                      dbo.PromotionPayment.BudgetToAddDate AS PaymentBudgetToAddDate, dbo.PromotionPayment.IsValid, dbo.PromotionPayment.CreditCardTransactionFK, 
                      dbo.AdvertisingEngineAccount.AdvertisingEngineAccountPK, dbo.AdvertisingEngineAccount.AdvertisingEngineFK, 
                      dbo.AdvertisingEngineAPICharge.AdvertisingEngineAPIChargePK, dbo.AdvertisingEngineAPICharge.AdvertisingEngineAccountFK, 
                      dbo.AdvertisingEngineAPICharge.APIUnits, dbo.AdvertisingEngineAPICharge.APICost
FROM         dbo.ProductGroup INNER JOIN
                      dbo.Customer ON dbo.ProductGroup.CustomerFK = dbo.Customer.CustomerPK INNER JOIN
                      dbo.Promotion ON dbo.ProductGroup.ProductGroupPK = dbo.Promotion.ProductGroupFK INNER JOIN
                      dbo.PromotionPayment ON dbo.Promotion.PromotionPK = dbo.PromotionPayment.PromotionFK INNER JOIN
                      dbo.CreditCardProfile INNER JOIN
                      dbo.CreditCardTransaction ON dbo.CreditCardProfile.CreditCardProfilePK = dbo.CreditCardTransaction.CreditCardProfileFK ON 
                      dbo.PromotionPayment.CreditCardTransactionFK = dbo.CreditCardTransaction.CreditCardTransactionPK INNER JOIN
                      dbo.AdvertisingEngineAccount ON dbo.Customer.CustomerPK = dbo.AdvertisingEngineAccount.CustomerFK INNER JOIN
                      dbo.AdvertisingEngineAPICharge ON dbo.AdvertisingEngineAccount.AdvertisingEngineAccountPK = dbo.AdvertisingEngineAPICharge.AdvertisingEngineAccountFK

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
		select pa.PromotionAdsPK,pa.PromotionFK,  pa.AdTitle, pa.AdTextLine1, pa.AdTextLine2, aea.AdvertisingEngineAdPK [AdEngineAdID], pa.IsDeleted, pa.CreatedDate, pa.DeletedDate, aea.AdvertisingEngineFK from Promotion p
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



IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.SetNegativeKeyword') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.SetNegativeKeyword;
GO

/****** Object:  StoredProcedure [dbo].[sp_UpdateKeywords]    Script Date: 06/19/2012 00:13:51 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Andre'
-- Create date: 6/7/2012
-- Description:	update neg keyword for ALL AdEngines (after launch)
-- =============================================
CREATE PROCEDURE [dbo].[SetNegativeKeyword] 
	-- Add the parameters for the stored procedure here
	@keyword nvarchar(250),
	@PromotionID int,
	@NegativeKeywordID int output,
	@Exists bit output
AS
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @ID int 
	
	
	--check to see if the negative keyword is associated to the promotion is already neg
	if exists (select * from Keyword k
				inner join PromotionKeywordAssociation pka on pka.KeywordFK = k.KeywordPK 
				where k.Keyword = @keyword and pka.PromotionFK = @PromotionID and pka.IsNegative = 1)
	BEGIN
		 select k.KeywordPK from Keyword k where k.KeywordPK=-1
		 return
	END
	
	BEGIN Transaction
	--Exists as positive 	
	if exists (select * from Keyword k
				inner join PromotionKeywordAssociation pka on pka.KeywordFK = k.KeywordPK 
				where k.Keyword = @keyword and pka.PromotionFK = @PromotionID and pka.IsNegative = 0)
	BEGIN
		SET @Exists = 1
		update PromotionKeywordAssociation set IsNegative = 1
			from Keyword k
			inner join PromotionKeywordAssociation pka on pka.KeywordFK = k.KeywordPK 
			where k.Keyword = @keyword and pka.PromotionFK = @PromotionID
	END	
	--In keyword table but not associate to the promo
	ELSE if exists	(select * from Keyword k where k.Keyword = @keyword)
	BEGIN
		SET @Exists = 0
		insert into PromotionKeywordAssociation(KeywordFK, PromotionFK, IsActive,IsDeleted,IsNegative,IsTargetGoogle, IsTargetMSN,CreatedDate)
		select k.KeywordPK,@PromotionID,1,0,1,1,1,CURRENT_TIMESTAMP from Keyword k where k.Keyword = @keyword
	END
	ELSE -- does not exists yet
	BEGIN
		SET @Exists = 0
		insert into Keyword(Keyword,CreatedDate) values (@keyword,CURRENT_TIMESTAMP)
		SET @ID = @@IDENTITY
		insert into PromotionKeywordAssociation(KeywordFK, PromotionFK, IsActive,IsDeleted,IsNegative,IsTargetGoogle, IsTargetMSN,CreatedDate)
		VALUES (@ID,@PromotionID,1,0,1,1,1,CURRENT_TIMESTAMP)
	END
	
	update pka set pka.IsDeleted = 1 from PromotionKeywordAssociation pka
		inner join keyword k on pka.KeywordFK = k.KeywordPK 
		where pka.PromotionFK = @PromotionID and pka.IsNegative = 0 
		and (k.Keyword like '% ' + @keyword or k.Keyword like @keyword + ' %' or k.Keyword like '% ' + @keyword + ' %')
	
	select k.KeywordPK from Keyword k
				inner join PromotionKeywordAssociation pka on pka.KeywordFK = k.KeywordPK 
				where pka.PromotionFK = @PromotionID and pka.IsNegative = 0
				and (k.Keyword like '% ' + @keyword or k.Keyword like @keyword + ' %' or k.Keyword like '% ' + @keyword + ' %')
	commit transaction												
	set @NegativeKeywordID = @ID										
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




/****** Object:  StoredProcedure [dbo].[GetKeywordForAdEngine]    Script Date: 08/06/2012 14:19:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

ALTER PROCEDURE [dbo].[GetKeywordForAdEngine]
(
	@PromotionPK            INT,
	@IsTargetGoogle bit = 0,
	@IsTargetMSN bit = 0
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
	
	select k.KeywordPK, k.Keyword, pka.IsTargetGoogle, pka.IsTargetMSN, pka.IsActive, pka.IsDeleted, pka.IsNegative, pka.SemplestProbability
	from Promotion p 
	inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK
	inner join Keyword k on k.KeywordPK = pka.KeywordFK
	where p.PromotionPK = @PromotionPK and (pka.IsTargetGoogle = @IsTargetGoogle or pka.IsTargetMSN = @IsTargetMSN) and pka.IsActive = 1
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetMSNGeoLocation') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetMSNGeoLocation;
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetMSNGeoLocation') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetMSNGeoLocation;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 		
-- EXAMPLE When PromoyionID is null
--DECLARE @totalSize int
--exec GetMSNGeoLocation @PromotionID = NULL, @ValueList = 'MA,,,;,41.5069100000,-71.3016090000,100.00', @ValueDelimiter = ',', @ListDelimiter = ';',@totalSize = @totalSize
			
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetMSNGeoLocation
(
	@PromotionID int = null,
	@ValueList varchar(max) = null,
	@ValueDelimiter varchar(3) = null,
	@ListDelimiter varchar(3) = null, 
	@totalSize int output
)
AS
BEGIN TRY
SET NOCOUNT ON;
declare @geoTargets Table(StateCode varchar(2),Latitude Decimal(18,10), Longitude Decimal(18,10),Radius Decimal(18,2) )
declare @cities table(city varchar(200), metroID int)
declare @citiesTEMP table(city varchar(200), metroID int)
declare @states table(states varchar(10))
declare @metro table(metro varchar(100), metroID int)
declare @citiesInStates table(city varchar(200))
declare @GeoPts table (pt Geography, Radius Decimal(18,2))

declare @metroSummary table(ID int, number int)
declare @citymetroSummary table(ID int, number int)
declare @LocationID Table (ID int);
DECLARE @pt geography, @str varchar(100),@Latitude Decimal(18,10), @Longitude Decimal(18,10),@Radius Decimal(18,2), @stateCount int, @metroCount int, @cityCount int


DECLARE @CostBasisTypeIDtbl TABLE (CostBasisTypeID int, BasisValue bit)
 --PUT THE CostBasis AND VALUE INTO  table 
 if (@PromotionID is null)	 
 BEGIN
	insert into @geoTargets(StateCode ,Latitude,Longitude,Radius)
	select s.Column1 [StateCode], CAST (Isnull(s.Column2, -1) as DECIMAL(18,10)) [Latitude], CAST (Isnull(s.Column3, -1) as DECIMAL(18,10)) [Longitude], CAST (Isnull(s.Column4, -1) as DECIMAL(18,2)) [Radius] from dbo.Split(@ValueList,@ListDelimiter) r 
	CROSS APPLY dbo.SplitIntoColumns(r.DATA,@ValueDelimiter) s
	
	
END
ELSE
BEGIN
	insert into @geoTargets(StateCode,Latitude,Longitude,Radius)
	select st.StateAbbr [State], gt.Latitude, gt.Longitude,gt.ProximityRadius from Promotion p 
		inner join GeoTargeting gt on gt.PromotionFK = p.PromotionPK
		left join StateCode st on st.StateAbbrPK = gt.StateCodeFK
		where p.PromotionPK = @PromotionID
END		
--select * from @geoTargets
--select * from @geoTargets gt where (gt.Radius is not null and gt.Radius <> -1)
insert into @states(states) 
select DISTINCT 'US-' + gt.StateCode from @geoTargets gt	
where (gt.Radius is null or gt.Radius = -1)

insert into @LocationID(ID)
select msn.LocationID from MSNGeoLocation msn 
inner join @states s on s.states = msn.MSNName and msn.IsState = 1

if exists (select * from @geoTargets gt where (gt.Radius is not null and gt.Radius <> -1))
BEGIN
	insert into @GeoPts(pt,Radius)
	select geography::STGeomFromText('POINT(' + Cast(gt.Longitude as Varchar) + ' ' + Cast(gt.Latitude as Varchar) + ')', 4326), gt.Radius 
	from @geoTargets gt where (gt.Radius is not null and gt.Radius <> -1) 
	
	Insert into @citiesTEMP(city, metroID)
	select s.MSNName,s.ParentMetroAreaLocationID from @GeoPts gp
	cross apply (
	SELECT msn.MSNName, msn.ParentMetroAreaLocationID from MSNGeoLocation msn
		WHERE msn.GeogCol1.STDistance(gp.pt)<=(gp.Radius * 1609.344) and msn.IsCity = 1) s
END

--get remaining cities
insert into @cities(city,metroID)
select distinct c.city, c.metroID from @citiesTEMP c
left join @citiesInStates cis on c.city = cis.city
where c.city is not null

insert into @citymetroSummary(ID,number)
select c.metroID, COUNT(*) from @cities c
group by c.metroID

insert into @metroSummary(ID,number)
select msn.ParentMetroAreaLocationID, COUNT(*) from MSNGeoLocation msn
where msn.IsCity = 1 and msn.ParentMetroAreaLocationID in (select DISTINCT cms.ID from @citymetroSummary cms) 
group by msn.ParentMetroAreaLocationID

insert into @metro(metro,metroID)
select DISTINCT msn.MSNName, msn.LocationID from MSNGeoLocation msn inner join  
(select ms.ID from @citymetroSummary cs
inner join @metroSummary ms on cs.ID = ms.ID and cs.number = ms.number) m 
on msn.LocationID = m.ID

--get all unque cities for all geotargets
delete @cities
from @cities c
inner join @metro m on m.metroID = c.metroID

select @stateCount = count(s.states) from @states s
select @metroCount = count(m.metro) from @metro m
select @cityCount = count(c.city) from @cities c
set @totalSize = ISNULL(@stateCount, 0) + ISNULL(@metroCount, 0) + ISNULL(@cityCount, 0)

select s.states [msnName] from @states s
select m.metro [msnName] from @metro m
select c.city [msnName] from @cities c


return @totalSize

	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO
--- CREATE COLUMN: IsMasterProfile
---
ALTER TABLE dbo.NickNameProfileAssociation ADD IsMasterProfile bit NOT NULL DEFAULT 0
GO

---
--- CREATE COLUMN: InvoiceTransactionFK
---
ALTER TABLE dbo.PromotionPayment ADD InvoiceTransactionFK int
GO
---
--- CREATE COLUMN: BudgetToAddAmount
---
ALTER TABLE dbo.PromotionPayment ADD BudgetToAddAmount money
GO
---
--- CREATE FOREIGN KEY CONSTRAINT: REL_InvoiceTransaction_PromotionPayment_3
---
ALTER TABLE dbo.PromotionPayment ADD 
	CONSTRAINT REL_InvoiceTransaction_PromotionPayment_3 FOREIGN KEY (InvoiceTransactionFK)
		REFERENCES dbo.InvoiceTransaction(InvoiceTransactionPK)
GO

---
--- CREATE TABLE: dbo.Job
---
CREATE TABLE dbo.Job
(
	JobPK int NOT NULL IDENTITY,
	Name varchar(250) NOT NULL,
	LastSuccessfulRunTime datetime2,
	PRIMARY KEY CLUSTERED (JobPK)
)
GO
---
--- CREATE COLUMN: IsDeleted
---
ALTER TABLE dbo.AdvertisingEngineAds ADD IsDeleted bit NOT NULL DEFAULT 0
GO

insert into Job (Name, LastSuccessfulRunTime) values ('EXPIRED_CREDENTIALS_EMAIL_SENDER', null)

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.SplitIntoColumns') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
  DROP FUNCTION dbo.SplitIntoColumns;
GO


CREATE FUNCTION dbo.SplitIntoColumns
(
 @List			varchar (max),
 @Delimiter		varchar	  (3)
)
RETURNS @ResultSet TABLE 
(
 Column1			varchar (max)	NULL,
 Column2			varchar (max)	NULL,
 Column3			varchar (max)	NULL,
 Column4			varchar (max)	NULL,
 Column5			varchar (max)	NULL,
 Column6			varchar (max)	NULL,
 Column7			varchar (max)	NULL,
 Column8			varchar (max)	NULL,
 Column9			varchar (max)	NULL,
 Column10			varchar (max)	NULL,
 Column11			varchar (max)	NULL,
 Column12			varchar (max)	NULL,
 Column13			varchar (max)	NULL,
 Column14			varchar (max)	NULL,
 Column15			varchar (max)	NULL,
 Column16			varchar (max)	NULL,
 Column17			varchar (max)	NULL,
 Column18			varchar (max)	NULL,
 Column19			varchar (max)	NULL,
 Column20			varchar (max)	NULL
)
AS
BEGIN 

  DECLARE @DelimiterLength			int;

  SELECT @DelimiterLength = DATALENGTH(@Delimiter);

  WITH Element (RowID, Data, List) AS
  (
    SELECT 1 [RowID],
           CASE WHEN CHARINDEX(@Delimiter, @List) > 0 THEN LEFT(@List, CHARINDEX(@Delimiter, @List) - 1) ELSE @List END [Data],
           CASE WHEN CHARINDEX(@Delimiter, @List) > 0 THEN NULLIF(RIGHT(@List, DATALENGTH(@List) - CHARINDEX(@Delimiter, @List) - @DelimiterLength + 1), '') ELSE NULL END [List]
     UNION ALL
    SELECT RowID + 1,
           CASE WHEN CHARINDEX(@Delimiter, List) > 0 THEN LEFT(List, CHARINDEX(@Delimiter, List) - 1) ELSE List END [Data],
           CASE WHEN CHARINDEX(@Delimiter, List) > 0 THEN NULLIF(RIGHT(List, DATALENGTH(List) - CHARINDEX(@Delimiter, List) - @DelimiterLength + 1), '') ELSE NULL END [List]
      FROM Element
     WHERE List IS NOT NULL
  )
  INSERT INTO @ResultSet (Column1, Column2, Column3, Column4, Column5, Column6, Column7, Column8, Column9, Column10, Column11, Column12, Column13, Column14, Column15, Column16, Column17, Column18, Column19, Column20)
  SELECT [1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12], [13], [14], [15], [16], [17], [18], [19], [20]
    FROM (SELECT RowID, NULLIF(Data, '') [Data] FROM Element) s 
   PIVOT (MAX(Data) FOR RowID IN ([1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12], [13], [14], [15], [16], [17], [18], [19], [20])) p OPTION (maxrecursion 5000);

  RETURN;

END;
GO

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Split') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
  DROP FUNCTION dbo.Split;
GO


CREATE FUNCTION dbo.Split
(
 @List			varchar (max),
 @Delimiter		varchar	  (3)
)
RETURNS @ResultSet TABLE
(
 Data			varchar (max)
)
AS
BEGIN 

  DECLARE @DelimiterLength			int;

  SELECT @DelimiterLength	= DATALENGTH(@Delimiter);

  WITH Element (Data, List) AS
  (
    SELECT CASE WHEN CHARINDEX(@Delimiter, @List) > 0 THEN LEFT(@List, CHARINDEX(@Delimiter, @List) - 1) ELSE @List END [Data],
           CASE WHEN CHARINDEX(@Delimiter, @List) > 0 THEN NULLIF(RIGHT(@List, DATALENGTH(@List) - CHARINDEX(@Delimiter, @List) - @DelimiterLength + 1), '') ELSE NULL END [List]
     UNION ALL
    SELECT CASE WHEN CHARINDEX(@Delimiter, List) > 0 THEN LEFT(List, CHARINDEX(@Delimiter, List) - 1) ELSE List END [Data],
           CASE WHEN CHARINDEX(@Delimiter, List) > 0 THEN NULLIF(RIGHT(List, DATALENGTH(List) - CHARINDEX(@Delimiter, List) - @DelimiterLength + 1), '') ELSE NULL END [List]
      FROM Element
     WHERE List IS NOT NULL
  )
  INSERT INTO @ResultSet (Data)  
  SELECT Data
    FROM Element
   WHERE Data IS NOT NULL OPTION (maxrecursion 5000);

  RETURN;

END;
GO