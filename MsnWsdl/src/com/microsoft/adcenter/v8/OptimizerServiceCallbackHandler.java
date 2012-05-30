
/**
 * OptimizerServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.v8;

    /**
     *  OptimizerServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class OptimizerServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public OptimizerServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public OptimizerServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for applyBudgetOpportunities method
            * override this method for handling normal response from applyBudgetOpportunities operation
            */
           public void receiveResultapplyBudgetOpportunities(
                    com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from applyBudgetOpportunities operation
           */
            public void receiveErrorapplyBudgetOpportunities(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for applyOpportunities method
            * override this method for handling normal response from applyOpportunities operation
            */
           public void receiveResultapplyOpportunities(
                    com.microsoft.adcenter.v8.ApplyOpportunitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from applyOpportunities operation
           */
            public void receiveErrorapplyOpportunities(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBudgetOpportunities method
            * override this method for handling normal response from getBudgetOpportunities operation
            */
           public void receiveResultgetBudgetOpportunities(
                    com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBudgetOpportunities operation
           */
            public void receiveErrorgetBudgetOpportunities(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBidOpportunities method
            * override this method for handling normal response from getBidOpportunities operation
            */
           public void receiveResultgetBidOpportunities(
                    com.microsoft.adcenter.v8.GetBidOpportunitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBidOpportunities operation
           */
            public void receiveErrorgetBidOpportunities(java.lang.Exception e) {
            }
                


    }
    