function disableIsLaunched() {
    $('.k-textbox').attr('disabled', 'disabled');
    $('.k-dropdownlist').attr('disabled', 'disabled');
    $('input').attr('disabled', true);
}
function disableIsLaunchedCompleted() {
    $('.k-textbox').attr('disabled', 'disabled');
    $('.k-dropdownlist').attr('disabled', 'disabled');
    $('.k-button').attr('disabled', 'disabled');
    $('input').attr('disabled', true);
}
function enableIsLaunched() {
    $('.k-textbox').attr('disabled', 'disabled');
    $('.k-dropdownlist').attr('disabled', 'disabled');
    $('input').attr('disabled', true);
}
function openAllTabs() {
    tabStrip.enable(tab.next(), tab.next().hasClass("k-state-disabled"));
    tabStrip.append({
        text: "Negative Keywords",
        contentUrl: '/Campaign/NegativeKeywords'
    }, tabStrip.tabGroup.children("li:last")).select();
    tabStrip.append({
        text: "Additional Links",
        contentUrl: '/Campaign/AdditionalLinks'
    }, tabStrip.tabGroup.children("li:last")).select();
    tabStrip.append({
        text: "BillingLaunch",
        contentUrl: '/Campaign/BillingLaunch'
    }, tabStrip.tabGroup.children("li:last")).select();
   
}
