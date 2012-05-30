

/**
 * OptimizerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.v8;

    /*
     *  OptimizerService java interface
     */

    public interface OptimizerService {
          

        /**
          * Auto generated method signature
          * 
                    * @param applyBudgetOpportunitiesRequest18
                
                    * @param applicationToken19
                
                    * @param customerAccountId20
                
                    * @param customerId21
                
                    * @param developerToken22
                
                    * @param password23
                
                    * @param userName24
                
             * @throws com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse applyBudgetOpportunities(

                        com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest applyBudgetOpportunitiesRequest18,com.microsoft.adcenter.v8.ApplicationToken applicationToken19,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId20,com.microsoft.adcenter.v8.CustomerId customerId21,com.microsoft.adcenter.v8.DeveloperToken developerToken22,com.microsoft.adcenter.v8.Password password23,com.microsoft.adcenter.v8.UserName userName24)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param applyBudgetOpportunitiesRequest18
            
                * @param applicationToken19
            
                * @param customerAccountId20
            
                * @param customerId21
            
                * @param developerToken22
            
                * @param password23
            
                * @param userName24
            
          */
        public void startapplyBudgetOpportunities(

            com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest applyBudgetOpportunitiesRequest18,com.microsoft.adcenter.v8.ApplicationToken applicationToken19,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId20,
                com.microsoft.adcenter.v8.CustomerId customerId21,
                com.microsoft.adcenter.v8.DeveloperToken developerToken22,
                com.microsoft.adcenter.v8.Password password23,
                com.microsoft.adcenter.v8.UserName userName24,
                

            final com.microsoft.adcenter.v8.OptimizerServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param applyOpportunitiesRequest26
                
                    * @param applicationToken27
                
                    * @param customerAccountId28
                
                    * @param customerId29
                
                    * @param developerToken30
                
                    * @param password31
                
                    * @param userName32
                
             * @throws com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.ApplyOpportunitiesResponse applyOpportunities(

                        com.microsoft.adcenter.v8.ApplyOpportunitiesRequest applyOpportunitiesRequest26,com.microsoft.adcenter.v8.ApplicationToken applicationToken27,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId28,com.microsoft.adcenter.v8.CustomerId customerId29,com.microsoft.adcenter.v8.DeveloperToken developerToken30,com.microsoft.adcenter.v8.Password password31,com.microsoft.adcenter.v8.UserName userName32)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param applyOpportunitiesRequest26
            
                * @param applicationToken27
            
                * @param customerAccountId28
            
                * @param customerId29
            
                * @param developerToken30
            
                * @param password31
            
                * @param userName32
            
          */
        public void startapplyOpportunities(

            com.microsoft.adcenter.v8.ApplyOpportunitiesRequest applyOpportunitiesRequest26,com.microsoft.adcenter.v8.ApplicationToken applicationToken27,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId28,
                com.microsoft.adcenter.v8.CustomerId customerId29,
                com.microsoft.adcenter.v8.DeveloperToken developerToken30,
                com.microsoft.adcenter.v8.Password password31,
                com.microsoft.adcenter.v8.UserName userName32,
                

            final com.microsoft.adcenter.v8.OptimizerServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getBudgetOpportunitiesRequest34
                
                    * @param applicationToken35
                
                    * @param customerAccountId36
                
                    * @param customerId37
                
                    * @param developerToken38
                
                    * @param password39
                
                    * @param userName40
                
             * @throws com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse getBudgetOpportunities(

                        com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest getBudgetOpportunitiesRequest34,com.microsoft.adcenter.v8.ApplicationToken applicationToken35,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId36,com.microsoft.adcenter.v8.CustomerId customerId37,com.microsoft.adcenter.v8.DeveloperToken developerToken38,com.microsoft.adcenter.v8.Password password39,com.microsoft.adcenter.v8.UserName userName40)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getBudgetOpportunitiesRequest34
            
                * @param applicationToken35
            
                * @param customerAccountId36
            
                * @param customerId37
            
                * @param developerToken38
            
                * @param password39
            
                * @param userName40
            
          */
        public void startgetBudgetOpportunities(

            com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest getBudgetOpportunitiesRequest34,com.microsoft.adcenter.v8.ApplicationToken applicationToken35,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId36,
                com.microsoft.adcenter.v8.CustomerId customerId37,
                com.microsoft.adcenter.v8.DeveloperToken developerToken38,
                com.microsoft.adcenter.v8.Password password39,
                com.microsoft.adcenter.v8.UserName userName40,
                

            final com.microsoft.adcenter.v8.OptimizerServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getBidOpportunitiesRequest42
                
                    * @param applicationToken43
                
                    * @param customerAccountId44
                
                    * @param customerId45
                
                    * @param developerToken46
                
                    * @param password47
                
                    * @param userName48
                
             * @throws com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.v8.GetBidOpportunitiesResponse getBidOpportunities(

                        com.microsoft.adcenter.v8.GetBidOpportunitiesRequest getBidOpportunitiesRequest42,com.microsoft.adcenter.v8.ApplicationToken applicationToken43,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId44,com.microsoft.adcenter.v8.CustomerId customerId45,com.microsoft.adcenter.v8.DeveloperToken developerToken46,com.microsoft.adcenter.v8.Password password47,com.microsoft.adcenter.v8.UserName userName48)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getBidOpportunitiesRequest42
            
                * @param applicationToken43
            
                * @param customerAccountId44
            
                * @param customerId45
            
                * @param developerToken46
            
                * @param password47
            
                * @param userName48
            
          */
        public void startgetBidOpportunities(

            com.microsoft.adcenter.v8.GetBidOpportunitiesRequest getBidOpportunitiesRequest42,com.microsoft.adcenter.v8.ApplicationToken applicationToken43,
                com.microsoft.adcenter.v8.CustomerAccountId customerAccountId44,
                com.microsoft.adcenter.v8.CustomerId customerId45,
                com.microsoft.adcenter.v8.DeveloperToken developerToken46,
                com.microsoft.adcenter.v8.Password password47,
                com.microsoft.adcenter.v8.UserName userName48,
                

            final com.microsoft.adcenter.v8.OptimizerServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    