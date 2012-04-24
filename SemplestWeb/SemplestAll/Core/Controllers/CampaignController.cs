﻿using System;
using System.Collections.Generic;
using System.Web.Mvc;
using System.Reflection;
using KendoGridBinder;
using Microsoft.Practices.EnterpriseLibrary.Logging;
using Semplest.Core.Models;
using Semplest.Core.Models.Repositories;
using SemplestWebApp.Helpers;
using SemplestWebApp.Services;
using Semplest.SharedResources.Helpers;

namespace Semplest.Core.Controllers
{
    [AuthorizeRole]
    public class CampaignController : Controller
    {
        private readonly ICampaignRepository _campaignRepository;

        public CampaignController(ICampaignRepository iCampaignRepository)
        {
            _campaignRepository = iCampaignRepository;
        }

        public ActionResult CampaignSetup()
        {
            //var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "Loading" };
            //Logger.Write(logEnty);
            //var logService = new LogService();
            //logService.AddToLog(1, "Campaign Setup Accessed", "CampaignSetup//CampaignSetup//CampaignSetup", 1);
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
                    Session.Add("AdModelProp", model.AdModelProp);
                    Session.Add("ProductGroup", model.ProductGroup);
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
                {
                    model.AllCategories = (List<CampaignSetupModel.CategoriesModel>)Session["AllCategories"];
                    model = _campaignRepository.GetKeyWords(model);
                    Session.Add("FullModel", model);
                }
                return PartialView("KeyWords", model);
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
            model.AllCategories = (List<CampaignSetupModel.CategoriesModel>)Session["AllCategories"];
            return PartialView(model);
        }
        public ActionResult KeyWords(CampaignSetupModel model)
        {
            model = (CampaignSetupModel)Session["FullModel"];
            return PartialView(model);
        }
        public ActionResult BillingLaunch(CampaignSetupModel model)
        {
            return PartialView(model);
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