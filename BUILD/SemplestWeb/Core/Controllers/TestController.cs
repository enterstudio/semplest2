using System.Web.Mvc;
using Semplest.Core.Models;

namespace Semplest.Core.Controllers
{
    public class TestController : Controller
    {
        //
        // GET: /Test/

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(Phone ph)
        {
            try
            {
                using (var db = new SemplestEntities())
                {
                    db.Phones.Add(ph);
                    db.SaveChanges();
                }
                return RedirectToAction("Index");
            }
            catch
            {

                return View();
            }
        }

    }
}
