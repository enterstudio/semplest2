using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.SharedResources.Encryption;

namespace Semplest.Core.Controllers
{
    public class EncryptionController : Controller
    {
        //
        // GET: /Encryption/

        public ActionResult Index()
        {
            EncryptionHelper aes = Semplest.SharedResources.Encryption.EncryptionHelper.getInstance();
            String test = "01tsemplest";
            String en = aes.EncryptString(test);
            String de = aes.DecryptString(en);

            return View();
        }

    }
}
