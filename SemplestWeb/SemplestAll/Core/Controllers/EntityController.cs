﻿using System.Linq;
using System.Web.Mvc;
using Semplest.Core.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")] 
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
                    db.BillTypes.AddObject(billtype);
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