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
    
    public partial class CreditCardProfile
    {
        public CreditCardProfile()
        {
            this.NickNameProfileAssociations = new HashSet<NickNameProfileAssociation>();
            this.Transactions = new HashSet<Transaction>();
        }
    
        public int CreditCardProfilePK { get; set; }
        public string CustomerRefNum { get; set; }
        public string AuthCode { get; set; }
        public string TxRefNum { get; set; }
        public Nullable<int> PromotionFK { get; set; }
        public Nullable<int> CustomerFK { get; set; }
    
        public virtual Customer Customer { get; set; }
        public virtual Promotion Promotion { get; set; }
        public virtual ICollection<NickNameProfileAssociation> NickNameProfileAssociations { get; set; }
        public virtual ICollection<Transaction> Transactions { get; set; }
    }
}
