using System;
using System.Linq;
using System.Collections.Generic;
using System.Data.Services;
using System.Data.Services.Common;
using Semplest.Core.Models;
using SemplestModel;

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
                        updatePromotion = new Promotion
                        {
                            PromotionName = model.ProductGroup.ProductPromotionName,
                            ProductGroupFK = updateProdGrp.ProductGroupPK,
                            LandingPageURL = model.AdModelProp.Url,
                            PromotionDescription = model.ProductGroup.Words,
                            PromotionBudgetAmount = model.ProductGroup.Budget,
                            PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate),
                            IsPaused = false,
                            IsCompleted = false,
                            IsLaunched = false
                        };

                        // need to add promotion ads and others

                        dbcontext.Promotions.Add(updatePromotion);
                    }
                    else
                    {
                        updatePromotion.LandingPageURL = model.AdModelProp.Url;
                        updatePromotion.PromotionDescription = model.ProductGroup.Words;
                        updatePromotion.PromotionBudgetAmount = model.ProductGroup.Budget;
                        updatePromotion.PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate);
                        updatePromotion.EditedDate = DateTime.Now;
                        // update promotion ads
                        foreach (PromotionAd pad in updatePromotion.PromotionAds)
                        {
                        }

                    }

                    dbcontext.SaveChanges();

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
                        // we need to add productgroup now 
                        // to get the foreignkey that needs tobe passed into Promotion
                        //dbcontext.SaveChanges();

                        // create promotion
                        var promo = new Promotion
                        {
                            //ProductGroupFK = prodgroup.ProductGroupPK,
                            PromotionName = model.ProductGroup.ProductPromotionName,
                            LandingPageURL = model.AdModelProp.Url,
                            PromotionDescription = model.ProductGroup.Words,
                            PromotionBudgetAmount = model.ProductGroup.Budget,
                            PromotionStartDate = Convert.ToDateTime(model.ProductGroup.StartDate),
                            IsPaused = false,
                            IsCompleted = false,
                            IsLaunched = false
                        };

                        // uncomment when geotargetting validation is added in view

                        // promotion geotargeting
                        //foreach (GeoTargeting geo in model.AdModelProp.Addresses)
                        //{
                        //    var geotarget = new GeoTargeting
                        //        {
                        //            Address = geo.Address,
                        //            City = geo.City,
                        //            StateCodeFK = geo.StateCodeFK,
                        //            Zip = geo.Zip,
                        //            ProximityRadius = geo.ProximityRadius,
                        //        };
                        //    promo.GeoTargetings.Add(geotarget);
                        //}

                        // promotion ads
                        foreach (PromotionAd pad in model.AdModelProp.Ads)
                        {
                            var cad = new PromotionAd { AdText = pad.AdText, AdTitle = pad.AdTitle };

                            // uncomment when validation added

                            // add sitelinks
                            //foreach (SiteLink slink in model.AdModelProp.SiteLinks)
                            //{
                            //    var slinkobj = new SiteLink { LinkText = "mylink", LinkURL = "mylink.com" };
                            //    cad.SiteLinks.Add(slinkobj);
                            //}

                            promo.PromotionAds.Add(cad);
                        }

                        // set promotion
                        dbcontext.ProductGroups.Add(prodgroup);
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

        public bool SaveKeywords(int promotionId, List<string> keywordsList)
        {
            bool retFlag = false;

            using (var dbcontext = new SemplestEntities())
            {
                // todo need to fix this
                return true;

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
    }
}