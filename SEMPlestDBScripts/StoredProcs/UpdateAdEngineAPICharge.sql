IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.UpdateAdEngineAPICharge') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.UpdateAdEngineAPICharge;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 6/15/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.UpdateAdEngineAPICharge
(
	@AdvertisingEngineAccountID            bigint,
	@AdvertisingEngine nvarchar(50),
	@CumulativeAPIUnits		bigint,
	@cost money output
	
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @RecordedAPIUnits bigint, @APICostPer1000 money, @newAUnitToAdd Bigint, @charge money

	--validate data
	IF NOT EXISTS (select 1 from AdvertisingEngineAccount a where a.AdvertisingEngineAccountPK = @AdvertisingEngineAccountID)
	BEGIN
		SELECT @ErrMsg = 'The AdvertisingEngineAccountPK was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	IF NOT EXISTS (select 1 from AdvertisingEngine a where a.AdvertisingEngine = @AdvertisingEngine)
	BEGIN
		SELECT @ErrMsg = 'The Advertising Engine was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	set @RecordedAPIUnits = 0
	set @cost = 0
	--check to see if paid anything to date
	if exists (select * from AdvertisingEngineAPICharge api where api.AdvertisingEngineAccountFK = @AdvertisingEngineAccountID)
	begin
		select @RecordedAPIUnits = SUM(api.APIUnits) from AdvertisingEngineAPICharge api 
			where api.AdvertisingEngineAccountFK = @AdvertisingEngineAccountID
	End 
	--Calculate new units to add to DB
	set @newAUnitToAdd = @CumulativeAPIUnits - @RecordedAPIUnits
	--cannot be less than 0
	if (@newAUnitToAdd < 0)
	BEGIN
		SELECT @ErrMsg = 'The cumulative API Units at AdEngine are less than we have in DB.  This should not Happen???'; 
		RAISERROR (@ErrMsg, 16, 1);
	END
	if (@newAUnitToAdd > 0)
	begin
		--get the API cost from the Config table
		if (@AdvertisingEngine = 'Google')
		begin
			select @APICostPer1000 = c.AdwordsAPICostPer1000 from Configuration c
		end	
		else
		BEGIN
			SELECT @ErrMsg = 'The Advertising Engine does not have a API Cost per 1000 unit. ABORT'; 
			RAISERROR (@ErrMsg, 16, 1);
		END
		set @charge = (@newAUnitToAdd /1000) * @APICostPer1000
		insert into AdvertisingEngineAPICharge(AdvertisingEngineAccountFK, APIUnits,APICost,CreatedDate)
			values (@AdvertisingEngineAccountID, @newAUnitToAdd,@charge,CURRENT_TIMESTAMP)
	End
	else
	BEGIN
		set @charge = 0
	END
	--return result
	set @cost = @charge
	return @cost
			 
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO