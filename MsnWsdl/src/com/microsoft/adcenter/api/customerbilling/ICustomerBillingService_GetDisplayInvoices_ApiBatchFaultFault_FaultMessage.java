
/**
 * ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.microsoft.adcenter.api.customerbilling;

public class ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage extends java.lang.Exception{

    private static final long serialVersionUID = 1337717221597L;
    
    private com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE faultMessage;

    
        public ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage() {
            super("ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage");
        }

        public ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage(java.lang.String s) {
           super(s);
        }

        public ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE msg){
       faultMessage = msg;
    }
    
    public com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE getFaultMessage(){
       return faultMessage;
    }
}
    