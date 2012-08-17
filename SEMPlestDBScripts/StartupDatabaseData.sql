insert into PayType(PayType) values ('CreditCard')
insert into PayType(PayType) values ('Invoice')
insert into PayType(PayType) values ('NoPay')

insert into TransactionType(TransactionType) values ('MediaSpend')
insert into TransactionType(TransactionType) values ('SemplestMediaSpendFee')
insert into TransactionType(TransactionType) values ('SemplestFlatFee')

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
insert into Frequency(Frequency) values ('Hour')
insert into Frequency(Frequency) values ('TwoHour')
insert into Frequency(Frequency) values ('ThreeHou')
insert into Frequency(Frequency) values ('SixHour')
--Ad Engines
Insert into AdvertisingEngine(AdvertisingEngine, LogoURL) VALUES ('MSN','MSN Logo.png')
Insert into AdvertisingEngine(AdvertisingEngine, LogoURL) VALUES ('Google','Google Logo.png')
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
--Employee Type
insert into EmployeeType(EmployeeType) values ('Rep')
insert into EmployeeType(EmployeeType) values ('Finance')
insert into EmployeeType(EmployeeType) values ('Sales')
insert into EmployeeType(EmployeeType) values ('Admin')
--SEmplest bid types
insert into SemplestBidType(SemplestBidType) values ('Initial')	
insert into SemplestBidType(SemplestBidType) values ('Ongoing')
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
insert into [AddressType] (AddressType) values ('STATE')
insert into [AddressType] (AddressType) values ('GEO_POINT')
GO
---ProductGroupCycleType
INSERT INTO ProductGroupCycleType (ProductGroupCycleType, CycleInDays) VALUES ('Product Group Cycle 30' ,30)
INSERT INTO ProductGroupCycleType (ProductGroupCycleType, CycleInDays) VALUES ('Product Group Cycle 7' ,7)
INSERT INTO ProductGroupCycleType (ProductGroupCycleType, CycleInDays) VALUES ('Product Group Cycle 365' ,365)

--Config
INSERT INTO [dbo].[Configuration]
           ([CustomerMinOrderAmount],
           [CustomerDefaultMonthlyFlatFeeAmount],
           [CustomerDefaultPerCampaignFlatFeeAmount],
           [CustomerDefaultPerAdGroupFlatFeeAmount],
           [DefaultMediaComissionPercentage],
           [DefaultSalesPersonCommissionPercentage],
           [MinSalespersonCommissionPercentage])
     VALUES
           (25,75,17.5,12.75,4.13,0,0)

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
					MSNApiUsername = 'API_SEMplest', --'API_Semplest_SBX'
					MSNApiPassword = 'q+3IPJa12ivj6rZhQXgOUA==', --'hngfp+b2J5xloOCwjzRx0w=='
					MSNUserAccessKey = '6LTW1JCMEKIUX3', --'4736850EZ79M'
					MSNUseSandbox = 0,
					
					AdwordsEmail = 'adwords@semplest.com',
					AdwordsPassword = '7ylZJTlhuCG4loTC6Qllrw==', 
					AdwordsUserAgent= 'Icosystem',
					AdwordsDeveloperToken = '2H8l6aUm6K_Q44vDvxs3Og',
					AdwordsUseSandbox = 1, 
					AdwordsBillingAccount = '8490069727',
					AdwordsAPICostPer1000 = 0.25,
					AdwordsValidationAccountID = 2387614989,
					AdwordsValidationAdGroupID= 4766339711,
					
					OrbitalGatewaySalemPlatform = '000001',
					OrbitalGatewayMerchantID = '041756',
					OrbitalGatewayUsername = 'TSEMPLEST01',
					OrbitalGatewayPassword = 'ZiSssEltPoU19aKz5kgZUg==',
					
					SemplestClientAdwordsTimeoutMS = 20000,
					SemplestClientKeywordTimeoutMS = 400000,
					SemplestClientMSNTimeoutMS = 20000,
					SemplestClientBiddingTimeoutMS = 1200000,
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
					ESBBrokerIP = 'VMDEVJAVA1',
					ESBWebServerPort = 9898,
					ESBWebServerURL = 'http://VMDEVJAVA1:9898/semplest',
					ESBHeaderBufferSize = 512000,
					ESBAsynchServletCorePoolSize = 10,
					ESBAsynchServletMaxPoolSize = 100,
					ESBAsynchCallDefaultTimeoutMS = 10000,
					
					ServiceESBServerPort = 9999,
					ServiceESBServerIP = 'VMDEVJAVA1',
					ServicePingFrequencyMS = 10000,
					ServiceNumberServiceThreads = 15,
					ServiceSMTP = 'VMDEVJAVA2',
					ServiceESBPingWaitMS = 30000,
					
					SemplestEncryptionkey = '12345678901234567890123456789044',
					
					SemplestKeywordsdictfile = 'data/stemword.dict',
					SemplestKeywordsdocfile = 'data/dmoz/all.cats',
					SemplestKeywordstwfile = 'data/dmoz/all.tw',
					SemplestKeywordsdfile = 'data/dmoz/all/all.descs',
					SemplestKeywordsbaseMultiWPath = 'data/dmoz/multiwords/',
					SemplestKeywordsnGramsSubC = 'arts,business,computers,games,health,home,news,recreation,reference,science,shopping,society,sports',
					SemplestKeywordsnGramsC = 'all_2',
					SemplestKeywordsvalidCat = 'arts,business,computers,games,health,home,news,recreation,reference,science,shopping,society,sports',
					SemplestKeywordslucenedfile = 'data/dmoz/all/all.descs',
					SemplestKeywordssmallhCounts = '/semplest/data/dmoz/small/hCounts.txt',
					SemplestKeywordsstoplist = 'data/stoplists/en.txt',
					SemplestKeywordsnumTopics  = 126,
					SemplestKeywordsuserInfoWeight = 0.75,
					SemplestKeywordsnumKeywordsGoogle = 1500,
					SemplestKeywordsnumKeywordsMSN = 4000,
					SemplestKeywordsnumThreads = 6, 
					
					DisplayTargetCPCLevel = 0,
					ActivationValidForDays = 3,
					DoNotLaunchAdServices = 1,
					SemplestBiddingBudgetMultFactor = 1.0,
					SemplestBiddingInitialBidBoostFactor = 1.1,
					SemplestBiddingPercentileValue = 85,
					SemplestBiddingMarginFactor = 2.0,
					MSNTrafficEstAccountID = 800609,
					MaxNumberOfSitelinks = 10,

					DefaultEmailContactUs = 'help@semplest.com',
					DefalutEmailContactMe = 'info@semplest.com',
					DefaultProductGroupName = 'Category',
					DefaultProductPromotionName = 'Sub-Category',
					SamplestDevelopmentEmail = 'development@semplest.com',
					SemplestDefaultBudgetMarkUpOrDown = 1,
					BillingDaysOffset = 6,
					OnErrorEmail = 'development@semplest.com',
					
					PGPPrivateKeyPassword='Yo7ugNaJ+luwlXIIrk/BWQ==',
					RSAPrivateKeyPassword='Yo7ugNaJ+luwlXIIrk/BWQ==',
					RunMode = 'DEV',
					BiddingServiceTargetPosition = 3,
					ReminderEmailUrlPrefix = 'https://172.18.9.24/SemplestCore/verify?token=',
					RegistrationReminderEmailDaysBack= 3,
					RegistrationReminderLinkAdditionalDays= 1,
					AdengineExecuteBidProcessFrequency= 'Daily', 
					BiddingServiceBidMultiplierForGoogleFromMSNHistory = 2.0,
					BiddingServiceGoogleVolMultiplierFromMSNHistory = 20 ,
					SemplestAdEngineReportLookbackDays = 5


SET IDENTITY_INSERT PromotionStatus ON
insert into PromotionStatus(PromotionStatusPK, PromotionStatus) values (1, 'Pending')
insert into PromotionStatus(PromotionStatusPK, PromotionStatus) values (2, 'Live')
insert into PromotionStatus(PromotionStatusPK, PromotionStatus) values (3, 'Paused')
insert into PromotionStatus(PromotionStatusPK, PromotionStatus) values (4, 'Ended')
insert into PromotionStatus(PromotionStatusPK, PromotionStatus) values (5, 'Deleted')
SET IDENTITY_INSERT PromotionStatus OFF
				
--add first admin user
DECLARE @EmployeeTypeID INT
select @EmployeeTypeID = et.EmployeeTypeID from EmployeeType et where et.EmployeeType = 'Admin' 
SET IDENTITY_INSERT [dbo].[Users] ON
INSERT [dbo].[Users] ([UserPK], [CustomerFK], [FirstName], [LastName], [Email], [CreatedDate], [EditedDate], [IsActive], [MiddleInitial], [IsRegistered]) VALUES (1, NULL, N'Mark', N'Kelley', N'mk@rre.com', CAST(0x070000000000000000 AS DateTime2), NULL, 1, N'x', 1)
SET IDENTITY_INSERT [dbo].[Users] OFF
SET IDENTITY_INSERT [dbo].[Employee] ON
INSERT [dbo].[Employee] ([EmployeePK], [EmployeeTypeFK], [UsersFK], [ReportingTo], [HireDate]) VALUES (1, @EmployeeTypeID, 1, NULL, CAST(0x070000000000A6350B AS DateTime2))
SET IDENTITY_INSERT [dbo].[Employee] OFF
SET IDENTITY_INSERT [dbo].[Credential] ON
INSERT [dbo].[Credential] ([CredentialPK], [UsersFK], [Username], [Password], [RememberMe], [SecurityQuestion], [SecurityAnswer]) VALUES (1, 1, N'markkelley', N'markkelley', 0, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Credential] OFF
SET IDENTITY_INSERT [dbo].[UserRolesAssociation] ON
INSERT [dbo].[UserRolesAssociation] ([UserRolesAssociationPK], [UsersFK], [RolesFK]) VALUES (1, 1, 6)
SET IDENTITY_INSERT [dbo].[UserRolesAssociation] OFF



