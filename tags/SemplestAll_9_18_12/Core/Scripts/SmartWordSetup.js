/// <reference path="jquery-1.7.2-vsdoc.js" />
/// <reference path="kendo.all-vsdoc.js" />


var formClean;




$(document).ready(function () {



    $("#form0").kendoValidator({
        rules: {
            custom: function (input) {
                var rval = false;
                if (input.is("[name=LandingUrl]")) {
                    if (input.val().substr(0, 4) == 'http') rval = true;
                }
                //                else if (input.is("[name=CategoryIds]")) {
                //                    var fields = $("input[name=CategoryIds]").serializeArray();
                //                    if (fields.length == 0) {
                //                        rval = false;
                //                    } else {
                //                        rval = true; }}
                else {
                    rval = true;
                }
                return rval;
            }
        }
    });


    //tabStrip.tabGroup.children('li:contains("Create Ads")').find('a.k-link').data('contentUrl', $('#CreateAdsUrl').val());
    $("#adMessage").css("visibility", "hidden");
    formClean = $('#LandingUrl').serialize() + $('#DisplayUrl').serialize() + $('#Words').serialize();

    var originalValue = $('#LandingUrl').val();
    if (originalValue.length == 0) {
        $('#LandingUrl').val('http://');
    }
    if ($('#IsCompleted').val() == 'False' && $('#IsLaunched').val() == 'True') {
        $('#LandingUrl').attr("readonly", true);
        $('#DisplayUrl').attr("readonly", true);
    }

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
    $('#LandingUrl').live("keypress", function (e) {
        if (e.keyCode == 38 || e.keyCode == 39)
            e.preventDefault();
    });
    $('#DisplayUrl').live("keypress", function (e) {
        if (e.keyCode == 47 || e.keyCode == 63)
            e.preventDefault();
        var dispStr = $('#DisplayUrl').val();
        if (dispStr.length > 35) {
            dispStr = dispStr.substring(0, 35);
            $('#DisplayUrl').val(dispStr);
        }
    });

    $('#LandingUrl').live("keyup", function (e) {
        var originalValue = $('#LandingUrl').val();
        var index = originalValue.indexOf('http://');
        if (index >= 0) {
            var dispStr = $('#LandingUrl').val().substring(index + 7);
            //var dispStr = $('#LandingUrl').val();
            if (dispStr.indexOf('/') >= 0) {
                dispStr = dispStr.substring(0, dispStr.indexOf('/'));
            }
            if (dispStr.indexOf('?') >= 0) {
                dispStr = dispStr.substring(0, dispStr.indexOf('?'));
            }
            $('#DisplayUrl').val(dispStr);
            if (dispStr.length > 35) {
                dispStr = dispStr.substring(0, 35);
                $('#DisplayUrl').val(dispStr);
            }

        }
        else {
            var landStr = $('#LandingUrl').val();
            if (landStr.indexOf('/') >= 0) {
                landStr = landStr.substring(0, landStr.indexOf('/'));
            }
            if (landStr.indexOf('?') >= 0) {
                landStr = landStr.substring(0, landStr.indexOf('?'));
            }
            $('#DisplayUrl').val(landStr);
            if (landStr.length > 35) {
                landStr = landStr.substring(0, 35);
                $('#DisplayUrl').val(landStr);
            }
        }
    });
    $("#IsAutoBid").click(function () {
        if ($("#IsAutoBid:checked").val() == 'true') {
            $("#AutoBidMaxCPC").attr('disabled', false);
        } else {
            $("#AutoBidMaxCPC").attr('disabled', true);
        }
    });
    var prodAuto = $("#AutoBidMaxCPC").kendoNumericTextBox({ format: "#", decimals: 0, min: 0 }).data("kendoNumericTextBox");
    if (prodAuto != null) {
        //$("#IsAutoBid").trigger('click');
        if ($("#IsAutoBid:checked").val() != null) {
            $("#AutoBidMaxCPC").attr('disabled', false);
        } else {
            $("#AutoBidMaxCPC").attr('disabled', true);
        }
        prodAuto.wrapper.find(".k-numeric-wrap").addClass("expand-padding").find(".k-select").hide();
        prodAuto.wrapper.find(".k-link").addClass("k-state-disabled").unbind("keydown");
        prodAuto.wrapper.find(".k-link").addClass("k-state-disabled").unbind("mousedown");
    }
    //$("#IsAutoBid").trigger();
    $('.k-dropdownlist').kendoDropDownList();
    // Juery Validator for Validations
    var validator = $("#productGroupModel").kendoValidator({
        rules: {
            minreq: function (input) {
                if ($.browser.version > "8.0" && $.browser.msie) {
                    if (input.is("[name=ProductGroup.Budget]")) {
                        if (input.val() < parseInt($('#Configuration_CustomerMinOrderAmount').val())) {
                            return false;
                        }
                        status.text("").addClass("valid");
                        return true;
                    }
                    return true;
                }
                else {
                    if (input.attr("name") == "ProductGroup.Budget") {
                        if (input.val() < parseInt($('#Configuration_CustomerMinOrderAmount').val())) {
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
            minreq: "Budget must not be less than " + parseInt($('#Configuration_CustomerMinOrderAmount').val()),
            min: "{0} should be greater than or equal to {1}",
            max: "{0} should be smaller than or equal to {1}"
        }
    }).data("kendoValidator"), status = $(".status");
    var validator1 = $("#adModel").kendoValidator().data("kendoValidator"), status = $(".status");
    //Save Click Validation Logic..
    $("#save1").click(function (e) {
        return;
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
            $('#lblbudgetdisplay').html('/ Promotion Total Budget');
            $("#EndDate").removeClass("enddate");
            $("#EndDate").kendoDatePicker({
                //change: endChange
            }).data("kendoDatePicker");
        } else {
            $('#lblbudgetdisplay').html('/ Month');
            $("#EndDate").addClass("enddate");
            $("#EndDate").val('');
            disposeDatePicker();
        }

    };

    function disposeDatePicker() {
        var datepicker = $("#EndDate").data("kendoDatePicker"),
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

    $("input[type='button']#btnOne").addClass("k-button rounded");
    $("#negativeKeyWords").click(function () {
        var length = tabStrip.items().length;
        var isnegativeKeyWordsAdded = false;
        for (var item = 0; item < length; item++) {
            if (tabStrip.items().item(item).innerText == "Negative SmartWords") {
                isnegativeKeyWordsAdded = true;
                break;
            }
        }
        if (!isnegativeKeyWordsAdded) {
            tabStrip.insertAfter({
                text: "Negative SmartWords",
                contentUrl: $('#NegativeSmartWordsUrl').val()
            }, tabStrip.tabGroup.children('li:contains("Define Product")'));
        }
        tab = tabStrip.tabGroup.children('li:contains("Negative SmartWords")');
        tabStrip.select(tab);
    });

    $("#viewSelectedKeywords").click(function () {
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
        formClean = $('#LandingUrl').serialize() + $('#DisplayUrl').serialize() + $('#Words').serialize();


        $('#DirtyFormWindow').hide();
        $('#DirtyFormWindow').data("kendoWindow").close();
    });

    $("#btnCancelDF").click(function (event) {
        var dirtyWindow = $('#DirtyFormWindow').data("kendoWindow");
        $('#DirtyFormWindow').hide();
        dirtyWindow.close();
    });

    $("#btnOkCAT").click(function (event) {
        //for now know submit lets just remove tabs
        //$("#hiddenDirtyForm").submit();

        selectionAddress = $('input[name=group1]:checked').val();
        $('#PromotionAddressType').val(selectionAddress);
        $("div .address button").trigger('click');
        $("div .adLink button").trigger('click');
        $("#AddBusinessLocationButton").attr('disabled', selectionAddress == 'NATIONALLY');
        $("#RemoveBusinessLocationButton").attr('disabled', selectionAddress == 'NATIONALLY');
        $("div .address button").attr('disabled', selectionAddress == 'NATIONALLY');
        if ($('#ChangeAddressTypeForm').data("kendoWindow") != null) {
            $('#ChangeAddressTypeForm').hide();
            $('#ChangeAddressTypeForm').data("kendoWindow").close();
        }
    });
    var selectionAddress = $('#PromotionAddressType').val();
    if (selectionAddress == '' || selectionAddress == 'NATIONALLY') {
        selectionAddress = 'NATIONALLY';
        $("#AddBusinessLocationButton").attr('disabled', true);
        $("#RemoveBusinessLocationButton").attr('disabled', true);
        $('#PromotionAddressType').val(selectionAddress);
    }

    $('input:radio[value|=' + selectionAddress + ']').attr('checked', true);
    $("#btnCancelCAT").click(function (event) {
        $('input:radio[value|=' + $('#PromotionAddressType').val() + ']').attr('checked', true);
        var changeWindow = $('#ChangeAddressTypeForm').data("kendoWindow");
        $('#ChangeAddressTypeForm').hide();
        changeWindow.close();
    });

    $("input[name=group1]").change(function (e) {
        var freshForm = true;
        for (var i = 0; i < $('div .address input[name*="Delete"]').length; i++) {
            if ($('#Addresses_' + i + '__Delete').val() == 'False') {
                if ($('#Addresses_' + i + '__Address').val() != '' ||
                    $('#Addresses_' + i + '__City').val() != '' ||
                        $('#Addresses_' + i + '__StateCodeFK').val() > 0 ||
                            $('#Addresses_' + i + '__Zip').val() != '' ||
                                $('#Addresses_' + i + '__ProximityRadius').val() != 5) {
                    freshForm = false;
                    break;
                }
            }
        }

        //            &&
        //
        if (freshForm) {
            $("#btnOkCAT").trigger('click');
        } else {
            var changeWindow = $('#ChangeAddressTypeForm').kendoWindow({
                resizable: false,
                modal: true,
                title: "Change Locale"
            }).data("kendoWindow");
            $('#ChangeAddressTypeForm').show();
            changeWindow.center();
            changeWindow.open();
        }
    });



    for (var i = 0; i < $('.address').length; i++) {
        $('.address')[i].outerHTML = DisableGeoTargetFields($('.address')[i].outerHTML);
    }

});                                              //end ready

function removeNestedForm(element, container, deleteElement) {
    var $container = $(element).parents(container);
    //    if (container == "div.ads") {
    //        if ($container.find('input')[1].value == null || $container.find('input')[1].value == '')
    //            $container.find('input')[1].value = 'deleted';
    //        if ($container.find('input')[2].value == null || $container.find('input')[2].value == '')
    //            $container.find('input')[2].value = 'deleted';
    //        if ($container.find('input')[3].value == null || $container.find('input')[3].value == '')
    //            $container.find('input')[3].value = 'deleted';
    //    }
    $container.find(deleteElement).val('True');
    $container.hide();
    var cnt = $(".ads input[name*='Delete']").length;
    for (var i = 0; i < cnt; i++) {
        if ($(".ads input[name*='Delete']")[i].value == 'False') {
            $("#adMessage").css("visibility", "hidden");
            return;
        }

    }
    $("#adMessage").css("visibility", "visible");

    $("#getCategories").attr('disabled', true);
}

function addNestedForm(container, counter, ticks, content) {
    var nextIndex = $(counter).length;
    var pattern = new RegExp(ticks, "gi");
    content = content.replace(pattern, nextIndex);
    pattern = "UIDVALUE";
    content = content.replace(pattern, nextIndex + ticks);
    if (container == "#addresses") {
        content = content.replace("doOptions()", "doOptions('Addresses_" + nextIndex +
"__City','Addresses_" + nextIndex + "__StateCodeFK','Addresses_" + nextIndex +
"__Zip','Addresses_" + nextIndex + "__Proximity')");

        content = content.replace("class=\"map\"", "class=\"map\"" + "id=\"map_" + nextIndex + "\"");
        content.replace(new RegExp('nestedObject', "igm"), ' Addresses_' + nextIndex + '_');
        content = DisableGeoTargetFields(content);

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
        $("#adMessage").css("visibility", "hidden");
        $("#getCategories").attr('disabled', false);
        $("#Ads_" + nextIndex + "__PromotionAdsPK_div").html(template({
            id: nextIndex + 1,
            title: $("#DisplayUrl").val(),
            twitter: $("#Ads_" + nextIndex + "__AdTitle").val(),
            content: $("#Ads_" + nextIndex + "__AdTextLine1").val(),
            content1: $("#Ads_" + nextIndex + "__AdTextLine2").val()
        }));
        $("#Ads_" + nextIndex + "__AdTitle").attr("data-bind", "events: { change: listener}");
        $("#Ads_" + nextIndex + "__AdTextLine1").attr("data-bind", "events: { change: listener}");
        $("#Ads_" + nextIndex + "__AdTextLine2").attr("data-bind", "events: { change: listener}");
        kendo.bind($("#Ads_" + nextIndex + "__PromotionAdsPK_ul"), kendo.observable({
            listener: function (e) {
                $("#Ads_" + nextIndex + "__PromotionAdsPK_div").html(template({
                    id: nextIndex + 1,
                    title: $("#DisplayUrl").val(),
                    twitter: $("#Ads_" + nextIndex + "__AdTitle").val(),
                    content: $("#Ads_" + nextIndex + "__AdTextLine1").val(),
                    content1: $("#Ads_" + nextIndex + "__AdTextLine2").val()
                }));
            }
        }));
    }
    if (container == "#addresses") {
        //$("#Addresses_" + nextIndex + "__StateCodeFK").kendoDropDownList();
        //$("#Addresses_" + nextIndex + "__ProximityRadii").kendoDropDownList();
        doOptions('Addresses_' + nextIndex + '__Address', 'Addresses_' + nextIndex + '__City', 'Addresses_' + nextIndex + '__StateCodeFK', 'Addresses_' + nextIndex + '__Zip', 'Addresses_' + nextIndex + '__ProximityRadius');
        $('#Addresses_' + nextIndex + '__Address').change(function (e) {
            doOptions('Addresses_' + nextIndex + '__Address', 'Addresses_' + nextIndex + '__City', 'Addresses_' + nextIndex + '__StateCodeFK', 'Addresses_' + nextIndex + '__Zip', 'Addresses_' + nextIndex + '__ProximityRadius');
        });
        $('#Addresses_' + nextIndex + '__City').change(function (e) {
            doOptions('Addresses_' + nextIndex + '__Address', 'Addresses_' + nextIndex + '__City', 'Addresses_' + nextIndex + '__StateCodeFK', 'Addresses_' + nextIndex + '__Zip', 'Addresses_' + nextIndex + '__ProximityRadius');
        });
        $('#Addresses_' + nextIndex + '__StateCodeFK').change(function (e) {
            doOptions('Addresses_' + nextIndex + '__Address', 'Addresses_' + nextIndex + '__City', 'Addresses_' + nextIndex + '__StateCodeFK', 'Addresses_' + nextIndex + '__Zip', 'Addresses_' + nextIndex + '__ProximityRadius');
        });
        $('#Addresses_' + nextIndex + '__Zip').change(function (e) {
            doOptions('Addresses_' + nextIndex + '__Address', 'Addresses_' + nextIndex + '__City', 'Addresses_' + nextIndex + '__StateCodeFK', 'Addresses_' + nextIndex + '__Zip', 'Addresses_' + nextIndex + '__ProximityRadius');
        });
        $('#Addresses_' + nextIndex + '__ProximityRadius').change(function (e) {
            doOptions('Addresses_' + nextIndex + '__Address', 'Addresses_' + nextIndex + '__City', 'Addresses_' + nextIndex + '__StateCodeFK', 'Addresses_' + nextIndex + '__Zip', 'Addresses_' + nextIndex + '__ProximityRadius');
        });
    }
    //    $.validator.unobtrusive.parse('#form0');
    //    $.validate.unobtrusive.parse('#form0');
}

function DisableGeoTargetFields(content) {
    if ($('input:radio[name=group1]:checked').val() == "STATE") {
        var labelStart = content.indexOf('State</label>') - 30;
        var comboStart = content.indexOf('--');
        var firstPartOfString = content.substr(0, labelStart);
        var secondPartOfString = content.substr(comboStart);
        content = firstPartOfString + content.substr(labelStart, comboStart - labelStart).replace(/disabled=\"disabled\"/g, '') + secondPartOfString;
    }
    else if ($('input:radio[name=group1]:checked').val() == "GEO_POINT") {
        content = content.replace('k-state-disabled', '');

        content = content.replace(/disabled=\"disabled\"/g, '');
    }
    return content;
}

var onSelect = function (e) {

    var formDirty = $('#LandingUrl').serialize() + $('#DisplayUrl').serialize() + $('#Words').serialize();
    if (formClean != formDirty && $('#IsNew').val() != 'True') {
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
            if ($('#displayBox')[0].nameProp == "") {
                $.blockUI({
                    message: "",
                    css: {
                        top: ($(window).height() - $('#displayBox')[0].naturalHeight) / 2 + 'px',
                        left: ($(window).width() - $('#displayBox')[0].naturalWidth) / 2 + 'px',
                        width: $('#displayBox')[0].naturalWidth + 'px',
                        border: '0px solid #aaa'
                    }
                });
            }
            else {
                $.blockUI({
                    message: $('#displayBox'),
                    css: {
                        top: ($(window).height() - $('#displayBox')[0].naturalHeight) / 2 + 'px',
                        left: ($(window).width() - $('#displayBox')[0].naturalWidth) / 2 + 'px',
                        width: $('#displayBox')[0].naturalWidth + 'px',
                        border: '0px solid #aaa'
                    }
                });
            }
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
function OnFailure(event) {
    $.unblockUI();
}

function OnSuccess(id) {
    if ($('#displayBox').attr('src') != $('#LogoUrlStr').val() + 'congratulations.jpg')
        $.unblockUI();
    var tab;
    //alert(id);
    if (id == "Create Ads") {
        tab = tabStrip.tabGroup.children('li:contains("' + id + '")');
        tabStrip.select(tab);
    } else if (id.name == "ViewSmartWords") {
        if (!tabStrip.tabGroup.children('li:contains("View SmartWords")').text()) {
            tabStrip.append({
                text: "View SmartWords",
                contentUrl: $('#ViewSmartWordsUrl').val()
            }, tabStrip.tabGroup.children("li:last")).select();
            tab = tabStrip.tabGroup.children('li:contains("View SmartWords")');
            tabStrip.select(tab);
        } else {
            tab = tabStrip.tabGroup.children('li:contains("View SmartWords")');
            tabStrip.select(tab);
            tabStrip.reload(tab);
        }
    } else if (id == "NegativeKeywords") {
        if ($("#NegativeKeywordsText").val().trim().length < 1) {
            removeCurrentTab();
        }
        var smartTab = tabStrip.tabGroup.children('li:contains("View SmartWords")');
        tabStrip.reload(smartTab);
    } else {
        if (id.name == "Keywords") {
            $('#KeywordCount').html(id.count);
            tabStrip.reload(tabStrip.select());
        } else if (id.name == "Categories") {
            $('input[name *= "HasBeenSaved"]').val('True');
            if (!tabStrip.tabGroup.children('li:contains("' + id.name + '")').text()) {
                tabStrip.append({
                    text: "Categories",
                    contentUrl: $("#CategoriesSmartWordsUrl").val()
                }, tabStrip.tabGroup.children("li:last")).select();
                tab = tabStrip.tabGroup.children('li:contains("' + id.name + '")');
                tabStrip.select(tab);
            } else {
                tab = tabStrip.tabGroup.children('li:contains("' + id.name + '")');
                tabStrip.select(tab);
            }
            parseNewIds(id.newKeys);
        } else if (id.name == "AdditionalLinks") {
            $('input[name *= "SiteLinksSaved"]').val('True');
            if ($('input[id*="SiteLinks_"]').length < 1) {
                removeCurrentTab();
            }
            parseNewIds(id.newKeys);
        }
        if (id != "" && id.name != "Keywords" && id.name != "Categories" && id.name != "AdditionalLinks") {
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

function parseNewIds(newKeys) {
    if (newKeys != "") {
        var items = newKeys.split(",");
        for (var i = 0; i < items.length; i++) {
            var nvp = items[i].split("=");
            //nvp[0]
            var replaceKey;
            if ($('input[value|="' + nvp[0] + '"]')[0].id.split("_")[1] == 'Ads') {
                replaceKey = "PromotionAdsPK";
            } else if ($('input[value|="' + nvp[0] + '"]')[0].id.split("_")[1] == 'Addresses') {
                replaceKey = "GeoTargetingPK";
            } else {
                replaceKey = "SiteLInkPK";
            }
            $('#' + $('input[value|="' + nvp[0] + '"]')[0].id.replace("UID", replaceKey)).val(nvp[1]);
        }
    }
}



$('#getCategories').click(function () {
    enabledIsLaunched();
    var urlStr = $('#LogoUrlStr').val() + 'reviewing your input.jpg';
    $('#displayBox').attr('src', urlStr);
    formClean = $('#LandingUrl').serialize() + $('#DisplayUrl').serialize() + $('#Words').serialize();
    $('#IsNew').val('False');
});

function removeCurrentTab() {
    var tab = tabStrip.select();
    var otherTab = tab.prev();
    tabStrip.remove(tab);
    tabStrip.select(tabStrip.tabGroup.children('li:contains("Define Product")'));
}

