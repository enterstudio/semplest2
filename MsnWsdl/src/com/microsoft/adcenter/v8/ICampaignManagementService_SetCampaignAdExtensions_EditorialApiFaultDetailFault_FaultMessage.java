
/**
 * ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.microsoft.adcenter.v8;

public class ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage extends java.lang.Exception{

    private static final long serialVersionUID = 1337717190996L;
    
    private com.microsoft.adcenter.v8.EditorialApiFaultDetailE faultMessage;

    
        public ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage() {
            super("ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage");
        }

        public ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage(java.lang.String s) {
           super(s);
        }

        public ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ICampaignManagementService_SetCampaignAdExtensions_EditorialApiFaultDetailFault_FaultMessage(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.microsoft.adcenter.v8.EditorialApiFaultDetailE msg){
       faultMessage = msg;
    }
    
    public com.microsoft.adcenter.v8.EditorialApiFaultDetailE getFaultMessage(){
       return faultMessage;
    }
}
    