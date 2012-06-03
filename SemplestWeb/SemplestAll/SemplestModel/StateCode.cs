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
    public partial class StateCode
    {
        #region Primitive Properties
    
        public virtual int StateAbbrPK
        {
            get;
            set;
        }
    
        public virtual string StateAbbr
        {
            get;
            set;
        }

        #endregion
        #region Navigation Properties
    
        public virtual ICollection<Address> Addresses
        {
            get
            {
                if (_addresses == null)
                {
                    var newCollection = new FixupCollection<Address>();
                    newCollection.CollectionChanged += FixupAddresses;
                    _addresses = newCollection;
                }
                return _addresses;
            }
            set
            {
                if (!ReferenceEquals(_addresses, value))
                {
                    var previousValue = _addresses as FixupCollection<Address>;
                    if (previousValue != null)
                    {
                        previousValue.CollectionChanged -= FixupAddresses;
                    }
                    _addresses = value;
                    var newValue = value as FixupCollection<Address>;
                    if (newValue != null)
                    {
                        newValue.CollectionChanged += FixupAddresses;
                    }
                }
            }
        }
        private ICollection<Address> _addresses;
    
        public virtual ICollection<GeoTargeting> GeoTargetings
        {
            get
            {
                if (_geoTargetings == null)
                {
                    var newCollection = new FixupCollection<GeoTargeting>();
                    newCollection.CollectionChanged += FixupGeoTargetings;
                    _geoTargetings = newCollection;
                }
                return _geoTargetings;
            }
            set
            {
                if (!ReferenceEquals(_geoTargetings, value))
                {
                    var previousValue = _geoTargetings as FixupCollection<GeoTargeting>;
                    if (previousValue != null)
                    {
                        previousValue.CollectionChanged -= FixupGeoTargetings;
                    }
                    _geoTargetings = value;
                    var newValue = value as FixupCollection<GeoTargeting>;
                    if (newValue != null)
                    {
                        newValue.CollectionChanged += FixupGeoTargetings;
                    }
                }
            }
        }
        private ICollection<GeoTargeting> _geoTargetings;

        #endregion
        #region Association Fixup
    
        private void FixupAddresses(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (e.NewItems != null)
            {
                foreach (Address item in e.NewItems)
                {
                    item.StateCode = this;
                }
            }
    
            if (e.OldItems != null)
            {
                foreach (Address item in e.OldItems)
                {
                    if (ReferenceEquals(item.StateCode, this))
                    {
                        item.StateCode = null;
                    }
                }
            }
        }
    
        private void FixupGeoTargetings(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (e.NewItems != null)
            {
                foreach (GeoTargeting item in e.NewItems)
                {
                    item.StateCode = this;
                }
            }
    
            if (e.OldItems != null)
            {
                foreach (GeoTargeting item in e.OldItems)
                {
                    if (ReferenceEquals(item.StateCode, this))
                    {
                        item.StateCode = null;
                    }
                }
            }
        }

        #endregion
    }
}
