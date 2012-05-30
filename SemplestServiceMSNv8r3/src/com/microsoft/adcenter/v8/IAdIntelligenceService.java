/**
 * IAdIntelligenceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public interface IAdIntelligenceService extends java.rmi.Remote {
    public com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse getPublisherKeywordPerformance(com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse suggestKeywordsForUrl(com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse getEstimatedBidByKeywordIds(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse getEstimatedPositionByKeywordIds(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse getEstimatedBidByKeywords(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse getEstimatedPositionByKeywords(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse getHistoricalSearchCount(com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse getHistoricalSearchCountByDevice(com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse getHistoricalKeywordPerformance(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse getHistoricalKeywordPerformanceByDevice(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse suggestKeywordsFromExistingKeywords(com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetKeywordLocationsResponse getKeywordLocations(com.microsoft.adcenter.v8.GetKeywordLocationsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetKeywordCategoriesResponse getKeywordCategories(com.microsoft.adcenter.v8.GetKeywordCategoriesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
    public com.microsoft.adcenter.v8.GetKeywordDemographicsResponse getKeywordDemographics(com.microsoft.adcenter.v8.GetKeywordDemographicsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail;
}
