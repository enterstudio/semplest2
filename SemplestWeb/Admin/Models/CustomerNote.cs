//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Semplest.Admin.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class CustomerNote
    {
        public int CustomerFK { get; set; }
        public int NotePK { get; set; }
        public Nullable<System.DateTime> CreatedDate { get; set; }
        public Nullable<System.DateTime> EditedDate { get; set; }
        public string Note { get; set; }
    
        public virtual Customer Customer { get; set; }
    }
}
