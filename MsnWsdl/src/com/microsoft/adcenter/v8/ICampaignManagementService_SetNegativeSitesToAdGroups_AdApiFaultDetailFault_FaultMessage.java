
/**
 * ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.microsoft.adcenter.v8;

public class ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage extends java.lang.Exception{

    private static final long serialVersionUID = 1337717191463L;
    
    private com.microsoft.adapi.AdApiFaultDetailE faultMessage;

    
        public ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage() {
            super("ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage");
        }

        public ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage(java.lang.String s) {
           super(s);
        }

        public ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ICampaignManagementService_SetNegativeSitesToAdGroups_AdApiFaultDetailFault_FaultMessage(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.microsoft.adapi.AdApiFaultDetailE msg){
       faultMessage = msg;
    }
    
    public com.microsoft.adapi.AdApiFaultDetailE getFaultMessage(){
       return faultMessage;
    }
}
    