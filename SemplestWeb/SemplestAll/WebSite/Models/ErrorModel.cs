using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SemplestModel;

namespace Semplest.WebSite.Models
{
    public class ErrorModel
    {
        public string MsgToShow { get; set; }
        public string MsgToLog { get; set; }
    }
    public class StaticModel : ModelBase
    {
        public StaticModel(string pageType)
        {
            using (var entities = new SemplestModel.Semplest())
            {
                switch (pageType)
                {
                    case "About":
                        Text = entities.WebsiteWebContents.FirstOrDefault().AboutUs;
                        Title = "About Us";
                        break;
                    case "FAQ":
                        Text = entities.WebsiteWebContents.FirstOrDefault().FAQ;
                        Title = "FAQs";
                        break;
                    case "Contact":
                        Text = entities.WebsiteWebContents.FirstOrDefault().ContactUs;
                        Title = "Contact Us";
                        break;
                    case "PrivacyPolicy":
                        Text = entities.WebsiteWebContents.FirstOrDefault().PrivacyPolicy;
                        Title = "Privacy Policy";
                        break;
                    case "TermsAndConditions":
                        Text = entities.WebsiteWebContents.FirstOrDefault().TermsAndConditions;
                        Title = "Terms and Conditions";
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
            string returnText;
            //returnText = Text.Replace("[~IMAGE_BEGIN]", "<img src=\"" + System.Configuration.ConfigurationManager.AppSettings["LogoURL"].ToString()).Replace("[~IMAGE_END]", "\" />");
            returnText = Text;

            return returnText;
        }
    }
}