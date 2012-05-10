using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Web.Mvc;

namespace SemplestModel.Validations
{
    public abstract class MultiFieldRequiredAttribute : ValidationAttribute
    {
        private readonly string[] fields;
        protected MultiFieldRequiredAttribute(string[] fields)
        {
            this.fields = fields;
        }
        public string[] Field1
        {
            get { return fields; }
        }
    }
    [AttributeUsage(AttributeTargets.Property)]
    public class TwoCompareAttribute : ValidationAttribute, IClientValidatable
    {
        // Methods
        public TwoCompareAttribute(string otherProperty)
            : base("Required")
        {
            if (otherProperty == null)
            {
                throw new ArgumentNullException("otherProperty");
            }
            OtherProperty = otherProperty;
        }

        public override string FormatErrorMessage(string name)
        {
            return string.Format(CultureInfo.CurrentCulture, ErrorMessageString, new object[] { name, this.OtherProperty });
        }

        public static string FormatPropertyForClientValidation(string property)
        {
            if (property == null)
            {
                throw new ArgumentException("property is Required", "property");
            }
            return ("*." + property);
        }

        public IEnumerable<ModelClientValidationRule> GetClientValidationRules(ModelMetadata metadata, ControllerContext context)
        {
            yield return new ModelClientValidationEqualToRule(this.FormatErrorMessage(metadata.GetDisplayName()), FormatPropertyForClientValidation(this.OtherProperty)) { ValidationType = "twofieldrequired" };
        }

        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            //PropertyInfo property = validationContext.ObjectType.GetProperty(this.OtherProperty);
            //if (property == null)
            //{
            //    return new ValidationResult(string.Format(CultureInfo.CurrentCulture, "UnknownProperty", new object[] { this.OtherProperty }));
            //}
            //object objB = property.GetValue(validationContext.ObjectInstance, null);
            //if (!object.Equals(value, objB))
            //{
            //    return new ValidationResult(this.FormatErrorMessage(validationContext.DisplayName));
            //}
            //return null;

            var property = validationContext.ObjectType.GetProperty(OtherProperty);
            if (property == null)
                return new ValidationResult(string.Format("Property '{0}' is undefined.", OtherProperty));

            var fieldValue = property.GetValue(validationContext.ObjectInstance, null);

            var property1 = validationContext.ObjectType.GetProperty(validationContext.DisplayName);
            if (property1 == null)
                return new ValidationResult(string.Format("Property '{0}' is undefined.", validationContext.DisplayName));

            var fieldValue1 = property1.GetValue(validationContext.ObjectInstance, null);

            if ((fieldValue == null || String.IsNullOrEmpty(fieldValue.ToString())) && (fieldValue1 == null || String.IsNullOrEmpty(fieldValue1.ToString())))
                return ValidationResult.Success;
            if (fieldValue != null && fieldValue1 == null)
                return new ValidationResult(FormatErrorMessage(validationContext.DisplayName));
            return null;
        }

