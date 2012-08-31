using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Semplest.Core.Models.Repositories
{
    public class StateRepository : IStateRepository
    {

        public string GetStateNameFromCode(int stateCode)
        {
            string stateName = string.Empty;
            using (var db = new SemplestModel.Semplest())
            {
                var state = db.StateCodes.SingleOrDefault(m => m.StateAbbrPK == stateCode);
                if (state != null)
                    stateName = state.StateAbbr;
            }
            return stateName;
        }
    }
}