using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using SemplestModel;
using System.Linq;
using Semplest.SharedResources.Services;

namespace Semplest.Core.Models
{
    public class CampaignSetupModel
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
            using (var entities = new SemplestEntities())
                Configuration = entities.Configurations.FirstOrDefault();

        }
        public ProductGroupModel ProductGroup { get; set; }
        public AdModel AdModelProp { get; set; }
        public BillingLaunchModel BillingLaunch { get; set; }

        public Configuration Configuration { get; set; }

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
        [Required]
        public string Url { get; set; }
    }

    public class AdEngineSelectModel
    {
        public int Id { get; set; }
        public string Name { get; set; }
    }

    public class ProductGroupModel
    {
        public ProductGroupModel()
        {
            using (var entities = new SemplestEntities())
            {
                Configuration = entities.Configurations.FirstOrDefault();
                AdvertisingEngines = entities.AdvertisingEngines.Select(t => new AdEngineSelectModel { Id = t.AdvertisingEnginePK, Name = t.AdvertisingEngine1 }).ToList();
                AdEnginesSelectedList = new List<AdEngineSelectModel>();
            }
            //using (SemplestEntities dbcontext = new SemplestEntities())
            //{
            //    try
            //    {
            //        var query = from c in dbcontext.AdvertisingEngines select c.AdvertisingEngine1;
            //        if (query.Count() > 0)
            //        {
            //            AdEnginesList = query.ToList();
            //        }
            //        else
            //        {
            //            AdEnginesList = new List<string>();
            //        }

            //    }
            //    catch (Exception ex)
            //    {
            //        string msg = ex.Message;
            //        throw;
            //    }
            //}

            AdEnginesSelectedList = new List<AdEngineSelectModel>();
        }
        public Configuration Configuration { get; set; }
        public string ProductGroupName { get; set; }
        public string ProductPromotionName { get; set; }
        public string Words { get; set; }
        public decimal Budget { get; set; }
        //public DateTime StartDate { get; set; }
        //public DateTime EndDate { get; set; }
        public string StartDate { get; set; }
        public string EndDate { get; set; }
        public List<string> AdEnginesList { get; set; }
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