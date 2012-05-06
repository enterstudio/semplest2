IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetKeywordForAdEngine') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetKeywordForAdEngine;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetKeywordForAdEngine
(
	@PromotionPK            INT,
	@IsTargetGoogle bit = 0,
	@IsTargetMSN bit = 0
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)

	--validate data
	IF NOT EXISTS (select * from Promotion p where p.PromotionPK =@PromotionPK)
	BEGIN
		SELECT @ErrMsg = 'The Promotion was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	--get general info
	select k.Keyword, pka.IsTargetGoogle, pka.IsTargetMSN, pka.IsActive, pka.IsDeleted, pka.IsNegative, pka.SemplestProbability
	from Promotion p 
	inner join PromotionKeywordAssociation pka on pka.PromotionFK = p.PromotionPK
	inner join Keyword k on k.KeywordPK = pka.KeywordFK
	where p.PromotionPK = @PromotionPK and pka.IsTargetGoogle = @IsTargetGoogle and pka.IsTargetMSN = @IsTargetMSN	 
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO