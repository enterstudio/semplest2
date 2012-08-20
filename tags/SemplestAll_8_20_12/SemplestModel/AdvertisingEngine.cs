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
    
    public partial class AdvertisingEngine
    {
        public AdvertisingEngine()
        {
            this.AdvertisingEngineAccounts = new HashSet<AdvertisingEngineAccount>();
            this.AdvertisingEngineAds = new HashSet<AdvertisingEngineAd>();
            this.AdvertisingEngineReportDatas = new HashSet<AdvertisingEngineReportData>();
            this.KeywordBids = new HashSet<KeywordBid>();
            this.PromotionAdEngineSelecteds = new HashSet<PromotionAdEngineSelected>();
            this.PromotionAdengineStatus = new HashSet<PromotionAdengineStatu>();
            this.PromotionBiddings = new HashSet<PromotionBidding>();
            this.TargetedDailyBudgets = new HashSet<TargetedDailyBudget>();
        }
    
        public int AdvertisingEnginePK { get; set; }
        public string AdvertisingEngine1 { get; set; }
        public string LogoURL { get; set; }
    
        public virtual ICollection<AdvertisingEngineAccount> AdvertisingEngineAccounts { get; set; }
        public virtual ICollection<AdvertisingEngineAd> AdvertisingEngineAds { get; set; }
        public virtual ICollection<AdvertisingEngineReportData> AdvertisingEngineReportDatas { get; set; }
        public virtual ICollection<KeywordBid> KeywordBids { get; set; }
        public virtual ICollection<PromotionAdEngineSelected> PromotionAdEngineSelecteds { get; set; }
        public virtual ICollection<PromotionAdengineStatu> PromotionAdengineStatus { get; set; }
        public virtual ICollection<PromotionBidding> PromotionBiddings { get; set; }
        public virtual ICollection<TargetedDailyBudget> TargetedDailyBudgets { get; set; }
    }
}