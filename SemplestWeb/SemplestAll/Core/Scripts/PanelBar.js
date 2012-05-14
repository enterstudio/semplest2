$(document).ready(function () {
    $.getJSON($('#SideBarUrl').val(), {}, function (data) {
        for (var mainGroup in data) {
            panelBar.append({ encoded: false, text: data[mainGroup].Name }, panelBar.select(data[mainGroup].Name));
            for (var subitem in data[mainGroup].SubItems) {
                panelBar.append({ text: data[mainGroup].SubItems[subitem].Name, url: data[mainGroup].SubItems[subitem].Url }, panelBar.element.children("li")[mainGroup]);
                for (var subitem1 in data[mainGroup].SubItems[subitem].SubItems) {
                    panelBar.append({ text: data[mainGroup].SubItems[subitem].SubItems[subitem1].Name, url: data[mainGroup].SubItems[subitem].SubItems[subitem1].Url }, panelBar.element.children("li")[mainGroup]);
                }
            }
        }
    });
    var panelBar = $("#panelbar-images").kendoPanelBar({
        expandMode: "single"
    }).data("kendoPanelBar");
    $("#panelbar-profile").kendoPanelBar({
        dataSource: [
            {
                text: "Home",
                items: [
                    { text: "Reporting" },
                    { text: "Billing" },
                    { text: "Quick Start Guide" },
                    { text: "FAQs" },
                    { text: "Contact Us" }
                ]
            }
        ],
        expandMode: "single"
    });
});