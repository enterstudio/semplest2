$(document).ready(function () {
    enableDisable();
    if ($('#IsCompleted').val() == 'False' && $('#IsLaunched').val() == 'True') {
        $('#getLaunchAdProduct').attr("disabled", true);
        $('#agreecheckbox').attr("disabled", true);
    }


    $("#btnCancel").click(function(event) {
        $.unblockUI();
    });

    if ($("#agreecheckbox:checked").val()) {
        $("#getLaunchAdProduct").attr('disabled', false);
    } else {
        if (true) {
            $("#getLaunchAdProduct").attr('disabled', true);
        }
    }

    var billingLaunchValidator = $("#tickets").kendoValidator({}).data("kendoValidator");
    
    $("#getLaunchAdProduct").click(function (e) {
        if (billingLaunchValidator.validate()) {
            var urlStr = $('#LogoUrlStr').val() + 'congratulations.jpg';
            $('#displayBox').attr('src', urlStr);
        } else {

            e.preventDefault();
        }
    });


    $('#creditcatdType').kendoDropDownList();
    $('#dropDownRange').kendoDropDownList();
    $('#dropDownCreditCard').kendoDropDownList();

    $("#viewSelectedKeywords").click(function () {
        //alert('in viewSelectedKeywords');
        var length = tabStrip.items().length;
        var isSelectedKeywordsAdded = false;
        for (var item = 0; item < length; item++) {
            if (tabStrip.items().item(item).innerText == "View Keywords") {
                isSelectedKeywordsAdded = true;
                break;
            }
        }
        var keywordsUrl = $("#ViewSelectedKeywordsUrl").val();
        if (!isSelectedKeywordsAdded)
            tabStrip.append({
                text: "View Keywords",
                contentUrl: keywordsUrl
            });
        var tab = tabStrip.tabGroup.children('li:contains("View Keywords")');
        tabStrip.select(tab);
    });

    $("#editadproduct").click(function () {
        tabChange1();
    });



    $("#agreecheckbox").click(function () {
        if ($("#agreecheckbox:checked").val()) {
            $("#getLaunchAdProduct").attr('disabled', false);
        }
        else {
            $("#getLaunchAdProduct").attr('disabled', true);
        }
    });

    function tabChange1(parameters) {
        var tab = tabStrip.select();
        tabStrip.remove(tab);
        var reqtab = tabStrip.tabGroup.children('li:contains("Define Product")');
        tabStrip.select(reqtab);
    }

});