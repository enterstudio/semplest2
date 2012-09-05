using System;
using System.Linq;
using SemplestModel;

namespace Semplest.Core.Models.Repositories
{
    public class PromotionRepository : IPromotionRepository
    {
        private SemplestModel.Semplest _dbcontext;

        public PromotionRepository(SemplestModel.Semplest dbcontext)
        {
            _dbcontext = dbcontext;
        }

        public int GetPromotionId(int userid, string prodGroupName, string promotionName)
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

        public Promotion GetPromoitionFromCampaign(int customerFK, SmartWordSetupModel model)
        {
            var queryProd = (from c in _dbcontext.ProductGroups
                             where
                                 c.CustomerFK == customerFK &&
                                 c.ProductGroupName == model.ProductGroup.ProductGroupName
                             select c).Single();
            return GetPromotionFromProductGroup(queryProd, model.ProductGroup.ProductPromotionName);
        }

        public Promotion GetPromotionFromProductGroup(ProductGroup prodGroup, string promotionName)
        {
            var promo = prodGroup.Promotions.FirstOrDefault(m => m.PromotionName == promotionName && !m.IsDeleted);
            return promo;
        }

        public void SetPromotionToLaunched(int id)
        {
            _dbcontext.Promotions.Single(t => t.PromotionPK == id).IsLaunched = true;
        }
    }
}