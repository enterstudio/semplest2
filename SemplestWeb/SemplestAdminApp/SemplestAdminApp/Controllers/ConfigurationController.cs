using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestAdminApp.Models;

namespace SemplestAdminApp.Controllers
{
    public class ConfigurationController : Controller
    {
        //
        // GET: /Configuration/
        SemplestEntities _dbContext = new SemplestEntities();
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
            _dbContext.SaveChanges();
            return View(c);
        }
    }
}
