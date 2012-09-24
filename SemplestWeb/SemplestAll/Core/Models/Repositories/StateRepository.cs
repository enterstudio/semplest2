using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Semplest.Core.Models.Repositories
{
    public class StateRepository : IStateRepository
    {
        private readonly SemplestModel.Semplest _dbContext;
        public StateRepository(SemplestModel.Semplest dbContext)
        {
            _dbContext = dbContext;
        }

        public string GetStateNameFromCode(int stateCode)
        {
            string stateName = string.Empty;
            var state = _dbContext.StateCodes.SingleOrDefault(m => m.StateAbbrPK == stateCode);
                if (state != null)
                    stateName = state.StateAbbr;
            return stateName;
        }
    }
}