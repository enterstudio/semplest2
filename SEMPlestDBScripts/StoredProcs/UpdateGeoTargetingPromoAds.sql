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
	
		UPDATE promotion set LandingPageURL = @LandingUrl, DisplayUrl = @DisplayUrl where PromotionPK = @PromotionPK
		
		insert into dbo.GeoTargeting(PromotionFK,Address,City,StateCodeFK,Zip,ProximityRadius,Latitude,Longitude)
			select @PromotionPK,g.Address,g.City,g.StateCodeFK,g.Zip,g.ProximityRadius,g.Latitude,g.Longitude from @GeoTVP g where g.operation='I'

        update g SET 
			g.Address = gt.Address, g.City= gt.City, g.StateCodeFK = gt.StateCodeFK, g.Zip = gt.Zip, 
			g.ProximityRadius = gt.ProximityRadius,g.Latitude = gt.Latitude, g.Longitude = gt.Longitude 
			FROM dbo.GeoTargeting g 
			INNER JOIN @GeoTVP gt ON gt.PKEY = g.GeoTargetingPK where gt.Operation = 'U'
			
        delete from dbo.GeoTargeting from dbo.GeoTargeting g INNER JOIN  @GEOTVP gt on gt.PKEY = g.GeoTargetingPK where gt.Operation= 'D'
        
        insert into dbo.PromotionAds (PromotionFK,AdTextLine1,AdTextLine2,AdTitle,CreatedDate)
			select @PromotionPK,a.AdTextLine1,a.AdTextLine2,a.AdTitle,current_timestamp from @AdTVP a where a.Operation ='I'
			
		update p SET 
			p.AdTextLine1 = a.AdTextLine1, p.AdTextLine2 = a.AdTextLine2, p.AdTitle = a.AdTitle
			FROM dbo.PromotionAds p 
			INNER JOIN @AdTVP a ON a.PKEY = p.PromotionAdsPK WHERE a.Operation = 'U'
			
		delete from dbo.PromotionAds from dbo.PromotionAds p INNER JOIN  @AdTVP a on a.PKEY = p.PromotionAdsPK where a.Operation= 'D'

     commit transaction   
	END
	
	SELECT g.GeoTargetingPK PKEY, gt.UID UID from dbo.GeoTargeting g 
	INNER JOIN @GEOTVP gt on 
			g.Address = gt.Address and g.City= gt.City and g.StateCodeFK = gt.StateCodeFK and g.City = gt.City and
			g.StateCodeFK = gt.StateCodeFK and g.Zip = gt.Zip and g.ProximityRadius = gt.ProximityRadius and
			g.Latitude = gt.Latitude and g.Longitude = gt.Longitude 
	WHERE gt.operation = 'I'
	UNION
	SELECT p.PromotionAdsPK PKEY, a.UID UID from dbo.PromotionAds p 
	INNER JOIN @AdTVP a on 
			p.AdTextLine1 = a.AdTextLine1 and p.AdTextLine2 = a.AdTextLine2 and p.AdTitle = a.AdTitle
	WHERE a.Operation = 'I'
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO