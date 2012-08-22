using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Semplest.Admin.Models.Repositories
{
    public interface  ICustomerRepository
    {
        void AddCustomer(CustomerAccountWithEmployeeModel m);
        bool DoesUserExit(string userId);
        bool ValidateAccountActivationToken(string token);

    }
}