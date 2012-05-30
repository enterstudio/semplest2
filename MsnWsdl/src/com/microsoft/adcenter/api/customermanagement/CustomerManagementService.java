

/**
 * CustomerManagementService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.api.customermanagement;

    /*
     *  CustomerManagementService java interface
     */

    public interface CustomerManagementService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getCurrentUserRequest128
                
                    * @param applicationToken129
                
                    * @param developerToken130
                
                    * @param password131
                
                    * @param userName132
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCurrentUser_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCurrentUser_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetCurrentUserResponse getCurrentUser(

                        com.microsoft.adcenter.api.customermanagement.GetCurrentUserRequest getCurrentUserRequest128,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken129,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken130,com.microsoft.adcenter.api.customermanagement.Password password131,com.microsoft.adcenter.api.customermanagement.UserName userName132)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCurrentUser_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCurrentUser_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCurrentUserRequest128
            
                * @param applicationToken129
            
                * @param developerToken130
            
                * @param password131
            
                * @param userName132
            
          */
        public void startgetCurrentUser(

            com.microsoft.adcenter.api.customermanagement.GetCurrentUserRequest getCurrentUserRequest128,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken129,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken130,
                com.microsoft.adcenter.api.customermanagement.Password password131,
                com.microsoft.adcenter.api.customermanagement.UserName userName132,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param cancelRequestToManageAccountsRequest134
                
                    * @param applicationToken135
                
                    * @param developerToken136
                
                    * @param password137
                
                    * @param userName138
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_CancelRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_CancelRequestToManageAccounts_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsResponse cancelRequestToManageAccounts(

                        com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsRequest cancelRequestToManageAccountsRequest134,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken135,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken136,com.microsoft.adcenter.api.customermanagement.Password password137,com.microsoft.adcenter.api.customermanagement.UserName userName138)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_CancelRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_CancelRequestToManageAccounts_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param cancelRequestToManageAccountsRequest134
            
                * @param applicationToken135
            
                * @param developerToken136
            
                * @param password137
            
                * @param userName138
            
          */
        public void startcancelRequestToManageAccounts(

            com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsRequest cancelRequestToManageAccountsRequest134,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken135,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken136,
                com.microsoft.adcenter.api.customermanagement.Password password137,
                com.microsoft.adcenter.api.customermanagement.UserName userName138,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param upgradeCustomerToAgencyRequest140
                
                    * @param applicationToken141
                
                    * @param developerToken142
                
                    * @param password143
                
                    * @param userName144
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpgradeCustomerToAgency_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpgradeCustomerToAgency_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyResponse upgradeCustomerToAgency(

                        com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyRequest upgradeCustomerToAgencyRequest140,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken141,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken142,com.microsoft.adcenter.api.customermanagement.Password password143,com.microsoft.adcenter.api.customermanagement.UserName userName144)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpgradeCustomerToAgency_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpgradeCustomerToAgency_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param upgradeCustomerToAgencyRequest140
            
                * @param applicationToken141
            
                * @param developerToken142
            
                * @param password143
            
                * @param userName144
            
          */
        public void startupgradeCustomerToAgency(

            com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyRequest upgradeCustomerToAgencyRequest140,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken141,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken142,
                com.microsoft.adcenter.api.customermanagement.Password password143,
                com.microsoft.adcenter.api.customermanagement.UserName userName144,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteCustomerRequest146
                
                    * @param applicationToken147
                
                    * @param developerToken148
                
                    * @param password149
                
                    * @param userName150
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteCustomer_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteCustomer_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.DeleteCustomerResponse deleteCustomer(

                        com.microsoft.adcenter.api.customermanagement.DeleteCustomerRequest deleteCustomerRequest146,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken147,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken148,com.microsoft.adcenter.api.customermanagement.Password password149,com.microsoft.adcenter.api.customermanagement.UserName userName150)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteCustomer_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteCustomer_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteCustomerRequest146
            
                * @param applicationToken147
            
                * @param developerToken148
            
                * @param password149
            
                * @param userName150
            
          */
        public void startdeleteCustomer(

            com.microsoft.adcenter.api.customermanagement.DeleteCustomerRequest deleteCustomerRequest146,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken147,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken148,
                com.microsoft.adcenter.api.customermanagement.Password password149,
                com.microsoft.adcenter.api.customermanagement.UserName userName150,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateUserRequest152
                
                    * @param applicationToken153
                
                    * @param developerToken154
                
                    * @param password155
                
                    * @param userName156
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateUser_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateUser_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.UpdateUserResponse updateUser(

                        com.microsoft.adcenter.api.customermanagement.UpdateUserRequest updateUserRequest152,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken153,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken154,com.microsoft.adcenter.api.customermanagement.Password password155,com.microsoft.adcenter.api.customermanagement.UserName userName156)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateUser_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateUser_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateUserRequest152
            
                * @param applicationToken153
            
                * @param developerToken154
            
                * @param password155
            
                * @param userName156
            
          */
        public void startupdateUser(

            com.microsoft.adcenter.api.customermanagement.UpdateUserRequest updateUserRequest152,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken153,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken154,
                com.microsoft.adcenter.api.customermanagement.Password password155,
                com.microsoft.adcenter.api.customermanagement.UserName userName156,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAccessibleCustomerRequest158
                
                    * @param applicationToken159
                
                    * @param developerToken160
                
                    * @param password161
                
                    * @param userName162
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccessibleCustomer_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccessibleCustomer_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerResponse getAccessibleCustomer(

                        com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerRequest getAccessibleCustomerRequest158,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken159,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken160,com.microsoft.adcenter.api.customermanagement.Password password161,com.microsoft.adcenter.api.customermanagement.UserName userName162)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccessibleCustomer_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccessibleCustomer_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAccessibleCustomerRequest158
            
                * @param applicationToken159
            
                * @param developerToken160
            
                * @param password161
            
                * @param userName162
            
          */
        public void startgetAccessibleCustomer(

            com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerRequest getAccessibleCustomerRequest158,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken159,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken160,
                com.microsoft.adcenter.api.customermanagement.Password password161,
                com.microsoft.adcenter.api.customermanagement.UserName userName162,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param findAccountsRequest164
                
                    * @param applicationToken165
                
                    * @param developerToken166
                
                    * @param password167
                
                    * @param userName168
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_FindAccounts_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_FindAccounts_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.FindAccountsResponse findAccounts(

                        com.microsoft.adcenter.api.customermanagement.FindAccountsRequest findAccountsRequest164,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken165,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken166,com.microsoft.adcenter.api.customermanagement.Password password167,com.microsoft.adcenter.api.customermanagement.UserName userName168)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_FindAccounts_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_FindAccounts_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param findAccountsRequest164
            
                * @param applicationToken165
            
                * @param developerToken166
            
                * @param password167
            
                * @param userName168
            
          */
        public void startfindAccounts(

            com.microsoft.adcenter.api.customermanagement.FindAccountsRequest findAccountsRequest164,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken165,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken166,
                com.microsoft.adcenter.api.customermanagement.Password password167,
                com.microsoft.adcenter.api.customermanagement.UserName userName168,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateAccountRequest170
                
                    * @param applicationToken171
                
                    * @param developerToken172
                
                    * @param password173
                
                    * @param userName174
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateAccount_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateAccount_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.UpdateAccountResponse updateAccount(

                        com.microsoft.adcenter.api.customermanagement.UpdateAccountRequest updateAccountRequest170,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken171,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken172,com.microsoft.adcenter.api.customermanagement.Password password173,com.microsoft.adcenter.api.customermanagement.UserName userName174)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateAccount_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateAccount_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateAccountRequest170
            
                * @param applicationToken171
            
                * @param developerToken172
            
                * @param password173
            
                * @param userName174
            
          */
        public void startupdateAccount(

            com.microsoft.adcenter.api.customermanagement.UpdateAccountRequest updateAccountRequest170,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken171,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken172,
                com.microsoft.adcenter.api.customermanagement.Password password173,
                com.microsoft.adcenter.api.customermanagement.UserName userName174,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param signupCustomerRequest176
                
                    * @param applicationToken177
                
                    * @param developerToken178
                
                    * @param password179
                
                    * @param userName180
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SignupCustomer_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SignupCustomer_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse signupCustomer(

                        com.microsoft.adcenter.api.customermanagement.SignupCustomerRequest signupCustomerRequest176,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken177,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken178,com.microsoft.adcenter.api.customermanagement.Password password179,com.microsoft.adcenter.api.customermanagement.UserName userName180)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SignupCustomer_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SignupCustomer_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param signupCustomerRequest176
            
                * @param applicationToken177
            
                * @param developerToken178
            
                * @param password179
            
                * @param userName180
            
          */
        public void startsignupCustomer(

            com.microsoft.adcenter.api.customermanagement.SignupCustomerRequest signupCustomerRequest176,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken177,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken178,
                com.microsoft.adcenter.api.customermanagement.Password password179,
                com.microsoft.adcenter.api.customermanagement.UserName userName180,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendRequestToManageAccountsRequest182
                
                    * @param applicationToken183
                
                    * @param developerToken184
                
                    * @param password185
                
                    * @param userName186
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SendRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SendRequestToManageAccounts_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsResponse sendRequestToManageAccounts(

                        com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsRequest sendRequestToManageAccountsRequest182,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken183,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken184,com.microsoft.adcenter.api.customermanagement.Password password185,com.microsoft.adcenter.api.customermanagement.UserName userName186)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SendRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SendRequestToManageAccounts_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendRequestToManageAccountsRequest182
            
                * @param applicationToken183
            
                * @param developerToken184
            
                * @param password185
            
                * @param userName186
            
          */
        public void startsendRequestToManageAccounts(

            com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsRequest sendRequestToManageAccountsRequest182,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken183,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken184,
                com.microsoft.adcenter.api.customermanagement.Password password185,
                com.microsoft.adcenter.api.customermanagement.UserName userName186,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteUserRequest188
                
                    * @param applicationToken189
                
                    * @param developerToken190
                
                    * @param password191
                
                    * @param userName192
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteUser_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteUser_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.DeleteUserResponse deleteUser(

                        com.microsoft.adcenter.api.customermanagement.DeleteUserRequest deleteUserRequest188,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken189,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken190,com.microsoft.adcenter.api.customermanagement.Password password191,com.microsoft.adcenter.api.customermanagement.UserName userName192)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteUser_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteUser_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteUserRequest188
            
                * @param applicationToken189
            
                * @param developerToken190
            
                * @param password191
            
                * @param userName192
            
          */
        public void startdeleteUser(

            com.microsoft.adcenter.api.customermanagement.DeleteUserRequest deleteUserRequest188,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken189,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken190,
                com.microsoft.adcenter.api.customermanagement.Password password191,
                com.microsoft.adcenter.api.customermanagement.UserName userName192,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getPilotFeaturesCountriesRequest194
                
                    * @param applicationToken195
                
                    * @param developerToken196
                
                    * @param password197
                
                    * @param userName198
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetPilotFeaturesCountries_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetPilotFeaturesCountries_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesResponse getPilotFeaturesCountries(

                        com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesRequest getPilotFeaturesCountriesRequest194,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken195,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken196,com.microsoft.adcenter.api.customermanagement.Password password197,com.microsoft.adcenter.api.customermanagement.UserName userName198)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetPilotFeaturesCountries_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetPilotFeaturesCountries_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPilotFeaturesCountriesRequest194
            
                * @param applicationToken195
            
                * @param developerToken196
            
                * @param password197
            
                * @param userName198
            
          */
        public void startgetPilotFeaturesCountries(

            com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesRequest getPilotFeaturesCountriesRequest194,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken195,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken196,
                com.microsoft.adcenter.api.customermanagement.Password password197,
                com.microsoft.adcenter.api.customermanagement.UserName userName198,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAccountsInfoRequest200
                
                    * @param applicationToken201
                
                    * @param developerToken202
                
                    * @param password203
                
                    * @param userName204
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccountsInfo_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccountsInfo_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse getAccountsInfo(

                        com.microsoft.adcenter.api.customermanagement.GetAccountsInfoRequest getAccountsInfoRequest200,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken201,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken202,com.microsoft.adcenter.api.customermanagement.Password password203,com.microsoft.adcenter.api.customermanagement.UserName userName204)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccountsInfo_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccountsInfo_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAccountsInfoRequest200
            
                * @param applicationToken201
            
                * @param developerToken202
            
                * @param password203
            
                * @param userName204
            
          */
        public void startgetAccountsInfo(

            com.microsoft.adcenter.api.customermanagement.GetAccountsInfoRequest getAccountsInfoRequest200,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken201,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken202,
                com.microsoft.adcenter.api.customermanagement.Password password203,
                com.microsoft.adcenter.api.customermanagement.UserName userName204,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param findAccountsOrCustomersInfoRequest206
                
                    * @param applicationToken207
                
                    * @param developerToken208
                
                    * @param password209
                
                    * @param userName210
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_FindAccountsOrCustomersInfo_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_FindAccountsOrCustomersInfo_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoResponse findAccountsOrCustomersInfo(

                        com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoRequest findAccountsOrCustomersInfoRequest206,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken207,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken208,com.microsoft.adcenter.api.customermanagement.Password password209,com.microsoft.adcenter.api.customermanagement.UserName userName210)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_FindAccountsOrCustomersInfo_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_FindAccountsOrCustomersInfo_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param findAccountsOrCustomersInfoRequest206
            
                * @param applicationToken207
            
                * @param developerToken208
            
                * @param password209
            
                * @param userName210
            
          */
        public void startfindAccountsOrCustomersInfo(

            com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoRequest findAccountsOrCustomersInfoRequest206,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken207,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken208,
                com.microsoft.adcenter.api.customermanagement.Password password209,
                com.microsoft.adcenter.api.customermanagement.UserName userName210,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCustomersInfoRequest212
                
                    * @param applicationToken213
                
                    * @param developerToken214
                
                    * @param password215
                
                    * @param userName216
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomersInfo_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomersInfo_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse getCustomersInfo(

                        com.microsoft.adcenter.api.customermanagement.GetCustomersInfoRequest getCustomersInfoRequest212,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken213,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken214,com.microsoft.adcenter.api.customermanagement.Password password215,com.microsoft.adcenter.api.customermanagement.UserName userName216)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomersInfo_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomersInfo_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCustomersInfoRequest212
            
                * @param applicationToken213
            
                * @param developerToken214
            
                * @param password215
            
                * @param userName216
            
          */
        public void startgetCustomersInfo(

            com.microsoft.adcenter.api.customermanagement.GetCustomersInfoRequest getCustomersInfoRequest212,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken213,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken214,
                com.microsoft.adcenter.api.customermanagement.Password password215,
                com.microsoft.adcenter.api.customermanagement.UserName userName216,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addPrepayAccountRequest218
                
                    * @param applicationToken219
                
                    * @param developerToken220
                
                    * @param password221
                
                    * @param userName222
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddPrepayAccount_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddPrepayAccount_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.AddPrepayAccountResponse addPrepayAccount(

                        com.microsoft.adcenter.api.customermanagement.AddPrepayAccountRequest addPrepayAccountRequest218,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken219,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken220,com.microsoft.adcenter.api.customermanagement.Password password221,com.microsoft.adcenter.api.customermanagement.UserName userName222)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddPrepayAccount_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddPrepayAccount_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addPrepayAccountRequest218
            
                * @param applicationToken219
            
                * @param developerToken220
            
                * @param password221
            
                * @param userName222
            
          */
        public void startaddPrepayAccount(

            com.microsoft.adcenter.api.customermanagement.AddPrepayAccountRequest addPrepayAccountRequest218,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken219,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken220,
                com.microsoft.adcenter.api.customermanagement.Password password221,
                com.microsoft.adcenter.api.customermanagement.UserName userName222,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAccountRequest224
                
                    * @param applicationToken225
                
                    * @param developerToken226
                
                    * @param password227
                
                    * @param userName228
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccount_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccount_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetAccountResponse getAccount(

                        com.microsoft.adcenter.api.customermanagement.GetAccountRequest getAccountRequest224,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken225,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken226,com.microsoft.adcenter.api.customermanagement.Password password227,com.microsoft.adcenter.api.customermanagement.UserName userName228)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccount_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetAccount_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAccountRequest224
            
                * @param applicationToken225
            
                * @param developerToken226
            
                * @param password227
            
                * @param userName228
            
          */
        public void startgetAccount(

            com.microsoft.adcenter.api.customermanagement.GetAccountRequest getAccountRequest224,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken225,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken226,
                com.microsoft.adcenter.api.customermanagement.Password password227,
                com.microsoft.adcenter.api.customermanagement.UserName userName228,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendRequestToStopManagingAccountsRequest230
                
                    * @param applicationToken231
                
                    * @param developerToken232
                
                    * @param password233
                
                    * @param userName234
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SendRequestToStopManagingAccounts_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SendRequestToStopManagingAccounts_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsResponse sendRequestToStopManagingAccounts(

                        com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsRequest sendRequestToStopManagingAccountsRequest230,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken231,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken232,com.microsoft.adcenter.api.customermanagement.Password password233,com.microsoft.adcenter.api.customermanagement.UserName userName234)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SendRequestToStopManagingAccounts_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_SendRequestToStopManagingAccounts_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendRequestToStopManagingAccountsRequest230
            
                * @param applicationToken231
            
                * @param developerToken232
            
                * @param password233
            
                * @param userName234
            
          */
        public void startsendRequestToStopManagingAccounts(

            com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsRequest sendRequestToStopManagingAccountsRequest230,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken231,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken232,
                com.microsoft.adcenter.api.customermanagement.Password password233,
                com.microsoft.adcenter.api.customermanagement.UserName userName234,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param acceptRequestToManageAccountsRequest236
                
                    * @param applicationToken237
                
                    * @param developerToken238
                
                    * @param password239
                
                    * @param userName240
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AcceptRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AcceptRequestToManageAccounts_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsResponse acceptRequestToManageAccounts(

                        com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsRequest acceptRequestToManageAccountsRequest236,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken237,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken238,com.microsoft.adcenter.api.customermanagement.Password password239,com.microsoft.adcenter.api.customermanagement.UserName userName240)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AcceptRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AcceptRequestToManageAccounts_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param acceptRequestToManageAccountsRequest236
            
                * @param applicationToken237
            
                * @param developerToken238
            
                * @param password239
            
                * @param userName240
            
          */
        public void startacceptRequestToManageAccounts(

            com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsRequest acceptRequestToManageAccountsRequest236,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken237,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken238,
                com.microsoft.adcenter.api.customermanagement.Password password239,
                com.microsoft.adcenter.api.customermanagement.UserName userName240,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getRequestToManageAccountsInfosRequest242
                
                    * @param applicationToken243
                
                    * @param developerToken244
                
                    * @param password245
                
                    * @param userName246
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetRequestToManageAccountsInfos_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetRequestToManageAccountsInfos_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosResponse getRequestToManageAccountsInfos(

                        com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosRequest getRequestToManageAccountsInfosRequest242,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken243,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken244,com.microsoft.adcenter.api.customermanagement.Password password245,com.microsoft.adcenter.api.customermanagement.UserName userName246)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetRequestToManageAccountsInfos_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetRequestToManageAccountsInfos_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getRequestToManageAccountsInfosRequest242
            
                * @param applicationToken243
            
                * @param developerToken244
            
                * @param password245
            
                * @param userName246
            
          */
        public void startgetRequestToManageAccountsInfos(

            com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosRequest getRequestToManageAccountsInfosRequest242,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken243,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken244,
                com.microsoft.adcenter.api.customermanagement.Password password245,
                com.microsoft.adcenter.api.customermanagement.UserName userName246,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param mapCustomerIdToExternalCustomerIdRequest248
                
                    * @param applicationToken249
                
                    * @param developerToken250
                
                    * @param password251
                
                    * @param userName252
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_MapCustomerIdToExternalCustomerId_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_MapCustomerIdToExternalCustomerId_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdResponse mapCustomerIdToExternalCustomerId(

                        com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdRequest mapCustomerIdToExternalCustomerIdRequest248,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken249,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken250,com.microsoft.adcenter.api.customermanagement.Password password251,com.microsoft.adcenter.api.customermanagement.UserName userName252)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_MapCustomerIdToExternalCustomerId_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_MapCustomerIdToExternalCustomerId_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param mapCustomerIdToExternalCustomerIdRequest248
            
                * @param applicationToken249
            
                * @param developerToken250
            
                * @param password251
            
                * @param userName252
            
          */
        public void startmapCustomerIdToExternalCustomerId(

            com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdRequest mapCustomerIdToExternalCustomerIdRequest248,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken249,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken250,
                com.microsoft.adcenter.api.customermanagement.Password password251,
                com.microsoft.adcenter.api.customermanagement.UserName userName252,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addAccountRequest254
                
                    * @param applicationToken255
                
                    * @param developerToken256
                
                    * @param password257
                
                    * @param userName258
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddAccount_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddAccount_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.AddAccountResponse addAccount(

                        com.microsoft.adcenter.api.customermanagement.AddAccountRequest addAccountRequest254,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken255,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken256,com.microsoft.adcenter.api.customermanagement.Password password257,com.microsoft.adcenter.api.customermanagement.UserName userName258)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddAccount_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddAccount_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addAccountRequest254
            
                * @param applicationToken255
            
                * @param developerToken256
            
                * @param password257
            
                * @param userName258
            
          */
        public void startaddAccount(

            com.microsoft.adcenter.api.customermanagement.AddAccountRequest addAccountRequest254,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken255,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken256,
                com.microsoft.adcenter.api.customermanagement.Password password257,
                com.microsoft.adcenter.api.customermanagement.UserName userName258,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCustomerPilotFeatureRequest260
                
                    * @param applicationToken261
                
                    * @param developerToken262
                
                    * @param password263
                
                    * @param userName264
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomerPilotFeature_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomerPilotFeature_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureResponse getCustomerPilotFeature(

                        com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureRequest getCustomerPilotFeatureRequest260,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken261,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken262,com.microsoft.adcenter.api.customermanagement.Password password263,com.microsoft.adcenter.api.customermanagement.UserName userName264)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomerPilotFeature_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomerPilotFeature_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCustomerPilotFeatureRequest260
            
                * @param applicationToken261
            
                * @param developerToken262
            
                * @param password263
            
                * @param userName264
            
          */
        public void startgetCustomerPilotFeature(

            com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureRequest getCustomerPilotFeatureRequest260,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken261,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken262,
                com.microsoft.adcenter.api.customermanagement.Password password263,
                com.microsoft.adcenter.api.customermanagement.UserName userName264,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUsersInfoRequest266
                
                    * @param applicationToken267
                
                    * @param developerToken268
                
                    * @param password269
                
                    * @param userName270
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetUsersInfo_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetUsersInfo_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetUsersInfoResponse getUsersInfo(

                        com.microsoft.adcenter.api.customermanagement.GetUsersInfoRequest getUsersInfoRequest266,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken267,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken268,com.microsoft.adcenter.api.customermanagement.Password password269,com.microsoft.adcenter.api.customermanagement.UserName userName270)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetUsersInfo_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetUsersInfo_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUsersInfoRequest266
            
                * @param applicationToken267
            
                * @param developerToken268
            
                * @param password269
            
                * @param userName270
            
          */
        public void startgetUsersInfo(

            com.microsoft.adcenter.api.customermanagement.GetUsersInfoRequest getUsersInfoRequest266,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken267,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken268,
                com.microsoft.adcenter.api.customermanagement.Password password269,
                com.microsoft.adcenter.api.customermanagement.UserName userName270,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserRequest272
                
                    * @param applicationToken273
                
                    * @param developerToken274
                
                    * @param password275
                
                    * @param userName276
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetUser_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetUser_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetUserResponse getUser(

                        com.microsoft.adcenter.api.customermanagement.GetUserRequest getUserRequest272,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken273,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken274,com.microsoft.adcenter.api.customermanagement.Password password275,com.microsoft.adcenter.api.customermanagement.UserName userName276)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetUser_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetUser_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserRequest272
            
                * @param applicationToken273
            
                * @param developerToken274
            
                * @param password275
            
                * @param userName276
            
          */
        public void startgetUser(

            com.microsoft.adcenter.api.customermanagement.GetUserRequest getUserRequest272,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken273,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken274,
                com.microsoft.adcenter.api.customermanagement.Password password275,
                com.microsoft.adcenter.api.customermanagement.UserName userName276,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCustomerRequest278
                
                    * @param applicationToken279
                
                    * @param developerToken280
                
                    * @param password281
                
                    * @param userName282
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomer_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomer_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetCustomerResponse getCustomer(

                        com.microsoft.adcenter.api.customermanagement.GetCustomerRequest getCustomerRequest278,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken279,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken280,com.microsoft.adcenter.api.customermanagement.Password password281,com.microsoft.adcenter.api.customermanagement.UserName userName282)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomer_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetCustomer_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCustomerRequest278
            
                * @param applicationToken279
            
                * @param developerToken280
            
                * @param password281
            
                * @param userName282
            
          */
        public void startgetCustomer(

            com.microsoft.adcenter.api.customermanagement.GetCustomerRequest getCustomerRequest278,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken279,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken280,
                com.microsoft.adcenter.api.customermanagement.Password password281,
                com.microsoft.adcenter.api.customermanagement.UserName userName282,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getRequestToManageAccountsRequest284
                
                    * @param applicationToken285
                
                    * @param developerToken286
                
                    * @param password287
                
                    * @param userName288
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetRequestToManageAccounts_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsResponse getRequestToManageAccounts(

                        com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsRequest getRequestToManageAccountsRequest284,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken285,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken286,com.microsoft.adcenter.api.customermanagement.Password password287,com.microsoft.adcenter.api.customermanagement.UserName userName288)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_GetRequestToManageAccounts_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getRequestToManageAccountsRequest284
            
                * @param applicationToken285
            
                * @param developerToken286
            
                * @param password287
            
                * @param userName288
            
          */
        public void startgetRequestToManageAccounts(

            com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsRequest getRequestToManageAccountsRequest284,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken285,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken286,
                com.microsoft.adcenter.api.customermanagement.Password password287,
                com.microsoft.adcenter.api.customermanagement.UserName userName288,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateUserRolesRequest290
                
                    * @param applicationToken291
                
                    * @param developerToken292
                
                    * @param password293
                
                    * @param userName294
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateUserRoles_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateUserRoles_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.UpdateUserRolesResponse updateUserRoles(

                        com.microsoft.adcenter.api.customermanagement.UpdateUserRolesRequest updateUserRolesRequest290,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken291,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken292,com.microsoft.adcenter.api.customermanagement.Password password293,com.microsoft.adcenter.api.customermanagement.UserName userName294)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateUserRoles_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateUserRoles_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateUserRolesRequest290
            
                * @param applicationToken291
            
                * @param developerToken292
            
                * @param password293
            
                * @param userName294
            
          */
        public void startupdateUserRoles(

            com.microsoft.adcenter.api.customermanagement.UpdateUserRolesRequest updateUserRolesRequest290,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken291,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken292,
                com.microsoft.adcenter.api.customermanagement.Password password293,
                com.microsoft.adcenter.api.customermanagement.UserName userName294,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteAccountRequest296
                
                    * @param applicationToken297
                
                    * @param developerToken298
                
                    * @param password299
                
                    * @param userName300
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteAccount_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteAccount_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse deleteAccount(

                        com.microsoft.adcenter.api.customermanagement.DeleteAccountRequest deleteAccountRequest296,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken297,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken298,com.microsoft.adcenter.api.customermanagement.Password password299,com.microsoft.adcenter.api.customermanagement.UserName userName300)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteAccount_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeleteAccount_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteAccountRequest296
            
                * @param applicationToken297
            
                * @param developerToken298
            
                * @param password299
            
                * @param userName300
            
          */
        public void startdeleteAccount(

            com.microsoft.adcenter.api.customermanagement.DeleteAccountRequest deleteAccountRequest296,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken297,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken298,
                com.microsoft.adcenter.api.customermanagement.Password password299,
                com.microsoft.adcenter.api.customermanagement.UserName userName300,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateCustomerRequest302
                
                    * @param applicationToken303
                
                    * @param developerToken304
                
                    * @param password305
                
                    * @param userName306
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateCustomer_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateCustomer_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.UpdateCustomerResponse updateCustomer(

                        com.microsoft.adcenter.api.customermanagement.UpdateCustomerRequest updateCustomerRequest302,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken303,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken304,com.microsoft.adcenter.api.customermanagement.Password password305,com.microsoft.adcenter.api.customermanagement.UserName userName306)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateCustomer_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_UpdateCustomer_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateCustomerRequest302
            
                * @param applicationToken303
            
                * @param developerToken304
            
                * @param password305
            
                * @param userName306
            
          */
        public void startupdateCustomer(

            com.microsoft.adcenter.api.customermanagement.UpdateCustomerRequest updateCustomerRequest302,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken303,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken304,
                com.microsoft.adcenter.api.customermanagement.Password password305,
                com.microsoft.adcenter.api.customermanagement.UserName userName306,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param declineRequestToManageAccountsRequest308
                
                    * @param applicationToken309
                
                    * @param developerToken310
                
                    * @param password311
                
                    * @param userName312
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeclineRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeclineRequestToManageAccounts_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsResponse declineRequestToManageAccounts(

                        com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsRequest declineRequestToManageAccountsRequest308,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken309,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken310,com.microsoft.adcenter.api.customermanagement.Password password311,com.microsoft.adcenter.api.customermanagement.UserName userName312)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeclineRequestToManageAccounts_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_DeclineRequestToManageAccounts_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param declineRequestToManageAccountsRequest308
            
                * @param applicationToken309
            
                * @param developerToken310
            
                * @param password311
            
                * @param userName312
            
          */
        public void startdeclineRequestToManageAccounts(

            com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsRequest declineRequestToManageAccountsRequest308,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken309,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken310,
                com.microsoft.adcenter.api.customermanagement.Password password311,
                com.microsoft.adcenter.api.customermanagement.UserName userName312,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param mapAccountIdToExternalAccountIdsRequest314
                
                    * @param applicationToken315
                
                    * @param developerToken316
                
                    * @param password317
                
                    * @param userName318
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_MapAccountIdToExternalAccountIds_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_MapAccountIdToExternalAccountIds_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsResponse mapAccountIdToExternalAccountIds(

                        com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsRequest mapAccountIdToExternalAccountIdsRequest314,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken315,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken316,com.microsoft.adcenter.api.customermanagement.Password password317,com.microsoft.adcenter.api.customermanagement.UserName userName318)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_MapAccountIdToExternalAccountIds_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_MapAccountIdToExternalAccountIds_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param mapAccountIdToExternalAccountIdsRequest314
            
                * @param applicationToken315
            
                * @param developerToken316
            
                * @param password317
            
                * @param userName318
            
          */
        public void startmapAccountIdToExternalAccountIds(

            com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsRequest mapAccountIdToExternalAccountIdsRequest314,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken315,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken316,
                com.microsoft.adcenter.api.customermanagement.Password password317,
                com.microsoft.adcenter.api.customermanagement.UserName userName318,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addUserRequest320
                
                    * @param applicationToken321
                
                    * @param developerToken322
                
                    * @param password323
                
                    * @param userName324
                
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddUser_AdApiFaultDetailFault_FaultMessage : 
             * @throws com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddUser_ApiFaultFault_FaultMessage : 
         */

         
                     public com.microsoft.adcenter.api.customermanagement.AddUserResponse addUser(

                        com.microsoft.adcenter.api.customermanagement.AddUserRequest addUserRequest320,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken321,com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken322,com.microsoft.adcenter.api.customermanagement.Password password323,com.microsoft.adcenter.api.customermanagement.UserName userName324)
                        throws java.rmi.RemoteException
             
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddUser_AdApiFaultDetailFault_FaultMessage
          ,com.microsoft.adcenter.api.customermanagement.ICustomerManagementService_AddUser_ApiFaultFault_FaultMessage;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addUserRequest320
            
                * @param applicationToken321
            
                * @param developerToken322
            
                * @param password323
            
                * @param userName324
            
          */
        public void startaddUser(

            com.microsoft.adcenter.api.customermanagement.AddUserRequest addUserRequest320,com.microsoft.adcenter.api.customermanagement.ApplicationToken applicationToken321,
                com.microsoft.adcenter.api.customermanagement.DeveloperToken developerToken322,
                com.microsoft.adcenter.api.customermanagement.Password password323,
                com.microsoft.adcenter.api.customermanagement.UserName userName324,
                

            final com.microsoft.adcenter.api.customermanagement.CustomerManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    