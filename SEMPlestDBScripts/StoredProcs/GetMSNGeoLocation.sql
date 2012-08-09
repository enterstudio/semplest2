IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.GetMSNGeoLocation') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.GetMSNGeoLocation;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 		
-- EXAMPLE When PromoyionID is null
--DECLARE @totalSize int
--exec GetMSNGeoLocation @PromotionID = NULL, @ValueList = 'MA,,,;,41.5069100000,-71.3016090000,100.00', @ValueDelimiter = ',', @ListDelimiter = ';',@totalSize = @totalSize
			
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.GetMSNGeoLocation
(
	@PromotionID int = null,
	@ValueList varchar(max) = null,
	@ValueDelimiter varchar(3) = null,
	@ListDelimiter varchar(3) = null, 
	@totalSize int output
)
AS
BEGIN TRY
SET NOCOUNT ON;
declare @geoTargets Table(StateCode varchar(2),Latitude Decimal(18,10), Longitude Decimal(18,10),Radius Decimal(18,2) )
declare @cities table(city varchar(200), metroID int)
declare @citiesTEMP table(city varchar(200), metroID int)
declare @states table(states varchar(10))
declare @metro table(metro varchar(100), metroID int)
declare @citiesInStates table(city varchar(200))
declare @GeoPts table (pt Geography, Radius Decimal(18,2))

declare @metroSummary table(ID int, number int)
declare @citymetroSummary table(ID int, number int)
declare @LocationID Table (ID int);
DECLARE @pt geography, @str varchar(100),@Latitude Decimal(18,10), @Longitude Decimal(18,10),@Radius Decimal(18,2), @stateCount int, @metroCount int, @cityCount int


DECLARE @CostBasisTypeIDtbl TABLE (CostBasisTypeID int, BasisValue bit)
 --PUT THE CostBasis AND VALUE INTO  table 
 if (@PromotionID is null)	 
 BEGIN
	insert into @geoTargets(StateCode ,Latitude,Longitude,Radius)
	select s.Column1 [StateCode], CAST (Isnull(s.Column2, -1) as DECIMAL(18,10)) [Latitude], CAST (Isnull(s.Column3, -1) as DECIMAL(18,10)) [Longitude], CAST (Isnull(s.Column4, -1) as DECIMAL(18,2)) [Radius] from dbo.Split(@ValueList,@ListDelimiter) r 
	CROSS APPLY dbo.SplitIntoColumns(r.DATA,@ValueDelimiter) s
	
	
END
ELSE
BEGIN
	insert into @geoTargets(StateCode,Latitude,Longitude,Radius)
	select st.StateAbbr [State], gt.Latitude, gt.Longitude,gt.ProximityRadius from Promotion p 
		inner join GeoTargeting gt on gt.PromotionFK = p.PromotionPK
		left join StateCode st on st.StateAbbrPK = gt.StateCodeFK
		where p.PromotionPK = @PromotionID
END		
--select * from @geoTargets
--select * from @geoTargets gt where (gt.Radius is not null and gt.Radius <> -1)

--Get the states
insert into @states(states) 
select DISTINCT 'US-' + gt.StateCode from @geoTargets gt	
where (gt.Radius is null or gt.Radius = -1)

insert into @LocationID(ID)
select msn.LocationID from MSNGeoLocation msn 
inner join @states s on s.states = msn.MSNName and msn.IsState = 1

--get the list of cities given pt and radius
if exists (select * from @geoTargets gt where (gt.Radius is not null and gt.Radius <> -1))
BEGIN
	insert into @GeoPts(pt,Radius)
	select geography::STGeomFromText('POINT(' + Cast(gt.Longitude as Varchar) + ' ' + Cast(gt.Latitude as Varchar) + ')', 4326), gt.Radius 
	from @geoTargets gt where (gt.Radius is not null and gt.Radius <> -1) 
	
	Insert into @citiesTEMP(city, metroID)
	select DISTINCT s.MSNName,s.ParentMetroAreaLocationID from @GeoPts gp
	cross apply (
	SELECT msn.MSNName, msn.ParentMetroAreaLocationID from MSNGeoLocation msn
		WHERE msn.GeogCol1.STDistance(gp.pt)<=(gp.Radius * 1609.344) and msn.IsCity = 1) s
END

--get remaining cities
insert into @cities(city,metroID)
select distinct c.city, c.metroID from @citiesTEMP c
left join @citiesInStates cis on c.city = cis.city
where c.city is not null

insert into @citymetroSummary(ID,number)
select c.metroID, COUNT(*) from @cities c
group by c.metroID

insert into @metroSummary(ID,number)
select msn.ParentMetroAreaLocationID, COUNT(*) from MSNGeoLocation msn
where msn.IsCity = 1 and msn.ParentMetroAreaLocationID in (select DISTINCT cms.ID from @citymetroSummary cms) 
group by msn.ParentMetroAreaLocationID

insert into @metro(metro,metroID)
select DISTINCT msn.MSNName, msn.LocationID from MSNGeoLocation msn inner join  
(select ms.ID from @citymetroSummary cs
inner join @metroSummary ms on cs.ID = ms.ID and cs.number = ms.number) m 
on msn.LocationID = m.ID

--get all unque cities for all geotargets
delete @cities
from @cities c
inner join @metro m on m.metroID = c.metroID

select @stateCount = count(s.states) from @states s
select @metroCount = count(m.metro) from @metro m
select @cityCount = count(c.city) from @cities c
set @totalSize = ISNULL(@stateCount, 0) + ISNULL(@metroCount, 0) + ISNULL(@cityCount, 0)

select s.states [msnName] from @states s
select m.metro [msnName] from @metro m
select c.city [msnName] from @cities c


return @totalSize

	
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO