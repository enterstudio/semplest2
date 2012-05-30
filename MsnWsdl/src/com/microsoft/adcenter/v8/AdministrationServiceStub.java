
/**
 * AdministrationServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package com.microsoft.adcenter.v8;

        

        /*
        *  AdministrationServiceStub java implementation
        */

        
        public class AdministrationServiceStub extends org.apache.axis2.client.Stub
        implements AdministrationService{
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
     _service = new org.apache.axis2.description.AxisService("AdministrationService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdministrationService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdministrationService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdministrationService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"BasicHttpBinding_IAdministrationService_policy\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><sp:TransportBinding xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken RequireClientCertificate=\"false\"></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic256/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[1]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetAssignedQuota"),"com.microsoft.adcenter.v8.IAdministrationService_GetAssignedQuota_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetAssignedQuota"),"com.microsoft.adcenter.v8.IAdministrationService_GetAssignedQuota_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetAssignedQuota"),"com.microsoft.adapi.AdApiFaultDetailE");
           
              faultExceptionNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetRemainingQuota"),"com.microsoft.adcenter.v8.IAdministrationService_GetRemainingQuota_AdApiFaultDetailFault_FaultMessage");
              faultExceptionClassNameMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetRemainingQuota"),"com.microsoft.adcenter.v8.IAdministrationService_GetRemainingQuota_AdApiFaultDetailFault_FaultMessage");
              faultMessageMap.put(new org.apache.axis2.client.FaultMapKey(new javax.xml.namespace.QName("https://adapi.microsoft.com","AdApiFaultDetail"), "GetRemainingQuota"),"com.microsoft.adapi.AdApiFaultDetailE");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public AdministrationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public AdministrationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public AdministrationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"https://adcenterapi.microsoft.com/Api/Advertiser/V8/Administration/AdministrationService.svc" );
                
    }

    /**
     * Default Constructor
     */
    public AdministrationServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("https://adcenterapi.microsoft.com/Api/Advertiser/V8/Administration/AdministrationService.svc" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public AdministrationServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.microsoft.adcenter.v8.AdministrationService#getAssignedQuota
                     * @param getAssignedQuotaRequest22
                    
                     * @param applicationToken23
                    
                     * @param customerAccountId24
                    
                     * @param customerId25
                    
                     * @param developerToken26
                    
                     * @param password27
                    
                     * @param userName28
                    
                     * @throws com.microsoft.adcenter.v8.IAdministrationService_GetAssignedQuota_AdApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetAssignedQuotaResponse getAssignedQuota(

                            com.microsoft.adcenter.v8.GetAssignedQuotaRequest getAssignedQuotaRequest22,com.microsoft.adcenter.v8.ApplicationToken applicationToken23,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId24,com.microsoft.adcenter.v8.CustomerId customerId25,com.microsoft.adcenter.v8.DeveloperToken developerToken26,com.microsoft.adcenter.v8.Password password27,com.microsoft.adcenter.v8.UserName userName28)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdministrationService_GetAssignedQuota_AdApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("GetAssignedQuota");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getAssignedQuotaRequest22,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getAssignedQuota")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getAssignedQuota"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken23!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken23 = toOM(applicationToken23, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementapplicationToken23,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId24!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId24 = toOM(customerAccountId24, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementcustomerAccountId24,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId25!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId25 = toOM(customerId25, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementcustomerId25,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken26!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken26 = toOM(developerToken26, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementdeveloperToken26,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password27!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword27 = toOM(password27, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementpassword27,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName28!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName28 = toOM(userName28, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementuserName28,env);
                                                
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
                                             com.microsoft.adcenter.v8.GetAssignedQuotaResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetAssignedQuotaResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAssignedQuota"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAssignedQuota"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAssignedQuota"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdministrationService_GetAssignedQuota_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdministrationService_GetAssignedQuota_AdApiFaultDetailFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.v8.AdministrationService#startgetAssignedQuota
                    * @param getAssignedQuotaRequest22
                
                    * @param applicationToken23
                
                    * @param customerAccountId24
                
                    * @param customerId25
                
                    * @param developerToken26
                
                    * @param password27
                
                    * @param userName28
                
                */
                public  void startgetAssignedQuota(

                 com.microsoft.adcenter.v8.GetAssignedQuotaRequest getAssignedQuotaRequest22,com.microsoft.adcenter.v8.ApplicationToken applicationToken23,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId24,
                    com.microsoft.adcenter.v8.CustomerId customerId25,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken26,
                    com.microsoft.adcenter.v8.Password password27,
                    com.microsoft.adcenter.v8.UserName userName28,
                    

                  final com.microsoft.adcenter.v8.AdministrationServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("GetAssignedQuota");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getAssignedQuotaRequest22,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getAssignedQuota")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getAssignedQuota"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken23!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken23 = toOM(applicationToken23, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementapplicationToken23,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId24!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId24 = toOM(customerAccountId24, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementcustomerAccountId24,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId25!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId25 = toOM(customerId25, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementcustomerId25,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken26!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken26 = toOM(developerToken26, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementdeveloperToken26,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password27!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword27 = toOM(password27, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementpassword27,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName28!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName28 = toOM(userName28, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getAssignedQuota")));
                                                    addHeader(omElementuserName28,env);
                                                
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
                                                                         com.microsoft.adcenter.v8.GetAssignedQuotaResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetAssignedQuota(
                                        (com.microsoft.adcenter.v8.GetAssignedQuotaResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetAssignedQuota(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAssignedQuota"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAssignedQuota"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetAssignedQuota"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdministrationService_GetAssignedQuota_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetAssignedQuota((com.microsoft.adcenter.v8.IAdministrationService_GetAssignedQuota_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetAssignedQuota(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignedQuota(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignedQuota(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignedQuota(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignedQuota(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignedQuota(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignedQuota(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetAssignedQuota(f);
                                            }
									    } else {
										    callback.receiveErrorgetAssignedQuota(f);
									    }
									} else {
									    callback.receiveErrorgetAssignedQuota(f);
									}
								} else {
								    callback.receiveErrorgetAssignedQuota(error);
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
                                    callback.receiveErrorgetAssignedQuota(axisFault);
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
                     * @see com.microsoft.adcenter.v8.AdministrationService#getRemainingQuota
                     * @param getRemainingQuotaRequest30
                    
                     * @param applicationToken31
                    
                     * @param customerAccountId32
                    
                     * @param customerId33
                    
                     * @param developerToken34
                    
                     * @param password35
                    
                     * @param userName36
                    
                     * @throws com.microsoft.adcenter.v8.IAdministrationService_GetRemainingQuota_AdApiFaultDetailFault_FaultMessage : 
                     */

                    

                            public  com.microsoft.adcenter.v8.GetRemainingQuotaResponse getRemainingQuota(

                            com.microsoft.adcenter.v8.GetRemainingQuotaRequest getRemainingQuotaRequest30,com.microsoft.adcenter.v8.ApplicationToken applicationToken31,com.microsoft.adcenter.v8.CustomerAccountId customerAccountId32,com.microsoft.adcenter.v8.CustomerId customerId33,com.microsoft.adcenter.v8.DeveloperToken developerToken34,com.microsoft.adcenter.v8.Password password35,com.microsoft.adcenter.v8.UserName userName36)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.microsoft.adcenter.v8.IAdministrationService_GetRemainingQuota_AdApiFaultDetailFault_FaultMessage{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("GetRemainingQuota");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getRemainingQuotaRequest30,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getRemainingQuota")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getRemainingQuota"));
                                                
                                               env.build();
                                    
                                        // add the children only if the parameter is not null
                                        if (applicationToken31!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementapplicationToken31 = toOM(applicationToken31, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementapplicationToken31,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerAccountId32!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId32 = toOM(customerAccountId32, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementcustomerAccountId32,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (customerId33!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementcustomerId33 = toOM(customerId33, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementcustomerId33,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (developerToken34!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken34 = toOM(developerToken34, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementdeveloperToken34,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (password35!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementpassword35 = toOM(password35, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementpassword35,env);
                                                
                                        }
                                    
                                        // add the children only if the parameter is not null
                                        if (userName36!=null){
                                            
                                                    org.apache.axiom.om.OMElement omElementuserName36 = toOM(userName36, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementuserName36,env);
                                                
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
                                             com.microsoft.adcenter.v8.GetRemainingQuotaResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.microsoft.adcenter.v8.GetRemainingQuotaResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetRemainingQuota"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetRemainingQuota"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetRemainingQuota"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        
                        if (ex instanceof com.microsoft.adcenter.v8.IAdministrationService_GetRemainingQuota_AdApiFaultDetailFault_FaultMessage){
                          throw (com.microsoft.adcenter.v8.IAdministrationService_GetRemainingQuota_AdApiFaultDetailFault_FaultMessage)ex;
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
                * @see com.microsoft.adcenter.v8.AdministrationService#startgetRemainingQuota
                    * @param getRemainingQuotaRequest30
                
                    * @param applicationToken31
                
                    * @param customerAccountId32
                
                    * @param customerId33
                
                    * @param developerToken34
                
                    * @param password35
                
                    * @param userName36
                
                */
                public  void startgetRemainingQuota(

                 com.microsoft.adcenter.v8.GetRemainingQuotaRequest getRemainingQuotaRequest30,com.microsoft.adcenter.v8.ApplicationToken applicationToken31,
                    com.microsoft.adcenter.v8.CustomerAccountId customerAccountId32,
                    com.microsoft.adcenter.v8.CustomerId customerId33,
                    com.microsoft.adcenter.v8.DeveloperToken developerToken34,
                    com.microsoft.adcenter.v8.Password password35,
                    com.microsoft.adcenter.v8.UserName userName36,
                    

                  final com.microsoft.adcenter.v8.AdministrationServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("GetRemainingQuota");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    getRemainingQuotaRequest30,
                                                    optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getRemainingQuota")), new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8",
                                                    "getRemainingQuota"));
                                                
                                         // add the soap_headers only if they are not null
                                        if (applicationToken31!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementapplicationToken31 = toOM(applicationToken31, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementapplicationToken31,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerAccountId32!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerAccountId32 = toOM(customerAccountId32, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementcustomerAccountId32,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (customerId33!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementcustomerId33 = toOM(customerId33, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementcustomerId33,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (developerToken34!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementdeveloperToken34 = toOM(developerToken34, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementdeveloperToken34,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (password35!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementpassword35 = toOM(password35, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementpassword35,env);
                                                
                                        }
                                    
                                         // add the soap_headers only if they are not null
                                        if (userName36!=null){
                                           
                                                    org.apache.axiom.om.OMElement omElementuserName36 = toOM(userName36, optimizeContent(new javax.xml.namespace.QName("https://adcenter.microsoft.com/v8", "getRemainingQuota")));
                                                    addHeader(omElementuserName36,env);
                                                
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
                                                                         com.microsoft.adcenter.v8.GetRemainingQuotaResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultgetRemainingQuota(
                                        (com.microsoft.adcenter.v8.GetRemainingQuotaResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorgetRemainingQuota(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetRemainingQuota"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetRemainingQuota"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"GetRemainingQuota"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
													if (ex instanceof com.microsoft.adcenter.v8.IAdministrationService_GetRemainingQuota_AdApiFaultDetailFault_FaultMessage){
														callback.receiveErrorgetRemainingQuota((com.microsoft.adcenter.v8.IAdministrationService_GetRemainingQuota_AdApiFaultDetailFault_FaultMessage)ex);
											            return;
										            }
										            
					
										            callback.receiveErrorgetRemainingQuota(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetRemainingQuota(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetRemainingQuota(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetRemainingQuota(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetRemainingQuota(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetRemainingQuota(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetRemainingQuota(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorgetRemainingQuota(f);
                                            }
									    } else {
										    callback.receiveErrorgetRemainingQuota(f);
									    }
									} else {
									    callback.receiveErrorgetRemainingQuota(f);
									}
								} else {
								    callback.receiveErrorgetRemainingQuota(error);
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
                                    callback.receiveErrorgetRemainingQuota(axisFault);
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
     //https://adcenterapi.microsoft.com/Api/Advertiser/V8/Administration/AdministrationService.svc
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetAssignedQuotaRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetAssignedQuotaRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetAssignedQuotaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetAssignedQuotaResponse.MY_QNAME,
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
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetRemainingQuotaRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetRemainingQuotaRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.microsoft.adcenter.v8.GetRemainingQuotaResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.microsoft.adcenter.v8.GetRemainingQuotaResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetAssignedQuotaRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetAssignedQuotaRequest.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.microsoft.adcenter.v8.GetRemainingQuotaRequest param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(com.microsoft.adcenter.v8.GetRemainingQuotaRequest.MY_QNAME,factory));
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
        
                if (com.microsoft.adcenter.v8.GetAssignedQuotaRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetAssignedQuotaRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetAssignedQuotaResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetAssignedQuotaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
           
                if (com.microsoft.adcenter.v8.GetRemainingQuotaRequest.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetRemainingQuotaRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adcenter.v8.GetRemainingQuotaResponse.class.equals(type)){
                
                           return com.microsoft.adcenter.v8.GetRemainingQuotaResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.microsoft.adapi.AdApiFaultDetailE.class.equals(type)){
                
                           return com.microsoft.adapi.AdApiFaultDetailE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

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
   