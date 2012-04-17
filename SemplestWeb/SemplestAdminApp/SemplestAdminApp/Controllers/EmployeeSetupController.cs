using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestAdminApp.Models;
using System.Data.Entity.Validation;



namespace SemplestAdminApp.Controllers
{
    public class EmployeeSetupController : Controller
    {
        //
        // GET: /EmployeeSetup/

        public ActionResult Index()
        {
            return View();
        }


        //public ActionResult Edit()
        //{

        //    return View();
        //}

        public ActionResult Edit(int id)
        {



            SemplestEntities dbcontext = new SemplestEntities();


            /*
             select employeePK, EmployeeTypeFK, UserPK, FirstName, LastName, Email, EmployeeTypeID, RolesFK, RoleName, EmployeeType 
                        from Employee e join 
                        dbo.Users u on e.usersFK=u.UserPk
						join dbo.employeetype et on e.employeetypefk= et.employeetypeid
						join dbo.UserRolesAssociation ura on ura.usersFK=e.usersFK
						join dbo.roles r on r.rolePK = ura.rolesFK

             */

            var viewModel =
               from e in dbcontext.Employees
               join u in dbcontext.Users on e.UsersFK equals u.UserPK
               join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
               join ura in dbcontext.UserRolesAssociations on e.UsersFK equals ura.UsersFK
               join r in dbcontext.Roles on ura.RolesFK equals r.RolePK
               where u.UserPK.Equals(id)
               select new EmployeeSetup
               {
                   EmployeePK = e.EmployeePK,
                   EmployeeTypeFK = e.EmployeeTypeFK,
                   EmployeeTypeID = et.EmployeeTypeID,
                   RolesFK = ura.RolesFK,
                   UserPK = u.UserPK,
                   EmployeeType = e.EmployeeType.EmployeeType1,
                   FirstName = u.FirstName,
                   LastName = u.LastName,
                   RoleName = r.RoleName,
                   Email = u.Email,
               };

            //var viewModel2 =
            //    from e in dbcontext.Employees
            //    join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
            //    join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
            //    join u in dbcontext.Users on e.UsersFK equals u.UserPK
            //    where (eca.CustomerFK == id)
            //    select new EmployeeCustomerAssociaitionModel
            //    {
            //        AccountNumber = eca.CustomerFK,
            //        EmployeeType = et.EmployeeType1,
            //        employeePK = e.EmployeePK,
            //        FirstName = u.FirstName,
            //        LastName = u.LastName,
            //        EmployeeUserPK = u.UserPK
            //    };


            //dropdown
            //var viewModel3 =
            //    from e in dbcontext.Employees
            //    join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
            //    join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
            //    join u in dbcontext.Users on e.UsersFK equals u.UserPK
            //    select new EmployeeDropdownModel
            //    {
            //        ID = e.EmployeePK,
            //        Name=u.FirstName + u.LastName
            //        //AccountNumber = eca.CustomerFK,
            //        //EmployeeType = et.EmployeeType1,
            //        //employeePK = e.EmployeePK,
            //        //FirstName = u.FirstName,
            //        //LastName = u.LastName,
            //        //EmployeeUserPK = u.UserPK
            //    };



            //for reps dropdown
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

            /////////////////////////////////////////////////////////////////////////////////
            //for sales dropdown
            /////////////////////////////////////////////////////////////////////////////////
            //var allsalespersons = from e in dbcontext.Employees
            //                      join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
            //                      join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
            //                      join u in dbcontext.Users on e.UsersFK equals u.UserPK
            //                      where (et.EmployeeType1 == "Sales")
            //                      select new EmployeeCustomerAssociaitionModel
            //                      {
            //                          AccountNumber = eca.CustomerFK,
            //                          employeePK = e.EmployeePK,
            //                          EmployeeType = et.EmployeeType1,
            //                          EmployeeUserPK = u.UserPK,
            //                          FirstName = u.FirstName,
            //                          LastName = u.LastName
            //                      };

            EmployeeSetupWithRolesModel x = new EmployeeSetupWithRolesModel();

            x.EmployeeSetup = viewModel.FirstOrDefault(c => c.UserPK.Equals(id));
            
            
            // x.Roles ...  = 
            // x.SelectedRoleID ... =
            

            /////////////////////////////////////////////////////////////////////////////////
            //for roles dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var roles  = (from r in dbcontext.Roles  select r).ToList();
            x.SelectedRoleID = viewModel.Select(r => r.RolesFK).FirstOrDefault();
            x.Roles = roles.Select(r => new SelectListItem
            {
            Value = r.RolePK.ToString() ,
            Text = r.RoleName.ToString()
            });


            /////////////////////////////////////////////////////////////////////////////////
            //for reps dropdown
            /////////////////////////////////////////////////////////////////////////////////
            ////x.SelectedRepID = viewModel2.Select(r => r.employeePK).FirstOrDefault();

            //x.Reps=allreps.Select(r=>new SelectListItem 
            //            {
            //                Value=r.employeePK.ToString() ,
            //                 Text=r.FirstName
            //            });

            //workaround below (same as for state dropdown but with lists, in order to get over the error) ; need to refactor later!!
            ////List<EmployeeCustomerAssociaitionModel> ll1 = allreps.ToList();
            ////List<SelectListItem> sl1 = new List<SelectListItem>();
            ////foreach (EmployeeCustomerAssociaitionModel s in ll1)
            ////{
            ////    SelectListItem mylistitem = new SelectListItem();
            ////    mylistitem.Text = s.FirstName + " " + s.LastName;
            ////    mylistitem.Value = s.EmployeeUserPK.ToString();
            ////    sl1.Add(mylistitem);
            ////}
            ////x.Reps = sl1;



            /////////////////////////////////////////////////////////////////////////////////
            //for salespersons drowdown
            /////////////////////////////////////////////////////////////////////////////////

            ////x.SelectedSalesPersonID = viewModel2.Select(r => r.employeePK).FirstOrDefault();
            //x.SalesPersons = allreps.Select(r => new SelectListItem
            //{
            //    //Value = r.EmployeeUserPK.ToString(),
            //    Value = r.employeePK.ToString(),
            //    Text = r.FirstName.ToString()
            //});
            //workaround below (same as for state dropdown but with lists, in order to get over the error) ; need to refactor later!!
            ////List<EmployeeCustomerAssociaitionModel> ll2 = allsalespersons.ToList();
            ////List<SelectListItem> sl2 = new List<SelectListItem>();
            ////foreach (EmployeeCustomerAssociaitionModel s in ll2)
            ////{
            ////    SelectListItem mylistitem = new SelectListItem();
            ////    mylistitem.Text = s.FirstName + " " + s.LastName;
            ////    mylistitem.Value = s.EmployeeUserPK.ToString();
            ////    sl2.Add(mylistitem);
            ////}
            ////x.SalesPersons = sl2;



            //return View(x);
            return View(x);


        }
    }
}
