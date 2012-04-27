IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.AddScheduleJob') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.AddScheduleJob;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - add new schedule					|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.AddScheduleJob
(
	@ScheduleFK int,
	@ExecutionStartTime datetime2,
	@ID int output
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)
	
	
	
	insert into ScheduleJob(ScheduleFK,ExecutionStartTime,IsComplete,IsSuccessful,CreatedDate)
		values (@ScheduleFK,@ExecutionStartTime,0,0, CURRENT_TIMESTAMP)
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