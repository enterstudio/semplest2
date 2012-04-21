using System.Web.Script.Serialization;
using Newtonsoft.Json;
namespace Semplest.Core.Models.Repositories
{
    public class CampaignRepository : ICampaignRepository
    {
        public int Save(string data)
        {
            var jss = new JavaScriptSerializer();
            var myDynamic = jss.Deserialize(data, typeof(object));

            return 0;
        }
    }
}