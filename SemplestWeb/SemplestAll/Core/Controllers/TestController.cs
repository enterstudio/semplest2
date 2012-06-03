using System.Web.Mvc;
using Semplest.Core.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")] 
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
                    db.Phones.AddObject(ph);
                    db.SaveChanges();
                }
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        public ActionResult TestMap()
        {
            return View();
        }
    }
}