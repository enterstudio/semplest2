
$(document).ready(function () {
    //Proximity TextBox To Numeric TextBox
    $("#Proxmity").kendoNumericTextBox();
    var budjet = $("#ProductGroup_Budget").kendoNumericTextBox({ format: "#", decimals: 0, min: $('#ProductGroup_Configuration_CustomerMinOrderAmount').val() }).data("kendoNumericTextBox");
    budjet.wrapper.find(".k-numeric-wrap").addClass("expand-padding").find(".k-select").hide();
    budjet.wrapper.find(".k-link")
        .addClass("k-state-disabled").unbind("keydown");
    budjet.wrapper.find(".k-link")
        .addClass("k-state-disabled").unbind("mousedown");
    //$('.k-dropdownlist').kendoDropDownList();
    // Juery Validator for Validations
    var validator = $("#productGroupModel").kendoValidator().data("kendoValidator"), status = $(".st    atus");
    var validator1 = $("#adModel").kendoValidator().data("kendoValidator"), status = $(".status");
    //Save Click Validation Logic..
    $("#save1").click(function () {
        if (validator.validate()) {
            //status.text("Hooray! Your Product has been defined!").addClass("valid");
            tabStrip.select(1);
            tabStrip.enable(tab.next(), tab.next().hasClass("k-state-disabled"));
        } else {
            status.text("Oops! There is invalid data in the form.").addClass("invalid");
        }
    });
    $('#getCategories').click(function () {
        if (validator1.validate()) {
        } else {
            status.text("Oops! There is invalid data in the form.").addClass("invalid");
        }
    });
    // Previous and Save And Continue Button tab changed Logic
    $("#save2").click(function () {
        tabStrip.select(2);
        tabStrip.enable(tab.next().next(), tab.next().next().hasClass("k-state-disabled"));
    });
    $("#save3").click(function () {
        tabStrip.select(3);
        tabStrip.enable(tab.next().next().next(), tab.next().next().next().hasClass("k-state-disabled"));
    });
    $("#back1").click(function () { tabStrip.select(0); });
    //    $("#back2").click(function () { tabStrip.select(1); });
    //    $("#back3").click(function () { tabStrip.select(2); });
    $("#save").click(function () { tabStrip.select(0); });

    // Dropdownlist Range in BillingLaunch
    $("#dropDownRange").kendoDropDownList();

    // event handler for select
    var onSelect = function (e) {
        // access the selected item via e.item (jQuery object)
        var dataItem = this.dataItem(e.item.index());
        if (dataItem.text == 'Specific Month') {
            $("#ProductGroup_EndDate").removeClass("enddate");
            $("#ProductGroup_EndDate").kendoDatePicker({
                change: endChange
            }).data("kendoDatePicker");
        } else {
            $("#ProductGroup_EndDate").addClass("enddate");
            disposeDatePicker();
        }
    };

    function disposeDatePicker() {
        var datepicker = $("#ProductGroup_EndDate").data("kendoDatePicker"),
            popup = datepicker.dateView.popup,
            element = popup.wrapper[0] ? popup.wrapper : popup.element;

        //Move the shared calendar to the body
        kendo.ui.DatePicker.sharedCalendar.element.hide().appendTo(document.body);

        //remove popup element;
        element.remove();
        //unwrap element
        var input = datepicker.element.show();

        input.removeClass("k-input").css("width", "auto");
        input.insertBefore(datepicker.wrapper);

        datepicker.wrapper.remove();

        //remove DatePicker object
        input.removeData("kendoDatePicker");
    }

    // attach select event handler during initialization
    var dropdownlist = $("#dropDownPeriodList").kendoDropDownList({
        select: onSelect
    });

    // detach select event handler via unbind()
    //dropdownlist.data("dropDownPeriodList").unbind("select", onSelect);

    ///////
    //DateFunctions Start And Date

    function startChange() {
        var startDate = start.value();

        if (startDate) {
            startDate = new Date(startDate);
            startDate.setDate(startDate.getDate() + 1);
            //end.min(startDate);
        }
    }

    function endChange() {
        var endDate = end.value();

        if (endDate) {
            endDate = new Date(endDate);
            endDate.setDate(endDate.getDate() - 1);
            start.max(endDate);
        }
    }
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    var toDay = new Date(y, m, d + 1);
    var start = $("#ProductGroup_StartDate").kendoDatePicker({
        change: startChange, value: toDay, format: "MM-dd-yyyy"
    }).data("kendoDatePicker");

    //    var end = $("#EndDate").kendoDatePicker({
    //        change: endChange
    //    }).data("kendoDatePicker");

    //start.max(end.value());
    //end.min(start.value());
    // Tab Activated Event to Change The Color of the Number 1,2,3,4

    // end Enable tabs Region

    //Selected Button Logic
    $("input[type='button']#btnOne").addClass("k-button rounded");
    $("#negativeKeyWords").click(function () {
        var length = tabStrip.items().length;
        var isnegativeKeyWordsAdded = false;
        for (var item = 0; item < length; item++) {
            if (tabStrip.items().item(item).innerText == "Negative Keywords") {
                isnegativeKeyWordsAdded = true;
                break;
            }
        }
        if (!isnegativeKeyWordsAdded) {
            tabStrip.append({
                text: "Negative Keywords",
                contentUrl: $('#NegativeKeyWordsUrl').val()
            });
        }
        tab = tabStrip.tabGroup.children('li:contains("Negative Keywords")');
        tabStrip.select(tab);
    });

    $("#viewSelectedKeywords").click(function () {
        alert('in viewSelectedKeywords');
        var length = tabStrip.items().length;
        var isSelectedKeywordsAdded = false;
        for (var item = 0; item < length; item++) {
            if (tabStrip.items().item(item).innerText == "View Keywords") {
                isSelectedKeywordsAdded = true;
                break;
            }
        }
        if (!isSelectedKeywordsAdded)
            tabStrip.append({
                text: "View Keywords",
                contentUrl: $('$ViewSelectedKeywordsUrl').val()
            });
    });
    tab = tabStrip.tabGroup.children('li:contains("View Keywords")');
    tabStrip.select(tab);


});

