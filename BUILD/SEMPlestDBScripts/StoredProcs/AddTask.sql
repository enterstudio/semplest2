IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.AddTask') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.AddTask;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - add new schedule					|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.AddTask
(
	@ServiceName varchar(100),
	@MethodName varchar(50),
	@Parameters varchar(2500),
	@ID int output
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)
	
	
	
	insert into Task(ServiceName,MethodName,[Parameters])
		values (@ServiceName,@MethodName,@Parameters)
	set @ID = @@IDENTITY
	return @ID
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO