using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using SemplestModel;
using SharedResources.Helpers;

namespace Semplest.SharedResources.Models
{
    public class ProfileModel : ModelBase
    {
        public ProfileModel()
        {
            using (var entities = new SemplestEntities())
                Configuration = entities.Configurations.FirstOrDefault();
        }

        [Required]
        [Display(Name = "User name")]
        public string UserName { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [Display(Name = "Password")]
        public string Password1 { get; set; }

        [ComparePassword("Password3")]
        [DataType(DataType.Password)]
        [Display(Name = "New Password")]
        public string Password2 { get; set; }
        
        [DataType(DataType.Password)]
        [Display(Name = "Verify Password")]
        public string Password3 { get; set; }
        
        [Display(Name = "Security Question")]
        public string SecurityQuestion { get; set; }
        [Display(Name = "Security Answer")]
        public string SecurityAnswer { get; set; }

        public bool IsRegistered { get; set; }

        [Display(Name = "Loggedinsucceded")]
        public bool LoggedInSucceeded { get; set; }
        public string LoginFailedMessage { get; set; }
    }
}