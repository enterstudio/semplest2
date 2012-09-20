using System.Collections.Generic;
using System.Linq;
using SemplestModel;
using SharedResources.Models;

namespace Semplest.Core.Models
{
    public class HomeModelParent
    {

        public int LaunchedCampaigns;
        public int StartedCampaignsNotLaunched;
        public int ClientsNotLoggedIn;
        public IEnumerable<AdvertisingEngine> AdvertisingEngines;
    }

    public class HomeModelChild
    {
        public HomeModelChild()
        {
            //CampaignSetup = new CampaignSetupModel();
           // CampaignSetup.AdModelProp.Addresses.FirstOrDefault().StateCodeFK = 0;
        }

        public List<GetCustomerPromotionStatus_Result> CustomerPromotions;

       // public CampaignSetupModel CampaignSetup { get; set; }
    }

    
}