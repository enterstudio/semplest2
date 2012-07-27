/// <reference path="jquery-1.7.2-vsdoc.js" />
var formClean;




$(document).ready(function () {

    formClean = $('#AdModelProp_LandingUrl').serialize() + $('#AdModelProp_DisplayUrl').serialize() + $('#ProductGroup_Words').serialize();
    //Proximity TextBox To Numeric TextBox
    $("#Proxmity").kendoNumericTextBox();
    $('.street').live("keypress", function (e) {
        if (e.keyCode == 10 || e.keyCode == 13)
            e.preventDefault();
    });
    $('.state').live("keypress", function (e) {
        if (e.keyCode == 10 || e.keyCode == 13)
            e.preventDefault();
    });
    $('#AdModelProp_LandingUrl').live("keypress", function (e) {
        if (e.keyCode == 38 || e.keyCode == 39)
            e.preventDefault();
    });
    $('#AdModelProp_DisplayUrl').live("keypress", function (e) {
        if (e.keyCode == 47 || e.keyCode == 63)
            e.preventDefault();
        var dispStr = $('#AdModelProp_DisplayUrl').val();
        if (dispStr.length > 35) {
            dispStr = dispStr.substring(0, 35);
            $('#AdModelProp_DisplayUrl').val(dispStr);
        }
    });

    $('#AdModelProp_LandingUrl').live("keyup", function (e) {
        var originalValue = $('#AdModelProp_LandingUrl').val();
        var index = originalValue.indexOf('http://');
        if (index >= 0) {
            var dispStr = $('#AdModelProp_LandingUrl').val().substring(index + 7);
            //var dispStr = $('#AdModelProp_LandingUrl').val();
            if (dispStr.indexOf('/') >= 0) {
                dispStr = dispStr.substring(0, dispStr.indexOf('/'));
            }
            if (dispStr.indexOf('?') >= 0) {
                dispStr = dispStr.substring(0, dispStr.indexOf('?'));
            }
            $('#AdModelProp_DisplayUrl').val(dispStr);
            if (dispStr.length > 35) {
                dispStr = dispStr.substring(0, 35);
                $('#AdModelProp_DisplayUrl').val(dispStr);
            }

        }
        else {
            var landStr = $('#AdModelProp_LandingUrl').val();
            if (landStr.indexOf('/') >= 0) {
                landStr = landStr.substring(0, landStr.indexOf('/'));
            }
            if (landStr.indexOf('?') >= 0) {
                landStr = landStr.substring(0, landStr.indexOf('?'));
            }
            $('#AdModelProp_DisplayUrl').val(landStr);
            if (landStr.length > 35) {
                landStr = landStr.substring(0, 35);
                $('#AdModelProp_DisplayUrl').val(landStr);
            }
        }
    });
    var budjet = $("#ProductGroup_Budget").kendoNumericTextBox({ format: "#", decimals: 0, min: 0 }).data("kendoNumericTextBox");
    budjet.wrapper.find(".k-numeric-wrap").addClass("expand-padding").find(".k-select").hide();
    budjet.wrapper.find(".k-link")
        .addClass("k-state-disabled").unbind("keydown");
    budjet.wrapper.find(".k-link")
        .addClass("k-state-disabled").unbind("mousedown");
    $('.k-dropdownlist').kendoDropDownList();
    // Juery Validator for Validations
    var validator = $("#productGroupModel").kendoValidator({
        rules: {
            minreq: function (input) {
                if ($.browser.version > "8.0" && $.browser.msie) {
                    if (input.is("[name=ProductGroup.Budget]")) {
                        if (input.val() < parseInt($('#ProductGroup_Configuration_CustomerMinOrderAmount').val())) {
                            return false;
                        }
                        status.text("").addClass("valid");
                        return true;
                    }
                    return true;
                }
                else {
                    if (input.attr("name") == "ProductGroup.Budget") {
                        if (input.val() < parseInt($('#ProductGroup_Configuration_CustomerMinOrderAmount').val())) {
                            return false;
                        }
                        status.text("").addClass("valid");
                        return true;
                    }
                    return true;
                }
            }
        },
        messages: {
            required: function (e) {
                return e.attr('name').split('.')[e.attr('name').split('.').length - 1] + " is Requried..";
            },
            minreq: "Budget must not be less than " + parseInt($('#ProductGroup_Configuration_CustomerMinOrderAmount').val()),
            min: "{0} should be greater than or equal to {1}",
            max: "{0} should be smaller than or equal to {1}"
        }
    }).data("kendoValidator"), status = $(".status");
    var validator1 = $("#adModel").kendoValidator().data("kendoValidator"), status = $(".status");
    //Save Click Validation Logic..
    $("#save1").click(function (e) {

        var searchengines = $('input[name="ProductGroup.AdEnginesList"]');
        var prodgrpbudget = $('input[name="ProductGroup.Budget"]');
        if (searchengines[0].checked == true || searchengines[1].checked == true) {
            if (validator.validate()) {
                status.text("").addClass("valid");
            } else {
                status.text("Oops! There is invalid data in the form.").addClass("invalid");
                e.preventDefault();
            }
        }
        else {
            status.text("Please select at least one Search Engine").addClass("invalid");
            e.preventDefault();
        }
    });
    //    $('#getCategories').click(function () {
    //        if (validator1.validate()) {
    //        } else {
    //            status.text("Oops! There is invalid data in the form.").addClass("invalid");
    //        }
    //    });
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
    //default the map to be displayed
    doOptions();
    $(":input").keypress(function (event) {
        if (event.keyCode == 13)
        { event.preventDefault(); }
    });

    // event handler for select
    var onSelect = function (e) {
        // access the selected item via e.item (jQuery object)
        var dataItem = this.dataItem(e.item.index());
        if (dataItem.text == 'Specific Period') {
            $('#lblbudgetdisplay').html('/ Promotion');
            $("#ProductGroup_EndDate").removeClass("enddate");
            $("#ProductGroup_EndDate").kendoDatePicker({
                //change: endChange
            }).data("kendoDatePicker");
        } else {
            $('#lblbudgetdisplay').html('/ Month');
            $("#ProductGroup_EndDate").addClass("enddate");
            $("#ProductGroup_EndDate").val('');
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
    $("#dropDownPeriodList").kendoDropDownList({
        select: onSelect
    });
    if ($("#ProductGroup_EndDate").val() == '')
        $("#dropDownPeriodList").data("kendoDropDownList").select(0);
    else {
        $("#dropDownPeriodList").data("kendoDropDownList").select(1);
        $('#lblbudgetdisplay').html('/ Promotion');
        $("#ProductGroup_EndDate").removeClass("enddate");
        $("#ProductGroup_EndDate").kendoDatePicker({
            //change: endChange
        }).data("kendoDatePicker");
    }
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
    var dateArray = $("#ProductGroup_StartDate").val().split("/");
    var toDay = new Date();
    if (dateArray.length > 1)
        toDay = new Date(dateArray[2], parseInt(dateArray[0]) - 1, dateArray[1]);


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
    $("#btnOkDF").click(function (event) {
        //for now know submit lets just remove tabs
        //$("#hiddenDirtyForm").submit();

        tabStrip.remove(tabStrip.tabGroup.children('li:contains("Additional Links")'));
        tabStrip.remove(tabStrip.tabGroup.children('li:contains("Negative Keywords")'));
        tabStrip.remove(tabStrip.tabGroup.children('li:contains("Categories")'));
        tabStrip.remove(tabStrip.tabGroup.children('li:contains("Billing & Launch")'));
        tabStrip.remove(tabStrip.tabGroup.children('li:contains("View Keywords")'));
        tabStrip.select(tabStrip.tabGroup.children('li:contains("Create Ads")'));
        formClean = $('#AdModelProp_LandingUrl').serialize() + $('#AdModelProp_DisplayUrl').serialize() + $('#ProductGroup_Words').serialize();


        $('#DirtyFormWindow').hide();
        $('#DirtyFormWindow').data("kendoWindow").close();
    });

    $("#btnCancelDF").click(function (event) {
        var dirtyWindow = $('#DirtyFormWindow').data("kendoWindow");
        $('#DirtyFormWindow').hide();
        dirtyWindow.close();
    });
//    if ($('#IsCompleted').val() == 'False' && $('#IsLaunched').val() == 'True') {
//        start.enable(false);
//        var datePicker = $("#ProductGroup_EndDate").data("kendoDatePicker");
//        if (datePicker != null)
//            datePicker.enable(false);
//    }
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

        content = content.replace("class=\"map\"", "class=\"map\"" + "id=\"map_" + nextIndex + "\"");
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
            title: $("#AdModelProp_DisplayUrl").val(),
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
                    title: $("#AdModelProp_DisplayUrl").val(),
                    twitter: $("#AdModelProp_Ads_" + nextIndex + "__AdTitle").val(),
                    content: $("#AdModelProp_Ads_" + nextIndex + "__AdTextLine1").val(),
                    content1: $("#AdModelProp_Ads_" + nextIndex + "__AdTextLine2").val()
                }));
            }
        }));
    }
    if (container == "#addresses") {
        $("#AdModelProp_Addresses_" + nextIndex + "__StateCodeFK").kendoDropDownList({ optionLabel: "--" });
        doOptions('AdModelProp_Addresses_' + nextIndex + '__Address', 'AdModelProp_Addresses_' + nextIndex + '__City', 'AdModelProp_Addresses_' + nextIndex + '__StateCodeFK', 'AdModelProp_Addresses_' + nextIndex + '__Zip', 'AdModelProp_Addresses_' + nextIndex + '__ProximityRadius');
        $('#AdModelProp_Addresses_' + nextIndex + '__Address').change(function (e) {
            doOptions('AdModelProp_Addresses_' + nextIndex + '__Address', 'AdModelProp_Addresses_' + nextIndex + '__City', 'AdModelProp_Addresses_' + nextIndex + '__StateCodeFK', 'AdModelProp_Addresses_' + nextIndex + '__Zip', 'AdModelProp_Addresses_' + nextIndex + '__ProximityRadius');
        });
        $('#AdModelProp_Addresses_' + nextIndex + '__City').change(function (e) {
            doOptions('AdModelProp_Addresses_' + nextIndex + '__Address', 'AdModelProp_Addresses_' + nextIndex + '__City', 'AdModelProp_Addresses_' + nextIndex + '__StateCodeFK', 'AdModelProp_Addresses_' + nextIndex + '__Zip', 'AdModelProp_Addresses_' + nextIndex + '__ProximityRadius');
        });
        $('#AdModelProp_Addresses_' + nextIndex + '__StateCodeFK').change(function (e) {
            doOptions('AdModelProp_Addresses_' + nextIndex + '__Address', 'AdModelProp_Addresses_' + nextIndex + '__City', 'AdModelProp_Addresses_' + nextIndex + '__StateCodeFK', 'AdModelProp_Addresses_' + nextIndex + '__Zip', 'AdModelProp_Addresses_' + nextIndex + '__ProximityRadius');
        });
        $('#AdModelProp_Addresses_' + nextIndex + '__Zip').change(function (e) {
            doOptions('AdModelProp_Addresses_' + nextIndex + '__Address', 'AdModelProp_Addresses_' + nextIndex + '__City', 'AdModelProp_Addresses_' + nextIndex + '__StateCodeFK', 'AdModelProp_Addresses_' + nextIndex + '__Zip', 'AdModelProp_Addresses_' + nextIndex + '__ProximityRadius');
        });
        $('#AdModelProp_Addresses_' + nextIndex + '__ProximityRadius').change(function (e) {
            doOptions('AdModelProp_Addresses_' + nextIndex + '__Address', 'AdModelProp_Addresses_' + nextIndex + '__City', 'AdModelProp_Addresses_' + nextIndex + '__StateCodeFK', 'AdModelProp_Addresses_' + nextIndex + '__Zip', 'AdModelProp_Addresses_' + nextIndex + '__ProximityRadius');
        });
    }
