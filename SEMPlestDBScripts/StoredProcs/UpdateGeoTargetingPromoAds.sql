IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.UpdateGeoTargetingPromoAds') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.UpdateGeoTargetingPromoAds;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Andre                                                                                                |
-- | Written - 8/11/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.UpdateGeoTargetingPromoAds
(
	@PromotionPK            INT,
	@LandingUrl				nvarchar(1024),
	@DisplayUrl				nvarchar(35),
	@GeoTVP					dbo.GeoTargetTableType READONLY,
	@AdTVP					dbo.PromoAdTableType READONLY
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	BEGIN
	
	begin Transaction
	
		UPDATE promotion set LandingPageURL = @LandingUrl, DisplayUrl = @DisplayUrl WHERE PromotionPK = @PromotionPK
		
		INSERT INTO dbo.GeoTargeting(PromotionFK,Address,City,StateCodeFK,Zip,ProximityRadius,Latitude,Longitude)
			select @PromotionPK,g.Address,g.City,g.StateCodeFK,g.Zip,g.ProximityRadius,g.Latitude,g.Longitude from @GeoTVP g WHERE g.operation='I'

        UPDATE g SET 
			g.Address = gt.Address, g.City= gt.City, g.StateCodeFK = gt.StateCodeFK, g.Zip = gt.Zip, 
			g.ProximityRadius = gt.ProximityRadius,g.Latitude = gt.Latitude, g.Longitude = gt.Longitude 
			FROM dbo.GeoTargeting g 
			INNER JOIN @GeoTVP gt ON gt.PKEY = g.GeoTargetingPK WHERE gt.Operation = 'U'
			
        DELETE FROM dbo.GeoTargeting FROM dbo.GeoTargeting g INNER JOIN  @GEOTVP gt ON gt.PKEY = g.GeoTargetingPK WHERE gt.Operation= 'D'
        
        INSERT INTO dbo.PromotionAds (PromotionFK,AdTextLine1,AdTextLine2,AdTitle,CreatedDate)
			select @PromotionPK,a.AdTextLine1,a.AdTextLine2,a.AdTitle,current_timestamp from @AdTVP a WHERE a.Operation ='I'
			
		UPDATE p SET 
			p.AdTextLine1 = a.AdTextLine1, p.AdTextLine2 = a.AdTextLine2, p.AdTitle = a.AdTitle
			FROM dbo.PromotionAds p 
			INNER JOIN @AdTVP a ON a.PKEY = p.PromotionAdsPK WHERE a.Operation = 'U'
			
		DELETE from dbo.PromotionAds from dbo.PromotionAds p INNER JOIN  @AdTVP a on a.PKEY = p.PromotionAdsPK where a.Operation= 'D'

     commit transaction   
	END
	
	SELECT g.GeoTargetingPK as PKEY, gt.UID as UID from dbo.GeoTargeting g 
	inner JOIN @GeoTVP gt on 
			(g.Address = gt.Address or (g.Address is null and gt.Address is null)) and
			(g.City= gt.City or (g.City is null and gt.City is null)) and 
			(g.StateCodeFK = gt.StateCodeFK or (g.StateCodeFK is null and gt.StateCodeFK is null)) and
			(g.Zip  = gt.Zip  or (g.Zip  is null and gt.Zip  is null)) and 
			(g.ProximityRadius  = gt.ProximityRadius  or (g.ProximityRadius  is null and gt.ProximityRadius  is null)) and
			(g.Latitude  = gt.Latitude  or (g.Latitude  is null and gt.Latitude  is null)) and 
			(g.Longitude  = gt.Longitude  or (g.Longitude  is null and gt.Longitude  is null)) 
	WHERE gt.operation = 'I' and g.PromotionFK = @PromotionPK
	UNION
	SELECT p.PromotionAdsPK as PKEY, a.UID as UID from dbo.PromotionAds p 
	INNER JOIN @AdTVP a on 
			p.AdTextLine1 = a.AdTextLine1 and p.AdTextLine2 = a.AdTextLine2 and p.AdTitle = a.AdTitle
	WHERE a.Operation = 'I' and p.IsDeleted=0 and p.PromotionFK = @PromotionPK
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO