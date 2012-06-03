﻿using System;
using System.Collections.Generic;
using System.Data;
using System.Dynamic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Web.Mvc;

/// <summary>
/// @Html.CheckBoxList(...) main methods
/// </summary>
internal static class MvcCheckBoxList
{
    // properties
    internal static string no_data_message = "No Records...";

    internal static string empty_model_message = "View Model cannot be null! " +
                                                 "Please make sure your View Model " +
                                                 "is created and passed to this View";

    internal static string empty_name_message = "Name of the CheckBoxList cannot be null or empty";

    static MvcCheckBoxList()
    {
        // reset internal counters
        linked_label_counter = 0;
        htmlwrap_rowbreak_counter = 0;
    }

    /// <summary>
    /// Counter to count when to insert HTML code that brakes checkbox list
    /// </summary>
    private static int htmlwrap_rowbreak_counter { get; set; }

    /// <summary>
    /// Counter to be used on a label linked to each checkbox in the list
    /// </summary>
    private static int linked_label_counter { get; set; }

    /// <summary>
    /// Model-Independent main function
    /// </summary>
    /// <param name="htmlHelper">MVC Html helper class that is being extended</param>
    /// <param name="listName">Name of each checkbox in a list (use this name to POST list values array back to the controller)</param>
    /// <param name="dataList">List of name/value pairs to be used as source data for the list</param>
    /// <param name="htmlAttributes">Each checkbox HTML tag attributes (e.g. 'new { class="somename" }')</param>
    /// <param name="wrapInfo">Settings for HTML wrapper of the list (e.g. 'new HtmlListInfo2(HtmlTag2.vertical_columns, 2, new { style="color:green;" })')</param>
    /// <param name="disabledValues">String array of values to disable</param>
    /// <param name="position">Direction of the list (e.g. 'Position2.Horizontal' or 'Position2.Vertical')</param>
    /// <returns>HTML string containing checkbox list</returns>
    internal static MvcHtmlString CheckBoxList
        (HtmlHelper htmlHelper, string listName, List<SelectListItem> dataList,
         object htmlAttributes, HtmlListInfo wrapInfo, string[] disabledValues,
         Position position = Position.Horizontal)
    {
        // validation
        if (dataList == null || dataList.Count == 0) return MvcHtmlString.Create(no_data_message);
        if (String.IsNullOrEmpty(listName)) throw new ArgumentException(empty_name_message, "listName");
        int numberOfItems = dataList.Count;

        // set up table/list html wrapper, if applicable
        htmlWrapperInfo htmlWrapper = createHtmlWrapper(wrapInfo, numberOfItems, position);

        // create checkbox list
        var sb = new StringBuilder();
        sb.Append(htmlWrapper.wrap_open);
        htmlwrap_rowbreak_counter = 0;

        // create list of selected values
        IEnumerable<string> selectedValues = dataList.Where(x => x.Selected).Select(s => s.Value);

        // create list of checkboxes based on data
        foreach (SelectListItem r in dataList)
        {
            // create checkbox element
            sb = createCheckBoxListElement(sb, htmlHelper, null, htmlWrapper, htmlAttributes, selectedValues,
                                           disabledValues, listName, r.Value, r.Text);
        }
        sb.Append(htmlWrapper.wrap_close);

        // return checkbox list
        return MvcHtmlString.Create(sb.ToString());
    }

    /// <summary>
    /// Model-Based main function
    /// </summary>
    /// <typeparam name="TModel">Current ViewModel</typeparam>
    /// <typeparam name="TItem">ViewModel Item</typeparam>
    /// <typeparam name="TValue">ViewModel Item type of the value</typeparam>
    /// <typeparam name="TKey">ViewModel Item type of the key</typeparam>
    /// <param name="htmlHelper">MVC Html helper class that is being extended</param>
    /// <param name="modelMetadata">Model Metadata</param>
    /// <param name="listName">Name of each checkbox in a list (use this name to POST list values array back to the controller)</param>
    /// <param name="sourceDataExpr">Data list to be used as a source for the list (set in viewmodel)</param>
    /// <param name="valueExpr">Data list value type to be used as checkbox 'Value'</param>
    /// <param name="textToDisplayExpr">Data list value type to be used as checkbox 'Text'</param>
    /// <param name="htmlAttributesExpr">Data list HTML tag attributes, to allow override of htmlAttributes for each checkbox (e.g. 'item => new { data_relation_id = item.RelationID }')</param>
    /// <param name="selectedValuesExpr">Data list of selected items (should be of same data type as a source list)</param>
    /// <param name="htmlAttributes">Each checkbox HTML tag attributes (e.g. 'new { class="somename" }')</param>
    /// <param name="wrapInfo">Settings for HTML wrapper of the list (e.g. 'new HtmlListInfo2(HtmlTag2.vertical_columns, 2, new { style="color:green;" })')</param>
    /// <param name="disabledValues">String array of values to disable</param>
    /// <param name="position">Direction of the list (e.g. 'Position2.Horizontal' or 'Position2.Vertical')</param>
    /// <returns>HTML string containing checkbox list</returns>
    internal static MvcHtmlString CheckBoxList_ModelBased<TModel, TItem, TValue, TKey>
        (HtmlHelper<TModel> htmlHelper,
         ModelMetadata modelMetadata,
         string listName,
         Expression<Func<TModel, IEnumerable<TItem>>> sourceDataExpr,
         Expression<Func<TItem, TValue>> valueExpr,
         Expression<Func<TItem, TKey>> textToDisplayExpr,
         Expression<Func<TItem, object>> htmlAttributesExpr,
         Expression<Func<TModel, IEnumerable<TItem>>> selectedValuesExpr,
         object htmlAttributes,
         HtmlListInfo wrapInfo,
         string[] disabledValues,
         Position position = Position.Horizontal)
    {
        // validation
        if (sourceDataExpr == null || sourceDataExpr.Body.ToString() == "null")
            return MvcHtmlString.Create(no_data_message);
        if (htmlHelper.ViewData.Model == null) throw new NoNullAllowedException(empty_model_message);
        if (string.IsNullOrEmpty(listName)) throw new ArgumentException(empty_name_message, "listName");

        // set properties
        TModel model = htmlHelper.ViewData.Model;
        List<TItem> sourceData = sourceDataExpr.Compile()(model).ToList();
        Func<TItem, TValue> valueFunc = valueExpr.Compile();
        Func<TItem, TKey> textToDisplayFunc = textToDisplayExpr.Compile();
        var selectedItems = new List<TItem>();
        if (selectedValuesExpr != null)
        {
            IEnumerable<TItem> _selectedItems = selectedValuesExpr.Compile()(model);
            if (_selectedItems != null) selectedItems = _selectedItems.ToList();
        }
        List<string> selectedValues = selectedItems.Select(s => valueFunc(s).ToString()).ToList();

        // validate source data
        if (!sourceData.Any()) return MvcHtmlString.Create(no_data_message);

        // set html properties for each checkbox from model object
        Func<TItem, object, object> _valueHtmlAttributesFunc = (item, baseAttributes) => baseAttributes;
        if (htmlAttributesExpr != null)
        {
            Func<TItem, object> valueHtmlAttributesFunc = htmlAttributesExpr.Compile();
            _valueHtmlAttributesFunc = (item, baseAttributes) =>
            {
                IDictionary<string, object> baseAttrDict = baseAttributes.toDictionary();
                IDictionary<string, object> itemAttrDict =
                    valueHtmlAttributesFunc(item).toDictionary();
                var result = new ExpandoObject();
                var d = result as IDictionary<string, object>;
                foreach (var pair in baseAttrDict.Concat(itemAttrDict))
                    d[pair.Key] = pair.Value;
                return result;
            };
        }

        // set up table/list html wrapper, if applicable
        int numberOfItems = sourceData.Count;
        htmlWrapperInfo htmlWrapper = createHtmlWrapper(wrapInfo, numberOfItems, position);

        // create checkbox list
        var sb = new StringBuilder();
        sb.Append(htmlWrapper.wrap_open);
        htmlwrap_rowbreak_counter = 0;

        // create list of checkboxes based on data
        foreach (TItem item in sourceData)
        {
            // get checkbox value and text
            string itemValue = valueFunc(item).ToString();
            string itemText = textToDisplayFunc(item).ToString();

            // create checkbox element
            sb = createCheckBoxListElement(sb, htmlHelper, modelMetadata, htmlWrapper,
                                           _valueHtmlAttributesFunc(item, htmlAttributes),
                                           selectedValues, disabledValues, listName, itemValue, itemText);
        }
        sb.Append(htmlWrapper.wrap_close);

        // return checkbox list
        return MvcHtmlString.Create(sb.ToString());
    }


    /// <summary>
    /// Model-Based main function
    /// </summary>
    /// <typeparam name="TModel">Current ViewModel</typeparam>
    /// <typeparam name="TItem">ViewModel Item</typeparam>
    /// <typeparam name="TValue">ViewModel Item type of the value</typeparam>
    /// <typeparam name="TKey">ViewModel Item type of the key</typeparam>
    /// <param name="htmlHelper">MVC Html helper class that is being extended</param>
    /// <param name="modelMetadata">Model Metadata</param>
    /// <param name="listName">Name of each checkbox in a list (use this name to POST list values array back to the controller)</param>
    /// <param name="sourceDataExpr">Data list to be used as a source for the list (set in viewmodel)</param>
    /// <param name="valueExpr">Data list value type to be used as checkbox 'Value'</param>
    /// <param name="textToDisplayExpr">Data list value type to be used as checkbox 'Text'</param>
    /// <param name="imgToDisplayExpr"> </param>
    /// <param name="htmlAttributesExpr">Data list HTML tag attributes, to allow override of htmlAttributes for each checkbox (e.g. 'item => new { data_relation_id = item.RelationID }')</param>
    /// <param name="selectedValuesExpr">Data list of selected items (should be of same data type as a source list)</param>
    /// <param name="htmlAttributes">Each checkbox HTML tag attributes (e.g. 'new { class="somename" }')</param>
    /// <param name="wrapInfo">Settings for HTML wrapper of the list (e.g. 'new HtmlListInfo2(HtmlTag2.vertical_columns, 2, new { style="color:green;" })')</param>
    /// <param name="disabledValues">String array of values to disable</param>
    /// <param name="position">Direction of the list (e.g. 'Position2.Horizontal' or 'Position2.Vertical')</param>
    /// <returns>HTML string containing checkbox list</returns>
    internal static MvcHtmlString CheckBoxList_ModelBased<TModel, TItem, TValue, TKey>
        (HtmlHelper<TModel> htmlHelper,
         ModelMetadata modelMetadata,
         string listName,
         Expression<Func<TModel, IEnumerable<TItem>>> sourceDataExpr,
         Expression<Func<TItem, TValue>> valueExpr,
         Expression<Func<TItem, TKey>> textToDisplayExpr,
        Expression<Func<TItem, TKey>> imgToDisplayExpr,
         Expression<Func<TItem, object>> htmlAttributesExpr,
         Expression<Func<TModel, IEnumerable<TItem>>> selectedValuesExpr,
         object htmlAttributes,
         HtmlListInfo wrapInfo,
         string[] disabledValues,
         Position position = Position.Horizontal)
    {
        // validation
        if (sourceDataExpr == null || sourceDataExpr.Body.ToString() == "null")
            return MvcHtmlString.Create(no_data_message);
        if (htmlHelper.ViewData.Model == null) throw new NoNullAllowedException(empty_model_message);
        if (string.IsNullOrEmpty(listName)) throw new ArgumentException(empty_name_message, "listName");

        // set properties
        TModel model = htmlHelper.ViewData.Model;
        List<TItem> sourceData = sourceDataExpr.Compile()(model).ToList();
        Func<TItem, TValue> valueFunc = valueExpr.Compile();
        Func<TItem, TKey> textToDisplayFunc = textToDisplayExpr.Compile();
        Func<TItem, TKey> imgToDisplayFunc = imgToDisplayExpr.Compile();
        var selectedItems = new List<TItem>();
        if (selectedValuesExpr != null)
        {
            IEnumerable<TItem> _selectedItems = selectedValuesExpr.Compile()(model);
            if (_selectedItems != null) selectedItems = _selectedItems.ToList();
        }
        List<string> selectedValues = selectedItems.Select(s => valueFunc(s).ToString()).ToList();

        // validate source data
        if (!sourceData.Any()) return MvcHtmlString.Create(no_data_message);

        // set html properties for each checkbox from model object
        Func<TItem, object, object> _valueHtmlAttributesFunc = (item, baseAttributes) => baseAttributes;
        if (htmlAttributesExpr != null)
        {
            Func<TItem, object> valueHtmlAttributesFunc = htmlAttributesExpr.Compile();
            _valueHtmlAttributesFunc = (item, baseAttributes) =>
            {
                IDictionary<string, object> baseAttrDict = baseAttributes.toDictionary();
                IDictionary<string, object> itemAttrDict =
                    valueHtmlAttributesFunc(item).toDictionary();
                var result = new ExpandoObject();
                var d = result as IDictionary<string, object>;
                foreach (var pair in baseAttrDict.Concat(itemAttrDict))
                    d[pair.Key] = pair.Value;
                return result;
            };
        }

        // set up table/list html wrapper, if applicable
        int numberOfItems = sourceData.Count;
        htmlWrapperInfo htmlWrapper = createHtmlWrapper(wrapInfo, numberOfItems, position);

        // create checkbox list
        var sb = new StringBuilder();
        sb.Append(htmlWrapper.wrap_open);
        htmlwrap_rowbreak_counter = 0;

        // create list of checkboxes based on data
        foreach (TItem item in sourceData)
        {
            // get checkbox value and text
            string itemValue = valueFunc(item).ToString();
            string itemText = textToDisplayFunc(item).ToString();
            string imgText = imgToDisplayFunc(item).ToString();
            // create checkbox element
            sb = createCheckBoxListElement(sb, htmlHelper, modelMetadata, htmlWrapper,
                                           _valueHtmlAttributesFunc(item, htmlAttributes),
                                           selectedValues, disabledValues, listName, itemValue, itemText, imgText);
        }
        sb.Append(htmlWrapper.wrap_close);

        // return checkbox list
        return MvcHtmlString.Create(sb.ToString());
    }
    /// <summary>
    /// Creates an HTML wrapper for the checkbox list
    /// </summary>
    /// <param name="wrapInfo">Settings for HTML wrapper of the list (e.g. 'new HtmlListInfo2(HtmlTag2.vertical_columns, 2, new { style="color:green;" })')</param>
    /// <param name="numberOfItems">Count of all items in the list</param>
    /// <param name="position">Direction of the list (e.g. 'Position2.Horizontal' or 'Position2.Vertical')</param>
    /// <returns>HTML wrapper information</returns>
    private static htmlWrapperInfo createHtmlWrapper
        (HtmlListInfo wrapInfo, int numberOfItems, Position position)
    {
        var w = new htmlWrapperInfo();

        if (wrapInfo != null)
        {
            // creating custom layouts
            switch (wrapInfo.htmlTag)
            {
                // creates user selected number of float sections with
                // vertically sorted checkboxes
                case HtmlTag.vertical_columns:
                    {
                        if (wrapInfo.Columns <= 0) wrapInfo.Columns = 1;
                        // calculate number of rows
                        int rows = Convert.ToInt32(Math.Ceiling(Convert.ToDecimal(numberOfItems)
                                                                / Convert.ToDecimal(wrapInfo.Columns)));
                        if (numberOfItems <= 4 &&
                            (numberOfItems <= wrapInfo.Columns || numberOfItems - wrapInfo.Columns == 1))
                            rows = numberOfItems;
                        w.separator_max_counter = rows;

                        // create wrapped raw html tag
                        htmlElementTag wrapRow = htmlElementTag.div;
                        var wrapHtml_builder = new TagBuilder(wrapRow.ToString());
                        IDictionary<string, object> user_html_attributes = wrapInfo.htmlAttributes.toDictionary();

                        // create raw style and merge it with user provided style (if applicable)
                        string defaultSectionStyle = "float:left; margin-right:30px; line-height:25px;";
                        object style;
                        user_html_attributes.TryGetValue("style", out style);
                        if (style != null) // if user style is set, use it
                            wrapHtml_builder.MergeAttribute("style", defaultSectionStyle + " " + style);
                        else // if not set, add only default style
                            wrapHtml_builder.MergeAttribute("style", defaultSectionStyle);

                        // merge it with other user provided attributes (e.g.: class)
                        user_html_attributes.Remove("style");
                        wrapHtml_builder.MergeAttributes(user_html_attributes);

                        // build wrapped raw html tag 
                        w.wrap_open = wrapHtml_builder.ToString(TagRenderMode.StartTag);
                        w.wrap_rowbreak = "</" + wrapRow + "> " +
                                          wrapHtml_builder.ToString(TagRenderMode.StartTag);
                        w.wrap_close = wrapHtml_builder.ToString(TagRenderMode.EndTag) +
                                       " <div style=\"clear:both;\"></div>";
                        w.append_to_element = "<br/>";
                    }
                    break;
                // creates an html <table> with checkboxes sorted horizontally
                case HtmlTag.table:
                    {
                        if (wrapInfo.Columns <= 0) wrapInfo.Columns = 1;
                        w.separator_max_counter = wrapInfo.Columns;

                        var wrapHtml_builder = new TagBuilder(htmlElementTag.table.ToString());
                        wrapHtml_builder.MergeAttributes(wrapInfo.htmlAttributes.toDictionary());
                        wrapHtml_builder.MergeAttribute("cellspacing", "0"); // for IE7 compatibility

                        htmlElementTag wrapRow = htmlElementTag.tr;
                        w.wrap_element = htmlElementTag.td;
                        w.wrap_open = wrapHtml_builder.ToString(TagRenderMode.StartTag) +
                                      "<" + wrapRow + ">";
                        w.wrap_rowbreak = "</" + wrapRow + "><" + wrapRow + ">";
                        w.wrap_close = "</" + wrapRow + ">" +
                                       wrapHtml_builder.ToString(TagRenderMode.EndTag);
                    }
                    break;
                // creates an html unordered (bulleted) list of checkboxes in one column
                case HtmlTag.ul:
                    {
                        var wrapHtml_builder = new TagBuilder(htmlElementTag.ul.ToString());
                        wrapHtml_builder.MergeAttributes(wrapInfo.htmlAttributes.toDictionary());
                        wrapHtml_builder.MergeAttribute("cellspacing", "0"); // for IE7 compatibility

                        w.wrap_element = htmlElementTag.li;
                        w.wrap_open = wrapHtml_builder.ToString(TagRenderMode.StartTag);
                        w.wrap_close = wrapHtml_builder.ToString(TagRenderMode.EndTag);
                    }
                    break;
            }
        }
        // default setting creates vertical or horizontal column of checkboxes
        else
        {
            if (position == Position.Horizontal) w.append_to_element = " &nbsp; ";
            if (position == Position.Vertical) w.append_to_element = "<br/>";
        }

        return w;
    }

    /// <summary>
    /// Creates an an individual checkbox
    /// </summary>
    /// <param name="sb">String builder of checkbox list</param>
    /// <param name="modelMetadata">Model Metadata</param>
    /// <param name="htmlWrapper">MVC Html helper class that is being extended</param>
    /// <param name="htmlAttributesForCheckBox">Each checkbox HTML tag attributes (e.g. 'new { class="somename" }')</param>
    /// <param name="selectedValues">List of strings of selected values</param>
    /// <param name="disabledValues">List of strings of disabled values</param>
    /// <param name="name">Name of the checkbox list (same for all checkboxes)</param>
    /// <param name="itemValue">Value of the checkbox</param>
    /// <param name="itemText">Text to be displayed next to checkbox</param>
    /// <param name="htmlHelper">HtmlHelper passed from view model</param>
    /// <returns>String builder of checkbox list</returns>
    private static StringBuilder createCheckBoxListElement
        (StringBuilder sb, HtmlHelper htmlHelper, ModelMetadata modelMetadata, htmlWrapperInfo htmlWrapper,
         object htmlAttributesForCheckBox, IEnumerable<string> selectedValues, IEnumerable<string> disabledValues,
         string name, string itemValue, string itemText)
    {
        // get full name from view model
        string fullName = htmlHelper.ViewContext.ViewData.TemplateInfo.GetFullHtmlFieldName(name);

        // create checkbox tag
        var builder = new TagBuilder("input");
        if (selectedValues.Any(x => x == itemValue)) builder.MergeAttribute("checked", "checked");
        builder.MergeAttributes(htmlAttributesForCheckBox.toDictionary());
        builder.MergeAttribute("type", "checkbox");
        builder.MergeAttribute("value", itemValue);
        builder.MergeAttribute("name", fullName);

        // create linked label tag
        string link_name = name + linked_label_counter++;
        builder.GenerateId(link_name);
        var linked_label_builder = new TagBuilder("label");
        linked_label_builder.MergeAttribute("for", link_name.Replace(".", "_"));
        linked_label_builder.MergeAttributes(htmlAttributesForCheckBox.toDictionary());
        linked_label_builder.InnerHtml = itemText;

        // if there are any errors for a named field, we add the css attribute
        ModelState modelState;
        if (htmlHelper.ViewData.ModelState.TryGetValue(fullName, out modelState))
            if (modelState.Errors.Count > 0)
                builder.AddCssClass(HtmlHelper.ValidationInputCssClassName);
        builder.MergeAttributes(htmlHelper.GetUnobtrusiveValidationAttributes(name, modelMetadata));

        // open checkbox tag wrapper
        sb.Append(htmlWrapper.wrap_element != htmlElementTag.None ? "<" + htmlWrapper.wrap_element + ">" : "");

        // build hidden tag for disabled checkbox (so the value will post)
        if (disabledValues != null && disabledValues.ToList().Any(x => x == itemValue))
        {
            // set main checkbox to be disabled
            builder.MergeAttribute("disabled", "disabled");

            // create a hidden input with checkbox value
            // so it can be posted if checked
            if (selectedValues.Any(x => x == itemValue))
            {
                var hidden_builder = new TagBuilder("input");
                hidden_builder.MergeAttribute("type", "hidden");
                hidden_builder.MergeAttribute("value", itemValue);
                hidden_builder.MergeAttribute("name", name);
                sb.Append(hidden_builder.ToString(TagRenderMode.Normal));
            }
        }

        // create checkbox tag
        sb.Append(builder.ToString(TagRenderMode.Normal));
        sb.Append(linked_label_builder.ToString(TagRenderMode.Normal));

        // close checkbox tag wrapper
        sb.Append(htmlWrapper.wrap_element != htmlElementTag.None ? "</" + htmlWrapper.wrap_element + ">" : "");

        // add element ending
        sb.Append(htmlWrapper.append_to_element);

        // add table column break, if applicable
        htmlwrap_rowbreak_counter += 1;
        if (htmlwrap_rowbreak_counter == htmlWrapper.separator_max_counter)
        {
            sb.Append(htmlWrapper.wrap_rowbreak);
            htmlwrap_rowbreak_counter = 0;
        }

        // return string builder with checkbox html markup
        return sb;
    }

