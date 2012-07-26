using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Globalization;
using System.Linq;
using Microsoft.Practices.EnterpriseLibrary.Logging;
using Semplest.SharedResources.Services;
using SemplestModel;
using Semplest.SharedResources;
using System.Data.Entity.Infrastructure;


namespace Semplest.Core.Models.Repositories
{
    public class CampaignRepository : ICampaignRepository
    {
        public int Save(string data)
        {
            // var jss = new JavaScriptSerializer();
            //   var myDynamic = jss.Deserialize(data, typeof(object));

            return 0;
        }


        public CampaignSetupModel GetCategories(CampaignSetupModel model)
        {
            var scw = new ServiceClientWrapper();

            // create AdCopy array

            // get categories or classifications
            var categories = scw.GetCategories(null, model.ProductGroup.ProductPromotionName,
                                               model.ProductGroup.Words,
                                               model.AdModelProp.Ads.Select(
                                                   pad => pad.AdTitle + " " + pad.AdTextLine1 + " " + pad.AdTextLine2).
                                                   ToArray(), model.AdModelProp.LandingUrl);

            // create categories list that will be displayed in a multiselect list box
            if (categories != null && categories.Count > 0)
            {
                for (var i = 0; i < categories.Count; i++)
                {
                    var cm = new CampaignSetupModel.CategoriesModel {Id = i, Name = categories[i]};
                    model.AllCategories.Add(cm);
                }
            }
            else
            {
                var logEnty = new LogEntry
                                  {ActivityId = Guid.NewGuid(), Message = "Could not get Categories from web service"};
                Logger.Write(logEnty);
            }
            return model;
            // save this some how while getting the keywords this is becoming null
        }

        public CampaignSetupModel GetKeyWords(CampaignSetupModel model, int promoId)
        {
            if (model.AllCategories.Count == 0)
            {
                //model.AllCategories = (List<CampaignSetupModel.CategoriesModel>)Session["AllCategories"];
            }

            var catList = new List<string>();

            foreach (var cat in model.AllCategories)
            {
                catList.AddRange(from t in model.CategoryIds where cat.Id == t select cat.Name);
            }

            var scw = new ServiceClientWrapper();
            // create AdCopy array


            // get keywords from the web service
            //List<string> keywords = scw.GetKeywords(catList, null, "coffee machine", null, null, "http://www.wholelattelove.com", null);
            var keywords = scw.GetKeywords(catList, null, SerializeAdEnginesSelectedToStringArray(model).ToArray(),
                                           model.ProductGroup.ProductPromotionName,
                                           model.ProductGroup.Words,
                                           model.AdModelProp.Ads.Select(
                                               pad => pad.AdTitle + " " + pad.AdTextLine1 + " " + pad.AdTextLine2).
                                               ToArray(), model.AdModelProp.LandingUrl,
                                           SerializeToGeoTargetObjectArray(model).ToArray());


            if (keywords != null && keywords.Length > 0)
            {

                model.AllKeywordProbabilityObjects.AddRange(keywords);
                SaveKeywords(promoId, model.AllKeywordProbabilityObjects, model.AdModelProp.NegativeKeywords,
                             model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
                foreach (
                    var kwm in
                        model.AllKeywordProbabilityObjects.Where(key => key.isDeleted == false).Select(
                            key => new CampaignSetupModel.KeywordsModel {Name = key.keyword, Id = key.id}))
                {
                    model.AllKeywords.Add(kwm);
                }
            }
            else
            {
                var logEnty = new LogEntry
                                  {ActivityId = Guid.NewGuid(), Message = "Could not get Keywords from web service"};
                Logger.Write(logEnty);
            }
            return model;
        }

        public List<string> SerializeAdEnginesSelectedToStringArray(CampaignSetupModel model)
        {
            return model.ProductGroup.AdEnginesList.Select(Convert.ToInt32).Select(id =>
                                                                                       {
                                                                                           var adEngineSelectModel =
                                                                                               model.ProductGroup.
                                                                                                   AdvertisingEngines.
                                                                                                   FirstOrDefault(
                                                                                                       t => t.Id == id);
                                                                                           return adEngineSelectModel !=
                                                                                                  null
                                                                                                      ? adEngineSelectModel
                                                                                                            .Name
                                                                                                      : null;
                                                                                       }).ToList();
        }

        public List<GeoTargetObject> SerializeToGeoTargetObjectArray(CampaignSetupModel model)
        {
            var geoList = new List<GeoTargetObject>();
            foreach (var geo in model.AdModelProp.Addresses)
            {
                if (geo.PromotionFK > 0)
                {
                    var geoTObj = new GeoTargetObject();
                    geoTObj.setAddress(geo.Address);
                    geoTObj.setCity(geo.City);
                    if (geo.StateCodeFK != null) geoTObj.setState(GetStateNameFromDb((int) geo.StateCodeFK));
                    geoTObj.setZip(geo.Zip);
                    geoTObj.setRadius((double) (geo.ProximityRadius ?? 0));
                    geoTObj.setLatitude((double) (geo.Latitude ?? 0));
                    geoTObj.setLongitude((double) (geo.Longitude ?? 0));
                    geoList.Add(geoTObj);
                }
            }
            return geoList;
        }

        public string GetStateNameFromDb(int stateCode)
        {
            return GetStateNameFromCode(stateCode);
        }

        public List<string> GetAdEnginesListFromDb()
        {
            return GetAdEngines();
        }

        private static bool _savedCampaign;
        private static SemplestModel.Semplest _dbcontext;
        //readonly Func<Semplest, int, Promotion> _promotonIdQuery = CompiledQuery.Compile((Semplest nw, int promoId) => nw.Promotions.FirstOrDefault(p => p.PromotionPK == promoId));
        private SemplestModel.Semplest InitializeContext()
        {
            if (_dbcontext == null || _savedCampaign)
            {
                _dbcontext = new SemplestModel.Semplest();
                _savedCampaign = false;
            }
            return _dbcontext;
        }

        public void SaveProductPromotion(int customerFk, CampaignSetupModel model, CampaignSetupModel oldModel)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var queryProdGrp = from c in dbcontext.ProductGroups
                                   where
                                       c.CustomerFK == customerFk &&
                                       c.ProductGroupName == model.ProductGroup.ProductGroupName
                                   select c;
                if (!queryProdGrp.Any())
                {
                    //create new productgroup and promotion
                    var prodgroup = new ProductGroup
                    {
                        ProductGroupName = model.ProductGroup.ProductGroupName,
                        IsActive = true,
                        CustomerFK = customerFk,
                        StartDate =
                            Convert.ToDateTime(model.ProductGroup.StartDate,
                                               new CultureInfo("en-Us")),
                        EndDate =
                            String.IsNullOrEmpty(model.ProductGroup.EndDate)
                                ? (DateTime?)null
                                : Convert.ToDateTime(model.ProductGroup.EndDate)
                    };
                    var promo = CreatePromotionFromModel(model,
                                                            dbcontext.Configurations.First().
                                                                CustomerDefaultPerCampaignFlatFeeAmount);
                    dbcontext.ProductGroups.Add(prodgroup);
                    dbcontext.Promotions.Add(promo);
                    SavePromotionAdEngineSelected(promo,model, dbcontext);
                    dbcontext.SaveChanges();
                }
                else
                {//productgroupexists
                    var updateProdGrp = queryProdGrp.Single();
                    var updatePromotion = GetPromotionFromProductGroup(updateProdGrp,
                                                                       model.ProductGroup.ProductPromotionName);
                    // if this is null means promotion name changed so create a new promotion
                    if (updatePromotion == null)
                    {
                        // create new promotion
                        updatePromotion = CreatePromotionFromModel(model,
                                                                   dbcontext.Configurations.First().
                                                                       CustomerDefaultPerCampaignFlatFeeAmount);
                        updatePromotion.ProductGroupFK = updateProdGrp.ProductGroupPK;
                        dbcontext.Promotions.Add(updatePromotion);
                        SavePromotionAdEngineSelected(updatePromotion, model, dbcontext);
                    }
                    else
                    {
                        // update promotion
                        UpdatePromotionFromModel(updatePromotion, model, dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount,customerFk, oldModel);
                        SavePromotionAdEngineSelected(updatePromotion, model, dbcontext);
                    }
                }
                dbcontext.SaveChanges();
                // we need to set this because the _dbcontext is  and campaign is updated so reflect changes we need to create new context
                _savedCampaign = true;
            }
        }

