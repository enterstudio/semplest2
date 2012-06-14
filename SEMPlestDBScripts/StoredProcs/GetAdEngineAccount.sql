IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetAdEngineAccount') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetAdEngineAccount;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                               |
-- | Written - 2012-06-04																							|
-- | Parms   - 																										|
-- | Purpose - 																										|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetAdEngineAccount
(
	@CustomerID            INT,
	@AdEngine	nvarchar(25)
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @acctID bigint
	Declare @accoutTable Table(AccountID bigint, CustomerName nvarchar(200))

	--validate data
	IF NOT EXISTS (select * from Customer c where c.CustomerPK = @CustomerID)
	BEGIN
		SELECT @ErrMsg = 'Customer not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	--
	insert into @accoutTable(CustomerName)
	select c.Name from Customer c where c.CustomerPK = @CustomerID	
	
	if exists (select  1 from Customer c
				inner join AdvertisingEngineAccount a on c.CustomerPK = a.CustomerFK 
				inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = a.AdvertisingEngineFK 
				where c.CustomerPK = @CustomerID and ae.AdvertisingEngine = @AdEngine)
	begin
		select  @acctID = a.AdvertisingEngineAccountPK from Customer c
				inner join AdvertisingEngineAccount a on c.CustomerPK = a.CustomerFK 
				inner join AdvertisingEngine ae on ae.AdvertisingEnginePK = a.AdvertisingEngineFK 
				where c.CustomerPK = @CustomerID and ae.AdvertisingEngine = @AdEngine
		update @accoutTable set AccountID = @acctID
	end		
	
	select at.AccountID,at.CustomerName from @accoutTable at	
	
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO