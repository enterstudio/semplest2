using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Semplest.SharedResources
{
    public class SEMplestConstants
    {
        public const string SESSION_USERID = "UserId";
        public const string SESSION_LOGINATTEMPTS = "loginAttempts";
        public const string SESSION_ISKEYWORDBIDDING = "IsKeyWordBidding";

       public enum PromotionAdAction { Add, Update, Delete }

        public enum SchedulePromotionType
        {
            Pause,
            Unpause,
            Delete,
            End
        }

    }
 }