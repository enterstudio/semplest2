IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetMSNGeoLocation') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetMSNGeoLocation;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetMSNGeoLocation
(
	@IsState            bit,
	@State varchar(2) = null,
	@Longitude decimal(8,4) = null,
	@Latitude decimal(8,4)= null,
	@Radius Decimal(10,2) = null
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250), @LocationID int, @pt geography, @str varchar(100);

	--validate data
	IF (@IsState = 1 and @State is null)
	BEGIN
		SELECT @ErrMsg = 'Need to provide a State'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	if (@IsState = 0  and (@Longitude is null or @Latitude is null or @Radius is null) )
	BEGIN
		SELECT @ErrMsg = 'Need to provide a Longitude, Latitude and Radius'; 
		RAISERROR (@ErrMsg, 16, 1);
	END;
	
	if (@IsState = 1)
	BEGIN
		--Find a state
		select @LocationID = msn.LocationID from MSNGeoLocation msn where msn.IsState = 1 and msn.MSNName = 'US-' + @State
		select msn.Name, msn.MSNName, msn.latitude, msn.longitude from MSNGeoLocation msn where IsCity = 1 and msn.ParentSubGeographyLocationID = @LocationID  
	END
	ELSE
	BEGIN
		set @str = 'POINT(' + Cast(@Longitude as Varchar) + ' ' + Cast(@Latitude as Varchar) + ')';
		SET @pt = geography::STGeomFromText(@str, 4326);
		
		SELECT msn.Name, msn.MSNName,msn.latitude, msn.longitude from MSNGeoLocation msn
		WHERE msn.GeogCol1.STDistance(@pt)<=(@radius * 1609.344)

	END			 
	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO