
/**
 * AdministrationServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.v8;

    /**
     *  AdministrationServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AdministrationServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AdministrationServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AdministrationServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getAssignedQuota method
            * override this method for handling normal response from getAssignedQuota operation
            */
           public void receiveResultgetAssignedQuota(
                    com.microsoft.adcenter.v8.GetAssignedQuotaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAssignedQuota operation
           */
            public void receiveErrorgetAssignedQuota(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRemainingQuota method
            * override this method for handling normal response from getRemainingQuota operation
            */
           public void receiveResultgetRemainingQuota(
                    com.microsoft.adcenter.v8.GetRemainingQuotaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRemainingQuota operation
           */
            public void receiveErrorgetRemainingQuota(java.lang.Exception e) {
            }
                


    }
    