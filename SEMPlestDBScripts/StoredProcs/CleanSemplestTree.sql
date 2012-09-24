IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'dbo.CleanSemplestTree') AND type in (N'P', N'PC'))
  DROP PROCEDURE dbo.CleanSemplestTree;
GO

-- +----------------------------------------------------------------------------------------------------------------+
-- | Author  - Mitch                                                                                                |
-- | Written - 9/20/2012																							|
-- | Parms   - 																							|
-- | Purpose - 						|
-- +----------------------------------------------------------------------------------------------------------------+

CREATE PROCEDURE dbo.CleanSemplestTree

AS
BEGIN TRY
	SET NOCOUNT ON;
begin transaction
delete from NodeURLAssociation
delete from SemplestURLData
delete from Domain
delete from Classifier
delete from SemplestTree
delete from SemplestTreeTemp
commit transaction
	
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