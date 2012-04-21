using System.Web;
using System.Web.Mvc;

namespace SemplestWebApp.Helpers
{
    public class AuthorizeRoleAttribute : AuthorizeAttribute
    {
        public string UserName { get; set; }

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            //var userName = HttpContext.Current.Session["User"];
            //if (userName != null)
            //    UserName = userName.ToString();
            //if (UserName.Equals("Sriram"))
            return true;
            //return base.AuthorizeCore(httpContext);
        }
    }
}