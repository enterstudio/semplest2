using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.Admin.Models;

namespace Semplest.Admin.Controllers
{
    [LoggingHandleErrorAttribute]
    public class ProfileController : Controller
    {
        //
        // GET: /User/

        public ActionResult LogOn()
        {
            return View();
        }

        [HttpPost]
        public ActionResult LogOn(Semplest.Admin.Models.ProfileModel pm)
        {
            using(SemplestEntities dbContext = new SemplestEntities())
            {
                var creds = dbContext.Credentials.Where(c => c.Username == pm.UserName && c.Password == pm.Password);
                if (creds.Count() == 1)
                {
                    Session["userId"] = creds.First().UsersFK;
                    return RedirectToAction("Index", "Home");
                }
                else 
                {
                    return View(pm);
                }

            };
            //return RedirectToRoute("Default");
            
        }

    }
}