        // Properties
        public string OtherProperty { get; private set; }


    }


    public class TwoFieldRequiredAttribute : MultiFieldRequiredAttribute, IClientValidatable
    {
        private readonly string field1;
        private readonly string field2;
        public TwoFieldRequiredAttribute(string field1, string field2)
            : base(new[] { field1, field2 })
        {
            this.field1 = field1;
            this.field2 = field2;
        }
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            var property = validationContext.ObjectType.GetProperty(field1);
            if (property == null)
                return new ValidationResult(string.Format("Property '{0}' is undefined.", field1));

            var fieldValue = property.GetValue(validationContext.ObjectInstance, null);

            var property1 = validationContext.ObjectType.GetProperty(field2);
            if (property1 == null)
                return new ValidationResult(string.Format("Property '{0}' is undefined.", field2));

            var fieldValue1 = property1.GetValue(validationContext.ObjectInstance, null);

            if ((fieldValue == null || String.IsNullOrEmpty(fieldValue.ToString())) && (fieldValue1 == null || String.IsNullOrEmpty(fieldValue1.ToString())))
                return ValidationResult.Success;
            if (fieldValue != null && fieldValue1 == null)
                return new ValidationResult(FormatErrorMessage(validationContext.DisplayName));
            return null;

        }

        public IEnumerable<ModelClientValidationRule> GetClientValidationRules(ModelMetadata metadata, ControllerContext context)
        {
            var rule = new ModelClientValidationRule
            {
                ErrorMessage = ErrorMessage,
                ValidationType = "twofieldrequired"
            };
            var field1Prop = BuildDependentPropertyId(field1, metadata, context as ViewContext);
            var field2Prop = BuildDependentPropertyId(field2, metadata, context as ViewContext);
            rule.ValidationParameters["properties"] = string.Join(",", field1Prop, field2Prop);

            yield return rule;
        }
        private string BuildDependentPropertyId(string dependentProperty, ModelMetadata metadata, ViewContext viewContext)
        {
            // build the ID of the property
            string depProp = viewContext.ViewData.TemplateInfo.GetFullHtmlFieldId(dependentProperty);
            // unfortunately this will have the name of the current field appended to the beginning,
            // because the TemplateInfo's context has had this fieldname appended to it. Instead, we
            // want to get the context as though it was one level higher (i.e. outside the current property,
            // which is the containing object (our Person), and hence the same level as the dependent property.
            var thisField = metadata.PropertyName + "_";
            if (depProp.StartsWith(thisField))
                // strip it off again
                depProp = depProp.Substring(thisField.Length);
            return depProp;
        }
    }

    public class RequiredIfAttribute : ValidationAttribute, IClientValidatable
    {
        private readonly RequiredAttribute innerAttribute = new RequiredAttribute();

        public string DependentProperty { get; set; }
        public object TargetValue { get; set; }

        public RequiredIfAttribute(string dependentProperty, object targetValue)
        {
            DependentProperty = dependentProperty;
            TargetValue = targetValue;
        }

        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            // get a reference to the property this validation depends upon
            var containerType = validationContext.ObjectInstance.GetType();
            var field = containerType.GetProperty(DependentProperty);

            if (field != null)
            {
                // get the value of the dependent property
                var dependentvalue = field.GetValue(validationContext.ObjectInstance, null);

                // compare the value against the target value
                if ((dependentvalue == null && TargetValue == null) ||
                    (dependentvalue != null && dependentvalue.Equals(TargetValue)))
                {
                    // match => means we should try validating this field
                    if (!innerAttribute.IsValid(value))
                        // validation failed - return an error
                        return new ValidationResult(ErrorMessage, new[] { validationContext.MemberName });
                }
            }

            return ValidationResult.Success;
        }

        public IEnumerable<ModelClientValidationRule> GetClientValidationRules(ModelMetadata metadata, ControllerContext context)
        {
            var rule = new ModelClientValidationRule
            {
                ErrorMessage = FormatErrorMessage(metadata.GetDisplayName()),
                ValidationType = "requiredif",
            };

            string depProp = BuildDependentPropertyId(metadata, context as ViewContext);

            // find the value on the control we depend on;
            // if it's a bool, format it javascript style 
            // (the default is True or False!)
            var targetValue = (TargetValue ?? "").ToString();
            if (TargetValue != null && TargetValue is bool)
                targetValue = targetValue.ToLower();

            rule.ValidationParameters.Add("dependentproperty", depProp);
            rule.ValidationParameters.Add("targetvalue", targetValue);

            yield return rule;
        }

        private string BuildDependentPropertyId(ModelMetadata metadata, ViewContext viewContext)
        {
            // build the ID of the property
            string depProp = viewContext.ViewData.TemplateInfo.GetFullHtmlFieldId(DependentProperty);
            // unfortunately this will have the name of the current field appended to the beginning,
            // because the TemplateInfo's context has had this fieldname appended to it. Instead, we
            // want to get the context as though it was one level higher (i.e. outside the current property,
            // which is the containing object (our Person), and hence the same level as the dependent property.
            var thisField = metadata.PropertyName + "_";
            if (depProp.StartsWith(thisField))
                // strip it off again
                depProp = depProp.Substring(thisField.Length);
            return depProp;
        }
    }
}

​