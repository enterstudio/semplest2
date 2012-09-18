using SemplestModel;
namespace Semplest.Core.Models.Repositories
{
    public interface IPromotionRepository
    {
        int GetPromotionId(int userid, string prodGroupName, string promotionName);

        Promotion GetPromoitionFromCampaign(int customerFK, SmartWordSetupModel model);

        void SetPromotionToLaunched(int id);
    }
}