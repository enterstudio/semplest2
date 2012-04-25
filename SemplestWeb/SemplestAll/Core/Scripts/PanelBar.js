$("#panelbar-images").kendoPanelBar({
    dataSource: [
        {
            text: "Home",
            items: [
                        { text: "Quick Start Guide" },
                        { text: "FAQs" },
                        { text: "Contact Us" },
                        { text: "Create User", url: "../Home" },
                        { text: "Campaign" },
                        { text: "Search Keywords", url: "../Home/SearchKeywords" }
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