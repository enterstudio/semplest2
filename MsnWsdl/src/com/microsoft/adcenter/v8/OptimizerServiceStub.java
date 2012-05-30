
/**
 * OptimizerServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.microsoft.adcenter.v8;

        

        /*
        *  OptimizerServiceStub java implementation
        */

        
        public class OptimizerServiceStub extends org.apache.axis2.client.Stub
        implements OptimizerService{
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
     _service = new org.apache.axis2.description.AxisService("OptimizerService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[4];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IOptimizerService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IOptimizerService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IOptimizerService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IOptimizerService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IOptimizerService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IOptimizerService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IOptimizerService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IOptimizerService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[3]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "ApplyBudgetOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "ApplyBudgetOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "ApplyBudgetOpportunities"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "ApplyBudgetOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "ApplyBudgetOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "ApplyBudgetOpportunities"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "ApplyOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "ApplyOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "ApplyOpportunities"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "ApplyOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "ApplyOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "ApplyOpportunities"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetBudgetOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetBudgetOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetBudgetOpportunities"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetBudgetOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetBudgetOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetBudgetOpportunities"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetBidOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetBidOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetBidOpportunities"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetBidOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetBidOpportunities"),"com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8","ApiFaultDetail"), "GetBidOpportunities"),"com.microsoft.adcenter.v8.ApiFaultDetailE");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public OptimizerServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public OptimizerServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public OptimizerServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"https://adcenterapi.microsoft.com/Api/Advertiser/V8/Optimizer/OptimizerService.svc" );
                
    }

    /**
     * Default Constructor
     */
    public OptimizerServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("https://adcenterapi.microsoft.com/Api/Advertiser/V8/Optimizer/OptimizerService.svc" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public OptimizerServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.OptimizerService#applyBudgetOpportunities
                     * @param applyBudgetOpportunitiesRequest50
                    
                     * @param applicationToken51
                    
                     * @param customerAccountId52
                    
                     * @param customerId53
                    
                     * @param developerToken54
                    
                     * @param password55
                    
                     * @param userName56
                    
                     * @throws com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse applyBudgetOpportunities(

                            com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest applyBudgetOpportunitiesRequest50,com.microsoft.adcenter.v8.ApplicationToken applicationToken51,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId52,com.microsoft.adcenter.v8.CustomerId customerId53,com.microsoft.adcenter.v8.DeveloperToken developerToken54,com.microsoft.adcenter.v8.Password password55,com.microsoft.adcenter.v8.UserName userName56)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("ApplyBudgetOpportunities");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    applyBudgetOpportunitiesRequest50,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "applyBudgetOpportunities")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "applyBudgetOpportunities"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken51!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken51 = toOM(applicationToken51, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementapplicationToken51,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId52!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId52 = toOM(customerAccountId52, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementcustomerAccountId52,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId53!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId53 = toOM(customerId53, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementcustomerId53,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken54!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken54 = toOM(developerToken54, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementdeveloperToken54,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password55!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword55 = toOM(password55, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementpassword55,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName56!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName56 = toOM(userName56, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementuserName56,env);
                                                
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
                                             com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyBudgetOpportunities"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyBudgetOpportunities"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyBudgetOpportunities"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.v8.OptimizerService#startapplyBudgetOpportunities
                    * @param applyBudgetOpportunitiesRequest50
                
                    * @param applicationToken51
                
                    * @param customerAccountId52
                
                    * @param customerId53
                
                    * @param developerToken54
                
                    * @param password55
                
                    * @param userName56
                
                */
                public  void startapplyBudgetOpportunities(

                 com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest applyBudgetOpportunitiesRequest50,com.microsoft.adcenter.v8.ApplicationToken applicationToken51,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId52,
                    com.microsoft.adcenter.v8.CustomerId customerId53,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken54,
                    com.microsoft.adcenter.v8.Password password55,
                    com.microsoft.adcenter.v8.UserName userName56,
                    

                  final com.microsoft.adcenter.v8.OptimizerServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("ApplyBudgetOpportunities");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    applyBudgetOpportunitiesRequest50,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "applyBudgetOpportunities")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "applyBudgetOpportunities"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken51!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken51 = toOM(applicationToken51, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementapplicationToken51,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId52!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId52 = toOM(customerAccountId52, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementcustomerAccountId52,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId53!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId53 = toOM(customerId53, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementcustomerId53,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken54!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken54 = toOM(developerToken54, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementdeveloperToken54,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password55!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword55 = toOM(password55, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementpassword55,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName56!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName56 = toOM(userName56, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyBudgetOpportunities")));
                                                    addHeader(omElementuserName56,env);
                                                
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
                                                                         com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultapplyBudgetOpportunities(
                                        (com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorapplyBudgetOpportunities(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyBudgetOpportunities"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyBudgetOpportunities"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyBudgetOpportunities"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorapplyBudgetOpportunities((com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorapplyBudgetOpportunities((com.microsoft.adcenter.v8.IOptimizerService_ApplyBudgetOpportunities_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorapplyBudgetOpportunities(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyBudgetOpportunities(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyBudgetOpportunities(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyBudgetOpportunities(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyBudgetOpportunities(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyBudgetOpportunities(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyBudgetOpportunities(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyBudgetOpportunities(f);
                                            }
									    } else {
										    callback.receiveErrorapplyBudgetOpportunities(f);
									    }
									} else {
									    callback.receiveErrorapplyBudgetOpportunities(f);
									}
								} else {
								    callback.receiveErrorapplyBudgetOpportunities(error);
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
                                    callback.receiveErrorapplyBudgetOpportunities(axisFault);
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
                     * @see com.microsoft.adcenter.v8.OptimizerService#applyOpportunities
                     * @param applyOpportunitiesRequest58
                    
                     * @param applicationToken59
                    
                     * @param customerAccountId60
                    
                     * @param customerId61
                    
                     * @param developerToken62
                    
                     * @param password63
                    
                     * @param userName64
                    
                     * @throws com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.ApplyOpportunitiesResponse applyOpportunities(

                            com.microsoft.adcenter.v8.ApplyOpportunitiesRequest applyOpportunitiesRequest58,com.microsoft.adcenter.v8.ApplicationToken applicationToken59,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId60,com.microsoft.adcenter.v8.CustomerId customerId61,com.microsoft.adcenter.v8.DeveloperToken developerToken62,com.microsoft.adcenter.v8.Password password63,com.microsoft.adcenter.v8.UserName userName64)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("ApplyOpportunities");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    applyOpportunitiesRequest58,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "applyOpportunities")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "applyOpportunities"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken59!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken59 = toOM(applicationToken59, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementapplicationToken59,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId60!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId60 = toOM(customerAccountId60, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementcustomerAccountId60,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId61!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId61 = toOM(customerId61, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementcustomerId61,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken62!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken62 = toOM(developerToken62, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementdeveloperToken62,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password63!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword63 = toOM(password63, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementpassword63,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName64!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName64 = toOM(userName64, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementuserName64,env);
                                                
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
                                             com.microsoft.adcenter.v8.ApplyOpportunitiesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.ApplyOpportunitiesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyOpportunities"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyOpportunities"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyOpportunities"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.v8.OptimizerService#startapplyOpportunities
                    * @param applyOpportunitiesRequest58
                
                    * @param applicationToken59
                
                    * @param customerAccountId60
                
                    * @param customerId61
                
                    * @param developerToken62
                
                    * @param password63
                
                    * @param userName64
                
                */
                public  void startapplyOpportunities(

                 com.microsoft.adcenter.v8.ApplyOpportunitiesRequest applyOpportunitiesRequest58,com.microsoft.adcenter.v8.ApplicationToken applicationToken59,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId60,
                    com.microsoft.adcenter.v8.CustomerId customerId61,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken62,
                    com.microsoft.adcenter.v8.Password password63,
                    com.microsoft.adcenter.v8.UserName userName64,
                    

                  final com.microsoft.adcenter.v8.OptimizerServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("ApplyOpportunities");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    applyOpportunitiesRequest58,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "applyOpportunities")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "applyOpportunities"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken59!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken59 = toOM(applicationToken59, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementapplicationToken59,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId60!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId60 = toOM(customerAccountId60, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementcustomerAccountId60,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId61!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId61 = toOM(customerId61, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementcustomerId61,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken62!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken62 = toOM(developerToken62, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementdeveloperToken62,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password63!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword63 = toOM(password63, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementpassword63,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName64!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName64 = toOM(userName64, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "applyOpportunities")));
                                                    addHeader(omElementuserName64,env);
                                                
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
                                                                         com.microsoft.adcenter.v8.ApplyOpportunitiesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultapplyOpportunities(
                                        (com.microsoft.adcenter.v8.ApplyOpportunitiesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorapplyOpportunities(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyOpportunities"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyOpportunities"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"ApplyOpportunities"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorapplyOpportunities((com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorapplyOpportunities((com.microsoft.adcenter.v8.IOptimizerService_ApplyOpportunities_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorapplyOpportunities(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyOpportunities(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyOpportunities(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyOpportunities(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyOpportunities(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyOpportunities(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyOpportunities(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorapplyOpportunities(f);
                                            }
									    } else {
										    callback.receiveErrorapplyOpportunities(f);
									    }
									} else {
									    callback.receiveErrorapplyOpportunities(f);
									}
								} else {
								    callback.receiveErrorapplyOpportunities(error);
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
                                    callback.receiveErrorapplyOpportunities(axisFault);
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
                     * @see com.microsoft.adcenter.v8.OptimizerService#getBudgetOpportunities
                     * @param getBudgetOpportunitiesRequest66
                    
                     * @param applicationToken67
                    
                     * @param customerAccountId68
                    
                     * @param customerId69
                    
                     * @param developerToken70
                    
                     * @param password71
                    
                     * @param userName72
                    
                     * @throws com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse getBudgetOpportunities(

                            com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest getBudgetOpportunitiesRequest66,com.microsoft.adcenter.v8.ApplicationToken applicationToken67,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId68,com.microsoft.adcenter.v8.CustomerId customerId69,com.microsoft.adcenter.v8.DeveloperToken developerToken70,com.microsoft.adcenter.v8.Password password71,com.microsoft.adcenter.v8.UserName userName72)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("GetBudgetOpportunities");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getBudgetOpportunitiesRequest66,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getBudgetOpportunities")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getBudgetOpportunities"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken67!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken67 = toOM(applicationToken67, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementapplicationToken67,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId68!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId68 = toOM(customerAccountId68, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementcustomerAccountId68,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId69!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId69 = toOM(customerId69, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementcustomerId69,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken70!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken70 = toOM(developerToken70, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementdeveloperToken70,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password71!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword71 = toOM(password71, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementpassword71,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName72!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName72 = toOM(userName72, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementuserName72,env);
                                                
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
                                             com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBudgetOpportunities"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBudgetOpportunities"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBudgetOpportunities"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.v8.OptimizerService#startgetBudgetOpportunities
                    * @param getBudgetOpportunitiesRequest66
                
                    * @param applicationToken67
                
                    * @param customerAccountId68
                
                    * @param customerId69
                
                    * @param developerToken70
                
                    * @param password71
                
                    * @param userName72
                
                */
                public  void startgetBudgetOpportunities(

                 com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest getBudgetOpportunitiesRequest66,com.microsoft.adcenter.v8.ApplicationToken applicationToken67,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId68,
                    com.microsoft.adcenter.v8.CustomerId customerId69,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken70,
                    com.microsoft.adcenter.v8.Password password71,
                    com.microsoft.adcenter.v8.UserName userName72,
                    

                  final com.microsoft.adcenter.v8.OptimizerServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
             _operationClient.getOptions().setAction("GetBudgetOpportunities");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getBudgetOpportunitiesRequest66,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getBudgetOpportunities")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getBudgetOpportunities"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken67!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken67 = toOM(applicationToken67, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementapplicationToken67,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId68!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId68 = toOM(customerAccountId68, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementcustomerAccountId68,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId69!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId69 = toOM(customerId69, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementcustomerId69,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken70!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken70 = toOM(developerToken70, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementdeveloperToken70,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password71!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword71 = toOM(password71, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementpassword71,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName72!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName72 = toOM(userName72, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBudgetOpportunities")));
                                                    addHeader(omElementuserName72,env);
                                                
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
                                                                         com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetBudgetOpportunities(
                                        (com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetBudgetOpportunities(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBudgetOpportunities"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBudgetOpportunities"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBudgetOpportunities"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetBudgetOpportunities((com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetBudgetOpportunities((com.microsoft.adcenter.v8.IOptimizerService_GetBudgetOpportunities_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetBudgetOpportunities(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBudgetOpportunities(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBudgetOpportunities(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBudgetOpportunities(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBudgetOpportunities(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBudgetOpportunities(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBudgetOpportunities(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBudgetOpportunities(f);
                                            }
									    } else {
										    callback.receiveErrorgetBudgetOpportunities(f);
									    }
									} else {
									    callback.receiveErrorgetBudgetOpportunities(f);
									}
								} else {
								    callback.receiveErrorgetBudgetOpportunities(error);
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
                                    callback.receiveErrorgetBudgetOpportunities(axisFault);
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
                     * @see com.microsoft.adcenter.v8.OptimizerService#getBidOpportunities
                     * @param getBidOpportunitiesRequest74
                    
                     * @param applicationToken75
                    
                     * @param customerAccountId76
                    
                     * @param customerId77
                    
                     * @param developerToken78
                    
                     * @param password79
                    
                     * @param userName80
                    
                     * @throws com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage : 
                     * @throws com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetBidOpportunitiesResponse getBidOpportunities(

                            com.microsoft.adcenter.v8.GetBidOpportunitiesRequest getBidOpportunitiesRequest74,com.microsoft.adcenter.v8.ApplicationToken applicationToken75,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId76,com.microsoft.adcenter.v8.CustomerId customerId77,com.microsoft.adcenter.v8.DeveloperToken developerToken78,com.microsoft.adcenter.v8.Password password79,com.microsoft.adcenter.v8.UserName userName80)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage
                        ,com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("GetBidOpportunities");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getBidOpportunitiesRequest74,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getBidOpportunities")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getBidOpportunities"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken75!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken75 = toOM(applicationToken75, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementapplicationToken75,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId76!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId76 = toOM(customerAccountId76, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementcustomerAccountId76,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId77!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId77 = toOM(customerId77, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementcustomerId77,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken78!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken78 = toOM(developerToken78, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementdeveloperToken78,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password79!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword79 = toOM(password79, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementpassword79,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName80!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName80 = toOM(userName80, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
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
                                             com.microsoft.adcenter.v8.GetBidOpportunitiesResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetBidOpportunitiesResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBidOpportunities"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBidOpportunities"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBidOpportunities"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage)ex;
                        }
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.v8.OptimizerService#startgetBidOpportunities
                    * @param getBidOpportunitiesRequest74
                
                    * @param applicationToken75
                
                    * @param customerAccountId76
                
                    * @param customerId77
                
                    * @param developerToken78
                
                    * @param password79
                
                    * @param userName80
                
                */
                public  void startgetBidOpportunities(

                 com.microsoft.adcenter.v8.GetBidOpportunitiesRequest getBidOpportunitiesRequest74,com.microsoft.adcenter.v8.ApplicationToken applicationToken75,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId76,
                    com.microsoft.adcenter.v8.CustomerId customerId77,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken78,
                    com.microsoft.adcenter.v8.Password password79,
                    com.microsoft.adcenter.v8.UserName userName80,
                    

                  final com.microsoft.adcenter.v8.OptimizerServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
             _operationClient.getOptions().setAction("GetBidOpportunities");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getBidOpportunitiesRequest74,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getBidOpportunities")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getBidOpportunities"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken75!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken75 = toOM(applicationToken75, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementapplicationToken75,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId76!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId76 = toOM(customerAccountId76, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementcustomerAccountId76,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId77!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId77 = toOM(customerId77, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementcustomerId77,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken78!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken78 = toOM(developerToken78, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementdeveloperToken78,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password79!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword79 = toOM(password79, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
                                                    addHeader(omElementpassword79,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName80!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName80 = toOM(userName80, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getBidOpportunities")));
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
                                                                         com.microsoft.adcenter.v8.GetBidOpportunitiesResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetBidOpportunities(
                                        (com.microsoft.adcenter.v8.GetBidOpportunitiesResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetBidOpportunities(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBidOpportunities"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBidOpportunities"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetBidOpportunities"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetBidOpportunities((com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
													if (ex instanceof com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetBidOpportunities((com.microsoft.adcenter.v8.IOptimizerService_GetBidOpportunities_ApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetBidOpportunities(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBidOpportunities(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBidOpportunities(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBidOpportunities(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBidOpportunities(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBidOpportunities(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBidOpportunities(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetBidOpportunities(f);
                                            }
									    } else {
										    callback.receiveErrorgetBidOpportunities(f);
									    }
									} else {
									    callback.receiveErrorgetBidOpportunities(f);
									}
								} else {
								    callback.receiveErrorgetBidOpportunities(error);
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
                                    callback.receiveErrorgetBidOpportunities(axisFault);
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
     //https://adcenterapi.microsoft.com/Api/Advertiser/V8/Optimizer/OptimizerService.svc
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse.MY_QNAME,
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
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.ApplyOpportunitiesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.ApplyOpportunitiesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.ApplyOpportunitiesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.ApplyOpportunitiesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetBidOpportunitiesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetBidOpportunitiesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetBidOpportunitiesResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetBidOpportunitiesResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.ApplyOpportunitiesRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.ApplyOpportunitiesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetBidOpportunitiesRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetBidOpportunitiesRequest.MY_QNAME,factory));
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
        
                if (com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplyBudgetOpportunitiesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (com.microsoft.adcenter.v8.ApplyOpportunitiesRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplyOpportunitiesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.ApplyOpportunitiesResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.ApplyOpportunitiesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetBudgetOpportunitiesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetBudgetOpportunitiesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (com.microsoft.adcenter.v8.GetBidOpportunitiesRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetBidOpportunitiesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetBidOpportunitiesResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetBidOpportunitiesResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
   