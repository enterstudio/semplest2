using System;
using System.Linq;
using System.Data.Services;
using System.Data.Services.Common;
using Semplest.Core.Models;
using SemplestModel;

namespace SemplestWebApp.Services
{
    public class SemplestDataService : DataService<SemplestEntities>
    {
        // This method is called only once to initialize service-wide policies.
        public static void InitializeService(DataServiceConfiguration config)
        {
            // TODO: set rules to indicate which entity sets and service operations are visible, updatable, etc.
            // Examples:
            config.SetEntitySetAccessRule("Campaign", EntitySetRights.AllRead
                                                      | EntitySetRights.WriteMerge | EntitySetRights.WriteReplace);
            // config.SetServiceOperationAccessRule("MyServiceOperation", ServiceOperationRights.All);
            config.DataServiceBehavior.MaxProtocolVersion = DataServiceProtocolVersion.V2;
        }

        public bool SaveProductGroupAndCampaign(int userid, CampaignSetupModel model)
        {
            using (var dbcontext = new SemplestEntities())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                int custfk = (int)queryCustFk.First();

                // check if the ProductGroupName already exists
                var queryProdGrp = from c in dbcontext.ProductGroups 
                                       where c.CustomerFK == custfk && c.ProductGroupName == model.ProductGroup.ProductGroupName select c;
                if (queryProdGrp.Count() > 0)
                {
                    // product grp already exists
                    string prodGrpName = queryProdGrp.First().ProductGroupName;
                }
                else
                {
                    // create product group
                    var prodgroup = new ProductGroup
                    {
                        ProductGroupName = model.ProductGroup.ProductGroupName,
                        IsActive = true,
                        CustomerFK = custfk,
                        StartDate = Convert.ToDateTime(model.ProductGroup.StartDate),
                        EndDate = String.IsNullOrEmpty(model.ProductGroup.EndDate) ? (DateTime?)null : Convert.ToDateTime(model.ProductGroup.EndDate)
                    };
                    // create promotion
                    var promo = new Promotion 
                    { 
                        ProductGroup = prodgroup,
                        LandingPageURL = model.AdModelProp.Url,
                        PromotionDescription = model.ProductGroup.Words,
                        CycleBudgetAmount = model.ProductGroup.Budget,
                        IsPaused = false
                    };
                    foreach (PromotionAd pad in model.AdModelProp.Ads)
                    {
                        var cad = new PromotionAd { AdText = pad.AdText, AdTitle = pad.AdTitle };
                        // todo need to add sitelinks
                        promo.PromotionAds.Add(cad);
                    }

                    dbcontext.ProductGroups.Add(prodgroup);
                    dbcontext.Promotions.Add(promo);

                    dbcontext.SaveChanges();
                    return true;
                }
            }
            return false;
        }

        public void SaveAd(CampaignSetupModel model)
        {
            // Campaign is now called as ProductGroup
            var campaign = new ProductGroup
                               {
                                   ProductGroupName = model.ProductGroup.ProductGroupName,
                                   IsActive = true,
                                   CustomerFK = 1,
                                   StartDate = Convert.ToDateTime(model.ProductGroup.StartDate),
                                   EndDate = Convert.ToDateTime(model.ProductGroup.EndDate),
                                   //TargetCycleBudget = model.Budget
                               };
            //var ae = new AdvertisingEngine { AdvertisingEngine1 = model.Google.ToString() };
            var promo = new Promotion { ProductGroup = campaign };
            promo.LandingPageURL = model.AdModelProp.Url;
            promo.PromotionDescription = model.ProductGroup.Words;
            // CampaignAds is now called as PromotionAd
            foreach (PromotionAd pad in model.AdModelProp.Ads)
            {
                var cad = new PromotionAd { AdText = pad.AdText, AdTitle = pad.AdTitle };
                promo.PromotionAds.Add(cad);
            }

            //promo.
            //var kewword = new Keyword { Keyword1 = model.Words };
            using (var db = new SemplestEntities())
            {
                db.ProductGroups.Add(campaign);


                db.Promotions.Add(promo);

                //db.AdvertisingEngines.Add(ae);
                db.SaveChanges();
            }
        }
    }
}