-- Email Types
INSERT INTO [dbo].[EmailType] ([EmailType]) VALUES ('ChangePassword')
INSERT INTO [dbo].[EmailType] ([EmailType]) VALUES ('CreditCardDeclined')
INSERT INTO [dbo].[EmailType] ([EmailType]) VALUES ('ExpiredActivationIds')
INSERT INTO [dbo].[EmailType] ([EmailType]) VALUES ('ForgottenPassword')
INSERT INTO [dbo].[EmailType] ([EmailType]) VALUES ('PromotionNotStarted')
INSERT INTO [dbo].[EmailType] ([EmailType]) VALUES ('WelcomeEmailChild')
INSERT INTO [dbo].[EmailType] ([EmailType]) VALUES ('WelcomeEmailParent')
INSERT INTO [dbo].[EmailType] ([EmailType]) VALUES ('WelcomeEmailNonParentUser')


--EmailTemplates
INSERT INTO [dbo].[EmailTemplate] ([CustomerFK],[EmailSubject],[EmailBody],[EmailFrom],[EmailTypeFK]) select  
        null,
        'Your New SEMplest Password',
        'Dear [VendorName],<br><br>Our records show your password to SEMplest has been changed. If you did not change your password, please contact us at [help@semplest.com].<br><br>Thank you!<br>SEMplest',
		'account@semplest.com',
		et.EmailTypePK  
		from EmailType et  where et.EmailType = 'ChangePassword'       


INSERT INTO [dbo].[EmailTemplate] ([CustomerFK],[EmailSubject],[EmailBody],[EmailFrom],[EmailTypeFK]) select
        null,
        'Your SEMplest Account has been Paused',
        'Dear [VendorName],<br><br>Our records show the credit card on file needs to be updated in order for your ads to remain active.<br><br>Please log into your SEMplest account to update your billing information or contact us at [help@semplest.com].<br><br>[SEMPLEST LINK]<br><br>Thank you!<br>SEMplest',
		'account@semplest.com',
		et.EmailTypePK  
		from EmailType et  where et.EmailType = 'CreditCardDeclined'	             
  

INSERT INTO [dbo].[EmailTemplate] ([CustomerFK],[EmailSubject],[EmailBody],[EmailFrom],[EmailTypeFK]) select
        null,
        'Expired SEMplest Password',
        'Dear [VendorName],<br><br>Due to inactivity using the SEMplest tool, your user name and password have expired. Below you will find updated account information. Please note, these activation IDs will expire in [XX] days.<br><br>User Name: [xxxxxx]<br>Password: [xxxxx]<br><br>[SEMPLEST LINK]<br><br>If you need any assistance, please reach out to us at [help@semplest.com].<br><br>Thank you!<br>SEMplest',
		'account@semplest.com',
		et.EmailTypePK  
		from EmailType et  where et.EmailType = 'ExpiredActivationIds'   



INSERT INTO [dbo].[EmailTemplate] ([CustomerFK],[EmailSubject],[EmailBody],[EmailFrom],[EmailTypeFK]) select
        null,
        'Your New SEMplest Password',
        'Dear [VendorName],<br><br>Below please find the temporary password to access your SEMplest account. Your user id has not changed. You will be prompted to change your password after logging in.<br><br>Password: [xxxxx]<br><br>[SEMPLEST LINK]<br><br>If you need any assistance, please reach out to us at [help@semplest.com].<br><br>Thank you!<br>SEMplest',
		'account@semplest.com',
		et.EmailTypePK  
		from EmailType et  where et.EmailType = 'ForgottenPassword'
		
		
INSERT INTO [dbo].[EmailTemplate] ([CustomerFK],[EmailSubject],[EmailBody],[EmailFrom],[EmailTypeFK]) select
        null,
        'Let SEMplest manage your search marketing!',
        'Dear [VendorName],<br><br>We noticed you haven’t created any search ads using SEMplest.<br><br>Creating a promotion is fast, easy and cost effective. If you need assistance getting started, please contact us at [help@semplest.com] or log into [SEMplest Link] and let us do the heavy lifting! We’ll have your promotions live on Google, Bing and Yahoo! in no time.<br><br>Want to learn more? Read our [FAQs] or [About Us].<br><br>We look forward to showing you how effective and efficient SEMplest makes search engine marketing!<br><br>Best,<br><br>The SEMplest Team',
		'account@semplest.com',
		et.EmailTypePK  
		from EmailType et  where et.EmailType = 'PromotionNotStarted'
		
		
INSERT INTO [dbo].[EmailTemplate] ([CustomerFK],[EmailSubject],[EmailBody],[EmailFrom],[EmailTypeFK]) select
        null,
        'How to reach the right audience and increase visits to your website—effortlessly!',
        'Dear [VendorName],<br><br>Interested in reaching your target audience through search engine marketing, but not sure how to get started?<br><br>Already have a search program and want to save time and money?<br><br>No worries!  [CustomerName] now offers an easy-to-use search marketing tool to help you get the most out of your advertising -- through search engine marketing on Google, Bing and Yahoo!.<br><br>You''re invited to try out [CustomerName] Search -- our intuitive tool for small businesses to create search engine marketing campaigns effectively and efficiently.<br><br>It lets you:<ul><li>Discover hundreds of personalized keywords for all of your business products.<li>Launch a search campaign in just three easy steps.<li>Sit back and relax -- it automates the ongoing management of your campaigns.</ul><br>Want to learn more? Visit <a href="http://www.semplest.com">www.semplest.com</a>.<br><br>Ready to get started? Go to [INSERT LINK] and use the following log in information:<br><br>User Name: [xxxxxx]<br>Password: [xxxxx]<br><br>With [CustomerName], it''s that easy!',
		'account@semplest.com',
		et.EmailTypePK  
		from EmailType et  where et.EmailType = 'WelcomeEmailChild'
		
		
INSERT INTO [dbo].[EmailTemplate] ([CustomerFK],[EmailSubject],[EmailBody],[EmailFrom],[EmailTypeFK]) select
        null,
        'Welcome to SEMplest! Account Details Inside',
        'Dear [VendorName],<br><br>Thank you for choosing SEMplest to effortlessly manage your search marketing needs!<br><br>To initiate your account and invite [CustomerName] clients to use the tool, go to [INSERT LINK] and enter the following log in information:<br><br>User Name: [xxxxxx]<br>Password: [xxxxx]<br><br>If you need any assistance, please reach out to us at [help@semplest.com].<br><br>We look forward to showing you how effective and efficient SEMplest makes search engine marketing!<br><br>Thank you!<br><br>The team at SEMplest<br>',
		'account@semplest.com',
		et.EmailTypePK  
		from EmailType et  where et.EmailType = 'WelcomeEmailParent'
		
INSERT INTO [dbo].[EmailTemplate] ([CustomerFK],[EmailSubject],[EmailBody],[EmailFrom],[EmailTypeFK]) select
		 null,
		 'Welcome to SEMplest! Account Details Inside',
		 'Dear [NonParentCustomer],<br><br>Thank you for choosing SEMplest to effortlessly manage your search marketing needs!<br> <br>To initiate your account and start using the tool, go to [INSERT LINK] and enter the following log in information:<br><br>User Name: [NonParentCustomerUserID]<br>Password: [NonParentCustomerPassword]<br><br>If you need any assistance, please reach out to us at [help@semplest.com].<br><br>We look forward to showing you how effective and efficient SEMplest makes search engine marketing!<br>Thank you!<br><br>The team at SEMplest<br>', 
		 'account@semplest.com',
		 et.EmailTypePK  
		 from EmailType et  where et.EmailType = 'WelcomeEmailNonParentUser'
		
--Web Content		
INSERT INTO [dbo].[WebContent]

