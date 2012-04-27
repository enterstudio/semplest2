using System.Web.Mvc;
using Semplest.Admin.Models;

namespace Semplest.Admin.Controllers
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
