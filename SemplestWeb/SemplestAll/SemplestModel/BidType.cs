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
    public partial class BidType
    {
        #region Primitive Properties
    
        public virtual int BidTypePK
        {
            get;
            set;
        }
    
        public virtual string BidType1
        {
            get;
            set;
        }

        #endregion
        #region Navigation Properties
    
        public virtual ICollection<AdvertisingEngineReportData> AdvertisingEngineReportDatas
        {
            get
            {
                if (_advertisingEngineReportDatas == null)
                {
                    var newCollection = new FixupCollection<AdvertisingEngineReportData>();
                    newCollection.CollectionChanged += FixupAdvertisingEngineReportDatas;
                    _advertisingEngineReportDatas = newCollection;
                }
                return _advertisingEngineReportDatas;
            }
            set
            {
                if (!ReferenceEquals(_advertisingEngineReportDatas, value))
                {
                    var previousValue = _advertisingEngineReportDatas as FixupCollection<AdvertisingEngineReportData>;
                    if (previousValue != null)
                    {
                        previousValue.CollectionChanged -= FixupAdvertisingEngineReportDatas;
                    }
                    _advertisingEngineReportDatas = value;
                    var newValue = value as FixupCollection<AdvertisingEngineReportData>;
                    if (newValue != null)
                    {
                        newValue.CollectionChanged += FixupAdvertisingEngineReportDatas;
                    }
                }
            }
        }
        private ICollection<AdvertisingEngineReportData> _advertisingEngineReportDatas;
    
        public virtual ICollection<KeywordBid> KeywordBids
        {
            get
            {
                if (_keywordBids == null)
                {
                    var newCollection = new FixupCollection<KeywordBid>();
                    newCollection.CollectionChanged += FixupKeywordBids;
                    _keywordBids = newCollection;
                }
                return _keywordBids;
            }
            set
            {
                if (!ReferenceEquals(_keywordBids, value))
                {
                    var previousValue = _keywordBids as FixupCollection<KeywordBid>;
                    if (previousValue != null)
                    {
                        previousValue.CollectionChanged -= FixupKeywordBids;
                    }
                    _keywordBids = value;
                    var newValue = value as FixupCollection<KeywordBid>;
                    if (newValue != null)
                    {
                        newValue.CollectionChanged += FixupKeywordBids;
                    }
                }
            }
        }
        private ICollection<KeywordBid> _keywordBids;

        #endregion
        #region Association Fixup
    
        private void FixupAdvertisingEngineReportDatas(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (e.NewItems != null)
            {
                foreach (AdvertisingEngineReportData item in e.NewItems)
                {
                    item.BidType = this;
                }
            }
    
            if (e.OldItems != null)
            {
                foreach (AdvertisingEngineReportData item in e.OldItems)
                {
                    if (ReferenceEquals(item.BidType, this))
                    {
                        item.BidType = null;
                    }
                }
            }
        }
    
        private void FixupKeywordBids(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (e.NewItems != null)
            {
                foreach (KeywordBid item in e.NewItems)
                {
                    item.BidType = this;
                }
            }
    
            if (e.OldItems != null)
            {
                foreach (KeywordBid item in e.OldItems)
                {
                    if (ReferenceEquals(item.BidType, this))
                    {
                        item.BidType = null;
                    }
                }
            }
        }

        #endregion
    }
}
