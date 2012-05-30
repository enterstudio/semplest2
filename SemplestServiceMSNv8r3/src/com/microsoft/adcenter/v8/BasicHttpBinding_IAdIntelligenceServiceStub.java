/**
 * BasicHttpBinding_IAdIntelligenceServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BasicHttpBinding_IAdIntelligenceServiceStub extends org.apache.axis.client.Stub implements com.microsoft.adcenter.v8.IAdIntelligenceService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[14];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetPublisherKeywordPerformance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetPublisherKeywordPerformanceRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetPublisherKeywordPerformanceRequest"), com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetPublisherKeywordPerformanceResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetPublisherKeywordPerformanceResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SuggestKeywordsForUrl");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SuggestKeywordsForUrlRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsForUrlRequest"), com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsForUrlResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SuggestKeywordsForUrlResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEstimatedBidByKeywordIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetEstimatedBidByKeywordIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordIdsRequest"), com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetEstimatedBidByKeywordIdsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEstimatedPositionByKeywordIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetEstimatedPositionByKeywordIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedPositionByKeywordIdsRequest"), com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedPositionByKeywordIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetEstimatedPositionByKeywordIdsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEstimatedBidByKeywords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetEstimatedBidByKeywordsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordsRequest"), com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetEstimatedBidByKeywordsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetEstimatedPositionByKeywords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetEstimatedPositionByKeywordsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedPositionByKeywordsRequest"), com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedPositionByKeywordsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetEstimatedPositionByKeywordsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHistoricalSearchCount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetHistoricalSearchCountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountRequest"), com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetHistoricalSearchCountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHistoricalSearchCountByDevice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetHistoricalSearchCountByDeviceRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountByDeviceRequest"), com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountByDeviceResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetHistoricalSearchCountByDeviceResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHistoricalKeywordPerformance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetHistoricalKeywordPerformanceRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceRequest"), com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetHistoricalKeywordPerformanceResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetHistoricalKeywordPerformanceByDevice");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetHistoricalKeywordPerformanceByDeviceRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceByDeviceRequest"), com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceByDeviceResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetHistoricalKeywordPerformanceByDeviceResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SuggestKeywordsFromExistingKeywords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SuggestKeywordsFromExistingKeywordsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsFromExistingKeywordsRequest"), com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsFromExistingKeywordsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SuggestKeywordsFromExistingKeywordsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeywordLocations");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordLocationsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordLocationsRequest"), com.microsoft.adcenter.v8.GetKeywordLocationsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordLocationsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetKeywordLocationsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordLocationsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeywordCategories");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordCategoriesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordCategoriesRequest"), com.microsoft.adcenter.v8.GetKeywordCategoriesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordCategoriesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetKeywordCategoriesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordCategoriesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeywordDemographics");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordDemographicsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordDemographicsRequest"), com.microsoft.adcenter.v8.GetKeywordDemographicsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordDemographicsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetKeywordDemographicsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordDemographicsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"),
                      "com.microsoft.adcenter.v8.ApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail"), 
                      true
                     ));
        _operations[13] = oper;

    }

    public BasicHttpBinding_IAdIntelligenceServiceStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_IAdIntelligenceServiceStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_IAdIntelligenceServiceStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AdPosition");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfEstimatedBidAndTraffic");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.EstimatedBidAndTraffic[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "EstimatedBidAndTraffic");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "EstimatedBidAndTraffic");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfEstimatedPositionAndTraffic");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.EstimatedPositionAndTraffic[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "EstimatedPositionAndTraffic");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "EstimatedPositionAndTraffic");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfHistoricalSearchCount");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.HistoricalSearchCount[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "HistoricalSearchCount");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "HistoricalSearchCount");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfHistoricalSearchCountPeriodic");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.HistoricalSearchCountPeriodic[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "HistoricalSearchCountPeriodic");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "HistoricalSearchCountPeriodic");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordAndConfidence");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordAndConfidence[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordAndConfidence");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordAndConfidence");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordCategory");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordCategory[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordCategory");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordCategory");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordCategoryResult");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordCategoryResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordCategoryResult");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordCategoryResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordDemographicResult");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordDemographicResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordDemographicResult");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordDemographicResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordEstimatedBid");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordEstimatedBid");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordEstimatedBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordEstimatedPosition");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordEstimatedPosition");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordEstimatedPosition");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordHistoricalPerformance");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordHistoricalPerformance[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordHistoricalPerformance");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordHistoricalPerformance");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordHistoricalPerformanceByDevice");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordHistoricalPerformanceByDevice[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordHistoricalPerformanceByDevice");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordHistoricalPerformanceByDevice");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordIdEstimatedBid");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordIdEstimatedBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedBid");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordIdEstimatedPosition");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordIdEstimatedPosition[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedPosition");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedPosition");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordKPI");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordKPI[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordKPI");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordKPI");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordLocation");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordLocation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordLocation");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordLocation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordLocationResult");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordLocationResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordLocationResult");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordLocationResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordPerformance");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordPerformance[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordPerformance");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordPerformance");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordSearchCount");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSearchCount[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSearchCount");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSearchCount");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordSearchCountByDevice");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSearchCountByDevice[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSearchCountByDevice");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSearchCountByDevice");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfKeywordSuggestion");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSuggestion[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSuggestion");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSuggestion");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfMatchType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Currency");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Currency.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "DayMonthAndYear");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DayMonthAndYear.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "EstimatedBidAndTraffic");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.EstimatedBidAndTraffic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "EstimatedPositionAndTraffic");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.EstimatedPositionAndTraffic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "HistoricalSearchCount");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.HistoricalSearchCount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "HistoricalSearchCountPeriodic");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.HistoricalSearchCountPeriodic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordAndConfidence");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordAndConfidence.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordCategory");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordCategory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordCategoryResult");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordCategoryResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordDemographic");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordDemographic.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordDemographicResult");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordDemographicResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordEstimatedBid");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordEstimatedPosition");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordEstimatedPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordHistoricalPerformance");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordHistoricalPerformance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordHistoricalPerformanceByDevice");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordHistoricalPerformanceByDevice.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedBid");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordIdEstimatedBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordIdEstimatedPosition");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordIdEstimatedPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordKPI");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordKPI.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordLocation");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordLocation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordLocationResult");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordLocationResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordPerformance");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordPerformance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSearchCount");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSearchCount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSearchCountByDevice");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSearchCountByDevice.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "KeywordSuggestion");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.KeywordSuggestion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MatchType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MatchType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "MonthAndYear");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.MonthAndYear.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Scale");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Scale.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "TargetAdPosition");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TargetAdPosition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "TimeInterval");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.TimeInterval.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOflong");
            cachedSerQNames.add(qName);
            cls = long[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long");
            qName2 = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "long");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
            cachedSerQNames.add(qName);
            cls = int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
            cachedSerQNames.add(qName);
            cls = org.apache.axis.types.Duration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adapi.AdApiError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adapi.AdApiFaultDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "ApplicationFault");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adapi.ApplicationFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "ArrayOfAdApiError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adapi.AdApiError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiError");
            qName2 = new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedBidByKeywordsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedPositionByKeywordIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedPositionByKeywordIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedPositionByKeywordsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetEstimatedPositionByKeywordsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceByDeviceRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceByDeviceResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalKeywordPerformanceResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountByDeviceRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountByDeviceResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetHistoricalSearchCountResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordCategoriesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordCategoriesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordCategoriesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordCategoriesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordDemographicsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordDemographicsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordDemographicsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordDemographicsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordLocationsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordLocationsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordLocationsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordLocationsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetPublisherKeywordPerformanceRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetPublisherKeywordPerformanceResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsForUrlRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsForUrlResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsFromExistingKeywordsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SuggestKeywordsFromExistingKeywordsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ApiFaultDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfBatchError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BatchError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfOperationError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.OperationError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BatchError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.OperationError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse getPublisherKeywordPerformance(com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetPublisherKeywordPerformance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetPublisherKeywordPerformance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse suggestKeywordsForUrl(com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SuggestKeywordsForUrl");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SuggestKeywordsForUrl"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse getEstimatedBidByKeywordIds(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetEstimatedBidByKeywordIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetEstimatedBidByKeywordIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse getEstimatedPositionByKeywordIds(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetEstimatedPositionByKeywordIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetEstimatedPositionByKeywordIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse getEstimatedBidByKeywords(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetEstimatedBidByKeywords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetEstimatedBidByKeywords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse getEstimatedPositionByKeywords(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetEstimatedPositionByKeywords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetEstimatedPositionByKeywords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse getHistoricalSearchCount(com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetHistoricalSearchCount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetHistoricalSearchCount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse getHistoricalSearchCountByDevice(com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetHistoricalSearchCountByDevice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetHistoricalSearchCountByDevice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse getHistoricalKeywordPerformance(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetHistoricalKeywordPerformance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetHistoricalKeywordPerformance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse getHistoricalKeywordPerformanceByDevice(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetHistoricalKeywordPerformanceByDevice");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetHistoricalKeywordPerformanceByDevice"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse suggestKeywordsFromExistingKeywords(com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SuggestKeywordsFromExistingKeywords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SuggestKeywordsFromExistingKeywords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetKeywordLocationsResponse getKeywordLocations(com.microsoft.adcenter.v8.GetKeywordLocationsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetKeywordLocations");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetKeywordLocations"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetKeywordLocationsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetKeywordLocationsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetKeywordLocationsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetKeywordCategoriesResponse getKeywordCategories(com.microsoft.adcenter.v8.GetKeywordCategoriesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetKeywordCategories");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetKeywordCategories"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetKeywordCategoriesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetKeywordCategoriesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetKeywordCategoriesResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetKeywordDemographicsResponse getKeywordDemographics(com.microsoft.adcenter.v8.GetKeywordDemographicsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetKeywordDemographics");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetKeywordDemographics"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetKeywordDemographicsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetKeywordDemographicsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetKeywordDemographicsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adapi.AdApiFaultDetail) {
              throw (com.microsoft.adapi.AdApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
