 $(document).ready(function () {
    $.getJSON($('#SideBarUrl').val(), {}, function (data) {
        for (var mainGroup in data) {
            for (var subitem in data[mainGroup].SubItems) {
                var items = [];
                for (var subitem1 in data[mainGroup].SubItems[subitem].SubItems) {
                    items[subitem1] = ({ text: data[mainGroup].SubItems[subitem].SubItems[subitem1].Name, url: data[mainGroup].SubItems[subitem].SubItems[subitem1].Url });
                }
                treeview.append({ text: data[mainGroup].SubItems[subitem].Name, url: data[mainGroup].SubItems[subitem].Url, items: items });
            }
        }
    });
    var panelBar = $("#panelbar-images").kendoPanelBar({
        expandMode: "single"
    }).data("kendoPanelBar");
    var treeview = $("#treeview").kendoTreeView().data("kendoTreeView");
    $("#panelbar-images").on("click", ".k-in", function (e) {
        treeview.toggle($(e.target).closest(".k-item"));
    });
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
​