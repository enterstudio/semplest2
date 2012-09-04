using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using SemplestModel;
using SemplestModel.Validations;
using SharedResources.Models;

namespace Semplest.Core.Models
{
    public class SmartWordSetupModel : ModelBase
    {
        public SmartWordSetupModel()
        {
            ProductGroup = new ProductGroupModel();
            Addresses = new List<GeoTargeting> {new GeoTargeting()};
            KeywordIds = new List<int>();
            AllKeywords = new List<CampaignSetupModel.KeywordsModel>();
            using (var entities = new SemplestModel.Semplest())
                Configuration = entities.Configurations.SingleOrDefault();
            NegativeKeywords = new List<string>();
        }

        public ProductGroupModel ProductGroup { get; set; }
        public List<GeoTargeting> Addresses { get; set; }
        public string ProductGroupName { get { return ProductGroup.ProductGroupName; } set { ProductGroup.ProductGroupName = value; } }
        public string ProductPromotionName { get { return ProductGroup.ProductPromotionName; } set { ProductGroup.ProductPromotionName = value; } }
        public string Words { get { return ProductGroup.Words; } set { ProductGroup.Words = value; } }
        public string LandingUrl { get; set; }
        public string PromotionAddressType { get; set; }
        public List<int> CategoryIds { get; set; }
        public List<CampaignSetupModel.CategoriesModel> AllCategories { get; set; }
        public List<int> KeywordIds { get; set; }
        public List<CampaignSetupModel.KeywordsModel> AllKeywords { get; set; }
        public int WordCount;
        public List<string> NegativeKeywords { get; set; }
        public string NegativeKeywordsText { get; set; }


    }

}