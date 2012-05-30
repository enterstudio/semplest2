
/**
 * CustomerManagementServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package com.microsoft.adcenter.api.customermanagement;

    /**
     *  CustomerManagementServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CustomerManagementServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CustomerManagementServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CustomerManagementServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getCurrentUser method
            * override this method for handling normal response from getCurrentUser operation
            */
           public void receiveResultgetCurrentUser(
                    com.microsoft.adcenter.api.customermanagement.GetCurrentUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentUser operation
           */
            public void receiveErrorgetCurrentUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelRequestToManageAccounts method
            * override this method for handling normal response from cancelRequestToManageAccounts operation
            */
           public void receiveResultcancelRequestToManageAccounts(
                    com.microsoft.adcenter.api.customermanagement.CancelRequestToManageAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelRequestToManageAccounts operation
           */
            public void receiveErrorcancelRequestToManageAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for upgradeCustomerToAgency method
            * override this method for handling normal response from upgradeCustomerToAgency operation
            */
           public void receiveResultupgradeCustomerToAgency(
                    com.microsoft.adcenter.api.customermanagement.UpgradeCustomerToAgencyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from upgradeCustomerToAgency operation
           */
            public void receiveErrorupgradeCustomerToAgency(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteCustomer method
            * override this method for handling normal response from deleteCustomer operation
            */
           public void receiveResultdeleteCustomer(
                    com.microsoft.adcenter.api.customermanagement.DeleteCustomerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteCustomer operation
           */
            public void receiveErrordeleteCustomer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateUser method
            * override this method for handling normal response from updateUser operation
            */
           public void receiveResultupdateUser(
                    com.microsoft.adcenter.api.customermanagement.UpdateUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateUser operation
           */
            public void receiveErrorupdateUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccessibleCustomer method
            * override this method for handling normal response from getAccessibleCustomer operation
            */
           public void receiveResultgetAccessibleCustomer(
                    com.microsoft.adcenter.api.customermanagement.GetAccessibleCustomerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccessibleCustomer operation
           */
            public void receiveErrorgetAccessibleCustomer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findAccounts method
            * override this method for handling normal response from findAccounts operation
            */
           public void receiveResultfindAccounts(
                    com.microsoft.adcenter.api.customermanagement.FindAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findAccounts operation
           */
            public void receiveErrorfindAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateAccount method
            * override this method for handling normal response from updateAccount operation
            */
           public void receiveResultupdateAccount(
                    com.microsoft.adcenter.api.customermanagement.UpdateAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateAccount operation
           */
            public void receiveErrorupdateAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for signupCustomer method
            * override this method for handling normal response from signupCustomer operation
            */
           public void receiveResultsignupCustomer(
                    com.microsoft.adcenter.api.customermanagement.SignupCustomerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from signupCustomer operation
           */
            public void receiveErrorsignupCustomer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendRequestToManageAccounts method
            * override this method for handling normal response from sendRequestToManageAccounts operation
            */
           public void receiveResultsendRequestToManageAccounts(
                    com.microsoft.adcenter.api.customermanagement.SendRequestToManageAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendRequestToManageAccounts operation
           */
            public void receiveErrorsendRequestToManageAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteUser method
            * override this method for handling normal response from deleteUser operation
            */
           public void receiveResultdeleteUser(
                    com.microsoft.adcenter.api.customermanagement.DeleteUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteUser operation
           */
            public void receiveErrordeleteUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPilotFeaturesCountries method
            * override this method for handling normal response from getPilotFeaturesCountries operation
            */
           public void receiveResultgetPilotFeaturesCountries(
                    com.microsoft.adcenter.api.customermanagement.GetPilotFeaturesCountriesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPilotFeaturesCountries operation
           */
            public void receiveErrorgetPilotFeaturesCountries(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccountsInfo method
            * override this method for handling normal response from getAccountsInfo operation
            */
           public void receiveResultgetAccountsInfo(
                    com.microsoft.adcenter.api.customermanagement.GetAccountsInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccountsInfo operation
           */
            public void receiveErrorgetAccountsInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for findAccountsOrCustomersInfo method
            * override this method for handling normal response from findAccountsOrCustomersInfo operation
            */
           public void receiveResultfindAccountsOrCustomersInfo(
                    com.microsoft.adcenter.api.customermanagement.FindAccountsOrCustomersInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from findAccountsOrCustomersInfo operation
           */
            public void receiveErrorfindAccountsOrCustomersInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCustomersInfo method
            * override this method for handling normal response from getCustomersInfo operation
            */
           public void receiveResultgetCustomersInfo(
                    com.microsoft.adcenter.api.customermanagement.GetCustomersInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCustomersInfo operation
           */
            public void receiveErrorgetCustomersInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addPrepayAccount method
            * override this method for handling normal response from addPrepayAccount operation
            */
           public void receiveResultaddPrepayAccount(
                    com.microsoft.adcenter.api.customermanagement.AddPrepayAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addPrepayAccount operation
           */
            public void receiveErroraddPrepayAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccount method
            * override this method for handling normal response from getAccount operation
            */
           public void receiveResultgetAccount(
                    com.microsoft.adcenter.api.customermanagement.GetAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccount operation
           */
            public void receiveErrorgetAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendRequestToStopManagingAccounts method
            * override this method for handling normal response from sendRequestToStopManagingAccounts operation
            */
           public void receiveResultsendRequestToStopManagingAccounts(
                    com.microsoft.adcenter.api.customermanagement.SendRequestToStopManagingAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendRequestToStopManagingAccounts operation
           */
            public void receiveErrorsendRequestToStopManagingAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for acceptRequestToManageAccounts method
            * override this method for handling normal response from acceptRequestToManageAccounts operation
            */
           public void receiveResultacceptRequestToManageAccounts(
                    com.microsoft.adcenter.api.customermanagement.AcceptRequestToManageAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from acceptRequestToManageAccounts operation
           */
            public void receiveErroracceptRequestToManageAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRequestToManageAccountsInfos method
            * override this method for handling normal response from getRequestToManageAccountsInfos operation
            */
           public void receiveResultgetRequestToManageAccountsInfos(
                    com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsInfosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRequestToManageAccountsInfos operation
           */
            public void receiveErrorgetRequestToManageAccountsInfos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for mapCustomerIdToExternalCustomerId method
            * override this method for handling normal response from mapCustomerIdToExternalCustomerId operation
            */
           public void receiveResultmapCustomerIdToExternalCustomerId(
                    com.microsoft.adcenter.api.customermanagement.MapCustomerIdToExternalCustomerIdResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from mapCustomerIdToExternalCustomerId operation
           */
            public void receiveErrormapCustomerIdToExternalCustomerId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAccount method
            * override this method for handling normal response from addAccount operation
            */
           public void receiveResultaddAccount(
                    com.microsoft.adcenter.api.customermanagement.AddAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAccount operation
           */
            public void receiveErroraddAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCustomerPilotFeature method
            * override this method for handling normal response from getCustomerPilotFeature operation
            */
           public void receiveResultgetCustomerPilotFeature(
                    com.microsoft.adcenter.api.customermanagement.GetCustomerPilotFeatureResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCustomerPilotFeature operation
           */
            public void receiveErrorgetCustomerPilotFeature(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUsersInfo method
            * override this method for handling normal response from getUsersInfo operation
            */
           public void receiveResultgetUsersInfo(
                    com.microsoft.adcenter.api.customermanagement.GetUsersInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUsersInfo operation
           */
            public void receiveErrorgetUsersInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUser method
            * override this method for handling normal response from getUser operation
            */
           public void receiveResultgetUser(
                    com.microsoft.adcenter.api.customermanagement.GetUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUser operation
           */
            public void receiveErrorgetUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCustomer method
            * override this method for handling normal response from getCustomer operation
            */
           public void receiveResultgetCustomer(
                    com.microsoft.adcenter.api.customermanagement.GetCustomerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCustomer operation
           */
            public void receiveErrorgetCustomer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRequestToManageAccounts method
            * override this method for handling normal response from getRequestToManageAccounts operation
            */
           public void receiveResultgetRequestToManageAccounts(
                    com.microsoft.adcenter.api.customermanagement.GetRequestToManageAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRequestToManageAccounts operation
           */
            public void receiveErrorgetRequestToManageAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateUserRoles method
            * override this method for handling normal response from updateUserRoles operation
            */
           public void receiveResultupdateUserRoles(
                    com.microsoft.adcenter.api.customermanagement.UpdateUserRolesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateUserRoles operation
           */
            public void receiveErrorupdateUserRoles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteAccount method
            * override this method for handling normal response from deleteAccount operation
            */
           public void receiveResultdeleteAccount(
                    com.microsoft.adcenter.api.customermanagement.DeleteAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAccount operation
           */
            public void receiveErrordeleteAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateCustomer method
            * override this method for handling normal response from updateCustomer operation
            */
           public void receiveResultupdateCustomer(
                    com.microsoft.adcenter.api.customermanagement.UpdateCustomerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateCustomer operation
           */
            public void receiveErrorupdateCustomer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for declineRequestToManageAccounts method
            * override this method for handling normal response from declineRequestToManageAccounts operation
            */
           public void receiveResultdeclineRequestToManageAccounts(
                    com.microsoft.adcenter.api.customermanagement.DeclineRequestToManageAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from declineRequestToManageAccounts operation
           */
            public void receiveErrordeclineRequestToManageAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for mapAccountIdToExternalAccountIds method
            * override this method for handling normal response from mapAccountIdToExternalAccountIds operation
            */
           public void receiveResultmapAccountIdToExternalAccountIds(
                    com.microsoft.adcenter.api.customermanagement.MapAccountIdToExternalAccountIdsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from mapAccountIdToExternalAccountIds operation
           */
            public void receiveErrormapAccountIdToExternalAccountIds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUser method
            * override this method for handling normal response from addUser operation
            */
           public void receiveResultaddUser(
                    com.microsoft.adcenter.api.customermanagement.AddUserResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUser operation
           */
            public void receiveErroraddUser(java.lang.Exception e) {
            }
                


    }
    