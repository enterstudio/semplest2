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


        public ActionResult Edit()
        {

            return View();
        }

        [HttpPost]
        public ActionResult Edit(User model)
        {
            using (SemplestEntities dbContext = new SemplestEntities())
            {
                dbContext.Users.Add(model);
                dbContext.SaveChanges();
            }

            return View(model);

        }
    }
}
