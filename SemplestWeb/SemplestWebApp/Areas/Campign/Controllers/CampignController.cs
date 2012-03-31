using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestWebApp.Models;
using KendoGridBinder;
using SemplestWebApp.Services;

namespace SemplestWebApp.Areas.Campign.Controllers
{
    public class CampignController : Controller
    {
        //
        // GET: /Campign/Campign/

        public ActionResult CampignSetup()
        {
            return View();
        }

        [HttpPost]
        public ActionResult CampignSetup(CampaignSetupModel model)
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
