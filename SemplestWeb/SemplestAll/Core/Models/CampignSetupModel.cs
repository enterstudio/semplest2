using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace Semplest.Core.Models
{
    public class CampaignSetupModel
    {
        public CampaignSetupModel()
        {
            Addresses = new List<GeoTargeting> { new GeoTargeting() };
            Ads = new List<Promotion> {new Promotion()};
            ProductGroup = new ProductGroupModel();
        }
        public ProductGroupModel ProductGroup { get; set; }

        public List<GeoTargeting> Addresses { get; set; }
        public List<Promotion> Ads { get; set; }

        public double Proximity { get; set; }

        public string Url { get; set; }
        public string Title { get; set; }
        public string AdCopy { get; set; }

        //public string ProductType { get; set; }
    }

    public class ProductGroupModel
    {
        public string ProductGroupName { get; set; }
        public string ProductPromotionName { get; set; }
        public string Words { get; set; }
        public decimal Budget { get; set; }
        public DateTime StartDate { get; set; }
        public DateTime EndDate { get; set; }
        public bool Google { get; set; }
        public bool YahooBing { get; set; }
    }

    public class AdditionalLinks
    {
        [Key]
        public int Id { get; set; }

        public string Name { get; set; }
        public string Url { get; set; }
    }
}