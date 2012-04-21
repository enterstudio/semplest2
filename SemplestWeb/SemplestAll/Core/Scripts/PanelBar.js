$("#panelbar-images").kendoPanelBar({
    dataSource: [
        {
            text: "Home",
            items: [
                { text: "My Account" },
                { text: "Reporting" },
                { text: "Billing" }
            ]
        },
        {
            text: "Product Groups",
            items: [
                { text: "Insurance", items: [{ text: "Health Insurance" }, { text: "Car Insurance" }] },
                { text: "Safty Tips", items: [{ text: "Auto Mobile" }] },
                { text: "Agents", items: [{ text: "Best Agents" }] }
            ]
        }
    ],
    expandMode: "single"
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