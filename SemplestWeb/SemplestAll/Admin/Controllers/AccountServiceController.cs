using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.Admin.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;


namespace Semplest.Admin.Controllers
{
    [ExceptionHelper]
    [AuthorizeRoleAttribute]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")] 
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
                   BillType = b.BillType1,
                   isActive = u.IsActive
               };

            var viewModel2 =
                from e in dbcontext.Employees
                join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                join u in dbcontext.Users on e.UsersFK equals u.UserPK
                where (eca.CustomerFK == id)
                select new EmployeeCustomerAssociaitionModel
            {
                AccountNumber = eca.CustomerFK,
                EmployeeType = et.EmployeeType1,
                employeePK = e.EmployeePK,
                FirstName = u.FirstName,
                LastName = u.LastName,
                EmployeeUserPK = u.UserPK
            };



            AccountServiceWithEmployeeModel x = new AccountServiceWithEmployeeModel();
            var parent =
         from ch in dbcontext.CustomerHierarchies
         where (ch.CustomerFK == id)
         select ch;


            if (parent.FirstOrDefault().CustomerFK == parent.FirstOrDefault().CustomerParentFK) //self
            {
                x.ParentName = "Self";

            }
            else


                if (parent.FirstOrDefault().CustomerParentFK == null) //parent
                {
                    
                    x.ParentName = "This is a parent";

                }
                else
                {
                    //parent
                    var findparent = from p in dbcontext.Customers
                                     where p.CustomerPK==(parent.FirstOrDefault().CustomerParentFK)
                                     select p;
                    x.ParentName = findparent.FirstOrDefault().Name;

                }


            x.AccountServiceModel = viewModel.Single(c => c.AccountNumber == id);
            x.EmployeeCustomerAssociaitionModel = viewModel2;







            //from u in dbcontext.Users
            //join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
            //join eca in dbcontext.EmployeeCustomerAssociations on c.CustomerPK equals eca.CustomerFK
            //join e in dbcontext.Employees on u.UserPK equals e.UsersFK
            //join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID

            //where (c.CustomerPK == id)
            //select new EmployeeCustomerAssociaitionModel
            //{
            //    AccountNumber = c.CustomerPK,
            //    EmployeeType = et.EmployeeType1,
            //    employeePK = e.EmployeePK,
            //    FirstName = u.FirstName,
            //    LastName = u.LastName,
            //    EmployeeUserPK = u.UserPK
            //};

            //return View(viewModel.Single(c=>c.AccountNumber==id));
            return View(x);
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
