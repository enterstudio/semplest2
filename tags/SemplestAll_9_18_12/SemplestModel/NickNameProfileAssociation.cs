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
    
    public partial class NickNameProfileAssociation
    {
        public int CreditCardProfileFK { get; set; }
        public int CreditCardNickNameFK { get; set; }
        public bool IsMasterProfile { get; set; }
        public bool IsDeleted { get; set; }
    
        public virtual CreditCardNickName CreditCardNickName { get; set; }
        public virtual CreditCardProfile CreditCardProfile { get; set; }
    }
}