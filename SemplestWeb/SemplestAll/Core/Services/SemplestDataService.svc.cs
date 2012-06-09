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

namespace Semplest.Core.Services
{
    public class SemplestDataService : DataService<SemplestEntities>
    {
        private static bool _savedCampaign;
        public  SemplestDataService()
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
                                AddGeoTargetingToPromotion(updatePromotion, model);
                                // promotion ads
                                AddPromotionAdsToPromotion(updatePromotion, model);

                                dbcontext.Promotions.AddObject(updatePromotion);
                            }
                            else
                            {
                                // update promotion
                                UpdatePromotionFromModel(updatePromotion, model, dbcontext);
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
                        AddGeoTargetingToPromotion(promo, model);

                        // save negative keywords
                        SaveNegativeKeywords(promo, model, dbcontext);

                        // promotion ads
                        AddPromotionAdsToPromotion(promo, model);

                        // add product group
                        dbcontext.ProductGroups.AddObject(prodgroup);
                        // add promotion
                        dbcontext.Promotions.AddObject(promo);
                        dbcontext.SaveChanges();
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
                    model.ProductGroup.AdEnginesList.Add(paes.AdvertisingEngine.AdvertisingEngine1);
                }

                // set URL
                model.AdModelProp.Url = promo.LandingPageURL;

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
                LandingPageURL = model.AdModelProp.Url,
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

