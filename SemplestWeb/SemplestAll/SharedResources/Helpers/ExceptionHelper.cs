using System;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using System.Web.Mvc;
using SemplestModel;
using Semplest.SharedResources.Services;

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
                var _dbContext = new SemplestModel.Semplest();
                SemplestModel.Error er = new SemplestModel.Error();
                er.ErrorMessage = filterContext.Exception.ToString();
                //filterContext.RequestContext.HttpContext.Session
                if (HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] == null)
                    er.UsersFK = 1;
                else
                    er.UsersFK =
                        ((Credential)
                         HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]) == null
                            ? 1
                            : ((Credential)
                               HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]).
                                  UsersFK;
                er.CreatedDate = DateTime.Now;
                _dbContext.Errors.Add(er);
                _dbContext.SaveChanges();
                var scw = new ServiceClientWrapper();
                scw.SendEmail("WebSite Error Message", "website@semplest.com",
                              _dbContext.Configurations.First().OnErrorEmail, er.ErrorMessage);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
                //throw;
            }
            // Log filterContext.Exception in some way.  
            //}
        }

        public static void LogException(Exception ex)
        {
            var _dbContext = new SemplestModel.Semplest();
            SemplestModel.Error er = new SemplestModel.Error();
            //first try saving to the database then try sending an email
            try
            {
                er.ErrorMessage = GetErrorMessage(ex);
                //filterContext.RequestContext.HttpContext.Session
                if (HttpContext.Current == null ||
                    HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] == null)
                    er.UsersFK = null;
                else
                    er.UsersFK =
                        ((Credential)
                         HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]) == null
                            ? 1
                            : ((Credential)
                               HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]).
                                  UsersFK;
                er.CreatedDate = DateTime.Now;
                _dbContext.Errors.Add(er);
                _dbContext.SaveChanges();
            }
            catch
            {
            }
            try
            {
                var scw = new ServiceClientWrapper();
                scw.SendEmail("WebSite Error Message", "website@semplest.com",
                              _dbContext.Configurations.First().OnErrorEmail, er.ErrorMessage);
            }
            catch
            {
            }
        }

        public static string GetErrorMessage(Exception ex)
        {
            if (ex is System.Data.Entity.Validation.DbEntityValidationException)
            {
                var deve =
                    (System.Data.Entity.Validation.DbEntityValidationException)ex;
                if (deve.EntityValidationErrors.Any() && deve.EntityValidationErrors.FirstOrDefault().ValidationErrors.Any())
                {
                    return deve.EntityValidationErrors.FirstOrDefault().ValidationErrors.FirstOrDefault().ErrorMessage;
                }
                return deve.ToString();
            }
            else
                return ex.ToString();
        }
    }

    public static partial class HtmlExtensions
    {
        public static MvcHtmlString ClientIdFor<TModel, TProperty>(this HtmlHelper<TModel> htmlHelper, Expression<Func<TModel, TProperty>> expression)
        {
            return MvcHtmlString.Create(htmlHelper.ViewContext.ViewData.TemplateInfo.GetFullHtmlFieldId(ExpressionHelper.GetExpressionText(expression)));
        }
    }
}