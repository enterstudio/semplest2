USE [semplest]
GO
/****** Object:  Table [dbo].[SEMCustomerDetails]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SEMCustomerDetails](
	[SEMCustomerDetailsPK] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](100) NOT NULL,
	[LastName] [nvarchar](100) NULL,
	[Company] [nvarchar](100) NOT NULL,
	[Phone] [nvarchar](100) NULL,
	[email] [nvarchar](100) NOT NULL,
	[CallMe] [bit] NOT NULL,
	[EmailMe] [bit] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
	[EditedDate] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[SEMCustomerDetailsPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Keyword]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Keyword](
	[KeywordPK] [int] IDENTITY(1,1) NOT NULL,
	[Keyword] [nvarchar](250) NOT NULL,
	[IsActive] [bit] NOT NULL,
	[ISNegative] [bit] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
	[EditedDate] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[KeywordPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HelpDefinition]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HelpDefinition](
	[GUIWidgetID] [int] NOT NULL,
	[HelpText] [nvarchar](300) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[GUIWidgetID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Frequency]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Frequency](
	[FrequencyPK] [int] IDENTITY(1,1) NOT NULL,
	[Frequency] [nchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[FrequencyPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Daily, Weekly, Monthly' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Frequency'
GO
/****** Object:  Table [dbo].[Error]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Error](
	[ErrorPK] [int] IDENTITY(1,1) NOT NULL,
	[ErrorMessage] [nvarchar](max) NOT NULL,
	[ErrorID] [int] NULL,
 CONSTRAINT [PK__Error__35F112FA03F0984C] PRIMARY KEY CLUSTERED 
(
	[ErrorPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EmployeeType]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeType](
	[EmployeeTypeID] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeType] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[EmployeeTypeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Configuration]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Configuration](
	[ConfigurationPK] [int] IDENTITY(1,1) NOT NULL,
	[CustomerMinOrderAmount] [money] NOT NULL,
	[CustomerDefaultMonthlyFlatFeeAmount] [money] NOT NULL,
	[CustomerDefaultPerCampaignFlatFeeAmount] [money] NOT NULL,
	[CustomerDefaultPerAdGroupFlatFeeAmount] [money] NOT NULL,
	[DefaultMediaComissionPercentage] [decimal](5, 4) NOT NULL,
	[DefaultSalesPersonCommissionPercentage] [decimal](5, 4) NOT NULL,
	[MinSalespersonCommissionPercentage] [decimal](5, 4) NOT NULL,
	[MaxSalespersonCommissionPercentage] [decimal](5, 4) NULL,
	[DefalutBudgetMixPercentageGoogle] [decimal](5, 4) NULL,
	[DefalutBudgetMixPercentageBing] [decimal](5, 4) NULL,
	[DefaultSemplestBannerImageUrl] [nvarchar](1024) NULL,
	[DefaultSemplestStyleSheetUrl] [nvarchar](1024) NULL,
	[MaxNumberOfSitelinks] [int] NULL,
	[LastAccountNumberUsed] [int] NULL,
	[LastSEMplestEmployeeIDused] [int] NULL,
	[DefaultEmailContactUs] [nvarchar](150) NULL,
	[DefalutEmailContactMe] [nvarchar](150) NULL,
	[DefaultProductGroupName] [nvarchar](256) NULL,
	[DefaultProductPromotionName] [nvarchar](256) NULL,
	[SamplestDevelopmentEmail] [nvarchar](150) NULL,
	[SemplestDefaultBudgetMarkUpOrDown] [nvarchar](1) NULL,
PRIMARY KEY CLUSTERED 
(
	[ConfigurationPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillType]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillType](
	[BillTypePK] [int] IDENTITY(1,1) NOT NULL,
	[BillType] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_BillType] PRIMARY KEY CLUSTERED 
(
	[BillTypePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'PayType: NoBill, BillCredit, BillInvoice ' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'BillType'
GO
/****** Object:  Table [dbo].[BidType]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BidType](
	[BidTypePK] [int] IDENTITY(1,1) NOT NULL,
	[BidType] [nvarchar](1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[BidTypePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Exact;Broad;Phrase;Negative;BroadWithModifier' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'BidType'
GO
/****** Object:  Table [dbo].[AdvertisingEngine]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AdvertisingEngine](
	[AdvertisingEnginePK] [int] IDENTITY(1,1) NOT NULL,
	[AdvertisingEngine] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_AdvertisingEngine] PRIMARY KEY CLUSTERED 
(
	[AdvertisingEnginePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AddressType]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AddressType](
	[AddressTypePK] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[AddressType] [nvarchar](1) NULL,
 CONSTRAINT [PK_AddressType] PRIMARY KEY CLUSTERED 
(
	[AddressTypePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[RolePK] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RolePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rights]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rights](
	[RightsPK] [int] IDENTITY(1,1) NOT NULL,
	[Controller] [nvarchar](40) NOT NULL,
	[Label] [nvarchar](40) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RightsPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductGroupCycleType]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductGroupCycleType](
	[ProductGroupCycleTypePK] [int] IDENTITY(1,1) NOT NULL,
	[ProductGroupCycleType] [nchar](30) NOT NULL,
	[CycleInDays] [int] NOT NULL,
 CONSTRAINT [PK_ProductGroupCycleType] PRIMARY KEY CLUSTERED 
(
	[ProductGroupCycleTypePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Weekly/7,Monthly/30,Quarterly/90,SemiAnnual/162,Annual/365' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ProductGroupCycleType'
GO
/****** Object:  Table [dbo].[PhoneType]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhoneType](
	[PhoneTypePK] [int] NOT NULL,
	[PhoneType] [nvarchar](20) NULL,
 CONSTRAINT [PK_PhoneType] PRIMARY KEY CLUSTERED 
(
	[PhoneTypePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Task]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Task](
	[TaskPK] [int] IDENTITY(1,1) NOT NULL,
	[ServiceName] [nchar](100) NOT NULL,
	[MethodName] [nchar](50) NOT NULL,
	[Parameters] [nchar](2500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TaskPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StateCode]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StateCode](
	[StateAbbrPK] [int] IDENTITY(1,1) NOT NULL,
	[StateAbbr] [nvarchar](5) NOT NULL,
 CONSTRAINT [PK_StateCode] PRIMARY KEY CLUSTERED 
(
	[StateAbbrPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Schedule]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Schedule](
	[SchedulePK] [int] IDENTITY(1,1) NOT NULL,
	[StartTime] [datetime2](7) NOT NULL,
	[FrequencyFK] [int] NOT NULL,
	[IsEnabled] [bit] NOT NULL,
	[IsSuccessful] [bit] NOT NULL,
	[IsInactive] [bit] NOT NULL,
	[IsComplete] [int] NOT NULL,
	[CreatedBy] [int] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
	[EditedBy] [int] NOT NULL,
	[EditedDate] [datetime2](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[SchedulePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RolesRightsAssociation]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RolesRightsAssociation](
	[RolesFK] [int] NOT NULL,
	[RightsFK] [int] NOT NULL,
	[IsVisible] [bit] NOT NULL,
	[IsReadonly] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RolesFK] ASC,
	[RightsFK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phone]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phone](
	[PhonePK] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[Phone] [nvarchar](25) NOT NULL,
	[Extension] [nvarchar](10) NULL,
	[PhoneTypeFK] [int] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
	[EditedDate] [datetime2](7) NULL,
 CONSTRAINT [PK_Phone] PRIMARY KEY CLUSTERED 
(
	[PhonePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Address]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Address](
	[AddressPK] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[Address1] [nvarchar](150) NOT NULL,
	[Address2] [nvarchar](150) NULL,
	[City] [nvarchar](100) NOT NULL,
	[StateAbbrFK] [int] NOT NULL,
	[ZipCode] [nvarchar](15) NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
	[EditedDate] [datetime2](7) NULL,
 CONSTRAINT [PK_Address] PRIMARY KEY CLUSTERED 
(
	[AddressPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerPK] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[TotalTargetCycleBudget] [money] NOT NULL,
	[ProductGroupCycleTypeFK] [int] NOT NULL,
	[BillTypeFK] [int] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
	[EditedDate] [datetime2](7) NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[CustomerPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ScheduleTaskAssociation]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ScheduleTaskAssociation](
	[TaskFK] [int] NOT NULL,
	[ScheduleFK] [int] NOT NULL,
	[TaskExecutionOrder] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TaskFK] ASC,
	[ScheduleFK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CustomerStyle]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerStyle](
	[CustomerFK] [int] NOT NULL,
	[CustomerLogo] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerFK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CustomerPhoneAssociation]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerPhoneAssociation](
	[CustomerFK] [int] NOT NULL,
	[PhoneFK] [int] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerFK] ASC,
	[PhoneFK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CustomerNotes]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerNotes](
	[CustomerFK] [int] NOT NULL,
	[NotePK] [int] NOT NULL,
	[CreatedDate] [datetime] NULL,
	[EditedDate] [datetime] NULL,
	[Note] [nvarchar](4000) NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerFK] ASC,
	[NotePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CustomerHierarchy]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerHierarchy](
	[CustomerHierarchyPK] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[CustomerFK] [int] NOT NULL,
	[CustomerParentFK] [int] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_CustomerHierarchy] PRIMARY KEY CLUSTERED 
(
	[CustomerHierarchyPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [UNI_CustomerHierarchy_2] UNIQUE NONCLUSTERED 
(
	[CustomerFK] ASC,
	[CustomerParentFK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CustomerAddressAssociation]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerAddressAssociation](
	[AddressFK] [int] NOT NULL,
	[CustomerFK] [int] NOT NULL,
	[AddressTypeFK] [int] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_CustomerAddressAssociation] PRIMARY KEY CLUSTERED 
(
	[AddressFK] ASC,
	[CustomerFK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AdvertisingEngineAccount]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AdvertisingEngineAccount](
	[AdvertisingEngineAccountPK] [varchar](30) NOT NULL,
	[AdvertisingEngineFK] [int] NOT NULL,
	[CustomerFK] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[AdvertisingEngineAccountPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'The PK comes from Google/MSN' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'AdvertisingEngineAccount'
GO
/****** Object:  Table [dbo].[ProductGroup]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductGroup](
	[ProductGroupPK] [int] IDENTITY(1,1) NOT NULL,
	[CustomerFK] [int] NOT NULL,
	[ProductGroupName] [nvarchar](50) NOT NULL,
	[StartDate] [datetime2](7) NOT NULL,
	[EndDate] [datetime2](7) NULL,
	[IsActive] [bit] NOT NULL,
	[CreateDate] [datetime2](7) NOT NULL,
	[EditedDate] [datetime2](7) NULL,
 CONSTRAINT [PK_ProductGroup] PRIMARY KEY CLUSTERED 
(
	[ProductGroupPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[sp_GetRigtsRolesInteraction]    Script Date: 04/19/2012 17:15:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
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
/****** Object:  Table [dbo].[Users]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserPK] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[CustomerFK] [int] NULL,
	[FirstName] [nvarchar](40) NOT NULL,
	[LastName] [nvarchar](40) NOT NULL,
	[Email] [nvarchar](100) NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
	[EditedDate] [datetime2](7) NULL,
	[IsActive] [bit] NOT NULL,
	[MiddleInitial] [nchar](1) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[UserPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promotion]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promotion](
	[PromotionPK] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[ProductGroupFK] [int] NOT NULL,
	[LandingPageURL] [nvarchar](35) NOT NULL,
	[CycleBudgetAmount] [money] NOT NULL,
	[StartDate] [datetime2](7) NOT NULL,
	[EndDate] [datetime2](7) NULL,
	[IsPaused] [bit] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
	[EditedDate] [nchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[PromotionPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserRolesAssociation]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRolesAssociation](
	[UserRolesAssociationPK] [int] IDENTITY(1,1) NOT NULL,
	[RolesFK] [int] NOT NULL,
	[UsersFK] [int] NOT NULL,
 CONSTRAINT [PK__UserRole__C4B597C51AD3FDA4] PRIMARY KEY CLUSTERED 
(
	[UserRolesAssociationPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TransactionHistory]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TransactionHistory](
	[TransactionHistoryPK] [int] IDENTITY(1,1) NOT NULL,
	[UserFK] [int] NOT NULL,
	[TransactionDate] [datetime2](7) NOT NULL,
	[TableName] [nvarchar](40) NOT NULL,
	[Field] [nvarchar](75) NOT NULL,
	[OldValue] [nvarchar](100) NOT NULL,
	[NewValue] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TransactionHistoryPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Credential]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Credential](
	[CredentialPK] [int] IDENTITY(1,1) NOT NULL,
	[UsersFK] [int] NOT NULL,
	[Username] [nvarchar](300) NOT NULL,
	[Password] [nvarchar](1) NOT NULL,
	[RememberMe] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CredentialPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[EmployeePK] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeTypeFK] [int] NOT NULL,
	[UsersFK] [int] NOT NULL,
	[ReportingTo] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[EmployeePK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[EmployeeTypeFK] ASC,
	[UsersFK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EmployeeCustomerAssociation]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EmployeeCustomerAssociation](
	[EmployeeCustomerAssociationPK] [int] IDENTITY(1,1) NOT NULL,
	[EmployeeFK] [int] NOT NULL,
	[CustomerFK] [int] NOT NULL,
 CONSTRAINT [PK_EmployeeCustomerAssociation] PRIMARY KEY CLUSTERED 
(
	[EmployeeCustomerAssociationPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[AdvertisingEngineCampaign]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AdvertisingEngineCampaign](
	[AdvertisingEngineCampaignPK] [nvarchar](40) NOT NULL,
	[PromotionFK] [int] NULL,
	[AdvertisingEngineAccountFK] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[AdvertisingEngineCampaignPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'The PK comes from Google/MSN' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'AdvertisingEngineCampaign'
GO
/****** Object:  Table [dbo].[PromotionKeywordAssociation]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PromotionKeywordAssociation](
	[KeywordFK] [int] NOT NULL,
	[PromotionFK] [int] NOT NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[KeywordFK] ASC,
	[PromotionFK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PromotionAds]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PromotionAds](
	[PromotionAdsPK] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[PromotionFK] [int] NULL,
	[AdText] [nvarchar](4000) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[PromotionAdsPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Each AdGroup has 1 or more Ads' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PromotionAds'
GO
/****** Object:  Table [dbo].[SiteLinks]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SiteLinks](
	[SiteLInkPK] [int] IDENTITY(1,1) NOT NULL,
	[PromotionAdsFK] [int] NOT NULL,
	[LinkText] [nvarchar](35) NOT NULL,
	[LinkURL] [nvarchar](1024) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[SiteLInkPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KeywordBid]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KeywordBid](
	[KeywordBidPK] [int] IDENTITY(1,1) NOT NULL,
	[KeywordFK] [int] NOT NULL,
	[PromotionFK] [int] NOT NULL,
	[StartDate] [datetime2](7) NOT NULL,
	[EndDate] [datetime2](7) NULL,
	[IsActive] [bit] NOT NULL,
	[BidTypeFK] [int] NOT NULL,
	[BidAmount] [money] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[KeywordBidPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'Contains keyword Bids over time' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'KeywordBid'
GO
/****** Object:  Table [dbo].[AdvertisingEngineBidData]    Script Date: 04/19/2012 17:14:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AdvertisingEngineBidData](
	[AdvertisingEngineBidPK] [int] NOT NULL,
	[KeywordBidFK] [int] NULL,
	[BidAmount] [money] NOT NULL,
	[NumberImpressions] [int] NOT NULL,
	[NumberClick] [int] NOT NULL,
	[AveragePosition] [int] NOT NULL,
	[AverageCPC] [money] NOT NULL,
	[QualityScore] [int] NULL,
	[CreatedDate] [datetime2](7) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[AdvertisingEngineBidPK] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Default [DF__Address__Created__2B3F6F97]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Address] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [DF__Advertisi__Creat__5535A963]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[AdvertisingEngineBidData] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [DF__Credentia__Remem__6477ECF3]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Credential] ADD  DEFAULT ('0') FOR [RememberMe]
GO
/****** Object:  Default [DF__Customer__TotalT__03317E3D]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Customer] ADD  DEFAULT ((0.0)) FOR [TotalTargetCycleBudget]
GO
/****** Object:  Default [Default_Create_Constraint]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Customer] ADD  CONSTRAINT [Default_Create_Constraint]  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [DF__CustomerA__Creat__68487DD7]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerAddressAssociation] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [DF__CustomerH__Creat__6EF57B66]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerHierarchy] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [DF__CustomerP__Creat__7A672E12]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerPhoneAssociation] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [DF__Keyword__IsActiv__0F975522]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Keyword] ADD  DEFAULT ('1') FOR [IsActive]
GO
/****** Object:  Default [DF__Keyword__ISNegat__108B795B]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Keyword] ADD  DEFAULT ((0)) FOR [ISNegative]
GO
/****** Object:  Default [DF__Keyword__Created__117F9D94]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Keyword] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [DF__KeywordBi__IsAct__38996AB5]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[KeywordBid] ADD  DEFAULT ('1') FOR [IsActive]
GO
/****** Object:  Default [DF__KeywordBi__BidAm__398D8EEE]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[KeywordBid] ADD  DEFAULT ('0.0') FOR [BidAmount]
GO
/****** Object:  Default [DF__Phone__CreatedDa__3E52440B]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Phone] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [Isactive_default]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[ProductGroup] ADD  CONSTRAINT [Isactive_default]  DEFAULT ('1') FOR [IsActive]
GO
/****** Object:  Default [DF__ProductGr__Creat__09DE7BCC]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[ProductGroup] ADD  DEFAULT (getdate()) FOR [CreateDate]
GO
/****** Object:  Default [DF__Promotion__IsPau__164452B1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Promotion] ADD  DEFAULT ('0') FOR [IsPaused]
GO
/****** Object:  Default [DF__Promotion__Creat__173876EA]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Promotion] ADD  DEFAULT ('CURRENT_TIMESTAMP') FOR [CreatedDate]
GO
/****** Object:  Default [DF__Promotion__Creat__24927208]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[PromotionKeywordAssociation] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [DF__RolesRigh__IsVis__41EDCAC5]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[RolesRightsAssociation] ADD  DEFAULT ('1') FOR [IsVisible]
GO
/****** Object:  Default [DF__RolesRigh__IsRea__42E1EEFE]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[RolesRightsAssociation] ADD  DEFAULT ('1') FOR [IsReadonly]
GO
/****** Object:  Default [DF__Schedule__IsEnab__550B8C31]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Schedule] ADD  DEFAULT ('0') FOR [IsEnabled]
GO
/****** Object:  Default [DF__Schedule__IsSucc__55FFB06A]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Schedule] ADD  DEFAULT ('0') FOR [IsSuccessful]
GO
/****** Object:  Default [DF__Schedule__IsInac__56F3D4A3]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Schedule] ADD  DEFAULT ('0') FOR [IsInactive]
GO
/****** Object:  Default [DF__Schedule__IsComp__57E7F8DC]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Schedule] ADD  DEFAULT ('0') FOR [IsComplete]
GO
/****** Object:  Default [DF__Schedule__Create__58DC1D15]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Schedule] ADD  DEFAULT ((0)) FOR [CreatedBy]
GO
/****** Object:  Default [DF__Schedule__Edited__59D0414E]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Schedule] ADD  DEFAULT ((0)) FOR [EditedBy]
GO
/****** Object:  Default [DF__SEMCustom__CallM__30CE2BBB]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[SEMCustomerDetails] ADD  DEFAULT ('0') FOR [CallMe]
GO
/****** Object:  Default [DF__SEMCustom__Email__31C24FF4]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[SEMCustomerDetails] ADD  DEFAULT ('1') FOR [EmailMe]
GO
/****** Object:  Default [DF__SEMCustom__Creat__32B6742D]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[SEMCustomerDetails] ADD  DEFAULT ('CURRENT_TIMESTAMP') FOR [CreatedDate]
GO
/****** Object:  Default [DF__Transacti__Trans__2DE6D218]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[TransactionHistory] ADD  DEFAULT (getdate()) FOR [TransactionDate]
GO
/****** Object:  Default [DF__Users__CreatedDa__4E88ABD4]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Users] ADD  DEFAULT (getdate()) FOR [CreatedDate]
GO
/****** Object:  Default [Default_IsActive]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [Default_IsActive]  DEFAULT ('1') FOR [IsActive]
GO
/****** Object:  ForeignKey [Address_StateCode]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [Address_StateCode] FOREIGN KEY([StateAbbrFK])
REFERENCES [dbo].[StateCode] ([StateAbbrPK])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [Address_StateCode]
GO
/****** Object:  ForeignKey [REL_AdvertisingEngine_AdvertisingEngineAccount_2]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[AdvertisingEngineAccount]  WITH CHECK ADD  CONSTRAINT [REL_AdvertisingEngine_AdvertisingEngineAccount_2] FOREIGN KEY([AdvertisingEngineFK])
REFERENCES [dbo].[AdvertisingEngine] ([AdvertisingEnginePK])
GO
ALTER TABLE [dbo].[AdvertisingEngineAccount] CHECK CONSTRAINT [REL_AdvertisingEngine_AdvertisingEngineAccount_2]
GO
/****** Object:  ForeignKey [REL_Customer_AdvertisingEngineAccount_3]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[AdvertisingEngineAccount]  WITH CHECK ADD  CONSTRAINT [REL_Customer_AdvertisingEngineAccount_3] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[AdvertisingEngineAccount] CHECK CONSTRAINT [REL_Customer_AdvertisingEngineAccount_3]
GO
/****** Object:  ForeignKey [REL_KeywordBid_AdvertisingEngineBidData_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[AdvertisingEngineBidData]  WITH CHECK ADD  CONSTRAINT [REL_KeywordBid_AdvertisingEngineBidData_1] FOREIGN KEY([KeywordBidFK])
REFERENCES [dbo].[KeywordBid] ([KeywordBidPK])
GO
ALTER TABLE [dbo].[AdvertisingEngineBidData] CHECK CONSTRAINT [REL_KeywordBid_AdvertisingEngineBidData_1]
GO
/****** Object:  ForeignKey [REL_AdvertisingEngineAccount_AdvertisingEngineCampaign_3]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[AdvertisingEngineCampaign]  WITH CHECK ADD  CONSTRAINT [REL_AdvertisingEngineAccount_AdvertisingEngineCampaign_3] FOREIGN KEY([AdvertisingEngineAccountFK])
REFERENCES [dbo].[AdvertisingEngineAccount] ([AdvertisingEngineAccountPK])
GO
ALTER TABLE [dbo].[AdvertisingEngineCampaign] CHECK CONSTRAINT [REL_AdvertisingEngineAccount_AdvertisingEngineCampaign_3]
GO
/****** Object:  ForeignKey [REL_Promotion_AdvertisingEngineCampaign_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[AdvertisingEngineCampaign]  WITH CHECK ADD  CONSTRAINT [REL_Promotion_AdvertisingEngineCampaign_1] FOREIGN KEY([PromotionFK])
REFERENCES [dbo].[Promotion] ([PromotionPK])
GO
ALTER TABLE [dbo].[AdvertisingEngineCampaign] CHECK CONSTRAINT [REL_Promotion_AdvertisingEngineCampaign_1]
GO
/****** Object:  ForeignKey [REL_Users_Credential_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Credential]  WITH CHECK ADD  CONSTRAINT [REL_Users_Credential_1] FOREIGN KEY([UsersFK])
REFERENCES [dbo].[Users] ([UserPK])
GO
ALTER TABLE [dbo].[Credential] CHECK CONSTRAINT [REL_Users_Credential_1]
GO
/****** Object:  ForeignKey [cycType_Relation]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [cycType_Relation] FOREIGN KEY([ProductGroupCycleTypeFK])
REFERENCES [dbo].[ProductGroupCycleType] ([ProductGroupCycleTypePK])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [cycType_Relation]
GO
/****** Object:  ForeignKey [REL_BillType_Customer_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [REL_BillType_Customer_1] FOREIGN KEY([BillTypeFK])
REFERENCES [dbo].[BillType] ([BillTypePK])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [REL_BillType_Customer_1]
GO
/****** Object:  ForeignKey [Address_Rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerAddressAssociation]  WITH CHECK ADD  CONSTRAINT [Address_Rel] FOREIGN KEY([AddressFK])
REFERENCES [dbo].[Address] ([AddressPK])
GO
ALTER TABLE [dbo].[CustomerAddressAssociation] CHECK CONSTRAINT [Address_Rel]
GO
/****** Object:  ForeignKey [AddressType_rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerAddressAssociation]  WITH CHECK ADD  CONSTRAINT [AddressType_rel] FOREIGN KEY([AddressTypeFK])
REFERENCES [dbo].[AddressType] ([AddressTypePK])
GO
ALTER TABLE [dbo].[CustomerAddressAssociation] CHECK CONSTRAINT [AddressType_rel]
GO
/****** Object:  ForeignKey [Customer_rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerAddressAssociation]  WITH CHECK ADD  CONSTRAINT [Customer_rel] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[CustomerAddressAssociation] CHECK CONSTRAINT [Customer_rel]
GO
/****** Object:  ForeignKey [Child_Rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerHierarchy]  WITH CHECK ADD  CONSTRAINT [Child_Rel] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[CustomerHierarchy] CHECK CONSTRAINT [Child_Rel]
GO
/****** Object:  ForeignKey [Paraent_Rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerHierarchy]  WITH CHECK ADD  CONSTRAINT [Paraent_Rel] FOREIGN KEY([CustomerParentFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[CustomerHierarchy] CHECK CONSTRAINT [Paraent_Rel]
GO
/****** Object:  ForeignKey [REL_Customer_CustomerNotes_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerNotes]  WITH CHECK ADD  CONSTRAINT [REL_Customer_CustomerNotes_1] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[CustomerNotes] CHECK CONSTRAINT [REL_Customer_CustomerNotes_1]
GO
/****** Object:  ForeignKey [custPhone_rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerPhoneAssociation]  WITH CHECK ADD  CONSTRAINT [custPhone_rel] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[CustomerPhoneAssociation] CHECK CONSTRAINT [custPhone_rel]
GO
/****** Object:  ForeignKey [PhoneCust_rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerPhoneAssociation]  WITH CHECK ADD  CONSTRAINT [PhoneCust_rel] FOREIGN KEY([PhoneFK])
REFERENCES [dbo].[Phone] ([PhonePK])
GO
ALTER TABLE [dbo].[CustomerPhoneAssociation] CHECK CONSTRAINT [PhoneCust_rel]
GO
/****** Object:  ForeignKey [REL_Customer_CustomerStyle_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[CustomerStyle]  WITH CHECK ADD  CONSTRAINT [REL_Customer_CustomerStyle_1] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[CustomerStyle] CHECK CONSTRAINT [REL_Customer_CustomerStyle_1]
GO
/****** Object:  ForeignKey [REL_EmployeeType_Employee_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [REL_EmployeeType_Employee_1] FOREIGN KEY([EmployeeTypeFK])
REFERENCES [dbo].[EmployeeType] ([EmployeeTypeID])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [REL_EmployeeType_Employee_1]
GO
/****** Object:  ForeignKey [REL_Users_Employee_2]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [REL_Users_Employee_2] FOREIGN KEY([UsersFK])
REFERENCES [dbo].[Users] ([UserPK])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [REL_Users_Employee_2]
GO
/****** Object:  ForeignKey [REL_Customer_EmployeeCustomerAssociation_2]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[EmployeeCustomerAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Customer_EmployeeCustomerAssociation_2] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[EmployeeCustomerAssociation] CHECK CONSTRAINT [REL_Customer_EmployeeCustomerAssociation_2]
GO
/****** Object:  ForeignKey [REL_Employee_EmployeeCustomerAssociation_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[EmployeeCustomerAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Employee_EmployeeCustomerAssociation_1] FOREIGN KEY([EmployeeFK])
REFERENCES [dbo].[Employee] ([EmployeePK])
GO
ALTER TABLE [dbo].[EmployeeCustomerAssociation] CHECK CONSTRAINT [REL_Employee_EmployeeCustomerAssociation_1]
GO
/****** Object:  ForeignKey [REL_BidType_KeywordBid_2]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[KeywordBid]  WITH CHECK ADD  CONSTRAINT [REL_BidType_KeywordBid_2] FOREIGN KEY([BidTypeFK])
REFERENCES [dbo].[BidType] ([BidTypePK])
GO
ALTER TABLE [dbo].[KeywordBid] CHECK CONSTRAINT [REL_BidType_KeywordBid_2]
GO
/****** Object:  ForeignKey [REL_PromotionKeywordAssociation_KeywordBid_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[KeywordBid]  WITH CHECK ADD  CONSTRAINT [REL_PromotionKeywordAssociation_KeywordBid_1] FOREIGN KEY([KeywordFK], [PromotionFK])
REFERENCES [dbo].[PromotionKeywordAssociation] ([KeywordFK], [PromotionFK])
GO
ALTER TABLE [dbo].[KeywordBid] CHECK CONSTRAINT [REL_PromotionKeywordAssociation_KeywordBid_1]
GO
/****** Object:  ForeignKey [PhoneType_rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Phone]  WITH CHECK ADD  CONSTRAINT [PhoneType_rel] FOREIGN KEY([PhoneTypeFK])
REFERENCES [dbo].[PhoneType] ([PhoneTypePK])
GO
ALTER TABLE [dbo].[Phone] CHECK CONSTRAINT [PhoneType_rel]
GO
/****** Object:  ForeignKey [Cust_Camp_rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[ProductGroup]  WITH CHECK ADD  CONSTRAINT [Cust_Camp_rel] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[ProductGroup] CHECK CONSTRAINT [Cust_Camp_rel]
GO
/****** Object:  ForeignKey [REL_ProductGroup_Promotion_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Promotion]  WITH CHECK ADD  CONSTRAINT [REL_ProductGroup_Promotion_1] FOREIGN KEY([ProductGroupFK])
REFERENCES [dbo].[ProductGroup] ([ProductGroupPK])
GO
ALTER TABLE [dbo].[Promotion] CHECK CONSTRAINT [REL_ProductGroup_Promotion_1]
GO
/****** Object:  ForeignKey [REL_Promotion_PromotionAds_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[PromotionAds]  WITH CHECK ADD  CONSTRAINT [REL_Promotion_PromotionAds_1] FOREIGN KEY([PromotionFK])
REFERENCES [dbo].[Promotion] ([PromotionPK])
GO
ALTER TABLE [dbo].[PromotionAds] CHECK CONSTRAINT [REL_Promotion_PromotionAds_1]
GO
/****** Object:  ForeignKey [REL_Keyword_PromotionKeywordAssociation_2]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[PromotionKeywordAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Keyword_PromotionKeywordAssociation_2] FOREIGN KEY([KeywordFK])
REFERENCES [dbo].[Keyword] ([KeywordPK])
GO
ALTER TABLE [dbo].[PromotionKeywordAssociation] CHECK CONSTRAINT [REL_Keyword_PromotionKeywordAssociation_2]
GO
/****** Object:  ForeignKey [REL_Promotion_PromotionKeywordAssociation_3]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[PromotionKeywordAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Promotion_PromotionKeywordAssociation_3] FOREIGN KEY([PromotionFK])
REFERENCES [dbo].[Promotion] ([PromotionPK])
GO
ALTER TABLE [dbo].[PromotionKeywordAssociation] CHECK CONSTRAINT [REL_Promotion_PromotionKeywordAssociation_3]
GO
/****** Object:  ForeignKey [REL_Rights_RolesRightsAssociation_2]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[RolesRightsAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Rights_RolesRightsAssociation_2] FOREIGN KEY([RightsFK])
REFERENCES [dbo].[Rights] ([RightsPK])
GO
ALTER TABLE [dbo].[RolesRightsAssociation] CHECK CONSTRAINT [REL_Rights_RolesRightsAssociation_2]
GO
/****** Object:  ForeignKey [REL_Roles_RolesRightsAssociation_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[RolesRightsAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Roles_RolesRightsAssociation_1] FOREIGN KEY([RolesFK])
REFERENCES [dbo].[Roles] ([RolePK])
GO
ALTER TABLE [dbo].[RolesRightsAssociation] CHECK CONSTRAINT [REL_Roles_RolesRightsAssociation_1]
GO
/****** Object:  ForeignKey [REL_Frequency_Schedule_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [REL_Frequency_Schedule_1] FOREIGN KEY([FrequencyFK])
REFERENCES [dbo].[Frequency] ([FrequencyPK])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [REL_Frequency_Schedule_1]
GO
/****** Object:  ForeignKey [REL_Schedule_ScheduleTaskAssociation_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[ScheduleTaskAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Schedule_ScheduleTaskAssociation_1] FOREIGN KEY([ScheduleFK])
REFERENCES [dbo].[Schedule] ([SchedulePK])
GO
ALTER TABLE [dbo].[ScheduleTaskAssociation] CHECK CONSTRAINT [REL_Schedule_ScheduleTaskAssociation_1]
GO
/****** Object:  ForeignKey [REL_PromotionAds_SiteLinks_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[SiteLinks]  WITH CHECK ADD  CONSTRAINT [REL_PromotionAds_SiteLinks_1] FOREIGN KEY([PromotionAdsFK])
REFERENCES [dbo].[PromotionAds] ([PromotionAdsPK])
GO
ALTER TABLE [dbo].[SiteLinks] CHECK CONSTRAINT [REL_PromotionAds_SiteLinks_1]
GO
/****** Object:  ForeignKey [REL_Users_TransactionHistory_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[TransactionHistory]  WITH CHECK ADD  CONSTRAINT [REL_Users_TransactionHistory_1] FOREIGN KEY([UserFK])
REFERENCES [dbo].[Users] ([UserPK])
GO
ALTER TABLE [dbo].[TransactionHistory] CHECK CONSTRAINT [REL_Users_TransactionHistory_1]
GO
/****** Object:  ForeignKey [REL_Roles_UserRolesAssociation_2]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[UserRolesAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Roles_UserRolesAssociation_2] FOREIGN KEY([RolesFK])
REFERENCES [dbo].[Roles] ([RolePK])
GO
ALTER TABLE [dbo].[UserRolesAssociation] CHECK CONSTRAINT [REL_Roles_UserRolesAssociation_2]
GO
/****** Object:  ForeignKey [REL_Users_UserRolesAssociation_1]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[UserRolesAssociation]  WITH CHECK ADD  CONSTRAINT [REL_Users_UserRolesAssociation_1] FOREIGN KEY([UsersFK])
REFERENCES [dbo].[Users] ([UserPK])
GO
ALTER TABLE [dbo].[UserRolesAssociation] CHECK CONSTRAINT [REL_Users_UserRolesAssociation_1]
GO
/****** Object:  ForeignKey [UserCustomer_rel]    Script Date: 04/19/2012 17:14:59 ******/
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [UserCustomer_rel] FOREIGN KEY([CustomerFK])
REFERENCES [dbo].[Customer] ([CustomerPK])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [UserCustomer_rel]
GO
