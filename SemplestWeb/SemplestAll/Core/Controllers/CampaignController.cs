
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web.Mvc;
using System.Reflection;
using Kendo.Mvc.Extensions;
using Kendo.Mvc.UI;
using KendoGridBinder;
using Semplest.Core.Models;
using Semplest.Core.Models.Repositories;
using SemplestModel;
using Semplest.SharedResources.Helpers;
using System.Configuration;
using Semplest.SharedResources.Services;
using SharedResources.Helpers;
using SharedResources.Models.Repositories;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [RequireHttpsHelper]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class CampaignController : Controller
    {
        private readonly ICampaignRepository _campaignRepository;

        public CampaignController(ICampaignRepository iCampaignRepository)
        {
            _campaignRepository = iCampaignRepository;
        }

        public ActionResult CampaignSetup(CampaignSetupModel cs)
        {
            Session["SiteLinks"] = null;
            Session["NegativeKeywords"] = null;
            Session["NegativeKeywordsText"] = null;
            Session["CampaignSetupModel"] = cs;
            Session["AllCategories"] = null;
            ViewBag.IsLaunched = false;
            ViewBag.IsCompleted = false;
            ViewBag.IsLaunchedAndCompleted = false;
            cs.AdModelProp.IsNew = true;
            var dbContext = new SemplestModel.Semplest();
            var userid =
                ((Credential)System.Web.HttpContext.Current.Session[SharedResources.SEMplestConstants.SESSION_USERID]).
                    UsersFK;
            cs.BillType = dbContext.Users.First(key => key.UserPK == userid).Customer.BillTypeFK;
            cs.ProductGroup.AllowAutoBid = dbContext.Users.Single(key => key.UserPK == userid).Customer.AllowAutobid;
            return View(cs);
        }

        [HttpGet]
        [RequireRequestValue("promotionId")]
        public ActionResult CampaignSetup(int promotionId)
        {

            var campaignSetupModel = _campaignRepository.GetCampaignSetupModelForPromotionId(promotionId);
            var i = 1;
            campaignSetupModel.AdModelProp.Ads.ForEach(t => t.SerailNo = i++);

            if (campaignSetupModel.AdModelProp.Addresses.Count == 0)
                campaignSetupModel.AdModelProp.Addresses.Add(new GeoTargeting());

            Session["AllCategories"] = null;

            // set sitelinks in session
            //Session.Add("AddsStoreModel", new AddsStoreModel {Ads = campaignSetupModel.AdModelProp.Ads.ToList()});
            Session["SiteLinks"] = campaignSetupModel.SiteLinks;
            // set negative keywords in session
            Session["NegativeKeywords"] = campaignSetupModel.AdModelProp.NegativeKeywords;
            Session["NegativeKeywordsText"] = campaignSetupModel.AdModelProp.NegativeKeywordsText;

            campaignSetupModel.ProductGroup.IsEdit = true;
            ViewBag.Title = campaignSetupModel.ProductGroup.ProductGroupName + " " +
                            campaignSetupModel.ProductGroup.ProductPromotionName;
            //campaignSetupModel.IsCompleted = true;
            ViewBag.IsLaunched = campaignSetupModel.IsLaunched;
            ViewBag.IsCompleted = campaignSetupModel.IsCompleted;
            ViewBag.IsLaunchedAndCompleted = campaignSetupModel.IsLaunched && campaignSetupModel.IsCompleted;
            ViewBag.IsNew = false;
            Session["CampaignSetupModel"] = campaignSetupModel;
            return View(campaignSetupModel);
        }

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "GetCategories")]
        public ActionResult GetCategories(CampaignSetupModel model)
        {
            try
            {
                model.SiteLinks = (List<SiteLink>) Session["SiteLinks"];
                model.AdModelProp.NegativeKeywords = (List<string>) Session["NegativeKeywords"];

                // we need save to database the ProductGroup and Promotion information
                //int userid = (int)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID];

                var newIds = _campaignRepository.SaveGeoTargetingAds(GetCustomerId(), model,
                                                                     (CampaignSetupModel)
                                                                     Session["CampaignSetupModel"]);
                if (!newIds.IsException && !newIds.IsValidationError)
                {
                    var csm = (CampaignSetupModel) Session["CampaignSetupModel"];
                    if (!String.IsNullOrEmpty(newIds.ReturnMessage))
                    {
                        foreach (var nvp in newIds.ReturnMessage.Split(',').Select(items => items.Split('=')))
                        {
                            var item = model.AdModelProp.Addresses.SingleOrDefault(t => t.UID == nvp[0]);
                            if (item != null)
                                item.GeoTargetingPK = int.Parse(nvp[1]);
                            else
                                model.AdModelProp.Ads.Single(t => t.UID == nvp[0]).PromotionAdsPK = int.Parse(nvp[1]);
                        }
                    }
                    csm.AdModelProp.Addresses = model.AdModelProp.Addresses;
                    csm.AdModelProp.Ads = model.AdModelProp.Ads;
                    // get the categoris from the web service
                    model = _campaignRepository.GetCategories(model);
                    if (model == null)
                        return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
                    Session.Add("AllCategories", model.AllCategories);
                    return Json(new {newKeys = newIds.ReturnMessage, name = "Categories"});
                }
                if (!newIds.IsException && newIds.IsValidationError)
                    return Json("Validation Error<~> " + newIds.ReturnMessage);

                if (newIds.ReturnMessage.Contains("Not a valid description"))
                    return
                        Json(
                            "Invalid Description<~>Please check your Landing URL and your words/phrases<br>describing your business.  The System was unable to<br>determine Keyword Categories.");
                if (newIds.ReturnMessage.ToLower().Contains("no service for"))
                {
                    return
                        Json(
                            "Services not available<~>Sorry, the Ad Engine Services are currently not available. Please try again in a few minutes. If this problem continues, please contact SEMplest.");
                }
                if (newIds.ReturnMessage.ToLower().Contains("geotarget limit"))
                {
                    return
                        Json(
                            "Too many cities<~>Your target selections are over the limit.");
                }
                return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                 return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
            }
        }


        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "GetKeywords")]
        public ActionResult GetKeywords(CampaignSetupModel model)
        {
            try
            {
                model.AllCategories = (List<CampaignSetupModel.CategoriesModel>)Session["AllCategories"];
                model.AdModelProp.NegativeKeywords = (List<string>)Session["NegativeKeywords"];
                model.AdModelProp.NegativeKeywordsText = (string)Session["NegativeKeywordsText"];

                if (!model.CategoryIds.Any())
                    return Json("At least one category needs to be selected");


                // get selected categories
                var catList = new List<string>();
                foreach (var cat in model.AllCategories)
                {
                    catList.AddRange(from t in model.CategoryIds where cat.Id == t select cat.Name);
                }

                // save the selected categories here
                //int userid = (int)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID];
                int userid =
                    ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;

                var dbcontext = new SemplestModel.Semplest();
                var promotionRepository = new PromotionRepository(dbcontext);
                var promoId = promotionRepository.GetPromotionId(userid, model.ProductGroup.ProductGroupName,
                                                model.ProductGroup.ProductPromotionName);
                _campaignRepository.SaveSelectedCategories(promoId, catList);
                model = _campaignRepository.GetKeyWords(model, promoId);
                if (model != null)
                {
                    model.BillingLaunch.KeywordsCount =
                        model.AllKeywordProbabilityObjects.Count(x => x.isDeleted == false);
                    Session.Add("CampaignSetupModel", model);
                    return Json("Billing & Launch");
                }
                return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
            }
        }

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "SaveProductPromotion")]
        public ActionResult SaveProductPromotion(CampaignSetupModel model)
        {
            try
            {
                if (model.AdModelProp.IsNew &&
                    _campaignRepository.DoesPromotionExist(model.ProductGroup.ProductGroupName,
                                                           model.ProductGroup.ProductPromotionName, GetCustomerId()))
                {
                    return Json("The promotion already exists.");
                }
                _campaignRepository.SaveProductPromotion(GetCustomerId(), model, (CampaignSetupModel)
                                                                        Session["CampaignSetupModel"]);
                Session["CampaignSetupModel"] = model;
                return Json("Create Ads");
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                return Json(ExceptionHelper.GetErrorMessage(ex));
            }
        }

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "LaunchAdProduct")]
        public ActionResult LaunchAdProduct(CampaignSetupModel model)
        {
            try
            {
                var dbContext = new SemplestModel.Semplest();
                var cr = new CreditCardRepository(dbContext);
                var sr = new StateRepository(dbContext);
                var pr = new PromotionRepository(dbContext);
                var bt = new BillTypeRepository(dbContext);
                var promo = pr.GetPromoitionFromCampaign(GetCustomerId(), model.ProductGroup.ProductGroupName,
                                                         model.ProductGroup.ProductPromotionName);
                var retVal = new ReturnState(false,false,"Not a credit card customer", null);
                if (model.BillType == bt.GetBillTypeCode("Credit Card"))
                {
                    retVal = cr.ChargeCreditCard(new CustomerObject
                                                         {
                                                             Address1 = model.BillingLaunch.Address,
                                                             City = model.BillingLaunch.City,
                                                             Email = model.BillingLaunch.Email,
                                                             StateAbbr =
                                                                 sr.GetStateNameFromCode(
                                                                     int.Parse(model.BillingLaunch.StateCodeFK)),
                                                             ExpireDateMMYY =
                                                                 model.BillingLaunch.ExpiryMonth +
                                                                 model.BillingLaunch.ExpiryYear,
                                                             FirstName = model.BillingLaunch.FirstName,
                                                             LastName = model.BillingLaunch.LastName,
                                                             Phone = model.BillingLaunch.Phone,
                                                             ZipCode = model.BillingLaunch.Zip,
                                                             creditCardNumber = model.BillingLaunch.CardNumber
                                                         }, promo, model.BillType, model.ProductGroup.Budget);
                }
                try
                {
                    if (!retVal.IsException && !retVal.IsValidationError)
                    {
                        dbContext.SaveChanges();
                        var adEngines = new List<string>();
                        adEngines.AddRange(
                            promo.PromotionAdEngineSelecteds.Select(
                                pades => pades.AdvertisingEngine.AdvertisingEngine1));
                        var sw = new ServiceClientWrapper();
                        if (sw.ScheduleAddPromotionToAdEngine(GetCustomerId(), promo.ProductGroupFK,
                                                              promo.PromotionPK, adEngines.ToArray()))
                        {
                            pr.SetPromotionToLaunched(promo.PromotionPK);
                            dbContext.SaveChanges();
                        }
                        return Json(retVal.ReturnMessage);
                    }
                }
                catch (Exception ex)
                {
                    ExceptionHelper.LogException(ex);
                    return Json(retVal.ReturnMessage);
                }
                if (!retVal.IsException && retVal.IsValidationError)
                    return Json("Validation Error<~> " + retVal.ReturnMessage);
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
            }
            return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
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

       public ActionResult AdditionalLinks()
        {
            var siteLInks = (List<SiteLink>)Session["SiteLinks"];
            var campaignModel = (CampaignSetupModel)Session["CampaignSetupModel"];
            if (siteLInks == null)
                siteLInks = new List<SiteLink> { new SiteLink() };
            campaignModel.SiteLinks = siteLInks;
            return PartialView(campaignModel);
        }


        public ActionResult CreateAds()
        {
            int userid = ((Credential) (Session[SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
            var sessModel = (CampaignSetupModel)Session["CampaignSetupModel"];
            var dbcontext = new SemplestModel.Semplest();
            var promoRepository = new PromotionRepository(dbcontext);
            var promoid = promoRepository.GetPromotionId(userid, sessModel.ProductGroup.ProductGroupName, sessModel.ProductGroup.ProductPromotionName);
            var campaignModel = _campaignRepository.GetCampaignSetupModelForPromotionId(promoid);
            Session["CampaignSetupModel"] = campaignModel;
            return PartialView("EditorTemplates/AdModel", campaignModel.AdModelProp);
        }

        //[HttpPost]
        //[ActionName("CampaignSetup")]
        //[AcceptSubmitType(Name = "Command", Type = "SetAdditionalLinks")]
        //public ActionResult SetAdditionalLinks(PromotionAd model)
        //{
        //    //model.AdTitle = (string) Session["AdTitle"];
        //    //if (Session["AddsStoreModel"] == null)
        //    //{
        //    //    Session.Add("AddsStoreModel", new AddsStoreModel {Ads = new List<PromotionAd> {model}});
        //    //}
        //    //else
        //    //{
        //    //    var addsStoreModel = (AddsStoreModel) Session["AddsStoreModel"];
        //    //    var promotionAd = addsStoreModel.Ads.FirstOrDefault(t => t.AdTitle.Equals(model.AdTitle));
        //    //    if (promotionAd != null)
        //    //        promotionAd.SiteLinks = model.SiteLinks.Where(t => !t.Delete).ToList();
        //    //    else
        //    //        addsStoreModel.Ads.Add(model);
        //    //    Session["AddsStoreModel"] = addsStoreModel;
        //    //}
        //    return Json("AdditionalLinks");
        //}

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "SetAdditionalLinks")]
        public ActionResult SetAdditionalLinks(CampaignSetupModel model)
        {
            try
            {
                Session["SiteLinks"] = model.SiteLinks.Where(t => t.Delete).ToList();
                var newIds = _campaignRepository.SaveSiteLinks(model, GetCustomerId(),
                                                               (CampaignSetupModel) Session["CampaignSetupModel"]);
                if (!newIds.IsException && !newIds.IsValidationError)
                {
                    var csm = (CampaignSetupModel) Session["CampaignSetupModel"];
                    if (!String.IsNullOrEmpty(newIds.ReturnMessage))
                    {
                        foreach (var nvp in newIds.ReturnMessage.Split(',').Select(items => items.Split('=')))
                        {
                            model.SiteLinks.Single(t => t.UID == nvp[0]).SiteLInkPK = int.Parse(nvp[1]);
                        }
                    }
                    csm.SiteLinks = model.SiteLinks;
                    return Json(new {newKeys = newIds.ReturnMessage, name = "AdditionalLinks"});
                }
                if (!newIds.IsException && newIds.IsValidationError)
                {
                    return Json("Validation Error<~> " + newIds.ReturnMessage);
                }
                return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
            }
        }

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "SetNegativeKeywords")]
        public ActionResult SetNegativeKeywords(AdModel model)
        {
            try
            {
                if (!string.IsNullOrEmpty(model.NegativeKeywordsText))
                {
                    var addl = model.NegativeKeywordsText.Split(',').ToList();
                    addl.ForEach(t => model.NegativeKeywords.Add(t.Trim()));
                }
                Session["NegativeKeywords"] = model.NegativeKeywords;
                Session["NegativeKeywordsText"] = model.NegativeKeywordsText;
                var csm = (CampaignSetupModel) Session["CampaignSetupModel"];
                csm.AdModelProp.NegativeKeywords = model.NegativeKeywords;
                csm.AdModelProp.NegativeKeywordsText = model.NegativeKeywordsText;
                
                var rs = _campaignRepository.SaveNegativeKeywords(csm, GetCustomerId());
                if(!rs.IsException && !rs.IsValidationError)
                {
                    csm.AllKeywords.Clear();
                    csm.AllKeywords = (List<CampaignSetupModel.KeywordsModel>)rs.ReturnObject;
                    return Json("NegativeKeywords");
                }
                if (!rs.IsException && rs.IsValidationError)
                    return Json("Validation Error<~> " + rs.ReturnMessage);
                return Json(ConfigurationManager.AppSettings["TechnicalDifficulties"]);
                
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                return Json(ExceptionHelper.GetErrorMessage(ex));
            }
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

        public ActionResult Categories()
        {
            var model = (CampaignSetupModel)Session["CampaignSetupModel"];
            model.AllCategories = (List<CampaignSetupModel.CategoriesModel>) Session["AllCategories"];
            if (model.AllCategories == null)
            {
                model.AllCategories =new List<CampaignSetupModel.CategoriesModel>();
                model = _campaignRepository.GetCategories((CampaignSetupModel) Session["CampaignSetupModel"]);
                if (model == null)
                {
                    ViewData["TechnicalDifficulties"] = ConfigurationManager.AppSettings["TechnicalDifficulties"];
                    return PartialView(null);
                }
                Session["CampaignSetupModel"] = model;
                Session["AllCategories"] = model.AllCategories;
            }
            int userid = ((Credential) (Session[SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
            var dbcontext = new SemplestModel.Semplest();
            var promoRepository = new PromotionRepository(dbcontext);
            var promoId = promoRepository.GetPromotionId(userid, model.ProductGroup.ProductGroupName,
                                                             model.ProductGroup.ProductPromotionName);
            var dbContext = new SemplestModel.Semplest();
            var cats = dbContext.KeywordCategories.Where(x => x.PromotionFK == promoId);
            var i = 0;
            if (cats.Any())
            {
                foreach (CampaignSetupModel.CategoriesModel cm in model.AllCategories)
                {
                    if (cats.Any(x => x.KeywordCategory1 == cm.Name))
                        model.CategoryIds.Add(i);
                    i += 1;
                }
            }
            return PartialView(model);
        }

        public ActionResult KeyWords()
        {
            var model = (CampaignSetupModel)Session["CampaignSetupModel"];
            return PartialView(model);
        }

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "KeyWords")]
        public ActionResult KeyWords(CampaignSetupModel model, FormCollection fc)
        {
            try
            {
                int userid = ((Credential) (Session[SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
                var dbcontext = new SemplestModel.Semplest();
                var promoRepository = new PromotionRepository(dbcontext);
                var promoId = promoRepository.GetPromotionId(userid, model.ProductGroup.ProductGroupName,
                                                                 model.ProductGroup.ProductPromotionName);
                _campaignRepository.SetKeywordsDeleted(model.KeywordIds, promoId);
                var sessionModel = (CampaignSetupModel) Session["CampaignSetupModel"];
                sessionModel.AllKeywords.RemoveAll(key => model.KeywordIds.Contains(key.Id));
                model.BillingLaunch.KeywordsCount = sessionModel.AllKeywords.Count();
                Session["CampaignSetupModel"] = sessionModel;
                //model = sessionModel;
                return Json(new {count = model.BillingLaunch.KeywordsCount, name = "Keywords"});
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                return Json(ExceptionHelper.GetErrorMessage(ex));
            }
        }

        public ActionResult BillingLaunch()
        {
            var model = (CampaignSetupModel)Session["CampaignSetupModel"];
            if (model.AllKeywords != null)
                model.BillingLaunch.KeywordsCount = model.AllKeywords.Count();
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


        public ActionResult GetSideBar()
        {
            int userid = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
            //var sds = new SemplestDataService();
            var vwProductPromotions = _campaignRepository.GetUserWithProductGroupAndPromotions(userid);
            var navBars = new List<NavBar>();
            var productGroupsBar = new NavBar { Name = "Product Groups..", SubItems = new List<NavBar>() };
            foreach (var promotion in vwProductPromotions.GroupBy(t => new { t.ProductGroupPK, t.ProductGroupName }).OrderBy(x => x.Key.ProductGroupName))
            {
                var promotionBar = new NavBar
                {
                    Name = promotion.Key.ProductGroupName,
                    Id = promotion.Key.ProductGroupPK,
                    SubItems = new List<NavBar>()
                };
                string baseUrl;
                if ((bool)Session[SharedResources.SEMplestConstants.SESSION_ISKEYWORDBIDDING])
                    baseUrl = ConfigurationManager.AppSettings["CampaignUrl"];
                else
                    baseUrl = ConfigurationManager.AppSettings["SmartUrl"];
                    
                foreach (var prom in promotion.OrderBy(x => x.PromotionName))
                    promotionBar.SubItems.Add(new NavBar
                    {
                        Name = prom.PromotionName,
                        Id = prom.PromotionPK,
                        Url = baseUrl + prom.PromotionPK.ToString(CultureInfo.InvariantCulture)
                    });
                //promotionBar.SubItems.Add(new NavBar { Name = prom.PromotionName, Id = prom.PromotionPK, Url = "../Campaign/CampaignSetup?promotionId=" + prom.PromotionPK.ToString() });

                productGroupsBar.SubItems.Add(promotionBar);
            }
            navBars.Add(productGroupsBar);
            return Json(navBars, JsonRequestBehavior.AllowGet);
        }


        [RequireRequestValue("promotionId")]
        public ActionResult Preview(int promotionId)
        {
            var campaignSetupModel = _campaignRepository.GetCampaignSetupModelForPromotionId(promotionId, true);
            //set sitelinks in session
            //if (!string.IsNullOrEmpty(campaignSetupModel.ProductGroup.StartDate))
            //    campaignSetupModel.ProductGroup.StartDate =
            //        Convert.ToDateTime(campaignSetupModel.ProductGroup.StartDate).ToString("MM/dd/yyyy");
            //if (!string.IsNullOrEmpty(campaignSetupModel.ProductGroup.EndDate))
            //    campaignSetupModel.ProductGroup.EndDate =
            //        Convert.ToDateTime(campaignSetupModel.ProductGroup.EndDate).ToString("MM/dd/yyyy");
            Session.Add("AddsStoreModel", new AddsStoreModel { Ads = campaignSetupModel.AdModelProp.Ads.ToList() });

            // set negative keywords in session
            Session["NegativeKeywords"] = campaignSetupModel.AdModelProp.NegativeKeywords;
            Session["NegativeKeywordsText"] = campaignSetupModel.AdModelProp.NegativeKeywordsText;

            campaignSetupModel.ProductGroup.IsEdit = true;
            return PartialView(campaignSetupModel);
        }

        [RequireRequestValue("HelpId")]
        public ActionResult DisplayHelp(int helpId)
        {
            var dbcontext = new SemplestModel.Semplest();

            return Content(dbcontext.WebContentQuestionMarkHelps.Single(h => h.WebContentQuestionMarkHelpPK == helpId).Copy);
        }

        public ActionResult Billing()
        {
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var dbContext = new SemplestModel.Semplest();
            IQueryable<Credential> cCred = dbContext.Credentials.Where(x => x.UsersFK == cred.UsersFK);
            ViewBag.Title = cCred.First().User.FirstName + " " + cCred.First().User.LastName + " - " + cCred.First().User.Customer.Name;
            return View(new BillingModel());
        }
        public ActionResult Billing_Read([DataSourceRequest] DataSourceRequest request)
        {
            return Json(GetBillingModel().ToDataSourceResult(request));
            //Select * from vwCreditCardTransacitonDetail where customer.customerID = Session CustomerID order by descending(dbo.CreditCardTransaction.CreatedDate)
        }
        private static IEnumerable<BillingModel> GetBillingModel()
        {
            var northwind = new SemplestModel.Semplest();

            return northwind.vwCreditCardTransactionDetails.Where(t => t.CustomerPK == 1).Select(product => new BillingModel
            {
                Amount = product.Amount,
                ProductGroupName = product.ProductGroupName,
                PromotionName = product.PromotionName,
                MediaSpend = product.MediaSpend,
                SEMplestFee = product.SEMplestFee
            });
        }

        private int GetCustomerId()
        {
            var customerFk =
                ((Credential) System.Web.HttpContext.Current.Session[SharedResources.SEMplestConstants.SESSION_USERID]).
                    User.CustomerFK;
            return customerFk != null ? customerFk.Value : -1;
        }
    }
}