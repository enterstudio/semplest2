

/**
 * CustomerBillingService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.api.customerbilling;

    /*
     *  CustomerBillingService java interface
     */

    public interface CustomerBillingService {
          

        /**
          * Auto generated method signature
          * 
                    * @param addInsertionOrderRequest28
                
                    * @param applicationToken29
                
                    * @param developerToken30
                
                    * @param password31
                
                    * @param userName32
                
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse addInsertionOrder(

                        com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest addInsertionOrderRequest28,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken29,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken30,com.microsoft.adcenter.api.customerbilling.Password password31,com.microsoft.adcenter.api.customerbilling.UserName userName32)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addInsertionOrderRequest28
            
                * @param applicationToken29
            
                * @param developerToken30
            
                * @param password31
            
                * @param userName32
            
          */
        public void startaddInsertionOrder(

            com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest addInsertionOrderRequest28,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken29,
                com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken30,
                com.microsoft.adcenter.api.customerbilling.Password password31,
                com.microsoft.adcenter.api.customerbilling.UserName userName32,
                

            final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getInsertionOrdersByAccountRequest34
                
                    * @param applicationToken35
                
                    * @param developerToken36
                
                    * @param password37
                
                    * @param userName38
                
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse getInsertionOrdersByAccount(

                        com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest getInsertionOrdersByAccountRequest34,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken35,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken36,com.microsoft.adcenter.api.customerbilling.Password password37,com.microsoft.adcenter.api.customerbilling.UserName userName38)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getInsertionOrdersByAccountRequest34
            
                * @param applicationToken35
            
                * @param developerToken36
            
                * @param password37
            
                * @param userName38
            
          */
        public void startgetInsertionOrdersByAccount(

            com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest getInsertionOrdersByAccountRequest34,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken35,
                com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken36,
                com.microsoft.adcenter.api.customerbilling.Password password37,
                com.microsoft.adcenter.api.customerbilling.UserName userName38,
                

            final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAccountMonthlySpendRequest40
                
                    * @param applicationToken41
                
                    * @param developerToken42
                
                    * @param password43
                
                    * @param userName44
                
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse getAccountMonthlySpend(

                        com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest getAccountMonthlySpendRequest40,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken41,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken42,com.microsoft.adcenter.api.customerbilling.Password password43,com.microsoft.adcenter.api.customerbilling.UserName userName44)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAccountMonthlySpendRequest40
            
                * @param applicationToken41
            
                * @param developerToken42
            
                * @param password43
            
                * @param userName44
            
          */
        public void startgetAccountMonthlySpend(

            com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest getAccountMonthlySpendRequest40,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken41,
                com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken42,
                com.microsoft.adcenter.api.customerbilling.Password password43,
                com.microsoft.adcenter.api.customerbilling.UserName userName44,
                

            final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKOHIOInvoicesRequest46
                
                    * @param applicationToken47
                
                    * @param developerToken48
                
                    * @param password49
                
                    * @param userName50
                
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse getKOHIOInvoices(

                        com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest getKOHIOInvoicesRequest46,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken47,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken48,com.microsoft.adcenter.api.customerbilling.Password password49,com.microsoft.adcenter.api.customerbilling.UserName userName50)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKOHIOInvoicesRequest46
            
                * @param applicationToken47
            
                * @param developerToken48
            
                * @param password49
            
                * @param userName50
            
          */
        public void startgetKOHIOInvoices(

            com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest getKOHIOInvoicesRequest46,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken47,
                com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken48,
                com.microsoft.adcenter.api.customerbilling.Password password49,
                com.microsoft.adcenter.api.customerbilling.UserName userName50,
                

            final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getDisplayInvoicesRequest52
                
                    * @param applicationToken53
                
                    * @param developerToken54
                
                    * @param password55
                
                    * @param userName56
                
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse getDisplayInvoices(

                        com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest getDisplayInvoicesRequest52,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken53,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken54,com.microsoft.adcenter.api.customerbilling.Password password55,com.microsoft.adcenter.api.customerbilling.UserName userName56)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getDisplayInvoicesRequest52
            
                * @param applicationToken53
            
                * @param developerToken54
            
                * @param password55
            
                * @param userName56
            
          */
        public void startgetDisplayInvoices(

            com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest getDisplayInvoicesRequest52,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken53,
                com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken54,
                com.microsoft.adcenter.api.customerbilling.Password password55,
                com.microsoft.adcenter.api.customerbilling.UserName userName56,
                

            final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getInvoicesInfoRequest58
                
                    * @param applicationToken59
                
                    * @param developerToken60
                
                    * @param password61
                
                    * @param userName62
                
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse getInvoicesInfo(

                        com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest getInvoicesInfoRequest58,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken59,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken60,com.microsoft.adcenter.api.customerbilling.Password password61,com.microsoft.adcenter.api.customerbilling.UserName userName62)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getInvoicesInfoRequest58
            
                * @param applicationToken59
            
                * @param developerToken60
            
                * @param password61
            
                * @param userName62
            
          */
        public void startgetInvoicesInfo(

            com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest getInvoicesInfoRequest58,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken59,
                com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken60,
                com.microsoft.adcenter.api.customerbilling.Password password61,
                com.microsoft.adcenter.api.customerbilling.UserName userName62,
                

            final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateInsertionOrderRequest64
                
                    * @param applicationToken65
                
                    * @param developerToken66
                
                    * @param password67
                
                    * @param userName68
                
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse updateInsertionOrder(

                        com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest updateInsertionOrderRequest64,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken65,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken66,com.microsoft.adcenter.api.customerbilling.Password password67,com.microsoft.adcenter.api.customerbilling.UserName userName68)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateInsertionOrderRequest64
            
                * @param applicationToken65
            
                * @param developerToken66
            
                * @param password67
            
                * @param userName68
            
          */
        public void startupdateInsertionOrder(

            com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest updateInsertionOrderRequest64,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken65,
                com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken66,
                com.microsoft.adcenter.api.customerbilling.Password password67,
                com.microsoft.adcenter.api.customerbilling.UserName userName68,
                

            final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getInvoicesRequest70
                
                    * @param applicationToken71
                
                    * @param developerToken72
                
                    * @param password73
                
                    * @param userName74
                
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse getInvoices(

                        com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest getInvoicesRequest70,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken71,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken72,com.microsoft.adcenter.api.customerbilling.Password password73,com.microsoft.adcenter.api.customerbilling.UserName userName74)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage
          ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getInvoicesRequest70
            
                * @param applicationToken71
            
                * @param developerToken72
            
                * @param password73
            
                * @param userName74
            
          */
        public void startgetInvoices(

            com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest getInvoicesRequest70,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken71,
                com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken72,
                com.microsoft.adcenter.api.customerbilling.Password password73,
                com.microsoft.adcenter.api.customerbilling.UserName userName74,
                

            final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    