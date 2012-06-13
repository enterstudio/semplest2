USE [semplest]
GO

/****** Object:  UserDefinedTableType [dbo].[PromotionKeywordTableType]    Script Date: 06/13/2012 17:43:08 ******/
CREATE TYPE [dbo].[PromotionKeywordTableType] AS TABLE(
	[Keyword] [varchar](250) NOT NULL,
	[IsActive] [bit] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
	[IsNegative] [bit] NOT NULL,
	[SemplestProbability] [float] NULL,
	[IsTargetMSN] [bit] NOT NULL,
	[IsTargetGoogle] [bit] NOT NULL,
	PRIMARY KEY CLUSTERED 
(
	[Keyword] ASC
)WITH (IGNORE_DUP_KEY = OFF)
)
GO


