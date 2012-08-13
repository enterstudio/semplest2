USE [semplest]
GO

CREATE TYPE [dbo].[SiteLinksTableType] AS TABLE(
	[LinkText] [nvarchar](35) NULL,
	[LinkUrl] [varchar](100) NULL,
	[UID] [varchar](100) NULL,
	[PKEY] [int] NULL,
	[Operation] [varchar](1) NOT NULL
)
GO