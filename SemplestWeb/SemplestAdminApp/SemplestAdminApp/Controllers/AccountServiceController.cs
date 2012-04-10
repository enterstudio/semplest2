using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestAdminApp.Models;

namespace SemplestAdminApp.Controllers
{
    public class AccountServiceController : Controller
    {
        //
        // GET: /ClientAccount/

        public ActionResult Index(int id)
        {
            SemplestEntities dbcontext = new SemplestEntities();
            var viewModel =
               from u in dbcontext.Users
               join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
               join caa in dbcontext.CustomerAddressAssociations on c.CustomerPK equals caa.CustomerFK
               join a in dbcontext.Addresses on caa.AddressFK equals a.AddressPK
               join sc in dbcontext.StateCodes on a.StateAbbrFK equals sc.StateAbbrPK
               join at in dbcontext.AddressTypes on caa.AddressTypeFK equals at.AddressTypePK
               join cpa in dbcontext.CustomerPhoneAssociations on c.CustomerPK equals cpa.CustomerFK 
               join p in dbcontext.Phones on cpa.PhoneFK equals p.PhonePK 
               join b in dbcontext.BillTypes on c.BillTypeFK equals b.BillTypePK 
               where (c.CustomerPK==id)
               select new AccountServiceModel 
               {
                    AccountNumber = c.CustomerPK ,
                    Customer  = c.Name ,
                    FirstName  = u.FirstName  ,
                    LastName  = u.LastName ,
                    Address1  = a.Address1 ,
                    Address2  = a.Address2 ,
                    City  = a.City ,
                    State  = sc.StateAbbr ,
                    Zip = a.ZipCode ,
                    Phone  = p.Phone1 ,
                    Email  = u.Email ,
                    BillType  = b.BillType1 
               };

            return View(viewModel.Single(c=>c.AccountNumber==id));
        }

        public ActionResult Finance(int id)
        {

            SemplestEntities dbcontext = new SemplestEntities();
            var viewModel =
               from u in dbcontext.Users
               join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
               join caa in dbcontext.CustomerAddressAssociations on c.CustomerPK equals caa.CustomerFK
               join a in dbcontext.Addresses on caa.AddressFK equals a.AddressPK
               join sc in dbcontext.StateCodes on a.StateAbbrFK equals sc.StateAbbrPK
               join at in dbcontext.AddressTypes on caa.AddressTypeFK equals at.AddressTypePK
               join cpa in dbcontext.CustomerPhoneAssociations on c.CustomerPK equals cpa.CustomerFK
               join p in dbcontext.Phones on cpa.PhoneFK equals p.PhonePK
               join b in dbcontext.BillTypes on c.BillTypeFK equals b.BillTypePK
               where (c.CustomerPK == id)
               select new AccountServiceModel
               {
                   AccountNumber = c.CustomerPK,
                   Customer = c.Name,
                   FirstName = u.FirstName,
                   LastName = u.LastName,
                   Address1 = a.Address1,
                   Address2 = a.Address2,
                   City = a.City,
                   State = sc.StateAbbr,
                   Zip = a.ZipCode,
                   Phone = p.Phone1,
                   Email = u.Email,
                   BillType = b.BillType1
               };

            return View(viewModel.Single(c => c.AccountNumber == id));
        }

    }
}
