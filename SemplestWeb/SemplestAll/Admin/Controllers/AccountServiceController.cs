using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Semplest.Admin.Models;
using SemplestModel;
using Semplest.SharedResources.Helpers;
using System.Text;
using System.IO;
using System.Data;
using System.Data.OleDb;
using FileHelpers;
using System.Transactions;
using Semplest.SharedResources.Services;

namespace Semplest.Admin.Controllers
{
    [ExceptionHelper]
    [AuthorizeRoleAttribute]
    [OutputCache(NoStore = true, Duration = 0, VaryByParam = "*")]
    public class AccountServiceController : Controller
    {
        //
        // GET: /ClientAccount/

        public ActionResult Index(int id)
        {
            SemplestEntities dbcontext = new SemplestEntities();

            var viewModel =
               from u in dbcontext.Users
               join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
               join caa in dbcontext.CustomerAddressAssociations on c.CustomerPK equals caa.CustomerFK
               join a in dbcontext.Addresses on caa.AddressFK equals a.AddressPK
               join sc in dbcontext.StateCodes on a.StateAbbrFK equals sc.StateAbbrPK
               join at in dbcontext.AddressTypes on caa.AddressTypeFK equals at.AddressTypePK
               join cpa in dbcontext.CustomerPhoneAssociations on c.CustomerPK equals cpa.CustomerFK
               join p in dbcontext.Phones on cpa.PhoneFK equals p.PhonePK
               join b in dbcontext.BillTypes on c.BillTypeFK equals b.BillTypePK

               where (c.CustomerPK == id)
               select new AccountServiceModel
               {
                   AccountNumber = c.CustomerPK,
                   Customer = c.Name,
                   FirstName = u.FirstName,
                   LastName = u.LastName,
                   Address1 = a.Address1,
                   Address2 = a.Address2,
                   City = a.City,
                   State = sc.StateAbbr,
                   Zip = a.ZipCode,
                   Phone = p.Phone1,
                   Email = u.Email,
                   BillType = b.BillType1,
                   isActive = u.IsActive
               };

            var viewModel2 =
                from e in dbcontext.Employees
                join eca in dbcontext.EmployeeCustomerAssociations on e.EmployeePK equals eca.EmployeeFK
                join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID
                join u in dbcontext.Users on e.UsersFK equals u.UserPK
                where (eca.CustomerFK == id)
                select new EmployeeCustomerAssociaitionModel
            {
                AccountNumber = eca.CustomerFK,
                EmployeeType = et.EmployeeType1,
                employeePK = e.EmployeePK,
                FirstName = u.FirstName,
                LastName = u.LastName,
                EmployeeUserPK = u.UserPK
            };



            AccountServiceWithEmployeeModel x = new AccountServiceWithEmployeeModel();
            var parent =
         from ch in dbcontext.CustomerHierarchies
         where (ch.CustomerFK == id)
         select ch;


            if (parent.FirstOrDefault().CustomerFK == parent.FirstOrDefault().CustomerParentFK) //self
            {
                x.ParentName = "Self";

            }
            else


                if (parent.FirstOrDefault().CustomerParentFK == null) //parent
                {

                    x.ParentName = "This is a parent";

                }
                else
                {
                    //parent
                    var findparent = from p in dbcontext.Customers
                                     where p.CustomerPK == (parent.FirstOrDefault().CustomerParentFK)
                                     select p;
                    x.ParentName = findparent.FirstOrDefault().Name;

                }


            x.AccountServiceModel = viewModel.Single(c => c.AccountNumber == id);
            x.EmployeeCustomerAssociaitionModel = viewModel2;







            //from u in dbcontext.Users
            //join c in dbcontext.Customers on u.CustomerFK equals c.CustomerPK
            //join eca in dbcontext.EmployeeCustomerAssociations on c.CustomerPK equals eca.CustomerFK
            //join e in dbcontext.Employees on u.UserPK equals e.UsersFK
            //join et in dbcontext.EmployeeTypes on e.EmployeeTypeFK equals et.EmployeeTypeID

            //where (c.CustomerPK == id)
            //select new EmployeeCustomerAssociaitionModel
            //{
            //    AccountNumber = c.CustomerPK,
            //    EmployeeType = et.EmployeeType1,
            //    employeePK = e.EmployeePK,
            //    FirstName = u.FirstName,
            //    LastName = u.LastName,
            //    EmployeeUserPK = u.UserPK
            //};

            //return View(viewModel.Single(c=>c.AccountNumber==id));
            return View(x);
        }



