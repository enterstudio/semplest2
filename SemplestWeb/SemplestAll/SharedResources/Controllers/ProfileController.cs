using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SemplestModel;

namespace Semplest.SharedResources.Controllers
{
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
                Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] = 1;
                return RedirectToAction("Index", "Home");
                var creds = dbContext.Credentials.Where(c => c.Username == pm.UserName && c.Password == pm.Password1);
                if (creds.Count() == 1)
                {
                    Credential c = creds.First();
                    Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] = c.UsersFK;
                    if (c.User.UserRolesAssociations.First().RolesFK == 2)
                        //means this is an admin user
                        return RedirectToAction("Index", "Home");
                    else if (c.User.IsRegistered)
                        //user is a regular core user
                        return RedirectToAction("CampaignSetup", "Campaign");
                    else if (!string.IsNullOrEmpty(pm.SecurityAnswer) && !string.IsNullOrEmpty(pm.SecurityQuestion))
                    {
                        //authenticated properly but hasn't registered yet
                        c.SecurityAnswer = pm.SecurityAnswer;
                        c.SecurityQuestion = pm.SecurityQuestion;
                        c.User.IsRegistered = true;
                        dbContext.SaveChanges();
                        return RedirectToAction("Index", "Home");
                    }
                    else
                        pm.IsRegistered = false;
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
    }
}
