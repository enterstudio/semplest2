USE [semplest]
GO

/****** Object:  StoredProcedure [dbo].[sp_GetRigtsRolesInteraction]    Script Date: 04/26/2012 17:07:26 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Andre' Barnes
-- Create date: c 4/12/12
-- Description:	Takes a role id and returns all right associations 
-- =============================================
CREATE PROCEDURE [dbo].[sp_GetRigtsRolesInteraction]
	-- Add the parameters for the stored procedure here
	 @roleId int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
SELECT
  ra.RolesFK, ri.Controller, ri.Label, ra.IsVisible, ra.IsReadonly, ri.RightsPK
FROM rights ri
left outer JOIN (select rolesfk,rightsfk, isvisible, isreadonly from RolesRightsAssociation where rolesfk=@roleId) ra ON ri.RightsPK = ra.RightsFK

END

GO


