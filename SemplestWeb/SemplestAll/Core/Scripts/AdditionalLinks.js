$(".additionalLinks").click(function () {
    var length = tabStrip.items().length;
    var isAdditionalLinksAdded = false;
    for (var item = 0; item < length; item++) {
        if (tabStrip.items().item(item).innerText == "Additional Links") {
            isAdditionalLinksAdded = true;
            break;
        }
    }
    if (!isAdditionalLinksAdded)
        tabStrip.append({
            text: "Additional Links",
            contentUrl: '/Campaign/AdditionalLinks?model=' + $(this).parent().parent().find('input')[1].value
        });
    tab = tabStrip.tabGroup.children('li:contains("Additional Links")');
    tabStrip.select(tab);
});
