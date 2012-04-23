IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.SetScheduleJobComplete') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.SetScheduleJobComplete;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - ScheduleID																							|
-- | Purpose - Update Schedule and Get Next Time to Run						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.SetScheduleJobComplete
(
	@ScheduleJobID			INT,
	@IsSuccessful			BIT,
	@ErrorMessage varchar(500)
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)
	BEGIN TRANSACTION
	-- put result in log
    insert into dbo.ScheduleLog(ScheduleJobFK,IsSuccessful,DateCreated,ErrorMessage,IsComplete) 
		values (@ScheduleJobID,@IsSuccessful,CURRENT_TIMESTAMP,@ErrorMessage,1) 
	--update the Job
	UPDATE ScheduleJob SET IsComplete = 1, IsSuccessful= @IsSuccessful	
		

	--Get the schedule parameters
	DECLARE @StartDateTime				DATETIME, 
			@Frequency					VARCHAR(15)
	
	
	--get Frequency of schedule
	SELECT @Frequency = f.Frequency
	FROM dbo.Schedule s
	inner join ScheduleJob sj on sj.ScheduleFK = s.SchedulePK
	INNER JOIN dbo.Frequency f on f.FrequencyPK = s.FrequencyFK
	WHERE sj.ScheduleJobPK = @ScheduleJobID;
	
	--Check to see if we need to add a new Job
	IF @Frequency IS NOT NULL
	BEGIN
		IF @Frequency NOT IN ('Now')
		BEGIN
			--Get The Start of the completed job 
			SELECT @StartDateTime = s.ExecutionStartTime
			FROM dbo.ScheduleJob s
			WHERE s.ScheduleJobPK = @ScheduleJobID;
			
			DECLARE @NextTimeToRun DATETIME;
			SELECT @NextTimeToRun = dbo.GetNextScheduleTime(@StartDateTime, @Frequency);
															
			--Add next job to run
			INSERT INTO ScheduleJob(ScheduleFK,IsComplete,IsSuccessful,ExecutionStartTime)
			SELECT sj.ScheduleFK,0,0,@NextTimeToRun FROM ScheduleJob sj where sj.ScheduleJobPK = @ScheduleJobID 
			
		END
	END
	COMMIT TRANSACTION	
	--Get the next Job to run
	SELECT job.ScheduleJobPK, job.ScheduleFK, job.ExecutionStartTime from GetNextJobToRun() job
	
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