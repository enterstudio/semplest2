//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SemplestAdminApp.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class KeywordBid
    {
        public KeywordBid()
        {
            this.AdvertisingEngineBidDatas = new HashSet<AdvertisingEngineBidData>();
        }
    
        public int KeywordBidPK { get; set; }
        public int KeywordFK { get; set; }
        public int AdGroupFK { get; set; }
        public System.DateTime StartDate { get; set; }
        public Nullable<System.DateTime> EndDate { get; set; }
        public bool IsActive { get; set; }
        public int BidTypeFK { get; set; }
        public decimal BidAmount { get; set; }
    
        public virtual AdGroupKeywordAssociation AdGroupKeywordAssociation { get; set; }
        public virtual ICollection<AdvertisingEngineBidData> AdvertisingEngineBidDatas { get; set; }
        public virtual BidType BidType { get; set; }
    }
}
