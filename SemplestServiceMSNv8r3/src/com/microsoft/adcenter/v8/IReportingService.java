/**
 * IReportingService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public interface IReportingService extends java.rmi.Remote {
    public com.microsoft.adcenter.v8.SubmitGenerateReportResponse submitGenerateReport(com.microsoft.adcenter.v8.SubmitGenerateReportRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.PollGenerateReportResponse pollGenerateReport(com.microsoft.adcenter.v8.PollGenerateReportRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
}
