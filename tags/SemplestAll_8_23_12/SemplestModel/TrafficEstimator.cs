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
    
    public partial class TrafficEstimator
    {
        public int TrafficEstimatorPK { get; set; }
        public Nullable<int> KeywordBidFK { get; set; }
        public int MicroBid { get; set; }
        public double AveMicroCost { get; set; }
        public double AveNumberClicks { get; set; }
        public Nullable<double> AvePosition { get; set; }
        public Nullable<double> AveCPC { get; set; }
        public System.DateTime CreatedDate { get; set; }
    
        public virtual KeywordBid KeywordBid { get; set; }
    }
}
