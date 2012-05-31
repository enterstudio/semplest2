using System.Collections.Generic;
using System.Linq;
using SemplestModel;

namespace Semplest.Core.Models
{
    public class HomeModelParent
    {
        public int LaunchedCampaigns;
        public int StartedCampaignsNotLaunched;
        public int ClientsNotLoggedIn;
        public IEnumerable<AdvertisingEngine> AdvertisingEngines ;
    }

    public class HomeModelChild : ModelBase
    {
        public HomeModelChild()
        {
            using (var entities = new SemplestEntities())
                Configuration = entities.Configurations.FirstOrDefault();
            CampaignSetup = new CampaignSetupModel();
            CampaignSetup.AdModelProp.Addresses.FirstOrDefault().StateCodeFK = 0;
        }
    
        public ICollection<Promotion> LiveAdvertising;
        public ICollection<Promotion> UnfinishedAdvertising;
        public ICollection<ProductGroup> ProductGroups;

        public CampaignSetupModel CampaignSetup { get; set; }
    }

    public class StaticModel : ModelBase
    {
        public StaticModel(StaticPages pageType)
        {
            using (var entities = new SemplestEntities())
            {
                Configuration = entities.Configurations.FirstOrDefault();
                switch (pageType)
                {
                    case StaticPages.About:
                        Text = entities.WebContents.FirstOrDefault().AboutUs;
                        Title = "About Us";
                        break;
                    case StaticPages.FAQ:
                        Text = entities.WebContents.FirstOrDefault().FAQ;
                        Title = "FAQs";
                        break;
                    case StaticPages.Contact:
                        Text = entities.WebContents.FirstOrDefault().ContactUs;
                        Title = "Contact Us";
                        break;
                    default:
                        Text = "No such Page";
                        break;
                }
            }
        }
        public string Text { get; set; }
        public string Title { get; set; }
    }

    public enum StaticPages { About, FAQ, Contact}
}