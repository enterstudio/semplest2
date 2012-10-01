using System.Collections.Generic;
using System.Linq;
using SemplestModel;
using SharedResources.Helpers;


namespace Semplest.Core.Models.Repositories
{
    public interface ICampaignRepository
    {

        ReturnState SaveGeoTargetingAds(int customerFK, CampaignSetupModel model, CampaignSetupModel oldModel);
        CampaignSetupModel GetCampaignSetupModelForPromotionId(int promoId, bool preview = false);
        bool DoesPromotionExist(string prodGroup, string promotionName, int custFk);
        IQueryable<vwProductPromotion> GetUserWithProductGroupAndPromotions(int userid);
        Promotion GetPromoitionFromCampaign(int customerFK, CampaignSetupModel model);
        List<ProductGroup> GetProductGroupsForUser(int userid);
        int GetBudgetCycleId(string budgetCycleName);
        Promotion CreatePromotionFromModel(CampaignSetupModel model, decimal customerDefaultPerCampaignFlatFeeAmount);

        void SavePromotionAdEngineSelected(Promotion promo, CampaignSetupModel model, SemplestModel.Semplest dbcontext);
        void SaveProductPromotion(int customerFk, CampaignSetupModel model, CampaignSetupModel oldModel);
        ReturnState SaveSiteLinks(CampaignSetupModel model, int customerFk, CampaignSetupModel oldModel);
        void SaveSelectedCategories(int promotionId, IEnumerable<string> selectedCategories);



        bool IsDeletedKeyword(string keyword, List<string> negativeKeywords);

        bool IsNegativeKeyword(string keyword, List<string> negativeKeywords);
        ReturnState SaveNegativeKeywords(CampaignSetupModel model, int customerFk);
        string GetStateNameFromCode(int stateCode);
        void SetKeywordsDeleted(List<int> keywordIds, int promoId);
        CampaignSetupModel GetCategories(CampaignSetupModel model);
        CampaignSetupModel GetKeyWords(CampaignSetupModel model, int promoId);
    }
}