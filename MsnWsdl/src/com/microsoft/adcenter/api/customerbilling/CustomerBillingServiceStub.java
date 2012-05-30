
/**
 * CustomerBillingServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.microsoft.adcenter.api.customerbilling;

        

        /*
        *  CustomerBillingServiceStub java implementation
        */

        
        public class CustomerBillingServiceStub extends org.apache.axis2.client.Stub
        implements CustomerBillingService{
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
     _service = new org.apache.axis2.description.AxisService("CustomerBillingService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[8];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[3]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[4]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[5]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[6]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_ICustomerBillingService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[7]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "AddInsertionOrder"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "AddInsertionOrder"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "AddInsertionOrder"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "AddInsertionOrder"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "AddInsertionOrder"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "AddInsertionOrder"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInsertionOrdersByAccount"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInsertionOrdersByAccount"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInsertionOrdersByAccount"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInsertionOrdersByAccount"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInsertionOrdersByAccount"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInsertionOrdersByAccount"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetAccountMonthlySpend"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetAccountMonthlySpend"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetAccountMonthlySpend"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetAccountMonthlySpend"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetAccountMonthlySpend"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetAccountMonthlySpend"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKOHIOInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKOHIOInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetKOHIOInvoices"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetKOHIOInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetKOHIOInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetKOHIOInvoices"),"com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetKOHIOInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetKOHIOInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetKOHIOInvoices"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetDisplayInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetDisplayInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetDisplayInvoices"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetDisplayInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetDisplayInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetDisplayInvoices"),"com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetDisplayInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetDisplayInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetDisplayInvoices"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInvoicesInfo"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInvoicesInfo"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInvoicesInfo"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetInvoicesInfo"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetInvoicesInfo"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetInvoicesInfo"),"com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInvoicesInfo"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInvoicesInfo"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInvoicesInfo"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "UpdateInsertionOrder"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "UpdateInsertionOrder"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "UpdateInsertionOrder"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "UpdateInsertionOrder"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "UpdateInsertionOrder"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "UpdateInsertionOrder"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetInvoices"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiBatchFault"), "GetInvoices"),"com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInvoices"),"com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customermanagement/Exception","ApiFault"), "GetInvoices"),"com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public CustomerBillingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public CustomerBillingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public CustomerBillingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"https://sharedservices.adcenterapi.microsoft.com/Api/Billing/v8/CustomerBillingService.svc" );
                
    }

    /**
     * Default Constructor
     */
    public CustomerBillingServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("https://sharedservices.adcenterapi.microsoft.com/Api/Billing/v8/CustomerBillingService.svc" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public CustomerBillingServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#addInsertionOrder
                     * @param addInsertionOrderRequest76
                    
                     * @param applicationToken77
                    
                     * @param developerToken78
                    
                     * @param password79
                    
                     * @param userName80
                    
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse addInsertionOrder(

                            com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest addInsertionOrderRequest76,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken77,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken78,com.microsoft.adcenter.api.customerbilling.Password password79,com.microsoft.adcenter.api.customerbilling.UserName userName80)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("AddInsertionOrder");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addInsertionOrderRequest76,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "addInsertionOrder")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "addInsertionOrder"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken77!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken77 = toOM(applicationToken77, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder")));
                                                    addHeader(omElementapplicationToken77,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken78!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken78 = toOM(developerToken78, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder")));
                                                    addHeader(omElementdeveloperToken78,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password79!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword79 = toOM(password79, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder")));
                                                    addHeader(omElementpassword79,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName80!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName80 = toOM(userName80, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder")));
                                                    addHeader(omElementuserName80,env);
                                                
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
                                             com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"AddInsertionOrder"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"AddInsertionOrder"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"AddInsertionOrder"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#startaddInsertionOrder
                    * @param addInsertionOrderRequest76
                
                    * @param applicationToken77
                
                    * @param developerToken78
                
                    * @param password79
                
                    * @param userName80
                
                */
                public  void startaddInsertionOrder(

                 com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest addInsertionOrderRequest76,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken77,
                    com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken78,
                    com.microsoft.adcenter.api.customerbilling.Password password79,
                    com.microsoft.adcenter.api.customerbilling.UserName userName80,
                    

                  final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("AddInsertionOrder");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    addInsertionOrderRequest76,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "addInsertionOrder")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "addInsertionOrder"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken77!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken77 = toOM(applicationToken77, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder")));
                                                    addHeader(omElementapplicationToken77,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken78!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken78 = toOM(developerToken78, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder")));
                                                    addHeader(omElementdeveloperToken78,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password79!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword79 = toOM(password79, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder")));
                                                    addHeader(omElementpassword79,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName80!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName80 = toOM(userName80, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "addInsertionOrder")));
                                                    addHeader(omElementuserName80,env);
                                                
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
                                                                         com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultaddInsertionOrder(
                                        (com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErroraddInsertionOrder(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"AddInsertionOrder"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"AddInsertionOrder"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"AddInsertionOrder"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErroraddInsertionOrder((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage){
														callback.receiveErroraddInsertionOrder((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_AddInsertionOrder_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErroraddInsertionOrder(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddInsertionOrder(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddInsertionOrder(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddInsertionOrder(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddInsertionOrder(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddInsertionOrder(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddInsertionOrder(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddInsertionOrder(f);
                                            }
									    } else {
										    callback.receiveErroraddInsertionOrder(f);
									    }
									} else {
									    callback.receiveErroraddInsertionOrder(f);
									}
								} else {
								    callback.receiveErroraddInsertionOrder(error);
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
                                    callback.receiveErroraddInsertionOrder(axisFault);
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
                     * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#getInsertionOrdersByAccount
                     * @param getInsertionOrdersByAccountRequest82
                    
                     * @param applicationToken83
                    
                     * @param developerToken84
                    
                     * @param password85
                    
                     * @param userName86
                    
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse getInsertionOrdersByAccount(

                            com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest getInsertionOrdersByAccountRequest82,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken83,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken84,com.microsoft.adcenter.api.customerbilling.Password password85,com.microsoft.adcenter.api.customerbilling.UserName userName86)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("GetInsertionOrdersByAccount");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getInsertionOrdersByAccountRequest82,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInsertionOrdersByAccount")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInsertionOrdersByAccount"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken83!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken83 = toOM(applicationToken83, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount")));
                                                    addHeader(omElementapplicationToken83,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken84!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken84 = toOM(developerToken84, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount")));
                                                    addHeader(omElementdeveloperToken84,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password85!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword85 = toOM(password85, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount")));
                                                    addHeader(omElementpassword85,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName86!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName86 = toOM(userName86, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount")));
                                                    addHeader(omElementuserName86,env);
                                                
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
                                             com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInsertionOrdersByAccount"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInsertionOrdersByAccount"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInsertionOrdersByAccount"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#startgetInsertionOrdersByAccount
                    * @param getInsertionOrdersByAccountRequest82
                
                    * @param applicationToken83
                
                    * @param developerToken84
                
                    * @param password85
                
                    * @param userName86
                
                */
                public  void startgetInsertionOrdersByAccount(

                 com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest getInsertionOrdersByAccountRequest82,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken83,
                    com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken84,
                    com.microsoft.adcenter.api.customerbilling.Password password85,
                    com.microsoft.adcenter.api.customerbilling.UserName userName86,
                    

                  final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("GetInsertionOrdersByAccount");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getInsertionOrdersByAccountRequest82,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInsertionOrdersByAccount")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInsertionOrdersByAccount"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken83!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken83 = toOM(applicationToken83, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount")));
                                                    addHeader(omElementapplicationToken83,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken84!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken84 = toOM(developerToken84, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount")));
                                                    addHeader(omElementdeveloperToken84,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password85!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword85 = toOM(password85, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount")));
                                                    addHeader(omElementpassword85,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName86!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName86 = toOM(userName86, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInsertionOrdersByAccount")));
                                                    addHeader(omElementuserName86,env);
                                                
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
                                                                         com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetInsertionOrdersByAccount(
                                        (com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetInsertionOrdersByAccount(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInsertionOrdersByAccount"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInsertionOrdersByAccount"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInsertionOrdersByAccount"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetInsertionOrdersByAccount((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage){
														callback.receiveErrorgetInsertionOrdersByAccount((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInsertionOrdersByAccount_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetInsertionOrdersByAccount(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInsertionOrdersByAccount(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInsertionOrdersByAccount(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInsertionOrdersByAccount(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInsertionOrdersByAccount(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInsertionOrdersByAccount(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInsertionOrdersByAccount(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInsertionOrdersByAccount(f);
                                            }
									    } else {
										    callback.receiveErrorgetInsertionOrdersByAccount(f);
									    }
									} else {
									    callback.receiveErrorgetInsertionOrdersByAccount(f);
									}
								} else {
								    callback.receiveErrorgetInsertionOrdersByAccount(error);
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
                                    callback.receiveErrorgetInsertionOrdersByAccount(axisFault);
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
                     * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#getAccountMonthlySpend
                     * @param getAccountMonthlySpendRequest88
                    
                     * @param applicationToken89
                    
                     * @param developerToken90
                    
                     * @param password91
                    
                     * @param userName92
                    
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse getAccountMonthlySpend(

                            com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest getAccountMonthlySpendRequest88,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken89,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken90,com.microsoft.adcenter.api.customerbilling.Password password91,com.microsoft.adcenter.api.customerbilling.UserName userName92)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("GetAccountMonthlySpend");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getAccountMonthlySpendRequest88,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getAccountMonthlySpend")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getAccountMonthlySpend"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken89!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken89 = toOM(applicationToken89, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend")));
                                                    addHeader(omElementapplicationToken89,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken90!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken90 = toOM(developerToken90, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend")));
                                                    addHeader(omElementdeveloperToken90,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password91!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword91 = toOM(password91, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend")));
                                                    addHeader(omElementpassword91,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName92!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName92 = toOM(userName92, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend")));
                                                    addHeader(omElementuserName92,env);
                                                
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
                                             com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAccountMonthlySpend"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAccountMonthlySpend"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAccountMonthlySpend"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#startgetAccountMonthlySpend
                    * @param getAccountMonthlySpendRequest88
                
                    * @param applicationToken89
                
                    * @param developerToken90
                
                    * @param password91
                
                    * @param userName92
                
                */
                public  void startgetAccountMonthlySpend(

                 com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest getAccountMonthlySpendRequest88,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken89,
                    com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken90,
                    com.microsoft.adcenter.api.customerbilling.Password password91,
                    com.microsoft.adcenter.api.customerbilling.UserName userName92,
                    

                  final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
             _operationClient.getOptions().setAction("GetAccountMonthlySpend");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getAccountMonthlySpendRequest88,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getAccountMonthlySpend")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getAccountMonthlySpend"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken89!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken89 = toOM(applicationToken89, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend")));
                                                    addHeader(omElementapplicationToken89,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken90!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken90 = toOM(developerToken90, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend")));
                                                    addHeader(omElementdeveloperToken90,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password91!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword91 = toOM(password91, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend")));
                                                    addHeader(omElementpassword91,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName92!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName92 = toOM(userName92, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getAccountMonthlySpend")));
                                                    addHeader(omElementuserName92,env);
                                                
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
                                                                         com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetAccountMonthlySpend(
                                        (com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetAccountMonthlySpend(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAccountMonthlySpend"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAccountMonthlySpend"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAccountMonthlySpend"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetAccountMonthlySpend((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage){
														callback.receiveErrorgetAccountMonthlySpend((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetAccountMonthlySpend_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetAccountMonthlySpend(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAccountMonthlySpend(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAccountMonthlySpend(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAccountMonthlySpend(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAccountMonthlySpend(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAccountMonthlySpend(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAccountMonthlySpend(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAccountMonthlySpend(f);
                                            }
									    } else {
										    callback.receiveErrorgetAccountMonthlySpend(f);
									    }
									} else {
									    callback.receiveErrorgetAccountMonthlySpend(f);
									}
								} else {
								    callback.receiveErrorgetAccountMonthlySpend(error);
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
                                    callback.receiveErrorgetAccountMonthlySpend(axisFault);
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
                     * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#getKOHIOInvoices
                     * @param getKOHIOInvoicesRequest94
                    
                     * @param applicationToken95
                    
                     * @param developerToken96
                    
                     * @param password97
                    
                     * @param userName98
                    
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse getKOHIOInvoices(

                            com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest getKOHIOInvoicesRequest94,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken95,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken96,com.microsoft.adcenter.api.customerbilling.Password password97,com.microsoft.adcenter.api.customerbilling.UserName userName98)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("GetKOHIOInvoices");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getKOHIOInvoicesRequest94,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getKOHIOInvoices")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getKOHIOInvoices"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken95!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken95 = toOM(applicationToken95, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices")));
                                                    addHeader(omElementapplicationToken95,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken96!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken96 = toOM(developerToken96, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices")));
                                                    addHeader(omElementdeveloperToken96,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password97!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword97 = toOM(password97, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices")));
                                                    addHeader(omElementpassword97,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName98!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName98 = toOM(userName98, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices")));
                                                    addHeader(omElementuserName98,env);
                                                
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
                                             com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKOHIOInvoices"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKOHIOInvoices"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKOHIOInvoices"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#startgetKOHIOInvoices
                    * @param getKOHIOInvoicesRequest94
                
                    * @param applicationToken95
                
                    * @param developerToken96
                
                    * @param password97
                
                    * @param userName98
                
                */
                public  void startgetKOHIOInvoices(

                 com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest getKOHIOInvoicesRequest94,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken95,
                    com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken96,
                    com.microsoft.adcenter.api.customerbilling.Password password97,
                    com.microsoft.adcenter.api.customerbilling.UserName userName98,
                    

                  final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
             _operationClient.getOptions().setAction("GetKOHIOInvoices");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getKOHIOInvoicesRequest94,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getKOHIOInvoices")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getKOHIOInvoices"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken95!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken95 = toOM(applicationToken95, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices")));
                                                    addHeader(omElementapplicationToken95,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken96!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken96 = toOM(developerToken96, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices")));
                                                    addHeader(omElementdeveloperToken96,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password97!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword97 = toOM(password97, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices")));
                                                    addHeader(omElementpassword97,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName98!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName98 = toOM(userName98, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getKOHIOInvoices")));
                                                    addHeader(omElementuserName98,env);
                                                
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
                                                                         com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetKOHIOInvoices(
                                        (com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetKOHIOInvoices(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKOHIOInvoices"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKOHIOInvoices"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetKOHIOInvoices"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetKOHIOInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage){
														callback.receiveErrorgetKOHIOInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiBatchFaultFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage){
														callback.receiveErrorgetKOHIOInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetKOHIOInvoices_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetKOHIOInvoices(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKOHIOInvoices(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKOHIOInvoices(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKOHIOInvoices(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKOHIOInvoices(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKOHIOInvoices(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKOHIOInvoices(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetKOHIOInvoices(f);
                                            }
									    } else {
										    callback.receiveErrorgetKOHIOInvoices(f);
									    }
									} else {
									    callback.receiveErrorgetKOHIOInvoices(f);
									}
								} else {
								    callback.receiveErrorgetKOHIOInvoices(error);
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
                                    callback.receiveErrorgetKOHIOInvoices(axisFault);
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
                     * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#getDisplayInvoices
                     * @param getDisplayInvoicesRequest100
                    
                     * @param applicationToken101
                    
                     * @param developerToken102
                    
                     * @param password103
                    
                     * @param userName104
                    
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse getDisplayInvoices(

                            com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest getDisplayInvoicesRequest100,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken101,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken102,com.microsoft.adcenter.api.customerbilling.Password password103,com.microsoft.adcenter.api.customerbilling.UserName userName104)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("GetDisplayInvoices");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getDisplayInvoicesRequest100,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getDisplayInvoices")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getDisplayInvoices"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken101!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken101 = toOM(applicationToken101, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices")));
                                                    addHeader(omElementapplicationToken101,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken102!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken102 = toOM(developerToken102, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices")));
                                                    addHeader(omElementdeveloperToken102,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password103!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword103 = toOM(password103, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices")));
                                                    addHeader(omElementpassword103,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName104!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName104 = toOM(userName104, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices")));
                                                    addHeader(omElementuserName104,env);
                                                
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
                                             com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetDisplayInvoices"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetDisplayInvoices"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetDisplayInvoices"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#startgetDisplayInvoices
                    * @param getDisplayInvoicesRequest100
                
                    * @param applicationToken101
                
                    * @param developerToken102
                
                    * @param password103
                
                    * @param userName104
                
                */
                public  void startgetDisplayInvoices(

                 com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest getDisplayInvoicesRequest100,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken101,
                    com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken102,
                    com.microsoft.adcenter.api.customerbilling.Password password103,
                    com.microsoft.adcenter.api.customerbilling.UserName userName104,
                    

                  final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
             _operationClient.getOptions().setAction("GetDisplayInvoices");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getDisplayInvoicesRequest100,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getDisplayInvoices")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getDisplayInvoices"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken101!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken101 = toOM(applicationToken101, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices")));
                                                    addHeader(omElementapplicationToken101,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken102!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken102 = toOM(developerToken102, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices")));
                                                    addHeader(omElementdeveloperToken102,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password103!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword103 = toOM(password103, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices")));
                                                    addHeader(omElementpassword103,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName104!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName104 = toOM(userName104, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getDisplayInvoices")));
                                                    addHeader(omElementuserName104,env);
                                                
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
                                                                         com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetDisplayInvoices(
                                        (com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetDisplayInvoices(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetDisplayInvoices"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetDisplayInvoices"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetDisplayInvoices"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetDisplayInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage){
														callback.receiveErrorgetDisplayInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiBatchFaultFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage){
														callback.receiveErrorgetDisplayInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetDisplayInvoices_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetDisplayInvoices(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetDisplayInvoices(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetDisplayInvoices(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetDisplayInvoices(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetDisplayInvoices(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetDisplayInvoices(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetDisplayInvoices(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetDisplayInvoices(f);
                                            }
									    } else {
										    callback.receiveErrorgetDisplayInvoices(f);
									    }
									} else {
									    callback.receiveErrorgetDisplayInvoices(f);
									}
								} else {
								    callback.receiveErrorgetDisplayInvoices(error);
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
                                    callback.receiveErrorgetDisplayInvoices(axisFault);
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
                     * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#getInvoicesInfo
                     * @param getInvoicesInfoRequest106
                    
                     * @param applicationToken107
                    
                     * @param developerToken108
                    
                     * @param password109
                    
                     * @param userName110
                    
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse getInvoicesInfo(

                            com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest getInvoicesInfoRequest106,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken107,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken108,com.microsoft.adcenter.api.customerbilling.Password password109,com.microsoft.adcenter.api.customerbilling.UserName userName110)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("GetInvoicesInfo");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getInvoicesInfoRequest106,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInvoicesInfo")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInvoicesInfo"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken107!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken107 = toOM(applicationToken107, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo")));
                                                    addHeader(omElementapplicationToken107,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken108!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken108 = toOM(developerToken108, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo")));
                                                    addHeader(omElementdeveloperToken108,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password109!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword109 = toOM(password109, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo")));
                                                    addHeader(omElementpassword109,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName110!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName110 = toOM(userName110, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo")));
                                                    addHeader(omElementuserName110,env);
                                                
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
                                             com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoicesInfo"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoicesInfo"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoicesInfo"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#startgetInvoicesInfo
                    * @param getInvoicesInfoRequest106
                
                    * @param applicationToken107
                
                    * @param developerToken108
                
                    * @param password109
                
                    * @param userName110
                
                */
                public  void startgetInvoicesInfo(

                 com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest getInvoicesInfoRequest106,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken107,
                    com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken108,
                    com.microsoft.adcenter.api.customerbilling.Password password109,
                    com.microsoft.adcenter.api.customerbilling.UserName userName110,
                    

                  final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
             _operationClient.getOptions().setAction("GetInvoicesInfo");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getInvoicesInfoRequest106,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInvoicesInfo")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInvoicesInfo"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken107!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken107 = toOM(applicationToken107, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo")));
                                                    addHeader(omElementapplicationToken107,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken108!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken108 = toOM(developerToken108, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo")));
                                                    addHeader(omElementdeveloperToken108,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password109!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword109 = toOM(password109, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo")));
                                                    addHeader(omElementpassword109,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName110!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName110 = toOM(userName110, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoicesInfo")));
                                                    addHeader(omElementuserName110,env);
                                                
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
                                                                         com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetInvoicesInfo(
                                        (com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetInvoicesInfo(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoicesInfo"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoicesInfo"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoicesInfo"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetInvoicesInfo((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage){
														callback.receiveErrorgetInvoicesInfo((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiBatchFaultFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage){
														callback.receiveErrorgetInvoicesInfo((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoicesInfo_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetInvoicesInfo(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoicesInfo(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoicesInfo(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoicesInfo(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoicesInfo(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoicesInfo(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoicesInfo(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoicesInfo(f);
                                            }
									    } else {
										    callback.receiveErrorgetInvoicesInfo(f);
									    }
									} else {
									    callback.receiveErrorgetInvoicesInfo(f);
									}
								} else {
								    callback.receiveErrorgetInvoicesInfo(error);
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
                                    callback.receiveErrorgetInvoicesInfo(axisFault);
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
                     * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#updateInsertionOrder
                     * @param updateInsertionOrderRequest112
                    
                     * @param applicationToken113
                    
                     * @param developerToken114
                    
                     * @param password115
                    
                     * @param userName116
                    
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse updateInsertionOrder(

                            com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest updateInsertionOrderRequest112,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken113,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken114,com.microsoft.adcenter.api.customerbilling.Password password115,com.microsoft.adcenter.api.customerbilling.UserName userName116)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
              _operationClient.getOptions().setAction("UpdateInsertionOrder");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    updateInsertionOrderRequest112,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "updateInsertionOrder")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "updateInsertionOrder"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken113!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken113 = toOM(applicationToken113, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder")));
                                                    addHeader(omElementapplicationToken113,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken114!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken114 = toOM(developerToken114, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder")));
                                                    addHeader(omElementdeveloperToken114,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password115!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword115 = toOM(password115, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder")));
                                                    addHeader(omElementpassword115,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName116!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName116 = toOM(userName116, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder")));
                                                    addHeader(omElementuserName116,env);
                                                
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
                                             com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"UpdateInsertionOrder"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"UpdateInsertionOrder"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"UpdateInsertionOrder"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#startupdateInsertionOrder
                    * @param updateInsertionOrderRequest112
                
                    * @param applicationToken113
                
                    * @param developerToken114
                
                    * @param password115
                
                    * @param userName116
                
                */
                public  void startupdateInsertionOrder(

                 com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest updateInsertionOrderRequest112,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken113,
                    com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken114,
                    com.microsoft.adcenter.api.customerbilling.Password password115,
                    com.microsoft.adcenter.api.customerbilling.UserName userName116,
                    

                  final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
             _operationClient.getOptions().setAction("UpdateInsertionOrder");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    updateInsertionOrderRequest112,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "updateInsertionOrder")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "updateInsertionOrder"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken113!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken113 = toOM(applicationToken113, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder")));
                                                    addHeader(omElementapplicationToken113,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken114!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken114 = toOM(developerToken114, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder")));
                                                    addHeader(omElementdeveloperToken114,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password115!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword115 = toOM(password115, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder")));
                                                    addHeader(omElementpassword115,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName116!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName116 = toOM(userName116, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "updateInsertionOrder")));
                                                    addHeader(omElementuserName116,env);
                                                
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
                                                                         com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultupdateInsertionOrder(
                                        (com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorupdateInsertionOrder(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"UpdateInsertionOrder"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"UpdateInsertionOrder"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"UpdateInsertionOrder"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorupdateInsertionOrder((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage){
														callback.receiveErrorupdateInsertionOrder((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_UpdateInsertionOrder_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorupdateInsertionOrder(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorupdateInsertionOrder(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorupdateInsertionOrder(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorupdateInsertionOrder(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorupdateInsertionOrder(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorupdateInsertionOrder(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorupdateInsertionOrder(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorupdateInsertionOrder(f);
                                            }
									    } else {
										    callback.receiveErrorupdateInsertionOrder(f);
									    }
									} else {
									    callback.receiveErrorupdateInsertionOrder(f);
									}
								} else {
								    callback.receiveErrorupdateInsertionOrder(error);
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
                                    callback.receiveErrorupdateInsertionOrder(axisFault);
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
                     * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#getInvoices
                     * @param getInvoicesRequest118
                    
                     * @param applicationToken119
                    
                     * @param developerToken120
                    
                     * @param password121
                    
                     * @param userName122
                    
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse getInvoices(

                            com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest getInvoicesRequest118,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken119,com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken120,com.microsoft.adcenter.api.customerbilling.Password password121,com.microsoft.adcenter.api.customerbilling.UserName userName122)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage
                        ,com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
              _operationClient.getOptions().setAction("GetInvoices");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getInvoicesRequest118,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInvoices")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInvoices"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken119!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken119 = toOM(applicationToken119, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices")));
                                                    addHeader(omElementapplicationToken119,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken120!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken120 = toOM(developerToken120, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices")));
                                                    addHeader(omElementdeveloperToken120,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password121!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword121 = toOM(password121, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices")));
                                                    addHeader(omElementpassword121,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName122!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName122 = toOM(userName122, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices")));
                                                    addHeader(omElementuserName122,env);
                                                
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
                                             com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoices"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoices"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoices"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage){
                          throw (com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.api.customerbilling.CustomerBillingService#startgetInvoices
                    * @param getInvoicesRequest118
                
                    * @param applicationToken119
                
                    * @param developerToken120
                
                    * @param password121
                
                    * @param userName122
                
                */
                public  void startgetInvoices(

                 com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest getInvoicesRequest118,com.microsoft.adcenter.api.customerbilling.ApplicationToken applicationToken119,
                    com.microsoft.adcenter.api.customerbilling.DeveloperToken developerToken120,
                    com.microsoft.adcenter.api.customerbilling.Password password121,
                    com.microsoft.adcenter.api.customerbilling.UserName userName122,
                    

                  final com.microsoft.adcenter.api.customerbilling.CustomerBillingServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
             _operationClient.getOptions().setAction("GetInvoices");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getInvoicesRequest118,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInvoices")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling",
                                                    "getInvoices"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken119!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken119 = toOM(applicationToken119, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices")));
                                                    addHeader(omElementapplicationToken119,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken120!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken120 = toOM(developerToken120, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices")));
                                                    addHeader(omElementdeveloperToken120,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password121!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword121 = toOM(password121, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices")));
                                                    addHeader(omElementpassword121,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName122!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName122 = toOM(userName122, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/api/customerbilling", "getInvoices")));
                                                    addHeader(omElementuserName122,env);
                                                
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
                                                                         com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetInvoices(
                                        (com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetInvoices(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoices"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoices"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetInvoices"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage){
														callback.receiveErrorgetInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiBatchFaultFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage){
														callback.receiveErrorgetInvoices((com.microsoft.adcenter.api.customerbilling.ICustomerBillingService_GetInvoices_ApiFaultFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetInvoices(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoices(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoices(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoices(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoices(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoices(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoices(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetInvoices(f);
                                            }
									    } else {
										    callback.receiveErrorgetInvoices(f);
									    }
									} else {
									    callback.receiveErrorgetInvoices(f);
									}
								} else {
								    callback.receiveErrorgetInvoices(error);
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
                                    callback.receiveErrorgetInvoices(axisFault);
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
     //https://sharedservices.adcenterapi.microsoft.com/Api/Billing/v8/CustomerBillingService.svc
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse.MY_QNAME,
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
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.ApplicationToken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.ApplicationToken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.DeveloperToken param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.DeveloperToken.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.Password param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.Password.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.UserName param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.UserName.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.TrackingId param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.TrackingId.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest.MY_QNAME,factory));
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
        
                if (com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.AddInsertionOrderRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.AddInsertionOrderResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetInsertionOrdersByAccountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetAccountMonthlySpendResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetKOHIOInvoicesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetDisplayInvoicesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetInvoicesInfoResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UpdateInsertionOrderResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetInvoicesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.GetInvoicesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiBatchFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customermanagement.exception.ApiFaultE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.ApplicationToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.ApplicationToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.DeveloperToken.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.DeveloperToken.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.Password.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.Password.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.UserName.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.UserName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.api.customerbilling.TrackingId.class.equals(type)){
                
                           return com.microsoft.adcenter.api.customerbilling.TrackingId.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   