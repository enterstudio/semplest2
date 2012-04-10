using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestAdminApp.Models;
using System.Reflection;
using System.Data.Entity.Validation;

namespace SemplestAdminApp.Controllers
{
    public class RolesController : Controller
    {
        //
        // GET: /Roles/

        SemplestEntities _dbContext = new SemplestEntities();

        public void AddRightToDatabase(string label, string controllerName, string vAction)
        {
            bool found = false;
            string myController = ControllerContext.RouteData.Values["Controller"].ToString();
            string controllerActionName = controllerName + "." + vAction;
            if (controllerName != myController && !string.IsNullOrEmpty(label))
            {
                foreach (Right r in _dbContext.Rights)
                {
                    if (label == r.Label && controllerActionName == r.Controller)
                    {
                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    _dbContext.Rights.Add(new Right { Controller = controllerActionName, Label = label });
                    _dbContext.SaveChanges();
                }
            }
        }

        public ActionResult Index()
        {
            var model = _dbContext.Roles;
            return View(model);
        }

        //
        // GET: /Roles/Details/5

        public ActionResult Details(int id)
        {
            return View();
        }

        //
        // GET: /Roles/Create

        public ActionResult Create()
        {
            ViewData["Roles"] = new SelectList(_dbContext.Roles, "RolePK", "RoleName");

            //var viewModel =
            //    from ro in _dbContext.Roles
            //    join ri in _dbContext.Rights on ro.RolePK equals ri.RolesFK
            //    group ri by new 
            //    {
            //        ri.r,
            //    } into grp
            //    select new RoleModel
            //    {
            //        //RightName = grp.FirstOrDefault().RightName,
            //        RightPK = grp.FirstOrDefault().RightsPK,
            //    };

            return View(_dbContext.Rights);
        }

        static public int MMk()
        { return 1; }


        public ActionResult Models(int id)
        {
            return View();
            //var viewModel =
            //                from ro in _dbContext.Roles
            //                join ri in _dbContext.Rights on ro.RolePK equals ri.RolesFK
            //                where ro.RolePK == id
            //                select new RoleModel
            //                 {
            //                     RightPK = ri.RightsPK,
            //                     RightName = ri.RightName
            //                 }; 
            //return Json(viewModel.ToList());
        }
     
        //
        // POST: /Roles/Create
        delegate int c();

        public static void hgas()
        {
            //c j = new c(MMk);
            //j.BeginInvoke()
                
        }

        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here
                foreach (Object j in collection)
                {
                    Console.WriteLine(j.ToString());
                }
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /Roles/Edit/5

        public ActionResult Edit(int id)
        {
            return View();
        }

        //
        // POST: /Roles/Edit/5

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
        // GET: /Roles/Delete/5

        public ActionResult Delete(int id)
        {
            return View();
        }

        //
        // POST: /Roles/Delete/5

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
