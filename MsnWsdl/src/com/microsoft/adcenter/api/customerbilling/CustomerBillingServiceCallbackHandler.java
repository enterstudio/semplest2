
/**
 * CustomerBillingServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.api.customerbilling;

    /**
     *  CustomerBillingServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CustomerBillingServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CustomerBillingServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CustomerBillingServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for addInsertionOrder method
            * override this method for handling normal response from addInsertionOrder operation
            */
           public void receiveResultaddInsertionOrder(
                    com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addInsertionOrder operation
           */
            public void receiveErroraddInsertionOrder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInsertionOrdersByAccount method
            * override this method for handling normal response from getInsertionOrdersByAccount operation
            */
           public void receiveResultgetInsertionOrdersByAccount(
                    com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInsertionOrdersByAccount operation
           */
            public void receiveErrorgetInsertionOrdersByAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccountMonthlySpend method
            * override this method for handling normal response from getAccountMonthlySpend operation
            */
           public void receiveResultgetAccountMonthlySpend(
                    com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccountMonthlySpend operation
           */
            public void receiveErrorgetAccountMonthlySpend(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getKOHIOInvoices method
            * override this method for handling normal response from getKOHIOInvoices operation
            */
           public void receiveResultgetKOHIOInvoices(
                    com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getKOHIOInvoices operation
           */
            public void receiveErrorgetKOHIOInvoices(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDisplayInvoices method
            * override this method for handling normal response from getDisplayInvoices operation
            */
           public void receiveResultgetDisplayInvoices(
                    com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDisplayInvoices operation
           */
            public void receiveErrorgetDisplayInvoices(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInvoicesInfo method
            * override this method for handling normal response from getInvoicesInfo operation
            */
           public void receiveResultgetInvoicesInfo(
                    com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInvoicesInfo operation
           */
            public void receiveErrorgetInvoicesInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateInsertionOrder method
            * override this method for handling normal response from updateInsertionOrder operation
            */
           public void receiveResultupdateInsertionOrder(
                    com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateInsertionOrder operation
           */
            public void receiveErrorupdateInsertionOrder(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getInvoices method
            * override this method for handling normal response from getInvoices operation
            */
           public void receiveResultgetInvoices(
                    com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInvoices operation
           */
            public void receiveErrorgetInvoices(java.lang.Exception e) {
            }
                


    }
    