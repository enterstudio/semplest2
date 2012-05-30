/**
 * BasicHttpBinding_ICustomerBillingServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.api.customerbilling;

public class BasicHttpBinding_ICustomerBillingServiceStub extends org.apache.axis.client.Stub implements com.microsoft.adcenter.api.customerbilling.ICustomerBillingService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[8];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInvoicesInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetInvoicesInfoRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInvoicesInfoRequest"), com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInvoicesInfoResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetInvoicesInfoResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInvoices");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetInvoicesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInvoicesRequest"), com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInvoicesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetInvoicesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDisplayInvoices");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetDisplayInvoicesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetDisplayInvoicesRequest"), com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetDisplayInvoicesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetDisplayInvoicesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddInsertionOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "AddInsertionOrderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">AddInsertionOrderRequest"), com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">AddInsertionOrderResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "AddInsertionOrderResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateInsertionOrder");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "UpdateInsertionOrderRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">UpdateInsertionOrderRequest"), com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">UpdateInsertionOrderResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "UpdateInsertionOrderResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInsertionOrdersByAccount");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetInsertionOrdersByAccountRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInsertionOrdersByAccountRequest"), com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInsertionOrdersByAccountResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetInsertionOrdersByAccountResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetKOHIOInvoices");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetKOHIOInvoicesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetKOHIOInvoicesRequest"), com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetKOHIOInvoicesResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetKOHIOInvoicesResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAccountMonthlySpend");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetAccountMonthlySpendRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetAccountMonthlySpendRequest"), com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetAccountMonthlySpendResponse"));
        oper.setReturnClass(com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "GetAccountMonthlySpendResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"),
                      "com.microsoft.adapi.AdApiFaultDetail",
                      new javax.xml.namespace.QName("https://adapi.microsoft.com", "AdApiFaultDetail"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"),
                      "com.microsoft.adcenter.api.customermanagement.Exception.ApiFault",
                      new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault"), 
                      true
                     ));
        _operations[7] = oper;

    }

    public BasicHttpBinding_ICustomerBillingServiceStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_ICustomerBillingServiceStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_ICustomerBillingServiceStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">AddInsertionOrderRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">AddInsertionOrderResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetAccountMonthlySpendRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetAccountMonthlySpendResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetDisplayInvoicesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetDisplayInvoicesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInsertionOrdersByAccountRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInsertionOrdersByAccountResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInvoicesInfoRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInvoicesInfoResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInvoicesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetInvoicesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetKOHIOInvoicesRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">GetKOHIOInvoicesResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">UpdateInsertionOrderRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", ">UpdateInsertionOrderResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfInsertionOrder");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.InsertionOrder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InsertionOrder");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InsertionOrder");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfInvoice");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.Invoice[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Invoice");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Invoice");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "ArrayOfInvoiceInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.InvoiceInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InvoiceInfo");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InvoiceInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "DataType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.DataType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InsertionOrder");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.InsertionOrder.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "Invoice");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.Invoice.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Entities", "InvoiceInfo");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Entities.InvoiceInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiBatchFault");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ApiFault");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.ApiFault.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ArrayOfBatchError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.BatchError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "BatchError");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "BatchError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "ArrayOfOperationError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.OperationError[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationError");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "BatchError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.BatchError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception", "OperationError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.api.customermanagement.Exception.OperationError.class;
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

    public com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse getInvoicesInfo(com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetInvoicesInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetInvoicesInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse getInvoices(com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetInvoices");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetInvoices"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse getDisplayInvoices(com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetDisplayInvoices");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetDisplayInvoices"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse addInsertionOrder(com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("AddInsertionOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "AddInsertionOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse updateInsertionOrder(com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("UpdateInsertionOrder");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateInsertionOrder"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse getInsertionOrdersByAccount(com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetInsertionOrdersByAccount");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetInsertionOrdersByAccount"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse getKOHIOInvoices(com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetKOHIOInvoices");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetKOHIOInvoices"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiBatchFault) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse getAccountMonthlySpend(com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.api.customermanagement.Exception.ApiFault {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("GetAccountMonthlySpend");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetAccountMonthlySpend"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse.class);
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
        if (axisFaultException.detail instanceof com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) {
              throw (com.microsoft.adcenter.api.customermanagement.Exception.ApiFault) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
