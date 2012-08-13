USE [semplest]
GO

CREATE TYPE [dbo].[PromoAdTableType] AS TABLE(
	[AdTitle] [nvarchar](25) NULL,
	[AdTextLine1] [nvarchar](35) NULL,
	[AdTextLine2] [nvarchar](35) NULL,
	[UID] [varchar](100) NULL,
	[PKEY] [int],
	[Operation][varchar](1) NOT NULL
	)

GO