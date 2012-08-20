
drop table promotionpayment
drop table CreditCardTransaction
drop table invoicetransaction
---
--- CREATE COLUMN: IsDeleted
---
ALTER TABLE dbo.NickNameProfileAssociation ADD IsDeleted bit NOT NULL DEFAULT 0
GO

---
--- CREATE TABLE: dbo.PayType
---
CREATE TABLE dbo.PayType
(
	PayTypePK int NOT NULL IDENTITY,
	PayType varchar(50) NOT NULL,
	PRIMARY KEY CLUSTERED (PayTypePK)
)
GO
---
--- CREATE TABLE: dbo.PromotionBudget
---
CREATE TABLE dbo.PromotionBudget
(
	PromotionBudgetPK int NOT NULL IDENTITY,
	TransactionsFK int NOT NULL,
	PromotionFK int,
	BudgetToAddDate datetime2 NOT NULL,
	IsValid bit NOT NULL DEFAULT 1,
	IsAppliedToPromotion bit NOT NULL DEFAULT 0,
	BudgetCarryOverAmount money NOT NULL DEFAULT 0,
	BudgetToAddAmount money,
	CreatedDate datetime2 NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY CLUSTERED (PromotionBudgetPK)
)
GO

---
--- CREATE FOREIGN KEY CONSTRAINT: REL_Promotion_PromotionBudget_1
---
ALTER TABLE dbo.PromotionBudget ADD 
	CONSTRAINT REL_Promotion_PromotionBudget_1 FOREIGN KEY (PromotionFK)
		REFERENCES dbo.Promotion(PromotionPK)
GO

---
--- CREATE TABLE: dbo.Transactions
---
CREATE TABLE dbo.Transactions
(
	TransactionsPK int NOT NULL IDENTITY,
	CustomerFK int NOT NULL,
	PayTypeFK int NOT NULL,
	TransactionTypeFK int NOT NULL,
	CreditCardProfileFK int,
	Amount money NOT NULL DEFAULT 0,
	CreatedDate datetime2 NOT NULL DEFAULT CURRENT_TIMESTAMP,
	EditedDate datetime2,
	PRIMARY KEY CLUSTERED (TransactionsPK)
)
GO

---
--- CREATE FOREIGN KEY CONSTRAINT: REL_Transactions_PromotionBudget_2
---
ALTER TABLE dbo.PromotionBudget ADD 
	CONSTRAINT REL_Transactions_PromotionBudget_2 FOREIGN KEY (TransactionsFK)
		REFERENCES dbo.Transactions(TransactionsPK)
GO

---
--- CREATE FOREIGN KEY CONSTRAINT: REL_CreditCardProfile_Transactions_2
---
ALTER TABLE dbo.Transactions ADD 
	CONSTRAINT REL_CreditCardProfile_Transactions_2 FOREIGN KEY (CreditCardProfileFK)
		REFERENCES dbo.CreditCardProfile(CreditCardProfilePK)
GO


---
--- CREATE FOREIGN KEY CONSTRAINT: REL_PayType_Transactions_3
---
ALTER TABLE dbo.Transactions ADD 
	CONSTRAINT REL_PayType_Transactions_3 FOREIGN KEY (PayTypeFK)
		REFERENCES dbo.PayType(PayTypePK)
GO


---
--- CREATE FOREIGN KEY CONSTRAINT: REL_Customer_Transactions_4
---
ALTER TABLE dbo.Transactions ADD 
	CONSTRAINT REL_Customer_Transactions_4 FOREIGN KEY (CustomerFK)
		REFERENCES dbo.Customer(CustomerPK)
GO

---
--- CREATE TABLE: dbo.TransactionType
---
CREATE TABLE dbo.TransactionType
(
	TransactionTypePK int NOT NULL IDENTITY,
	TransactionType varchar(50) NOT NULL,
	PRIMARY KEY CLUSTERED (TransactionTypePK)
)
GO

insert into PayType(PayType) values ('CreditCard')
insert into PayType(PayType) values ('Invoice')
insert into PayType(PayType) values ('NoPay')

insert into TransactionType(TransactionType) values ('MediaSpend')
insert into TransactionType(TransactionType) values ('SemplestMediaSpendFee')
insert into TransactionType(TransactionType) values ('SemplestFlatFee')

---
--- CHANGE COLUMN: AddressType.AddressType
---
ALTER TABLE dbo.AddressType
	ALTER COLUMN AddressType
		nvarchar(25)
GO


---
--- CREATE COLUMN: AddressTypeFK
---
ALTER TABLE dbo.GeoTargeting ADD AddressTypeFK int
GO
---
--- CREATE FOREIGN KEY CONSTRAINT: REL_AddressType_GeoTargeting_3
---
ALTER TABLE dbo.GeoTargeting ADD 
	CONSTRAINT REL_AddressType_GeoTargeting_3 FOREIGN KEY (AddressTypeFK)
		REFERENCES dbo.AddressType(AddressTypePK)
GO


