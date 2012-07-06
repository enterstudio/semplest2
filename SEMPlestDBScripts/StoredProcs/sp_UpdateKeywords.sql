IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.sp_UpdateKeywords') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.sp_UpdateKeywords;
GO

/****** Object:  StoredProcedure [dbo].[sp_UpdateKeywords]    Script Date: 06/19/2012 00:13:51 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Andre'
-- Create date: 6/7/2012
-- Description:	update to keywords and keyword associations
-- =============================================
CREATE PROCEDURE [dbo].[sp_UpdateKeywords] 
	-- Add the parameters for the stored procedure here
	@kwa dbo.PromotionKeywordTableType READONLY,
	@PromotionId int
AS
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)
	
	
	declare @kwa_withoutDups TABLE(
	[Keyword] [varchar](250) NOT NULL,
	[IsActive] [bit] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
	[IsNegative] [bit] NOT NULL,
	[SemplestProbability] [float] NULL,
	[IsTargetMSN] [bit] NOT NULL,
	[IsTargetGoogle] [bit] NOT NULL
	)
	
	insert into @kwa_withoutDups(IsActive,IsDeleted,IsNegative,IsTargetGoogle,IsTargetMSN,Keyword,SemplestProbability)
	select k.IsActive,k.IsDeleted,k.IsNegative,k.IsTargetGoogle,k.IsTargetMSN,k.Keyword,0 from @kwa k
		group by k.IsActive,k.IsDeleted,k.IsNegative,k.IsTargetGoogle,k.IsTargetMSN,k.Keyword
	
	INSERT INTO Keyword (KeyWord)(
	select keyword
					from 
					(
						select k.KeywordPk, kwa.keyword 
						from @kwa_withoutDups kwa  
						LEFT OUTER JOIN keyword k ON kwa.keyword = k.keyword where KeywordPk is null) 
						m )
	
	begin Transaction
						
	delete from PromotionKeywordAssociation where PromotionFK = @PromotionId
						
	INSERT INTO  PromotionKeywordAssociation (KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)(
	select KeywordPk,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle
					from 
					(
						select k.KeywordPk, @PromotionId as PromotionFK,getdate() as CreatedDate,kwa.IsActive,kwa.IsDeleted,kwa.IsNegative,kwa.SemplestProbability,kwa.IsTargetMSN,kwa.IsTargetGoogle
						from @kwa_withoutDups kwa  
						INNER JOIN keyword k ON kwa.keyword = k.keyword)  n)
						
	commit transaction											
	SELECT @@ROWCOUNT
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



