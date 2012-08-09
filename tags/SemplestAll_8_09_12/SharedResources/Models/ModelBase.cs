using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SemplestModel;

namespace SharedResources.Models
{
        public abstract class ModelBase
        {
            public Configuration Configuration { get; set; }
        }
}