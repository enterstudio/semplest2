using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestModel;

namespace Semplest.SharedResources.Helpers
{
    public class ExceptionHelper : HandleErrorAttribute
    {
        public override void OnException(ExceptionContext filterContext)
        {
            base.OnException(filterContext);

            //if (filterContext.ExceptionHandled)
            //{
            try
            {
                SemplestEntities _dbContext = new SemplestEntities();
                SemplestModel.Error er = new SemplestModel.Error();
                er.ErrorMessage = filterContext.Exception.ToString();
                //filterContext.RequestContext.HttpContext.Session
                if (HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] == null)
                    er.UsersFK = 1;
                else
                    er.UsersFK = string.IsNullOrEmpty(HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID].ToString()) ? 1 : int.Parse(HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID].ToString());
                er.TimeStamp = DateTime.Now;
                _dbContext.Errors.Add(er);
                _dbContext.SaveChanges();
                //send email
            }
            catch (Exception ex) { Console.WriteLine(ex.ToString()); }
            // Log filterContext.Exception in some way.  
            //}
        }
    }  
}