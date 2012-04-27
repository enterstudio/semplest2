$(document).ready(function () {
});

//Helper functions to Add Multiple Items..

function removeNestedForm(element, container, deleteElement) {
    $container = $(element).parents(container);
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
