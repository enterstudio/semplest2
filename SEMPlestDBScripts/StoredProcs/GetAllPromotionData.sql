IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetAllPromotionData') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetAllPromotionData;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetAllPromotionData
(
	@PromotionPK            INT
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
	select p.PromotionPK,p.ProductGroupFK,p.PromotionName,p.PromotionDescription,p.LandingPageURL,
		p.PromotionBudgetAmount,p.PromotionStartDate, p.PromotionEndDate,bc.BudgetCycle,
		p.BudgetToAddToNextCycle, p.BudgetToAddToNextCycle,p.CycleStartDate,
		p.RemainingBudgetInCycle,p.StartBudgetInCycle,
		p.EditedDate, p.IsLaunched, p.IsCompleted,p.IsPaused,p.CreatedDate,p.EditedDate 
		from Promotion p 
		inner join BudgetCycle bc on bc.BudgetCyclePK = p.BudgetCycleFK
		where p.PromotionPK  = @PromotionPK
		--get ADs
		select pa.AdTitle, pa.AdText from Promotion p
		inner join PromotionAds pa on pa.PromotionFK = p.PromotionPK
		where p.PromotionPK = @PromotionPK
		--get Geotargeting
		select gt.Address, gt.City,st.StateAbbr [State], gt.Zip, gt.Latitude, gt.Longitude,gt.ProximityRadius [Radius] from Promotion p 
		inner join GeoTargeting gt on gt.PromotionFK = p.PromotionPK
		inner join StateCode st on st.StateAbbrPK = gt.StateCodeFK
		where p.PromotionPK = @PromotionPK			 
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO