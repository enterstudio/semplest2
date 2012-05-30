/**
 * BasicHttpBinding_IOptimizerServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BasicHttpBinding_IOptimizerServiceStub extends org.apache.axis.client.Stub implements com.microsoft.adcenter.v8.IOptimizerService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetBudgetOpportunities");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetBudgetOpportunitiesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBudgetOpportunitiesRequest"), com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBudgetOpportunitiesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetBudgetOpportunitiesResponse"));
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
        oper.setName("GetBidOpportunities");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetBidOpportunitiesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBidOpportunitiesRequest"), com.microsoft.adcenter.v8.GetBidOpportunitiesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBidOpportunitiesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.GetBidOpportunitiesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GetBidOpportunitiesResponse"));
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
        oper.setName("ApplyBudgetOpportunities");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApplyBudgetOpportunitiesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ApplyBudgetOpportunitiesRequest"), com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ApplyBudgetOpportunitiesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApplyBudgetOpportunitiesResponse"));
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
        oper.setName("ApplyOpportunities");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApplyOpportunitiesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ApplyOpportunitiesRequest"), com.microsoft.adcenter.v8.ApplyOpportunitiesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ApplyOpportunitiesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.ApplyOpportunitiesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApplyOpportunitiesResponse"));
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

    }

    public BasicHttpBinding_IOptimizerServiceStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_IOptimizerServiceStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_IOptimizerServiceStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "ArrayOfBidOpportunity");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities.BidOpportunity[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BidOpportunity");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BidOpportunity");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "ArrayOfBudgetOpportunity");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities.BudgetOpportunity[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BudgetOpportunity");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BudgetOpportunity");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BidOpportunity");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities.BidOpportunity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "BudgetOpportunity");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities.BudgetOpportunity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts.Entities", "Opportunity");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts_Entities.Opportunity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Advertiser.Optimizer.Api.DataContracts", "BudgetLimitType");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Advertiser_Optimizer_Api_DataContracts.BudgetLimitType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/Microsoft.AdCenter.Shared.Api", "ErrorCodes");
            cachedSerQNames.add(qName);
            cls = org.datacontract.schemas._2004._07.Microsoft_AdCenter_Shared_Api.ErrorCodes.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

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

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ApplyBudgetOpportunitiesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ApplyBudgetOpportunitiesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ApplyOpportunitiesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ApplyOpportunitiesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">ApplyOpportunitiesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ApplyOpportunitiesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBidOpportunitiesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetBidOpportunitiesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBidOpportunitiesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetBidOpportunitiesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBudgetOpportunitiesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">GetBudgetOpportunitiesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse.class;
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

    public com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse getBudgetOpportunities(com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetBudgetOpportunities");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetBudgetOpportunities"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse.class);
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

    public com.microsoft.adcenter.v8.GetBidOpportunitiesResponse getBidOpportunities(com.microsoft.adcenter.v8.GetBidOpportunitiesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetBidOpportunities");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetBidOpportunities"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.GetBidOpportunitiesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.GetBidOpportunitiesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.GetBidOpportunitiesResponse.class);
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

    public com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse applyBudgetOpportunities(com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ApplyBudgetOpportunities");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ApplyBudgetOpportunities"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse.class);
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

    public com.microsoft.adcenter.v8.ApplyOpportunitiesResponse applyOpportunities(com.microsoft.adcenter.v8.ApplyOpportunitiesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("ApplyOpportunities");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ApplyOpportunities"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.ApplyOpportunitiesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.ApplyOpportunitiesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.ApplyOpportunitiesResponse.class);
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
