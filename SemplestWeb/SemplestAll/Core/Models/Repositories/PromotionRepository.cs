using System.Linq;
using SemplestModel;

namespace Semplest.Core.Models.Repositories
{
    public class PromotionRepository : IPromotionRepository
    {
        readonly SemplestModel.Semplest _dbcontext;

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

        public Promotion GetPromoitionFromCampaign(int customerFK, string productGroupName, string productPromotionName)
        {
            var queryProd = (from c in _dbcontext.ProductGroups
                             where
                                 c.CustomerFK == customerFK &&
                                 c.ProductGroupName == productGroupName
                             select c).Single();
            return GetPromotionFromProductGroup(queryProd, productPromotionName);
        }

        public Promotion GetPromotionFromProductGroup(ProductGroup prodGroup, string promotionName)
        {
            var promo = prodGroup.Promotions.Single(m => m.PromotionName == promotionName && !m.IsDeleted);
            return promo;
        }

        public void SetPromotionToLaunched(int id)
        {
            _dbcontext.Promotions.Single(t => t.PromotionPK == id).IsLaunched = true;
        }
    }
}