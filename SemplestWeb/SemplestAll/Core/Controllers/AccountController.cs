using System.Web.Mvc;
using System.Web.Routing;
using System.Web.Security;
using Semplest.Core.Models;
using Semplest.SharedResources.Helpers;
using SemplestModel;
using System.Linq;
using System;

namespace Semplest.Core.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class AccountController : Controller
    {
        public IFormsAuthenticationService FormsService { get; set; }
        public IMembershipService MembershipService { get; set; }

        protected override void Initialize(RequestContext requestContext)
        {
            if (FormsService == null)
            {
                FormsService = new FormsAuthenticationService();
            }
            if (MembershipService == null)
            {
                MembershipService = new AccountMembershipService();
            }

            base.Initialize(requestContext);
        }

        // **************************************
        // URL: /Account/LogOn
        // **************************************

        public ActionResult LogOn()
        {
            return View();
        }

        [HttpPost]
        public ActionResult LogOn(LogOnModel model, string returnUrl)
        {
            return RedirectToAction("Profile", "Home");
            //if (ModelState.IsValid)
            //{
            //    if (MembershipService.ValidateUser(model.UserName, model.Password))
            //    {
            //        FormsService.SignIn(model.UserName, model.RememberMe);
            //        if (Url.IsLocalUrl(returnUrl))
            //        {
            //            return Redirect(returnUrl);
            //        }
            //        else
            //        {
            //            return RedirectToAction("Index", "Home");
            //        }
            //    }
            //    else
            //    {
            //        ModelState.AddModelError("", "The user name or password provided is incorrect.");
            //    }
            //}

            //// If we got this far, something failed, redisplay form
            //return View(model);
        }

        // **************************************
        // URL: /Account/LogOff
        // **************************************

        public ActionResult LogOff()
        {
            FormsService.SignOut();

            return RedirectToAction("Index", "Home");
        }

        // **************************************
        // URL: /Account/Register
        // **************************************

        public ActionResult Register()
        {
            ViewBag.PasswordLength = MembershipService.MinPasswordLength;

            return View();
        }

        [HttpPost]
        public ActionResult Register(RegisterModel model)
        {
            if (ModelState.IsValid)
            {
                // Attempt to register the user
                MembershipCreateStatus createStatus = MembershipService.CreateUser(model.UserName, model.Password,
                                                                                   model.Email);

                if (createStatus == MembershipCreateStatus.Success)
                {
                    FormsService.SignIn(model.UserName, false /* createPersistentCookie */);
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ModelState.AddModelError("", AccountValidation.ErrorCodeToString(createStatus));
                }
            }

            // If we got this far, something failed, redisplay form
            ViewBag.PasswordLength = MembershipService.MinPasswordLength;
            return View(model);
        }

        // **************************************
        // URL: /Account/ChangePassword
        // **************************************

        [Authorize]
        public ActionResult ChangePassword()
        {
            ViewBag.PasswordLength = MembershipService.MinPasswordLength;
            return View();
        }

        [Authorize]
        [HttpPost]
        public ActionResult ChangePassword(ChangePasswordModel model)
        {
            if (ModelState.IsValid)
            {
                if (MembershipService.ChangePassword(User.Identity.Name, model.OldPassword, model.NewPassword))
                {
                    return RedirectToAction("ChangePasswordSuccess");
                }
                else
                {
                    ModelState.AddModelError("", "The current password is incorrect or the new password is invalid.");
                }
            }

            // If we got this far, something failed, redisplay form
            ViewBag.PasswordLength = MembershipService.MinPasswordLength;
            return View(model);
        }

        // **************************************
        // URL: /Account/ChangePasswordSuccess
        // **************************************

        public ActionResult ChangePasswordSuccess()
        {
            return View();
        }

        //****************************************
        //URL:/Account/ParentProfile
        //****************************************

        public ActionResult ParentProfile()
        {
            return View();
        }

        //****************************************
        //URL:/Account/MyProfile
        //****************************************

        public ActionResult MyProfile()
        {

            SemplestEntities dbcontext = new SemplestEntities();
            int userid=((Credential)Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]).UsersFK;
            int customerID = dbcontext.Users.Where(r => r.UserPK == userid).First().CustomerFK.GetValueOrDefault(-1);
            

            var viewModel =
               from u in dbcontext.Users
               join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
               join caa in dbcontext.CustomerAddressAssociations on c.CustomerPK equals caa.CustomerFK
               join a in dbcontext.Addresses on caa.AddressFK equals a.AddressPK
               join sc in dbcontext.StateCodes on a.StateAbbrFK equals sc.StateAbbrPK
               join at in dbcontext.AddressTypes on caa.AddressTypeFK equals at.AddressTypePK
               join cpa in dbcontext.CustomerPhoneAssociations on c.CustomerPK equals cpa.CustomerFK
               join p in dbcontext.Phones on cpa.PhoneFK equals p.PhonePK

               where (c.CustomerPK == customerID)
               select new ChildModel
               {   
                   AccountNumber = c.CustomerPK,
                   Customer = c.Name,
                   FirstName = u.FirstName,
                   LastName = u.LastName,
                   MiddleInitial = u.MiddleInitial,
                   Address1 = a.Address1,
                   Address2 = a.Address2,
                   City = a.City,
                   Zip = a.ZipCode,
                   Phone = p.Phone1,
                   Email = u.Email,
                   UserPK = u.UserPK,
                   SelectedStateID  = sc.StateAbbrPK
               };

            ChildModel cm = new ChildModel();
            cm = viewModel.Single();
         
            //add userid and password to model
            var credential = dbcontext.Credentials.First(r => r.UsersFK.Equals(userid));
            cm.UserID = credential.Username;
            cm.UserPassword = credential.Password;
            cm.SecurityQuestion = credential.SecurityQuestion;
            cm.SecurityAnswer = credential.SecurityAnswer;

            /////////////////////////////////////////////////////////////////////////////////
            //for state dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allstates = (from sc in dbcontext.StateCodes select sc).ToList();
            cm.SelectedStateID = viewModel.Select(r => r.SelectedStateID).FirstOrDefault();
            cm.States = allstates.Select(r => new SelectListItem
            {
                Value = r.StateAbbrPK.ToString(),
                Text = r.StateAbbr.ToString()
            });


            return View(cm);


        }



        //****************************************
        //URL:/Account/MyProfile
        //****************************************

        [HttpPost]
        public ActionResult MyProfile(ChildModel m, string command)
        {
            
            if (command.ToLower() == "cancel") return RedirectToAction("Index2", "Home");
            //if (command.ToLower() == "delete")



            SemplestEntities dbcontext = new SemplestEntities();




            //check if userid has been taken by other users

            var userIDSs = from c in dbcontext.Credentials
                           where c.Username.Equals(m.UserID) && !c.UsersFK.Equals(m.UserPK)
                           select c;
            if (userIDSs.Count() > 0)
                ModelState.AddModelError("UserID", "This UserID is already taken!!");



            if (!ModelState.IsValid)
            {
                

                var allstates = (from sc in dbcontext.StateCodes select sc).ToList();

                m.States = allstates.Select(r => new SelectListItem
                {
                    Value = r.StateAbbrPK.ToString(),
                    Text = r.StateAbbr.ToString()
                });

                return View(m);
            }


            var user = dbcontext.Users.ToList().Find(p => p.UserPK == m.UserPK);
            user.FirstName = m.FirstName;
            user.LastName = m.LastName;
            user.MiddleInitial = m.MiddleInitial;
            user.Email = m.Email;
            user.EditedDate = DateTime.Now;
            
            //UpdateModel(user);


            var customer = dbcontext.Customers.ToList().Find(p => p.CustomerPK == m.AccountNumber);
            var customeraddressassociation = dbcontext.CustomerAddressAssociations.ToList().Find(p => p.CustomerFK == customer.CustomerPK);
            var address = dbcontext.Addresses.ToList().Find(p => p.AddressPK == customeraddressassociation.AddressFK);


            customer.Name = m.Customer;
            
            address.Address1 = m.Address1;
            address.Address2 = m.Address2;
            address.City = m.City;
            address.ZipCode = m.Zip;
            address.EditedDate = DateTime.Now;
            address.StateAbbrFK = m.SelectedStateID;
            UpdateModel(address);



            var customerphoneassociation = dbcontext.CustomerPhoneAssociations.ToList().Find(p => p.CustomerFK == m.AccountNumber);
            var phone = dbcontext.Phones.ToList().Find(p => p.PhonePK == customerphoneassociation.PhoneFK);
            phone.Phone1 = m.Phone;

            UpdateModel(phone);

            var credentials = dbcontext.Credentials.ToList().Find(p => p.UsersFK == m.UserPK);
            credentials.Username = m.UserID;
            credentials.Password = m.UserPassword;
            credentials.SecurityQuestion = m.SecurityQuestion;
            credentials.SecurityAnswer = m.SecurityAnswer;


            UpdateModel(credentials);
  

            
  


  
            dbcontext.SaveChanges();






            return RedirectToAction("Index2","Home");
            //return View("index");
            //return View(m);
        }







    }
}