IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.AddAdvertisingEngineAccount') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.AddAdvertisingEngineAccount;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - add new AdvertisingEngineAccount					|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.AddAdvertisingEngineAccount
(
	@AdvertisingEngineAccountID bigint,
	@AdvertisingEngine nvarchar(50),
	@CustomerID int, 
	@AdvertisingEngineAccountNumber varchar(50) = null
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @AdEngineID INT
	IF NOT EXISTS (select 1 from AdvertisingEngine a where a.AdvertisingEngine = @AdvertisingEngine)
	BEGIN
		SELECT @ErrMsg = 'The Advertising Engine was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	IF NOT EXISTS (select 1 from Customer c where c.CustomerPK = @CustomerID)
	BEGIN
		SELECT @ErrMsg = 'The Customer was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	IF EXISTS (select 1 from AdvertisingEngineAccount ac where ac.AdvertisingEngineAccountPK = @AdvertisingEngineAccountID)
	BEGIN
		SELECT @ErrMsg = 'The AdvertisingEngineAccount already Exists.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	--get Ad Engine ID
	select @AdEngineID = a.AdvertisingEnginePK from AdvertisingEngine a where a.AdvertisingEngine = @AdvertisingEngine
	--Add Ad Engine's ID to Customer
	insert into AdvertisingEngineAccount(AdvertisingEngineAccountPK,AdvertisingEngineFK,CustomerFK, AdvertisingEngineAccountNumber)
		VALUES (@AdvertisingEngineAccountID,@AdEngineID,@CustomerID, @AdvertisingEngineAccountNumber)
		
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO