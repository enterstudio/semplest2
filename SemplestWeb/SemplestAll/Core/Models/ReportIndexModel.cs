using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Semplest.Core.Models
{
    public class ReportIndexModel
    {
        public IEnumerable<SemplestModel.ProductGroup> ProductGroups;
        public IEnumerable<SemplestModel.AdvertisingEngine> AdvertisingEngines;

    }
}