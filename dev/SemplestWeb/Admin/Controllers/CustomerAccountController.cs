using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Semplest.Admin.Controllers
{
    public class CustomerAccountController : Controller
    {
        //
        // GET: /CreateNewCustomerAccount/

        public ActionResult Index()
        {
            
            //redirect to edit or add??
            return View();
        }

        public ActionResult Edit()
        {
            return View();
        }

        public ActionResult Create()
        {
            return View();
        }

    }
}
