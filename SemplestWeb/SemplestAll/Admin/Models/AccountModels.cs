using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Web.Mvc;
using System.Web.Security;
using System.Web;
using Semplest.Admin.Models;
using SemplestModel;
using System.ComponentModel;

public class LoggingHandleErrorAttribute : HandleErrorAttribute
{
    public override void OnException(ExceptionContext filterContext)
    {
        base.OnException(filterContext);

        //if (filterContext.ExceptionHandled)
        //{
        try
        {
            SemplestEntities _dbContext = new SemplestEntities();
            SemplestModel.Error er = new SemplestModel.Error();
            er.ErrorMessage = filterContext.Exception.ToString();
            //filterContext.RequestContext.HttpContext.Session
            er.UsersFK = 1;
            _dbContext.Errors.Add(er);
            _dbContext.SaveChanges();
            //send email
        }
        catch (Exception ex) { Console.WriteLine(ex.ToString()); }
            // Log filterContext.Exception in some way.  
        //}
    }
}  



//This code is used for binding form data to collections
public static class HtmlPrefixScopeExtensions
{
    private const string idsToReuseKey = "__htmlPrefixScopeExtensions_IdsToReuse_";

    public static IDisposable BeginCollectionItem(this HtmlHelper html, string collectionName)
    {
        var idsToReuse = GetIdsToReuse(html.ViewContext.HttpContext, collectionName);
        string itemIndex = idsToReuse.Count > 0 ? idsToReuse.Dequeue() : Guid.NewGuid().ToString();

        // autocomplete="off" is needed to work around a very annoying Chrome behaviour whereby it reuses old values after the user clicks "Back", which causes the xyz.index and xyz[...] values to get out of sync.
        html.ViewContext.Writer.WriteLine(string.Format("<input type=\"hidden\" name=\"{0}.index\" autocomplete=\"off\" value=\"{1}\" />", collectionName, html.Encode(itemIndex)));

        return BeginHtmlFieldPrefixScope(html, string.Format("{0}[{1}]", collectionName, itemIndex));
    }

    public static IDisposable BeginHtmlFieldPrefixScope(this HtmlHelper html, string htmlFieldPrefix)
    {
        return new HtmlFieldPrefixScope(html.ViewData.TemplateInfo, htmlFieldPrefix);
    }

    private static Queue<string> GetIdsToReuse(HttpContextBase httpContext, string collectionName)
    {
        // We need to use the same sequence of IDs following a server-side validation failure,  
        // otherwise the framework won't render the validation error messages next to each item.
        string key = idsToReuseKey + collectionName;
        var queue = (Queue<string>)httpContext.Items[key];
        if (queue == null)
        {
            httpContext.Items[key] = queue = new Queue<string>();
            var previouslyUsedIds = httpContext.Request[collectionName + ".index"];
            if (!string.IsNullOrEmpty(previouslyUsedIds))
                foreach (string previouslyUsedId in previouslyUsedIds.Split(','))
                    queue.Enqueue(previouslyUsedId);
        }
        return queue;
    }

    private class HtmlFieldPrefixScope : IDisposable
    {
        private readonly TemplateInfo templateInfo;
        private readonly string previousHtmlFieldPrefix;

        public HtmlFieldPrefixScope(TemplateInfo templateInfo, string htmlFieldPrefix)
        {
            this.templateInfo = templateInfo;

            previousHtmlFieldPrefix = templateInfo.HtmlFieldPrefix;
            templateInfo.HtmlFieldPrefix = htmlFieldPrefix;
        }

        public void Dispose()
        {
            templateInfo.HtmlFieldPrefix = previousHtmlFieldPrefix;
        }
    }
}




namespace Semplest.Admin.Models
{

    
    public class HomeModel
    {
        public string Customer { get; set; }
        public int AccountNumber { get; set; }
        public string FirstName { get; set; }
        [DisplayName("First Name")] 
        public string LastName { get; set; }
        [DisplayName("Last Name")] 
        public string Email { get; set; }
    }



    public class EmployeeCustomerAssociaitionModel
    {                
                public int AccountNumber { get; set; }
                public string EmployeeType { get; set; }
                public int employeePK { get; set; }
                [DisplayName("First Name")] 
                public string FirstName { get; set; }
                [DisplayName("Middle Initial")] 
                public string MiddleInitial { get; set; }
                [DisplayName("Last Name")] 
                public string LastName  { get; set; }
                public int EmployeeUserPK { get; set; }
     }

    public class EmployeeDropdownModel
    {
        public int ID { get; set; }
        public string Name { get; set; }
    }


    public class AccountServiceModel
    {
        public int AccountNumber { get; set; }
        public string Customer { get; set; }
        [DisplayName("First Name")] 
        public string FirstName { get; set; }
        [DisplayName("Last Name")] 
        public string LastName { get; set; }
        public string Address1 { get; set; }
        public string Address2 { get; set; }
        public string City { get; set; }
        public string State { get; set; }
        public string Zip { get; set; }
        public string Phone { get; set; }
        public string Email { get; set; }
        public string BillType { get; set; }
        //no credit table in the database --> need to add these
        //no rep, salesperson  
      }

