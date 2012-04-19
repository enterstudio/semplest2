$("#panelbar-admin").kendoPanelBar({
    dataSource: [
                {
                    text: "Home",
                    items: [
                        { text: "Employee Setup" },
                        { text: "Client Account Setup" },
                        { text: "Billing/Finance" },
                        { text: "Configure" }
                    ]
                }
            ], expandMode: "single"
});