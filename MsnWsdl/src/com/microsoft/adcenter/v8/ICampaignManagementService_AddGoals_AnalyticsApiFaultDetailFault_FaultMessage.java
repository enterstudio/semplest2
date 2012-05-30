
/**
 * ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.microsoft.adcenter.v8;

public class ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage extends java.lang.Exception{

    private static final long serialVersionUID = 1337717190520L;
    
    private com.microsoft.adcenter.v8.AnalyticsApiFaultDetailE faultMessage;

    
        public ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage() {
            super("ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage");
        }

        public ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage(java.lang.String s) {
           super(s);
        }

        public ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ICampaignManagementService_AddGoals_AnalyticsApiFaultDetailFault_FaultMessage(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.microsoft.adcenter.v8.AnalyticsApiFaultDetailE msg){
       faultMessage = msg;
    }
    
    public com.microsoft.adcenter.v8.AnalyticsApiFaultDetailE getFaultMessage(){
       return faultMessage;
    }
}
    