using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Web.Mvc;
using ExcelLibrary.SpreadSheet;
using Semplest.Core.Models.Repositories;
using Semplest.SharedResources;
using Semplest.SharedResources.Services;
using SemplestModel;
using Semplest.Core.Models;
using Semplest.SharedResources.Helpers;
using System.Web.Script.Serialization;
using TreeView.Models;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [RequireHttpsHelper]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class SmartWordController : Controller
    {
        //
        // GET: /SmartWord/

        public ActionResult Index()
        {
            var dbContext = new SemplestModel.Semplest();
            var cred = ((Credential) (Session[SEMplestConstants.SESSION_USERID]));

            var child = new HomeModelChild();
            IQueryable<Credential> cCred = dbContext.Credentials.Where(x => x.UsersFK == cred.UsersFK);
            ViewBag.Title = cCred.First().User.FirstName + " " + cCred.First().User.LastName + " - " +
                            cCred.First().User.Customer.Name;
            child.ProductGroups = cCred.First().User.Customer.ProductGroups;
            return View(child);
        }

        [HttpGet]
        [RequireRequestValue("promotionId")]
        public ActionResult Setup(int promotionId)
        {
            ViewBag.IsNew = "False";
            Session["AllCategories"] = null;
            Session["AllKeyWords"] = null;
            Session["PromoId"] = null;
            Session["NegativeSmartWords"] = null;
            Session["NegativeSmartwordsText"] = null;
            Session["CategoryList"] = null;
            Session["SmartWordSetupModel"] = null;
            var swr = new SmartWordRepository();
            var swsm = swr.GetSetupModelForPromotionId(promotionId, GetCustomerId());
            if (swsm.Addresses.Count == 0)
                swsm.Addresses.Add(new GeoTargeting());
            ViewBag.Title = swsm.ProductGroup.ProductGroupName + " " + swsm.ProductGroup.ProductPromotionName;
            Session.Add("PromoId", promotionId);
            Session.Add("NegativeSmartwords", swsm.NegativeKeywords);
            Session.Add("NegativeSmartwordsText", swsm.NegativeKeywordsText);
            Session.Add("SmartWordSetupModel", swsm);
            return View(swsm);
        }

        [HttpPost]
        [ActionName("Setup")]
        [AcceptSubmitType(Name = "Command", Type = "Setup")]
        public ActionResult Setup(SmartWordSetupModel swsm)
        {
            try
            {

                ViewBag.IsNew = "False";
                var swr = new SmartWordRepository();
                var newIds = swr.SavePromotionDetails(swsm, swsm, GetCustomerId());
                var scw = new ServiceClientWrapper();
                if (!string.IsNullOrEmpty(newIds))
                {
                    foreach (var nvp in newIds.Split(',').Select(items => items.Split('=')))
                    {
                        var item = swsm.Addresses.SingleOrDefault(t => t.UID == nvp[0]);
                        if (item != null)
                            item.GeoTargetingPK = int.Parse(nvp[1]);
                    }
                }


                var categories = scw.GetCategories(null, swsm.ProductGroup.ProductPromotionName,
                                                   swsm.ProductGroup.Words,
                                                   null, swsm.LandingUrl);
                if (Session["NegativeSmartwords"] != null)
                    SetNegativeKeywords(swsm);
                Session.Add("CategoryList", categories);
                var categoryModels = new List<CampaignSetupModel.CategoriesModel>();
                if (categories != null && categories.Count > 0)
                {
                    categoryModels.AddRange(
                        categories.Select((t, i) => new CampaignSetupModel.CategoriesModel {Id = i, Name = t}));
                    Session.Add("AllCategories", categoryModels);
                }
                
                return Json(new {newKeys = newIds, name = "Categories"});
                // get the categoris from the web service
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                return Json(ExceptionHelper.GetErrorMessage(ex));
            }

        }



        public ActionResult Setup(SmartWordSetupModel swsm, string command)
        {
            ViewBag.IsNew = "True";
            return View(swsm);
        }

        public ActionResult Categories()
        {
            var categoryModels = (List<CampaignSetupModel.CategoriesModel>) Session["AllCategories"];
            var swsm = (SmartWordSetupModel)(Session["SmartWordSetupModel"]);
            if (categoryModels == null)
            {
                var scw = new ServiceClientWrapper();
                categoryModels = new List<CampaignSetupModel.CategoriesModel>();
                var categories = scw.GetCategories(null, swsm.ProductGroup.ProductPromotionName,
                                                   swsm.ProductGroup.Words,
                                                   null, swsm.LandingUrl);
                Session.Add("CategoryList", categories);
                categoryModels.AddRange(
                        categories.Select((t, j) => new CampaignSetupModel.CategoriesModel { Id = j, Name = t }));
                //Session["CampaignSetupModel"] = model;
                Session["AllCategories"] = categoryModels;
            }

            var selectedIds = new List<int>();
            if (Session["PromoId"] != null)
            {
                int promoId =int.Parse(Session["PromoId"].ToString());
                var dbContext = new SemplestModel.Semplest();
                var cats = dbContext.KeywordCategories.Where(x => x.PromotionFK == promoId);
                var i = 0;
                
                if (cats.Any())
                {
                    foreach (CampaignSetupModel.CategoriesModel cm in categoryModels)
                    {
                        if (cats.Any(x => x.KeywordCategory1 == cm.Name))
                            selectedIds.Add(i);
                        i += 1;
                    }
                }
            }
            var swm = new SmartWordSetupModel();
            swm.CategoryIds = selectedIds;
            swm.AllCategories = categoryModels;
            return PartialView(swm);
        }

        [HttpPost]
        [ActionName("Setup")]
        [AcceptSubmitType(Name = "Command", Type = "GetKeywords")]
        public ActionResult GetKeywords(SmartWordSetupModel model)
        {
            if (model.CategoryIds == null)
                return Json("Atleast one Category needs to be selected");
            int userid =
                ((Credential) (Session[SEMplestConstants.SESSION_USERID])).UsersFK;
            var catList = new List<string>();
            var categoryModels = (List<CampaignSetupModel.CategoriesModel>) Session["AllCategories"];
            foreach (var cat in categoryModels)
                catList.AddRange(model.CategoryIds.Where(t => cat.Id == t).Select(t => cat.Name));
            var scw = new ServiceClientWrapper();
            var keywords = scw.GetKeywords(catList, null, new string[] {"MSN", "Google"},
                                           model.ProductGroup.ProductPromotionName,
                                           model.ProductGroup.Words, null, model.LandingUrl,
                                           null);
            var dbcontext = new SemplestModel.Semplest();
            var kr = new KeyWordRepository(dbcontext);
            var kpos = new List<KeywordProbabilityObject>();
            kpos.AddRange(keywords);
            
            var promotionRepository = new PromotionRepository(dbcontext);
            var promoId = promotionRepository.GetPromotionId(userid, model.ProductGroup.ProductGroupName,
                                                             model.ProductGroup.ProductPromotionName);
            
            ICategoriesRepository catRepos = new CategoriesRepository(dbcontext);
            catRepos.SaveSelectedCategories(promoId, catList);
            kr.SaveKeywords(promoId, kpos, (List<string>)Session["NegativeSmartwords"],
                                            model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
            foreach (
                var kwm in
                    kpos.Where(key => key.isDeleted == false).Select(
                        key => new CampaignSetupModel.KeywordsModel {Name = key.keyword, Id = key.id}))
                model.AllKeywords.Add(kwm);
            Session.Add("AllKeyWords", model.AllKeywords);
            return Json(new {name = "ViewSmartWords"});
        }

        public ActionResult Words()
        {
            var keyWordModels = (List<CampaignSetupModel.KeywordsModel>) Session["AllKeyWords"];
            if (keyWordModels == null)
            {
                keyWordModels = ((SmartWordSetupModel) Session["SmartWordSetupModel"]).AllKeywords;
                Session["AllKeyWords"] = ((SmartWordSetupModel) Session["SmartWordSetupModel"]).AllKeywords;
            }
            //var keyWordModelsF = keyWordModels.Where(x => x.Name.Contains("work")).ToList();
            var swm = new SmartWordSetupModel {AllKeywords = keyWordModels, WordCount = keyWordModels.Count()};
            return PartialView(swm);
        }

        [HttpPost]
        [ActionName("Setup")]
        [AcceptSubmitType(Name = "Command", Type = "SetNegativeKeywords")]
        public ActionResult SetNegativeKeywords(SmartWordSetupModel model)
        {
            try
            {
                if (!string.IsNullOrEmpty(model.NegativeKeywordsText))
                {
                    var addl = model.NegativeKeywordsText.Split(',').ToList();
                    addl.ForEach(t => model.NegativeKeywords.Add(t.Trim()));
                }
                Session["NegativeSmartwords"] = model.NegativeKeywords;
                Session["NegativeSmartwordsText"] = model.NegativeKeywordsText;
                try
                {
                    var dbcontext = new SemplestModel.Semplest();
                    IPromotionRepository pr = new PromotionRepository(dbcontext);
                    IKeyWordRepository kwr = new KeyWordRepository(dbcontext);
                    var customerFK = GetCustomerId();
                    var promo = pr.GetPromoitionFromCampaign(customerFK, model);
                    model.AllKeywords = kwr.SaveNegativeKeywords(model, customerFK, promo);
                    Session["AllKeyWords"] = model.AllKeywords;
                }
                catch (InvalidOperationException io)
                {
                    //if this is the promo hasn't yet been saved then just leave it in the session and move on
                }      
                return Json("NegativeKeywords");
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                return Json(ExceptionHelper.GetErrorMessage(ex));
            }
        }

        public ActionResult NegativeSmartWords(SmartWordSetupModel model)
        {
            if (Session["NegativeSmartwords"] != null)
            {
                model.NegativeKeywords = (List<string>) Session["NegativeSmartwords"];
                model.NegativeKeywordsText = (string) Session["NegativeSmartwordsText"];
            }
            return PartialView("NegativeSmartWords", model);
        }


        [HttpPost]
        [ActionName("Setup")]
        [CampaignController.AcceptSubmitTypeAttribute(Name = "Command", Type = "FilterSmartWords")]
        public ActionResult KeyWords(SmartWordSetupModel model)
        {
            try
            {
                var promoId = int.Parse(Session["PromoId"].ToString());
                IKeyWordRepository kr = new KeyWordRepository(new SemplestModel.Semplest());
                kr.SetKeywordsDeleted(model.KeywordIds, promoId);
                var sessionModel = (SmartWordSetupModel)Session["SmartWordSetupModel"];
                sessionModel.AllKeywords.RemoveAll(key => model.KeywordIds.Contains(key.Id));
                //model.KeywordsCount = sessionModel.AllKeywords.Count();
                Session["SmartWordSetupModel"] = sessionModel;
                //model = sessionModel;
                return Json(new { count = sessionModel.AllKeywords.Count(), name = "Keywords" });
            }
            catch (Exception ex)
            {
                ExceptionHelper.LogException(ex);
                return Json(ExceptionHelper.GetErrorMessage(ex));
            }
        }

        public ActionResult ExcelExport()
        {
            var keyWordModels = (List<CampaignSetupModel.KeywordsModel>) Session["AllKeyWords"];
            var workbook = new Workbook();
            var worksheet = new Worksheet("First Sheet");
            var row = 0;
            foreach (CampaignSetupModel.KeywordsModel kw in keyWordModels)
            {
                worksheet.Cells[row, 0] = new Cell(kw.Name);
                row++;
            }
            worksheet.Cells.ColumnWidth[0] = 10000;            
            workbook.Worksheets.Add(worksheet);
            var ms = new MemoryStream();
            workbook.SaveToStream(ms);
            var dbContext = new SemplestModel.Semplest();
            var promoReposiorty = new PromotionRepository(dbContext);
            promoReposiorty.SetPromotionToLaunched((int) Session["PromoId"]);
            dbContext.SaveChanges();
            var mimetype = "application/x-excel";
                //application/excel
            return File(ms.ToArray(), mimetype, "SmartWords.xls");
            //var grid = new System.Web.UI.WebControls.GridView {DataSource = keyWordModels};
            //grid.DataBind();
            //var sw = new StringWriter();
            //var htw = new HtmlTextWriter(sw);
            //grid.RenderControl(htw);
            //var sm = new MemoryStream(Encoding.ASCII.GetBytes(sw.ToString()));
            //return File(sm, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "SmartWords.xlsx");
        }

        public ActionResult CsvExport()
        {
            var keyWordModels = (List<CampaignSetupModel.KeywordsModel>)Session["AllKeyWords"];
            var sb = new StringBuilder();
            foreach (CampaignSetupModel.KeywordsModel kw in keyWordModels)
            {
                sb.Append(kw.Name);
                sb.Append(Environment.NewLine);
            }
            var dbContext = new SemplestModel.Semplest();
            var promoReposiorty = new PromotionRepository(dbContext);
            promoReposiorty.SetPromotionToLaunched((int)Session["PromoId"]);
            dbContext.SaveChanges();
            var ms = new MemoryStream();
            ms.Write(Encoding.ASCII.GetBytes(sb.ToString()),0,sb.ToString().Length);
            return File(ms.ToArray(), "text/csv", "SmartWords.csv");
        }

        private int GetCustomerId()
        {
            var customerFk =
                ((Credential)System.Web.HttpContext.Current.Session[SharedResources.SEMplestConstants.SESSION_USERID]).
                    User.CustomerFK;
            return customerFk.Value;
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


        public ActionResult BuildSubItems()
        {
            const string json = "[\"top/business/financial_services/insurance/agents_and_marketers/travel/mexico\",\"top/business/financial_services/insurance/agents_and_marketers/automotive/united_states/illinois\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states/washington\",\"top/home/personal_finance/insurance/automotive\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states/kansas\",\"top/business/financial_services/insurance/agents_and_marketers/automotive/united_states\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line/united_states\",\"top/business/financial_services/insurance/agents_and_marketers/multi-line\",\"top/business/financial_services/insurance/agents_and_marketers\"]";
            var jss = new JavaScriptSerializer();
            var jsonList = jss.Deserialize<List<string>>(json);
            jsonList = (List<string>)Session["CategoryList"];
            var strs = jsonList.Select(jsl => jsl.Split('/').ToList()).ToList();
            //strs =  (List<string>) Session["CategoryList"];
            var treeManager = new TreeManager();

            foreach (var row in strs)
            {
                var path = new List<String>();
                foreach (String item in row)
                {
                    path.Add(item);
                    treeManager.AddData(treeManager, path);
                }
            }
            var productGroupsBar = new NavBar { Name = "Product Groups..", SubItems = new List<NavBar>() };
            NavBar promotionBar = null;
            foreach (var promotion in treeManager.Select(x => x))
            {
                Console.WriteLine("as");
                promotionBar = new NavBar
                {
                    Name = promotion.GetName(),
                    Id = 1,
                    SubItems = new List<NavBar>()
                };

                BuildSubItems(promotionBar, promotion);
                productGroupsBar.SubItems.Add(promotionBar);
            }
            
            var navBars = new List<NavBar>();
            navBars.Add(productGroupsBar);
            var jss2 = new JavaScriptSerializer();
            return Json(navBars, JsonRequestBehavior.AllowGet);
        }

        private void BuildSubItems(NavBar top, TreeItem next)
        {
            foreach (var child in next.children)
            {
                var promotionBar = new NavBar
                {
                    Name = child.Value.GetName(),
                    Id = 1,
                    SubItems = new List<NavBar>()
                };
                top.SubItems.Add(promotionBar);

                BuildSubItems(promotionBar, child.Value);
            }
        }

    }
}
