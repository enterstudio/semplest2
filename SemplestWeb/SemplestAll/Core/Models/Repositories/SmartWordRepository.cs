using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity.Infrastructure;
using System.Data.SqlClient;
using System.Globalization;
using System.Linq;
using System.Web;
using Semplest.SharedResources.Services;
using SemplestModel;
using SemplestModel.TVP;


namespace Semplest.Core.Models.Repositories
{
    public class SmartWordRepository : ISmartWordRepository
    {
        public SmartWordSetupModel GetSetupModelForPromotionId(int promoId, int customerFk)
        {
            var model = new SmartWordSetupModel();
            var dbcontext = new SemplestModel.Semplest();
            var promo = dbcontext.Promotions.Single(p => p.PromotionPK == promoId);
            //only let the user see their promo

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
                model.LandingUrl = promo.LandingPageURL;

                // set display url
                // set geotargetings
                model.Addresses = promo.GeoTargetings.ToList();
                var singleOrDefault = promo.GeoTargetings.FirstOrDefault();
                if (singleOrDefault != null && singleOrDefault.AddressType != null)
                    model.PromotionAddressType = singleOrDefault.AddressType.AddressType1;
                else
                    model.PromotionAddressType = "NATIONALLY";

                // set promotionads
                //model.AdModelProp.Ads = promo.PromotionAds.Where(ads => !ads.IsDeleted).ToList();

                // set negative keywords
                if (promo.PromotionKeywordAssociations != null)
                model.NegativeKeywords =
                    promo.PromotionKeywordAssociations.Where(m => m.IsNegative && !m.IsDeleted).Select(m => m.Keyword.Keyword1).
                        ToList();

                // set islaunched
                //    if (!preview)
                //    {
                model.AllKeywords.AddRange(
                    promo.PromotionKeywordAssociations.Where(key => !key.IsDeleted && !key.IsNegative).OrderByDescending(o => o.SemplestProbability).Select(
                        key =>
                        new CampaignSetupModel.KeywordsModel { Name = key.Keyword.Keyword1, Id = key.Keyword.KeywordPK }));
                //    }
                //}

                //if (!preview)
                //{
                var cnt = model.NegativeKeywords.Count();
                for (var i = 0; i < cnt; i++)
                {
                    model.NegativeKeywordsText += model.NegativeKeywords[i];
                    if (i < cnt - 1)
                    {
                        model.NegativeKeywordsText += ", ";
                    }
                }
                //}





            }
            return model;
        }

        public string SavePromotionDetails(SmartWordSetupModel model, SmartWordSetupModel oldModel, int customerFk)
        {
            var rString = new System.Text.StringBuilder();
            using (var dbcontext = new SemplestModel.Semplest())
            {
                var queryProdGrp = (from c in dbcontext.ProductGroups
                                    where
                                        c.CustomerFK == customerFk &&
                                        c.ProductGroupName == model.ProductGroup.ProductGroupName
                                    select c).SingleOrDefault();
                Promotion promo;
                if (queryProdGrp == null)
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
                                                    ? (DateTime?) null
                                                    : Convert.ToDateTime(model.ProductGroup.EndDate)
                                        };

                    if (model.LandingUrl != null)
                        model.LandingUrl = model.LandingUrl.Trim();
                    promo = CreatePromotionFromModel(model);
                    dbcontext.ProductGroups.Add(prodgroup);
                    dbcontext.Promotions.Add(promo);
                    dbcontext.SaveChanges();
                }
                else
                {
                    var updateProdGrp = queryProdGrp;
                    promo = GetPromotionFromProductGroup(updateProdGrp,
                                                         model.ProductGroup.ProductPromotionName);
                    // if this is null means promotion name changed so create a new promotion
                    if (promo == null)
                    {
                        // create new promotion
                        promo = CreatePromotionFromModel(model);
                        promo.ProductGroupFK = updateProdGrp.ProductGroupPK;
                        dbcontext.Promotions.Add(promo);
                    }
                    else
                    {
                        promo.LandingPageURL = model.LandingUrl.Trim();
                        promo.PromotionName = model.ProductGroup.ProductPromotionName;
                        promo.PromotionDescription = model.ProductGroup.Words;
                    }
                }


                GeoTargetTableType gt;
                int addressCode = -1;
                var st = dbcontext.AddressTypes.SingleOrDefault(pt => pt.AddressType1 == model.PromotionAddressType);
                if (st != null)
                    addressCode = st.AddressTypePK;
                AddGeoTargetingToPromotion(promo, model, oldModel, out gt);
      

