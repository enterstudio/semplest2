using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestAdminApp.Models;
using System.Data.Entity.Validation;



namespace SemplestAdminApp.Controllers
{
    [LoggingHandleErrorAttribute]
    public class EmployeeSetupController : Controller
    {

        public ActionResult Add()
        {
            SemplestEntities dbcontext = new SemplestEntities();
          

            EmployeeSetupWithRolesModel x = new EmployeeSetupWithRolesModel();
          

            /////////////////////////////////////////////////////////////////////////////////
            //for roles dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var roles = (from r in dbcontext.Roles select r).ToList();
            x.SelectedRoleID = -1;
            x.Roles = roles.Select(r => new SelectListItem
            {
                Value = r.RolePK.ToString(),
                Text = r.RoleName.ToString()
            });


            /////////////////////////////////////////////////////////////////////////////////
            //for Reportingto dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var reportingto = (
                from e in dbcontext.Employees
                join u in dbcontext.Users on e.UsersFK equals u.UserPK
                select new ReportingToModel
                {
                    EmployeePK = e.EmployeePK,
                    FirstName = u.FirstName,
                    LastName = u.LastName
                }
                ).ToList();
            x.SelectedReportingToID = -1;


            //to add exception to dropdownlist - it can be optional, in this case the employee reporting to may be optional
            List<SelectListItem> sli = new List<SelectListItem>();
            sli.Add(new SelectListItem { Value = (-1).ToString(), Text = "Nobody" });


            x.ReportingTo = reportingto.Select(r => new SelectListItem
            {
                Value = r.EmployeePK.ToString(),
                Text = r.FirstName.ToString() + " " + r.FirstName.ToString()
            }).Union(sli);

            /////////////////////////////////////////////////////////////////////////////////
            // for employeetype dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var employeetypes = (from r in dbcontext.EmployeeTypes select r).ToList();
            x.SelectedEmployeeTypeID = -1; //viewModel.Select(r => r.EmployeeTypeID).FirstOrDefault();
            x.EmployeeTypes = employeetypes.Select(r => new SelectListItem
            {
                Value = r.EmployeeTypeID.ToString(),
                Text = r.EmployeeType1.ToString()
            });

            //return View(x);
            return View(x);

        }

        public ActionResult Index(string search)
        {
            //ViewBag.Message = "Welcome to SEMPLEST ADMIN!";
            SemplestEntities dbcontext = new SemplestEntities();
            //FUTURE: add rearch by email and by account number || u.Email.Contains(emailsearch)
            //if (search == null) search = "";

            var viewModel =
               from e in dbcontext.Employees
               join u in dbcontext.Users on e.UsersFK equals u.UserPK
               join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
               join ura in dbcontext.UserRolesAssociations on e.UsersFK equals ura.UsersFK
               join r in dbcontext.Roles on ura.RolesFK equals r.RolePK
               where (u.FirstName.ToLower().Contains(search.ToLower())||u.LastName.ToLower().Contains(search.ToLower())||u.Email.ToLower().Contains(search.ToLower()))
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
                   ReportingTo = (e.ReportingTo == null ? -1 : e.ReportingTo.Value)
               };
            return View(viewModel);
        }


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
                    ReportingTo=(e.ReportingTo==null?-1:e.ReportingTo.Value)
               };

            EmployeeSetupWithRolesModel x = new EmployeeSetupWithRolesModel();
            x.EmployeeSetup = viewModel.FirstOrDefault(c => c.UserPK.Equals(id));
             

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
            //for Reportingto dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var reportingto = (
                from e in dbcontext.Employees
                join u in dbcontext.Users on e.UsersFK equals u.UserPK
                select new ReportingToModel 
                {
                     EmployeePK =e.EmployeePK,
                     FirstName=u.FirstName,
                     LastName=u.LastName 
                }
                ).ToList();
            x.SelectedReportingToID= viewModel.Select(r => r.ReportingTo).FirstOrDefault();


            //to add exception to dropdownlist - it can be optional, in this case the employee reporting to may be optional
            List<SelectListItem> sli = new List<SelectListItem>();
            sli.Add(new SelectListItem { Value = (-1).ToString(), Text = "Nobody" });


            x.ReportingTo= reportingto.Select(r => new SelectListItem
            {
                Value = r.EmployeePK.ToString(),
                Text = r.FirstName.ToString() + " " + r.FirstName.ToString()
            }).Union(sli);

            /////////////////////////////////////////////////////////////////////////////////
            // for employeetype dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var employeetypes = (from r in dbcontext.EmployeeTypes  select r).ToList();
            x.SelectedEmployeeTypeID  = viewModel.Select(r => r.EmployeeTypeID).FirstOrDefault();
            x.EmployeeTypes = employeetypes.Select(r => new SelectListItem
            {
                Value = r.EmployeeTypeID.ToString(),
                Text = r.EmployeeType1.ToString()
            });

            //return View(x);
            return View(x);
        }


        [HttpPost]
        public ActionResult Edit(EmployeeSetupWithRolesModel m)
        {

            SemplestEntities dbcontext = new SemplestEntities();
            
            var user = dbcontext.Users.ToList().Find(p => p.UserPK == m.EmployeeSetup.UserPK);
            user.FirstName = m.EmployeeSetup.FirstName; ;
            user.LastName = m.EmployeeSetup.LastName;
            user.Email = m.EmployeeSetup.Email;
            user.EditedDate = DateTime.Now;
            UpdateModel(user);
            //need to add effective date to db ---><><>

            var employee = dbcontext.Employees.ToList().Find(p => p.UsersFK == m.EmployeeSetup.UserPK);
            employee.EmployeeTypeFK = m.SelectedEmployeeTypeID;
            employee.ReportingTo = m.SelectedReportingToID == -1 ?  default(int?) : m.SelectedReportingToID;
            UpdateModel(employee);

            var userrolesassociation = dbcontext.UserRolesAssociations.ToList().Find(p => p.UsersFK == m.EmployeeSetup.UserPK);
            userrolesassociation.RolesFK = m.SelectedRoleID;
            UpdateModel(userrolesassociation);
            dbcontext.SaveChanges();


            ////repopulate states ddl
            //var states = (from sc in dbcontext.StateCodes select sc).ToList();
            //m.States = states.Select(r => new SelectListItem
            //{
            //    Value = r.StateAbbrPK.ToString(),
            //    Text = r.StateAbbr.ToString()
            //});


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

            //return View("index");

            return RedirectToAction("Index"); 

        }


    }
}
