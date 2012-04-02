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
  
            string[] users = new string[] { "Elegant Details", "Flower Allie", "Flowers by Color", "Nature's Petals", "Nicole's Flowers", "Manik's Flowers", "Tudor's Flowers", "Andre's Petals", "Mark's Tulips" };

            var quer = from u in users
                       where u.ToLower().Contains(query.ToLower())
                       select u;

            return Json(quer);
        } 


    }
}
