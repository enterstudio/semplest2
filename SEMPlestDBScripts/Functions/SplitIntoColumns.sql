IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.SplitIntoColumns') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
  DROP FUNCTION dbo.SplitIntoColumns;
GO


CREATE FUNCTION dbo.SplitIntoColumns
(
 @List			varchar (max),
 @Delimiter		varchar	  (3)
)
RETURNS @ResultSet TABLE 
(
 Column1			varchar (max)	NULL,
 Column2			varchar (max)	NULL,
 Column3			varchar (max)	NULL,
 Column4			varchar (max)	NULL,
 Column5			varchar (max)	NULL,
 Column6			varchar (max)	NULL,
 Column7			varchar (max)	NULL,
 Column8			varchar (max)	NULL,
 Column9			varchar (max)	NULL,
 Column10			varchar (max)	NULL,
 Column11			varchar (max)	NULL,
 Column12			varchar (max)	NULL,
 Column13			varchar (max)	NULL,
 Column14			varchar (max)	NULL,
 Column15			varchar (max)	NULL,
 Column16			varchar (max)	NULL,
 Column17			varchar (max)	NULL,
 Column18			varchar (max)	NULL,
 Column19			varchar (max)	NULL,
 Column20			varchar (max)	NULL
)
AS
BEGIN 

  DECLARE @DelimiterLength			int;

  SELECT @DelimiterLength = DATALENGTH(@Delimiter);

  WITH Element (RowID, Data, List) AS
  (
    SELECT 1 [RowID],
           CASE WHEN CHARINDEX(@Delimiter, @List) > 0 THEN LEFT(@List, CHARINDEX(@Delimiter, @List) - 1) ELSE @List END [Data],
           CASE WHEN CHARINDEX(@Delimiter, @List) > 0 THEN NULLIF(RIGHT(@List, DATALENGTH(@List) - CHARINDEX(@Delimiter, @List) - @DelimiterLength + 1), '') ELSE NULL END [List]
     UNION ALL
    SELECT RowID + 1,
           CASE WHEN CHARINDEX(@Delimiter, List) > 0 THEN LEFT(List, CHARINDEX(@Delimiter, List) - 1) ELSE List END [Data],
           CASE WHEN CHARINDEX(@Delimiter, List) > 0 THEN NULLIF(RIGHT(List, DATALENGTH(List) - CHARINDEX(@Delimiter, List) - @DelimiterLength + 1), '') ELSE NULL END [List]
      FROM Element
     WHERE List IS NOT NULL
  )
  INSERT INTO @ResultSet (Column1, Column2, Column3, Column4, Column5, Column6, Column7, Column8, Column9, Column10, Column11, Column12, Column13, Column14, Column15, Column16, Column17, Column18, Column19, Column20)
  SELECT [1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12], [13], [14], [15], [16], [17], [18], [19], [20]
    FROM (SELECT RowID, NULLIF(Data, '') [Data] FROM Element) s 
   PIVOT (MAX(Data) FOR RowID IN ([1], [2], [3], [4], [5], [6], [7], [8], [9], [10], [11], [12], [13], [14], [15], [16], [17], [18], [19], [20])) p OPTION (maxrecursion 5000);

  RETURN;

END;
GO
