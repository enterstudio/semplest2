using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.Admin.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;
using LinqKit;
using System.Data.Objects;
using Semplest.SharedResources.Services;
//using System.Web.Security;


namespace Semplest.Admin.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class CustomerAccountController : Controller
    {
        //
        // GET: /CreateNewCustomerAccount/

        public ActionResult Index(string usersearch, string accountnumbersearch, string emailsearch, FormCollection form)
        {

            //ViewBag.Message = "Welcome to SEMPLEST ADMIN!";
            SemplestModel.Semplest dbcontext = new SemplestModel.Semplest();

            var viewModel =
                from u in dbcontext.Users
                join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
                where ((c.Name.Contains(usersearch) || u.FirstName.Contains(usersearch) || u.LastName.Contains(usersearch)))
                select new HomeModel
                {
                    Customer = c.Name,
                    AccountNumber = c.CustomerPK,
                    FirstName = u.FirstName,
                    LastName = u.LastName,
                    Email = u.Email
                };

            var predicate = PredicateBuilder.True<HomeModel>();


            if (form["searchtype"] == "Customer" && usersearch != null && usersearch != "")
            {
                predicate = (p => p.Customer.ToLower().Contains(usersearch.ToLower()));
            }

            if (form["searchtype"] == "LastName" && usersearch != null && usersearch != "")
            {
                predicate = (p => p.LastName.ToLower().Contains(usersearch.ToLower()));
            }

            int accnumber;
            bool validaccountsearch = int.TryParse(accountnumbersearch, out accnumber);

            if (accountnumbersearch != null && accountnumbersearch != "" && validaccountsearch)
            {
                predicate = (p => p.AccountNumber == accnumber);
            }

            if (emailsearch != null && emailsearch != "")
            {
                predicate = (p => p.Email.ToLower().Contains(emailsearch.ToLower()));
            }


            //ordering by lastname, firstname
            viewModel = viewModel.OrderBy(p => p.Customer).ThenBy(p => p.LastName).ThenBy(p => p.FirstName);
            viewModel = viewModel.AsExpandable().Where(predicate);


            return View(viewModel);
        }

        public ActionResult Edit(int id)
        {

            SemplestModel.Semplest dbcontext = new SemplestModel.Semplest();

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
                   CustomerNote = (n.Note == null ? null : n.Note),
                   isActive = u.IsActive,
                   selectedBillTypeid = c.BillTypeFK,
                   internalID=c.InternalCustomerId,
                   PercentMedia = c.PercentOfMedia,
                    ServiceFee = c.ServiceFee ,
                     CreditLimit=c.CreditLimit,
                     PromotionFeeAmount=c.PromotionFeeAmount ,
                     PromotionFeeOverride = c.PromotionFeeOverride 
               };

            
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

            /////////////////////////////////////////////////////////////////////////////
            ////for parents dropdown
            /////////////////////////////////////////////////////////////////////////////
            var selectedparent =
               from ch in dbcontext.CustomerHierarchies
               where (ch.CustomerFK == id)
               select ch;

            var allparents =
                from c in dbcontext.Customers
                join chi in dbcontext.CustomerHierarchies.Where(p => p.CustomerParentFK == null) on c.CustomerPK equals chi.CustomerFK
                select c;


            /////////////////////////////////////////////////////////////////////////////
            ////for billtype dropdown
            /////////////////////////////////////////////////////////////////////////////
            var selectedbilltype =
               from bt in dbcontext.BillTypes
               select bt;

            var allbilltypes =
                from bt in dbcontext.BillTypes
                select bt;



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
                          where (et.EmployeeType1 == "Rep" && u.IsActive.Equals(true))
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
                                  where (et.EmployeeType1 == "Sales" && u.IsActive.Equals(true))
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

            


            //add userid and password to model
            var credential = dbcontext.Credentials.First(r => r.UsersFK.Equals(x.CustomerAccount.UserPK));
            x.CustomerAccount.UserID = credential.Username;
            x.CustomerAccount.UserPassword = credential.Password;



            /////////////////////////////////////////////////////////////////////////////////
            //for roles dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var roles = (from r in dbcontext.Roles select r).ToList().OrderBy(r => r.RoleName);
            //x.SelectedRoleID = viewModel.Select(r => r.RolesFK).FirstOrDefault();
            
            
            var userrolesassociation = dbcontext.UserRolesAssociations.ToList().Find(p => p.UsersFK == x.CustomerAccount.UserPK);
            if (userrolesassociation == null) { x.SelectedRoleID = -1; }
            else { x.SelectedRoleID = userrolesassociation.RolesFK; }


            x.Roles = roles.Select(r => new SelectListItem
            {
                Value = r.RolePK.ToString(),
                Text = r.RoleName.ToString()
            });




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
            if (selectedrep.ToList().FirstOrDefault() == null)
                x.SelectedRepID = -1;
            else
            x.SelectedRepID = selectedrep.ToList().FirstOrDefault().employeePK;

            //x.Reps=allreps.Select(r=>new SelectListItem 
            //            {
            //                Value=r.employeePK.ToString() ,
            //                 Text=r.FirstName
            //            });

            //workaround below (same as for state dropdown but with lists, in order to get over the error i get above) ; need to refactor later!!
            List<SelectListItem> slina = new List<SelectListItem>();
            slina.Add(new SelectListItem { Value = (-1).ToString(), Text = "«« Not Assigned »»" });



            List<EmployeeCustomerAssociaitionModel> ll1 = allreps.OrderBy(r => r.LastName).ThenBy(r => r.FirstName).ToList();
            List<SelectListItem> sl1 = new List<SelectListItem>();
            foreach (EmployeeCustomerAssociaitionModel s in ll1)
            {
                SelectListItem mylistitem = new SelectListItem();
                mylistitem.Text = s.FirstName + " " + s.LastName;
                mylistitem.Value = s.employeePK.ToString();
                sl1.Add(mylistitem);
            }
            x.Reps = sl1.Union(slina);




            /////////////////////////////////////////////////////////////////////////////////
            //for salespersons drowdown
            /////////////////////////////////////////////////////////////////////////////////

            //x.SelectedSalesPersonID = viewModel2.Select(r => r.employeePK).FirstOrDefault();
            if (selectedsales.ToList().FirstOrDefault()== null)
                x.SelectedSalesPersonID = -1;
            else
                x.SelectedSalesPersonID = selectedsales.ToList().First().employeePK;
            //x.SalesPersons = allreps.Select(r => new SelectListItem
            //{
            //    //Value = r.EmployeeUserPK.ToString(),
            //    Value = r.employeePK.ToString(),
            //    Text = r.FirstName.ToString()
            //});
            //workaround below (same as for state dropdown but with lists, in order to get over the error) ; need to refactor later!!
            List<EmployeeCustomerAssociaitionModel> ll2 = allsalespersons.OrderBy(r => r.LastName).ThenBy(r => r.FirstName).ToList();
            List<SelectListItem> sl2 = new List<SelectListItem>();
            foreach (EmployeeCustomerAssociaitionModel s in ll2)
            {
                SelectListItem mylistitem = new SelectListItem();
                mylistitem.Text = s.FirstName + " " + s.LastName;
                mylistitem.Value = s.employeePK.ToString();
                sl2.Add(mylistitem);
            }
            x.SalesPersons = sl2.Union(slina);

            //   var allparents = (from a in dbcontext.Customers select a).ToList();


            //////////////////////////////////
            //// for parent dropdown
            ////////////////////////////////
            List<SelectListItem> sli = new List<SelectListItem>();
            sli.Add(new SelectListItem { Value = (-1).ToString(), Text = "«« Parent »»" });
            sli.Add(new SelectListItem { Value = (0).ToString(), Text = "«« Single User »»" });
            x.Parents = allparents.ToList().Select(r => new SelectListItem
            {
                Value = r.CustomerPK.ToString(),
                Text = r.Name.ToString()
            }).Union(sli);


            if (selectedparent.FirstOrDefault().CustomerFK == selectedparent.FirstOrDefault().CustomerParentFK) //self -- single user
            {
                //self -- single user
                x.SelectedParentID = 0;
            }
            else


                if (selectedparent.FirstOrDefault().CustomerParentFK == null) //parent
                {
                    //parent
                    x.SelectedParentID = -1;

                }
                else
                {
                    x.SelectedParentID = selectedparent.ToList().FirstOrDefault().CustomerParentFK.Value;
                }





            //////////////////////////////////
            //// for billtype dropdown
            ////////////////////////////////

            x.BillTypes = allbilltypes.ToList().Select(r => new SelectListItem
            {
                Value = r.BillTypePK.ToString(),
                Text = r.BillType1.ToString()
            });


            x.SelectedBillTypeID = x.CustomerAccount.selectedBillTypeid;


            //List<Customer> ll3 = allparents.ToList();
            //List<SelectListItem> sl3 = new List<SelectListItem>();
            //foreach (Customer s in ll3)
            //{
            //    SelectListItem mylistitem = new SelectListItem();
            //    mylistitem.Text = s.Name + "(" + s.CustomerPK + ")";
            //    mylistitem.Value = s.CustomerPK.ToString();
            //    sl3.Add(mylistitem);
            //}
            //x.Parents = sl3;

            return View(x);


        }


        //[HttpPost]
        //public JsonResult doesUserNameExist(string UserID)
        //{

        //    Semplest dbcontext = new SemplestModel.Semplest();

        //    var users = from c in dbcontext.Credentials
        //                where c.Username.Equals(UserID)
        //                select c;
        //    return Json(users == null);
        //}





        [HttpPost]
        public ActionResult Edit(CustomerAccountWithEmployeeModel m, string command)
        {
            //for cancel just redirect to main page
            if (command.ToLower() == "cancel") return RedirectToAction("Index");
            
            if (command.ToLower() == "delete") return RedirectToAction("Remove", new {id=m.CustomerAccount.AccountNumber});

            SemplestModel.Semplest dbcontext = new SemplestModel.Semplest();

            
            //check if userid has been taken by other users

                  var userIDSs = from c in dbcontext.Credentials
                        where c.Username.Equals(m.CustomerAccount.UserID) && !c.UsersFK.Equals(m.CustomerAccount.UserPK)
                        select c;

                  if (userIDSs.Count() > 0)
                      ModelState.AddModelError("CustomerAccount.UserID", "This UserID is already taken!!");


            if (!ModelState.IsValid)
            {
                #region needs to repopulate lists to get the same view again

                //repopulate 

                /////////////////////////////////////////////////////////////////////////////////
                //for reps dropdown
                /////////////////////////////////////////////////////////////////////////////////
                var allreps = from e in dbcontext.Employees
                              //join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                              join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                              join u in dbcontext.Users on e.UsersFK equals u.UserPK
                              where (et.EmployeeType1 == "Rep" && u.IsActive.Equals(true))
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

                //repopulate 

                /////////////////////////////////////////////////////////////////////////////////
                //for roles dropdown
                /////////////////////////////////////////////////////////////////////////////////
                var roles = (from r in dbcontext.Roles select r).ToList().OrderBy(r => r.RoleName);

                m.Roles = roles.Select(r => new SelectListItem
                {
                    Value = r.RolePK.ToString(),
                    Text = r.RoleName.ToString()
                });



                /////////////////////////////////////////////////////////////////////////////////
                //for sales dropdown
                /////////////////////////////////////////////////////////////////////////////////
                var allsalespersons = from e in dbcontext.Employees
                                      //join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                                      join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                                      join u in dbcontext.Users on e.UsersFK equals u.UserPK
                                      where (et.EmployeeType1 == "Sales" && u.IsActive.Equals(true))
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

                var allstates = (from sc in dbcontext.StateCodes select sc).ToList();

                m.States = allstates.Select(r => new SelectListItem
                {
                    Value = r.StateAbbrPK.ToString(),
                    Text = r.StateAbbr.ToString()
                });


                List<SelectListItem> slina = new List<SelectListItem>();
                slina.Add(new SelectListItem { Value = (-1).ToString(), Text = "«« Not Assigned »»" });



                List<EmployeeCustomerAssociaitionModel> ll1 = allreps.OrderBy(r => r.LastName).ThenBy(r => r.FirstName).ToList();
                List<SelectListItem> sl1 = new List<SelectListItem>();
                foreach (EmployeeCustomerAssociaitionModel s in ll1)
                {
                    SelectListItem mylistitem = new SelectListItem();
                    mylistitem.Text = s.FirstName + " " + s.LastName;
                    mylistitem.Value = s.employeePK.ToString();
                    sl1.Add(mylistitem);
                }


                m.Reps= sl1.Union(slina);

                



                List<EmployeeCustomerAssociaitionModel> ll2 = allsalespersons.OrderBy(r => r.LastName).ThenBy(r => r.FirstName).ToList();
                List<SelectListItem> sl2 = new List<SelectListItem>();
                foreach (EmployeeCustomerAssociaitionModel s in ll2)
                {
                    SelectListItem mylistitem = new SelectListItem();
                    mylistitem.Text = s.FirstName + " " + s.LastName;
                    mylistitem.Value = s.employeePK.ToString();
                    sl2.Add(mylistitem);
                }
                m.SalesPersons = sl2.Union(slina);




              var allparents =
              from c in dbcontext.Customers
              join chi in dbcontext.CustomerHierarchies.Where(p=>p.CustomerParentFK == null) on c.CustomerPK equals chi.CustomerFK
              select c;




                List<SelectListItem> sli = new List<SelectListItem>();
                sli.Add(new SelectListItem { Value = (-1).ToString(), Text = "«« Parent »»" });
                sli.Add(new SelectListItem { Value = (0).ToString(), Text = "«« Single User »»" });
                m.Parents = allparents.ToList().Select(r => new SelectListItem
                {
                    Value = r.CustomerPK.ToString(),
                    Text = r.Name.ToString()
                }).Union(sli);



                var allbilltypes =
                    from bt in dbcontext.BillTypes
                    select bt;
				



                m.BillTypes = allbilltypes.ToList().Select(r => new SelectListItem
                {
                    Value = r.BillTypePK.ToString(),
                    Text = r.BillType1.ToString()
                });

                #endregion
                return View(m);
            }


            var user = dbcontext.Users.ToList().Find(p => p.UserPK == m.CustomerAccount.UserPK);
            user.FirstName = m.CustomerAccount.FirstName;
            user.LastName = m.CustomerAccount.LastName;
            user.MiddleInitial = m.CustomerAccount.MiddleInitial;
            user.Email = m.CustomerAccount.Email;
            user.EditedDate = DateTime.Now;
            user.IsActive = m.CustomerAccount.isActive;
            UpdateModel(user);


            var userrolesassociation = dbcontext.UserRolesAssociations.ToList().Find(p => p.UsersFK == m.CustomerAccount.UserPK);
            userrolesassociation.RolesFK = m.SelectedRoleID;
            UpdateModel(userrolesassociation);


            var customer = dbcontext.Customers.ToList().Find(p => p.CustomerPK == m.CustomerAccount.AccountNumber);
            var customeraddressassociation = dbcontext.CustomerAddressAssociations.ToList().Find(p => p.CustomerFK == customer.CustomerPK);
            var address = dbcontext.Addresses.ToList().Find(p => p.AddressPK == customeraddressassociation.AddressFK);


            customer.Name = m.CustomerAccount.Customer;
            customer.BillTypeFK = m.SelectedBillTypeID;
            customer.PercentOfMedia = m.CustomerAccount.PercentMedia;
            customer.InternalCustomerId = m.CustomerAccount.internalID;
            customer.ServiceFee = m.CustomerAccount.ServiceFee;
            customer.PromotionFeeAmount = m.CustomerAccount.PromotionFeeAmount;
            customer.PromotionFeeOverride = m.CustomerAccount.PromotionFeeOverride;
            customer.CreditLimit = m.CustomerAccount.CreditLimit;



            address.Address1 = m.CustomerAccount.Address1;
            address.Address2 = m.CustomerAccount.Address2;
            address.City = m.CustomerAccount.City;
            address.ZipCode = m.CustomerAccount.Zip;
            address.EditedDate = DateTime.Now;
            address.StateAbbrFK = m.SelectedStateID;

            var customerphoneassociation = dbcontext.CustomerPhoneAssociations.ToList().Find(p => p.CustomerFK == m.CustomerAccount.AccountNumber);
            var phone = dbcontext.Phones.ToList().Find(p => p.PhonePK == customerphoneassociation.PhoneFK);

            phone.Phone1 = m.CustomerAccount.Phone;


            var rep = from c in dbcontext.Customers
                      join eca in dbcontext.EmployeeCustomerAssociations on c.CustomerPK equals eca.CustomerFK
                      join e in dbcontext.Employees on eca.EmployeeFK equals e.EmployeePK
                      join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                      where (c.CustomerPK == m.CustomerAccount.AccountNumber && et.EmployeeType1.ToLower() == "rep")
                      select new ECAModel
                      {
                          CustomerPK = c.CustomerPK,
                          EmployeePK = e.EmployeePK
                      };

            var sales = from c in dbcontext.Customers
                        join eca in dbcontext.EmployeeCustomerAssociations on c.CustomerPK equals eca.CustomerFK
                        join e in dbcontext.Employees on eca.EmployeeFK equals e.EmployeePK
                        join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                        where (c.CustomerPK == m.CustomerAccount.AccountNumber && et.EmployeeType1.ToLower() == "sales")
                        select new ECAModel
                        {
                            CustomerPK = c.CustomerPK,
                            EmployeePK = e.EmployeePK
                        };

            //rep.ToList().First().EmployeePK = m.SelectedRepID;
            //sales.ToList().First().EmployeePK = m.SelectedSalesPersonID;
            var credentials = dbcontext.Credentials.ToList().Find(p => p.UsersFK == m.CustomerAccount.UserPK);
            credentials.Username = m.CustomerAccount.UserID;
            credentials.Password = m.CustomerAccount.UserPassword;

            var employeesales = dbcontext.EmployeeCustomerAssociations.ToList().Find(p => p.CustomerFK == m.CustomerAccount.AccountNumber && p.EmployeeFK == (sales.ToList().FirstOrDefault()==null?-1: sales.ToList().FirstOrDefault().EmployeePK) );
            if (employeesales == null && m.SelectedSalesPersonID !=-1)
            {
                //add one
                var addemployeesales=new EmployeeCustomerAssociation {  CustomerFK=m.CustomerAccount.AccountNumber  , EmployeeFK = m.SelectedSalesPersonID  };
                dbcontext.EmployeeCustomerAssociations.Add(addemployeesales);
            }
            else if (employeesales != null && m.SelectedSalesPersonID == -1)
            { 
                //remove
                dbcontext.EmployeeCustomerAssociations.Remove(employeesales);
            }
            else if (employeesales != null  && m.SelectedSalesPersonID != -1)
            {
                employeesales.EmployeeFK = m.SelectedSalesPersonID;
                UpdateModel(employeesales);
            }
            
            var employeerep = dbcontext.EmployeeCustomerAssociations.ToList().Find(p => p.CustomerFK == m.CustomerAccount.AccountNumber && p.EmployeeFK == (rep.ToList().FirstOrDefault()==null?-1: rep.ToList().FirstOrDefault().EmployeePK) );
            if (employeerep == null && m.SelectedRepID !=-1)
            {
                //add one
                var addemployeerep =new EmployeeCustomerAssociation {  CustomerFK=m.CustomerAccount.AccountNumber  , EmployeeFK = m.SelectedRepID };
                dbcontext.EmployeeCustomerAssociations.Add(addemployeerep);

            }
            else if (employeerep != null && m.SelectedRepID == -1)
                {
                    //remove
                    dbcontext.EmployeeCustomerAssociations.Remove(employeerep);
                }
        else if (employeerep != null  && m.SelectedRepID  != -1)
                {
                    employeerep.EmployeeFK = m.SelectedRepID;
                    UpdateModel(employeerep);
                }


            

            //var employeecustomerassociation = dbcontext.EmployeeCustomerAssociations.ToList().Find(p => p.CustomerFK  == customer.CustomerPK && p.EmployeeFK==1);

            //employeecustomerassociation.
            //employeecustomerassociation.EmployeeCustomerAssociationPK

            UpdateModel(address);
            var customernote = dbcontext.CustomerNotes.ToList().FirstOrDefault(p => p.CustomerFK == m.CustomerAccount.AccountNumber);
            customernote.Note = m.CustomerAccount.CustomerNote;
            UpdateModel(customernote);


            var parents = dbcontext.CustomerHierarchies.FirstOrDefault(p => p.CustomerFK == m.CustomerAccount.AccountNumber);
            //var parents = dbcontext.CustomerHierarchies.FirstOrDefault();

            if (m.SelectedParentID == 0) //self -- single user
            {
                parents.CustomerParentFK = parents.CustomerFK;
            }
            else if (m.SelectedParentID == -1) //parent
            {
                parents.CustomerParentFK = null;
            }
            else
            {
                parents.CustomerParentFK = m.SelectedParentID;
            }

            dbcontext.SaveChanges();

            return RedirectToAction("Index");
            //return View("index");
            //return View(m);
        }



        public ActionResult Add()
        {

            SemplestModel.Semplest dbcontext = new SemplestModel.Semplest();
            /////////////////////////////////////////////////////////////////////////////////
            //for reps dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allreps = from e in dbcontext.Employees
                          //join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                          join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                          join u in dbcontext.Users on e.UsersFK equals u.UserPK
                          where (et.EmployeeType1 == "Rep" && u.IsActive.Equals(true))
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
                                  where (et.EmployeeType1 == "Sales" && u.IsActive.Equals(true))
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
            //for roles dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var roles = (from r in dbcontext.Roles select r).ToList().OrderBy(r => r.RoleName);
            x.SelectedRoleID = -1;
            x.Roles = roles.Select(r => new SelectListItem
            {
                Value = r.RolePK.ToString(),
                Text = r.RoleName.ToString()
            });





            /////////////////////////////////////////////////////////////////////////////////
            //for parents dropdown
            /////////////////////////////////////////////////////////////////////////////////
            //var allparents = (from a in dbcontext.Customers select a).ToList();
            var allparents =
              from c in dbcontext.Customers
              join chi in dbcontext.CustomerHierarchies.Where(p=>p.CustomerParentFK == null) on c.CustomerPK equals chi.CustomerFK
              select c;

            List<SelectListItem> sli = new List<SelectListItem>();
            sli.Add(new SelectListItem { Value = (-1).ToString(), Text = "«« Parent »»" });
            sli.Add(new SelectListItem { Value = (0).ToString(), Text = "«« Single User »»" });
            x.Parents = allparents.ToList().Select(r => new SelectListItem
            {
                Value = r.CustomerPK.ToString(),
                Text = r.Name.ToString()
            }).Union(sli);







            /////////////////////////////////////////////////////////////////////////////////
            //for billtype dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allbilltypes = (from a in dbcontext.BillTypes select a).ToList();

            x.SelectedBillTypeID = 1;
            x.BillTypes = allbilltypes.Select(r => new SelectListItem
            {
                Value = r.BillTypePK.ToString(),
                Text = r.BillType1.ToString()
            });


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

            List<SelectListItem> slina = new List<SelectListItem>();
            slina.Add(new SelectListItem { Value = (-1).ToString(), Text = "«« Not Assigned »»" });


            //x.Reps=allreps.Select(r=>new SelectListItem 
            //            {
            //                Value=r.employeePK.ToString() ,
            //                 Text=r.FirstName
            //            });

            //workaround below (same as for state dropdown but with lists, in order to get over the error i get above) ; need to refactor later!!
            List<EmployeeCustomerAssociaitionModel> ll1 = allreps.OrderBy(r => r.LastName).ThenBy(r => r.FirstName).ToList(); ;
            List<SelectListItem> sl1 = new List<SelectListItem>();
            foreach (EmployeeCustomerAssociaitionModel s in ll1)
            {
                SelectListItem mylistitem = new SelectListItem();
                mylistitem.Text = s.FirstName + " " + s.LastName;
                mylistitem.Value = s.employeePK.ToString();
                sl1.Add(mylistitem);
            }
            x.Reps = sl1.Union(slina);



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
            List<EmployeeCustomerAssociaitionModel> ll2 = allsalespersons.OrderBy(r => r.LastName).ThenBy(r => r.FirstName).ToList();
            List<SelectListItem> sl2 = new List<SelectListItem>();
            foreach (EmployeeCustomerAssociaitionModel s in ll2)
            {
                SelectListItem mylistitem = new SelectListItem();
                mylistitem.Text = s.FirstName + " " + s.LastName;
                mylistitem.Value = s.employeePK.ToString();
                sl2.Add(mylistitem);
            }
            x.SalesPersons = sl2.Union(slina);
            
            x.CustomerAccount = new CustomerAccount();
            x.CustomerAccount.UserPassword = Semplest.SharedResources.Helpers.RandomPassword.Generate(8,10);
            x.CustomerAccount.isActive = true;

            return View(x);
        }



        [HttpPost]
        public ActionResult Add(CustomerAccountWithEmployeeModel m, string command, FormCollection fc )
        {
            
            if (command.ToLower() == "cancel") return RedirectToAction("Index");


            SemplestModel.Semplest dbcontext = new SemplestModel.Semplest();

            


            //check if userid has been taken by other users

            var userIDSs = from c in dbcontext.Credentials
                        where c.Username.Equals(m.CustomerAccount.UserID) 
                        select c;
            if (userIDSs.Count() > 0)
                      ModelState.AddModelError("CustomerAccount.UserID", "This UserID is already taken!!");

               
                  if (!ModelState.IsValid)
                  {
                      //repopulate 
                   #region needs to repopulate lists to get the same view again

                      var roles = (from r in dbcontext.Roles select r).ToList().OrderBy(r => r.RoleName);

                      m.Roles = roles.Select(r => new SelectListItem
                      {
                          Value = r.RolePK.ToString(),
                          Text = r.RoleName.ToString()
                      });




                      //repopualte

                      var allreps = from e in dbcontext.Employees
                                    //join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                                    join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                                    join u in dbcontext.Users on e.UsersFK equals u.UserPK
                                    where (et.EmployeeType1 == "Rep" && u.IsActive.Equals(true))
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
                                            where (et.EmployeeType1 == "Sales" && u.IsActive.Equals(true))
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


                      var allparents =
              from c in dbcontext.Customers
              join chi in dbcontext.CustomerHierarchies.Where(p => p.CustomerParentFK == null) on c.CustomerPK equals chi.CustomerFK
              select c;

                      List<SelectListItem> sli = new List<SelectListItem>();


                      sli.Add(new SelectListItem { Value = (-1).ToString(), Text = "«« Parent »»" });
                      sli.Add(new SelectListItem { Value = (0).ToString(), Text = "«« Single User   »»" });

                      //x.SelectedParentID = -1;

                      m.Parents = allparents.ToList().Select(r => new SelectListItem
                      {
                          Value = r.CustomerPK.ToString(),
                          Text = r.Name.ToString()
                      }).Union(sli);



                      /////////////////////////////////////////////////////////////////////////////////
                      //for billtype dropdown
                      /////////////////////////////////////////////////////////////////////////////////
                      var allbilltypes = (from a in dbcontext.BillTypes select a).ToList();

                      
                      m.BillTypes = allbilltypes.Select(r => new SelectListItem
                      {
                          Value = r.BillTypePK.ToString(),
                          Text = r.BillType1.ToString()
                      });




                      //for state dropdown
                      /////////////////////////////////////////////////////////////////////////////////
                      var allstates = (from sc in dbcontext.StateCodes select sc).ToList();
                      
                      m.States = allstates.Select(r => new SelectListItem
                      {
                          Value = r.StateAbbrPK.ToString(),
                          Text = r.StateAbbr.ToString()
                      });


                      List<SelectListItem> slina = new List<SelectListItem>();
                      slina.Add(new SelectListItem { Value = (-1).ToString(), Text = "«« Not Assigned »»" });



                      List<EmployeeCustomerAssociaitionModel> ll1 = allreps.OrderBy(r => r.LastName).ThenBy(r => r.FirstName).ToList(); ;
                      List<SelectListItem> sl1 = new List<SelectListItem>();
                      foreach (EmployeeCustomerAssociaitionModel s in ll1)
                      {
                          SelectListItem mylistitem = new SelectListItem();
                          mylistitem.Text = s.FirstName + " " + s.LastName;
                          mylistitem.Value = s.employeePK.ToString();
                          sl1.Add(mylistitem);
                      }
                      m.Reps = sl1.Union(slina);


                      List<EmployeeCustomerAssociaitionModel> ll2 = allsalespersons.OrderBy(r => r.LastName).ThenBy(r => r.FirstName).ToList();
                      List<SelectListItem> sl2 = new List<SelectListItem>();
                      foreach (EmployeeCustomerAssociaitionModel s in ll2)
                      {
                          SelectListItem mylistitem = new SelectListItem();
                          mylistitem.Text = s.FirstName + " " + s.LastName;
                          mylistitem.Value = s.employeePK.ToString();
                          sl2.Add(mylistitem);
                      }
                      m.SalesPersons = sl2.Union(slina);
                      return View(m);     
   #endregion
                  }

             

            try
            {
                


                //BillType bt = dbcontext.BillTypes.First(p => p.BillType1 == "Flat Fee"); // --- feees --- !!!
                //revisit 
                ProductGroupCycleType pgct = dbcontext.ProductGroupCycleTypes.First(p => p.ProductGroupCycleType1 == "Product Group Cycle 30");

                var c = new Customer
                            { 
                                Name = m.CustomerAccount.Customer,
                                BillTypeFK = m.SelectedBillTypeID,
                                ProductGroupCycleType = pgct,
                                 PercentOfMedia=m.CustomerAccount.PercentMedia,
                                 ServiceFee= m.CustomerAccount.ServiceFee,
                                  InternalCustomerId= m.CustomerAccount.internalID,
                                PromotionFeeAmount = m.CustomerAccount.PromotionFeeAmount,
                                CreditLimit=m.CustomerAccount.CreditLimit,
                                PromotionFeeOverride=m.CustomerAccount.PromotionFeeOverride 
                            };

                dbcontext.Customers.Add(c);

                var u = new User
                            {
                                Customer = c,
                                Email = m.CustomerAccount.Email,
                                FirstName = m.CustomerAccount.FirstName,
                                LastName = m.CustomerAccount.LastName,
                                MiddleInitial = m.CustomerAccount.MiddleInitial,
                                IsActive = m.CustomerAccount.isActive
                            };
                dbcontext.Users.Add(u);

                var r = dbcontext.Roles.First(p => p.RolePK == m.SelectedRoleID);
                var ura = new UserRolesAssociation { Role = r, User = u };
                dbcontext.UserRolesAssociations.Add(ura);


                //
                var cr = new Credential
                             { 
                                 User = u,
                                 UsersFK = u.UserPK,
                                 Username = m.CustomerAccount.UserID,
                                 Password = m.CustomerAccount.UserPassword
                             };
                dbcontext.Credentials.Add(cr);


                PhoneType pt = dbcontext.PhoneTypes.First(p => p.PhoneType1 == "Business"); // --- phone types --- !!!!
                var ph = new Phone {Phone1 = m.CustomerAccount.Phone, PhoneType = pt};
                dbcontext.Phones.Add(ph);

                var cpa = new CustomerPhoneAssociation {Customer = c, Phone = ph};
                dbcontext.CustomerPhoneAssociations.Add(cpa);

                var sc = dbcontext.StateCodes.First(p => p.StateAbbrPK == m.SelectedStateID);
                var at = dbcontext.AddressTypes.First(p => p.AddressType1 == "H"); // --- address types --- !!!

                var a = new Address
                            {
                                Address1 = m.CustomerAccount.Address1,
                                Address2 = m.CustomerAccount.Address2,
                                City = m.CustomerAccount.City,
                                ZipCode = m.CustomerAccount.Zip,
                                StateCode = sc
                            };
                dbcontext.Addresses.Add(a);

                var caa = new CustomerAddressAssociation {Address = a, Customer = c, AddressType = at};
                dbcontext.CustomerAddressAssociations.Add(caa);

                var cn = new CustomerNote {Customer = c, Note = m.CustomerAccount.CustomerNote};
                dbcontext.CustomerNotes.Add(cn);

                
                //don't add if not assigned
                if (m.SelectedRepID != -1)
                {
                    var addrep = new EmployeeCustomerAssociation { Customer = c, EmployeeFK = m.SelectedRepID };
                    dbcontext.EmployeeCustomerAssociations.Add(addrep);
                }
                
                //don't add if not assigned
                if (m.SelectedSalesPersonID != -1)
                {
                    var addsales = new EmployeeCustomerAssociation { Customer = c, EmployeeFK = m.SelectedSalesPersonID };
                    dbcontext.EmployeeCustomerAssociations.Add(addsales);
                }

                CustomerHierarchy ch = null;
                if (m.SelectedParentID == -1) //set parent
                {
                    ch = new CustomerHierarchy {CustomerFK = c.CustomerPK, CustomerParentFK = null};
                    dbcontext.CustomerHierarchies.Add(ch);
                }
                else if (m.SelectedParentID == 0) //set self -- single user
                {
                    ch = new CustomerHierarchy {CustomerFK = c.CustomerPK, CustomerParentFK = c.CustomerPK};
                    dbcontext.CustomerHierarchies.Add(ch);
                }
                else //assign a parent
                {
                    ch = new CustomerHierarchy {CustomerFK = c.CustomerPK, CustomerParentFK = m.SelectedParentID};
                    dbcontext.CustomerHierarchies.Add(ch);
                }
                dbcontext.SaveChanges();

                /////////////////////////////////////////////////////////////////////////////
                ///// sending of emails

                if (fc["sendcustomeremail"] != null)
                {

                    string from, to, body, subject;

                    //send email to child customers
                    //if  child customer
                    if (m.SelectedParentID >0)
                    {
                        var emailtemplate = (from et in dbcontext.EmailTemplates
                                             where et.EmailTemplatePK.Equals(13)
                                             select et).FirstOrDefault();

                        var parentdetails = from usr in dbcontext.Users
                                            join cus in dbcontext.Customers on usr.CustomerFK equals cus.CustomerPK
                                            where usr.CustomerFK == m.SelectedParentID
                                            select new { usr.CustomerFK, usr.Email, cus.Name };

                        //send mail //revisit
                        from = "accounts@semplest.com";
                        to = u.Email;
                        body = emailtemplate.EmailBody;
                        //parent name in subject line
                        subject = parentdetails.FirstOrDefault().Name + " " +emailtemplate.EmailSubject;
                        body = body.Replace("[ChildCustomerFirstLast]", u.FirstName.ToString() + " " + u.LastName.ToString());
                        body = body.Replace("[ParentCustomerName]", parentdetails.FirstOrDefault().Name.ToString());
                        body = body.Replace("[FAQs]", "http://faq");
                        body = body.Replace("[ChildCustomerUserID]", cr.Username.ToString());
                        body = body.Replace("[ChildCustomerPassword]", cr.Password.ToString());
                        body = body.Replace("[INSERT LINK]", "http://encrypto");
                        bool sent = false;
                        ServiceClientWrapper scw = new ServiceClientWrapper();
                        sent = scw.SendEmail(subject, from, to, body);
                    }


                    if (m.SelectedParentID == -1) ///set parent
                    {

                        var emailtemplate = (from et in dbcontext.EmailTemplates
                                             where et.EmailTemplatePK.Equals(14)
                                             select et).FirstOrDefault();

                        
                        //send mail //revisit
                        from = "accounts@semplest.com";
                        to = u.Email;
                        body = emailtemplate.EmailBody;
                        subject = emailtemplate.EmailSubject;
                        

                        
                        body = body.Replace("[ParentCustomerName]", c.Name.FirstOrDefault().ToString());
                        body = body.Replace("[ParentCustomerUserID]", cr.Username.ToString());
                        body = body.Replace("[ParentCustomerPassword]", cr.Password.ToString());
                        body = body.Replace("[INSERT LINK]", "http://encrypto");
                        body = body.Replace("[DefaultEmailContactUS]", dbcontext.Configurations.First().DefaultEmailContactUs.ToString());
                        bool sent = false;
                        ServiceClientWrapper scw = new ServiceClientWrapper();
                        sent = scw.SendEmail(subject, from, to, body);
                    }



                    
                    if (m.SelectedParentID ==0) // non child parent customer - self
                    {

                        var emailtemplate = (from et in dbcontext.EmailTemplates
                                             where et.EmailTemplatePK.Equals(25)
                                             select et).FirstOrDefault();


                        //send mail //revisit
                        from = "accounts@semplest.com";
                        to = u.Email;
                        body = emailtemplate.EmailBody;
                        subject = emailtemplate.EmailSubject;
                        body = body.Replace("[NonParentCustomer]", u.FirstName.ToString() + " " + u.LastName.ToString());
                        body = body.Replace("[NonParentCustomerUserID]", cr.Username.ToString());
                        body = body.Replace("[NonParentCustomerPassword]", cr.Password.ToString());
                        body = body.Replace("[INSERT LINK]", "http://encrypto");
                        bool sent = false;
                        ServiceClientWrapper scw = new ServiceClientWrapper();
                        sent = scw.SendEmail(subject, from, to, body);
                    }
                    //SendEmail


                }

            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.TargetSite);
            }


            return RedirectToAction("Index");
        }



        public ActionResult Delete(int id)
        {

            SemplestModel.Semplest dbcontext = new SemplestModel.Semplest();

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
                    CustomerNote = (n.Note == null ? null : n.Note),
                    isActive = u.IsActive
                };

            CustomerAccountWithEmployeeModel x = new CustomerAccountWithEmployeeModel();
            x.CustomerAccount = viewModel.Single(c => c.AccountNumber == id);


            return PartialView(x);
            //return RedirectToAction("Index");
        }

        [HttpPost]
        public ActionResult Delete(CustomerAccountWithEmployeeModel m, string command)
        {
            SemplestModel.Semplest dbcontext = new SemplestModel.Semplest();
            //Semplest context = new SemplestModel.Semplest();


            if (command.ToLower() == "cancel") return RedirectToAction("Index");
            if (command.ToLower() == "delete")
            {

                try
                {

                    var user = dbcontext.Users.ToList().Find(p => p.UserPK == m.CustomerAccount.UserPK);


                    var customer = dbcontext.Customers.ToList().Find(p => p.CustomerPK == m.CustomerAccount.AccountNumber);
                    var customeraddressassociation = dbcontext.CustomerAddressAssociations.ToList().Find(p => p.CustomerFK.Equals(m.CustomerAccount.AccountNumber));
                    var address = dbcontext.Addresses.ToList().Find(p => p.AddressPK.Equals(customeraddressassociation.AddressFK));
                    var customernotes = dbcontext.CustomerNotes.ToList().Find(p => p.CustomerFK.Equals(m.CustomerAccount.AccountNumber));

                    var employeecustomerassociation = dbcontext.EmployeeCustomerAssociations.ToList();
                    //var employeecustomerassociation = dbcontext.EmployeeCustomerAssociations.ToList().Find(p => p.CustomerFK.Equals(m.CustomerAccount.AccountNumber));
                    //var employeecustomerassociation = from x in dbcontext.EmployeeCustomerAssociations 
                    //                                where x.CustomerFK.Equals(m.CustomerAccount.AccountNumber)


                    var customerstyle = dbcontext.CustomerStyles.ToList().Find(p => p.CustomerFK.Equals(m.CustomerAccount.AccountNumber));
                    var customerphoneassociation = dbcontext.CustomerPhoneAssociations.ToList().Find(p => p.CustomerFK.Equals(m.CustomerAccount.AccountNumber));
                    var phone = dbcontext.Phones.ToList().Find(p => p.PhonePK.Equals(customerphoneassociation.PhoneFK));
                    var credentials = dbcontext.Credentials.ToList().Find(p => p.UsersFK.Equals(m.CustomerAccount.UserPK));
                    var userrolesassociation = dbcontext.UserRolesAssociations.ToList().Find(p => p.UsersFK.Equals(m.CustomerAccount.UserPK));
                    var customerhierarchy = dbcontext.CustomerHierarchies.ToList().Find(p => p.CustomerFK.Equals(m.CustomerAccount.AccountNumber));


                    var productgroup = dbcontext.ProductGroups.ToList().Find(p => p.CustomerFK.Equals(customer.CustomerPK));
                    if (productgroup != null) throw new Exception("Could not delete customer");


                    //UPDATE: no need to check for promotion, won't be deleting any customer that has a productgroup assigned!!!
                    //var promotion = dbcontext.Promotions.ToList().Find(p => p.ProductGroupFK.Equals(productgroup.ProductGroupPK));
                    //if (promotion != null) throw new Exception("Could not delete customer");


                    //Message = "The operation failed: The relationship could not be changed because one or more of the foreign-key properties is non-nullable. When a change is made to a relationship, the related foreign-key property is set to a null value. If the foreign-key does not sup...
                    //dbcontext.Customers.Remove(customer);
                    //dbcontext.Users.Remove(user);
                    //dbcontext.EmployeeCustomerAssociations.Remove(employeecustomerassociation);
                    //if (customerstyle!=null)
                    //    dbcontext.CustomerStyles.Remove(customerstyle);
                    //dbcontext.CustomerPhoneAssociations.Remove(customerphoneassociation);
                    //dbcontext.Phones.Remove(phone);
                    //dbcontext.Credentials.Remove(credentials);
                    //if(userrolesassociation!=null)
                    //    dbcontext.UserRolesAssociations.Remove(userrolesassociation);

                    //workaround for deletion:


                    var caa = customeraddressassociation;
                    var a = address;
                    var cn = customernotes;

                    dbcontext.CustomerAddressAssociations.Remove(caa);
                    dbcontext.Addresses.Remove(a);
                    dbcontext.CustomerNotes.Remove(cn);


                    //EmployeeCustomerAssociation eca = employeecustomerassociation;
                    //dbcontext.EmployeeCustomerAssociations.Remove(eca);

                    foreach (EmployeeCustomerAssociation c1 in employeecustomerassociation)
                    {
                        if (c1.CustomerFK.Equals(m.CustomerAccount.AccountNumber))
                        {
                            dbcontext.EmployeeCustomerAssociations.Remove(c1);
                        }
                    }


                    var c = customer;
                    dbcontext.Customers.Remove(c);

                    var cr = credentials;
                    dbcontext.Credentials.Remove(cr);

                    var u = user;
                    dbcontext.Users.Remove(u);

                    var cpa = customerphoneassociation;
                    dbcontext.CustomerPhoneAssociations.Remove(cpa);

                    var ph = phone;
                    dbcontext.Phones.Remove(ph);


                    if (customerstyle != null)
                    {
                        var cs = customerstyle;
                        dbcontext.CustomerStyles.Remove(cs);
                    }

                    if (userrolesassociation != null)
                    {
                        var ura = userrolesassociation;
                        dbcontext.UserRolesAssociations.Remove(ura);
                    }

                    var ch = customerhierarchy;
                    dbcontext.CustomerHierarchies.Remove(ch);

                    dbcontext.SaveChanges();

                    TempData["message"] = "Customer Account #" + m.CustomerAccount.AccountNumber + " (" + m.CustomerAccount.Customer + ") has been successfully deleted.";
                }

                catch (Exception ex)
                {
                    TempData["message"] = "Customer Account #" + m.CustomerAccount.AccountNumber + " (" + m.CustomerAccount.Customer + ") could NOT be deleted.";
                }



            }
            //return View();
            return RedirectToAction("Index");
        }


    }
}
