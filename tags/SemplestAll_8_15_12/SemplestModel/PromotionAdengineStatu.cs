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
    
    public partial class PromotionAdengineStatu
    {
        public int PromotionAdengineStatusPK { get; set; }
        public int PromotionFK { get; set; }
        public int PromotionStatusFK { get; set; }
        public int AdvertisingEngineFK { get; set; }
    
        public virtual AdvertisingEngine AdvertisingEngine { get; set; }
        public virtual Promotion Promotion { get; set; }
        public virtual PromotionStatu PromotionStatu { get; set; }
    }
}