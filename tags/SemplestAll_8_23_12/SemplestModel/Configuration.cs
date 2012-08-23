//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SemplestModel
{
    using System;
    using System.Collections.Generic;
    
    public partial class Configuration
    {
        public int ConfigurationPK { get; set; }
        public decimal CustomerMinOrderAmount { get; set; }
        public decimal CustomerDefaultMonthlyFlatFeeAmount { get; set; }
        public decimal CustomerDefaultPerCampaignFlatFeeAmount { get; set; }
        public decimal CustomerDefaultPerAdGroupFlatFeeAmount { get; set; }
        public decimal DefaultMediaComissionPercentage { get; set; }
        public decimal DefaultSalesPersonCommissionPercentage { get; set; }
        public decimal MinSalespersonCommissionPercentage { get; set; }
        public Nullable<decimal> MaxSalespersonCommissionPercentage { get; set; }
        public Nullable<decimal> DefalutBudgetMixPercentageGoogle { get; set; }
        public Nullable<decimal> DefalutBudgetMixPercentageBing { get; set; }
        public string DefaultSemplestBannerImageUrl { get; set; }
        public string DefaultSemplestStyleSheetUrl { get; set; }
        public Nullable<int> MaxNumberOfSitelinks { get; set; }
        public Nullable<int> LastAccountNumberUsed { get; set; }
        public Nullable<int> LastSEMplestEmployeeIDused { get; set; }
        public string DefaultEmailContactUs { get; set; }
        public string DefalutEmailContactMe { get; set; }
        public string DefaultProductGroupName { get; set; }
        public string DefaultProductPromotionName { get; set; }
        public string SamplestDevelopmentEmail { get; set; }
        public string SemplestDefaultBudgetMarkUpOrDown { get; set; }
        public Nullable<int> BillingDaysOffset { get; set; }
        public string OnErrorEmail { get; set; }
        public string MSNCampaignURL { get; set; }
        public string MSNCampagnNamespace { get; set; }
        public string MSNCustomerURL { get; set; }
        public string MSNCustomerNamespace { get; set; }
        public string MSNReportingURL { get; set; }
        public string MSNReportingNamespace { get; set; }
        public string MSNAdIntelligenceURL { get; set; }
        public string MSNAdIntelligenceNamespace { get; set; }
        public Nullable<long> MSNParentCustomerID { get; set; }
        public string MSNApiUsername { get; set; }
        public string MSNApiPassword { get; set; }
        public string MSNUserAccessKey { get; set; }
        public string AdwordsEmail { get; set; }
        public string AdwordsPassword { get; set; }
        public string AdwordsUserAgent { get; set; }
        public string AdwordsDeveloperToken { get; set; }
        public string OrbitalGatewaySalemPlatform { get; set; }
        public string OrbitalGatewayMerchantID { get; set; }
        public string OrbitalGatewayUsername { get; set; }
        public string OrbitalGatewayPassword { get; set; }
        public Nullable<int> SemplestClientAdwordsTimeoutMS { get; set; }
        public Nullable<int> SemplestClientKeywordTimeoutMS { get; set; }
        public Nullable<int> SemplestClientBiddingTimeoutMS { get; set; }
        public Nullable<int> SemplestClientMailTimeoutMS { get; set; }
        public Nullable<int> SemplestClientSchedulerTimeoutMS { get; set; }
        public Nullable<int> SemplestClientMSNTimeoutMS { get; set; }
        public Nullable<int> SemplestBiddingMaxRetry { get; set; }
        public Nullable<int> SemplestBiddingSleepPeriod { get; set; }
        public Nullable<int> SemplestBiddingSleepBackOffTime { get; set; }
        public Nullable<long> SemplestBiddingMaxMicroBid { get; set; }
        public Nullable<long> SemplestBiddingStepAboveFpCPC { get; set; }
        public Nullable<long> SemplestBiddingDefaultMicroBid { get; set; }
        public Nullable<long> SemplestBiddingMaxDefaultMicroBid { get; set; }
        public Nullable<long> SemplestBiddingStepFirst { get; set; }
        public Nullable<long> SemplestBiddingStepSecond { get; set; }
        public Nullable<long> SemplestBiddingStepRest { get; set; }
        public Nullable<int> SemplestBiddingGooglePercent { get; set; }
        public Nullable<int> ESBRegServicePort { get; set; }
        public string ESBBrokerName { get; set; }
        public Nullable<int> ESBBrokerPort { get; set; }
        public string ESBBrokerIP { get; set; }
        public Nullable<int> ESBWebServerPort { get; set; }
        public Nullable<int> ESBHeaderBufferSize { get; set; }
        public Nullable<int> ESBAsynchServletCorePoolSize { get; set; }
        public Nullable<int> ESBAsynchServletMaxPoolSize { get; set; }
        public Nullable<int> ESBAsynchServletMaxWorkInQueue { get; set; }
        public Nullable<int> ESBAsynchCallDefaultTimeoutMS { get; set; }
        public Nullable<int> ServiceESBServerPort { get; set; }
        public string ServiceESBServerIP { get; set; }
        public Nullable<int> ServicePingFrequencyMS { get; set; }
        public Nullable<int> ServiceNumberServiceThreads { get; set; }
        public string ServiceSMTP { get; set; }
        public string ESBWebServerURL { get; set; }
        public bool AdwordsUseSandbox { get; set; }
        public string SemplestEncryptionkey { get; set; }
        public string SemplestKeywordsdictfile { get; set; }
        public string SemplestKeywordsdocfile { get; set; }
        public string SemplestKeywordstwfile { get; set; }
        public string SemplestKeywordsdfile { get; set; }
        public string SemplestKeywordsbaseMultiWPath { get; set; }
        public string SemplestKeywordsnGramsSubC { get; set; }
        public string SemplestKeywordsnGramsC { get; set; }
        public string SemplestKeywordsvalidCat { get; set; }
        public string SemplestKeywordslucenedfile { get; set; }
        public string SemplestKeywordssmallhCounts { get; set; }
        public string SemplestKeywordsstoplist { get; set; }
        public Nullable<int> SemplestKeywordsnumTopics { get; set; }
        public Nullable<double> SemplestKeywordsuserInfoWeight { get; set; }
        public Nullable<int> SemplestKeywordsnumKeywordsGoogle { get; set; }
        public Nullable<int> SemplestKeywordsnumKeywordsMSN { get; set; }
        public Nullable<int> SemplestKeywordsnumThreads { get; set; }
        public Nullable<bool> DisplayTargetCPCLevel { get; set; }
        public Nullable<int> ServiceESBPingWaitMS { get; set; }
        public string AdwordsBillingAccount { get; set; }
        public Nullable<decimal> AdwordsAPICostPer1000 { get; set; }
        public Nullable<long> AdwordsValidationAccountID { get; set; }
        public Nullable<long> AdwordsValidationAdGroupID { get; set; }
        public Nullable<long> AdWordsValidationCampaignID { get; set; }
        public Nullable<int> ActivationValidForDays { get; set; }
        public Nullable<bool> MSNUseSandbox { get; set; }
        public bool DoNotLaunchAdServices { get; set; }
        public string DevelopmentEmail { get; set; }
        public Nullable<float> SemplestBiddingInitialBidBoostFactor { get; set; }
        public Nullable<int> SemplestBiddingPercentileValue { get; set; }
        public Nullable<double> SemplestBiddingMarginFactor { get; set; }
        public Nullable<long> MSNTrafficEstAccountID { get; set; }
        public Nullable<double> SemplestBiddingBudgetMultFactor { get; set; }
        public string RunMode { get; set; }
        public string RSAPrivateKeyPassword { get; set; }
        public string PGPPrivateKeyPassword { get; set; }
        public string ReminderEmailUrlPrefix { get; set; }
        public Nullable<int> BiddingServiceTargetPosition { get; set; }
        public Nullable<int> RegistrationReminderEmailDaysBack { get; set; }
        public Nullable<int> RegistrationReminderLinkAdditionalDays { get; set; }
        public string AdengineExecuteBidProcessFrequency { get; set; }
        public Nullable<double> BiddingServiceBidMultiplierForGoogleFromMSNHistory { get; set; }
        public Nullable<int> BiddingServiceGoogleVolMultiplierFromMSNHistory { get; set; }
        public Nullable<int> SemplestAdEngineReportLookbackDays { get; set; }
        public Nullable<int> MSNReportRetrievalTimeoutSecs { get; set; }
    }
}
