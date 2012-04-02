using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

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
            //var users = (from u in 
            //             where u.Name.StartsWith(query)
            //             orderby u.Name // optional but it'll look nicer 
            //             select u.Name).Distinct().ToArray();

            string[] users = new string[] { "Elegant Details","Flower Allie", "Flowers by Color" }; 

            return Json(users);
        } 


    }
}
