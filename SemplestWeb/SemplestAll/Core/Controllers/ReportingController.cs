﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;
using SemplestModel;
using Semplest.Core.Models;
using Semplest.SharedResources.Helpers;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class ReportingController : Controller
    {
        //
        // GET: /Reporting/

        public ActionResult Index()
        {
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var dbContext = new SemplestModel.Semplest();
            IQueryable<Credential> cCred = dbContext.Credentials.Where(x => x.UsersFK == cred.UsersFK);
            ViewBag.Title = cCred.First().User.FirstName + " " + cCred.First().User.LastName + " - " + cCred.First().User.Customer.Name;
            var credential = dbContext.Credentials.FirstOrDefault(x => x.UsersFK == cred.UsersFK);
            if (credential != null)
            {
                var rim = new ReportIndexModel
                              {
                                  AdvertisingEngines = dbContext.AdvertisingEngines,
                                  ProductGroups = credential.User.Customer.ProductGroups
                              };
                return View(rim);
            }
            return View(new ReportIndexModel());
        }
        [HttpPost]
        public ActionResult Index(ReportIndexModel model)
        {
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var dbContext = new SemplestModel.Semplest();
            model.AdvertisingEngines = dbContext.AdvertisingEngines;
            var credential = dbContext.Credentials.FirstOrDefault(x => x.UsersFK == cred.UsersFK);
            if (credential != null)
                model.ProductGroups = credential.User.Customer.ProductGroups;
            return RedirectToAction("ReportDetails", model);
        }
        public ActionResult ReportDetails(ReportIndexModel model)
        {
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var dbContext = new SemplestModel.Semplest();
            model.AdvertisingEngines = dbContext.AdvertisingEngines;
            var credential = dbContext.Credentials.FirstOrDefault(x => x.UsersFK == cred.UsersFK);
            if (credential != null)
                model.ProductGroups = credential.User.Customer.ProductGroups;
            model.Detail = dbContext.vwPromotionCharts.Where(t => t.UserPK == cred.UsersFK).OrderBy(t => t.Keyword);
            model.Configuration = dbContext.Configurations.FirstOrDefault();
            return View(model);
        }

        public ActionResult ReportDetailsGrid()
        {
            var dbContext = new SemplestModel.Semplest();
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var grp = dbContext.vwPromotionCharts.Where(t => t.UserPK == cred.UsersFK).OrderBy(t => t.Keyword).GroupBy(t => new { t.Keyword, t.PromotionName });
            var reports = grp.Select(v => new vwPromotionChartModel
                                              {
                                                  AmountSpent = v.Sum(t => t.NumberClick * t.AverageCPC),
                                                  NumberImpressions = v.Sum(t => t.NumberImpressions),
                                                  KeyWord = v.Key.Keyword,
                                                  NumberClick = v.Sum(t => t.NumberClick),
                                                  SearchCTR = v.Sum(t => t.NumberClick * 100 / t.NumberImpressions),
                                                  CPC = v.Sum(t => t.NumberClick) == 0 ? 0 : v.Sum(t => t.NumberClick * t.AverageCPC) / v.Sum(t => t.NumberClick),
                                                  AveragePosition = v.Average(t => t.AveragePosition),
                                                  IsActive = v.FirstOrDefault().IsActive ? "Live" : "Paused"
                                              }).ToList();
            return Json(reports, JsonRequestBehavior.AllowGet);
        }

        public ActionResult ReportSummaryGrid()
        {
            var dbContext = new SemplestModel.Semplest();
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var grp = dbContext.vwPromotionCharts.Where(t => t.UserPK == cred.UsersFK).OrderBy(t => t.Keyword).GroupBy(t => new { t.PromotionName });
            var reports = grp.Select(v => new vwPromotionChartModel
                                              {
                                                  AmountSpent = v.Sum(t => t.NumberClick * t.AverageCPC),
                                                  NumberImpressions = v.Sum(t => t.NumberImpressions),
                                                  KeyWord = v.FirstOrDefault().PromotionName,
                                                  NumberClick = v.Sum(t => t.NumberClick),
                                                  SearchCTR = v.Sum(t => t.NumberClick * 100 / t.NumberImpressions),
                                                  CPC = v.Sum(t => t.NumberClick) == 0 ? 0 : v.Sum(t => t.NumberClick * t.AverageCPC) / v.Sum(t => t.NumberClick),
                                                  AveragePosition = v.Sum(t => t.AveragePosition),
                                                  IsActive = v.FirstOrDefault().IsActive ? "Live" : "Paused"
                                              }).ToList();
            return Json(reports, JsonRequestBehavior.AllowGet);
        }
        public ActionResult ReportChart(ReportIndexModel model)
        {
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var dbContext = new SemplestModel.Semplest();
            model.AdvertisingEngines = dbContext.AdvertisingEngines;
            var credential = dbContext.Credentials.FirstOrDefault(x => x.UsersFK == cred.UsersFK);
            if (credential != null)
                model.ProductGroups = credential.User.Customer.ProductGroups;
            model.Configuration = dbContext.Configurations.FirstOrDefault();
            return PartialView(model);
        }
        public ActionResult ReportGraph(int promotionFk, int advertisingEngineFk, DateTime? startDate, DateTime? endDate)
        {
            var dbContext = new SemplestModel.Semplest();
            var userid = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
            var reportDate = dbContext.vwPromotionCharts.Where(t => t.PromotionFK == promotionFk && t.AdvertisingEngineFK == advertisingEngineFk && t.UserPK == userid);
            var reports = new List<ReportChartModel>();
            var reports1 = new List<ReportChartModel>();
            var grp = reportDate.GroupBy(t => t.TransactionDate);
            foreach (var data in grp)
            {
                reports.Add(new ReportChartModel { Clicks = data.Sum(t => t.NumberClick), Impressions = data.Sum(t => t.NumberImpressions), Date = data.Key.ToString("MM/dd") });
            }
            var grp1 = reports.GroupBy(t => t.Date);
            foreach (var data in grp1)
            {
                reports1.Add(new ReportChartModel { Clicks = data.Sum(t => t.Clicks), Impressions = data.Sum(t => t.Impressions), Date = data.Key });
            }
            return Json(reports1, JsonRequestBehavior.AllowGet);
        }
    }
}
