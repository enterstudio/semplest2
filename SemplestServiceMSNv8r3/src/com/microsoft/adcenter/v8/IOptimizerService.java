/**
 * IOptimizerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public interface IOptimizerService extends java.rmi.Remote {
    public com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse getBudgetOpportunities(com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetBidOpportunitiesResponse getBidOpportunities(com.microsoft.adcenter.v8.GetBidOpportunitiesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse applyBudgetOpportunities(com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.ApplyOpportunitiesResponse applyOpportunities(com.microsoft.adcenter.v8.ApplyOpportunitiesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
}
