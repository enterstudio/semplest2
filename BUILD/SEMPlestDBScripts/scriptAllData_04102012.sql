USE [semplest]
GO
/****** Object:  Table [dbo].[Keyword]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[HelpDefinition]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[Error]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[EmployeeType]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[PhoneType]    Script Date: 04/10/2012 14:34:06 ******/
INSERT [dbo].[PhoneType] ([PhoneTypePK], [PhoneType]) VALUES (1, N'1')
/****** Object:  Table [dbo].[Configuration]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[Configuration] ON
INSERT [dbo].[Configuration] ([ConfigurationPK], [CustomerMinOrderAmount], [CustomerDefaultMonthlyFlatFeeAmount], [CustomerDefaultPerCampaignFlatFeeAmount], [CustomerDefaultPerAdGroupFlatFeeAmount], [DefaultMediaComissionPercentage], [DefaultSalesPersonCommissionPercentage], [MinSalespersonCommissionPercentage], [MaxSalespersonCommissionPercentage], [DefalutBudgetMixPercentageGoogle], [DefalutBudgetMixPercentageBing], [DefaultSemplestBannerImageUrl], [DefaultSemplestStyleSheetUrl], [MaxNumberOfSitelinks], [LastAccountNumberUsed], [LastSEMplestEmployeeIDused], [DefaultEmailContactUs], [DefalutEmailContactMe], [DefaultProductGroupName], [DefaultProductPromotionName], [SamplestDevelopmentEmail], [SemplestDefaultBudgetMarkUpOrDown]) VALUES (1, 200.0000, 100.0000, 75.0000, 75.0000, CAST(0.5000 AS Decimal(5, 4)), CAST(0.4000 AS Decimal(5, 4)), CAST(0.0000 AS Decimal(5, 4)), NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Configuration] OFF
/****** Object:  Table [dbo].[BillType]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[BillType] ON
INSERT [dbo].[BillType] ([BillTypePK], [BillType]) VALUES (1, N'Flat Fee')
INSERT [dbo].[BillType] ([BillTypePK], [BillType]) VALUES (2, N'Media Comission')
SET IDENTITY_INSERT [dbo].[BillType] OFF
/****** Object:  Table [dbo].[BidType]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[AdvertisingEngine]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[AddressType]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[AddressType] ON
INSERT [dbo].[AddressType] ([AddressTypePK], [AddressType]) VALUES (3, N'H')
SET IDENTITY_INSERT [dbo].[AddressType] OFF
/****** Object:  Table [dbo].[Roles]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[Roles] ON
INSERT [dbo].[Roles] ([RolePK], [RoleName]) VALUES (1, N'Customer (child)')
INSERT [dbo].[Roles] ([RolePK], [RoleName]) VALUES (2, N'Customer (parent)')
INSERT [dbo].[Roles] ([RolePK], [RoleName]) VALUES (3, N'Account Representative (Rep)')
INSERT [dbo].[Roles] ([RolePK], [RoleName]) VALUES (4, N'Salesperson')
INSERT [dbo].[Roles] ([RolePK], [RoleName]) VALUES (5, N'Finance User')
INSERT [dbo].[Roles] ([RolePK], [RoleName]) VALUES (6, N'Super User (Admin)')
INSERT [dbo].[Roles] ([RolePK], [RoleName]) VALUES (7, N'System')
SET IDENTITY_INSERT [dbo].[Roles] OFF
/****** Object:  Table [dbo].[Rights]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[Rights] ON
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1098, N'Home.Index', N'usersearch')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1099, N'Home.Index', N'emailsearch')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1100, N'Home.Index', N'accountnumbersearch')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1101, N'EmployeeSetup.Edit', N'MiddleInitial')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1102, N'EmployeeSetup.Edit', N'LastName')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1103, N'EmployeeSetup.Edit', N'FirstName')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1104, N'EmployeeSetup.Edit', N'Email')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1105, N'EmployeeSetup.Edit', N'EditedDate')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1106, N'EmployeeSetup.Edit', N'CreatedDate')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1107, N'EmployeeSetup.Edit', N'IsActive')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1108, N'Configuration.Index', N'CustomerMinOrderAmount')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1109, N'Configuration.Index', N'CustomerDefaultMonthlyFlatFeeAmount')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1110, N'Configuration.Index', N'CustomerDefaultPerCampaignFlatFeeAmount')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1111, N'Configuration.Index', N'DefaultMediaComissionPercentage')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1112, N'Configuration.Index', N'DefaultSalesPersonCommissionPercentage')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1113, N'Configuration.Index', N'CustomerDefaultPerAdGroupFlatFeeAmount')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1114, N'Configuration.Index', N'DefalutBudgetMixPercentageGoogle')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1115, N'Configuration.Index', N'MaxSalespersonCommissionPercentage')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1116, N'Configuration.Index', N'MinSalespersonCommissionPercentage')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1117, N'Configuration.Index', N'LastAccountNumberUsed')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1118, N'Configuration.Index', N'MaxNumberOfSitelinks')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1119, N'Configuration.Index', N'DefaultSemplestStyleSheetUrl')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1120, N'Configuration.Index', N'DefaultProductGroupName')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1121, N'Configuration.Index', N'DefalutEmailContactMe')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1122, N'Configuration.Index', N'SemplestDefaultBudgetMarkUpOrDown')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1123, N'Configuration.Index', N'DefaultProductPromotionName')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1124, N'Configuration.Index', N'SamplestDevelopmentEmail')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1125, N'Configuration.Index', N'DefaultSemplestBannerImageUrl')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1126, N'Configuration.Index', N'LastSEMplestEmployeeIDused')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1127, N'Configuration.Index', N'DefalutBudgetMixPercentageBing')
INSERT [dbo].[Rights] ([RightsPK], [Controller], [Label]) VALUES (1128, N'Configuration.Index', N'DefaultEmailContactUs')
SET IDENTITY_INSERT [dbo].[Rights] OFF
/****** Object:  Table [dbo].[ProductGroupCycleType]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[ProductGroupCycleType] ON
INSERT [dbo].[ProductGroupCycleType] ([ProductGroupCycleTypePK], [ProductGroupCycleType], [CycleInDays]) VALUES (1, N'Product Group Cycle 30        ', 30)
INSERT [dbo].[ProductGroupCycleType] ([ProductGroupCycleTypePK], [ProductGroupCycleType], [CycleInDays]) VALUES (2, N'Product Group Cycle 7         ', 7)
INSERT [dbo].[ProductGroupCycleType] ([ProductGroupCycleTypePK], [ProductGroupCycleType], [CycleInDays]) VALUES (3, N'Product Group Cycle 365       ', 365)
SET IDENTITY_INSERT [dbo].[ProductGroupCycleType] OFF
/****** Object:  Table [dbo].[sysdiagrams]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[StateCode]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[StateCode] ON
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (1, N'AL')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (2, N'AK')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (3, N'AZ')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (4, N'AR')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (5, N'CA')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (6, N'CO')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (7, N'CT')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (8, N'DE')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (9, N'FL')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (10, N'GA')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (11, N'HI')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (12, N'ID')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (13, N'IL')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (14, N'IN')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (15, N'IA')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (16, N'KS')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (17, N'KY')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (18, N'LA')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (19, N'ME')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (20, N'MD')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (21, N'MA')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (22, N'MI')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (23, N'MN')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (24, N'MS')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (25, N'MO')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (26, N'MT')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (27, N'NE')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (28, N'NV')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (29, N'NH')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (30, N'NJ')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (31, N'NM')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (32, N'NY')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (33, N'NC')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (34, N'ND')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (35, N'OH')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (36, N'OK')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (37, N'OR')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (38, N'PA')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (39, N'RI')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (40, N'SC')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (41, N'SD')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (42, N'TN')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (43, N'TX')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (44, N'UT')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (45, N'VT')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (46, N'VA')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (47, N'WA')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (48, N'WV')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (49, N'WI')
INSERT [dbo].[StateCode] ([StateAbbrPK], [StateAbbr]) VALUES (50, N'WY')
SET IDENTITY_INSERT [dbo].[StateCode] OFF/****** Object:  Table [dbo].[SEMCustomerDetails]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[RolesRightsAssociation]    Script Date: 04/10/2012 14:34:06 ******/
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (1, 1098, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (1, 1099, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (1, 1100, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (3, 1098, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (3, 1099, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (3, 1100, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (3, 1101, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (3, 1102, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (3, 1103, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (3, 1104, 1, 1)
INSERT [dbo].[RolesRightsAssociation] ([RolesFK], [RightsFK], [IsVisible], [IsReadonly]) VALUES (3, 1105, 1, 1)
/****** Object:  Table [dbo].[Address]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[Address] ON
INSERT [dbo].[Address] ([AddressPK], [Address1], [Address2], [City], [StateAbbrFK], [ZipCode], [CreatedDate], [EditedDate]) VALUES (6, N'123 Main Street', NULL, N'New York', 1, N'1', CAST(0x07702A6CC08389350B AS DateTime2), NULL)
SET IDENTITY_INSERT [dbo].[Address] OFF
/****** Object:  Table [dbo].[Customer]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[Customer] ON
INSERT [dbo].[Customer] ([CustomerPK], [Name], [TotalTargetCycleBudget], [ProductGroupCycleTypeFK], [BillTypeFK], [CreatedDate], [EditedDate]) VALUES (2, N'State Farm', 1000000.0000, 1, 1, CAST(0x07B010B3FF7C89350B AS DateTime2), NULL)
SET IDENTITY_INSERT [dbo].[Customer] OFF
/****** Object:  Table [dbo].[Phone]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[Phone] ON
INSERT [dbo].[Phone] ([PhonePK], [Phone], [Extension], [PhoneTypeFK], [CreatedDate], [EditedDate]) VALUES (1, N'2122556545', N'123', 1, CAST(0x07D0853E5A8489350B AS DateTime2), NULL)
SET IDENTITY_INSERT [dbo].[Phone] OFF
/****** Object:  Table [dbo].[CustomerStyle]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[CustomerPhoneAssociation]    Script Date: 04/10/2012 14:34:06 ******/
INSERT [dbo].[CustomerPhoneAssociation] ([CustomerFK], [PhoneFK], [CreatedDate]) VALUES (2, 1, CAST(0x07700FC98C8489350B AS DateTime2))
/****** Object:  Table [dbo].[CustomerNotes]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[CustomerHierarchy]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[CustomerAddressAssociation]    Script Date: 04/10/2012 14:34:06 ******/
INSERT [dbo].[CustomerAddressAssociation] ([AddressFK], [CustomerFK], [AddressTypeFK], [CreatedDate]) VALUES (6, 2, 3, CAST(0x0760D5244C8689350B AS DateTime2))
/****** Object:  Table [dbo].[AdvertisingEngineAccount]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[ProductGroup]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[ProductGroup] ON
INSERT [dbo].[ProductGroup] ([ProductGroupPK], [CustomerFK], [ProductGroupName], [StartDate], [EndDate], [IsActive], [CreateDate], [EditedDate]) VALUES (3, 2, N'Product Group 1', CAST(0x07000000000046350B AS DateTime2), CAST(0x070000000000B4360B AS DateTime2), 1, CAST(0x0780E9570C7D89350B AS DateTime2), NULL)
SET IDENTITY_INSERT [dbo].[ProductGroup] OFF
/****** Object:  Table [dbo].[Users]    Script Date: 04/10/2012 14:34:06 ******/
SET IDENTITY_INSERT [dbo].[Users] ON
INSERT [dbo].[Users] ([UserPK], [CustomerFK], [FirstName], [LastName], [Email], [CreatedDate], [EditedDate], [IsActive], [MiddleInitial]) VALUES (1, 2, N'Mark', N'Kelley', N'markk@fdsfds.com', CAST(0x0770DB43207D89350B AS DateTime2), NULL, 1, N'X')
SET IDENTITY_INSERT [dbo].[Users] OFF
/****** Object:  Table [dbo].[UserRolesAssociation]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[TransactionHistory]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[Promotion]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[Employee]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[Credential]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[AdvertisingEngineCampaign]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[EmployeeCustomerAssociation]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[PromotionKeywordAssociation]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[PromotionAds]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[SiteLinks]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[KeywordBid]    Script Date: 04/10/2012 14:34:06 ******/
/****** Object:  Table [dbo].[AdvertisingEngineBidData]    Script Date: 04/10/2012 14:34:06 ******/
