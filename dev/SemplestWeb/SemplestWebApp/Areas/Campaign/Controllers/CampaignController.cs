using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestWebApp.Models;
using KendoGridBinder;
using SemplestWebApp.Services;
using Microsoft.Practices.EnterpriseLibrary.Logging;

namespace SemplestWebApp.Areas.Campaign.Controllers
{
    public class CampaignController : Controller
    {
        //
        // GET: /Campign/Campign/

        public ActionResult CampaignSetup()
        {
            LogEntry logEnty = new LogEntry();
            logEnty.ActivityId = Guid.NewGuid();
            logEnty.Message = "Loading CampaignSetup";
            Logger.Write(logEnty);
            return View();
        }

        public ActionResult GetAddress()
        {
            return PartialView(new Address());
        }

        [HttpPost]
        public ActionResult CampaignSetup(CampaignSetupModel model)
        {
            if (ModelState.IsValid)
            {
                SemplestDataService service = new SemplestDataService();
                service.SaveAd(model);
            }
            return View(model);
        }

        [HttpPost]
        public JsonResult AdditionalLinks(KendoGridRequest request)
        {
            var employees = new List<AdditionalLinks>
            {
                new AdditionalLinks { Id = 1, Name = "Bill", Url= "Jones"},
                new AdditionalLinks { Id = 2, Name = "Rob", Url = "Johnson"},
                new AdditionalLinks { Id = 3, Name = "Jane", Url = "Smith"},
            };
            var grid = new KendoGrid<AdditionalLinks>(request, employees);
            return Json(grid);
        }

        [HttpPost]
        public void UpdateAdditionalLinks(KendoGridRequest request)
        {
        }

    }
}