//    $.validator.unobtrusive.parse('#form0');
//    $.validate.unobtrusive.parse('#form0');
}


var onSelect = function (e) {

    var formDirty = $('#AdModelProp_LandingUrl').serialize() + $('#AdModelProp_DisplayUrl').serialize() + $('#ProductGroup_Words').serialize();
    if (formClean != formDirty && $('#AdModelProp_IsNew').val() != 'True') {
        var dirtyFormWindow = $('#DirtyFormWindow').kendoWindow({
            resizable: false,
            modal: true,
            title: "Unsaved Values"
        }).data("kendoWindow");
        $('#DirtyFormWindow').show();
        dirtyFormWindow.center();
        dirtyFormWindow.open();
        e.preventDefault();
    }

};
var onActivate = function (e) {
    switch (tabStrip.select().text()) {
        case "Create Ads":

            for (var map in mapArray) {
                L.Util.requestAnimFrame(mapArray[map].invalidateSize, mapArray[map], !1, mapArray[map]._container);
            }
            if ($('#currentMode').val() != "True") {
                $("#btnOne").addClass('selected');
                $("#btnTwo").removeClass('selected');
                $("#btnThree").removeClass('selected');
                $("#btnTwo").addClass('unselected');
                $("#btnThree").addClass('unselected');
            }
            break;
        case "Define Product":
        case 'Additional Click Through Links("SiteLinks")':
        case "Negative Keywords":
            if ($('#currentMode').val() != "True") {
                $("#btnOne").addClass('selected');
                $("#btnTwo").removeClass('selected');
                $("#btnThree").removeClass('selected');
                $("#btnTwo").addClass('unselected');
                $("#btnThree").addClass('unselected');
            }
            break;
        case "Categories":
            if ($('#currentMode').val() != "True") {
                $("#btnOne").addClass('selected');
                $("#btnTwo").addClass('selected');
                $("#btnTwo").removeClass('unselected');
                $("#btnThree").removeClass('selected');
                $("#btnThree").addClass('unselected');
            }
            break;
        case "Billing & Launch":
            tabStrip.reload(tabStrip.tabGroup.children('li:contains("Billing & Launch")'));
            break;
        case "View Keywords":
            tabStrip.reload(tabStrip.tabGroup.children('li:contains("View Keywords")'));
            if ($('#currentMode').val() != "True") {
                $("#btnOne").removeClass('unselected');
                $("#btnTwo").removeClass('unselected');
                $("#btnThree").removeClass('unselected');
                $("#btnOne").addClass('selected');
                $("#btnTwo").addClass('selected');
                $("#btnThree").addClass('selected');
            }
            break;
    }
};

