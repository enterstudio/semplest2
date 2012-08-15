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
            var dbContext = new SemplestModel.Semplest();
//            SortedList<DateTime, ErrorModel> list = new SortedList<DateTime, ErrorModel>();
            List<ErrorModel> list = new List<ErrorModel>();
            List<DateTime> dt = new List<DateTime>();
            
            DateTime t = DateTime.Now.Date;
            foreach (Error er in dbContext.Errors.OrderByDescending(x => x.CreatedDate))
            {
                if (!dt.Contains(er.CreatedDate.Date))
                    dt.Add(er.CreatedDate.Date);
                ViewData["CreateDate"] = new SelectList(dt, "Date", "Date");
            }
            foreach (Error er in dbContext.Errors.Where(x => x.CreatedDate.Month == t.Month && x.CreatedDate.Day == t.Day && x.CreatedDate.Year == t.Year).OrderByDescending(x => x.CreatedDate))
            {
                var em = new ErrorModel();
                em.ErrorMessage = er.ErrorMessage;
                em.User = er.User != null ? er.User.Credentials.First().Username : "N/A";
                em.TimeStamp = er.CreatedDate;
                list.Add(em);
            }
            return View(list);
        }

    [HttpGet]
    public PartialViewResult ErrorView(string ddl)
    {
        var dbContext = new SemplestModel.Semplest();
        List<ErrorModel> list = new List<ErrorModel>();
        DateTime reqDate = DateTime.Parse(ddl);
        foreach (Error er in dbContext.Errors.Where(x => x.CreatedDate.Month == reqDate.Month && x.CreatedDate.Day == reqDate.Day && x.CreatedDate.Year == reqDate.Year).OrderByDescending(x => x.CreatedDate))
        {
            var em = new ErrorModel();
            em.ErrorMessage = er.ErrorMessage;
            em.User = er.User != null ? er.User.Credentials.First().Username : "N/A";
            em.TimeStamp = er.CreatedDate;

            list.Add(em);
        }
        return PartialView("_ErrorView", list);
    }

    public ActionResult GetData(string d)
        {
            return null;
        }

    }
}
