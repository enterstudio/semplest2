using SemplestModel;
using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Web.Mvc;
using System.Web.Routing;

namespace Semplest.SharedResources.Helpers
{
    public static class Extensions
    {
        public static bool IsAdmin(this Credential c)
        { return string.IsNullOrEmpty(c.User.CustomerFK.ToString().Trim()); }
    }

    public static class LabelExtensions
    {
        public static MvcHtmlString LabelFor<TModel, TValue>(
            this HtmlHelper<TModel> html,
            Expression<Func<TModel, TValue>> expression,
            object htmlAttributes,bool isTrue
        )
        {
            return LabelHelper(
                html,
                ModelMetadata.FromLambdaExpression(expression, html.ViewData),
                ExpressionHelper.GetExpressionText(expression),
                htmlAttributes
            );
        }

        private static MvcHtmlString LabelHelper(
            HtmlHelper html,
            ModelMetadata metadata,
            string htmlFieldName,
            object htmlAttributes
        )
        {
            //string resolvedLabelText = metadata.DisplayName ?? metadata.PropertyName ?? htmlFieldName.Split('.').Last();
            string resolvedLabelText = metadata.DisplayName ?? metadata.PropertyName ?? string.Empty;
            if (string.IsNullOrEmpty(resolvedLabelText))
            {
                return MvcHtmlString.Empty;
            }

            TagBuilder tag = new TagBuilder("label");
            tag.Attributes.Add("for", TagBuilder.CreateSanitizedId(html.ViewContext.ViewData.TemplateInfo.GetFullHtmlFieldName(htmlFieldName)));
            tag.Attributes.Add("id", TagBuilder.CreateSanitizedId(html.ViewContext.ViewData.TemplateInfo.GetFullHtmlFieldName(htmlFieldName)));
            tag.MergeAttributes(new RouteValueDictionary(htmlAttributes));
            tag.SetInnerText(resolvedLabelText);
            return MvcHtmlString.Create(tag.ToString(TagRenderMode.Normal));
        }
    }
}