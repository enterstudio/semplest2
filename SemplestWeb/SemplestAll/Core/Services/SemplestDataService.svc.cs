using System;
using System.Linq;
using System.Collections.Generic;
using System.Data.Services;
using System.Data.Services.Common;
using Semplest.Core.Models;
using SemplestModel;
using Semplest.SharedResources.Services;

namespace SemplestWebApp.Services
{
    public class SemplestDataService : DataService<SemplestEntities>
    {
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

        public bool SaveProductGroupAndCampaign(int userid, CampaignSetupModel model)
        {
            bool retFlag = false;
            using (var dbcontext = new SemplestEntities())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                int custfk = (int)queryCustFk.FirstOrDefault();

                // check if the ProductGroupName already exists
                var queryProdGrp = from c in dbcontext.ProductGroups 
                                       where c.CustomerFK == custfk && c.ProductGroupName == model.ProductGroup.ProductGroupName select c;
                if (queryProdGrp.Count() > 0)
                {
                    try
                    {
                        // product grp already exists so update the product group 
                        var updateProdGrp = queryProdGrp.FirstOrDefault();
                        updateProdGrp.ProductGroupName = model.ProductGroup.ProductGroupName;
                        updateProdGrp.StartDate = Convert.ToDateTime(model.ProductGroup.StartDate);
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

                            dbcontext.Promotions.Add(updatePromotion);
                        }
                        else
                        {
                            // update promotion
                            UpdatePromotionFromModel(updatePromotion, model, dbcontext);
                        }

                        dbcontext.SaveChanges();

                    }
                    catch (Exception ex)
                    {
                        string msg = ex.ToString();
                        throw;
                    }

                    retFlag = true;
                }
                else
                {
                    try
                    {
                        // create product group
                        var prodgroup = new ProductGroup
                        {
                            ProductGroupName = model.ProductGroup.ProductGroupName,
                            IsActive = true,
                            CustomerFK = custfk,
                            StartDate = Convert.ToDateTime(model.ProductGroup.StartDate),
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
                        dbcontext.ProductGroups.Add(prodgroup);
                        // add promotion
                        dbcontext.Promotions.Add(promo);
                        dbcontext.SaveChanges();
                        retFlag = true;

                    }
                    catch (Exception ex)
                    {
                        string msg = ex.Message;
                        throw;
                    }
                }
            }
            return retFlag;
        }

        public CampaignSetupModel GetCampaignSetupModelForPromotionId(int promoId)
        {
            CampaignSetupModel model = new CampaignSetupModel();
            var dbcontext = new SemplestEntities();
            var promo = dbcontext.Promotions.FirstOrDefault(p => p.PromotionPK == promoId);

            // populate model from promotions
            model.ProductGroup.ProductGroupName = promo.ProductGroup.ProductGroupName;
            model.ProductGroup.ProductPromotionName = promo.PromotionName;
            model.ProductGroup.Budget = promo.PromotionBudgetAmount;
            model.ProductGroup.StartDate = promo.ProductGroup.StartDate.ToString();
            model.ProductGroup.EndDate = promo.ProductGroup.EndDate.HasValue ? promo.ProductGroup.EndDate.ToString() : String.Empty;

            // set words
            model.ProductGroup.Words = promo.PromotionDescription;

            // set advertising engines
            model.ProductGroup.AdEnginesSelectedList = new List<AdEngineSelectModel>();
            foreach(PromotionAdEngineSelected paes in promo.PromotionAdEngineSelecteds)
            {
                AdEngineSelectModel aesm = new AdEngineSelectModel{ Id = paes.AdvertisingEngine.AdvertisingEnginePK, Name = paes.AdvertisingEngine.AdvertisingEngine1 };
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
            model.AdModelProp.NegativeKeywords = promo.PromotionKeywordAssociations.Where(m => m.IsNegative == true).Select(m => m.Keyword.Keyword1).ToList();
            int cnt = model.AdModelProp.NegativeKeywords.Count();
            for (int i = 0; i < cnt; i++)
            {
                model.AdModelProp.NegativeKeywordsText += model.AdModelProp.NegativeKeywords[i];
                if (i < cnt - 1)
                {
                    model.AdModelProp.NegativeKeywordsText += ", ";
                }
            }

            return model;
        }

        public User GetUserWithProductGroupAndPromotions(int userid)
        {
            var semplestEntities = new SemplestEntities();
            var user = semplestEntities.Users.Include("Customer.ProductGroups").Include("Customer.ProductGroups.Promotions").FirstOrDefault(t => t.UserPK == userid);
            return user;
        }

        private Promotion GetPromotionFromProductGroup(ProductGroup prodGroup, string promotionName)
        {
            var promo = prodGroup.Promotions.Where(m => m.PromotionName == promotionName).FirstOrDefault();
            return promo;
        }

        public List<ProductGroup> GetProductGroupsForUser(int userid)
        {
            using (var dbcontext = new SemplestEntities())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                int custfk = (int)queryCustFk.First();

                // get ProductGroup
                var queryProdGrp = from c in dbcontext.ProductGroups
                                   where c.CustomerFK == custfk 
                                   select c;
                // get Promotion
                if (queryProdGrp.Count() > 0)
                {
                    return queryProdGrp.ToList();
                }
            }
            return null;

        }