//Generate Tab
var tabStrip = $("#tabstrip").kendoTabStrip({ activate: onActivate, select: onSelect

}).data("kendoTabStrip");

// Start Enable tabs region
var tab = tabStrip.select();
tabStrip.enable(tab.next(), tab.next().hasClass("k-state-disabled"));
function OnBegin() {
    var urlStr = $('#LogoUrlStr').val() + 'congratulations.jpg';
    if (urlStr == $('#displayBox').attr('src')) {
        $.blockUI({ message: '<div><img src ="' + urlStr + '" /><div style="text-align:center"><button class="k-button" id="btnCongrats">Ok</button></div></div>', css: {
            top: ($(window).height() - $('#displayBox')[0].naturalHeight) / 2 + 'px',
            left: ($(window).width() - $('#displayBox')[0].naturalWidth) / 2 + 'px',
            width: $('#displayBox')[0].naturalWidth + 'px',
            border: '0px solid #aaa'
        }
        });
    }
    else
        if ($.browser.version > "8.0") {
            $.blockUI({
                message: $('#displayBox'),
                css: {
                    top: ($(window).height() - $('#displayBox')[0].naturalHeight) / 2 + 'px',
                    left: ($(window).width() - $('#displayBox')[0].naturalWidth) / 2 + 'px',
                    width: $('#displayBox')[0].naturalWidth + 'px',
                    border: '0px solid #aaa'
                }
            });
        } else {
            $.blockUI({
                message: $('#displayBox'),
                css: {
                    top: ($(window).height() - $('#displayBox')[0].clientHeight) / 2 + 'px',
                    left: ($(window).width() - $('#displayBox')[0].clientWidth) / 2 + 'px',
                    width: $('#displayBox')[0].clientWidth + 'px',
                    border: '0px solid #aaa'
                }
            });
        }
    }


