using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Semplest.SharedResources.Models
{
    public class ProfileModel
    {
        [Required]
        [Display(Name = "User name")]
        public string UserName { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [Display(Name = "Password")]
        public string Password1 { get; set; }

        [Display(Name = "New Password")]
        public string Password2 { get; set; }
        [Display(Name = "Verify Password")]
        public string Password3 { get; set; }
        
        [Display(Name = "Security Question")]
        public string SecurityQuestion { get; set; }
        [Display(Name = "Security Answer")]
        public string SecurityAnswer { get; set; }

        public bool IsRegistered;
        public bool LoggedInSucceeded;
        public string LoginFailedMessage { get; set; }
    }
}