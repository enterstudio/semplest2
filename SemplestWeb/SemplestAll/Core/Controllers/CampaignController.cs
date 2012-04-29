using System;
using System.Collections.Generic;
using System.Linq;
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
    [ExceptionHelper]
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
            if (ModelState.IsValid)
            {
                // we need save to database the ProductGroup and Promotion information
                //int userid = (int)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID];
                int userid = 1; // for testing
                SemplestDataService ds = new SemplestDataService();
                ds.SaveProductGroupAndCampaign(userid, model);

                // get the categoris from the web service
                model = _campaignRepository.GetCategories(model);

                // save this some how while getting the keywords this is becoming null
                Session.Add("AllCategories", model.AllCategories);
                Session.Add("AdModelProp", model.AdModelProp);
                Session.Add("ProductGroup", model.ProductGroup);
            }
            return Json("Categories");
        }

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "GetKeywords")]
        public ActionResult GetKeywords(CampaignSetupModel model)
        {
            if (ModelState.IsValid)
            {
                model.AllCategories = (List<CampaignSetupModel.CategoriesModel>)Session["AllCategories"];

                // get selected categories
                var catList = new List<string>();
                foreach (var cat in model.AllCategories)
                {
                    catList.AddRange(from t in model.CategoryIds where cat.Id == t select cat.Name);
                }

                // save the selected categories here
                //int userid = (int)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID];
                int userid = 1; // for testing
                SemplestDataService ds = new SemplestDataService();
                int promoId = ds.GetPromotionId(userid, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
                ds.SaveSelectedCategories(promoId, catList);

                // get the keywords from web service
                model = _campaignRepository.GetKeyWords(model);

                // save the keywords here
                ds.SaveKeywords(promoId, new List<string>(model.AllKeywords.Select(m => m.Name)));

                model.BillingLaunch.KeywordsCount = model.AllKeywords.Count;
                Session.Add("FullModel", model);
            }
            return Json("BillingLaunch");
        }

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "LaunchAdProduct")]
        public ActionResult LaunchAdProduct(CampaignSetupModel model)
        {
            if (ModelState.IsValid)
            {
                model = (CampaignSetupModel)Session["FullModel"];
                //SemplestDataService ds = new SemplestDataService();
                //ds.SaveAd(model);
            }
            //return PartialView("KeyWords", model);
            return View();
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
            model = (CampaignSetupModel)Session["FullModel"];
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