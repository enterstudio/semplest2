//------------------------------------------------------------------------------
// <auto-generated>
//    This code was generated from a template.
//
//    Manual changes to this file may cause unexpected behavior in your application.
//    Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SemplestAdminApp.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Employee
    {
        public Employee()
        {
            this.Customers = new HashSet<Customer>();
        }
    
        public int EmployeePK { get; set; }
        public int EmployeeTypeFK { get; set; }
        public int UsersFK { get; set; }
    
        public virtual EmployeeType EmployeeType { get; set; }
        public virtual User User { get; set; }
        public virtual ICollection<Customer> Customers { get; set; }
    }
}
