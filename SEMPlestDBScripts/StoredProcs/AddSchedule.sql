IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.AddSchedule') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.AddSchedule;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 4/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - add new schedule					|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.AddSchedule
(
	@ScheduleName varchar(100),
	@StartTime DateTime2,
	@EndDate Datetime2 = null,
	@Frequency varchar(25),
	@IsEnabled bit,
	@IsInactive bit,
	@PromotionFK int = null,
	@CustomerFK int = null,
	@ProductGroupFK int = null,
	@UsersFK int = null,
	@ID int output
)
AS
BEGIN TRY
	SET NOCOUNT ON;
	DECLARE @ErrMsg VARCHAR(250)
	
	declare @freqID int;
	select @freqID = f.FrequencyPK from Frequency f where f.Frequency = @Frequency 
	if (@freqID is not null)
	begin
	
		insert into Schedule(ScheduleName,StartTime,EndDate,FrequencyFK,IsEnabled,IsInactive,PromotionFK,CustomerFK,ProductGroupFK,UsersFK, CreatedDate)
		values (@ScheduleName,@StartTime,@EndDate,@freqID,@IsEnabled,@IsInactive,@PromotionFK,@CustomerFK,@ProductGroupFK,@UsersFK, CURRENT_TIMESTAMP)
		set @ID = @@IDENTITY
		return @ID
	END
	
	return null;
END TRY
BEGIN CATCH
	DECLARE @ErrMessage	nvarchar(4000),
          @ErrorSeverity	int,
          @ErrorState		int;
	SELECT @ErrMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY(), @ErrorState = ERROR_STATE();
	RAISERROR (@ErrMessage, @ErrorSeverity, @ErrorState);
END CATCH;
GO