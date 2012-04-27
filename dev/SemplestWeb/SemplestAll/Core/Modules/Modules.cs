using Ninject.Modules;
using Semplest.Core.Models.Repositories;

namespace Semplest.Core.Modules
{
    public class Module : NinjectModule
    {
        public override void Load()
        {
            Bind<ICampaignRepository>().To<CampaignRepository>();
        }
    }
}