alter table configuration add MSNReportRetrievalTimeoutSecs int
go
update Configuration set MSNReportRetrievalTimeoutSecs = 900
go

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.SetBidObject') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.SetBidObject;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.SetBidObject   
(
	@PromotionPK            INT,
	@KeywordAdEngineID      BIGINT,
	@Keyword				NVARCHAR(250),
	@MicroBidAmount			INT,
	@BidType				VARCHAR(25),
	@AdvertisingEngine		VARCHAR(50),
	@IsNegative				bit = 1,
	@CompetitionType		varchar(20),
	@IsDefaultValue bit,
	@ID int output
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @currentMicroBidAmt int, @keywordBidPK int, @currentTime datetime2, @BidTypeID int, 
			@AdEngineID int,@keywordPK int

	--validate data
	--AdEngine
	IF NOT EXISTS (select * from AdvertisingEngine a where a.AdvertisingEngine = @AdvertisingEngine)
	BEGIN
		SELECT @ErrMsg = 'The Advertising Engine was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	--BidType
	IF NOT EXISTS (select * from BidType bt where bt.BidType = @BidType)
	BEGIN
		SELECT @ErrMsg = 'The Bid Type was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	if not exists (select * from Keyword k where k.Keyword = @Keyword)
	BEGIN
		SELECT @ErrMsg = 'The Selected keyword does not exist'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;		
	select @AdEngineID = a.AdvertisingEnginePK from AdvertisingEngine a where a.AdvertisingEngine = @AdvertisingEngine
	select @BidTypeID = bt.BidTypePK from BidType bt where bt.BidType = @BidType
	if (@IsNegative = 1)
	BEGIN
		SET @MicroBidAmount = 0
	END	
	SET @currentTime = CURRENT_TIMESTAMP
	
	BEGIN TRANSACTION
	--Check to see if this keyword is already bid on for the AdEngine and BidType	
	if exists (select * from PromotionKeywordAssociation pka
				inner join Keyword k on k.KeywordPK = pka.KeywordFK
				inner join KeywordBid kb on kb.KeywordFK = k.KeywordPK and kb.PromotionFK = @PromotionPK
				inner join AdvertisingEngine a on a.AdvertisingEnginePK = kb.AdvertisingEngineFK
				where pka.PromotionFK = @PromotionPK and a.AdvertisingEnginePK = @AdEngineID 
					 and kb.BidTypeFK = @BidTypeID
					 and (k.Keyword = @Keyword or kb.KeywordAdEngineID = @KeywordAdEngineID))
	BEGIN
		
		select @currentMicroBidAmt = kb.MicroBidAmount, @keywordBidPK = kb.KeywordBidPK , @keywordPK = kb.KeywordFK
			from PromotionKeywordAssociation pka
					inner join Keyword k on k.KeywordPK = pka.KeywordFK
					inner join KeywordBid kb on kb.KeywordFK = k.KeywordPK and kb.PromotionFK = @PromotionPK
					inner join AdvertisingEngine a on a.AdvertisingEnginePK = kb.AdvertisingEngineFK
					where pka.PromotionFK = @PromotionPK and pka.IsActive = 1 and a.AdvertisingEnginePK = @AdEngineID
						 and kb.BidTypeFK = @BidTypeID
						 and (k.Keyword = @Keyword or kb.KeywordAdEngineID = @KeywordAdEngineID)
		
			if (@MicroBidAmount != @currentMicroBidAmt) 
			BEGIN
				 --update the last bid with an end Date and set inactive
				 UPDATE KeywordBid set EndDate = @currentTime, IsActive = 0 WHERE KeywordBidPK = @keywordBidPK
				 --add new active keyword bid
				 INSERT INTO KeywordBid(KeywordFK,AdvertisingEngineFK,PromotionFK,StartDate,EndDate,IsActive,BidTypeFK,MicroBidAmount,KeywordAdEngineID, CompetitionType, IsDefaultValue)
				 select kb.KeywordFK,kb.AdvertisingEngineFK,kb.PromotionFK,@currentTime,null,1,@BidTypeID,@MicroBidAmount,@KeywordAdEngineID, @CompetitionType, @IsDefaultValue
					from KeywordBid kb where kb.KeywordBidPK = @keywordBidPK
				SET @ID = @@IDENTITY	 
				--make sure the associaition is active
				update PromotionKeywordAssociation set IsActive = 1 where PromotionFK = @PromotionPK and KeywordFK = @keywordPK	
			END	
			ELSE  -- update competition parameters 
			BEGIN
				update KeywordBid set CompetitionType = @CompetitionType, IsDefaultValue = @IsDefaultValue
					from KeywordBid kb where kb.KeywordBidPK = @keywordBidPK
				SET @ID = @keywordBidPK	
			END	 
	END	
	
	ELSE --New Bid on Keyword
	  BEGIN
			--create the keyword bid
			select @keywordPK = k.KeywordPK from Keyword k where k.Keyword = @Keyword
			insert into KeywordBid(KeywordFK,AdvertisingEngineFK,PromotionFK,StartDate,EndDate,IsActive,BidTypeFK,MicroBidAmount,KeywordAdEngineID,CompetitionType,IsDefaultValue)
				VALUES (@keywordPK,@AdEngineID,@PromotionPK,@currentTime,null,1,@BidTypeID,@MicroBidAmount,@KeywordAdEngineID, @CompetitionType,@IsDefaultValue)
			SET @ID = @@IDENTITY	
	  END
	   		
	COMMIT TRANSACTION	
	
	RETURN @ID			 
	
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
	
	return;
	/*
	
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
			 
	*/
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



IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.UpdateGeoTargetingPromoAds') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.UpdateGeoTargetingPromoAds;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Andre                                                                                                |
-- | Written - 8/11/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.UpdateGeoTargetingPromoAds
(
	@PromotionPK            INT,
	@LandingUrl				nvarchar(1024),
	@DisplayUrl				nvarchar(35),
	@AddressTypeFK          INT,
	@GeoTVP					dbo.GeoTargetTableType READONLY,
	@AdTVP					dbo.PromoAdTableType READONLY
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	BEGIN
	
	begin Transaction
	
		UPDATE promotion set LandingPageURL = @LandingUrl, DisplayUrl = @DisplayUrl WHERE PromotionPK = @PromotionPK
		
		INSERT INTO dbo.GeoTargeting(PromotionFK,Address,City,StateCodeFK,Zip,ProximityRadius,Latitude,Longitude,AddressTypeFK)
			select @PromotionPK,g.Address,g.City,g.StateCodeFK,g.Zip,g.ProximityRadius,g.Latitude,g.Longitude,@AddressTypeFK from @GeoTVP g WHERE g.operation='I'

        UPDATE g SET 
			g.Address = gt.Address, g.City= gt.City, g.StateCodeFK = gt.StateCodeFK, g.Zip = gt.Zip, 
			g.ProximityRadius = gt.ProximityRadius,g.Latitude = gt.Latitude, g.Longitude = gt.Longitude, g.AddressTypeFK=@AddressTypeFK
			FROM dbo.GeoTargeting g 
			INNER JOIN @GeoTVP gt ON gt.PKEY = g.GeoTargetingPK WHERE gt.Operation = 'U'
			
        DELETE FROM dbo.GeoTargeting FROM dbo.GeoTargeting g INNER JOIN  @GEOTVP gt ON gt.PKEY = g.GeoTargetingPK WHERE gt.Operation= 'D'
        
        INSERT INTO dbo.PromotionAds (PromotionFK,AdTextLine1,AdTextLine2,AdTitle,CreatedDate)
			select @PromotionPK,a.AdTextLine1,a.AdTextLine2,a.AdTitle,current_timestamp from @AdTVP a WHERE a.Operation ='I'
			
		UPDATE p SET 
			p.AdTextLine1 = a.AdTextLine1, p.AdTextLine2 = a.AdTextLine2, p.AdTitle = a.AdTitle
			FROM dbo.PromotionAds p 
			INNER JOIN @AdTVP a ON a.PKEY = p.PromotionAdsPK WHERE a.Operation = 'U'
			
		DELETE from dbo.PromotionAds from dbo.PromotionAds p INNER JOIN  @AdTVP a on a.PKEY = p.PromotionAdsPK where a.Operation= 'D'

     commit transaction   
	END
	
	SELECT g.GeoTargetingPK as PKEY, gt.UID as UID from dbo.GeoTargeting g 
	inner JOIN @GeoTVP gt on 
			(g.Address = gt.Address or (g.Address is null and gt.Address is null)) and
			(g.City= gt.City or (g.City is null and gt.City is null)) and 
			(g.StateCodeFK = gt.StateCodeFK or (g.StateCodeFK is null and gt.StateCodeFK is null)) and
			(g.Zip  = gt.Zip  or (g.Zip  is null and gt.Zip  is null)) and 
			(g.ProximityRadius  = gt.ProximityRadius  or (g.ProximityRadius  is null and gt.ProximityRadius  is null)) and
			(g.Latitude  = gt.Latitude  or (g.Latitude  is null and gt.Latitude  is null)) and 
			(g.Longitude  = gt.Longitude  or (g.Longitude  is null and gt.Longitude  is null)) 
	WHERE gt.operation = 'I' and g.PromotionFK = @PromotionPK
	UNION
	SELECT p.PromotionAdsPK as PKEY, a.UID as UID from dbo.PromotionAds p 
	INNER JOIN @AdTVP a on 
			p.AdTextLine1 = a.AdTextLine1 and p.AdTextLine2 = a.AdTextLine2 and p.AdTitle = a.AdTitle
	WHERE a.Operation = 'I' and p.IsDeleted=0 and p.PromotionFK = @PromotionPK
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO

insert into [AddressType] (AddressType) values ('STATE')
insert into [AddressType] (AddressType) values ('GEO_POINT')

GO