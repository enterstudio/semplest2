using System.Web.Mvc;

namespace SemplestWebApp.Areas.Campaign
{
    public class CampignAreaRegistration : AreaRegistration
    {
        public override string AreaName
        {
            get
            {
                return "Campaign";
            }
        }

        public override void RegisterArea(AreaRegistrationContext context)
        {
            context.MapRoute(
                "Campaign_default",
                "Campaign/{controller}/{action}/{id}",
                new { action = "CampaignSetup", id = UrlParameter.Optional }
            );
        }
    }
}
