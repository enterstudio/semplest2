﻿#pragma warning disable 1591
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.261
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SharedResources.Views.Profile
{
    using System;
    using System.Collections.Generic;
    using System.IO;
    using System.Linq;
    using System.Net;
    using System.Text;
    using System.Web;
    using System.Web.Helpers;
    using System.Web.Mvc;
    using System.Web.Mvc.Ajax;
    using System.Web.Mvc.Html;
    using System.Web.Routing;
    using System.Web.Security;
    using System.Web.UI;
    using System.Web.WebPages;
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("RazorGenerator", "1.3.2.0")]
    [System.Web.WebPages.PageVirtualPathAttribute("~/Views/Profile/LogIn.cshtml")]
    public class LogIn : System.Web.Mvc.WebViewPage<Semplest.SharedResources.Models.ProfileModel>
    {
        public LogIn()
        {
        }
        public override void Execute()
        {


            
            #line 2 "..\..\Views\Profile\LogIn.cshtml"
  
    ViewBag.Title = "LogOn";


            
            #line default
            #line hidden
WriteLiteral("\r\n<h2>Log In</h2>\r\n\r\n");


            
            #line 8 "..\..\Views\Profile\LogIn.cshtml"
 using (Html.BeginForm())
{

            
            #line default
            #line hidden
WriteLiteral("         <fieldset>\r\n             <legend>Account Information</legend>\r\n         " +
"   <div id=\"options\" align=\"center\" >\r\n            <div class=\"editor-label\">\r\n " +
"               ");


            
            #line 14 "..\..\Views\Profile\LogIn.cshtml"
           Write(Html.LabelFor(m => m.UserName));

            
            #line default
            #line hidden
WriteLiteral("\r\n                ");


            
            #line 15 "..\..\Views\Profile\LogIn.cshtml"
           Write(Html.HiddenFor(m => m.IsRegistered));

            
            #line default
            #line hidden
WriteLiteral("\r\n");


            
            #line 16 "..\..\Views\Profile\LogIn.cshtml"
                 if (Model != null)
                {
            
            #line default
            #line hidden
            
            #line 17 "..\..\Views\Profile\LogIn.cshtml"
            Write(Html.Hidden("LoggedInSucceeded", Model.LoggedInSucceeded));

            
            #line default
            #line hidden
            
            #line 17 "..\..\Views\Profile\LogIn.cshtml"
                                                                           }

            
            #line default
            #line hidden
WriteLiteral("            </div>\r\n            <div class=\"editor-field\">\r\n                ");


            
            #line 20 "..\..\Views\Profile\LogIn.cshtml"
           Write(Html.TextBoxFor(m => m.UserName, new { @class = "k-textbox" }));

            
            #line default
            #line hidden
WriteLiteral("\r\n                ");


            
            #line 21 "..\..\Views\Profile\LogIn.cshtml"
           Write(Html.ValidationMessageFor(m => m.UserName));

            
            #line default
            #line hidden
WriteLiteral("\r\n            </div>\r\n            <div class=\"editor-label\">\r\n                ");


            
            #line 24 "..\..\Views\Profile\LogIn.cshtml"
           Write(Html.LabelFor(m => m.Password1));

            
            #line default
            #line hidden
WriteLiteral("\r\n            </div>\r\n            <div class=\"editor-field\">\r\n                ");


            
            #line 27 "..\..\Views\Profile\LogIn.cshtml"
           Write(Html.PasswordFor(m => m.Password1, new { @class = "k-textbox" }));

            
            #line default
            #line hidden
WriteLiteral("\r\n                ");


            
            #line 28 "..\..\Views\Profile\LogIn.cshtml"
           Write(Html.ValidationMessageFor(m => m.Password1));

            
            #line default
            #line hidden
WriteLiteral("\r\n            </div>\r\n            <p>\r\n                <input type=\"submit\" value" +
"=\"Log On\" class =\"k-button\" id=\"btnSubmit\" />\r\n            </p>\r\n");


            
            #line 33 "..\..\Views\Profile\LogIn.cshtml"
             if (Model != null)
            {
                if (!Model.LoggedInSucceeded)
                {            

            
            #line default
            #line hidden
WriteLiteral("                    <div class=\"editor-label\">");


            
            #line 37 "..\..\Views\Profile\LogIn.cshtml"
                                         Write(Model.LoginFailedMessage);

            
            #line default
            #line hidden
WriteLiteral("</div>\r\n");


            
            #line 38 "..\..\Views\Profile\LogIn.cshtml"
                }
                else if (!Model.IsRegistered)
                {

            
            #line default
            #line hidden
WriteLiteral("                    <div class=\"passwordverify\">");


            
            #line 41 "..\..\Views\Profile\LogIn.cshtml"
                                           Write(Html.Partial("_Password", Model));

            
            #line default
            #line hidden
WriteLiteral("</div>\r\n");


            
            #line 42 "..\..\Views\Profile\LogIn.cshtml"
                }
            }

            
            #line default
            #line hidden
WriteLiteral("            </div>\r\n        </fieldset>\r\n");


            
            #line 46 "..\..\Views\Profile\LogIn.cshtml"
        
}

            
            #line default
            #line hidden
WriteLiteral(@"
<script type=""text/javascript"">
    $(document).ready(function () {
        $(""input[id$='btnSubmit']"").click(function () {
            $.ajax({
                type: ""GET"",
                url: ""/Profile/Verify"",
                data: { userName: $('#UserName').val(), password: $('#Password1').val() },
                success: function (data) { $('.passwordverify').html(data); }
            });
        });
    })
</script>");


        }
    }
}
#pragma warning restore 1591
