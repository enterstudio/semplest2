USE [semplest]
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
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	INSERT INTO Keyword (KeyWord)(
	select keyword
					from 
					(
						select k.KeywordPk, kwa.keyword 
						from @kwa kwa  
						LEFT OUTER JOIN keyword k ON kwa.keyword = k.keyword where KeywordPk is null) m)
						
	delete from PromotionKeywordAssociation where PromotionFK = @PromotionId and IsNegative <> 1
						
	INSERT INTO  PromotionKeywordAssociation (KeywordFK,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle)(
	select KeywordPk,PromotionFK,CreatedDate,IsActive,IsDeleted,IsNegative,SemplestProbability,IsTargetMSN,IsTargetGoogle
					from 
					(
						select k.KeywordPk, @PromotionId as PromotionFK,getdate() as CreatedDate,kwa.IsActive,kwa.IsDeleted,kwa.IsNegative,kwa.SemplestProbability,kwa.IsTargetMSN,kwa.IsTargetGoogle
						from @kwa kwa  
						INNER JOIN keyword k ON kwa.keyword = k.keyword WHERE NOT EXISTS(select Keywordfk from PromotionKeywordAssociation where KeywordFK=k.KeywordPK and promotionfk=@PromotionId))  n)
												
	SELECT @@ROWCOUNT
END

GO


