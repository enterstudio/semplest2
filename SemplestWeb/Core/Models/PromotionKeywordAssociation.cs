//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Semplest.Core.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class PromotionKeywordAssociation
    {
        public PromotionKeywordAssociation()
        {
            this.KeywordBids = new HashSet<KeywordBid>();
        }
    
        public int KeywordFK { get; set; }
        public int PromotionFK { get; set; }
        public System.DateTime CreatedDate { get; set; }
    
        public virtual Keyword Keyword { get; set; }
        public virtual ICollection<KeywordBid> KeywordBids { get; set; }
        public virtual Promotion Promotion { get; set; }
    }
}
