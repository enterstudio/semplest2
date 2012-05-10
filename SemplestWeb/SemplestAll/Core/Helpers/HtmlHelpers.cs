using System;
using System.Globalization;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Mvc.Html;

namespace Semplest.Core.Helpers
{
    public static class HtmlHelpers
    {
        public static IHtmlString LinkToAddNestedForm<TModel>(this HtmlHelper<TModel> htmlHelper, string linkText,
                                                              string containerElement, string counterElement,
                                                              string collectionProperty, Type nestedType)
        {
            long ticks = DateTime.UtcNow.Ticks;
            object nestedObject = Activator.CreateInstance(nestedType);
            string partial = htmlHelper.EditorFor(x => nestedObject).ToHtmlString().JsEncode();
            partial = partial.Replace("id=\\\"nestedObject", "id=\\\"" + collectionProperty + "_" + ticks + "_");
            partial = partial.Replace("name=\\\"nestedObject", "name=\\\"" + collectionProperty + "[" + ticks + "]");
            string js = string.Format("javascript:addNestedForm('{0}','{1}','{2}','{3}');return false;",
                                      containerElement, counterElement, ticks, partial);
            var tb = new TagBuilder("button");
            tb.Attributes.Add("onclick", js);
            tb.InnerHtml = "<span class=\"k-add k-icon\"></span>" + linkText;
            tb.Attributes.Add("class", "k-button");
            string tag = tb.ToString(TagRenderMode.Normal);
            return MvcHtmlString.Create(tag);
        }
        public static IHtmlString LinkToAddNestedForm<TModel>(this HtmlHelper<TModel> htmlHelper, string linkText,
                                                              string containerElement, string counterElement,
                                                              string collectionProperty, Type nestedType, string prefix)
        {
            long ticks = DateTime.UtcNow.Ticks;
            object nestedObject = Activator.CreateInstance(nestedType);
            string partial = htmlHelper.EditorFor(x => nestedObject).ToHtmlString().JsEncode();
            partial = partial.Replace("id=\\\"AdModelProp_nestedObject", "id=\\\"" + collectionProperty.Replace(".", "_") + "_" + ticks + "_");
            partial = partial.Replace("name=\\\"AdModelProp.nestedObject", "name=\\\"" + collectionProperty.Replace(".", "_") + "[" + ticks + "]");
            string js = string.Format("javascript:addNestedForm('{0}','{1}','{2}','{3}');return false;",
                                      containerElement, counterElement, ticks, partial);
            var tb = new TagBuilder("button");
            tb.Attributes.Add("onclick", js);
            tb.InnerHtml = "<span class=\"k-add k-icon\"></span>" + linkText;
            tb.Attributes.Add("class", "k-button");
            string tag = tb.ToString(TagRenderMode.Normal);
            return MvcHtmlString.Create(tag);
        }

        public static IHtmlString LinkToRemoveNestedForm(this HtmlHelper htmlHelper, string linkText, string container,
                                                         string deleteElement)
        {
            string js = string.Format("javascript:removeNestedForm(this,'{0}','{1}');return false;", container,
                                      deleteElement);
            var tb = new TagBuilder("button");
            tb.Attributes.Add("onclick", js);
            tb.Attributes.Add("class", "k-button");
            tb.InnerHtml = "<span class=\"k-delete k-icon\"></span>" + linkText;
            string tag = tb.ToString(TagRenderMode.Normal);
            return MvcHtmlString.Create(tag);
        }

        private static string JsEncode(this string s)
        {
            if (string.IsNullOrEmpty(s)) return "";
            int i;
            int len = s.Length;
            var sb = new StringBuilder(len + 4);

            for (i = 0; i < len; i += 1)
            {
                char c = s[i];
                switch (c)
                {
                    case '>':
                    case '"':
                    case '\\':
                        sb.Append('\\');
                        sb.Append(c);
                        break;
                    case '\b':
                        sb.Append("\\b");
                        break;
                    case '\t':
                        sb.Append("\\t");
                        break;
                    case '\n':
                        //sb.Append("\\n");
                        break;
                    case '\f':
                        sb.Append("\\f");
                        break;
                    case '\r':
                        //sb.Append("\\r");
                        break;
                    default:
                        if (c < ' ')
                        {
                            //t = "000" + Integer.toHexString(c); 
                            var tmp = new string(c, 1);
                            string t = "000" + int.Parse(tmp, NumberStyles.HexNumber);
                            sb.Append("\\u" + t.Substring(t.Length - 4));
                        }
                        else
                        {
                            sb.Append(c);
                        }
                        break;
                }
            }
            return sb.ToString();
        }
    }
}
