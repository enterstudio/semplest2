using System;
using System.Web.Mvc;
using System.Reflection;
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
        private readonly ICampaignRepository _campaignRepository;

        public CampaignController(ICampaignRepository iCampaignRepository)
        {
            _campaignRepository = iCampaignRepository;
        }

        [AuthorizeRole]
        public ActionResult CampaignSetup()
        {
            var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "Loading" };
            Logger.Write(logEnty);
            var logService = new LogService();
            logService.AddToLog(1, "Campaign Setup Accessed", "CampaignSetup//CampaignSetup//CampaignSetup", 1);
            var campaignSetupModel = new CampaignSetupModel();
            return View(campaignSetupModel);
        }


        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "GetCategories")]
        public ActionResult GetCategories(CampaignSetupModel model)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    model = _campaignRepository.GetCategories(model);
                    // save this some how while getting the keywords this is becoming null
                    Session.Add("AllCategories", model.AllCategories);
                }
                return PartialView("Categories", model);
            }
            catch (Exception)
            {
                return View(model);
            }
        }

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "GetKeywords")]
        public ActionResult GetKeywords(CampaignSetupModel model)
        {
            try
            {
                if (ModelState.IsValid)
                    model = _campaignRepository.GetKeyWords(model);
                return View(model);
            }
            catch (Exception)
            {
                //string err = ex.Message + "\\r\\n" + ex.StackTrace;
                return View(model);
            }
        }

        #region Nested type: AcceptSubmitTypeAttribute

        public class AcceptSubmitTypeAttribute : ActionMethodSelectorAttribute
        {
            public string Name { get; set; }
            public string Type { get; set; }

            public override bool IsValidForRequest(ControllerContext controllerContext, MethodInfo methodInfo)
            {
                return controllerContext.RequestContext.HttpContext
                           .Request.Form[Name] == Type;
            }
        }

        #endregion

        public ActionResult AdModel(AdModel model)
        {
            return PartialView(model);
        }
        
        public ActionResult AdditionalLinks()
        {
            return PartialView();
        }
        public ActionResult NegativeKeyWords()
        {
            return PartialView();
        }
        public ActionResult Categories(CampaignSetupModel model)
        {
            return PartialView(model);
        }
        public ActionResult KeyWords()
        {
            return PartialView();
        }
        [HttpPost]
        public void UpdateAdditionalLinks(KendoGridRequest request)
        {
        }

        public ActionResult SaveDefineProduct(CampaignSetupModel data)
        {
            if (data == null)
                return Json(0);
            return Json(123);
            // return Json(campaignRepository.Save(data),JsonRequestBehavior.AllowGet);
        }
    }
}