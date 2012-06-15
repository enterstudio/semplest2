using System.Web;
using System.Web.Mvc;
using SemplestModel;
using System.Linq;

namespace Semplest.SharedResources.Helpers
{
    public class AuthorizeRoleAttribute : AuthorizeAttribute
    {
        //public string UserName { get; set; }

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {

            //var db = new SemplestEntities();
            //httpContext.Session[SEMplestConstants.SESSION_USERID] = db.Credentials.First(x => x.UsersFK == 71);
            //return true;
            var db = new SemplestEntities();
            httpContext.Session[SEMplestConstants.SESSION_USERID] = db.Credentials.First(x => x.UsersFK == 12);
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
