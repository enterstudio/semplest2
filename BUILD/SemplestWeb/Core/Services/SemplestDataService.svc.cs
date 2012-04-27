using System;
using System.Collections.Generic;
using System.Data.Services;
using System.Data.Services.Common;
using System.Linq;
using System.ServiceModel.Web;
using System.Web;
using Semplest.Core.Models;
using SemplestWebApp.Models;

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

        public void SaveAd(CampaignSetupModel model)
        {
            // Campaign is now called as ProductGroup
            var campaign = new ProductGroup
            {
                ProductGroupName = model.ProductGroupName,
                IsActive = true,
                CustomerFK = 1,
                StartDate = model.StartDate,
                EndDate = model.EndDate,
                
                  //TargetCycleBudget = model.Budget
            };
            // CampaignAds is now called as PromotionAd
            PromotionAd cad = new PromotionAd { AdText = model.AdCopy };
            AdvertisingEngine ae = new AdvertisingEngine { AdvertisingEngine1 = model.Google.ToString() };
            var ag = new Promotion { ProductGroup = campaign };
            ag.PromotionAds.Add(cad);
            //ae.AdGroups.Add(ag);
            Keyword kewword = new Keyword { Keyword1 = model.Words };
            using (var db = new SemplestEntities())
            {
                db.ProductGroups.Add(campaign);
                db.Promotions.Add(ag);
                db.PromotionAds.Add(cad);
                db.AdvertisingEngines.Add(ae);
                db.SaveChanges();
            }
        }
    }
}
