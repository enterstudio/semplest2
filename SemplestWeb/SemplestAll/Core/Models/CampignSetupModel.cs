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
            Ads = new List<PromotionAd> {new PromotionAd()};
            ProductGroup = new ProductGroupModel();
        }
        public ProductGroupModel ProductGroup { get; set; }

        public List<GeoTargeting> Addresses { get; set; }
        public List<PromotionAd> Ads { get; set; }

        public double Proximity { get; set; }

        public string Url { get; set; }
        public string Title { get; set; }
        public string AdCopy { get; set; }

        //public string ProductType { get; set; }

        #region Nested type: CategoriesModel

        public int[] CategoryIds { get; set; }
        public List<CategoriesModel> SelectedCategories { get; set; }
        public List<CategoriesModel> AllCategories { get; set; }

        public class CategoriesModel
        {
            public int Id { get; set; }
            public string Name { get; set; }
        }

        #endregion

        #region Nested type: KeywordsModel
        public List<KeywordsModel> AllKeywords { get; set; }

        public class KeywordsModel
        {
            public string Name { get; set; }
        }

        #endregion

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