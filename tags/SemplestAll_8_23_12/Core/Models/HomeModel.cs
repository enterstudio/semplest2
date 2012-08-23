using System.Collections.Generic;
using System.Linq;
using SemplestModel;
using SharedResources.Models;

namespace Semplest.Core.Models
{
    public class HomeModelParent : ModelBase
    {
        public HomeModelParent()
        {
            using (var entities = new SemplestModel.Semplest())
                Configuration = entities.Configurations.FirstOrDefault();
        }

        public int LaunchedCampaigns;
        public int StartedCampaignsNotLaunched;
        public int ClientsNotLoggedIn;
        public IEnumerable<AdvertisingEngine> AdvertisingEngines;
    }

    public class HomeModelChild : ModelBase
    {
        public HomeModelChild()
        {
            using (var entities = new SemplestModel.Semplest())
                Configuration = entities.Configurations.FirstOrDefault();
            CampaignSetup = new CampaignSetupModel();
            CampaignSetup.AdModelProp.Addresses.FirstOrDefault().StateCodeFK = 0;
        }

        public ICollection<Promotion> LiveAdvertising;
        public ICollection<Promotion> UnfinishedAdvertising;
        public ICollection<ProductGroup> ProductGroups;

        public CampaignSetupModel CampaignSetup { get; set; }
    }

    
}