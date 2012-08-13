USE [semplest]
GO

CREATE TYPE [dbo].[GeoTargetTableType] AS TABLE(
	[Address] [varchar](150) NULL,
	[City] [varchar](100) NULL,
	[StateCodeFK] [int] NULL,
	[Zip] [nvarchar](15) NULL,
	[Longitude] [decimal] (18,10) NULL,
	[Latitude] [decimal] (18,10) NULL,
	[ProximityRadius] [decimal] (18,10) NULL,
	[UID] [varchar](100) NULL,
	[PKEY] [int],
	[Operation][varchar](1) NOT NULL
	)


GO


