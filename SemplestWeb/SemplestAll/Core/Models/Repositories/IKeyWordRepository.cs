using SemplestModel;
using System.Collections.Generic;

namespace Semplest.Core.Models.Repositories
{
    public interface IKeyWordRepository
    {
        List<CampaignSetupModel.KeywordsModel> SaveNegativeKeywords(SmartWordSetupModel model, int customerFk, Promotion promo);
    }
}