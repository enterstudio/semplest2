using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SemplestModel;
using SharedResources.Models;

namespace Semplest.Core.Models
{
    public class BillingModel
    {
        public decimal Amount { get; set; }
        public string ProductGroupName { get; set; }
        public string PromotionName { get; set; }
        public decimal MediaSpend { get; set; }
        public decimal SEMplestFee { get; set; }
        public DateTime Date { get; set; }
        public string Transaction { get; set; }
        public string Type { get; set; }

    }
}