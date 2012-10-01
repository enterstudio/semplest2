using Semplest.SharedResources.Services;
using SemplestModel;
using SharedResources.Helpers;

namespace SharedResources.Models.Repositories
{
    public interface ICreditCardRepository
    {
        ReturnState ChargeCreditCard(CustomerObject co, Promotion promo, int payTypeFk, decimal budget);
    }
}