                var parameter = new SqlParameter("PromotionPK", promo.PromotionPK) {SqlDbType = SqlDbType.Int};
                var parameter2 = new SqlParameter("LandingUrl", model.LandingUrl.Trim())
                                     {SqlDbType = SqlDbType.NVarChar};
                var parameter3 = new SqlParameter("DisplayUrl", string.Empty) {SqlDbType = SqlDbType.NVarChar};
                var parameter4 = new SqlParameter("AddressTypeFK", addressCode) {SqlDbType = SqlDbType.Int};
                var parameter5 = new SqlParameter("GeoTVP", gt)
                                     {SqlDbType = SqlDbType.Structured, TypeName = "GeoTargetTableType"};
                var parameter6 = new SqlParameter("AdTVP", null)
                                     {SqlDbType = SqlDbType.Structured, TypeName = "PromoAdTableType"};
                var parameters = new object[] {parameter, parameter2, parameter3, parameter4, parameter5, parameter6};
                var results =
                    ((IObjectContextAdapter) dbcontext).ObjectContext.ExecuteStoreQuery<RVal>(
                        "exec UpdateGeoTargetingPromoAds @PromotionPK, @LandingUrl, @DisplayUrl, @AddressTypeFK, @GeoTVP, @AdTVP",
                        parameters);
                foreach (var r in results)
                {
                    rString.Append(r.UID);
                    rString.Append("=");
                    rString.Append(r.PKEY);
                    rString.Append(",");
                }















                dbcontext.SaveChanges();
            }
            return string.IsNullOrEmpty(rString.ToString())
                       ? String.Empty
                       : rString.ToString().Substring(0, rString.ToString().Length - 1);
        }

        private Promotion CreatePromotionFromModel(SmartWordSetupModel model)
        {
            return new Promotion
                       {
                           IsKeywordServiceOnly = true,
                           PromotionName = model.ProductGroup.ProductPromotionName,
                           LandingPageURL = model.LandingUrl,
                           PromotionDescription = model.ProductGroup.Words,
                           PromotionBudgetAmount = 0,
                           BudgetCycleFK = 3,
                           PromotionStartDate =
                               Convert.ToDateTime(model.ProductGroup.StartDate, new CultureInfo("en-Us")),
                           IsPaused = false,
                           IsCompleted = false,
                           IsLaunched = false,
                           IsDeleted = false,
                           CreatedDate = DateTime.Now,
                           IsAutobid = false
                       };
        }

        private Promotion GetPromotionFromProductGroup(ProductGroup prodGroup, string promotionName)
        {
            var promo = prodGroup.Promotions.SingleOrDefault(m => m.PromotionName == promotionName && !m.IsDeleted);
            return promo;
        }

        private bool AddGeoTargetingToPromotion(Promotion promo, SmartWordSetupModel model, SmartWordSetupModel oldModel,
                                                out GeoTargetTableType gtt)
        {
            bool shouldUpdateGeoTargeting = false;
            gtt = new GeoTargetTableType();

            GeoTargetTableTypeRow gtr;

            if (model.Addresses != null)
            {
                foreach (GeoTargeting geo in model.Addresses)
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
                        gtr.StateCodeFK = geo.StateCodeFK == int.MinValue ? null : geo.StateCodeFK;
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
                            oldModel.Addresses.SingleOrDefault(x => x.GeoTargetingPK == geo.GeoTargetingPK);
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

        private List<GeoTargetObject> SerializeToGeoTargetObjectArray(SmartWordSetupModel model)
        {
            var geoList = new List<GeoTargetObject>();
            var sr = new StateRepository();
            foreach (var geo in model.Addresses)
            {
                if (!geo.IsState && !geo.Delete && !geo.IsCountry)
                {
                    var geoTObj = new GeoTargetObject();
                    geoTObj.address = geo.Address;
                    geoTObj.city = geo.City;
                    if (geo.StateCodeFK != int.MinValue) geoTObj.state = sr.GetStateNameFromCode((int) geo.StateCodeFK);
                    geoTObj.zip = geo.Zip;
                    geoTObj.radius = (double?) (geo.ProximityRadius ?? null);
                    geoTObj.latitude = (double?) (geo.Latitude ?? null);
                    geoTObj.longitude = (double?) (geo.Longitude ?? null);
                    geoList.Add(geoTObj);
                }
            }
            return geoList;
        }
    }
}