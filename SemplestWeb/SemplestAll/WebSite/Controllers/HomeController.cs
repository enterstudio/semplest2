using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Net.Mail;
using Semplest.WebSite.Models;

namespace Semplest.WebSite.Controllers
{
    public class HomeController : Controller
    {
        //
        // GET: /Home/

        public ActionResult Index()
        {
            return View();
        }
        public ActionResult SEMAbout()
        {
            return View();
        }
        public ActionResult OpenInvitation()
        {
            return View();
        }
        public ActionResult ContactUs()
        {
            return View();
        }
        public ActionResult ThankYou()
        {
            return View();
        }
        public ActionResult ErrorPage()
        {
            return View();
        }

        [HttpPost]
        public ActionResult ContactUs(SEMCustomerDetail model)
        {
            if (ModelState.IsValid && !(model.CallMe == false && model.EmailMe == false))
            {
                try
                {
                    model.CreatedDate = DateTime.Now;
                    using (SemplestEntities dbContext = new SemplestEntities())
                    {
                        string semEmail = dbContext.Configurations.Select(m => m.DefalutEmailContactMe).FirstOrDefault();

                        if (model.EmailMe == false)
                        {
                            model.email = "";
                        }
                        else if (model.CallMe == false)
                        {
                            model.Phone = "";
                        }
                        dbContext.SEMCustomerDetails.Add(model);
                        dbContext.SaveChanges();

                        // send email using smtp server
                        if (model.EmailMe == true)
                            SendMail(model, semEmail);
                    }
                }
                catch (Exception ex)
                {
                    string errMsg = "Error: " + ex.Message + "\r\n" + ex.StackTrace;
                    ErrorModel errModel = new ErrorModel() { MsgToLog = errMsg, MsgToShow = "Error" };
                    return View("ErrorPage", errModel);
                }
                return RedirectToAction("ThankYou");
            }
            else
            {
                return View(model);
            }
        }


        private void SendMail(SEMCustomerDetail model, string sEmail)
        {
            MailMessage mail = new MailMessage();
            SmtpClient SmtpServer = new SmtpClient("172.18.9.36", 25);

            mail.From = new MailAddress(model.email);
            mail.To.Add(sEmail);
            mail.Subject = "Semplest Website Inquiry";
            StringBuilder sb = new StringBuilder();
            sb.AppendLine("Name: " + model.FirstName + " " + model.LastName);
            sb.AppendLine("Company: " + model.Company);
            if (!String.IsNullOrEmpty(model.Phone))
                sb.AppendLine("Phone: " + model.Phone);
            if (!String.IsNullOrEmpty(model.email))
                sb.AppendLine("Email: " + model.email);

            mail.Body = sb.ToString();

            SmtpServer.Send(mail); 

        }
    }
}
