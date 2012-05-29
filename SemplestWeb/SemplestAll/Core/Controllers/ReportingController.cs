using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestModel;
using Semplest.Core.Models;
using Semplest.SharedResources.Helpers;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class ReportingController : Controller
    {
        //
        // GET: /Reporting/

        public ActionResult Index()
        {
            Credential cred = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]));
            SemplestEntities dbContext = new SemplestEntities();
            ReportIndexModel rim = new ReportIndexModel();
            rim.AdvertisingEngines = dbContext.AdvertisingEngines;
            rim.ProductGroups = dbContext.Credentials.Where(x => x.UsersFK == cred.UsersFK).First().User.Customer.ProductGroups;
            return View(rim);
        }
        [HttpPost]
        public ActionResult Index(ReportIndexModel model)
        {
            Credential cred = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]));
            SemplestEntities dbContext = new SemplestEntities();
            model.AdvertisingEngines = dbContext.AdvertisingEngines;
            model.ProductGroups = dbContext.Credentials.Where(x => x.UsersFK == cred.UsersFK).First().User.Customer.ProductGroups;
            return RedirectToAction("ReportDetails", model);
        }
        public ActionResult ReportDetails(ReportIndexModel model)
        {
            Credential cred = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]));
            SemplestEntities dbContext = new SemplestEntities();
            model.AdvertisingEngines = dbContext.AdvertisingEngines;
            model.ProductGroups = dbContext.Credentials.Where(x => x.UsersFK == cred.UsersFK).First().User.Customer.ProductGroups;
            model.Configuration = dbContext.Configurations.FirstOrDefault();
            return View(model);
        }

        public ActionResult ReportChart(ReportIndexModel model)
        {
            Credential cred = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]));
            SemplestEntities dbContext = new SemplestEntities();
            model.AdvertisingEngines = dbContext.AdvertisingEngines;
            model.ProductGroups = dbContext.Credentials.Where(x => x.UsersFK == cred.UsersFK).First().User.Customer.ProductGroups;
            model.Configuration = dbContext.Configurations.FirstOrDefault();
            return PartialView(model);
        }
        public ActionResult ReportGraph(int promotionFk, int advertisingEngineFk, DateTime? startDate, DateTime? endDate)
        {
            SemplestEntities dbContext = new SemplestEntities();
            var reportDate = dbContext.vwPromotionCharts.Where(t => t.PromotionFK == promotionFk && t.AdvertisingEngineFK == advertisingEngineFk);
            List<ReportChartModel> reports = new List<ReportChartModel>();
            List<ReportChartModel> reports1 = new List<ReportChartModel>();
            var grp = reportDate.GroupBy(t => t.TransactionDate);
            int count = grp.Count();
            foreach (var data in grp)
            {
                reports.Add(new ReportChartModel { Clicks = data.Sum(t => t.NumberClick), Impressions = data.Sum(t => t.NumberImpressions), Date = data.Key.ToString("MM/dd") });
            }
            var grp1 = reports.GroupBy(t => t.Date);
            foreach (var data in grp1)
            {
                reports1.Add(new ReportChartModel { Clicks = data.Sum(t => t.Clicks), Impressions = data.Sum(t => t.Impressions), Date = data.Key });
            }
            return Json(reports1, JsonRequestBehavior.AllowGet);
        }
    }
}
