using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestAdminApp.Models;


namespace SemplestAdminApp.Controllers
{
    public class CustomerAccountController : Controller
    {
        //
        // GET: /CreateNewCustomerAccount/

        public ActionResult Index()
        {
            
            //redirect to edit or add??
            return View();
        }

        public ActionResult Edit(int id)
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
               select new CustomerAccount 
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
                   UserPK= u.UserPK ,
                   StateID=sc.StateAbbrPK
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


            /////////////////////////////////////////////////////////////////////////////////
            //for reps dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allreps = from e in dbcontext.Employees
                          join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                          join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                          join u in dbcontext.Users on e.UsersFK equals u.UserPK
                          where (et.EmployeeType1 == "Rep")
                          select new EmployeeCustomerAssociaitionModel
                          {
                              AccountNumber = eca.CustomerFK,
                              employeePK = e.EmployeePK,
                              EmployeeType = et.EmployeeType1,
                              EmployeeUserPK = u.UserPK,
                              FirstName = u.FirstName,
                              LastName = u.LastName
                          };

            /////////////////////////////////////////////////////////////////////////////////
            //for sales dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allsalespersons = from e in dbcontext.Employees
                                  join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                                  join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                                  join u in dbcontext.Users on e.UsersFK equals u.UserPK
                                  where (et.EmployeeType1 == "Sales")
                                  select new EmployeeCustomerAssociaitionModel
                                  {
                                      AccountNumber = eca.CustomerFK,
                                      employeePK = e.EmployeePK,
                                      EmployeeType = et.EmployeeType1,
                                      EmployeeUserPK = u.UserPK,
                                      FirstName = u.FirstName,
                                      LastName = u.LastName
                                  };
            

            CustomerAccountWithEmployeeModel x = new CustomerAccountWithEmployeeModel();
            x.CustomerAccount = viewModel.Single(c => c.AccountNumber == id);
            x.EmployeeCustomerAssociaitionModel = viewModel2;


            /////////////////////////////////////////////////////////////////////////////////
            //for state dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allstates = (from sc in dbcontext.StateCodes select sc).ToList();
            x.SelectedStateID = viewModel.Select(r=>r.StateID).FirstOrDefault();
            x.States = allstates.Select(r => new SelectListItem
                        {
                            Value = r.StateAbbrPK.ToString(),
                            Text = r.StateAbbr.ToString()
                        });


            /////////////////////////////////////////////////////////////////////////////////
            //for reps dropdown
            /////////////////////////////////////////////////////////////////////////////////
            x.SelectedRepID = viewModel2.Select(r => r.employeePK).FirstOrDefault();

            //x.Reps=allreps.Select(r=>new SelectListItem 
            //            {
            //                Value=r.employeePK.ToString() ,
            //                 Text=r.FirstName
            //            });

            //workaround below (same as for state dropdown but with lists, in order to get over the error i get above) ; need to refactor later!!
            List<EmployeeCustomerAssociaitionModel> ll1 = allreps.ToList();
            List<SelectListItem> sl1= new List<SelectListItem>();
            foreach (EmployeeCustomerAssociaitionModel s in ll1)
            {
                SelectListItem mylistitem = new SelectListItem();
                mylistitem.Text = s.FirstName + " " + s.LastName;
                mylistitem.Value = s.EmployeeUserPK.ToString();
                sl1.Add(mylistitem);
            }
            x.Reps = sl1;



            /////////////////////////////////////////////////////////////////////////////////
            //for salespersons drowdown
            /////////////////////////////////////////////////////////////////////////////////

            x.SelectedSalesPersonID = viewModel2.Select(r => r.employeePK ).FirstOrDefault();
            //x.SalesPersons = allreps.Select(r => new SelectListItem
            //{
            //    //Value = r.EmployeeUserPK.ToString(),
            //    Value = r.employeePK.ToString(),
            //    Text = r.FirstName.ToString()
            //});
            //workaround below (same as for state dropdown but with lists, in order to get over the error) ; need to refactor later!!
            List<EmployeeCustomerAssociaitionModel> ll2 = allsalespersons.ToList();
            List<SelectListItem> sl2 = new List<SelectListItem>();
            foreach (EmployeeCustomerAssociaitionModel s in ll2)
            {
                SelectListItem mylistitem = new SelectListItem();
                mylistitem.Text = s.FirstName + " " + s.LastName;
                mylistitem.Value = s.EmployeeUserPK.ToString();
                sl2.Add(mylistitem);
            }
            x.SalesPersons = sl2;


            return View(x);

            
        }


