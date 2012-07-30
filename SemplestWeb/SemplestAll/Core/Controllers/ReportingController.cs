﻿
using System;
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
    [RequireHttpsHelper]
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

        public ActionResult ReportDetailsGrid(string promotionFk, string advertisingEngineFk, DateTime? startDate, DateTime? endDate)
        {
            var dbContext = new SemplestModel.Semplest();
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var promotionFks = Array.ConvertAll(promotionFk.Split(','), int.Parse);
            var adFks = Array.ConvertAll(advertisingEngineFk.Split(','), int.Parse);
            var grp = dbContext.vwPromotionCharts.Where(t => promotionFks.Contains(t.PromotionFK) && t.UserPK == cred.UsersFK && adFks.Contains(t.AdvertisingEngineFK) && t.TransactionDate >= startDate && t.TransactionDate <= endDate).OrderBy(t => t.Keyword).GroupBy(t => new { t.Keyword, t.PromotionName });
            var reports = grp.Select(v => new vwPromotionChartModel
            {
                AmountSpent = v.Sum(t => t.NumberClick * t.AverageCPC),
                NumberImpressions = v.Sum(t => t.NumberImpressions),
                KeyWord = v.Key.Keyword,
                NumberClick = v.Sum(t => t.NumberClick),
                SearchCTR = v.Sum(t => t.NumberClick / t.NumberImpressions),
                CPC = v.Sum(t => t.NumberClick) == 0 ? 0 : v.Sum(t => t.NumberClick * t.AverageCPC) / v.Sum(t => t.NumberClick),
                AveragePosition = v.Average(t => t.AveragePosition),
            }).ToList();
            return Json(reports, JsonRequestBehavior.AllowGet);
        }

        public ActionResult ReportSummaryGrid(string promotionFk, string advertisingEngineFk, DateTime? startDate, DateTime? endDate)
        {
            var dbContext = new SemplestModel.Semplest();
            var cred = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID]));
            var promotionFks = Array.ConvertAll(promotionFk.Split(','), int.Parse);
            var adFks = Array.ConvertAll(advertisingEngineFk.Split(','), int.Parse);
            var grp = dbContext.vwPromotionCharts.Where(t => promotionFks.Contains(t.PromotionFK) && t.UserPK == cred.UsersFK && adFks.Contains(t.AdvertisingEngineFK) && t.TransactionDate >= startDate && t.TransactionDate <= endDate).OrderBy(t => t.Keyword).GroupBy(t => new { t.PromotionName });
            var reports = grp.Select(v => new vwPromotionChartModel
            {
                AmountSpent = v.Sum(t => t.NumberClick * t.AverageCPC),
                NumberImpressions = v.Sum(t => t.NumberImpressions),
                KeyWord = v.FirstOrDefault().PromotionName,
                NumberClick = v.Sum(t => t.NumberClick),
                SearchCTR = v.Sum(t => t.NumberClick / t.NumberImpressions),
                CPC = v.Sum(t => t.NumberClick) == 0 ? 0 : v.Sum(t => t.NumberClick * t.AverageCPC) / v.Sum(t => t.NumberClick),
                AveragePosition = v.Average(t => t.AveragePosition),
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
        public ActionResult ReportGraph(string promotionFk, string advertisingEngineFk, DateTime? startDate, DateTime? endDate, string mode)
        {
            var dbContext = new SemplestModel.Semplest();
            var userid = ((Credential)(Session[SharedResources.SEMplestConstants.SESSION_USERID])).UsersFK;
            var promotionFks = Array.ConvertAll(promotionFk.Split(','), int.Parse);
            var adFks = Array.ConvertAll(advertisingEngineFk.Split(','), int.Parse);
            List<vwPromotionChart> promotionCharts;
            var reports = new List<ReportChartModel>();
            var reports1 = new List<ReportChartModel>();
            IEnumerable<IGrouping<DateTime, vwPromotionChart>> grp;
            IEnumerable<IGrouping<string, vwPromotionChart>> grpa;
            IEnumerable<IGrouping<string, ReportChartModel>> grp1;
            switch (mode)
            {
                case "1":
                    promotionCharts = dbContext.vwPromotionCharts.Where(t => promotionFks.Contains(t.PromotionFK) && adFks.Contains(t.AdvertisingEngineFK) && t.UserPK == userid && t.TransactionDate >= startDate && t.TransactionDate <= endDate).ToList();

                    grp = promotionCharts.GroupBy(t => t.TransactionDate);
                    foreach (var data in grp)
                    {
                        var count = data.Count();
                        reports.Add(new ReportChartModel { Clicks = data.Sum(t => t.NumberClick) / count, Impressions = data.Sum(t => t.NumberImpressions) / count, Date = data.Key.ToString("MM/dd"), AveragePosition = data.Sum(t => t.AveragePosition) / count, AverageCPC = data.Sum(t => t.AverageCPC) / count });
                    }
                    grp1 = reports.GroupBy(t => t.Date);
                    foreach (var data in grp1)
                    {
                        var count = data.Count();
                        reports1.Add(new ReportChartModel { Clicks = data.Sum(t => t.Clicks) / count, Impressions = data.Sum(t => t.Impressions) / count, Date = data.Key, AveragePosition = data.Sum(t => t.AveragePosition) / count, AverageCPC = data.Sum(t => t.AverageCPC) / count });
                    }
                    return Json(reports1, JsonRequestBehavior.AllowGet);
                case "2":
                    promotionCharts = dbContext.GetMondayChart(startDate, endDate).Where(t => promotionFks.Contains(t.PromotionFK) && adFks.Contains(t.AdvertisingEngineFK) && t.UserPK == userid).ToList();

                    grp = promotionCharts.GroupBy(t => t.TransactionDate);
                    foreach (var data in grp)
                    {
                        var count = data.Count();
                        reports.Add(new ReportChartModel { Clicks = data.Sum(t => t.NumberClick) / count, Impressions = data.Sum(t => t.NumberImpressions) / count, Date = data.Key.ToString("MM/dd"), AveragePosition = data.Sum(t => t.AveragePosition) / count, AverageCPC = data.Sum(t => t.AverageCPC) / count });
                    }
                    grp1 = reports.GroupBy(t => t.Date);
                    foreach (var data in grp1)
                    {
                        var count = data.Count();
                        reports1.Add(new ReportChartModel { Clicks = data.Sum(t => t.Clicks) / count, Impressions = data.Sum(t => t.Impressions) / count, Date = data.Key, AveragePosition = data.Sum(t => t.AveragePosition) / count, AverageCPC = data.Sum(t => t.AverageCPC) / count });
                    }
                    return Json(reports1, JsonRequestBehavior.AllowGet);


                  
                case "3":
                    promotionCharts = dbContext.vwPromotionCharts.Where(t => promotionFks.Contains(t.PromotionFK) && adFks.Contains(t.AdvertisingEngineFK) && t.UserPK == userid && t.TransactionDate >= startDate && t.TransactionDate <= endDate).ToList();

                    grpa = promotionCharts.GroupBy(t => (t.TransactionDate.Month) + "/" + (t.TransactionDate.Year));
                    foreach (var data in grpa)
                    {
                        var count = data.Count();
                        reports.Add(new ReportChartModel { Clicks = data.Sum(t => t.NumberClick) / count, Impressions = data.Sum(t => t.NumberImpressions) / count, Date = data.Key.ToString(), AveragePosition = data.Sum(t => t.AveragePosition) / count, AverageCPC = data.Sum(t => t.AverageCPC) / count });
                    }
                    grp1 = reports.GroupBy(t => t.Date);
                    foreach (var data in grp1)
                    {
                        var count = data.Count();
                        reports1.Add(new ReportChartModel { Clicks = data.Sum(t => t.Clicks) / count, Impressions = data.Sum(t => t.Impressions) / count, Date = data.Key, AveragePosition = data.Sum(t => t.AveragePosition) / count, AverageCPC = data.Sum(t => t.AverageCPC) / count });
                    }
                    return Json(reports1, JsonRequestBehavior.AllowGet);
                case "4":
                    promotionCharts = dbContext.vwPromotionCharts.Where(t => promotionFks.Contains(t.PromotionFK) && adFks.Contains(t.AdvertisingEngineFK) && t.UserPK == userid && t.TransactionDate >= startDate && t.TransactionDate <= endDate).ToList();

                    grpa = promotionCharts.GroupBy(t => t.TransactionDate.Year.ToString());
                    foreach (var data in grpa)
                    {
                        var count = data.Count();
                        reports.Add(new ReportChartModel { Clicks = data.Sum(t => t.NumberClick) / count, Impressions = data.Sum(t => t.NumberImpressions) / count, Date = data.Key.ToString(), AveragePosition = data.Sum(t => t.AveragePosition) / count, AverageCPC = data.Sum(t => t.AverageCPC) / count });
                    }
                    grp1 = reports.GroupBy(t => t.Date);
                    foreach (var data in grp1)
                    {
                        var count = data.Count();
                        reports1.Add(new ReportChartModel { Clicks = data.Sum(t => t.Clicks) / count, Impressions = data.Sum(t => t.Impressions) / count, Date = data.Key, AveragePosition = data.Sum(t => t.AveragePosition) / count, AverageCPC = data.Sum(t => t.AverageCPC) / count });
                    }
                    return Json(reports1, JsonRequestBehavior.AllowGet);
            }
            return Json(null, JsonRequestBehavior.AllowGet);

        }

        public ActionResult GetFilterData(string promotionFk, string advertisingEngineFk, DateTime? startDate, DateTime? endDate)
        {
            var reportData = new List<PromotionModel> { new PromotionModel { PromotionId = "Impressions", PromotionName = "Number Impressions" }, new PromotionModel { PromotionId = "Clicks", PromotionName = "Number Clicks" }, new PromotionModel { PromotionId = "AverageCPC", PromotionName = "Average CPC" }, new PromotionModel { PromotionId = "AveragePosition", PromotionName = "Average Position" } };
            return Json(reportData, JsonRequestBehavior.AllowGet);
        }
    }
}