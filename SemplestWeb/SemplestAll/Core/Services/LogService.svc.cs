using System.Data.Services;
using System.Data.Services.Common;
using Semplest.Core.Models;

namespace SemplestWebApp.Services
{
    public class LogService : DataService<SemplestEntities>
    {
        // This method is called only once to initialize service-wide policies.
        public static void InitializeService(DataServiceConfiguration config)
        {
            // TODO: set rules to indicate which entity sets and service operations are visible, updatable, etc.
            // Examples:
            // config.SetEntitySetAccessRule("MyEntityset", EntitySetRights.AllRead);
            // config.SetServiceOperationAccessRule("MyServiceOperation", ServiceOperationRights.All);
            config.DataServiceBehavior.MaxProtocolVersion = DataServiceProtocolVersion.V2;
        }

        public void AddToLog(int activityId, string description, string url, int userId)
        {
            //var semplest = new SemplestEntities();
            //semplest.ActivityLog.Add(new ActivityLog
            //{
            //    ActivityDate = DateTime.Now,
            //    Description = description,
            //    ActivityFK = 1,
            //    Url = url,
            //    UserFK = userId
            //});
            //semplest.SaveChanges();
        }
    }
}