function OnSuccess(id) {
    if ($('#displayBox').attr('src') != $('#LogoUrlStr').val() + 'congratulations.jpg')
        $.unblockUI();
    var tab;
    //alert(id);
    if (id == "Categories") {
        if ($('#IsLaunched').val() == 'False') {
            if (!tabStrip.tabGroup.children('li:contains("' + id + '")').text()) {
                tabStrip.append({
                    text: "Categories",
                    contentUrl: $('#CategoriesUrl').val()
                }, tabStrip.tabGroup.children("li:last")).select();
                tab = tabStrip.tabGroup.children('li:contains("' + id + '")');
                tabStrip.select(tab);
            } else {
                tab = tabStrip.tabGroup.children('li:contains("' + id + '")');
                tabStrip.select(tab);
            }
        }
    } else if (id == "Create Ads") {
        tab = tabStrip.tabGroup.children('li:contains("' + id + '")');
        tabStrip.select(tab);
    } else if (id == "Billing & Launch") {
        if (!tabStrip.tabGroup.children('li:contains("' + id + '")').text()) {
            tabStrip.append({
                text: "Billing & Launch",
                contentUrl: $('#BillingLaunchUrl').val()
            }, tabStrip.tabGroup.children("li:last")).select();
            tab = tabStrip.tabGroup.children('li:contains("' + id + '")');
            tabStrip.select(tab);
        } else {
            tab = tabStrip.tabGroup.children('li:contains("' + id + '")');
            tabStrip.select(tab);
        }
    }
    else if (id == "AdditionalLinks") {
        if ($('input[id*="SiteLinks_"]').length < 1) {
            removeCurrentTab();
        }
    }
    else if (id == "NegativeKeywords") {
        if ($("#NegativeKeywordsText").val().trim().length < 1) {
            removeCurrentTab();
        }
    } else if (id == "Keywords") {

    } else {
        if (id.name == "Keywords") {
            $('#KeywordCount').html(id.count);
            tabStrip.reload(tabStrip.select());
        }
        if (id != "" && id.name != "Keywords") {
            var arr = id.split('<~>');
            var stitle, sbody;
            if (arr.length > 1) {
                sbody = arr[1];
                stitle = arr[0];
            } else {
                sbody = arr[0];
                stitle = "Error";
            }
            $('.InvalidDescriptionText').html(sbody);
            var pausePromotionWindow = $('#InvalidDescriptionWindow').kendoWindow({
                resizable: false,
                modal: true,
                title: stitle
            }).data("kendoWindow");
            $('#InvalidDescriptionWindow').show();
            pausePromotionWindow.center();
            pausePromotionWindow.open();
        }
    }
    //$("#tabstrip").children('.k-content').height(650);
}

function removeCurrentTab() {
    var tab = tabStrip.select();
    var otherTab = tab.prev();
    tabStrip.remove(tab);
    tabStrip.select(tabStrip.tabGroup.children('li:contains("Create Ads")'));
}