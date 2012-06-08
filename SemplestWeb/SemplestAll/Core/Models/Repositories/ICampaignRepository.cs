namespace Semplest.Core.Models.Repositories
{
    public interface ICampaignRepository
    {
        int Save(string data);
        CampaignSetupModel GetCategories(CampaignSetupModel model);
        CampaignSetupModel GetKeyWords(CampaignSetupModel model, int promoId);
    }
}