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
    
    public partial class CreditCardNickName
    {
        public CreditCardNickName()
        {
            this.NickNameProfileAssociations = new HashSet<NickNameProfileAssociation>();
        }
    
        public int CreditCardNickNamePK { get; set; }
        public int CustomerFK { get; set; }
        public string CreditCardNickName1 { get; set; }
    
        public virtual Customer Customer { get; set; }
        public virtual ICollection<NickNameProfileAssociation> NickNameProfileAssociations { get; set; }
    }
}
