﻿#pragma warning disable 1591
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.17626
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

            Layout = "~/Views/Shared/_LogInLayout.cshtml";
            ViewBag.Title = "LogOn";



#line default
#line hidden


#line 6 "..\..\Views\Profile\LogIn.cshtml"
            using (Html.BeginForm())
            {


#line default
#line hidden
                WriteLiteral("    <div id=\"tickets\">\r\n        <h3 style=\"margin-left: 20px;margin-top: 5px; col" +
                "or: grey\">\r\n            Welcome!</h3>\r\n            <ul>\r\n                <li>\r\n " +
                "                   ");



#line 13 "..\..\Views\Profile\LogIn.cshtml"
                Write(Html.LabelFor(t => t.UserName, new { @class = "required" }));


#line default
#line hidden
                WriteLiteral("\r\n                    ");



#line 14 "..\..\Views\Profile\LogIn.cshtml"
                Write(Model.LoggedInSucceeded ? Html.TextBoxFor(m => m.UserName, new { @class = "k-textbox", @readonly = true }) : Html.TextBoxFor(m => m.UserName, new { @class = "k-textbox" }));


#line default
#line hidden
                WriteLiteral("\r\n                    ");



#line 15 "..\..\Views\Profile\LogIn.cshtml"
                Write(Html.ValidationMessageFor(m => m.UserName));


#line default
#line hidden
                WriteLiteral("\r\n                </li>\r\n                <li>\r\n                    ");



#line 18 "..\..\Views\Profile\LogIn.cshtml"
                Write(Html.LabelFor(t => t.Password1, new { @class = "required" }));


#line default
#line hidden
                WriteLiteral("\r\n                    ");



#line 19 "..\..\Views\Profile\LogIn.cshtml"
                Write(Model.LoggedInSucceeded ? Html.PasswordFor(m => m.Password1, new { @class = "k-textbox", @readonly = true, @value = "********" }) : Html.PasswordFor(m => m.Password1, new { @class = "k-textbox" }));


#line default
#line hidden
                WriteLiteral("\r\n                    ");



#line 20 "..\..\Views\Profile\LogIn.cshtml"
                Write(Html.ValidationMessageFor(m => m.Password1));


#line default
#line hidden
                WriteLiteral(" \r\n                </li>\r\n                <li class=\"accept\">\r\n                  " +
                "  ");



#line 23 "..\..\Views\Profile\LogIn.cshtml"
                Write(Html.HiddenFor(m => m.IsRegistered));


#line default
#line hidden
                WriteLiteral("\r\n                    ");



#line 24 "..\..\Views\Profile\LogIn.cshtml"
                Write(Html.HiddenFor(m => m.LoggedInSucceeded));


#line default
#line hidden
                WriteLiteral("</li>\r\n                <li class=\"accept\">\r\n                    <button class=\"k-" +
                "button\" type=\"submit\" id=\"btnSubmit\">\r\n                        Log On</button>\r\n" +
                "                </li>\r\n               \r\n");



#line 30 "..\..\Views\Profile\LogIn.cshtml"
                if (!Model.LoggedInSucceeded)
                {


#line default
#line hidden
                    WriteLiteral("                        <li class=\"status\">\r\n                            ");



#line 33 "..\..\Views\Profile\LogIn.cshtml"
                    Write(Model.LoginFailedMessage);


#line default
#line hidden
                    WriteLiteral("\r\n                        </li>\r\n");



#line 35 "..\..\Views\Profile\LogIn.cshtml"
                }
                else if (!Model.IsRegistered)
                {


#line default
#line hidden

#line 38 "..\..\Views\Profile\LogIn.cshtml"
                    Write(Html.Partial("_Password", Model));


#line default
#line hidden

#line 38 "..\..\Views\Profile\LogIn.cshtml"

                }


#line default
#line hidden
                WriteLiteral("            </ul>\r\n    </div>\r\n");



#line 42 "..\..\Views\Profile\LogIn.cshtml"
            }


#line default
#line hidden
            WriteLiteral(@"<style scoped>
    .k-textbox
    {
        width: 11.8em;
    }
    
    #tickets
    {
    }
    
    #tickets h3
    {
        font-weight: bold;
        font-size: 2em;
    }
    
    #tickets ul
    {
        list-style-type: none;
        margin: 0;
        padding: 0;
        text-align: center;
    }
    #tickets li
    {
        margin: 10px 0 0 0;
        text-align: center;
    }
    
    label
    {
        display: inline-block;
        text-align: right;
        width: 120px;
        margin-left: -50px;
    }
    
    .required
    {
        font-weight: bold;
        margin-right: 5px;
    }
    
    .accept, .status
    {
        text-align: center;
    }
    
    .valid
    {
        color: green;
    }
    
    .invalid
    {
        color: red;
    }
    span.k-tooltip
    {
        margin-left: 6px;
    }
</style>

");


        }
    }
}
#pragma warning restore 1591