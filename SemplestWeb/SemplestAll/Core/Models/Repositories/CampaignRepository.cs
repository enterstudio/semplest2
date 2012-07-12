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
                                           SerializeToGeoTargetObjectArray(model).ToArray(), null);


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

        public void SaveProductGroupAndCampaign(int userid, CampaignSetupModel model, CampaignSetupModel oldModel)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                var i = queryCustFk.FirstOrDefault();
                if (i != null)
                {
                    var custfk = (int) i;

                    // check if the ProductGroupName already exists
                    var queryProdGrp = from c in dbcontext.ProductGroups
                                       where
                                           c.CustomerFK == custfk &&
                                           c.ProductGroupName == model.ProductGroup.ProductGroupName
                                       select c;
                    if (queryProdGrp.Any())
                    {
                        // product grp already exists so update the product group 
                        var updateProdGrp = queryProdGrp.FirstOrDefault();
                        if (updateProdGrp != null)
                        {
                            updateProdGrp.ProductGroupName = model.ProductGroup.ProductGroupName;
                            updateProdGrp.StartDate = Convert.ToDateTime(model.ProductGroup.StartDate,
                                                                         new CultureInfo("en-Us"));
                            updateProdGrp.EndDate = String.IsNullOrEmpty(model.ProductGroup.EndDate)
                                                        ? (DateTime?) null
                                                        : Convert.ToDateTime(model.ProductGroup.EndDate);

                            // get promotion and update it
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

                                // add geotargeting to promotion
                                AddGeoTargetingToPromotion(updatePromotion, model, custfk);
                                // promotion ads
                                AddPromotionAdsToPromotion(updatePromotion, model, custfk, null);

                                dbcontext.Promotions.Add(updatePromotion);
                            }
                            else
                            {
                                // update promotion
                                UpdatePromotionFromModel(updatePromotion, model, dbcontext, custfk, oldModel);
                            }
                        }

                        dbcontext.SaveChanges();

                        // we need to set this because the _dbcontext is  and campaign is updated so reflect changes we need to create new context
                        _savedCampaign = true;
                    }
                    else
                    {
                        // create product group
                        var prodgroup = new ProductGroup
                                            {
                                                ProductGroupName = model.ProductGroup.ProductGroupName,
                                                IsActive = true,
                                                CustomerFK = custfk,
                                                StartDate =
                                                    Convert.ToDateTime(model.ProductGroup.StartDate,
                                                                       new CultureInfo("en-Us")),
                                                EndDate =
                                                    String.IsNullOrEmpty(model.ProductGroup.EndDate)
                                                        ? (DateTime?) null
                                                        : Convert.ToDateTime(model.ProductGroup.EndDate)
                                            };

                        // create promotion
                        var promo = CreatePromotionFromModel(model,
                                                             dbcontext.Configurations.First().
                                                                 CustomerDefaultPerCampaignFlatFeeAmount);

                        // add advertising engines that are selected
                        SavePromotionAdEngineSelected(promo, model, dbcontext);

                        // add geotargeting to promotion
                        AddGeoTargetingToPromotion(promo, model, custfk);

                        // save site links
                        AddSiteLinksToPromotion(promo, model, custfk);

                        // promotion ads
                        AddPromotionAdsToPromotion(promo, model, custfk, null);

                        // add product group
                        dbcontext.ProductGroups.Add(prodgroup);
                        // add promotion
                        dbcontext.Promotions.Add(promo);
                        dbcontext.SaveChanges();

                        // save negative keywords
                        SaveNegativeKeywords(promo, model, dbcontext, custfk);

                        // we need to set this because the _dbcontext is  and campaign is updated so reflect changes we need to create new context
                        _savedCampaign = true;
                    }
                }
            }
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
            var promo = prodGroup.Promotions.FirstOrDefault(m => m.PromotionName == promotionName);
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
            var promo = new Promotion
                            {


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
                                CreatedDate = DateTime.Now
                            };

            return promo;

        }

        public void UpdatePromotionFromModel(Promotion updatePromotion, CampaignSetupModel model,
                                             SemplestModel.Semplest dbcontext, int customerFk,
                                             CampaignSetupModel oldModel)
        {
            var configuration = dbcontext.Configurations.First();
            updatePromotion.LandingPageURL = model.AdModelProp.LandingUrl;
            updatePromotion.DisplayURL = model.AdModelProp.DisplayUrl;
            updatePromotion.PromotionDescription = model.ProductGroup.Words;
            updatePromotion.PromotionBudgetAmount = model.ProductGroup.Budget;
            updatePromotion.PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate,
                                                                    new CultureInfo("en-Us"));
            updatePromotion.CycleStartDate = Convert.ToDateTime(model.ProductGroup.StartDate,
                                                                    new CultureInfo("en-Us"));
            updatePromotion.PromotionEndDate = string.IsNullOrEmpty(model.ProductGroup.EndDate)
                                               ? (DateTime?)null
                                               : Convert.ToDateTime(model.ProductGroup.EndDate, new CultureInfo("en-Us"));
            updatePromotion.CycleEndDate =
                Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")).AddMonths(1);
            updatePromotion.StartBudgetInCycle = model.ProductGroup.Budget -
                                                 configuration.CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.RemainingBudgetInCycle = model.ProductGroup.Budget -
                                                     configuration.CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.EditedDate = DateTime.Now;

            try
            {
                var sw = new ServiceClientWrapper();
                var adEngines = new List<string>();
                if (updatePromotion.IsLaunched)
                {
                    adEngines.AddRange(
                        updatePromotion.PromotionAdEngineSelecteds.Select(
                            pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    sw.scheduleUpdateBudget(customerFk, updatePromotion.PromotionPK, model.ProductGroup.Budget,
                                            adEngines);
                    sw.scheduleChangePromotionStartDate(customerFk, updatePromotion.PromotionPK,
                                                        updatePromotion.PromotionStartDate, adEngines);
                }
            }
            catch (Exception ex)
            {
                SharedResources.Helpers.ExceptionHelper.LogException(ex.ToString());
            }

            // update Geotargeting
            foreach (GeoTargeting geo in updatePromotion.GeoTargetings.ToList())
            {
                dbcontext.GeoTargetings.Remove(geo);
            }

            // update promotion ads; delete first and add them again
            foreach (PromotionAd pad in updatePromotion.PromotionAds.ToList())
            {
                //foreach (SiteLink sli in pad.SiteLinks.ToList())
                //{
                //    dbcontext.SiteLinks.Remove(sli);
                //}
                dbcontext.PromotionAds.Remove(pad);
            }

            // update sitelink; delet first and add them
            foreach (var slink in updatePromotion.SiteLinks.ToList())
            {
                dbcontext.SiteLinks.Remove(slink);
            }

            SavePromotionAdEngineSelected(updatePromotion, model, dbcontext);
            AddGeoTargetingToPromotion(updatePromotion, model, customerFk);
            AddSiteLinksToPromotion(updatePromotion, model, customerFk);
            List<PromotionAd> adAds = AddPromotionAdsToPromotion(updatePromotion, model, customerFk, oldModel);
            SaveNegativeKeywords(updatePromotion, model, dbcontext, customerFk);
            dbcontext.SaveChanges();
            List<int> ads = new List<int>();
            foreach (PromotionAd ad in adAds)
            {
                ads.Add(
                    dbcontext.PromotionAds.Where(
                        key =>
                        key.AdTextLine1 == ad.AdTextLine1 && key.AdTextLine2 == ad.AdTextLine2 &&
                        key.AdTitle == ad.AdTitle && key.PromotionFK == updatePromotion.PromotionPK).First().
                        PromotionAdsPK);
            }
            if (ads.Count > 0 && updatePromotion.IsLaunched)
            {
                var adEngines = new List<string>();
                adEngines.AddRange(
                    updatePromotion.PromotionAdEngineSelecteds.Select(
                        pades => pades.AdvertisingEngine.AdvertisingEngine1));
                var sw = new ServiceClientWrapper();
                sw.scheduleAds(customerFk, updatePromotion.PromotionPK, ads, adEngines,
                               SEMplestConstants.PromotionAdAction.Add);
            }

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
            {
                dbcontext.PromotionAdEngineSelecteds.Remove(adsel);
            }

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

        public void AddGeoTargetingToPromotion(Promotion promo, CampaignSetupModel model, int customerFk)
        {
            if (model.AdModelProp.Addresses != null)
            {
                foreach (GeoTargeting geo in model.AdModelProp.Addresses)
                {
                    // this is check should be removed once we fix the logic in partialview and model
                    if (!String.IsNullOrEmpty(geo.Zip) || (!String.IsNullOrEmpty(geo.City) && geo.StateCodeFK > 0))
                    {
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
                        try
                        {
                            var adEngines = new List<string>();
                            if (promo.IsLaunched)
                            {
                                adEngines.AddRange(
                                    promo.PromotionAdEngineSelecteds.Select(
                                        pades => pades.AdvertisingEngine.AdvertisingEngine1));
                                var sw = new ServiceClientWrapper();
                                sw.scheduleUpdateGeoTargeting(customerFk, promo.PromotionPK, adEngines);
                            }
                        }

                        catch (Exception ex)
                        {
                            SharedResources.Helpers.ExceptionHelper.LogException(ex.ToString());
                        }
                    }
                }
            }
        }

        public void AddSiteLinksToPromotion(Promotion promo, CampaignSetupModel model, int customerFk)
        {
            if (model.SiteLinks != null)
                foreach (var sitelink in model.SiteLinks)
                {
                    //TODO remove when the validation is added
                    if (!string.IsNullOrEmpty(sitelink.LinkText) && !string.IsNullOrEmpty((sitelink.LinkURL)))
                    {
                        var slink = new SiteLink
                                        {
                                            LinkText = sitelink.LinkText,
                                            LinkURL = sitelink.LinkURL,
                                            PromotionFK = promo.PromotionPK
                                        };
                        promo.SiteLinks.Add(slink);
                    }
                }
            try
            {
                var adEngines = new List<string>();
                if (promo.IsLaunched)
                {
                    adEngines.AddRange(
                        promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    var sw = new ServiceClientWrapper();
                    sw.scheduleRefreshSiteLinks(customerFk, promo.PromotionPK, adEngines);
                }
            }
            catch (Exception ex)
            {
                SharedResources.Helpers.ExceptionHelper.LogException(ex.ToString());
            }
        }

        public List<PromotionAd> AddPromotionAdsToPromotion(Promotion promo, CampaignSetupModel model, int customerFk,
                                                            CampaignSetupModel oldModel)
        {
            List<PromotionAd> adAds = new List<PromotionAd>();
            List<GoogleAddAdRequest> verifyAds = new List<GoogleAddAdRequest>();
            foreach (PromotionAd pad in model.AdModelProp.Ads.Where(t => !t.Delete))
            {
                var cad = new PromotionAd
                              {
                                  AdTextLine1 = pad.AdTextLine1,
                                  AdTextLine2 = pad.AdTextLine2,
                                  AdTitle = pad.AdTitle,
                                  PromotionAdsPK = pad.PromotionAdsPK
                              };
                promo.PromotionAds.Add(cad);
                verifyAds.Add(new GoogleAddAdRequest
                                  {
                                      promotionAdID = promo.PromotionPK,
                                      headline = pad.AdTitle,
                                      description1 = pad.AdTextLine1,
                                      description2 = pad.AdTextLine2
                                  });
            }
            try
            {

                var adEngines = new List<string>();
                var promoAds = new List<PromotionAd>();
                List<int> deleteAds = new List<int>();
                List<int> updateAds = new List<int>();
                if (promo.IsLaunched)
                {
                    adEngines.AddRange(
                        promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    //promoAds.AddRange(promo.PromotionAds.Select(pa => pa.PromotionAdsPK));
                    foreach (PromotionAd oldPa in oldModel.AdModelProp.Ads)
                    {
                        var matchingAds = promo.PromotionAds.Where(key => key.PromotionAdsPK == oldPa.PromotionAdsPK);
                        if (matchingAds.Count() > 0)
                        {
                            foreach (PromotionAd pa in matchingAds)
                                if (pa.AdTextLine1 != oldPa.AdTextLine1 || pa.AdTextLine2 != oldPa.AdTextLine2 ||
                                    pa.AdTitle != oldPa.AdTitle)
                                {
                                    updateAds.Add(pa.PromotionAdsPK);
                                    break;
                                }
                        }
                        else
                            deleteAds.Add(oldPa.PromotionAdsPK);
                    }
                    foreach (PromotionAd pa in promo.PromotionAds.Where(key => key.PromotionAdsPK == 0))
                        adAds.Add(pa);
                    var sw = new ServiceClientWrapper();
                    if (updateAds.Count > 0)
                        sw.scheduleAds(customerFk, promo.PromotionPK, updateAds, adEngines,
                                       SEMplestConstants.PromotionAdAction.Update);
                    if (deleteAds.Count > 0)
                        sw.scheduleAds(customerFk, promo.PromotionPK, deleteAds, adEngines,
                                       SEMplestConstants.PromotionAdAction.Delete);
                }
            }
            catch (Exception ex)
            {
                SharedResources.Helpers.ExceptionHelper.LogException(ex.ToString());
            }
            return adAds;
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
            List<string> negativeKeywordsToBeInserted = new List<string>();
            if (negativeKeywords != null)
                negativeKeywordsToBeInserted.AddRange(negativeKeywords);
            foreach (var kpo in kpos)
            {
                kpo.isDeleted = IsDeletedKeyword(kpo.keyword.Trim(), negativeKeywords);
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
                }
            }
        }

        public bool IsDeletedKeyword(string keyword, List<string> negativeKeywords)
        {
            if (negativeKeywords == null)
                return false;
            string k = keyword.ToUpper();
            return (negativeKeywords.Any(key => k.Contains(key.ToUpper())) ||
                    negativeKeywords.Any(key => k.Contains(key.ToUpper() + " ")) ||
                    negativeKeywords.Any(key => k.Contains(" " + key.ToUpper())) ||
                    negativeKeywords.Any(key => k.Contains(" " + key.ToUpper() + " ")));
        }

        public bool IsNegativeKeyword(string keyword, List<string> negativeKeywords)
        {
            if (negativeKeywords == null || String.IsNullOrEmpty(keyword))
                return false;
            return negativeKeywords.Any(key => keyword.ToUpper().Equals(key.ToUpper()));
        }

        public void SaveNegativeKeywords(Promotion promo, CampaignSetupModel model, SemplestModel.Semplest dbcontext,
                                         int customerFk)
        {
            IEnumerable<PromotionKeywordAssociation> qry =
                dbcontext.PromotionKeywordAssociations.Where(key => key.PromotionFK == promo.PromotionPK).ToList();
            var kpos = new List<KeywordProbabilityObject>();
            List<KeywordIdRemoveOppositePair> addKiops = new List<KeywordIdRemoveOppositePair>();
            List<KeywordIdRemoveOppositePair> addNewKiops = new List<KeywordIdRemoveOppositePair>();
            List<KeywordIdRemoveOppositePair> addDeletedKiops = new List<KeywordIdRemoveOppositePair>();
            List<string> addNewKeywords = new List<string>();
            KeywordProbabilityObject kpo;
            foreach (PromotionKeywordAssociation pka in qry)
            {
                kpo = new KeywordProbabilityObject
                          {
                              keyword = pka.Keyword.Keyword1,
                              semplestProbability = pka.SemplestProbability == null ? 0 : pka.SemplestProbability.Value,
                              isTargetMSN = pka.IsTargetMSN,
                              isTargetGoogle = pka.IsTargetGoogle
                          };
                kpos.Add(kpo);
            }
            if (model.AdModelProp.NegativeKeywords != null)
            {
                foreach (string negativeKeyword in model.AdModelProp.NegativeKeywords)
                {
                    if (qry.Any(key => key.Keyword.Keyword1 == negativeKeyword))
                    {
                        if (promo.IsLaunched)
                        {
                            KeywordIdRemoveOppositePair kiop = new KeywordIdRemoveOppositePair();
                            PromotionKeywordAssociation pka =
                                qry.Where(key => key.Keyword.Keyword1 == negativeKeyword).First();
                            //means if the keyword existied and was positive it needs to be removed and added as a negative.
                            kiop.KeywordId = pka.KeywordFK;
                            if (!pka.IsNegative)
                            {
                                kiop.RemoveOpposite = true;
                                addKiops.Add(kiop);
                            }
                        }
                    }
                    else
                    {
                        kpo = new KeywordProbabilityObject {keyword = negativeKeyword};
                        kpos.Add(kpo);
                        if (promo.IsLaunched)
                        {
                            addNewKeywords.Add(negativeKeyword);
                        }
                    }
                }
            }
            //check for negative keywords that have been removed
            foreach (PromotionKeywordAssociation k in qry.Where(key => key.IsNegative == true))
            {
                if (!model.AdModelProp.NegativeKeywords.Contains(k.Keyword.Keyword1))
                {
                    //if (k.IsDeleted)
                    KeywordIdRemoveOppositePair kiopDelete = new KeywordIdRemoveOppositePair();
                    kiopDelete.KeywordId = k.Keyword.KeywordPK;
                    kiopDelete.RemoveOpposite = false;
                    addDeletedKiops.Add(kiopDelete);
                }
            }
            ServiceClientWrapper sw = new ServiceClientWrapper();
            var adEngines = new List<string>();
            adEngines.AddRange(
                promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
            if (addDeletedKiops.Count > 0)
                sw.scheduleNegativeKeywords(customerFk, promo.PromotionPK, addDeletedKiops, adEngines, false);

            SaveKeywords(promo.PromotionPK, kpos, model.AdModelProp.NegativeKeywords,
                         model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);

            if (addKiops.Count() > 0)
                sw.scheduleNegativeKeywords(customerFk, promo.PromotionPK, addKiops, adEngines, true);
            KeywordIdRemoveOppositePair kiopNew = new KeywordIdRemoveOppositePair();
            foreach (string k in addNewKeywords)
            {
                kiopNew.KeywordId = dbcontext.Keywords.Where(key => key.Keyword1 == k).FirstOrDefault().KeywordPK;
                kiopNew.RemoveOpposite = false;
                addNewKiops.Add(kiopNew);
            }
            if (addNewKiops.Count() > 0)
                sw.scheduleNegativeKeywords(customerFk, promo.PromotionPK, addNewKiops, adEngines, true);
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
                dbcontext.SaveChanges();
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
                    where (pgs.CustomerFK == custFk && pgs.ProductGroupName == prodGroup && pms.PromotionName == promotionName)
                    select pms;

                if (queryProdGrp.Any())
                    return true;
                else
                    return false;
            }
        }
    }
}