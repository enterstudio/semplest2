using Semplest.SharedResources.Services;
using SemplestModel;

namespace SharedResources.Models.Repositories
{
    public interface ICreditCardRepository
    {
        bool ChargeCreditCard(CustomerObject co, Promotion promo, int payTypeFk, decimal budget);
    }
}