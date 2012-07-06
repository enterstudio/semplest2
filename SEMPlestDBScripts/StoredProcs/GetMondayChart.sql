IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetMondayChart') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetMondayChart;
go  
CREATE PROCEDURE GetMondayChart(@StartDate DATETIME,@EndDate DATETIME) AS
BEGIN TRY
DECLARE @ErrMsg VARCHAR(250)
    DECLARE @Table TABLE (Date DateTime,Name varchar(100))
    INSERT INTO @Table EXEC dbo.GetMondays @StartDate,@EndDate
    SELECT * FROM vwPromotionChart WHERE TransactionDate IN (SELECT Date FROM @Table)
END TRY

BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO