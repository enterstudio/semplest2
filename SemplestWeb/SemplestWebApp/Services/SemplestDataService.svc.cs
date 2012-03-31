using System;
using System.Collections.Generic;
using System.Data.Services;
using System.Data.Services.Common;
using System.Linq;
using System.ServiceModel.Web;
using System.Web;
using SemplestWebApp.Models;

namespace SemplestWebApp.Services
{
    public class SemplestDataService : DataService<SemplestWebApp.Models.SemplestEntities>
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
            var campaign = new Campaign
            {
                CampaignName = model.ProductGroupName,
                IsActive = true,
                CustomerFK = 1,
                StartDate = model.StartDate,
                EndDate = model.EndDate,
                TargetCycleBudget = model.Budget
            };
            CampaignAd cad = new CampaignAd { AdText = model.AdCopy };
            AdvertisingEngine ae = new AdvertisingEngine { AdvertisingEngine1 = model.Google.ToString() };
            var ag = new AdGroup { Campaign = campaign };
            ag.CampaignAds.Add(cad);
            ae.AdGroups.Add(ag);
            Keyword kewword = new Keyword { Keyword1 = model.Words };
            using (var db = new SemplestEntities())
            {
                db.Campaigns.Add(campaign);
                db.AdGroups.Add(ag);
                db.CampaignAds.Add(cad);
                db.AdvertisingEngines.Add(ae);
                db.SaveChanges();
            }
        }
    }
}
