IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.Split') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
  DROP FUNCTION dbo.Split;
GO


CREATE FUNCTION dbo.Split
(
 @List			varchar (max),
 @Delimiter		varchar	  (3)
)
RETURNS @ResultSet TABLE
(
 Data			varchar (max)
)
AS
BEGIN 

  DECLARE @DelimiterLength			int;

  SELECT @DelimiterLength	= DATALENGTH(@Delimiter);

  WITH Element (Data, List) AS
  (
    SELECT CASE WHEN CHARINDEX(@Delimiter, @List) > 0 THEN LEFT(@List, CHARINDEX(@Delimiter, @List) - 1) ELSE @List END [Data],
           CASE WHEN CHARINDEX(@Delimiter, @List) > 0 THEN NULLIF(RIGHT(@List, DATALENGTH(@List) - CHARINDEX(@Delimiter, @List) - @DelimiterLength + 1), '') ELSE NULL END [List]
     UNION ALL
    SELECT CASE WHEN CHARINDEX(@Delimiter, List) > 0 THEN LEFT(List, CHARINDEX(@Delimiter, List) - 1) ELSE List END [Data],
           CASE WHEN CHARINDEX(@Delimiter, List) > 0 THEN NULLIF(RIGHT(List, DATALENGTH(List) - CHARINDEX(@Delimiter, List) - @DelimiterLength + 1), '') ELSE NULL END [List]
      FROM Element
     WHERE List IS NOT NULL
  )
  INSERT INTO @ResultSet (Data)  
  SELECT Data
    FROM Element
   WHERE Data IS NOT NULL OPTION (maxrecursion 5000);

  RETURN;

END;
GO
