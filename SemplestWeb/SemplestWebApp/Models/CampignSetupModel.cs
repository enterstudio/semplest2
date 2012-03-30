using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace SemplestWebApp.Models
{
    public class CampignSetupModel
    {
        public CampignSetupModel()
        {
        }

        //[Required]
        public string ProductGroupName { get; set; }

        public string ProductPromotionName { get; set; }
        public string Words { get; set; }
        public string Budget { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public bool Google { get; set; }
        public bool Yahoo { get; set; }
        public bool Bing { get; set; }
        public Address Address { get; set; }

        public double Proxmity { get; set; }

        public string Url { get; set; }

        public AdGroup Ad { get; set; }
        public CampaignAd AdEngine { get; set; }
        public string Title { get; set; }

    }
}