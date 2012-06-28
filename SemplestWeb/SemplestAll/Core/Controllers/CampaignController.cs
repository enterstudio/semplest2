
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web.Mvc;
using System.Reflection;
using System.Threading;
using Kendo.Mvc.Extensions;
using Kendo.Mvc.UI;
using KendoGridBinder;
using Microsoft.Practices.EnterpriseLibrary.Logging;
using Semplest.Core.Models;
using Semplest.Core.Models.Repositories;
using SemplestModel;
using Semplest.SharedResources.Helpers;
using System.Configuration;
using Semplest.SharedResources.Services;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class CampaignController : Controller
    {
        private readonly ICampaignRepository _campaignRepository;
        private Thread _workerThread;

        public CampaignController(ICampaignRepository iCampaignRepository)
        {
            _campaignRepository = iCampaignRepository;
        }

        public ActionResult CampaignSetup(CampaignSetupModel cs, string command)
        {

            if (command == "") command = "";

            var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = "Loading CampaignSetup Controller" };
            Logger.Write(logEnty);
            //var logService = new LogService();
            //logService.AddToLog(1, "Campaign Setup Accessed", "CampaignSetup//CampaignSetup//CampaignSetup", 1);
            //var scw = new ServiceClientWrapper();
            //scw.SendEmail("subject", "manik@agencystrategies.com", "andre@agencystrategies.com", "test mail");

            //var campaignSetupModel = new CampaignSetupModel();
            Session["SiteLinks"] = null;
            Session["NegativeKeywords"] = null;
            Session["NegativeKeywordsText"] = null;
            Session["CampaignSetupModel"] = cs;
            Session["AllCategories"] = null;
            ViewBag.IsLaunched = false;
            ViewBag.IsCompleted = false;
            ViewBag.IsLaunchedAndCompleted = false;
            ViewBag.IsNew = true;

            return View(cs);
        }

        [HttpGet]
        [RequireRequestValue("promotionId")]
        public ActionResult CampaignSetup(int promotionId)
        {

            //var logEnty = new LogEntry {ActivityId = Guid.NewGuid(), Message = "Loading CampaignSetup Controller"};
            //Logger.Write(logEnty);
            //var logService = new LogService();
            //logService.AddToLog(1, "Campaign Setup Accessed", "CampaignSetup//CampaignSetup//CampaignSetup", 1);
            //var scw = new ServiceClientWrapper();
            //scw.SendEmail("subject", "manik@agencystrategies.com", "andre@agencystrategies.com", "test mail");

            //var ds = new SemplestDataService();
            var campaignSetupModel = _campaignRepository.GetCampaignSetupModelForPromotionId(promotionId);

            // for ads
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
                if (ModelState.IsValid)
                {
                    model.SiteLinks = (List<SiteLink>)Session["SiteLinks"];
                    model.AdModelProp.NegativeKeywords = (List<string>)Session["NegativeKeywords"];
                    // we need save to database the ProductGroup and Promotion information
                    //int userid = (int)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID];
                    int userid =
                        ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;

                    //int userid = 1; // for testing
                    string msg =
                        "In GetCategories ActionResult for --- ProductGroup: {0} --- Promotion: {1} --- Before saving  SaveProductGroupAndCampaign to database";
                    msg = String.Format(msg, model.ProductGroup.ProductGroupName,
                                        model.ProductGroup.ProductPromotionName);
                    var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = msg };
                    Logger.Write(logEnty);

                    _campaignRepository.SaveProductGroupAndCampaign(userid, model, (CampaignSetupModel)Session["CampaignSetupModel"]);

                    msg =
                        "In GetCategories ActionResult for --- ProductGroup: {0} --- Promotion: {1} After saving  SaveProductGroupAndCampaign";
                    msg = String.Format(msg, model.ProductGroup.ProductGroupName,
                                        model.ProductGroup.ProductPromotionName);
                    logEnty.Message = msg;
                    Logger.Write(logEnty);

                    msg =
                        "In GetCategories ActionResult for --- ProductGroup: {0} --- Promotion: {1} Before getting categories form web service";
                    msg = String.Format(msg, model.ProductGroup.ProductGroupName,
                                        model.ProductGroup.ProductPromotionName);
                    logEnty.Message = msg;
                    Logger.Write(logEnty);

                    // get the categoris from the web service
                    model = _campaignRepository.GetCategories(model);

                    msg =
                        "In GetCategories ActionResult for --- ProductGroup: {0} --- Promotion: {1} After successfully getting categories form web service";
                    msg = String.Format(msg, model.ProductGroup.ProductGroupName,
                                        model.ProductGroup.ProductPromotionName);
                    logEnty.Message = msg;
                    Logger.Write(logEnty);

                    // save this some how while getting the keywords this is becoming null
                    Session.Add("AllCategories", model.AllCategories);
                    //Session.Add("AdModelProp", model.AdModelProp);
                    //Session.Add("ProductGroup", model.ProductGroup);
                    return Json("Categories");
                }
                return Json("ModelState Invalid required data is missing");

                //return View(model);
            }
            catch (Exception ex)
            {
                if (ex.Message.Contains("Not a valid description"))
                    return Json("Invalid Description<~>Please check your Landing URL and your words/phrases<br>describing your business.  The System was unable to<br>determine Keyword Categories.");
                else
                    return Json(ex.ToString());

            }
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
            try
            {
                if (ModelState.IsValid)
                {
                    model.AllCategories = (List<CampaignSetupModel.CategoriesModel>)Session["AllCategories"];
                    model.AdModelProp.NegativeKeywords = (List<string>)Session["NegativeKeywords"];
                    model.AdModelProp.NegativeKeywordsText = (string)Session["NegativeKeywordsText"];

                    if (!model.CategoryIds.Any())
                        return Json("Atleast one Category needs to be selected");


                    // get selected categories
                    var catList = new List<string>();
                    foreach (var cat in model.AllCategories)
                    {
                        catList.AddRange(from t in model.CategoryIds where cat.Id == t select cat.Name);
                    }

                    // save the selected categories here
                    //int userid = (int)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID];
                    int userid =
                        ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
                    //int userid = 1; // for testing

                    String msg =
                        "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} --- Before saving  SaveProductGroupAndCampaign to database";
                    WriteLog(msg, model);

                    //var ds = new SemplestDataService();
                    var promoId = _campaignRepository.GetPromotionId(userid, model.ProductGroup.ProductGroupName,
                                                    model.ProductGroup.ProductPromotionName);
                    _campaignRepository.SaveSelectedCategories(promoId, catList);

                    msg =
                        "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} After saving  SaveProductGroupAndCampaign";
                    WriteLog(msg, model);

                    msg =
                        "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} Before getting keywords form web service";
                    WriteLog(msg, model);

                    // get the keywords from web service
                    model = _campaignRepository.GetKeyWords(model, promoId);

                    msg =
                        "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} After getting keywords form web service";
                    WriteLog(msg, model);

                    msg =
                        "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} Before saving keywords to database";
                    WriteLog(msg, model);

                    msg =
                        "In GetKeywords ActionResult for --- ProductGroup: {0} --- Promotion: {1} After saving keywords to database";
                    WriteLog(msg, model);

                    model.BillingLaunch.KeywordsCount = model.AllKeywordProbabilityObjects.Count(x => x.isDeleted == false);
                    Session.Add("CampaignSetupModel", model);

                    return Json("BillingLaunch");
                }
                return Json("ModelState Invalid required data is missing");
            }
            catch (Exception ex)
            {
                if (ex.Message.Contains("Not enough data provided"))
                    return Json("Invalid words/phrases, URL or ADs<~>Please check your Landing URL and your words/phrases<br>describing your business.  The System was unable to<br>determine Keyword Categories.");
                else
                    return Json(ex.ToString());
            }
        }

        public void DoWorkFast(object data)
        {
            var locData = (ThreadData)data;
            //var ds = new SemplestDataService();
            //SemplestDataService.SaveKeywords(locData._promoId, locData._model);
        }

        private class ThreadData
        {
            public readonly int _promoId;
            public readonly CampaignSetupModel _model;

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
            ServiceClientWrapper sw = new ServiceClientWrapper();
            List<string> adEngines = new List<string>();
            if (ModelState.IsValid)
            {
                model = (CampaignSetupModel)Session["CampaignSetupModel"];
                //SemplestDataService ds = new SemplestDataService();
                //ds.SaveAd(model);
            }
            var dbContext = new SemplestModel.Semplest();
            //ProductGroup pg = dbContext.ProductGroups.Where(x => x.ProductGroupName == model.ProductGroup.ProductGroupName).First();
            //Promotion pm = dbContext.ProductGroups.Where(x => x.ProductGroupName==model.ProductGroup.ProductGroupName).First().Promotions.Where(p => p.PromotionName == model.ProductGroup.ProductPromotionName).First();
            var userid = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
            int customerFk = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).User.CustomerFK.Value;
            var pm =
                dbContext.Users.First(x => x.UserPK == userid).Customer.ProductGroups.First(
                    x => x.ProductGroupName == model.ProductGroup.ProductGroupName).Promotions.First(
                    p => p.PromotionName == model.ProductGroup.ProductPromotionName);
            foreach (PromotionAdEngineSelected pades in pm.PromotionAdEngineSelecteds)
                adEngines.Add(pades.AdvertisingEngine.AdvertisingEngine1);
            try
            {
                pm.IsLaunched = sw.scheduleAddPromotionToAdEngine(customerFk, pm.ProductGroupFK, pm.PromotionPK, adEngines.ToArray()); ;
            }
            catch (Exception ex)
            {
                var logEnty = new LogEntry { ActivityId = Guid.NewGuid(), Message = ex.Message };
                Logger.Write(logEnty);
                pm.IsLaunched = true;
            }
            dbContext.SaveChanges();
            //return PartialView("KeyWords", model);

            //return View();
            //return Json("Congratulations, Your Product has Launched!!!");
            // now we are showing the image with wait window so we don't to show this in message box
            return Json("");
            //return Json("LaunchAdProduct");

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

        //public ActionResult AdditionalLinks(string model)
        //{
        //    //if (Session["AdTitle"] == null)
        //    //    Session.Add("AdTitle", model);
        //    //else
        //    //    Session["AdTitle"] = model;
        //    //var addsStoreModel = (AddsStoreModel) Session["AddsStoreModel"];
        //    //PromotionAd promotionAd;
        //    //if (addsStoreModel != null)
        //    //{
        //    //    promotionAd = addsStoreModel.Ads.FirstOrDefault(t => t.AdTitle.Equals(model));
        //    //    if (promotionAd != null)
        //    //        promotionAd.SiteLinks = promotionAd.SiteLinks.Where(t => !t.Delete).ToList();
        //    //}
        //    //else
        //    //{
        //    //    promotionAd = new PromotionAd {AdTitle = model};
        //    //}
        //    //return PartialView(promotionAd);
        //    return PartialView();
        //    //return PartialView(model);
        //}

        public ActionResult AdditionalLinks()
        {
            var siteLInks = (List<SiteLink>)Session["SiteLinks"];
            var campaignModel = (CampaignSetupModel)Session["CampaignSetupModel"];
            if (siteLInks == null)
                siteLInks = new List<SiteLink>() { new SiteLink() };
            campaignModel.SiteLinks = siteLInks;
            return PartialView(campaignModel);
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
            Session["SiteLinks"] = model.SiteLinks.Where(t => !t.Delete).ToList();
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
            addl.ForEach(t => model.NegativeKeywords.Add(t.Trim()));
            Session["NegativeKeywords"] = model.NegativeKeywords;
            Session["NegativeKeywordsText"] = model.NegativeKeywordsText;
            //SemplestDataService.CheckForNegativeKeywords(model.NegativeKeywords);
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
            model = (CampaignSetupModel)Session["CampaignSetupModel"];
            return PartialView(model);
        }

        // this should be called when Save and Continue button clicked on Keywords page

        [HttpPost]
        [ActionName("CampaignSetup")]
        [AcceptSubmitType(Name = "Command", Type = "KeyWords")]
        public ActionResult KeyWords(CampaignSetupModel model, FormCollection fc)
        {
            int userid = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
            var promoId = _campaignRepository.GetPromotionId(userid, model.ProductGroup.ProductGroupName,
                                model.ProductGroup.ProductPromotionName);
            _campaignRepository.SetKeywordsDeleted(model.KeywordIds, promoId);
            CampaignSetupModel sessionModel = (CampaignSetupModel)Session["CampaignSetupModel"];
            sessionModel.AllKeywords.RemoveAll(key => model.KeywordIds.Contains(key.Id));
            model.BillingLaunch.KeywordsCount = sessionModel.AllKeywords.Count();
            Session["CampaignSetupModel"] = sessionModel;
            //model = sessionModel;
            return Json(new { count = model.BillingLaunch.KeywordsCount, name = "Keywords" });
        }

        public ActionResult BillingLaunch(CampaignSetupModel model)
        {
            model = (CampaignSetupModel)Session["CampaignSetupModel"];
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

                foreach (var prom in promotion.OrderBy(x => x.PromotionName))
                    promotionBar.SubItems.Add(new NavBar
                    {
                        Name = prom.PromotionName,
                        Id = prom.PromotionPK,
                        Url =
                            ConfigurationManager.AppSettings["CampaignUrl"] +
                            prom.PromotionPK.ToString(CultureInfo.InvariantCulture)
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

        [HttpPost]
        public ActionResult AddNewCard(FormCollection fc)
        {
            try
            {
                Credential c = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]));

                

                #region handle form data here....
                //handle form data
                if (fc["ExpirationDate"].ToString().Split(',')[0] == "-Select Month-" )
                { 
                    //no exp month has been selected
                }
                if (fc["ExpirationDate"].ToString().Split(',')[1] == "-Select Year-")
                { 
                    //no exp year has been selected
                }
                if (fc["CardNumber"].ToString() == "")
                {
                    //no card number entered
                }
                if (fc["FirstName"].ToString() == "")
                {
                    //no FirstName  entered
                }
                if (fc["LastName"].ToString() == "")
                {
                    //no LastName entered
                }
                if (fc["Address"].ToString() == "")
                {
                    //no Address entered
                }
                if (fc["City"].ToString() == "")
                {
                    //no City entered
                }
                if (fc["zip"].ToString() == "")
                {
                    //no zip entered
                }
                if (fc["phone"].ToString() == "")
                {
                    //no zip entered
                }
                if (fc["email"].ToString() == "")
                {
                    //no zip entered
                }

                #endregion

                //make api call 
                CustomerObject co = new CustomerObject() {  ExpireDateMMYY = fc["ExpirationDate"].ToString().Split(',')[0].ToString() + fc["ExpirationDate"].ToString().Split(',')[1],
                                                            creditCardNumber = fc["CardNumber"],
                                                            FirstName = fc["FirstName"].ToString(),
                                                            LastName = fc["FirstName"].ToString(),
                                                            Address1 = fc["Address"].ToString(),
                                                            City = fc["City"].ToString(),
                                                            ZipCode = fc["zip"].ToString(),
                                                            Phone = fc["phone"].ToString(),
                                                            Email = fc["email"].ToString(),
                                                             StateAbbr=fc["state"].ToString()};

                ServiceClientWrapper scw=new ServiceClientWrapper();
                GatewayReturnObject myret = scw.CreateProfile(co);
                if (myret.Message != "Profile Request Processed") throw new Exception();
                if (myret.isGood != true) throw new Exception();


                string customerreferencenumber = myret.CustomerRefNum.ToString();
                var dbContext = new SemplestModel.Semplest();
                var custid = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).User.Customer.CustomerPK;
                var trans = dbContext.CreditCardProfiles.Add(new CreditCardProfile() { CustomerFK = custid, CustomerRefNum = customerreferencenumber });
                
                //to do: add nickname for dropdown so that we can avoid calling the cc api everytime we are on the billinglaunch page
                //save nickname to creditcardprofiles
                

                //return to billinglaunch,
                //update the card drop down, select the last one added





                /////////////////////////////////////////////////////
                //info: to charge card call AuthorizeAndCapture below
                //double amountToCharge=2.0;
                //GatewayReturnObject myret3 = scw.AuthorizeAndCapture(myret.CustomerRefNum, amountToCharge);

               



            }
            catch (Exception ex)
            {

            }

            return View();


        }

        [RequireRequestValue("HelpId")]
        public ActionResult DisplayHelp(int helpId)
        {
            var dbcontext = new SemplestModel.Semplest();

            return Content(dbcontext.WebContentQuestionMarkHelps.FirstOrDefault(h => h.WebContentQuestionMarkHelpPK == helpId).Copy);
        }

        public ActionResult Billing()
        {
            Credential cred = ((Credential)(Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]));
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
    }
}