/**
 * BasicHttpBinding_ICampaignManagementServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BasicHttpBinding_ICampaignManagementServiceStub extends org.apache.axis.client.Stub implements com.microsoft.adcenter.v8.ICampaignManagementService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[88];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
        _initOperationDesc6();
        _initOperationDesc7();
        _initOperationDesc8();
        _initOperationDesc9();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAdExtensionsByCampaignIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdExtensionsByCampaignIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByCampaignIdsRequest"), com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByCampaignIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdExtensionsByCampaignIdsResponse"));
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
        oper.setName("GetAdExtensionsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdExtensionsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByIdsRequest"), com.microsoft.adcenter.v8.GetAdExtensionsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAdExtensionsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdExtensionsByIdsResponse"));
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
        oper.setName("SetAdExtensionsToCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetAdExtensionsToCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAdExtensionsToCampaignsRequest"), com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAdExtensionsToCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetAdExtensionsToCampaignsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"),
                      "com.microsoft.adcenter.v8.EditorialApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"), 
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
        oper.setName("DeleteAdExtensionsFromCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteAdExtensionsFromCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdExtensionsFromCampaignsRequest"), com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdExtensionsFromCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteAdExtensionsFromCampaignsResponse"));
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
        oper.setName("GetAdsByEditorialStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdsByEditorialStatusRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByEditorialStatusRequest"), com.microsoft.adcenter.v8.GetAdsByEditorialStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByEditorialStatusResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAdsByEditorialStatusResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdsByEditorialStatusResponse"));
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
        oper.setName("GetAdsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByIdsRequest"), com.microsoft.adcenter.v8.GetAdsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAdsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdsByIdsResponse"));
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
        oper.setName("GetAdsByAdGroupId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdsByAdGroupIdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByAdGroupIdRequest"), com.microsoft.adcenter.v8.GetAdsByAdGroupIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByAdGroupIdResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdsByAdGroupIdResponse"));
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
        oper.setName("UpdateAds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateAdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateAdsRequest"), com.microsoft.adcenter.v8.UpdateAdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateAdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateAdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateAdsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"),
                      "com.microsoft.adcenter.v8.EditorialApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PauseAds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseAdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseAdsRequest"), com.microsoft.adcenter.v8.PauseAdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseAdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.PauseAdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseAdsResponse"));
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
        oper.setName("ResumeAds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeAdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeAdsRequest"), com.microsoft.adcenter.v8.ResumeAdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeAdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.ResumeAdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeAdsResponse"));
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
        oper.setName("AddKeywords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddKeywordsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddKeywordsRequest"), com.microsoft.adcenter.v8.AddKeywordsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddKeywordsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddKeywordsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddKeywordsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"),
                      "com.microsoft.adcenter.v8.EditorialApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteKeywords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteKeywordsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteKeywordsRequest"), com.microsoft.adcenter.v8.DeleteKeywordsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteKeywordsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteKeywordsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteKeywordsResponse"));
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
        oper.setName("GetKeywordsByEditorialStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordsByEditorialStatusRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByEditorialStatusRequest"), com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByEditorialStatusResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordsByEditorialStatusResponse"));
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
        oper.setName("GetKeywordsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByIdsRequest"), com.microsoft.adcenter.v8.GetKeywordsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetKeywordsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordsByIdsResponse"));
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

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeywordsByAdGroupId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordsByAdGroupIdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByAdGroupIdRequest"), com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByAdGroupIdResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordsByAdGroupIdResponse"));
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
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PauseKeywords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseKeywordsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseKeywordsRequest"), com.microsoft.adcenter.v8.PauseKeywordsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseKeywordsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.PauseKeywordsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseKeywordsResponse"));
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
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ResumeKeywords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeKeywordsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeKeywordsRequest"), com.microsoft.adcenter.v8.ResumeKeywordsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeKeywordsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.ResumeKeywordsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeKeywordsResponse"));
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
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateKeywords");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateKeywordsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateKeywordsRequest"), com.microsoft.adcenter.v8.UpdateKeywordsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateKeywordsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateKeywordsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateKeywordsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"),
                      "com.microsoft.adcenter.v8.EditorialApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddBusinesses");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddBusinessesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddBusinessesRequest"), com.microsoft.adcenter.v8.AddBusinessesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddBusinessesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddBusinessesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddBusinessesResponse"));
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
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateBusinesses");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateBusinessesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateBusinessesRequest"), com.microsoft.adcenter.v8.UpdateBusinessesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateBusinessesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateBusinessesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateBusinessesResponse"));
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
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteBusinesses");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteBusinessesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteBusinessesRequest"), com.microsoft.adcenter.v8.DeleteBusinessesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteBusinessesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteBusinessesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteBusinessesResponse"));
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
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetBusinessesInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetBusinessesInfoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesInfoRequest"), com.microsoft.adcenter.v8.GetBusinessesInfoRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesInfoResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetBusinessesInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetBusinessesInfoResponse"));
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
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetBusinessesByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetBusinessesByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesByIdsRequest"), com.microsoft.adcenter.v8.GetBusinessesByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetBusinessesByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetBusinessesByIdsResponse"));
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
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddSitePlacements");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddSitePlacementsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddSitePlacementsRequest"), com.microsoft.adcenter.v8.AddSitePlacementsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddSitePlacementsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddSitePlacementsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddSitePlacementsResponse"));
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
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteSitePlacements");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteSitePlacementsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteSitePlacementsRequest"), com.microsoft.adcenter.v8.DeleteSitePlacementsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteSitePlacementsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteSitePlacementsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteSitePlacementsResponse"));
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
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSitePlacementsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetSitePlacementsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetSitePlacementsByIdsRequest"), com.microsoft.adcenter.v8.GetSitePlacementsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetSitePlacementsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetSitePlacementsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetSitePlacementsByIdsResponse"));
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
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSitePlacementsByAdGroupId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetSitePlacementsByAdGroupIdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetSitePlacementsByAdGroupIdRequest"), com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetSitePlacementsByAdGroupIdResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetSitePlacementsByAdGroupIdResponse"));
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
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PauseSitePlacements");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseSitePlacementsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseSitePlacementsRequest"), com.microsoft.adcenter.v8.PauseSitePlacementsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseSitePlacementsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.PauseSitePlacementsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseSitePlacementsResponse"));
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
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ResumeSitePlacements");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeSitePlacementsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeSitePlacementsRequest"), com.microsoft.adcenter.v8.ResumeSitePlacementsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeSitePlacementsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.ResumeSitePlacementsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeSitePlacementsResponse"));
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
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateSitePlacements");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateSitePlacementsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateSitePlacementsRequest"), com.microsoft.adcenter.v8.UpdateSitePlacementsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateSitePlacementsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateSitePlacementsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateSitePlacementsResponse"));
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
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetPlacementDetailsForUrls");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetPlacementDetailsForUrlsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetPlacementDetailsForUrlsRequest"), com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetPlacementDetailsForUrlsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetPlacementDetailsForUrlsResponse"));
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
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNormalizedStrings");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNormalizedStringsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNormalizedStringsRequest"), com.microsoft.adcenter.v8.GetNormalizedStringsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNormalizedStringsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetNormalizedStringsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNormalizedStringsResponse"));
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
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKeywordEditorialReasonsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordEditorialReasonsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordEditorialReasonsByIdsRequest"), com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordEditorialReasonsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetKeywordEditorialReasonsByIdsResponse"));
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
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAdEditorialReasonsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdEditorialReasonsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdEditorialReasonsByIdsRequest"), com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdEditorialReasonsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdEditorialReasonsByIdsResponse"));
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
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DownloadCampaignHierarchy");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DownloadCampaignHierarchyRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DownloadCampaignHierarchyRequest"), com.microsoft.adcenter.v8.DownloadCampaignHierarchyRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DownloadCampaignHierarchyResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DownloadCampaignHierarchyResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DownloadCampaignHierarchyResponse"));
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
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDownloadStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetDownloadStatusRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDownloadStatusRequest"), com.microsoft.adcenter.v8.GetDownloadStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDownloadStatusResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetDownloadStatusResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetDownloadStatusResponse"));
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
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddGoals");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddGoalsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddGoalsRequest"), com.microsoft.adcenter.v8.AddGoalsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddGoalsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddGoalsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddGoalsResponse"));
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
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AnalyticsApiFaultDetail"),
                      "com.microsoft.adcenter.v8.AnalyticsApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AnalyticsApiFaultDetail"), 
                      true
                     ));
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateGoals");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateGoalsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateGoalsRequest"), com.microsoft.adcenter.v8.UpdateGoalsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateGoalsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateGoalsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateGoalsResponse"));
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
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AnalyticsApiFaultDetail"),
                      "com.microsoft.adcenter.v8.AnalyticsApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AnalyticsApiFaultDetail"), 
                      true
                     ));
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetGoals");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetGoalsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetGoalsRequest"), com.microsoft.adcenter.v8.GetGoalsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetGoalsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetGoalsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetGoalsResponse"));
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
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteGoals");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteGoalsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteGoalsRequest"), com.microsoft.adcenter.v8.DeleteGoalsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteGoalsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteGoalsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteGoalsResponse"));
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
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetAnalyticsType");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetAnalyticsTypeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAnalyticsTypeRequest"), com.microsoft.adcenter.v8.SetAnalyticsTypeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAnalyticsTypeResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetAnalyticsTypeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetAnalyticsTypeResponse"));
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
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAnalyticsType");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAnalyticsTypeRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAnalyticsTypeRequest"), com.microsoft.adcenter.v8.GetAnalyticsTypeRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAnalyticsTypeResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAnalyticsTypeResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAnalyticsTypeResponse"));
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
        _operations[41] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCampaignAdExtensions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetCampaignAdExtensionsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignAdExtensionsRequest"), com.microsoft.adcenter.v8.GetCampaignAdExtensionsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignAdExtensionsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetCampaignAdExtensionsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetCampaignAdExtensionsResponse"));
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
        _operations[42] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetCampaignAdExtensions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetCampaignAdExtensionsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetCampaignAdExtensionsRequest"), com.microsoft.adcenter.v8.SetCampaignAdExtensionsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetCampaignAdExtensionsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetCampaignAdExtensionsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetCampaignAdExtensionsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"),
                      "com.microsoft.adcenter.v8.EditorialApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"), 
                      true
                     ));
        _operations[43] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAccountMigrationStatuses");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAccountMigrationStatusesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAccountMigrationStatusesRequest"), com.microsoft.adcenter.v8.GetAccountMigrationStatusesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAccountMigrationStatusesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAccountMigrationStatusesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAccountMigrationStatusesResponse"));
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
        _operations[44] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddAdExtensions");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddAdExtensionsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdExtensionsRequest"), com.microsoft.adcenter.v8.AddAdExtensionsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdExtensionsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddAdExtensionsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddAdExtensionsResponse"));
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
        _operations[45] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddCampaignsRequest"), com.microsoft.adcenter.v8.AddCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddCampaignsResponse"));
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
        _operations[46] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCampaignsByAccountId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetCampaignsByAccountIdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignsByAccountIdRequest"), com.microsoft.adcenter.v8.GetCampaignsByAccountIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignsByAccountIdResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetCampaignsByAccountIdResponse"));
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
        _operations[47] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCampaignsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetCampaignsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignsByIdsRequest"), com.microsoft.adcenter.v8.GetCampaignsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetCampaignsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetCampaignsByIdsResponse"));
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
        _operations[48] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PauseCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseCampaignsRequest"), com.microsoft.adcenter.v8.PauseCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.PauseCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseCampaignsResponse"));
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
        _operations[49] = oper;

    }

    private static void _initOperationDesc6(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ResumeCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeCampaignsRequest"), com.microsoft.adcenter.v8.ResumeCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.ResumeCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeCampaignsResponse"));
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
        _operations[50] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteCampaignsRequest"), com.microsoft.adcenter.v8.DeleteCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteCampaignsResponse"));
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
        _operations[51] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateCampaignsRequest"), com.microsoft.adcenter.v8.UpdateCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateCampaignsResponse"));
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
        _operations[52] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNegativeKeywordsByCampaignIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNegativeKeywordsByCampaignIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByCampaignIdsRequest"), com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByCampaignIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNegativeKeywordsByCampaignIdsResponse"));
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
        _operations[53] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetNegativeKeywordsToCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetNegativeKeywordsToCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeKeywordsToCampaignsRequest"), com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeKeywordsToCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetNegativeKeywordsToCampaignsResponse"));
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
        _operations[54] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNegativeSitesByCampaignIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNegativeSitesByCampaignIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByCampaignIdsRequest"), com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByCampaignIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNegativeSitesByCampaignIdsResponse"));
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
        _operations[55] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetNegativeSitesToCampaigns");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetNegativeSitesToCampaignsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeSitesToCampaignsRequest"), com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeSitesToCampaignsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetNegativeSitesToCampaignsResponse"));
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
        _operations[56] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddAdGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddAdGroupsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdGroupsRequest"), com.microsoft.adcenter.v8.AddAdGroupsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdGroupsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddAdGroupsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddAdGroupsResponse"));
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
        _operations[57] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteAdGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteAdGroupsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdGroupsRequest"), com.microsoft.adcenter.v8.DeleteAdGroupsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdGroupsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteAdGroupsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteAdGroupsResponse"));
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
        _operations[58] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAdGroupsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdGroupsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByIdsRequest"), com.microsoft.adcenter.v8.GetAdGroupsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdGroupsByIdsResponse"));
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
        _operations[59] = oper;

    }

    private static void _initOperationDesc7(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAdGroupsByCampaignId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdGroupsByCampaignIdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByCampaignIdRequest"), com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByCampaignIdResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetAdGroupsByCampaignIdResponse"));
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
        _operations[60] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PauseAdGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseAdGroupsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseAdGroupsRequest"), com.microsoft.adcenter.v8.PauseAdGroupsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseAdGroupsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.PauseAdGroupsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PauseAdGroupsResponse"));
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
        _operations[61] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ResumeAdGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeAdGroupsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeAdGroupsRequest"), com.microsoft.adcenter.v8.ResumeAdGroupsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeAdGroupsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.ResumeAdGroupsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ResumeAdGroupsResponse"));
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
        _operations[62] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SubmitAdGroupForApproval");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SubmitAdGroupForApprovalRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SubmitAdGroupForApprovalRequest"), com.microsoft.adcenter.v8.SubmitAdGroupForApprovalRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SubmitAdGroupForApprovalResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SubmitAdGroupForApprovalResponse"));
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
        _operations[63] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateAdGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateAdGroupsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateAdGroupsRequest"), com.microsoft.adcenter.v8.UpdateAdGroupsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateAdGroupsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateAdGroupsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateAdGroupsResponse"));
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
        _operations[64] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNegativeKeywordsByAdGroupIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNegativeKeywordsByAdGroupIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByAdGroupIdsRequest"), com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByAdGroupIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNegativeKeywordsByAdGroupIdsResponse"));
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
        _operations[65] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetNegativeKeywordsToAdGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetNegativeKeywordsToAdGroupsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeKeywordsToAdGroupsRequest"), com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeKeywordsToAdGroupsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetNegativeKeywordsToAdGroupsResponse"));
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
        _operations[66] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetNegativeSitesByAdGroupIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNegativeSitesByAdGroupIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByAdGroupIdsRequest"), com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByAdGroupIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetNegativeSitesByAdGroupIdsResponse"));
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
        _operations[67] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetNegativeSitesToAdGroups");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetNegativeSitesToAdGroupsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeSitesToAdGroupsRequest"), com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeSitesToAdGroupsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetNegativeSitesToAdGroupsResponse"));
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
        _operations[68] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddTarget");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddTargetRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddTargetRequest"), com.microsoft.adcenter.v8.AddTargetRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddTargetResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddTargetResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddTargetResponse"));
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
        _operations[69] = oper;

    }

    private static void _initOperationDesc8(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteTarget");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteTargetRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetRequest"), com.microsoft.adcenter.v8.DeleteTargetRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteTargetResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteTargetResponse"));
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
        _operations[70] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTargetByAdGroupId");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetByAdGroupIdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetByAdGroupIdRequest"), com.microsoft.adcenter.v8.GetTargetByAdGroupIdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetByAdGroupIdResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetByAdGroupIdResponse"));
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
        _operations[71] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateTarget");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateTargetRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateTargetRequest"), com.microsoft.adcenter.v8.UpdateTargetRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateTargetResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateTargetResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateTargetResponse"));
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
        _operations[72] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddTargetsToLibrary");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddTargetsToLibraryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddTargetsToLibraryRequest"), com.microsoft.adcenter.v8.AddTargetsToLibraryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddTargetsToLibraryResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddTargetsToLibraryResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddTargetsToLibraryResponse"));
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
        _operations[73] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateTargetsInLibrary");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateTargetsInLibraryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateTargetsInLibraryRequest"), com.microsoft.adcenter.v8.UpdateTargetsInLibraryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateTargetsInLibraryResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateTargetsInLibraryResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateTargetsInLibraryResponse"));
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
        _operations[74] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateDeviceOSTargets");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateDeviceOSTargetsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateDeviceOSTargetsRequest"), com.microsoft.adcenter.v8.UpdateDeviceOSTargetsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateDeviceOSTargetsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.UpdateDeviceOSTargetsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "UpdateDeviceOSTargetsResponse"));
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
        _operations[75] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteTargetsFromLibrary");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteTargetsFromLibraryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetsFromLibraryRequest"), com.microsoft.adcenter.v8.DeleteTargetsFromLibraryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetsFromLibraryResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteTargetsFromLibraryResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteTargetsFromLibraryResponse"));
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
        _operations[76] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTargetsInfoFromLibrary");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetsInfoFromLibraryRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsInfoFromLibraryRequest"), com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsInfoFromLibraryResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetsInfoFromLibraryResponse"));
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
        _operations[77] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTargetsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByIdsRequest"), com.microsoft.adcenter.v8.GetTargetsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetTargetsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetsByIdsResponse"));
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
        _operations[78] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDeviceOSTargetsByIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetDeviceOSTargetsByIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDeviceOSTargetsByIdsRequest"), com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDeviceOSTargetsByIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetDeviceOSTargetsByIdsResponse"));
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
        _operations[79] = oper;

    }

    private static void _initOperationDesc9(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetTargetToAdGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetTargetToAdGroupRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetTargetToAdGroupRequest"), com.microsoft.adcenter.v8.SetTargetToAdGroupRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetTargetToAdGroupResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetTargetToAdGroupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetTargetToAdGroupResponse"));
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
        _operations[80] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteTargetFromAdGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteTargetFromAdGroupRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetFromAdGroupRequest"), com.microsoft.adcenter.v8.DeleteTargetFromAdGroupRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetFromAdGroupResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteTargetFromAdGroupResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteTargetFromAdGroupResponse"));
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
        _operations[81] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTargetsByAdGroupIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetsByAdGroupIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByAdGroupIdsRequest"), com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByAdGroupIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetsByAdGroupIdsResponse"));
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
        _operations[82] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SetTargetToCampaign");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetTargetToCampaignRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetTargetToCampaignRequest"), com.microsoft.adcenter.v8.SetTargetToCampaignRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetTargetToCampaignResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SetTargetToCampaignResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SetTargetToCampaignResponse"));
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
        _operations[83] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteTargetFromCampaign");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteTargetFromCampaignRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetFromCampaignRequest"), com.microsoft.adcenter.v8.DeleteTargetFromCampaignRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetFromCampaignResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteTargetFromCampaignResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteTargetFromCampaignResponse"));
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
        _operations[84] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetTargetsByCampaignIds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetsByCampaignIdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByCampaignIdsRequest"), com.microsoft.adcenter.v8.GetTargetsByCampaignIdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByCampaignIdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetTargetsByCampaignIdsResponse"));
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
        _operations[85] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddAds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddAdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdsRequest"), com.microsoft.adcenter.v8.AddAdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.AddAdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AddAdsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"),
                      "com.microsoft.adcenter.v8.EditorialApiFaultDetail",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail"), 
                      true
                     ));
        _operations[86] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DeleteAds");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteAdsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdsRequest"), com.microsoft.adcenter.v8.DeleteAdsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdsResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.DeleteAdsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeleteAdsResponse"));
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
        _operations[87] = oper;

    }

    public BasicHttpBinding_ICampaignManagementServiceStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_ICampaignManagementServiceStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_ICampaignManagementServiceStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
        addBindings0();
        addBindings1();
        addBindings2();
        addBindings3();
    }

    private void addBindings0() {
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
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AccountAnalyticsType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AccountAnalyticsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AdComponent");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AdComponent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AnalyticsType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AnalyticsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfAccountAnalyticsType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AccountAnalyticsType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AccountAnalyticsType");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AccountAnalyticsType");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfAnalyticsType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.AnalyticsType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AnalyticsType");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "AnalyticsType");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfGoal");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Goal[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Goal");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Goal");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfGoalError");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalError");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfGoalResult");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalResult");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "ArrayOfStep");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Step[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Step");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Step");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "CostModel");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "CostModel>null");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.CostModelNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "DaysApplicableForConversion");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.DaysApplicableForConversion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Goal");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Goal.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalError");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "GoalResult");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.GoalResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "RevenueModel");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.RevenueModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "RevenueModelType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.RevenueModelType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "Step");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.Step.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.CampaignManagement.Api.DataContracts", "StepType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_CampaignManagement_Api_DataContracts.StepType.class;
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

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdExtensionsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddAdExtensionsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdExtensionsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddAdExtensionsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdGroupsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddAdGroupsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdGroupsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddAdGroupsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddAdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddAdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddAdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddBusinessesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddBusinessesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddBusinessesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddBusinessesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddGoalsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddGoalsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddGoalsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddGoalsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddKeywordsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddKeywordsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddKeywordsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddKeywordsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddSitePlacementsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddSitePlacementsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddSitePlacementsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddSitePlacementsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddTargetRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddTargetRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddTargetResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddTargetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddTargetsToLibraryRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddTargetsToLibraryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">AddTargetsToLibraryResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AddTargetsToLibraryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdExtensionsFromCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdExtensionsFromCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdGroupsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteAdGroupsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdGroupsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteAdGroupsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteAdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteAdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteAdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteBusinessesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteBusinessesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteBusinessesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteBusinessesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteGoalsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteGoalsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteGoalsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteGoalsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteKeywordsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteKeywordsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteKeywordsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteKeywordsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteSitePlacementsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteSitePlacementsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteSitePlacementsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteSitePlacementsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetFromAdGroupRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteTargetFromAdGroupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetFromAdGroupResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteTargetFromAdGroupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetFromCampaignRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteTargetFromCampaignRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetFromCampaignResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteTargetFromCampaignResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteTargetRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteTargetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetsFromLibraryRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteTargetsFromLibraryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DeleteTargetsFromLibraryResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeleteTargetsFromLibraryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DownloadCampaignHierarchyRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DownloadCampaignHierarchyRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">DownloadCampaignHierarchyResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DownloadCampaignHierarchyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAccountMigrationStatusesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAccountMigrationStatusesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAccountMigrationStatusesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAccountMigrationStatusesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdEditorialReasonsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdEditorialReasonsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByCampaignIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByCampaignIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdExtensionsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdExtensionsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdExtensionsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByCampaignIdRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByCampaignIdResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdGroupsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdGroupsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByAdGroupIdRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdsByAdGroupIdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByAdGroupIdResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByEditorialStatusRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdsByEditorialStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByEditorialStatusResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdsByEditorialStatusResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAdsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAdsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAnalyticsTypeRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAnalyticsTypeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetAnalyticsTypeResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetAnalyticsTypeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetBusinessesByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetBusinessesByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetBusinessesInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBusinessesInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetBusinessesInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignAdExtensionsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetCampaignAdExtensionsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignAdExtensionsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetCampaignAdExtensionsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings1() {
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
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignsByAccountIdRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetCampaignsByAccountIdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignsByAccountIdResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetCampaignsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetCampaignsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetCampaignsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDeviceOSTargetsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDeviceOSTargetsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDownloadStatusRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetDownloadStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetDownloadStatusResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetDownloadStatusResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetGoalsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetGoalsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetGoalsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetGoalsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordEditorialReasonsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordEditorialReasonsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByAdGroupIdRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByAdGroupIdResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByEditorialStatusRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByEditorialStatusResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetKeywordsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetKeywordsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByAdGroupIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByAdGroupIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByCampaignIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeKeywordsByCampaignIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByAdGroupIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByAdGroupIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByCampaignIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNegativeSitesByCampaignIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNormalizedStringsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNormalizedStringsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetNormalizedStringsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetNormalizedStringsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetPlacementDetailsForUrlsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetPlacementDetailsForUrlsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetSitePlacementsByAdGroupIdRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetSitePlacementsByAdGroupIdResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetSitePlacementsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetSitePlacementsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetSitePlacementsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetSitePlacementsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetByAdGroupIdRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetByAdGroupIdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetByAdGroupIdResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByAdGroupIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByAdGroupIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByCampaignIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetsByCampaignIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByCampaignIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByIdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetsByIdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsByIdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetsByIdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsInfoFromLibraryRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetTargetsInfoFromLibraryResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseAdGroupsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseAdGroupsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseAdGroupsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseAdGroupsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseAdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseAdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseAdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseAdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseKeywordsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseKeywordsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseKeywordsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseKeywordsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseSitePlacementsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseSitePlacementsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PauseSitePlacementsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PauseSitePlacementsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeAdGroupsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeAdGroupsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeAdGroupsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeAdGroupsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeAdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeAdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeAdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeAdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeKeywordsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeKeywordsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeKeywordsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeKeywordsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeSitePlacementsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeSitePlacementsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ResumeSitePlacementsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ResumeSitePlacementsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAdExtensionsToCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAdExtensionsToCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAnalyticsTypeRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetAnalyticsTypeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetAnalyticsTypeResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetAnalyticsTypeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetCampaignAdExtensionsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetCampaignAdExtensionsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetCampaignAdExtensionsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetCampaignAdExtensionsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeKeywordsToAdGroupsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeKeywordsToAdGroupsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeKeywordsToCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeKeywordsToCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeSitesToAdGroupsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeSitesToAdGroupsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeSitesToCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetNegativeSitesToCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetTargetToAdGroupRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetTargetToAdGroupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetTargetToAdGroupResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetTargetToAdGroupResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetTargetToCampaignRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetTargetToCampaignRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SetTargetToCampaignResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SetTargetToCampaignResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SubmitAdGroupForApprovalRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SubmitAdGroupForApprovalRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SubmitAdGroupForApprovalResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateAdGroupsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateAdGroupsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateAdGroupsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateAdGroupsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateAdsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateAdsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateAdsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateAdsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateBusinessesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateBusinessesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateBusinessesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateBusinessesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateCampaignsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateCampaignsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateCampaignsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateCampaignsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateDeviceOSTargetsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateDeviceOSTargetsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateDeviceOSTargetsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateDeviceOSTargetsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateGoalsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateGoalsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateGoalsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateGoalsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateKeywordsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateKeywordsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateKeywordsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateKeywordsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateSitePlacementsRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateSitePlacementsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateSitePlacementsResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateSitePlacementsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }
    private void addBindings2() {
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
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateTargetRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateTargetRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateTargetResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateTargetResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateTargetsInLibraryRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateTargetsInLibraryRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">UpdateTargetsInLibraryResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.UpdateTargetsInLibraryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountMigrationStatusesInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountMigrationStatusesInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Ad");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Ad.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistribution");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistribution>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdDistributionNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdEditorialStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdEditorialStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension2");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtension2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdentity");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionIdentity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdToCampaignIdAssociation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionIdToCampaignIdAssociation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionsTypeFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionsTypeFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionsTypeFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroup");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeKeywords");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupNegativeKeywords.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeSites");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupNegativeSites.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeRange");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeRange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AnalyticsApiFaultDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AnalyticsApiFaultDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ApiFaultDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAccountMigrationStatusesInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountMigrationStatusesInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountMigrationStatusesInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountMigrationStatusesInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAd");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Ad[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Ad");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Ad");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdExtension");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtension[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdExtension2");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtension2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension2");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtension2");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdExtensionIdentity");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionIdentity[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdentity");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdentity");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdExtensionIdToCampaignIdAssociation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionIdToCampaignIdAssociation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdToCampaignIdAssociation");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionIdToCampaignIdAssociation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdGroup");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroup[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroup");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroup");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdGroupNegativeKeywords");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupNegativeKeywords[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeKeywords");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeKeywords");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdGroupNegativeSites");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupNegativeSites[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeSites");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupNegativeSites");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAgeTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfArrayOfPlacementDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PlacementDetail[][].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfPlacementDetail");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfPlacementDetail");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfBatchError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BatchError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfBusiness");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Business[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Business");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Business");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfBusinessInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BusinessInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfBusinessTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BusinessTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCampaign");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Campaign[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Campaign");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Campaign");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCampaignAdExtension");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignAdExtension[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtension");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtension");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCampaignAdExtensionCollection");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignAdExtensionCollection[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionCollection");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionCollection");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCampaignNegativeKeywords");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignNegativeKeywords[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignNegativeKeywords");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignNegativeKeywords");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCampaignNegativeSites");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignNegativeSites[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignNegativeSites");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignNegativeSites");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCampaignScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignScope[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignScope");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignScope");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCityTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CityTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CityTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CityTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCountryTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CountryTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfDayTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DayTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfDeviceOS");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeviceOS[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOS");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOS");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfDeviceType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeviceType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceType");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceType");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfDimension");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Dimension[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Dimension");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Dimension");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfEditorialError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.EditorialError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialError");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfEditorialReason");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.EditorialReason[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReason");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReason");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfEditorialReasonCollection");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.EditorialReasonCollection[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReasonCollection");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReasonCollection");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfGenderTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GenderTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfHoursOfOperation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.HoursOfOperation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HoursOfOperation");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HoursOfOperation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfHourTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.HourTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfKeyword");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Keyword[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Keyword");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Keyword");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfMediaType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MediaType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MediaType");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MediaType");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfMetroAreaTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MetroAreaTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfMigrationStatusInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MigrationStatusInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationStatusInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationStatusInfo");
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

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfPaymentType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PaymentType[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PaymentType");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PaymentType");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfPlacementDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PlacementDetail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PlacementDetail");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PlacementDetail");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfPublisherCountry");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PublisherCountry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherCountry");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherCountry");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfRadiusTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.RadiusTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RadiusTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RadiusTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfSiteLink");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SiteLink[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SiteLink");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SiteLink");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfSitePlacement");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SitePlacement[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePlacement");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePlacement");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfStateTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.StateTargetBid[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StateTargetBid");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StateTargetBid");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Target[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Target");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Target");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfTargetAssociation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TargetAssociation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAssociation");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAssociation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfTargetInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TargetInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BatchError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Bid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Bid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BiddingModel");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BiddingModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetLimitType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BudgetLimitType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Business");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Business.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessGeoCodeStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BusinessGeoCodeStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessImageIcon");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BusinessImageIcon.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BusinessInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BusinessStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BusinessTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BusinessTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BusinessTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Campaign");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Campaign.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtension");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignAdExtension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionCollection");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignAdExtensionCollection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignAdExtensionEditorialStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignAdExtensionEditorialStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignNegativeKeywords");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignNegativeKeywords.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignNegativeSites");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignNegativeSites.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignScope.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CityTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CityTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CityTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CityTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CountryTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CountryTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Date");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Date.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Day");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Day.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }
    private void addBindings3() {
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
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DayTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DayTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DayTimeInterval");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DayTimeInterval.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOS");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeviceOS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceOSTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeviceOSTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeviceTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeviceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Dimension");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Dimension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DownloadEntityFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DownloadEntityFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DownloadEntityFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DownloadStatus");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DownloadStatus>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DownloadStatusNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialApiFaultDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.EditorialApiFaultDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.EditorialError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReason");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.EditorialReason.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "EditorialReasonCollection");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.EditorialReasonCollection.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GenderTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GenderTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GenderType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourRange");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.HourRange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HoursOfOperation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.HoursOfOperation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.HourTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "HourTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.HourTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ImpressionsPerDayRange");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ImpressionsPerDayRange.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "IncrementalBidPercentage");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.IncrementalBidPercentage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Keyword");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Keyword.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordEditorialStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordEditorialStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LocationTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.LocationTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MediaType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MediaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MetroAreaTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MetroAreaTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MigrationStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MigrationStatusInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MigrationStatusInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MobileAd");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MobileAd.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Network");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Network.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.OperationError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PaymentType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PaymentType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PhoneExtension");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PhoneExtension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PlacementDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PlacementDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PricingModel");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PricingModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherCountry");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PublisherCountry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RadiusTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.RadiusTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RadiusTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.RadiusTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SiteLink");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SiteLink.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SiteLinksAdExtension");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SiteLinksAdExtension.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePlacement");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SitePlacement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePlacementStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SitePlacementStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StandardBusinessIcon");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.StandardBusinessIcon.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StateTarget");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.StateTarget.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "StateTargetBid");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.StateTargetBid.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Target");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Target.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetAssociation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TargetAssociation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TargetInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TargetInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TextAd");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TextAd.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TimeOfTheDay");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TimeOfTheDay.class;
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

    public com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsResponse getAdExtensionsByCampaignIds(com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAdExtensionsByCampaignIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAdExtensionsByCampaignIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAdExtensionsByCampaignIdsResponse.class);
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

    public com.microsoft.adcenter.v8.GetAdExtensionsByIdsResponse getAdExtensionsByIds(com.microsoft.adcenter.v8.GetAdExtensionsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAdExtensionsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAdExtensionsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAdExtensionsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAdExtensionsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAdExtensionsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsResponse setAdExtensionsToCampaigns(com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.EditorialApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetAdExtensionsToCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetAdExtensionsToCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetAdExtensionsToCampaignsResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.EditorialApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.EditorialApiFaultDetail) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.ApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.ApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsResponse deleteAdExtensionsFromCampaigns(com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteAdExtensionsFromCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteAdExtensionsFromCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteAdExtensionsFromCampaignsResponse.class);
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

    public com.microsoft.adcenter.v8.GetAdsByEditorialStatusResponse getAdsByEditorialStatus(com.microsoft.adcenter.v8.GetAdsByEditorialStatusRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAdsByEditorialStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAdsByEditorialStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAdsByEditorialStatusResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAdsByEditorialStatusResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAdsByEditorialStatusResponse.class);
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

    public com.microsoft.adcenter.v8.GetAdsByIdsResponse getAdsByIds(com.microsoft.adcenter.v8.GetAdsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAdsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAdsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAdsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAdsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAdsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse getAdsByAdGroupId(com.microsoft.adcenter.v8.GetAdsByAdGroupIdRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAdsByAdGroupId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAdsByAdGroupId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAdsByAdGroupIdResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateAdsResponse updateAds(com.microsoft.adcenter.v8.UpdateAdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.EditorialApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateAds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateAds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateAdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateAdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateAdsResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.EditorialApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.EditorialApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.PauseAdsResponse pauseAds(com.microsoft.adcenter.v8.PauseAdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("PauseAds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PauseAds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.PauseAdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.PauseAdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.PauseAdsResponse.class);
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

    public com.microsoft.adcenter.v8.ResumeAdsResponse resumeAds(com.microsoft.adcenter.v8.ResumeAdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ResumeAds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ResumeAds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.ResumeAdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.ResumeAdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.ResumeAdsResponse.class);
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

    public com.microsoft.adcenter.v8.AddKeywordsResponse addKeywords(com.microsoft.adcenter.v8.AddKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.EditorialApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddKeywords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddKeywords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddKeywordsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddKeywordsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddKeywordsResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.EditorialApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.EditorialApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.DeleteKeywordsResponse deleteKeywords(com.microsoft.adcenter.v8.DeleteKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteKeywords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteKeywords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteKeywordsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteKeywordsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteKeywordsResponse.class);
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

    public com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusResponse getKeywordsByEditorialStatus(com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetKeywordsByEditorialStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetKeywordsByEditorialStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetKeywordsByEditorialStatusResponse.class);
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

    public com.microsoft.adcenter.v8.GetKeywordsByIdsResponse getKeywordsByIds(com.microsoft.adcenter.v8.GetKeywordsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetKeywordsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetKeywordsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetKeywordsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetKeywordsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetKeywordsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse getKeywordsByAdGroupId(com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetKeywordsByAdGroupId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetKeywordsByAdGroupId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetKeywordsByAdGroupIdResponse.class);
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

    public com.microsoft.adcenter.v8.PauseKeywordsResponse pauseKeywords(com.microsoft.adcenter.v8.PauseKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("PauseKeywords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PauseKeywords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.PauseKeywordsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.PauseKeywordsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.PauseKeywordsResponse.class);
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

    public com.microsoft.adcenter.v8.ResumeKeywordsResponse resumeKeywords(com.microsoft.adcenter.v8.ResumeKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ResumeKeywords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ResumeKeywords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.ResumeKeywordsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.ResumeKeywordsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.ResumeKeywordsResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateKeywordsResponse updateKeywords(com.microsoft.adcenter.v8.UpdateKeywordsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.EditorialApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateKeywords");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateKeywords"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateKeywordsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateKeywordsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateKeywordsResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.EditorialApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.EditorialApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.AddBusinessesResponse addBusinesses(com.microsoft.adcenter.v8.AddBusinessesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddBusinesses");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddBusinesses"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddBusinessesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddBusinessesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddBusinessesResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateBusinessesResponse updateBusinesses(com.microsoft.adcenter.v8.UpdateBusinessesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateBusinesses");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateBusinesses"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateBusinessesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateBusinessesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateBusinessesResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteBusinessesResponse deleteBusinesses(com.microsoft.adcenter.v8.DeleteBusinessesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteBusinesses");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteBusinesses"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteBusinessesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteBusinessesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteBusinessesResponse.class);
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

    public com.microsoft.adcenter.v8.GetBusinessesInfoResponse getBusinessesInfo(com.microsoft.adcenter.v8.GetBusinessesInfoRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetBusinessesInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetBusinessesInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetBusinessesInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetBusinessesInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetBusinessesInfoResponse.class);
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

    public com.microsoft.adcenter.v8.GetBusinessesByIdsResponse getBusinessesByIds(com.microsoft.adcenter.v8.GetBusinessesByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetBusinessesByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetBusinessesByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetBusinessesByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetBusinessesByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetBusinessesByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.AddSitePlacementsResponse addSitePlacements(com.microsoft.adcenter.v8.AddSitePlacementsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddSitePlacements");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddSitePlacements"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddSitePlacementsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddSitePlacementsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddSitePlacementsResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteSitePlacementsResponse deleteSitePlacements(com.microsoft.adcenter.v8.DeleteSitePlacementsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteSitePlacements");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteSitePlacements"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteSitePlacementsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteSitePlacementsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteSitePlacementsResponse.class);
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

    public com.microsoft.adcenter.v8.GetSitePlacementsByIdsResponse getSitePlacementsByIds(com.microsoft.adcenter.v8.GetSitePlacementsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetSitePlacementsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetSitePlacementsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetSitePlacementsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetSitePlacementsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetSitePlacementsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdResponse getSitePlacementsByAdGroupId(com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetSitePlacementsByAdGroupId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetSitePlacementsByAdGroupId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetSitePlacementsByAdGroupIdResponse.class);
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

    public com.microsoft.adcenter.v8.PauseSitePlacementsResponse pauseSitePlacements(com.microsoft.adcenter.v8.PauseSitePlacementsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("PauseSitePlacements");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PauseSitePlacements"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.PauseSitePlacementsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.PauseSitePlacementsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.PauseSitePlacementsResponse.class);
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

    public com.microsoft.adcenter.v8.ResumeSitePlacementsResponse resumeSitePlacements(com.microsoft.adcenter.v8.ResumeSitePlacementsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ResumeSitePlacements");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ResumeSitePlacements"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.ResumeSitePlacementsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.ResumeSitePlacementsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.ResumeSitePlacementsResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateSitePlacementsResponse updateSitePlacements(com.microsoft.adcenter.v8.UpdateSitePlacementsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateSitePlacements");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateSitePlacements"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateSitePlacementsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateSitePlacementsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateSitePlacementsResponse.class);
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

    public com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsResponse getPlacementDetailsForUrls(com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetPlacementDetailsForUrls");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetPlacementDetailsForUrls"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetPlacementDetailsForUrlsResponse.class);
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

    public com.microsoft.adcenter.v8.GetNormalizedStringsResponse getNormalizedStrings(com.microsoft.adcenter.v8.GetNormalizedStringsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetNormalizedStrings");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetNormalizedStrings"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetNormalizedStringsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetNormalizedStringsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetNormalizedStringsResponse.class);
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

    public com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsResponse getKeywordEditorialReasonsByIds(com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetKeywordEditorialReasonsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetKeywordEditorialReasonsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetKeywordEditorialReasonsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsResponse getAdEditorialReasonsByIds(com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAdEditorialReasonsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAdEditorialReasonsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAdEditorialReasonsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.DownloadCampaignHierarchyResponse downloadCampaignHierarchy(com.microsoft.adcenter.v8.DownloadCampaignHierarchyRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DownloadCampaignHierarchy");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DownloadCampaignHierarchy"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DownloadCampaignHierarchyResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DownloadCampaignHierarchyResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DownloadCampaignHierarchyResponse.class);
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

    public com.microsoft.adcenter.v8.GetDownloadStatusResponse getDownloadStatus(com.microsoft.adcenter.v8.GetDownloadStatusRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetDownloadStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetDownloadStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetDownloadStatusResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetDownloadStatusResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetDownloadStatusResponse.class);
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

    public com.microsoft.adcenter.v8.AddGoalsResponse addGoals(com.microsoft.adcenter.v8.AddGoalsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail, com.microsoft.adcenter.v8.AnalyticsApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddGoals");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddGoals"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddGoalsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddGoalsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddGoalsResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.AnalyticsApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.AnalyticsApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.UpdateGoalsResponse updateGoals(com.microsoft.adcenter.v8.UpdateGoalsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail, com.microsoft.adcenter.v8.AnalyticsApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateGoals");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateGoals"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateGoalsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateGoalsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateGoalsResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.AnalyticsApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.AnalyticsApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetGoalsResponse getGoals(com.microsoft.adcenter.v8.GetGoalsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetGoals");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetGoals"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetGoalsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetGoalsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetGoalsResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteGoalsResponse deleteGoals(com.microsoft.adcenter.v8.DeleteGoalsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteGoals");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteGoals"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteGoalsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteGoalsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteGoalsResponse.class);
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

    public com.microsoft.adcenter.v8.SetAnalyticsTypeResponse setAnalyticsType(com.microsoft.adcenter.v8.SetAnalyticsTypeRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetAnalyticsType");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetAnalyticsType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetAnalyticsTypeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetAnalyticsTypeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetAnalyticsTypeResponse.class);
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

    public com.microsoft.adcenter.v8.GetAnalyticsTypeResponse getAnalyticsType(com.microsoft.adcenter.v8.GetAnalyticsTypeRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAnalyticsType");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAnalyticsType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAnalyticsTypeResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAnalyticsTypeResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAnalyticsTypeResponse.class);
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

    public com.microsoft.adcenter.v8.GetCampaignAdExtensionsResponse getCampaignAdExtensions(com.microsoft.adcenter.v8.GetCampaignAdExtensionsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[42]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetCampaignAdExtensions");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCampaignAdExtensions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetCampaignAdExtensionsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetCampaignAdExtensionsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetCampaignAdExtensionsResponse.class);
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

    public com.microsoft.adcenter.v8.SetCampaignAdExtensionsResponse setCampaignAdExtensions(com.microsoft.adcenter.v8.SetCampaignAdExtensionsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.EditorialApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[43]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetCampaignAdExtensions");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetCampaignAdExtensions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetCampaignAdExtensionsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetCampaignAdExtensionsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetCampaignAdExtensionsResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.EditorialApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.EditorialApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.GetAccountMigrationStatusesResponse getAccountMigrationStatuses(com.microsoft.adcenter.v8.GetAccountMigrationStatusesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[44]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAccountMigrationStatuses");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAccountMigrationStatuses"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAccountMigrationStatusesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAccountMigrationStatusesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAccountMigrationStatusesResponse.class);
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

    public com.microsoft.adcenter.v8.AddAdExtensionsResponse addAdExtensions(com.microsoft.adcenter.v8.AddAdExtensionsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[45]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddAdExtensions");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddAdExtensions"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddAdExtensionsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddAdExtensionsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddAdExtensionsResponse.class);
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

    public com.microsoft.adcenter.v8.AddCampaignsResponse addCampaigns(com.microsoft.adcenter.v8.AddCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[46]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddCampaignsResponse.class);
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

    public com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse getCampaignsByAccountId(com.microsoft.adcenter.v8.GetCampaignsByAccountIdRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[47]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetCampaignsByAccountId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCampaignsByAccountId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetCampaignsByAccountIdResponse.class);
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

    public com.microsoft.adcenter.v8.GetCampaignsByIdsResponse getCampaignsByIds(com.microsoft.adcenter.v8.GetCampaignsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[48]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetCampaignsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetCampaignsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetCampaignsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetCampaignsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetCampaignsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.PauseCampaignsResponse pauseCampaigns(com.microsoft.adcenter.v8.PauseCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[49]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("PauseCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PauseCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.PauseCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.PauseCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.PauseCampaignsResponse.class);
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

    public com.microsoft.adcenter.v8.ResumeCampaignsResponse resumeCampaigns(com.microsoft.adcenter.v8.ResumeCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[50]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ResumeCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ResumeCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.ResumeCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.ResumeCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.ResumeCampaignsResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteCampaignsResponse deleteCampaigns(com.microsoft.adcenter.v8.DeleteCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[51]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteCampaignsResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateCampaignsResponse updateCampaigns(com.microsoft.adcenter.v8.UpdateCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[52]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateCampaignsResponse.class);
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

    public com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsResponse getNegativeKeywordsByCampaignIds(com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[53]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetNegativeKeywordsByCampaignIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetNegativeKeywordsByCampaignIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetNegativeKeywordsByCampaignIdsResponse.class);
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

    public com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse setNegativeKeywordsToCampaigns(com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[54]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetNegativeKeywordsToCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetNegativeKeywordsToCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetNegativeKeywordsToCampaignsResponse.class);
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

    public com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsResponse getNegativeSitesByCampaignIds(com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[55]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetNegativeSitesByCampaignIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetNegativeSitesByCampaignIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetNegativeSitesByCampaignIdsResponse.class);
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

    public com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsResponse setNegativeSitesToCampaigns(com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[56]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetNegativeSitesToCampaigns");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetNegativeSitesToCampaigns"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetNegativeSitesToCampaignsResponse.class);
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

    public com.microsoft.adcenter.v8.AddAdGroupsResponse addAdGroups(com.microsoft.adcenter.v8.AddAdGroupsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[57]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddAdGroups");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddAdGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddAdGroupsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddAdGroupsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddAdGroupsResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteAdGroupsResponse deleteAdGroups(com.microsoft.adcenter.v8.DeleteAdGroupsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[58]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteAdGroups");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteAdGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteAdGroupsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteAdGroupsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteAdGroupsResponse.class);
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

    public com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse getAdGroupsByIds(com.microsoft.adcenter.v8.GetAdGroupsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[59]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAdGroupsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAdGroupsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAdGroupsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse getAdGroupsByCampaignId(com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[60]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAdGroupsByCampaignId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAdGroupsByCampaignId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetAdGroupsByCampaignIdResponse.class);
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

    public com.microsoft.adcenter.v8.PauseAdGroupsResponse pauseAdGroups(com.microsoft.adcenter.v8.PauseAdGroupsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[61]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("PauseAdGroups");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PauseAdGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.PauseAdGroupsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.PauseAdGroupsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.PauseAdGroupsResponse.class);
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

    public com.microsoft.adcenter.v8.ResumeAdGroupsResponse resumeAdGroups(com.microsoft.adcenter.v8.ResumeAdGroupsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[62]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ResumeAdGroups");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ResumeAdGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.ResumeAdGroupsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.ResumeAdGroupsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.ResumeAdGroupsResponse.class);
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

    public com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse submitAdGroupForApproval(com.microsoft.adcenter.v8.SubmitAdGroupForApprovalRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[63]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SubmitAdGroupForApproval");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SubmitAdGroupForApproval"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SubmitAdGroupForApprovalResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateAdGroupsResponse updateAdGroups(com.microsoft.adcenter.v8.UpdateAdGroupsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[64]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateAdGroups");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateAdGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateAdGroupsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateAdGroupsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateAdGroupsResponse.class);
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

    public com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsResponse getNegativeKeywordsByAdGroupIds(com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[65]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetNegativeKeywordsByAdGroupIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetNegativeKeywordsByAdGroupIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetNegativeKeywordsByAdGroupIdsResponse.class);
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

    public com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsResponse setNegativeKeywordsToAdGroups(com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[66]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetNegativeKeywordsToAdGroups");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetNegativeKeywordsToAdGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetNegativeKeywordsToAdGroupsResponse.class);
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

    public com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsResponse getNegativeSitesByAdGroupIds(com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[67]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetNegativeSitesByAdGroupIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetNegativeSitesByAdGroupIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetNegativeSitesByAdGroupIdsResponse.class);
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

    public com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsResponse setNegativeSitesToAdGroups(com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[68]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetNegativeSitesToAdGroups");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetNegativeSitesToAdGroups"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetNegativeSitesToAdGroupsResponse.class);
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

    public com.microsoft.adcenter.v8.AddTargetResponse addTarget(com.microsoft.adcenter.v8.AddTargetRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[69]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddTarget");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddTarget"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddTargetResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddTargetResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddTargetResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteTargetResponse deleteTarget(com.microsoft.adcenter.v8.DeleteTargetRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[70]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteTarget");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteTarget"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteTargetResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteTargetResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteTargetResponse.class);
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

    public com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse getTargetByAdGroupId(com.microsoft.adcenter.v8.GetTargetByAdGroupIdRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[71]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetTargetByAdGroupId");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetTargetByAdGroupId"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetTargetByAdGroupIdResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateTargetResponse updateTarget(com.microsoft.adcenter.v8.UpdateTargetRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[72]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateTarget");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateTarget"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateTargetResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateTargetResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateTargetResponse.class);
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

    public com.microsoft.adcenter.v8.AddTargetsToLibraryResponse addTargetsToLibrary(com.microsoft.adcenter.v8.AddTargetsToLibraryRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[73]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddTargetsToLibrary");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddTargetsToLibrary"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddTargetsToLibraryResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddTargetsToLibraryResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddTargetsToLibraryResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateTargetsInLibraryResponse updateTargetsInLibrary(com.microsoft.adcenter.v8.UpdateTargetsInLibraryRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[74]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateTargetsInLibrary");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateTargetsInLibrary"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateTargetsInLibraryResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateTargetsInLibraryResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateTargetsInLibraryResponse.class);
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

    public com.microsoft.adcenter.v8.UpdateDeviceOSTargetsResponse updateDeviceOSTargets(com.microsoft.adcenter.v8.UpdateDeviceOSTargetsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[75]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateDeviceOSTargets");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateDeviceOSTargets"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.UpdateDeviceOSTargetsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.UpdateDeviceOSTargetsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.UpdateDeviceOSTargetsResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteTargetsFromLibraryResponse deleteTargetsFromLibrary(com.microsoft.adcenter.v8.DeleteTargetsFromLibraryRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[76]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteTargetsFromLibrary");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteTargetsFromLibrary"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteTargetsFromLibraryResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteTargetsFromLibraryResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteTargetsFromLibraryResponse.class);
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

    public com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryResponse getTargetsInfoFromLibrary(com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[77]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetTargetsInfoFromLibrary");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetTargetsInfoFromLibrary"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetTargetsInfoFromLibraryResponse.class);
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

    public com.microsoft.adcenter.v8.GetTargetsByIdsResponse getTargetsByIds(com.microsoft.adcenter.v8.GetTargetsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[78]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetTargetsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetTargetsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetTargetsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetTargetsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetTargetsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsResponse getDeviceOSTargetsByIds(com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[79]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetDeviceOSTargetsByIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetDeviceOSTargetsByIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetDeviceOSTargetsByIdsResponse.class);
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

    public com.microsoft.adcenter.v8.SetTargetToAdGroupResponse setTargetToAdGroup(com.microsoft.adcenter.v8.SetTargetToAdGroupRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[80]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetTargetToAdGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetTargetToAdGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetTargetToAdGroupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetTargetToAdGroupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetTargetToAdGroupResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteTargetFromAdGroupResponse deleteTargetFromAdGroup(com.microsoft.adcenter.v8.DeleteTargetFromAdGroupRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[81]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteTargetFromAdGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteTargetFromAdGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteTargetFromAdGroupResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteTargetFromAdGroupResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteTargetFromAdGroupResponse.class);
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

    public com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsResponse getTargetsByAdGroupIds(com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[82]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetTargetsByAdGroupIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetTargetsByAdGroupIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetTargetsByAdGroupIdsResponse.class);
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

    public com.microsoft.adcenter.v8.SetTargetToCampaignResponse setTargetToCampaign(com.microsoft.adcenter.v8.SetTargetToCampaignRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[83]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SetTargetToCampaign");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SetTargetToCampaign"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SetTargetToCampaignResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SetTargetToCampaignResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SetTargetToCampaignResponse.class);
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

    public com.microsoft.adcenter.v8.DeleteTargetFromCampaignResponse deleteTargetFromCampaign(com.microsoft.adcenter.v8.DeleteTargetFromCampaignRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[84]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteTargetFromCampaign");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteTargetFromCampaign"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteTargetFromCampaignResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteTargetFromCampaignResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteTargetFromCampaignResponse.class);
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

    public com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse getTargetsByCampaignIds(com.microsoft.adcenter.v8.GetTargetsByCampaignIdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[85]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetTargetsByCampaignIds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetTargetsByCampaignIds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetTargetsByCampaignIdsResponse.class);
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

    public com.microsoft.adcenter.v8.AddAdsResponse addAds(com.microsoft.adcenter.v8.AddAdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.EditorialApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[86]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddAds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddAds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.AddAdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.AddAdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.AddAdsResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.v8.EditorialApiFaultDetail) {
              throw (com.microsoft.adcenter.v8.EditorialApiFaultDetail) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.v8.DeleteAdsResponse deleteAds(com.microsoft.adcenter.v8.DeleteAdsRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[87]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("DeleteAds");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "DeleteAds"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.DeleteAdsResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.DeleteAdsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.DeleteAdsResponse.class);
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
