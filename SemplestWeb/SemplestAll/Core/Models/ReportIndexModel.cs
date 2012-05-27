using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SemplestModel;

namespace Semplest.Core.Models
{
    public class ReportIndexModel : ModelBase
    {
        public ReportIndexModel()
        {
            using (var entities = new SemplestEntities())
                Configuration = entities.Configurations.FirstOrDefault();
        }
        public IEnumerable<SemplestModel.ProductGroup> ProductGroups;
        public IEnumerable<SemplestModel.AdvertisingEngine> AdvertisingEngines;

    }

    public class ReportChartModel
    {
        public string Date { get; set; }
        public double Clicks { get; set; }
        public double Impressions { get; set; }
    }

}