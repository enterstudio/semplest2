using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestModel;
using Semplest.SharedResources.Helpers;

namespace Semplest.SharedResources.Controllers
{
    [ExceptionHelper]
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
        public ActionResult LogIn(Semplest.SharedResources.Models.ProfileModel pm, string ReturnUrl)
        {
            using (SemplestEntities dbContext = new SemplestEntities())
            {
                var creds = dbContext.Credentials.Where(c => c.Username == pm.UserName && c.Password == pm.Password1);
                if (creds.Count() == 1)
                {
                    Credential c = creds.First();
                    if (c.User.IsActive)
                    {
                        Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] = c.UsersFK;
                        if (c.User.IsRegistered)
                        {
                            //if the user doesn't have a parent in the customerparentfk column then they are a parent else they are a child
                            if (c.User.CustomerFK == null || string.IsNullOrEmpty(c.User.Customer.CustomerHierarchies.First().CustomerParentFK.ToString()))
                                return RedirectToAction("Index", "Home");
                            else if (c.User.IsRegistered)
                                //user is a regular core user
                                return RedirectToAction("Index2", "Home");
                        }
                        else if (!string.IsNullOrEmpty(pm.SecurityAnswer) && !string.IsNullOrEmpty(pm.SecurityQuestion))
                        {
                            //authenticated properly and submitted secondary form SecurityAnswer/SecurityQuestion
                            c.SecurityAnswer = pm.SecurityAnswer;
                            c.SecurityQuestion = pm.SecurityQuestion;
                            c.User.IsRegistered = true;
                            dbContext.SaveChanges();
                            return RedirectToAction("Index", "Home");
                        }
                        else
                        {
                            //authenticated properly and HAS NOT submitted secondary form SecurityAnswer/SecurityQuestion to complete registration
                            pm.IsRegistered = false;
                        }
                    }
                    else
                    {
                        pm.LoggedInSucceeded = false;
                        pm.LoginFailedMessage = "Sorry, your account is currently disabled, please contact SEMplest Customer Service for assistance.";
                    }
                }
                else
                {
                    pm.LoggedInSucceeded = false;
                    pm.LoginFailedMessage = "Your userid or password is invalid please try again.";
                }
                return View(pm);
            }
        }

        public ActionResult Verify(string userName, string password)
        {
            using (SemplestEntities dbContext = new SemplestEntities())
            {
                var creds = dbContext.Credentials.Where(c => c.Username == userName && c.Password == password);
                if (creds.Count() == 1)
                {
                    Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] = creds.First().UsersFK;
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
