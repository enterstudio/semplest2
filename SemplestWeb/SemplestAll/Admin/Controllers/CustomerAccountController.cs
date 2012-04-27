using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.Admin.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;
using LinqKit;


namespace Semplest.Admin.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    public class CustomerAccountController : Controller
    {
        //
        // GET: /CreateNewCustomerAccount/

        public ActionResult Index(string usersearch, string accountnumbersearch, string emailsearch, FormCollection form)
        {

            //ViewBag.Message = "Welcome to SEMPLEST ADMIN!";
            SemplestEntities dbcontext = new SemplestEntities();



            var viewModel =
                from u in dbcontext.Users
                join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
                //where ((c.Name.Contains(usersearch) || u.FirstName.Contains(usersearch) || u.LastName.Contains(usersearch)))
                select new HomeModel
                {
                    Customer = c.Name,
                    AccountNumber = c.CustomerPK,
                    FirstName = u.FirstName,
                    LastName = u.LastName,
                    Email = u.Email
                };

            var predicate = PredicateBuilder.True <HomeModel>();


            if (form["searchtype"] == "Customer" && usersearch != null && usersearch != "")
            {
                predicate = (p => p.Customer.ToLower().Contains(usersearch.ToLower()));
            }

            if (form["searchtype"] == "LastName" && usersearch != null && usersearch != "")
            {
                predicate = (p => p.LastName.ToLower().Contains(usersearch.ToLower()));
            }


            if ( accountnumbersearch != null && accountnumbersearch!="")
            {
                predicate = (p => p.AccountNumber.Equals(accountnumbersearch.ToLower()));
            }

            if (emailsearch != null && emailsearch!="")
            {
                predicate = (p => p.Email.ToLower().Contains(emailsearch.ToLower()));
            }


           
            viewModel = viewModel.AsExpandable().Where(predicate);
            
            //ordering by lastname, firstname
            viewModel = viewModel.OrderBy(p => p.LastName).ThenBy(p => p.FirstName); 

            return View(viewModel);
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
               join n in dbcontext.CustomerNotes.DefaultIfEmpty() on c.CustomerPK equals n.CustomerFK 

               where (c.CustomerPK == id)
               select new CustomerAccount
               {
                   AccountNumber = c.CustomerPK,
                   Customer = c.Name,
                   FirstName = u.FirstName,
                   LastName = u.LastName,
                   MiddleInitial = u.MiddleInitial,
                   Address1 = a.Address1,
                   Address2 = a.Address2,
                   City = a.City,
                   State = sc.StateAbbr,
                   Zip = a.ZipCode,
                   Phone = p.Phone1,
                   Email = u.Email,
                   BillType = b.BillType1,
                   UserPK = u.UserPK,
                   StateID = sc.StateAbbrPK,
                   CustomerNote=(n.Note==null?null:n.Note),
                   isActive = u.IsActive 
               };

            //viewmodel2 might not be needed
            var viewModel2 =
                from e in dbcontext.Employees
                join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                join u in dbcontext.Users on e.UsersFK equals u.UserPK
                where (eca.CustomerFK == id && et.EmployeeType1.ToLower() == "rep")
                select new EmployeeCustomerAssociaitionModel
                {
                    AccountNumber = eca.CustomerFK,
                    EmployeeType = et.EmployeeType1,
                    employeePK = e.EmployeePK,
                    FirstName = u.FirstName,
                    MiddleInitial = u.MiddleInitial,
                    LastName = u.LastName,
                    EmployeeUserPK = u.UserPK
                };


            var selectedrep =
                from e in dbcontext.Employees
                join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                join u in dbcontext.Users on e.UsersFK equals u.UserPK
                where (eca.CustomerFK == id && et.EmployeeType1.ToLower()=="rep")
                select new EmployeeCustomerAssociaitionModel
                {
                    AccountNumber = eca.CustomerFK,
                    EmployeeType = et.EmployeeType1,
                    employeePK = e.EmployeePK,
                    FirstName = u.FirstName,
                    MiddleInitial = u.MiddleInitial,
                    LastName = u.LastName,
                    EmployeeUserPK = u.UserPK
                };


            var selectedsales =
                from e in dbcontext.Employees
                join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                join u in dbcontext.Users on e.UsersFK equals u.UserPK
                where (eca.CustomerFK == id && et.EmployeeType1.ToLower() == "sales")
                select new EmployeeCustomerAssociaitionModel
                {
                    AccountNumber = eca.CustomerFK,
                    EmployeeType = et.EmployeeType1,
                    employeePK = e.EmployeePK,
                    FirstName = u.FirstName,
                    MiddleInitial = u.MiddleInitial,
                    LastName = u.LastName,
                    EmployeeUserPK = u.UserPK
                };


            /////////////////////////////////////////////////////////////////////////////////
            //for reps dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allreps = from e in dbcontext.Employees
                          //join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                          join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                          join u in dbcontext.Users on e.UsersFK equals u.UserPK
                          where (et.EmployeeType1 == "Rep")
                          select new EmployeeCustomerAssociaitionModel
                          {
                              //AccountNumber = eca.CustomerFK,
                              employeePK = e.EmployeePK,
                              EmployeeType = et.EmployeeType1,
                              EmployeeUserPK = u.UserPK,
                              FirstName = u.FirstName,
                              LastName = u.LastName,
                              MiddleInitial = u.MiddleInitial
                          };

            /////////////////////////////////////////////////////////////////////////////////
            //for sales dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allsalespersons = from e in dbcontext.Employees
                                  //join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                                  join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                                  join u in dbcontext.Users on e.UsersFK equals u.UserPK
                                  where (et.EmployeeType1 == "Sales")
                                  select new EmployeeCustomerAssociaitionModel
                                  {
                                      //AccountNumber = eca.CustomerFK,
                                      employeePK = e.EmployeePK,
                                      EmployeeType = et.EmployeeType1,
                                      EmployeeUserPK = u.UserPK,
                                      FirstName = u.FirstName,
                                      LastName = u.LastName,
                                      MiddleInitial = u.MiddleInitial
                                  };


            CustomerAccountWithEmployeeModel x = new CustomerAccountWithEmployeeModel();
            x.CustomerAccount = viewModel.Single(c => c.AccountNumber == id);
            x.EmployeeCustomerAssociaitionModel = viewModel2;


            /////////////////////////////////////////////////////////////////////////////////
            //for state dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allstates = (from sc in dbcontext.StateCodes select sc).ToList();
            x.SelectedStateID = viewModel.Select(r => r.StateID).FirstOrDefault();
            x.States = allstates.Select(r => new SelectListItem
                        {
                            Value = r.StateAbbrPK.ToString(),
                            Text = r.StateAbbr.ToString()
                        });


            /////////////////////////////////////////////////////////////////////////////////
            //for reps dropdown
            /////////////////////////////////////////////////////////////////////////////////
            x.SelectedRepID = selectedrep.ToList().First().employeePK ;

            //x.Reps=allreps.Select(r=>new SelectListItem 
            //            {
            //                Value=r.employeePK.ToString() ,
            //                 Text=r.FirstName
            //            });

            //workaround below (same as for state dropdown but with lists, in order to get over the error i get above) ; need to refactor later!!
            List<EmployeeCustomerAssociaitionModel> ll1 = allreps.ToList();
            List<SelectListItem> sl1 = new List<SelectListItem>();
            foreach (EmployeeCustomerAssociaitionModel s in ll1)
            {
                SelectListItem mylistitem = new SelectListItem();
                mylistitem.Text = s.FirstName + " " + s.LastName;
                mylistitem.Value = s.employeePK.ToString();
                sl1.Add(mylistitem);
            }
            x.Reps = sl1;



            /////////////////////////////////////////////////////////////////////////////////
            //for salespersons drowdown
            /////////////////////////////////////////////////////////////////////////////////

            //x.SelectedSalesPersonID = viewModel2.Select(r => r.employeePK).FirstOrDefault();
            x.SelectedSalesPersonID = selectedsales.ToList().First().employeePK;
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
                mylistitem.Value = s.employeePK.ToString();
                sl2.Add(mylistitem);
            }
            x.SalesPersons = sl2;


            return View(x);


        }


        [HttpPost]
        public ActionResult Edit(CustomerAccountWithEmployeeModel m)
        {

            if (!ModelState.IsValid)
                return View(m);

            SemplestEntities dbcontext = new SemplestEntities();


            var user = dbcontext.Users.ToList().Find(p => p.UserPK == m.CustomerAccount.UserPK);
            user.FirstName = m.CustomerAccount.FirstName;
            user.LastName = m.CustomerAccount.LastName;
            user.MiddleInitial = m.CustomerAccount.MiddleInitial;
            user.Email = m.CustomerAccount.Email;
            user.EditedDate = DateTime.Now;
            user.IsActive = m.CustomerAccount.isActive;
            UpdateModel(user);

            
            var customer = dbcontext.Customers.ToList().Find(p => p.CustomerPK == m.CustomerAccount.AccountNumber);
            var customeraddressassociation = dbcontext.CustomerAddressAssociations.ToList().Find(p => p.CustomerFK == customer.CustomerPK);
            var address = dbcontext.Addresses.ToList().Find(p => p.AddressPK == customeraddressassociation.AddressFK);
            

            customer.Name = m.CustomerAccount.Customer;
            
            address.Address1 = m.CustomerAccount.Address1;
            address.Address2 = m.CustomerAccount.Address2;
            address.City = m.CustomerAccount.City;
            address.ZipCode = m.CustomerAccount.Zip;
            address.EditedDate = DateTime.Now;
            address.StateAbbrFK = m.SelectedStateID;



            var rep = from c in dbcontext.Customers
                      join eca in dbcontext.EmployeeCustomerAssociations on c.CustomerPK equals eca.CustomerFK
                      join e in dbcontext.Employees on eca.EmployeeFK equals e.EmployeePK
                      join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                      where (c.CustomerPK == m.CustomerAccount.AccountNumber && et.EmployeeType1.ToLower() == "rep")
                      select new ECAModel
                      {
                            CustomerPK=c.CustomerPK,
                             EmployeePK = e.EmployeePK
                      };

            var sales = from c in dbcontext.Customers
                      join eca in dbcontext.EmployeeCustomerAssociations on c.CustomerPK equals eca.CustomerFK
                      join e in dbcontext.Employees on eca.EmployeeFK equals e.EmployeePK
                      join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                      where (c.CustomerPK == m.CustomerAccount.AccountNumber && et.EmployeeType1.ToLower()  == "sales")
                      select new ECAModel
                      {
                          CustomerPK = c.CustomerPK,
                          EmployeePK = e.EmployeePK
                      };

            //rep.ToList().First().EmployeePK = m.SelectedRepID;
            //sales.ToList().First().EmployeePK = m.SelectedSalesPersonID;

            var employeesales= dbcontext.EmployeeCustomerAssociations.ToList().Find(p => p.CustomerFK==m.CustomerAccount.AccountNumber && p.EmployeeFK==sales.ToList().First().EmployeePK);
            employeesales.EmployeeFK = m.SelectedSalesPersonID;


            var employeerep = dbcontext.EmployeeCustomerAssociations.ToList().Find(p => p.CustomerFK == m.CustomerAccount.AccountNumber && p.EmployeeFK == rep.ToList().First().EmployeePK);
            employeerep.EmployeeFK = m.SelectedRepID;



            UpdateModel(employeerep);
            UpdateModel(employeesales);
            //var employeecustomerassociation = dbcontext.EmployeeCustomerAssociations.ToList().Find(p => p.CustomerFK  == customer.CustomerPK && p.EmployeeFK==1);
            
            
            //employeecustomerassociation.
            //employeecustomerassociation.EmployeeCustomerAssociationPK

            UpdateModel(address);
            var customernote=dbcontext.CustomerNotes.ToList().FirstOrDefault(p=>p.CustomerFK==m.CustomerAccount.AccountNumber);
            customernote.Note = m.CustomerAccount.CustomerNote;
            UpdateModel(customernote);
            
            

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



        public ActionResult Add()
        {



            SemplestEntities dbcontext = new SemplestEntities();

            /////////////////////////////////////////////////////////////////////////////////
            //for reps dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allreps = from e in dbcontext.Employees
                          //join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                          join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                          join u in dbcontext.Users on e.UsersFK equals u.UserPK
                          where (et.EmployeeType1 == "Rep")
                          select new EmployeeCustomerAssociaitionModel
                          {
                              //AccountNumber = eca.CustomerFK,
                              employeePK = e.EmployeePK,
                              EmployeeType = et.EmployeeType1,
                              EmployeeUserPK = u.UserPK,
                              FirstName = u.FirstName,
                              MiddleInitial = u.MiddleInitial,
                              LastName = u.LastName
                          };






            /////////////////////////////////////////////////////////////////////////////////
            //for sales dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allsalespersons = from e in dbcontext.Employees
                                  //join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                                  join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                                  join u in dbcontext.Users on e.UsersFK equals u.UserPK
                                  where (et.EmployeeType1 == "Sales")
                                  select new EmployeeCustomerAssociaitionModel
                                  {
                                      //AccountNumber = eca.CustomerFK,
                                      employeePK = e.EmployeePK,
                                      EmployeeType = et.EmployeeType1,
                                      EmployeeUserPK = u.UserPK,
                                      FirstName = u.FirstName,
                                      MiddleInitial = u.MiddleInitial,
                                      LastName = u.LastName
                                  };


            CustomerAccountWithEmployeeModel x = new CustomerAccountWithEmployeeModel();
            //x.CustomerAccount = //viewModel.Single(c => c.AccountNumber == id);
            //x.EmployeeCustomerAssociaitionModel = viewModel2;


            /////////////////////////////////////////////////////////////////////////////////
            //for state dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allstates = (from sc in dbcontext.StateCodes select sc).ToList();
            x.SelectedStateID = -1;//viewModel.Select(r => r.StateID).FirstOrDefault();
            x.States = allstates.Select(r => new SelectListItem
            {
                Value = r.StateAbbrPK.ToString(),
                Text = r.StateAbbr.ToString()
            });


            /////////////////////////////////////////////////////////////////////////////////
            //for reps dropdown
            /////////////////////////////////////////////////////////////////////////////////
            x.SelectedRepID = -1; //viewModel2.Select(r => r.employeePK).FirstOrDefault();

            //x.Reps=allreps.Select(r=>new SelectListItem 
            //            {
            //                Value=r.employeePK.ToString() ,
            //                 Text=r.FirstName
            //            });

            //workaround below (same as for state dropdown but with lists, in order to get over the error i get above) ; need to refactor later!!
            List<EmployeeCustomerAssociaitionModel> ll1 = allreps.ToList();
            List<SelectListItem> sl1 = new List<SelectListItem>();
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

            x.SelectedSalesPersonID = -1; //viewModel2.Select(r => r.employeePK).FirstOrDefault();
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
        public ActionResult Add(CustomerAccountWithEmployeeModel m)
        {
            if (!ModelState.IsValid)
                return View(m);


            try
            {
                SemplestEntities dbcontext = new SemplestEntities();

                BillType bt = dbcontext.BillTypes.First(p => p.BillType1 == "Flat Fee"); // --- feees --- !!!

                ProductGroupCycleType pgct = dbcontext.ProductGroupCycleTypes.First(p => p.ProductGroupCycleType1 == "Product Group Cycle 30");

                Customer c = dbcontext.Customers.Add(new Customer { Name = m.CustomerAccount.Customer, BillType = bt, ProductGroupCycleType = pgct });
                User u = dbcontext.Users.Add(new User
                {
                    Customer = c,
                    Email = m.CustomerAccount.Email,
                    FirstName = m.CustomerAccount.FirstName,
                    LastName = m.CustomerAccount.LastName,
                    MiddleInitial = m.CustomerAccount.MiddleInitial,
                    IsActive=m.CustomerAccount.isActive 
                });

                Credential cr = dbcontext.Credentials.Add(new Credential { User = u, UsersFK = u.UserPK, Username = m.CustomerAccount.Email, Password = "t" }); //-- default password --- !!

                PhoneType pt = dbcontext.PhoneTypes.First(p => p.PhoneType1 == "Business"); // --- phone types --- !!!!
                Phone ph = dbcontext.Phones.Add(new Phone { Phone1 = m.CustomerAccount.Phone, PhoneType = pt });
                CustomerPhoneAssociation cpa = dbcontext.CustomerPhoneAssociations.Add(new CustomerPhoneAssociation { Customer = c, Phone = ph });

                StateCode sc = dbcontext.StateCodes.First(p => p.StateAbbrPK == m.SelectedStateID);
                AddressType at = dbcontext.AddressTypes.First(p => p.AddressType1 == "H"); // --- address types --- !!!
                Address a = dbcontext.Addresses.Add(new Address { Address1 = m.CustomerAccount.Address1, Address2 = m.CustomerAccount.Address2, City = m.CustomerAccount.City, ZipCode = m.CustomerAccount.Zip, StateCode = sc });
                CustomerAddressAssociation caa = dbcontext.CustomerAddressAssociations.Add(new CustomerAddressAssociation { Address = a, Customer = c, AddressType = at });

                CustomerNote cn = dbcontext.CustomerNotes.Add(new CustomerNote { Customer=c, Note=m.CustomerAccount.CustomerNote });
                

                EmployeeCustomerAssociation addrep = dbcontext.EmployeeCustomerAssociations.Add(new EmployeeCustomerAssociation { Customer=c, EmployeeFK=m.SelectedRepID });
                EmployeeCustomerAssociation addsales = dbcontext.EmployeeCustomerAssociations.Add(new EmployeeCustomerAssociation { Customer = c, EmployeeFK = m.SelectedSalesPersonID });

                dbcontext.SaveChanges();

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.TargetSite);
            }


            return RedirectToAction("Index");
        }

    }
}
