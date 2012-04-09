using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Reflection;
using SemplestWebApp.Models;

namespace SemplestWebApp.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            return View();
        }

        public ActionResult SearchKeywords()
        {
            return View();
        }

        [HttpPost]
        [ActionName("SearchKeywords")]
        [AcceptSubmitType(Name = "Command", Type = "GetCategories")] 
        public ActionResult GetCategories(SearchKeywordsModel model)
        {
            try 
	        {
                if (ModelState.IsValid)
                {
                    SemplestWebApp.Services.ServiceClientWrapper scw = new Services.ServiceClientWrapper();
                    List<string> categories = scw.GetCategories(null, model.Product, null, null, null);
                    if (categories != null && categories.Count > 0)
                    {
                        int i = 0;
                        foreach (string cate in categories)
                        {
                            SearchKeywordsModel.CategoriesModel cm = new SearchKeywordsModel.CategoriesModel { Id = i, Name = cate };
                            i++;
                            model.AllCategories.Add(cm);
                        }
                    }
                    else
                    {
                        CreateDummyModel(model);
                    }

                    // save this some how while getting the keywords this is becoming null
                    Session.Add("AllCategories", model.AllCategories);
                }
                return View(model);
	        }
	        catch (Exception ex)
	        {
                string err = ex.Message + "\\r\\n" + ex.StackTrace;
                CreateDummyModel(model);
                ViewBag.AllCategories = model.AllCategories;
                Session.Add("AllCategories", model.AllCategories);
                return View(model);
	        }
        }

        [HttpPost]
        [ActionName("SearchKeywords")]
        [AcceptSubmitType(Name = "Command", Type = "GetKeywords")]
        public ActionResult GetKeywords(SearchKeywordsModel model)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    //SemplestWebApp.Helpers.ServiceHelper.CallSemplestTestGetMethod();
                    if (model.AllCategories.Count == 0)
                    {
                        model.AllCategories = (List<SearchKeywordsModel.CategoriesModel>)Session["AllCategories"];
                    }

                    if (model.AllCategories.Count <= 0)
                    {
                    }

                    List<string> catList = new List<string>();

                    foreach (SearchKeywordsModel.CategoriesModel cat in model.AllCategories)
                    {
                        for (int i = 0; i < model.ItemIds.Length; i++)
                        {
                            if (cat.Id == model.ItemIds[i])
                            {
                                catList.Add(cat.Name);
                            }
                        }
                    }


                    SemplestWebApp.Services.ServiceClientWrapper scw = new Services.ServiceClientWrapper();
                    //var query = from c in model.AllCategories
                    //            let i = c.Id
                    //            where model.ItemIds.Contains(i)
                    //            select  c.Name ;
                    //List<string> catList = model.AllCategories.Select(m => m.Name).Where(
                    //List<string> keywords = scw.GetKeywords(catList, null, "coffee machine", null, null, "http://www.wholelattelove.com", null);
                    List<string> keywords = scw.GetKeywords(catList, null, model.Product, null, null, model.LandingPage, null);
                    if (keywords != null && keywords.Count > 0)
                    {
                        int i = 0;
                        foreach (string key in keywords)
                        {
                            SearchKeywordsModel.KeywordsModel kwm = new SearchKeywordsModel.KeywordsModel();
                            kwm.Name = key;
                            model.AllKeywords.Add(kwm);
                        }
                    }
                    else
                    {
                        CreateDummyModel(model);
                    }
                }

                return View(model);

            }
            catch (Exception)
            {
                CreateDummyModel(model);
                return View(model);
            }
        }

        public class AcceptSubmitTypeAttribute : ActionMethodSelectorAttribute
        {
            public string Name { get; set; }
            public string Type { get; set; }

            public override bool IsValidForRequest(ControllerContext controllerContext, MethodInfo methodInfo)
            {
                return controllerContext.RequestContext.HttpContext
                    .Request.Form[this.Name] == this.Type;
            }
        } 


        void CreateDummyModel(SearchKeywordsModel model)
        {
             // create a dummy model
            //model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Name = "category 1" });
            //model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Name = "category 2" });
            //model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Name = "category 3" });
            //model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Name = "category 4" });
            //model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Name = "category 5" });
            model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Id = 1, Name = "category 1" });
            model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Id = 2, Name = "category 2" });
            model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Id = 3, Name = "category 3" });
            model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Id = 4, Name = "category 4" });
            model.AllCategories.Add(new SearchKeywordsModel.CategoriesModel { Id = 5, Name = "category 5" });
        }

    }
}
