using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace SharedResources.Helpers
{
    public class ComparePassword : ValidationAttribute
    {
        public ComparePassword(string otherPropertyName)
        {
            OtherPropertyName = otherPropertyName;
        }
        public string OtherPropertyName { get; set; }

        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            System.Reflection.PropertyInfo propInfo = validationContext.ObjectType.GetProperty(OtherPropertyName);
            if (propInfo.GetValue(validationContext.ObjectInstance, null) != null)
            {
                string otherPassword = propInfo.GetValue(validationContext.ObjectInstance, null).ToString();
                if (otherPassword != (string)value)
                {
                    return new ValidationResult("Both Passwords should be the same");
                }
            }
            return null;
        }

        
    } 

}