    /// <summary>
    /// Creates an an individual checkbox
    /// </summary>
    /// <param name="sb">String builder of checkbox list</param>
    /// <param name="modelMetadata">Model Metadata</param>
    /// <param name="htmlWrapper">MVC Html helper class that is being extended</param>
    /// <param name="htmlAttributesForCheckBox">Each checkbox HTML tag attributes (e.g. 'new { class="somename" }')</param>
    /// <param name="selectedValues">List of strings of selected values</param>
    /// <param name="disabledValues">List of strings of disabled values</param>
    /// <param name="name">Name of the checkbox list (same for all checkboxes)</param>
    /// <param name="itemValue">Value of the checkbox</param>
    /// <param name="itemText">Text to be displayed next to checkbox</param>
    /// <param name="htmlHelper">HtmlHelper passed from view model</param>
    /// <param name="imgUrl"> </param>
    /// <returns>String builder of checkbox list</returns>
    private static StringBuilder createCheckBoxListElement
        (StringBuilder sb, HtmlHelper htmlHelper, ModelMetadata modelMetadata, htmlWrapperInfo htmlWrapper,
         object htmlAttributesForCheckBox, IEnumerable<string> selectedValues, IEnumerable<string> disabledValues,
         string name, string itemValue, string itemText, string imgUrl)
    {
        // get full name from view model
        string fullName = htmlHelper.ViewContext.ViewData.TemplateInfo.GetFullHtmlFieldName(name);

        // create checkbox tag
        var builder = new TagBuilder("input");
        if (selectedValues.Any(x => x == itemValue)) builder.MergeAttribute("checked", "checked");
        builder.MergeAttributes(htmlAttributesForCheckBox.toDictionary());
        builder.MergeAttribute("type", "checkbox");
        builder.MergeAttribute("value", itemValue);
        builder.MergeAttribute("name", fullName);

        // create linked label tag
        var linked_label_builder = new TagBuilder("label");
        var linked_img_builder = new TagBuilder("img");
        if (string.IsNullOrEmpty(imgUrl))
        {
            string link_name = name + linked_label_counter++;
            builder.GenerateId(link_name);

            linked_label_builder.MergeAttribute("for", link_name.Replace(".", "_"));
            linked_label_builder.MergeAttributes(htmlAttributesForCheckBox.toDictionary());
            linked_label_builder.InnerHtml = itemText;
        }
        else
        {
            string link_name = name + linked_label_counter++;
            builder.GenerateId(link_name);

            linked_img_builder.MergeAttribute("for", link_name.Replace(".", "_"));
            linked_img_builder.MergeAttributes(htmlAttributesForCheckBox.toDictionary());
            linked_img_builder.Attributes.Add("src", imgUrl);
            linked_img_builder.Attributes.Add("style", "vertical-align:middle");

        }
        // if there are any errors for a named field, we add the css attribute
        ModelState modelState;
        if (htmlHelper.ViewData.ModelState.TryGetValue(fullName, out modelState))
            if (modelState.Errors.Count > 0)
                builder.AddCssClass(HtmlHelper.ValidationInputCssClassName);
        builder.MergeAttributes(htmlHelper.GetUnobtrusiveValidationAttributes(name, modelMetadata));

        // open checkbox tag wrapper
        sb.Append(htmlWrapper.wrap_element != htmlElementTag.None ? "<" + htmlWrapper.wrap_element + ">" : "");

        // build hidden tag for disabled checkbox (so the value will post)
        if (disabledValues != null && disabledValues.ToList().Any(x => x == itemValue))
        {
            // set main checkbox to be disabled
            builder.MergeAttribute("disabled", "disabled");

            // create a hidden input with checkbox value
            // so it can be posted if checked
            if (selectedValues.Any(x => x == itemValue))
            {
                var hidden_builder = new TagBuilder("input");
                hidden_builder.MergeAttribute("type", "hidden");
                hidden_builder.MergeAttribute("value", itemValue);
                hidden_builder.MergeAttribute("name", name);
                sb.Append(hidden_builder.ToString(TagRenderMode.Normal));
            }
        }

        // create checkbox tag
        sb.Append(builder.ToString(TagRenderMode.Normal));
        if (string.IsNullOrEmpty(imgUrl))
            sb.Append(linked_label_builder.ToString(TagRenderMode.Normal));
        else
            sb.Append(linked_img_builder.ToString(TagRenderMode.Normal));

        // close checkbox tag wrapper
        sb.Append(htmlWrapper.wrap_element != htmlElementTag.None ? "</" + htmlWrapper.wrap_element + ">" : "");

        // add element ending
        sb.Append(htmlWrapper.append_to_element);

        // add table column break, if applicable
        htmlwrap_rowbreak_counter += 1;
        if (htmlwrap_rowbreak_counter == htmlWrapper.separator_max_counter)
        {
            sb.Append(htmlWrapper.wrap_rowbreak);
            htmlwrap_rowbreak_counter = 0;
        }

        // return string builder with checkbox html markup
        return sb;
    }
}