        public List<Promotion> GetPromotionsForUser(int userid, string prodGroupName)
        {
            using (var dbcontext = new SemplestEntities())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                int custfk = (int)queryCustFk.First();

                // get ProductGroup
                var queryProdGrp = from c in dbcontext.ProductGroups
                                   where c.CustomerFK == custfk && c.ProductGroupName == prodGroupName
                                   select c;
                // get Promotions
                if (queryProdGrp.Count() > 0)
                {
                    var prodGrp = queryProdGrp.First();
                    var queryPromo = prodGrp.Promotions;
                    if (queryPromo.Count() > 0)
                    {
                        return queryPromo.ToList();
                    }
                }
            }
            return null;
        }

        public int GetPromotionId(int userid, string prodGroupName, string promotionName)
        {
            using (var dbcontext = new SemplestEntities())
            {
                // get the customerfk from userid
                var queryCustFk = from c in dbcontext.Users where c.UserPK == userid select c.CustomerFK;
                int custfk = (int)queryCustFk.First();

                // get ProductGroup
                var queryProdGrp = from c in dbcontext.ProductGroups
                                   where c.CustomerFK == custfk && c.ProductGroupName == prodGroupName
                                   select c;
                // get Promotion
                if (queryProdGrp.Count() > 0)
                {
                    var prodGrp = queryProdGrp.First();
                    var queryPromo = prodGrp.Promotions.Where(m => m.PromotionName == promotionName);
                    if (queryPromo.Count() > 0)
                    {
                        var promo = queryPromo.First();
                        return promo.PromotionPK;
                    }
                }
            }
            return -1;
        }

        private int GetBudgetCycleId(string budgetCycleName)
        {
            using (var dbcontext = new SemplestEntities())
            {
                var queryBudgetCycle = dbcontext.BudgetCycles.Where(m => m.BudgetCycle1 == budgetCycleName);
                if (queryBudgetCycle.Count() > 0)
                {
                    return queryBudgetCycle.FirstOrDefault().BudgetCyclePK;
                }
            }
                return -1;
        }

        private Promotion CreatePromotionFromModel(CampaignSetupModel model, decimal CustomerDefaultPerCampaignFlatFeeAmount)
        {
            var promo = new Promotion
            {


                PromotionName = model.ProductGroup.ProductPromotionName,
                LandingPageURL = model.AdModelProp.Url,
                PromotionDescription = model.ProductGroup.Words,
                PromotionBudgetAmount = model.ProductGroup.Budget,
                BudgetCycleFK = GetBudgetCycleId("Monthly"),
                CycleStartDate =Convert.ToDateTime(model.ProductGroup.StartDate),
                CycleEndDate = string.IsNullOrEmpty(model.ProductGroup.EndDate) ? Convert.ToDateTime(model.ProductGroup.StartDate).AddMonths(1) : Convert.ToDateTime(model.ProductGroup.EndDate),
                StartBudgetInCycle=model.ProductGroup.Budget-CustomerDefaultPerCampaignFlatFeeAmount,
                RemainingBudgetInCycle=model.ProductGroup.Budget-CustomerDefaultPerCampaignFlatFeeAmount,
                PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate),
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
            updatePromotion.PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate);
            updatePromotion.CycleStartDate =Convert.ToDateTime(model.ProductGroup.StartDate);
            updatePromotion.CycleEndDate = string.IsNullOrEmpty(model.ProductGroup.EndDate) ? Convert.ToDateTime(model.ProductGroup.StartDate).AddMonths(1) : Convert.ToDateTime(model.ProductGroup.EndDate);
            updatePromotion.StartBudgetInCycle = model.ProductGroup.Budget - dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.RemainingBudgetInCycle = model.ProductGroup.Budget - dbcontext.Configurations.First().CustomerDefaultPerCampaignFlatFeeAmount;
            updatePromotion.EditedDate = DateTime.Now;

            // update Geotargeting
            foreach (GeoTargeting geo in updatePromotion.GeoTargetings.ToList())
            {
                dbcontext.GeoTargetings.Remove(geo);
            }

            // update promotion ads; delete first and add them again
            foreach (PromotionAd pad in updatePromotion.PromotionAds.ToList())
            {
                foreach (SiteLink sli in pad.SiteLinks.ToList())
                {
                    dbcontext.SiteLinks.Remove(sli);
                }
                dbcontext.PromotionAds.Remove(pad);
            }

            SavePromotionAdEngineSelected(updatePromotion, model, dbcontext);
            AddGeoTargetingToPromotion(updatePromotion, model);
            SaveNegativeKeywords(updatePromotion, model, dbcontext);
            AddPromotionAdsToPromotion(updatePromotion, model);
        }

        private void SavePromotionAdEngineSelected(Promotion promo, CampaignSetupModel model, SemplestEntities dbcontext)
        {
            foreach (string aes in model.ProductGroup.AdEnginesList)
            {
                int adengineid = Convert.ToInt32(aes);
                var proAdEng = dbcontext.AdvertisingEngines.Where(m => m.AdvertisingEnginePK == adengineid);
                if (proAdEng.Count() > 0)
                {
                    var adEngSelQuery = dbcontext.PromotionAdEngineSelecteds.Where(m => m.PromotionFK == promo.PromotionPK);
                    if (adEngSelQuery.Count() == 0)
                    {
                        var adEngineSel = new PromotionAdEngineSelected
                        {
                            AdvertisingEngineFK = proAdEng.First().AdvertisingEnginePK,
                            PromotionFK = promo.PromotionPK
                        };
                        dbcontext.PromotionAdEngineSelecteds.Add(adEngineSel);
                    }
                    else
                    {
                        adEngSelQuery.First().AdvertisingEngineFK = proAdEng.First().AdvertisingEnginePK;
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
            foreach (PromotionAd pad in model.AdModelProp.Ads)
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

        public bool SaveSelectedCategories(int promotionId, List<string> selectedCategories)
        {
            bool retFlag = false;

            using (var dbcontext = new SemplestEntities())
            {
                var query = dbcontext.KeywordCategories.Where(c => c.PromotionFK == promotionId);
                if (query.Count() == 0)
                {
                    foreach (string category in selectedCategories)
                    {
                        KeywordCategory keyCategory = new KeywordCategory();
                        keyCategory.PromotionFK = promotionId;
                        keyCategory.KeywordCategory1 = category;
                        dbcontext.KeywordCategories.Add(keyCategory);
                    }
                    dbcontext.SaveChanges();
                }
                else  // categories exists so update them
                {
                    // delete them first
                    foreach (KeywordCategory kc in query)
                    {
                        dbcontext.KeywordCategories.Remove(kc);
                    }
                    dbcontext.SaveChanges();
                    // add them
                    foreach (string category in selectedCategories)
                    {
                        KeywordCategory keyCategory = new KeywordCategory();
                        keyCategory.PromotionFK = promotionId;
                        keyCategory.KeywordCategory1 = category;
                        dbcontext.KeywordCategories.Add(keyCategory);
                    }
                    dbcontext.SaveChanges();
                }
                retFlag = true;
            }

            return retFlag;
        }

        public bool SaveKeywords(int promotionId, CampaignSetupModel model)
        {
            bool retFlag = false;

            using (var dbcontext = new SemplestEntities())
            {
                // todo need to fix this
                //return true;

                foreach (KeywordProbabilityObject kpo in model.AllKeywordProbabilityObjects)
                {
                    var queryKeyword = dbcontext.Keywords.Where(c => c.Keyword1 == kpo.keyword);
                    if (queryKeyword.Count() == 0)
                    {
                        // add it in Keywords table and in PromotionKeywordAssociations
                        var newKeyword = dbcontext.Keywords.Add(new Keyword { Keyword1 = kpo.keyword, CreatedDate = DateTime.Now });
                        //dbcontext.SaveChanges();

                        int keywordId = newKeyword.KeywordPK;
                        dbcontext.PromotionKeywordAssociations.Add(
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

                        dbcontext.SaveChanges();

                    }
                    else  // keyword already there in the Keywords table, setup an association with promotion if its not there
                    {
                        int keywordId = queryKeyword.First().KeywordPK;
                        queryKeyword.First().EditedDate = DateTime.Now;
                        var queryPka = dbcontext.PromotionKeywordAssociations.Where(c => c.PromotionFK == promotionId && c.KeywordFK == keywordId);
                        if (queryPka.Count() == 0)
                        {
                            dbcontext.PromotionKeywordAssociations.Add(
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

                            dbcontext.SaveChanges();

                        }
                        else
                        {
                            var pka = queryPka.First();
                            pka.SemplestProbability = kpo.semplestProbability;
                            pka.IsTargetMSN = kpo.isTargetMSN;
                            pka.IsTargetGoogle = kpo.isTargetGoogle;

                            dbcontext.SaveChanges();
                        }
                    }
                }
                retFlag = true;
            }

            return retFlag;
        }

        public bool SaveSiteLinks(int userid, CampaignSetupModel model)
        {
            bool retFlag = false;

            int promoId = GetPromotionId(userid, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
            using (SemplestEntities dbcontext = new SemplestEntities())
            {
                var query = dbcontext.PromotionAds.Where(c => c.PromotionFK == promoId);
                if (query.Count() > 0)
                {
                    foreach (PromotionAd pad in query)
                    {
                        
                    }
                }

            }

            return retFlag;
        }


        public bool SaveNegativeKeywords(Promotion promo, CampaignSetupModel model, SemplestEntities dbcontext)
        {
            bool retFlag = false;
            if (model.AdModelProp.NegativeKeywords != null)
            {
                foreach (string negKeyword in model.AdModelProp.NegativeKeywords)
                {
                    var queryKeyword = dbcontext.Keywords.Where(c => c.Keyword1 == negKeyword);
                    if (queryKeyword.Count() > 0)
                    {
                        int keywordId = queryKeyword.First().KeywordPK;
                        queryKeyword.First().EditedDate = DateTime.Now;
                        var queryPka = dbcontext.PromotionKeywordAssociations.Where(c => c.PromotionFK == promo.PromotionPK && c.KeywordFK == keywordId);
                        if (queryPka.Count() == 0)
                        {
                            dbcontext.PromotionKeywordAssociations.Add(
                                new PromotionKeywordAssociation
                                {
                                    PromotionFK = promo.PromotionPK,
                                    KeywordFK = keywordId,
                                    CreatedDate = DateTime.Now,
                                    IsActive = true,
                                    IsDeleted = false,
                                    IsNegative = false,
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
                    else
                    {
                        var newNegKeyword = dbcontext.Keywords.Add(new Keyword { Keyword1 = negKeyword, CreatedDate = DateTime.Now });
                        //dbcontext.SaveChanges();

                        int keywordId = newNegKeyword.KeywordPK;
                        dbcontext.PromotionKeywordAssociations.Add(
                            new PromotionKeywordAssociation
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
            return retFlag;
        }

        // this one is not used
        public bool SaveNegativeKeywords(int userid, CampaignSetupModel model)
        {
            bool retFlag = false;
            int promoId = GetPromotionId(userid, model.ProductGroup.ProductGroupName, model.ProductGroup.ProductPromotionName);
            using (SemplestEntities dbcontext = new SemplestEntities())
            {
                foreach (string negKeyword in model.AdModelProp.NegativeKeywords)
                {
                    var queryKeyword = dbcontext.Keywords.Where(c => c.Keyword1 == negKeyword);
                    if (queryKeyword.Count() > 0)
                    {
                        int keywordId = queryKeyword.First().KeywordPK;
                        var queryPka = dbcontext.PromotionKeywordAssociations.Where(c => c.PromotionFK == promoId && c.KeywordFK == keywordId);
                        if (queryPka.Count() == 0)
                        {
                            dbcontext.PromotionKeywordAssociations.Add(
                                new PromotionKeywordAssociation
                                {
                                    PromotionFK = promoId,
                                    KeywordFK = keywordId,
                                    IsActive = true,
                                    IsDeleted = false,
                                    IsNegative = false,
                                    SemplestProbability = 0,
                                    IsTargetMSN = false,
                                    IsTargetGoogle = false
                                });

                            dbcontext.SaveChanges();

                        }
                        else
                        {
                            var pka = queryPka.First();
                            pka.IsNegative = true;

                            dbcontext.SaveChanges();
                        }

                    }
                    else
                    {
                        var newNegKeyword = dbcontext.Keywords.Add(new Keyword { Keyword1 = negKeyword });
                        //dbcontext.SaveChanges();

                        int keywordId = newNegKeyword.KeywordPK;
                        dbcontext.PromotionKeywordAssociations.Add(
                            new PromotionKeywordAssociation
                            {
                                PromotionFK = promoId,
                                //KeywordFK = keywordId,
                                IsActive = true,
                                IsDeleted = false,
                                IsNegative = true,
                                SemplestProbability = 0,
                                IsTargetMSN = false,
                                IsTargetGoogle = false
                            });

                    }


                }

            }

            return retFlag;
        }

        public string GetStateNameFromCode(int stateCode)
        {
            string stateName = String.Empty;
            using (var db = new SemplestEntities())
            {
                stateName = db.StateCodes.Where(m => m.StateAbbrPK == stateCode).First().StateAbbr;
            }
            return stateName;
        }

        public List<string> GetAdEngines()
        {
            using (var db = new SemplestEntities())
            {
                return db.AdvertisingEngines.Select(m => m.AdvertisingEngine1).ToList();
            }

        }
    }
}