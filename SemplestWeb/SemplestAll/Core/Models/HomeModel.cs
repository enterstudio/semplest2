﻿using System.Data.Entity;
using System.Collections.Generic;
namespace Semplest.Core.Models
{
    public class HomeModelParent
    {
        public int LaunchedCampaigns;
        public int StartedCampaignsNotLaunched;
        public int ClientsNotLoggedIn;
        public IEnumerable<SemplestModel.AdvertisingEngine> AdvertisingEngines ;
    }

    public class HomeModelChild
    {

    }
}