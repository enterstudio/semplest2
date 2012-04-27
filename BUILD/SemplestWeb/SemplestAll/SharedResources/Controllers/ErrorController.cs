using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.ComponentModel.DataAnnotations;
using SemplestModel;

namespace Semplest.SharedResources.Controllers
{
    public class ErrorModel
    {
        public DateTime TimeStamp { get; set; }
        public string ErrorMessage { get; set; }
        public string User { get; set; }

    }

    public class ErrorController : Controller
    {
        //
        // GET: /Error/

        public ActionResult Index()
        {
            SemplestEntities dbContext = new SemplestEntities();
//            SortedList<DateTime, ErrorModel> list = new SortedList<DateTime, ErrorModel>();
            List<ErrorModel> list = new List<ErrorModel>();
            ErrorModel em = null;
            foreach (Error er in dbContext.Errors.OrderByDescending(x => x.CreatedDate))
            {
                em = new ErrorModel();
                em.ErrorMessage = er.ErrorMessage;
                em.User = er.User.Credentials.First().Username;
                em.TimeStamp = er.CreatedDate;

                list.Add(em);
            }
            return View(list);
        }

    }
}
