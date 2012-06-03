using System;
using System.Data.Objects;
using System.Globalization;
using System.Linq;
using System.Collections.Generic;
using System.Data.Services;
using System.Data.Services.Common;
using Semplest.Core.Models;
using SemplestModel;

namespace Semplest.Core.Services
{
    public class SemplestDataService : DataService<SemplestEntities>
    {
        private static SemplestEntities _dbcontext;
        static SemplestDataService()
        {
            _dbcontext = new SemplestEntities();
        }
        // This method is called only once to initialize service-wide policies.
        public static void InitializeService(DataServiceConfiguration config)
        {
            config.SetEntitySetAccessRule("Campaign", EntitySetRights.AllRead
                                                      | EntitySetRights.WriteMerge | EntitySetRights.WriteReplace);
            config.DataServiceBehavior.MaxProtocolVersion = DataServiceProtocolVersion.V2;
            _dbcontext = new SemplestEntities();
        }

        public void SaveProductGroupAndCampaign(int userid, CampaignSetupModel model)
        {
            // get the customerfk from userid
            var queryCustFk = from c in _dbcontext.Users where c.UserPK == userid select c.CustomerFK;
            var i = queryCustFk.FirstOrDefault();
            if (i != null)
            {
                var custfk = (int)i;

                // check if the ProductGroupName already exists
                var queryProdGrp = from c in _dbcontext.ProductGroups
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
                            updatePromotion = CreatePromotionFromModel(model, _dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount);
                            updatePromotion.ProductGroupFK = updateProdGrp.ProductGroupPK;

                            // add geotargeting to promotion
                            AddGeoTargetingToPromotion(updatePromotion, model);
                            // promotion ads
                            AddPromotionAdsToPromotion(updatePromotion, model);

                            _dbcontext.Promotions.AddObject(updatePromotion);
                        }
                        else
                        {
                            // update promotion
                            UpdatePromotionFromModel(updatePromotion, model);
                        }
                    }

                    _dbcontext.SaveChanges();
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
                    var promo = CreatePromotionFromModel(model, _dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount);

                    // add advertising engines that are selected
                    SavePromotionAdEngineSelected(promo, model);

                    // add geotargeting to promotion
                    AddGeoTargetingToPromotion(promo, model);

                    // save negative keywords
                    SaveNegativeKeywords(promo, model);

                    // promotion ads
                    AddPromotionAdsToPromotion(promo, model);

