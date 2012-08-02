IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.SetNegativeKeyword') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.SetNegativeKeyword;
GO

/****** Object:  StoredProcedure [dbo].[sp_UpdateKeywords]    Script Date: 06/19/2012 00:13:51 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Andre'
-- Create date: 6/7/2012
-- Description:	update neg keyword for ALL AdEngines (after launch)
-- =============================================
CREATE PROCEDURE [dbo].[SetNegativeKeyword] 
	-- Add the parameters for the stored procedure here
	@keyword nvarchar(250),
	@PromotionID int,
	@NegativeKeywordID int output,
	@Exists bit output
AS
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @ID int 
	
	
	--check to see if the negative keyword is associated to the promotion is already neg
	if exists (select * from Keyword k
				inner join PromotionKeywordAssociation pka on pka.KeywordFK = k.KeywordPK 
				where k.Keyword = @keyword and pka.PromotionFK = @PromotionID and pka.IsNegative = 1)
	BEGIN
		 select k.KeywordPK from Keyword k where k.KeywordPK=-1
		 return
	END
	
	BEGIN Transaction
	--Exists as positive 	
	if exists (select * from Keyword k
				inner join PromotionKeywordAssociation pka on pka.KeywordFK = k.KeywordPK 
				where k.Keyword = @keyword and pka.PromotionFK = @PromotionID and pka.IsNegative = 0)
	BEGIN
		SET @Exists = 1
		update PromotionKeywordAssociation set IsNegative = 1
			from Keyword k
			inner join PromotionKeywordAssociation pka on pka.KeywordFK = k.KeywordPK 
			where k.Keyword = @keyword and pka.PromotionFK = @PromotionID
	END	
	--In keyword table but not associate to the promo
	ELSE if exists	(select * from Keyword k where k.Keyword = @keyword)
	BEGIN
		SET @Exists = 0
		insert into PromotionKeywordAssociation(KeywordFK, PromotionFK, IsActive,IsDeleted,IsNegative,IsTargetGoogle, IsTargetMSN,CreatedDate)
		select k.KeywordPK,@PromotionID,1,0,1,1,1,CURRENT_TIMESTAMP from Keyword k where k.Keyword = @keyword
	END
	ELSE -- does not exists yet
	BEGIN
		SET @Exists = 0
		insert into Keyword(Keyword,CreatedDate) values (@keyword,CURRENT_TIMESTAMP)
		SET @ID = @@IDENTITY
		insert into PromotionKeywordAssociation(KeywordFK, PromotionFK, IsActive,IsDeleted,IsNegative,IsTargetGoogle, IsTargetMSN,CreatedDate)
		VALUES (@ID,@PromotionID,1,0,1,1,1,CURRENT_TIMESTAMP)
	END
	
	update pka set pka.IsDeleted = 1 from PromotionKeywordAssociation pka
		inner join keyword k on pka.KeywordFK = k.KeywordPK 
		where pka.PromotionFK = @PromotionID and pka.IsNegative = 0 
		and (k.Keyword like '% ' + @keyword or k.Keyword like @keyword + ' %' or k.Keyword like '% ' + @keyword + ' %')
	
	select k.KeywordPK from Keyword k
				inner join PromotionKeywordAssociation pka on pka.KeywordFK = k.KeywordPK 
				where pka.PromotionFK = @PromotionID and pka.IsNegative = 0
				and (k.Keyword like '% ' + @keyword or k.Keyword like @keyword + ' %' or k.Keyword like '% ' + @keyword + ' %')
	commit transaction												
	set @NegativeKeywordID = @ID										
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



