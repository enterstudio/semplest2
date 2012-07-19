using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SharedResources.Models
{
    public class StaticModel : ModelBase
    {
        public StaticModel(StaticPages pageType)
        {
            using (var entities = new SemplestModel.Semplest())
            {
                Configuration = entities.Configurations.FirstOrDefault();
                switch (pageType)
                {
                    case StaticPages.About:
                        Text = Queryable.FirstOrDefault(entities.WebContents).AboutUs;
                        Title = "About Us";
                        break;
                    case StaticPages.FAQ:
                        Text = Queryable.FirstOrDefault(entities.WebContents).FAQ;
                        Title = "FAQs";
                        break;
                    case StaticPages.Contact:
                        Text = Queryable.FirstOrDefault(entities.WebContents).ContactUs;
                        Title = "Contact Us";
                        break;
                    case StaticPages.PrivacyPolicy:
                        Text = Queryable.FirstOrDefault(entities.WebContents).PrivacyPolicy;
                        Title = "Privacy Policy";
                        break;
                    case StaticPages.TermsAndConditions:
                        Text = Queryable.FirstOrDefault(entities.WebContents).TermsAndConditions;
                        Title = "Terms of Use";
                        break;
                    case StaticPages.ServicesAgreement:
                        Text = Queryable.FirstOrDefault(entities.WebContents).ServicesAgreement;
                        Title = "Services Agreement";
                        break;
                    default:
                        Text = "No such Page";
                        break;
                }
            }
        }
        string _Text;
        public string Text
        {
            get { return ReplacePlaceHolders(_Text); }
            set { _Text = value; }
        }
        public string Title { get; set; }

        private string ReplacePlaceHolders(string Text)
        {
            string returnText = Text;
            if (System.Configuration.ConfigurationManager.AppSettings["LogoURL"] != null)
            returnText = Text.Replace("[~IMAGE_BEGIN]", "<img src=\"" + System.Configuration.ConfigurationManager.AppSettings["LogoURL"].ToString()).Replace("[~IMAGE_END]", "\" />");
            return returnText;
        }
    }

    public enum StaticPages { About, FAQ, Contact, PrivacyPolicy, TermsAndConditions, ServicesAgreement }
}