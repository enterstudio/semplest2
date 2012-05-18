using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace SharedResources.Helpers
{
    public class ComparePassword : ValidationAttribute
    {
        public string PasswordToCompareWith { get; set; }

        public override bool IsValid(object value)
        {
            if (PasswordToCompareWith == (string)value)
            {
                return true;
            }
            return false;
        }
    } 

}