        [HttpPost]
        public ActionResult Edit(CustomerAccountWithEmployeeModel m)
        {

            SemplestEntities dbcontext = new SemplestEntities();
            
            
            var user = dbcontext.Users.ToList().Find(p => p.UserPK == m.CustomerAccount.UserPK);
            user.FirstName = m.CustomerAccount.FirstName;
            user.LastName = m.CustomerAccount.LastName;
            user.Email = m.CustomerAccount.Email;
            user.EditedDate = DateTime.Now;
            UpdateModel(user);

            var customer = dbcontext.Customers.ToList().Find(p => p.CustomerPK == m.CustomerAccount.AccountNumber);
            var customeraddressassociation = dbcontext.CustomerAddressAssociations.ToList().Find(p => p.CustomerFK == customer.CustomerPK);
            var address = dbcontext.Addresses.ToList().Find(p => p.AddressPK == customeraddressassociation.AddressFK );
            address.Address1 = m.CustomerAccount.Address1;
            address.Address2 = m.CustomerAccount.Address2;
            address.City = m.CustomerAccount.City;
            address.ZipCode = m.CustomerAccount.Zip;
            address.EditedDate = DateTime.Now;
            address.StateAbbrFK = m.SelectedStateID;

            UpdateModel(address);
            dbcontext.SaveChanges();
            

           
            //Role ro = _dbContext.Roles.Add(new Role { RoleName = f["roleName"].ToString() });
            //_dbContext.SaveChanges();
            //foreach (sp_GetRigtsRolesInteraction_Result s in userRights)
            //{
            //    RolesRightsAssociation ra = new RolesRightsAssociation
            //    {
            //        IsReadonly = s.IsReadonly ==null ? false : bool.Parse(s.IsReadonly.ToString()), IsVisible = s.IsVisible == null ? false : bool.Parse(s.IsVisible.ToString()), RightsFK = s.RightsPK, RolesFK = ro.RolePK
            //    };
            //    _dbContext.RolesRightsAssociations.Add(ra);
            //}
            //_dbContext.SaveChanges();



            ////repopulate states ddl
            //var states = (from sc in dbcontext.StateCodes select sc).ToList();
            //m.States = states.Select(r => new SelectListItem
            // {
            //     Value = r.StateAbbrPK.ToString(),
            //     Text = r.StateAbbr.ToString()
            // });
            

            ////repopulate reps ddl
            //var allreps = from e in dbcontext.Employees
            //              join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
            //              join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
            //              join u in dbcontext.Users on e.UsersFK equals u.UserPK
            //              where (et.EmployeeType1 == "Rep")
            //              select new EmployeeCustomerAssociaitionModel
            //              {
            //                  AccountNumber = eca.CustomerFK,
            //                  employeePK = e.EmployeePK,
            //                  EmployeeType = et.EmployeeType1,
            //                  EmployeeUserPK = u.UserPK,
            //                  FirstName = u.FirstName,
            //                  LastName = u.LastName
            //              };
            //List<EmployeeCustomerAssociaitionModel> ll1 = allreps.ToList();
            //List<SelectListItem> sl1 = new List<SelectListItem>();
            //foreach (EmployeeCustomerAssociaitionModel s in ll1)
            //{
            //    SelectListItem mylistitem = new SelectListItem();
            //    mylistitem.Text = s.FirstName + " " + s.LastName;
            //    mylistitem.Value = s.EmployeeUserPK.ToString();
            //    sl1.Add(mylistitem);
            //}
            //m.Reps = sl1;



            ////repopulate salepersons ddl
            ////for reps dropdown
            //var allsalespersons = from e in dbcontext.Employees
            //              join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
            //              join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
            //              join u in dbcontext.Users on e.UsersFK equals u.UserPK
            //              where (et.EmployeeType1 == "Sales")
            //              select new EmployeeCustomerAssociaitionModel
            //              {
            //                  AccountNumber = eca.CustomerFK,
            //                  employeePK = e.EmployeePK,
            //                  EmployeeType = et.EmployeeType1,
            //                  EmployeeUserPK = u.UserPK,
            //                  FirstName = u.FirstName,
            //                  LastName = u.LastName
            //              };
            //List<EmployeeCustomerAssociaitionModel> ll2 = allsalespersons.ToList();
            //List<SelectListItem> sl2 = new List<SelectListItem>();
            //foreach (EmployeeCustomerAssociaitionModel s in ll2)
            //{
            //    SelectListItem mylistitem = new SelectListItem();
            //    mylistitem.Text = s.FirstName + " " + s.LastName;
            //    mylistitem.Value = s.EmployeeUserPK.ToString();
            //    sl2.Add(mylistitem);
            //}
            //m.SalesPersons = sl2;


            return RedirectToAction("Index");
            //return View("index");
            //return View(m);
        }

       


        public ActionResult Create()
        {
            return View();
        }

    }
}
