using System.Collections.Generic;
using System.Linq;
using SemplestModel;
using Semplest.SharedResources.Services;

namespace Semplest.Core.Models.Repositories
{
    public interface ICampaignRepository
    {

        void SaveGeoTargetingAds(int customerFK, CampaignSetupModel model, CampaignSetupModel oldModel);
        CampaignSetupModel GetCampaignSetupModelForPromotionId(int promoId, bool preview = false);
        bool DoesPromotionExist(string prodGroup, string promotionName, int custFk);
        IQueryable<vwProductPromotion> GetUserWithProductGroupAndPromotions(int userid);
        Promotion GetPromoitionFromCampaign(int customerFK, CampaignSetupModel model);
        List<ProductGroup> GetProductGroupsForUser(int userid);
        int GetPromotionId(int userid, string prodGroupName, string promotionName);
        int GetBudgetCycleId(string budgetCycleName);
        Promotion CreatePromotionFromModel(CampaignSetupModel model, decimal customerDefaultPerCampaignFlatFeeAmount);

        void SavePromotionAdEngineSelected(Promotion promo, CampaignSetupModel model, SemplestModel.Semplest dbcontext);
        void AddGeoTargetingToPromotion(Promotion promo, CampaignSetupModel model, int customerFk, CampaignSetupModel oldModel, System.Data.Objects.ObjectContext context);
        void SaveProductPromotion(int customerFk, CampaignSetupModel model, CampaignSetupModel oldModel);
        void SaveSiteLinks(CampaignSetupModel model, int customerFk, CampaignSetupModel oldModel);
        void SaveSelectedCategories(int promotionId, IEnumerable<string> selectedCategories);

        void SaveKeywords(int promotionId, List<KeywordProbabilityObject> kpos, List<string> negativeKeywords,
                          string productGroupName, string promotionName);

        bool IsDeletedKeyword(string keyword, List<string> negativeKeywords);

        bool IsNegativeKeyword(string keyword, List<string> negativeKeywords);
        List<CampaignSetupModel.KeywordsModel> SaveNegativeKeywords(CampaignSetupModel model, int customerFk);
        string GetStateNameFromCode(int stateCode);
        List<string> GetAdEngines();
        bool IsPromotionLaunched(int promoId);
        bool IsPromotionCompleted(int promoId);
        bool IsPromotionLaunchedAndCompleted(int promoId);
        void SetKeywordsDeleted(List<int> keywordIds, int promoId);
        CampaignSetupModel GetCategories(CampaignSetupModel model);
        CampaignSetupModel GetKeyWords(CampaignSetupModel model, int promoId);
        GoogleViolation[] ValidateSiteLinks(int promoId);
        GoogleViolation[] ValidateGeotargeting(int promoId);
        GoogleViolation[] ValidateAds(string landingPageURL, string displayURL, List<GoogleAddAdRequest> ads);
        GoogleViolation[] ValidateGoogleNegativeKeywords(List<string> negativeKeywords);
    }
}