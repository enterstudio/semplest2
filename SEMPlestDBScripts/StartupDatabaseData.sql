--roles 
insert into dbo.roles (rolename) values ('Customer (child)')
insert into dbo.roles (rolename) values ('Customer (parent)')
insert into dbo.roles (rolename) values ('Account Representative (Rep)')
insert into dbo.roles (rolename) values ('Salesperson')
insert into dbo.roles (rolename) values ('Finance User')
insert into dbo.roles (rolename) values ('Super User (Admin)')
insert into dbo.roles (rolename) values ('System')

--scheduler 
insert into Frequency(Frequency) values ('Now')
insert into Frequency(Frequency) values ('Daily')
insert into Frequency(Frequency) values ('Weekly')
insert into Frequency(Frequency) values ('Monthly')
insert into Frequency(Frequency) values ('TenMinutes')
--Ad Engines
Insert into AdvertisingEngine(AdvertisingEngine) VALUES ('MSN')
Insert into AdvertisingEngine(AdvertisingEngine) VALUES ('Google')
--Keyword Match Type
insert into BidType(BidType) values ('Broad')
insert into BidType(BidType) values ('Exact')
insert into BidType(BidType) values ('Phrase')
--Budget cycle
insert into BudgetCycle(BudgetCycle) values ('Daily')
insert into BudgetCycle(BudgetCycle) values ('Weekly')
insert into BudgetCycle(BudgetCycle) values ('Monthly')
insert into BudgetCycle(BudgetCycle) values ('Yearly')
--Billing Types
insert into BillType(BillType) values ('No Bill')
insert into BillType(BillType) values ('Credit Card')
insert into BillType(BillType) values ('Invoice')

--states

/****** Object:  Table [dbo].[StateCode]    Script Date: 05/08/2012 18:04:10 ******/
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
SET IDENTITY_INSERT [dbo].[StateCode] OFF
/****** Object:  Table [dbo].[PhoneType]    Script Date: 05/08/2012 18:04:10 ******/
INSERT [dbo].[PhoneType] ([PhoneTypePK], [PhoneType]) VALUES (1, N'Business')
GO


insert into [AddressType] (AddressType) values ('H')
GO

--Config
update Configuration 
					set MSNCampaignURL = 'https://adcenterapi.microsoft.com/Api/Advertiser/v8/CampaignManagement/CampaignManagementService.svc?wsdl' ,
					MSNCampagnNamespace = 'https://adcenter.microsoft.com/v8',
					MSNCustomerURL ='https://sharedservices.adcenterapi.microsoft.com/Api/CustomerManagement/v8/CustomerManagementService.svc?wsdl',
					MSNCustomerNamespace = 'https://adcenter.microsoft.com/api/customermanagement',
					MSNReportingURL = 'https://adcenterapi.microsoft.com/Api/Advertiser/v8/Reporting/ReportingService.svc?wsdl',
					MSNReportingNamespace = 'https://adcenter.microsoft.com/v8',
					MSNAdIntelligenceURL = 'https://adcenterapi.microsoft.com/Api/Advertiser/v8/CampaignManagement/AdIntelligenceService.svc?wsdl',
					MSNAdIntelligenceNamespace = 'https://adcenter.microsoft.com/v8',
					MSNParentCustomerID = 694122,
					MSNApiUsername = 'API_SEMplest',
					MSNApiPassword = '1s3mpl3st',
					MSNUserAccessKey = '6LTW1JCMEKIUX3',
					
					AdwordsEmail = 'adwords@semplest.com',
					AdwordsPassword = 'ic0system', 
					AdwordsUserAgent= 'Icosystem',
					AdwordsDeveloperToken = '2H8l6aUm6K_Q44vDvxs3Og',
					
					OrbitalGatewaySalemPlatform = '000001',
					OrbitalGatewayMerchantID = '041756',
					OrbitalGatewayUsername = 'TSEMPLEST01',
					OrbitalGatewayPassword = '01tsemplest',
					
					SemplestClientAdwordsTimeoutMS = 20000,
					SemplestClientKeywordTimeoutMS = 20000,
					SemplestClientMSNTimeoutMS = 20000,
					SemplestClientBiddingTimeoutMS = 20000,
					SemplestClientMailTimeoutMS = 5000,
					SemplestClientSchedulerTimeoutMS = 5000,
					
					SemplestBiddingMaxRetry = 10,
					SemplestBiddingSleepPeriod = 500,
					SemplestBiddingSleepBackOffTime = 1000,
					SemplestBiddingMaxMicroBid = 3000000,
					SemplestBiddingStepAboveFpCPC = 500000,
					SemplestBiddingDefaultMicroBid = 1000000,
					SemplestBiddingMaxDefaultMicroBid = 1500000,
					SemplestBiddingStepFirst = 100000,
					SemplestBiddingStepSecond =  600000,
					SemplestBiddingStepRest =  800000,
					SemplestBiddingGooglePercent = 70,
					
					ESBRegServicePort = 9999,
					ESBBrokerName = 'SEMplestMQ',
					ESBBrokerPort = 61616,
					ESBBrokerIP = 'VMJAVA1',
					ESBWebServerPort = 9898,
					ESBWebServerURL = 'http://VMJAVA1:9898/semplest',
					ESBHeaderBufferSize = 512000,
					ESBAsynchServletCorePoolSize = 10,
					ESBAsynchServletMaxPoolSize = 100,
					ESBAsynchCallDefaultTimeoutMS = 10000,
					
					ServiceESBServerPort = 9999,
					ServiceESBServerIP = 'VMJAVA1',
					ServicePingFrequencyMS = 10000,
					ServiceNumberServiceThreads = 15,
					ServiceSMTP = 'VMJAVA2'
				where ConfigurationPK = 1

