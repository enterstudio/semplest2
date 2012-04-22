using System;
using System.Collections.Generic;
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
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "GetCategories")]
        public ActionResult GetCategories(CampaignSetupModel model)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    var scw = new ServiceClientWrapper();

                    // create AdCopy array
                    var promAds = model.Ads;
                    List<string> liAddcopies = new List<string>();
                    foreach (PromotionAd pAd in promAds)
                    {
                        liAddcopies.Add(pAd.AdText);
                    }

                    // get categories or classifications
                    List<string> categories = scw.GetCategories(null, model.ProductGroup.ProductPromotionName, 
                                                model.ProductGroup.Words, liAddcopies.ToArray(), model.Url);

                    // create categories list that will be displayed in a multiselect list box
                    if (categories != null && categories.Count > 0)
                    {
                        for (int i = 0; i < categories.Count; i++)
                        {
                            var cm = new CampaignSetupModel.CategoriesModel { Id = i, Name = categories[i] };
                            model.AllCategories.Add(cm);
                        }
                    }
                    else
                    {
                        var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "Could not get Categories from web service" };
                        Logger.Write(logEnty);
                    }

                    // save this some how while getting the keywords this is becoming null
                    Session.Add("AllCategories", model.AllCategories);
                }
                return View(model);
            }
            catch (Exception ex)
            {
                string err = ex.Message + "\\r\\n" + ex.StackTrace;
                //CreateDummyModel(model);
                //ViewBag.AllCategories = model.AllCategories;
                //Session.Add("AllCategories", model.AllCategories);
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
                    if (model.AllCategories.Count == 0)
                    {
                        model.AllCategories = (List<CampaignSetupModel.CategoriesModel>)Session["AllCategories"];
                    }

                    if (model.AllCategories.Count <= 0)
                    {
                    }

                    var catList = new List<string>();

                    foreach (CampaignSetupModel.CategoriesModel cat in model.AllCategories)
                    {
                        for (int i = 0; i < model.CategoryIds.Length; i++)
                        {
                            if (cat.Id == model.CategoryIds[i])
                            {
                                catList.Add(cat.Name);
                            }
                        }
                    }

                    var scw = new ServiceClientWrapper();
                    // create AdCopy array
                    var promAds = model.Ads;
                    List<string> liAddcopies = new List<string>();
                    foreach (PromotionAd pAd in promAds)
                    {
                        liAddcopies.Add(pAd.AdText);
                    }

                    // get keywords from the web service
                    //List<string> keywords = scw.GetKeywords(catList, null, "coffee machine", null, null, "http://www.wholelattelove.com", null);
                    List<string> keywords = scw.GetKeywords(catList, null, model.ProductGroup.ProductPromotionName,
                                                    model.ProductGroup.Words, liAddcopies.ToArray(), model.Url, null);
                    if (keywords != null && keywords.Count > 0)
                    {
                        int i = 0;
                        foreach (string key in keywords)
                        {
                            var kwm = new CampaignSetupModel.KeywordsModel();
                            kwm.Name = key;
                            model.AllKeywords.Add(kwm);
                        }
                    }
                    else
                    {
                        var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "Could not get Keywords from web service" };
                        Logger.Write(logEnty);
                    }
                }

                return View(model);
            }
            catch (Exception ex)
            {
                string err = ex.Message + "\\r\\n" + ex.StackTrace;
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