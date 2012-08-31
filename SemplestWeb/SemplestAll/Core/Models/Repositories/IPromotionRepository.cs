namespace Semplest.Core.Models.Repositories
{
    public interface IPromotionRepository
    {
        int GetPromotionId(int userid, string prodGroupName, string promotionName); 
    }
}