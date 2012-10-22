/*
update the status of existing campaigns
*/

--Live
insert into PromotionAdengineStatus(PromotionFK,AdvertisingEngineFK,PromotionStatusFK)
select p.PromotionPK, paes.AdvertisingEngineFK, 2 from Promotion p 
inner join PromotionAdEngineSelected paes on paes.PromotionFK = p.PromotionPK
left join AdvertisingEnginePromotion aep on aep.PromotionFK = p.PromotionPK
where p.IsLaunched = 1 and p.IsDeleted = 0 and p.IsPaused = 0 and 
p.PromotionPK not in (
--all promotions with status
select paes.PromotionFK from PromotionAdengineStatus paes
inner join PromotionStatus ps on ps.PromotionStatusPK = paes.PromotionStatusFK
group by paes.PromotionFK )
--order by p.PromotionPK

--pending
insert into PromotionAdengineStatus(PromotionFK,AdvertisingEngineFK,PromotionStatusFK)
select p.PromotionPK, paes.AdvertisingEngineFK, 1 from Promotion p 
inner join PromotionAdEngineSelected paes on paes.PromotionFK = p.PromotionPK
left join AdvertisingEnginePromotion aep on aep.PromotionFK = p.PromotionPK
where p.IsLaunched = 0 and  
p.PromotionPK not in (
--all promotions with status
select paes.PromotionFK from PromotionAdengineStatus paes
inner join PromotionStatus ps on ps.PromotionStatusPK = paes.PromotionStatusFK
group by paes.PromotionFK )
--order by p.PromotionPK

--paused
insert into PromotionAdengineStatus(PromotionFK,AdvertisingEngineFK,PromotionStatusFK)
select p.PromotionPK, paes.AdvertisingEngineFK, 3 from Promotion p 
inner join PromotionAdEngineSelected paes on paes.PromotionFK = p.PromotionPK
left join AdvertisingEnginePromotion aep on aep.PromotionFK = p.PromotionPK
where p.IsPaused = 1 and  
p.PromotionPK not in (
--all promotions with status
select paes.PromotionFK from PromotionAdengineStatus paes
inner join PromotionStatus ps on ps.PromotionStatusPK = paes.PromotionStatusFK
group by paes.PromotionFK )
--order by p.PromotionPK




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
		p.EditedDate, p.IsLaunched, p.IsCompleted,p.IsPaused,p.CreatedDate, aep.AdvertisingEngineCampaignPK, aep.AdvertisingEngineAdGroupID , 
		aea.AdvertisingEngineAccountPK,aea.AdvertisingEngineAccountNumber, ae.AdvertisingEngine, p.IsAutobid, p.AutoBidMaxCPC, p.CycleEndDate, P.CreditCardProfileFK

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

---
--- DROP FOREIGN KEY: CreditCardProfile.REL_Promotion_CreditCardProfile_1
---
ALTER TABLE dbo.CreditCardProfile DROP CONSTRAINT REL_Promotion_CreditCardProfile_1
GO
---
--- DROP FOREIGN KEY: Transactions.REL_Customer_Transactions_4
---
ALTER TABLE dbo.Transactions DROP CONSTRAINT REL_Customer_Transactions_4
GO
---
--- DROP FOREIGN KEY: Transactions.REL_PayType_Transactions_3
---
ALTER TABLE dbo.Transactions DROP CONSTRAINT REL_PayType_Transactions_3
GO
---
--- DROP COLUMN: CreditCardProfile.AuthCode
---
ALTER TABLE dbo.CreditCardProfile DROP COLUMN AuthCode
GO

---
--- DROP COLUMN: CreditCardProfile.PromotionFK
---
ALTER TABLE dbo.CreditCardProfile DROP COLUMN PromotionFK
GO

---
--- DROP COLUMN: CreditCardProfile.TxRefNum
---
ALTER TABLE dbo.CreditCardProfile DROP COLUMN TxRefNum
GO

---
--- DROP COLUMN: Transactions.CustomerFK
---
ALTER TABLE dbo.Transactions DROP COLUMN CustomerFK
GO

---
--- DROP COLUMN: Transactions.PayTypeFK
---
ALTER TABLE dbo.Transactions DROP COLUMN PayTypeFK
GO

---
--- DROP COLUMN: Transactions.TransactionTypeFK
---
ALTER TABLE dbo.Transactions DROP COLUMN TransactionTypeFK
GO

---
--- CREATE COLUMN: CreditCardProfileFK
---
ALTER TABLE dbo.Promotion ADD CreditCardProfileFK int
GO
---
--- CREATE COLUMN: AuthCode
---
ALTER TABLE dbo.Transactions ADD AuthCode varchar(6)
GO
---
--- CREATE COLUMN: TxRefNum
---
ALTER TABLE dbo.Transactions ADD TxRefNum varchar(40)
GO
--
-- RE-CREATE FOREIGN KEY: CreditCardProfile.REL_Customer_CreditCardProfile_2
--
ALTER TABLE dbo.CreditCardProfile DROP CONSTRAINT REL_Customer_CreditCardProfile_2
GO
---
--- CREATE FOREIGN KEY CONSTRAINT: REL_Customer_CreditCardProfile_1
---
ALTER TABLE dbo.CreditCardProfile ADD 
	CONSTRAINT REL_Customer_CreditCardProfile_1 FOREIGN KEY (CustomerFK)
		REFERENCES dbo.Customer(CustomerPK)
GO
