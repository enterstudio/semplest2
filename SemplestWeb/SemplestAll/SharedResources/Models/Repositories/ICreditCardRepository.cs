using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Semplest.SharedResources.Services;

namespace SharedResources.Models.Repositories
{
    public interface ICreditCardRepository
    {
        bool ChargeCreditCard(CustomerObject co, int customerFk, int payTypeFk);
    }
}