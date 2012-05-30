/**
 * IAdministrationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public interface IAdministrationService extends java.rmi.Remote {
    public com.microsoft.adcenter.v8.GetAssignedQuotaResponse getAssignedQuota(com.microsoft.adcenter.v8.GetAssignedQuotaRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail;
    public com.microsoft.adcenter.v8.GetRemainingQuotaResponse getRemainingQuota(com.microsoft.adcenter.v8.GetRemainingQuotaRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail;
}
