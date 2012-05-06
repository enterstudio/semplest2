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
                            updatePromotion = CreatePromotionFromModel(model);
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
                        string msg = ex.Message;
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
                        var promo = CreatePromotionFromModel(model);

                        // add geotargeting to promotion
                        AddGeoTargetingToPromotion(promo, model);

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

        private Promotion GetPromotionFromProductGroup(ProductGroup prodGroup, string promotionName)
        {
            var promo = prodGroup.Promotions.Where(m => m.PromotionName == promotionName).FirstOrDefault();
            return promo;
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

        private Promotion CreatePromotionFromModel(CampaignSetupModel model)
        {
            var promo = new Promotion
            {
                PromotionName = model.ProductGroup.ProductPromotionName,
                LandingPageURL = model.AdModelProp.Url,
                PromotionDescription = model.ProductGroup.Words,
                PromotionBudgetAmount = model.ProductGroup.Budget,
                BudgetCycleFK = GetBudgetCycleId("Monthly"),
                PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate),
                IsPaused = false,
                IsCompleted = false,
                IsLaunched = false
            };

            return promo;

        }

        private void UpdatePromotionFromModel(Promotion updatePromotion, CampaignSetupModel model, SemplestEntities dbcontext)
        {
            updatePromotion.LandingPageURL = model.AdModelProp.Url;
            updatePromotion.PromotionDescription = model.ProductGroup.Words;
            updatePromotion.PromotionBudgetAmount = model.ProductGroup.Budget;
            updatePromotion.PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate);
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


            AddGeoTargetingToPromotion(updatePromotion, model);
            AddPromotionAdsToPromotion(updatePromotion, model);
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
                var cad = new PromotionAd { AdText = pad.AdText, AdTitle = pad.AdTitle };

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
                        var newKeyword = dbcontext.Keywords.Add(new Keyword { Keyword1 = kpo.keyword });
                        //dbcontext.SaveChanges();

                        int keywordId = newKeyword.KeywordPK;
                        dbcontext.PromotionKeywordAssociations.Add(
                            new PromotionKeywordAssociation
                            {
                                PromotionFK = promotionId,
                                //KeywordFK = keywordId,
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
                        // todo find out more
                        return true;

                        int keywordId = queryKeyword.First().KeywordPK;
                        var queryPka = dbcontext.PromotionKeywordAssociations.Where(c => c.PromotionFK == promotionId && c.KeywordFK == keywordId);
                        if (queryPka.Count() == 0)
                        {
                            dbcontext.PromotionKeywordAssociations.Add(
                                new PromotionKeywordAssociation
                                {
                                    PromotionFK = promotionId,
                                    KeywordFK = keywordId,
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


        public bool SaveKeywordsOld(int promotionId, List<string> keywordsList)
        {
            bool retFlag = false;

            using (var dbcontext = new SemplestEntities())
            {
                // todo need to fix this
                //return true;

                foreach (string keyword in keywordsList)
                {
                    if (dbcontext.Keywords.Where(c => c.Keyword1 == keyword).Count() == 0)
                    {
                        // add it in Keywords table and in PromotionKeywordAssociations
                        dbcontext.Keywords.Add(new Keyword { Keyword1 = keyword });
                        dbcontext.SaveChanges();

                        int keywordId = dbcontext.Keywords.Where(c => c.Keyword1 == keyword).Select(c => c.KeywordPK).First();
                        dbcontext.PromotionKeywordAssociations.Add(
                            new PromotionKeywordAssociation
                            {
                                PromotionFK = promotionId,
                                KeywordFK = keywordId,
                                IsActive = true,
                                IsDeleted = false,
                                IsNegative = false
                            });

                    }
                    else  // keyword already there in the Keywords table, setup an association with promotion if its not there
                    {
                        // todo find out more

                        var query = dbcontext.PromotionKeywordAssociations.Where(c => c.PromotionFK == promotionId);
                        if (query.Count() == 0)
                        {
                            int keywordId = dbcontext.Keywords.Where(c => c.Keyword1 == keyword).Select(c => c.KeywordPK).First();
                            dbcontext.PromotionKeywordAssociations.Add(
                                new PromotionKeywordAssociation
                                {
                                    PromotionFK = promotionId,
                                    KeywordFK = keywordId,
                                    IsActive = true,
                                    IsDeleted = false,
                                    IsNegative = false
                                });

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
                        dbcontext.SaveChanges();

                        int keywordId = newNegKeyword.KeywordPK;
                        dbcontext.PromotionKeywordAssociations.Add(
                            new PromotionKeywordAssociation
                            {
                                PromotionFK = promoId,
                                KeywordFK = keywordId,
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

        public void SaveAd(CampaignSetupModel model)
        {
            // Campaign is now called as ProductGroup
            var campaign = new ProductGroup
                               {
                                   ProductGroupName = model.ProductGroup.ProductGroupName,
                                   IsActive = true,
                                   CustomerFK = 1,
                                   StartDate = Convert.ToDateTime(model.ProductGroup.StartDate),
                                   EndDate = Convert.ToDateTime(model.ProductGroup.EndDate),
                                   //TargetCycleBudget = model.Budget
                               };
            //var ae = new AdvertisingEngine { AdvertisingEngine1 = model.Google.ToString() };
            var promo = new Promotion { ProductGroup = campaign };
            promo.LandingPageURL = model.AdModelProp.Url;
            promo.PromotionDescription = model.ProductGroup.Words;
            // CampaignAds is now called as PromotionAd
            foreach (PromotionAd pad in model.AdModelProp.Ads)
            {
                var cad = new PromotionAd { AdText = pad.AdText, AdTitle = pad.AdTitle };
                promo.PromotionAds.Add(cad);
            }

            //promo.
            //var kewword = new Keyword { Keyword1 = model.Words };
            using (var db = new SemplestEntities())
            {
                db.ProductGroups.Add(campaign);


                db.Promotions.Add(promo);

                //db.AdvertisingEngines.Add(ae);
                db.SaveChanges();
            }
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