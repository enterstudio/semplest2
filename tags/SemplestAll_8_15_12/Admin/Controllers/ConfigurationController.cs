﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.Admin.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;

namespace Semplest.Admin.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")] 
    public class ConfigurationController : Controller
    {
        //
        // GET: /Configuration/
        SemplestModel.Semplest _dbContext = new SemplestModel.Semplest();
        public ActionResult Index()
        {
            return View(_dbContext.Configurations.First<Configuration>());
        }

        
        [HttpPost]
        public ActionResult Index(Configuration c2)
        {
            Configuration c = _dbContext.Configurations.First<Configuration>();
            c.CustomerMinOrderAmount = c2.CustomerMinOrderAmount;
            c.CustomerDefaultMonthlyFlatFeeAmount = c2.CustomerDefaultMonthlyFlatFeeAmount;
            c.CustomerDefaultPerCampaignFlatFeeAmount = c2.CustomerDefaultPerCampaignFlatFeeAmount;
            c.CustomerDefaultPerAdGroupFlatFeeAmount = c2.CustomerDefaultPerAdGroupFlatFeeAmount;
            c.DefaultMediaComissionPercentage = c2.DefaultMediaComissionPercentage;
            c.DefaultSalesPersonCommissionPercentage = c2.DefaultSalesPersonCommissionPercentage;
            c.MinSalespersonCommissionPercentage = c2.MinSalespersonCommissionPercentage;
            c.MaxSalespersonCommissionPercentage = c2.MaxSalespersonCommissionPercentage;
            c.DefalutBudgetMixPercentageGoogle = c2.DefalutBudgetMixPercentageGoogle;
            c.DefalutBudgetMixPercentageBing = c2.DefalutBudgetMixPercentageBing;
            c.DefaultSemplestBannerImageUrl = c2.DefaultSemplestBannerImageUrl;
            c.DefaultSemplestStyleSheetUrl = c2.DefaultSemplestStyleSheetUrl;
            c.MaxNumberOfSitelinks = c2.MaxNumberOfSitelinks;
            c.LastAccountNumberUsed = c2.LastAccountNumberUsed;
            c.LastSEMplestEmployeeIDused = c2.LastSEMplestEmployeeIDused;
            c.DefaultEmailContactUs = c2.DefaultEmailContactUs;
            c.DefalutEmailContactMe = c2.DefalutEmailContactMe;
            c.DefaultProductGroupName = c2.DefaultProductGroupName;
            c.DefaultProductPromotionName = c2.DefaultProductPromotionName;
            c.SamplestDevelopmentEmail = c2.SamplestDevelopmentEmail;
            c.SemplestDefaultBudgetMarkUpOrDown = c2.SemplestDefaultBudgetMarkUpOrDown;
            c.BillingDaysOffset = c2.BillingDaysOffset;
            c.OnErrorEmail = c2.OnErrorEmail;
            c.ESBWebServerURL = c2.ESBWebServerURL;
            c.DisplayTargetCPCLevel = c2.DisplayTargetCPCLevel;
            c.DoNotLaunchAdServices = c2.DoNotLaunchAdServices;
            _dbContext.SaveChanges();
            return View(c);
        }
    }
}