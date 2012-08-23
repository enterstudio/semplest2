using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.Admin.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;
using LinqKit;

namespace Semplest.Admin.Controllers
{
    [ExceptionHelper]
    [AuthorizeRole]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class HomeController : Controller
    {
        //public ActionResult Index(string usersearch, string accountnumbersearch, string emailsearch, FormCollection form)
        public ActionResult Index()
        {

            //ViewBag.Message = "Welcome to SEMPLEST ADMIN!";
            //Semplest dbcontext = new SemplestModel.Semplest();

            ////FUTURE: add rearch by email and by account number || u.Email.Contains(emailsearch)

            //var viewModel =
            //    from u in dbcontext.Users
            //    join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
            //    where ((c.Name.Contains(usersearch) || u.FirstName.Contains(usersearch) || u.LastName.Contains(usersearch)) )
            //    select new HomeModel
            //        {
            //        Customer = c.Name,
            //        AccountNumber = c.CustomerPK,
            //        FirstName = u.FirstName,
            //        LastName = u.LastName,
            //        Email = u.Email
            //    };

            //var predicate = PredicateBuilder.True<HomeModel>();


            //if (form["searchtype"] == "Customer" && usersearch != null && usersearch != "")
            //{
            //    predicate = (p => p.Customer.ToLower().Contains(usersearch.ToLower()));
            //}

            //if (form["searchtype"] == "LastName" && usersearch != null && usersearch != "")
            //{
            //    predicate = (p => p.LastName.ToLower().Contains(usersearch.ToLower()));
            //}


            //int accnumber;
            //bool validaccountsearch = int.TryParse(accountnumbersearch, out accnumber);

            //if (accountnumbersearch != null && accountnumbersearch != "" && validaccountsearch)
            //{
            //    predicate = (p => p.AccountNumber == accnumber);
            //}


            //if (emailsearch != null && emailsearch != "")
            //{
            //    predicate = (p => p.Email.ToLower().Contains(emailsearch.ToLower()));
            //}


            ////ordering by lastname, firstname
            //viewModel = viewModel.OrderBy(p=>p.Customer).ThenBy(p => p.LastName).ThenBy(p => p.FirstName); 
            //viewModel = viewModel.AsExpandable().Where(predicate);

            //return View(viewModel);
            return View();
        }

        public ActionResult SchedulerView()
        {
            var dbContext = new SemplestModel.Semplest();
            var
            svmc  = new SchedulerViewModelCollection();
            foreach (SchedulerView svm in dbContext.SchedulerViews)
            {
                svmc.SVM.Add(new SchedulerViewModel{ CustomerName = svm.CustomerName, ExecutionStartTime = svm.ExecutionStartTime, Frequency = svm.Frequency, IsComplete = svm.IsComplete, IsEnabled = svm.IsEnabled, IsInactive = svm.IsInactive, IsSuccessful = svm.IsSuccessful, PromotionName = svm.PromotionName, ScheduleJobPK = svm.ScheduleJobPK, ScheduleName = svm.ScheduleName, SchedulePK = svm.SchedulePK});
            }
            svmc.Status = "All";
            return View(svmc);
        }

        [HttpPost]
        public ActionResult SchedulerView(SchedulerViewModelCollection svmc)
        {
            var dbContext = new SemplestModel.Semplest();
            var
            svmcNew = new SchedulerViewModelCollection();
            List<SchedulerView> lsvc;
            switch (svmc.Status)
            {
                case "IsEnabled" :
                    lsvc = dbContext.SchedulerViews.Where(x => x.IsEnabled == true).ToList();
                    break;
                case "IsDisabled" :
                    lsvc = dbContext.SchedulerViews.Where(x => x.IsEnabled == false).ToList();
                    break;
                default:
                    lsvc = dbContext.SchedulerViews.ToList();
                    break;
            }
            foreach (SchedulerView svm in lsvc)
            {
                svmcNew.SVM.Add(new SchedulerViewModel { CustomerName = svm.CustomerName, ExecutionStartTime = svm.ExecutionStartTime, Frequency = svm.Frequency, IsComplete = svm.IsComplete, IsEnabled = svm.IsEnabled, IsInactive = svm.IsInactive, IsSuccessful = svm.IsSuccessful, PromotionName = svm.PromotionName, ScheduleJobPK = svm.ScheduleJobPK, ScheduleName = svm.ScheduleName, SchedulePK = svm.SchedulePK });
            }
            svmcNew.Status = svmc.Status;
            return View(svmcNew);
        }

        //public ActionResult GetUsers(string query)
        //{
        //    List<string> users = new List<string>();
        //    using (Semplest dbContext = new SemplestModel.Semplest())
        //    {
        //        System.Data.Entity.DbSet dusers = dbContext.Users;
        //        foreach (User du in dusers)
        //        {
        //            users.Add(du.FirstName + " "  + du.LastName);
        //        }
        //    }
        //    var quer = from u in users
        //               where u.ToLower().Contains(query.ToLower())
        //               select u;

        //    return Json(quer);
        //} 


    }
}