        private void UpdatePromotionFromModel(Promotion updatePromotion, CampaignSetupModel model, SemplestEntities dbcontext)
        {
            updatePromotion.LandingPageURL = model.AdModelProp.Url;
            updatePromotion.PromotionDescription = model.ProductGroup.Words;
            updatePromotion.PromotionBudgetAmount = model.ProductGroup.Budget;
            updatePromotion.PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us"));
            updatePromotion.CycleStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us"));
            updatePromotion.CycleEndDate = string.IsNullOrEmpty(model.ProductGroup.EndDate) ? Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")).AddMonths(1) : Convert.ToDateTime(model.ProductGroup.EndDate, new CultureInfo("en-Us"));
            updatePromotion.StartBudgetInCycle = model.ProductGroup.Budget - dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.RemainingBudgetInCycle = model.ProductGroup.Budget - dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.EditedDate = DateTime.Now;

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

            SavePromotionAdEngineSelected(updatePromotion, model, dbcontext);
            AddGeoTargetingToPromotion(updatePromotion, model);
            SaveNegativeKeywords(updatePromotion, model, dbcontext);
            AddPromotionAdsToPromotion(updatePromotion, model);
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

            foreach (string aes in model.ProductGroup.AdEnginesList)
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

        private void AddGeoTargetingToPromotion(Promotion promo, CampaignSetupModel model)
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
                    }
                }
            }
        }

        private void AddPromotionAdsToPromotion(Promotion promo, CampaignSetupModel model)
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

        public static void SaveKeywords(int promotionId, CampaignSetupModel model)
        {
            DataTable stationIds = new DataTable();
            stationIds.Columns.Add("Keyword", typeof(string));
            stationIds.Columns.Add("IsActive", typeof(Boolean));
            stationIds.Columns.Add("IsDeleted", typeof(Boolean));
            stationIds.Columns.Add("IsNegative", typeof(Boolean));
            stationIds.Columns.Add("SemplestProbability", typeof(float));
            stationIds.Columns.Add("IsTargetMSN", typeof(Boolean));
            stationIds.Columns.Add("IsTargetGoogle", typeof(Boolean));
            foreach (var kpo in model.AllKeywordProbabilityObjects)
            {
                kpo.isDeleted = IsNegativeKeyword(kpo.keyword.Trim(), model.AdModelProp.NegativeKeywords);
                DataRow dr = stationIds.NewRow();
                dr["Keyword"] = kpo.keyword.Trim();
                dr["IsActive"] = "true";
                dr["IsDeleted"] = kpo.isDeleted;
                dr["IsNegative"] = "false";
                dr["SemplestProbability"] = kpo.semplestProbability;
                dr["IsTargetMSN"] = kpo.isTargetMSN;
                dr["IsTargetGoogle"] = kpo.isTargetGoogle;
                stationIds.Rows.Add(dr);
            }
            SqlParameter parameter = new SqlParameter("kwa", stationIds);
            parameter.SqlDbType = SqlDbType.Structured;
            parameter.TypeName = "PromotionKeywordTableType";


            SqlParameter parameter2 = new SqlParameter("@PromotionId", promotionId);
            parameter2.SqlDbType = SqlDbType.Int;

            var parameters = new object[] { parameter, parameter2 };
            using (var dbcontext = new SemplestEntities())
            {
                var results = dbcontext.ExecuteStoreCommand("exec sp_UpdateKeywords @kwa, @PromotionId", parameters);

                int userid = ((Credential)System.Web.HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]).UsersFK;
                var pkas = dbcontext.Users.Where(key => key.UserPK == userid).First().Customer.ProductGroups.Where(key => key.ProductGroupName == model.ProductGroup.ProductGroupName).First().Promotions.Where(key => key.PromotionName == model.ProductGroup.ProductPromotionName).First().PromotionKeywordAssociations;
                foreach (PromotionKeywordAssociation pka in pkas)
                {
                    var qry = model.AllKeywordProbabilityObjects.Where(key => key.keyword == pka.Keyword.Keyword1);
                    if (qry.Any())
                        qry.First().id = pka.Keyword.KeywordPK;
                }
            }
        }

        private static bool IsNegativeKeyword(string keyword, List<string> negativeKeywords)
        {
            string k = keyword.ToUpper();
            return (negativeKeywords.Where(key => k.Contains(key.ToUpper())).Count() > 0 ||
                    negativeKeywords.Where(key => k.Contains(key.ToUpper() + " ")).Count() > 0 ||
                    negativeKeywords.Where(key => k.Contains(" " + key.ToUpper())).Count() > 0 ||
                    negativeKeywords.Where(key => k.Contains(" " + key.ToUpper() + " ")).Count() > 0);
        }

        private static void SaveNegativeKeywords(Promotion promo, CampaignSetupModel model, SemplestEntities dbcontext)
        {
            if (model.AdModelProp.NegativeKeywords != null)
            {
                foreach (var negKeyword in model.AdModelProp.NegativeKeywords)
                {
                    var keyword = negKeyword.Trim();
                    var queryKeyword = dbcontext.Keywords.Where(c => c.Keyword1 == keyword);
                    if (queryKeyword.Any())
                    {
                        var keywordId = queryKeyword.First().KeywordPK;
                        queryKeyword.First().EditedDate = DateTime.Now;
                        if (dbcontext.PromotionKeywordAssociations != null)
                        {
                            var queryPka = dbcontext.PromotionKeywordAssociations.Where(c => c.PromotionFK == promo.PromotionPK && c.KeywordFK == keywordId);
                            if (!queryPka.Any())
                            {
                                dbcontext.PromotionKeywordAssociations.AddObject(
                                    new PromotionKeywordAssociation
                                        {
                                            PromotionFK = promo.PromotionPK,
                                            KeywordFK = keywordId,
                                            CreatedDate = DateTime.Now,
                                            IsActive = true,
                                            IsDeleted = false,
                                            IsNegative = true,
                                            SemplestProbability = 0,
                                            IsTargetMSN = false,
                                            IsTargetGoogle = false
                                        });

                                //dbcontext.SaveChanges();

                            }
                            else
                            {
                                var pka = queryPka.First();
                                pka.IsNegative = true;

                                //dbcontext.SaveChanges();
                            }
                        }
                    }
                    else
                    {
                        dbcontext.Keywords.AddObject(new Keyword {Keyword1 = keyword, CreatedDate = DateTime.Now});
                        var changes = dbcontext.SaveChanges();

                        if (changes > 0)
                        {
                            var queryK = dbcontext.Keywords.Where(c => c.Keyword1 == keyword);
                            if (queryK.Any())
                            {
                                var keywordId = queryK.First().KeywordPK;

                                dbcontext.PromotionKeywordAssociations.AddObject(new PromotionKeywordAssociation
                                                                             {
                                                                                 PromotionFK = promo.PromotionPK,
                                                                                 KeywordFK = keywordId,
                                                                                 CreatedDate = DateTime.Now,
                                                                                 IsActive = true,
                                                                                 IsDeleted = false,
                                                                                 IsNegative = true,
                                                                                 SemplestProbability = 0,
                                                                                 IsTargetMSN = false,
                                                                                 IsTargetGoogle = false
                                                                             });
                            }

                        }

                    //dbcontext.SaveChanges();
                    }
                }
            }
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

        public  static bool IsPromotionLaunched(int promoId)
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
    }
}