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
        }
    
        public ICollection<Promotion> LiveAdvertising;
        public ICollection<Promotion> UnfinishedAdvertising;
        public ICollection<ProductGroup> ProductGroups;
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
                    default:
                        Text = "No such Page";
                        break;
                }
            }
        }
        public string Text { get; set; }
        public string Title { get; set; }
    }

    public enum StaticPages { About, FAQ}
}