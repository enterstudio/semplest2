using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestWebApp.Models;

namespace SemplestWebApp.Areas.Campign.Controllers
{
    public class CampignController : Controller
    {
        //
        // GET: /Campign/Campign/

        public ActionResult CampignSetup()
        {
            return View();
        }

        [HttpPost]
        public ActionResult CampignSetup(CampignSetupModel model)
        {
            if (ModelState.IsValid)
            {
                // need to call wcf service to save data here
            }
            return View(model);
        }

    }
}
