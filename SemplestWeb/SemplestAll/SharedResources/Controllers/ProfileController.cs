using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.SharedResources.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;

namespace Semplest.SharedResources.Controllers
{
    [ExceptionHelper]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")] 
    public class ProfileController : Controller
    {
        //
        // GET: /Profile/

        public ActionResult LogIn()
        {
            Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] = null;
            return View();
        }

        [HttpPost]
        public ActionResult LogIn(Semplest.SharedResources.Models.ProfileModel pm, string ReturnUrl, string isAdmin)
        {
            bool isAdminLogin = isAdmin == null ? false : true;
            using (SemplestEntities dbContext = new SemplestEntities())
            {
                Credential cred = null;
                if (Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] != null)
                {
                    cred = (Credential)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID];
                }
                else
                {
                    var creds = dbContext.Credentials.Where(c => c.Username == pm.UserName && c.Password == pm.Password1);

                    if (creds.Count() == 1)
                    {
                        if ((isAdminLogin && creds.First().IsAdmin()) || (!isAdminLogin && !creds.First().IsAdmin()))
                            cred = creds.First();
                    }

                }
                if (cred == null)
                {
                        pm.LoggedInSucceeded = false;
                        pm.LoginFailedMessage = "Your userid or password is invalid please try again.";
                }
                else if (cred.User.IsActive)
                    {
                        Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] = cred;
                        if (cred.User.IsRegistered)
                        {
                            //if the user doesn't have a parent in the customerparentfk column then they are a parent else they are a child
                            //if (cred.User.CustomerFK == null || string.IsNullOrEmpty(cred.User.Customer.CustomerHierarchies.First().CustomerParentFK.ToString()))
                            //    return RedirectToAction("Index", "Home");
                            //else if (cred.User.IsRegistered)
                                //user is a regular core user
                            if (cred.User.CustomerFK == null)
                                return RedirectToAction("Index", "Home");
                            else
                                return RedirectToAction("Index2", "Home");
                        }
                        else if (pm.LoggedInSucceeded)
                        {
                            Credential saveCred = dbContext.Credentials.Where(x => x.Username == cred.Username && x.Password == cred.Password).First();
                            //authenticated properly and submitted secondary form SecurityAnswer/SecurityQuestion
                            saveCred.SecurityAnswer = pm.SecurityAnswer;
                            saveCred.SecurityQuestion = pm.SecurityQuestion;
                            saveCred.User.IsRegistered = true;
                            int i = dbContext.SaveChanges();
                            return RedirectToAction("Index", "Home");
                        }
                        else
                        {
                            //authenticated properly and HAS NOT submitted secondary form SecurityAnswer/SecurityQuestion to complete registration
                            pm.IsRegistered = false;
                            pm.LoggedInSucceeded = true;
                        }
                    }
                    else
                    {
                        pm.LoggedInSucceeded = false;
                        pm.LoginFailedMessage = "Sorry, your account is currently disabled, please contact SEMplest Customer Service for assistance.";
                    }
                }

                return View(pm);
            }

        public ActionResult Verify(string userName, string password)
        {
            using (SemplestEntities dbContext = new SemplestEntities())
            {
                var creds = dbContext.Credentials.Where(c => c.Username == userName && c.Password == password);
                if (creds.Count() == 1)
                {
                    Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] = creds.First();
                    if (creds.First().User.UserRolesAssociations.First().RolesFK == 2)
                        //means this is an admin user
                        return RedirectToAction("Index", "Home");
                    else
                        if (creds.First().User.IsRegistered)
                            return RedirectToAction("Index", "Home");
                        else
                        {
                            Semplest.SharedResources.Models.ProfileModel pm = new Models.ProfileModel();
                            pm.UserName = userName;
                            pm.Password1 = password;
                            return PartialView("_Password", pm);
                        }
                }
                Semplest.SharedResources.Models.ProfileModel pm2 = new Models.ProfileModel();
                pm2.UserName = userName + userName;
                pm2.Password1 = password;
                return View(pm2);
            }
        }

        public void AddRightToDatabase(string label, string controllerName, string vAction)
        {

            bool found = false;
            string myController = ControllerContext.RouteData.Values["Controller"].ToString();
            if (controllerName != "Roles")
            {
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
                        try
                        {
                            if (!found)
                            {
                                dbContext.Rights.Add(new Right { Controller = controllerActionName, Label = label });
                                dbContext.SaveChanges();
                            }
                        }
                        catch (Exception ex)
                        {
                            Console.WriteLine(ex.ToString());
                        }
                    }
                }
            }
        }
    }
}
