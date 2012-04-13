using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Web.Mvc;
using System.Web.Security;
using System.Web;



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




namespace SemplestAdminApp.Models
{





    
    public class HomeModel
    {
        public string Customer { get; set; }
        public int AccountNumber { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Email { get; set; }
    }


    public class EmployeeCustomerAssociaitionModel
    {
                public int AccountNumber { get; set; }
                public string EmployeeType { get; set; }
                public int employeePK { get; set; }
                public string FirstName { get; set; }
                public string LastName  { get; set; }
                public int EmployeeUserPK { get; set; }
    }


    public class AccountServiceModel
    {
        public int AccountNumber { get; set; }
        public string Customer { get; set; }
        public string FirstName { get; set; }
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
