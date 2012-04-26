using System.Web;
using System.Web.Mvc;
namespace Semplest.SharedResources.Helpers
{
    public class AuthorizeRoleAttribute : AuthorizeAttribute
    {
        //public string UserName { get; set; }

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return true;
            string userId = string.Empty;
            if (HttpContext.Current.Session["UserId"] != null)
                userId = HttpContext.Current.Session["UserId"].ToString();
            return !string.IsNullOrEmpty(userId);
        }

        //protected override bool AuthorizeCore(HttpContextBase httpContext)
        //{
        //    //var userName = HttpContext.Current.Session["User"];
        //    //if (userName != null)
        //    //    UserName = userName.ToString();
        //    //if (UserName.Equals("Sriram"))
        //    return true;
        //    //return base.AuthorizeCore(httpContext);
        //}
    }
}
