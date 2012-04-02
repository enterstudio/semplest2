using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace SemplestWebApp.Models
{
    public class CampaignSetupModel
    {
        public CampaignSetupModel()
        {
            Addresses = new List<Address> { new Address { Address1 = "" } };
        }

        //[Required]
        public string ProductGroupName { get; set; }
        public string ProductPromotionName { get; set; }
        public string Words { get; set; }
        public decimal Budget { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public bool Google { get; set; }
        public bool Yahoo { get; set; }
        public bool Bing { get; set; }

        public List<Address> Addresses { get; set; }

        public double Proximity { get; set; }

        public string Url { get; set; }
        public string Title { get; set; }
        public string AdCopy { get; set; }

        //public string ProductType { get; set; }

    }

    public class AdditionalLinks
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        public string Url { get; set; }
    }

}