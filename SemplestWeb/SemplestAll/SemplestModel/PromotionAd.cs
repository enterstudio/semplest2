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
    
    public partial class PromotionAd
    {
        public PromotionAd()
        {
            this.SiteLinks = new HashSet<SiteLink>();
            this.AdvertisingEngineAds = new HashSet<AdvertisingEngineAd>();
        }
    
        public int PromotionAdsPK { get; set; }
        public int PromotionFK { get; set; }
        public string AdTitle { get; set; }
        public string AdText { get; set; }
    
        public virtual Promotion Promotion { get; set; }
        public virtual ICollection<SiteLink> SiteLinks { get; set; }
        public virtual ICollection<AdvertisingEngineAd> AdvertisingEngineAds { get; set; }
    }
}
