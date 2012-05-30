/**
 * BasicHttpBinding_IReportingServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.adcenter.v8;

public class BasicHttpBinding_IReportingServiceStub extends org.apache.axis.client.Stub implements com.microsoft.adcenter.v8.IReportingService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[2];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SubmitGenerateReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SubmitGenerateReportRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SubmitGenerateReportRequest"), com.microsoft.adcenter.v8.SubmitGenerateReportRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SubmitGenerateReportResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.SubmitGenerateReportResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SubmitGenerateReportResponse"));
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
        oper.setName("PollGenerateReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PollGenerateReportRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PollGenerateReportRequest"), com.microsoft.adcenter.v8.PollGenerateReportRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PollGenerateReportResponse"));
        oper.setReturnClass(com.microsoft.adcenter.v8.PollGenerateReportResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PollGenerateReportResponse"));
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

    }

    public BasicHttpBinding_IReportingServiceStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_IReportingServiceStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_IReportingServiceStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PollGenerateReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PollGenerateReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">PollGenerateReportResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PollGenerateReportResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SubmitGenerateReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SubmitGenerateReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", ">SubmitGenerateReportResponse");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SubmitGenerateReportResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountReportScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountReportScope.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountThroughAdGroupReportScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountThroughAdGroupReportScope.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountThroughCampaignReportScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountThroughCampaignReportScope.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistributionReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDistributionReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdDistributionReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDynamicTextPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdDynamicTextPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDynamicTextPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdDynamicTextPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDynamicTextPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdDynamicTextPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByAdsReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionByAdsReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByAdsReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionByAdsReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByKeywordReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionByKeywordReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByKeywordReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionByKeywordReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionDimensionReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionDimensionReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionDimensionReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionDimensionReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupReportScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupReportScope.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupStatusReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupStatusReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupStatusReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdStatusReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdStatusReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdStatusReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdTypeReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdTypeReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdTypeReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGenderDemographicReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeGenderDemographicReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGenderDemographicReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeGenderDemographicReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGenderDemographicReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeGenderDemographicReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGroupReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGroupReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeGroupReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ApiFaultDetail");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ApiFaultDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAccountPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AccountPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AccountPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdDynamicTextPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdDynamicTextPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDynamicTextPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdDynamicTextPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdExtensionByAdsReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionByAdsReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByAdsReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByAdsReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdExtensionByKeywordReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionByKeywordReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByKeywordReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionByKeywordReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdExtensionDimensionReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdExtensionDimensionReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionDimensionReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdExtensionDimensionReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdGroupPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdGroupReportScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdGroupReportScope[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupReportScope");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdGroupReportScope");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAdPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AdPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AdPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfAgeGenderDemographicReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.AgeGenderDemographicReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGenderDemographicReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "AgeGenderDemographicReportColumn");
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

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfBehavioralPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BehavioralPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfBehavioralTargetReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BehavioralTargetReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralTargetReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralTargetReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfBudgetSummaryReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BudgetSummaryReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCampaignPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfCampaignReportScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignReportScope[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignReportScope");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignReportScope");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfConversionPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ConversionPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ConversionPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ConversionPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfDestinationUrlPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DestinationUrlPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DestinationUrlPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DestinationUrlPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfGoalsAndFunnelsReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GoalsAndFunnelsReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GoalsAndFunnelsReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GoalsAndFunnelsReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfKeywordMigrationReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordMigrationReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordMigrationReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordMigrationReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfKeywordPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfMetroAreaDemographicReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MetroAreaDemographicReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaDemographicReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaDemographicReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfNegativeKeywordConflictReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.NegativeKeywordConflictReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "NegativeKeywordConflictReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "NegativeKeywordConflictReportColumn");
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

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfPublisherUsagePerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PublisherUsagePerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherUsagePerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherUsagePerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfRichAdComponentPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.RichAdComponentPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdComponentPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdComponentPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfSearchCampaignChangeHistoryReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchCampaignChangeHistoryReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchCampaignChangeHistoryReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchCampaignChangeHistoryReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfSearchQueryPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchQueryPerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryPerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryPerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfSegmentationReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SegmentationReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SegmentationReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SegmentationReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfSitePerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SitePerformanceReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePerformanceReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePerformanceReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfTacticChannelReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TacticChannelReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TacticChannelReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TacticChannelReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ArrayOfTrafficSourcesReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TrafficSourcesReportColumn[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TrafficSourcesReportColumn");
            qName2 = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TrafficSourcesReportColumn");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BatchError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BatchError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BehavioralPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BehavioralPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BehavioralPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralTargetReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BehavioralTargetReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralTargetReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BehavioralTargetReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BehavioralTargetReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BehavioralTargetReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BidMatchTypeReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BidMatchTypeReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BidMatchTypeReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BudgetSummaryReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BudgetSummaryReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportTime");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BudgetSummaryReportTime.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "BudgetSummaryReportTimePeriod");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.BudgetSummaryReportTimePeriod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignReportScope");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignReportScope.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignStatusReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CampaignStatusReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CampaignStatusReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CashbackReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

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
            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CashbackReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CashbackReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ChangeEntityReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ChangeEntityReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ChangeEntityReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ChangeTypeReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ChangeTypeReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ChangeTypeReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ComponentTypeFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ComponentTypeFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ComponentTypeFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ConversionPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ConversionPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ConversionPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ConversionPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ConversionPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ConversionPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "CountryReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.CountryReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "Date");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.Date.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeliveredMatchTypeReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeliveredMatchTypeReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeliveredMatchTypeReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DestinationUrlPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DestinationUrlPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DestinationUrlPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DestinationUrlPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DestinationUrlPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DestinationUrlPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceTypeReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "DeviceTypeReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.DeviceTypeReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GenderReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GenderReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GoalsAndFunnelsReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GoalsAndFunnelsReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GoalsAndFunnelsReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GoalsAndFunnelsReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "GoalsAndFunnelsReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.GoalsAndFunnelsReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordMigrationReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordMigrationReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordMigrationReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordMigrationReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "KeywordPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.KeywordPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LanguageAndRegionReportFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "LanguageAndRegionReportFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.LanguageAndRegionReportFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaDemographicReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MetroAreaDemographicReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaDemographicReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MetroAreaDemographicReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "MetroAreaDemographicReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.MetroAreaDemographicReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "NegativeKeywordConflictReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.NegativeKeywordConflictReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "NegativeKeywordConflictReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.NegativeKeywordConflictReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "NonHourlyReportAggregation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.NonHourlyReportAggregation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "OperationError");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.OperationError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherUsagePerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PublisherUsagePerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherUsagePerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PublisherUsagePerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "PublisherUsagePerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.PublisherUsagePerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportAggregation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ReportAggregation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportFormat");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ReportFormat.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportLanguage");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ReportLanguage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportRequestStatus");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ReportRequestStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportRequestStatusType");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ReportRequestStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportTime");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ReportTime.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "ReportTimePeriod");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.ReportTimePeriod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdComponentPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.RichAdComponentPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdComponentPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.RichAdComponentPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdComponentPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.RichAdComponentPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdSubTypeFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(simplelistsf);
            cachedDeserFactories.add(simplelistdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "RichAdSubTypeFilter>null");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.RichAdSubTypeFilterNull.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchCampaignChangeHistoryReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchCampaignChangeHistoryReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchCampaignChangeHistoryReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchCampaignChangeHistoryReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchCampaignChangeHistoryReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchCampaignChangeHistoryReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryPerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchQueryPerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryPerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchQueryPerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryPerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchQueryPerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SearchQueryReportAggregation");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SearchQueryReportAggregation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SegmentationReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SegmentationReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SegmentationReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SegmentationReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SegmentationReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SegmentationReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePerformanceReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SitePerformanceReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePerformanceReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SitePerformanceReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "SitePerformanceReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.SitePerformanceReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TacticChannelReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TacticChannelReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TacticChannelReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TacticChannelReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TacticChannelReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TacticChannelReportRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TrafficSourcesReportColumn");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TrafficSourcesReportColumn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TrafficSourcesReportFilter");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TrafficSourcesReportFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "TrafficSourcesReportRequest");
            cachedSerQNames.add(qName);
            cls = com.microsoft.adcenter.v8.TrafficSourcesReportRequest.class;
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

    public com.microsoft.adcenter.v8.SubmitGenerateReportResponse submitGenerateReport(com.microsoft.adcenter.v8.SubmitGenerateReportRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("SubmitGenerateReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "SubmitGenerateReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.SubmitGenerateReportResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.SubmitGenerateReportResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.SubmitGenerateReportResponse.class);
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

    public com.microsoft.adcenter.v8.PollGenerateReportResponse pollGenerateReport(com.microsoft.adcenter.v8.PollGenerateReportRequest parameters) throws java.rmi.RemoteException, com.microsoft.adapi.AdApiFaultDetail, com.microsoft.adcenter.v8.ApiFaultDetail {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("PollGenerateReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PollGenerateReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.microsoft.adcenter.v8.PollGenerateReportResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.microsoft.adcenter.v8.PollGenerateReportResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.microsoft.adcenter.v8.PollGenerateReportResponse.class);
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
