using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Semplest.Core.Models.Repositories
{
    public interface ISmartWordRepository
    {
        SmartWordSetupModel GetSetupModelForPromotionId(int promoId, int customerFk);
        string SavePromotionDetails(SmartWordSetupModel model, SmartWordSetupModel oldModel, int customerFk);
    }
}