using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;

namespace Semplest.Core.Models
{
    public class CampaignSetupModel
    {
        public CampaignSetupModel()
        {
            ProductGroup = new ProductGroupModel();
            AdModelProp = new AdModel();
            // for categories
            AllCategories = new List<CategoriesModel>();
            SelectedCategories = new List<CategoriesModel>();
            CategoryIds = new List<int>();
            // for keywords
            AllKeywords = new List<KeywordsModel>();
            SelectedKeywords = new List<KeywordsModel>();
            KeywordIds = new List<int>();
        }
        public ProductGroupModel ProductGroup { get; set; }
        public AdModel AdModelProp { get; set; }
        
        #region Nested type: CategoriesModel

        public List<int> CategoryIds { get; set; }
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
        public List<KeywordsModel> SelectedKeywords { get; set; }
        public List<int> KeywordIds { get; set; }

        public class KeywordsModel
        {
            public int Id { get; set; }
            public string Name { get; set; }
        }

        #endregion

    }

    public class AdModel
    {
        public AdModel ()
        {
            Addresses = new List<GeoTargeting> { new GeoTargeting() };
            Ads = new List<PromotionAd> { new PromotionAd() };
        }
        public List<GeoTargeting> Addresses { get; set; }
        public List<PromotionAd> Ads { get; set; }
        public string Url { get; set; }

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