using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestModel;
using Semplest.Core.Models;

namespace Semplest.Core.Controllers
{
    public class ReportingController : Controller
    {
        //
        // GET: /Reporting/

        public ActionResult Index()
        {
            
            SemplestEntities dbContext = new SemplestEntities();
            ReportIndexModel rim = new ReportIndexModel();
            rim.AdvertisingEngines = dbContext.AdvertisingEngines;
            rim.ProductGroups = dbContext.ProductGroups;
            return View(rim);
        }

        //
        // GET: /Reporting/Details/5

        public ActionResult Details(int id)
        {
            return View();
        }

        //
        // GET: /Reporting/Create

        public ActionResult Create()
        {
            return View();
        } 

        //
        // POST: /Reporting/Create

        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
        
        //
        // GET: /Reporting/Edit/5
 
        public ActionResult Edit(int id)
        {
            return View();
        }

        //
        // POST: /Reporting/Edit/5

        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here
 
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /Reporting/Delete/5
 
        public ActionResult Delete(int id)
        {
            return View();
        }

        //
        // POST: /Reporting/Delete/5

        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
 
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