        public void SaveGeoTargetingAds(int customerFK, CampaignSetupModel model, CampaignSetupModel oldModel)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {

                var queryProd = (from c in dbcontext.ProductGroups
                                 where
                                     c.CustomerFK == customerFK &&
                                     c.ProductGroupName == model.ProductGroup.ProductGroupName
                                 select c).Single();
                var promo = GetPromotionFromProductGroup(queryProd, model.ProductGroup.ProductPromotionName);
                AddGeoTargetingToPromotion(promo, model, customerFK, oldModel,
                                           ((IObjectContextAdapter) dbcontext).ObjectContext);
                List<PromotionAd> addAds;
                List<int> updateAds;
                List<int> deleteAds;
                var shouldscheduleAds = AddPromotionAdsToPromotion(promo, model, customerFK, oldModel,
                                                                   ((IObjectContextAdapter) dbcontext).ObjectContext,
                                                                   out addAds, out updateAds, out deleteAds);
                promo.LandingPageURL = model.AdModelProp.LandingUrl.Trim();
                promo.DisplayURL = model.AdModelProp.DisplayUrl.Trim();
                dbcontext.SaveChanges();
                _savedCampaign = true;
                var adEngines = new List<string>();
                var promoAds = new List<PromotionAd>();
                if (promo.IsLaunched && shouldscheduleAds)
                {

                    adEngines.AddRange(
                        promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    var sw = new ServiceClientWrapper();
                    if (addAds.Any())
                    {
                        var addAdsIds =
                            addAds.Select(
                                promoAd =>
                                dbcontext.PromotionAds.Single(
                                    row =>
                                    row.AdTextLine1 == promoAd.AdTextLine1 && row.AdTextLine2 == promoAd.AdTextLine2 &&
                                    row.AdTitle == promoAd.AdTitle && row.PromotionFK == promo.PromotionPK).
                                    PromotionAdsPK).ToList();
                        sw.scheduleAds(promo.PromotionPK, addAdsIds, adEngines, SEMplestConstants.PromotionAdAction.Add);
                    }
                    if (updateAds.Any())
                        sw.scheduleAds(promo.PromotionPK, updateAds, adEngines,
                                       SEMplestConstants.PromotionAdAction.Update);
                    if (deleteAds.Any())
                        sw.scheduleAds(promo.PromotionPK, deleteAds, adEngines,
                                       SEMplestConstants.PromotionAdAction.Delete);
                }
            }
        }

        private Promotion GetDBPromoitionFromCampaign(SemplestModel.Semplest dbcontext, int customerFK, CampaignSetupModel model)
        {
            var queryProd = (from c in dbcontext.ProductGroups
                             where
                                 c.CustomerFK == customerFK &&
                                 c.ProductGroupName == model.ProductGroup.ProductGroupName
                             select c).Single();
            return GetPromotionFromProductGroup(queryProd, model.ProductGroup.ProductPromotionName);
        }

