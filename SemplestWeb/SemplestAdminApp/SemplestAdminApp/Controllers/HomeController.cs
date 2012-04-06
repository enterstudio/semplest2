using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestAdminApp.Models;


namespace SemplestAdminApp.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index(string usersearch, string accountnumbersearch, string emailsearch)
        {

            


            ViewBag.Message = "Welcome to SEMPLEST ADMIN!";
            SemplestEntities dbcontext = new SemplestEntities();

            //FUTURE: add rearch by email and by account number || u.Email.Contains(emailsearch)

            var viewModel =
                from u in dbcontext.Users
                join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
                where ((c.Name.Contains(usersearch) || u.FirstName.Contains(usersearch) || u.LastName.Contains(usersearch)) )
                select new HomeModel
                {
                    Customer = c.Name,
                    AccountNumber = c.CustomerPK,
                    FirstName = u.FirstName,
                    LastName = u.LastName,
                    Email = u.Email
                };

            return View(viewModel);
        }







        //public ActionResult GetUsers(string query)
        //{
        //    List<string> users = new List<string>();
        //    using (SemplestEntities dbContext = new SemplestEntities())
        //    {
        //        System.Data.Entity.DbSet dusers = dbContext.Users;
        //        foreach (User du in dusers)
        //        {
        //            users.Add(du.FirstName + " "  + du.LastName);
        //        }
        //    }
        //    var quer = from u in users
        //               where u.ToLower().Contains(query.ToLower())
        //               select u;

        //    return Json(quer);
        //} 


    }
}
