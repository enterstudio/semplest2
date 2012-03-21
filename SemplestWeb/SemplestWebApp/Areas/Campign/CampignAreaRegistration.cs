using System.Web.Mvc;

namespace SemplestWebApp.Areas.Campign
{
    public class CampignAreaRegistration : AreaRegistration
    {
        public override string AreaName
        {
            get
            {
                return "Campign";
            }
        }

        public override void RegisterArea(AreaRegistrationContext context)
        {
            context.MapRoute(
                "Campign_default",
                "Campign/{controller}/{action}/{id}",
                new { action = "CampignSetup", id = UrlParameter.Optional }
            );
        }
    }
}
