using SemplestModel;
namespace Semplest.Core.Models.Repositories
{
    public interface IPromotionRepository
    {
        int GetPromotionId(int userid, string prodGroupName, string promotionName);

        Promotion GetPromoitionFromCampaign(int customerFK, string productGroupName, string productPromotionName);

        void SetPromotionToLaunched(int id);
    }
}