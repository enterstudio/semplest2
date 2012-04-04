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
        public ActionResult Index()
        {
            ViewBag.Message = "Welcome to SEMPLEST ADMIN!";

            return View();
        }

        public ActionResult About()
        {
            return View();
        }

        public ActionResult GetUsers(string query)
        {
            List<string> users = new List<string>();
            using (SemplestEntities dbContext = new SemplestEntities())
            {
                //System.Data.Entity.DbSet dusers = dbContext.Users;
                //foreach (User du in dusers)
                //{
                //    users.Add(du.FirstName + " "  + du.LastName);
                //}
            }
            var quer = from u in users
                       where u.ToLower().Contains(query.ToLower())
                       select u;

            return Json(quer);
        } 


    }
}
