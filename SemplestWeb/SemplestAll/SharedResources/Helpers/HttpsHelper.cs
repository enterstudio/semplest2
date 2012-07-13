using System.Web.Mvc;

namespace Semplest.SharedResources.Helpers
{
    public class RequireHttpsHelper : RequireHttpsAttribute
    {
        protected override void HandleNonHttpsRequest(AuthorizationContext filterContext)
        {
            if (filterContext.HttpContext.Request.Url != null && !filterContext.HttpContext.Request.Url.Host.Contains("localhost"))
            {
                base.HandleNonHttpsRequest(filterContext);
            }
        }
    }
}