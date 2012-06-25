using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Semplest.Core.Controllers
{
    public class EncryptionController : Controller
    {
        //
        // GET: /Encryption/

        public ActionResult Index()
        {
            bool retval = Semplest.SharedResources.Encryption.EncryptionHelper.VerifyPassword("blah");
            return View();
        }

    }
}
