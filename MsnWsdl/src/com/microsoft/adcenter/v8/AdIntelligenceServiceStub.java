
/**
 * AdIntelligenceServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.microsoft.adcenter.v8;

        

        /*
        *  AdIntelligenceServiceStub java implementation
        */

        
        public class AdIntelligenceServiceStub extends org.apache.axis2.client.Stub
        implements AdIntelligenceService{
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized java.lang.String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("AdIntelligenceService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[14];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[3]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[4]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[5]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[6]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[7]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[8]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[9]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[10]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[11]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[12]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdIntelligenceService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[13]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalKeywordPerformance"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalKeywordPerformance"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalKeywordPerformance"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalKeywordPerformance"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalKeywordPerformance"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalKeywordPerformance"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordCategories"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordCategories"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordCategories"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordCategories"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordCategories"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordCategories"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalKeywordPerformanceByDevice"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalKeywordPerformanceByDevice"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalKeywordPerformanceByDevice"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalKeywordPerformanceByDevice"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalKeywordPerformanceByDevice"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalKeywordPerformanceByDevice"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordDemographics"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordDemographics"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordDemographics"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordDemographics"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordDemographics"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordDemographics"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordLocations"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordLocations"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKeywordLocations"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordLocations"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordLocations"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetKeywordLocations"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedBidByKeywordIds"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedBidByKeywordIds"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedBidByKeywordIds"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedBidByKeywordIds"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedBidByKeywordIds"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedBidByKeywordIds"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SuggestKeywordsForUrl"),"com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SuggestKeywordsForUrl"),"com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SuggestKeywordsForUrl"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SuggestKeywordsForUrl"),"com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SuggestKeywordsForUrl"),"com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SuggestKeywordsForUrl"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedBidByKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedBidByKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedBidByKeywords"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedBidByKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedBidByKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedBidByKeywords"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedPositionByKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedPositionByKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedPositionByKeywords"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedPositionByKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedPositionByKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedPositionByKeywords"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalSearchCount"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalSearchCount"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalSearchCount"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalSearchCount"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalSearchCount"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalSearchCount"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetPublisherKeywordPerformance"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetPublisherKeywordPerformance"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetPublisherKeywordPerformance"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetPublisherKeywordPerformance"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetPublisherKeywordPerformance"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetPublisherKeywordPerformance"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalSearchCountByDevice"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalSearchCountByDevice"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetHistoricalSearchCountByDevice"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalSearchCountByDevice"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalSearchCountByDevice"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetHistoricalSearchCountByDevice"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SuggestKeywordsFromExistingKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SuggestKeywordsFromExistingKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "SuggestKeywordsFromExistingKeywords"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SuggestKeywordsFromExistingKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SuggestKeywordsFromExistingKeywords"),"com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "SuggestKeywordsFromExistingKeywords"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedPositionByKeywordIds"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedPositionByKeywordIds"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetEstimatedPositionByKeywordIds"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedPositionByKeywordIds"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedPositionByKeywordIds"),"com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetEstimatedPositionByKeywordIds"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public AdIntelligenceServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public AdIntelligenceServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
        _service.applyPolicy();
        
	
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public AdIntelligenceServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"https://adcenterapi.microsoft.com/Api/Advertiser/V8/AdIntelligence/AdIntelligenceService.svc" );
                
    }

    /**
     * Default Constructor
     */
    public AdIntelligenceServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("https://adcenterapi.microsoft.com/Api/Advertiser/V8/AdIntelligence/AdIntelligenceService.svc" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public AdIntelligenceServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getHistoricalKeywordPerformance
                     * @param getHistoricalKeywordPerformanceRequest190
                    
                     * @param applicationToken191
                    
                     * @param customerAccountId192
                    
                     * @param customerId193
                    
                     * @param developerToken194
                    
                     * @param password195
                    
                     * @param userName196
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse getHistoricalKeywordPerformance(

                            com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest getHistoricalKeywordPerformanceRequest190,com.microsoft.adcenter.v8.ApplicationToken applicationToken191,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId192,com.microsoft.adcenter.v8.CustomerId customerId193,com.microsoft.adcenter.v8.DeveloperToken developerToken194,com.microsoft.adcenter.v8.Password password195,com.microsoft.adcenter.v8.UserName userName196)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("GetHistoricalKeywordPerformance");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricalKeywordPerformanceRequest190,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalKeywordPerformance")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalKeywordPerformance"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken191!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken191 = toOM(applicationToken191, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementapplicationToken191,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId192!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId192 = toOM(customerAccountId192, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementcustomerAccountId192,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId193!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId193 = toOM(customerId193, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementcustomerId193,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken194!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken194 = toOM(developerToken194, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementdeveloperToken194,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password195!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword195 = toOM(password195, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementpassword195,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName196!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName196 = toOM(userName196, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementuserName196,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformance"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformance"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformance"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetHistoricalKeywordPerformance
                    * @param getHistoricalKeywordPerformanceRequest190
                
                    * @param applicationToken191
                
                    * @param customerAccountId192
                
                    * @param customerId193
                
                    * @param developerToken194
                
                    * @param password195
                
                    * @param userName196
                
                */
                public  void startgetHistoricalKeywordPerformance(

                 com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest getHistoricalKeywordPerformanceRequest190,com.microsoft.adcenter.v8.ApplicationToken applicationToken191,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId192,
                    com.microsoft.adcenter.v8.CustomerId customerId193,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken194,
                    com.microsoft.adcenter.v8.Password password195,
                    com.microsoft.adcenter.v8.UserName userName196,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("GetHistoricalKeywordPerformance");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricalKeywordPerformanceRequest190,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalKeywordPerformance")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalKeywordPerformance"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken191!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken191 = toOM(applicationToken191, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementapplicationToken191,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId192!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId192 = toOM(customerAccountId192, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementcustomerAccountId192,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId193!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId193 = toOM(customerId193, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementcustomerId193,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken194!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken194 = toOM(developerToken194, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementdeveloperToken194,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password195!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword195 = toOM(password195, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementpassword195,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName196!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName196 = toOM(userName196, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformance")));
                                                    addHeader(omElementuserName196,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricalKeywordPerformance(
                                        (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricalKeywordPerformance(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformance"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformance"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformance"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetHistoricalKeywordPerformance((com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetHistoricalKeywordPerformance((com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformance_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetHistoricalKeywordPerformance(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformance(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformance(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformance(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformance(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformance(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformance(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformance(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricalKeywordPerformance(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricalKeywordPerformance(f);
									}
								} else {
								    callback.receiveErrorgetHistoricalKeywordPerformance(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricalKeywordPerformance(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getKeywordCategories
                     * @param getKeywordCategoriesRequest198
                    
                     * @param applicationToken199
                    
                     * @param customerAccountId200
                    
                     * @param customerId201
                    
                     * @param developerToken202
                    
                     * @param password203
                    
                     * @param userName204
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetKeywordCategoriesResponse getKeywordCategories(

                            com.microsoft.adcenter.v8.GetKeywordCategoriesRequest getKeywordCategoriesRequest198,com.microsoft.adcenter.v8.ApplicationToken applicationToken199,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId200,com.microsoft.adcenter.v8.CustomerId customerId201,com.microsoft.adcenter.v8.DeveloperToken developerToken202,com.microsoft.adcenter.v8.Password password203,com.microsoft.adcenter.v8.UserName userName204)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("GetKeywordCategories");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getKeywordCategoriesRequest198,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordCategories")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordCategories"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken199!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken199 = toOM(applicationToken199, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementapplicationToken199,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId200!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId200 = toOM(customerAccountId200, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementcustomerAccountId200,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId201!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId201 = toOM(customerId201, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementcustomerId201,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken202!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken202 = toOM(developerToken202, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementdeveloperToken202,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password203!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword203 = toOM(password203, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementpassword203,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName204!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName204 = toOM(userName204, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementuserName204,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetKeywordCategoriesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetKeywordCategoriesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordCategories"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordCategories"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordCategories"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetKeywordCategories
                    * @param getKeywordCategoriesRequest198
                
                    * @param applicationToken199
                
                    * @param customerAccountId200
                
                    * @param customerId201
                
                    * @param developerToken202
                
                    * @param password203
                
                    * @param userName204
                
                */
                public  void startgetKeywordCategories(

                 com.microsoft.adcenter.v8.GetKeywordCategoriesRequest getKeywordCategoriesRequest198,com.microsoft.adcenter.v8.ApplicationToken applicationToken199,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId200,
                    com.microsoft.adcenter.v8.CustomerId customerId201,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken202,
                    com.microsoft.adcenter.v8.Password password203,
                    com.microsoft.adcenter.v8.UserName userName204,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("GetKeywordCategories");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getKeywordCategoriesRequest198,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordCategories")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordCategories"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken199!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken199 = toOM(applicationToken199, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementapplicationToken199,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId200!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId200 = toOM(customerAccountId200, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementcustomerAccountId200,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId201!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId201 = toOM(customerId201, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementcustomerId201,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken202!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken202 = toOM(developerToken202, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementdeveloperToken202,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password203!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword203 = toOM(password203, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementpassword203,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName204!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName204 = toOM(userName204, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordCategories")));
                                                    addHeader(omElementuserName204,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetKeywordCategoriesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetKeywordCategories(
                                        (com.microsoft.adcenter.v8.GetKeywordCategoriesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetKeywordCategories(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordCategories"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordCategories"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordCategories"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetKeywordCategories((com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetKeywordCategories((com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordCategories_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetKeywordCategories(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordCategories(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordCategories(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordCategories(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordCategories(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordCategories(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordCategories(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordCategories(f);
                                            }
									    } else {
										    callback.receiveErrorgetKeywordCategories(f);
									    }
									} else {
									    callback.receiveErrorgetKeywordCategories(f);
									}
								} else {
								    callback.receiveErrorgetKeywordCategories(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetKeywordCategories(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getHistoricalKeywordPerformanceByDevice
                     * @param getHistoricalKeywordPerformanceByDeviceRequest206
                    
                     * @param applicationToken207
                    
                     * @param customerAccountId208
                    
                     * @param customerId209
                    
                     * @param developerToken210
                    
                     * @param password211
                    
                     * @param userName212
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse getHistoricalKeywordPerformanceByDevice(

                            com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest getHistoricalKeywordPerformanceByDeviceRequest206,com.microsoft.adcenter.v8.ApplicationToken applicationToken207,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId208,com.microsoft.adcenter.v8.CustomerId customerId209,com.microsoft.adcenter.v8.DeveloperToken developerToken210,com.microsoft.adcenter.v8.Password password211,com.microsoft.adcenter.v8.UserName userName212)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("GetHistoricalKeywordPerformanceByDevice");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricalKeywordPerformanceByDeviceRequest206,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalKeywordPerformanceByDevice")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalKeywordPerformanceByDevice"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken207!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken207 = toOM(applicationToken207, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementapplicationToken207,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId208!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId208 = toOM(customerAccountId208, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementcustomerAccountId208,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId209!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId209 = toOM(customerId209, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementcustomerId209,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken210!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken210 = toOM(developerToken210, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementdeveloperToken210,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password211!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword211 = toOM(password211, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementpassword211,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName212!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName212 = toOM(userName212, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementuserName212,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformanceByDevice"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformanceByDevice"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformanceByDevice"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetHistoricalKeywordPerformanceByDevice
                    * @param getHistoricalKeywordPerformanceByDeviceRequest206
                
                    * @param applicationToken207
                
                    * @param customerAccountId208
                
                    * @param customerId209
                
                    * @param developerToken210
                
                    * @param password211
                
                    * @param userName212
                
                */
                public  void startgetHistoricalKeywordPerformanceByDevice(

                 com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest getHistoricalKeywordPerformanceByDeviceRequest206,com.microsoft.adcenter.v8.ApplicationToken applicationToken207,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId208,
                    com.microsoft.adcenter.v8.CustomerId customerId209,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken210,
                    com.microsoft.adcenter.v8.Password password211,
                    com.microsoft.adcenter.v8.UserName userName212,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
             _operationClient.getOptions().setAction("GetHistoricalKeywordPerformanceByDevice");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricalKeywordPerformanceByDeviceRequest206,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalKeywordPerformanceByDevice")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalKeywordPerformanceByDevice"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken207!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken207 = toOM(applicationToken207, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementapplicationToken207,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId208!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId208 = toOM(customerAccountId208, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementcustomerAccountId208,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId209!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId209 = toOM(customerId209, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementcustomerId209,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken210!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken210 = toOM(developerToken210, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementdeveloperToken210,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password211!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword211 = toOM(password211, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementpassword211,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName212!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName212 = toOM(userName212, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalKeywordPerformanceByDevice")));
                                                    addHeader(omElementuserName212,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricalKeywordPerformanceByDevice(
                                        (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformanceByDevice"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformanceByDevice"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalKeywordPerformanceByDevice"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetHistoricalKeywordPerformanceByDevice((com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetHistoricalKeywordPerformanceByDevice((com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalKeywordPerformanceByDevice_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(f);
									}
								} else {
								    callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricalKeywordPerformanceByDevice(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[2].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[2].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getKeywordDemographics
                     * @param getKeywordDemographicsRequest214
                    
                     * @param applicationToken215
                    
                     * @param customerAccountId216
                    
                     * @param customerId217
                    
                     * @param developerToken218
                    
                     * @param password219
                    
                     * @param userName220
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetKeywordDemographicsResponse getKeywordDemographics(

                            com.microsoft.adcenter.v8.GetKeywordDemographicsRequest getKeywordDemographicsRequest214,com.microsoft.adcenter.v8.ApplicationToken applicationToken215,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId216,com.microsoft.adcenter.v8.CustomerId customerId217,com.microsoft.adcenter.v8.DeveloperToken developerToken218,com.microsoft.adcenter.v8.Password password219,com.microsoft.adcenter.v8.UserName userName220)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("GetKeywordDemographics");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getKeywordDemographicsRequest214,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordDemographics")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordDemographics"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken215!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken215 = toOM(applicationToken215, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementapplicationToken215,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId216!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId216 = toOM(customerAccountId216, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementcustomerAccountId216,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId217!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId217 = toOM(customerId217, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementcustomerId217,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken218!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken218 = toOM(developerToken218, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementdeveloperToken218,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password219!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword219 = toOM(password219, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementpassword219,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName220!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName220 = toOM(userName220, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementuserName220,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetKeywordDemographicsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetKeywordDemographicsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordDemographics"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordDemographics"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordDemographics"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetKeywordDemographics
                    * @param getKeywordDemographicsRequest214
                
                    * @param applicationToken215
                
                    * @param customerAccountId216
                
                    * @param customerId217
                
                    * @param developerToken218
                
                    * @param password219
                
                    * @param userName220
                
                */
                public  void startgetKeywordDemographics(

                 com.microsoft.adcenter.v8.GetKeywordDemographicsRequest getKeywordDemographicsRequest214,com.microsoft.adcenter.v8.ApplicationToken applicationToken215,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId216,
                    com.microsoft.adcenter.v8.CustomerId customerId217,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken218,
                    com.microsoft.adcenter.v8.Password password219,
                    com.microsoft.adcenter.v8.UserName userName220,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
             _operationClient.getOptions().setAction("GetKeywordDemographics");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getKeywordDemographicsRequest214,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordDemographics")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordDemographics"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken215!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken215 = toOM(applicationToken215, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementapplicationToken215,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId216!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId216 = toOM(customerAccountId216, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementcustomerAccountId216,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId217!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId217 = toOM(customerId217, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementcustomerId217,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken218!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken218 = toOM(developerToken218, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementdeveloperToken218,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password219!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword219 = toOM(password219, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementpassword219,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName220!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName220 = toOM(userName220, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordDemographics")));
                                                    addHeader(omElementuserName220,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetKeywordDemographicsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetKeywordDemographics(
                                        (com.microsoft.adcenter.v8.GetKeywordDemographicsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetKeywordDemographics(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordDemographics"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordDemographics"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordDemographics"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetKeywordDemographics((com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetKeywordDemographics((com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordDemographics_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetKeywordDemographics(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordDemographics(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordDemographics(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordDemographics(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordDemographics(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordDemographics(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordDemographics(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordDemographics(f);
                                            }
									    } else {
										    callback.receiveErrorgetKeywordDemographics(f);
									    }
									} else {
									    callback.receiveErrorgetKeywordDemographics(f);
									}
								} else {
								    callback.receiveErrorgetKeywordDemographics(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetKeywordDemographics(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[3].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[3].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getKeywordLocations
                     * @param getKeywordLocationsRequest222
                    
                     * @param applicationToken223
                    
                     * @param customerAccountId224
                    
                     * @param customerId225
                    
                     * @param developerToken226
                    
                     * @param password227
                    
                     * @param userName228
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetKeywordLocationsResponse getKeywordLocations(

                            com.microsoft.adcenter.v8.GetKeywordLocationsRequest getKeywordLocationsRequest222,com.microsoft.adcenter.v8.ApplicationToken applicationToken223,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId224,com.microsoft.adcenter.v8.CustomerId customerId225,com.microsoft.adcenter.v8.DeveloperToken developerToken226,com.microsoft.adcenter.v8.Password password227,com.microsoft.adcenter.v8.UserName userName228)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("GetKeywordLocations");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getKeywordLocationsRequest222,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordLocations")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordLocations"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken223!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken223 = toOM(applicationToken223, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementapplicationToken223,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId224!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId224 = toOM(customerAccountId224, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementcustomerAccountId224,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId225!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId225 = toOM(customerId225, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementcustomerId225,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken226!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken226 = toOM(developerToken226, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementdeveloperToken226,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password227!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword227 = toOM(password227, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementpassword227,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName228!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName228 = toOM(userName228, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementuserName228,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetKeywordLocationsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetKeywordLocationsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordLocations"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordLocations"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordLocations"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetKeywordLocations
                    * @param getKeywordLocationsRequest222
                
                    * @param applicationToken223
                
                    * @param customerAccountId224
                
                    * @param customerId225
                
                    * @param developerToken226
                
                    * @param password227
                
                    * @param userName228
                
                */
                public  void startgetKeywordLocations(

                 com.microsoft.adcenter.v8.GetKeywordLocationsRequest getKeywordLocationsRequest222,com.microsoft.adcenter.v8.ApplicationToken applicationToken223,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId224,
                    com.microsoft.adcenter.v8.CustomerId customerId225,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken226,
                    com.microsoft.adcenter.v8.Password password227,
                    com.microsoft.adcenter.v8.UserName userName228,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
             _operationClient.getOptions().setAction("GetKeywordLocations");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getKeywordLocationsRequest222,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordLocations")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getKeywordLocations"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken223!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken223 = toOM(applicationToken223, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementapplicationToken223,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId224!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId224 = toOM(customerAccountId224, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementcustomerAccountId224,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId225!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId225 = toOM(customerId225, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementcustomerId225,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken226!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken226 = toOM(developerToken226, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementdeveloperToken226,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password227!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword227 = toOM(password227, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementpassword227,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName228!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName228 = toOM(userName228, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getKeywordLocations")));
                                                    addHeader(omElementuserName228,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetKeywordLocationsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetKeywordLocations(
                                        (com.microsoft.adcenter.v8.GetKeywordLocationsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetKeywordLocations(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordLocations"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordLocations"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKeywordLocations"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetKeywordLocations((com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetKeywordLocations((com.microsoft.adcenter.v8.IAdIntelligenceService_GetKeywordLocations_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetKeywordLocations(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordLocations(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordLocations(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordLocations(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordLocations(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordLocations(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordLocations(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKeywordLocations(f);
                                            }
									    } else {
										    callback.receiveErrorgetKeywordLocations(f);
									    }
									} else {
									    callback.receiveErrorgetKeywordLocations(f);
									}
								} else {
								    callback.receiveErrorgetKeywordLocations(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetKeywordLocations(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[4].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[4].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getEstimatedBidByKeywordIds
                     * @param getEstimatedBidByKeywordIdsRequest230
                    
                     * @param applicationToken231
                    
                     * @param customerAccountId232
                    
                     * @param customerId233
                    
                     * @param developerToken234
                    
                     * @param password235
                    
                     * @param userName236
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse getEstimatedBidByKeywordIds(

                            com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest getEstimatedBidByKeywordIdsRequest230,com.microsoft.adcenter.v8.ApplicationToken applicationToken231,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId232,com.microsoft.adcenter.v8.CustomerId customerId233,com.microsoft.adcenter.v8.DeveloperToken developerToken234,com.microsoft.adcenter.v8.Password password235,com.microsoft.adcenter.v8.UserName userName236)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("GetEstimatedBidByKeywordIds");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getEstimatedBidByKeywordIdsRequest230,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedBidByKeywordIds")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedBidByKeywordIds"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken231!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken231 = toOM(applicationToken231, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementapplicationToken231,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId232!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId232 = toOM(customerAccountId232, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementcustomerAccountId232,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId233!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId233 = toOM(customerId233, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementcustomerId233,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken234!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken234 = toOM(developerToken234, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementdeveloperToken234,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password235!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword235 = toOM(password235, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementpassword235,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName236!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName236 = toOM(userName236, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementuserName236,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywordIds"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywordIds"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywordIds"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetEstimatedBidByKeywordIds
                    * @param getEstimatedBidByKeywordIdsRequest230
                
                    * @param applicationToken231
                
                    * @param customerAccountId232
                
                    * @param customerId233
                
                    * @param developerToken234
                
                    * @param password235
                
                    * @param userName236
                
                */
                public  void startgetEstimatedBidByKeywordIds(

                 com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest getEstimatedBidByKeywordIdsRequest230,com.microsoft.adcenter.v8.ApplicationToken applicationToken231,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId232,
                    com.microsoft.adcenter.v8.CustomerId customerId233,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken234,
                    com.microsoft.adcenter.v8.Password password235,
                    com.microsoft.adcenter.v8.UserName userName236,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
             _operationClient.getOptions().setAction("GetEstimatedBidByKeywordIds");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getEstimatedBidByKeywordIdsRequest230,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedBidByKeywordIds")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedBidByKeywordIds"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken231!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken231 = toOM(applicationToken231, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementapplicationToken231,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId232!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId232 = toOM(customerAccountId232, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementcustomerAccountId232,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId233!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId233 = toOM(customerId233, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementcustomerId233,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken234!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken234 = toOM(developerToken234, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementdeveloperToken234,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password235!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword235 = toOM(password235, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementpassword235,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName236!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName236 = toOM(userName236, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywordIds")));
                                                    addHeader(omElementuserName236,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetEstimatedBidByKeywordIds(
                                        (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetEstimatedBidByKeywordIds(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywordIds"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywordIds"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywordIds"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetEstimatedBidByKeywordIds((com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetEstimatedBidByKeywordIds((com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywordIds_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetEstimatedBidByKeywordIds(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywordIds(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywordIds(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywordIds(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywordIds(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywordIds(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywordIds(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywordIds(f);
                                            }
									    } else {
										    callback.receiveErrorgetEstimatedBidByKeywordIds(f);
									    }
									} else {
									    callback.receiveErrorgetEstimatedBidByKeywordIds(f);
									}
								} else {
								    callback.receiveErrorgetEstimatedBidByKeywordIds(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetEstimatedBidByKeywordIds(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[5].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[5].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#suggestKeywordsForUrl
                     * @param suggestKeywordsForUrlRequest238
                    
                     * @param applicationToken239
                    
                     * @param customerAccountId240
                    
                     * @param customerId241
                    
                     * @param developerToken242
                    
                     * @param password243
                    
                     * @param userName244
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse suggestKeywordsForUrl(

                            com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest suggestKeywordsForUrlRequest238,com.microsoft.adcenter.v8.ApplicationToken applicationToken239,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId240,com.microsoft.adcenter.v8.CustomerId customerId241,com.microsoft.adcenter.v8.DeveloperToken developerToken242,com.microsoft.adcenter.v8.Password password243,com.microsoft.adcenter.v8.UserName userName244)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
              _operationClient.getOptions().setAction("SuggestKeywordsForUrl");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    suggestKeywordsForUrlRequest238,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "suggestKeywordsForUrl")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "suggestKeywordsForUrl"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken239!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken239 = toOM(applicationToken239, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementapplicationToken239,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId240!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId240 = toOM(customerAccountId240, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementcustomerAccountId240,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId241!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId241 = toOM(customerId241, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementcustomerId241,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken242!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken242 = toOM(developerToken242, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementdeveloperToken242,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password243!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword243 = toOM(password243, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementpassword243,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName244!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName244 = toOM(userName244, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementuserName244,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsForUrl"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsForUrl"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsForUrl"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startsuggestKeywordsForUrl
                    * @param suggestKeywordsForUrlRequest238
                
                    * @param applicationToken239
                
                    * @param customerAccountId240
                
                    * @param customerId241
                
                    * @param developerToken242
                
                    * @param password243
                
                    * @param userName244
                
                */
                public  void startsuggestKeywordsForUrl(

                 com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest suggestKeywordsForUrlRequest238,com.microsoft.adcenter.v8.ApplicationToken applicationToken239,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId240,
                    com.microsoft.adcenter.v8.CustomerId customerId241,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken242,
                    com.microsoft.adcenter.v8.Password password243,
                    com.microsoft.adcenter.v8.UserName userName244,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
             _operationClient.getOptions().setAction("SuggestKeywordsForUrl");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    suggestKeywordsForUrlRequest238,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "suggestKeywordsForUrl")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "suggestKeywordsForUrl"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken239!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken239 = toOM(applicationToken239, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementapplicationToken239,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId240!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId240 = toOM(customerAccountId240, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementcustomerAccountId240,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId241!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId241 = toOM(customerId241, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementcustomerId241,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken242!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken242 = toOM(developerToken242, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementdeveloperToken242,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password243!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword243 = toOM(password243, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementpassword243,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName244!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName244 = toOM(userName244, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsForUrl")));
                                                    addHeader(omElementuserName244,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultsuggestKeywordsForUrl(
                                        (com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorsuggestKeywordsForUrl(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsForUrl"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsForUrl"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsForUrl"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorsuggestKeywordsForUrl((com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorsuggestKeywordsForUrl((com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsForUrl_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorsuggestKeywordsForUrl(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsForUrl(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsForUrl(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsForUrl(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsForUrl(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsForUrl(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsForUrl(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsForUrl(f);
                                            }
									    } else {
										    callback.receiveErrorsuggestKeywordsForUrl(f);
									    }
									} else {
									    callback.receiveErrorsuggestKeywordsForUrl(f);
									}
								} else {
								    callback.receiveErrorsuggestKeywordsForUrl(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorsuggestKeywordsForUrl(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[6].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[6].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getEstimatedBidByKeywords
                     * @param getEstimatedBidByKeywordsRequest246
                    
                     * @param applicationToken247
                    
                     * @param customerAccountId248
                    
                     * @param customerId249
                    
                     * @param developerToken250
                    
                     * @param password251
                    
                     * @param userName252
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse getEstimatedBidByKeywords(

                            com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest getEstimatedBidByKeywordsRequest246,com.microsoft.adcenter.v8.ApplicationToken applicationToken247,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId248,com.microsoft.adcenter.v8.CustomerId customerId249,com.microsoft.adcenter.v8.DeveloperToken developerToken250,com.microsoft.adcenter.v8.Password password251,com.microsoft.adcenter.v8.UserName userName252)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
              _operationClient.getOptions().setAction("GetEstimatedBidByKeywords");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getEstimatedBidByKeywordsRequest246,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedBidByKeywords")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedBidByKeywords"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken247!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken247 = toOM(applicationToken247, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementapplicationToken247,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId248!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId248 = toOM(customerAccountId248, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementcustomerAccountId248,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId249!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId249 = toOM(customerId249, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementcustomerId249,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken250!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken250 = toOM(developerToken250, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementdeveloperToken250,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password251!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword251 = toOM(password251, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementpassword251,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName252!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName252 = toOM(userName252, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementuserName252,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywords"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywords"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywords"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetEstimatedBidByKeywords
                    * @param getEstimatedBidByKeywordsRequest246
                
                    * @param applicationToken247
                
                    * @param customerAccountId248
                
                    * @param customerId249
                
                    * @param developerToken250
                
                    * @param password251
                
                    * @param userName252
                
                */
                public  void startgetEstimatedBidByKeywords(

                 com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest getEstimatedBidByKeywordsRequest246,com.microsoft.adcenter.v8.ApplicationToken applicationToken247,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId248,
                    com.microsoft.adcenter.v8.CustomerId customerId249,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken250,
                    com.microsoft.adcenter.v8.Password password251,
                    com.microsoft.adcenter.v8.UserName userName252,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
             _operationClient.getOptions().setAction("GetEstimatedBidByKeywords");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getEstimatedBidByKeywordsRequest246,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedBidByKeywords")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedBidByKeywords"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken247!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken247 = toOM(applicationToken247, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementapplicationToken247,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId248!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId248 = toOM(customerAccountId248, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementcustomerAccountId248,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId249!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId249 = toOM(customerId249, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementcustomerId249,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken250!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken250 = toOM(developerToken250, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementdeveloperToken250,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password251!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword251 = toOM(password251, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementpassword251,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName252!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName252 = toOM(userName252, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedBidByKeywords")));
                                                    addHeader(omElementuserName252,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetEstimatedBidByKeywords(
                                        (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetEstimatedBidByKeywords(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywords"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywords"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedBidByKeywords"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetEstimatedBidByKeywords((com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetEstimatedBidByKeywords((com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedBidByKeywords_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetEstimatedBidByKeywords(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywords(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywords(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywords(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywords(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywords(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywords(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedBidByKeywords(f);
                                            }
									    } else {
										    callback.receiveErrorgetEstimatedBidByKeywords(f);
									    }
									} else {
									    callback.receiveErrorgetEstimatedBidByKeywords(f);
									}
								} else {
								    callback.receiveErrorgetEstimatedBidByKeywords(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetEstimatedBidByKeywords(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[7].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[7].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getEstimatedPositionByKeywords
                     * @param getEstimatedPositionByKeywordsRequest254
                    
                     * @param applicationToken255
                    
                     * @param customerAccountId256
                    
                     * @param customerId257
                    
                     * @param developerToken258
                    
                     * @param password259
                    
                     * @param userName260
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse getEstimatedPositionByKeywords(

                            com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest getEstimatedPositionByKeywordsRequest254,com.microsoft.adcenter.v8.ApplicationToken applicationToken255,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId256,com.microsoft.adcenter.v8.CustomerId customerId257,com.microsoft.adcenter.v8.DeveloperToken developerToken258,com.microsoft.adcenter.v8.Password password259,com.microsoft.adcenter.v8.UserName userName260)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
              _operationClient.getOptions().setAction("GetEstimatedPositionByKeywords");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getEstimatedPositionByKeywordsRequest254,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedPositionByKeywords")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedPositionByKeywords"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken255!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken255 = toOM(applicationToken255, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementapplicationToken255,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId256!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId256 = toOM(customerAccountId256, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementcustomerAccountId256,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId257!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId257 = toOM(customerId257, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementcustomerId257,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken258!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken258 = toOM(developerToken258, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementdeveloperToken258,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password259!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword259 = toOM(password259, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementpassword259,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName260!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName260 = toOM(userName260, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementuserName260,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywords"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywords"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywords"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetEstimatedPositionByKeywords
                    * @param getEstimatedPositionByKeywordsRequest254
                
                    * @param applicationToken255
                
                    * @param customerAccountId256
                
                    * @param customerId257
                
                    * @param developerToken258
                
                    * @param password259
                
                    * @param userName260
                
                */
                public  void startgetEstimatedPositionByKeywords(

                 com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest getEstimatedPositionByKeywordsRequest254,com.microsoft.adcenter.v8.ApplicationToken applicationToken255,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId256,
                    com.microsoft.adcenter.v8.CustomerId customerId257,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken258,
                    com.microsoft.adcenter.v8.Password password259,
                    com.microsoft.adcenter.v8.UserName userName260,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
             _operationClient.getOptions().setAction("GetEstimatedPositionByKeywords");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getEstimatedPositionByKeywordsRequest254,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedPositionByKeywords")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedPositionByKeywords"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken255!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken255 = toOM(applicationToken255, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementapplicationToken255,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId256!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId256 = toOM(customerAccountId256, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementcustomerAccountId256,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId257!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId257 = toOM(customerId257, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementcustomerId257,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken258!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken258 = toOM(developerToken258, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementdeveloperToken258,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password259!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword259 = toOM(password259, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementpassword259,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName260!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName260 = toOM(userName260, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywords")));
                                                    addHeader(omElementuserName260,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetEstimatedPositionByKeywords(
                                        (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetEstimatedPositionByKeywords(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywords"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywords"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywords"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetEstimatedPositionByKeywords((com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetEstimatedPositionByKeywords((com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywords_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetEstimatedPositionByKeywords(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywords(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywords(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywords(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywords(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywords(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywords(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywords(f);
                                            }
									    } else {
										    callback.receiveErrorgetEstimatedPositionByKeywords(f);
									    }
									} else {
									    callback.receiveErrorgetEstimatedPositionByKeywords(f);
									}
								} else {
								    callback.receiveErrorgetEstimatedPositionByKeywords(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetEstimatedPositionByKeywords(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[8].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[8].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getHistoricalSearchCount
                     * @param getHistoricalSearchCountRequest262
                    
                     * @param applicationToken263
                    
                     * @param customerAccountId264
                    
                     * @param customerId265
                    
                     * @param developerToken266
                    
                     * @param password267
                    
                     * @param userName268
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse getHistoricalSearchCount(

                            com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest getHistoricalSearchCountRequest262,com.microsoft.adcenter.v8.ApplicationToken applicationToken263,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId264,com.microsoft.adcenter.v8.CustomerId customerId265,com.microsoft.adcenter.v8.DeveloperToken developerToken266,com.microsoft.adcenter.v8.Password password267,com.microsoft.adcenter.v8.UserName userName268)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[9].getName());
              _operationClient.getOptions().setAction("GetHistoricalSearchCount");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricalSearchCountRequest262,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalSearchCount")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalSearchCount"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken263!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken263 = toOM(applicationToken263, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementapplicationToken263,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId264!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId264 = toOM(customerAccountId264, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementcustomerAccountId264,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId265!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId265 = toOM(customerId265, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementcustomerId265,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken266!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken266 = toOM(developerToken266, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementdeveloperToken266,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password267!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword267 = toOM(password267, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementpassword267,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName268!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName268 = toOM(userName268, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementuserName268,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCount"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCount"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCount"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetHistoricalSearchCount
                    * @param getHistoricalSearchCountRequest262
                
                    * @param applicationToken263
                
                    * @param customerAccountId264
                
                    * @param customerId265
                
                    * @param developerToken266
                
                    * @param password267
                
                    * @param userName268
                
                */
                public  void startgetHistoricalSearchCount(

                 com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest getHistoricalSearchCountRequest262,com.microsoft.adcenter.v8.ApplicationToken applicationToken263,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId264,
                    com.microsoft.adcenter.v8.CustomerId customerId265,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken266,
                    com.microsoft.adcenter.v8.Password password267,
                    com.microsoft.adcenter.v8.UserName userName268,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[9].getName());
             _operationClient.getOptions().setAction("GetHistoricalSearchCount");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricalSearchCountRequest262,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalSearchCount")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalSearchCount"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken263!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken263 = toOM(applicationToken263, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementapplicationToken263,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId264!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId264 = toOM(customerAccountId264, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementcustomerAccountId264,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId265!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId265 = toOM(customerId265, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementcustomerId265,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken266!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken266 = toOM(developerToken266, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementdeveloperToken266,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password267!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword267 = toOM(password267, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementpassword267,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName268!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName268 = toOM(userName268, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCount")));
                                                    addHeader(omElementuserName268,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricalSearchCount(
                                        (com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricalSearchCount(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCount"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCount"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCount"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetHistoricalSearchCount((com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetHistoricalSearchCount((com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCount_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetHistoricalSearchCount(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCount(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCount(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCount(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCount(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCount(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCount(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCount(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricalSearchCount(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricalSearchCount(f);
									}
								} else {
								    callback.receiveErrorgetHistoricalSearchCount(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricalSearchCount(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[9].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[9].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getPublisherKeywordPerformance
                     * @param getPublisherKeywordPerformanceRequest270
                    
                     * @param applicationToken271
                    
                     * @param customerAccountId272
                    
                     * @param customerId273
                    
                     * @param developerToken274
                    
                     * @param password275
                    
                     * @param userName276
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse getPublisherKeywordPerformance(

                            com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest getPublisherKeywordPerformanceRequest270,com.microsoft.adcenter.v8.ApplicationToken applicationToken271,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId272,com.microsoft.adcenter.v8.CustomerId customerId273,com.microsoft.adcenter.v8.DeveloperToken developerToken274,com.microsoft.adcenter.v8.Password password275,com.microsoft.adcenter.v8.UserName userName276)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[10].getName());
              _operationClient.getOptions().setAction("GetPublisherKeywordPerformance");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getPublisherKeywordPerformanceRequest270,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getPublisherKeywordPerformance")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getPublisherKeywordPerformance"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken271!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken271 = toOM(applicationToken271, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementapplicationToken271,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId272!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId272 = toOM(customerAccountId272, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementcustomerAccountId272,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId273!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId273 = toOM(customerId273, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementcustomerId273,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken274!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken274 = toOM(developerToken274, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementdeveloperToken274,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password275!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword275 = toOM(password275, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementpassword275,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName276!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName276 = toOM(userName276, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementuserName276,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetPublisherKeywordPerformance"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetPublisherKeywordPerformance"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetPublisherKeywordPerformance"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetPublisherKeywordPerformance
                    * @param getPublisherKeywordPerformanceRequest270
                
                    * @param applicationToken271
                
                    * @param customerAccountId272
                
                    * @param customerId273
                
                    * @param developerToken274
                
                    * @param password275
                
                    * @param userName276
                
                */
                public  void startgetPublisherKeywordPerformance(

                 com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest getPublisherKeywordPerformanceRequest270,com.microsoft.adcenter.v8.ApplicationToken applicationToken271,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId272,
                    com.microsoft.adcenter.v8.CustomerId customerId273,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken274,
                    com.microsoft.adcenter.v8.Password password275,
                    com.microsoft.adcenter.v8.UserName userName276,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[10].getName());
             _operationClient.getOptions().setAction("GetPublisherKeywordPerformance");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getPublisherKeywordPerformanceRequest270,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getPublisherKeywordPerformance")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getPublisherKeywordPerformance"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken271!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken271 = toOM(applicationToken271, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementapplicationToken271,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId272!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId272 = toOM(customerAccountId272, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementcustomerAccountId272,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId273!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId273 = toOM(customerId273, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementcustomerId273,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken274!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken274 = toOM(developerToken274, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementdeveloperToken274,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password275!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword275 = toOM(password275, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementpassword275,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName276!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName276 = toOM(userName276, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getPublisherKeywordPerformance")));
                                                    addHeader(omElementuserName276,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetPublisherKeywordPerformance(
                                        (com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetPublisherKeywordPerformance(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetPublisherKeywordPerformance"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetPublisherKeywordPerformance"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetPublisherKeywordPerformance"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetPublisherKeywordPerformance((com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetPublisherKeywordPerformance((com.microsoft.adcenter.v8.IAdIntelligenceService_GetPublisherKeywordPerformance_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetPublisherKeywordPerformance(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPublisherKeywordPerformance(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPublisherKeywordPerformance(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPublisherKeywordPerformance(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPublisherKeywordPerformance(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPublisherKeywordPerformance(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPublisherKeywordPerformance(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetPublisherKeywordPerformance(f);
                                            }
									    } else {
										    callback.receiveErrorgetPublisherKeywordPerformance(f);
									    }
									} else {
									    callback.receiveErrorgetPublisherKeywordPerformance(f);
									}
								} else {
								    callback.receiveErrorgetPublisherKeywordPerformance(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetPublisherKeywordPerformance(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[10].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[10].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getHistoricalSearchCountByDevice
                     * @param getHistoricalSearchCountByDeviceRequest278
                    
                     * @param applicationToken279
                    
                     * @param customerAccountId280
                    
                     * @param customerId281
                    
                     * @param developerToken282
                    
                     * @param password283
                    
                     * @param userName284
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse getHistoricalSearchCountByDevice(

                            com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest getHistoricalSearchCountByDeviceRequest278,com.microsoft.adcenter.v8.ApplicationToken applicationToken279,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId280,com.microsoft.adcenter.v8.CustomerId customerId281,com.microsoft.adcenter.v8.DeveloperToken developerToken282,com.microsoft.adcenter.v8.Password password283,com.microsoft.adcenter.v8.UserName userName284)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[11].getName());
              _operationClient.getOptions().setAction("GetHistoricalSearchCountByDevice");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricalSearchCountByDeviceRequest278,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalSearchCountByDevice")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalSearchCountByDevice"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken279!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken279 = toOM(applicationToken279, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementapplicationToken279,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId280!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId280 = toOM(customerAccountId280, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementcustomerAccountId280,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId281!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId281 = toOM(customerId281, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementcustomerId281,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken282!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken282 = toOM(developerToken282, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementdeveloperToken282,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password283!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword283 = toOM(password283, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementpassword283,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName284!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName284 = toOM(userName284, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementuserName284,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCountByDevice"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCountByDevice"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCountByDevice"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetHistoricalSearchCountByDevice
                    * @param getHistoricalSearchCountByDeviceRequest278
                
                    * @param applicationToken279
                
                    * @param customerAccountId280
                
                    * @param customerId281
                
                    * @param developerToken282
                
                    * @param password283
                
                    * @param userName284
                
                */
                public  void startgetHistoricalSearchCountByDevice(

                 com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest getHistoricalSearchCountByDeviceRequest278,com.microsoft.adcenter.v8.ApplicationToken applicationToken279,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId280,
                    com.microsoft.adcenter.v8.CustomerId customerId281,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken282,
                    com.microsoft.adcenter.v8.Password password283,
                    com.microsoft.adcenter.v8.UserName userName284,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[11].getName());
             _operationClient.getOptions().setAction("GetHistoricalSearchCountByDevice");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getHistoricalSearchCountByDeviceRequest278,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalSearchCountByDevice")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getHistoricalSearchCountByDevice"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken279!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken279 = toOM(applicationToken279, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementapplicationToken279,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId280!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId280 = toOM(customerAccountId280, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementcustomerAccountId280,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId281!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId281 = toOM(customerId281, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementcustomerId281,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken282!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken282 = toOM(developerToken282, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementdeveloperToken282,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password283!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword283 = toOM(password283, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementpassword283,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName284!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName284 = toOM(userName284, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getHistoricalSearchCountByDevice")));
                                                    addHeader(omElementuserName284,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetHistoricalSearchCountByDevice(
                                        (com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetHistoricalSearchCountByDevice(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCountByDevice"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCountByDevice"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetHistoricalSearchCountByDevice"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetHistoricalSearchCountByDevice((com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetHistoricalSearchCountByDevice((com.microsoft.adcenter.v8.IAdIntelligenceService_GetHistoricalSearchCountByDevice_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetHistoricalSearchCountByDevice(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCountByDevice(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCountByDevice(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCountByDevice(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCountByDevice(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCountByDevice(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCountByDevice(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetHistoricalSearchCountByDevice(f);
                                            }
									    } else {
										    callback.receiveErrorgetHistoricalSearchCountByDevice(f);
									    }
									} else {
									    callback.receiveErrorgetHistoricalSearchCountByDevice(f);
									}
								} else {
								    callback.receiveErrorgetHistoricalSearchCountByDevice(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetHistoricalSearchCountByDevice(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[11].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[11].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#suggestKeywordsFromExistingKeywords
                     * @param suggestKeywordsFromExistingKeywordsRequest286
                    
                     * @param applicationToken287
                    
                     * @param customerAccountId288
                    
                     * @param customerId289
                    
                     * @param developerToken290
                    
                     * @param password291
                    
                     * @param userName292
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse suggestKeywordsFromExistingKeywords(

                            com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest suggestKeywordsFromExistingKeywordsRequest286,com.microsoft.adcenter.v8.ApplicationToken applicationToken287,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId288,com.microsoft.adcenter.v8.CustomerId customerId289,com.microsoft.adcenter.v8.DeveloperToken developerToken290,com.microsoft.adcenter.v8.Password password291,com.microsoft.adcenter.v8.UserName userName292)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[12].getName());
              _operationClient.getOptions().setAction("SuggestKeywordsFromExistingKeywords");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    suggestKeywordsFromExistingKeywordsRequest286,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "suggestKeywordsFromExistingKeywords")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "suggestKeywordsFromExistingKeywords"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken287!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken287 = toOM(applicationToken287, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementapplicationToken287,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId288!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId288 = toOM(customerAccountId288, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementcustomerAccountId288,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId289!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId289 = toOM(customerId289, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementcustomerId289,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken290!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken290 = toOM(developerToken290, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementdeveloperToken290,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password291!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword291 = toOM(password291, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementpassword291,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName292!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName292 = toOM(userName292, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementuserName292,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsFromExistingKeywords"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsFromExistingKeywords"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsFromExistingKeywords"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startsuggestKeywordsFromExistingKeywords
                    * @param suggestKeywordsFromExistingKeywordsRequest286
                
                    * @param applicationToken287
                
                    * @param customerAccountId288
                
                    * @param customerId289
                
                    * @param developerToken290
                
                    * @param password291
                
                    * @param userName292
                
                */
                public  void startsuggestKeywordsFromExistingKeywords(

                 com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest suggestKeywordsFromExistingKeywordsRequest286,com.microsoft.adcenter.v8.ApplicationToken applicationToken287,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId288,
                    com.microsoft.adcenter.v8.CustomerId customerId289,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken290,
                    com.microsoft.adcenter.v8.Password password291,
                    com.microsoft.adcenter.v8.UserName userName292,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[12].getName());
             _operationClient.getOptions().setAction("SuggestKeywordsFromExistingKeywords");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    suggestKeywordsFromExistingKeywordsRequest286,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "suggestKeywordsFromExistingKeywords")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "suggestKeywordsFromExistingKeywords"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken287!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken287 = toOM(applicationToken287, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementapplicationToken287,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId288!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId288 = toOM(customerAccountId288, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementcustomerAccountId288,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId289!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId289 = toOM(customerId289, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementcustomerId289,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken290!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken290 = toOM(developerToken290, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementdeveloperToken290,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password291!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword291 = toOM(password291, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementpassword291,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName292!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName292 = toOM(userName292, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "suggestKeywordsFromExistingKeywords")));
                                                    addHeader(omElementuserName292,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultsuggestKeywordsFromExistingKeywords(
                                        (com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorsuggestKeywordsFromExistingKeywords(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsFromExistingKeywords"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsFromExistingKeywords"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"SuggestKeywordsFromExistingKeywords"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorsuggestKeywordsFromExistingKeywords((com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorsuggestKeywordsFromExistingKeywords((com.microsoft.adcenter.v8.IAdIntelligenceService_SuggestKeywordsFromExistingKeywords_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorsuggestKeywordsFromExistingKeywords(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
                                            }
									    } else {
										    callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
									    }
									} else {
									    callback.receiveErrorsuggestKeywordsFromExistingKeywords(f);
									}
								} else {
								    callback.receiveErrorsuggestKeywordsFromExistingKeywords(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorsuggestKeywordsFromExistingKeywords(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[12].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[12].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdIntelligenceService#getEstimatedPositionByKeywordIds
                     * @param getEstimatedPositionByKeywordIdsRequest294
                    
                     * @param applicationToken295
                    
                     * @param customerAccountId296
                    
                     * @param customerId297
                    
                     * @param developerToken298
                    
                     * @param password299
                    
                     * @param userName300
                    
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse getEstimatedPositionByKeywordIds(

                            com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest getEstimatedPositionByKeywordIdsRequest294,com.microsoft.adcenter.v8.ApplicationToken applicationToken295,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId296,com.microsoft.adcenter.v8.CustomerId customerId297,com.microsoft.adcenter.v8.DeveloperToken developerToken298,com.microsoft.adcenter.v8.Password password299,com.microsoft.adcenter.v8.UserName userName300)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[13].getName());
              _operationClient.getOptions().setAction("GetEstimatedPositionByKeywordIds");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getEstimatedPositionByKeywordIdsRequest294,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedPositionByKeywordIds")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedPositionByKeywordIds"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken295!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken295 = toOM(applicationToken295, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementapplicationToken295,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId296!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId296 = toOM(customerAccountId296, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementcustomerAccountId296,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId297!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId297 = toOM(customerId297, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementcustomerId297,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken298!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken298 = toOM(developerToken298, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementdeveloperToken298,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password299!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword299 = toOM(password299, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementpassword299,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName300!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName300 = toOM(userName300, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementuserName300,env);
                                                
                                        }
                                    
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywordIds"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywordIds"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywordIds"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage)ex;
                        }
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see com.microsoft.adcenter.v8.AdIntelligenceService#startgetEstimatedPositionByKeywordIds
                    * @param getEstimatedPositionByKeywordIdsRequest294
                
                    * @param applicationToken295
                
                    * @param customerAccountId296
                
                    * @param customerId297
                
                    * @param developerToken298
                
                    * @param password299
                
                    * @param userName300
                
                */
                public  void startgetEstimatedPositionByKeywordIds(

                 com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest getEstimatedPositionByKeywordIdsRequest294,com.microsoft.adcenter.v8.ApplicationToken applicationToken295,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId296,
                    com.microsoft.adcenter.v8.CustomerId customerId297,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken298,
                    com.microsoft.adcenter.v8.Password password299,
                    com.microsoft.adcenter.v8.UserName userName300,
                    

                  final com.microsoft.adcenter.v8.AdIntelligenceServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[13].getName());
             _operationClient.getOptions().setAction("GetEstimatedPositionByKeywordIds");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getEstimatedPositionByKeywordIdsRequest294,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedPositionByKeywordIds")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getEstimatedPositionByKeywordIds"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken295!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken295 = toOM(applicationToken295, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementapplicationToken295,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId296!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId296 = toOM(customerAccountId296, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementcustomerAccountId296,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId297!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId297 = toOM(customerId297, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementcustomerId297,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken298!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken298 = toOM(developerToken298, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementdeveloperToken298,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password299!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword299 = toOM(password299, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementpassword299,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName300!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName300 = toOM(userName300, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getEstimatedPositionByKeywordIds")));
                                                    addHeader(omElementuserName300,env);
                                                
                                        }
                                    
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetEstimatedPositionByKeywordIds(
                                        (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetEstimatedPositionByKeywordIds(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywordIds"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywordIds"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetEstimatedPositionByKeywordIds"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetEstimatedPositionByKeywordIds((com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetEstimatedPositionByKeywordIds((com.microsoft.adcenter.v8.IAdIntelligenceService_GetEstimatedPositionByKeywordIds_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetEstimatedPositionByKeywordIds(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
                                            }
									    } else {
										    callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
									    }
									} else {
									    callback.receiveErrorgetEstimatedPositionByKeywordIds(f);
									}
								} else {
								    callback.receiveErrorgetEstimatedPositionByKeywordIds(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorgetEstimatedPositionByKeywordIds(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[13].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[13].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    ////////////////////////////////////////////////////////////////////////
    
    private static org.apache.neethi.Policy getPolicy (java.lang.String policyString) {
    	return org.apache.neethi.PolicyEngine.getPolicy(org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(
    	        new java.io.StringReader(policyString)).getDocument().getXMLStreamReader(false));
    }
    
    /////////////////////////////////////////////////////////////////////////

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //https://adcenterapi.microsoft.com/Api/Advertiser/V8/AdIntelligence/AdIntelligenceService.svc
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adapi.AdApiFaultDetailE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adapi.AdApiFaultDetailE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.ApiFaultDetailE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.ApiFaultDetailE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.ApplicationToken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.ApplicationToken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.CustomerAccountId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.CustomerAccountId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.CustomerId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.CustomerId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.DeveloperToken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.DeveloperToken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.Password param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.Password.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.UserName param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.UserName.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.TrackingId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.TrackingId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetKeywordCategoriesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetKeywordCategoriesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetKeywordCategoriesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetKeywordCategoriesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetKeywordDemographicsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetKeywordDemographicsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetKeywordDemographicsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetKeywordDemographicsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetKeywordLocationsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetKeywordLocationsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetKeywordLocationsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetKeywordLocationsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetKeywordCategoriesRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetKeywordCategoriesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetKeywordDemographicsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetKeywordDemographicsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetKeywordLocationsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetKeywordLocationsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetKeywordCategoriesRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetKeywordCategoriesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetKeywordCategoriesResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetKeywordCategoriesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetHistoricalKeywordPerformanceByDeviceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetKeywordDemographicsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetKeywordDemographicsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetKeywordDemographicsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetKeywordDemographicsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetKeywordLocationsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetKeywordLocationsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetKeywordLocationsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetKeywordLocationsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetEstimatedBidByKeywordIdsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.SuggestKeywordsForUrlRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.SuggestKeywordsForUrlResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetEstimatedBidByKeywordsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetHistoricalSearchCountRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetHistoricalSearchCountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetPublisherKeywordPerformanceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetHistoricalSearchCountByDeviceResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.SuggestKeywordsFromExistingKeywordsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetEstimatedPositionByKeywordIdsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerAccountId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerAccountId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.CustomerId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.CustomerId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   