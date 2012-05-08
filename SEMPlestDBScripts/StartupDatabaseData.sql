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
					SemplestClientSchedulerTimeoutMS = 5000
				where ConfigurationPK = 1