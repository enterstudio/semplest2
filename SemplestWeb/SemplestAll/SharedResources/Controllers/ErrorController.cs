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
[OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")] 
    public class ErrorController : Controller
    {
        //
        // GET: /Error/

        public ActionResult Index()
        {
            SemplestEntities dbContext = new SemplestEntities();
//            SortedList<DateTime, ErrorModel> list = new SortedList<DateTime, ErrorModel>();
            List<ErrorModel> list = new List<ErrorModel>();
            List<DateTime> dt = new List<DateTime>();
            ErrorModel em = null;
            DateTime t = DateTime.Now.Date;
            //foreach (Error er in dbContext.Errors.Where(x=>x.CreatedDate>t).OrderByDescending(x => x.CreatedDate))
            foreach (Error er in dbContext.Errors.OrderByDescending(x => x.CreatedDate))
            {
                em = new ErrorModel();
                em.ErrorMessage = er.ErrorMessage;
                em.User = er.User != null ? er.User.Credentials.First().Username : "N/A";
                em.TimeStamp = er.CreatedDate;
                if (!dt.Contains(er.CreatedDate.Date))
                    dt.Add(er.CreatedDate.Date);
                ViewData["CreateDate"] = new SelectList(dt, "Date", "Date");
                list.Add(em);
            }
            return View(list);
        }

        public ActionResult GetData(string d)
        {
            return null;
        }

    }
}
