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
        SemplestEntities _dbContext = new SemplestEntities();
        //
        // GET: /Roles/

        public void AddRightToDatabase(string label, string controllerName, string vAction)
        {
            
            bool found = false;
            string myController = ControllerContext.RouteData.Values["Controller"].ToString();
            string controllerActionName = controllerName + "." + vAction;
            if (controllerName != myController && !string.IsNullOrEmpty(label))
            {
                using (SemplestEntities dbContext = new SemplestEntities())
                {
                    foreach (Right r in dbContext.Rights)
                    {
                        if (label == r.Label && controllerActionName == r.Controller)
                        {
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                    {
                        dbContext.Rights.Add(new Right { Controller = controllerActionName, Label = label });
                        dbContext.SaveChanges();
                    }
                }
            }
        }

        public ActionResult Index()
        {
            IEnumerable<SemplestAdminApp.Models.Role> viewModel = _dbContext.Roles;
            return View(viewModel);
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
                return View(_dbContext.sp_GetRigtsRolesInteraction(null));
            
            //var viewModel =
            //       from ra in _dbContext.RolesRightsAssociations
            //       join r in _dbContext.Rights on ra.RightsFK equals r.RightsPK
            //       group r by new
            //       {
            //           r.Controller,
            //           r.Label
            //       } into grp
            //       select new UserRoleModel
            //       {
            //           Controller = grp.FirstOrDefault().Controller,
            //           Label = grp.FirstOrDefault().Label,
            //           IsVisible = false,
            //           IsReadonly = false
            //       };
            //IEnumerable<SemplestAdminApp.Models.sp_GetRigtsRolesInteraction_Result> viewModel = _dbContext.sp_GetRigtsRolesInteraction(null);
            

            
        }

        //
        // POST: /Roles/Create
        [HttpPost]
        public ActionResult Create(IEnumerable<sp_GetRigtsRolesInteraction_Result> userRights, FormCollection f)
        {
            // TODO: Add insert logic here
                Role ro = _dbContext.Roles.Add(new Role { RoleName = f["roleName"].ToString() });
                _dbContext.SaveChanges();
                foreach (sp_GetRigtsRolesInteraction_Result s in userRights)
                {
                    RolesRightsAssociation ra = new RolesRightsAssociation
                    {
                        IsReadonly = s.IsReadonly == null ? false : bool.Parse(s.IsReadonly.ToString()),
                        IsVisible = s.IsVisible == null ? false : bool.Parse(s.IsVisible.ToString()),
                        RightsFK = s.RightsPK,
                        RolesFK = ro.RolePK
                    };
                    _dbContext.RolesRightsAssociations.Add(ra);
                }
                _dbContext.SaveChanges();

                /*update code*/
                //foreach (RolesRightsAssociation r in _dbContext.RolesRightsAssociations)
                //{

                //    r.IsReadonly = ur.IsReadonly == null ? false : bool.Parse(ur.IsReadonly.ToString());
                //    r.IsVisible = ur.IsVisible  == null ? false : bool.Parse(ur.IsVisible.ToString());
                //    r.RolesFK = ro.RolePK;
                //    r.RightsFK = ur.RightsPK;
                //}
                _dbContext.SaveChanges();
            return RedirectToAction("Index");
        }

        public ActionResult Models(string RoleId)
        {

            int role = int.Parse(RoleId);
            RolesRightsAssociation a = new RolesRightsAssociation();
            a.IsVisible = false;
            a.IsReadonly = false;
            //Right ri = new Right();
            //ri.Controller ="DefaultController";
            //ri.Label ="DefaultLabel";
            //a.Right=ri;
            //var viewModel =
            //    from ra in _dbContext.RolesRightsAssociations
            //    join r in _dbContext.Rights on ra.RightsFK equals r.RightsPK into tl_j
            //    where ra.RolesFK == role
            //    from j in tl_j.DefaultIfEmpty()
            //    select new UserRoleModel
            //    {
            //        Controller = j.Controller,
            //        Label = j.Label,
            //        IsVisible = ra.IsVisible == null ? false : ra.IsVisible,
            //        IsReadonly = ra.IsReadonly == null ? false : ra.IsReadonly
            //    };

            /*from r in _dbContext.Rights
            join ra in _dbContext.RolesRightsAssociations on r.RightsPK equals ra.RightsFK
            where ra.RolesFK == role
            select new UserRoleModel
            {
                Controller = r.Controller,
                Label = r.Controller,
                IsVisible = ra.IsVisible,
                IsReadonly = ra.IsReadonly
            };*/
                return PartialView("_RolesRightsAssociation", _dbContext.sp_GetRigtsRolesInteraction(role));
            //sp_GetRigtsRolesInteraction_Result model = _dbContext.sp_GetRigtsRolesInteraction(role);

            
            //return View();
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