function removeNestedForm(element, container, deleteElement) {
    var $container = $(element).parents(container);
    if (container == "div.ads") {
        if ($container.find('input')[1].value == null || $container.find('input')[1].value == '')
            $container.find('input')[1].value = 'deleted';
        if ($container.find('input')[2].value == null || $container.find('input')[2].value == '')
            $container.find('input')[2].value = 'deleted';
        if ($container.find('input')[3].value == null || $container.find('input')[3].value == '')
            $container.find('input')[3].value = 'deleted';
    }
    $container.find(deleteElement).val('True');
    $container.hide();
}

function addNestedForm(container, counter, ticks, content) {
    var nextIndex = $(counter).length;
    var pattern = new RegExp(ticks, "gi");
    content = content.replace(pattern, nextIndex);
    if (container == "#addresses") {
        content = content.replace("doOptions()", "doOptions('AdModelProp_Addresses_" + nextIndex +
"__City','AdModelProp_Addresses_" + nextIndex + "__StateCodeFK','AdModelProp_Addresses_" + nextIndex +
"__Zip','AdModelProp_Addresses_" + nextIndex + "__Proximity')");
        content = content.replace("optionsNarrative", "optionsNarrative_" + nextIndex + "");
        content.replace(new RegExp('nestedObject', "igm"), ' Addresses_' + nextIndex + '_');
    }

    if (container == "#sitelinks") {
        var deletedElements = $(container).find('input.mark-for-delete[value="True"]').length;
        if (nextIndex - deletedElements > 9) {
            alert('Maximul Limit Reached');
            return;
        } else {
            $(container).append(content);
            return;
        }
    }
    $(container).append(content);
    if (container == "#ads") {
        $("#AdModelProp_Ads_" + nextIndex + "__PromotionAdsPK_div").html(template({
            id: nextIndex + 1,
            title: $("#AdModelProp_Url").val(),
            twitter: $("#AdModelProp_Ads_" + nextIndex + "__AdTitle").val(),
            content: $("#AdModelProp_Ads_" + nextIndex + "__AdTextLine1").val(),
            content1: $("#AdModelProp_Ads_" + nextIndex + "__AdTextLine2").val()
        }));
        $("#AdModelProp_Ads_" + nextIndex + "__AdTitle").attr("data-bind", "events: { change: listener}");
        $("#AdModelProp_Ads_" + nextIndex + "__AdTextLine1").attr("data-bind", "events: { change: listener}");
        $("#AdModelProp_Ads_" + nextIndex + "__AdTextLine2").attr("data-bind", "events: { change: listener}");
        kendo.bind($("#AdModelProp_Ads_" + nextIndex + "__PromotionAdsPK_ul"), kendo.observable({
            listener: function (e) {
                $("#AdModelProp_Ads_" + nextIndex + "__PromotionAdsPK_div").html(template({
                    id: nextIndex + 1,
                    title: $("#AdModelProp_Url").val(),
                    twitter: $("#AdModelProp_Ads_" + nextIndex + "__AdTitle").val(),
                    content: $("#AdModelProp_Ads_" + nextIndex + "__AdTextLine1").val(),
                    content1: $("#AdModelProp_Ads_" + nextIndex + "__AdTextLine2").val()
                }));
            }
        }));
    }
    if (container == "#addresses") {
        //$("#AdModelProp_Addresses_" + nextIndex + "__StateCodeFK").kendoDropDownList();
    }
}
