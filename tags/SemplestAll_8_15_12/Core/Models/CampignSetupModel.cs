using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using SemplestModel;
using SemplestModel.Validations;
using System.Linq;
using Semplest.SharedResources.Services;
using System;
using SharedResources.Models;


namespace Semplest.Core.Models
{

    public class CampaignSetupModel : ModelBase
    {
        public CampaignSetupModel()
        {
            ProductGroup = new ProductGroupModel();
            AdModelProp = new AdModel();
            BillingLaunch = new BillingLaunchModel();
            // for categories
            AllCategories = new List<CategoriesModel>();
            SelectedCategories = new List<CategoriesModel>();
            CategoryIds = new List<int>();
            // for keywords
            AllKeywords = new List<KeywordsModel>();
            AllKeywordProbabilityObjects = new List<KeywordProbabilityObject>();
            SelectedKeywords = new List<KeywordsModel>();
            KeywordIds = new List<int>();
            using (var entities = new SemplestModel.Semplest())
                Configuration = entities.Configurations.FirstOrDefault();
            SiteLinks = new List<SiteLink>();
        }

        public ProductGroupModel ProductGroup { get; set; }
        public AdModel AdModelProp { get; set; }
        public BillingLaunchModel BillingLaunch { get; set; }

        public List<SiteLink> SiteLinks { get; set; }

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
        public List<KeywordProbabilityObject> AllKeywordProbabilityObjects { get; set; }
        public List<KeywordsModel> AllKeywords { get; set; }
        public List<KeywordsModel> SelectedKeywords { get; set; }
        public List<int> KeywordIds { get; set; }

        public class KeywordsModel
        {
            public int Id { get; set; }
            public string Name { get; set; }
        }

        #endregion

        public bool IsLaunched { get; set; }
        public bool IsCompleted { get; set; }


        //added by tudor
        public decimal PercentMedia { get; set; }
        public bool PromotionFeeOverRide  { get; set; }
        public decimal? PromotionFeeOverRideAmount { get; set; }
        public int BillType { get; set; }
        //added by tudor 

    }

    public class AddsStoreModel
    {
        public List<PromotionAd> Ads { get; set; }
    }
    public class AdModel
    {
        public AdModel()
        {
            Addresses = new List<GeoTargeting> { new GeoTargeting() };
            Ads = new List<PromotionAd> { new PromotionAd() };
            NegativeKeywords = new List<string>();
        }
        public List<GeoTargeting> Addresses { get; set; }
        public List<PromotionAd> Ads { get; set; }
        public List<string> NegativeKeywords { get; set; }
        public string NegativeKeywordsText { get; set; }
        [Required(ErrorMessage = "Url is Required...")]
        //[RegularExpression(@"(http://|)(www\.)?([^\.]+)\.(\w{2}|(com|net|org|edu|int|mil|gov|arpa|biz|aero|name|coop|info|pro|museum))$",ErrorMessage = "url should be in this format http://www.semplest.com")]
        public string LandingUrl { get; set; }
        // display url limit 35 characters
        public string DisplayUrl { get; set; }
        public bool IsNew { get; set; }
    }

    public class AdEngineSelectModel
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string ImageUrl { get; set; }
    }

    public class ProductGroupModel
    {
        public ProductGroupModel()
        {
            using (var entities = new SemplestModel.Semplest())
            {
                Configuration = entities.Configurations.FirstOrDefault();
                string filePath = System.Configuration.ConfigurationManager.AppSettings["LogoURL"].ToString();
                AdvertisingEngines = entities.AdvertisingEngines.Select(t => new AdEngineSelectModel { Id = t.AdvertisingEnginePK, Name = t.AdvertisingEngine1, ImageUrl = filePath + t.LogoURL }).ToList();
                AdEnginesSelectedList = AdvertisingEngines;
            }
            AdEnginesList = new List<int>();
        }

        public Configuration Configuration { get; set; }
        public string ProductGroupName { get; set; }
        public string ProductPromotionName { get; set; }
        public string Words { get; set; }
        public decimal Budget { get; set; }
        public bool IsEdit { get; set; }
        //public DateTime StartDate { get; set; }
        //public DateTime EndDate { get; set; }
        public string StartDate { get; set; }
        public string EndDate { get; set; }
        [Required(ErrorMessage = "Pleaes select at least one Search Engine")]
        [CheckBoxAtleaseOneChecked]
        public List<int> AdEnginesList { get; set; }
        public List<AdEngineSelectModel> AdEnginesSelectedList { get; set; }
        public List<AdEngineSelectModel> AdvertisingEngines { get; set; }
        public bool Google { get; set; }
        public bool YahooBing { get; set; }
    }

    public class BillingLaunchModel
    {
        public int KeywordsCount { get; set; }
        public string Range { get; set; }
    }

    public class AdditionalLinks
    {
        [Key]
        public int Id { get; set; }

        public string Name { get; set; }
        public string Url { get; set; }
    }

    public class NavBar
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Url { get; set; }
        public List<NavBar> SubItems { get; set; }
    }
}