        public ActionResult CustomerImport(int id)
        {
            SemplestEntities dbcontext = new SemplestEntities();


            CustomerImport x = new CustomerImport();

            /////////////////////////////////////////////////////////////////////////////////
            //for billtype dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var allbilltypes = (from a in dbcontext.BillTypes select a).ToList();

            x.SelectedBillTypeID = 1;
            x.BillTypes = allbilltypes.Select(r => new SelectListItem
            {
                Value = r.BillTypePK.ToString(),
                Text = r.BillType1.ToString()
            });


            //for roles dropdown
            /////////////////////////////////////////////////////////////////////////////////
            var roles = (from r in dbcontext.Roles select r).ToList().OrderBy(r => r.RoleName);

            x.Roles = roles.Select(r => new SelectListItem
            {
                Value = r.RolePK.ToString(),
                Text = r.RoleName.ToString()
            });

            x.ParentID = id;
            return View(x);

        }


       


        public ActionResult CustomerImportResult(ImportResultModel m)
        {
            return View(m);
        }


        [AcceptVerbs(HttpVerbs.Post)]
        public ActionResult Upload(HttpPostedFileBase uploadFile, CustomerImport imp, FormCollection fc)
        {
            string importstatus;
            importstatus  = "The import was the successful..";
            SemplestEntities dbcontext = new SemplestEntities();
            

            {

                StringBuilder strValidations = new StringBuilder(string.Empty);
                try
                {
                    if (uploadFile.ContentLength > 0)
                    {
                        string filePath = Path.Combine(HttpContext.Server.MapPath("../Uploads"),
                        Path.GetFileName(uploadFile.FileName));
                        uploadFile.SaveAs(filePath);
                        FileHelperEngine engine = new FileHelperEngine(typeof(CustomerImportData));
                        engine.ErrorManager.ErrorMode = ErrorMode.SaveAndContinue;

                        CustomerImportData[] customersimported = (CustomerImportData[])engine.ReadFile(filePath);


                        if (engine.ErrorManager.HasErrors)
                            foreach (ErrorInfo err in engine.ErrorManager.Errors)
                            {
                                string s;
                                s = err.LineNumber + " / " + err.RecordString + " / " + err.ExceptionInfo.ToString();

                                //Console.WriteLine(err.LineNumber);    
                                //Console.WriteLine(err.RecordString);   
                                //Console.WriteLine(err.ExceptionInfo.ToString());
                            }

                        if (customersimported.Count() < 1) throw new Exception("No customers could be imported from csv file");
                        ///////////
                        ///////////


                        foreach (CustomerImportData cust in customersimported)
                        {

                            CustomerAccount m = new CustomerAccount();


                            #region
                            //cust.ContactCompanyName;
                            //cust.ContactEmail;
                            //cust.ContactFirstName;
                            //cust.ContactLastName;
                            //cust.ContactMiddleInitial;
                            //cust.ContactPhoneNumber;
                            //cust.ContactAddressLine1;
                            //cust.ContactAddressLine2;
                            //cust.ContactCity;
                            //cust.ContactState;
                            //cust.ContactStatus;
                            //cust.ContactZip;
                            //cust.FixedMonthlybudget;
                            //cust.InternalCustomerID;
                            ///////
                            //cust.LocalTargetAddress1;
                            //cust.LocalTargetAddress2;
                            //cust.LocalTargetAddress3;
                            //cust.LocalTargetProximity1;
                            //cust.LocalTargetProximity1;
                            //cust.LocalTargetProximity2;
                            //cust.LocalTargetProximity3;
                            //cust.ParentCompanyName;

                            //ca.Address1;
                            //ca.Address2;
                            //ca.City;
                            //ca.Customer;
                            //ca.Email;
                            //ca.FirstName;
                            //ca.MiddleInitial;
                            //ca.Phone;
                            //ca.State;
                            //ca.UserID;
                            //ca.UserPassword;
                            //ca.Zip;
                            //ca.isActive;
                            #endregion

                            /*
                        //cust.ContactStatus;
                        cust.FixedMonthlybudget;
                        //cust.InternalCustomerID;
                        /////
                        cust.LocalTargetAddress1;
                        cust.LocalTargetAddress2;
                        cust.LocalTargetAddress3;
                        cust.LocalTargetProximity1;
                        cust.LocalTargetProximity2;
                        cust.LocalTargetProximity3;
                        cust.ParentCompanyName;
                        /////
                        */

                            m.internalID = cust.InternalCustomerID;
                            m.Address1 = cust.ContactAddressLine1;
                            m.Address2 = cust.ContactAddressLine2;
                            m.City = cust.ContactCity;
                            m.Customer = cust.ContactCompanyName;
                            m.Email = cust.ContactEmail;
                            m.FirstName = cust.ContactFirstName;
                            m.MiddleInitial = cust.ContactMiddleInitial;
                            m.LastName = cust.ContactLastName;
                            m.Phone = cust.ContactPhoneNumber;
                            m.State = cust.ContactState;
                            m.UserID = cust.ContactEmail;
                            m.UserPassword = Semplest.SharedResources.Helpers.RandomPassword.Generate(8, 10);
                            m.Zip = cust.ContactZip;
                            m.isActive = true;


                            var emailtemplate = (from et in dbcontext.EmailTemplates
                                                 where et.EmailTemplatePK.Equals(13)
                                                 select et).FirstOrDefault();
                                                        
                            try
                            {
                                var existing = (from ex in dbcontext.Customers
                                                where ex.InternalCustomerId.Equals(cust.InternalCustomerID) && ex.Name.Equals(m.Customer)
                                                select ex).ToList();

                                if (existing.Count() > 0) throw new Exception();


                                ProductGroupCycleType pgct = dbcontext.ProductGroupCycleTypes.First(p => p.ProductGroupCycleType1 == "Product Group Cycle 30");

                                //Customer c = dbcontext.Customers.Add(new Customer { Name = m.Customer, BillTypeFK = imp.SelectedBillTypeID, ProductGroupCycleType = pgct, InternalCustomerId = cust.InternalCustomerID });
                                var c = new Customer { Name = m.Customer, BillTypeFK = imp.SelectedBillTypeID, ProductGroupCycleType = pgct, InternalCustomerId = cust.InternalCustomerID };
                                dbcontext.Customers.AddObject(c);
                                var u = new User
                                {
                                    Customer = c,
                                    Email = m.Email,
                                    FirstName = m.FirstName,
                                    LastName = m.LastName,
                                    MiddleInitial = m.MiddleInitial,
                                    IsActive = m.isActive
                                };
                                dbcontext.Users.AddObject(u);

                                var cr = new Credential { User = u, UsersFK = u.UserPK, Username = m.UserID, Password = m.UserPassword };
                                dbcontext.Credentials.AddObject(cr);


                                PhoneType pt = dbcontext.PhoneTypes.First(p => p.PhoneType1 == "Business"); // --- phone types --- !!!!
                                Phone ph = new Phone { Phone1 = m.Phone, PhoneType = pt };
                                dbcontext.Phones.AddObject(ph);
                                
                                var cpa = new CustomerPhoneAssociation { Customer = c, Phone = ph };
                                dbcontext.CustomerPhoneAssociations.AddObject(cpa);

                                StateCode sc = dbcontext.StateCodes.First(p => p.StateAbbr == m.State);
                                AddressType at = dbcontext.AddressTypes.First(p => p.AddressType1 == "H"); // --- address types --- !!!
                                var a = new Address { Address1 = m.Address1, Address2 = m.Address2, City = m.City, ZipCode = m.Zip, StateCode = sc };
                                dbcontext.Addresses.AddObject(a);
                                var caa = new CustomerAddressAssociation { Address = a, Customer = c, AddressType = at };
                                dbcontext.CustomerAddressAssociations.AddObject(caa);

                                var cn = new CustomerNote { Customer = c, Note = m.CustomerNote };
                                dbcontext.CustomerNotes.AddObject(cn);

                                var r = dbcontext.Roles.First(p => p.RolePK == imp.SelectedRoleID);
                                var ura = new UserRolesAssociation { Role = r, User = u };
                                dbcontext.UserRolesAssociations.AddObject(ura);

                                //default to the parent's rep and salesperson

                                var parentrepandsales = (from prs in dbcontext.EmployeeCustomerAssociations
                                                         where prs.CustomerFK.Equals(imp.ParentID)
                                                         select prs).ToList();
                                foreach (EmployeeCustomerAssociation eca in parentrepandsales)
                                {
                                    var addrepandsales = new EmployeeCustomerAssociation { Customer = c, EmployeeFK = eca.EmployeeFK };
                                    dbcontext.EmployeeCustomerAssociations.AddObject(addrepandsales);
                                }

                                //add child to parent in customerhierarchy
                                var ch = new CustomerHierarchy { CustomerFK = c.CustomerPK, CustomerParentFK = imp.ParentID };
                                dbcontext.CustomerHierarchies.AddObject(ch);
                                dbcontext.SaveChanges();

                                if (fc["sendcustomeremail"] != null)
                                {

                                    ///////////////////////////////////////////////////////////////
                                    //FOR SENDING OUT EMAILS
                                    /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// ///

                                    var parentdetails = from usr in dbcontext.Users
                                                        join cus in dbcontext.Customers on usr.CustomerFK equals cus.CustomerPK
                                                        where usr.CustomerFK == imp.ParentID
                                                        select new { usr.CustomerFK, usr.Email, cus.Name };

                                    //send mail //revisit
                                    string from = parentdetails.FirstOrDefault().Email;
                                    string to = u.Email;
                                    string body = emailtemplate.EmailBody;
                                    string subject = emailtemplate.EmailSubject;
                                    body = body.Replace("[ChildCustomerFirstLast]", u.FirstName.ToString() + " " + u.LastName.ToString());
                                    body = body.Replace("[ParentCustomerName]", parentdetails.FirstOrDefault().Name.ToString());
                                    body = body.Replace("[FAQs]", "http://faq");
                                    body = body.Replace("[ChildCustomerUserID]", cr.Username.ToString());
                                    body = body.Replace("[ChildCustomerPassword]", cr.Password.ToString());
                                    body = body.Replace("[INSERT LINK]", "http://encrypto");

                                    //SendEmail
                                    bool sent = false;
                                    ServiceClientWrapper scw = new ServiceClientWrapper();
                                    sent = scw.SendEmail(subject, from, to, body);
                                }
                                                            
                            }
                            catch (Exception ex)
                            {
                                //Console.WriteLine(ex.TargetSite);
                                SemplestEntities _dbContext = new SemplestEntities();
                                SemplestModel.Error er = new SemplestModel.Error();
                                er.ErrorMessage = ex.Message+"  \r\n "+ex.InnerException  +"  \r\n "+ex.StackTrace +"  \r\n "+ex.Source+"  \r\n "+ex.TargetSite;
                                //filterContext.RequestContext.HttpContext.Session
                                //if (HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] == null)
                                //    er.UsersFK = 1;
                                //else
                                //    er.UsersFK = ((Credential)HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]) == null ? 1 : ((Credential)HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]).UsersFK;
                                er.CreatedDate = DateTime.Now;
                                _dbContext.Errors.AddObject(er);
                                _dbContext.SaveChanges();
                                
                                var scw = new ServiceClientWrapper();
                                scw.SendEmail("WebSite Error Message", "website@semplest.com", _dbContext.Configurations.First().OnErrorEmail, er.ErrorMessage);
                            }
                        }//endforeach

                    }
                    else throw new Exception();

                }
                catch (Exception ex)
                {
                    importstatus = "An error has occured. Please check the file for errors and try again..";
                    //Console.WriteLine(ex.TargetSite);
                    SemplestEntities _dbContext = new SemplestEntities();
                    SemplestModel.Error er = new SemplestModel.Error();
                    er.ErrorMessage = ex.Message + "  \r\n " + ex.InnerException + "  \r\n " + ex.StackTrace + "  \r\n " + ex.Source + "  \r\n " + ex.TargetSite;
                    //filterContext.RequestContext.HttpContext.Session
                    //if (HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID] == null)
                    //    er.UsersFK = 1;
                    //else
                    //    er.UsersFK = ((Credential)HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]) == null ? 1 : ((Credential)HttpContext.Current.Session[Semplest.SharedResources.SEMplestConstants.SESSION_USERID]).UsersFK;
                    er.CreatedDate = DateTime.Now;
                    _dbContext.Errors.AddObject(er);
                    _dbContext.SaveChanges();
                    var scw = new ServiceClientWrapper();
                    scw.SendEmail("WebSite Error Message", "website@semplest.com", _dbContext.Configurations.First().OnErrorEmail, er.ErrorMessage);

                }


                /*
                 
                 *   public Boolean SendEmail(String subject, String from, String recipient, String msgTxt)
        {
            var jsonHash = new Dictionary<string, string>();
            jsonHash.Add("subject", subject);
            jsonHash.Add("from", from);
            jsonHash.Add("recipient", recipient);
            jsonHash.Add("msgTxt", msgTxt);
            string jsonstr = JsonConvert.SerializeObject(jsonHash);
            string returnData = runMethod(_baseURLTest, MAILSERVICEOFFERED, "SendEmail", jsonstr, timeoutMS);
            var dict = JsonConvert.DeserializeObject<Dictionary<string, string>>(returnData);
            string boolResult = dict.Values.First();
            return Convert.ToBoolean(boolResult);
        }
                 
                 */



                //scope.Complete();
            }

            //return View(m);

            ImportResultModel res = new ImportResultModel();
            res.Importresult = importstatus;
            return RedirectToAction("CustomerImportResult", "AccountService",   res );
        }
      


        [IgnoreFirst(1)] 
        [DelimitedRecord(",")]
        public class CustomerImportData
        {
            public string ParentCompanyName;
            public string ContactCompanyName;	
            public string ContactFirstName;	
            public string ContactMiddleInitial;
            public string ContactLastName;
            public string ContactPhoneNumber;
            public string ContactEmail;
            public string ContactAddressLine1;
            public string ContactAddressLine2;
            public string ContactCity;
            public string ContactState;
            public string ContactZip;
            public string ContactStatus;
            public string  InternalCustomerID;
            public decimal FixedMonthlybudget;
            [FieldQuotedAttribute]
            public string LocalTargetAddress1;
            [FieldQuotedAttribute]
            public string LocalTargetProximity1;
            [FieldQuotedAttribute]
            public string LocalTargetAddress2;
            [FieldQuotedAttribute]
            public string LocalTargetProximity2;
            [FieldQuotedAttribute]
            public string LocalTargetAddress3;
            [FieldQuotedAttribute]
            public string LocalTargetProximity3;
           
        }
        
    }
}


