IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetCustomerPromotionStatus') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetCustomerPromotionStatus;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 9/17/2012																							|
-- | Parms   - 																							|
-- | Purpose - GetCustomerPromotionStatus					|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetCustomerPromotionStatus
(
	@CustomerID int
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)
	
	IF NOT EXISTS (select 1 from Customer c where c.CustomerPK = @CustomerID)
	BEGIN
		SELECT @ErrMsg = 'The CustomerIDK was not found.'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	
	declare @promo Table(typePromo varchar(25), PromotionStatus varchar(25), PromotionPK int , PromotionName varchar(200))
	--Get all promotion not yet launched
	insert into @promo(typePromo,PromotionStatus,PromotionPK, PromotionName)
	select 'NotLaunched', null, p.PromotionPK, p.PromotionName from Promotion p
	inner join ProductGroup pg on pg.ProductGroupPK = p.ProductGroupFK
	where p.IsLaunched = 0 and pg.CustomerFK = 17

	--Get Launched and all AdEngines are Live
	insert into @promo(typePromo,PromotionStatus,PromotionPK, PromotionName)
	select 'Launched', ps.PromotionStatus, p.PromotionPK, p.PromotionName from Promotion p
	inner join ProductGroup pg on pg.ProductGroupPK = p.ProductGroupFK
	inner join PromotionAdengineStatus paes on paes.PromotionFK = p.PromotionPK
	inner join PromotionStatus ps on ps.PromotionStatusPK = paes.PromotionStatusFK
	where p.IsLaunched = 1 and p.IsDeleted = 0 and pg.CustomerFK = 17
	group by ps.PromotionStatus, p.PromotionPK, p.PromotionName
	having ps.PromotionStatus = 'Live'

	--Get the rest that we will call Launched and Pending (ignor those deleted status)
	insert into @promo(typePromo,PromotionStatus,PromotionPK, PromotionName)
	select 'Launched','Pending', p.PromotionPK, p.PromotionName from Promotion p
	inner join ProductGroup pg on pg.ProductGroupPK = p.ProductGroupFK
	inner join PromotionAdengineStatus paes on paes.PromotionFK = p.PromotionPK
	inner join PromotionStatus ps on ps.PromotionStatusPK = paes.PromotionStatusFK
	where p.IsLaunched = 1 and p.IsDeleted = 0 and p.PromotionPK not in (select p.PromotionPK from @promo p) and pg.CustomerFK = 17
	group by ps.PromotionStatus, p.PromotionPK, p.PromotionName
	having ps.PromotionStatus <> 'Deleted'

	select * from @promo
		
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO