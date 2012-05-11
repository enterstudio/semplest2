
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;
using System.Reflection;
using System.Threading;
using KendoGridBinder;
using Microsoft.Practices.EnterpriseLibrary.Logging;
using Semplest.Core.Models;
using Semplest.Core.Models.Repositories;
using SemplestModel;
using SemplestWebApp.Helpers;
using SemplestWebApp.Services;
using Semplest.SharedResources.Helpers;
using Semplest.SharedResources.Services;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    public class CampaignController : Controller
    {
        private readonly ICampaignRepository _campaignRepository;
        private Thread _workerThread;

        public CampaignController(ICampaignRepository iCampaignRepository)
        {
            _campaignRepository = iCampaignRepository;
        }

        public ActionResult CampaignSetup()
        {
            var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "Loading CampaignSetup Controller" };
            Logger.Write(logEnty);
            //var logService = new LogService();
            //logService.AddToLog(1, "Campaign Setup Accessed", "CampaignSetup//CampaignSetup//CampaignSetup", 1);
            //var scw = new ServiceClientWrapper();
            //scw.SendEmail("subject", "manik@agencystrategies.com", "andre@agencystrategies.com", "test mail");

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
                var addsStoreModel = (AddsStoreModel)Session["AddsStoreModel"];
                if (addsStoreModel != null)
                {
                    foreach (var ad in addsStoreModel.Ads)
                    {
                        var admodel = model.AdModelProp.Ads.FirstOrDefault(t => t.AdTitle == ad.AdTitle);
                        if (admodel != null)
                        {
                            admodel.SiteLinks = ad.SiteLinks;
                        }
                    }
                }
                //model.AdModelProp.SiteLinks = (List<SiteLink>)Session["SiteLinks"];
                model.AdModelProp.NegativeKeywords = (List<string>)Session["NegativeKeywords"];
                // we need save to database the ProductGroup and Promotion information
                //int userid = (int)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID];
                int userid = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;

                //int userid = 1; // for testing
                string msg = "In GetCategories ActionResult for --- ProductGroup: {0} --- Promotion: {1} --- Before saving  SaveProductGroupAndCampaign to database";
                msg = String.Format(msg, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
                var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = msg };
                Logger.Write(logEnty);

                SemplestDataService ds = new SemplestDataService();
                ds.SaveProductGroupAndCampaign(userid, model);

                msg = "In GetCategories ActionResult for --- ProductGroup: {0} --- Promotion: {1} After saving  SaveProductGroupAndCampaign";
                msg = String.Format(msg, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
                logEnty.Message = msg;
                Logger.Write(logEnty);

                msg = "In GetCategories ActionResult for --- ProductGroup: {0} --- Promotion: {1} Before getting categories form web service";
                msg = String.Format(msg, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
                logEnty.Message = msg;
                Logger.Write(logEnty);

                // get the categoris from the web service
                model = _campaignRepository.GetCategories(model);

                msg = "In GetCategories ActionResult for --- ProductGroup: {0} --- Promotion: {1} After successfully getting categories form web service";
                msg = String.Format(msg, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
                logEnty.Message = msg;
                Logger.Write(logEnty);

                // save this some how while getting the keywords this is becoming null
                Session.Add("AllCategories", model.AllCategories);
                //Session.Add("AdModelProp", model.AdModelProp);
                //Session.Add("ProductGroup", model.ProductGroup);
                return Json("Categories");
            }
            return View(model);
        }

        private void WriteLog(string msg, CampaignSetupModel model)
        {
            msg = String.Format(msg, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
            var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = msg };
            Logger.Write(logEnty);
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
                int userid = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
                //int userid = 1; // for testing

                String msg = "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} --- Before saving  SaveProductGroupAndCampaign to database";
                WriteLog(msg, model);

                SemplestDataService ds = new SemplestDataService();
                int promoId = ds.GetPromotionId(userid, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
                ds.SaveSelectedCategories(promoId, catList);

                msg = "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} After saving  SaveProductGroupAndCampaign";
                WriteLog(msg, model);

                msg = "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} Before getting keywords form web service";
                WriteLog(msg, model);

                // get the keywords from web service
                model = _campaignRepository.GetKeyWords(model);

                msg = "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} After getting keywords form web service";
                WriteLog(msg, model);

                msg = "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} Before saving keywords to database";
                WriteLog(msg, model);

                // save the keywords to database
                //ds.SaveKeywords(promoId, model);
                ThreadData tData = new ThreadData(promoId, model);
                _workerThread = new Thread(new ParameterizedThreadStart(DoWorkFast));
                _workerThread.Start(tData);
                

                msg = "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} After saving keywords to database";
                WriteLog(msg, model);

                model.BillingLaunch.KeywordsCount = model.AllKeywords.Count;
                Session.Add("FullModel", model);
            }
            return Json("BillingLaunch");
        }

        public void DoWorkFast(object data)
        {
            ThreadData locData = (ThreadData)data;
            SemplestDataService ds = new SemplestDataService();
            ds.SaveKeywords(locData._promoId, locData._model);
        }

        class ThreadData
        {
            public int _promoId;
            public CampaignSetupModel _model;
            public ThreadData(int promoId, CampaignSetupModel model)
            {
                _promoId = promoId;
                _model = model;
            }
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
            var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "In LaunchAdProduct ActionResult" };
            Logger.Write(logEnty);

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
        public ActionResult AdditionalLinks(string model)
        {
            if (Session["AdTitle"] == null)
                Session.Add("AdTitle", model);
            else
                Session["AdTitle"] = model;
            //if (Session["SiteLinks"] != null)
            //    model.SiteLinks = (List<SiteLink>)Session["SiteLinks"];
            return PartialView(new PromotionAd { AdTitle = model });
            //return PartialView(model);
        }
        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "SetAdditionalLinks")]
        public ActionResult SetAdditionalLinks(PromotionAd model)
        {
            model.AdTitle = (string)Session["AdTitle"];
            if (Session["AddsStoreModel"] == null)
            {
                Session.Add("AddsStoreModel", new AddsStoreModel { Ads = new List<PromotionAd> { model } });
            }
            else
            {
                var addsStoreModel = (AddsStoreModel)Session["AddsStoreModel"];
                var promotionAd = addsStoreModel.Ads.FirstOrDefault(t => t.AdTitle.Equals(model.AdTitle));
                if (promotionAd != null)
                    promotionAd.SiteLinks = model.SiteLinks.Where(t => !t.Delete).ToList();
                else
                    addsStoreModel.Ads.Add(model);
                Session["AddsStoreModel"] = addsStoreModel;
            }
            return Json("AdditionalLinks");
        }
        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "SetNegativeKeywords")]
        public ActionResult SetNegativeKeywords(AdModel model)
        {
            if (string.IsNullOrEmpty(model.NegativeKeywordsText))
                return Json("NegativeKeywords");
            var addl = model.NegativeKeywordsText.Split(',').ToList();
            addl.ForEach(t => model.NegativeKeywords.Add(t));
            Session["NegativeKeywords"] = model.NegativeKeywords;
            Session["NegativeKeywordsText"] = model.NegativeKeywordsText;

            //SemplestDataService ds = new SemplestDataService();
            //int userid = 1;
            //CampaignSetupModel fullmodel = 
            //ds.SaveNegativeKeywords(userid, model);

            return Json("NegativeKeywords");
        }
        public ActionResult NegativeKeyWords(AdModel model)
        {
            if (Session["NegativeKeywords"] != null)
            {
                model.NegativeKeywords = (List<string>)Session["NegativeKeywords"];
                model.NegativeKeywordsText = (string)Session["NegativeKeywordsText"];
            }
            return PartialView(model);
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
        public ActionResult AdEngines(IEnumerable<AdEngineSelectModel> models)
        {
            return PartialView(models);
        }
        public ActionResult SaveDefineProduct(CampaignSetupModel data)
        {
            if (data == null)
                return Json(0);
            return Json(123);
            // return Json(campaignRepository.Save(data),JsonRequestBehavior.AllowGet);
        }

        public ActionResult GetSideBar()
        {
            var semplestEntities = new SemplestEntities();
            var promotions = semplestEntities.ProductGroups.Include("Promotions");
            var navBars = new List<NavBar>();
            var homeBar = new NavBar
            {
                Name = "Home",
                SubItems = new List<NavBar>
                                                 {
                                                     new NavBar {Name = "Quick Start Guide"},
                                                     new NavBar {Name = "FAQs"},
                                                     new NavBar {Name = "Contact Us"},
                                                     new NavBar {Name = "Create User"},
                                                     new NavBar {Name = "Campaign" , Url = "../Campaign/CampaignSetup"},
                                                     new NavBar {Name = "Search Keywords"}
                                                 }
            };
            navBars.Add(homeBar);
            var productGroupsBar = new NavBar { Name = "Product Groups..", SubItems = new List<NavBar>() };
            foreach (var promotion in promotions)
            {
                var promotionBar = new NavBar { Name = promotion.ProductGroupName, Id = promotion.ProductGroupPK, SubItems = new List<NavBar>() };
                foreach (var problem in promotionBar.SubItems)
                    promotionBar.SubItems.Add(new NavBar { Name = problem.Name, Id = problem.Id, Url = "../Campaign/CampaignSetup" });
                productGroupsBar.SubItems.Add(promotionBar);
            }
            navBars.Add(productGroupsBar);
            return Json(navBars, JsonRequestBehavior.AllowGet);
        }
    }
}