using System.Linq;
using System.Web.Mvc;
using Semplest.Core.Models;
using SemplestModel;

namespace Semplest.Core.Controllers
{
    public class EntityController : Controller
    {
        //
        // GET: /Entity/


        public ActionResult Index()
        {
            return View();
        }

        public ActionResult BillType()
        {
            //var model = new BillType();
            //{
            //    model.BillType1 = "Credit Card";
            //    model.Customers.Add(new Customer());
            //};

            using (var db = new SemplestEntities())
            {
                try
                {
                    if (db.BillTypes.Count() > 0)
                        return View(db.BillTypes.ToList());
                    else
                        return View();
                }
                catch
                {
                    return View();
                }
            }


            //return View();
        }

        public ActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Create(BillType billtype)
        {
            try
            {
                using (var db = new SemplestEntities())
                {
                    db.BillTypes.Add(billtype);
                    db.SaveChanges();
                }
                return RedirectToAction("BillType");
            }
            catch
            {
                return View();
            }
        }
    }
}