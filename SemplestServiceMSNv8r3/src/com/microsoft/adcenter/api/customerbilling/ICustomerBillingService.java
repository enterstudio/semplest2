/**
 * ICustomerBillingService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customerbilling;

public interface ICustomerBillingService extends java.rmi.Remote {
    public com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse getInvoicesInfo(com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
    public com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse getInvoices(com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
    public com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse getDisplayInvoices(com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
    public com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse addInsertionOrder(com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
    public com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse updateInsertionOrder(com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
    public com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse getInsertionOrdersByAccount(com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
    public com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse getKOHIOInvoices(com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
    public com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse getAccountMonthlySpend(com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault;
}
