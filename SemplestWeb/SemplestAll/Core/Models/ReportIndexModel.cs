﻿using System;
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
            StartDate = DateTime.Now;
            EndDate = DateTime.Now.AddDays(2);
        }
        public IEnumerable<SemplestModel.ProductGroup> ProductGroups;
        public IEnumerable<SemplestModel.AdvertisingEngine> AdvertisingEngines;

        public int PromotionFK { get; set; }
        public int EngineFK { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public string PromotionName { get; set; }
        public string SearchEngineName { get; set; }

    }

    public class ReportChartModel
    {
        public string Date { get; set; }
        public double Clicks { get; set; }
        public double Impressions { get; set; }
    }

}