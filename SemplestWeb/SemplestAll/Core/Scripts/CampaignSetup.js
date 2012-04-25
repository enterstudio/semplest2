$(document).ready(function () {
    //Proximity TextBox To Numeric TextBox
    $("#Proxmity").kendoNumericTextBox();
    // Juery Validator for Validations
    var validator = $("#productGroupModel").kendoValidator().data("kendoValidator"), status = $(".status");
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
    $("#back2").click(function () { tabStrip.select(1); });
    $("#back3").click(function () { tabStrip.select(2); });
    $("#save").click(function () { tabStrip.select(0); });
    //DropdownlistBindig
    $("#dropDownList").kendoDropDownList({ dataTextField: "text", dataValueField: "value", dataSource: [{ text: "Item1", value: "1" }, { text: "Item2", value: "2"}] });


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
    var onSelectTab = function (e) {
        if (e.item.innerText == "Additional Links")
            if ($('#additionalLinksdiv').html() == '')
                $('#additionalLinksdiv').load('/Campaign/AdditionalLinks', function () { alert('Additional Links'); });
        if (e.item.innerText == "Negative Keywords")
            if ($('#negativeKeyWordsdiv').html() == '')
                $('#negativeKeyWordsdiv').load('/Campaign/NegativeKeyWords', function () { alert('Negative Key Words'); });
        if (e.item.innerText == "KeyWords" || e.item.innerText == "Keywords")
            if ($('#KeyWordsdiv').html() == '')
                $('#KeyWordsdiv').load('/Campaign/KeyWords', function () { });
        if (e.item.innerText == "Categories")
            if ($('#Categoriesdiv').html() == '')
                $('#Categoriesdiv').load('/Campaign/Categories', function () { });
    };
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    var toDay = new Date(y, m, d + 1);
    var start = $("#ProductGroup_StartDate").kendoDatePicker({
        change: startChange, value: toDay
    }).data("kendoDatePicker");

    //    var end = $("#EndDate").kendoDatePicker({
    //        change: endChange
    //    }).data("kendoDatePicker");

    //start.max(end.value());
    //end.min(start.value());
    // Tab Activated Event to Change The Color of the Number 1,2,3,4
    var onActivate = function () {
        switch (tabStrip.select().text()) {
            case "DEFINE PRODUCT":
                $("input[type='button']#btnOne").addClass('k-state-btnerror');
                $("input[type='button']#btnTwo").removeClass('k-state-btnerror');
                $("input[type='button']#btnThree").removeClass('k-state-btnerror');
                break;
            case "CREATE ADS":
                $("input[type='button']#btnOne").removeClass('k-state-btnerror');
                $("input[type='button']#btnTwo").addClass('k-state-btnerror');
                $("input[type='button']#btnThree").removeClass('k-state-btnerror');
                break;
            case 'Additional Click Through Links("SiteLinks")':
                $("input[type='button']#btnOne").removeClass('k-state-btnerror');
                $("input[type='button']#btnTwo").removeClass('k-state-btnerror');
                $("input[type='button']#btnThree").addClass('k-state-btnerror');
                break;
            case "Negative Keywords":
                $("input[type='button']#btnOne").removeClass('k-state-btnerror');
                $("input[type='button']#btnTwo").removeClass('k-state-btnerror');
                $("input[type='button']#btnThree").removeClass('k-state-btnerror');
                break;
        }
    };
    //Generate Tab
    var tabStrip = $("#tabstrip").kendoTabStrip({ activate: onActivate, select: onSelectTab }).data("kendoTabStrip");

    // Start Enable tabs region
    var tab = tabStrip.select();


    tabStrip.enable(tab.next(), tab.next().hasClass("k-state-disabled"));
    tabStrip.enable(tab.next().next(), tab.next().next().hasClass("k-state-disabled"));
    tabStrip.enable(tab.next().next().next(), tab.next().next().next().hasClass("k-state-disabled"));
    // end Enable tabs Region

    //Selected Button Logic
    $("input[type='button']#btnOne").addClass("k-button rounded");

    var isAdditionalLinksAdded = false;
    $("#additionalLinks").click(function () {
        if (!isAdditionalLinksAdded) {
            tabStrip.append({
                text: "Additional Links",
                content: '<div id="additionalLinksdiv" />'
            });
            isAdditionalLinksAdded = true;
        }
    });
    var isnegativeKeyWordsAdded = false;
    $("#negativeKeyWords").click(function () {
        if (!isnegativeKeyWordsAdded) {
            tabStrip.append({
                text: "Negative Keywords",
                content: '<div id="negativeKeyWordsdiv" />'
            });
            isnegativeKeyWordsAdded = true;
        }
    });
    var isKeywordsAdded = false;
    $("#getCategories").click(function () {
        if (!isKeywordsAdded) {
            //            tabStrip.append({
            //                text: "Key Words",
            //                content: '<div id="KeyWordsdiv" />'
            //            });
            isKeywordsAdded = true;
        }
    });
    //    if (isKeywordsAdded) {
    //        tabStrip.append({
    //            text: "Key Words",
    //            content: '<div id="KeyWordsdiv" />'
    //        });
    //    }
    //    $('#frmCampaign').submit(function (e) {
    //        e.preventDefault();
    //                $.fn.serializeObject = function () {
    //                    var o = {};
    //                    var a = this.serializeArray();
    //                    $.each(a, function () {
    //                        if (o[this.name] !== undefined) {
    //                            if (!o[this.name].push) {
    //                                o[this.name] = [o[this.name]];
    //                            }
    //                            o[this.name].push(this.value || '');
    //                        } else {
    //                            o[this.name] = this.value || '';
    //                        }
    //                    });
    //                    return o;
    //                };
    //                var data = $(this).serializeArray();
    //                var data1 = (JSON.stringify(data));
    //                alert(data1);
    //                $.post('/Campaign/GetCategories/', { data: data1 }, function (de) {
    //                    alert(de);
    //                }).error(function (err) { alert(err); });
    //    });


});

//Helper functions to Add Multiple Items..
 
function removeNestedForm(element, container, deleteElement) {
    var $container = $(element).parents(container);
    $container.find(deleteElement).val('True');
    $container.hide();
}

function addNestedForm(container, counter, ticks, content) {
    var nextIndex = $(counter).length;
    var pattern = new RegExp(ticks, "gi");
    content = content.replace(pattern, nextIndex);
    content = content.replace("doOptions()", "doOptions('Addresses_" + nextIndex + "__City','Addresses_" + nextIndex + "__StateCodeFK','Addresses_" + nextIndex + "__Zip','Addresses_" + nextIndex + "__Proximity')");
    content = content.replace("optionsNarrative", "optionsNarrative_" + nextIndex + "");
    $(container).append(content);
}