    public class CustomerAccount
    {
        public int AccountNumber { get; set; }
        public string Customer { get; set; }
        [DisplayName("First Name")] 
        public string FirstName { get; set; }
        [DisplayName("Middle Initial")] 
        public string MiddleInitial { get; set; }
        [DisplayName("Last Name")] 
        public string LastName { get; set; }
        public string Address1 { get; set; }
        public string Address2 { get; set; }
        public string City { get; set; }
        public string State { get; set; }
        public int StateID { get; set; }
        public string Zip { get; set; }
        public string Phone { get; set; }
        public string Email { get; set; }
        public string BillType { get; set; }
        public int  UserPK { get; set; }
    }

    public class EmployeeSetup
    {
        //employeePK, employeetypefk, UserPK, employeetypeid, rolesFK, FirstName, LastName, Email, rolename, employeetype
        public int EmployeePK { get; set; }
        public int EmployeeTypeFK { get; set; }
        public int UserPK { get; set; }
        public int EmployeeTypeID { get; set; }
        public int RolesFK { get; set; }
        [DisplayName("First Name")] 
        public string FirstName { get; set; }
        [DisplayName("Middle Initail")] 
        public string MiddleInitial { get; set; }
        [DisplayName("Last Name")] 
        public string LastName { get; set; }
        public string Email { get; set; }
        public string RoleName { get; set; }
        public string EmployeeType { get; set; }
        public int ReportingTo { get; set; }
        public bool Active { get; set; }
    }


    public class EmployeeSetupWithRolesModel
    {
        public EmployeeSetup EmployeeSetup { get; set; }

        //for role dropdown
        public int SelectedRoleID { get; set; }
        public IEnumerable<SelectListItem> Roles { get; set; }
        
        
        //for reporting to dropdown
        public int SelectedReportingToID { get; set; }
        public IEnumerable<SelectListItem> ReportingTo { get; set; }

        //for employeetype dropdown
        public int SelectedEmployeeTypeID { get; set; }
        public IEnumerable<SelectListItem> EmployeeTypes { get; set; }
    }

    
    public class CustomerAccountWithEmployeeModel
    {
        public CustomerAccount CustomerAccount { get; set; }
        public IEnumerable<EmployeeCustomerAssociaitionModel> EmployeeCustomerAssociaitionModel { get; set; }
        //public IEnumerable<EmployeeCustomerAssociaitionModel> EmployeeCustomerAssociaitionModel2 { get; set; }

        //public MyListModel MyListModel { get; set; }
        //public int[] employeeitemIDs { get; set; }
        //public List<EmployeeDropdownModel> EmployeeList { get; set; }


        //for state dropdown
        public int SelectedStateID { get; set; }
        public IEnumerable<SelectListItem> States { get; set; }

        //for rep dropdown
        public int SelectedRepID { get; set; }
        public IEnumerable<SelectListItem> Reps { get; set; }

        //for rep dropdown
        public int SelectedSalesPersonID { get; set; }
        public IEnumerable<SelectListItem> SalesPersons { get; set; }

    }


    public class ReportingToModel
    {
        public int EmployeePK { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
    }
    

    public class AccountServiceWithEmployeeModel
    {
        public AccountServiceModel AccountServiceModel { get; set; }
        public IEnumerable<EmployeeCustomerAssociaitionModel> EmployeeCustomerAssociaitionModel { get; set; }
    }


    public class UserRoleModel
    {
        public int RightPK { get; set; }
        public string Controller { get; set; }
        public string Label { get; set; }
        public bool IsVisible { get; set; }
        public bool IsReadonly { get; set; }
    }


    //public class MyListModel
    //{
    //    public string SelectedItemId { get; set; }
    //    public IEnumerable<SelectListItem> Items { get; set; }
    //} 


    
    public class AddUserModel
    {
 
    }

    public class ChangePasswordModel
    {
        [Required]
        [DataType(DataType.Password)]
        [Display(Name = "Current password")]
        public string OldPassword { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = "The {0} must be at least {2} characters long.", MinimumLength = 6)]
        [DataType(DataType.Password)]
        [Display(Name = "New password")]
        public string NewPassword { get; set; }

        [DataType(DataType.Password)]
        [Display(Name = "Confirm new password")]
        [Compare("NewPassword", ErrorMessage = "The new password and confirmation password do not match.")]
        public string ConfirmPassword { get; set; }
    }

    public class LogOnModel
    {
        [Required]
        [Display(Name = "User name")]
        public string UserName { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [Display(Name = "Password")]
        public string Password { get; set; }

        [Display(Name = "Remember me?")]
        public bool RememberMe { get; set; }
    }

    public class RegisterModel
    {
        [Required]
        [Display(Name = "User name")]
        public string UserName { get; set; }

        [Required]
        [DataType(DataType.EmailAddress)]
        [Display(Name = "Email address")]
        public string Email { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = "The {0} must be at least {2} characters long.", MinimumLength = 6)]
        [DataType(DataType.Password)]
        [Display(Name = "Password")]
        public string Password { get; set; }

        [DataType(DataType.Password)]
        [Display(Name = "Confirm password")]
        [Compare("Password", ErrorMessage = "The password and confirmation password do not match.")]
        public string ConfirmPassword { get; set; }
    }
}
