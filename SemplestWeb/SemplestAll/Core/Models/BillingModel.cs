using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SemplestModel;

namespace Semplest.Core.Models
{
    public class BillingModel : ModelBase
    {
        public BillingModel()
        {
            using (var entities = new SemplestModel.Semplest())
                Configuration = entities.Configurations.FirstOrDefault();
        }
        public decimal Amount { get; set; }
        public string ProductGroupName { get; set; }
        public string PromotionName { get; set; }
        public decimal MediaSpend { get; set; }
        public decimal SEMplestFee { get; set; }

    }
}