([FAQ],[AboutUs],[ContactUs],[PrivacyPolicy],[TermsAndConditions],[ServicesAgreement]) Values
('<ol>
<li><p><b>What is SEM?</b><br>SEM is Search Engine Marketing. Search Engine Marketing is a form of Internet marketing that promotes websites by increasing visibility in search engine results. It is sometimes referred to as Pay Per Click (PPC) advertising since you only pay when a user clicks on your ad.</p></li>
<li><p><b>What are SEM ads?</b><br>SEM ads are short, text-based ads that appear above and/or to the side of the natural (unpaid) search results.<br>[~IMAGE_BEGIN]SearchEngineMarketingAds.png[~IMAGE_END]</p></li>
<li><p><b>What is the SEMplest tool?</b><br>The SEMplest tool is a simple, intuitive, well designed tool for businesses to create SEM campaigns effectively and efficiently.  This tool helps businesses seamlessly manage hundreds of keywords for multiple products and services, with multiple audience targets across multiple search engines. SEMplest uses artificial intelligence to automate the optimization of SEM campaigns. We do the heavy lifting for you.</p></li>
<li><p><b>How does SEMplest work?</b><br>Based on some basic information you provide about your business, the tool automatically generates hundreds of keywords and bids on each keyword(s) using proprietary technology and artificial intelligence. The tool monitors and dynamically changes the bids over time, across search engines to give you the best possible cost per visitor, and therefore, the best return on your investment. It''s important to note that you are not charged for your ads that potential customers see. You are only charged for those visitors that clicked on your ads and land on your website.</p></li>
<li><p><b>What does CPC mean?</b><br>CPC is cost per click, which is the amount of money that is spent on each click on your search engine advertisement.</p></li>
<li><p><b>Which search engines will my ads appear in?</b><br>The tool places advertisements in Google and Bing/Yahoo! You have the choice which search engine you want your ads to appear, although we recommend you use all of them.</p></li>
</ol>
<h3>Creating Ad Campaigns</h3>
<ol start="7">
<li><p><b>How many ads should I create?</b><br>SEMplest only requires one ad copy, but you are encouraged to try several different ads and the tool  will rotate and monitor to see which is performing better. The better performing ad will be used more often to help maximize the number of visitors to your site.</p></li>
<li><p><b>Why am I being asked to select locations to advertise in?</b><br>Selecting locations will help target your ads to the specific geographic areas in which you would like to market your services and products.</p></li>
<li><p><b>What is a keyword?</b><br>Keywords are words browsers type into search engines to find information relating to that search term. When a keyword is typed into a search box on a search engine, the engine uses that keyword to search the web for relevant web sites.</p></li>
<li><p><b>What is a long tail keyword?</b><br>Long tail keyword refers to several keywords or phrases a user types into a search engine to find relevant information. For example, "flowers" would be considered a broad keyword, whereas "flowers for a June wedding" would be a long tail phrase.</p></li>
<li><p><b>What is a negative keyword?</b><br>Negative keywords are keywords within a paid search campaign that prevent your ad from showing up. For example, if you are a florist who only sells fresh flowers, you may make "silk" a negative keyword.</p></li>
<li><p><b>How did you come up with the particular keywords for my advertisement?</b><br>Based on the information you entered to describe your business, along with your selected category, ad copy, website and location, we generated the best set of keywords to match what your target audience is using as search terms.</p></li>
<li><p><b>What do I do if I see a keyword that I don''t want my ad to appear under?</b><br>You may remove keywords that you don''t want to see your ads to appear under by checking off those keywords from the link that appears on your advertisement summary screen.</p></li>
<li><p><b>What if I don''t see a keyword that I would like to bid on?</b><br>With a typical SEM campaign you bid on the big keywords that everyone else wants. You''ll have to bid very high to win those words and phrases so your monthly budget doesn''t go too far. With SEMplest''s tool, we find you a large number of keywords and phrases that, individually, are not clicked as often, but together, in total, can get you many more high value prospects for the same investment.</p></li>
<li><p><b>What are Sitelinks?</b><br>Sitelinks are sub landing pages that sometimes appear under a search advertisement and are meant to help users navigate your site.  Currently, site links are only available for search campaigns via Google.<br>[~IMAGE_BEGIN]WhatAreSiteLinks.png[~IMAGE_END]</p></li>
<li><p><b>Can I edit my campaign after it is started?</b><br>Yes, you may edit your campaign at any time.</p></li>
<li><p><b>Can I stop my campaign if I don''t want to continue?</b><br>Yes, you may stop your campaign at any time.</p></li>
<li><p><b>Can I restart my campaign if it has been stopped?</b><br>Yes.</p></li>
</ol>

<h3>Campaign Billing</h3>
<ol start="19">
<li><p><b>How do I add or change a credit card?</b><br>This can all be done online in your account dashboard.</p></li>
<li><p><b>How am I billed?</b><br>When you first start a campaign, we immediately bill your selected credit card for the amount of the monthly budget you set, along with any SEMplest fees. On a reoccurring monthly basis, we will bill your card approximately 7 days before the next month of services is due to begin. Any unused budget from the previous month will roll over into the next full billing cycle (e.g. if only half your budget was used this month, the unused amount will roll over and you''ll only be charged half your budget during the next billing cycle!). Please note, services cannot begin until your credit card has been approved.</p></li>
<li><p><b>I changed my campaign budget in the middle of the month, but the change is not reflected on the campaign information page.</b><br>Any changes to your campaign budget will be reflected during the next billing cycle (i.e., the next month).</p></li>
<li><p><b>Why did I get charged more than my budget?</b><br>Occasionally there are charges applied by the search engines after your budget has been used up. This rarely occurs, and will generally be constrained to several dollars over your budget. Any overages will be reflected on your next month''s bill.</p></li>
<li><p><b>What if I am not using the tool anymore and I want a refund of the remaining money on my account?</b><br>First, stop any active campaigns. Then, email help@semplest.com to request a refund. Note that you will not be able to receive a refund until the end of the current billing cycle.</p></li>
</ol>

<h3>Campaign Reporting and Communications</h3>
<ol start="24">
<li><p><b>I received an email telling me that my account has been suspended. Why?</b><br>Accounts can be suspended for a number of reasons, most often because of billing issues. Please make sure you have an updated credit card on file or email help@semplest.com to work with a representative to correct any account issues. Once the issue(s) has been corrected, the representative can un-suspend your account.</p></li>
<li><p><b>Why did I stop receiving clicks on my campaign part way through the month? I was getting a lot of traffic!</b><br>Once your campaign''s budget has been exhausted for a particular month, the campaign will be paused until the next month. If this occurs consistently, you should consider increasing your campaign budget.</p></li>
<li><p><b>How can I track my results?</b><br>You can track your results by logging into the tool and visit the "Reporting" section.</p></li>
<li><p><b>Why did I receive an email saying my campaign had been rejected?</b><br>If the ad you entered contained content objectionable to a search engine (language that is obscene, proprietary/trademarked, spam, etc.), it''s possible that the search engine will later review your ad and reject it. If this occurs, we''ll send you an email and ask you to rewrite and resubmit your ads.</p></li>
</ol>
For additional questions or concerns, please reach out to SEMplest at [help@semplest.com]'
,
'<p>SEMplest is the only SEM provider to offer even novice users a simple, "do-it-yourself" option to create search marketing campaigns that delivers effective results.</p>
<p>In just three simple steps, businesses can simultaneously purchase keywords and create ads on multiple search engines using new technologies that automate keyword selection, bidding and campaign creation. Then, let us do all the heavy lifting to manage your campaign on an ongoing basis with our proprietary bidding algorithm that constantly makes sure you are getting the best bang for your buck across Google, Bing and Yahoo!</p>
<p>We are the only SEM provider to offer</p>
<ul>
<li>Automated optimization: dynamically optimizing keyword purchases and ongoing campaign management</li>
<li>Personalization: hundreds of unique keywords purchased for each advertiser</li>
<li>Intelligent spend of money:  automatically generating and optimizing hundreds of long tail keywords which drives down advertiser expenses (lowers cost per click)</li>
<li>Transparent pricing: no hidden charges or mark-ups</li>
<li>Cost efficiencies: SEMplest''s automated technology creates lower overhead expenses</li>
</ul>
<p>It''s really as simple as one, two, three:</p>
<p>1.Briefly Describe Your Business<br>[~IMAGE_BEGIN]BrieflyDescribeYourBusiness.png[~IMAGE_END]<br>2. Create Your Ads<br>[~IMAGE_BEGIN]CreateYourAds.png[~IMAGE_END]<br>3. Launch Your Campaign<br>[~IMAGE_BEGIN]LaunchYourCampaign.png[~IMAGE_END]<br></p>
<p>Click here to schedule a demo or email info@semplest.com</p>
<p><b>SEMPLEST MANAGEMENT TEAM</b></p>
<p><b>Paul Benjou</b> - Chief Executive Officer<br>Mr. Benjou brings over 35 years of executive level management to SEMplest. Mr. Benjou has been the Founder and Principal at The Center for Media Management Strategies, a consultancy serving digital media companies and prior companies include Universal McCann, DraftWorldwide, ValueClick and Datran Media.  He serves as a Senior Fellow and Advisory Board member with the Society for New Communications Research and is a sustaining member of the American Institute for Economic Research. He served on the Board of Global Networks, Inc. and remains as an advisor.</p>
<p><b>Mitchell Berg, Ph.D.</b> - Chief Technology Officer<br>Mr. Berg has over 25 years of technology and software architecture and development experience with a focus on developing and commercializing R&D. Previous roles included Chief Information Officer of BenefitPlan Manager Corp. and Advanced Information Technologist at The Boeing Company.</p>
<p><b>Chad Miller</b> - Chief Revenue Officer<br>Mr. Miller has been in the digital and technology industry for 15 years. During most of this period he has been focused on marketing and selling technology and media services involving email, display and analytics with companies like Nielsen, Accenture and Valueclick.</p>
<p><b>Nicole Ragains</b> - Executive Vice President, Operations<br>Ms. Ragains has been in the financial and digital industries for over 11 years. Prior roles included running Corporate Development for XO Group and financial consulting for Huron Consulting Group and Arthur Andersen.</p>'
,
'<p>Need assistance? We''re here to help!</p><p>Feel free to contact us at help@semplest.com and someone will be in touch shortly.</p><p>Thank you!</p>'
,
'<!-- SET: MAIN CONTENT -->
	    		<div id="bar">Your Privacy Rights</div>
				<div class="spaceLegal" >
				Your privacy is important to us.  We have created this privacy policy ("Policy") to explain the types of information we collect through the Web sites, online services, applications and social networking platforms on which it is posted (each referred to herein as a "Site"), as well as how we will use, disclose and protect this information once it is collected, and what choices you may have in connection with some of our uses and disclosures of your information.  By visiting this Site, you agree to the terms of this Policy as they may be amended from time to time.
				<br /><br />
				Here are a few general principles to keep in mind as you read through this Policy:
				<br /><br />
				<ul>
					<li>This Site is owned or operated by SEMplest LLC or one of its subsidiaries (referred to collectively in this policy as "SEMplest," "we," "us," "our" and other similar pronouns).  
					<li>As our business evolves, this Policy may change, so check back to this page periodically to make sure you understand how your Personal Information will be treated.
					<li>This Policy is incorporated into, and part of, our <a href="/TermsOfUse">Terms of Use</a>, which governs your use of the Site as a whole.  Additionally, this Policy may be supplemented from time to time by other terms that apply to specific Sites.  
					<li>Unless otherwise specified, this Policy <u>does not</u> apply to information that you may provide to us, or that we may obtain, other than from you through our Site, such as over the phone, by mail, or in person. 
				</ul>
				<br />
				<b>Opt In and Opt Out</b><br />
				You may have the right to opt in to or opt out of certain of our uses and disclosures of your Personal Information.  For example, when you are asked to provide Personal Information on our Sites, you may have the opportunity to elect to, or not to, receive promotional messages from us by e-mail.  You may unsubscribe from our promotional emails by clicking on the opt-out link within the e-mail you receive. Please understand that it may take us some time to process any opt out request and that even if you opt out of receiving promotional correspondence from us, we may still contact you in connection with your relationship, activities, transactions and communications with us.  
				<br /><br />
				<b>What information is collected on this Site?</b>
				<br /><br />
				<b><i>Personal Information</i></b><br />
				"Personal Information" is information that can be used to identify you or contact you as an individual, as well as information attributed with such information.  We collect Personal Information such as your name; age or date of birth; postal address; e-mail address; telephone number; wireless device address (including text message address); screen name or username; photograph; gender; credit card and other payment information; wedding and event related information; information about your family; and interests, hobbies and demographic information.  We collect Personal Information via the Site in a variety of circumstances, such as when you conduct a transaction on our Site; create an account on our Site; edit your online profile; sign up for our newsletters; sign-up for certain services; make online purchases; enter sweepstakes and contests; complete surveys; contribute to a chat room, bulletin board, message board, list serve, blog, wiki or other social forum on the Site; or submit a comment or question to us by using a "contact us" or similar feature on the Site.  On some of our Sites, you may not be able to participate in certain activities or access certain content, unless you provide us with the requested Personal Information.
				<br /><br />
				<b><i>Site Usage Information</i></b><br />
				As is the case with many Web sites, our servers automatically collect your IP address when you visit the Site, and we may associate that with your domain name or that of your Internet access provider. IP addresses are not linked to Personal Information. We may also capture certain "clickstream data" pertaining to your usage of and navigation around the Site.  Clickstream data includes, for example, information about your computer or device, Web browser and operating system and their settings, the referring page that linked you to the Site, the pages or ads you see or click on during your visit and when and for how long you do so, items you download, the next Web site you visit when you leave the Site, and any search terms you have entered on the Site or a referral site.  All of this information is used for a variety of purposes, including, for example, to gather aggregated demographic or statistical information.
				<br /><br />
				In addition, we may deploy various tracking technologies on the Site to collect additional information about your Site visits.  These technologies may enable us to, for example, assign a unique number to you, to collect information about your usage of our Site, administer the Site and our systems, and to relate such Site usage information to other information about you, including your Personal Information. <b>By using our Site, you agree to our use of these tracking technologies. </b>  Examples of the types of tracking technologies deployed on the Site may include the following: <br /><br />
				<ul>
					<li>"Cookies" are small data files stored on your computer or device at the request of a Web site.  In addition to the general purposes listed above, cookies enable us to recognize you at our Site, to enhance your experience on the Site (for example, by storing your username) and/or to collect general usage and aggregated statistical information.  Most browsers can be set to detect cookies and give you an opportunity to reject them, but refusing cookies may, in some cases, limit your use of the Site or its features.  To learn more about the use of cookies, including how to manage or delete them, click here.
					<li>"Local shared objects," such as "Flash cookies," may be stored on your computer or device using a media player or other software installed on your computer or device.  Local shared objects operate a lot like cookies, but cannot be managed in the same way.  Depending on how local shared objects are enabled on your computer or device, you may be able to manage them using software settings.  For information on managing Flash cookies, for example, click here.  
					<li>A "pixel tag" (also known as a "clear GIF" or "web beacon") is a tiny image - typically just one-pixel - that can be placed on a Web page or in our electronic communications to you in order to help us measure the effectiveness of our content by, for example, counting the number of individuals who visit us online or verifying whether you''ve opened one of our emails or seen one of our Web pages. 
					<li>"HTML5" (the language some Web sites, such as mobile Web sites, are coded in) may be used to store information on your computer or device about your Site usage activities and to help determine how our Site is being used by our visitors, how it can be improved, and to customize it for our users.
					<li>"Cache cookies," such as eTags, may be used to identify your computer or device as the same computer or device that visited our Site or another web site in the past. 
					<li>"Browser history sniffing" may be used to enable us to detect whether you have visited a Web page of ours or of someone else''s in the past by determining whether its URL is located in the list of URLs stored in your Web browser''s history file. 
					<li>"Browser fingerprinting" can enable us to recognize your computer or device as the same one that has been used to visit our Site in the past based on various detectable information from your computer or device that, together, can be used as a "fingerprint" of your computer or device. 
				</ul>
				<br />
				The above tracking technologies may be deployed by us or our service providers on our behalf.  For example, we currently use, and/or in the future may use Coremetrics, Google Analytics, Comscore and/or other third party vendors, to collect Site usage information and track traffic to, from and around the Sites.  
				To find out more about how your Site usage information is collected through the Google Analytics tools, <a href=" http://www.google.com/intl/en/analytics/privacyoverview.html ">click here</a>, and to find out information about Coremetrics'' practices, <a href="http://www.coremetrics.com/company/privacy.php#services">click here</a>.  You may be able to opt-out of certain collection by Google Analytics by <a href="http://tools.google.com/dlpage/gaoptout?hl=en">clicking here</a>, and for Coremetrics'' opt-out options, <a href="http://www.coremetrics.com/company/privacy.php#optout">click here</a>.
				<br /><br />
				<b>How we may use your information</b><br />
				We (or one of our service providers, on our behalf) may use your information (including your Personal Information and Site usage information) for a variety of purposes, such as the following:
				<br /><br />
				<ul>
					<li>processing and fulfilling your transactions
					<li>administering the Site, the Site''s features and services, and your account(s) with us 
					<li>enabling users to use the Site and the Site''s features and services
					<li>responding to and addressing your requests, questions, and concerns 
					<li>developing new features and offerings on the Site
					<li>sending you marketing and other communications, including information about products, <li>services, and events, of ours and of others, that we think might interest you 
					<li>protecting our rights and property  
					<li>customizing the Site to your interests and history with us
					<li>tailoring ads displayed to you on our Site and elsewhere to your interests and history with us
					<li>other purposes described at the time you choose to provide Personal Information to us
				</ul>
				<br />
				To perform the above functions, we may match information collected from you through different means or at different times, including both Personal Information and Site usage information (to the extent permitted hereunder, and use such information along with information obtained from other sources (including third parties) such as demographic information and updated contact information.  We or our service providers may also use your information to assess the level of interest in, and use of, the Site, our e-mails and our other messaging campaigns both on an individual basis and in the aggregate.
				<br /><br />
				<b>How we may share Personal Information and Site usage information with others?</b><br />
				We may share Personal Information and Site usage information with others for a variety of reasons.  In addition to the kinds of information sharing you might expect, such as sharing with third-party providers who need your information in order to provide services to us, and sharing what you voluntarily post to public areas on the Site with other Site users, we may share your information:
				<br /><br />
				<ul>
					<li>when we believe in good faith that disclosure is necessary to protect our rights or property, protect your safety or the safety of others, investigate fraud or respond to a government, judicial or other legal request, or to comply with the law
					<li>in connection with a corporate change or dissolution, including for example a merger, acquisition, reorganization, consolidation, bankruptcy, liquidation, sale of assets, or wind-down of a business, and such third party will be required to use the information shared in accordance with this Policy
				</ul>
				<br />
				In addition, we may share non-personally identifiable Site usage information (including aggregate data) with others, for their use, in a form that does not include your name or contact information. 
				<br /><br />
				<b>Third-Party Ad Servers and Networks</b><br />
				We currently do not use third-party advertising companies to serve ads when you visit our Site, but may do so in the future. These companies may use information about your visits to this Site and other Web sites in order to provide advertisements about goods and services of interest to you.  These advertisements may appear on this Site and on other Web sites.  These companies may employ cookies, clear GIFs and other tracking technologies to cause relevant ads to be displayed to you.  We encourage you to read these businesses'' privacy policies to learn about how they treat your information.  For more information about third-party advertisers and how to prevent them from using your information, visit the NAI''s consumer Web site at <a href="http://www.networkadvertising.org/consumer/">http://www.networkadvertising.org/consumer/</a>.
				<br /><br />
				<b>Your Access Rights</b><br />
				You may be able to review and update your PII and other information by logging into the Site and visiting the "My Account" (or similar) area.  You also may be able to review and update your communication preferences in your online account profile.  If you would like to deactivate your membership with us, you should contact SEMplest LLC by emailing <b><a href=mailto:privacy@semplest.com> privacy@semplest.com</a></b> and writing "Deactivate Membership" in the subject line.  You may also write to SEMplest LLC at 195 Broadway, 25th Floor, New York NY 10007 or call us at 212.219.8555.  Please note that your right to delete your information is subject to our records retention policies and applicable law, including any statutory retention requirements.
				<br /><br />
				<b>Security</b><br />
				We use various efforts intended to safeguard the security and integrity of Personal Information collected on this Site.  For example, where appropriate, we use Secure Sockets Layer (SSL), private networks, intrusion detection measures and firewalls, and encrypted password protection.  We also have in place various access controls and restrictions with respect to Personal Information, such as restricting certain employees from accessing Personal Information, requiring our employees to use password-protected screen-savers when they leave their desk and passwords to regain access upon their return, and keeping employees up-to-date on our security and privacy practices.  Additionally, the servers that we store Personal Information on are kept in a secure environment, subject to various physical access controls.  Despite these measures, however, no system or entity can guarantee that information will be absolutely safe from unauthorized intrusion.  
				<br /><br />
				If you correspond with us by e-mail, text message, or using Web forms like a "contact us" feature on our Site, you should be aware that your transmission might not be secure from access by unauthorized parties. We have no liability for disclosure of your information due to errors or unauthorized acts of third parties during or after transmission. If you create an account on our Site, you are responsible for maintaining the confidentiality of your account password and for any activity that occurs under your account.  Please notify us of any unauthorized use of your password or account.  If we believe that the security of your Personal Information in our care may have been compromised, we may seek to notify you.  If we have your e-mail address, we may notify you by e-mail. <b>You consent to our use of e-mail as a means of such notification.  If you prefer for us to use the U.S. Postal Service to notify you in this situation, please e-mail us at privacy@semplest.com. </b>
				<br /><br />
				<b>Links to other Web sites</b><br />
				The Site may contain links, banners, widgets or advertisements that lead to other Web sites not subject to this Privacy Policy (including other sites that may be co-branded with SEMplest brands).  Thus, the posted policies of these other sites will govern the collection and use of your information thereon, and we encourage you to read each such privacy statement to learn about how your information may be treated by others.  Additionally, one some of our Sites, you may be able to register with or purchase directly from third party retailers, and these other companies'' information practices are governed by their privacy policies.
				<br /><br />
				<b>Children under the Age of 13</b><br />
				The Site is not intended for children under 13 years of age.  We do not knowingly collect or store any personally identifiable information about children under the age of 13.  If you are under 13, please do not register on the Website, make purchases through the Website or send any information about yourself to us, including your name, address, telephone number or email address.  If you believe that we might have any information from or about a child under the age of 13, please contact us at <b><a href=mailto:privacy@semplest.com> privacy@semplest.com</a></b>.
				<br /><br />
				<b>Changes to this Policy</b><br />
				We may change this Policy from time to time, and we will let you know by posting the changed Policy on this page with a new "Last Updated" date.  When we do, and such change reflects a change to our information practices that affect your Personal Information (including any material changes), we will notify you by email, and you may opt-out of this change by sending a message to <b><a href=mailto:privacy@semplest.com> privacy@semplest.com</a></b>. We will also post the changes in our Policy 30 days prior to a change. 
				<br /><br />
				<b>Contact Us</b><br />
				If you have any questions or comments, you may contact us at: SEMplest LLC, by email at <b><a href=mailto:privacy@semplest.com> privacy@semplest.com</a></b>, by postal mail at 195 Broadway, Floor 25, New York, NY 10007, or by phone at 212.219.8555.  Please indicate in the subject line of your communication the purpose for your question or comment (for example, if your question or comment is about this Policy or our privacy practices, please put "Privacy Policy" in the subject line of your communication, and if your question or comment is regarding your membership, please put "Membership" in the subject line).
				<br /><br />
				Last Updated:  May 25, 2012	
				</div>	

    		<!-- END: MAIN CONTENT -->
'
,
'    		<!-- SET: MAIN CONTENT -->
	    		<div id="bar">Website Terms of Use</div>
				<div class="spaceLegal">
				The following terms and conditions (the "Terms of Use") govern your use of semplest.com and the subdomains thereof (the "Site). The Site is made available, managed or operated by SEMplest LLC or one of its subsidiaries (referred to collectively in this policy as "SEMplest," "we," "us," "our" and other similar pronouns).
				<br /><br />
				We may change these Terms of Use from time to time, by posting such changes on the Site, and such changes will be effective upon any further use of the Site.  BY USING THE SITE, YOU ACCEPT AND AGREE TO BE BOUND BY THESE TERMS OF USE. IF YOU DO NOT AGREE TO THESE TERMS OF USE, PLEASE DO NOT ACCESS OR OTHERWISE USE THE SITE.
				<br /><br />
				<b>PRIVACY AND PROTECTION OF PERSONAL INFORMATION</b>
				<br /><br />
				You may choose to submit certain personally identifiable information to us via the Site for various purposes.  When submitting information to the Site, you agree to provide only true, accurate, current and complete information, and you accept all responsibility for all activities that occur under your information. See our Site <a href="/PrivacyPolicy">Privacy Policy</a> for our policies relating to our collection and use of your information via the Site.  The Privacy Policy is incorporated into these Terms of Use by this reference. <br /><br />
				<b>PROPRIETARY RIGHTS</b>
				<br /><br />
				The information and materials on the Site (including, without limitation, content, text, data, graphics, logos, images, photographs, designs, software code and files) (the "Materials") are provided by us and others, and may be protected by copyright, trademark, trade dress and other laws. You may only use the Materials for your informational and non-commercial purposes only. You may not use the Site or Materials for a purpose not expressly authorized in the Materials or these Terms of Use without our prior written permission. Ownership of the Materials and all proprietary rights in the Materials shall at all times remain, as between you and us, with us. We and our licensors reserve all rights not expressly granted to you herein. <br /><br />
				<b>TRADEMARKS</b>
				<br /><br />
				All trademarks, service marks, trade names, logos, and other designations (collectively the "Marks") are the sole property of SEMplest or its licensors. Nothing contained on the Site should be interpreted as granting any right or license to use any such Marks without the prior written permission of SEMplest or the respective owner(s) of the Marks displayed. <br /><br />
				<b>SUBMITTED MATERIALS</b>
				<br /><br />
				Unless specifically requested, we do not solicit nor do we wish to receive any confidential, secret or proprietary information or other material from you through the Site, by e-mail or in any other way.  Any information, creative works, ideas, suggestions, concepts, methods, systems, designs, plans, techniques or other materials submitted, uploaded, posted or otherwise sent to us via any method ("Submitted Materials") will be deemed not to be confidential or secret, and may be used by us in any manner consistent with these Terms of Use and Site <a href="/PrivacyPolicy">Privacy Policy</a>. By submitting, posting or sending Submitted Materials to us or the Site, you: (i) represent and warrant that the Submitted Materials are original to you, that no other party has any rights thereto, and that any "moral rights" in Submitted Materials have been waived, and (ii) you grant us and our affiliates a royalty-free, unrestricted, worldwide, perpetual, irrevocable, non-exclusive and fully transferable, assignable and sublicensable right and license to use, copy, reproduce, modify, adapt, publish, translate, create derivative works from, distribute, perform, display, make, sell and export such material (in whole or part) and/or to incorporate it in other works in any form, media, or technology now known or later developed.  We cannot be responsible for maintaining any Submitted Materials that you provide to us, and we may delete or destroy any such Submitted Materials at any time.
				<br /><br />
				<b>RIGHT TO MONITOR AND EDITORIAL CONTROL</b>
				<br /><br />
				We reserve the right (but do not have nor assume any obligation) to monitor and/or review all information and materials submitted to the Site.  We are not responsible for any such materials.  However, we reserve the right at all times to disclose any information as necessary to satisfy any law, regulation or government request (subject to our <a href="PrivacyPolicy">Privacy Policy</a> ) or to edit, refuse to post or to remove any information or materials, in whole or in part, that in our sole discretion, are objectionable or in violation of these Terms of Use, any of our policies or applicable law.  <br /><br />
				<b>PROHIBITED USER CONDUCT</b>
				<br /><br /> 
				You agree that, while using the Site, the Materials and/or the various services and features offered on or through the Site, you shall not:
				<br /><br />
				<ul class="letter">
					<li>impersonate any person or entity or misrepresent your affiliation with any other person or entity; 
					<li>obtain or attempt to gain unauthorized access to other computer systems, Materials, information or any services made available on or through the Site through any means, or obtain or attempt to obtain any materials or information through any means not intentionally made publicly available or provided for through the Site; 
					<li>engage in spidering, "screen scraping," "database scraping," harvesting of e-mail addresses or other contact or personal information, or any other automatic means of accessing, logging-in or registering on the Site or for any services available on the Site, or obtaining lists of users or obtaining or accessing other information or features on the Site, including, without limitation, any information residing on any server or database connected to the Site; 
					<li>use the Site, the Materials or the services on the Site in any manner that could damage, disable, overburden, or impair the Site or such services, or interfere with another party''s use and enjoyment thereof, including, without limitation, sending mass unsolicited messages or "flooding" servers with requests; 
					<li>use the Site, the Materials or the Site''s services or features in violation of SEMplest''s or any third party''s intellectual property or other proprietary or legal rights; 
					<li>use the Site, the Materials or the Site''s services or features in violation of any applicable law; 
					<li>attempt (or encourage or support any one else''s attempt) to circumvent, reverse engineer, decrypt, or otherwise alter or interfere with the Site, any Materials or the Site''s services, or make any unauthorized use thereof; 
					<li>upload, post, transmit, distribute or otherwise publish to, on or through the Site, any information, content or materials which are false, fraudulent, misleading, unlawful, threatening, abusive, harassing, hateful, racially, ethnically or otherwise objectionable, libelous, defamatory, obscene, vulgar, offensive, incendiary, pornographic, profane, sexually explicit or indecent, including without limitation, any material which encourages conduct that would constitute a criminal offense, give rise to civil liability or otherwise violate any local, state, national or international law; 
					<li>use the Site or the Materials to, or in any other manner, violate, plagiarize or infringe the rights of third parties, including without limitation, copyright, trademark, trade secret, confidentiality, contract, patent, rights of privacy or rights of publicity or any other proprietary or legal right;
					<li>upload, post, publish, distribute or otherwise transmit any information or material which constitutes, contains or disseminates a virus, spyware, or other harmful component, or which contains any embedded links, advertising, chain letters or pyramid schemes of any kind; 
					<li>use, redistribute, republish or exploit any part of the Site or any Materials for any commercial or promotional purposes, or contact any other user of the Site for commercial or promotional purposes, or offer to buy or sell any product or service on or through your activities on the Site; or
					<li>alter, edit, delete, remove, fail to display, otherwise change the meaning or appearance of, or repurpose any of the Materials (or attempt to do any of the foregoing), including, without limitation, any trademarks, trade names, logos, service marks, promotional taglines, or any other proprietary content or proprietary rights notices included therein or thereon.
				</ul>
				<br />
				<b>INDEMNIFICATION</b>
				<br /><br />
				You agree to defend, indemnify and hold us and our directors, officers, employees and agents harmless from any and all claims, liabilities, costs and expenses, including reasonable attorneys'' fees, arising in any way from (i) your use of the Site or the Materials, (ii) your Submitted Materials, in whole or in part, or (ii) your breach or violation of any applicable law or these Terms of Use.  We reserve the right, at our own expense, to assume the exclusive defense and control of any matter otherwise subject to indemnification by you, and in such case, you agree to cooperate with any such defense. <br /><br />
				<b>LINKS TO OTHER WEBSITES </b>
				<br /><br />
				The Site may contain links (including, for example, in the form of hyperlinks, logos, banners and widgets) to, or be linked from, other websites or online services. We are not responsible for and do not accept responsibility for or make any representations regarding such other websites, the contents of those websites, or their privacy policies, and you acknowledge that any such links do not necessarily constitute an endorsement, approval or sponsorship thereof by us. All rules, policies (including privacy policies) and operating procedures of such other websites will apply to you while on those other websites. <br /><br />
				<b>DISCLAIMER OF WARRANTIES</b>
				<br /><br />
				THE SITE, INCLUDING, WITHOUT LIMITATION, ALL SERVICES, FORUMS, CONTENT, FUNCTIONS, DOWNLOADS AND MATERIALS, ARE PROVIDED "AS IS," "AS AVAILABLE," WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING, WITHOUT LIMITATION, ANY WARRANTY FOR INFORMATION, DATA, DATA PROCESSING SERVICES, UPTIME OR UNINTERRUPTED ACCESS, ANY WARRANTIES CONCERNING THE AVAILABILITY, ACCURACY, USEFULNESS, CORRECTNESS, PRECISION, THOROUGHNESS, COMPLETENESS OR CONTENT OF INFORMATION, AND ANY WARRANTIES OF TITLE, NON-INFRINGEMENT, MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE, AND SEMPLEST HEREBY DISCLAIMS ANY AND ALL SUCH WARRANTIES, EXPRESS AND IMPLIED.  SEMPLEST DOES NOT WARRANT THAT THE SITE, THE SERVICES, THE FORUMS OR THE SITE MATERIALS WILL BE TIMELY, SECURE, UNINTERRUPTED OR ERROR FREE, OR THAT DEFECTS WILL BE CORRECTED IN A TIMELY MANNER OR AT ALL.  SEMPLEST MAKES NO WARRANTY THAT THE SITE, IN WHOLE OR IN PART, WILL MEET USERS'' REQUIREMENTS.  NO ADVICE, RESULTS OR INFORMATION, WHETHER ORAL OR WRITTEN, OBTAINED BY YOU FROM SEMPLEST, OR FROM OR THROUGH THE SITE, SHALL CREATE ANY WARRANTY NOT EXPRESSLY MADE HEREIN.  SEMPLEST ALSO ASSUMES NO RESPONSIBILITY, AND SHALL NOT BE LIABLE FOR, ANY DAMAGES TO, OR VIRUSES THAT MAY INFECT, YOUR COMPUTER EQUIPMENT OR OTHER PROPERTY ON ACCOUNT OF YOUR ACCESS TO, USE OF, OR BROWSING IN THE SITE OR YOUR DOWNLOADING OR UPLOADING OF ANY MATERIALS, DATA, TEXT, IMAGES, VIDEO, OR AUDIO FROM THE SITE.  IF YOU ARE DISSATISFIED WITH THE SITE, YOU SHOULD DISCONTINUE USING THE SITE.  SEMPLEST DOES NOT NECESSARILY ENDORSE, SUPPORT, SANCTION, ENCOURAGE OR AGREE WITH ANY SITE MATERIALS OR ANY SUBMITTED MATERIALS, OR ANY OPINION, RECOMMENDATION, OFFER, INFORMATION, CONTENT, LINK, DATA OR ADVICE EXPRESSED OR IMPLIED THEREIN, AND SEMPLEST EXPRESSLY DISCLAIMS ANY AND ALL LIABILITY IN CONNECTION WITH ANY SUBMITTED MATERIALS AND ANY OTHER CONTENT, MATERIALS, OFFERS OR INFORMATION AVAILABLE ON OR THROUGH THE SITE CREATED OR PROVIDED BY USERS OR OTHER THIRD PARTIES.  USE OF THE SITE, CREATION OF AN ACCOUNT OR THE SUBMISSION OF ANY SUBMITTED MATERIALS DOES NOT GUARANTEE ACCEPTANCE OR USE THEREOF.
				<br /><br />
				WITHOUT LIMITATION OF THE ABOVE IN THIS SECTION, SEMPLEST AND ITS AFFILIATES, SUPPLIERS AND LICENSORS MAKE NO WARRANTIES OR REPRESENTATIONS REGARDING ANY PRODUCTS OR SERVICES ORDERED OR PROVIDED VIA THE SITE, AND HEREBY DISCLAIM, AND YOU HEREBY WAIVE, ANY AND ALL WARRANTIES AND REPRESENTATIONS MADE IN PRODUCT OR SERVICES LITERATURE, FREQUENTLY ASKED QUESTIONS DOCUMENTS AND OTHERWISE ON THE SITE OR IN CORRESPONDENCE WITH SEMPLEST OR ITS AGENTS.  ANY PRODUCTS AND SERVICES ORDERED OR PROVIDED VIA THE SITE ARE PROVIDED BY SEMPLEST (OR ITS LICENSORS OR THIRD PARTY PROVIDERS OR SUPPLIERS) "AS IS", EXCEPT TO THE EXTENT, IF AT ALL, OTHERWISE SET FORTH IN A LICENSE OR SALE AGREEMENT SEPARATELY ENTERED INTO IN WRITING BETWEEN YOU AND SEMPLEST OR ITS LICENSOR OR SUPPLIER.
				<br /><br />
				<b>LIMITATION OF LIABILITY</b>
				<br /><br />   
				IN NO EVENT, INCLUDING BUT NOT LIMITED TO NEGLIGENCE, SHALL SEMPLEST, OR ANY OF ITS AFFILIATES, DIRECTORS, OFFICERS, EMPLOYEES, AGENTS OR CONTENT OR SERVICE PROVIDERS (COLLECTIVELY, THE "PROTECTED ENTITIES") BE LIABLE FOR ANY DIRECT, INDIRECT, SPECIAL, INCIDENTAL, CONSEQUENTIAL, EXEMPLARY OR PUNITIVE DAMAGES ARISING FROM, OR DIRECTLY OR INDIRECTLY RELATED TO, THE USE OF, OR THE INABILITY TO USE, THE SITE OR THE CONTENT, MATERIALS AND FUNCTIONS OF OR RELATED THERETO, YOUR PROVISION OF INFORMATION OR CONTENT VIA THE SITE, LOST BUSINESS OR LOST SALES, EVEN IF SUCH PROTECTED ENTITY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.  SOME JURISDICTIONS DO NOT ALLOW THE LIMITATION OR EXCLUSION OF LIABILITY FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES, SO SOME OF THE ABOVE LIMITATIONS MAY NOT APPLY TO CERTAIN USERS.  IN NO EVENT SHALL THE PROTECTED ENTITIES BE RESPONSIBLE OR LIABLE FOR OR IN CONNECTION WITH ANY DISPUTE OR OTHER ISSUE BETWEEN OR AMONGST USERS OF THE SITE, OR IN CONNECTION WITH ANY INFORMATION, CONTENT OR MATERIALS POSTED, TRANSMITTED, EXCHANGED OR RECEIVED BY OR ON BEHALF OF ANY USER OR OTHER PERSON ON OR THROUGH THE SITE.  IN NO EVENT SHALL THE TOTAL AGGREGATE LIABILITY OF THE PROTECTED ENTITIES TO YOU FOR ALL DAMAGES, LOSSES, AND CAUSES OF ACTION (WHETHER IN CONTRACT OR TORT, INCLUDING, BUT NOT LIMITED TO, NEGLIGENCE OR OTHERWISE) ARISING FROM THESE TERMS OF USE OR YOUR USE OF THE SITE EXCSEMPLEST FOR YOUR USE OF THE SITE, OR (B) TEN DOLLARS ($10).  ALL USERS OF THE SITE UNDERSTAND AND AGREE THAT (I) THE MUTUAL AGREEMENTS MADE IN THIS SECTION REFLECT A REASONABLE ALLOCATION OF RISK, AND (II) THE PARTIES HERETO WOULD NOT HAVE ENTERED INTO THESE TERMS OF USE WITHOUT THESE LIMITATIONS ON LIABILITY.
				<br /><br />  
				<b>TERMINATION</b>
				<br /><br />
				We reserve the right any time and from time to time to modify or discontinue, temporarily or permanently, the Site (or any portion thereof) with or without notice.  We may terminate, change, suspend or discontinue any aspect of the Site at any time.  We may restrict, suspend or terminate your access to the Site, to any Materials and/or its services (including, without limitation, any Forum) if we believe you are in breach of these Terms of Use or applicable law, or for any other reason without notice or liability.  We maintain a policy that provides for the termination in appropriate circumstances of the Site''s use privileges of users who are repeat infringers of intellectual property rights.
				<br /><br />
				<b>JURISDICTIONAL ISSUES; MISCELLANEOUS</b>
				<br /><br />
				The Site is intended for users who are located in the United States of America.  We do not represent that materials on the Site are appropriate or available for use in other locations.  Persons who choose to access the Site from other locations do so on their own initiative, and are responsible for compliance with local laws, if and to the extent local laws are applicable. These Terms of Use shall be governed by and construed in accordance with the laws of the State of New York, without regard to such state''s rules regarding conflicts of laws. By accessing the Site, you agree that courts located in New York shall have exclusive jurisdiction over all claims and actions arising out of or relating to these Terms of Use and/or your use of the Site, and you further agree and submit to the exercise of personal jurisdiction of such courts and consent to extra-territorial service of process for the purpose of litigating any such claim or action. These Terms of Use constitute the entire agreement between you and SEMplest with respect to the Site and supersede all prior communications and proposals between you and SEMplest with respect to the Site. If any part of these Terms of Use is held invalid or unenforceable, that portion shall be interpreted in a manner consistent with applicable law to reflect, as nearly as possible, the original intentions of the parties, and the remaining portions shall remain in full force and effect. <br /><br />
				<b>COPYRIGHT</b>
				<br /><br />
				We respect the intellectual property rights of others, and require that the people who use the Site do the same.  If you believe that your work has been copied in a way that constitutes copyright infringement, please forward the following information to our Copyright Agent, designated as such pursuant to the Digital Millennium Copyright Act, 17 U.S.C. § 512(c)(2) (the "DMCA"), named below:
				<br /><br />
				<ul>
					<li>Your address, telephone number, and email address; 
					<li>A description of the copyrighted work that you claim has been infringed; 
					<li>A description of where the alleged infringing material is located; 
					<li>A statement by you that you have a good faith belief that the disputed use is not authorized by the copyright owner, its agent, or the law; 
					<li>An electronic or physical signature of the person authorized to act on behalf of the owner of the copyright interest; and 
					<li>A statement by you, made under penalty of perjury, that the above information in your notice is accurate and that you are the copyright owner or authorized to act on the copyright owner''s behalf. 
				</ul>
				<br />
				Copyright Agent:
				<br /><br />
				Executive Vice President<br />
				SEMplest LLC<br />
				195 Broadway, Floor 25<br />
				New York, New York 10007<br />
				phone: 212.219.8555<br />
				Email: <a href=mailto:copyright@semplest.com>copyright@semplest.com</a>
				<br /><br />
				Last Updated: May 25, 2012	
				</div>	
    		<!-- END: MAIN CONTENT -->'
,
'<p><b>By using these services, you agree to the terms of the agreement below:</b></p>
<p>UPDATED ON JUNE 12, 2012</p>
<p>PLEASE SCROLL DOWN AND READ THE SERVICES AGREEMENT BELOW</p>
<p>This Services Agreement (this “Agreement”) govern your use of our services, and unless other terms and conditions expressly govern, any other electronic services that may be made available by SEMplest LLC or its affiliates (“we”, “us” or “our”) from time to time (each, a "Service"). </p>
<p>By using or accepting a Service, you agree to be bound by the terms and conditions contained in this Agreement.</p>
<ol>
<li>Changes to Services Agreement. We may change the terms of this Agreement at any time by notifying you of the change in writing or electronically (which may be by email, by posting a notice on the Service that the terms have been “updated” or other reasonable means). The changes also will appear in this document, which you can access at any time by going to the Services Agreement footer in the SEMplest application. You signify that you agree to be bound by such changes by using a Service after changes are made to this Agreement.</li>
<li>Privacy and Your Account. Registration data and other information about you and your account  are subject to our Privacy Policy and Terms of Use found at www.semplest.com/privacypolicy and www.semplest.com/termsofuse, respectively, as updated from time to time, which are hereby incorporated by reference and apply to all users in accordance with this Agreement. By registering or using any Service, you hereby agree to our collection and usage of your personal information and acknowledge that you have read and accept the above-referenced Privacy Policy and Terms of Use.</li>
<li>Fees and Payments. You agree to pay the subscription fees and any other charges incurred in connection with your user name and password for a Service (including any applicable taxes) at the rates in effect when the charges were incurred. If your subscription includes access to areas containing premium services, your access to such areas may be subject to additional fees, terms and conditions, which will be separately disclosed in such areas. Unless otherwise agreed in writing, we will bill all charges automatically to your debit or credit card. Subscription fees will be billed at the beginning of your subscription or any renewal. If the full designated advertisement amount for a particular month or months are not fully used for advertisements, we may use such amounts for advertisements in subsequent months, and, if after six months the total amount designated for advertisement during such six-month period (regardless of the monthly allocations) is not used, then we will refund the amount that remains unused. If you elect to cancel the Services without utilizing the fully allocated pre-paid fees designated for advertisements, we will refund such unused amounts to you. If you suspend the Services, we will not renew the advertisement amounts/charge for the advertisements during the suspension period, and will resume the Services, subscription period and charges based on the date you elect to resume the Services (as opposed to the initial subscription date). No refunds for amounts under $5 will be made unless and until the aggregate refund amount exceeds $5. Unless otherwise stated in writing herein, all fees and charges are nonrefundable. We may change the fees and charges then in effect, or add new fees or additional fees, terms and conditions, which will be separately disclosed in such areas. We will bill all charges automatically to your debit or credit card. If you want to use a different debit or credit card or there is a change in debit or credit card validity or expiration date, or if you believe someone has accessed a Service using your user name and password without your authorization, you must follow the procedures outlined in the Terms of Use. You are responsible for any fees or charges incurred to access a Service through an Internet access provider or other third-party service.</li>
<li>Renewal. If applicable, your subscription will renew automatically, unless we terminate it or you notify us by telephone, mail, or e-mail (receipt of which must be confirmed by email reply from us) of your decision to terminate your subscription. You must cancel your subscription before it renews in order to avoid billing of subscription fees for the renewal term to your debit or credit card, subject to applicable law.</li>
<li>Limitations on Use.<ol style = "list-style-type: lower-alpha;"><li>Only one individual may access a Service at the same time using the same user name or password, unless we agree otherwise.</li><li>. In consideration of your using our Service, you represent that you are able to form a binding contract. You also agree to that any information you provide about yourself is accurate and complete information at the time provided. You agree to timely update any information provided to us to keep it accurate and complete. Failure to accurately and completely provide, and timely update, information about yourself is reasonable grounds for us to suspend or terminate your account and refuse you service in the future.</li><li>In addition to this Agreement, when using a particular Service, you are also bound by the posted guidelines and rules for that particular Service, if applicable.</li><li>Certain names, logos, and/or phrases in the Service may constitute our or third party trademarks and/or copyrights. The mark "SEMplest" and the contents of the Service are the sole property of SEMplest LLC. Reproduction in whole or in part is strictly prohibited without our express written permission.</li><li><b>All of the writing in the Service, including without limitation any tools and any key words we generate, are the copyrighted property of SEMplest LLC, and is protected as such. None of the materials may be reproduced without our written permission. Such materials may not be used or reproduced in any form. Any reproduction, editing or other use by any means mechanical or electronic without our explicit written permission is expressly prohibited.</b></li><li>We reserve the right from time to time to make modifications and changes to our Services. These modifications and changes may include, but are not limited to, discontinuing, temporarily or permanently, any service offered by, or through our Services (or any part thereof) with or without notice. You agree that we shall not be liable to you or to any other party for any changes and modifications to our Services.</li><li>You agree that, under certain circumstances and without prior notice, we may terminate your access to the Services, including purging your member account and any material and information associated with your member account (including your user name, password, and profile). Cause for such termination shall include, but not be limited to, violation of the provisions set forth in this Agreement. You acknowledge and agree that all terminations for cause shall be made in our sole discretion, and that we shall not be liable to you or any other party for the termination of your access to our Services or the purging of any material.</li></ol></li>
<li>License Grant. You hereby grant to us and agree that we do and will have a nonexclusive global license to publish the content submitted by users and contributors within the Services. You hereby grant to us and agree that we do and will also have global nonexclusive adaptation and resale rights over any content and material submitted by users and contributors within our Services. These nonexclusive publishing license and resale/adaptation rights extend to any materials submitted "for publication" within our Services. We and our staff are not and will not be responsible for any misleading, false, or otherwise injurious information and advice communicated in any area of our Services or for any results obtained from the use of such information. We will not be liable for any loss or damage suffered by a user through the user''s reliance on information gained in any area of our Services.</li>
<li>Third Party Web Sites, Services and Software. We utilize and may link to, or promote, web sites or services from other companies. You agree that we are not responsible for, and do not control, these web sites or services.</li>
<li>DISCLAIMERS OF WARRANTIES AND LIMITATIONS ON LIABILITY.<p>YOU EXPRESSLY UNDERSTAND AND AGREE THAT:</p><p>YOUR USE OF OUR AREA IS AT YOUR SOLE RISK. THE SERVICES PROVIDED ARE PROVIDED ON AN "AS IS" AND "AS AVAILABLE" BASIS. WE EXPRESSLY DISCLAIM ALL WARRANTIES OF ANY KIND, WHETHER EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT.</p><p>WE MAKE NO WARRANTY THAT: (i) THE SERVICE WILL MEET ANY OF YOUR REQUIREMENTS, (ii) THE SERVICE WILL BE TIMELY, SECURE, UNINTERRUPTED, OR FREE FROM ERROR OR OMISSION, (iii) THE RESULTS THAT MAY BE OBTAINED FROM THE USE OF ANY SERVICE IN OUR AREA WILL BE USEFUL, ACCURATE OR RELIABLE, (iv) THE QUALITY OF ANY PRODUCTS, SERVICES, INFORMATION, OR OTHER MATERIAL PURCHASED OR OBTAINED BY YOU THROUGH THE SERVICES OFFERED IN OUR AREA WILL MEET YOUR EXPECTATIONS, AND (V) ANY ERRORS IN THE OPERATION OF AREA INCLUDING THE OPERATION OF ANY SOFTWARE WILL BE CORRECTED.</p><p>NO ADVICE OR INFORMATION, WHETHER ORAL OR WRITTEN, OBTAINED BY YOU FROM US OR FROM ANY SERVICE PROVIDED BY US SHALL CREATE ANY WARRANTY NOT EXPRESSLY STATED IN THIS AGREEMENT.</p><p>SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OF CERTAIN WARRANTIES OR THE LIMITATION OR EXCLUSION OF LIABILITY FOR INCIDENTAL OR CONSEQUENTIAL DAMAGES. ACCORDINGLY, SOME OF THE ABOVE LIMITATIONS IN THIS SECTION MAY NOT APPLY TO YOU.</p><p>YOU EXPRESSLY UNDERSTAND AND AGREE THAT WE SHALL NOT BE LIABLE TO YOU FOR ANY DAMAGES, DIRECT, INDIRECT, INCIDENTAL, OR OTHERWISE, INCLUDING BUT NOT LIMITED TO, DAMAGES FOR LOSS OF PROFITS, GOODWILL AND REPUTATION, OR OTHER INTANGIBLE LOSSES. THIS LIMITATION ON LIABILITY APPLIES EVEN IF WE HAVE BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.</p></li>
<li>General.<p>You agree that we may access, maintain, and disclose information you provide to us if required to do so by law or if we, in good faith, believes that such access, maintenance or disclosure is reasonably necessary to: (i) comply with any legal process; (ii) enforce this Agreement; (iii) respond to claims that any material or information posted, provided, transmitted, or otherwise made available by you violates the rights of third parties; (iv) respond to your customer service requests; or (v) otherwise protect the rights and property of us, our vendors, users and/or the general public.</p><p>You agree to indemnify and hold harmless us, our subsidiaries, affiliates, directors, shareholders, officers, agents, vendors or other partners, and employees, from any claim or demand, including attorneys'' fees, made by any third party due to or arising out of any material or information posted, provided, transmitted, or otherwise made available by you through our Services, or by your use of our Services, or by your violation of this Agreement, or your violation of the rights of another.</p><p>Sections 8 and 9 shall survive the expiration or termination of this Agreement and/or your access to the Service.</p><p>This Agreement constitutes the entire agreement between you and us and govern your use of our Services. This Agreement supersedes any prior terms of use agreements between you and us with respect to the subject matter hereof.</p><p>This Agreement and the relationship between you and us shall be governed by the laws of the State of New York without regard to its conflict of law provisions. You and we agree to submit to the personal and exclusive jurisdiction of the courts located within the county of New York, New York.</p><p>You agree that, except as otherwise expressly provided in this Agreement, there shall be no third party beneficiaries to this agreement.</p><p>Our failure t to exercise or enforce any right or provision of this Agreement shall not constitute a waiver of such right or provision. If any term or provision of this Agreement is found by a court of competent jurisdiction to be invalid, such term or provision  shall be interpreted to the fullest extent permitted by law to achieve the intent of such term or provision, and the other terms and provisions of the Terms of use shall remain in full force and effect.</p><p>You agree that your member account is non-transferable and any rights to your account or contents within your account terminate upon your death.</p><p>You agree that regardless of any statute or law to the contrary, any claim or cause of action brought by you arising out of or related to use of any Services or this Agreement must be filed within one (1) year after such claim or cause of action arose or be forever barred.</p><p>The section titles and other headings in this Agreement are for convenience only and have no legal or contractual effect.</p></li>
</ol>'

)


--Web Content QuestionMarkHelper
--Web Content QuestionMarkHelper
SET IDENTITY_INSERT [dbo].[WebContentQuestionMarkHelp] ON
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (1,'[configuration.DefaultProductGroupName]','Please type a word or phrase that best describes the over-arching category of your product or service. For example, if you are a florist, you may enter "Seasonal Events" as your category and "Wedding Flowers" or "Prom Flowers" as your Sub Category. This information will help us create a targeted advertising message to deliver you the best fit customer.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (2,'[configuration.DefaultPromotionName]','Please type a word or phrase that best describes your product or service in more detail. This information will help us create a targeted advertising message to deliver you the best fit customer. For example, if you are a florist and you entered "Seasonal Events" as your category, you may type "Wedding Flowers" or "Prom Flowers" as your Sub Category. Sub Category should be as specific as possible to help us best understand your what you are trying to advertise.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (3,'Description','Please type in words and phrases that describe, in detail, what you sell or promote. For example, if you are a florist, and your Category is "Seasonal Events" and your Sub Category is "Wedding Flowers", your description may be "beautiful, fresh wedding flowers, creative designs, gorgeous centerpieces  and  bridal bouquets, specializing in unique and exquisite floral wedding arrangements." The more descriptive, the more information we have to best understand what will draw a customer to your site.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (4,'Budget','Please enter the MONTHLY amount you would like to spend across all selected search engines. Whole dollars amounts only.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (5,'Search Engines','Please select which search engines you would like your advertisement to appear. We highly encourage advertising across all search engines.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (6,'Location','Entering a location helps target your ads to the specific geographic area in which you would like to market your services and products. You can enter an entire address or just a city/state or zip. Then select a radius (in miles) from that address that you would like your ad to appear. For example, if you are a florist in Boston, you may want to advertise your services within a 50 mile radius of your shop’s actual address. You may enter as many business addresses as necessary. For example, you may have a flower shop in Brooklyn, NY and Staten Island, NY. ')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (7,'URL','This URL will serve as the landing page for all of your ads and appears directly below your ad copy in the search results.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (8,'Ad Title','An ad title is meant to catch the eye of a consumer so they read your advertisement. Ad Copy has a maximum character limit of 25. Search engines do not allow all caps, or the use of punctuation marks in ad titles.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (9,'Ad Copy','This is your advertisement that is going to appear on the search engines. Ad Copy has a maximum character limit of 70. Offers or discounts are a great way to attract customers.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (10,'Additional Click Through','Additional click through options is a feature that lets you include additional links to other content on your site that''s different than the landing page you entered under URL. These sub links appear below your ad copy in the search results.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (11,'Negative Keywords','Adding a negative keyword to your product sub category means that your ads won''t show for searches containing that term. By filtering out unwanted impressions, negative keywords can help you reach the most appropriate prospects. For example, if you are a florist who only sells fresh flowers, you may add "silk" a negative keyword.')
INSERT INTO [dbo].[WebContentQuestionMarkHelp]([WebContentQuestionMarkHelpPK],[Title],[Copy]) VALUES (12,'Categories','Please pick the category that most closely represents your product or service. This information will help us create a targeted advertising message to deliver you the best fit customer.')
SET IDENTITY_INSERT [dbo].[WebContentQuestionMarkHelp] OFF
GO

-- Jobs
insert into Job (Name, LastSuccessfulRunTime) values ('EXPIRED_CREDENTIALS_EMAIL_SENDER', null)