//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;

namespace SemplestModel
{
    public partial class vwPromotionChart
    {
        #region Primitive Properties
    
        public virtual string Keyword
        {
            get;
            set;
        }
    
        public virtual string PromotionName
        {
            get;
            set;
        }
    
        public virtual int NumberImpressions
        {
            get;
            set;
        }
    
        public virtual int NumberClick
        {
            get;
            set;
        }
    
        public virtual int AdvertisingEngineFK
        {
            get;
            set;
        }
    
        public virtual int PromotionFK
        {
            get;
            set;
        }
    
        public virtual System.DateTime TransactionDate
        {
            get;
            set;
        }
    
        public virtual int MicroBidAmount
        {
            get;
            set;
        }
    
        public virtual int AveragePosition
        {
            get;
            set;
        }
    
        public virtual decimal AverageCPC
        {
            get;
            set;
        }
    
        public virtual int AdvertisingEngineBidDataPK
        {
            get;
            set;
        }
    
        public virtual int UserPK
        {
            get;
            set;
        }
    
        public virtual bool IsActive
        {
            get;
            set;
        }

        #endregion
    }
}
