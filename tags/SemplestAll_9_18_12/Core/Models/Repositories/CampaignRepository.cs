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
using SemplestModel.TVP;


namespace Semplest.Core.Models.Repositories
{
    public class RVal
    {
        public int PKEY { get; set; }
        public string UID { get; set; }
    }

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
      

        private List<GeoTargetObject> SerializeToGeoTargetObjectArray(CampaignSetupModel model)
        {
            var geoList = new List<GeoTargetObject>();
            var sr = new StateRepository();
            foreach (var geo in model.AdModelProp.Addresses)
            {
                if (!geo.IsState && !geo.Delete && !geo.IsCountry)
                {
                    var geoTObj = new GeoTargetObject();
                    geoTObj.address = geo.Address;
                    geoTObj.city = geo.City;
                    if (geo.StateCodeFK != int.MinValue) geoTObj.state = sr.GetStateNameFromCode((int)geo.StateCodeFK);
                    geoTObj.zip = geo.Zip;
                    geoTObj.radius = (double?)(geo.ProximityRadius ?? null);
                    geoTObj.latitude = (double?)(geo.Latitude ?? null);
                    geoTObj.longitude = (double?)(geo.Longitude ?? null);
                    geoList.Add(geoTObj);
                }
            }
            return geoList;
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
                    _savedCampaign = true;
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
                        UpdatePromotionFromModel(updatePromotion, model, dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount);
                        if (updatePromotion.IsLaunched)
                        {
                            var sw = new ServiceClientWrapper();
                            var adEngines = new List<string>();
                            adEngines.AddRange(
                                updatePromotion.PromotionAdEngineSelecteds.Select(
                                    pades => pades.AdvertisingEngine.AdvertisingEngine1));
                            if (model.ProductGroup.Budget != oldModel.ProductGroup.Budget)
                                sw.scheduleUpdateBudget(updatePromotion.PromotionPK, model.ProductGroup.Budget,
                                                        adEngines);
                            if (Convert.ToDateTime(model.ProductGroup.StartDate) != Convert.ToDateTime(oldModel.ProductGroup.StartDate))
                                sw.scheduleChangePromotionStartDate(updatePromotion.PromotionPK,
                                                                    updatePromotion.PromotionStartDate, adEngines);
                        }
                        SavePromotionAdEngineSelected(updatePromotion, model, dbcontext);
                    }
                }
                dbcontext.SaveChanges();
                // we need to set this because the _dbcontext is  and campaign is updated so reflect changes we need to create new context
                _savedCampaign = true;
            }
        }
            
        public string SaveGeoTargetingAds(int customerFK, CampaignSetupModel model, CampaignSetupModel oldModel)
        {
            var rString = new System.Text.StringBuilder();
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var queryProd = (from c in dbcontext.ProductGroups
                                 where
                                     c.CustomerFK == customerFK &&
                                     c.ProductGroupName == model.ProductGroup.ProductGroupName
                                 select c).Single();
                var promo = GetPromotionFromProductGroup(queryProd, model.ProductGroup.ProductPromotionName);

                List<PromotionAd> addAds;
                List<int> updateAds;
                List<int> deleteAds;
                GoogleViolation[] gv;
                PromoAdTableType at;
                var shouldscheduleAds = AddPromotionAdsToPromotion(promo, model, customerFK, oldModel,
                                                   out addAds, out updateAds, out deleteAds, out at);
                if (shouldscheduleAds)
                {
                    List<GoogleAddAdRequest> verifyAds =
                      model.AdModelProp.Ads.Where(t => !t.Delete).Select(pad => new GoogleAddAdRequest
                      {
                          promotionAdID = promo.PromotionPK,
                          headline = pad.AdTitle,
                          description1 =
                              pad.AdTextLine1,
                          description2 =
                              pad.AdTextLine2
                      }).ToList();
                    gv = ValidateAds(model.AdModelProp.LandingUrl,
                                                                           model.AdModelProp.DisplayUrl, verifyAds);
                    if (gv.Length > 0)
                        throw new Exception(gv.First().shortFieldPath + ": " + gv.First().errorMessage);
                }
                GeoTargetTableType gt;
                int addressCode =-1;
                var st = dbcontext.AddressTypes.SingleOrDefault(pt => pt.AddressType1 == model.AdModelProp.PromotionAddressType);
                if (st != null)
                    addressCode = st.AddressTypePK;
                var shouldUpdateGeoTargeting = AddGeoTargetingToPromotion(promo, model, customerFK, oldModel, out gt);
                if (shouldUpdateGeoTargeting)
                {
                    var gtos = SerializeToGeoTargetObjectArray(model);
                    if (gtos.Any())
                    {
                        gv = ValidateGeotargeting(gtos);
                        if (gv.Length > 0)
                            throw new Exception(gv.First().shortFieldPath + ": " + gv.First().errorMessage);
                    }
                }

                var parameter = new SqlParameter("PromotionPK", promo.PromotionPK) { SqlDbType = SqlDbType.Int };
                var parameter2 = new SqlParameter("LandingUrl", model.AdModelProp.LandingUrl.Trim()) { SqlDbType = SqlDbType.NVarChar };
                var parameter3 = new SqlParameter("DisplayUrl", model.AdModelProp.DisplayUrl.Trim()) { SqlDbType = SqlDbType.NVarChar };
                var parameter4 = new SqlParameter("AddressTypeFK", addressCode) { SqlDbType = SqlDbType.Int };
                var parameter5 = new SqlParameter("GeoTVP", gt) { SqlDbType = SqlDbType.Structured, TypeName = "GeoTargetTableType" };
                var parameter6 = new SqlParameter("AdTVP", at) { SqlDbType = SqlDbType.Structured, TypeName = "PromoAdTableType" };
                var parameters = new object[] {parameter, parameter2, parameter3, parameter4, parameter5, parameter6};
                var results = ((IObjectContextAdapter)dbcontext).ObjectContext.ExecuteStoreQuery<RVal>("exec UpdateGeoTargetingPromoAds @PromotionPK, @LandingUrl, @DisplayUrl, @AddressTypeFK, @GeoTVP, @AdTVP", parameters);
                _savedCampaign = true;
                foreach (var r in results)
                {
                    rString.Append(r.UID);
                    rString.Append("=");
                    rString.Append(r.PKEY);
                    rString.Append(",");
                }
                    
                if (promo.IsLaunched)
                {
                    var sw = new ServiceClientWrapper();
                    var adEngines = new List<string>();
                    adEngines.AddRange(
                            promo.PromotionAdEngineSelecteds.Select(
                                pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    if (shouldscheduleAds)
                    {
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
                            sw.scheduleAds(promo.PromotionPK, addAdsIds, adEngines,
                                           SEMplestConstants.PromotionAdAction.Add);
                        }
                        if (updateAds.Any())
                            sw.scheduleAds(promo.PromotionPK, updateAds, adEngines,
                                           SEMplestConstants.PromotionAdAction.Update);
                        if (deleteAds.Any())
                            sw.scheduleAds(promo.PromotionPK, deleteAds, adEngines,
                                           SEMplestConstants.PromotionAdAction.Delete);
                    }
                    if (shouldUpdateGeoTargeting)
                        sw.scheduleUpdateGeoTargeting(promo.PromotionPK, adEngines);
                }
            }
            return string.IsNullOrEmpty(rString.ToString()) ? String.Empty : rString.ToString().Substring(0, rString.ToString().Length - 1);
        }

        public Promotion GetPromoitionFromCampaign(int customerFK, CampaignSetupModel model)
        {
            Promotion promo;
            using (var dbContext =new SemplestModel.Semplest())
            {
                promo = GetPromoitionFromCampaign(dbContext, customerFK, model);
            }
            return promo;
        }

        private Promotion GetPromoitionFromCampaign(SemplestModel.Semplest dbcontext, int customerFK, CampaignSetupModel model)
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
                model.ProductGroup.IsAutoBid = promo.IsAutobid;
                model.ProductGroup.AutoBidMaxCPC = promo.AutoBidMaxCPC;
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
                var singleOrDefault = promo.GeoTargetings.FirstOrDefault();
                if (singleOrDefault != null && singleOrDefault.AddressType != null)
                    model.AdModelProp.PromotionAddressType = singleOrDefault.AddressType.AddressType1;
                else
                    model.AdModelProp.PromotionAddressType = "NATIONALLY";

                // set promotionads
                model.AdModelProp.Ads = promo.PromotionAds.Where(ads => !ads.IsDeleted).ToList();

                if (!preview)
                {
                    // set negative keywords
                    if (promo.PromotionKeywordAssociations != null)
                        model.AdModelProp.NegativeKeywords =
                            promo.PromotionKeywordAssociations.Where(m => m.IsNegative && !m.IsDeleted).Select(m => m.Keyword.Keyword1).
                                ToList();
                }

                // set islaunched
                model.IsLaunched = promo.IsLaunched;
                model.IsCompleted = promo.IsCompleted;
                if (!preview)
                {
                    model.AllKeywords.AddRange(
                        promo.PromotionKeywordAssociations.Where(key => !key.IsDeleted && !key.IsNegative).OrderByDescending(o => o.SemplestProbability).Select(
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
                          select new {c.PercentOfMedia, c.PromotionFeeAmount, c.PromotionFeeOverride, c.AllowAutobid};
            var firstOrDefault = custobj.FirstOrDefault();
            if (firstOrDefault != null)
            {
                model.ProductGroup.AllowAutoBid = firstOrDefault.AllowAutobid;
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
                                IsAutobid = model.ProductGroup.IsAutoBid,
                                AutoBidMaxCPC = model.ProductGroup.AutoBidMaxCPC
                            };

            return promo;

        }

        private void UpdatePromotionFromModel(Promotion updatePromotion, CampaignSetupModel model,
                                             decimal customerDefaultPerCampaignFlatFeeAmount)
        {
            model.AdModelProp.LandingUrl = model.AdModelProp.LandingUrl.Trim();
            model.AdModelProp.DisplayUrl = string.IsNullOrEmpty(model.AdModelProp.DisplayUrl) ? string.Empty : model.AdModelProp.DisplayUrl.Trim();
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
            updatePromotion.IsAutobid = model.ProductGroup.IsAutoBid;
            updatePromotion.AutoBidMaxCPC = model.ProductGroup.AutoBidMaxCPC;
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

        public bool AddGeoTargetingToPromotion(Promotion promo, CampaignSetupModel model, int customerFk, CampaignSetupModel oldModel, out GeoTargetTableType gtt)
        {
            bool shouldUpdateGeoTargeting = false;
            gtt = new GeoTargetTableType();

            GeoTargetTableTypeRow gtr;

            if (model.AdModelProp.Addresses != null)
            {
                foreach (GeoTargeting geo in model.AdModelProp.Addresses)
                {
                    gtr = gtt.NewRow();
                    if (geo.Delete & !geo.HasBeenSaved)
                    {
                        var gt = promo.GeoTargetings.FirstOrDefault(x => x.GeoTargetingPK == geo.GeoTargetingPK);
                        if (gt != null)
                        {
                            gtr.PKEY = geo.GeoTargetingPK;
                            gtr.Operation = "D";
                            shouldUpdateGeoTargeting = true;
                        }
                    }
                    else if (geo.GeoTargetingPK == 0 && !geo.IsCountry & !geo.HasBeenSaved)
                    {
                        shouldUpdateGeoTargeting = true;
                        gtr.Address = geo.Address;
                        gtr.City = geo.City;
                        gtr.StateCodeFK = geo.StateCodeFK == int.MinValue ? null: geo.StateCodeFK;
                        gtr.Zip = geo.Zip;
                        gtr.ProximityRadius = geo.ProximityRadius;
                        gtr.Latitude = geo.Latitude;
                        gtr.Longitude = geo.Longitude;
                        gtr.UID = geo.UID;
                        gtr.Operation = "I";
                    }
                    else if (!geo.IsCountry)
                    {
                        GeoTargeting geoOld =
                            oldModel.AdModelProp.Addresses.SingleOrDefault(x => x.GeoTargetingPK == geo.GeoTargetingPK);
                        if (geoOld.Address != geo.Address ||
                            geoOld.City != geo.City ||
                            geoOld.Latitude != geo.Latitude ||
                            geoOld.Longitude != geo.Longitude ||
                            geoOld.ProximityRadius != geo.ProximityRadius ||
                            geoOld.Zip != geo.Zip ||
                            geoOld.StateCodeFK != geo.StateCodeFK)
                        {
                            shouldUpdateGeoTargeting = true;
                            gtr.Address = geo.Address;
                            gtr.City = geo.City;
                            gtr.Latitude = geo.Latitude;
                            gtr.Longitude = geo.Longitude;
                            gtr.ProximityRadius = geo.ProximityRadius;
                            gtr.Zip = geo.Zip;
                            gtr.StateCodeFK = geo.StateCodeFK == int.MinValue ? null : geo.StateCodeFK;
                            gtr.PKEY = geo.GeoTargetingPK;
                            gtr.Operation = "U";
                        }
                    }
                    if (!string.IsNullOrEmpty(gtr.Operation))
                        gtt.Add(gtr);
                }
            }
            return shouldUpdateGeoTargeting;
        }

        public string SaveSiteLinks(CampaignSetupModel model, int customerFk, CampaignSetupModel oldModel)
        {
            bool shouldRefreshSiteLinks = false;
            var rString = new System.Text.StringBuilder();
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var queryProd = (from c in dbcontext.ProductGroups
                                 where
                                     c.CustomerFK == customerFk &&
                                     c.ProductGroupName == model.ProductGroup.ProductGroupName
                                 select c).Single();
                var promo = GetPromotionFromProductGroup(queryProd, model.ProductGroup.ProductPromotionName);
                List<GoogleSiteLink> sl =
                                          model.SiteLinks.Where(t => !t.Delete).Select(row => new GoogleSiteLink
                                          {
                                              LinkText = row.LinkText,
                                              LinkURL = row.LinkURL
                                          }).ToList();
                if (sl.Any())
                {
                    GoogleViolation[] gv = ValidateSiteLinks(sl);
                    if (gv.Length > 0)
                        throw new Exception(gv.First().shortFieldPath + ": " + gv.First().errorMessage);
                }
                SiteLinksTableType st;
                shouldRefreshSiteLinks = AddSiteLinksToPromotion(promo, model, customerFk, ((IObjectContextAdapter)dbcontext).ObjectContext, oldModel, out st);

                var parameter = new SqlParameter("PromotionPK", promo.PromotionPK) { SqlDbType = SqlDbType.Int };
                var parameter2 = new SqlParameter("SlTVP", st) { SqlDbType = SqlDbType.Structured, TypeName = "SiteLinksTableType" };
                var parameters = new object[] { parameter, parameter2 };
                var results = ((IObjectContextAdapter)dbcontext).ObjectContext.ExecuteStoreQuery<RVal>("exec UpdateSiteLinks @PromotionPK, @SlTVP", parameters);
                _savedCampaign = true;
                foreach (var r in results)
                {
                    rString.Append(r.UID);
                    rString.Append("=");
                    rString.Append(r.PKEY);
                    rString.Append(",");
                }
                _savedCampaign = true;
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
            return string.IsNullOrEmpty(rString.ToString()) ? String.Empty : rString.ToString().Substring(0, rString.ToString().Length - 1);
        }

        private bool AddSiteLinksToPromotion(Promotion promo, CampaignSetupModel model, int customerFk, System.Data.Objects.ObjectContext context, CampaignSetupModel oldModel, out SiteLinksTableType st)
        {
            bool shouldRefreshSiteLinks = false;
            st = new SiteLinksTableType();
            if (model.SiteLinks != null)

                foreach (var sitelink in model.SiteLinks)
                {
                    SiteLinksTableTypeRow str = st.NewRow();
                    if (sitelink.Delete && !sitelink.SiteLinksSaved)
                    {
                        var sl = promo.SiteLinks.SingleOrDefault(x => x.SiteLInkPK == sitelink.SiteLInkPK);
                        if (sl != null)
                        {
                            str.Operation = "D";
                            str.PKEY = sl.SiteLInkPK;
                            context.DeleteObject(sl);
                            shouldRefreshSiteLinks = true;
                        }
                    }
                        //TODO remove when the validation is added
                        //if (!string.IsNullOrEmpty(sitelink.LinkText) && !string.IsNullOrEmpty((sitelink.LinkURL)))
                    else if (sitelink.SiteLInkPK == 0 && !sitelink.SiteLinksSaved)
                    {
                        shouldRefreshSiteLinks = true;
                        str.LinkText = sitelink.LinkText;
                        str.LinkUrl = sitelink.LinkURL;
                        str.UID = sitelink.UID;
                        str.Operation = "I";
                    }
                    else
                    {
                        var siteOld = oldModel.SiteLinks.Single(x => x.SiteLInkPK == sitelink.SiteLInkPK);
                        if (siteOld.LinkText != sitelink.LinkText ||
                            siteOld.LinkURL != sitelink.LinkURL)
                        {
                            shouldRefreshSiteLinks = true;
                            str.LinkText = sitelink.LinkText;
                            str.LinkUrl = sitelink.LinkURL;
                            str.PKEY = sitelink.SiteLInkPK;
                            str.Operation = "U";
                        }
                    }
                    if (!string.IsNullOrEmpty(str.Operation))
                        st.Add(str);
                }
            return shouldRefreshSiteLinks;
           
        }

        private static bool AddPromotionAdsToPromotion(Promotion promo, CampaignSetupModel model, int customerFk,
                                                            CampaignSetupModel oldModel, out List<PromotionAd> addAds, out List<int> updateAds, out List<int> deleteAds, out PromoAdTableType att)
        {
            deleteAds = new List<int>();
            updateAds = new List<int>();
            addAds = new List<PromotionAd>();
            bool shouldscheduleAds = false;
            att = new PromoAdTableType();

            PromoAdTableTypeRow atr;
            foreach (PromotionAd pad in model.AdModelProp.Ads)
            {
                atr = att.NewRow();
                if (pad.Delete && pad.PromotionAdsPK != 0)
                {
                    var singlePromo = promo.PromotionAds.Single(id => id.PromotionAdsPK == pad.PromotionAdsPK);
                    if (singlePromo != null)
                    {
                        if (!promo.IsLaunched)
                        {
                            atr.PKEY = pad.PromotionAdsPK;
                            atr.Operation = "D";
                        }
                        deleteAds.Add(pad.PromotionAdsPK);
                        shouldscheduleAds = true;
                    }
                }
                else if (!pad.Delete && pad.PromotionAdsPK == 0)
                {
                    shouldscheduleAds = true;
                    addAds.Add(pad);
                    atr.AdTextLine1 = pad.AdTextLine1;
                    atr.AdTextLine2 = pad.AdTextLine2;
                    atr.AdTitle = pad.AdTitle;
                    atr.UID = pad.UID;
                    atr.Operation = "I";
                }
                else if (!pad.Delete && pad.PromotionAdsPK != 0)
                {
                    var oldAd = oldModel.AdModelProp.Ads.SingleOrDefault(x => x.PromotionAdsPK == pad.PromotionAdsPK);
                    if (oldAd.AdTextLine1 != pad.AdTextLine1 ||
                            oldAd.AdTextLine2 != pad.AdTextLine2 || oldAd.AdTitle != pad.AdTitle)
                    {
                        shouldscheduleAds = true;
                        updateAds.Add(pad.PromotionAdsPK);
                        atr.AdTextLine1 = pad.AdTextLine1;
                        atr.AdTextLine2 = pad.AdTextLine2;
                        atr.AdTitle = pad.AdTitle;
                        atr.PKEY = pad.PromotionAdsPK;
                        atr.Operation = "U";
                    }
                }
                if (!string.IsNullOrEmpty(atr.Operation))
                    att.Add(atr);
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
            if (negativeKeywords != null)
                negativeKeywordsToBeInserted.AddRange(negativeKeywords);
            foreach (var kpo in kpos)
            {
                if (!kpo.isDeleted)
                {
                    kpo.isDeleted = IsDeletedKeyword(kpo.keyword.Trim(), negativeKeywords);
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

        private void RefreshKeywords(CampaignSetupModel model, Promotion promo)
        {
            using (var dbcontext = new SemplestModel.Semplest())
            {
                IEnumerable<PromotionKeywordAssociation> qry =
                    dbcontext.PromotionKeywordAssociations.Where(key => key.PromotionFK == promo.PromotionPK).ToList();
                var kpos = new List<KeywordProbabilityObject>();
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
                SaveKeywords(promo.PromotionPK, kpos, model.AdModelProp.NegativeKeywords,
                             model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
            }
        }
        public List<CampaignSetupModel.KeywordsModel> SaveNegativeKeywords(CampaignSetupModel model, int customerFk)
        {
            if (model.AdModelProp.NegativeKeywords.Any())
            {
                GoogleViolation[] gv = ValidateGoogleNegativeKeywords(model.AdModelProp.NegativeKeywords);
                if (gv.Length > 0)
                    throw new Exception(gv.First().shortFieldPath + ": " + gv.First().errorMessage);
            }
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var promo = GetPromoitionFromCampaign(dbcontext, customerFk, model);
                if (!promo.IsLaunched)
                { RefreshKeywords(model, promo); }
                else
                {
                    var addKiops = new List<KeywordIdRemoveOppositePair>();
                    var addNewKiops = new List<string>();
                    var addDeletedKiops = new List<int>();
                    var qpka = promo.PromotionKeywordAssociations.ToList();
                    //check negative keywords that have been added to the gui
                    if (model.AdModelProp.NegativeKeywords != null)
                    {
                        foreach (string negativeKeyword in model.AdModelProp.NegativeKeywords)
                        {
                            var kiop = new KeywordIdRemoveOppositePair();
                            var pka = qpka.SingleOrDefault(key => key.Keyword.Keyword1 == negativeKeyword);
                            if (pka != null)
                            {
                                //means if the keyword existied and was positive it needs to be removed and added as a negative. 
                                //if the keyword is already negative then do nothing because we've already added it
                                kiop.keywordId = pka.KeywordFK;
                                if (!pka.IsNegative)
                                {
                                    kiop.removeOpposite = true;
                                    addKiops.Add(kiop);
                                }
                            }
                            else
                            {
                                var kw = dbcontext.Keywords.SingleOrDefault(key => key.Keyword1 == negativeKeyword);
                                if (kw != null)
                                {
                                    kiop.keywordId = kw.KeywordPK;
                                    kiop.removeOpposite = false;
                                    addKiops.Add(kiop);
                                }
                                else//this keyword doesn't exist in the database so when we call the stored proc get the id so it can be sent to the api
                                    addNewKiops.Add(negativeKeyword);
                            }
                        }
                    }

                    //check for negative keywords that have been removed from the gui
                    foreach (PromotionKeywordAssociation k in qpka.Where(key => key.IsNegative == true).ToList())
                    {
                        if (!model.AdModelProp.NegativeKeywords.Contains(k.Keyword.Keyword1))
                            addDeletedKiops.Add(k.Keyword.KeywordPK);
                    }

                    List<int> deletedKeywords = new List<int>();
                    var op = new System.Data.Objects.ObjectParameter("NegativeKeywordID", typeof(int));
                    var op2 = new System.Data.Objects.ObjectParameter("Exists", typeof(int));
                    foreach (string kw in model.AdModelProp.NegativeKeywords)
                    {
                        //keywords that need to be deleted
                        var snr = dbcontext.SetNegativeKeyword(kw, promo.PromotionPK, op, op2).ToList();
                        if (snr.Any())
                        {
                            deletedKeywords.AddRange(snr.Select(ids => ids.KeywordPK));
                        }

                        if (!string.IsNullOrEmpty(op.Value.ToString()))
                        {
                            var kop = new KeywordIdRemoveOppositePair { keywordId = int.Parse(op.Value.ToString()), removeOpposite = bool.Parse(op2.Value.ToString()) };
                            addKiops.Add(kop);
                        }
                    }
                    foreach (int dk in addDeletedKiops)
                        promo.PromotionKeywordAssociations.Single(kw => kw.KeywordFK == dk).IsDeleted=true;
                    dbcontext.SaveChanges();
                    _savedCampaign = true;
                    var sw = new ServiceClientWrapper();
                    var adEngines = new List<string>();
                    adEngines.AddRange(
                        promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    if (addDeletedKiops.Any())
                        sw.DeleteNegativeKeywords(promo.PromotionPK, addDeletedKiops, adEngines);
                    if (addKiops.Any())
                        sw.AddNegativeKeywords(promo.PromotionPK, addKiops, adEngines);
                    if (deletedKeywords.Any())
                        sw.DeleteKeywords(promo.PromotionPK, deletedKeywords, adEngines);
                }
                model.AllKeywords.Clear();
                model.AllKeywords.AddRange(
                    promo.PromotionKeywordAssociations.Where(key => !key.IsDeleted && !key.IsNegative).Select(
                        key =>
                        new CampaignSetupModel.KeywordsModel { Name = key.Keyword.Keyword1, Id = key.Keyword.KeywordPK }));
            }
            return model.AllKeywords;
        }

        public string GetStateNameFromCode(int stateCode)
        {
            string stateName = string.Empty;
            using (var db = new SemplestModel.Semplest())
            {
                var state = db.StateCodes.SingleOrDefault(m => m.StateAbbrPK == stateCode);
                if(state != null)
                    stateName = state.StateAbbr;
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
                _savedCampaign = true;
                var adEngines = new List<string>();
                var promo = dbcontext.Promotions.Single(row => row.PromotionPK == promoId);
                if (promo.IsLaunched)
                {
                    var sw = new ServiceClientWrapper();
                    adEngines.AddRange(
                            promo.PromotionAdEngineSelecteds.Select(pades => pades.AdvertisingEngine.AdvertisingEngine1));
                    sw.DeleteKeywords(promoId, keywordIds, adEngines);
                }
            }
        }

        private GoogleViolation[] ValidateSiteLinks(List<GoogleSiteLink> sl)
        {
            var sw = new ServiceClientWrapper();
            return sw.ValidateGoogleRefreshSiteLinks(sl);
        }

        private GoogleViolation[] ValidateGeotargeting(List<GeoTargetObject> gto)
        {
            var sw = new ServiceClientWrapper();
            return sw.ValidateGoogleGeoTargets(gto);
        }

        private GoogleViolation[] ValidateAds(String landingPageURL, String displayURL, List<GoogleAddAdRequest> ads)
        {
            var sw = new ServiceClientWrapper();
            return sw.ValidateGoogleAd(landingPageURL, displayURL, ads);
        }

        private GoogleViolation[] ValidateGoogleNegativeKeywords(List<string> negativeKeywords)
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