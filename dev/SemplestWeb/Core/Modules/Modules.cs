using Ninject.Modules;
using SemplestWebApp.Models.Repositories;

namespace SemplestWebApp.Modules
{
    public class Module : NinjectModule
    {
        public override void Load()
        {
            Bind<ICampaignRepository>().To<CampaignRepository>();
        }
    }
}