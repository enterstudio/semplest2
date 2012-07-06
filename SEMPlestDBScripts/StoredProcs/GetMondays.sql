IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetMondays') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetMondays;
GO
/****** Object:  StoredProcedure [dbo].[GetMondays]    Script Date: 07/06/2012 17:47:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[GetMondays](@StartDate DATETIME,@EndDate DATETIME) AS
BEGIN TRY
DECLARE @ErrMsg VARCHAR(250);
WITH cte AS (
	SELECT 1 AS DayID,
		@StartDate AS FromDate,
		DATENAME(dw, @StartDate) AS Dayname
	UNION ALL
		SELECT cte.DayID + 1 AS DayID,
		DATEADD(d, 1 ,cte.FromDate),
		DATENAME(dw, DATEADD(d, 1 ,cte.FromDate)) AS Dayname
	FROM cte
	WHERE 
		DATEADD(d,1,cte.FromDate) < @EndDate
	)

	SELECT FromDate AS Date, Dayname FROM CTE WHERE DayName LIKE 'Monday' -- For Monday
OPTION (MaxRecursion 370)
END TRY

BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO