using System;
using System.Globalization;
using System.Linq;
using System.Collections.Generic;
using System.Data.Services;
using System.Data.Services.Common;
using Semplest.Core.Models;
using SemplestModel;
using System.Data.Objects;
using System.Data;
using System.Data.SqlClient;
using Semplest.SharedResources.Services;
using System.Diagnostics;

namespace Semplest.Core.Services
{
    public class SemplestDataService : DataService<SemplestEntities>
    {
        private static bool _savedCampaign;
        public SemplestDataService()
        {
            _savedCampaign = false;
        }
        private static SemplestEntities _dbcontext;


        private static SemplestEntities InitializeContext()
        {
            // we need to check _savedCampaign flag because the _dbcontext is static and campaign is updated 
            // to reflect changes we need to create new context

            if (_dbcontext == null || _savedCampaign == true)
            {
                _dbcontext = new SemplestEntities();
                _savedCampaign = false;
            }
            return _dbcontext;
        }

        // This method is called only once to initialize service-wide policies.
        public static void InitializeService(DataServiceConfiguration config)
        {
            // TODO: set rules to indicate which entity sets and service operations are visible, updatable, etc.
            // Examples:
            config.SetEntitySetAccessRule("Campaign", EntitySetRights.AllRead
                                                      | EntitySetRights.WriteMerge | EntitySetRights.WriteReplace);
            // config.SetServiceOperationAccessRule("MyServiceOperation", ServiceOperationRights.All);
            config.DataServiceBehavior.MaxProtocolVersion = DataServiceProtocolVersion.V2;
        }

