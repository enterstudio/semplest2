using System;
using System.Collections.Generic;
using System.Web.Mvc;
using KendoGridBinder;
using Microsoft.Practices.EnterpriseLibrary.Logging;
using Semplest.Core.Models;
using Semplest.Core.Models.Repositories;
using SemplestWebApp.Helpers;
using SemplestWebApp.Services;

namespace Semplest.Core.Controllers
{
    public class CampaignController : Controller
    {
        private ICampaignRepository campaignRepository;

        public CampaignController(ICampaignRepository iCampaignRepository)
        {
            campaignRepository = iCampaignRepository;
        }

        [AuthorizeRole]
        public ActionResult CampaignSetup()
        {
            var logEnty = new LogEntry {ActivityId = Guid.NewGuid(), Message = "Loading"};
            Logger.Write(logEnty);
            var logService = new LogService();
            logService.AddToLog(1, "Campaign Setup Accessed", "CampaignSetup//CampaignSetup//CampaignSetup", 1);
            var campaignSetupModel = new CampaignSetupModel();
            return View(campaignSetupModel);
        }

        [HttpPost]
        public ActionResult CampaignSetup(CampaignSetupModel model)
        {
            if (ModelState.IsValid)
            {
                var service = new SemplestDataService();
                service.SaveAd(model);
            }
            return View(model);
        }

        [HttpPost]
        public JsonResult AdditionalLinks(KendoGridRequest request)
        {
            var employees = new List<AdditionalLinks>
                                {
                                    new AdditionalLinks {Id = 1, Name = "Bill", Url = "Jones"},
                                    new AdditionalLinks {Id = 2, Name = "Rob", Url = "Johnson"},
                                    new AdditionalLinks {Id = 3, Name = "Jane", Url = "Smith"},
                                };
            var grid = new KendoGrid<AdditionalLinks>(request, employees);
            return Json(grid);
        }

        [HttpPost]
        public void UpdateAdditionalLinks(KendoGridRequest request)
        {
        }

        public ActionResult SaveDefineProduct(string data)
        {
            return Json(campaignRepository.Save(data),JsonRequestBehavior.AllowGet);
        }
    }
}