                    // add product group
                    _dbcontext.ProductGroups.AddObject(prodgroup);
                    // add promotion
                    _dbcontext.Promotions.AddObject(promo);
                    _dbcontext.SaveChanges();
                }
            }
        }
        static readonly Func<SemplestEntities, int, Promotion> PromotonIdQuery = CompiledQuery.Compile((SemplestEntities nw, int promoId) => nw.Promotions.FirstOrDefault(p => p.PromotionPK == promoId));
        public static CampaignSetupModel GetCampaignSetupModelForPromotionId(int promoId)
        {
            var model = new CampaignSetupModel();
            var promo = PromotonIdQuery.Invoke(_dbcontext, promoId);

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

        public IQueryable<vwProductPromotion> GetUserWithProductGroupAndPromotions(int userid)
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
            // get the customerfk from userid
            var queryCustFk = from c in _dbcontext.Users where c.UserPK == userid select c.CustomerFK;
            var customerIdFk = queryCustFk.FirstOrDefault();
            if (customerIdFk != null)
            {
                var custfk = (int)customerIdFk;

                // get ProductGroup
                var queryProdGrp = from c in _dbcontext.ProductGroups
                                   where c.CustomerFK == custfk
                                   select c;
                // get Promotion
                if (queryProdGrp.Any())
                {
                    return queryProdGrp.ToList();
                }
            }
            return null;

        }

        public static int GetPromotionId(int userid, string prodGroupName, string promotionName)
        {
            // get the customerfk from userid
            var queryCustFk = from c in _dbcontext.Users where c.UserPK == userid select c.CustomerFK;
            var i = queryCustFk.First();
            if (i != null)
            {
                var custfk = (int)i;

                // get ProductGroup
                var queryProdGrp = from c in _dbcontext.ProductGroups
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
            return -1;
        }

        private static int GetBudgetCycleId(string budgetCycleName)
        {
            var queryBudgetCycle = _dbcontext.BudgetCycles.Where(m => m.BudgetCycle1 == budgetCycleName);
            if (queryBudgetCycle.Any())
            {
                var budgetCycle = queryBudgetCycle.FirstOrDefault();
                if (budgetCycle != null)
                    return budgetCycle.BudgetCyclePK;
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

        private void UpdatePromotionFromModel(Promotion updatePromotion, CampaignSetupModel model)
        {
            updatePromotion.LandingPageURL = model.AdModelProp.Url;
            updatePromotion.PromotionDescription = model.ProductGroup.Words;
            updatePromotion.PromotionBudgetAmount = model.ProductGroup.Budget;
            updatePromotion.PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us"));
            updatePromotion.CycleStartDate = Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us"));
            updatePromotion.CycleEndDate = string.IsNullOrEmpty(model.ProductGroup.EndDate) ? Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")).AddMonths(1) : Convert.ToDateTime(model.ProductGroup.EndDate, new CultureInfo("en-Us"));
            updatePromotion.StartBudgetInCycle = model.ProductGroup.Budget - _dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.RemainingBudgetInCycle = model.ProductGroup.Budget - _dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.EditedDate = DateTime.Now;

            // update Geotargeting
            foreach (GeoTargeting geo in updatePromotion.GeoTargetings.ToList())
            {
                _dbcontext.GeoTargetings.DeleteObject(geo);
            }

            // update promotion ads; delete first and add them again
            foreach (PromotionAd pad in updatePromotion.PromotionAds.ToList())
            {
                foreach (SiteLink sli in pad.SiteLinks.ToList())
                {
                    _dbcontext.SiteLinks.DeleteObject(sli);
                }
                _dbcontext.PromotionAds.DeleteObject(pad);
            }

            SavePromotionAdEngineSelected(updatePromotion, model);
            AddGeoTargetingToPromotion(updatePromotion, model);
            SaveNegativeKeywords(updatePromotion, model);
            AddPromotionAdsToPromotion(updatePromotion, model);
        }

        private void SavePromotionAdEngineSelected(Promotion promo, CampaignSetupModel model)
        {
            var existingAdenginesSeleccted = _dbcontext.PromotionAdEngineSelecteds.Where(m => m.PromotionFK == promo.PromotionPK);
            var templist = new List<int>();
            model.ProductGroup.AdEnginesList.ForEach(t => templist.Add(Convert.ToInt32(t)));
            var dn = existingAdenginesSeleccted.Where(t => !templist.Contains(t.AdvertisingEngineFK));
            foreach (var adsel in dn)
            {
                _dbcontext.PromotionAdEngineSelecteds.DeleteObject(adsel);
            }

            foreach (string aes in model.ProductGroup.AdEnginesList)
            {
                int adengineid = Convert.ToInt32(aes);
                var proAdEng = _dbcontext.AdvertisingEngines.FirstOrDefault(m => m.AdvertisingEnginePK == adengineid);
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
                        _dbcontext.PromotionAdEngineSelecteds.AddObject(adEngineSel);
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

                if (pad.SiteLinks != null)
                {
                    // add sitelinks
                    foreach (SiteLink slink in pad.SiteLinks)
                    {
                        // this is check should be removed once we fix the logic in partialview and model
                        if (!String.IsNullOrEmpty(slink.LinkText) && !String.IsNullOrEmpty(slink.LinkURL))
                        {
                            var slinkobj = new SiteLink { LinkText = slink.LinkText, LinkURL = slink.LinkURL };
                            cad.SiteLinks.Add(slinkobj);
                        }
                    }
                }

                promo.PromotionAds.Add(cad);
            }
        }

        public static void SaveSelectedCategories(int promotionId, IEnumerable<string> selectedCategories)
        {
            var query = _dbcontext.KeywordCategories.Where(c => c.PromotionFK == promotionId);
            if (!query.Any())
            {
                foreach (var keyCategory in selectedCategories.Select(category => new KeywordCategory { PromotionFK = promotionId, KeywordCategory1 = category }))
                {
                    _dbcontext.KeywordCategories.AddObject(keyCategory);
                }
                _dbcontext.SaveChanges();
            }
            else  // categories exists so update them
            {
                // delete them first
                foreach (KeywordCategory kc in query)
                {
                    _dbcontext.KeywordCategories.DeleteObject(kc);
                }
                _dbcontext.SaveChanges();
                // add them
                foreach (var keyCategory in selectedCategories.Select(category => new KeywordCategory { PromotionFK = promotionId, KeywordCategory1 = category }))
                {
                    _dbcontext.KeywordCategories.AddObject(keyCategory);
                }
                _dbcontext.SaveChanges();
            }
        }

        public static void SaveKeywords(int promotionId, CampaignSetupModel model)
        {

            foreach (var kpo in model.AllKeywordProbabilityObjects)
            {
                var kpo1 = kpo;
                var queryKeyword = _dbcontext.Keywords.Where(c => c.Keyword1 == kpo1.keyword.Trim());
                if (!queryKeyword.Any())
                {
                    // add it in Keywords table and in PromotionKeywordAssociations
                    _dbcontext.Keywords.AddObject(new Keyword { Keyword1 = kpo.keyword.Trim(), CreatedDate = DateTime.Now });
                    //dbcontext.SaveChanges();

                    _dbcontext.PromotionKeywordAssociations.AddObject(
                        new PromotionKeywordAssociation
                        {
                            PromotionFK = promotionId,
                            //KeywordFK = keywordId,
                            CreatedDate = DateTime.Now,
                            IsActive = true,
                            IsDeleted = false,
                            IsNegative = false,
                            SemplestProbability = kpo.semplestProbability,
                            IsTargetMSN = kpo.isTargetMSN,
                            IsTargetGoogle = kpo.isTargetGoogle
                        });

                    _dbcontext.SaveChanges();

                }
                else  // keyword already there in the Keywords table, setup an association with promotion if its not there
                {
                    var keywordId = queryKeyword.First().KeywordPK;
                    queryKeyword.First().EditedDate = DateTime.Now;
                    var queryPka = _dbcontext.PromotionKeywordAssociations.Where(c => c.PromotionFK == promotionId && c.KeywordFK == keywordId);
                    if (!queryPka.Any())
                    {
                        _dbcontext.PromotionKeywordAssociations.AddObject(
                            new PromotionKeywordAssociation
                            {
                                PromotionFK = promotionId,
                                KeywordFK = keywordId,
                                CreatedDate = DateTime.Now,
                                IsActive = true,
                                IsDeleted = false,
                                IsNegative = false,
                                SemplestProbability = kpo.semplestProbability,
                                IsTargetMSN = kpo.isTargetMSN,
                                IsTargetGoogle = kpo.isTargetGoogle
                            });

                        _dbcontext.SaveChanges();

                    }
                    else
                    {
                        var pka = queryPka.First();
                        pka.SemplestProbability = kpo.semplestProbability;
                        pka.IsTargetMSN = kpo.isTargetMSN;
                        pka.IsTargetGoogle = kpo.isTargetGoogle;

                        _dbcontext.SaveChanges();
                    }
                }
            }
        }


        private static void SaveNegativeKeywords(Promotion promo, CampaignSetupModel model)
        {
            if (model.AdModelProp.NegativeKeywords != null)
            {
                foreach (var negKeyword in model.AdModelProp.NegativeKeywords)
                {
                    var keyword = negKeyword;
                    var queryKeyword = _dbcontext.Keywords.Where(c => c.Keyword1 == keyword);
                    if (queryKeyword.Any())
                    {
                        var keywordId = queryKeyword.First().KeywordPK;
                        queryKeyword.First().EditedDate = DateTime.Now;
                        if (_dbcontext.PromotionKeywordAssociations != null)
                        {
                            var queryPka = _dbcontext.PromotionKeywordAssociations.Where(c => c.PromotionFK == promo.PromotionPK && c.KeywordFK == keywordId);
                            if (!queryPka.Any())
                            {
                                _dbcontext.PromotionKeywordAssociations.AddObject(
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
                        _dbcontext.Keywords.AddObject(new Keyword { Keyword1 = negKeyword, CreatedDate = DateTime.Now });
                        //dbcontext.SaveChanges();

                        if (_dbcontext.PromotionKeywordAssociations != null)
                            _dbcontext.PromotionKeywordAssociations.AddObject(new PromotionKeywordAssociation
                                    {
                                        PromotionFK = promo.PromotionPK,
                                        //KeywordFK = keywordId,
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
    }
}