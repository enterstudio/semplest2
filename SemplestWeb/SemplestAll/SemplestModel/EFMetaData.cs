using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web.Mvc;

namespace SemplestModel
{
    [MetadataType(typeof(ConfigurationMetadata))]
    public partial class Configuration
    { }
    public class ConfigurationMetadata
    {
        [DisplayName("Minimum Order Amount:")]
        public decimal CustomerMinOrderAmount { get; set; }
        [DisplayName("Default SEMplest Monthly Flat Fee:")]
        public decimal CustomerDefaultMonthlyFlatFeeAmount { get; set; }
        [DisplayName("Default SEMplest Per Campaign Flat Fee:")]
        public decimal CustomerDefaultPerCampaignFlatFeeAmount { get; set; }
        [DisplayName("Default Per Ad Group Flat Fee:")]
        public decimal CustomerDefaultPerAdGroupFlatFeeAmount { get; set; }
        [DisplayName("Default SEMplest Media Commission:")]
        public decimal DefaultMediaComissionPercentage { get; set; }
        [DisplayName("Default Salesperson Commission Percetnage:")]
        public decimal DefaultSalesPersonCommissionPercentage { get; set; }
        [DisplayName("Min Salesperson Commission Percentage:")]
        public decimal MinSalespersonCommissionPercentage { get; set; }
        [DisplayName("Max Salesperson Commission Percentage:")]
        public Nullable<decimal> MaxSalespersonCommissionPercentage { get; set; }
        [DisplayName("Default Budget Mix:")]
        public Nullable<decimal> DefalutBudgetMixPercentageGoogle { get; set; }
        [DisplayName("Default Budget Mix:")]
        public Nullable<decimal> DefalutBudgetMixPercentageBing { get; set; }
        [DisplayName("SEMplese Banner Image:")]
        public string DefaultSemplestBannerImageUrl { get; set; }
        [DisplayName("SEMplest Style Sheet:")]
        public string DefaultSemplestStyleSheetUrl { get; set; }
        [DisplayName("Maximum # of sitelinks:")]
        public Nullable<int> MaxNumberOfSitelinks { get; set; }
        [DisplayName("Last account number used:")]
        public Nullable<int> LastAccountNumberUsed { get; set; }
        [DisplayName("Last SEMplest Emplyee ID used:")]
        public Nullable<int> LastSEMplestEmployeeIDused { get; set; }
        public string DefaultEmailContactUs { get; set; }
        public string DefalutEmailContactMe { get; set; }
        [DisplayName("Default Product Group Name:")]
        public string DefaultProductGroupName { get; set; }
        [DisplayName("Default Product/Promotion Name:")]
        public string DefaultProductPromotionName { get; set; }
        public string SamplestDevelopmentEmail { get; set; }
        public string SemplestDefaultBudgetMarkUpOrDown { get; set; }
    }


    [MetadataType(typeof(RoleMetaData))]
    public partial class Role { }
    public class RoleMetaData
    {
        [HiddenInput(DisplayValue = false)]
        public int RolePK { get; set; }
        [DisplayName("Role Name:")]
        public string RoleName { get; set; }
    }

    public partial class GeoTargeting
    {
        public List<StateCode> StateCodes
        {
            get { return new SemplestEntities().StateCodes.ToList(); }
        }
    }

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
        [RegularExpression("^[a-z0-9_\\+-]+(\\.[a-z0-9_\\+-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,4})$")]
        public string email { get; set; }
    }

}
