using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SemplestModel;

namespace Semplest.Core.Models
{

    public class vwPromotionChartModel
    {
        public string KeyWord;
        public String IsActive;
        public decimal AmountSpent;
        public double NumberImpressions;
        public double NumberClick;
        public decimal SearchCTR;
        public decimal CPC;
        public double AveragePosition;
    }

    public class ReportIndexModel : ModelBase
    {
        public ReportIndexModel()
        {
            using (var entities = new SemplestModel.Semplest())
                Configuration = entities.Configurations.FirstOrDefault();
            StartDate = DateTime.Now;
            EndDate = DateTime.Now.AddDays(2);
        }
        public IEnumerable<SemplestModel.ProductGroup> ProductGroups;
        public IEnumerable<SemplestModel.AdvertisingEngine> AdvertisingEngines;
        public IEnumerable<SemplestModel.vwPromotionChart> Detail;

        public int PromotionFK { get; set; }
        public int EngineFK { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public string PromotionName { get; set; }
        public string SearchEngineName { get; set; }

        public string Start
        {
            get
            {
                return StartDate.ToString("MM/dd");

            }
        }
        public string End
        {
            get
            {
                return EndDate.ToString("MM/dd");

            }
        }

    }

    public class ReportChartModel
    {
        public string Date { get; set; }
        public double Clicks { get; set; }
        public double Impressions { get; set; }
    }

}