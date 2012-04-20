using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace SemplestWebSite.Models
{
    [MetadataType(typeof(SEMCustomerDetailMetaData))]
    public partial class SEMCustomerDetail
    { }
    public class SEMCustomerDetailMetaData
    {
        [Required]
        public string FirstName { get; set; }
        [Required]
        public string LastName { get; set; }
        [Required]
        public string Company { get; set; }

        [DataType(DataType.EmailAddress, ErrorMessage = "Invalid Email Address")] 
        public string email { get; set; }
    }
}