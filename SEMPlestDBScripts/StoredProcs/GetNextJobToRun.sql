IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetNextJobToRun') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetNextJobToRun;
GO
/****** Object:  StoredProcedure [dbo].[GetNextJobToRun]    Script Date: 05/09/2012 10:45:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - Get Next Time to Run						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE [dbo].[GetNextJobToRun]

AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)
	
	--Get the next Job to run
	
--Get the next Job to run

	SELECT job.ScheduleJobPK, job.ScheduleFK, job.ExecutionStartTime from ScheduleJob job
	INNER JOIN
	 (SELECT top 1 sj.ScheduleJobPK,MIN(sj.ExecutionStartTime) [MinDate] from ScheduleJob sj
	 inner join Schedule s on s.SchedulePK = sj.ScheduleFK
	 inner join ScheduleTaskAssociation sta on sta.ScheduleFK = s.SchedulePK
	 where sj.IsComplete = 0 and s.IsEnabled = 1 and s.IsInactive = 0
		Group by sj.ScheduleJobPK order by [MinDate] Asc) topJob on topJob.ScheduleJobPK = job.ScheduleJobPK
	inner join Schedule s on s.SchedulePK = job.ScheduleFK 
	where s.IsEnabled = 1 and s.IsInactive = 0	
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
