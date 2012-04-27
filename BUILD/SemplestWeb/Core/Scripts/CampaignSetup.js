$(document).ready(function () {
    //Proximity TextBox To Numeric TextBox
    $("#Proxmity").kendoNumericTextBox();
    // Juery Validator for Validations
    var validator = $("#cap-view").kendoValidator().data("kendoValidator"), status = $(".status");
    //Save Click Validation Logic..
    $("#save1").click(function () {
        if (validator.validate()) {
            status.text("Hooray! Your tickets has been booked!").addClass("valid");
            tabStrip.select(1);
            tabStrip.enable(tab.next(), tab.next().hasClass("k-state-disabled"));
        } else {
            status.text("Oops! There is invalid data in the form.").addClass("invalid");
        }
    });
    // Previous and Save And Continue Button tab changed Logic
    $("#save2").click(function () { tabStrip.select(2); tabStrip.enable(tab.next().next(), tab.next().next().hasClass("k-state-disabled")); });
    $("#save3").click(function () { tabStrip.select(3); tabStrip.enable(tab.next().next().next(), tab.next().next().next().hasClass("k-state-disabled")); });
    $("#back1").click(function () { tabStrip.select(0); });
    $("#back2").click(function () { tabStrip.select(1); });
    $("#back3").click(function () { tabStrip.select(2); });
    $("#save").click(function () { tabStrip.select(0); });
    //DropdownlistBindig
    $("#dropDownList").kendoDropDownList({ dataTextField: "text", dataValueField: "value", dataSource: [{ text: "Item1", value: "1" }, { text: "Item2", value: "2"}] });

    // Dropdownlist for Period
    $("#dropDownPeriodList").kendoDropDownList();

    //DateFunctions Start And Date
    function startChange() {
        var startDate = start.value();

        if (startDate) {
            startDate = new Date(startDate);
            startDate.setDate(startDate.getDate() + 1);
            end.min(startDate);
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

    var start = $("#StartDate").kendoDatePicker({
        change: startChange
    }).data("kendoDatePicker");

    var end = $("#EndDate").kendoDatePicker({
        change: endChange
    }).data("kendoDatePicker");

    start.max(end.value());
    end.min(start.value());
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
    var tabStrip = $("#tabstrip").kendoTabStrip({ activate: onActivate }).data("kendoTabStrip");

    // Start Enable tabs region
    //                var tab = tabStrip.select();
    //                tabStrip.enable(tab.next(), tab.next().hasClass("k-state-disabled"));
    //                tabStrip.enable(tab.next().next(), tab.next().next().hasClass("k-state-disabled"));
    //                tabStrip.enable(tab.next().next().next(), tab.next().next().next().hasClass("k-state-disabled"));
    // end Enable tabs Region

    //Selected Button Logic
    $("input[type='button']#btnOne").addClass("k-button rounded");
    
    var isAdditionalLinksAdded = false;
    $("#additionalLinks").click(function () {
        if (!isAdditionalLinksAdded) {
            tabStrip.append({
                text: 'Additional Click Through Links("SiteLinks")'
            });
            isAdditionalLinksAdded = true;
        }
    });
    var isnegativeKeyWordsAdded = false;
    $("#negativeKeyWords").click(function () {
        if (!isnegativeKeyWordsAdded) {
            tabStrip.append({
                text: 'Negative Keywords'
            });
            isnegativeKeyWordsAdded = true;
        }
    });
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
    content = content.replace("doOptions()", "doOptions('Addresses_" + nextIndex + "__Address1')");
    content = content.replace("optionsNarrative", "optionsNarrative_" + nextIndex + "");
    $(container).append(content);
} 