        public void SaveProductGroupAndCampaign(int userid, CampaignSetupModel model)
        {
            using (var dbcontext = new SemplestEntities())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                var i = queryCustFk.FirstOrDefault();
                if (i != null)
                {
                    var custfk = (int)i;

                    // check if the ProductGroupName already exists
                    var queryProdGrp = from c in dbcontext.ProductGroups
                                       where c.CustomerFK == custfk && c.ProductGroupName == model.ProductGroup.ProductGroupName
                                       select c;
                    if (queryProdGrp.Any())
                    {
                        // product grp already exists so update the product group 
                        var updateProdGrp = queryProdGrp.FirstOrDefault();
                        if (updateProdGrp != null)
                        {
                            updateProdGrp.ProductGroupName = model.ProductGroup.ProductGroupName;
                            updateProdGrp.StartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us"));
                            updateProdGrp.EndDate = String.IsNullOrEmpty(model.ProductGroup.EndDate) ? (DateTime?)null : Convert.ToDateTime(model.ProductGroup.EndDate);

                            // get promotion and update it
                            var updatePromotion = GetPromotionFromProductGroup(updateProdGrp, model.ProductGroup.ProductPromotionName);
                            // if this is null means promotion name changed so create a new promotion
                            if (updatePromotion == null)
                            {
                                // create new promotion
                                updatePromotion = CreatePromotionFromModel(model, dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount);
                                updatePromotion.ProductGroupFK = updateProdGrp.ProductGroupPK;

                                // add geotargeting to promotion
                                AddGeoTargetingToPromotion(updatePromotion, model, custfk);
                                // promotion ads
                                AddPromotionAdsToPromotion(updatePromotion, model, custfk);

                                dbcontext.Promotions.AddObject(updatePromotion);
                            }
                            else
                            {
                                // update promotion
                                UpdatePromotionFromModel(updatePromotion, model, dbcontext, custfk);
                            }
                        }

                        dbcontext.SaveChanges();

                        // we need to set this because the _dbcontext is static and campaign is updated so reflect changes we need to create new context
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
                            StartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")),
                            EndDate = String.IsNullOrEmpty(model.ProductGroup.EndDate) ? (DateTime?)null : Convert.ToDateTime(model.ProductGroup.EndDate)
                        };

                        // create promotion
                        var promo = CreatePromotionFromModel(model, dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount);

                        // add advertising engines that are selected
                        SavePromotionAdEngineSelected(promo, model, dbcontext);

                        // add geotargeting to promotion
                        AddGeoTargetingToPromotion(promo, model,custfk);

                        // save site links
                        AddSiteLinksToPromotion(promo, model, custfk);

                        // promotion ads
                        AddPromotionAdsToPromotion(promo, model, custfk);

                        // add product group
                        dbcontext.ProductGroups.AddObject(prodgroup);
                        // add promotion
                        dbcontext.Promotions.AddObject(promo);
                        dbcontext.SaveChanges();

                        // save negative keywords
                        SaveNegativeKeywords(promo, model, dbcontext);
                    }
                }
            }
        }

        static readonly Func<SemplestEntities, int, Promotion> PromotonIdQuery = CompiledQuery.Compile((SemplestEntities nw, int promoId) => nw.Promotions.FirstOrDefault(p => p.PromotionPK == promoId));

        public static CampaignSetupModel GetCampaignSetupModelForPromotionId(int promoId)
        {
            var model = new CampaignSetupModel();
            var dbcontext = InitializeContext();
            //var promo = dbcontext.Promotions.FirstOrDefault(p => p.PromotionPK == promoId);
            var promo = PromotonIdQuery.Invoke(dbcontext, promoId);

            // populate model from promotions
            if (promo != null)
            {
                model.ProductGroup.ProductGroupName = promo.ProductGroup.ProductGroupName;
                model.ProductGroup.ProductPromotionName = promo.PromotionName;
                model.ProductGroup.Budget = promo.PromotionBudgetAmount;
                model.ProductGroup.StartDate = promo.ProductGroup.StartDate.ToString(new CultureInfo("en-Us"));
                model.ProductGroup.EndDate = promo.ProductGroup.EndDate.HasValue ? promo.ProductGroup.EndDate.Value.ToString(CultureInfo.InvariantCulture) : String.Empty;

                // set words
                model.ProductGroup.Words = promo.PromotionDescription;
            }

            // set advertising engines
            model.ProductGroup.AdEnginesSelectedList = new List<AdEngineSelectModel>();
            if (promo != null)
            {
                foreach (var paes in promo.PromotionAdEngineSelecteds)
                {
                    var aesm = new AdEngineSelectModel { Id = paes.AdvertisingEngine.AdvertisingEnginePK, Name = paes.AdvertisingEngine.AdvertisingEngine1 };
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

                // set negative keywords
                if (promo.PromotionKeywordAssociations != null)
                    model.AdModelProp.NegativeKeywords = promo.PromotionKeywordAssociations.Where(m => m.IsNegative).Select(m => m.Keyword.Keyword1).ToList();

                // set islaunched
                model.IsLaunched = promo.IsLaunched;
                model.IsCompleted = promo.IsCompleted;

                // set sitelinks
                model.SiteLinks = promo.SiteLinks.ToList();
            }
            var cnt = model.AdModelProp.NegativeKeywords.Count();
            for (var i = 0; i < cnt; i++)
            {
                model.AdModelProp.NegativeKeywordsText += model.AdModelProp.NegativeKeywords[i];
                if (i < cnt - 1)
                {
                    model.AdModelProp.NegativeKeywordsText += ", ";
                }
            }


            //added by tudor
            int userid = ((Credential)System.Web.HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]).UsersFK;
            var queryCustFk = from u in dbcontext.Users where u.UserPK == userid select u.CustomerFK;
            var custobj = from c in dbcontext.Customers where c.CustomerPK == queryCustFk.FirstOrDefault() select new { c.PercentOfMedia, c.PromotionFeeAmount, c.PromotionFeeOverride };
            model.PercentMedia = custobj.FirstOrDefault().PercentOfMedia;
            model.PromotionFeeOverRide = custobj.FirstOrDefault().PromotionFeeOverride;
            model.PromotionFeeOverRideAmount = custobj.FirstOrDefault().PromotionFeeAmount;
            //



            return model;
        }

        public static IQueryable<vwProductPromotion> GetUserWithProductGroupAndPromotions(int userid)
        {
            var semplestEntities = new SemplestEntities();
            return semplestEntities.vwProductPromotions.Where(t => t.UserPK == userid);
        }

        private static Promotion GetPromotionFromProductGroup(ProductGroup prodGroup, string promotionName)
        {
            var promo = prodGroup.Promotions.FirstOrDefault(m => m.PromotionName == promotionName);
            return promo;
        }

        public List<ProductGroup> GetProductGroupsForUser(int userid)
        {
            using (var dbcontext = new SemplestEntities())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                var customerIdFk = queryCustFk.FirstOrDefault();
                if (customerIdFk != null)
                {
                    int custfk = (int)customerIdFk;

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

        public static int GetPromotionId(int userid, string prodGroupName, string promotionName)
        {
            using (var dbcontext = new SemplestEntities())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                var i = queryCustFk.First();
                if (i != null)
                {
                    var custfk = (int)i;

                    // get ProductGroup
                    var queryProdGrp = from c in dbcontext.ProductGroups
                                       where c.CustomerFK == custfk && c.ProductGroupName == prodGroupName
                                       select c;
                    // get Promotion
                    if (queryProdGrp.Any())
                    {
                        var prodGrp = queryProdGrp.First();
                        var queryPromo = prodGrp.Promotions.Where(m => m.PromotionName == promotionName);
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

        private static int GetBudgetCycleId(string budgetCycleName)
        {
            using (var dbcontext = new SemplestEntities())
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

        private Promotion CreatePromotionFromModel(CampaignSetupModel model, decimal customerDefaultPerCampaignFlatFeeAmount)
        {
            var promo = new Promotion
            {


                PromotionName = model.ProductGroup.ProductPromotionName,
                LandingPageURL = model.AdModelProp.LandingUrl,
                DisplayURL = model.AdModelProp.DisplayUrl,
                PromotionDescription = model.ProductGroup.Words,
                PromotionBudgetAmount = model.ProductGroup.Budget,
                BudgetCycleFK = GetBudgetCycleId("Monthly"),
                CycleStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")),
                CycleEndDate = string.IsNullOrEmpty(model.ProductGroup.EndDate) ? Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")).AddMonths(1) : Convert.ToDateTime(model.ProductGroup.EndDate, new CultureInfo("en-Us")),
                StartBudgetInCycle = model.ProductGroup.Budget - customerDefaultPerCampaignFlatFeeAmount,
                RemainingBudgetInCycle = model.ProductGroup.Budget - customerDefaultPerCampaignFlatFeeAmount,
                PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")),
                IsPaused = false,
                IsCompleted = false,
                IsLaunched = false,
                CreatedDate = DateTime.Now
            };

            return promo;

        }

        private void UpdatePromotionFromModel(Promotion updatePromotion, CampaignSetupModel model, SemplestEntities dbcontext, int customerFK)
        {
            updatePromotion.LandingPageURL = model.AdModelProp.LandingUrl;
            updatePromotion.DisplayURL = model.AdModelProp.DisplayUrl;
            updatePromotion.PromotionDescription = model.ProductGroup.Words;
            updatePromotion.PromotionBudgetAmount = model.ProductGroup.Budget;
            updatePromotion.PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us"));
            updatePromotion.CycleStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us"));
            updatePromotion.CycleEndDate = string.IsNullOrEmpty(model.ProductGroup.EndDate) ? Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")).AddMonths(1) : Convert.ToDateTime(model.ProductGroup.EndDate, new CultureInfo("en-Us"));
            updatePromotion.StartBudgetInCycle = model.ProductGroup.Budget - dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.RemainingBudgetInCycle = model.ProductGroup.Budget - dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.EditedDate = DateTime.Now;

            try
            {
                ServiceClientWrapper sw = new ServiceClientWrapper();
                List<string> adEngines = new List<string>();
                if (updatePromotion.IsLaunched)
                {
                    foreach (PromotionAdEngineSelected pades in updatePromotion.PromotionAdEngineSelecteds)
                        adEngines.Add(pades.AdvertisingEngine.AdvertisingEngine1);
                    sw.scheduleUpdateBudget(customerFK, updatePromotion.PromotionPK,model.ProductGroup.Budget, adEngines);
                    sw.scheduleChangePromotionStartDate(customerFK, updatePromotion.PromotionPK, updatePromotion.PromotionStartDate, adEngines);
                }
            }
            catch (Exception ex) { Semplest.SharedResources.Helpers.ExceptionHelper.LogException(ex.ToString()); }

            // update Geotargeting
            foreach (GeoTargeting geo in updatePromotion.GeoTargetings.ToList())
            {
                dbcontext.GeoTargetings.DeleteObject(geo);
            }

            // update promotion ads; delete first and add them again
            foreach (PromotionAd pad in updatePromotion.PromotionAds.ToList())
            {
                //foreach (SiteLink sli in pad.SiteLinks.ToList())
                //{
                //    dbcontext.SiteLinks.DeleteObject(sli);
                //}
                dbcontext.PromotionAds.DeleteObject(pad);
            }

            // update sitelink; delet first and add them
            foreach (var slink in updatePromotion.SiteLinks.ToList())
            {
                dbcontext.SiteLinks.DeleteObject(slink);
            }

            SavePromotionAdEngineSelected(updatePromotion, model, dbcontext);
            AddGeoTargetingToPromotion(updatePromotion, model, customerFK);
            AddSiteLinksToPromotion(updatePromotion, model, customerFK);
            SaveNegativeKeywords(updatePromotion, model, dbcontext);
            AddPromotionAdsToPromotion(updatePromotion, model, customerFK);
        }

        private void SavePromotionAdEngineSelected(Promotion promo, CampaignSetupModel model, SemplestEntities dbcontext)
        {
            var existingAdenginesSeleccted = dbcontext.PromotionAdEngineSelecteds.Where(m => m.PromotionFK == promo.PromotionPK);
            var templist = new List<int>();
            model.ProductGroup.AdEnginesList.ForEach(t => templist.Add(Convert.ToInt32(t)));
            var dn = existingAdenginesSeleccted.Where(t => !templist.Contains(t.AdvertisingEngineFK));
            foreach (var adsel in dn)
            {
                dbcontext.PromotionAdEngineSelecteds.DeleteObject(adsel);
            }

            foreach (int aes in model.ProductGroup.AdEnginesList)
            {
                int adengineid = Convert.ToInt32(aes);
                var proAdEng = dbcontext.AdvertisingEngines.FirstOrDefault(m => m.AdvertisingEnginePK == adengineid);
                if (proAdEng != null)
                {
                    var adEngSelQuery = existingAdenginesSeleccted.FirstOrDefault(m => m.AdvertisingEngineFK == proAdEng.AdvertisingEnginePK);
                    if (adEngSelQuery == null)
                    {
                        var adEngineSel = new PromotionAdEngineSelected
                        {
                            AdvertisingEngineFK = proAdEng.AdvertisingEnginePK,
                            PromotionFK = promo.PromotionPK
                        };
                        dbcontext.PromotionAdEngineSelecteds.AddObject(adEngineSel);
                    }
                    //dbcontext.SaveChanges();
                }
            }
        }

        private void AddGeoTargetingToPromotion(Promotion promo, CampaignSetupModel model, int customerFk)
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
                            ServiceClientWrapper sw = new ServiceClientWrapper();
                            List<string> adEngines = new List<string>();
                            if (promo.IsLaunched)
                            {
                                foreach (PromotionAdEngineSelected pades in promo.PromotionAdEngineSelecteds)
                                    adEngines.Add(pades.AdvertisingEngine.AdvertisingEngine1);
                                sw.scheduleUpdateGeoTargeting(customerFk, promo.PromotionPK, adEngines);
                            }
                        }
                        catch (Exception ex) { Semplest.SharedResources.Helpers.ExceptionHelper.LogException(ex.ToString()); }
                    }
                }
            }
        }

        private void AddSiteLinksToPromotion(Promotion promo, CampaignSetupModel model, int customerFk)
        {
            if (model.SiteLinks != null)
                foreach (var sitelink in model.SiteLinks)
                {
                    var slink = new SiteLink
                    {
                        LinkText = sitelink.LinkText,
                        LinkURL = sitelink.LinkURL,
                        PromotionFK = promo.PromotionPK
                    };
                    promo.SiteLinks.Add(slink);
                    try
                    {
                        ServiceClientWrapper sw = new ServiceClientWrapper();
                        List<string> adEngines = new List<string>();
                        if (promo.IsLaunched)
                        {
                            foreach (PromotionAdEngineSelected pades in promo.PromotionAdEngineSelecteds)
                                adEngines.Add(pades.AdvertisingEngine.AdvertisingEngine1);
                            sw.scheduleRefreshSiteLinksForAd(customerFk, promo.PromotionPK, adEngines);
                        }
                    }
                    catch (Exception ex) { Semplest.SharedResources.Helpers.ExceptionHelper.LogException(ex.ToString()); }
                }
        }

        private void AddPromotionAdsToPromotion(Promotion promo, CampaignSetupModel model, int customerFk)
        {
            foreach (PromotionAd pad in model.AdModelProp.Ads.Where(t => !t.Delete))
            {
                var cad = new PromotionAd { AdTextLine1 = pad.AdTextLine1, AdTextLine2 = pad.AdTextLine2, AdTitle = pad.AdTitle };

                //if (pad.SiteLinks != null)
                //{
                //    // add sitelinks
                //    foreach (SiteLink slink in pad.SiteLinks)
                //    {
                //        // this is check should be removed once we fix the logic in partialview and model
                //        if (!String.IsNullOrEmpty(slink.LinkText) && !String.IsNullOrEmpty(slink.LinkURL))
                //        {
                //            var slinkobj = new SiteLink { LinkText = slink.LinkText, LinkURL = slink.LinkURL };
                //            cad.SiteLinks.Add(slinkobj);
                //        }
                //    }
                //}

                promo.PromotionAds.Add(cad);
                try
                {
                    ServiceClientWrapper sw = new ServiceClientWrapper();
                    List<string> adEngines = new List<string>();
                    List<int> promoAds = new List<int>();
                    if (promo.IsLaunched)
                    {
                        foreach (PromotionAdEngineSelected pades in promo.PromotionAdEngineSelecteds)
                            adEngines.Add(pades.AdvertisingEngine.AdvertisingEngine1);
                        foreach (PromotionAd pa in promo.PromotionAds)
                            promoAds.Add(pa.PromotionAdsPK);
                        sw.scheduleAds(customerFk, promo.PromotionPK, promoAds, adEngines, true);
                    }
                }
                catch (Exception ex) { Semplest.SharedResources.Helpers.ExceptionHelper.LogException(ex.ToString()); }
            }
        }

        public static void SaveSelectedCategories(int promotionId, IEnumerable<string> selectedCategories)
        {
            using (var dbcontext = new SemplestEntities())
            {
                var query = dbcontext.KeywordCategories.Where(c => c.PromotionFK == promotionId);
                if (!query.Any())
                {
                    foreach (var keyCategory in selectedCategories.Select(category => new KeywordCategory { PromotionFK = promotionId, KeywordCategory1 = category }))
                    {
                        dbcontext.KeywordCategories.AddObject(keyCategory);
                    }
                    dbcontext.SaveChanges();
                }
                else  // categories exists so update them
                {
                    // delete them first
                    foreach (KeywordCategory kc in query)
                    {
                        dbcontext.KeywordCategories.DeleteObject(kc);
                    }
                    dbcontext.SaveChanges();
                    // add them
                    foreach (var keyCategory in selectedCategories.Select(category => new KeywordCategory { PromotionFK = promotionId, KeywordCategory1 = category }))
                    {
                        dbcontext.KeywordCategories.AddObject(keyCategory);
                    }
                    dbcontext.SaveChanges();
                }
            }





        }

        public static void SaveKeywords(int promotionId, List<KeywordProbabilityObject> kpos, List<string> negativeKeywords, string productGroupName, string promotionName)
        {
            DataTable stationIds = new DataTable();
            stationIds.Columns.Add("Keyword", typeof(string));
            stationIds.Columns.Add("IsActive", typeof(Boolean));
            stationIds.Columns.Add("IsDeleted", typeof(Boolean));
            stationIds.Columns.Add("IsNegative", typeof(Boolean));
            stationIds.Columns.Add("SemplestProbability", typeof(float));
            stationIds.Columns.Add("IsTargetMSN", typeof(Boolean));
            stationIds.Columns.Add("IsTargetGoogle", typeof(Boolean));
            foreach (KeywordProbabilityObject kpo in kpos)
            {
                kpo.isDeleted = IsDeletedKeyword(kpo.keyword.Trim(), negativeKeywords);
                DataRow dr = stationIds.NewRow();
                dr["Keyword"] = kpo.keyword.Trim();
                dr["IsActive"] = "true";
                dr["IsDeleted"] = kpo.isDeleted;
                dr["IsNegative"] = IsNegativeKeyword(kpo.keyword.Trim(), negativeKeywords); ;
                dr["SemplestProbability"] = kpo.semplestProbability;
                dr["IsTargetMSN"] = kpo.isTargetMSN;
                dr["IsTargetGoogle"] = kpo.isTargetGoogle;
                stationIds.Rows.Add(dr);
                //Debug.WriteLine("insert into @kwa (keyword,IsActive,IsDeleted,IsNegative,IsTargetGoogle,IsTargetMSN) values ('" + kpo.keyword + "',1,0,1,0,0)");
            }
            if (stationIds.Rows.Count > 0)
            {
                SqlParameter parameter = new SqlParameter("kwa", stationIds);
                parameter.SqlDbType = SqlDbType.Structured;
                parameter.TypeName = "PromotionKeywordTableType";


                SqlParameter parameter2 = new SqlParameter("@PromotionId", promotionId);
                parameter2.SqlDbType = SqlDbType.Int;

                var parameters = new object[] { parameter, parameter2 };
                using (var dbcontext = new SemplestEntities())
                {
                    var results = dbcontext.ExecuteStoreCommand("exec sp_UpdateKeywords @kwa, @PromotionId", parameters);
                    //set keyword id's back in the model
                    int userid = ((Credential)System.Web.HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]).UsersFK;
                    var pkas = dbcontext.Users.Where(key => key.UserPK == userid).First().Customer.ProductGroups.Where(key => key.ProductGroupName == productGroupName).First().Promotions.Where(key => key.PromotionName == promotionName).First().PromotionKeywordAssociations;
                    foreach (PromotionKeywordAssociation pka in pkas)
                    {
                        var qry = kpos.Where(key => key.keyword == pka.Keyword.Keyword1);
                        if (qry.Any())
                            qry.First().id = pka.Keyword.KeywordPK;
                    }
                }
            }
        }

        private static bool IsDeletedKeyword(string keyword, List<string> negativeKeywords)
        {
            if (negativeKeywords == null)
                return false;
            string k = keyword.ToUpper();
            return (negativeKeywords.Where(key => k.Contains(key.ToUpper())).Count() > 0 ||
                    negativeKeywords.Where(key => k.Contains(key.ToUpper() + " ")).Count() > 0 ||
                    negativeKeywords.Where(key => k.Contains(" " + key.ToUpper())).Count() > 0 ||
                    negativeKeywords.Where(key => k.Contains(" " + key.ToUpper() + " ")).Count() > 0);
        }

        private static bool IsNegativeKeyword(string keyword, List<string> negativeKeywords)
        {
            return negativeKeywords.Where(key => keyword.ToUpper().Contains(key.ToUpper())).Count() > 0;
        }

        private static void SaveNegativeKeywords(Promotion promo, CampaignSetupModel model, SemplestEntities dbcontext)
        {
            IEnumerable<PromotionKeywordAssociation> qry = dbcontext.PromotionKeywordAssociations.Where(key => key.PromotionFK == promo.PromotionPK).ToList();
            List<KeywordProbabilityObject> kpos = new List<KeywordProbabilityObject>();
            KeywordProbabilityObject kpo;
            foreach (PromotionKeywordAssociation pka in qry)
            {
                kpo = new KeywordProbabilityObject();
                kpo.keyword = pka.Keyword.Keyword1;
                kpo.semplestProbability=pka.SemplestProbability ==null ? 0 : pka.SemplestProbability .Value;
                kpo.isTargetMSN = pka.IsTargetMSN;
                kpo.isTargetGoogle = pka.IsTargetGoogle;
                kpos.Add(kpo);
            }
            if (model.AdModelProp.NegativeKeywords != null)
                foreach (string negativeKeyword in model.AdModelProp.NegativeKeywords)
                {
                    if (!qry.Where(key => key.Keyword.Keyword1 == negativeKeyword).Any())
                    {
                        kpo = new KeywordProbabilityObject();
                        kpo.keyword = negativeKeyword;
                        kpos.Add(kpo);
                    }
                }
            SaveKeywords(promo.PromotionPK, kpos, model.AdModelProp.NegativeKeywords, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
        }

        public static string GetStateNameFromCode(int stateCode)
        {
            string stateName;
            using (var db = new SemplestEntities())
            {
                stateName = db.StateCodes.First(m => m.StateAbbrPK == stateCode).StateAbbr;
            }
            return stateName;
        }

        public static List<string> GetAdEngines()
        {
            using (var db = new SemplestEntities())
            {
                return db.AdvertisingEngines.Select(m => m.AdvertisingEngine1).ToList();
            }

        }

        public static bool IsPromotionLaunched(int promoId)
        {
            using (var db = new SemplestEntities())
            {
                var promo = PromotonIdQuery.Invoke(db, promoId);
                return promo.IsLaunched;
            }
        }

        public static bool IsPromotionCompleted(int promoId)
        {
            using (var db = new SemplestEntities())
            {
                var promo = PromotonIdQuery.Invoke(db, promoId);
                return promo.IsCompleted;
            }
        }

        public static bool IsPromotionLaunchedAndCompleted(int promoId)
        {
            using (var db = new SemplestEntities())
            {
                var promo = PromotonIdQuery.Invoke(db, promoId);
                return promo.IsCompleted && promo.IsLaunched;
            }
        }

        public static void SetKeywordsDeleted(List<int> keywordIds, int promoId)
        {
            using (var dbcontext = new SemplestEntities())
            {
                foreach (int keywordId in keywordIds)
                    dbcontext.PromotionKeywordAssociations.Where(key => key.KeywordFK == keywordId).Where(key => key.PromotionFK == promoId).First().IsDeleted = true;
                dbcontext.SaveChanges();
            }
        }
    }
}