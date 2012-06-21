﻿using System.Collections.Generic;
using System.Linq;
using Semplest.SharedResources.Services;
using SemplestModel;

namespace Semplest.Core.Models.Repositories
{
    public interface ICampaignRepository
    {
        void SaveProductGroupAndCampaign(int userid, CampaignSetupModel model);
        CampaignSetupModel GetCampaignSetupModelForPromotionId(int promoId);
        IQueryable<vwProductPromotion> GetUserWithProductGroupAndPromotions(int userid);
        Promotion GetPromotionFromProductGroup(ProductGroup prodGroup, string promotionName);
        List<ProductGroup> GetProductGroupsForUser(int userid);
        int GetPromotionId(int userid, string prodGroupName, string promotionName);
        int GetBudgetCycleId(string budgetCycleName);
        Promotion CreatePromotionFromModel(CampaignSetupModel model, decimal customerDefaultPerCampaignFlatFeeAmount);

        void UpdatePromotionFromModel(Promotion updatePromotion, CampaignSetupModel model, SemplestModel.Semplest dbcontext,
                                      int customerFk);

        void SavePromotionAdEngineSelected(Promotion promo, CampaignSetupModel model, SemplestModel.Semplest dbcontext);
        void AddGeoTargetingToPromotion(Promotion promo, CampaignSetupModel model, int customerFk);
        void AddSiteLinksToPromotion(Promotion promo, CampaignSetupModel model, int customerFk);
        void AddPromotionAdsToPromotion(Promotion promo, CampaignSetupModel model, int customerFk);
        void SaveSelectedCategories(int promotionId, IEnumerable<string> selectedCategories);

        void SaveKeywords(int promotionId, List<KeywordProbabilityObject> kpos, List<string> negativeKeywords,
                          string productGroupName, string promotionName);

        bool IsDeletedKeyword(string keyword, List<string> negativeKeywords);

        bool IsNegativeKeyword(string keyword, List<string> negativeKeywords);
        void SaveNegativeKeywords(Promotion promo, CampaignSetupModel model, SemplestModel.Semplest dbcontext);
        string GetStateNameFromCode(int stateCode);
        List<string> GetAdEngines();
        bool IsPromotionLaunched(int promoId);
        bool IsPromotionCompleted(int promoId);
        bool IsPromotionLaunchedAndCompleted(int promoId);
        void SetKeywordsDeleted(List<int> keywordIds, int promoId);
        CampaignSetupModel GetCategories(CampaignSetupModel model);
        CampaignSetupModel GetKeyWords(CampaignSetupModel model, int promoId);
    }
}