        public CampaignSetupModel GetCampaignSetupModelForPromotionId(int promoId, bool preview = false)
        {
            var model = new CampaignSetupModel();
            var dbcontext = InitializeContext();
            var promo = dbcontext.Promotions.FirstOrDefault(p => p.PromotionPK == promoId);
            //only let the user see their promo
            int customerFk =
                ((Credential)
                 (System.Web.HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID])).
                    User.CustomerFK.Value;
            if (promo != null && promo.ProductGroup.CustomerFK != customerFk)
                promo = null;
            // populate model from promotions
            if (promo != null)
            {
                model.ProductGroup.ProductGroupName = promo.ProductGroup.ProductGroupName;
                model.ProductGroup.ProductPromotionName = promo.PromotionName;
                model.ProductGroup.Budget = promo.PromotionBudgetAmount;
                model.ProductGroup.StartDate = promo.PromotionStartDate.ToString("MM/dd/yyyy",
                                                                                     new CultureInfo("en-Us"));
                model.ProductGroup.EndDate = promo.PromotionEndDate.HasValue
                                                 ? promo.PromotionEndDate.Value.ToString("MM/dd/yyyy",
                                                                                             CultureInfo.
                                                                                                 InvariantCulture)
                                                 : String.Empty;

                // set words
                model.ProductGroup.Words = promo.PromotionDescription;
            }

            // set advertising engines
            model.ProductGroup.AdEnginesSelectedList = new List<AdEngineSelectModel>();
            if (promo != null)
            {
                foreach (var paes in promo.PromotionAdEngineSelecteds)
                {
                    var aesm = new AdEngineSelectModel
                                   {
                                       Id = paes.AdvertisingEngine.AdvertisingEnginePK,
                                       Name = paes.AdvertisingEngine.AdvertisingEngine1
                                   };
                    model.ProductGroup.AdEnginesSelectedList.Add(aesm);
                    model.ProductGroup.AdEnginesList.Add(paes.AdvertisingEngine.AdvertisingEnginePK);
                }

                // set URL
                model.AdModelProp.LandingUrl = promo.LandingPageURL;

                // set display url
                model.AdModelProp.DisplayUrl = promo.DisplayURL;

                // set geotargetings
                model.AdModelProp.Addresses = promo.GeoTargetings.ToList();

                // set promotionads
                model.AdModelProp.Ads = promo.PromotionAds.ToList();

                if (!preview)
                {
                    // set negative keywords
                    if (promo.PromotionKeywordAssociations != null)
                        model.AdModelProp.NegativeKeywords =
                            promo.PromotionKeywordAssociations.Where(m => m.IsNegative).Select(m => m.Keyword.Keyword1).
                                ToList();
                }

                // set islaunched
                model.IsLaunched = promo.IsLaunched;
                model.IsCompleted = promo.IsCompleted;
                if (!preview)
                {
                    model.AllKeywords.AddRange(
                        promo.PromotionKeywordAssociations.Where(key => !key.IsDeleted && !key.IsNegative).Select(
                            key =>
                            new CampaignSetupModel.KeywordsModel
                                {Name = key.Keyword.Keyword1, Id = key.Keyword.KeywordPK}));
                }
                model.SiteLinks = promo.SiteLinks.ToList();
            }

            if (!preview)
            {
                var cnt = model.AdModelProp.NegativeKeywords.Count();
                for (var i = 0; i < cnt; i++)
                {
                    model.AdModelProp.NegativeKeywordsText += model.AdModelProp.NegativeKeywords[i];
                    if (i < cnt - 1)
                    {
                        model.AdModelProp.NegativeKeywordsText += ", ";
                    }
                }
            }


            //added by tudor
            var userid =
                ((Credential) System.Web.HttpContext.Current.Session[SharedResources.SEMplestConstants.SESSION_USERID]).
                    UsersFK;
            var queryCustFk = from u in dbcontext.Users where u.UserPK == userid select u.CustomerFK;
            var custobj = from c in dbcontext.Customers
                          where c.CustomerPK == queryCustFk.FirstOrDefault()
                          select new {c.PercentOfMedia, c.PromotionFeeAmount, c.PromotionFeeOverride};
            var firstOrDefault = custobj.FirstOrDefault();
            if (firstOrDefault != null)
            {
                model.PercentMedia = firstOrDefault.PercentOfMedia;
                model.PromotionFeeOverRide = firstOrDefault.PromotionFeeOverride;
                model.PromotionFeeOverRideAmount = firstOrDefault.PromotionFeeAmount;
            }
            model.BillType = dbcontext.Users.First(key => key.UserPK == userid).Customer.BillTypeFK;

