
/**
 * INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.microsoft.adcenter.api.notifications;

public class INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage extends java.lang.Exception{

    private static final long serialVersionUID = 1337717278702L;
    
    private com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE faultMessage;

    
        public INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage() {
            super("INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage");
        }

        public INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage(java.lang.String s) {
           super(s);
        }

        public INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public INotificationService_GetArchivedNotifications_ApiFaultFault_FaultMessage(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE msg){
       faultMessage = msg;
    }
    
    public com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE getFaultMessage(){
       return faultMessage;
    }
}
    