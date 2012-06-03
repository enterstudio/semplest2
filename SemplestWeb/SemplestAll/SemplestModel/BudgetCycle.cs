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
    public partial class BudgetCycle
    {
        #region Primitive Properties
    
        public virtual int BudgetCyclePK
        {
            get;
            set;
        }
    
        public virtual string BudgetCycle1
        {
            get;
            set;
        }

        #endregion
        #region Navigation Properties
    
        public virtual ICollection<Promotion> Promotions
        {
            get
            {
                if (_promotions == null)
                {
                    var newCollection = new FixupCollection<Promotion>();
                    newCollection.CollectionChanged += FixupPromotions;
                    _promotions = newCollection;
                }
                return _promotions;
            }
            set
            {
                if (!ReferenceEquals(_promotions, value))
                {
                    var previousValue = _promotions as FixupCollection<Promotion>;
                    if (previousValue != null)
                    {
                        previousValue.CollectionChanged -= FixupPromotions;
                    }
                    _promotions = value;
                    var newValue = value as FixupCollection<Promotion>;
                    if (newValue != null)
                    {
                        newValue.CollectionChanged += FixupPromotions;
                    }
                }
            }
        }
        private ICollection<Promotion> _promotions;

        #endregion
        #region Association Fixup
    
        private void FixupPromotions(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (e.NewItems != null)
            {
                foreach (Promotion item in e.NewItems)
                {
                    item.BudgetCycle = this;
                }
            }
    
            if (e.OldItems != null)
            {
                foreach (Promotion item in e.OldItems)
                {
                    if (ReferenceEquals(item.BudgetCycle, this))
                    {
                        item.BudgetCycle = null;
                    }
                }
            }
        }

        #endregion
    }
}