            return model;
        }

        public IQueryable<vwProductPromotion> GetUserWithProductGroupAndPromotions(int userid)
        {
            var semplestEntities = new SemplestModel.Semplest();
            return semplestEntities.vwProductPromotions.Where(t => t.UserPK == userid);
        }

        public Promotion GetPromotionFromProductGroup(ProductGroup prodGroup, string promotionName)
        {
            var promo = prodGroup.Promotions.FirstOrDefault(m => m.PromotionName == promotionName && !m.IsDeleted);
            return promo;
        }

        public List<ProductGroup> GetProductGroupsForUser(int userid)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                var customerIdFk = queryCustFk.FirstOrDefault();
                if (customerIdFk != null)
                {
                    var custfk = (int) customerIdFk;

                    // get ProductGroup
                    var queryProdGrp = from c in dbcontext.ProductGroups
                                       where c.CustomerFK == custfk
                                       select c;
                    // get Promotion
                    if (queryProdGrp.Any())
                    {
                        return queryProdGrp.ToList();
                    }
                }
            }
            return null;

        }

        public int GetPromotionId(int userid, string prodGroupName, string promotionName)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                var i = queryCustFk.First();
                if (i != null)
                {
                    var custfk = (int) i;

                    // get ProductGroup
                    var queryProdGrp = from c in dbcontext.ProductGroups
                                       where c.CustomerFK == custfk && c.ProductGroupName == prodGroupName
                                       select c;
                    // get Promotion
                    if (queryProdGrp.Any())
                    {
                        var prodGrp = queryProdGrp.First();
                        var queryPromo = prodGrp.Promotions.Where(m => m.PromotionName == promotionName).ToList();
                        if (queryPromo.Any())
                        {
                            var promo = queryPromo.First();
                            return promo.PromotionPK;
                        }
                    }
                }
            }
            return -1;
        }


        public int GetBudgetCycleId(string budgetCycleName)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var queryBudgetCycle = dbcontext.BudgetCycles.Where(m => m.BudgetCycle1 == budgetCycleName);
                if (queryBudgetCycle.Any())
                {
                    var budgetCycle = queryBudgetCycle.FirstOrDefault();
                    if (budgetCycle != null)
                        return budgetCycle.BudgetCyclePK;
                }
            }
            return -1;
        }

        public Promotion CreatePromotionFromModel(CampaignSetupModel model,
                                                  decimal customerDefaultPerCampaignFlatFeeAmount)
        {
            if (model.AdModelProp.LandingUrl != null && model.AdModelProp.DisplayUrl != null)
            {
                model.AdModelProp.LandingUrl = model.AdModelProp.LandingUrl.Trim();
                model.AdModelProp.DisplayUrl = model.AdModelProp.DisplayUrl.Trim();
            }
            var promo = new Promotion
                            {

                                                        //no whitespace in database

                                PromotionName = model.ProductGroup.ProductPromotionName,
                                LandingPageURL = model.AdModelProp.LandingUrl,
                                DisplayURL = model.AdModelProp.DisplayUrl,
                                PromotionDescription = model.ProductGroup.Words,
                                PromotionBudgetAmount = model.ProductGroup.Budget,
                                BudgetCycleFK = GetBudgetCycleId("Monthly"),
                                PromotionEndDate =
                                    string.IsNullOrEmpty(model.ProductGroup.EndDate)
                                        ? (DateTime?)null
                                        : Convert.ToDateTime(model.ProductGroup.EndDate, new CultureInfo("en-Us")),
                                        CycleEndDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")).AddMonths(1),
                                StartBudgetInCycle = model.ProductGroup.Budget - customerDefaultPerCampaignFlatFeeAmount,
                                RemainingBudgetInCycle =
                                    model.ProductGroup.Budget - customerDefaultPerCampaignFlatFeeAmount,
                                PromotionStartDate =
                                    Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")),
                                CycleStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")),

                                IsPaused = false,
                                IsCompleted = false,
                                IsLaunched = false,
                                CreatedDate = DateTime.Now,
                            };

            return promo;

        }

        private void UpdatePromotionFromModel(Promotion updatePromotion, CampaignSetupModel model,
                                             decimal customerDefaultPerCampaignFlatFeeAmount, int customerFk,
                                             CampaignSetupModel oldModel)
        {
            model.AdModelProp.LandingUrl = model.AdModelProp.LandingUrl.Trim();
            model.AdModelProp.DisplayUrl = model.AdModelProp.DisplayUrl.Trim();
            updatePromotion.LandingPageURL = model.AdModelProp.LandingUrl;
            updatePromotion.DisplayURL = model.AdModelProp.DisplayUrl;
            updatePromotion.PromotionDescription = model.ProductGroup.Words;
            updatePromotion.PromotionBudgetAmount = model.ProductGroup.Budget;
            updatePromotion.PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate,
                                                                    new CultureInfo("en-Us"));
            updatePromotion.CycleStartDate = Convert.ToDateTime(model.ProductGroup.StartDate,
                                                                new CultureInfo("en-Us"));
            updatePromotion.PromotionEndDate = string.IsNullOrEmpty(model.ProductGroup.EndDate)
                                                   ? (DateTime?) null
                                                   : Convert.ToDateTime(model.ProductGroup.EndDate,
                                                                        new CultureInfo("en-Us"));
            updatePromotion.CycleEndDate =
                Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")).AddMonths(1);
            updatePromotion.StartBudgetInCycle = model.ProductGroup.Budget -
                                                 customerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.RemainingBudgetInCycle = model.ProductGroup.Budget -
                                                     customerDefaultPerCampaignFlatFeeAmount;


                
            if (!updatePromotion.IsLaunched) return;

            var sw = new ServiceClientWrapper();
            var adEngines = new List<string>();
            adEngines.AddRange(
                updatePromotion.PromotionAdEngineSelecteds.Select(
                    pades => pades.AdvertisingEngine.AdvertisingEngine1));
            if (model.ProductGroup.Budget != oldModel.ProductGroup.Budget) 
            sw.scheduleUpdateBudget(updatePromotion.PromotionPK, model.ProductGroup.Budget,
                                    adEngines);
            if (model.ProductGroup.StartDate != oldModel.ProductGroup.StartDate) 
            sw.scheduleChangePromotionStartDate(updatePromotion.PromotionPK,
                                                updatePromotion.PromotionStartDate, adEngines);
        }

        

        public void SavePromotionAdEngineSelected(Promotion promo, CampaignSetupModel model,
                                                  SemplestModel.Semplest dbcontext)
        {
            var existingAdenginesSeleccted =
                dbcontext.PromotionAdEngineSelecteds.Where(m => m.PromotionFK == promo.PromotionPK);
            var templist = new List<int>();
            model.ProductGroup.AdEnginesList.ForEach(t => templist.Add(Convert.ToInt32(t)));
            var dn = existingAdenginesSeleccted.Where(t => !templist.Contains(t.AdvertisingEngineFK));
            foreach (var adsel in dn)
                dbcontext.PromotionAdEngineSelecteds.Remove(adsel);

            foreach (int aes in model.ProductGroup.AdEnginesList)
            {
                int adengineid = Convert.ToInt32(aes);
                var proAdEng = dbcontext.AdvertisingEngines.FirstOrDefault(m => m.AdvertisingEnginePK == adengineid);
                if (proAdEng != null)
                {
                    var adEngSelQuery =
                        existingAdenginesSeleccted.FirstOrDefault(
                            m => m.AdvertisingEngineFK == proAdEng.AdvertisingEnginePK);
                    if (adEngSelQuery == null)
                    {
                        var adEngineSel = new PromotionAdEngineSelected
                                              {
                                                  AdvertisingEngineFK = proAdEng.AdvertisingEnginePK,
                                                  PromotionFK = promo.PromotionPK
                                              };
                        dbcontext.PromotionAdEngineSelecteds.Add(adEngineSel);
                    }
                    //dbcontext.SaveChanges();
                }
            }
        }

        public GeoTargeting MapGeoTargeting(GeoTargeting geoTargeting)
        {
            return new GeoTargeting();
        }

        public void AddGeoTargetingToPromotion(Promotion promo, CampaignSetupModel model, int customerFk, CampaignSetupModel oldModel, System.Data.Objects.ObjectContext context)
        {
            bool shouldUpdateGeoTargeting = false;
            if (model.AdModelProp.Addresses != null)
            {
                var modelIds = new List<int>();
                foreach (GeoTargeting geo in model.AdModelProp.Addresses)
                {
                    if (geo.Delete)
                    {
                        shouldUpdateGeoTargeting = true;
                        context.DeleteObject(promo.GeoTargetings.FirstOrDefault(x => x.GeoTargetingPK == geo.GeoTargetingPK));
                    }
                    else if (geo.GeoTargetingPK == 0)
                    {
                        shouldUpdateGeoTargeting = true;
                        if (geo.StateCodeFK < 0)
                            geo.StateCodeFK = null;
                        var geotarget = new GeoTargeting
                                            {
                                                Address = geo.Address,
                                                City = geo.City,
                                                StateCodeFK = geo.StateCodeFK,
                                                Zip = geo.Zip,
                                                ProximityRadius = geo.ProximityRadius,
                                                Latitude = geo.Latitude,
                                                Longitude = geo.Longitude
                                            };
                        promo.GeoTargetings.Add(geotarget);
                    }
                    else
                    {
                        GeoTargeting geo1 = geo;
                        modelIds.Add(geo1.GeoTargetingPK);
                        var geoOld = oldModel.AdModelProp.Addresses.FirstOrDefault(x => x.GeoTargetingPK == geo1.GeoTargetingPK);
                        if (geoOld != null)
                        {
                            if (geoOld.Address != geo1.Address ||
                                geoOld.City != geo1.City ||
                                geoOld.Latitude != geo1.Latitude ||
                                geoOld.Longitude != geo1.Longitude ||
                                geoOld.ProximityRadius != geo1.ProximityRadius ||
                                geoOld.Zip != geo1.Zip ||
                                geoOld.StateCode != geo1.StateCode ||
                                geoOld.Promotion.PromotionName != model.ProductGroup.ProductPromotionName)
                            {
                                shouldUpdateGeoTargeting = true;
                                var gt = promo.GeoTargetings.Single(x => x.GeoTargetingPK == geo1.GeoTargetingPK);
                                gt.Address = geo1.Address;
                                gt.City = geo1.City;
                                gt.Latitude = geo1.Latitude;
                                gt.Longitude = geo1.Longitude;
                                gt.ProximityRadius = geo1.ProximityRadius;
                                gt.Zip = geo1.Zip;
                                gt.StateCode = geo1.StateCode;
                            }
                        }
                    }
                }

                try
                {
                    var adEngines = new List<string>();
                    if (promo.IsLaunched && shouldUpdateGeoTargeting)
                    {
                        adEngines.AddRange(
                            promo.PromotionAdEngineSelecteds.Select(
                                pades => pades.AdvertisingEngine.AdvertisingEngine1));
                        var sw = new ServiceClientWrapper();
                        sw.scheduleUpdateGeoTargeting(promo.PromotionPK, adEngines);
                    }
                }

                catch (Exception ex)
                {
                    SharedResources.Helpers.ExceptionHelper.LogException(ex);
                }
                //}
            }
        }

        public void SaveSiteLinks(CampaignSetupModel model, int customerFk, CampaignSetupModel oldModel)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var queryProd = (from c in dbcontext.ProductGroups
                                   where
                                       c.CustomerFK == customerFk &&
                                       c.ProductGroupName == model.ProductGroup.ProductGroupName
                                   select c).Single();
                AddSiteLinksToPromotion(GetPromotionFromProductGroup(queryProd, model.ProductGroup.ProductPromotionName), model, customerFk, ((IObjectContextAdapter)dbcontext).ObjectContext, oldModel);
                dbcontext.SaveChanges();
                _savedCampaign = true;
            }
        }

        private static void AddSiteLinksToPromotion(Promotion promo, CampaignSetupModel model, int customerFk, System.Data.Objects.ObjectContext context, CampaignSetupModel oldModel)
        {
            bool shouldRefreshSiteLinks = false;
            if (model.SiteLinks != null)
                foreach (var sitelink in model.SiteLinks)
                {
                    if(sitelink.Delete)
                    {
                        context.DeleteObject(promo.SiteLinks.FirstOrDefault(x => x.SiteLInkPK == sitelink.SiteLInkPK));
                        shouldRefreshSiteLinks = true;
                    }
                    //TODO remove when the validation is added
                    //if (!string.IsNullOrEmpty(sitelink.LinkText) && !string.IsNullOrEmpty((sitelink.LinkURL)))
                    else if(sitelink.SiteLInkPK==0)
                    {
                        shouldRefreshSiteLinks = true;
                        var slink = new SiteLink
                                        {
                                            LinkText = sitelink.LinkText,
                                            LinkURL = sitelink.LinkURL,
                                            PromotionFK = promo.PromotionPK
                                        };
                        promo.SiteLinks.Add(slink);
                    }
                    else
                    {
                        var siteOld = oldModel.SiteLinks.Single(x => x.SiteLInkPK == sitelink.SiteLInkPK);
                        if (siteOld.LinkText != sitelink.LinkText ||
                                siteOld.LinkURL != sitelink.LinkURL)
                            {
                                shouldRefreshSiteLinks = true;
                                var sl = promo.SiteLinks.Single(x => x.SiteLInkPK== sitelink.SiteLInkPK);
                                sl.LinkText = sitelink.LinkText;
                                sl.LinkURL = sitelink.LinkURL;
                            }
                    }
                }
            try
            {
                var adEngines = new List<string>();
                if (promo.IsLaunched && shouldRefreshSiteLinks)
                {
                    adEngines.AddRange(
                        promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    var sw = new ServiceClientWrapper();
                    sw.scheduleRefreshSiteLinks(promo.PromotionPK, adEngines);
                }
            }
            catch (Exception ex)
            {
                SharedResources.Helpers.ExceptionHelper.LogException(ex);
            }
        }

        public bool AddPromotionAdsToPromotion(Promotion promo, CampaignSetupModel model, int customerFk,
                                                            CampaignSetupModel oldModel, System.Data.Objects.ObjectContext context, out List<PromotionAd> addAds, out List<int> updateAds, out List<int> deleteAds)
        {
            deleteAds = new List<int>();
            updateAds = new List<int>();
            addAds = new List<PromotionAd>();
            bool shouldscheduleAds = false;
            foreach (PromotionAd pad in model.AdModelProp.Ads)
            {
                if (pad.Delete)
                {
                    shouldscheduleAds = true;
                    deleteAds.Add(pad.PromotionAdsPK);
                    context.DeleteObject(promo.PromotionAds.FirstOrDefault(x => x.PromotionAdsPK == pad.PromotionAdsPK));
                }
                else if (pad.PromotionAdsPK == 0)
                {
                    shouldscheduleAds = true;
                    addAds.Add(pad);
                    pad.AdTextLine1 = pad.AdTextLine1;
                    pad.AdTextLine2 = pad.AdTextLine2;
                    pad.AdTitle = pad.AdTitle;
                    var cad = new PromotionAd
                                  {
                                      AdTextLine1 = pad.AdTextLine1,
                                      AdTextLine2 = pad.AdTextLine2,
                                      AdTitle = pad.AdTitle,
                                      PromotionAdsPK = pad.PromotionAdsPK
                                  };
                    promo.PromotionAds.Add(cad);
                }
                else
                {
                    pad.AdTextLine1 = pad.AdTextLine1;
                    pad.AdTextLine2 = pad.AdTextLine2;
                    pad.AdTitle = pad.AdTitle;
                    var padOld = oldModel.AdModelProp.Ads.FirstOrDefault(x => x.PromotionAdsPK == pad.PromotionAdsPK);
                    if (padOld != null)
                    {
                        if (padOld.AdTextLine1 != pad.AdTextLine1 ||
                            padOld.AdTextLine2 != pad.AdTextLine2 ||
                            padOld.AdTitle != pad.AdTitle)
                        {
                            shouldscheduleAds = true;
                            updateAds.Add(pad.PromotionAdsPK);
                            var pa = promo.PromotionAds.Single(x => x.PromotionAdsPK == pad.PromotionAdsPK);
                            pa.AdTextLine1 = pad.AdTextLine1;
                            pa.AdTextLine2 = pad.AdTextLine2;
                            pa.AdTitle = pad.AdTitle;
                        }
                    }
                }
            }
            return shouldscheduleAds;
        }

        public void SaveSelectedCategories(int promotionId, IEnumerable<string> selectedCategories)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var query = dbcontext.KeywordCategories.Where(c => c.PromotionFK == promotionId);
                if (!query.Any())
                {
                    foreach (
                        var keyCategory in
                            selectedCategories.Select(
                                category => new KeywordCategory {PromotionFK = promotionId, KeywordCategory1 = category})
                        )
                    {
                        dbcontext.KeywordCategories.Add(keyCategory);
                    }
                    dbcontext.SaveChanges();
                }
                else // categories exists so update them
                {
                    // delete them first
                    foreach (KeywordCategory kc in query)
                    {
                        dbcontext.KeywordCategories.Remove(kc);
                    }
                    dbcontext.SaveChanges();
                    // add them
                    foreach (
                        var keyCategory in
                            selectedCategories.Select(
                                category => new KeywordCategory {PromotionFK = promotionId, KeywordCategory1 = category})
                        )
                    {
                        dbcontext.KeywordCategories.Add(keyCategory);
                    }
                    dbcontext.SaveChanges();
                }
            }





        }

        public void SaveKeywords(int promotionId, List<KeywordProbabilityObject> kpos, List<string> negativeKeywords,
                                 string productGroupName, string promotionName)
        {
            var stationIds = new DataTable();
            stationIds.Columns.Add("Keyword", typeof (string));
            stationIds.Columns.Add("IsActive", typeof (Boolean));
            stationIds.Columns.Add("IsDeleted", typeof (Boolean));
            stationIds.Columns.Add("IsNegative", typeof (Boolean));
            stationIds.Columns.Add("SemplestProbability", typeof (float));
            stationIds.Columns.Add("IsTargetMSN", typeof (Boolean));
            stationIds.Columns.Add("IsTargetGoogle", typeof (Boolean));
            var negativeKeywordsToBeInserted = new List<string>();
            var deletedKeywords = new List<int>();
            if (negativeKeywords != null)
                negativeKeywordsToBeInserted.AddRange(negativeKeywords);
            foreach (var kpo in kpos)
            {
                if (!kpo.isDeleted)
                {
                    kpo.isDeleted = IsDeletedKeyword(kpo.keyword.Trim(), negativeKeywords);
                    deletedKeywords.Add(kpo.id);
                }

                var dr = stationIds.NewRow();
                dr["Keyword"] = kpo.keyword.Trim();
                dr["IsActive"] = "true";
                dr["IsDeleted"] = kpo.isDeleted;
                if (IsNegativeKeyword(kpo.keyword.Trim(), negativeKeywords))
                {
                    dr["IsNegative"] = true;
                    negativeKeywordsToBeInserted.Remove(kpo.keyword.Trim());
                }
                else
                    dr["IsNegative"] = false;
                dr["SemplestProbability"] = kpo.semplestProbability;
                dr["IsTargetMSN"] = kpo.isTargetMSN;
                dr["IsTargetGoogle"] = kpo.isTargetGoogle;
                stationIds.Rows.Add(dr);
                //System.Diagnostics.Debug.WriteLine("insert into @kwa (keyword,IsActive,IsDeleted,IsNegative,IsTargetGoogle,IsTargetMSN) values ('" + dr["Keyword"].ToString() + "',1,0,1,0,0)");
            }
            foreach (string s in negativeKeywordsToBeInserted)
            {
                var dr = stationIds.NewRow();
                dr["Keyword"] = s.Trim();
                dr["IsActive"] = "true";
                dr["IsNegative"] = true;
                dr["IsDeleted"] = false;
                dr["IsTargetMSN"] = 0;
                dr["IsTargetGoogle"] = 0;
                stationIds.Rows.Add(dr);
            }
            if (stationIds.Rows.Count > 0)
            {
                var parameter = new SqlParameter("kwa", stationIds)
                                    {SqlDbType = SqlDbType.Structured, TypeName = "PromotionKeywordTableType"};


                var parameter2 = new SqlParameter("@PromotionId", promotionId) {SqlDbType = SqlDbType.Int};

                var parameters = new object[] {parameter, parameter2};
                using (var dbcontext = new SemplestModel.Semplest())
                {
                    ((IObjectContextAdapter) dbcontext).ObjectContext.CommandTimeout = 100;
                    dbcontext.Database.ExecuteSqlCommand("exec sp_UpdateKeywords @kwa, @PromotionId", parameters);
                    _savedCampaign = true;
                    
                    //set keyword id's back in the model
                    int userid =
                        ((Credential)
                         System.Web.HttpContext.Current.Session[SharedResources.SEMplestConstants.SESSION_USERID]).
                            UsersFK;
                    var firstOrDefault = dbcontext.Users.FirstOrDefault(key => key.UserPK == userid);
                    if (firstOrDefault != null)
                    {
                        var promotion =
                            firstOrDefault.Customer.ProductGroups.First(key => key.ProductGroupName == productGroupName)
                                .Promotions.FirstOrDefault(key => key.PromotionName == promotionName);
                        if (promotion != null)
                        {
                            var pkas = promotion.PromotionKeywordAssociations;
                            foreach (PromotionKeywordAssociation pka in pkas)
                            {
                                PromotionKeywordAssociation pka1 = pka;
                                var qry = kpos.Where(key => key.keyword == pka1.Keyword.Keyword1).ToList();
                                if (qry.Any())
                                    qry.First().id = pka.Keyword.KeywordPK;
                            }
                        }
                    }
                    var sw = new ServiceClientWrapper();
                    var adEngines = new List<string>();
                    var promo = dbcontext.Promotions.Single(row => row.PromotionPK == promotionId);
                    adEngines.AddRange(
                        promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    sw.DeleteKeywords(promotionId, deletedKeywords, adEngines);
                }
            }
        }

        public bool IsDeletedKeyword(string keyword, List<string> negativeKeywords)
        {
            if (negativeKeywords == null)
                return false;
            string k = keyword.ToUpper();
            return (negativeKeywords.Any(key => k.Contains(key.ToUpper() + " ")) ||
                    negativeKeywords.Any(key => k.Contains(" " + key.ToUpper())) ||
                    negativeKeywords.Any(key => k.Contains(" " + key.ToUpper() + " ")));
        }

        public bool IsNegativeKeyword(string keyword, List<string> negativeKeywords)
        {
            if (negativeKeywords == null || String.IsNullOrEmpty(keyword))
                return false;
            return negativeKeywords.Any(key => keyword.ToUpper().Equals(key.ToUpper()));
        }

        public List<CampaignSetupModel.KeywordsModel> SaveNegativeKeywords(CampaignSetupModel model, int customerFk)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var promo = GetDBPromoitionFromCampaign(dbcontext, customerFk, model);
                IEnumerable<PromotionKeywordAssociation> qry =
                    dbcontext.PromotionKeywordAssociations.Where(key => key.PromotionFK == promo.PromotionPK).ToList();
                var kpos = new List<KeywordProbabilityObject>();
                var addKiops = new List<KeywordIdRemoveOppositePair>();
                var addNewKiops = new List<KeywordIdRemoveOppositePair>();
                var addDeletedKiops = new List<KeywordIdRemoveOppositePair>();
                var addNewKeywords = new List<string>();
                KeywordProbabilityObject kpo;

                foreach (PromotionKeywordAssociation pka in qry)
                {
                    kpo = new KeywordProbabilityObject
                              {
                                  keyword = pka.Keyword.Keyword1,
                                  semplestProbability =
                                      pka.SemplestProbability == null ? 0 : pka.SemplestProbability.Value,
                                  isTargetMSN = pka.IsTargetMSN,
                                  isTargetGoogle = pka.IsTargetGoogle,
                                  isDeleted = pka.IsDeleted,
                                  id = pka.KeywordFK
                              };
                    kpos.Add(kpo);
                }
                if (promo.IsLaunched && model.AdModelProp.NegativeKeywords != null)
                {
                    foreach (string negativeKeyword in model.AdModelProp.NegativeKeywords)
                    {
                        if (qry.Any(key => key.Keyword.Keyword1 == negativeKeyword))
                        {
                            var kiop = new KeywordIdRemoveOppositePair();
                            var pka = qry.First(key => key.Keyword.Keyword1 == negativeKeyword);
                            //means if the keyword existied and was positive it needs to be removed and added as a negative. if the keyword is already negative then do nothing because we've already added it
                            kiop.KeywordId = pka.KeywordFK;
                            if (!pka.IsNegative)
                            {
                                kiop.RemoveOpposite = true;
                                addKiops.Add(kiop);
                            }
                        }
                        else
                        {
                            kpo = new KeywordProbabilityObject {keyword = negativeKeyword};
                            kpos.Add(kpo);
                            addNewKeywords.Add(negativeKeyword);
                        }
                    }
                }
                //check for negative keywords that have been removed
                foreach (PromotionKeywordAssociation k in qry.Where(key => key.IsNegative == true))
                {
                    if (!model.AdModelProp.NegativeKeywords.Contains(k.Keyword.Keyword1))
                    {
                        var kiopDelete = new KeywordIdRemoveOppositePair
                                             {
                                                 KeywordId = k.Keyword.KeywordPK,
                                                 RemoveOpposite = false
                                             };
                        addDeletedKiops.Add(kiopDelete);
                    }
                }
                var sw = new ServiceClientWrapper();
                var adEngines = new List<string>();
                adEngines.AddRange(
                    promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                if (addDeletedKiops.Any())
                    sw.scheduleNegativeKeywords(promo.PromotionPK, addDeletedKiops, adEngines, false);
                if (addKiops.Any())
                    sw.scheduleNegativeKeywords(promo.PromotionPK, addKiops, adEngines, true);

                SaveKeywords(promo.PromotionPK, kpos, model.AdModelProp.NegativeKeywords,
                             model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
                //find more elegant way of doing this this is so we can update the view keywords tab and 
                //get the id's of the newly added negative keywords to call the api
                using (var dbcontext2 = new SemplestModel.Semplest())
                {
                    promo = GetDBPromoitionFromCampaign(dbcontext2, customerFk, model);
                    model.AllKeywords.Clear();
                    model.AllKeywords.AddRange(
                        promo.PromotionKeywordAssociations.Where(key => !key.IsDeleted && !key.IsNegative).Select(
                            key =>
                            new CampaignSetupModel.KeywordsModel
                                {Name = key.Keyword.Keyword1, Id = key.Keyword.KeywordPK}));
                    var kiopNew = new KeywordIdRemoveOppositePair();
                    foreach (string k in addNewKeywords)
                    {
                        kiopNew.KeywordId = dbcontext2.Keywords.Single(key => key.Keyword1 == k).KeywordPK;
                        kiopNew.RemoveOpposite = false;
                        addNewKiops.Add(kiopNew);
                    }
                    if (addNewKiops.Any())
                        sw.scheduleNegativeKeywords(promo.PromotionPK, addNewKiops, adEngines, true);
                }
            }
            return model.AllKeywords;
        }

        public string GetStateNameFromCode(int stateCode)
        {
            string stateName;
            using (var db = new SemplestModel.Semplest())
            {
                stateName = db.StateCodes.First(m => m.StateAbbrPK == stateCode).StateAbbr;
            }
            return stateName;
        }

        public List<string> GetAdEngines()
        {
            using (var db = new SemplestModel.Semplest())
            {
                return db.AdvertisingEngines.Select(m => m.AdvertisingEngine1).ToList();
            }

        }

        public bool IsPromotionLaunched(int promoId)
        {
            using (var db = new SemplestModel.Semplest())
            {
                var promo = db.Promotions.FirstOrDefault(p => p.PromotionPK == promoId);
                return promo != null && promo.IsLaunched;
            }
        }

        public bool IsPromotionCompleted(int promoId)
        {
            using (var db = new SemplestModel.Semplest())
            {
                var promo = db.Promotions.FirstOrDefault(p => p.PromotionPK == promoId);
                return promo != null && promo.IsCompleted;
            }
        }

        public bool IsPromotionLaunchedAndCompleted(int promoId)
        {
            using (var db = new SemplestModel.Semplest())
            {
                var promo = db.Promotions.FirstOrDefault(p => p.PromotionPK == promoId);
                return promo != null && (promo.IsCompleted && promo.IsLaunched);
            }
        }

        public void SetKeywordsDeleted(List<int> keywordIds, int promoId)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                foreach (int keywordId in keywordIds)
                    dbcontext.PromotionKeywordAssociations.Where(key => key.KeywordFK == keywordId).First(
                        key => key.PromotionFK == promoId).IsDeleted = true;
                var sw = new ServiceClientWrapper();
                dbcontext.SaveChanges();
                var adEngines = new List<string>();
                var promo = dbcontext.Promotions.Single(row => row.PromotionPK == promoId);
                adEngines.AddRange(
                        promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                sw.DeleteKeywords(promoId, keywordIds, adEngines);
            }
        }

        public GoogleViolation[] ValidateSiteLinks(int promoId)
        {
            var sw = new ServiceClientWrapper();
            return sw.ValidateGoogleRefreshSiteLinks(promoId);
        }

        public GoogleViolation[] ValidateGeotargeting(int promoId)
        {
            var sw = new ServiceClientWrapper();
            return sw.ValidateGoogleGeoTargets(promoId);
        }

        public GoogleViolation[] ValidateAds(String landingPageURL, String displayURL, List<GoogleAddAdRequest> ads)
        {
            var sw = new ServiceClientWrapper();
            return sw.ValidateGoogleAd(landingPageURL, displayURL, ads);
        }

        public GoogleViolation[] ValidateGoogleNegativeKeywords(List<string> negativeKeywords)
        {
            var sw = new ServiceClientWrapper();
            return sw.ValidateGoogleNegativeKeywords(negativeKeywords);
        }

        public bool DoesPromotionExist(string prodGroup, string promotionName, int custFk)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                    var queryProdGrp =
                    from pgs in dbcontext.ProductGroups
                    join pms in dbcontext.Promotions on pgs.ProductGroupPK equals pms.ProductGroupFK
                    where (pgs.CustomerFK == custFk && pgs.ProductGroupName == prodGroup && pms.PromotionName == promotionName && !pms.IsDeleted)
                    select pms;

                if (queryProdGrp.Any())
                    return true;
                else
                    return false;
            }
        }
    }
}